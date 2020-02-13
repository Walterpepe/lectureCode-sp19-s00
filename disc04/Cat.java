public class Cat extends Animal{

    public Cat(String name, int age){
        super(name,age);
        noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }


    public static void main(String[] args){
        Cat kitty = new Cat("Kitty", 10);
        kitty.greet();

        Cat little = new Cat("Little Kitty", 2);
        little.greet();
    }
}