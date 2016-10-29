package shawn.c4q.nyc.derplist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import shawn.c4q.nyc.derplist.R;
import shawn.c4q.nyc.derplist.model.ListItem;

/**
 * Created by shawnspeaks on 10/20/16.
 */

public class DerpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
 //put generic in viewholder
    private List<ListItem> listData;
    private LayoutInflater inflater;
    private int headerView = 0;




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
    public int getItemViewType(int position) {
        if(position == 0) {
            return headerView;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == headerView){
            View view = inflater.inflate(R.layout.listitem, parent, false);
            return new DerpHolder(view);
        }else{
            View view = inflater.inflate(R.layout.fooditemview, parent, false);
            return new DerpHolder2(view);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DerpHolder){
            ListItem item = listData.get(position);
            ((DerpHolder) holder).title.setText(item.getTitle());
            ((DerpHolder) holder).icon.setImageResource(item.getImageResId());
        }else{

            ((DerpHolder2) holder).mFood.setText(R.string.add);

        }
    }


//    @Override
//    public void onBindViewHolder(DerpHolder holder, int position) {
//        ListItem item = listData.get(position);
//        holder.title.setText(item.getTitle());
//        holder.icon.setImageResource(item.getImageResId());
//    }

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

    class DerpHolder2 extends RecyclerView.ViewHolder {
        private EditText mFood;
        private EditText mQuantity;
        private EditText mPrice;
        private View container;

        public DerpHolder2(View itemView) {
            super(itemView);
            mFood = (EditText) itemView.findViewById(R.id.food_edit_text);
            mQuantity = (EditText) itemView.findViewById(R.id.qty_edit_text);
            mPrice = (EditText) itemView.findViewById(R.id.price_edit_text);
            container = itemView.findViewById(R.id.linear_recView_container);
        }
    }

}
