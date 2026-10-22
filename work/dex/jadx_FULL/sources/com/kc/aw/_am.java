package com.kc.aw;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.doodle.Doodle;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class _am extends _al {
    public _j6 _c;
    public View _d;
    public ViewGroup _e;
    public AdvertRatioLayout _f;
    public AdvertRatioLayout _g;
    public AdvertRatioLayout _h;
    public ImageView _i;
    public PtgVideoView _j;
    public LinearLayout _k;
    public PtgShakeView _l;
    public float _m;
    public _hy _n;
    public _k9._b _o;
    public _kc _p;
    public MediaPlayer.OnCompletionListener _q;
    public NiceVideoPlayer._b _r;

    @Keep
    public final class _a implements AdvertRatioLayout._a {
        public final _am _a;

        public _a(_am _amVar) {
            this._a = _amVar;
        }

        @Override // com.kc.aw.component.base.AdvertRatioLayout._a
        public final void _a(int i, int i2) {
            ImageView imageView;
            PtgShakeView ptgShakeView = this._a._l;
            if (ptgShakeView == null || (imageView = ptgShakeView._a) == null) {
                return;
            }
            imageView.post(new _jy(ptgShakeView, i, i2));
        }
    }

    @Keep
    public final class _b implements View.OnClickListener {
        public final _am _a;

        public _b(_am _amVar) {
            this._a = _amVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _j6 _j6Var = this._a._c;
            if (_j6Var != null) {
                _dp._a _aVar = (_dp._a) _j6Var;
                _h _hVar = _aVar._a._c;
                if (_hVar != null && _hVar._x) {
                    int i_a = _o6._a(view);
                    boolean z = i_a == 6 || i_a == 4;
                    _dp _dpVar = _aVar._a;
                    if (z) {
                        _dpVar._b(view, _o6._a(view), null);
                    } else {
                        _dpVar._a(view, 0, null);
                    }
                }
            }
        }
    }

    @Keep
    public final class _c implements _u {
    }

    @Keep
    public final class _d implements _t {
        public final _am _a;

        public _d(_am _amVar) {
            this._a = _amVar;
        }

        @Override // com.kc.aw._t
        public final void _a() {
            _j6 _j6Var = this._a._c;
            if (_j6Var != null) {
                _dp._a _aVar = (_dp._a) _j6Var;
                _dp _dpVar = _aVar._a;
                if (_dpVar._a != null) {
                    if (!_dpVar._J) {
                        _aVar._a._J = true;
                        _dp _dpVar2 = _aVar._a;
                        _dpVar2._a.onRenderSuccess(_dpVar2);
                    }
                    _aVar._a._f();
                }
            }
        }

        @Override // com.kc.aw._t
        public final void _a(View view, int i, Exception exc) {
            _j6 _j6Var = this._a._c;
            if (_j6Var != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RESOURCE_ERROR, exc.getMessage(), (Object) null);
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = ((_dp._a) _j6Var)._a._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderFail(adErrorImpl);
                }
            }
        }
    }

    @Keep
    public final class _e implements View.OnClickListener {
        public final _am _a;

        public _e(_am _amVar) {
            this._a = _amVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener;
            _am _amVar = this._a;
            PtgVideoView ptgVideoView = _amVar._j;
            if (ptgVideoView != null) {
                ptgVideoView._b();
                _amVar._j.setOnErrorListener(null);
                _amVar._j = null;
            }
            _j6 _j6Var = this._a._c;
            if (_j6Var == null || (adInteractionListener = ((_dp._a) _j6Var)._a._a) == null) {
                return;
            }
            adInteractionListener.onAdDismiss();
        }
    }

    public _am(Context context) {
        super(context);
        this._m = 0.55f;
        _c();
        _d();
    }

    public static void _a(_h _hVar, TextView textView, boolean z) {
        int i;
        if (_hVar == null || textView == null) {
            return;
        }
        if (TextUtils.isEmpty(_hVar._k())) {
            i = z ? 8 : 4;
        } else {
            textView.setText(_hVar._k());
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void _a(int i) {
    }

    public final void _a(_h _hVar, float f, _d3._d _dVar) {
        PtgVideoView ptgVideoView;
        if (_hVar == null || (ptgVideoView = this._j) == null) {
            _dVar._a(new Exception("广告信息为空"));
            return;
        }
        ptgVideoView.setSizeCallback(new _a(this));
        this._j._a(_hVar, f, this._o);
        this._j.setShowPlayButton(true);
        this._j.setVideoStateListener(this._p);
        this._j.setOnCompletionListener(this._q);
        this._j.setOnErrorListener(this._r);
        this._j._a(_dVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    public final void _a(_h _hVar, int i, ImageView imageView, AdvertRatioLayout advertRatioLayout, _d3._d _dVar) {
        _j9 _j9Var;
        String str;
        int iDp2px;
        int iDp2px2;
        if (_hVar == null || advertRatioLayout == null || imageView == null) {
            return;
        }
        if (!_hVar._s()) {
            List<_j9> list_h = _hVar._h();
            if (list_h == null || list_h.isEmpty()) {
                str = "";
            } else {
                if (i == 1) {
                    if (list_h.size() > 1) {
                        _j9Var = list_h.get(1);
                    } else {
                        _j9Var = list_h.get(0);
                    }
                } else if (i != 2 || list_h.size() <= 2) {
                    _j9Var = list_h.get(0);
                } else {
                    _j9Var = list_h.get(2);
                }
                str = _j9Var._a;
            }
        } else if (_hVar._l() != null) {
            str = _hVar._l()._a;
        } else {
            str = "";
        }
        String str2 = str;
        if (!PtgAdSdk.getConfig()._b()) {
            advertRatioLayout.setSizeCallback(new _aq(this, _hVar, imageView, str2, advertRatioLayout, _dVar));
            _d3 _d3Var = new _d3(_bq._a(getContext()), new _ar(this, _dVar, str2, advertRatioLayout, imageView));
            _d3Var._h = true;
            _d3Var.executeOnExecutor(_d3Var._f, str2);
            return;
        }
        AdSlot adSlot = this._b;
        if (adSlot != null) {
            iDp2px = ScreenUtils.dp2px(adSlot.getExpressViewAcceptedWidth());
            iDp2px2 = ScreenUtils.dp2px(this._b.getExpressViewAcceptedHeight());
        } else {
            iDp2px = 0;
            iDp2px2 = 0;
        }
        advertRatioLayout.setSizeCallback(new _ao(this, _hVar, imageView, str2, iDp2px, iDp2px2, advertRatioLayout, _dVar));
        _ap _apVar = new _ap(this, advertRatioLayout, imageView, _dVar);
        AtomicBoolean atomicBoolean = _ez._a;
        _l2 _l2VarLoad = Doodle.load(str2);
        _l2VarLoad._d = iDp2px;
        _l2VarLoad._e = iDp2px2;
        _l2VarLoad._h = false;
        _l2VarLoad._n = new _ey(_apVar);
        _l2VarLoad._a(iDp2px, iDp2px2);
    }

    public final void _c() {
        View view = this._d;
        if (view != null) {
            view.setOnClickListener(new _e(this));
        }
    }

    public final void _d() {
        ViewGroup viewGroup = this._e;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new _b(this));
            super.setAdShowListener(new _c());
            setAdRenderListener(new _d(this));
        }
    }

    public ViewGroup getAdRootView() {
        return this._e;
    }

    public View getShakeLayout() {
        return this._k;
    }

    @Override // com.kc.aw._al, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this._d == null) {
            throw new IllegalStateException("确实 dislike 组件");
        }
        if (this._e == null) {
            throw new IllegalStateException("缺失指定 click 组件");
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public void setAdLayoutParams(AdSlot adSlot) {
        int iDp2px;
        int iDp2px2;
        int iDp2px3;
        ViewGroup viewGroup;
        float f = 0.0f;
        int iDp2px4 = 0;
        try {
            int iDp2px5 = ScreenUtils.dp2px(adSlot.getExpressViewAcceptedWidth());
            int iDp2px6 = ScreenUtils.dp2px(adSlot.getExpressViewAcceptedHeight());
            iDp2px = ScreenUtils.dp2px(adSlot.getExpressViewPaddingLeft());
            try {
                iDp2px2 = ScreenUtils.dp2px(adSlot.getExpressViewPaddingTop());
                try {
                    iDp2px3 = ScreenUtils.dp2px(adSlot.getExpressViewPaddingRight());
                    try {
                        iDp2px4 = ScreenUtils.dp2px(adSlot.getExpressViewPaddingBottom());
                        int i = (iDp2px5 - iDp2px) - iDp2px3;
                        int i2 = (iDp2px6 - iDp2px2) - iDp2px4;
                        if (i > 0 && i2 > 0) {
                            f = i2 / i;
                        }
                    } catch (Exception unused) {
                        Logger.e("realWidth or realHeight is 0");
                    }
                } catch (Exception unused2) {
                    iDp2px3 = 0;
                }
            } catch (Exception unused3) {
                iDp2px2 = 0;
                iDp2px3 = 0;
                Logger.e("realWidth or realHeight is 0");
                setNativeRatio(f);
                viewGroup = this._e;
                if (viewGroup == null) {
                    return;
                }
                viewGroup.setPadding(iDp2px, iDp2px2, iDp2px3, iDp2px4);
            }
        } catch (Exception unused4) {
            iDp2px = 0;
        }
        setNativeRatio(f);
        viewGroup = this._e;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setPadding(iDp2px, iDp2px2, iDp2px3, iDp2px4);
    }

    @Override // com.kc.aw._al
    public void setAdShowListener(_u _uVar) {
    }

    public void setExpressAdInteractionListener(_j6 _j6Var) {
        this._c = _j6Var;
    }

    public void setNativeRatio(float f) {
        this._m = f;
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setRatio(f);
        }
        AdvertRatioLayout advertRatioLayout2 = this._g;
        if (advertRatioLayout2 != null) {
            advertRatioLayout2.setRatio(f);
        }
        AdvertRatioLayout advertRatioLayout3 = this._h;
        if (advertRatioLayout3 != null) {
            advertRatioLayout3.setRatio(f);
        }
        PtgVideoView ptgVideoView = this._j;
        if (ptgVideoView != null) {
            ptgVideoView.setVideoRatio(f);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this._q = onCompletionListener;
    }

    public void setOnErrorListener(NiceVideoPlayer._b _bVar) {
        this._r = _bVar;
    }

    public void setVideoProgressListener(_k9._b _bVar) {
        this._o = _bVar;
    }

    public void setVideoStateListener(_kc _kcVar) {
        this._p = _kcVar;
    }

    @Override // com.kc.aw._al
    public void setVisibilityChanged(_aj._a _aVar) {
    }
}
