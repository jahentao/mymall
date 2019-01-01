package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryMapper {
    List<TbContentCategory> selectTbContentCatsByParentId(Long parentId);

    void insertCategory(TbContentCategory contentCategory);

    TbContentCategory selectTbContentCatById(Long id);

    void updateContentCategoryById(TbContentCategory parentContentCategory);
}
