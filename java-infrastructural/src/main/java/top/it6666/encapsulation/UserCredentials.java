package top.it6666.encapsulation;

/**
 * @author BNTang
 * @description 用户凭证类，隐藏内部实现细节，防止外部直接访问对象内部的数据，减少因误用导致的错误
 */
public class UserCredentials {
    // 私有属性，外部无法直接访问
    private String username;
    private String password;

    // 公有的构造函数，用于初始化用户名和密码
    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 公有的方法，用于验证密码是否正确
    public boolean authenticate(String inputPassword) {
        return inputPassword != null && inputPassword.equals(this.password);
    }

    // 获得用户名的公有方法
    public String getUsername() {
        return this.username;
    }

    // 重置密码的方法，增加安全性校验
    public void resetPassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword)) {
            this.password = newPassword;
            System.out.println("密码重置成功。");
        } else {
            System.out.println("旧密码不正确，密码重置失败。");
        }
    }

    // 私有的设置密码方法，外部无法访问
    private void setPassword(String password) {
        this.password = password;
    }
}
