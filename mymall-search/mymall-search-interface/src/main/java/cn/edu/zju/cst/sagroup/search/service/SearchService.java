package cn.edu.zju.cst.sagroup.search.service;

import cn.edu.zju.cst.sagroup.common.pojo.SearchResult;

public interface SearchService {
    SearchResult search(String keyWord, int page, int rows) throws Exception;
}
