package shawn.c4q.nyc.derplist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawnspeaks on 10/20/16.
 */

public class DerpData {

    private static final String[] titles = {"Title one", "Number Two", "Ran out of three."};

    private static final int[] icons = {android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_alert};

    public static List<ListItem> getListData(){
        List<ListItem> data = new ArrayList<>();

//        for (int x = 0; x < 4; x++) {
//            create ListItem with dummy data, then add them to our List
            for (int i = 0; i < titles.length && i < icons.length; i++) {
                ListItem item = new ListItem();
                item.setImageResId(icons[i]);
                item.setTitle(titles[i]);
                data.add(item);
            }
        return data;
    }

}
