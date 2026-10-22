package com.kc.aw;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cd {
    public static boolean _a(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        int screenRealWidth = ScreenUtils.getScreenRealWidth(context);
        int screenRealHeight = ScreenUtils.getScreenRealHeight(context);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        if (screenRealWidth <= 0 || screenRealHeight == 0) {
            screenRealWidth = displayMetrics.widthPixels;
            screenRealHeight = displayMetrics.heightPixels;
        }
        return Math.sqrt(Math.pow((double) (((float) screenRealHeight) / displayMetrics.ydpi), 2.0d) + Math.pow((double) (((float) screenRealWidth) / displayMetrics.xdpi), 2.0d)) >= 7.0d;
    }
}
