package ie.rmxsantiago.celluloid;

import android.app.Application;
import android.os.StrictMode;

public class CelluloidApplication extends Application {
    private static final String TAG = "CelluloidApplication";
    private static final boolean DEVELOPER_MODE = true;

    @Override
    public void onCreate() {
        super.onCreate();

        settingStrictMode();
    }

    private void settingStrictMode() {
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}
