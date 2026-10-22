package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class UtilsTransActivity4MainProcess extends UtilsTransActivity {
    public static void S(Activity activity, Utils.Consumer<Intent> consumer, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.start(activity, consumer, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void T(Activity activity, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.start(activity, null, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void U(Utils.Consumer<Intent> consumer, UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.start(null, consumer, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }

    public static void V(UtilsTransActivity.TransActivityDelegate transActivityDelegate) {
        UtilsTransActivity.start(null, null, transActivityDelegate, UtilsTransActivity4MainProcess.class);
    }
}
