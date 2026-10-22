package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
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
public final class _af extends _am {
    public TextView _s;
    public TextView _t;
    public ImageView _u;

    @Keep
    public final class _a implements _d3._d {
        public final _af _a;

        public _a(_af _afVar) {
            this._a = _afVar;
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
            _af _afVar = this._a;
            _t _tVar = _afVar._a;
            if (_tVar != null) {
                _tVar._a(_afVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    public _af(Context context) {
        super(context);
    }

    @Override // com.kc.aw._am
    public final void _a(int i) {
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setLayoutParams(new LinearLayout.LayoutParams(i - ScreenUtils.dp2px(20.0f), -2));
        }
    }

    @Override // com.kc.aw._al
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_banner_view_top_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._t = (TextView) viewInflate.findViewById(R.id.ptgTvSource);
        this._u = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        _o6._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.kc.aw._al
    public void setAd(_h _hVar) {
        try {
            setVisibility(8);
            _am._a(_hVar, this._s, true);
            TextView textView = this._t;
            if (_hVar != null && textView != null) {
                _i6 _i6Var = _hVar._z;
                if (TextUtils.isEmpty(_i6Var != null ? _i6Var._d : "")) {
                    textView.setVisibility(8);
                } else {
                    _i6 _i6Var2 = _hVar._z;
                    textView.setText(_i6Var2 != null ? _i6Var2._d : "");
                    textView.setVisibility(0);
                }
            }
            _a(_hVar, 0, this._u, this._f, new _a(this));
        } catch (Exception e) {
            _t _tVar = this._a;
            if (_tVar != null) {
                _tVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }
}
