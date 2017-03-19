package com.sueboy

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Group

/**
 * Created by nichita on 19/03/17.
 */
class Bar extends ArrayList<Sprite>{

    def things = ["backdrop","building","shelves","bartop","stools","bottles"]


    Bar(){
//       add(new Sprite(new Texture("assets/bar-backdrop.png")))
        things.stream().map{"assets/bar-${it}.png"}.map{new Texture(it)}.map{new Sprite(it)}.each {add(it)}
    }



}
