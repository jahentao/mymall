package cn.edu.zju.cst.sagroup.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.concurrent.CountDownLatch;

@MapperScan(value = "cn.edu.zju.cst.sagroup.manager.mapper")
@SpringBootApplication
public class CartServiceApplicationStarter {
    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder()
                .sources(CartServiceApplicationStarter.class)
                .web(WebApplicationType.NONE)
                .run(args);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
