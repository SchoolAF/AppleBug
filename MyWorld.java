import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        bug bug = new bug();
        addObject(bug, getWidth() / 2, getHeight() / 2);

        apple apple = new apple();
        addObject(apple, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));

        Bomb bomb = new Bomb();
        addObject(bomb, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));

        Cherry cherry = new Cherry();
        addObject(cherry, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));

    }
}
