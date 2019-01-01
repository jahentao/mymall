package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatMapper {
    List<TbItemCat> getItemCatByParentId(long parentId);

    String getItemCatNameById(long id);
}
