package com.huachenjie.base.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.huachenjie.base.R;
import com.zj.adlib.pd6;
import com.zj.adlib.rd6;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class OptionsPickerHelper {
    public static final String d = "请选择";
    public static final String e = "取消";
    public static final String f = "保存";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnPickChangeListener f7347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTwoColumnPickChangeListener f7348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rd6 f7349a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f32999a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f7351a = Collections.emptyList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<String> f7353b = Collections.emptyList();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<String> f7354c = Collections.emptyList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7352a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f7350a = d;
    public String b = e;
    public String c = f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnOptionsSelectListener f7346a = new OnOptionsSelectListener() { // from class: com.zj.adlib.qd6
        @Override // com.bigkoo.pickerview.listener.OnOptionsSelectListener
        public final void a(int i, int i2, int i3, View view) {
            this.f44182a.h(i, i2, i3, view);
        }
    };

    public interface OnPickChangeListener {
        void a(int position, String value);
    }

    public interface OnTwoColumnPickChangeListener {
        void a(int firstPosition, int secondPosition, String firstValue, String secondValue);
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (OptionsPickerHelper.this.f7349a != null) {
                OptionsPickerHelper.this.f7349a.onClick(v);
            }
        }
    }

    public class b implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f33001a = "submit";
        public static final String b = "cancel";

        public b() {
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(View v) {
            OptionsPickerHelper.this.e(v);
            Button button = (Button) v.findViewById(R.id.btnSubmit);
            Button button2 = (Button) v.findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(OptionsPickerHelper.this.f32999a);
            button2.setOnClickListener(OptionsPickerHelper.this.f32999a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i, int i2, int i3, View view) {
        OnTwoColumnPickChangeListener onTwoColumnPickChangeListener;
        if (!this.f7352a) {
            if (i < 0 || i >= this.f7351a.size() || this.f7347a == null) {
                return;
            }
            this.f7347a.a(i, this.f7351a.get(i));
            return;
        }
        if (i < 0 || i >= this.f7353b.size() || i2 < 0 || i2 >= this.f7354c.size() || (onTwoColumnPickChangeListener = this.f7348a) == null) {
            return;
        }
        onTwoColumnPickChangeListener.a(i, i2, this.f7353b.get(i), this.f7354c.get(i2));
    }

    public final void e(View rootView) {
        if (rootView == null) {
            return;
        }
        TextView textView = (TextView) rootView.findViewById(R.id.tvTitle);
        TextView textView2 = (TextView) rootView.findViewById(R.id.btnCancel);
        TextView textView3 = (TextView) rootView.findViewById(R.id.btnSubmit);
        if (textView != null) {
            textView.setText(this.f7350a);
        }
        if (textView2 != null) {
            textView2.setText(this.b);
        }
        if (textView3 != null) {
            textView3.setText(this.c);
        }
    }

    public final int f(int index, int size) {
        if (size > 0 && index >= 0) {
            return Math.min(index, size - 1);
        }
        return 0;
    }

    public final rd6 g(Context context) {
        rd6 rd6Var = this.f7349a;
        if (rd6Var != null) {
            return rd6Var;
        }
        rd6 rd6VarB = new pd6(context, this.f7346a).r(R.layout.pickerview_custom_options, new b()).f(true).C(Color.parseColor("#191F20")).D(Color.parseColor("#979A9A")).n(Color.parseColor("#E8E8E8")).p(7).s(3.0f).k(16).b();
        this.f7349a = rd6VarB;
        return rd6VarB;
    }

    public void i() {
        rd6 rd6Var = this.f7349a;
        if (rd6Var != null && rd6Var.o()) {
            this.f7349a.f();
        }
        this.f7349a = null;
        this.f7347a = null;
        this.f7348a = null;
        this.f7351a = Collections.emptyList();
        this.f7353b = Collections.emptyList();
        this.f7354c = Collections.emptyList();
    }

    public final void j(String title, String cancel, String submit) {
        if (TextUtils.isEmpty(title)) {
            title = d;
        }
        this.f7350a = title;
        if (TextUtils.isEmpty(cancel)) {
            cancel = e;
        }
        this.b = cancel;
        if (TextUtils.isEmpty(submit)) {
            submit = f;
        }
        this.c = submit;
    }

    public final int k(List<String> source, String defaultValue) {
        if (source == null || source.isEmpty() || TextUtils.isEmpty(defaultValue)) {
            return 0;
        }
        return f(source.indexOf(defaultValue), source.size());
    }

    public void l(Context context, int defaultFirstIndex, int defaultSecondIndex, List<String> firstList, List<String> secondList, OnTwoColumnPickChangeListener listener) {
        m(context, defaultFirstIndex, defaultSecondIndex, firstList, secondList, null, null, null, listener);
    }

    public void m(Context context, int defaultFirstIndex, int defaultSecondIndex, List<String> firstList, List<String> secondList, String title, String cancel, String submit, OnTwoColumnPickChangeListener listener) {
        this.f7352a = true;
        this.f7347a = null;
        this.f7348a = listener;
        j(title, cancel, submit);
        if (firstList == null) {
            firstList = Collections.emptyList();
        }
        this.f7353b = firstList;
        if (secondList == null) {
            secondList = Collections.emptyList();
        }
        this.f7354c = secondList;
        if (this.f7353b.isEmpty() || this.f7354c.isEmpty()) {
            return;
        }
        int iF = f(defaultFirstIndex, this.f7353b.size());
        int iF2 = f(defaultSecondIndex, this.f7354c.size());
        g(context);
        this.f7349a.B(this.f7353b, this.f7354c, null);
        this.f7349a.G(iF, iF2);
        this.f7349a.t();
    }

    public void n(Context context, String defaultFirstValue, String defaultSecondValue, List<String> firstList, List<String> secondList, OnTwoColumnPickChangeListener listener) {
        o(context, defaultFirstValue, defaultSecondValue, firstList, secondList, null, null, null, listener);
    }

    public void o(Context context, String defaultFirstValue, String defaultSecondValue, List<String> firstList, List<String> secondList, String title, String cancel, String submit, OnTwoColumnPickChangeListener listener) {
        m(context, k(firstList, defaultFirstValue), k(secondList, defaultSecondValue), firstList, secondList, title, cancel, submit, listener);
    }

    public void p(Context context, String defaultValue, List<String> list, OnPickChangeListener listener) {
        q(context, defaultValue, list, null, null, null, listener);
    }

    public void q(Context context, String defaultValue, List<String> list, String title, String cancel, String submit, OnPickChangeListener listener) {
        this.f7352a = false;
        this.f7348a = null;
        this.f7347a = listener;
        j(title, cancel, submit);
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f7351a = list;
        if (list.isEmpty()) {
            return;
        }
        int iK = k(this.f7351a, defaultValue);
        g(context);
        this.f7349a.C(this.f7351a);
        this.f7349a.F(iK);
        this.f7349a.t();
    }
}
