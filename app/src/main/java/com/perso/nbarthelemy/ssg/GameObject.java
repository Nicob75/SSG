package com.perso.nbarthelemy.ssg;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Nico on 06/04/2016.
 */
public abstract class GameObject {
    protected short gameId;
    protected ImageView imageView;
    protected float speed;
    protected short direction;

    public GameObject(short gameId, float speed, short direction){
        this.gameId = gameId;
        this.speed = speed;
        this.direction = direction;
        this.imageView = new ImageView(GameEngine.getInstance().getContext() );
//        this.imageView.setWi
        leafObjectActions();
        postCreateActions();
    }

    public short getDirection() {
        return direction;
    }

    public void setDirection(short direction) {
        this.direction = direction;
    }

    public short getGameId() {
        return gameId;
    }

    public void setGameId(short gameId) {
        this.gameId = gameId;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void leafObjectActions() { //in order: leafObjectActions, then postCreateActions
    }

    public void postCreateActions() {
        GameEngine gameEngine = GameEngine.getInstance();
        Level01 level01 = (Level01)gameEngine.getContext();
        RelativeLayout layout = level01.getMainLayout();
        layout.addView(this.imageView);
    }

    public void move() {
        if (imageView != null ) {
            switch (direction) {
                case 0:
                    imageView.setX(imageView.getX() + speed );
                    break;
                case 90:
                    imageView.setY(imageView.getY() - speed );
                    break;
                case 180:
                    imageView.setX(imageView.getX() - speed );
                    break;
                case 270:
                    imageView.setY(imageView.getY() + speed );
                    break;
            }
            checkOutside();
        }
    }

    public void checkOutside() {
        GameEngine gameEngine = GameEngine.getInstance();
        if (imageView.getX() < gameEngine.getScreenXMin() || imageView.getY() < gameEngine.getScreenYMin()
                || imageView.getX() > gameEngine.getScreenXMax() || imageView.getY() > gameEngine.getScreenYMax() ) {
            Level01 level01 = (Level01)gameEngine.getContext();
            level01.runOnUiThread(new InstanceDestroy(this) );
        }

//        if (imageView.getY() < gameEngine.getScreenYMin() - 50 ) {
//            Level01 level01 = (Level01)GameEngine.getContext();
//            level01.runOnUiThread(new InstanceRebirth(this) );
//        }
    }

    class InstanceDestroy implements Runnable {
        GameObject gameObject;
        InstanceDestroy(GameObject gameObject) {
            this.gameObject = gameObject;
        }

        @Override
        public void run() {
            GameEngine gameEngine = GameEngine.getInstance();
            Level01 level01 = (Level01)gameEngine.getContext();
            RelativeLayout layout = level01.getMainLayout();

            layout.removeView(gameObject.imageView);
//            gameObject.imageView = null; // TODO
//            gameEngine.destroyGameObject(gameObject);
        }
    }

    class InstanceRebirth implements Runnable {
        GameObject gameObject;
        InstanceRebirth(GameObject gameObject) {
            this.gameObject = gameObject;
        }

        @Override
        public void run() {
            GameEngine gameEngine = GameEngine.getInstance();
            Level01 level01 = (Level01)gameEngine.getContext();
            RelativeLayout layout = level01.getMainLayout();

            imageView.setY(500);
            layout.addView(gameObject.imageView);
//            gameObject.imageView = null; // TO IMPROVE
//            gameEngine.destroyGameObject(gameObject);
        }
    }
}
