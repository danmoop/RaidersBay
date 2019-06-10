package com.danmoop.raidersbay.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.GameObjects.CannonBall;
import com.danmoop.raidersbay.GameObjects.Enemy;
import com.danmoop.raidersbay.GameObjects.Player;
import com.danmoop.raidersbay.Manager.LevelManager;
import com.danmoop.raidersbay.Manager.Storage;
import com.danmoop.raidersbay.Model.Level;
import com.danmoop.raidersbay.Model.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.danmoop.raidersbay.Settings.*;

public class PlayScene extends Level
{
    private LevelManager levelManager;

    private Player player;
    private Enemy enemy;
    private CannonBall playerBall;
    private CannonBall enemyBall;

    private Text waveText;
    private Text fireText;
    private Text prepareText;

    private Timer timer;
    private boolean isFiring;

    private int waveNum;

    PlayScene(LevelManager levelManager)
    {
        this.levelManager = levelManager;

        waveNum = 1;
        isFiring = false;

        waveText = (Text) addHUDElement(new Text("Fonts/eina.ttf", "Wave 1", 100, 100, 40, STYLED_TEXT()));

        fireText = new Text("Fonts/eina.ttf", "Fire!", 100, 100, 50, FIRE_TEXT());
        prepareText = new Text("Fonts/eina.ttf", "Prepare!", 100, 100, 50, STYLED_TEXT());

        player = (Player) addGameObject(new Player(RANDOMSHIP(false), 100, 50));
        enemy = (Enemy) addGameObject(new Enemy(RANDOMSHIP(true), 100, 34));
    }

    @Override
    public void start()
    {
        player.setSize((int) (player.getWidth() * 1.5), (int) (player.getHeight() * 1.5));
        enemy.setSize((int) (enemy.getWidth() * 1.5), (int) (enemy.getHeight() * 1.5));

        player.setPos(SCREEN_WIDTH / 2f - player.getWidth() / 2f - 250, SCREEN_HEIGHT / 2f - player.getHeight() / 2f);
        enemy.setPos(SCREEN_WIDTH / 2f - enemy.getWidth() / 2f + 250, SCREEN_HEIGHT / 2f - enemy.getHeight() / 2f);

        fireText.setPos(SCREEN_WIDTH / 2f - fireText.getWidth() / 2f, fireText.getHeight() + 35);
        prepareText.setPos(SCREEN_WIDTH / 2f - prepareText.getWidth() / 2f, prepareText.getHeight() + 35);
        waveText.setPos(SCREEN_WIDTH / 2f - waveText.getWidth() / 2f, SCREEN_HEIGHT - waveText.getHeight());

        setTimer();
    }

    @Override
    public void update()
    {
        if(Gdx.input.justTouched() && enemy.isTargeted() && playerBall == null && isFiring)
        {
            playerBall = (CannonBall) addGameObject(new CannonBall(new Texture("ShipParts/cannonBall.png"), 20));
            playerBall.setPos(player.getX() + player.getWidth(), player.getY() + player.getHeight() / 2f);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            levelManager.open(new IntroScene(levelManager));

        if(playerBall != null && playerBall.collidedWith(enemy))
        {
            destroyGameObject(playerBall);
            playerBall = null;
            player.attack(enemy, player.damage);
        }

        if(enemyBall != null && enemyBall.collidedWith(player))
        {
            destroyGameObject(enemyBall);
            enemyBall = null;
            enemy.attack(player, enemy.damage);

            if(player.isDestroyed())
                levelManager.open(new IntroScene(levelManager));
        }

        if(enemy.isDestroyed())
            enemyDestroyed();

        updateGameObjects();
    }

    private void enemyDestroyed()
    {
        enemy.generateNewShip();
        enemy.HP = 100;
        enemy.setText(String.valueOf(enemy.HP));

        player.HP = 100;
        player.setText(String.valueOf(player.HP));

        waveNum++;
        waveText.setText("Wave " + waveNum);

        int highScore = Storage.getInteger("highscore");

        if(waveNum > highScore)
            Storage.putInt("highscore", waveNum);
    }

    private void setTimer()
    {
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                isFiring = !isFiring;
            }
        }, 1250, 1250);
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glClearColor(95 / 255f, 189 / 255f, 197 / 255f, 1);

        batch.begin();

        renderGameObjects(batch);

        if(isFiring)
            fireText.render(batch);
        else
            prepareText.render(batch);

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
}