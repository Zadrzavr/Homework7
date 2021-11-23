/**
 * Java 1 Homework 7
 *
 * @author Kirill Morozov
 * version 23.11.2021
 */

class Homework7 {

    public static void main(String[] args) {
        Cat[] cats = {new Cat("Morison", 15),
                new Cat("Trall", 20),
                new Cat("Genji", 25),
                new Cat("Geralt", 30),
                new Cat("Vesemir", 15)};

        Plate plate = new Plate(60);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    void info() {
        String isHungry = !hungry ? "full" : "hungry";
        System.out.println(name + ": " + isHungry);
    }

    void eat(Plate plate) {
        if (hungry && plate.decreaseFood(appetite))
            hungry = false;
    }
}

class Plate {

    public int food;
    public Plate(int food) {
        this.food = food;
    }


    boolean decreaseFood(int n) {
        int i = food - n;
        if (i < 0) return false;

        food -= n;
        return true;
    }
    void addFood(int food) {
        this.food += food;
    }

    void info() {
        System.out.println("plate: " + food);
    }
}
