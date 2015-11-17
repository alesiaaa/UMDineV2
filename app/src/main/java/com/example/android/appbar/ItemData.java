package com.example.android.appbar;

/**
 * Created by alesiarazumova on 11/14/15.
 */


public class ItemData {


        private String title;
        private String price;

        public ItemData(String title,String price){

            this.title = title;
            this.price = price;
        }

        // getters & setters

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPrice() {
            return price;
    }



    }