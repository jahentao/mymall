package cn.edu.zju.cst.sagroup.order.service;

import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.order.pojo.OrderInfo;

public interface OrderService {
    E3Result createOrder(OrderInfo orderInfo);
}
