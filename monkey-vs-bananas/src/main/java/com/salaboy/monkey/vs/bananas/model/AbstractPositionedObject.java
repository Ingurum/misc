/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.monkey.vs.bananas.model;

/**
 *
 * @author salaboy
 */
public abstract class AbstractPositionedObject implements PositionedObject{
    private int x = 0;
    private int y = 0;
    private String level = "floor";
    
    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AbstractPositionedObject{" + "x=" + x + ", y=" + y + ", level=" + level + '}';
    }
    
    
    
}
