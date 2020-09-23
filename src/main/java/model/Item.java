package model;

public class Item {
    private String name;
    private Stat stat;
    private int statIncrease;

    public Item(String name,Stat stat, int statIncrease) {
        this.name = name;
        this.stat=stat;
        this.statIncrease = statIncrease;



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
