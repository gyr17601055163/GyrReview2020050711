package com.example.demo.configuration.interceptor;

import com.example.demo.annotation.MdxApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Component
public class MdxInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //辅助Method，表示被拦截的方法实例
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        MdxApi methodAnnotation = handlerMethod.getMethodAnnotation(MdxApi.class);
        //获取传过来的Code参数
        String code = request.getParameter("code");

        //校验start
        //没用MdxApi注解，不需要做校验，直接放行
        if (methodAnnotation==null){
            return super.preHandle(request, response, handler);
        }else{
            if (mdxCheck(code)){
                return super.preHandle(request, response, handler);
            }else{
                response.getOutputStream().print("{'msg':'error'}");
                return false;
            }
        }
        //校验end
    }

    /**
     * 进行幂等性校验
     * @param code
     * @return
     */
    public boolean mdxCheck(String code){
        //写lua脚本执行redis命令
        String lua="if redis.call('get',KEYS[1]) then return redis.call('del',KEYS[1]) else return 0 end";

        //这里的范型类型为lua脚本执行返回值的类型
        DefaultRedisScript<Long> defaultRedisScript=new DefaultRedisScript<>();
        //添加要执行的lua脚本
        defaultRedisScript.setScriptText(lua);
        //设置脚本返回值类型
        defaultRedisScript.setResultType(Long.class);

        //执行脚本
        Long execute = redisTemplate.execute(defaultRedisScript, Collections.singletonList(code));

        if (execute==1){
            return true;
        }else{
            return false;
        }
    }
}
