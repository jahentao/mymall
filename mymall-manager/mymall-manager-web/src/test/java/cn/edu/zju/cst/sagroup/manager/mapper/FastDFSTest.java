package cn.edu.zju.cst.sagroup.manager.mapper;

import cn.edu.zju.cst.sagroup.common.utils.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSTest {

    @Test
    public void testFastDfsClient() throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("F:\\Workspace\\GitHub\\e3-springboot\\mymall-manager\\mymall-manager-web\\src\\main\\resources\\conf\\fastdfs-client.conf");
        String file = fastDFSClient.uploadFile("H:\\jahentao\\Pictures\\分类\\背景\\秒速五厘米 星空 情侣.jpg");
        System.out.println(file);
    }

}
