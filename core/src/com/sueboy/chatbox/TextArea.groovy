package com.sueboy.chatbox

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.sueboy.Font

/**
 * Created by nichita on 18/03/17.
 */
class TextArea extends Actor{

    def textfields = new ArrayList<TextLine>()

    TextArea(List<TextLine> strings){
        for (int i = strings.size()-1 ; i>0 ; i--){
            strings.get(i).sety((float)(strings.size()-i))
        }
        textfields.addAll(strings)

    }

//    TextArea(List<String> strings){
//        this (strings.stream().map{
//            new TextLine(it)
//        } as List)
//    }

    def createBox(Color color,int width=1004,int height=(textfields.size()*Font.hi)) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(10, 10, width, height);
        def texture = new Texture(pixmap);
        pixmap.dispose();
        texture
    }

    @Override
    void draw(Batch batch, float parentAlpha) {

        textfields.each {it.draw(batch,parentAlpha)}
    }
}
