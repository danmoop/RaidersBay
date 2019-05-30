package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject
{
    protected Texture texture;

    protected int textureWidth;
    protected int textureHeight;

    protected Vector2 pos;

    GameObject(Texture texture)
    {
        this.texture = texture;

        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureWidth = texture.getWidth();
        textureHeight = texture.getHeight();

        pos = new Vector2(0, 0);
    }

    protected void increaseTextureDimensions(float n)
    {
        textureWidth *= n;
        textureHeight *= n;
    }

    public void setTexture(Texture texture)
    {
        this.texture = texture;
    }

    protected abstract void update();
    protected abstract void render(SpriteBatch batch);

    protected abstract void dispose();
}