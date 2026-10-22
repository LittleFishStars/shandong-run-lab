package com.kc.aw;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l5 {
    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    public static _hy _a(_h _hVar, int i, int i2) {
        double d;
        double d2;
        double d3;
        boolean z;
        if (_hVar == null) {
            return null;
        }
        _hy _hyVar = new _hy();
        int i_n = _hVar._n();
        int i_g = _hVar._g();
        double d4 = i2;
        double d5 = i;
        double d6 = d4 / d5;
        Map<String, String> map = _hVar._G;
        if (map != null) {
            String str = map.get("blurThreshold");
            if (TextUtil.isEmpty(str)) {
                d = 0.3d;
            } else {
                try {
                    d = Double.parseDouble(str);
                } catch (Exception unused) {
                    d = 0.3d;
                }
            }
        } else {
            d = 0.3d;
        }
        if (d6 > 1.0d) {
            double d7 = ((double) i_g) / ((double) i_n);
            double d8 = d6 - d7;
            if (d8 > d) {
                d2 = d5 * d7;
                i2 = (int) d2;
                z = true;
            } else if (d8 < (-d)) {
                d3 = d4 / d7;
                i = (int) d3;
                z = true;
            } else {
                i = -1;
                z = false;
                i2 = -1;
            }
        } else {
            double d9 = ((double) i_n) / ((double) i_g);
            double d10 = (d5 / d4) - d9;
            if (d10 > d) {
                d3 = d4 * d9;
                i = (int) d3;
                z = true;
            } else if (d10 < (-d)) {
                d2 = d5 / d9;
                i2 = (int) d2;
                z = true;
            } else {
                i = -1;
                z = false;
                i2 = -1;
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        _hyVar._b = z;
        _hyVar._a = layoutParams;
        return _hyVar;
    }

    public static boolean _a(View view) {
        Rect rect = new Rect();
        if (view != null && view.getGlobalVisibleRect(rect)) {
            int width = view.getWidth();
            if (rect.height() * rect.width() > view.getHeight() * width * 0.1f) {
                return true;
            }
        }
        return false;
    }
}
