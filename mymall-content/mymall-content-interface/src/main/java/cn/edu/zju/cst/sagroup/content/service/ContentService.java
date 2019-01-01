package cn.edu.zju.cst.sagroup.content.service;

import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.common.pojo.EasyUIDataGridResult;
import cn.edu.zju.cst.sagroup.pojo.TbContent;

import java.util.List;

public interface ContentService {
    E3Result addContent(TbContent content);
    EasyUIDataGridResult getContentListByCategoryId(Long categoryId, int page, int rows);
    List<TbContent> getContentList(Long cid);
}
