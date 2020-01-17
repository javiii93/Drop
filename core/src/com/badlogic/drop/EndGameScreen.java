package com.badlogic.drop;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.drop.GameScreen.punt;


public class EndGameScreen implements Screen {

    final Drop game;

    OrthographicCamera camera;
    Sound endGame;
    boolean b = true;
    Texture main;


    public EndGameScreen(final Drop gam) {

        game = gam;
        endGame = Gdx.audio.newSound(Gdx.files.internal("endGame.wav"));
        main = new Texture(Gdx.files.internal("rainPicture.jpg"));
        camera = new OrthographicCamera();

        camera.setToOrtho(false, 800, 480);


    }


    @Override

    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();

        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        game.font.draw(game.batch, "Se ha acabado el juego Drop!!! Tu puntuacion es de: " + punt, 100, 150);

        game.font.draw(game.batch, "Pulsa cualquier parte para volver a empezar!", 100, 100);

        game.batch.end();
        if (b) {
            endGame.play();
            b = false;
        }


        if (Gdx.input.isTouched()) {

            game.setScreen(new GameScreen(game));

            dispose();

        }

    }


    @Override

    public void resize(int width, int height) {

    }


    @Override

    public void show() {

    }


    @Override

    public void hide() {

    }


    @Override

    public void pause() {

    }


    @Override

    public void resume() {

    }


    @Override

    public void dispose() {
        endGame.dispose();

    }

}