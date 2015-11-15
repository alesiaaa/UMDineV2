package com.example.android.appbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


/**
 * Created by alesiarazumova on 11/14/15.
 */
public class recyclerViewActivity extends Activity {

   /* private List<menuItem> item;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.fragment_tab_3);  
        rv=(RecyclerView)findViewById(R.id.recycler_view);  
        LinearLayoutManager llm = new LinearLayoutManager(this); 
        rv.setLayoutManager(llm); 
        rv.setHasFixedSize(true);  
        initializeData(); 
        initializeAdapter(); }


   // This method creates an ArrayList that has three food item objects  

    private void initializeData(){ 
        item = new ArrayList<>(); 
        item.add(new menuItem("Banana", "$2")); //R.drawable.pic 
        item.add(new menuItem("Tyme", "$12")); 
        item.add(new menuItem("Lollipops", "$4"));
         }

    private void initializeAdapter(){ 
        menuItemsAdapter adapter = new menuItemsAdapter(item); 
        rv.setAdapter(adapter);
      }

}
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_3);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menu_item);

        // this is data for recycler view
        ItemData itemsData[] = {
                new ItemData ("Help", "Help"),
                new ItemData("Delete","Help"),
                new ItemData("Cloud","Help"),
                new ItemData("Favorite","Help"),
                new ItemData("Like","Help"),
                new ItemData("Rating","Help")
        };

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        menuItemsAdapter mAdapter = new menuItemsAdapter (itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}

