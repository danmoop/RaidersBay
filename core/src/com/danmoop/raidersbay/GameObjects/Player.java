package com.danmoop.raidersbay.GameObjects;
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