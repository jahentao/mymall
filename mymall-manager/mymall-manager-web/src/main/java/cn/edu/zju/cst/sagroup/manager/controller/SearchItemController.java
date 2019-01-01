package cn.edu.zju.cst.sagroup.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.search.service.SearchItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchItemController {

    @Reference(timeout = 300000)
    private SearchItemService searchItemService;

    @RequestMapping("/index/item/import")
    @ResponseBody
    public E3Result impotItemIndex() {
        E3Result result = searchItemService.importItems();
        return result;
    }
}
