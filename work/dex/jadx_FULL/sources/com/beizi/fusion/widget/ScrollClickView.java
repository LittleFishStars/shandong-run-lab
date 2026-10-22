package com.beizi.fusion.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;
import com.beizi.fusion.jh;
import com.beizi.fusion.so;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScrollClickView extends LinearLayout {
    public static final String DIR_DOWN = "down";
    public static final String DIR_LEFT = "left";
    public static final String DIR_RIGHT = "right";
    public static final String DIR_UP = "up";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27957a;
    ImageView b;
    ImageView c;
    TextView d;
    TextView e;
    private String f;
    private String g;
    private int h;
    private int i;
    private String j;
    private int k;
    private int l;
    private ValueAnimator m;
    private Context n;
    private FrameLayout o;
    private FrameLayout p;
    private LinearLayout q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: com.beizi.fusion.widget.ScrollClickView$a$a, reason: collision with other inner class name */
        public class C0330a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27959a;

            public C0330a(int i) {
                this.f27959a = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = ScrollClickView.this.b.getLayoutParams();
                    if (layoutParams instanceof FrameLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) layoutParams).topMargin = ScrollClickView.this.l - iIntValue;
                    }
                    ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.p.getLayoutParams();
                    if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                        layoutParams2.height = iIntValue - (this.f27959a / 3);
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                        layoutParams3.topMargin = ScrollClickView.this.l - layoutParams3.height;
                    }
                    ScrollClickView.this.o.requestLayout();
                } catch (Exception unused) {
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ScrollClickView scrollClickView = ScrollClickView.this;
                if (scrollClickView.o != null && scrollClickView.p != null) {
                    if (scrollClickView.b.getLayoutParams() == null) {
                        return;
                    }
                    int i = ScrollClickView.this.b.getLayoutParams().height;
                    ScrollClickView scrollClickView2 = ScrollClickView.this;
                    scrollClickView2.m = ValueAnimator.ofInt(i, scrollClickView2.l);
                    jh.c("ScrollClickUtil", "handHeight = " + i + ",scrollbarHeight = " + ScrollClickView.this.l);
                    ViewGroup.LayoutParams layoutParams = ScrollClickView.this.c.getLayoutParams();
                    StringBuilder sb = new StringBuilder();
                    sb.append("handHeight = ");
                    sb.append(i);
                    jh.c("ScrollClickUtil", sb.toString());
                    if (layoutParams != null) {
                        layoutParams.height = ScrollClickView.this.l;
                    }
                    ScrollClickView.this.m.setDuration(1000L);
                    ScrollClickView.this.m.setRepeatCount(-1);
                    ScrollClickView.this.m.setRepeatMode(1);
                    ScrollClickView.this.m.addUpdateListener(new C0330a(i));
                    return;
                }
                jh.c("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
            } catch (Exception unused) {
            }
        }
    }

    public class b implements Runnable {

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27961a;

            public a(int i) {
                this.f27961a = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = ScrollClickView.this.o.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = iIntValue;
                    }
                    ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.p.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = iIntValue - (this.f27961a / 3);
                    }
                    ScrollClickView.this.o.requestLayout();
                } catch (Exception unused) {
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ScrollClickView scrollClickView = ScrollClickView.this;
                if (scrollClickView.o != null && scrollClickView.p != null) {
                    if (scrollClickView.b.getLayoutParams() == null) {
                        return;
                    }
                    int i = ScrollClickView.this.b.getLayoutParams().height;
                    ScrollClickView scrollClickView2 = ScrollClickView.this;
                    scrollClickView2.m = ValueAnimator.ofInt(i, scrollClickView2.l);
                    ViewGroup.LayoutParams layoutParams = ScrollClickView.this.c.getLayoutParams();
                    jh.c("ScrollClickUtil", "handHeight = " + i);
                    if (layoutParams != null) {
                        layoutParams.height = ScrollClickView.this.l;
                    }
                    ScrollClickView.this.m.setDuration(1000L);
                    ScrollClickView.this.m.setRepeatCount(-1);
                    ScrollClickView.this.m.setRepeatMode(1);
                    ScrollClickView.this.m.addUpdateListener(new a(i));
                    return;
                }
                jh.c("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
            } catch (Exception unused) {
            }
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27957a = false;
        this.j = DIR_UP;
        this.k = 45;
        this.l = 180;
        this.q = null;
        init(context);
    }

    private void a() {
        try {
            this.b.post(new b());
        } catch (Exception unused) {
        }
    }

    private void b() {
        try {
            this.b.post(new a());
        } catch (Exception unused) {
        }
    }

    public void buildRealView() {
        try {
            if (DIR_UP.equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n).inflate(R.layout.beizi_layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n).inflate(R.layout.beizi_layout_scrollview_down, this);
            }
        } catch (Throwable unused) {
            if (DIR_UP.equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n.getApplicationContext()).inflate(R.layout.beizi_layout_scrollview_up, this);
            } else if (DIR_DOWN.equalsIgnoreCase(this.j)) {
                this.q = (LinearLayout) LayoutInflater.from(this.n.getApplicationContext()).inflate(R.layout.beizi_layout_scrollview_down, this);
            }
        }
        try {
            LinearLayout linearLayout = this.q;
            if (linearLayout == null) {
                return;
            }
            this.b = (ImageView) linearLayout.findViewById(R.id.hand);
            this.c = (ImageView) this.q.findViewById(R.id.scrollbar);
            this.d = (TextView) this.q.findViewById(R.id.title);
            this.e = (TextView) this.q.findViewById(R.id.details);
            this.o = (FrameLayout) this.q.findViewById(R.id.scroll_container);
            this.p = (FrameLayout) this.q.findViewById(R.id.scrollbar_container);
            this.k = so.a(this.n, this.k);
            this.l = so.a(this.n, this.l) + this.k;
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(this.f);
                this.d.setTextSize(2, this.h);
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setText(this.g);
                this.e.setTextSize(2, this.i);
            }
            ImageView imageView = this.b;
            if (imageView == null || this.c == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
            if (layoutParams != null) {
                int i = this.k;
                layoutParams.width = i;
                layoutParams.height = i;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.l;
                    layoutParams2.width = (int) (i * 0.55f);
                }
            }
            if (DIR_DOWN.equalsIgnoreCase(this.j)) {
                a();
            } else if (DIR_UP.equalsIgnoreCase(this.j)) {
                b();
            } else {
                if ("left".equalsIgnoreCase(this.j)) {
                    return;
                }
                "right".equalsIgnoreCase(this.j);
            }
        } catch (Exception unused2) {
        }
    }

    public void init(Context context) {
        if (this.f27957a) {
            return;
        }
        this.n = context;
        this.f27957a = true;
    }

    public void setDetailText(String str) {
        this.g = str;
    }

    public void setDetailsFont(int i) {
        this.i = i;
    }

    public void setHandWidth(int i) {
        this.k = i;
    }

    public void setScrollDirection(String str) {
        this.j = str;
    }

    public void setScrollbarHeight(int i) {
        this.l = i;
    }

    public void setTitleFont(int i) {
        this.h = i;
    }

    public void setTitleText(String str) {
        this.f = str;
    }

    public void startAnim() {
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        sb.append(this.m != null);
        jh.c("ScrollClickUtil", sb.toString());
        try {
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        } catch (Exception unused) {
        }
    }

    public void stopAnim() {
        try {
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.m.cancel();
            }
        } catch (Exception unused) {
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27957a = false;
        this.j = DIR_UP;
        this.k = 45;
        this.l = 180;
        this.q = null;
        init(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.f27957a = false;
        this.j = DIR_UP;
        this.k = 45;
        this.l = 180;
        this.q = null;
        init(context);
    }
}
