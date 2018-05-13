package rohit.com.singlecontextdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 24343 on 1/4/2018.
 */

public class MyApplication extends Application
{
    private static MyApplication sInstance;
    private int gameScore = 0;
    public int getGameScore()
    {
        return gameScore;
    }
    public void setGameScore(int gameScore)
    {
        this.gameScore = gameScore;
    }
    public void incrementScore()
    {
        gameScore++;
    }


    public static Context getAppContext()
    {
        return sInstance;
    }
  /*  @Override
    public void onCreate() {
        super.onCreate();
        Log.d("onCreate", "onCreate() called");
        sInstance = this;
    }*/

}
