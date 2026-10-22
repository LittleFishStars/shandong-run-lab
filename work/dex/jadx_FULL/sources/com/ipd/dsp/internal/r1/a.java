package com.ipd.dsp.internal.r1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.e1.l;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class a extends com.ipd.dsp.internal.x1.c {
    public int g;
    public int h;
    public final boolean i;
    public final boolean j;
    public boolean k;
    public final boolean l;
    public FrameLayout m;
    public ImageView n;
    public TextView o;
    public ImageView p;
    public InterfaceC0916a q;
    public com.ipd.dsp.internal.s1.i r;
    public TextView s;
    public com.ipd.dsp.internal.s1.d t;
    public com.ipd.dsp.internal.s1.g u;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.r1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0916a {
        void a();

        void a(Map<String, Object> map);

        void a(boolean z);
    }

    public a(Context context, boolean z, float f, boolean z2, boolean z3, boolean z4, com.ipd.dsp.internal.e1.h hVar) {
        super(context);
        this.i = z;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        if (!z) {
            int iA = (int) (s.a(context) * 0.75f);
            this.g = iA;
            this.h = (int) (iA * f);
        }
        b(getContext(), hVar);
    }

    public final View a(Context context, com.ipd.dsp.internal.e1.h hVar) {
        int iA = (int) s.a(context, 12.0f);
        int iA2 = (int) s.a(context, 16.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388693;
        layoutParams.bottomMargin = iA;
        layoutParams.setMarginEnd(iA2);
        com.ipd.dsp.internal.s1.a aVar = new com.ipd.dsp.internal.s1.a(context);
        aVar.setLayoutParams(layoutParams);
        aVar.a(hVar);
        return aVar;
    }

    public void b(Context context, com.ipd.dsp.internal.e1.h hVar) {
        this.m = new FrameLayout(context);
        this.u = new com.ipd.dsp.internal.s1.g(context);
        if (this.i) {
            this.m.setBackgroundColor(-16777216);
            this.m.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.m);
            if (this.j) {
                addView(e(context));
            }
            if (this.l) {
                addView(b(context));
            }
            addView(c(context));
            addView(a(getContext()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            addView(this.u, layoutParams);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.g, this.h + ((int) s.a(context, 35.0f)));
            layoutParams2.gravity = 17;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(this.g, 0);
            layoutParams3.weight = 1.0f;
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(layoutParams3);
            frameLayout.setBackgroundResource(R.drawable.ipd_bg_light);
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.m = frameLayout2;
            frameLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, -1));
            if (this.j) {
                frameLayout.addView(e(context));
            }
            if (this.l) {
                frameLayout.addView(b(context));
            }
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = (int) s.a(context, -8.0f);
            linearLayout.addView(c(context));
            linearLayout.addView(frameLayout);
            linearLayout.addView(this.u, layoutParams4);
            addView(linearLayout);
        }
        addView(a(context, hVar));
        if (this.l) {
            addView(d(context));
        }
    }

    public final /* synthetic */ void c(View view) {
        boolean z = this.k;
        this.k = !z;
        this.n.setImageResource(!z ? R.drawable.ipd_volume_off : R.drawable.ipd_volume_on);
        InterfaceC0916a interfaceC0916a = this.q;
        if (interfaceC0916a != null) {
            interfaceC0916a.a(this.k);
        }
    }

    public final View d(Context context) {
        com.ipd.dsp.internal.s1.i iVar = new com.ipd.dsp.internal.s1.i(context);
        this.r = iVar;
        return iVar;
    }

    public final View e(Context context) {
        int iA = (int) s.a(context, 5.0f);
        int iA2 = (int) s.a(context, 15.0f);
        int i = iA2 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.setMargins(iA2, iA2, iA2, iA2);
        ImageView imageView = new ImageView(context);
        this.n = imageView;
        imageView.setLayoutParams(layoutParams);
        this.n.setPadding(iA, iA, iA, iA);
        this.n.setBackgroundResource(R.drawable.ipd_bg_circle);
        this.n.setImageResource(this.k ? R.drawable.ipd_volume_off : R.drawable.ipd_volume_on);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.tea
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44903a.c(view);
            }
        });
        return this.n;
    }

    public boolean i() {
        ImageView imageView = this.p;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void j() {
        if (i()) {
            this.p.performClick();
        }
    }

    public void k() {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.t = null;
        super.onDetachedFromWindow();
    }

    public void setEndCardCTABtnText(String str) {
        com.ipd.dsp.internal.s1.d dVar = this.t;
        if (dVar == null || dVar.getVisibility() != 0) {
            return;
        }
        this.t.setCTABtnText(str);
    }

    public void setOnClickListener(InterfaceC0916a interfaceC0916a) {
        this.q = interfaceC0916a;
    }

    public void setVolumeBtnVisibility(boolean z) {
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final View c(Context context) {
        ViewGroup.LayoutParams layoutParams;
        int iA = (int) s.a(context, 5.0f);
        int iA2 = (int) s.a(context, 15.0f);
        if (this.i) {
            int i = iA2 * 2;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = GravityCompat.END;
            layoutParams2.setMargins(iA2, iA2, iA2, iA2);
            layoutParams = layoutParams2;
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = GravityCompat.END;
            layoutParams3.setMargins(0, 0, iA, iA);
            layoutParams = layoutParams3;
        }
        ImageView imageView = new ImageView(context);
        this.p = imageView;
        imageView.setLayoutParams(layoutParams);
        this.p.setVisibility(4);
        this.p.setPadding(iA, iA, iA, iA);
        this.p.setBackgroundResource(R.drawable.ipd_bg_circle);
        this.p.setImageResource(R.drawable.ipd_close);
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dea
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41164a.b(view);
            }
        });
        return this.p;
    }

    public final View a(Context context) {
        int iA = (int) s.a(context, 10.0f);
        int iA2 = (int) s.a(context, 15.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((iA2 * 5) + iA, iA2 * 2);
        layoutParams.gravity = GravityCompat.END;
        layoutParams.setMargins(0, iA2, ((int) s.a(context, 50.0f)) + (this.l ? iA * 3 : 0), 0);
        TextView textView = new TextView(context);
        this.s = textView;
        textView.setLayoutParams(layoutParams);
        int i = iA / 2;
        this.s.setPadding(i, 0, i, 0);
        this.s.setBackground(new com.ipd.dsp.internal.u1.a.C0921a().c(iA).a(Color.parseColor("#77000000")).a());
        this.s.setGravity(17);
        this.s.setTextColor(-1);
        this.s.setText("查看详情 >");
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.eda
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f41412a.a(view);
            }
        });
        return this.s;
    }

    public void c(int i) {
        TextView textView = this.o;
        if (textView != null) {
            if (i < 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            this.o.setText(String.valueOf(i));
        }
    }

    public final /* synthetic */ void a(View view) {
        InterfaceC0916a interfaceC0916a = this.q;
        if (interfaceC0916a != null) {
            interfaceC0916a.a(getTouchCoordsMap());
        }
    }

    public void a(String str, String str2, com.ipd.dsp.internal.s1.i.a aVar) {
        TextView textView;
        if (this.r == null || (textView = this.o) == null) {
            return;
        }
        try {
            this.r.a(Integer.parseInt(textView.getText().toString()), str, str2, aVar);
        } catch (Throwable unused) {
        }
    }

    public void a(com.ipd.dsp.internal.e1.d dVar, Bitmap bitmap) {
        if (this.m == null) {
            return;
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.o;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.s;
        if (textView2 != null && textView2.getVisibility() == 0 && this.l) {
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginEnd(marginLayoutParams.getMarginEnd() - ((int) s.a(getContext(), 30.0f)));
                this.s.setLayoutParams(layoutParams);
            }
        }
        com.ipd.dsp.internal.s1.d dVar2 = new com.ipd.dsp.internal.s1.d(getContext(), this.i, this.m.getWidth(), this.m.getHeight(), dVar, bitmap, new com.ipd.dsp.internal.s1.d.a() { // from class: com.zj.adlib.dfa
            @Override // com.ipd.dsp.internal.s1.d.a
            public final void a(Map map) {
                this.f41175a.a(map);
            }
        });
        this.t = dVar2;
        this.m.addView(dVar2);
    }

    public final View b(Context context) {
        int iA = (int) s.a(context, 15.0f);
        int i = iA * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = GravityCompat.END;
        if (this.i) {
            layoutParams.setMargins(0, iA, (int) s.a(context, 50.0f), 0);
        } else {
            layoutParams.setMargins(iA, iA, iA, iA);
        }
        TextView textView = new TextView(context);
        this.o = textView;
        textView.setLayoutParams(layoutParams);
        this.o.setBackgroundResource(R.drawable.ipd_bg_circle);
        this.o.setGravity(17);
        this.o.setTextColor(-1);
        this.o.setVisibility(8);
        return this.o;
    }

    public final /* synthetic */ void a(Map map) {
        InterfaceC0916a interfaceC0916a = this.q;
        if (interfaceC0916a != null) {
            interfaceC0916a.a((Map<String, Object>) map);
        }
    }

    public void a(l lVar) {
        com.ipd.dsp.internal.s1.g gVar = this.u;
        if (gVar != null) {
            gVar.a(lVar, !this.i ? 1 : 0);
        }
    }

    public final /* synthetic */ void b(View view) {
        InterfaceC0916a interfaceC0916a = this.q;
        if (interfaceC0916a != null) {
            interfaceC0916a.a();
        }
    }
}
