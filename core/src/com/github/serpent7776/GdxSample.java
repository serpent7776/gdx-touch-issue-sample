package com.github.serpent7776;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GdxSample extends ApplicationAdapter {

	private static final String TAG = GdxSample.class.getSimpleName();

	Stage stage;
	Texture img;
	Image image1;
	Image image2;

	@Override
	public void create() {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		img = new Texture("badlogic.jpg");
		image1 = new Image(img);
		image2 = new Image(img);
		stage.addActor(image1);
		stage.addActor(image2);
		final float width = Gdx.graphics.getWidth();
		final float height = Gdx.graphics.getWidth();
		image1.setBounds(0, 0, width * 0.2f, height * 0.2f);
		image2.setBounds(0.7f * width, 0.7f * height, 0.3f * width, 0.3f * height);
		image1.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log(TAG, "left image clicked");
			}

		});
		image2.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log(TAG, "right image clicked");
			}

		});
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		final float delta = Gdx.graphics.getDeltaTime();
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void dispose () {
		stage.dispose();
	}

}
