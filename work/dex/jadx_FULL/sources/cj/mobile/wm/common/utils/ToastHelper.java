package cj.mobile.wm.common.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ToastHelper {
    public static final String TAG = dexc.dexa("XN`") + ToastHelper.class.getSimpleName();

    public static void doShowToast(Context context, String str) {
        ThreadUtils.isUIThread(dexc.dexa("UpbtuIfmqfs.epTipxUpbtu"));
        try {
            if (context instanceof Activity) {
                context = context.getApplicationContext();
            }
            Toast.makeText(context, str, 0).show();
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexc.dexa("epTipxUpbtu!") + th);
        }
    }

    public static void showToast(final Context context, final String str) {
        if (context != null) {
            if (ThreadUtils.isUIThread(dexc.dexa("UpbtuIfmqfs.tipxUpbtu"))) {
                doShowToast(context, str);
            } else {
                ThreadUtils.runOnUIThread(new Runnable() { // from class: cj.mobile.wm.common.utils.ToastHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastHelper.doShowToast(context, str);
                    }
                });
            }
        }
    }
}
