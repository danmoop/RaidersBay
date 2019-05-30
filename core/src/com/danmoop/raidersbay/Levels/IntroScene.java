package com.danmoop.raidersbay.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.GameObjects.Player;
import com.danmoop.raidersbay.Model.FontConfiguration;
import com.danmoop.raidersbay.Model.Level;
import com.danmoop.raidersbay.Model.Text;

import java.util.Random;

import static com.danmoop.raidersbay.Settings.*;

public class IntroScene extends Level
{
    private OrthographicCamera camera;
    private Text gameTitle;
    private Player player;

    public IntroScene()
    {
        camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);

        player = (Player) addGameObject(new Player(getRandomShip(), 100, 10));

        gameTitle = (Text) addHUDElement(new Text("Fonts/eina.ttf", GAME_TITLE, 100, 100, 40, gameTitleTextConfig()));
    }

    @Override
    public void start()
    {
        camera.setToOrtho(false, SCREEN_WIDTH, SCREEN_HEIGHT);

        gameTitle.setPos(
                SCREEN_WIDTH / 2f - gameTitle.getWidth() / 2f,
                SCREEN_HEIGHT - gameTitle.getHeight()
        );
    }

    @Override
    public void update()
    {
        camera.update();

        updateGameObjects();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(95 / 255f, 189 / 255f, 197 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        renderGameObjects(batch);

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

    private FontConfiguration gameTitleTextConfig()
    {
        return parameter ->
        {
            parameter.borderColor = Color.BLACK;
            parameter.borderWidth = 3;

            parameter.shadowColor = Color.BLACK;
            parameter.shadowOffsetY = 2;
            parameter.shadowOffsetX = 2;
        };
    }
}