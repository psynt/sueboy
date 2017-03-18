package com.sueboy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Stage

/**
 * Created by nichita on 18/03/17.
 */
class Stuff extends Stage{

    def bt = getBatch()
    def font = new BitmapFont()
    def text = "hello";

    Stuff() {
        super()
        addActor(new Thing());
    }

    void draw() {
        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        bt.setProjectionMatrix(camera.combined);

        bt.begin();

        font.draw(bt,text,300,300)

        getActors().each {
            it.draw(bt,1);
        }

//        playerShip.draw(bt, 1F);

        bt.end();

        Gdx.input.setInputProcessor(this);
    }


}
