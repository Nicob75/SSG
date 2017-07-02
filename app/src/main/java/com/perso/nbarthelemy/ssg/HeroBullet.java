package com.perso.nbarthelemy.ssg;

/**
 * Created by Nico on 06/04/2016.
 */
public class HeroBullet extends Bullet {
    public HeroBullet(short gameId, float speed, short direction){
        super(gameId, speed, direction);
        this.imageView.setImageDrawable(GameEngine.getInstance().getContext().getResources().getDrawable(R.drawable.spr_mis1));
    }

    @Override
    public void customCollision(int x, int y, short gameId) {
        GameEngine gameEngine = GameEngine.getInstance();
        for (GameObject gameObject : gameEngine.getGameObjectList() ) {
            if (gameObject.gameId != gameId) {
                if (gameObject instanceof Enemy) {
                    Level01 level01 = (Level01)gameEngine.getContext();
                    level01.runOnUiThread(new InstanceDestroy(this) );
                }
            }
        }
    }
}
