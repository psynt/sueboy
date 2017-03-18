package com.sueboy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

/**
 * Created by nichita on 18/03/17.
 */
class Stuff extends Stage{

    def bt = getBatch()
    def a = new Thing()

    def font = new BitmapFont()
    def text = "hello";

    Stuff() {
        super()
        a.addListener(new InputListener(){
            @Override
            boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                ((Thing)event.getTarget()).setTouched(true);
                text = "bye"
                println "hit"
                true
            }

        })

        a.setTouchable(Touchable.enabled)
        addActor(a);

    }

    void draw() {
        camera.update();

        bt.setProjectionMatrix(camera.combined);

        bt.begin();

        font.draw(bt,text,300,300)

        getActors().each {
            it.draw(bt,1);
        }

        bt.end();
    }


}
