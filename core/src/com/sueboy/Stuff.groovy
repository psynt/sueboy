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

    def font = new BitmapFont()
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
//        addActor(a);

    }

    void draw() {
        camera.update();

        bt.setProjectionMatrix(camera.combined);

        bt.begin();

        def tl = [new TextLine("yellow!"),new TextLine("Bye")]

        def ta = new TextArea(tl)

        def tb = new TextBox(ta, Color.BLUE)

        addActor(tb)

//        addActor(new TextLine("yellow!"));
//        addActor(new TextLine("Bye",1));
//        Font.draw(bt,"yellow",0,0)
//        Font.draw(bt,"Bye!",0,Font.hi)

        getActors().each {
            it.draw(bt,0.5f);
        }

        bt.end();
    }

    @Override
    void dispose() {
        super.dispose()
//        font.dispose()
    }
}
