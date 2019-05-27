package com.danmoop.raidersbay;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Levels.FirstLevel;
import com.danmoop.raidersbay.Manager.LevelManager;

public class Main extends ApplicationAdapter {

	private LevelManager manager;

	private SpriteBatch batch;

	@Override
	public void create ()
	{
		batch = new SpriteBatch();

		manager = new LevelManager();
		manager.open(new FirstLevel());
	}

	@Override
	public void render () {
		manager.getActiveLevel().update();
		manager.getActiveLevel().render(batch);
	}
	
	@Override
	public void dispose () {
		manager.getActiveLevel().dispose();
	}
}