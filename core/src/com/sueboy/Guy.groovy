package com.sueboy

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group

/**
 * Created by nichita on 19/03/17.
 */
class Guy extends Group{

    def gen
    def hfsz = 8

    Guy(GuyGen gg,int x=512,int y=512) {
        gen = gg
        setBounds(x+hfsz,y+hfsz,x-hfsz,y-hfsz)
    }


    @Override
    void draw(Batch batch, float parentAlpha) {
        gen.each{
            new Actor(){
                @Override
                void draw(Batch batch, float parentAlpha) {
                    batch.draw()
                }
            }
            it.draw(batch,parentAlpha)
        }
    }
}
