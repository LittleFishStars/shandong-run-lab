package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.model.AdSlot;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ab extends _am {
    public ImageView _s;

    @Keep
    public final class _a implements _d3._d {
        public final _ab _a;

        public _a(_ab _abVar) {
            this._a = _abVar;
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
            _ab _abVar = this._a;
            _t _tVar = _abVar._a;
            if (_tVar != null) {
                _tVar._a(_abVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    public _ab(Context context) {
        super(context);
    }

    @Override // com.kc.aw._al
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_banner_view_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        _o6._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.kc.aw._al
    public void setAd(_h _hVar) {
        try {
            setVisibility(8);
            AdSlot adSlot = this._b;
            if (adSlot != null) {
                setAdvertColor(adSlot.getExpressViewColor());
            }
            _a(_hVar, 0, this._s, this._f, new _a(this));
        } catch (Exception e) {
            _t _tVar = this._a;
            if (_tVar != null) {
                _tVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }

    public void setAdvertColor(String str) {
        int color;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            color = Color.parseColor(str);
        } catch (Exception unused) {
            color = Color.parseColor("#FFFFFF");
        }
        this._e.setBackgroundColor(color);
    }
}
