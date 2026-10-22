package com.alibaba.triver.kit.api.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.StringRes;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverToastUtils {
    private static final String TAG = "TriverToastUtils";
    private static Toast sToast;

    public static void cancelToast() {
        Toast toast = sToast;
        if (toast != null) {
            toast.cancel();
            sToast = null;
        }
    }

    public static void showLongToast(Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence) || context == null) {
            return;
        }
        Toast toast = sToast;
        if (toast == null) {
            sToast = Toast.makeText(context.getApplicationContext(), charSequence, 0);
        } else {
            toast.setText(charSequence);
        }
        sToast.setDuration(1);
        sToast.show();
    }

    public static void showToast(Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence) || context == null) {
            return;
        }
        Toast toast = sToast;
        if (toast == null) {
            sToast = Toast.makeText(context.getApplicationContext(), charSequence, 0);
        } else {
            toast.setText(charSequence);
        }
        sToast.setDuration(0);
        sToast.show();
    }

    public static void showLongToast(Context context, @StringRes int i) {
        if (context == null || context.getResources() == null) {
            return;
        }
        try {
            String string = context.getResources().getString(i);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Toast toast = sToast;
            if (toast == null) {
                sToast = Toast.makeText(context.getApplicationContext(), string, 0);
            } else {
                toast.setText(string);
            }
            sToast.setDuration(1);
            sToast.show();
        } catch (Exception e) {
            RVLogger.w(TAG, e.getMessage());
        }
    }

    public static void showToast(Context context, @StringRes int i) {
        if (context == null || context.getResources() == null) {
            return;
        }
        try {
            String string = context.getResources().getString(i);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Toast toast = sToast;
            if (toast == null) {
                sToast = Toast.makeText(context.getApplicationContext(), string, 0);
            } else {
                toast.setText(string);
            }
            sToast.setDuration(0);
            sToast.show();
        } catch (Exception e) {
            RVLogger.w(TAG, e.getMessage());
        }
    }
}
