package shawn.c4q.nyc.derplist.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import shawn.c4q.nyc.derplist.R;
import shawn.c4q.nyc.derplist.adapter.DerpAdapter;
import shawn.c4q.nyc.derplist.model.ListItem;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG TOOL";
    private RecyclerView recView;
    private DerpAdapter adapter;
    ArrayList<? extends ListItem> tempList = new ArrayList<>();
    private static final String[] titles = {"Title one", "Number Two", "Ran out of three."};
    private static final int[] icons = {android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_alert};
    private String nextPersonsName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recView = (RecyclerView) findViewById(R.id.rec_list);
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DerpAdapter((List<ListItem>) tempList, this);
        recView.setAdapter(adapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("tempList", (ArrayList<? extends Parcelable>) tempList);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tempList = savedInstanceState.getParcelableArrayList("tempList");
        recView = (RecyclerView) findViewById(R.id.rec_list);
//      Linear Manager types: Grid, Linear, Staggered Grid.
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DerpAdapter((List<ListItem>) tempList, this);
        recView.setAdapter(adapter);
    }

    public void onFoodAddClick(View view){
        // implement me later
    }


    public void onClick(View view) {

        Log.d(TAG, "!!");
        Toast.makeText(this, "This button kinda works", Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction().add(R.id.activity_list, new FriendAddFragment()).commit();

    }


    public void addNameClick(View view){
        EditText mEditText;
        mEditText = (EditText) findViewById(R.id.editNameText);
        if(!mEditText.getText().toString().isEmpty()) {
            Log.d(TAG, mEditText.getText().toString());
            nextPersonsName = mEditText.getText().toString();
            getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.activity_list)).commit();
            populateRecyclerView();
            Log.d(TAG, String.valueOf(tempList.size()));
        }
    }

    public void populateRecyclerView (){
        ListItem myItem = new ListItem();
        myItem.setTitle(nextPersonsName);
        myItem.setImageResId(icons[1]);
//        tempList.add(myItem);
        adapter.addItem(myItem);
    }

}
