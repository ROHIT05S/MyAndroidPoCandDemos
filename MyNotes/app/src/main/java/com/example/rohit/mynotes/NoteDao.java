package com.example.rohit.mynotes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.provider.SyncStateContract;

import java.util.List;

/**
 * Created by Rohit on 01-04-2018.
 */
@Dao
public interface NoteDao
{
    @Query("SELECT * FROM user "+ Constants.TABLE_NAME_NOTE)
    List<Note> getAll();
   @Insert
   long insertNote(Note note);
   /* * update the object in database *
    @param note, object to be updated */
   @Update
   void update(Note repos);
   /* * delete the object from database *
   @param note, object to be deleted */
   @Delete
   void delete(Note note);
   /* * delete list of objects from database *
   @param note, array of objects to be deleted */
   @Delete
   void delete(Note... note); // Note... is varargs, here note is an array

}
