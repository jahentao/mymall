package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbItemParamItem;

public interface TbItemParamItemMapper {
    void insert(TbItemParamItem tbItemParamItem);

    TbItemParamItem selectItemParamByItemId(Long itemId);
}
