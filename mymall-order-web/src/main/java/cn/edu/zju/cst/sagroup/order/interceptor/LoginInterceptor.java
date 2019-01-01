package cn.edu.zju.cst.sagroup.order.interceptor;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.edu.zju.cst.sagroup.cart.service.CartService;
import cn.edu.zju.cst.sagroup.common.pojo.E3Result;
import cn.edu.zju.cst.sagroup.common.utils.CookieUtils;
import cn.edu.zju.cst.sagroup.common.utils.JsonUtils;
import cn.edu.zju.cst.sagroup.pojo.TbItem;
import cn.edu.zju.cst.sagroup.pojo.TbUser;
import cn.edu.zju.cst.sagroup.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Reference
    private UserService userService;
    @Reference
    private CartService cartService;
    @Value("${SSO_SERVICE_URL}")
    private String SSO_SERVICE_URL;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1、从Cookie中取出token
        String token = CookieUtils.getCookieValue(request, "MYMALL_TOKEN");
        // 2、没有token，直接跳转登录
        if (StringUtils.isBlank(token)) {
            response.sendRedirect(SSO_SERVICE_URL + "/login?redirect=" + request.getRequestURL());
            return false;
        }
        // 3、取到token，调用sso服务取出user信息
        E3Result e3Result = userService.getUserByToken(token);
        // 4、没有用户信息跳转登录
        if (e3Result.getStatus() != 200) {
            response.sendRedirect(SSO_SERVICE_URL + "/login?redirect=" + request.getRequestURL());
            return false;
        }
        // 5、存在用户信息，则保存至request中
        TbUser user = (TbUser) e3Result.getData();
        request.setAttribute("user", user);
        // 6、判断Cookie中是否含有购物车商品，有则合并
        String jsonCartList = CookieUtils.getCookieValue(request, "MYMALL_CART", true);
        if (StringUtils.isNotBlank(jsonCartList)) {
            // 合并
            cartService.mergeCart(user.getId(), JsonUtils.jsonToList(jsonCartList, TbItem.class));
        }
        return true;
    }
}
