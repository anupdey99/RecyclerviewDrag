package com.example.anup.recyclerviewdrag;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IT on 16-Oct-17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements ItemTouchHelperAdapter{

    private Context mContext;
    private ArrayList<ItemModel> contentList;
    private static OnItemClickListener itemClickListener;
    private static OnItemLongClickListener itemLongClickListener;
    private int view_type = 0;


    @Override
    public int getItemViewType(int position) {
        if (view_type == 0){
            return R.layout.row_item;
        }else {
            return R.layout.row_item_grid;
        }
    }

    public Adapter(Context mContext, ArrayList<ItemModel> contentList,int view_type) {
        this.mContext = mContext;
        this.contentList = contentList;
        this.view_type = view_type;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition<toPosition){
            for (int i = fromPosition; i< toPosition; i++){
                Collections.swap(contentList,i,i+1);
            }
        }else {
            for (int i = fromPosition; i> toPosition; i--){
                Collections.swap(contentList,i,i-1);
            }
        }
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        contentList.remove(position);
        notifyItemRemoved(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        ImageView logo;
        TextView itemTitle;
        TextView itemDescription;
        RelativeLayout card;

        public MyViewHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.image_view);
            itemTitle = itemView.findViewById(R.id.item_name);
            itemDescription = itemView.findViewById(R.id.item_description);
            card = itemView.findViewById(R.id.card_click);

            card.setOnClickListener(this);
            card.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClicked(v,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            itemLongClickListener.onItemLongClicked(v,getAdapterPosition());
            return true;
        }
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener){

        itemClickListener = onItemClickListener;

    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){

        itemLongClickListener = onItemLongClickListener;
    }

    public void changeView(int type){
        this.view_type = type;
    }


}
