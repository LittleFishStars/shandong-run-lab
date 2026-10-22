package com.alibaba.ariver.app.ui.tabbar;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
class TabBarUtils {
    private static final String TAG = "H5TabbarUtils";

    public static void addCheckedState(StateListDrawable stateListDrawable, Drawable drawable) {
        if (stateListDrawable instanceof TabStateListDrawable) {
            ((TabStateListDrawable) stateListDrawable).addCheckedState(drawable);
        } else {
            RVLogger.e(TAG, "tab addCheckedState invalid StateListDrawable");
        }
    }

    public static void addNormalState(StateListDrawable stateListDrawable, Drawable drawable) {
        if (stateListDrawable instanceof TabStateListDrawable) {
            ((TabStateListDrawable) stateListDrawable).addNormalState(drawable);
        } else {
            RVLogger.e(TAG, "tab addCheckedState invalid StateListDrawable");
        }
    }

    public static StateListDrawable generateEmptyTopDrawable() {
        return new TabStateListDrawable();
    }

    public static ColorStateList generateTextColor(int i, int i2) {
        int i3 = i2 | (-16777216);
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[0]}, new int[]{i3, i3, i | (-16777216)});
    }

    public static String getAbsoluteUrl(String str, Bundle bundle) {
        int iIndexOf;
        String string = BundleUtils.getString(bundle, "url");
        String absoluteUrlWithURLLib = !TextUtils.isEmpty(string) ? UrlUtils.getAbsoluteUrlWithURLLib(string, str) : null;
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(absoluteUrlWithURLLib) && !string.startsWith(absoluteUrlWithURLLib)) {
            return absoluteUrlWithURLLib;
        }
        Uri uri = Uri.parse(string);
        if (uri != null) {
            String encodedFragment = uri.getEncodedFragment();
            if (!TextUtils.isEmpty(encodedFragment) && (iIndexOf = encodedFragment.indexOf("?")) != -1) {
                absoluteUrlWithURLLib = absoluteUrlWithURLLib + encodedFragment.substring(iIndexOf);
            }
        }
        RVLogger.d(TAG, "addHashQuery : " + absoluteUrlWithURLLib);
        return absoluteUrlWithURLLib;
    }
}
