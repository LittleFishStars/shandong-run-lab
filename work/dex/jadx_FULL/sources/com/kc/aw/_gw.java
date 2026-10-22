package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gw extends _am {
    public TextView _s;

    @Keep
    public final class _a implements _d3._d {
        public final _gw _a;

        public _a(_gw _gwVar) {
            this._a = _gwVar;
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
            _gw _gwVar = this._a;
            _t _tVar = _gwVar._a;
            if (_tVar != null) {
                _tVar._a(_gwVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    @Keep
    public final class _b implements _d3._d {
        public final _gw _a;

        public _b(_gw _gwVar) {
            this._a = _gwVar;
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
            _gw _gwVar = this._a;
            _t _tVar = _gwVar._a;
            if (_tVar != null) {
                _tVar._a(_gwVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    public _gw(Context context) {
        super(context);
    }

    @Override // com.kc.aw._am
    public final void _a(int i) {
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setLayoutParams(new FrameLayout.LayoutParams(i - ScreenUtils.dp2px(20.0f), -2));
        }
    }

    @Override // com.kc.aw._al
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_native_view_text_float, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._i = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        PtgVideoView ptgVideoView = (PtgVideoView) viewInflate.findViewById(R.id.ptgVideoView);
        this._j = ptgVideoView;
        ptgVideoView.setVideoRatio(this._m);
        this._j.setSoundGravity(85);
        _o6._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.kc.aw._al
    public void setAd(_h _hVar) {
        try {
            setVisibility(8);
            _am._a(_hVar, this._s, false);
            if (_hVar._s()) {
                _a(_hVar, this._m, new _a(this));
            } else {
                _a(_hVar, 0, this._i, this._f, new _b(this));
            }
        } catch (Exception e) {
            _t _tVar = this._a;
            if (_tVar != null) {
                _tVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }
}
