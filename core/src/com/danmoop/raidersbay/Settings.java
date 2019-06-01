package com.danmoop.raidersbay;

import com.badlogic.gdx.graphics.Color;
import com.danmoop.raidersbay.Model.FontConfiguration;

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
}