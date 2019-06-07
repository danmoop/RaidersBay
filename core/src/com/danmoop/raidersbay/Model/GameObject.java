package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.danmoop.raidersbay.Settings.SCREEN_HEIGHT;

public abstract class GameObject
{
    protected Texture texture;
    protected int textureWidth;
    protected int textureHeight;

    protected Vector2 pos;

    protected GameObject(Texture texture)
    {
        this.texture = texture;

        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureWidth = texture.getWidth();
        textureHeight = texture.getHeight();

        pos = new Vector2(0, 0);
    }

    public int getWidth()
    {
        return textureWidth;
    }

    public int getHeight()
    {
        return textureHeight;
    }

    public void setPos(float x, float y)
    {
        pos.x = x;
        pos.y = y;
    }

    public void setSize(int width, int height)
    {
        textureWidth = width;
        textureHeight = height;
    }

    public float getX()
    {
        return pos.x;
    }

    public float getY()
    {
        return pos.y;
    }

    protected void setTexture(Texture texture)
    {
        this.texture = texture;
    }

    public boolean isTargeted()
    {
        int x = Gdx.input.getX();
        int y = Gdx.input.getY();

        return x >= pos.x && x <= pos.x + textureWidth
                && SCREEN_HEIGHT - y >= pos.y && SCREEN_HEIGHT - y <= pos.y + textureHeight;
    }

    public boolean collidedWith(GameObject object)
    {
        return pos.x + textureWidth > object.getX() && pos.x < object.getX() + object.getWidth()
                && pos.y + textureHeight > object.getY() && pos.y < object.getY() + object.getHeight();
    }

    protected abstract void update();
    protected abstract void render(SpriteBatch batch);

    protected abstract void dispose();
}