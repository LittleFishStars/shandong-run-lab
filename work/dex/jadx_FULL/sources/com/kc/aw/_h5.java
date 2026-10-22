package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h5 {
    public static AppCompatActivity _a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return _a(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static Activity _b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return _b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void _c(Context context) {
        ActionBar supportActionBar;
        if (_a(context) != null && (supportActionBar = _a(context).getSupportActionBar()) != null) {
            supportActionBar.show();
        }
        if (_b(context) != null) {
            _b(context).getWindow().clearFlags(1024);
        }
    }
}
