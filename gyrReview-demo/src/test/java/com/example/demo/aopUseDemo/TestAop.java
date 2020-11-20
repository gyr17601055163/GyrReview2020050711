package com.example.demo.aopUseDemo;

import com.example.demo.mapper.user.UserDao;
import com.example.demo.mapper.user.UserDaoImpl;
import com.example.demo.service.daLeTou.DaLeTouServie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAop {

    @Autowired
    private UserDaoImpl userDaoImpl;
    @Autowired
    private DaLeTouServie daLeTouServie;

    @Test
    public void test1(){
        Map<String,Object> map=new HashMap<>();
        map.put("1","1");
        userDaoImpl.getUserList(map);
    }

    /**
     * 通过jdk动态代理实现在源代码的基础上，新增日志输出功能
     */
    @Test
    public void test2(){
        Map<String,Object> map=new HashMap<>();
        map.put("1","1");

        // newProxyInstance的三个参数解释：
        // 参数1：代理类的类加载器，同目标类的类加载器
        // 参数2：代理类要实现的接口列表，同目标类实现的接口列表
        // 参数3：回调，是一个InvocationHandler接口的实现对象，当调用代理对象的方法时，执行的是回调中的invoke方法
        UserDao proxy= (UserDao) Proxy.newProxyInstance(UserDaoImpl.class.getClassLoader(), UserDaoImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            // 参数proxy:被代理的对象
            // 参数method:执行的方法，代理对象执行哪个方法，method就是哪个方法
            // 参数args:执行方法的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----------------新增日志输出功能");
                Object invoke = method.invoke(userDaoImpl, args);
                return invoke;
            }
        });
        //proxy为生成的代理对象
        proxy.getUserList(map);
        proxy.delUserMassage("");
    }

    /**
     * 通过cglib动态代理实现在源代码的基础上，新增日志输出功能
     */
    @Test
    public void test3(){
        // 创建cglib核心对象
        Enhancer enhancer=new Enhancer();
        // 设置父类
        enhancer.setSuperclass(DaLeTouServie.class);
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            /**
             * 当你调用目标方法时，实质上是调用该方法
             * intercept四个参数：
             * proxy:代理对象
             * method:目标方法
             * args：目标方法的形参
             * methodProxy:代理方法
             */
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("--------新增日志输出功能");
                Object invoke = method.invoke(daLeTouServie, args);
                return invoke;
            }
        });
        // 创建代理对象
        DaLeTouServie proxy=(DaLeTouServie) enhancer.create();
        //代理对象执行方法
        proxy.getData();
    }
}
