package com.danmoop.raidersbay.Manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Storage
{
    private static Preferences prefs = Gdx.app.getPreferences("RaiderBayPrefs");

    public static void putString(String key, String str)
    {
        prefs.putString(key, str);

        prefs.flush();
    }

    public static void putInt(String key, int integer)
    {
        prefs.putInteger(key, integer);

        prefs.flush();
    }

    public static int getInteger(String key)
    {
        return prefs.getInteger(key);
    }

    public static String getString(String key)
    {
        return prefs.getString(key);
    }
}