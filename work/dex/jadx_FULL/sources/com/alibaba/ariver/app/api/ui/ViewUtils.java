package com.alibaba.ariver.app.api.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ViewUtils {
    public static boolean isTransparentTitle(@NonNull Bundle bundle, String str) {
        boolean z = TextUtils.equals(RVStartParams.TRANSPARENT_TITLE_ALWAYS, str) || TextUtils.equals("auto", str);
        if (z) {
            return true;
        }
        if (!TextUtils.equals("custom", str) || !bundle.containsKey(RVParams.LONG_BACKBTN_IMAGE) || !bundle.containsKey(RVParams.LONG_BACKBTN_TEXTCOLOR) || !bundle.containsKey(RVParams.LONG_TITLE_COLOR)) {
            return z;
        }
        String string = BundleUtils.getString(bundle, RVParams.LONG_BACKBTN_IMAGE);
        return ((TextUtils.isEmpty(string) || TextUtils.equals(string, "default")) && BundleUtils.getInt(bundle, RVParams.LONG_BACKBTN_TEXTCOLOR) == -16777216 && BundleUtils.getInt(bundle, RVParams.LONG_TITLE_COLOR) == -16777216) ? false : true;
    }

    public static int specToLayoutParam(int i) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == 1073741824) {
            return View.MeasureSpec.getSize(i);
        }
        return mode == 0 ? -2 : -1;
    }
}
