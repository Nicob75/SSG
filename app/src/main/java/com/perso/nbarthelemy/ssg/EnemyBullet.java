package com.perso.nbarthelemy.ssg;

/**
 * Created by Nico on 06/04/2016.
 */
public class EnemyBullet extends Bullet {
    public EnemyBullet(short gameId, float speed, short direction){
        super(gameId, speed, direction);
    }

    public void customCollision(int x, int y, short gameId) {

    }
}
