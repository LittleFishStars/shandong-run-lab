package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ToastUtils f28200a = p();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WeakReference<IToast> f1401a = null;
    public static final String b = "TAG_TOAST";
    public static final String c = "toast null";
    public static final String d = "toast nothing";
    public static final int h = -16777217;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1402a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1406b = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f1408c = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f1409d = -16777217;
    public int e = -1;
    public int f = -16777217;
    public int g = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1404a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable[] f1405a = new Drawable[4];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1407b = false;

    public static abstract class AbsToast implements IToast {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f28201a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Toast f1410a = new Toast(Utils.a());

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ToastUtils f1411a;

        public AbsToast(ToastUtils toastUtils) {
            this.f1411a = toastUtils;
            if (toastUtils.f1402a == -1 && this.f1411a.f1406b == -1 && this.f1411a.f1408c == -1) {
                return;
            }
            this.f1410a.setGravity(this.f1411a.f1402a, this.f1411a.f1406b, this.f1411a.f1408c);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void a(CharSequence charSequence) {
            View viewX = this.f1411a.X(charSequence);
            if (viewX != null) {
                b(viewX);
                d();
                return;
            }
            View view = this.f1410a.getView();
            this.f28201a = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                b(i.G0(com.blankj.utilcode.R.layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f28201a.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.f1411a.f != -16777217) {
                textView.setTextColor(this.f1411a.f);
            }
            if (this.f1411a.g != -1) {
                textView.setTextSize(this.f1411a.g);
            }
            e(textView);
            d();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void b(View view) {
            this.f28201a = view;
            this.f1410a.setView(view);
        }

        public View c(int i) {
            Bitmap bitmapE1 = i.e1(this.f28201a);
            ImageView imageView = new ImageView(Utils.a());
            imageView.setTag(ToastUtils.b + i);
            imageView.setImageBitmap(bitmapE1);
            return imageView;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        @CallSuper
        public void cancel() {
            Toast toast = this.f1410a;
            if (toast != null) {
                toast.cancel();
            }
            this.f1410a = null;
            this.f28201a = null;
        }

        public final void d() {
            if (i.x0()) {
                b(c(-1));
            }
        }

        public final void e(TextView textView) {
            if (this.f1411a.e != -1) {
                this.f28201a.setBackgroundResource(this.f1411a.e);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.f1411a.f1409d != -16777217) {
                Drawable background = this.f28201a.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1411a.f1409d, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f1411a.f1409d, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f1411a.f1409d, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f28201a.setBackgroundColor(this.f1411a.f1409d);
                }
            }
        }
    }

    public interface IToast {
        void a(CharSequence charSequence);

        void b(View view);

        void cancel();

        void show(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MODE {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
    }

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        public static final int K = i.v(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i.J() - K, Integer.MIN_VALUE), i2);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtils.f1401a != null) {
                IToast iToast = (IToast) ToastUtils.f1401a.get();
                if (iToast != null) {
                    iToast.cancel();
                }
                ToastUtils.f1401a = null;
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f28202a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CharSequence f1413a;

        public b(View view, CharSequence charSequence, int i) {
            this.f28202a = view;
            this.f1413a = charSequence;
            this.K = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastUtils.l();
            IToast iToastQ = ToastUtils.q(ToastUtils.this);
            ToastUtils.f1401a = new WeakReference(iToastQ);
            View view = this.f28202a;
            if (view != null) {
                iToastQ.b(view);
            } else {
                iToastQ.a(this.f1413a);
            }
            iToastQ.show(this.K);
        }
    }

    public static final class c extends AbsToast {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f28203a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public IToast f1414a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Utils.a f1415a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.cancel();
            }
        }

        public class b extends Utils.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f28205a;

            public b(int i) {
                this.f28205a = i;
            }

            @Override // com.blankj.utilcode.util.Utils.a
            public void a(@NonNull Activity activity) {
                if (c.this.h()) {
                    c.this.k(activity, this.f28205a, false);
                }
            }
        }

        public c(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.AbsToast, com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            Window window;
            if (h()) {
                m();
                for (Activity activity : i.I()) {
                    if (i.o0(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ToastUtils.b);
                        sb.append(f28203a - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            IToast iToast = this.f1414a;
            if (iToast != null) {
                iToast.cancel();
                this.f1414a = null;
            }
            super.cancel();
        }

        public final boolean h() {
            return this.f1415a != null;
        }

        public final void i() {
            b bVar = new b(f28203a);
            this.f1415a = bVar;
            i.b(bVar);
        }

        public final IToast j(int i) {
            d dVar = new d(((AbsToast) this).f1411a);
            ((AbsToast) dVar).f1410a = ((AbsToast) this).f1410a;
            dVar.show(i);
            return dVar;
        }

        public final void k(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = ((AbsToast) this).f1410a.getGravity();
                layoutParams.bottomMargin = ((AbsToast) this).f1410a.getYOffset() + i.Z();
                layoutParams.topMargin = ((AbsToast) this).f1410a.getYOffset() + i.d0();
                layoutParams.leftMargin = ((AbsToast) this).f1410a.getXOffset();
                View viewC = c(i);
                if (z) {
                    viewC.setAlpha(0.0f);
                    viewC.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewC, layoutParams);
            }
        }

        public final IToast l(Activity activity, int i) {
            e eVar = new e(((AbsToast) this).f1411a, activity.getWindowManager(), 99);
            ((AbsToast) eVar).f28201a = c(-1);
            ((AbsToast) eVar).f1410a = ((AbsToast) this).f1410a;
            eVar.show(i);
            return eVar;
        }

        public final void m() {
            i.S0(this.f1415a);
            this.f1415a = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            if (((AbsToast) this).f1410a == null) {
                return;
            }
            if (i.q0()) {
                this.f1414a = j(i);
            } else {
                this.f1414a = j(i);
            }
        }
    }

    public static final class d extends AbsToast {

        public static class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f28206a;

            public a(Handler handler) {
                this.f28206a = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(@NonNull Message message) {
                try {
                    this.f28206a.dispatchMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                this.f28206a.handleMessage(message);
            }
        }

        public d(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            Toast toast = ((AbsToast) this).f1410a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i);
            ((AbsToast) this).f1410a.show();
        }
    }

    public static void K(@NonNull View view, int i, ToastUtils toastUtils) {
        L(view, null, i, toastUtils);
    }

    public static void L(@Nullable View view, @Nullable CharSequence charSequence, int i, @NonNull ToastUtils toastUtils) {
        i.T0(toastUtils.new b(view, charSequence, i));
    }

    public static void N(@Nullable CharSequence charSequence, int i, ToastUtils toastUtils) {
        L(null, o(charSequence), i, toastUtils);
    }

    public static void P(@StringRes int i) {
        N(i.e0(i), 1, f28200a);
    }

    public static void Q(@StringRes int i, Object... objArr) {
        N(i.e0(i), 1, f28200a);
    }

    public static void R(@Nullable CharSequence charSequence) {
        N(charSequence, 1, f28200a);
    }

    public static void S(@Nullable String str, Object... objArr) {
        N(i.E(str, objArr), 1, f28200a);
    }

    public static void T(@StringRes int i) {
        N(i.e0(i), 0, f28200a);
    }

    public static void U(@StringRes int i, Object... objArr) {
        N(i.f0(i, objArr), 0, f28200a);
    }

    public static void V(@Nullable CharSequence charSequence) {
        N(charSequence, 0, f28200a);
    }

    public static void W(@Nullable String str, Object... objArr) {
        N(i.E(str, objArr), 0, f28200a);
    }

    public static void l() {
        i.T0(new a());
    }

    @NonNull
    public static ToastUtils m() {
        return f28200a;
    }

    public static CharSequence o(CharSequence charSequence) {
        if (charSequence == null) {
            return c;
        }
        return charSequence.length() == 0 ? d : charSequence;
    }

    @NonNull
    public static ToastUtils p() {
        return new ToastUtils();
    }

    public static IToast q(ToastUtils toastUtils) {
        if (toastUtils.f1407b || !NotificationManagerCompat.from(Utils.a()).areNotificationsEnabled() || i.v0()) {
            return i.v0() ? new e(toastUtils, 2038) : new c(toastUtils);
        }
        return new d(toastUtils);
    }

    @NonNull
    public final ToastUtils A() {
        this.f1407b = true;
        return this;
    }

    @NonNull
    public final ToastUtils B(@DrawableRes int i) {
        return C(ContextCompat.getDrawable(Utils.a(), i));
    }

    @NonNull
    public final ToastUtils C(@Nullable Drawable drawable) {
        this.f1405a[2] = drawable;
        return this;
    }

    @NonNull
    public final ToastUtils D(@ColorInt int i) {
        this.f = i;
        return this;
    }

    @NonNull
    public final ToastUtils E(int i) {
        this.g = i;
        return this;
    }

    @NonNull
    public final ToastUtils F(@DrawableRes int i) {
        return G(ContextCompat.getDrawable(Utils.a(), i));
    }

    @NonNull
    public final ToastUtils G(@Nullable Drawable drawable) {
        this.f1405a[1] = drawable;
        return this;
    }

    public final void H(@StringRes int i) {
        N(i.e0(i), n(), this);
    }

    public final void I(@StringRes int i, Object... objArr) {
        N(i.f0(i, objArr), n(), this);
    }

    public final void J(@NonNull View view) {
        K(view, n(), this);
    }

    public final void M(@Nullable CharSequence charSequence) {
        N(charSequence, n(), this);
    }

    public final void O(@Nullable String str, Object... objArr) {
        N(i.E(str, objArr), n(), this);
    }

    public final View X(CharSequence charSequence) {
        if (!"dark".equals(this.f1403a) && !"light".equals(this.f1403a)) {
            Drawable[] drawableArr = this.f1405a;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewG0 = i.G0(com.blankj.utilcode.R.layout.utils_toast_view);
        TextView textView = (TextView) viewG0.findViewById(R.id.message);
        if ("dark".equals(this.f1403a)) {
            ((GradientDrawable) viewG0.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f1405a[0] != null) {
            View viewFindViewById = viewG0.findViewById(com.blankj.utilcode.R.id.utvLeftIconView);
            ViewCompat.setBackground(viewFindViewById, this.f1405a[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.f1405a[1] != null) {
            View viewFindViewById2 = viewG0.findViewById(com.blankj.utilcode.R.id.utvTopIconView);
            ViewCompat.setBackground(viewFindViewById2, this.f1405a[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.f1405a[2] != null) {
            View viewFindViewById3 = viewG0.findViewById(com.blankj.utilcode.R.id.utvRightIconView);
            ViewCompat.setBackground(viewFindViewById3, this.f1405a[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.f1405a[3] != null) {
            View viewFindViewById4 = viewG0.findViewById(com.blankj.utilcode.R.id.utvBottomIconView);
            ViewCompat.setBackground(viewFindViewById4, this.f1405a[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewG0;
    }

    public final int n() {
        return this.f1404a ? 1 : 0;
    }

    @NonNull
    public final ToastUtils r(@ColorInt int i) {
        this.f1409d = i;
        return this;
    }

    @NonNull
    public final ToastUtils s(@DrawableRes int i) {
        this.e = i;
        return this;
    }

    @NonNull
    public final ToastUtils t(int i) {
        return u(ContextCompat.getDrawable(Utils.a(), i));
    }

    @NonNull
    public final ToastUtils u(@Nullable Drawable drawable) {
        this.f1405a[3] = drawable;
        return this;
    }

    @NonNull
    public final ToastUtils v(boolean z) {
        this.f1404a = z;
        return this;
    }

    @NonNull
    public final ToastUtils w(int i, int i2, int i3) {
        this.f1402a = i;
        this.f1406b = i2;
        this.f1408c = i3;
        return this;
    }

    @NonNull
    public final ToastUtils x(@DrawableRes int i) {
        return y(ContextCompat.getDrawable(Utils.a(), i));
    }

    @NonNull
    public final ToastUtils y(@Nullable Drawable drawable) {
        this.f1405a[0] = drawable;
        return this;
    }

    @NonNull
    public final ToastUtils z(String str) {
        this.f1403a = str;
        return this;
    }

    public static final class e extends AbsToast {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WindowManager.LayoutParams f28207a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WindowManager f1417a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.cancel();
            }
        }

        public e(ToastUtils toastUtils, int i) {
            super(toastUtils);
            this.f28207a = new WindowManager.LayoutParams();
            this.f1417a = (WindowManager) Utils.a().getSystemService("window");
            this.f28207a.type = i;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.AbsToast, com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            try {
                WindowManager windowManager = this.f1417a;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(((AbsToast) this).f28201a);
                    this.f1417a = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            if (((AbsToast) this).f1410a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f28207a;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.f28207a;
            layoutParams2.flags = 152;
            layoutParams2.packageName = Utils.a().getPackageName();
            this.f28207a.gravity = ((AbsToast) this).f1410a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.f28207a;
            int i2 = layoutParams3.gravity;
            if ((i2 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i2 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = ((AbsToast) this).f1410a.getXOffset();
            this.f28207a.y = ((AbsToast) this).f1410a.getYOffset();
            this.f28207a.horizontalMargin = ((AbsToast) this).f1410a.getHorizontalMargin();
            this.f28207a.verticalMargin = ((AbsToast) this).f1410a.getVerticalMargin();
            try {
                WindowManager windowManager = this.f1417a;
                if (windowManager != null) {
                    windowManager.addView(((AbsToast) this).f28201a, this.f28207a);
                }
            } catch (Exception unused) {
            }
            i.U0(new a(), i == 0 ? 2000L : 3500L);
        }

        public e(ToastUtils toastUtils, WindowManager windowManager, int i) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f28207a = layoutParams;
            this.f1417a = windowManager;
            layoutParams.type = i;
        }
    }
}
