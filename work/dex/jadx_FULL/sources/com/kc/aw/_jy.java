package com.kc.aw;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jy implements Runnable {
    public final int _a;
    public final int _b;
    public final PtgShakeView _c;

    public _jy(PtgShakeView ptgShakeView, int i, int i2) {
        this._c = ptgShakeView;
        this._a = i;
        this._b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        PtgShakeView ptgShakeView = this._c;
        if (ptgShakeView._a == null || ptgShakeView._b == null) {
            return;
        }
        int i = 0;
        int iDp2px = ScreenUtils.dp2px(ptgShakeView._e[0]);
        int iDp2px2 = ScreenUtils.dp2px(this._c._e[1]);
        PtgShakeView ptgShakeView2 = this._c;
        int i2 = this._a;
        int i3 = this._b;
        int iDp2px3 = ScreenUtils.dp2px(ptgShakeView2._f[0]);
        int iDp2px4 = ScreenUtils.dp2px(ptgShakeView2._f[1]);
        int iMax = Math.max(iDp2px, Math.min(iDp2px2, (int) (Math.min(i2, i3) * 0.38f)));
        ptgShakeView2._c = iMax;
        float f = iDp2px;
        float f2 = iDp2px3;
        float f3 = iDp2px2 - f;
        int i4 = (int) ((((iDp2px4 - f2) * (iMax - f)) / f3) + f2);
        ptgShakeView2._a.setLayoutParams(new LinearLayout.LayoutParams(iMax, iMax));
        ptgShakeView2._a.setPadding(i4, i4, i4, i4);
        PtgShakeView ptgShakeView3 = this._c;
        int iDp2px5 = ScreenUtils.dp2px(ptgShakeView3._g[0]);
        int iDp2px6 = ScreenUtils.dp2px(ptgShakeView3._g[1]);
        int iDp2px7 = ScreenUtils.dp2px(ptgShakeView3._h[0]);
        int iDp2px8 = ScreenUtils.dp2px(ptgShakeView3._h[1]);
        float f4 = iDp2px5;
        float f5 = (((iDp2px6 - f4) * (ptgShakeView3._c - f)) / f3) + f4;
        if (f5 > f4) {
            ptgShakeView3._b.setTextSize(1, ScreenUtils.px2dp(f5));
            float f6 = iDp2px7;
            ptgShakeView3._b.setPadding(0, (int) ((((iDp2px8 - f6) * (ptgShakeView3._c - f)) / f3) + f6), 0, 0);
            textView = ptgShakeView3._b;
        } else {
            textView = ptgShakeView3._b;
            i = 8;
        }
        textView.setVisibility(i);
        PtgShakeView ptgShakeView4 = this._c;
        _lz _lzVar = ptgShakeView4._d;
        if (_lzVar != null) {
            _lzVar.cancel();
            ptgShakeView4._d = null;
        }
        float f7 = ptgShakeView4._c / 2.0f;
        _lz _lzVar2 = new _lz(f7, f7);
        ptgShakeView4._d = _lzVar2;
        _lzVar2.setDuration(800L);
        ptgShakeView4._d.setRepeatMode(2);
        ptgShakeView4._d.setRepeatCount(-1);
        PtgShakeView ptgShakeView5 = this._c;
        ImageView imageView = ptgShakeView5._a;
        if (imageView == null || ptgShakeView5._d == null) {
            return;
        }
        imageView.clearAnimation();
        ptgShakeView5._a.startAnimation(ptgShakeView5._d);
    }
}
