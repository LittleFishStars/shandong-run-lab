package com.kc.cw.ad.e;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.widget.ScrollClickView;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f38824a;
    ImageView b;
    TextView c;
    private boolean d;
    private String e;
    private int f;
    private String g;
    private int h;
    private int i;
    private ValueAnimator j;
    private Context k;
    private FrameLayout l;
    private FrameLayout m;
    private LinearLayout n;

    /* JADX INFO: renamed from: com.kc.cw.ad.e.a$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f38825a;

        public AnonymousClass1(a aVar) {
            this.f38825a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f38825a.l == null || this.f38825a.m == null) {
                f.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                return;
            }
            if (this.f38825a.f38824a.getLayoutParams() == null) {
                return;
            }
            int i = this.f38825a.f38824a.getLayoutParams().height;
            a aVar = this.f38825a;
            aVar.j = ValueAnimator.ofInt(i, aVar.i);
            f.b("ScrollClickUtil", "handHeight = " + i + ",scrollbarHeight = " + this.f38825a.i);
            ViewGroup.LayoutParams layoutParams = this.f38825a.b.getLayoutParams();
            StringBuilder sb = new StringBuilder();
            sb.append("handHeight = ");
            sb.append(i);
            f.b("ScrollClickUtil", sb.toString());
            if (layoutParams != null) {
                layoutParams.height = this.f38825a.i;
            }
            this.f38825a.j.setDuration(1000L);
            this.f38825a.j.setRepeatCount(-1);
            this.f38825a.j.setRepeatMode(1);
            this.f38825a.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i) { // from class: com.kc.cw.ad.e.a.1.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final int f38826a;
                final AnonymousClass1 b;

                {
                    this.b = this;
                    this.f38826a = i;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams2 = this.b.f38825a.f38824a.getLayoutParams();
                    if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) layoutParams2).topMargin = this.b.f38825a.i - iIntValue;
                    }
                    ViewGroup.LayoutParams layoutParams3 = this.b.f38825a.m.getLayoutParams();
                    if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                        layoutParams3.height = iIntValue - (this.f38826a / 3);
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                        layoutParams4.topMargin = this.b.f38825a.i - layoutParams4.height;
                    }
                    this.b.f38825a.l.requestLayout();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.e.a$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f38827a;

        public AnonymousClass2(a aVar) {
            this.f38827a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f38827a.l == null || this.f38827a.m == null) {
                f.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                return;
            }
            if (this.f38827a.f38824a.getLayoutParams() == null) {
                return;
            }
            int i = this.f38827a.f38824a.getLayoutParams().height;
            a aVar = this.f38827a;
            aVar.j = ValueAnimator.ofInt(i, aVar.i);
            ViewGroup.LayoutParams layoutParams = this.f38827a.b.getLayoutParams();
            f.b("ScrollClickUtil", "handHeight = " + i);
            if (layoutParams != null) {
                layoutParams.height = this.f38827a.i;
            }
            this.f38827a.j.setDuration(1000L);
            this.f38827a.j.setRepeatCount(-1);
            this.f38827a.j.setRepeatMode(1);
            this.f38827a.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i) { // from class: com.kc.cw.ad.e.a.2.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final int f38828a;
                final AnonymousClass2 b;

                {
                    this.b = this;
                    this.f38828a = i;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams2 = this.b.f38827a.l.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = iIntValue;
                    }
                    ViewGroup.LayoutParams layoutParams3 = this.b.f38827a.m.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.height = iIntValue - (this.f38828a / 3);
                    }
                    this.b.f38827a.l.requestLayout();
                }
            });
        }
    }

    public a(Context context) {
        super(context);
        this.d = false;
        this.f = 12;
        this.g = ScrollClickView.DIR_UP;
        this.h = 45;
        this.i = 180;
        this.n = null;
        a(context);
    }

    private void d() {
        this.f38824a.post(new AnonymousClass1(this));
    }

    private void e() {
        this.f38824a.post(new AnonymousClass2(this));
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        sb.append(this.j != null);
        f.b("ScrollClickUtil", sb.toString());
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void a(Context context) {
        if (this.d) {
            return;
        }
        this.k = context;
        this.d = true;
    }

    public void b() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.j.cancel();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    /* JADX WARN: Code duplicated, block: B:24:0x00cb  */
    public void c() {
        LayoutInflater layoutInflaterFrom;
        int i;
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout2;
        try {
            if (!ScrollClickView.DIR_UP.equalsIgnoreCase(this.g)) {
                if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.g)) {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(R.layout.ss_layout_scrollview_down, this);
                }
                linearLayout = this.n;
                if (linearLayout == null) {
                    return;
                }
                this.f38824a = (ImageView) linearLayout.findViewById(R.id.hand);
                this.b = (ImageView) this.n.findViewById(R.id.scrollbar);
                this.c = (TextView) this.n.findViewById(R.id.title);
                this.l = (FrameLayout) this.n.findViewById(R.id.scroll_container);
                this.m = (FrameLayout) this.n.findViewById(R.id.scrollbar_container);
                this.h = ViewUtil.dip2px(this.k, this.h);
                this.i = ViewUtil.dip2px(this.k, this.i) + this.h;
                textView = this.c;
                if (textView != null) {
                    textView.setText(this.e);
                    this.c.setTextSize(2, this.f);
                }
                imageView = this.f38824a;
                if (imageView != null || this.b == null) {
                }
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
                if (layoutParams != null) {
                    int i2 = this.h;
                    layoutParams.width = i2;
                    layoutParams.height = i2;
                    if (layoutParams2 != null) {
                        layoutParams2.height = this.i;
                        layoutParams2.width = (int) (i2 * 0.55f);
                    }
                }
                if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.g)) {
                    e();
                    return;
                } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.g)) {
                    d();
                    return;
                } else {
                    if ("left".equalsIgnoreCase(this.g)) {
                        return;
                    }
                    "right".equalsIgnoreCase(this.g);
                    return;
                }
            }
            linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(R.layout.ss_layout_scrollview_up, this);
            this.n = linearLayout2;
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.g)) {
                layoutInflaterFrom = LayoutInflater.from(this.k.getApplicationContext());
                i = R.layout.ss_layout_scrollview_up;
            } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.g)) {
                layoutInflaterFrom = LayoutInflater.from(this.k.getApplicationContext());
                i = R.layout.ss_layout_scrollview_down;
            }
            this.n = (LinearLayout) layoutInflaterFrom.inflate(i, this);
        }
        linearLayout = this.n;
        if (linearLayout == null) {
            return;
        }
        this.f38824a = (ImageView) linearLayout.findViewById(R.id.hand);
        this.b = (ImageView) this.n.findViewById(R.id.scrollbar);
        this.c = (TextView) this.n.findViewById(R.id.title);
        this.l = (FrameLayout) this.n.findViewById(R.id.scroll_container);
        this.m = (FrameLayout) this.n.findViewById(R.id.scrollbar_container);
        this.h = ViewUtil.dip2px(this.k, this.h);
        this.i = ViewUtil.dip2px(this.k, this.i) + this.h;
        textView = this.c;
        if (textView != null) {
            textView.setText(this.e);
            this.c.setTextSize(2, this.f);
        }
        imageView = this.f38824a;
        if (imageView != null) {
        }
    }

    public void setHandWidth(int i) {
        this.h = i;
    }

    public void setScrollDirection(String str) {
        this.g = str;
    }

    public void setScrollbarHeight(int i) {
        this.i = i;
    }

    public void setTitleFont(int i) {
        this.f = i;
    }

    public void setTitleText(String str) {
        this.e = str;
    }
}
