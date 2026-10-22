package com.huachenjie.common.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyf.immersionbar.e;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.ShadowLayout;
import com.zj.adlib.c67;
import com.zj.adlib.dx4;
import com.zj.adlib.fv5;
import com.zj.adlib.rh3;
import com.zj.adlib.yr9;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.lifecycle.ILifeCycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements ILifeCycle, BaseView, SideTextInterface {
    public static final int K = 0;
    public TextView A;
    public TextView B;
    public TextView C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f33634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f8485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Toolbar f8486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public T f8487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dx4 f8488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8489a;
    public Dialog b;
    public Activity c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Dialog f8490c;
    public Dialog d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ImageView f8491d;
    public ImageView n;
    public TextView p;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            BaseActivity.this.onBackPressed();
        }
    }

    private void c0() {
        T t = (T) initPresenter();
        this.f8487a = t;
        if (t != null) {
            t.a(this);
            this.f8487a.e();
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public int C() {
        return zn1.a(R.color.color_8997A4);
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public String H() {
        return null;
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
    public View S(int id) {
        return findViewById(id);
    }

    public View.OnClickListener T() {
        return new a();
    }

    @DrawableRes
    public int U() {
        return R.drawable.ic_back_black;
    }

    @ColorInt
    public int V() {
        return -1;
    }

    public View W() {
        return this.B;
    }

    public CharSequence X() {
        return "";
    }

    @ColorRes
    public int Y() {
        return R.color.white;
    }

    @ColorRes
    public int Z() {
        return R.color.black;
    }

    @ColorRes
    public int a0() {
        return R.color.black;
    }

    @ColorRes
    public int b0() {
        return R.color.white;
    }

    public void d0(@DrawableRes int bgId) {
        ImageView imageView = this.f8491d;
        if (imageView != null) {
            yr9.q(imageView, bgId);
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public void dismissLoadingDialogs() {
        if (isFinishing()) {
            return;
        }
        Dialog dialog = this.f33634a;
        if (dialog != null && dialog.isShowing()) {
            this.f33634a.dismiss();
        }
        Dialog dialog2 = this.b;
        if (dialog2 != null && dialog2.isShowing()) {
            this.b.dismiss();
        }
        Dialog dialog3 = this.f8490c;
        if (dialog3 != null && dialog3.isShowing()) {
            this.f8490c.dismiss();
            this.f8490c = null;
        }
        Dialog dialog4 = this.d;
        if (dialog4 == null || !dialog4.isShowing()) {
            return;
        }
        this.d.dismiss();
        this.d = null;
    }

    public void e0(@DrawableRes int iconId, @DrawableRes int bgId, View.OnClickListener listener) {
        TextView textView = this.B;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            if (imageView.getParent() != null && (this.n.getParent() instanceof ShadowLayout)) {
                ((ShadowLayout) this.n.getParent()).setVisibility(0);
            }
            this.n.setVisibility(0);
            yr9.r(this.n, iconId);
            yr9.q(this.n, bgId);
            this.n.setOnClickListener(listener);
        }
    }

    public void f0(@StringRes int resId, View.OnClickListener listener) {
        TextView textView = this.B;
        if (textView != null) {
            textView.setVisibility(0);
            yr9.v(this.B, resId);
            new c67(this.B, listener, null);
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.f8489a = true;
    }

    public void g0(CharSequence text, @ColorInt int textColor, View.OnClickListener listener) {
        TextView textView = this.B;
        if (textView != null) {
            textView.setVisibility(0);
            yr9.w(this.B, text.toString());
            this.B.setTextColor(textColor);
            new c67(this.B, listener, null);
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public abstract int getContentViewRes();

    @Override // com.huachenjie.common.base.BaseView
    public Context getContext() {
        return this.c;
    }

    public dx4 getLifeCycleObservable() {
        if (this.f8488a == null) {
            this.f8488a = dx4.a();
        }
        return this.f8488a;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    public void getServerData() {
    }

    public void h0() {
        e.p3(this).d3(this.f8486a).T2(false).u1(R.color.transparent).G1(false).a1();
    }

    public abstract void handleIntent(Intent intent);

    @Override // com.huachenjie.common.base.BaseView
    public void hideInputForce() {
        if (getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    public void i0(CharSequence title) {
        j0(title, true);
    }

    public abstract void initField();

    public T initPresenter() {
        return null;
    }

    public void initToolbar() {
        j0(X(), true);
        h0();
    }

    public abstract void initView();

    public void j0(CharSequence title, boolean isShowBack) {
        Toolbar toolbar = (Toolbar) S(R.id.toolbar);
        this.f8486a = toolbar;
        if (toolbar != null) {
            this.f8491d = (ImageView) S(R.id.img_back);
            this.p = (TextView) S(R.id.tv_title);
            this.A = (TextView) S(R.id.tv_sub_title);
            this.B = (TextView) S(R.id.tv_menu);
            this.n = (ImageView) S(R.id.img_menu);
            this.f8486a.setTitle("");
            this.f8486a.setBackgroundColor(ContextCompat.getColor(this.c, b0()));
            this.p.setTextColor(ContextCompat.getColor(this.c, a0()));
            yr9.w(this.p, title.toString());
            setSupportActionBar(this.f8486a);
            this.f8491d.setVisibility(isShowBack ? 0 : 8);
            this.f8491d.setImageResource(U());
            this.f8491d.getDrawable().setTint(V());
            this.f8491d.setOnClickListener(T());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        rh3.b(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        try {
            setRequestedOrientation(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8485a = this;
        this.c = this;
        if (getContentViewRes() != 0) {
            setContentView(getContentViewRes());
        }
        initField();
        if (getIntent() != null) {
            handleIntent(getIntent());
        }
        initToolbar();
        initView();
        c0();
        getServerData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dx4 dx4Var = this.f8488a;
        if (dx4Var != null) {
            dx4Var.b();
            this.f8488a = null;
        }
        T t = this.f8487a;
        if (t != null) {
            t.b(this);
            this.f8487a.d();
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    /* JADX INFO: renamed from: p */
    public TextView getSideTextView() {
        return this.C;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public void q(TextView view) {
        this.C = view;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return false;
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence title) {
        yr9.w(this.p, title.toString());
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(boolean cancelable) {
        if (isFinishing()) {
            return null;
        }
        if (cancelable) {
            if (this.f33634a == null) {
                this.f33634a = DialogUtil.p(this, true);
            }
            this.f33634a.show();
            return this.f33634a;
        }
        if (this.b == null) {
            this.b = DialogUtil.p(this, false);
        }
        this.b.show();
        return this.b;
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showToast(String text) {
        fv5.b(text);
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(String message, boolean cancelable) {
        if (isFinishing()) {
            return null;
        }
        if (cancelable) {
            Dialog dialogO = DialogUtil.o(this, message, true);
            this.f8490c = dialogO;
            dialogO.show();
            return this.f8490c;
        }
        Dialog dialogO2 = DialogUtil.o(this, message, false);
        this.d = dialogO2;
        dialogO2.show();
        return this.d;
    }
}
