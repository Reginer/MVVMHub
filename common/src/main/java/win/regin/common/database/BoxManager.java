package win.regin.common.database;

import android.app.Application;
import io.objectbox.BoxStore;

/**
 * @author :Reginer in  19-6-20 下午12:05.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
public class BoxManager {
    private static BoxStore sBoxStore;

    public static void init(Application application) {
        sBoxStore = MyObjectBox.builder().androidContext(application).build();
    }

    private static class BoxManagerHolder {
        private static final BoxManager INSTANCE = new BoxManager();
    }

    public static BoxManager getInstance() {
        return BoxManager.BoxManagerHolder.INSTANCE;
    }

    public BoxStore getDao() {
        return sBoxStore;
    }
}
