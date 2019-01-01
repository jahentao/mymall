package cn.edu.zju.cst.sagroup.content.service;

import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.common.pojo.EasyUITreeNode;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNode> getContentCategoryList(Long parentId);
    E3Result addContentCategory(long parentId, String name);
}
