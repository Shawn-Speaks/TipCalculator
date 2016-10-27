package shawn.c4q.nyc.derplist.model;

/**
 * Created by shawnspeaks on 10/20/16.
 */


/**
 * Java representation of data to be displayed in RecyclerView
 */


public class ListItem {
    private String title;
    private int imageResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
