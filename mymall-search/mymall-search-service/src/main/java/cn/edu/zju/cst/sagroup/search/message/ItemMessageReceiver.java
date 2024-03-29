package cn.edu.zju.cst.sagroup.search.message;

import cn.edu.zju.cst.sagroup.common.pojo.SearchItem;
import cn.edu.zju.cst.sagroup.search.mapper.SearchItemMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ItemMessageReceiver {

    @Autowired
    private SearchItemMapper searchItemMapper;
    @Autowired
    private SolrClient solrClient;

    @JmsListener(destination = "itemAddTopic", containerFactory = "jmsTopicListenerContainerFactory")
    public void itemAddReceiver(Long msg) {
        try {
            // 0、等待1s让mymall-manager-service提交完事务，商品添加成功
            Thread.sleep(1000);
            // 1、根据商品id查询商品信息
            SearchItem searchItem = searchItemMapper.getItemById(msg);
            // 2、创建一SolrInputDocument对象。
            SolrInputDocument document = new SolrInputDocument();
            // 3、使用SolrServer对象写入索引库。
            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSell_point());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCategory_name());
            // 5、向索引库中添加文档。
            solrClient.add(document);
            solrClient.commit();
        } catch (SolrServerException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "itemDeleteTopic", containerFactory = "jmsTopicListenerContainerFactory")
    public void itemDeleteReceiver(Long itemId) {
        try {
            // 0、等待1s让mymall-manager-service提交完事务，商品删除成功
            Thread.sleep(1000);
            // 1、删除Solr中对应商品索引
            UpdateResponse rsp = solrClient.deleteByQuery("id:"+itemId);
            // 2、提交
            solrClient.commit();
        } catch (InterruptedException | IOException | SolrServerException e) {
            e.printStackTrace();
        }
    }
}
