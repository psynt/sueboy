package com.sueboy

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator

/**
 * Created by nichita on 18/03/17.
 */

class Font {

    static font;
    static wid;

    static init(){

        def gen = new FreeTypeFontGenerator(Gdx.files.internal("Inconsolata.otf"))
        def par = new FreeTypeFontGenerator.FreeTypeFontParameter()
        par.size = 16
        font = gen.generateFont(par)
        gen.dispose()

        wid = 3.8

    }


}
