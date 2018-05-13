package com.example.rohit.demowithrealmdatabase.adapter;

import android.content.Context;

import com.example.rohit.demowithrealmdatabase.model.Book;

import io.realm.RealmResults;

/**
 * Created by Rohit on 23-09-2017.
 */

public class RealmBooksAdapter extends RealmModelAdapter<Book> {

    public RealmBooksAdapter(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {

        super(context, realmResults, automaticUpdate);
    }
}
