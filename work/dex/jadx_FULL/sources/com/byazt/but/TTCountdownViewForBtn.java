package com.byazt.but;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.dna.qp;
import com.byazt.nr.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 672, 673})
public class TTCountdownViewForBtn extends LinearLayout implements qp.c, uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f28332a;
    public final d c;
    public boolean i;
    public c n;
    public int sp;
    public Context tt;
    public TextView uj;
    public TextView ve;
    public int x;

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.f28332a = new AtomicBoolean(true);
        this.c = new d(Looper.getMainLooper(), this);
        this.sp = 5;
        this.x = 1;
        this.i = false;
        this.tt = context;
        uj();
    }

    private void a() {
        try {
            if (this.i || this.ve == null) {
                return;
            }
            sp();
            int i = this.x;
            if (i < this.sp + 1) {
                this.x = i + 1;
                this.c.sendEmptyMessageDelayed(1, 1000L);
            } else {
                c cVar = this.n;
                if (cVar != null) {
                    cVar.c();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void n() {
        d dVar = this.c;
        if (dVar != null) {
            dVar.removeMessages(1);
        }
        this.x = 1;
    }

    private void sp() {
        if (this.ve != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.x;
            int i2 = this.sp;
            sb.append(i <= i2 ? i2 - i : 0);
            sb.append("s");
            this.ve.setText(sb.toString());
        }
    }

    private void uj() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int iVe = pf.ve(this.tt, 14.0f);
        gradientDrawable.setCornerRadius(iVe);
        int i = iVe * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.ve = new TextView(this.tt);
        int iVe2 = pf.ve(this.tt, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.ve.setTextColor(-1);
        this.ve.setTextSize(2, 14.0f);
        addView(this.ve, layoutParams);
        View view = new View(this.tt);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = pf.ve(this.tt, 1.0f);
        layoutParams2.height = pf.ve(this.tt, 12.0f);
        layoutParams2.leftMargin = iVe2;
        layoutParams2.rightMargin = iVe2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.uj = new TextView(this.tt);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.uj.setTextColor(-1);
        this.uj.setTextSize(2, 14.0f);
        this.uj.setText("跳过");
        addView(this.uj, layoutParams3);
    }

    @Override // com.byazt.but.uj
    public void c() {
        if (this.i) {
            return;
        }
        n();
        a();
    }

    @Override // com.byazt.but.uj
    public View getView() {
        return this;
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        n();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f28332a.set(z);
        if (this.i) {
            return;
        }
        if (this.f28332a.get()) {
            ve();
        } else {
            tt();
        }
    }

    @Override // com.byazt.but.uj
    public void setCountDownTime(int i) {
        this.sp = i;
        sp();
        n();
    }

    @Override // com.byazt.but.uj
    public void setCountdownListener(c cVar) {
        this.n = cVar;
        this.f28332a.get();
    }

    public void tt() {
        try {
            d dVar = this.c;
            if (dVar != null) {
                dVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    public void ve() {
        try {
            a();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.but.uj
    public void c(boolean z) {
        this.i = z;
        if (z) {
            n();
        }
    }
}
