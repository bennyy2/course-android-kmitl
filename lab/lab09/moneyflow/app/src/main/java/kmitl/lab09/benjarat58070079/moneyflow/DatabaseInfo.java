package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Benny on 8/11/2560.
 */
@Entity
public class DatabaseInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "amount")
    public int amount;

public String toString(){
    return String.format("%s :: %s :: %s",type, name, amount);
}


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
