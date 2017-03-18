package com.sueboy

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

/**
 * Created by nichita on 18/03/17.
 */
class Thing extends Actor{


    Thing() {
        super()
        addListener(new ClickListener(){
            @Override
            void clicked(InputEvent event, float x, float y) {
                println "hit"
            }
        })
    }

    @Override
    void draw(Batch batch, float parentAlpha) {
        new Sprite(new Texture("jet.png")).draw(batch);
    }
}
