package com.danmoop.raidersbay.GameObjects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Model.Ship;

import static com.danmoop.raidersbay.Settings.RANDOMSHIP;

public class Enemy extends Ship
{
    private boolean attacking;

    public Enemy(Texture texture, int HP, int damage)
    {
        super(texture, HP, damage);
    }

    @Override
    protected void update()
    {
        HPText.setPos(pos.x + textureWidth / 2f - HPText.getWidth() / 2f, pos.y + textureHeight + 25);
    }

    public void generateNewShip()
    {
        setTexture(RANDOMSHIP(true));
    }

    @Override
    protected void render(SpriteBatch batch)
    {
        batch.draw(texture, pos.x, pos.y, textureWidth, textureHeight);

        HPText.render(batch);
    }

    @Override
    protected void dispose()
    {
        texture.dispose();
        HPText.dispose();
    }

    public boolean isAttacking()
    {
        return attacking;
    }

    public void setAttacking(boolean attacking)
    {
        this.attacking = attacking;
    }
}
