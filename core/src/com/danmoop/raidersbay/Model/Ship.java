package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Ship extends GameObject
{
    public int HP;
    public int damage;

    public Ship(Texture texture, int HP, int damage)
    {
        super(texture);

        this.HP = HP;
        this.damage = damage;
    }

    public boolean isDead()
    {
        return HP <= 0;
    }

    public void attack(Ship ship, int damage)
    {
        ship.HP -= damage;
    }
}