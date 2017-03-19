package com.sueboy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Main extends ApplicationAdapter {
	private Stage st,st2;

	@Override
	public void create () {
		Font.init();
		st= new Stuff();
//		st2= new Stuff();
        Gdx.input.setInputProcessor(st);

	}

	@Override
	public void dispose () {
		st.dispose();
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		st.act(Gdx.graphics.getDeltaTime());
		st.draw();

//		st2.act(Gdx.graphics.getDeltaTime());
//		st2.draw();


	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

}
