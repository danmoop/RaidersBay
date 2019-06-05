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
    protected void update()
    {
        HPText.setPos(pos.x + textureWidth / 2f - HPText.getWidth() / 2f, pos.y + textureHeight + 25);

        if(Gdx.input.isKeyPressed(Input.Keys.D))
            pos.x += 4;
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            pos.x -= 4;

        if(Gdx.input.isKeyPressed(Input.Keys.W))
            pos.y += 4;
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            pos.y -= 4;
    }

    @Override
    protected void render(SpriteBatch batch)
    {
        HPText.render(batch);

        batch.draw(texture, pos.x, pos.y, textureWidth, textureHeight);
    }

    @Override
    protected void dispose()
    {
        texture.dispose();
        HPText.dispose();
    }
}