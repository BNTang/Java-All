package top.it6666.polymorphism;

/**
 * 动物
 * 创建一个表示动物的基类（父类）
 *
 * @author BNTang
 */
class Animal {
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        // 向上转型
        Animal animal = new Dog();

        // 运行时多态，调用的是 Dog 类的 makeSound 方法
        animal.makeSound();
    }
}
