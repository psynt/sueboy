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

    TextLine(String text,float y=0,float x=0){
        this.text = text
        setBounds(x,y,(float)(Font.wid*text.length()),Font.hi)
    }


    def len(){
        Font.wid*text.length()
    }

    @Override
    void draw(Batch bt, float parentAlpha) {
        Font.draw(bt,text,getX(),(float)(getY()+Font.hi))
    }
}
