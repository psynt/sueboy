package com.sueboy.chatbox

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.sueboy.Font

/**
 * Created by nichita on 18/03/17.
 */
class TextLine extends Actor{

    def text
    def offx,offy

    TextLine(String text,float y=0,float x=10){
        this.text = text
        offx=x
        offy=(float)((y)*Font.hi)
        setBounds(offx,offy,(float)(offx+Font.wid*text.length()),(float)(offy+Font.hi))
    }

    def sety(float y){
        offy = (float)((y)*Font.hi)
    }

    @Override
    void draw(Batch bt, float parentAlpha) {
        Font.draw(bt,text,offx,offy)
    }
}
