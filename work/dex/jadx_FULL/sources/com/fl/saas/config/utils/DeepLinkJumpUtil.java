package com.fl.saas.config.utils;

import android.app.Activity;
import com.fl.saas.common.listener.DeepLinkOpenListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DeepLinkJumpUtil {
    public static final int DEEPLINK_OPEN_REQUEST = 10001;
    private DeepLinkOpenListener deepLinkOpenListener;

    public static class Holder {
        private static final DeepLinkJumpUtil INSTANCE = new DeepLinkJumpUtil();

        private Holder() {
        }
    }

    private DeepLinkJumpUtil() {
    }

    public static DeepLinkJumpUtil getInstance() {
        return Holder.INSTANCE;
    }

    public void removeDeepLinkOpenListener() {
        this.deepLinkOpenListener = null;
    }

    public void reportActivityResult(int i, int i2, Activity activity) {
        DeepLinkOpenListener deepLinkOpenListener;
        if (i == 10001 && i2 == 0 && (deepLinkOpenListener = this.deepLinkOpenListener) != null) {
            deepLinkOpenListener.onDeepLinkOpenFailed(activity);
            this.deepLinkOpenListener = null;
        }
    }

    public void setDeepLinkOpenListener(DeepLinkOpenListener deepLinkOpenListener) {
        this.deepLinkOpenListener = deepLinkOpenListener;
    }
}
