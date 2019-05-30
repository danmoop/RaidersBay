package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.Ship;

public class Enemy extends Ship
{
    public Enemy(Texture texture, int HP, int damage)
    {
        super(texture, HP, damage);
    }

    @Override
    protected void update()
    {

    }

    @Override
    protected void render(SpriteBatch batch)
    {

    }

    @Override
    protected void dispose()
    {

    }
}
