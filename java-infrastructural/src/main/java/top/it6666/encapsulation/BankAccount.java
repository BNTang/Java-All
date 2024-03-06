package top.it6666.encapsulation;

/**
 * @author BNTang
 * @version 1.0
 * @description 封装示例
 * @since 2024/3/6 星期三
 **/
public class BankAccount {
    // 私有属性，隐藏内部实现细节 (封装性 & 增强安全性)
    private String accountNumber;
    private double balance;

    // 构造方法，初始化必要的属性
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // 公有方法来进行操作，简化了操作接口 (易于维护 & 接口与实现分离)
    // 存款方法
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("存款成功。当前余额: " + balance);
        } else {
            System.out.println("存款金额必须大于0。");
        }
    }

    // 取款方法
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("取款成功。当前余额: " + balance);
        } else {
            System.out.println("取款金额无效或余额不足。");
        }
    }

    // 查看余额
    public double checkBalance() {
        return balance;
    }

    // 设置属性为私有，并提供公有的获取方法（getter），不需要设置器（setter）来保证账户号不可更改 (封装性 & 增强安全性)
    public String getAccountNumber() {
        return accountNumber;
    }

    // 重写 toString 方法来定义如何打印对象信息，而非直接暴露属性 (隐藏实现细节，简化接口)
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
