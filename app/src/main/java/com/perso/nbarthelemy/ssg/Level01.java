package com.perso.nbarthelemy.ssg;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Level01 extends AppCompatActivity {

//    int testVar = 1;

    TextView gScoreTextView;
    ImageView gBcgImageView;
//    ImageView gHeroImageView;
//    ImageView gEnemy1_0_ImageView;
//    ImageView gEnemy1_1_ImageView;
//    ImageView gEnemy2_0_ImageView;

//    Hero hero;

    // Called when the user clicks the finger image button
//    private View.OnClickListener bcgImageViewOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            gBcgImageView.scrollBy(0,5);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GameEngine gameEngine = GameEngine.getInstance();
        gameEngine.init(this);

        setContentView(R.layout.activity_level01);

        gScoreTextView = (TextView) findViewById(R.id.textview_score);
        gBcgImageView = (ImageView) findViewById(R.id.imageview_bcg);

//        gHeroImageView = (ImageView) findViewById(R.id.imageview_hero);
        Hero hero = new Hero(gameEngine.getNextGameId(), 0.0f, (short)0 );
//        hero.imageView = gHeroImageView;
        hero.getImageView().setX(500);
        hero.getImageView().setY(1500);
        gameEngine.addGameObject(hero);
//        gEnemy1_0_ImageView = (ImageView) findViewById(R.id.imageview_enemy1_0);
//        gEnemy1_1_ImageView = (ImageView) findViewById(R.id.imageview_enemy1_1);
        Enemy enemy = new Enemy(gameEngine.getNextGameId(), 0.0f, (short)0 );
//        enemy.imageView = gHeroImageView;
        enemy.getImageView().setX(500);
        enemy.getImageView().setY(300);
        gameEngine.addGameObject(enemy);
//        gEnemy2_0_ImageView = (ImageView) findViewById(R.id.imageview_enemy2_0);
//        gBcgImageView.setOnClickListener(bcgImageViewOnClickListener);

        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        //ImageView img = (ImageView)findViewById(R.id.imageview_bcg);
        gBcgImageView.setBackgroundResource(R.drawable.bcg2_test_anim);

        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) gBcgImageView.getBackground();

        // Start the animation (looped playback by default).
        frameAnimation.start();

        Timer timer = new Timer();
        // move_objects
        timer.schedule(new moveObjectsTimer(), 0,25);
    }

    public boolean onTouchEvent(MotionEvent e) {
        GameEngine gameEngine = GameEngine.getInstance();
        int xpos = ((int) e.getX()) - 100;
        int ypos = ((int) e.getY()) - 500;
        if (xpos > gameEngine.getScreenXMin() && ypos > gameEngine.getScreenYMin()
                && xpos < gameEngine.getScreenXMax() && ypos < gameEngine.getScreenYMax() ) {
            Hero hero = (Hero)gameEngine.getGameObject(0);
            hero.getImageView().setX(xpos);
            hero.getImageView().setY(ypos);
        }
        return true;
    }

    public RelativeLayout getMainLayout() {
        return (RelativeLayout)findViewById(R.id.mainLayout);
    }

    final Runnable moveObjects = new Runnable() {
        @Override
        public void run() {
            GameEngine.getInstance().moveObjects();
        }
    };

    class moveObjectsTimer extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(moveObjects);
        }
    }

}
