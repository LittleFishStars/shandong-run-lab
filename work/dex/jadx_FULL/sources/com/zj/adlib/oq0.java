package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.listener.OnDismissListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class oq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f43807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f18696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f18699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f18700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Animation f18701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnDismissListener f18702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ar6 f18703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18704a;
    public ViewGroup b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Animation f18705b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18706b;
    public ViewGroup c;
    public int K = 80;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f18707c = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnKeyListener f18697a = new d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnTouchListener f18698a = new e();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            oq0.this.f();
        }
    }

    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            oq0.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oq0 oq0Var = oq0.this;
            oq0Var.f18703a.f15349a.removeView(oq0Var.b);
            oq0.this.f18706b = false;
            oq0.this.f18704a = false;
            if (oq0.this.f18702a != null) {
                oq0.this.f18702a.a(oq0.this);
            }
        }
    }

    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || !oq0.this.o()) {
                return false;
            }
            oq0.this.f();
            return true;
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            oq0.this.f();
            return false;
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (oq0.this.f18702a != null) {
                oq0.this.f18702a.a(oq0.this);
            }
        }
    }

    public oq0(Context context) {
        this.f18696a = context;
    }

    private Animation l() {
        return AnimationUtils.loadAnimation(this.f18696a, cr6.a(this.K, true));
    }

    private Animation m() {
        return AnimationUtils.loadAnimation(this.f18696a, cr6.a(this.K, false));
    }

    public void e() {
        if (this.c != null) {
            Dialog dialog = new Dialog(this.f18696a, R.style.custom_dialog2);
            this.f43807a = dialog;
            dialog.setCancelable(this.f18703a.f15375h);
            this.f43807a.setContentView(this.c);
            Window window = this.f43807a.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f43807a.setOnDismissListener(new f());
        }
    }

    public void f() {
        if (n()) {
            g();
            return;
        }
        if (this.f18704a) {
            return;
        }
        if (this.f18707c) {
            this.f18701a.setAnimationListener(new b());
            this.f18700a.startAnimation(this.f18701a);
        } else {
            h();
        }
        this.f18704a = true;
    }

    public final void g() {
        Dialog dialog = this.f43807a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void h() {
        this.f18703a.f15349a.post(new c());
    }

    public View i(int i) {
        return this.f18700a.findViewById(i);
    }

    public void initAnim() {
        this.f18705b = l();
        this.f18701a = m();
    }

    public void initEvents() {
    }

    public void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f18696a);
        if (n()) {
            ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.c = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.c.findViewById(R.id.content_container);
            this.f18700a = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.c.setOnClickListener(new a());
        } else {
            ar6 ar6Var = this.f18703a;
            if (ar6Var.f15349a == null) {
                ar6Var.f15349a = (ViewGroup) ((Activity) this.f18696a).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(R.layout.layout_basepickerview, this.f18703a.f15349a, false);
            this.b = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i = this.f18703a.B;
            if (i != -1) {
                this.b.setBackgroundColor(i);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.b.findViewById(R.id.content_container);
            this.f18700a = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        r(true);
    }

    public Dialog j() {
        return this.f43807a;
    }

    public ViewGroup k() {
        return this.f18700a;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        if (n()) {
            return false;
        }
        return this.b.getParent() != null || this.f18706b;
    }

    public final void p(View view) {
        this.f18703a.f15349a.addView(view);
        if (this.f18707c) {
            this.f18700a.startAnimation(this.f18705b);
        }
    }

    public void q() {
        Dialog dialog = this.f43807a;
        if (dialog != null) {
            dialog.setCancelable(this.f18703a.f15375h);
        }
    }

    public void r(boolean z) {
        ViewGroup viewGroup = n() ? this.c : this.b;
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.f18697a);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public oq0 s(OnDismissListener onDismissListener) {
        this.f18702a = onDismissListener;
        return this;
    }

    public oq0 setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            View viewFindViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                viewFindViewById.setOnTouchListener(this.f18698a);
            } else {
                viewFindViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void t() {
        if (n()) {
            x();
        } else {
            if (o()) {
                return;
            }
            this.f18706b = true;
            p(this.b);
            this.b.requestFocus();
        }
    }

    public void u(View view) {
        this.f18699a = view;
        t();
    }

    public void v(View view, boolean z) {
        this.f18699a = view;
        this.f18707c = z;
        t();
    }

    public void w(boolean z) {
        v(null, z);
    }

    public final void x() {
        Dialog dialog = this.f43807a;
        if (dialog != null) {
            dialog.show();
        }
    }
}
