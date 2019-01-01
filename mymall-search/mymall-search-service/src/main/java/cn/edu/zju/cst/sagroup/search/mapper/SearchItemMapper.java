package cn.edu.zju.cst.sagroup.search.mapper;

import cn.edu.zju.cst.sagroup.common.pojo.SearchItem;

import java.util.List;

public interface SearchItemMapper {
    List<SearchItem> getItemList();
	SearchItem getItemById(Long itemId);
}