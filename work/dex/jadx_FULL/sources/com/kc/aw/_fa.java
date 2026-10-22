package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kc.aw.activity.PtgInteractionPortraitActivity;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.widgets.PlaceholderImageView;
import com.kc.aw.component.widgets.PtgConfirmBtn;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.doodle.Doodle;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.kc.aw.widget.PtgRoundFrameLayout;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fa extends FrameLayout {
    public _3 _a;
    public String _b;
    public _h _c;
    public int _d;
    public int _e;
    public View _f;
    public FrameLayout _g;
    public PtgVideoView _h;
    public RelativeLayout _i;
    public ImageView _j;
    public LinearLayout _k;
    public PtgShakeView _l;
    public TextView _m;
    public TextView _n;
    public PlaceholderImageView _o;
    public int _p;
    public int _q;
    public float _r;

    @Keep
    public final class _a implements View.OnClickListener {
        public final PtgConfirmBtn _a;
        public final _fa _b;

        public _a(_fa _faVar, PtgConfirmBtn ptgConfirmBtn) {
            this._b = _faVar;
            this._a = ptgConfirmBtn;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _3 _3 = this._b._a;
            if (_3 != null) {
                PtgConfirmBtn ptgConfirmBtn = this._a;
                _fh _fhVar = ((_fj) _3)._c;
                _h _hVar = _fhVar._d;
                if (_hVar != null && _hVar._x) {
                    _fhVar._a(ptgConfirmBtn, 0, null, false);
                }
            }
        }
    }

    @Keep
    public final class _b implements View.OnClickListener {
        public final _fa _a;

        public _b(_fa _faVar) {
            this._a = _faVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _3 _3 = this._a._a;
            if (_3 != null) {
                _fj _fjVar = (_fj) _3;
                _fjVar._c._f = true;
                _f6 _f6Var = _fjVar._a;
                if (_f6Var != null) {
                    ((PtgInteractionPortraitActivity._a) _f6Var)._a.onBackPressed();
                }
            }
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final _fa _a;

        public _c(_fa _faVar) {
            this._a = _faVar;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            Exception exc;
            _fa _faVar = this._a;
            _faVar._p = _faVar._g.getWidth();
            _fa _faVar2 = this._a;
            _faVar2._q = _faVar2._g.getHeight();
            this._a._c();
            _fa _faVar3 = this._a;
            if (!_faVar3._c._s()) {
                String str_b = _faVar3._c._b();
                if (!PtgAdSdk.getConfig()._b()) {
                    _d3 _d3Var = new _d3(_faVar3.getContext(), new _fd(_faVar3, str_b));
                    _d3Var._h = false;
                    _d3Var.executeOnExecutor(_d3Var._f, str_b);
                    return;
                } else {
                    _fc _fcVar = new _fc(_faVar3, str_b);
                    AtomicBoolean atomicBoolean = _ez._a;
                    _l2 _l2VarLoad = Doodle.load(str_b);
                    _l2VarLoad._h = false;
                    _l2VarLoad._n = new _ex(_fcVar);
                    _l2VarLoad._a(_l2VarLoad._d, _l2VarLoad._e);
                    return;
                }
            }
            _h _hVar = _faVar3._c;
            float f = _faVar3._r;
            _fb _fbVar = new _fb(_faVar3);
            if (_hVar == null || _faVar3._h == null) {
                exc = new Exception("广告数据异常");
            } else {
                if (_hVar._s()) {
                    _faVar3._h._a(_hVar, f, new _fe(_faVar3));
                    _faVar3._h.setOnErrorListener(new _ff(_faVar3));
                    _faVar3._h.setOnCompletionListener(new _fg(_faVar3));
                    _faVar3._h.setVideoStateListener(new _f9(_faVar3));
                    _faVar3._h._a(_fbVar);
                    _faVar3._h.setShowPlayButton(true);
                    return;
                }
                exc = new Exception("广告类型异常");
            }
            _fbVar._a(exc);
        }
    }

    public _fa(Context context) {
        super(context);
        this._d = 0;
        this._e = 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0136  */
    public final View _a() throws Throwable {
        int screenRealWidth;
        int i_g;
        FrameLayout.LayoutParams layoutParams;
        int iDp2px;
        try {
            setVisibility(4);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.aw_layout_interaction, (ViewGroup) null);
            this._f = viewInflate;
            this._i = (RelativeLayout) viewInflate.findViewById(R.id.iconTextLayout);
            PtgConfirmBtn ptgConfirmBtn = (PtgConfirmBtn) this._f.findViewById(R.id.advertBtn);
            _m1._a(this._f, ptgConfirmBtn, null);
            ptgConfirmBtn.setOnClickListener(new _a(this, ptgConfirmBtn));
            PtgRoundFrameLayout ptgRoundFrameLayout = (PtgRoundFrameLayout) this._f.findViewById(R.id.closeAdvertLayout);
            ptgRoundFrameLayout.setOnClickListener(new _b(this));
            this._g = (FrameLayout) this._f.findViewById(R.id.imageLayout);
            this._j = (ImageView) this._f.findViewById(R.id.advertIv);
            LinearLayout linearLayout = (LinearLayout) this._f.findViewById(R.id.ptg_shake_layout);
            this._k = linearLayout;
            this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
            this._m = (TextView) this._f.findViewById(R.id.titleTv);
            this._n = (TextView) this._f.findViewById(R.id.subtitleTv);
            this._o = (PlaceholderImageView) this._f.findViewById(R.id.sourceIv);
            PtgVideoView ptgVideoView = (PtgVideoView) this._f.findViewById(R.id.ptgVideoView);
            this._h = ptgVideoView;
            ptgVideoView.setSoundMarginTop(ScreenUtils.dp2px(6.0f));
            if (this._e == 1 && (layoutParams = (FrameLayout.LayoutParams) ptgRoundFrameLayout.getLayoutParams()) != null) {
                if (this._d == 0) {
                    PtgVideoView ptgVideoView2 = this._h;
                    if (ptgVideoView2 != null) {
                        ptgVideoView2.setSoundMarginTop(ScreenUtils.dp2px(6.0f));
                    }
                    layoutParams.topMargin = ScreenUtils.dp2px(15.0f);
                    iDp2px = ScreenUtils.dp2px(15.0f);
                } else {
                    PtgVideoView ptgVideoView3 = this._h;
                    if (ptgVideoView3 != null) {
                        ptgVideoView3.setSoundMarginTop(ScreenUtils.dp2px(11.0f));
                    }
                    layoutParams.topMargin = ScreenUtils.dp2px(30.0f);
                    iDp2px = ScreenUtils.dp2px(38.0f);
                }
                layoutParams.rightMargin = iDp2px;
                ptgRoundFrameLayout.setLayoutParams(layoutParams);
            }
            _o6._a((ImageView) this._f.findViewById(R.id.ptg_sdk_ad_logo_iv));
            int screenRealWidth2 = -1;
            if (this._e == 1) {
                screenRealWidth = -1;
            } else if (this._d == 0) {
                screenRealWidth2 = (int) (ScreenUtils.getScreenRealWidth(getContext()) * 0.8f);
                this._p = screenRealWidth2;
                _h _hVar = this._c;
                if (_hVar != null) {
                    i_g = (int) (((double) screenRealWidth2) * (((double) _hVar._g()) / ((double) this._c._n())));
                    if (i_g > screenRealWidth2) {
                        i_g = screenRealWidth2;
                    }
                } else {
                    i_g = screenRealWidth2;
                }
                this._q = i_g;
                this._g.setLayoutParams(new LinearLayout.LayoutParams(this._p, this._q));
                screenRealWidth = -2;
            } else {
                screenRealWidth = (int) (ScreenUtils.getScreenRealWidth(getContext()) * 0.85f);
                ((LinearLayout) this._f.findViewById(R.id.advertRootLayout)).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                screenRealWidth2 = (int) (screenRealWidth * 1.0f);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(screenRealWidth2, screenRealWidth);
            layoutParams2.gravity = 17;
            addView(this._f, layoutParams2);
            _b();
            _c();
            this._g.post(new _c(this));
        } catch (Exception e) {
            _3 _3 = this._a;
            if (_3 != null) {
                StringBuilder sb_a = _jf._a("布局初始失败：");
                sb_a.append(e.getMessage());
                ((_fj) _3)._a(sb_a.toString());
            }
        }
        return this._f;
    }

    public final void _b() {
        try {
            String str_k = this._c._k();
            String str_e = this._c._e();
            String str_i = this._c._i();
            boolean z = TextUtils.isEmpty(str_k) && TextUtils.isEmpty(str_e);
            if (this._m != null) {
                if (TextUtils.isEmpty(str_k)) {
                    this._m.setVisibility(8);
                } else {
                    this._m.setText(str_k);
                    this._m.setVisibility(0);
                }
            }
            if (this._n != null) {
                if (TextUtils.isEmpty(str_e)) {
                    this._n.setVisibility(8);
                } else {
                    this._n.setText(str_e);
                    this._n.setVisibility(0);
                }
            }
            if (this._o != null) {
                if (TextUtils.isEmpty(str_i)) {
                    this._o.setVisibility(8);
                } else {
                    if (PtgAdSdk.getConfig()._b()) {
                        _ez._a(str_i, this._o);
                    } else {
                        _d3 _d3Var = new _d3(getContext(), this._o);
                        _d3Var.executeOnExecutor(_d3Var._f, str_i);
                    }
                    this._o.setVisibility(0);
                }
            }
            RelativeLayout relativeLayout = this._i;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(z ? 8 : 0);
            }
        } catch (Exception e) {
            _3 _3 = this._a;
            if (_3 != null) {
                StringBuilder sb_a = _jf._a("渲染失败：");
                sb_a.append(e.getMessage());
                ((_fj) _3)._a(sb_a.toString());
            }
        }
    }

    public final void _c() throws Throwable {
        int i;
        _hy _hyVar_a;
        int i2 = this._p;
        if (i2 <= 0 || (i = this._q) <= 0) {
            return;
        }
        this._r = i / i2;
        if (this._j != null && (_hyVar_a = _l5._a(this._c, i2, i)) != null) {
            this._j.setLayoutParams(_hyVar_a._a);
            if (_hyVar_a._b) {
                if (PtgAdSdk.getConfig()._b()) {
                    _l2 _l2VarLoad = Doodle.load(this._c._b());
                    _l2VarLoad._i = true;
                    _l2VarLoad._h = false;
                    _aw._a(getContext(), _l2VarLoad._a(3000L), this._g);
                } else {
                    _aw._a(getContext(), this._c._b(), this._g);
                }
            }
        }
        PtgShakeView ptgShakeView = this._l;
        if (ptgShakeView != null) {
            int i3 = this._p;
            int i4 = this._q;
            ImageView imageView = ptgShakeView._a;
            if (imageView == null) {
                return;
            }
            imageView.post(new _jy(ptgShakeView, i3, i4));
        }
    }

    public void setAdvertActionCallback(_3 _3) {
        this._a = _3;
    }

    public void setAdvertHashCode(String str) {
        this._b = str;
    }

    public void setAdvertInfo(_h _hVar) {
        this._c = _hVar;
    }

    public void setInteractionCallback(_f6 _f6Var) {
    }

    public void setScreenMode(int i) {
        this._e = i;
    }

    public void setScreenType(int i) {
        this._d = i;
    }

    public void setShakeLayoutVisible(boolean z) {
        LinearLayout linearLayout = this._k;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }
}
