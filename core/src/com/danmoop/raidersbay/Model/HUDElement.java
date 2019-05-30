package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface HUDElement
{
    void render(SpriteBatch batch);

    void dispose();
}