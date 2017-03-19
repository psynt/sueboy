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

    TextBox(TextArea ta, Color color, int width=1024,int height=((ta.textfields.size()+1)*Font.hi),int x=0, int y=0){

        def pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888)
        pixmap.setColor(color)
        pixmap.fillRectangle(x-width, (int)(y-(height)), width*2, height*2)

        t = new Texture(pixmap)

        addActor(new Actor(){
            @Override
            void draw(Batch batch, float parentAlpha) {
                batch.draw(t,x,(int)(y))
            }
        })

        pixmap.dispose()

        ta.setBounds(x,y,width,height)

        addActor(ta)

    }


}
