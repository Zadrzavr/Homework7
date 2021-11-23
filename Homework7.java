class Homework7 {

    public static void main(String[] args) {
        Cat[] cats = {new Cat("Vasilij", 15),
                new Cat("Bombilo", 20),
                new Cat("Snezhok", 25),
                new Cat("Kuzma", 30),
                new Cat("Kote", 15)};

        Plate plate = new Plate(80);

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
        String isHungry = !hungry ? "сыт" : "голоден";
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
        int diff = food - n;
        if (diff < 0) return false;

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
