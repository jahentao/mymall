package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.pojo.TbItemParam;
import cn.edu.zju.cst.sagroup.pojo.TbItemParamAndName;

import java.util.List;

public interface TbItemParamMapper {

    List<TbItemParamAndName> getItemParamList();

    TbItemParam getItemParamByCid(Long cid);

    Integer insertItemParam(TbItemParam tbItemParam);
}
