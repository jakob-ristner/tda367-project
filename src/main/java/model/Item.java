package model;

public class Item {
    private String name;
    private Stat stat;
    private int statIncrease;

    public Item() {

    }

    public Stat getStat() {
        return stat;
    }

    public int getStatIncrease() {
        return statIncrease;
    }

    public String getName() {
        return name;
    }
}
