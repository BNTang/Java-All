package top.it6666.mybatis.session;

/**
 * @author BNTang
 * @version 1.0
 * @description SqlSessionFactory 工厂定义和实现
 * @since 2024/6/16 星期日
 **/
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     *
     * @return SqlSession
     */
    SqlSession openSession();
}
