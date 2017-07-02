package com.perso.nbarthelemy.ssg;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;

/**
 * Created by Nico on 06/04/2016.
 */
public abstract class ActiveObject extends GameObject{

    protected short[][] hitBox = null;
    protected int width;
    protected int height;

    public ActiveObject(short gameId, float speed, short direction){
        super(gameId, speed, direction);
    }

    @Override
    public void postCreateActions() {
        super.postCreateActions();

        measureDimensionAndInitMask();
    }

    private void measureDimensionAndInitMask() {
        if (imageView != null) {
//            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                @Override
//                public void onGlobalLayout() {
//                    width = imageView.getWidth();
//                    height = imageView.getHeight();
//
                    width = 144;
                    height = 144;
                    hitBox = new short[width][height];

                    for (short[] row: hitBox)
                        java.util.Arrays.fill(row, gameId );
//                    // move here
////                        widthtext.setText(width);
////                        heighttext.setText(height);
//                }
//            });
        }
    }

    @Override
    public void move() {
        super.move();
        if (imageView != null) {
            GameEngine gameEngine = GameEngine.getInstance();
            int globalX = (int)imageView.getX();
            int globalY = (int)imageView.getY();
//            for(int y=0; y<width; y++ ) {
//                for(int x=0; x<height; x++ ) {
//                    int curX = globalX + x;
//                    int curY = globalY + y;
//                    if (curX > gameEngine.getScreenXMin() && curY > gameEngine.getScreenYMin()
//                            && curX < gameEngine.getScreenXMax() && curY < gameEngine.getScreenYMax() ) {
//                        short id = gameEngine.getObjectCollisionAt(curX, curY );
//                        if (id != -1 && id != gameId) {
//                            customCollision(curX, curY, id );
//                        }
//                        gameEngine.setObjectCollisionAt(curX, curY, gameId );
//                    }
//                }
//            }
        }
    }

    public abstract void customCollision(int x, int y, short gameId);
}
