package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject
{
    protected Texture texture;
    protected Vector2 pos;

    public abstract void update();
    public abstract void render(SpriteBatch batch);

    public abstract void dispose();
}