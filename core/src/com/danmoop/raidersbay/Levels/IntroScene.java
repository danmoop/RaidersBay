package com.danmoop.raidersbay.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.danmoop.raidersbay.Manager.LevelManager;
import com.danmoop.raidersbay.Manager.Storage;
import com.danmoop.raidersbay.Model.Level;
import com.danmoop.raidersbay.Model.Text;
import com.danmoop.raidersbay.UI.UIButton;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.danmoop.raidersbay.Settings.*;

public class IntroScene extends Level
{
    private Text gameTitle;
    private Text highScoreText;
    private UIButton playButton;
    private Texture player;
    private Texture enemy;
    private LevelManager manager;

    public IntroScene(LevelManager manager)
    {
        this.manager = manager;

        gameTitle = (Text) addHUDElement(new Text("Fonts/eina.ttf", GAME_TITLE, 100, 100, 50, STYLED_TEXT()));

        playButton = (UIButton) addGameObject(new UIButton(new Texture("UI/play.png")));

        player = new Texture("Ships/Intro/ship (3).png");
        enemy = new Texture("Ships/Intro/ship (2).png");
    }

    @Override
    public void start()
    {
        gameTitle.setPos(
                SCREEN_WIDTH / 2f - gameTitle.getWidth() / 2f,
                SCREEN_HEIGHT - gameTitle.getHeight()
        );

        player.setFilter(Linear, Linear);
        enemy.setFilter(Linear, Linear);

        int highScore = Storage.getInteger("highscore");

        highScoreText = (Text) addHUDElement(new Text("Fonts/eina.ttf", "Highscore: Wave " + highScore, 100, 100, 30, STYLED_TEXT()));

        highScoreText.setPos(SCREEN_WIDTH / 2f - highScoreText.getWidth() / 2f, 30 + highScoreText.getHeight());
    }

    @Override
    public void update()
    {
        if(Gdx.input.justTouched() && playButton.isTargeted())
            manager.open(new PlayScene(manager));

        updateGameObjects();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Gdx.gl.glClearColor(95 / 255f, 189 / 255f, 197 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        renderGameObjects(batch);

        batch.draw(player, SCREEN_WIDTH / 2f - player.getWidth() / 2f - 200, SCREEN_HEIGHT / 2f - player.getHeight(), 86, 147);
        batch.draw(enemy, SCREEN_WIDTH / 2f - player.getWidth() / 2f + 200, SCREEN_HEIGHT / 2f - player.getHeight(), 86, 147);

        batch.end();
    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void dispose()
    {
        player.dispose();
        enemy.dispose();
        disposeGameObjects();
    }
}