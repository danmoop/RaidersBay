package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class Text implements HUDElement
{
    private BitmapFont font;

    private FreeTypeFontGenerator generator;

    private int fontSize;
    private GlyphLayout glyphLayout;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private String text;
    private float x;
    private float y;

    public Text(String pathFile, String text, float x, float y, int fontSize, FontConfiguration configuration)
    {
        // Layout is where out text placed, so we understand what are text's X & Y coordinates, and also width & height
        glyphLayout = new GlyphLayout();

        // Initialize free font generator using a font taken from a specific directory
        generator = new FreeTypeFontGenerator(Gdx.files.internal(pathFile));

        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = fontSize;

        // Configuration contains different settings for our text, like border color, shadows etc.
        // If we pass config as null, then don't do anything with the font, leave as is
        if(configuration != null)
            configuration.setup(parameter);

        // finally, after all the configurations and initializations - generate the font
        font = generator.generateFont(parameter);

        // apply linear filter to it, so it would look smoother
        font.getRegion().getTexture().setFilter(Linear, Linear);

        this.fontSize = fontSize;
        this.text = text;
        this.x = x;
        this.y = y;

        // place the text in a layout
        glyphLayout.setText(font, text);
    }

    public float getWidth()
    {
        return glyphLayout.width;
    }

    public float getHeight()
    {
        return glyphLayout.height;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    void setText(String text)
    {
        glyphLayout.setText(font, text);
    }

    public void setPos(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(SpriteBatch batch)
    {
        font.draw(batch, glyphLayout, x, y);
    }

    @Override
    public void dispose()
    {
        font.dispose();
        generator.dispose();
    }
}