package rohit.com.cricketscoreui;

/**
 * Created by 24343 on 1/30/2018.
 */

public interface DrawableClickListener
{
    public static enum DrawablePosition { TOP, BOTTOM, LEFT, RIGHT };
    public void onClick(DrawablePosition target);
}
