package cn.edu.zju.cst.sagroup.manager.service;

import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.common.pojo.EasyUIDataGridResult;
import cn.edu.zju.cst.sagroup.pojo.TbItem;
import cn.edu.zju.cst.sagroup.pojo.TbItemDesc;

public interface TbItemService {
    TbItem getItemById(Long itemId);
    EasyUIDataGridResult getItemList(int page, int rows);
    E3Result addItem(TbItem item, String desc);
    TbItemDesc getItemDescById(Long itemId);
}
