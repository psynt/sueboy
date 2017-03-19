package com.sueboy.chatbox

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.Stage
import com.sueboy.Font

/**
 * Created by nichita on 18/03/17.
 */
class TextArea extends Group{

    def textfields = new ArrayList<TextLine>()

    TextArea(List<TextLine> strings,int x=0, int y=0, int w=1024, int h=1024){ //((strings.size()+1)*Font.hi)
        def maxl = 0
        for (int i = strings.size()-1 ; i>=0 ; i--){
            def tl = strings.get(i)
            def ay = (float) (y + ((strings.size()-i-1) * Font.hi))
            if(tl.len()>maxl) maxl = tl.len()
            tl.setBounds(x,ay,x+tl.len(),(float)(ay))
        }
        textfields.addAll(strings)
        strings.each {addActor(it)}
    }

}
