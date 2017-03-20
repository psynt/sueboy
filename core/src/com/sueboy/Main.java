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

import java.util.Random;

public class Main extends ApplicationAdapter {
	private Stage st,st2;
	private Bar b;
	private Guy g;
	private SpriteBatch sb;
	public static Random rand = new Random();

	@Override
	public void create () {
		Font.init();
		sb = new SpriteBatch();
		st= new Stuff();
		b = new Bar();
		g=new Guy(new GuyGen());
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


		sb.begin();
		b.forEach(e -> e.draw(sb));
//		g.draw(sb,1);
		sb.end();



		st.act(Gdx.graphics.getDeltaTime());
		st.draw();


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
