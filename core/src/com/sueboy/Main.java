package com.sueboy;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Map;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Engine eng;



	public class PositionComponent implements Component {
		public float x = 0.0f;
		public float y = 0.0f;
	}

	public class VelocityComponent implements Component {
		public float x = 0.0f;
		public float y = 0.0f;
	}

	public class MovementSystem extends EntitySystem {
		private ImmutableArray<Entity> entities;

		private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
		private ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);

		public MovementSystem() {}

		public void addedToEngine(Engine engine) {
			entities = engine.getEntitiesFor(Family.all(PositionComponent.class, VelocityComponent.class).get());
		}

		public void update(float deltaTime) {
			for (int i = 0; i < entities.size(); ++i) {
				Entity entity = entities.get(i);
				PositionComponent position = pm.get(entity);
				VelocityComponent velocity = vm.get(entity);

				position.x += velocity.x * deltaTime;
				position.y += velocity.y * deltaTime;
			}
		}
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
		Entity ent = new Entity();

		ent.add(new VelocityComponent());
		ent.add(new PositionComponent());
		eng = new Engine();
		eng.addEntity(ent);
		eng.addSystem(new MovementSystem());
	}

	@Override
	public void render () {

//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();



		eng.update(0);
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
//		img.dispose();
	}


}
