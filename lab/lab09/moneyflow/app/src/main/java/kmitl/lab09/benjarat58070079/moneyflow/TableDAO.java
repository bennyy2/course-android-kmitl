package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Benny on 8/11/2560.
 */
@Dao
interface TableDAO {

    @Query("SELECT * FROM DatabaseInfo")
    List<DatabaseInfo> getAll();

    @Insert
    void insert(DatabaseInfo databaseInfo);

    @Delete
    void delete(DatabaseInfo databaseInfo);

    @Update
    void update(DatabaseInfo databaseInfo);


}
