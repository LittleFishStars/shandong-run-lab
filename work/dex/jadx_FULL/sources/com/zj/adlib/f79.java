package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import java.text.ParseException;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f79 extends oq0 implements View.OnClickListener {
    public static final String f = "submit";
    public static final String g = "cancel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sv9 f41614a;

    public class a implements ISelectTimeCallback {
        public a() {
        }

        @Override // com.bigkoo.pickerview.listener.ISelectTimeCallback
        public void a() {
            try {
                ((oq0) f79.this).f18703a.f15353a.a(sv9.f44785a.parse(f79.this.f41614a.q()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public f79(ar6 ar6Var) {
        super(ar6Var.f15346a);
        ((oq0) this).f18703a = ar6Var;
        A(ar6Var.f15346a);
    }

    public final void A(Context context) {
        q();
        initViews();
        initAnim();
        CustomListener customListener = ((oq0) this).f18703a.f15350a;
        if (customListener == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, ((oq0) this).f18700a);
            TextView textView = (TextView) i(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
            Button button = (Button) i(R.id.btnSubmit);
            Button button2 = (Button) i(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(((oq0) this).f18703a.f15378j) ? context.getResources().getString(R.string.pickerview_submit) : ((oq0) this).f18703a.f15378j);
            button2.setText(TextUtils.isEmpty(((oq0) this).f18703a.f15380k) ? context.getResources().getString(R.string.pickerview_cancel) : ((oq0) this).f18703a.f15380k);
            textView.setText(TextUtils.isEmpty(((oq0) this).f18703a.f15381l) ? "" : ((oq0) this).f18703a.f15381l);
            button.setTextColor(((oq0) this).f18703a.q);
            button2.setTextColor(((oq0) this).f18703a.r);
            textView.setTextColor(((oq0) this).f18703a.s);
            relativeLayout.setBackgroundColor(((oq0) this).f18703a.u);
            button.setTextSize(((oq0) this).f18703a.v);
            button2.setTextSize(((oq0) this).f18703a.v);
            textView.setTextSize(((oq0) this).f18703a.w);
        } else {
            customListener.a(LayoutInflater.from(context).inflate(((oq0) this).f18703a.o, ((oq0) this).f18700a));
        }
        LinearLayout linearLayout = (LinearLayout) i(R.id.timepicker);
        linearLayout.setBackgroundColor(((oq0) this).f18703a.t);
        B(linearLayout);
    }

    public final void B(LinearLayout linearLayout) {
        int i;
        ar6 ar6Var = ((oq0) this).f18703a;
        sv9 sv9Var = new sv9(linearLayout, ar6Var.f15359a, ar6Var.p, ar6Var.x);
        this.f41614a = sv9Var;
        if (((oq0) this).f18703a.f15353a != null) {
            sv9Var.K(new a());
        }
        this.f41614a.F(((oq0) this).f18703a.f15371f);
        ar6 ar6Var2 = ((oq0) this).f18703a;
        int i2 = ar6Var2.g;
        if (i2 != 0 && (i = ar6Var2.h) != 0 && i2 <= i) {
            H();
        }
        ar6 ar6Var3 = ((oq0) this).f18703a;
        Calendar calendar = ar6Var3.f15361b;
        if (calendar == null || ar6Var3.f15364c == null) {
            if (calendar == null) {
                Calendar calendar2 = ar6Var3.f15364c;
                if (calendar2 != null && calendar2.get(1) > 2100) {
                    throw new IllegalArgumentException("The endDate should not be later than 2100");
                }
                G();
            } else {
                if (calendar.get(1) < 1900) {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
                G();
            }
        } else {
            if (calendar.getTimeInMillis() > ((oq0) this).f18703a.f15364c.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            G();
        }
        I();
        sv9 sv9Var2 = this.f41614a;
        ar6 ar6Var4 = ((oq0) this).f18703a;
        sv9Var2.C(ar6Var4.f15366d, ar6Var4.f15368e, ar6Var4.f15370f, ar6Var4.f15372g, ar6Var4.f15374h, ar6Var4.f15376i);
        sv9 sv9Var3 = this.f41614a;
        ar6 ar6Var5 = ((oq0) this).f18703a;
        sv9Var3.P(ar6Var5.i, ar6Var5.j, ar6Var5.k, ar6Var5.l, ar6Var5.m, ar6Var5.n);
        this.f41614a.B(((oq0) this).f18703a.C);
        this.f41614a.u(((oq0) this).f18703a.f15379j);
        setOutSideCancelable(((oq0) this).f18703a.f15375h);
        this.f41614a.x(((oq0) this).f18703a.f15369e);
        this.f41614a.y(((oq0) this).f18703a.A);
        this.f41614a.z(((oq0) this).f18703a.f15355a);
        this.f41614a.D(((oq0) this).f18703a.f40593a);
        this.f41614a.O(((oq0) this).f18703a.y);
        this.f41614a.N(((oq0) this).f18703a.z);
        this.f41614a.s(((oq0) this).f18703a.f15377i);
    }

    public boolean C() {
        return this.f41614a.t();
    }

    public void D() {
        if (((oq0) this).f18703a.f15354a != null) {
            try {
                ((oq0) this).f18703a.f15354a.a(sv9.f44785a.parse(this.f41614a.q()), ((oq0) this).f18699a);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void E(Calendar calendar) {
        ((oq0) this).f18703a.f15357a = calendar;
        I();
    }

    public void F(boolean z) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sv9.f44785a.parse(this.f41614a.q()));
            int i = calendar.get(1);
            int i2 = calendar.get(2);
            int i3 = calendar.get(5);
            int i4 = calendar.get(11);
            int i5 = calendar.get(12);
            int i6 = calendar.get(13);
            this.f41614a.F(z);
            sv9 sv9Var = this.f41614a;
            ar6 ar6Var = ((oq0) this).f18703a;
            sv9Var.C(ar6Var.f15366d, ar6Var.f15368e, ar6Var.f15370f, ar6Var.f15372g, ar6Var.f15374h, ar6Var.f15376i);
            this.f41614a.H(i, i2, i3, i4, i5, i6);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public final void G() {
        sv9 sv9Var = this.f41614a;
        ar6 ar6Var = ((oq0) this).f18703a;
        sv9Var.I(ar6Var.f15361b, ar6Var.f15364c);
        z();
    }

    public final void H() {
        this.f41614a.M(((oq0) this).f18703a.g);
        this.f41614a.A(((oq0) this).f18703a.h);
    }

    public final void I() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = ((oq0) this).f18703a.f15357a;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = calendar2.get(1);
            i2 = ((oq0) this).f18703a.f15357a.get(2);
            i3 = ((oq0) this).f18703a.f15357a.get(5);
            i4 = ((oq0) this).f18703a.f15357a.get(11);
            i5 = ((oq0) this).f18703a.f15357a.get(12);
            i6 = ((oq0) this).f18703a.f15357a.get(13);
        }
        int i7 = i4;
        int i8 = i3;
        int i9 = i2;
        sv9 sv9Var = this.f41614a;
        sv9Var.H(i, i9, i8, i7, i5, i6);
    }

    public void J(String str) {
        TextView textView = (TextView) i(R.id.tvTitle);
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.zj.adlib.oq0
    public boolean n() {
        return ((oq0) this).f18703a.f15373g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            D();
        } else if (str.equals("cancel") && (onClickListener = ((oq0) this).f18703a.f15348a) != null) {
            onClickListener.onClick(view);
        }
        f();
    }

    public final void z() {
        ar6 ar6Var = ((oq0) this).f18703a;
        Calendar calendar = ar6Var.f15361b;
        if (calendar == null || ar6Var.f15364c == null) {
            if (calendar != null) {
                ar6Var.f15357a = calendar;
                return;
            }
            Calendar calendar2 = ar6Var.f15364c;
            if (calendar2 != null) {
                ar6Var.f15357a = calendar2;
                return;
            }
            return;
        }
        Calendar calendar3 = ar6Var.f15357a;
        if (calendar3 == null || calendar3.getTimeInMillis() < ((oq0) this).f18703a.f15361b.getTimeInMillis() || ((oq0) this).f18703a.f15357a.getTimeInMillis() > ((oq0) this).f18703a.f15364c.getTimeInMillis()) {
            ar6 ar6Var2 = ((oq0) this).f18703a;
            ar6Var2.f15357a = ar6Var2.f15361b;
        }
    }
}
