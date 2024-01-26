import greenfoot.*;

public class ScoreDisplay extends Actor {

    public ScoreDisplay(String text) {
        GreenfootImage image = new GreenfootImage(text, 24, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
