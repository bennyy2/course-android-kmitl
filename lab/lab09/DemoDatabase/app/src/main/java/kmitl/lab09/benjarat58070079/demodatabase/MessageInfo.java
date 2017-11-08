package kmitl.lab09.benjarat58070079.demodatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by student on 11/3/2017 AD.
 */
@Entity
class MessageInfo {


    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "text")
    private String text;
    @ColumnInfo(name = "time")
    private String time;


    public String toString(){
        return String.format("%s :: %s", text, time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
