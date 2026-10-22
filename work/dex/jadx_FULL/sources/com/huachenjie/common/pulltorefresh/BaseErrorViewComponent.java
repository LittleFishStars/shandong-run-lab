package com.huachenjie.common.pulltorefresh;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseComponent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class BaseErrorViewComponent<T> extends BaseComponent<T> {
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 2;
    public static final int P = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f33839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Button f8811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f8812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f8813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshClickListener f8814a;
    public View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Button f8815b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f8816b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f8817b;
    public View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ImageView f8818c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TextView f8819c;
    public TextView d;
    public TextView e;
    public TextView f;

    public interface OnRefreshClickListener {
        boolean a();
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (BaseErrorViewComponent.this.f8814a != null) {
                BaseErrorViewComponent.this.f8814a.a();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (BaseErrorViewComponent.this.f8814a != null) {
                BaseErrorViewComponent.this.f8814a.a();
            }
        }
    }

    public BaseErrorViewComponent(T context) {
        super(context);
    }

    public void A() {
        z(3);
    }

    public void B() {
        z(2);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    public void e() {
        z(0);
    }

    public void f(int resId) {
        if (resId != -1) {
            this.e.setText(b() == null ? "" : b().getString(resId));
        }
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f33839a = a(R.id.layout_data_empty_container);
        this.b = a(R.id.layout_load_error_container);
        this.c = a(R.id.layout_network_error_container);
        this.f8818c = (ImageView) a(R.id.img_data_empty);
        this.e = (TextView) a(R.id.tv_data_empty_desc);
        this.f = (TextView) a(R.id.tv_data_empty_sub_desc);
        this.f8812a = (ImageView) a(R.id.img_load_error);
        this.f8813a = (TextView) a(R.id.tv_load_error_desc);
        this.f8817b = (TextView) a(R.id.tv_load_error_sub_desc);
        this.f8811a = (Button) a(R.id.btn_load_error_refresh);
        this.f8816b = (ImageView) a(R.id.img_network_error);
        this.f8819c = (TextView) a(R.id.tv_network_error_desc);
        this.d = (TextView) a(R.id.tv_network_error_sub_desc);
        this.f8815b = (Button) a(R.id.btn_network_error_refresh);
    }

    public void g(String text) {
        TextView textView = this.e;
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        textView.setText(text);
    }

    public void h(int resId) {
        if (resId != -1) {
            this.f8818c.setImageResource(resId);
        }
    }

    public void i(Drawable drawable) {
        if (drawable != null) {
            this.f8818c.setImageDrawable(drawable);
        }
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
        Button button = this.f8811a;
        if (button != null) {
            button.setOnClickListener(new a());
        }
        Button button2 = this.f8815b;
        if (button2 != null) {
            button2.setOnClickListener(new b());
        }
    }

    public void j(int resId) {
        if (resId != -1) {
            this.f.setVisibility(0);
            this.f.setText(b() == null ? "" : b().getString(resId));
        }
    }

    public void k(String text) {
        this.f.setVisibility(TextUtils.isEmpty(text) ? 8 : 0);
        TextView textView = this.f;
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        textView.setText(text);
    }

    public void l(int resId) {
        if (resId != -1) {
            this.f8813a.setText(b() == null ? "" : b().getString(resId));
        }
    }

    public void m(String text) {
        TextView textView = this.f8813a;
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        textView.setText(text);
    }

    public void n(int resId) {
        if (resId != -1) {
            this.f8812a.setImageResource(resId);
        }
    }

    public void o(Drawable drawable) {
        if (drawable != null) {
            this.f8812a.setImageDrawable(drawable);
        }
    }

    public void p(int resId) {
        if (resId != -1) {
            this.f8817b.setVisibility(0);
            this.f8817b.setText(b() == null ? "" : b().getString(resId));
        }
    }

    public void q(String text) {
        this.f8817b.setVisibility(TextUtils.isEmpty(text) ? 8 : 0);
        TextView textView = this.f8817b;
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        textView.setText(text);
    }

    public void r(int resId) {
        if (resId != -1) {
            this.f8819c.setText(b() == null ? "" : b().getString(resId));
        }
    }

    public void s(String text) {
        TextView textView = this.f8819c;
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        textView.setText(text);
    }

    public void setOnRefreshClickListener(OnRefreshClickListener listener) {
        this.f8814a = listener;
    }

    public void t(int resId) {
        if (resId != -1) {
            this.f8816b.setImageResource(resId);
        }
    }

    public void u(Drawable drawable) {
        if (drawable != null) {
            this.f8816b.setImageDrawable(drawable);
        }
    }

    public void v(int resId) {
        if (resId != -1) {
            this.d.setVisibility(0);
            this.d.setText(b() == null ? "" : b().getString(resId));
        }
    }

    public void w(String text) {
        this.d.setVisibility(TextUtils.isEmpty(text) ? 8 : 0);
        TextView textView = this.d;
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        textView.setText(text);
    }

    public void y() {
        z(1);
    }

    public final void z(int errorType) {
        View view = this.f33839a;
        if (view != null) {
            view.setVisibility(1 == errorType ? 0 : 8);
        }
        View view2 = this.b;
        if (view2 != null) {
            view2.setVisibility(3 == errorType ? 0 : 8);
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(2 != errorType ? 8 : 0);
        }
    }
}
