package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbItemDesc;

public interface TbItemDescMapper {

    void insert(TbItemDesc tbItemDesc);

    TbItemDesc selectItemDescByPrimaryKey(Long itemId);

    int delete(Long itemId);
}
