package top.it6666.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.it6666.mybatis.binding.MapperProxyFactory;
import top.it6666.mybatis.binding.MapperRegistry;
import top.it6666.mybatis.session.SqlSession;
import top.it6666.mybatis.session.SqlSessionFactory;
import top.it6666.mybatis.session.defaults.DefaultSqlSessionFactory;
import top.it6666.test.dao.ISchoolDao;
import top.it6666.test.dao.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试类
 * @since 2024/4/16 星期二
 **/
public class ApiTest {
    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("top.it6666.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        ISchoolDao iSchoolDao = sqlSession.getMapper(ISchoolDao.class);

        // 4. 测试验证
        String res = iSchoolDao.querySchoolName("neo");
        logger.info("测试结果：{}", res);
    }
}
