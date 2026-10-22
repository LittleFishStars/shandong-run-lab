package com.acse.ottn.animator;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.acse.ottn.R;
import com.acse.ottn.a5;
import com.acse.ottn.b0;
import com.acse.ottn.j;
import com.acse.ottn.v4;
import com.acse.ottn.z2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SwitchOnAnimSmallView extends FrameLayout {
    public static final int g = 300;
    public static final int h = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f22856a;
    public ImageView b;
    public ImageView c;
    public float d;
    public float e;
    public boolean f;

    public class a extends b0 {

        /* JADX INFO: renamed from: com.acse.ottn.animator.SwitchOnAnimSmallView$a$a, reason: collision with other inner class name */
        public class RunnableC0093a implements Runnable {

            /* JADX INFO: renamed from: com.acse.ottn.animator.SwitchOnAnimSmallView$a$a$a, reason: collision with other inner class name */
            public class RunnableC0094a implements Runnable {
                public RunnableC0094a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SwitchOnAnimSmallView.this.c != null) {
                        SwitchOnAnimSmallView.this.c.setBackgroundResource(R.mipmap.finger_normal);
                    }
                    SwitchOnAnimSmallView.this.d();
                }
            }

            public RunnableC0093a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimSmallView.this.b == null || SwitchOnAnimSmallView.this.f22856a == null) {
                    return;
                }
                SwitchOnAnimSmallView.this.b.setBackgroundResource(R.mipmap.switch_on_circle_point);
                SwitchOnAnimSmallView.this.c();
                SwitchOnAnimSmallView.this.f22856a.postDelayed(new RunnableC0094a(), 100L);
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.b0, com.acse.ottn.j.a
        public void b(j jVar) {
            if (SwitchOnAnimSmallView.this.c == null || SwitchOnAnimSmallView.this.f22856a == null) {
                return;
            }
            SwitchOnAnimSmallView.this.c.setBackgroundResource(R.mipmap.finger_click);
            SwitchOnAnimSmallView.this.f22856a.postDelayed(new RunnableC0093a(), 200L);
        }
    }

    public class b extends b0 {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimSmallView.this.f) {
                    return;
                }
                SwitchOnAnimSmallView.this.b();
            }
        }

        public b() {
        }

        @Override // com.acse.ottn.b0, com.acse.ottn.j.a
        public void b(j jVar) {
            SwitchOnAnimSmallView.this.f22856a.postDelayed(new a(), 1000L);
        }
    }

    public SwitchOnAnimSmallView(Context context) {
        this(context, null);
    }

    public void setFingerVisible(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public SwitchOnAnimSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22856a = new Handler();
        this.f = false;
        LayoutInflater.from(context).inflate(R.layout.finger_switch_on_guide_small_layout, (ViewGroup) this, true);
        a();
    }

    public final void a() {
        this.b = (ImageView) findViewById(R.id.switch_anim_circle_point);
        this.c = (ImageView) findViewById(R.id.finger_switch);
        this.d = a5.a(getContext(), 8.0f);
        this.e = a5.a(getContext(), 5.0f);
    }

    public void b() {
        this.f = false;
        v4.i(this.b, 0.0f);
        this.b.setBackgroundResource(R.mipmap.switch_off_circle_point);
        this.c.setBackgroundResource(R.mipmap.finger_normal);
        e();
    }

    public final void c() {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        z2 z2VarA = z2.a(imageView, "translationX", 0.0f, this.e);
        z2VarA.a(500L);
        z2VarA.k();
    }

    public final void d() {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        z2 z2VarA = z2.a(imageView, "translationY", -this.d, 0.0f);
        z2VarA.a(300L);
        z2VarA.a((j.a) new b());
        z2VarA.k();
    }

    public final void e() {
        z2 z2VarA = z2.a(this.c, "translationY", 0.0f, -this.d);
        z2VarA.a(300L);
        z2VarA.a((j.a) new a());
        z2VarA.k();
    }

    public void f() {
        this.f = true;
    }
}
