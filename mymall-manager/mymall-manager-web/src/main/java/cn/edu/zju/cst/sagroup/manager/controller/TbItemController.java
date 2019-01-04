package cn.edu.zju.cst.sagroup.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.common.pojo.EasyUIDataGridResult;
import cn.edu.zju.cst.sagroup.manager.service.TbItemService;
import cn.edu.zju.cst.sagroup.pojo.TbItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class TbItemController {

    @Reference
    private TbItemService tbItemService;

    @GetMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        return tbItemService.getItemById(itemId);
    }

    @GetMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        EasyUIDataGridResult result = tbItemService.getItemList(page, rows);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public E3Result saveItem(TbItem item, String desc) {
        E3Result result = tbItemService.addItem(item, desc);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public E3Result deleteItem(long[] ids) {
        for (long id : ids) {
            tbItemService.deleteItem(id);
        }
        return E3Result.ok();
    }

}
