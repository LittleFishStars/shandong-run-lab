package com.byazt.nw;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.byazt.an.ViewPager;
import com.byazt.gr.uj;
import com.byazt.gr.ve;
import com.byazt.nr.m;
import com.byazt.nz.BaseIndicator;
import com.byazt.nz.DotIndicator;
import com.byazt.nz.RectangleIndicator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.uj {
    public static final Interpolator h = new Interpolator() { // from class: com.byazt.nw.BaseSwiper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28852a;
    public List<T> c;
    public final Runnable d;
    public int da;
    public final Runnable eo;
    public BaseIndicator gr;
    public int gt;
    public FrameLayout gu;
    public int i;
    public boolean m;
    public boolean md;
    public int my;
    public int n;
    public boolean nu;
    public Scroller p;
    public int qy;
    public boolean rh;
    public int rl;
    public String sl;
    public int sp;
    public float t;
    public ViewPager tt;
    public boolean u;
    public int uj;
    public Context ve;
    public int x;
    public boolean yp;
    public com.byazt.nw.c yv;
    public boolean z;
    public c zm;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, 1695})
    public class SwiperViewPager extends ViewPager {
        public SwiperViewPager(Context context) {
            super(context);
        }

        private MotionEvent c(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }

        @Override // com.byazt.an.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.m) {
                return false;
            }
            try {
                if (BaseSwiper.this.qy != 1) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(c(motionEvent));
                c(motionEvent);
                return zOnInterceptTouchEvent;
            } catch (IllegalArgumentException e) {
                m.c(e);
                return false;
            }
        }

        @Override // com.byazt.an.ViewPager, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!BaseSwiper.this.m) {
                return false;
            }
            try {
                return BaseSwiper.this.qy == 1 ? super.onTouchEvent(c(motionEvent)) : super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException e) {
                m.c(e);
                return false;
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, 2221})
    public class c extends com.byazt.an.tt {
        public c() {
        }

        @Override // com.byazt.an.tt
        public int c() {
            if (BaseSwiper.this.z) {
                return 1024;
            }
            return BaseSwiper.this.c.size();
        }

        @Override // com.byazt.an.tt
        public int c(Object obj) {
            return -2;
        }

        @Override // com.byazt.an.tt
        public boolean c(View view, Object obj) {
            return view == obj;
        }

        @Override // com.byazt.an.tt
        public Object c(ViewGroup viewGroup, int i) {
            View viewC = BaseSwiper.this.c(i, com.byazt.nw.tt.c(BaseSwiper.this.z, i, BaseSwiper.this.c.size()));
            viewGroup.addView(viewC);
            return viewC;
        }

        @Override // com.byazt.an.tt
        public void c(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.byazt.an.tt
        public float c(int i) {
            if (BaseSwiper.this.t <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.t;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, 854})
    public class tt extends Scroller {
        public tt(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, BaseSwiper.this.sp);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, BaseSwiper.this.sp);
        }
    }

    public BaseSwiper(Context context) {
        super(context);
        this.c = new CopyOnWriteArrayList();
        this.uj = -1;
        this.n = 2000;
        this.f28852a = 500;
        this.sp = 500;
        this.x = 0;
        this.i = -1;
        this.da = -1;
        this.sl = "normal";
        this.t = 1.0f;
        this.u = true;
        this.yp = true;
        this.z = true;
        this.m = true;
        this.my = 0;
        this.gt = 0;
        this.rl = 0;
        this.qy = 0;
        this.md = true;
        this.d = new Runnable() { // from class: com.byazt.nw.BaseSwiper.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = BaseSwiper.this.tt.getCurrentItem() + 1;
                if (BaseSwiper.this.z) {
                    if (currentItem >= 1024) {
                        BaseSwiper.this.tt.c(512, false);
                        return;
                    } else {
                        BaseSwiper.this.tt.c(currentItem, true);
                        return;
                    }
                }
                com.byazt.an.tt adapter = BaseSwiper.this.tt.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.c()) {
                        BaseSwiper.this.tt.c(0, false);
                    } else {
                        BaseSwiper.this.tt.c(currentItem, true);
                    }
                }
            }
        };
        this.eo = new Runnable() { // from class: com.byazt.nw.BaseSwiper.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseSwiper.this.yp) {
                    BaseSwiper.this.md = false;
                    int currentItem = BaseSwiper.this.tt.getCurrentItem() + 1;
                    if (BaseSwiper.this.z) {
                        if (currentItem >= 1024) {
                            BaseSwiper.this.tt.c(512, false);
                        } else {
                            BaseSwiper.this.tt.c(currentItem, true);
                        }
                        BaseSwiper baseSwiper = BaseSwiper.this;
                        baseSwiper.postDelayed(baseSwiper.eo, BaseSwiper.this.n);
                        return;
                    }
                    com.byazt.an.tt adapter = BaseSwiper.this.tt.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.c()) {
                            BaseSwiper.this.tt.c(0, false);
                            BaseSwiper baseSwiper2 = BaseSwiper.this;
                            baseSwiper2.postDelayed(baseSwiper2.eo, BaseSwiper.this.n);
                        } else {
                            BaseSwiper.this.tt.c(currentItem, true);
                            BaseSwiper baseSwiper3 = BaseSwiper.this;
                            baseSwiper3.postDelayed(baseSwiper3.eo, BaseSwiper.this.n);
                        }
                    }
                }
            }
        };
        this.ve = context;
        this.gu = new FrameLayout(context);
        this.tt = c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.gu.addView(this.tt, layoutParams);
        addView(this.gu);
    }

    public BaseSwiper da(int i) {
        this.da = i;
        c(this.sl, this.x, this.i, i, true);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.yp) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.nu) {
                    uj();
                }
            } else if (action == 0) {
                n();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.byazt.an.tt getAdapter() {
        return this.tt.getAdapter();
    }

    public int getCurrentItem() {
        return this.tt.getCurrentItem();
    }

    public ViewPager getViewPager() {
        return this.tt;
    }

    public BaseSwiper<T> i(int i) {
        this.i = i;
        c(this.sl, this.x, i, this.da, true);
        return this;
    }

    public void setOnPageChangeListener(com.byazt.nw.c cVar) {
        this.yv = cVar;
    }

    public void setTwoItems(boolean z) {
        this.rh = z;
    }

    public abstract View sl(int i);

    public void t(int i) {
        if (this.yv != null) {
            int iC = com.byazt.nw.tt.c(this.z, i, this.c.size());
            this.yv.c(this.z, iC, i, iC == 0, iC == this.c.size() - 1);
        }
        if (this.u) {
            this.gr.c(i);
        }
    }

    public void u(int i) {
        if (i == 1 && this.nu) {
            n();
        }
        com.byazt.nw.c cVar = this.yv;
        if (cVar != null) {
            cVar.c(this.z, i);
        }
    }

    public void yp(int i) {
        c(this.sl, this.x, this.i, this.da, true);
        if (this.zm == null) {
            this.zm = new c();
            this.tt.c((ViewPager.uj) this);
            this.tt.setAdapter(this.zm);
        }
        if (this.z) {
            if (i >= 1024) {
                this.tt.c(512, false);
                return;
            } else {
                this.tt.c(i, true);
                return;
            }
        }
        if (i < 0 || i >= this.c.size()) {
            return;
        }
        this.tt.c(i, true);
    }

    public void z(int i) {
        removeCallbacks(this.d);
        postDelayed(this.d, i);
    }

    public BaseSwiper a(int i) {
        this.gr.setSelectedColor(i);
        return this;
    }

    public BaseSwiper n(int i) {
        if (i < 0) {
            i = this.n;
        }
        this.uj = i;
        uj();
        return this;
    }

    public BaseSwiper sp(int i) {
        this.gr.setUnSelectedColor(i);
        return this;
    }

    public BaseSwiper tt(float f) {
        this.gr.setIndicatorHeight((int) f);
        return this;
    }

    public BaseSwiper uj(float f) {
        this.gr.setIndicatorY(f);
        return this;
    }

    public BaseSwiper ve(float f) {
        this.gr.setIndicatorX(f);
        return this;
    }

    public BaseSwiper x(int i) {
        this.x = i;
        c(this.sl, i, this.i, this.da, true);
        return this;
    }

    public void a() {
        int i;
        c(this.sl, this.x, this.i, this.da, true);
        if (this.zm == null) {
            this.zm = new c();
            this.tt.c((ViewPager.uj) this);
            this.tt.setAdapter(this.zm);
        }
        int i2 = this.my;
        if (i2 < 0 || i2 >= this.c.size()) {
            this.my = 0;
        }
        if (this.z) {
            i = this.my + 512;
        } else {
            i = this.my;
        }
        this.tt.c(i, true);
    }

    public ViewPager c() {
        return new SwiperViewPager(getContext());
    }

    public void sp() {
        removeCallbacks(this.d);
    }

    public BaseSwiper tt() {
        this.gr.c();
        return this;
    }

    public BaseSwiper uj(int i) {
        this.n = i;
        uj();
        return this;
    }

    public BaseSwiper ve(int i) {
        this.sp = i;
        if (this.p == null) {
            this.p = new tt(this.ve, h);
        }
        this.tt.setScroller(this.p);
        return this;
    }

    private boolean x() {
        return this.c.size() <= 2 && this.z;
    }

    public BaseSwiper c(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.gr = new RectangleIndicator(this.ve);
        } else {
            this.gr = new DotIndicator(this.ve);
        }
        addView(this.gr, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public BaseSwiper tt(String str) {
        this.gr.setIndicatorDirection(str);
        return this;
    }

    public BaseSwiper n(float f) {
        this.t = f;
        return this;
    }

    public BaseSwiper tt(int i) {
        this.f28852a = i;
        return this;
    }

    public BaseSwiper uj(boolean z) {
        this.gr.setLoop(z);
        if (this.z != z) {
            int iC = com.byazt.nw.tt.c(z, this.tt.getCurrentItem(), this.c.size());
            this.z = z;
            c cVar = this.zm;
            if (cVar != null) {
                cVar.ve();
                this.tt.setCurrentItem(iC);
            }
        }
        return this;
    }

    public BaseSwiper n(boolean z) {
        this.nu = z;
        return this;
    }

    public BaseSwiper tt(boolean z) {
        this.m = z;
        return this;
    }

    public void n() {
        removeCallbacks(this.eo);
    }

    public BaseSwiper ve(boolean z) {
        this.u = z;
        return this;
    }

    public BaseSwiper c(float f) {
        this.gr.setIndicatorWidth((int) f);
        return this;
    }

    public BaseSwiper ve(String str) {
        this.sl = str;
        c(str, this.x, this.i, this.da, true);
        return this;
    }

    public BaseSwiper c(int i) {
        this.qy = i;
        return this;
    }

    public BaseSwiper c(boolean z) {
        this.yp = z;
        uj();
        return this;
    }

    public void ve() {
        int i;
        c(this.sl, this.x, this.i, this.da, true);
        if (this.zm == null) {
            this.zm = new c();
            this.tt.c((ViewPager.uj) this);
            this.tt.setAdapter(this.zm);
        }
        int i2 = this.my;
        if (i2 < 0 || i2 >= this.c.size()) {
            this.my = 0;
        }
        if (this.z) {
            i = this.my + 512;
        } else {
            i = this.my;
        }
        this.tt.c(i, true);
        if (!this.z) {
            t(i);
        }
        if (this.yp) {
            uj();
        }
    }

    public void c(String str, int i, int i2, int i3, boolean z) {
        c cVar = this.zm;
        if (cVar != null) {
            cVar.ve();
        }
        this.tt.setPageMargin(i);
        if (i2 > 0 || i3 > 0) {
            if (this.qy == 1) {
                this.tt.setPadding(0, i2 + i, 0, i3 + i);
            } else {
                this.tt.setPadding(i2 + i, 0, i3 + i, 0);
            }
            this.gu.setClipChildren(false);
            this.tt.setClipChildren(false);
            this.tt.setClipToPadding(false);
        }
        if (this.qy == 1) {
            uj ujVar = new uj();
            ujVar.c(str);
            this.tt.c(true, (ViewPager.n) ujVar);
            this.tt.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.tt.c(false, (ViewPager.n) new ve());
        } else if (TextUtils.equals(str, "cube")) {
            this.tt.c(false, (ViewPager.n) new com.byazt.gr.c());
        } else if (TextUtils.equals(str, "fade")) {
            this.tt.c(false, (ViewPager.n) new com.byazt.gr.tt());
        } else {
            this.tt.c(false, (ViewPager.n) null);
        }
        this.tt.setOffscreenPageLimit((int) this.t);
    }

    public void uj() {
        int i;
        removeCallbacks(this.eo);
        int i2 = this.n;
        if (this.md && (i = this.uj) > 0) {
            i2 = i;
        }
        postDelayed(this.eo, i2);
    }

    public View c(int i, int i2) {
        if (this.c.size() == 0) {
            return new View(getContext());
        }
        View viewSl = sl(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewSl instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (x()) {
            viewSl.setTag("two_items_tag");
        }
        if (viewSl.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewSl.getParent()).removeView(viewSl);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewSl, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (x()) {
            frameLayout.setTag(Integer.valueOf(i));
        }
        return frameLayout;
    }

    public BaseSwiper<T> c(T t) {
        if (t != null) {
            this.c.add(t);
            if (this.u) {
                this.gr.tt();
            }
        }
        c cVar = this.zm;
        if (cVar != null) {
            cVar.ve();
            this.gr.c(this.my, this.tt.getCurrentItem());
        }
        return this;
    }

    @Override // com.byazt.an.ViewPager.uj
    public void c(int i, float f, int i2) {
        com.byazt.nw.c cVar = this.yv;
        if (cVar != null) {
            boolean z = this.z;
            cVar.c(z, com.byazt.nw.tt.c(z, i, this.c.size()), f, i2);
        }
        if (x()) {
            c(i, findViewWithTag(Integer.valueOf(i)));
            if (f > 0.0f) {
                int i3 = i + 1;
                c(i3, findViewWithTag(Integer.valueOf(i3)));
            }
        }
    }

    private void c(int i, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t = this.c.get(com.byazt.nw.tt.c(true, i, this.c.size()));
            if (t == null) {
                return;
            }
            if (t instanceof com.byazt.xj.ve) {
                viewFindViewWithTag = ((com.byazt.xj.ve) t).i();
            } else if (t instanceof View) {
                viewFindViewWithTag = (View) t;
            }
            if (viewFindViewWithTag == null) {
                return;
            }
            if (viewFindViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
            }
            ((ViewGroup) view).addView(viewFindViewWithTag);
        }
    }
}
