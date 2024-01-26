import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bug extends Actor
{
    private int score = 0;
    private double speed = 2.0; // Initial speed

    /**
     * Act - do whatever the bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        handleKeyPresses();
        
        apple apple = (apple) getWorld().getObjects(apple.class).get(0);
        if (getDistance(apple) < 20) {
            moveAppleRandom();
            increaseScore();
        }

        if (isTouching(Cherry.class)) {
            increaseSpeed();
        }

        if (isTouching(Bomb.class)) {
            gameOver();
        }
        
        // Display the score
        displayScore();        
    }

    private void handleKeyPresses() {
        if (Greenfoot.isKeyDown("up")) {
            move((int) speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            move((int) -speed);
        }
        if (Greenfoot.isKeyDown("left")) {
            turn((int) -speed);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn((int) speed);
        }
    }
    
    public double getDistance(Actor other) {
        int xDistance = other.getX() - getX();
        int yDistance = other.getY() - getY();
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
    
    public void moveAppleRandom() {
        GreenfootImage worldImage = getWorld().getBackground();
        int maxX = worldImage.getWidth();
        int maxY = worldImage.getHeight();
        
        int randomX = Greenfoot.getRandomNumber(maxX);
        int randomY = Greenfoot.getRandomNumber(maxY);
        
        apple apple = (apple) getWorld().getObjects(apple.class).get(0);
        apple.setLocation(randomX, randomY);
    }
    
    private void increaseScore() {
        score++;
    }
    
    private void displayScore() {
        getWorld().removeObjects(getWorld().getObjects(ScoreDisplay.class));
        ScoreDisplay scoreDisplay = new ScoreDisplay("Score: " + score);
        getWorld().addObject(scoreDisplay, 50, 20);
    }

    private void increaseSpeed() {
        speed += 0.1;
        Cherry cherry = (Cherry) getWorld().getObjects(Cherry.class).get(0);
        moveCherryRandom(cherry);
    }
    
    private void moveCherryRandom(Cherry cherry) {
        GreenfootImage worldImage = getWorld().getBackground();
        int maxX = worldImage.getWidth() - cherry.getImage().getWidth();
        int maxY = worldImage.getHeight() - cherry.getImage().getHeight();
        
        int randomX = Greenfoot.getRandomNumber(maxX);
        int randomY = Greenfoot.getRandomNumber(maxY);
        
        cherry.setLocation(randomX, randomY);
    }
    
    private void gameOver() {
        GreenfootImage image = new GreenfootImage("Game Over", 24, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(image);
        Greenfoot.stop();
    }
}
