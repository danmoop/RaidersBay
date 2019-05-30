package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Font implements HUDElement
{
    private BitmapFont font;
    private GlyphLayout layout;
    private String text;
    private float x;
    private float y;

    public Font(BitmapFont font, String text, float x, float y)
    {
        this.font = font;
        this.layout = new GlyphLayout();
        this.text = text;
        this.x = x;
        this.y = y;

        this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.layout.setText(font, text);
    }

    public void setScale(float n)
    {
        font.getData().setScale(n);
        layout.setText(font, text);
    }

    public void setPos(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getWidth()
    {
        return layout.width;
    }

    public float getHeight()
    {
        return layout.height;
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        font.draw(batch, layout, x, y);
    }

    @Override
    public void dispose()
    {
        font.dispose();
    }
}