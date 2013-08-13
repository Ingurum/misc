/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.monkey.vs.bananas.model;

/**
 *
 * @author salaboy
 */
public interface PositionedObject {
    void setY(int y);
    void setX(int x);
    int getX();
    int getY();
    String getLevel();
    void setLevel(String level);

}
