package com.kc.cw.ad.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.widget.ScrollClickView;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f38817a;
    int b;
    private Context c;
    private int d;
    private int e;
    private a f = null;
    private boolean g = false;
    private int h = 200;
    private com.kc.cw.ad.e.a i;

    @Keep
    public interface a {
        void a(com.kc.cw.ad.a.d dVar);
    }

    public k(Context context) {
        this.c = context;
    }

    public View a(int i, int i2, String str) {
        com.kc.cw.ad.d.b.f.a("ScrollClickUtil", "enter getScrollClick");
        if (this.c == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = "向上滑动跳转至\n第三方应用或详情页";
            }
            com.kc.cw.ad.e.a aVar = new com.kc.cw.ad.e.a(this.c);
            this.i = aVar;
            aVar.setScrollDirection(ScrollClickView.DIR_UP);
            this.i.setTitleText(str);
            int i3 = Integer.parseInt("35");
            int i4 = Integer.parseInt("56");
            float f = i / 360.0f;
            this.i.setTitleFont((int) (10.0f * f));
            this.i.setHandWidth((int) (i3 * f));
            this.i.setScrollbarHeight((int) (i4 * f));
            this.i.c();
            TextUtils.isEmpty("50%");
            String str2 = TextUtils.isEmpty("77%") ? "50%" : "77%";
            this.f38817a = (Integer.parseInt("50") * i) / 100;
            this.b = str2.endsWith("%") ? (Integer.parseInt(str2.substring(0, str2.indexOf("%"))) * i2) / 100 : Integer.parseInt(str2);
            this.f38817a = ViewUtil.dip2px(this.c, this.f38817a);
            this.b = ViewUtil.dip2px(this.c, this.b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.kc.cw.ad.d.b.f.a("ScrollClickUtil", "topInt = " + this.b + ",centerXInt = " + this.f38817a + ",adWidthDp = " + i + ",adHeightDp = " + i2);
            this.i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, i2, i, layoutParams) { // from class: com.kc.cw.ad.d.k.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final int f38818a;
                final int b;
                final FrameLayout.LayoutParams c;
                final k d;

                {
                    this.d = this;
                    this.f38818a = i2;
                    this.b = i;
                    this.c = layoutParams;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (this.d.i == null) {
                        return;
                    }
                    this.d.i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = this.d.i.getMeasuredWidth();
                    int measuredHeight = this.d.i.getMeasuredHeight();
                    k kVar = this.d;
                    if (kVar.b == 0) {
                        kVar.b = ViewUtil.dip2px(kVar.c, this.f38818a) / 2;
                    }
                    k kVar2 = this.d;
                    if (kVar2.f38817a == 0) {
                        kVar2.f38817a = ViewUtil.dip2px(kVar2.c, this.b) / 2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = this.c;
                    k kVar3 = this.d;
                    layoutParams2.topMargin = kVar3.b - (measuredHeight / 2);
                    layoutParams2.leftMargin = kVar3.f38817a - (measuredWidth / 2);
                    kVar3.i.setLayoutParams(this.c);
                    com.kc.cw.ad.d.b.f.a("ScrollClickUtil", "topMargin = " + this.c.topMargin + ",leftMargin = " + this.c.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
                }
            });
            this.i.setLayoutParams(layoutParams);
            this.i.postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.d.k.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final k f38819a;

                {
                    this.f38819a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f38819a.i != null) {
                        this.f38819a.i.a();
                    }
                }
            }, 10L);
            return this.i;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        a(1000);
        b(0);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void b() {
        this.g = false;
        com.kc.cw.ad.e.a aVar = this.i;
        if (aVar != null) {
            aVar.b();
        }
        this.f = null;
        this.c = null;
        this.i = null;
        this.h = 200;
    }

    public void b(int i) {
        this.e = i;
    }
}
