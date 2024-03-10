package top.it6666.inheritance;

/**
 * 动物
 *
 * @author BNTang
 * @date 2024/03/10 09:36:41
 * @description 创建一个表示动物的基类（父类）
 */
class Animal {
    // 动物类有一个叫的方法
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}

// 创建一个 Cat 类（子类），继承自 Animal 类
class Cat extends Animal {
    // 重写父类的 makeSound 方法
    @Override
    public void makeSound() {
        // 这里的调用体现了多态性，即 Cat 的叫声不同于一般 Animal
        System.out.println("猫咪喵喵叫");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        // Upcasting: 将 Cat 对象向上转型为 Animal 类型
        Animal myAnimal = new Cat();
        // 虽然 myAnimal 在编译时是 Animal 类型，但实际执行的是 Cat 的 makeSound 方法
        myAnimal.makeSound();

        // 创建一个 Animal 类型的对象，调用 makeSound 方法
        Animal anotherAnimal = new Animal();
        anotherAnimal.makeSound();

        // 这里可以看到，Cat 对象（myAnimal）能够替换 Animal 对象（anotherAnimal）的位置，
        // 并且程序的行为没有发生错误，体现了里氏替换原则
    }
}
