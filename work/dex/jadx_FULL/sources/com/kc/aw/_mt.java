package com.kc.aw;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mt extends _aj {
    public FrameLayout _f;
    public ImageView _g;
    public LinearLayout _h;
    public PtgShakeView _i;
    public TextView _j;
    public boolean _k;

    public _mt(Context context) {
        super(context);
        this._k = false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    public static FrameLayout.LayoutParams _a(_mt _mtVar, _h _hVar) {
        int width = _mtVar.getWidth();
        int height = _mtVar.getHeight();
        int i_n = _hVar._n();
        int i_g = _hVar._g();
        double d = height;
        double d2 = width;
        double d3 = d / d2;
        if (d3 > 1.0d) {
            double d4 = ((double) i_g) / ((double) i_n);
            if (d3 - d4 > 0.8d) {
                height = (int) (d2 * d4);
                _mtVar._k = true;
            } else {
                _mtVar._k = false;
                width = -1;
                height = -1;
            }
        } else {
            double d5 = ((double) i_n) / ((double) i_g);
            if ((d2 / d) - d5 > 0.8d) {
                width = (int) (d * d5);
                _mtVar._k = true;
            } else {
                _mtVar._k = false;
                width = -1;
                height = -1;
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.kc.aw._aj
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_splash_image_layout, (ViewGroup) null);
        this._a = viewInflate;
        this._f = (FrameLayout) viewInflate.findViewById(R.id.ptgAdvertLayout);
        this._g = (ImageView) this._a.findViewById(R.id.ptgSplashIv);
        this._j = (TextView) this._a.findViewById(R.id.ptgSplashHotArea);
        this._h = (LinearLayout) this._a.findViewById(R.id.ptgSplashShakeLayout);
        this._i = (PtgShakeView) this._a.findViewById(R.id.ptgSplashShakeIv);
        _df._a(this._j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this._a, layoutParams);
        setGravity(17);
    }

    @Override // com.kc.aw._aj
    public final void _c() {
        super._c();
        PtgShakeView ptgShakeView = this._i;
        if (ptgShakeView != null) {
            ImageView imageView = ptgShakeView._a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            _lz _lzVar = ptgShakeView._d;
            if (_lzVar != null) {
                _lzVar.cancel();
                ptgShakeView._d = null;
            }
        }
    }

    @Override // com.kc.aw._aj
    public void setAd(_h _hVar) {
        String str;
        Handler handler;
        _d3._c _cVar;
        if (PtgAdSdk.getConfig()._b()) {
            str = _hVar._f() != null ? _hVar._f()._a : "";
            System.currentTimeMillis();
            _ms _msVar = new _ms(this, _hVar);
            AtomicBoolean atomicBoolean = _ez._a;
            if (TextUtil.isEmpty(str)) {
                return;
            }
            com.kc.aw.lib.utils._d._b(new _f1(str, _msVar));
            return;
        }
        str = _hVar._f() != null ? _hVar._f()._a : "";
        try {
            _d3 _d3Var = new _d3(_bq._a(getContext()), new _mr(this, _hVar));
            _d3Var._i = 3000;
            _d3Var._h = true;
            _d3Var.executeOnExecutor(_d3Var._f, str);
            int i = _d3Var._i;
            if (i <= 0 || (handler = _d3Var._a) == null || (_cVar = _d3Var._l) == null) {
                return;
            }
            handler.postDelayed(_cVar, i);
        } catch (Exception e) {
            _t _tVar = this._c;
            if (_tVar != null) {
                _tVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }
}
