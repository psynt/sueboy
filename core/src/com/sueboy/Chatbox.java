package com.sueboy;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by nichita on 18/03/17.
 */
public class Chatbox extends SpriteBatch {

    public Chatbox(){

        new BitmapFont().draw(this, "Hello World", 200, 200);
    }

}
