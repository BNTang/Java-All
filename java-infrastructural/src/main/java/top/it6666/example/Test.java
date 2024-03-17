package top.it6666.example;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试类
 * @since 2024/3/16 星期六
 **/
public class Test {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    // a = a + b;
    private static void test1() {
        byte a = 10;
        byte b = 20;

        // 对于 a = a + b，如果 a 和 b 是 byte、short 或 char 类型的变量，在进行算术运算的时候会首先提升为 int 类型（这称为 类型提升），然后才执行加法运算。
        // 如果想将结果赋值回 byte、short 或 char 类型的变量，必须进行显式的类型转换，否则编译器会报错，因为 int 类型不能隐式转换为 byte、short 或 char 类型。
        // 必须显式转换，否则编译报错（Incompatible types. Found: 'int', required: 'byte'）
        // a = a + b;
        a = (byte) (a + b);

        System.out.println(a);
    }

    // a += b;
    private static void test2() {
        byte a = 10;
        byte b = 20;

        // 对于 a += b，不会改变变量 a 的数据类型，所以不需要进行类型转换，编译器会自动进行类型转换。
        // a += b; 相当于 a = (byte)(a + b);
        a += b;

        System.out.println(a);
    }

    // 3 * 0.1 == 0.3 将会返回什么？true 还是 false？
    private static void test3() {
        double a = 3 * 0.1;
        System.out.println(Math.abs(a));

        double b = 0.3;
        System.out.println(Math.abs(b));
        System.out.println(a - b);

        double epsilon = 0.0001; // 定义一个很小的误差范围

        // Math.abs 方法用于返回参数的绝对值，即参数的正数部分，Math.abs(a - b) 返回 a - b 的绝对值，即两个数之间的误差，然后与误差范围进行比较。
        // a = 3 * 0.1 = 0.30000000000000004 与 b = 0.3, 误差范围为 0.0001
        // Math.abs(a - b) = 4.440892098500626E-16

        System.out.println(Math.abs(a - b));
        boolean areEqual = Math.abs(a - b) < epsilon; // 比较是否在误差范围内相等
        System.out.println(areEqual);
    }

    // 能在 Switch 中使用 String 吗?
    private static void test4() {
        String str = "Hello";
        switch (str) {
            case "Hello":
                System.out.println("Hello");
                break;
            case "World":
                System.out.println("World");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
