package com.danmoop.raidersbay.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.GameObjects.BadLogic;
import com.danmoop.raidersbay.Model.Level;

public class FirstLevel extends Level
{
    private BadLogic badLogic;

    @Override
    public void start()
    {
        badLogic = (BadLogic) addGameObject(new BadLogic());
    }

    @Override
    public void update()
    {
        updateGameObjects();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        renderGameObjects(batch);

        batch.end();
    }

    @Override
    public void dispose()
    {
        disposeGameObjects();
    }
}
