package android.taobao.windvane.config;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVCommonConfig {
    private static WVCommonConfig instance;

    public static WVCommonConfig getInstance() {
        if (instance == null) {
            synchronized (WVCommonConfig.class) {
                if (instance == null) {
                    instance = new WVCommonConfig();
                }
            }
        }
        return instance;
    }

    public void init() {
    }
}
