package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.danmoop.raidersbay.Model.GameObject;

public class BadLogic extends GameObject
{
    public BadLogic()
    {
        this.texture = new Texture("badlogic.jpg");
        this.pos = new Vector2(0, 0);
    }

    @Override
    public void update()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.D))
            pos.x += 5;
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            pos.x -= 5;
        if(Gdx.input.isKeyPressed(Input.Keys.W))
            pos.y += 5;
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            pos.y -= 5;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y);
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}
