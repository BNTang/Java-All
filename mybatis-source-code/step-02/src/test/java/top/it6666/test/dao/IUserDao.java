package top.it6666.test.dao;

/**
 * 用户接口
 */
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
