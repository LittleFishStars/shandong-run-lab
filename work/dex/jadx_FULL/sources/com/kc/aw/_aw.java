package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kc.aw.lib.utils.ot.LruDiskUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _aw {
    public static void _a(Context context, Bitmap bitmap, FrameLayout frameLayout) {
        Bitmap bitmap_a;
        if (context == null || bitmap == null || frameLayout == null) {
            return;
        }
        try {
            bitmap_a = _a9._a(bitmap);
        } catch (Exception unused) {
            bitmap_a = null;
        }
        if (bitmap_a != null) {
            frameLayout.setBackground(new BitmapDrawable(context.getResources(), bitmap_a));
        } else {
            frameLayout.setBackgroundColor(-16777216);
        }
    }

    public static void _a(Context context, String str, FrameLayout frameLayout) throws Throwable {
        if (context == null || TextUtils.isEmpty(str) || frameLayout == null) {
            return;
        }
        Bitmap asBitmap = LruDiskUtils.get(context).getAsBitmap(com.kc.aw.lib.utils._a._c(str) + "_blur");
        if (asBitmap != null) {
            frameLayout.setBackground(new BitmapDrawable(context.getResources(), asBitmap));
        } else {
            frameLayout.setBackgroundColor(-16777216);
        }
    }
}
