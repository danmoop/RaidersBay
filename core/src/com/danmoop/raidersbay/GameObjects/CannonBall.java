package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.GameObject;

public class CannonBall extends GameObject
{
    private int speed;

    public CannonBall(Texture texture, int speed)
    {
        super(texture);

        this.speed = speed;
        textureWidth = 20;
        textureHeight = 20;
    }

    @Override
    protected void update()
    {
        pos.x += speed;
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
