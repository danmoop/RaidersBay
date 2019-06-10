package com.danmoop.raidersbay.Model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SnapshotArray;

import static com.danmoop.raidersbay.Settings.SCREEN_HEIGHT;
import static com.danmoop.raidersbay.Settings.SCREEN_WIDTH;

public abstract class Level
{
    private OrthographicCamera camera;

    private SnapshotArray<GameObject> gameObjects;
    private SnapshotArray<HUDElement> hudElements;

    protected Level()
    {
        this.gameObjects = new SnapshotArray<>();
        this.hudElements = new SnapshotArray<>();

        camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);

        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public OrthographicCamera getCamera()
    {
        return camera;
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

    public void destroyGameObject(GameObject object)
    {
        gameObjects.removeIndex(gameObjects.indexOf(object, true));
    }

    protected void updateGameObjects()
    {
        for (GameObject gameObject : gameObjects)
        {
            gameObject.update();
        }

        camera.update();
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

        batch.setProjectionMatrix(camera.combined);
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