package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            pos.x -= 4;

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            pos.x += 4;

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            pos.y += 4;

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            pos.y -= 4;

        HPText.setPos(pos.x + textureWidth / 2f - HPText.getWidth() / 2f, pos.y + textureHeight + 25);
    }

    @Override
    protected void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y);

        HPText.render(batch);
    }

    @Override
    protected void dispose()
    {
        texture.dispose();
    }
}
