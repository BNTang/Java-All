package top.it6666.mybatis.session.defaults;

import top.it6666.mybatis.binding.MapperRegistry;
import top.it6666.mybatis.session.SqlSession;
import top.it6666.mybatis.session.SqlSessionFactory;

/**
 * @author BNTang
 * @version 1.0
 * @description SqlSessionFactory 工厂定义和实现
 * @since 2024/6/16 星期日
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    /**
     * 打开一个 session
     *
     * @return SqlSession
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
