package win.regin.common.database;

import android.app.Application;
import androidx.room.Room;

/**
 * @author :Reginer in  19-6-19 下午4:54.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
public class DaoManager {
    private static AppDatabase sDatabase;

    public static void init(Application application) {
        sDatabase = Room.databaseBuilder(application, AppDatabase.class, "mvvm").build();
    }

    private static class DaoManagerHolder {
        private static final DaoManager INSTANCE = new DaoManager();
    }

    public static DaoManager getInstance() {
        return DaoManager.DaoManagerHolder.INSTANCE;
    }

    public AppDatabase getDao() {
        return sDatabase;
    }

    public DaoOptions getDaoOptions() {
        return new DaoOptions();
    }
}
