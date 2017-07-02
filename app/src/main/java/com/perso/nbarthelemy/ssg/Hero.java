package com.perso.nbarthelemy.ssg;

import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Nico on 06/04/2016.
 */
public class Hero extends ActiveObject{

    public Hero(short gameId, float speed, short direction){
        super(gameId, speed, direction);
        Timer timer = new Timer();
        // can_shoot
        timer.schedule(new heroShootTimer(), 0,500);
    }

    @Override
    public void leafObjectActions() {
        this.imageView.setImageDrawable(GameEngine.getInstance().getContext().getResources().getDrawable(R.drawable.spr_flight1));
    }

    final Runnable heroShoot = new Runnable() {
        @Override
        public void run() {
            GameEngine gameEngine = GameEngine.getInstance();
            Level01 level01 = (Level01)gameEngine.getContext();

            HeroBullet heroBullet = new HeroBullet(gameEngine.getNextGameId(), 4.0f, (short)90 );
            ImageView heroBulletImageView = heroBullet.getImageView();
            ImageView heroImageView = GameEngine.getInstance().getGameObject(0).getImageView();
            heroBulletImageView.setX(heroImageView.getX() + 24 );
            heroBulletImageView.setY(heroImageView.getY() + 20 );

            HeroBullet heroBullet2 = new HeroBullet(gameEngine.getNextGameId(), 4.0f, (short)90 );
            ImageView heroBulletImageView2 = heroBullet2.getImageView();
            heroBulletImageView2.setX(heroImageView.getX() + 96 );
            heroBulletImageView2.setY(heroImageView.getY() + 20 );

            GameEngine.getInstance().addGameObject(heroBullet);
            GameEngine.getInstance().addGameObject(heroBullet2);
        }
    };

//    public void move() {
//        super.move();
//
//    }

    class heroShootTimer extends TimerTask {
        @Override
        public void run() {
            Level01 level01 = (Level01)GameEngine.getInstance().getContext();
            level01.runOnUiThread(heroShoot );
        }
    }

    public void customCollision(int x, int y, short gameId) {

    }

    public void display(){

    }
}
