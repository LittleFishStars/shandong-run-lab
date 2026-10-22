package com.kc.aw;

import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kn {
    public static final ConcurrentHashMap _p = new ConcurrentHashMap();
    public final PtgVideoView _a;
    public ViewGroup _b;
    public boolean _c;
    public int _d;
    public int _e;
    public boolean _f;
    public int _g;
    public int _h;
    public Runnable _l;
    public boolean _i = true;
    public final _a _j = new _a(this);
    public final Handler _k = new Handler();
    public final _b _m = new _b(this);
    public final AtomicInteger _n = new AtomicInteger();
    public final AtomicBoolean _o = new AtomicBoolean();

    @Keep
    public final class _a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final _kn _a;

        public _a(_kn _knVar) {
            this._a = _knVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            _kn _knVar = this._a;
            if (_knVar._a != null) {
                _knVar._a();
                _kn _knVar2 = this._a;
                if (_knVar2._d <= 0 || _knVar2._e <= 0) {
                    return;
                }
                _knVar2._a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    @Keep
    public final class _b implements ViewTreeObserver.OnScrollChangedListener {
        public final _kn _a;

        @Keep
        public final class _a implements Runnable {
            public final _b _a;

            public _a(_b _bVar) {
                this._a = _bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                _kn _knVar = this._a._a;
                ConcurrentHashMap concurrentHashMap = _kn._p;
                _knVar._a();
            }
        }

        public _b(_kn _knVar) {
            this._a = _knVar;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            _kn _knVar = this._a;
            if (_knVar._a == null || _knVar._b == null) {
                return;
            }
            Runnable runnable = _knVar._l;
            if (runnable != null) {
                _knVar._k.removeCallbacks(runnable);
            }
            _kn _knVar2 = this._a;
            _a _aVar = new _a(this);
            _knVar2._l = _aVar;
            _knVar2._k.postDelayed(_aVar, 16L);
        }
    }

    public _kn(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2  */
    public final void _a() {
        ViewGroup viewGroup;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int iSqrt;
        PtgVideoView ptgVideoView = this._a;
        if (ptgVideoView == null) {
            return;
        }
        this._f = ptgVideoView.hasWindowFocus();
        this._d = this._a.getWidth();
        this._e = this._a.getHeight();
        PtgVideoView ptgVideoView2 = this._a;
        boolean z4 = false;
        if (ptgVideoView2 == null) {
            viewGroup = null;
        } else {
            try {
                ViewParent parent = ptgVideoView2.getParent();
                while (true) {
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) parent;
                        if (!(viewGroup2 == null ? false : viewGroup2 instanceof ScrollView)) {
                            ViewGroup viewGroup3 = (ViewGroup) parent;
                            if (!(viewGroup3 == null ? false : viewGroup3 instanceof HorizontalScrollView)) {
                                ViewGroup viewGroup4 = (ViewGroup) parent;
                                if (!(viewGroup4 == null ? false : viewGroup4 instanceof AbsListView)) {
                                    ViewGroup viewGroup5 = (ViewGroup) parent;
                                    if (viewGroup5 == null) {
                                        z = false;
                                    } else {
                                        try {
                                            if (!Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup5)) {
                                                try {
                                                    if (!Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup5)) {
                                                        z = false;
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                        } catch (Exception unused2) {
                                        }
                                        z = true;
                                    }
                                    if (!z) {
                                        ViewGroup viewGroup6 = (ViewGroup) parent;
                                        if (viewGroup6 == null) {
                                            z2 = false;
                                        } else {
                                            try {
                                                if (!Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup6)) {
                                                    try {
                                                        if (!Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup6)) {
                                                            z2 = false;
                                                        }
                                                    } catch (Exception unused3) {
                                                    }
                                                }
                                            } catch (Exception unused4) {
                                            }
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            ViewGroup viewGroup7 = (ViewGroup) parent;
                                            if (viewGroup7 == null) {
                                                z3 = false;
                                            } else {
                                                try {
                                                    if (!Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup7)) {
                                                        try {
                                                            if (!Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup7)) {
                                                                try {
                                                                    if (!Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup7)) {
                                                                        z3 = false;
                                                                    }
                                                                } catch (Exception unused5) {
                                                                }
                                                            }
                                                        } catch (Exception unused6) {
                                                        }
                                                    }
                                                } catch (Exception unused7) {
                                                }
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                parent = parent.getParent();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        viewGroup = (ViewGroup) parent;
                    } else {
                        viewGroup = null;
                    }
                }
            } catch (Exception unused8) {
            }
        }
        this._b = viewGroup;
        int i2 = this._d;
        if (i2 <= 0 || (i = this._e) <= 0) {
            return;
        }
        if (this._a != null) {
            Rect rect = new Rect();
            if (this._a.getGlobalVisibleRect(rect)) {
                this._c = ((float) (rect.height() * rect.width())) > ((float) (i2 * i)) * 0.5f;
            } else {
                this._c = false;
            }
        }
        if (!this._o.get() && this._f && this._c) {
            this._o.set(true);
        }
        ViewGroup viewGroup8 = this._b;
        if (viewGroup8 == null) {
            _a(this._a);
            return;
        }
        if (this._c) {
            PtgVideoView ptgVideoView3 = this._a;
            if (ptgVideoView3 != null && ptgVideoView3.getVisibility() == 0) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                try {
                    viewGroup8.getLocationOnScreen(iArr);
                    ptgVideoView3.getLocationOnScreen(iArr2);
                    int i3 = iArr[0];
                    int width = viewGroup8.getWidth() / 2;
                    int i4 = iArr[1];
                    int height = viewGroup8.getHeight() / 2;
                    int width2 = ((ptgVideoView3.getWidth() / 2) + iArr2[0]) - (width + i3);
                    int height2 = ((ptgVideoView3.getHeight() / 2) + iArr2[1]) - (height + i4);
                    iSqrt = (int) Math.sqrt((height2 * height2) + (width2 * width2));
                } catch (Exception unused9) {
                    iSqrt = 0;
                }
            } else {
                iSqrt = 0;
            }
            this._g = iSqrt;
            boolean z5 = iSqrt != this._h;
            this._h = iSqrt;
            ViewGroup viewGroup9 = this._b;
            PtgVideoView ptgVideoView4 = this._a;
            ConcurrentHashMap concurrentHashMap = _p;
            synchronized (concurrentHashMap) {
                int iIdentityHashCode = System.identityHashCode(viewGroup9);
                List arrayList = (List) concurrentHashMap.get(Integer.valueOf(iIdentityHashCode));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    concurrentHashMap.put(Integer.valueOf(iIdentityHashCode), arrayList);
                }
                if (!arrayList.contains(ptgVideoView4)) {
                    arrayList.add(ptgVideoView4);
                }
            }
            z4 = z5;
        } else {
            PtgVideoView ptgVideoView5 = this._a;
            if (ptgVideoView5 != null) {
                ConcurrentHashMap concurrentHashMap2 = _p;
                synchronized (concurrentHashMap2) {
                    List list = (List) concurrentHashMap2.get(Integer.valueOf(System.identityHashCode(viewGroup8)));
                    if (list != null && list.contains(ptgVideoView5)) {
                        list.remove(ptgVideoView5);
                        if (2 != ptgVideoView5.getLastState()) {
                            ptgVideoView5.setLastState(2);
                            ptgVideoView5._a();
                        }
                    }
                }
            }
        }
        if (z4) {
            _a(this._b);
        }
    }

    public final void _a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = _p;
        synchronized (concurrentHashMap) {
            List<PtgVideoView> list = (List) concurrentHashMap.get(Integer.valueOf(System.identityHashCode(viewGroup)));
            if (list != null && !list.isEmpty()) {
                PtgVideoView ptgVideoView = null;
                int i = Integer.MAX_VALUE;
                for (PtgVideoView ptgVideoView2 : list) {
                    _kn _knVar = ptgVideoView2._k;
                    int i2 = (_knVar == null || !_knVar._c) ? -1 : _knVar._g;
                    if (i2 < i && i2 > -1) {
                        ptgVideoView = ptgVideoView2;
                        i = i2;
                    }
                }
                for (PtgVideoView ptgVideoView3 : list) {
                    if (ptgVideoView == ptgVideoView3) {
                        _a(ptgVideoView3);
                    } else if (ptgVideoView3 != null && 2 != ptgVideoView3.getLastState()) {
                        ptgVideoView3.setLastState(2);
                        ptgVideoView3._a();
                    }
                }
            }
        }
    }

    public final void _a(PtgVideoView ptgVideoView) {
        PtgCoreVideo ptgCoreVideo;
        if (this._i && ptgVideoView != null) {
            if (((!_id._a(ptgVideoView._b) || (ptgCoreVideo = ptgVideoView._j) == null || ptgCoreVideo.getCurrStatus() == 7 || ptgVideoView._j.getCurrStatus() == 3) ? false : true) && 1 != ptgVideoView.getLastState() && ptgVideoView.hasWindowFocus()) {
                ptgVideoView.setLastState(1);
                _fz._a.post(new _ke(ptgVideoView));
            }
        }
    }

    public final void _b() {
        try {
            if (this._a != null) {
                _a();
                if (this._b != null) {
                    this._a.getViewTreeObserver().addOnScrollChangedListener(this._m);
                } else {
                    this._a.getViewTreeObserver().removeOnScrollChangedListener(this._m);
                }
                this._a.getViewTreeObserver().addOnGlobalLayoutListener(this._j);
            }
        } catch (Exception unused) {
        }
    }

    public final void _c() {
        try {
            PtgVideoView ptgVideoView = this._a;
            if (ptgVideoView != null) {
                ViewTreeObserver viewTreeObserver = ptgVideoView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    _b _bVar = this._m;
                    if (_bVar != null) {
                        viewTreeObserver.removeOnScrollChangedListener(_bVar);
                    }
                    _a _aVar = this._j;
                    if (_aVar != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(_aVar);
                    }
                }
                ViewGroup viewGroup = this._b;
                PtgVideoView ptgVideoView2 = this._a;
                if (viewGroup != null && ptgVideoView2 != null) {
                    ConcurrentHashMap concurrentHashMap = _p;
                    synchronized (concurrentHashMap) {
                        try {
                            List list = (List) concurrentHashMap.get(Integer.valueOf(System.identityHashCode(viewGroup)));
                            if (list != null && list.contains(ptgVideoView2)) {
                                list.remove(ptgVideoView2);
                                if (2 != ptgVideoView2.getLastState()) {
                                    ptgVideoView2.setLastState(2);
                                    ptgVideoView2._a();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
