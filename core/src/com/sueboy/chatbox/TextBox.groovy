package com.sueboy.chatbox

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.sueboy.Font

/**
 * Created by nichita on 18/03/17.
 */
class TextBox extends Group{
    def t

    TextBox(TextArea ta, Color color, int width=1024,int height=((ta.textfields.size())*Font.hi)+5,int x=0, int y=0){

        def pixmap = new Pixmap(width, height+5, Pixmap.Format.RGBA8888)
        pixmap.setColor(color)
        pixmap.fillRectangle(x, y, width, height+5)

        t = new Texture(pixmap)

        addActor(new Actor(){
            @Override
            void draw(Batch batch, float parentAlpha) {
                batch.draw(t,x,y)
            }
        })

        pixmap.dispose()

        addActor(ta)

    }


}
