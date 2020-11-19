package com.example.demo.web.forRedis幂等性控制;

import com.example.demo.annotation.MdxApi;
import com.example.demo.common.util.FreemarkerUtils;
import com.example.demo.common.util.UID;
import com.example.demo.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@RestController
public class MdxController extends BaseController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 要进行幂等性校验的方法，通过校验之后进行的业务操作方法（例如支付操作）
     * 校验标识@MdxApi
     * @return
     */
    @RequestMapping("add")
    @MdxApi
    public String add(HttpServletRequest request,HttpServletResponse response){
        System.out.println("----------------支付");
        return request.getParameter("code")+"---";
    }

    /**
     * 通过该方法到达我们的测试页面
     */
    @RequestMapping("getIndex")
    public void getIndex(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        FreemarkerUtils.getStaticHtml(MdxController.class,
                "/template/",
                "test.html",stringObjectHashMap,writer);
    }
}
