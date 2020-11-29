package com.example.demo.web.forAop幂等性控制;

import com.example.demo.annotation.AopMdxApi;
import com.example.demo.common.util.FreemarkerUtils;
import com.example.demo.web.forRedis幂等性控制.MdxController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

@RestController
public class AopController{

    @RequestMapping("add2")
    @AopMdxApi
    public String add2(HttpServletRequest request, HttpServletResponse response){
        System.out.println("----------------支付2");
        return request.getParameter("code")+"---";
    }

    /**
     * 通过该方法到达我们的测试页面
     */
    @RequestMapping("getIndex2")
    public void getIndex2(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        FreemarkerUtils.getStaticHtml(MdxController.class,
                "/template/",
                "test2.html",stringObjectHashMap,writer);
    }
}
