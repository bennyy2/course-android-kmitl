package kmitl.lab09.benjarat58070079.demodatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by student on 11/3/2017 AD.
 */
@Dao
public interface MessageInfoDAO {

    @Query("SELECT * FROM MessageInfo")
    List<MessageInfo> getAll();

    @Insert
    void insert(MessageInfo messageInfo);
}
