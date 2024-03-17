package top.it6666.example;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试类
 * @since 2024/3/16 星期六
 **/
public class Test {
    public static void main(String[] args) {
        test1();
        test2();
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
}
