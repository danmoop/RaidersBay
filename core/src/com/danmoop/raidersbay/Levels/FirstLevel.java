package com.danmoop.raidersbay.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.GameObjects.Player;
import com.danmoop.raidersbay.Model.Font;
import com.danmoop.raidersbay.Model.Level;

import java.util.Random;

import static com.danmoop.raidersbay.Settings.*;

public class FirstLevel extends Level
{
    private OrthographicCamera camera;
    private Font gameTitle;
    private Player player;

    public FirstLevel()
    {
        camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        camera.update();

        player = (Player) addGameObject(new Player(getRandomShip(), 100, 10));
        gameTitle = (Font) addHUDElement(new Font(new BitmapFont(), GAME_TITLE, 0, 0));

        gameTitle.setPos(
                SCREEN_WIDTH / 2f - gameTitle.getWidth() / 2f,
                SCREEN_HEIGHT / 2f - gameTitle.getHeight() / 2f
        );
    }

    @Override
    public void start()
    {
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        System.out.println(player.HP);
        System.out.println(player.damage);
    }

    @Override
    public void update()
    {
        camera.update();

        gameTitle.update();

        if(Gdx.input.isKeyPressed(Input.Keys.E))
        {
            gameTitle.setScale(3);
            gameTitle.setPos(
                    SCREEN_WIDTH / 2f - gameTitle.getWidth() / 2f,
                    SCREEN_HEIGHT / 2f - gameTitle.getHeight() / 2f
            );
        }

        updateGameObjects();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0.3f, 0.1f, 0.77f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        renderGameObjects(batch);

        gameTitle.render(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void dispose()
    {
        disposeGameObjects();
    }

    private Texture getRandomShip()
    {
        Random rand = new Random();

        FileHandle[] ships = Gdx.files.internal("Ships/Pirates").list();

        return new Texture(ships[rand.nextInt(ships.length)]);
    }
}