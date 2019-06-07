package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.Texture;
import static com.danmoop.raidersbay.Settings.STYLED_TEXT;

public abstract class Ship extends GameObject
{
    public int HP;
    public int damage;

    protected Text HPText;

    public Ship(Texture texture, int HP, int damage)
    {
        super(texture);

        this.HP = HP;
        this.damage = damage;

        HPText = new Text("Fonts/eina.ttf", String.valueOf(this.HP), pos.x + (textureWidth / 4f), pos.y + textureHeight + 25, 25, STYLED_TEXT());
    }

    public boolean isDestroyed()
    {
        return HP <= 0;
    }

    public void attack(Ship ship, int damage)
    {
        ship.takeDamage(damage);
    }

    private void takeDamage(int damage)
    {
        HP -= damage;

        setText(String.valueOf(HP));

        HPText.setPos(pos.x + textureWidth / 2f - HPText.getWidth() / 2f, pos.y + textureHeight + 25);
    }

    public void setText(String text)
    {
        HPText.setText(text);
    }
}