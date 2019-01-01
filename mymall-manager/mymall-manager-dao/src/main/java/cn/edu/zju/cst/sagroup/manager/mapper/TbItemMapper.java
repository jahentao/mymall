package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbItem;

import java.util.List;

public interface TbItemMapper {

    TbItem selectByPrimaryKey(Long id);

    List<TbItem> getItemList();

    void insert(TbItem item);
}