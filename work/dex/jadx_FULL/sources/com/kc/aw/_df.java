package com.kc.aw;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _df {
    public static final HashMap _a = new HashMap();

    public static void _a(TextView textView) {
        _dg _dgVar = _dg.PTG_AD_HOT_AREA_BG;
        if (textView != null) {
            Context context = textView.getContext();
            HashMap map = _a;
            Drawable drawable = map.containsKey(_dgVar) ? (Drawable) ((WeakReference) map.get(_dgVar)).get() : null;
            if (drawable == null) {
                _dd _ddVar = (_dd) _de._a.get(_dgVar);
                GradientDrawable gradientDrawable_a = _ddVar != null ? _ddVar._a(context) : null;
                map.put(_dgVar, new WeakReference(gradientDrawable_a));
                drawable = gradientDrawable_a;
            }
            if (drawable != null) {
                textView.setBackground(drawable);
            }
        }
    }
}
