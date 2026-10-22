package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mu extends _aj {
    public PtgVideoView _f;
    public LinearLayout _g;
    public PtgShakeView _h;
    public TextView _i;

    @Keep
    public final class _a implements _d3._d {
        public boolean _a;
        public final _h _b;
        public final _mu _c;

        public _a(_mu _muVar, _h _hVar) {
            this._c = _muVar;
            this._b = _hVar;
        }

        @Override // com.kc.aw._d3._g
        public final void _a(Bitmap bitmap) {
            _t _tVar = this._c._c;
            if (_tVar != null) {
                _tVar._a();
            }
            Context context = this._c.getContext();
            _mu _muVar = this._c;
            _b2._a(context, _muVar, this._b, _muVar._f, _muVar._i, _muVar._g, _muVar._b);
        }

        @Override // com.kc.aw._d3._d
        public final void _a(Exception exc) {
            _mu _muVar = this._c;
            _t _tVar = _muVar._c;
            if (_tVar == null || this._a) {
                return;
            }
            this._a = true;
            _tVar._a(_muVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
        }
    }

    public _mu(Context context) {
        super(context);
    }

    @Override // com.kc.aw._aj
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.aw_splash_video_view, (ViewGroup) null);
        this._a = viewInflate;
        PtgVideoView ptgVideoView = (PtgVideoView) viewInflate.findViewById(R.id.ptgVideoView);
        this._f = ptgVideoView;
        ptgVideoView.setShowPlayButton(false);
        this._f.setSoundMarginTop(ScreenUtils.dp2px(30.0f));
        this._i = (TextView) this._a.findViewById(R.id.ptgSplashHotArea);
        this._g = (LinearLayout) this._a.findViewById(R.id.ptgSplashShakeLayout);
        this._h = (PtgShakeView) this._a.findViewById(R.id.ptgSplashShakeIv);
        _df._a(this._i);
        addView(this._a, -1, -1);
    }

    @Override // com.kc.aw._aj
    public final void _c() {
        super._c();
        PtgShakeView ptgShakeView = this._h;
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
        PtgVideoView ptgVideoView = this._f;
        if (ptgVideoView != null) {
            ptgVideoView._b();
            this._f = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PtgVideoView ptgVideoView = this._f;
        if (ptgVideoView != null) {
            ptgVideoView._b();
            this._f = null;
        }
    }

    @Override // com.kc.aw._aj
    public void setAd(_h _hVar) {
        Exception exc;
        _a _aVar = new _a(this, _hVar);
        if (_hVar == null || this._f == null) {
            exc = new Exception("广告数据异常");
        } else {
            if (_hVar._s()) {
                this._f._a(_hVar, 0.0f, new _mv());
                this._f.setOnErrorListener(new _mw());
                this._f.setOnCompletionListener(new _mx());
                this._f.setVideoStateListener(new _my());
                this._f._a(_aVar);
                return;
            }
            exc = new Exception("广告类型异常");
        }
        _aVar._a(exc);
    }
}
