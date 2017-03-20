package com.sueboy

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite

import static com.sueboy.Main.rand

/**
 * Created by nichita on 19/03/17.
 */
class GuyGen extends ArrayList<Texture>{

    static feet = ["1","2","3","4"]
    static head = ["1","2","3","4"]
    static body = ["1","2","3","4"]
    static hair = ["hair1","hair2","hair3","hat1","hat2"]

    GuyGen(){
        def num = rand.nextInt(4)
        add(new Texture("assets/guy-bottom${feet[num]}.png"))
        num = rand.nextInt(4)
        add(new Texture("assets/guy-head${head[num]}.png"))
        num = rand.nextInt(4)
        add(new Texture("assets/guy-top${body[num]}.png"))
        num = rand.nextInt(5)
        add(new Texture("assets/guy-${hair[num]}.png"))
    }

}
