package shawn.c4q.nyc.derplist.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shawn.c4q.nyc.derplist.R;

/**
 * Created by shawnspeaks on 10/27/16.
 */

public class FriendAddFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addfriend, container, false);
    }
}
