package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gx extends _am {
    public TextView _s;
    public ImageView _t;
    public ImageView _u;
    public ImageView _v;

    @Keep
    public final class _a implements _d3._d {
        public final _gx _a;

        public _a(_gx _gxVar) {
            this._a = _gxVar;
        }

        @Override // com.kc.aw._d3._g
        public final void _a(Bitmap bitmap) {
            this._a.setVisibility(0);
            _t _tVar = this._a._a;
            if (_tVar != null) {
                _tVar._a();
            }
        }

        @Override // com.kc.aw._d3._d
        public final void _a(Exception exc) {
            _gx _gxVar = this._a;
            _t _tVar = _gxVar._a;
            if (_tVar != null) {
                _tVar._a(_gxVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    public _gx(Context context) {
        super(context);
    }

    @Override // com.kc.aw._am
    public final void _a(int i) {
        if (this._f == null || this._g == null || this._h == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((i - ScreenUtils.dp2px(30.0f)) / 3, -2);
        this._f.setLayoutParams(layoutParams);
        this._g.setLayoutParams(layoutParams);
        this._h.setLayoutParams(layoutParams);
    }

    @Override // com.kc.aw._al
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_native_view_three_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout1);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        AdvertRatioLayout advertRatioLayout2 = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout2);
        this._g = advertRatioLayout2;
        advertRatioLayout2.setRatio(this._m);
        AdvertRatioLayout advertRatioLayout3 = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout3);
        this._h = advertRatioLayout3;
        advertRatioLayout3.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._t = (ImageView) viewInflate.findViewById(R.id.ptgImgCover1);
        this._u = (ImageView) viewInflate.findViewById(R.id.ptgImgCover2);
        this._v = (ImageView) viewInflate.findViewById(R.id.ptgImgCover3);
        _o6._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.kc.aw._al
    public void setAd(_h _hVar) {
        try {
            setVisibility(8);
            _am._a(_hVar, this._s, true);
            _a(_hVar, 0, this._t, this._f, new _a(this));
            _a(_hVar, 1, this._u, this._g, null);
            _a(_hVar, 2, this._v, this._h, null);
        } catch (Exception e) {
            _t _tVar = this._a;
            if (_tVar != null) {
                _tVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }
}
