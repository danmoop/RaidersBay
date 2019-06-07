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

import static com.danmoop.raidersbay.Settings.*;

public class PlayScene extends Level
{
    private LevelManager levelManager;

    private Player player;
    private Enemy enemy;
    private CannonBall ball;

    private Text waveText;

    private int waveNum;

    PlayScene(LevelManager levelManager)
    {
        this.levelManager = levelManager;

        waveNum = 1;

        waveText = (Text) addHUDElement(new Text("Fonts/eina.ttf", "Wave 1", 100, 100, 30, STYLED_TEXT()));
        player = (Player) addGameObject(new Player(RANDOMSHIP(false), 100, 25));
        enemy = (Enemy) addGameObject(new Enemy(RANDOMSHIP(true), 100, 25));
        ball = (CannonBall) addGameObject(new CannonBall(new Texture("ShipParts/cannonBall.png")));
    }

    @Override
    public void start()
    {
        player.setSize((int) (player.getWidth() * 1.5), (int) (player.getHeight() * 1.5));

        enemy.setSize((int) (enemy.getWidth() * 1.5), (int) (enemy.getHeight() * 1.5));

        player.setPos(SCREEN_WIDTH / 2f - player.getWidth() / 2f - 250, SCREEN_HEIGHT / 2f - player.getHeight() / 2f);
        enemy.setPos(SCREEN_WIDTH / 2f - enemy.getWidth() / 2f + 250, SCREEN_HEIGHT / 2f - enemy.getHeight() / 2f);

        // REMOVE LATER
        ball.setPos(player.getX(), player.getY());

        waveText.setPos(SCREEN_WIDTH / 2f - waveText.getWidth() / 2f, SCREEN_HEIGHT - waveText.getHeight());
    }

    @Override
    public void update()
    {
        if(ball.collidedWith(enemy))
            System.out.println("collided"); // works fine

        if(Gdx.input.justTouched() && enemy.isTargeted())
        {
            player.attack(enemy, player.damage);

            if(enemy.isDestroyed())
                enemyDestroyed();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            levelManager.open(new IntroScene(levelManager));

        updateGameObjects();
    }

    private void enemyDestroyed()
    {
        enemy.generateNewShip();
        enemy.HP = 100;
        enemy.setText(String.valueOf(enemy.HP));
        waveNum++;
        waveText.setText("Wave " + waveNum);

        int highScore = Storage.getInteger("highscore");

        if(waveNum > highScore)
            Storage.putInt("highscore", waveNum);
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
}