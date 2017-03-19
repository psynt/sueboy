package com.sueboy

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor

/**
 * Created by nichita on 18/03/17.
 */
class Thing extends Actor{

    def touched = 0
    def actorX = 0, actorY = 0
    def plane =new Texture("jet.png")

    Thing(){
        setBounds(actorX,actorY,plane.getWidth(),plane.getHeight())
    }

    @Override
    void act(float delta) {
        if (touched)
            actorX+=5
    }

    @Override
    void draw(Batch batch, float parentAlpha) {
        batch.draw(plane,actorX,actorY)
    }
}
