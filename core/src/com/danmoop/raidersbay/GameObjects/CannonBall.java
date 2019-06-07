package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.GameObject;

public class CannonBall extends GameObject
{
    public CannonBall(Texture texture)
    {
        super(texture);

        textureWidth = 20;
        textureHeight = 20;
    }

    @Override
    protected void update()
    {
        pos.x += 3;
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
