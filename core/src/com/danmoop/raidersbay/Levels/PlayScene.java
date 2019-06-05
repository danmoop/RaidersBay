package com.danmoop.raidersbay.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.GameObjects.Enemy;
import com.danmoop.raidersbay.GameObjects.Player;
import com.danmoop.raidersbay.Manager.LevelManager;
import com.danmoop.raidersbay.Model.Level;

import java.util.Random;

import static com.danmoop.raidersbay.Settings.SCREEN_HEIGHT;
import static com.danmoop.raidersbay.Settings.SCREEN_WIDTH;

public class PlayScene extends Level
{
    private LevelManager levelManager;

    private Player player;
    private Enemy enemy;

    PlayScene(LevelManager levelManager)
    {
        this.levelManager = levelManager;

        player = (Player) addGameObject(new Player(getRandomTexture(false), 100, 25));
        enemy = (Enemy) addGameObject(new Enemy(getRandomTexture(true), 100, 25));
    }

    @Override
    public void start()
    {
        player.setPos(SCREEN_WIDTH / 2f - player.getWidth() / 2f - 250, SCREEN_HEIGHT / 2f - player.getHeight() / 2f);
        enemy.setPos(SCREEN_WIDTH / 2f - enemy.getWidth() / 2f + 250, SCREEN_HEIGHT / 2f - enemy.getHeight() / 2f);
    }

    @Override
    public void update()
    {

        if(Gdx.input.justTouched() && enemy.isClickedOn())
            player.attack(enemy, player.damage);

        updateGameObjects();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glClearColor(95 / 255f, 189 / 255f, 197 / 255f, 1);

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

    private Texture getRandomTexture(boolean isPirate)
    {
        Random random = new Random();

        FileHandle[] ships =
                isPirate ? Gdx.files.internal("Ships/Pirates").list()
                        : Gdx.files.internal("Ships/Raiders").list();

        return new Texture(ships[random.nextInt(ships.length)]);
    }
}