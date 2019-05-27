package com.danmoop.raidersbay.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.danmoop.raidersbay.Main;

import static com.danmoop.raidersbay.Settings.SCREEN_HEIGHT;
import static com.danmoop.raidersbay.Settings.SCREEN_WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = SCREEN_WIDTH;
		config.height = SCREEN_HEIGHT;

		new LwjglApplication(new Main(), config);
	}
}
