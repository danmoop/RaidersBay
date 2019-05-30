package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;

public abstract class Level
{
    private SnapshotArray<GameObject> gameObjects;
    private SnapshotArray<HUDElement> hudElements;

    protected Level()
    {
        this.gameObjects = new SnapshotArray<>();
        this.hudElements = new SnapshotArray<>();
    }

    protected GameObject addGameObject(GameObject object)
    {
        gameObjects.add(object);

        return object;
    }

    protected HUDElement addHUDElement(HUDElement element)
    {
        hudElements.add(element);

        return element;
    }

    public void removeGameObject(GameObject object)
    {
        gameObjects.removeIndex(gameObjects.indexOf(object, false));
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

        for (HUDElement hudElement : hudElements)
        {
            hudElement.render(batch);
        }
    }

    protected void disposeGameObjects()
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.dispose();
        }

        for (HUDElement hudElement : hudElements)
        {
            hudElement.dispose();
        }
    }

    public abstract void start();

    public abstract void update();

    public abstract void render(SpriteBatch batch);

    public abstract void resize(int width, int height);

    public abstract void dispose();
}