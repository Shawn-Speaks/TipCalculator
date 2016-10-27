package shawn.c4q.nyc.derplist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import shawn.c4q.nyc.derplist.R;
import shawn.c4q.nyc.derplist.model.ListItem;

/**
 * Created by shawnspeaks on 10/20/16.
 */

public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;


    public DerpAdapter(){
        listData = new ArrayList<>();
    }

    public void addItem(ListItem item){
        listData.add(item);
        notifyItemInserted(listData.size()-1);
    }

    public DerpAdapter(List<ListItem> listData, Context context){
        this.inflater = LayoutInflater.from(context);
        this.listData = listData;
    }

    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem, parent, false);
        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder {
        //THIS CLASS DOES NOT NEED TO BE NESTED.
        private TextView title;
        private ImageView icon;
        private View container;


        public DerpHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_text);
            icon = (ImageView) itemView.findViewById(R.id.img_icon);
            container = itemView.findViewById(R.id.cont_item_root);
        }
    }

}
