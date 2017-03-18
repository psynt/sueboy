package com.sueboy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.Touchable

/**
 * Created by nichita on 18/03/17.
 */
class Stuff extends Stage{

    def bt = getBatch()
    def a = new Thing()

    def font = Font.font
    def text = "hello"*15;

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

        font.draw(bt,text,0,300)

        getActors().each {
            it.draw(bt,1);
        }

        bt.end();
    }

    @Override
    void dispose() {
        super.dispose()
        font.dispose()
    }
}
