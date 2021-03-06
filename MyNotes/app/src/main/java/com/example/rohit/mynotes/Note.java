package com.example.rohit.mynotes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Rohit on 01-04-2018.
 */
@Entity
public class Note implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int note_id;
    @ColumnInfo(name = "note_content") // column name will be "note_content" instead of "content" in table private String content; private String title; private public Note(int note_id, String content, String title) { this.note_id = note_id; this.content = content; this.title = title; } public int getNote_id() { return note_id; } public void setNote_id(int note_id) { this.note_id = note_id; } public String getContent() { return content; } public void setContent(String content) { this.content = content; } public String getTitle() { return title; } public void setTitle(String title) { this.title = title; } @Override public boolean equals(Object o) { if (this == o) return true; if (!(o instanceof Note)) return false; Note note = (Note) o; if (note_id != note.note_id) return false; return title != null ? title.equals(note.title) : note.title == null; } @Override public int hashCode() { int result = note_id; result = 31 * result + (title != null ? title.hashCode() : 0); return result; } @Override public String toString() { return "Note{" + "note_id=" + note_id + ", content='" + content + '\'' + ", title='" + title + '\'' + '}'; }
    private String content;
    private String title;
   // private
    public Note(String content, String title)
    {

        this.content = content;
        this.title = title;
    }


    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Note))
            return false;
        Note note = (Note) o;
        if (note_id != note.note_id)
            return false;
        return title != null ? title.equals(note.title) : note.title == null;
    }
    @Override
    public int hashCode()
    {
        int result = note_id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
    @Override
    public String toString()
    {
        return "Note{" + "note_id=" + note_id + ", content='" + content + '\'' + ", title='" + title + '\'' + '}';
    }


}
