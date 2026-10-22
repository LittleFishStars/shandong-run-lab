package com.kc.aw;

import android.view.View;
import com.kc.openset.advertisers.hl.HLADNID;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _m1 {
    public static _m2 _a;

    @Keep
    public final class _a implements Runnable {
        public final _nl _a;
        public final View _b;

        public _a(_nl _nlVar, View view) {
            this._a = _nlVar;
            this._b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            _m2 _m2Var;
            _nl _nlVar = this._a;
            if (_nlVar == null || (view = this._b) == null || (_m2Var = _m1._a) == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 && height == 0) {
                width = view.getMeasuredWidth();
                height = view.getMeasuredHeight();
            }
            int[] iArr = {width, height};
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int i = iArr2[0];
            int i2 = iArr2[1];
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = (i3 / 4) + i;
            int i6 = (i4 / 4) + i2;
            int iNextInt = _m2Var._a.nextInt(((((i3 * 3) / 4) + i) - i5) + 1) + i5;
            int iNextInt2 = _m2Var._a.nextInt(((((i4 * 3) / 4) + i2) - i6) + 1) + i6;
            if (iNextInt <= 0 || iNextInt2 <= 0) {
                return;
            }
            _nlVar._i = iNextInt;
            _nlVar._j = iNextInt2;
            _nlVar._g = iNextInt;
            _nlVar._h = iNextInt2;
        }
    }

    public static void _a(View view, View view2, View view3) {
        _m2 _m2Var = _a;
        if (_m2Var != null) {
            _m2Var._a(view, view2, view3);
        }
    }

    public static void _a(View view, _h _hVar) {
        if (_a == null || view == null || _hVar == null) {
            return;
        }
        _dj._a(_hVar);
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 && height == 0) {
                view.measure(0, 0);
                width = view.getMeasuredWidth();
                height = view.getMeasuredHeight();
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            HashMap map = new HashMap();
            map.put("__HW_W__", String.valueOf(width));
            map.put("__HW_H__", String.valueOf(height));
            map.put("__HW_SLOT_SCREEN_X__", String.valueOf(i));
            map.put("__HW_SLOT_SCREEN_Y__", String.valueOf(i2));
            map.put("__HW_SHOW_TIME__", HLADNID.Reason.OTHER);
            map.put("__HW_MAX_SHOW_RATIO__", "100");
            map.put("__HW_EVENT_TIME__", String.valueOf(System.currentTimeMillis()));
            map.putAll(_k._a(_hVar._q));
            if (_hVar._s == null) {
                _hVar._s = new _ks();
            }
            _hVar._s._a = map;
        } catch (Exception unused) {
        }
    }

    public static void _a(_nl _nlVar, View view) {
        if (view != null) {
            try {
                view.post(new _a(_nlVar, view));
            } catch (Exception unused) {
            }
        }
    }
}
