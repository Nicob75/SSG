package com.perso.nbarthelemy.ssg;

/**
 * Created by Nico on 06/04/2016.
 */
public class Enemy extends ActiveObject {
    public Enemy(short gameId, float speed, short direction){
        super(gameId, speed, direction);
        this.imageView.setImageDrawable(GameEngine.getInstance().getContext().getResources().getDrawable(R.drawable.spr_enemi1));
    }

    public void customCollision(int x, int y, short gameId) {

    }
}
