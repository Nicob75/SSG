package com.perso.nbarthelemy.ssg;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nico on 06/04/2016.
 */
public class GameEngine {
    private static GameEngine gameEngine = null;
    private static short nextGameId = 0;
    private static List<GameObject> gameObjectList = null;
    private static Context context = null;

//    private static final int screenXMin = -64;
//    private static final int screenYMin = 10;
//    private static final int screenXMax = 1144;
//    private static final int screenYMax = 1984;

    private static final int screenXMin = 0;
    private static final int screenYMin = 0;
    private static final int screenXMax = 1080;
    private static final int screenYMax = 1920;

    private static short[][] collisionGrid = null;

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public static short[][] getCollisionGrid() {
        return collisionGrid;
    }

    public static void setCollisionGrid(short[][] collisionGrid) {
        GameEngine.collisionGrid = collisionGrid;
    }

    public int getScreenXMin() {
        return screenXMin;
    }

    public int getScreenYMin() {
        return screenYMin;
    }

    public int getScreenXMax() {
        return screenXMax;
    }

    public int getScreenYMax() {
        return screenYMax;
    }

    private GameEngine(){
    }

    public static GameEngine getInstance() {
        if (gameEngine == null) {
            gameEngine = new GameEngine();
        }
        return gameEngine;
    }

    public void init(Context pContext){
        nextGameId = 0;
        gameObjectList = new ArrayList<>();
        context = pContext;
        collisionGrid = new short[1080][1920];
    }

    public short getNextGameId(){
        return nextGameId++;
    }

//    public GameObject getGameObject(short gameId) {
    public GameObject getGameObject(int index) {
        return gameObjectList.get(index);
    }

    public List<GameObject> getGameObjectList() {
        return gameObjectList;
    }

    public void setGameObjectList(List<GameObject> gameObjectList) {
        gameObjectList = gameObjectList;
    }

    public void addGameObject(GameObject gameObject) {
        gameObjectList.add(gameObject);
    }

    public Context getContext() {
        return context;
    }

    public void moveObjects() {
        resetCollisionGrid();
        for(GameObject gameObject : gameObjectList) {
            gameObject.move();
        }
    }

    public void destroyGameObject(GameObject gameObject) {
        gameObjectList.remove(gameObject);
    }

    public void resetCollisionGrid(){
        for (short[] row: collisionGrid)
            java.util.Arrays.fill(row, (short)-1 );
    }

    public short getObjectCollisionAt(int collisionGridX, int collisionGridY) {
        return collisionGrid[collisionGridX][collisionGridY];
    }

    public void setObjectCollisionAt(int collisionGridX, int collisionGridY, short gameObjectId) {
        collisionGrid[collisionGridX][collisionGridY]= gameObjectId;
    }

//    public void setObjectCollisionAt(int[][] collisionGridPositions, short gameObjectId) {
//        collisionGrid[collisionGridX][collisionGridY]= gameObjectId;
//    }
}
