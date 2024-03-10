package top.it6666.polymorphism;

/**
 * 打印机类
 * 用于演示方法重载
 *
 * @author BNTang
 */
class Printer {
    /**
     * 打印字符串
     *
     * @param content 要打印的字符串
     */
    public void print(String content) {
        System.out.println("打印字符串: " + content);
    }

    /**
     * 重载 print 方法，参数类型为 int，与打印字符串的方法区分开来
     *
     * @param number 要打印的数字
     */
    public void print(int number) {
        System.out.println("打印数字: " + number);
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // 调用 print 方法打印字符串
        printer.print("Hello, World!");

        // 调用重载的 print 方法打印数字
        printer.print(12345);

        // 编译器根据参数类型来决定调用哪个方法
    }
}
