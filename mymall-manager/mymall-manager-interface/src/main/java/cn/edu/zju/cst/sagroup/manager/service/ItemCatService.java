package cn.edu.zju.cst.sagroup.manager.service;

import cn.edu.zju.cst.sagroup.common.pojo.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {
    List<EasyUITreeNode> getCatList(Long parentId);
}
