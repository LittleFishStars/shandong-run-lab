package com.kc.aw;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.doodle.Doodle;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o6 {
    public static int _a(View view) {
        if (view == null) {
            return 0;
        }
        Object tag = view.getTag(R.id.aw_native_view_tag);
        if (tag instanceof _nl) {
            return ((_nl) tag)._k;
        }
        return 0;
    }

    public static void _a(View view, int i) {
        if (view != null) {
            Object tag = view.getTag(R.id.aw_native_view_tag);
            if (tag instanceof _nl) {
                ((_nl) tag)._k = i;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            int i4 = (width / 4) + i2;
            int i5 = (height / 4) + i3;
            int iNextInt = com.kc.aw.lib.utils._a._a.nextInt(((((width * 3) / 4) + i2) - i4) + 1) + i4;
            int iNextInt2 = com.kc.aw.lib.utils._a._a.nextInt(((((height * 3) / 4) + i3) - i5) + 1) + i5;
            int[] iArr2 = {iNextInt, iNextInt2, iNextInt, iNextInt2};
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            int i6 = iArr2[0];
            int i7 = iArr2[1];
            int i8 = iArr2[2];
            int i9 = iArr2[3];
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis2, 0, i6, i7, 0);
            view.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            long jNextInt = new Random().nextInt(123);
            _fz._a.postDelayed(new _o3(view, jUptimeMillis, jUptimeMillis2 + jNextInt, i8, i9), jNextInt);
        }
    }

    public static void _a(ImageView imageView) {
        _l2 _l2VarLoad;
        int i = R.drawable.aw_api_logo;
        try {
            int iDpToPx = ScreenUtils.dpToPx(PtgAdSdk.getContext(), 9.0f);
            int iDpToPx2 = ScreenUtils.dpToPx(PtgAdSdk.getContext(), 9.0f);
            if (imageView != null) {
                int i2 = PtgAdSdk.getConfig()._c;
                if (i2 != 0) {
                    AtomicBoolean atomicBoolean = _ez._a;
                    if (i2 == 0) {
                        return;
                    }
                    _l2VarLoad = Doodle.load(i2);
                    _l2VarLoad._d = iDpToPx;
                    _l2VarLoad._e = iDpToPx2;
                    _l2VarLoad._h = false;
                    _l2VarLoad._n = new _f0(imageView, i2);
                } else {
                    String str = PtgAdSdk.getConfig()._d;
                    if (!TextUtils.isEmpty(str)) {
                        if (PtgAdSdk.getConfig()._b()) {
                            _ez._a(imageView, str, iDpToPx, iDpToPx2);
                            return;
                        } else {
                            _d3 _d3Var = new _d3(_bq._a(imageView.getContext()), new _o5(imageView));
                            _d3Var.executeOnExecutor(_d3Var._f, str);
                            return;
                        }
                    }
                    if (i == 0) {
                        return;
                    }
                    AtomicBoolean atomicBoolean2 = _ez._a;
                    if (i == 0) {
                        return;
                    }
                    _l2 _l2VarLoad2 = Doodle.load(i);
                    _l2VarLoad2._d = iDpToPx;
                    _l2VarLoad2._e = iDpToPx2;
                    _l2VarLoad2._h = false;
                    _l2VarLoad2._n = new _f0(imageView, i);
                    _l2VarLoad = _l2VarLoad2;
                }
                _l2VarLoad._a(iDpToPx, iDpToPx2);
            }
        } catch (Exception unused) {
        }
    }

    public static void _b(View view) {
        if (view != null) {
            Object tag = view.getTag(R.id.aw_native_view_tag);
            if (tag instanceof _nl) {
                ((_nl) tag)._k = 0;
            }
        }
    }
}
