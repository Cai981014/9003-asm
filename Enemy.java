package WizardTD;

import processing.core.PImage;

public class Enemy {
    private String type;
    private int hp;
    private float speed;
    private float armour;
    private int manaGainedOnKill;
    private PImage image;

    private int currentX;
    private int currentY;
    private String[][] levelLayout;

    public Enemy(String type, int hp, float speed, float armour, int manaGainedOnKill, PImage image) {
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
        this.hp -= damage * (1 - this.armour);
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public String getType() {
        return this.type;
    }

    // Setter for image
    public void setImage(PImage image) {
        this.image = image;
    }

    public void move() {
        // Logic to move the enemy based on its speed...
        if (currentX + 1 < levelLayout[0].length && levelLayout[currentY][currentX + 1].equals("X")) {
            currentX++;
        } else if (currentX - 1 >= 0 && levelLayout[currentY][currentX - 1].equals("X")) {
            currentX--;
        } else if (currentY + 1 < levelLayout.length && levelLayout[currentY + 1][currentX].equals("X")) {
            currentY++;
        } else if (currentY - 1 >= 0 && levelLayout[currentY - 1][currentX].equals("X")) {
            currentY--;
        }
    
        // Update the enemy's position based on the currentX and currentY
        this.image.width = currentX * 32; // assuming CELLSIZE is the size of each cell
        this.image.height = currentY * 32;
    }

    
}
