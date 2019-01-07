package cn.edu.zju.cst.sagroup.search.controller;

import cn.edu.zju.cst.sagroup.common.pojo.SearchResult;
import cn.edu.zju.cst.sagroup.search.service.SearchService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Controller
public class SearchController {

    @Reference
    private SearchService searchService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Value("${PAGE_ROWS}")
    private Integer PAGE_ROWS;

    @RequestMapping(value={"/search.html","/"}, produces="text/html")
    @ResponseBody
    public String search(String keyword,
                         @RequestParam(defaultValue = "1") Integer page,
                         HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        //检查redis是否缓存了静态页面
        String key = "mymall_search_" + keyword + "_" +page;
        String html = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(html)){
            // 有缓存
//            System.out.println("有缓存");
            return html;
        }
//        System.out.println("无缓存");

        // 调用Service查询商品信息
        SearchResult result = searchService.search(keyword, page, PAGE_ROWS);

        // 手动渲染
        WebContext context = new WebContext(
                request,response,
                request.getServletContext(),
                request.getLocale()
        );
        context.setVariable("query", keyword);
        context.setVariable("totalPages", result.getTotalPages());
        context.setVariable("recourdCount", result.getRecourdCount());
        context.setVariable("page", page);
        context.setVariable("itemList", result.getItemList());

        html = thymeleafViewResolver.getTemplateEngine().process("search", context);
        // 将静态页面返回到redis
        if(!StringUtils.isEmpty(html)) {
            redisTemplate.opsForValue().set(key, html);
            // 10 秒过期
            redisTemplate.expire(key,3, TimeUnit.HOURS);
        }
        // 返回渲染结果
        return html;
    }

}
