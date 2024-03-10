package top.it6666.encapsulation;

public class Application {

    public static void main(String[] args) {
        // 创建UserCredentials对象时设置用户名和密码
        UserCredentials credentials = new UserCredentials("Alice", "Alice123");

        // 尝试使用正确的密码进行认证
        boolean isAuthenticated = credentials.authenticate("Alice123");
        System.out.println("认证 " + (isAuthenticated ? "成功" : "失败"));

        // 尝试使用错误的密码进行认证
        isAuthenticated = credentials.authenticate("WrongPassword");
        System.out.println("认证 " + (isAuthenticated ? "成功" : "失败"));

        // 获取用户名
        String username = credentials.getUsername();
        System.out.println("用户名是：" + username);

        // 尝试重置密码，必须提供当前正确的密码
        credentials.resetPassword("Alice123", "Alice456");

        // 用新密码进行认证
        isAuthenticated = credentials.authenticate("Alice456");
        System.out.println("使用新密码认证 " + (isAuthenticated ? "成功" : "失败"));

        // 尝试使用旧密码进行认证
        isAuthenticated = credentials.authenticate("Alice123");
        System.out.println("使用旧密码认证 " + (isAuthenticated ? "成功" : "失败"));

        // ================================================================================================
        UserCredentials adminCredentials = new UserCredentials("admin", "adminPass");
        UserCredentials userCredentials = new UserCredentials("user", "userPass");

        // 在不同场景中重复使用对象:
        if (adminCredentials.authenticate("adminPass")) {
            // 执行管理员操作
        }

        if (userCredentials.authenticate("userPass")) {
            // 执行用户操作
        }
    }
}
