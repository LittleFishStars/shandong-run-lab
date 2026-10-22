package cn.hzjizhun.admin.base.ad;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ErrorCallback {
    void errorReport(String str);

    default void reportWithProbability(String str) {
        try {
            if (new Random().nextInt(10000) == 1000) {
                errorReport(str);
            }
        } catch (Throwable unused) {
        }
    }
}
