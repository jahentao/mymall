package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbContent;

import java.util.List;

public interface TbContentMapper {
    List<TbContent> getContentListByCategoryId(Long categoryId);

    List<TbContent> getAllContentList();

    void insertContent(TbContent tbContent);
}
