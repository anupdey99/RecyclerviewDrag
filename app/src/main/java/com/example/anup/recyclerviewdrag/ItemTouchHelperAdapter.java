package com.example.anup.recyclerviewdrag;

/**
 * Created by IT on 16-Oct-17.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
