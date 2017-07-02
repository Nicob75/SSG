package com.perso.nbarthelemy.ssg;

import android.graphics.Bitmap;

/**
 * Created by Nico on 06/04/2016.
 */
public abstract class Bullet extends ActiveObject {
    public Bullet(short gameId, float speed, short direction){
        super(gameId, speed, direction);
    }
}
