package kmitl.lab09.benjarat58070079.moneyflow;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Benny on 8/11/2560.
 */
@Database(entities = {DatabaseInfo.class}, version = 1)
public abstract class DatabaseTable extends RoomDatabase{

    public abstract TableDAO getTableDAO();


}
