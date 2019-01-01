package cn.edu.zju.cst.sagroup.manager.mapper;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.edu.zju.cst.sagroup.manager.service.TbItemService;
import cn.edu.zju.cst.sagroup.pojo.TbItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {

    @Reference
    private TbItemService tbItemService;

    @Test
    public void selectTbItemByIDTest() {
        TbItem tbItem = tbItemService.getItemById(536563L);
        System.out.println(tbItem);
    }
}
