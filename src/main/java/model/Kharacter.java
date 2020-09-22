package model;

public class Kharacter {
    private int speed;
    private int strength;
    private int sanity;
    private int stamina;
    private String name;

    public Kharacter() {

    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getSanity() {
        return sanity;
    }

    public int getStamina() {
        return stamina;
    }

    public void updateStat(Stat stat, int statDelta) {
        switch (stat) {
            case SPEED:
                speed += statDelta;
                break;
            case SANITY:
                sanity += statDelta;
                break;
            case STAMINA:
                stamina += statDelta;
                break;
            case STRENGTH:
                strength += statDelta;
                break;
            default:
                break;
        }
    }


    public String getName() {
        return name;
    }
}

