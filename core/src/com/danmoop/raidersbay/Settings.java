package com.danmoop.raidersbay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.danmoop.raidersbay.Model.FontConfiguration;

import java.util.Random;

public class Settings
{
    public static final String GAME_TITLE = "Raider's Bay";
    public static final short SCREEN_WIDTH = 800;
    public static final short SCREEN_HEIGHT = 400;

    public static FontConfiguration STYLED_TEXT()
    {
        return parameter ->
        {
            parameter.borderColor = Color.BLACK;
            parameter.borderWidth = 2;

            parameter.shadowColor = Color.BLACK;
            parameter.shadowOffsetY = 2;
            parameter.shadowOffsetX = 2;
        };
    }

    public static Texture RANDOMSHIP(boolean isPirate)
    {
        Random random = new Random();

        FileHandle[] ships =
                isPirate ? Gdx.files.internal("Ships/Pirates").list()
                        : Gdx.files.internal("Ships/Raiders").list();

        return new Texture(ships[random.nextInt(ships.length)]);
    }
}