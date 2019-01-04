package cn.edu.zju.cst.sagroup.item.message;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.edu.zju.cst.sagroup.item.pojo.Item;
import cn.edu.zju.cst.sagroup.manager.service.TbItemService;
import cn.edu.zju.cst.sagroup.pojo.TbItem;
import cn.edu.zju.cst.sagroup.pojo.TbItemDesc;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 接收后台添加商品消息，生成商品详情页面
 */
@Component
public class GeneratePageMessageReceiver {

    @Reference
    private TbItemService itemService;
    @Autowired
    private SpringTemplateEngine springTemplateEngine;
    @Value("${TEMPLATE_NAME}")
    private String TEMPLATE_NAME;
    @Value("${TEMPLATE_FILEPATH}")
    private String TEMPLATE_FILEPATH;

    @JmsListener(destination = "itemAddTopic", containerFactory = "jmsTopicListenerContainerFactory")
    public void itemAddReceiver(Long itemId) {
        FileWriter writer = null;
        try {
            // 0、等待1s让mymall-manager-service提交完事务，商品添加成功
            Thread.sleep(1000);
            // 1、准备商品数据
            TbItem tbItem = itemService.getItemById(itemId);
            TbItemDesc itemDesc = itemService.getItemDescById(itemId);
            Item item = new Item(tbItem);
            // 2、构造上下文(Model)
            Context context = new Context();
            context.setVariable("item", item);
            context.setVariable("itemDesc", itemDesc);
            // 3、生成页面
            writer = new FileWriter(TEMPLATE_FILEPATH + itemId + ".html");
            springTemplateEngine.process(TEMPLATE_NAME, context, writer);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            if (writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
