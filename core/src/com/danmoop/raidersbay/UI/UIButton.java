package com.danmoop.raidersbay.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.GameObject;

import static com.danmoop.raidersbay.Settings.SCREEN_HEIGHT;
import static com.danmoop.raidersbay.Settings.SCREEN_WIDTH;

public class UIButton extends GameObject
{
    public UIButton(Texture texture)
    {
        super(texture);

        pos.x = SCREEN_WIDTH / 2f - 40;
        pos.y = SCREEN_HEIGHT / 2f - 40;

        setSize(80, 80);
    }

    @Override
    protected void update()
    {
        if(Gdx.input.justTouched())
        {
            System.out.println(isClickedOn());
        }
    }

    @Override
    protected void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y, 80, 80);
    }

    @Override
    protected void dispose()
    {

    }
}