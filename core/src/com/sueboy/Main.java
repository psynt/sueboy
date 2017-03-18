package com.sueboy;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.EventAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Map;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private BitmapFont font;
	private boolean clicked;
    private Sprite sprite;
    private Group gr;
	private Actor act;
	private String text = "Hello";

	@Override
	public void create () {
		gr = new Group();
		batch = new SpriteBatch();
        img = new Texture("jet.png");
        sprite = new Sprite(img);
        act = new Actor(){
			@Override
			public void draw(Batch batch, float parentAlpha) {
				new Sprite(new Texture("jet.png")).draw(batch);
			}
		};
        act.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("aaaaaa!!! ouch!");
				text = "hit";
			}
		});

		font = new BitmapFont();
		font.setColor(Color.BLACK);

	}

	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(img, 0, 0);

		//String text = clicked?"Hello world":"Goodbye Universe";
//        font.draw(batch, text, 200, 200);
//        act.draw(batch,1);
//
//		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//			clicked = true;
//		}
//
//		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
//			clicked = false;
//		}


		new Stuff().draw();

		batch.end();



	}

}
