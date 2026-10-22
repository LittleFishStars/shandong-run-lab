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
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rd6<T> extends oq0 implements View.OnClickListener {
    public static final String f = "submit";
    public static final String g = "cancel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rv9<T> f44426a;

    public rd6(ar6 ar6Var) {
        super(ar6Var.f15346a);
        ((oq0) this).f18703a = ar6Var;
        y(ar6Var.f15346a);
    }

    public void A() {
        if (((oq0) this).f18703a.f15352a != null) {
            int[] iArrI = this.f44426a.i();
            ((oq0) this).f18703a.f15352a.a(iArrI[0], iArrI[1], iArrI[2], ((oq0) this).f18699a);
        }
    }

    public void B(List<T> list, List<T> list2, List<T> list3) {
        this.f44426a.w(false);
        this.f44426a.x(list, list2, list3);
        z();
    }

    public void C(List<T> list) {
        E(list, null, null);
    }

    public void D(List<T> list, List<List<T>> list2) {
        E(list, list2, null);
    }

    public void E(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f44426a.y(list, list2, list3);
        z();
    }

    public void F(int i) {
        ((oq0) this).f18703a.f15345a = i;
        z();
    }

    public void G(int i, int i2) {
        ar6 ar6Var = ((oq0) this).f18703a;
        ar6Var.f15345a = i;
        ar6Var.b = i2;
        z();
    }

    public void H(int i, int i2, int i3) {
        ar6 ar6Var = ((oq0) this).f18703a;
        ar6Var.f15345a = i;
        ar6Var.b = i2;
        ar6Var.c = i3;
        z();
    }

    public void I(String str) {
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
            A();
        } else if (str.equals("cancel") && (onClickListener = ((oq0) this).f18703a.f15348a) != null) {
            onClickListener.onClick(view);
        }
        f();
    }

    public final void y(Context context) {
        q();
        initViews();
        initAnim();
        initEvents();
        CustomListener customListener = ((oq0) this).f18703a.f15350a;
        if (customListener == null) {
            LayoutInflater.from(context).inflate(((oq0) this).f18703a.o, ((oq0) this).f18700a);
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
        LinearLayout linearLayout = (LinearLayout) i(R.id.optionspicker);
        linearLayout.setBackgroundColor(((oq0) this).f18703a.t);
        rv9<T> rv9Var = new rv9<>(linearLayout, ((oq0) this).f18703a.f15367d);
        this.f44426a = rv9Var;
        OnOptionsSelectChangeListener onOptionsSelectChangeListener = ((oq0) this).f18703a.f15351a;
        if (onOptionsSelectChangeListener != null) {
            rv9Var.setOptionsSelectChangeListener(onOptionsSelectChangeListener);
        }
        this.f44426a.B(((oq0) this).f18703a.x);
        this.f44426a.s(((oq0) this).f18703a.C);
        this.f44426a.m(((oq0) this).f18703a.f15379j);
        rv9<T> rv9Var2 = this.f44426a;
        ar6 ar6Var = ((oq0) this).f18703a;
        rv9Var2.t(ar6Var.f15356a, ar6Var.f15360b, ar6Var.f15363c);
        rv9<T> rv9Var3 = this.f44426a;
        ar6 ar6Var2 = ((oq0) this).f18703a;
        rv9Var3.C(ar6Var2.d, ar6Var2.e, ar6Var2.f);
        rv9<T> rv9Var4 = this.f44426a;
        ar6 ar6Var3 = ((oq0) this).f18703a;
        rv9Var4.p(ar6Var3.f15358a, ar6Var3.f15362b, ar6Var3.f15365c);
        this.f44426a.D(((oq0) this).f18703a.f15347a);
        setOutSideCancelable(((oq0) this).f18703a.f15375h);
        this.f44426a.q(((oq0) this).f18703a.A);
        this.f44426a.r(((oq0) this).f18703a.f15355a);
        this.f44426a.v(((oq0) this).f18703a.f40593a);
        this.f44426a.A(((oq0) this).f18703a.y);
        this.f44426a.z(((oq0) this).f18703a.z);
        this.f44426a.k(((oq0) this).f18703a.f15377i);
    }

    public final void z() {
        rv9<T> rv9Var = this.f44426a;
        if (rv9Var != null) {
            ar6 ar6Var = ((oq0) this).f18703a;
            rv9Var.n(ar6Var.f15345a, ar6Var.b, ar6Var.c);
        }
    }
}
