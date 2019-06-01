package com.danmoop.raidersbay.GameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.Level;
import com.danmoop.raidersbay.Model.Ship;
import com.danmoop.raidersbay.Model.Text;

import static com.danmoop.raidersbay.Settings.STYLED_TEXT;

public class Player extends Ship
{
    private Text HPText;

    public Player(Texture texture, int HP, int damage)
    {
        super(texture, HP, damage);

        HPText = new Text("Fonts/eina.ttf", String.valueOf(this.HP), pos.x + (textureWidth / 4f), pos.y + textureHeight + 25, 18, STYLED_TEXT());
    }

    @Override
    protected void update()
    {
        HPText.setPos(pos.x + HPText.getWidth() / 3, pos.y + textureHeight + 25);

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