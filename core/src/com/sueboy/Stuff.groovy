package com.sueboy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.sueboy.chatbox.TextArea
import com.sueboy.chatbox.TextBox
import com.sueboy.chatbox.TextLine

/**
 * Created by nichita on 18/03/17.
 */
class Stuff extends Stage{

    def bt = getBatch()
    def a = new Thing()

    def text = "hello"*15;
    def gee = new Guy(new GuyGen(),100,100)

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
//        addActor(a);

    }

    void draw() {
        camera.update();

        bt.setProjectionMatrix(camera.combined);

        bt.begin();

        def tl = [new TextLine("yellow!"),new TextLine("Bye")]



        def ta = new TextArea(tl)

        def tb = new TextBox(ta, Color.BLUE,100)

//        addActor(tb)
        addActor(gee)


        getActors().each {
            it.draw(bt,1);
        }

        bt.end();
    }

    @Override
    void dispose() {
        super.dispose()
    }
}
