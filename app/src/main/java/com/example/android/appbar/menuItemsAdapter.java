package com.example.android.appbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alesiarazumova on 11/14/15.
 */


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

public class menuItemsAdapter extends RecyclerView.Adapter<menuItemsAdapter.ViewHolder> {
    private ItemData[] itemsData;

    public menuItemsAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public menuItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtView1.setText(itemsData[position].getTitle());
        viewHolder.txtView2.setText(itemsData[position].getPrice());


    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtView1;
        public TextView txtView2;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtView1 = (TextView) itemLayoutView.findViewById(R.id.menu_item);
            txtView2 = (TextView) itemLayoutView.findViewById(R.id.menu_item_price);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}
