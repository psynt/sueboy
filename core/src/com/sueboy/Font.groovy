package com.sueboy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator

/**
 * Created by nichita on 18/03/17.
 */

class Font {

    static font;
    static wid;
    static hi = 16

    static init(){

        def gen = new FreeTypeFontGenerator(Gdx.files.internal("Inconsolata.otf"))
        def par = new FreeTypeFontGenerator.FreeTypeFontParameter()
        par.size = hi
        font = gen.generateFont(par)
        gen.dispose()

        wid = 3.8

    }

    static draw(Batch bt, String text,float x, float y){
        font.draw(bt,text,x,(float)(y+hi))
    }


}
