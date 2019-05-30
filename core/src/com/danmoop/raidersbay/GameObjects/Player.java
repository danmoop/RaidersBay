package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.Ship;

public class Player extends Ship
{
    public Player(Texture texture, int HP, int damage)
    {
        super(texture, HP, damage);
    }

    @Override
    public void attack(Ship ship, int damage)
    {
        ship.HP -= damage;
    }

    @Override
    protected void update()
    {
    }

    @Override
    protected void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y, textureWidth, textureHeight);
    }

    @Override
    protected void dispose()
    {
        texture.dispose();
    }
}