package com.kc.bw.common.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ToastHelper {
    public static final String TAG = dexg.dexa("XN`") + ToastHelper.class.getSimpleName();

    public static void doShowToast(Context context, String str) {
        ThreadUtils.isUIThread(dexg.dexa("UpbtuIfmqfs.epTipxUpbtu"));
        try {
            if (context instanceof Activity) {
                context = context.getApplicationContext();
            }
            Toast.makeText(context, str, 0).show();
        } catch (Throwable th) {
            DebugLog.release_w(TAG, dexg.dexa("epTipxUpbtu!") + th);
        }
    }

    public static void showToast(Context context, String str) {
        if (context != null) {
            if (ThreadUtils.isUIThread(dexg.dexa("UpbtuIfmqfs.tipxUpbtu"))) {
                doShowToast(context, str);
            } else {
                ThreadUtils.runOnUIThread(new Runnable(context, str) { // from class: com.kc.bw.common.utils.ToastHelper.1
                    public final Context val$context;
                    public final String val$msg;

                    {
                        this.val$context = context;
                        this.val$msg = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ToastHelper.doShowToast(this.val$context, this.val$msg);
                    }
                });
            }
        }
    }
}
