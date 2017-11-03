package kmitl.lab09.benjarat58070079.demodatabase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by student on 11/3/2017 AD.
 */

@Database(entities = {MessageInfo.class}, version = 1)
public abstract class MessageDB extends RoomDatabase{


    public abstract MessageInfoDAO getmessageInfoDAO();


    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
