package WizardTD;

public class Player {
    private int mana;
    private int manaCap;
    private int manaGainedPerSecond;

    public Player(int initialMana, int initialManaCap, int initialManaGainedPerSecond) {
        this.mana = initialMana;
        this.manaCap = initialManaCap;
        this.manaGainedPerSecond = initialManaGainedPerSecond;
    }

    public void gainMana() {
        this.mana += this.manaGainedPerSecond;
        if (this.mana > this.manaCap) {
            this.mana = this.manaCap;
        }
    }

    public boolean spendMana(int amount) {
        if (this.mana >= amount) {
            this.mana -= amount;
            return true;
        }
        return false;
    }

    // Getter and Setter methods
    public int getMana() {
        return this.mana;
    }

    // Setter for mana
    public void setMana(int mana) {
        this.mana = mana;
        if (this.mana > this.manaCap) {
            this.mana = this.manaCap;
        }
    }

    // Getter for manaCap
    public int getManaCap() {
        return this.manaCap;
    }

    // Setter for manaCap
    public void setManaCap(int manaCap) {
        this.manaCap = manaCap;
    }

    // Getter for manaGainedPerSecond
    public int getManaGainedPerSecond() {
        return this.manaGainedPerSecond;
    }

    // Setter for manaGainedPerSecond
    public void setManaGainedPerSecond(int manaGainedPerSecond) {
        this.manaGainedPerSecond = manaGainedPerSecond;
    }

}
