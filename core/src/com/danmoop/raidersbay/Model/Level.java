package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;

public abstract class Level
{
    private SnapshotArray<GameObject> gameObjects;

    public Level()
    {
        this.gameObjects = new SnapshotArray<GameObject>();
    }

    protected GameObject addGameObject(GameObject object)
    {
        gameObjects.add(object);

        return object;
    }

    public void removeGameObject(GameObject object)
    {
        gameObjects.removeIndex(gameObjects.indexOf(object, true));
    }

    protected void updateGameObjects()
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.update();
        }
    }

    protected void renderGameObjects(SpriteBatch batch)
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.render(batch);
        }
    }

    protected void disposeGameObjects()
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.dispose();
        }
    }

    public abstract void start();

    public abstract void update();

    public abstract void render(SpriteBatch batch);

    public abstract void dispose();
}