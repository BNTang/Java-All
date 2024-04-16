package top.it6666.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.it6666.test.dao.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2024/4/16 星期二
 **/
public class ApiTest {
    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
    }

    @Test
    public void test_proxy_class() {
        // 使用JDK动态代理
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return "你被代理了 ！";
                    }
                }
        );

        String result = userDao.queryUserName("1");
        logger.info("测试结果: {}", result);
    }
}
