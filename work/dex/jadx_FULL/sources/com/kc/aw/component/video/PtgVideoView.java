package com.kc.aw.component.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kc.aw._aw;
import com.kc.aw._bb;
import com.kc.aw._bq;
import com.kc.aw._d3;
import com.kc.aw._ez;
import com.kc.aw._f1;
import com.kc.aw._h;
import com.kc.aw._hu;
import com.kc.aw._hy;
import com.kc.aw._ii;
import com.kc.aw._ij;
import com.kc.aw._k7;
import com.kc.aw._k8;
import com.kc.aw._k9;
import com.kc.aw._kb;
import com.kc.aw._kc;
import com.kc.aw._kf;
import com.kc.aw._kg;
import com.kc.aw._kh;
import com.kc.aw._kj;
import com.kc.aw._kk;
import com.kc.aw._kl;
import com.kc.aw._km;
import com.kc.aw._kn;
import com.kc.aw._kq;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.aw.lib.utils._d;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgVideoView extends _k7 {
    public static final int _w = 0;
    public int _b;
    public int _c;
    public boolean _d;
    public boolean _e;
    public AdvertRatioLayout _f;
    public ImageView _g;
    public ImageView _h;
    public ImageView _i;
    public PtgCoreVideo _j;
    public final _kn _k;
    public _h _l;
    public final _kb _m;
    public boolean _n;
    public int _o;
    public int _p;
    public final AtomicBoolean _q;
    public Bitmap _r;
    public _kc _s;
    public MediaPlayer.OnCompletionListener _t;
    public _hy _u;
    public AdvertRatioLayout._a _v;

    @Keep
    public final class _a implements _kq {
        public final PtgVideoView _a;

        public _a(PtgVideoView ptgVideoView) {
            this._a = ptgVideoView;
        }

        @Override // com.kc.aw._kq
        public final void _a(Bitmap bitmap) {
            if (bitmap == null) {
                if (this._a._q.get()) {
                    return;
                }
                PtgVideoView ptgVideoView = this._a;
                if (ptgVideoView._a != null) {
                    ptgVideoView._q.set(true);
                    this._a._a._a((Bitmap) null);
                    return;
                }
                return;
            }
            ImageView imageView = this._a._g;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            PtgVideoView ptgVideoView2 = this._a;
            _hy _hyVar = ptgVideoView2._u;
            if (_hyVar != null && _hyVar._b) {
                _aw._a(ptgVideoView2.getContext(), bitmap, this._a._f);
            }
            if (this._a._q.get()) {
                return;
            }
            PtgVideoView ptgVideoView3 = this._a;
            if (ptgVideoView3._a != null) {
                ptgVideoView3._q.set(true);
                this._a._a._a(bitmap);
            }
        }
    }

    @Keep
    public final class _b implements _k9._b {
        public final _h _a;
        public final _k9._b _b;
        public final PtgVideoView _c;

        public _b(PtgVideoView ptgVideoView, _h _hVar, _k9._b _bVar) {
            this._c = ptgVideoView;
            this._a = _hVar;
            this._b = _bVar;
        }

        @Override // com.kc.aw._k9._b
        public final void _a(long j, long j2) {
            PtgVideoView ptgVideoView = this._c;
            _h _hVar = this._a;
            _kb _kbVar = ptgVideoView._m;
            if (_kbVar != null) {
                _kbVar._a(_hVar, j2);
            }
            _k9._b _bVar = this._b;
            if (_bVar != null) {
                _bVar._a(j, j2);
            }
        }
    }

    public PtgVideoView(Context context) {
        super(context);
        this._b = 0;
        this._c = 0;
        this._d = true;
        this._e = true;
        this._n = true;
        this._o = 51;
        this._p = 0;
        this._q = new AtomicBoolean();
        this._m = new _kb();
        this._k = new _kn(this);
    }

    public PtgVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._b = 0;
        this._c = 0;
        this._d = true;
        this._e = true;
        this._n = true;
        this._o = 51;
        this._p = 0;
        this._q = new AtomicBoolean();
        this._m = new _kb();
        this._k = new _kn(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSoundMute(boolean z) {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            this._n = z;
            ptgCoreVideo.setVolume(z ? 0 : 7);
            ImageView imageView = this._i;
            if (imageView == null || !this._e) {
                return;
            }
            imageView.setImageResource(z ? R.drawable.aw_ic_player_mute : R.drawable.aw_ic_player_unmute);
        }
    }

    public final void _a() {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo._b();
        }
    }

    public final void _a(_d3._d _dVar) {
        int i;
        Handler handler;
        _d3._c _cVar;
        this._a = _dVar;
        _h _hVar = this._l;
        if (_hVar == null) {
            _dVar._a(new Exception("广告信息异常"));
            return;
        }
        String str_m = _hVar._m();
        if (!TextUtils.isEmpty(str_m)) {
            if (!PtgAdSdk.getConfig()._b()) {
                _d3 _d3Var = new _d3(_bq._a(getContext()), new _km(this, str_m));
                _d3Var._i = 3000;
                _d3Var._h = true;
                _d3Var.executeOnExecutor(_d3Var._f, str_m);
                i = _d3Var._i;
                if (i <= 0 || (handler = _d3Var._a) == null || (_cVar = _d3Var._l) == null) {
                    return;
                }
                handler.postDelayed(_cVar, i);
                return;
            }
            _a(str_m);
        }
        _k8 _k8Var_l = this._l._l();
        str_m = _k8Var_l != null ? _k8Var_l._a : "";
        if (!PtgAdSdk.getConfig()._b()) {
            _d3 _d3Var2 = new _d3(_bq._a(getContext()), new _kl(this, str_m));
            _d3Var2._g = true;
            _d3Var2._i = 3000;
            _d3Var2._h = true;
            _d3Var2.executeOnExecutor(_d3Var2._f, str_m);
            i = _d3Var2._i;
            if (i <= 0 || (handler = _d3Var2._a) == null || (_cVar = _d3Var2._l) == null) {
                return;
            }
            handler.postDelayed(_cVar, i);
            return;
        }
        _a(str_m);
    }

    public final void _a(_h _hVar, float f, _k9._b _bVar) {
        this._l = _hVar;
        if (_hVar == null) {
            return;
        }
        _bb _bbVar = _hVar._D;
        if (_bbVar != null) {
            this._b = _bbVar._a;
            this._c = _bbVar._b;
        } else {
            this._c = 0;
        }
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._i = this._b != 0;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.aw_native_view_video, (ViewGroup) null);
        this._j = (PtgCoreVideo) viewInflate.findViewById(R.id.myvideo);
        this._g = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        this._h = (ImageView) viewInflate.findViewById(R.id.playButton);
        this._i = (ImageView) viewInflate.findViewById(R.id.soundButton);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.advertMaxLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(f);
        this._f.addOnLayoutChangeListener(new _kf(this));
        this._g.setVisibility(4);
        setSoundGravity(this._o);
        setSoundMarginTop(this._p);
        addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        this._h.setOnClickListener(new _kg(this));
        this._i.setOnClickListener(new _kh(this));
        setShowSoundButton(this._c == 1);
        setSoundMute(this._c == 0);
        _b _bVar2 = new _b(this, _hVar, _bVar);
        _h _hVar2 = this._l;
        if (_hVar2 == null) {
            return;
        }
        _k8 _k8Var_l = _hVar2._l();
        String str = _k8Var_l != null ? _k8Var_l._a : "";
        String str_a = _hu._a(getContext())._a(str, true);
        _ij._a _aVar = new _ij._a();
        _aVar._a = str_a;
        _aVar._b = str;
        _aVar._c = true;
        _ij _ijVar = new _ij(_aVar);
        _ii _iiVar = new _ii(getContext());
        _iiVar.setPlayerListener(new _kj(this, _bVar2));
        _iiVar.setInfo(_ijVar);
        this._j.setHeartVideoContent(_iiVar);
        this._j.setFrameListener(new _kk(this));
    }

    public final void _a(String str) {
        _a _aVar = new _a(this);
        AtomicBoolean atomicBoolean = _ez._a;
        if (TextUtil.isEmpty(str)) {
            return;
        }
        _d._b(new _f1(str, _aVar));
    }

    public final void _a(boolean z) {
        ImageView imageView = this._h;
        if (imageView != null) {
            imageView.setVisibility((this._d && z) ? 0 : 8);
        }
    }

    public final void _b() {
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._c();
            ViewGroup viewGroup = this._k._b;
            if (viewGroup != null) {
                ConcurrentHashMap concurrentHashMap = _kn._p;
                synchronized (concurrentHashMap) {
                    concurrentHashMap.remove(Integer.valueOf(System.identityHashCode(viewGroup)));
                }
            }
        }
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo._b();
            this._j._a(false);
            this._j = null;
        }
        try {
            Bitmap bitmap = this._r;
            if (bitmap != null && !bitmap.isRecycled()) {
                this._r.recycle();
                this._r = null;
            }
            ImageView imageView = this._g;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            this._v = null;
        } catch (Exception unused) {
        }
    }

    public final void _c() {
        if (this._j == null || getWindowVisibility() != 0) {
            return;
        }
        if (this._j.getCurrStatus() == 4) {
            this._j._c();
        } else {
            this._j._d();
        }
    }

    public int getLastState() {
        _kn _knVar = this._k;
        if (_knVar != null) {
            return _knVar._n.get();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._b();
            PtgCoreVideo ptgCoreVideo = this._j;
            if (ptgCoreVideo != null) {
                ptgCoreVideo.setInScrollView(this._k._b != null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._c();
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._a();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._f = z;
            PtgVideoView ptgVideoView = _knVar._a;
            if (ptgVideoView != null) {
                if (!z) {
                    if (2 != ptgVideoView.getLastState()) {
                        ptgVideoView.setLastState(2);
                        ptgVideoView._a();
                        return;
                    }
                    return;
                }
                ViewGroup viewGroup = _knVar._b;
                if (viewGroup != null) {
                    _knVar._a(viewGroup);
                } else if (_knVar._c) {
                    _knVar._a(ptgVideoView);
                }
            }
        }
    }

    public void setLastState(int i) {
        _kn _knVar = this._k;
        if (_knVar != null) {
            _knVar._n.set(i);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this._t = onCompletionListener;
    }

    public void setOnErrorListener(NiceVideoPlayer._b _bVar) {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo.setOnErrorListener(_bVar);
        }
    }

    public void setShowPlayButton(boolean z) {
        this._d = z;
        _a(z);
    }

    public void setShowSoundButton(boolean z) {
        ImageView imageView;
        this._e = z;
        if (z || (imageView = this._i) == null || imageView.getVisibility() != 0) {
            return;
        }
        this._i.setVisibility(8);
    }

    public void setSizeCallback(AdvertRatioLayout._a _aVar) {
        this._v = _aVar;
    }

    public void setSoundGravity(int i) {
        this._o = i;
        ImageView imageView = this._i;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i;
            this._i.setLayoutParams(layoutParams2);
        }
    }

    public void setSoundMarginTop(int i) {
        this._p = i;
        ImageView imageView = this._i;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = i;
            this._i.setLayoutParams(layoutParams2);
        }
    }

    public void setVideoLayoutParams(FrameLayout.LayoutParams layoutParams) {
        PtgCoreVideo ptgCoreVideo = this._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo.setLayoutParams(layoutParams);
        }
    }

    public void setVideoRatio(float f) {
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setRatio(f);
        }
    }

    public void setVideoStateListener(_kc _kcVar) {
        this._s = _kcVar;
    }
}
