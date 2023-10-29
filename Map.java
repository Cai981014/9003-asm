package WizardTD;

import processing.core.PApplet;
import processing.core.PImage;

public class Map {
    private String layout;
    private PImage image;

    public Map(String layout, PImage image) {
        this.layout = layout;
        this.image = image;
    }

    public void render(PApplet pApplet) {
        pApplet.image(this.image, 0, 0);
    }
}
