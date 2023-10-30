package WizardTD;

import processing.core.PImage;

public class Monster {
    private String type;
    private int hp;
    private float speed;
    private float armour;
    private int manaGainedOnKill;
    private PImage image;

    private int currentX;
    private int currentY;
    private String[][] levelLayout;

    public Monster(String type, int hp, float speed, float armour, int manaGainedOnKill, PImage image) {
        this.type = type;
        this.hp = hp;
        this.speed = speed;
        this.armour = armour;
        this.manaGainedOnKill = manaGainedOnKill;
        this.image = image;
        this.currentX = 0; // starting position
        this.currentY = 0; // starting position
        this.levelLayout = levelLayout;
    }

    public void takeDamage(int damage) {
        setHp(getHp() - (int)(damage * (1 - getArmour())));
        if (getHp() < 0) {
            setHp(0);
        }
    }

    public void move() {
        // Logic to move the monster based on its speed...
        if (currentX + 1 < levelLayout[0].length && levelLayout[currentY][currentX + 1].equals("X")) {
            currentX++;
        } else if (currentX - 1 >= 0 && levelLayout[currentY][currentX - 1].equals("X")) {
            currentX--;
        } else if (currentY + 1 < levelLayout.length && levelLayout[currentY + 1][currentX].equals("X")) {
            currentY++;
        } else if (currentY - 1 >= 0 && levelLayout[currentY - 1][currentX].equals("X")) {
            currentY--;
        }
    }

    // Getter and Setter methods
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getArmour() {
        return armour;
    }

    public void setArmour(float armour) {
        this.armour = armour;
    }

    public int getManaGainedOnKill() {
        return manaGainedOnKill;
    }

    public void setManaGainedOnKill(int manaGainedOnKill) {
        this.manaGainedOnKill = manaGainedOnKill;
    }

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public String[][] getLevelLayout() {
        return levelLayout;
    }

    public void setLevelLayout(String[][] levelLayout) {
        this.levelLayout = levelLayout;
    }
}