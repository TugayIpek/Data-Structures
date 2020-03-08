public abstract class Person implements AutomationSystem {
    String name;

    public String getName() {
        return name;
    }

    @Override
    public abstract void menu();
}
