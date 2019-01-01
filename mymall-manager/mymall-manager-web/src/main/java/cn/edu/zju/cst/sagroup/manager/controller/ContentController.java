package cn.edu.zju.cst.sagroup.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.common.pojo.EasyUIDataGridResult;
import cn.edu.zju.cst.sagroup.content.service.ContentService;
import cn.edu.zju.cst.sagroup.pojo.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    @ResponseBody
    @RequestMapping("/query/list")
    public EasyUIDataGridResult getContentListByCategoryId(Long categoryId, Integer page, Integer rows) {
        return contentService.getContentListByCategoryId(categoryId, page, rows);
    }

    @RequestMapping("/save")
    @ResponseBody
    public E3Result addContent(TbContent content) {
        return contentService.addContent(content);
    }
}
