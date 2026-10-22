package com.kc.aw;

import android.view.MotionEvent;
import android.view.View;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _m2 {
    public final Random _a = new Random();

    @Keep
    public final class _a implements View.OnTouchListener {
        public final View _a;

        public _a(View view) {
            this._a = view;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                _m2._a(this._a, view, motionEvent);
                return false;
            }
            if (action != 1) {
                return false;
            }
            _m2._b(this._a, view, motionEvent);
            return false;
        }
    }

    public static void _a(View view, View view2, MotionEvent motionEvent) {
        Object tag = view2.getTag(R.id.aw_native_view_tag);
        if (view == null || !(tag instanceof _nl)) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = (int) (rawX - iArr[0]);
        int i2 = (int) (rawY - iArr[1]);
        _nl _nlVar = (_nl) tag;
        _nlVar._a = i;
        _nlVar._b = i2;
        _nlVar._c = System.currentTimeMillis();
    }

    public static void _b(View view, View view2, MotionEvent motionEvent) {
        Object tag = view2.getTag(R.id.aw_native_view_tag);
        if (view == null || !(tag instanceof _nl)) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = (int) (rawX - iArr[0]);
        int i2 = (int) (rawY - iArr[1]);
        _nl _nlVar = (_nl) tag;
        _nlVar._d = i;
        _nlVar._e = i2;
        _nlVar._f = System.currentTimeMillis();
    }

    public final void _a(View view, View view2, View view3) {
        if (view == null || view2 == null) {
            return;
        }
        view2.setTag(R.id.aw_native_view_tag, new _nl(view3));
        view2.setOnTouchListener(new _a(view));
    }

    public final void _a(View view, _h _hVar, int i) {
        String str;
        String str2;
        String strValueOf;
        String str3;
        Map<String, String> map;
        if (view == null || _hVar == null) {
            return;
        }
        try {
            _ks _ksVar = _hVar._s;
            if (_ksVar == null || (map = _ksVar._a) == null) {
                str = "0";
                str2 = str;
            } else {
                str = map.get("__HW_W__");
                str2 = _hVar._s._a.get("__HW_H__");
            }
            HashMap map2 = new HashMap();
            map2.put("__HW_W__", str);
            map2.put("__HW_H__", str2);
            map2.put("__HW_DENSITY__", String.valueOf(ScreenUtils.getDensity()));
            map2.put("\\$acw\\$", str);
            map2.put("\\$ach\\$", str2);
            Map<String, String> map3 = _hVar._r;
            if (map3 != null) {
                map2.put("iReportM", map3.get("iReportM"));
            }
            _nk _nkVar = _hVar._t;
            if (_nkVar != null) {
                map2.put("__MP_SPEED_ACC__", String.valueOf(_nkVar._d));
                map2.put("__MP_DEGREE__", String.valueOf(_nkVar._e));
            }
            if (i == 1 || i == 5 || i == 7) {
                map2.put("__HW_SLD__", "2");
                map2.put("\\$itm\\$", "2");
                if (_nkVar != null) {
                    map2.put("__MP_X_MAX_ACC__", String.valueOf(_nkVar._a));
                    map2.put("__MP_Y_MAX_ACC__", String.valueOf(_nkVar._b));
                    map2.put("__MP_Z_MAX_ACC__", String.valueOf(_nkVar._c));
                    map2.put("__HW_X_MAX_ACC__", String.valueOf(_nkVar._a));
                    map2.put("__HW_Y_MAX_ACC__", String.valueOf(_nkVar._b));
                    map2.put("__HW_Z_MAX_ACC__", String.valueOf(_nkVar._c));
                    map2.put("\\$xma\\$", String.valueOf(_nkVar._a));
                    map2.put("\\$yma\\$", String.valueOf(_nkVar._b));
                    strValueOf = String.valueOf(_nkVar._c);
                    str3 = "\\$zma\\$";
                    map2.put(str3, strValueOf);
                }
            } else {
                map2.put("__HW_SLD__", "0");
                map2.put("\\$itm\\$", "1");
                Object tag = view.getTag(R.id.aw_native_view_tag);
                if (tag instanceof _nl) {
                    _nl _nlVar = (_nl) tag;
                    int i2 = _nlVar._g;
                    int i3 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                    if (i2 <= 0 && (i2 = _nlVar._a) == 0) {
                        i2 = -999;
                    }
                    map2.put("__HW_DOWN_X__", String.valueOf(i2));
                    int i4 = _nlVar._h;
                    if (i4 <= 0 && (i4 = _nlVar._b) == 0) {
                        i4 = -999;
                    }
                    map2.put("__HW_DOWN_Y__", String.valueOf(i4));
                    map2.put("__HW_DOWN_TIME__", String.valueOf(_nlVar._c));
                    int i5 = _nlVar._i;
                    if (i5 <= 0 && (i5 = _nlVar._d) == 0) {
                        i5 = -999;
                    }
                    map2.put("__HW_UP_X__", String.valueOf(i5));
                    int i6 = _nlVar._j;
                    if (i6 <= 0 && (i6 = _nlVar._e) == 0) {
                        i6 = -999;
                    }
                    map2.put("__HW_UP_Y__", String.valueOf(i6));
                    map2.put("__HW_UP_TIME__", String.valueOf(_nlVar._f));
                    int i7 = _nlVar._g;
                    if (i7 <= 0 && (i7 = _nlVar._a) == 0) {
                        i7 = -999;
                    }
                    map2.put("\\$dx\\$", String.valueOf(i7));
                    int i8 = _nlVar._h;
                    if (i8 <= 0 && (i8 = _nlVar._b) == 0) {
                        i8 = -999;
                    }
                    map2.put("\\$dy\\$", String.valueOf(i8));
                    int i9 = _nlVar._i;
                    if (i9 <= 0 && (i9 = _nlVar._d) == 0) {
                        i9 = -999;
                    }
                    map2.put("\\$ux\\$", String.valueOf(i9));
                    int i10 = _nlVar._j;
                    if (i10 > 0) {
                        i3 = i10;
                    } else {
                        int i11 = _nlVar._e;
                        if (i11 != 0) {
                            i3 = i11;
                        }
                    }
                    strValueOf = String.valueOf(i3);
                    str3 = "\\$uy\\$";
                    map2.put(str3, strValueOf);
                } else {
                    map2.put("__HW_DOWN_X__", "-999");
                    map2.put("__HW_DOWN_Y__", "-999");
                    map2.put("__HW_UP_X__", "-999");
                    map2.put("__HW_UP_Y__", "-999");
                }
            }
            map2.putAll(_k._a(_hVar._q));
            if (_hVar._s == null) {
                _hVar._s = new _ks();
            }
            _hVar._s._b = map2;
        } catch (Exception unused) {
        }
    }
}
