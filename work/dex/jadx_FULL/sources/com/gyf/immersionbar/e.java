package com.gyf.immersionbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zj.adlib.mf7;
import com.zj.adlib.qh3;
import com.zj.adlib.ul0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@TargetApi(19)
public final class e implements ImmersionCallback {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f32550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Dialog f6813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f6814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f6815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Window f6816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public androidx.fragment.app.Fragment f6817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.gyf.immersionbar.a f6818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f6819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qh3 f6820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ul0 f6821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, ul0> f6822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6823a;
    public ViewGroup b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f6824b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;

    public class a implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f32551a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ViewGroup.LayoutParams f6825a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Integer f6826a;

        public a(ViewGroup.LayoutParams layoutParams, View view, int i, Integer num) {
            this.f6825a = layoutParams;
            this.f32551a = view;
            this.K = i;
            this.f6826a = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6825a.height = (this.f32551a.getHeight() + this.K) - this.f6826a.intValue();
            View view = this.f32551a;
            view.setPadding(view.getPaddingLeft(), (this.f32551a.getPaddingTop() + this.K) - this.f6826a.intValue(), this.f32551a.getPaddingRight(), this.f32551a.getPaddingBottom());
            this.f32551a.setLayoutParams(this.f6825a);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32552a;

        static {
            int[] iArr = new int[BarHide.values().length];
            f32552a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32552a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32552a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32552a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e(Activity activity) {
        this.f6823a = false;
        this.f6824b = false;
        this.c = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.f6820a = null;
        this.f6822a = new HashMap();
        this.N = 0;
        this.d = false;
        this.e = false;
        this.f = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.f32550a = activity;
        d1(activity.getWindow());
    }

    public static void A0(@NonNull Fragment fragment, NotchCallback notchCallback) {
        if (fragment.getActivity() == null) {
            return;
        }
        z0(fragment.getActivity(), notchCallback);
    }

    public static void A2(androidx.fragment.app.Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        w2(fragment.getActivity(), i, viewArr);
    }

    public static e A3(@NonNull androidx.fragment.app.Fragment fragment, boolean z) {
        return G0().h(fragment, z);
    }

    public static void B0(@NonNull androidx.fragment.app.Fragment fragment, NotchCallback notchCallback) {
        if (fragment.getActivity() == null) {
            return;
        }
        z0(fragment.getActivity(), notchCallback);
    }

    public static void B2(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        x2(fragment.getActivity(), viewArr);
    }

    public static void E2(@NonNull Window window) {
        window.clearFlags(1024);
    }

    public static boolean G(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && G(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static mf7 G0() {
        return mf7.k();
    }

    @TargetApi(14)
    public static int H0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).k();
    }

    public static void I(@NonNull Activity activity, @NonNull Dialog dialog) {
        G0().b(activity, dialog, false);
    }

    @TargetApi(14)
    public static int I0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return H0(fragment.getActivity());
    }

    public static void J(@NonNull Activity activity, @NonNull Dialog dialog, boolean z) {
        G0().b(activity, dialog, z);
    }

    @TargetApi(14)
    public static int J0(@NonNull Context context) {
        return com.gyf.immersionbar.a.c(context, com.gyf.immersionbar.b.f6802a);
    }

    public static void K(@NonNull Fragment fragment) {
        G0().c(fragment, false);
    }

    @TargetApi(14)
    public static int K0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return H0(fragment.getActivity());
    }

    public static void L(@NonNull Fragment fragment, boolean z) {
        G0().c(fragment, z);
    }

    public static void M(@NonNull androidx.fragment.app.Fragment fragment) {
        G0().d(fragment, false);
    }

    public static void N(@NonNull androidx.fragment.app.Fragment fragment, boolean z) {
        G0().d(fragment, z);
    }

    @TargetApi(14)
    public static boolean O0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).m();
    }

    @TargetApi(14)
    public static boolean P0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return O0(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean Q0(@NonNull Context context) {
        return q0(context) > 0;
    }

    @TargetApi(14)
    public static boolean R0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return O0(fragment.getActivity());
    }

    public static boolean S0(@NonNull Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    public static boolean T0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return S0(fragment.getActivity());
    }

    public static boolean U0(@NonNull View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static void U1(Activity activity) {
        V1(activity, true);
    }

    public static boolean V0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return S0(fragment.getActivity());
    }

    public static void V1(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        Y1(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0), z);
    }

    public static void W1(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        U1(fragment.getActivity());
    }

    public static void X1(Fragment fragment, boolean z) {
        if (fragment == null) {
            return;
        }
        V1(fragment.getActivity(), z);
    }

    public static void Y1(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            view.setFitsSystemWindows(z);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup instanceof DrawerLayout) {
            Y1(viewGroup.getChildAt(0), z);
        } else {
            viewGroup.setFitsSystemWindows(z);
            viewGroup.setClipToPadding(true);
        }
    }

    public static void Z0(@NonNull Window window) {
        window.setFlags(1024, 1024);
    }

    public static void Z1(androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return;
        }
        U1(fragment.getActivity());
    }

    public static void a2(androidx.fragment.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return;
        }
        V1(fragment.getActivity(), z);
    }

    public static boolean g1(String str) {
        return str == null || str.trim().length() == 0;
    }

    @TargetApi(14)
    public static int i0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).a();
    }

    public static boolean i1(Fragment fragment) {
        Context context = fragment.getContext();
        if (context == null) {
            return false;
        }
        return j1(context);
    }

    @TargetApi(14)
    public static int j0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return i0(fragment.getActivity());
    }

    public static boolean j1(Context context) {
        return d.a(context).f6812a;
    }

    @TargetApi(14)
    public static int k0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return i0(fragment.getActivity());
    }

    public static boolean k1(androidx.fragment.app.Fragment fragment) {
        Context context = fragment.getContext();
        if (context == null) {
            return false;
        }
        return j1(context);
    }

    public static void k2(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                int i2 = R.id.immersion_fits_layout_overlap;
                Integer num = (Integer) view.getTag(i2);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(i2, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    }
                    layoutParams.height = i;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @TargetApi(14)
    public static boolean l1(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).n();
    }

    public static void l2(Activity activity, View... viewArr) {
        k2(activity, H0(activity), viewArr);
    }

    @TargetApi(14)
    public static boolean m1(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return l1(fragment.getActivity());
    }

    public static void m2(Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        k2(fragment.getActivity(), i, viewArr);
    }

    @TargetApi(14)
    public static boolean n1(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return l1(fragment.getActivity());
    }

    public static void n2(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        l2(fragment.getActivity(), viewArr);
    }

    @TargetApi(14)
    public static int o0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).d();
    }

    public static boolean o1() {
        OSUtils.isMIUI6Later();
        return true;
    }

    public static void o2(androidx.fragment.app.Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        k2(fragment.getActivity(), i, viewArr);
    }

    @TargetApi(14)
    public static int p0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return o0(fragment.getActivity());
    }

    public static boolean p1() {
        if (OSUtils.isMIUI6Later()) {
            return true;
        }
        OSUtils.isFlymeOS4Later();
        return true;
    }

    public static void p2(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        l2(fragment.getActivity(), viewArr);
    }

    public static e p3(@NonNull Activity activity) {
        return G0().f(activity, false);
    }

    @TargetApi(14)
    public static int q0(@NonNull Context context) {
        d.a aVarA = d.a(context);
        if (!aVarA.f6812a || aVarA.b) {
            return com.gyf.immersionbar.a.f(context);
        }
        return 0;
    }

    public static void q2(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                int i2 = R.id.immersion_fits_layout_overlap;
                Integer num = (Integer) view.getTag(i2);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(i2, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    int i3 = layoutParams.height;
                    if (i3 == -2 || i3 == -1) {
                        view.post(new a(layoutParams, view, i, num));
                    } else {
                        layoutParams.height = i3 + (i - num.intValue());
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static e q3(@NonNull Activity activity, @NonNull Dialog dialog) {
        return G0().e(activity, dialog, false);
    }

    @TargetApi(14)
    public static int r0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return o0(fragment.getActivity());
    }

    public static void r2(Activity activity, View... viewArr) {
        q2(activity, H0(activity), viewArr);
    }

    public static e r3(@NonNull Activity activity, @NonNull Dialog dialog, boolean z) {
        return G0().e(activity, dialog, z);
    }

    @TargetApi(14)
    public static int s0(@NonNull Activity activity) {
        return new com.gyf.immersionbar.a(activity).g();
    }

    public static void s2(Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        q2(fragment.getActivity(), i, viewArr);
    }

    public static e s3(@NonNull Activity activity, boolean z) {
        return G0().f(activity, z);
    }

    @TargetApi(14)
    public static int t0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return s0(fragment.getActivity());
    }

    public static void t2(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        r2(fragment.getActivity(), viewArr);
    }

    public static e t3(@NonNull DialogFragment dialogFragment) {
        return G0().g(dialogFragment, false);
    }

    @TargetApi(14)
    public static int u0(@NonNull Context context) {
        d.a aVarA = d.a(context);
        if (!aVarA.f6812a || aVarA.b) {
            return com.gyf.immersionbar.a.i(context);
        }
        return 0;
    }

    public static void u2(androidx.fragment.app.Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        q2(fragment.getActivity(), i, viewArr);
    }

    public static e u3(@NonNull DialogFragment dialogFragment, boolean z) {
        return G0().g(dialogFragment, z);
    }

    @TargetApi(14)
    public static int v0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return s0(fragment.getActivity());
    }

    public static void v2(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        r2(fragment.getActivity(), viewArr);
    }

    public static e v3(@NonNull Fragment fragment) {
        return G0().g(fragment, false);
    }

    public static int w0(@NonNull Activity activity) {
        return NotchUtils.getNotchHeight(activity);
    }

    public static void w2(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                int i2 = R.id.immersion_fits_layout_overlap;
                Integer num = (Integer) view.getTag(i2);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(i2, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public static e w3(@NonNull Fragment fragment, boolean z) {
        return G0().g(fragment, z);
    }

    public static int x0(@NonNull Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return w0(fragment.getActivity());
    }

    public static void x2(Activity activity, View... viewArr) {
        w2(activity, H0(activity), viewArr);
    }

    public static e x3(@NonNull androidx.fragment.app.DialogFragment dialogFragment) {
        return G0().h(dialogFragment, false);
    }

    public static int y0(@NonNull androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return w0(fragment.getActivity());
    }

    public static void y2(Fragment fragment, int i, View... viewArr) {
        if (fragment == null) {
            return;
        }
        w2(fragment.getActivity(), i, viewArr);
    }

    public static e y3(@NonNull androidx.fragment.app.DialogFragment dialogFragment, boolean z) {
        return G0().h(dialogFragment, z);
    }

    public static void z0(@NonNull Activity activity, NotchCallback notchCallback) {
        NotchUtils.getNotchHeight(activity, notchCallback);
    }

    public static void z2(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        x2(fragment.getActivity(), viewArr);
    }

    public static e z3(@NonNull androidx.fragment.app.Fragment fragment) {
        return G0().h(fragment, false);
    }

    public e A(@ColorInt int i, @ColorInt int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.K = i;
        ul0Var.L = i;
        ul0Var.N = i2;
        ul0Var.O = i2;
        ul0Var.f45169a = f;
        ul0Var.c = f;
        return this;
    }

    public e A1(@ColorInt int i) {
        this.f6821a.L = i;
        return this;
    }

    public e B(@ColorRes int i) {
        return D(ContextCompat.getColor(this.f32550a, i));
    }

    public e B1(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.L = i;
        ul0Var.c = f;
        return this;
    }

    public e C(String str) {
        return D(Color.parseColor(str));
    }

    public int C0() {
        return this.R;
    }

    public e C1(@ColorInt int i, @ColorInt int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.L = i;
        ul0Var.O = i2;
        ul0Var.c = f;
        return this;
    }

    public final void C2() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f6815a;
        int i = com.gyf.immersionbar.b.b;
        View viewFindViewById = viewGroup.findViewById(i);
        if (viewFindViewById == null) {
            viewFindViewById = new View(this.f32550a);
            viewFindViewById.setId(i);
            this.f6815a.addView(viewFindViewById);
        }
        if (this.f6818a.n()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f6818a.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f6818a.g(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        viewFindViewById.setLayoutParams(layoutParams);
        ul0 ul0Var = this.f6821a;
        viewFindViewById.setBackgroundColor(ColorUtils.blendARGB(ul0Var.L, ul0Var.O, ul0Var.c));
        ul0 ul0Var2 = this.f6821a;
        if (ul0Var2.l && ul0Var2.m && !ul0Var2.f20096b) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
        }
    }

    public e D(@ColorInt int i) {
        ul0 ul0Var = this.f6821a;
        ul0Var.N = i;
        ul0Var.O = i;
        return this;
    }

    public int D0() {
        return this.O;
    }

    public e D1(@ColorRes int i) {
        return F1(ContextCompat.getColor(this.f32550a, i));
    }

    public final void D2() {
        ViewGroup viewGroup = this.f6815a;
        int i = com.gyf.immersionbar.b.f32546a;
        View viewFindViewById = viewGroup.findViewById(i);
        if (viewFindViewById == null) {
            viewFindViewById = new View(this.f32550a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f6818a.k());
            layoutParams.gravity = 48;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setId(i);
            this.f6815a.addView(viewFindViewById);
        }
        ul0 ul0Var = this.f6821a;
        if (ul0Var.f20101g) {
            viewFindViewById.setBackgroundColor(ColorUtils.blendARGB(ul0Var.K, ul0Var.N, ul0Var.f45169a));
        } else {
            viewFindViewById.setBackgroundColor(ColorUtils.blendARGB(ul0Var.K, 0, ul0Var.f45169a));
        }
    }

    public e E(boolean z) {
        this.f6821a.o = z;
        return this;
    }

    public int E0() {
        return this.Q;
    }

    public e E1(String str) {
        return F1(Color.parseColor(str));
    }

    public final void F() {
        if (this.f32550a != null) {
            qh3 qh3Var = this.f6820a;
            if (qh3Var != null) {
                qh3Var.a();
                this.f6820a = null;
            }
            c.b().d(this);
            f.a().removeOnNavigationBarListener(this.f6821a.f20092a);
        }
    }

    public int F0() {
        return this.P;
    }

    public e F1(@ColorInt int i) {
        this.f6821a.O = i;
        return this;
    }

    public e F2(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.f45169a = f;
        ul0Var.b = f;
        return this;
    }

    public e G1(boolean z) {
        return H1(z, 0.2f);
    }

    public e G2(@ColorRes int i) {
        return M2(ContextCompat.getColor(this.f32550a, i));
    }

    public final void H() {
        if (this.f6819a == null) {
            this.f6819a = p3(this.f32550a);
        }
        e eVar = this.f6819a;
        if (eVar == null || eVar.d) {
            return;
        }
        eVar.a1();
    }

    public e H1(boolean z, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        this.f6821a.f20098d = z;
        if (!z || o1()) {
            ul0 ul0Var = this.f6821a;
            ul0Var.c = ul0Var.d;
        } else {
            this.f6821a.c = f;
        }
        return this;
    }

    public e H2(@ColorRes int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return N2(ContextCompat.getColor(this.f32550a, i), f);
    }

    public e I1(boolean z) {
        this.f6821a.l = z;
        return this;
    }

    public e I2(@ColorRes int i, @ColorRes int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return O2(ContextCompat.getColor(this.f32550a, i), ContextCompat.getColor(this.f32550a, i2), f);
    }

    public e J1(boolean z) {
        if (OSUtils.isEMUI3_x()) {
            ul0 ul0Var = this.f6821a;
            ul0Var.n = z;
            ul0Var.m = z;
        }
        return this;
    }

    public e J2(String str) {
        return M2(Color.parseColor(str));
    }

    public e K1(boolean z) {
        this.f6821a.m = z;
        return this;
    }

    public e K2(String str, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return N2(Color.parseColor(str), f);
    }

    public androidx.fragment.app.Fragment L0() {
        return this.f6817a;
    }

    public void L1(Configuration configuration) {
        m3();
        if (!OSUtils.isEMUI3_x()) {
            Y();
        } else if (this.d && !this.f6823a && this.f6821a.m) {
            a1();
        } else {
            Y();
        }
    }

    public e L2(String str, String str2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return O2(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public e M0(String str) {
        if (g1(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        ul0 ul0Var = this.f6822a.get(str);
        if (ul0Var != null) {
            this.f6821a = ul0Var.m1069clone();
        }
        return this;
    }

    public void M1() {
        e eVar;
        F();
        if (this.c && (eVar = this.f6819a) != null) {
            ul0 ul0Var = eVar.f6821a;
            ul0Var.k = eVar.f;
            if (ul0Var.f20089a != BarHide.FLAG_SHOW_BAR) {
                eVar.S1();
            }
        }
        this.d = false;
    }

    public e M2(@ColorInt int i) {
        this.f6821a.K = i;
        return this;
    }

    public Window N0() {
        return this.f6816a;
    }

    public void N1() {
        m3();
        if (this.f6823a || !this.d || this.f6821a == null) {
            return;
        }
        if (OSUtils.isEMUI3_x() && this.f6821a.n) {
            a1();
        } else if (this.f6821a.f20089a != BarHide.FLAG_SHOW_BAR) {
            S1();
        }
    }

    public e N2(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.K = i;
        ul0Var.f45169a = f;
        return this;
    }

    public final void O() {
        if (!this.f6823a) {
            if (this.f6821a.k) {
                if (this.f6820a == null) {
                    this.f6820a = new qh3(this);
                }
                this.f6820a.c(this.f6821a.T);
                return;
            } else {
                qh3 qh3Var = this.f6820a;
                if (qh3Var != null) {
                    qh3Var.b();
                    return;
                }
                return;
            }
        }
        e eVar = this.f6819a;
        if (eVar != null) {
            if (eVar.f6821a.k) {
                if (eVar.f6820a == null) {
                    eVar.f6820a = new qh3(eVar);
                }
                e eVar2 = this.f6819a;
                eVar2.f6820a.c(eVar2.f6821a.T);
                return;
            }
            qh3 qh3Var2 = eVar.f6820a;
            if (qh3Var2 != null) {
                qh3Var2.b();
            }
        }
    }

    public final void O1() {
        c0();
        if (this.f6823a || !OSUtils.isEMUI3_x()) {
            return;
        }
        b0();
    }

    public e O2(@ColorInt int i, @ColorInt int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.K = i;
        ul0Var.N = i2;
        ul0Var.f45169a = f;
        return this;
    }

    public final void P() {
        int iK = this.f6821a.i ? this.f6818a.k() : 0;
        int i = this.N;
        if (i == 1) {
            q2(this.f32550a, iK, this.f6821a.f20088a);
        } else if (i == 2) {
            w2(this.f32550a, iK, this.f6821a.f20088a);
        } else {
            if (i != 3) {
                return;
            }
            k2(this.f32550a, iK, this.f6821a.f20095b);
        }
    }

    public e P1() {
        if (this.f6821a.f20093a.size() != 0) {
            this.f6821a.f20093a.clear();
        }
        return this;
    }

    public e P2(@ColorRes int i) {
        return S2(ContextCompat.getColor(this.f32550a, i));
    }

    public e Q(boolean z) {
        this.f6821a.i = z;
        return this;
    }

    public e Q1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        Map<Integer, Integer> map = this.f6821a.f20093a.get(view);
        if (map != null && map.size() != 0) {
            this.f6821a.f20093a.remove(view);
        }
        return this;
    }

    public e Q2(String str) {
        return S2(Color.parseColor(str));
    }

    public final void R() {
        if (Build.VERSION.SDK_INT < 28 || this.d) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = this.f6816a.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.f6816a.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    public e R1() {
        this.f6821a = new ul0();
        this.N = 0;
        return this;
    }

    public e R2(boolean z) {
        this.f6821a.f20101g = z;
        return this;
    }

    public void S() {
        qh3 qh3Var;
        e eVar = this.f6819a;
        if (eVar == null || (qh3Var = eVar.f6820a) == null) {
            return;
        }
        qh3Var.b();
        this.f6819a.f6820a.d();
    }

    public void S1() {
        int iB2 = 256;
        if (OSUtils.isEMUI3_x()) {
            c1();
        } else {
            R();
            iB2 = b2(i2(b1(256)));
            T1();
        }
        this.f6815a.setSystemUiVisibility(Y0(iB2));
        h2();
        X0();
        if (this.f6821a.f20092a != null) {
            f.a().b(this.f32550a.getApplication());
        }
    }

    public e S2(@ColorInt int i) {
        this.f6821a.N = i;
        return this;
    }

    public e T(boolean z) {
        this.f6821a.f20102h = z;
        if (!z) {
            this.N = 0;
        } else if (this.N == 0) {
            this.N = 4;
        }
        return this;
    }

    public final void T1() {
        if (Build.VERSION.SDK_INT >= 30) {
            j2();
            c2();
        }
    }

    public e T2(boolean z) {
        return U2(z, 0.2f);
    }

    public e U(boolean z, @ColorRes int i) {
        return W(z, ContextCompat.getColor(this.f32550a, i));
    }

    public e U2(boolean z, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        this.f6821a.f20097c = z;
        if (!z || p1()) {
            ul0 ul0Var = this.f6821a;
            ul0Var.R = ul0Var.S;
            ul0Var.f45169a = ul0Var.b;
        } else {
            this.f6821a.f45169a = f;
        }
        return this;
    }

    public e V(boolean z, @ColorRes int i, @ColorRes int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return X(z, ContextCompat.getColor(this.f32550a, i), ContextCompat.getColor(this.f32550a, i2), f);
    }

    public e V2(@IdRes int i) {
        return X2(this.f32550a.findViewById(i));
    }

    public e W(boolean z, @ColorInt int i) {
        return X(z, i, -16777216, 0.0f);
    }

    public e W0(BarHide barHide) {
        this.f6821a.f20089a = barHide;
        if (OSUtils.isEMUI3_x()) {
            ul0 ul0Var = this.f6821a;
            BarHide barHide2 = ul0Var.f20089a;
            ul0Var.f20096b = barHide2 == BarHide.FLAG_HIDE_NAVIGATION_BAR || barHide2 == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public e W2(@IdRes int i, View view) {
        return X2(view.findViewById(i));
    }

    public e X(boolean z, @ColorInt int i, @ColorInt int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.f20102h = z;
        ul0Var.P = i;
        ul0Var.Q = i2;
        ul0Var.h = f;
        if (!z) {
            this.N = 0;
        } else if (this.N == 0) {
            this.N = 4;
        }
        this.b.setBackgroundColor(ColorUtils.blendARGB(i, i2, f));
        return this;
    }

    public final void X0() {
        WindowInsetsController windowInsetsController;
        if (Build.VERSION.SDK_INT < 30 || (windowInsetsController = this.b.getWindowInsetsController()) == null) {
            return;
        }
        int i = b.f32552a[this.f6821a.f20089a.ordinal()];
        if (i == 1) {
            windowInsetsController.hide(WindowInsets.Type.statusBars());
            windowInsetsController.hide(WindowInsets.Type.navigationBars());
        } else if (i == 2) {
            windowInsetsController.hide(WindowInsets.Type.statusBars());
        } else if (i == 3) {
            windowInsetsController.hide(WindowInsets.Type.navigationBars());
        } else if (i == 4) {
            windowInsetsController.show(WindowInsets.Type.statusBars());
            windowInsetsController.show(WindowInsets.Type.navigationBars());
        }
        windowInsetsController.setSystemBarsBehavior(2);
    }

    public e X2(View view) {
        if (view == null) {
            return this;
        }
        this.f6821a.f20095b = view;
        if (this.N == 0) {
            this.N = 3;
        }
        return this;
    }

    public final void Y() {
        if (OSUtils.isEMUI3_x()) {
            a0();
        } else {
            Z();
        }
        P();
    }

    public final int Y0(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            return i;
        }
        int i2 = b.f32552a[this.f6821a.f20089a.ordinal()];
        if (i2 == 1) {
            i |= 518;
        } else if (i2 == 2) {
            i |= 1028;
        } else if (i2 == 3) {
            i |= 514;
        } else if (i2 == 4) {
            i |= 0;
        }
        return i | 4096;
    }

    public e Y2(boolean z) {
        this.f6821a.j = z;
        return this;
    }

    public final void Z() {
        if (G(this.f6815a.findViewById(android.R.id.content))) {
            g2(0, 0, 0, 0);
            return;
        }
        int iK = (this.f6821a.f20102h && this.N == 4) ? this.f6818a.k() : 0;
        if (this.f6821a.j) {
            iK = this.f6818a.k() + this.M;
        }
        g2(0, iK, 0, 0);
    }

    public e Z2(@IdRes int i) {
        return c3(i, true);
    }

    @Override // com.gyf.immersionbar.OnNavigationBarListener
    public void a(boolean z, NavigationBarType navigationBarType) {
        View viewFindViewById = this.f6815a.findViewById(com.gyf.immersionbar.b.b);
        if (viewFindViewById != null) {
            this.f6818a = new com.gyf.immersionbar.a(this.f32550a);
            int paddingBottom = this.b.getPaddingBottom();
            int paddingRight = this.b.getPaddingRight();
            if (z) {
                viewFindViewById.setVisibility(0);
                if (!G(this.f6815a.findViewById(android.R.id.content))) {
                    if (this.K == 0) {
                        this.K = this.f6818a.d();
                    }
                    if (this.L == 0) {
                        this.L = this.f6818a.g();
                    }
                    if (!this.f6821a.f20096b) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        if (this.f6818a.n()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.K;
                            layoutParams.height = paddingBottom;
                            if (this.f6821a.f20094a) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = GravityCompat.END;
                            int i = this.L;
                            layoutParams.width = i;
                            if (this.f6821a.f20094a) {
                                i = 0;
                            }
                            paddingRight = i;
                            paddingBottom = 0;
                        }
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }
                g2(0, this.b.getPaddingTop(), paddingRight, paddingBottom);
            }
            viewFindViewById.setVisibility(8);
            paddingBottom = 0;
            paddingRight = 0;
            g2(0, this.b.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public final void a0() {
        if (this.f6821a.j) {
            this.e = true;
            this.b.post(this);
        } else {
            this.e = false;
            O1();
        }
    }

    public void a1() {
        if (this.f6821a.o) {
            n3();
            S1();
            Y();
            O();
            i3();
            this.d = true;
        }
    }

    public e a3(@IdRes int i, View view) {
        return e3(view.findViewById(i), true);
    }

    public e b(String str) {
        if (g1(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.f6822a.put(str, this.f6821a.m1069clone());
        return this;
    }

    public final void b0() {
        View viewFindViewById = this.f6815a.findViewById(com.gyf.immersionbar.b.b);
        ul0 ul0Var = this.f6821a;
        if (!ul0Var.l || !ul0Var.m) {
            c.b().d(this);
            viewFindViewById.setVisibility(8);
        } else if (viewFindViewById != null) {
            c.b().a(this);
            c.b().c(this.f32550a.getApplication());
        }
    }

    @RequiresApi(api = 21)
    public final int b1(int i) {
        if (!this.d) {
            this.f6821a.M = this.f6816a.getNavigationBarColor();
        }
        int i2 = i | 1024;
        ul0 ul0Var = this.f6821a;
        if (ul0Var.f20094a && ul0Var.l) {
            i2 |= 512;
        }
        this.f6816a.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        if (this.f6818a.m()) {
            this.f6816a.clearFlags(134217728);
        }
        this.f6816a.addFlags(Integer.MIN_VALUE);
        ul0 ul0Var2 = this.f6821a;
        if (ul0Var2.f20101g) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f6816a.setStatusBarContrastEnforced(false);
            }
            Window window = this.f6816a;
            ul0 ul0Var3 = this.f6821a;
            window.setStatusBarColor(ColorUtils.blendARGB(ul0Var3.K, ul0Var3.N, ul0Var3.f45169a));
        } else {
            this.f6816a.setStatusBarColor(ColorUtils.blendARGB(ul0Var2.K, 0, ul0Var2.f45169a));
        }
        ul0 ul0Var4 = this.f6821a;
        if (ul0Var4.l) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f6816a.setNavigationBarContrastEnforced(false);
            }
            Window window2 = this.f6816a;
            ul0 ul0Var5 = this.f6821a;
            window2.setNavigationBarColor(ColorUtils.blendARGB(ul0Var5.L, ul0Var5.O, ul0Var5.c));
        } else {
            this.f6816a.setNavigationBarColor(ul0Var4.M);
        }
        return i2;
    }

    public final int b2(int i) {
        return this.f6821a.f20098d ? i | 16 : i;
    }

    public e b3(@IdRes int i, View view, boolean z) {
        return e3(view.findViewById(i), z);
    }

    public e c(View view) {
        return h(view, this.f6821a.N);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    public final void c0() {
        int iG;
        int iD;
        if (G(this.f6815a.findViewById(android.R.id.content))) {
            g2(0, 0, 0, 0);
            return;
        }
        int iK = (this.f6821a.f20102h && this.N == 4) ? this.f6818a.k() : 0;
        if (this.f6821a.j) {
            iK = this.f6818a.k() + this.M;
        }
        if (this.f6818a.m()) {
            ul0 ul0Var = this.f6821a;
            if (ul0Var.l && ul0Var.m) {
                if (ul0Var.f20094a) {
                    iG = 0;
                    iD = 0;
                } else if (this.f6818a.n()) {
                    iD = this.f6818a.d();
                    iG = 0;
                } else {
                    iG = this.f6818a.g();
                    iD = 0;
                }
                if (this.f6821a.f20096b) {
                    if (this.f6818a.n()) {
                        iD = 0;
                    } else {
                        iG = 0;
                    }
                } else if (!this.f6818a.n()) {
                    iG = this.f6818a.g();
                }
            } else {
                iG = 0;
                iD = 0;
            }
        } else {
            iG = 0;
            iD = 0;
        }
        g2(0, iK, iG, iD);
    }

    public final void c1() {
        this.f6816a.addFlags(TTAdConstant.KEY_CLICK_AREA);
        D2();
        if (this.f6818a.m() || OSUtils.isEMUI3_x()) {
            ul0 ul0Var = this.f6821a;
            if (ul0Var.l && ul0Var.m) {
                this.f6816a.addFlags(134217728);
            } else {
                this.f6816a.clearFlags(134217728);
            }
            if (this.K == 0) {
                this.K = this.f6818a.d();
            }
            if (this.L == 0) {
                this.L = this.f6818a.g();
            }
            C2();
        }
    }

    @RequiresApi(api = 30)
    public final void c2() {
        WindowInsetsController windowInsetsController = this.b.getWindowInsetsController();
        if (this.f6821a.f20098d) {
            windowInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    public e c3(@IdRes int i, boolean z) {
        androidx.fragment.app.Fragment fragment = this.f6817a;
        if (fragment != null && fragment.getView() != null) {
            return e3(this.f6817a.getView().findViewById(i), z);
        }
        Fragment fragment2 = this.f6814a;
        return (fragment2 == null || fragment2.getView() == null) ? e3(this.f32550a.findViewById(i), z) : e3(this.f6814a.getView().findViewById(i), z);
    }

    public e d(View view, @ColorRes int i) {
        return h(view, ContextCompat.getColor(this.f32550a, i));
    }

    public e d0(@ColorRes int i) {
        this.f6821a.R = ContextCompat.getColor(this.f32550a, i);
        ul0 ul0Var = this.f6821a;
        ul0Var.S = ul0Var.R;
        return this;
    }

    public final void d1(Window window) {
        this.f6816a = window;
        this.f6821a = new ul0();
        ViewGroup viewGroup = (ViewGroup) this.f6816a.getDecorView();
        this.f6815a = viewGroup;
        this.b = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    public e d2(OnBarListener onBarListener) {
        if (onBarListener != null) {
            ul0 ul0Var = this.f6821a;
            if (ul0Var.f20090a == null) {
                ul0Var.f20090a = onBarListener;
            }
        } else {
            ul0 ul0Var2 = this.f6821a;
            if (ul0Var2.f20090a != null) {
                ul0Var2.f20090a = null;
            }
        }
        return this;
    }

    public e d3(View view) {
        return view == null ? this : e3(view, true);
    }

    public e e(View view, @ColorRes int i, @ColorRes int i2) {
        return i(view, ContextCompat.getColor(this.f32550a, i), ContextCompat.getColor(this.f32550a, i2));
    }

    public e e0(String str) {
        this.f6821a.R = Color.parseColor(str);
        ul0 ul0Var = this.f6821a;
        ul0Var.S = ul0Var.R;
        return this;
    }

    public boolean e1() {
        return this.d;
    }

    public e e2(@Nullable OnKeyboardListener onKeyboardListener) {
        ul0 ul0Var = this.f6821a;
        if (ul0Var.f20091a == null) {
            ul0Var.f20091a = onKeyboardListener;
        }
        return this;
    }

    public e e3(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.N == 0) {
            this.N = 1;
        }
        ul0 ul0Var = this.f6821a;
        ul0Var.f20088a = view;
        ul0Var.f20101g = z;
        return this;
    }

    public e f(View view, String str) {
        return h(view, Color.parseColor(str));
    }

    public e f0(@ColorInt int i) {
        ul0 ul0Var = this.f6821a;
        ul0Var.R = i;
        ul0Var.S = i;
        return this;
    }

    public boolean f1() {
        return this.f6824b;
    }

    public e f2(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            ul0 ul0Var = this.f6821a;
            if (ul0Var.f20092a == null) {
                ul0Var.f20092a = onNavigationBarListener;
                f.a().addOnNavigationBarListener(this.f6821a.f20092a);
            }
        } else if (this.f6821a.f20092a != null) {
            f.a().removeOnNavigationBarListener(this.f6821a.f20092a);
            this.f6821a.f20092a = null;
        }
        return this;
    }

    public e f3(@IdRes int i) {
        androidx.fragment.app.Fragment fragment = this.f6817a;
        if (fragment != null && fragment.getView() != null) {
            return h3(this.f6817a.getView().findViewById(i));
        }
        Fragment fragment2 = this.f6814a;
        return (fragment2 == null || fragment2.getView() == null) ? h3(this.f32550a.findViewById(i)) : h3(this.f6814a.getView().findViewById(i));
    }

    public e g(View view, String str, String str2) {
        return i(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public e g0(boolean z) {
        this.f6821a.f20094a = z;
        return this;
    }

    public final void g2(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.O = i;
        this.P = i2;
        this.Q = i3;
        this.R = i4;
    }

    public e g3(@IdRes int i, View view) {
        return h3(view.findViewById(i));
    }

    public Activity getActivity() {
        return this.f32550a;
    }

    public e h(View view, @ColorInt int i) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap map = new HashMap();
        map.put(Integer.valueOf(this.f6821a.K), Integer.valueOf(i));
        this.f6821a.f20093a.put(view, map);
        return this;
    }

    public int h0() {
        return this.M;
    }

    public boolean h1() {
        return this.f6823a;
    }

    public final void h2() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.f6816a, com.gyf.immersionbar.b.o, this.f6821a.f20097c);
            ul0 ul0Var = this.f6821a;
            if (ul0Var.l) {
                SpecialBarFontUtils.setMIUIBarDark(this.f6816a, com.gyf.immersionbar.b.p, ul0Var.f20098d);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            ul0 ul0Var2 = this.f6821a;
            int i = ul0Var2.R;
            if (i != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.f32550a, i);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.f32550a, ul0Var2.f20097c);
            }
        }
    }

    public e h3(View view) {
        if (view == null) {
            return this;
        }
        if (this.N == 0) {
            this.N = 2;
        }
        this.f6821a.f20088a = view;
        return this;
    }

    public e i(View view, @ColorInt int i, @ColorInt int i2) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap map = new HashMap();
        map.put(Integer.valueOf(i), Integer.valueOf(i2));
        this.f6821a.f20093a.put(view, map);
        return this;
    }

    public final int i2(int i) {
        return this.f6821a.f20097c ? i | 8192 : i;
    }

    public final void i3() {
        if (this.f6821a.f20093a.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.f6821a.f20093a.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer numValueOf = Integer.valueOf(this.f6821a.K);
                Integer numValueOf2 = Integer.valueOf(this.f6821a.N);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    numValueOf2 = entry2.getValue();
                    numValueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.f6821a.g - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(numValueOf.intValue(), numValueOf2.intValue(), this.f6821a.f45169a));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(numValueOf.intValue(), numValueOf2.intValue(), this.f6821a.g));
                    }
                }
            }
        }
    }

    public final void j() {
        ul0 ul0Var = this.f6821a;
        int iBlendARGB = ColorUtils.blendARGB(ul0Var.K, ul0Var.N, ul0Var.f45169a);
        ul0 ul0Var2 = this.f6821a;
        if (ul0Var2.f20099e && iBlendARGB != 0) {
            U2(iBlendARGB > -4539718, ul0Var2.e);
        }
        ul0 ul0Var3 = this.f6821a;
        int iBlendARGB2 = ColorUtils.blendARGB(ul0Var3.L, ul0Var3.O, ul0Var3.c);
        ul0 ul0Var4 = this.f6821a;
        if (!ul0Var4.f20100f || iBlendARGB2 == 0) {
            return;
        }
        H1(iBlendARGB2 > -4539718, ul0Var4.f);
    }

    @RequiresApi(api = 30)
    public final void j2() {
        WindowInsetsController windowInsetsController = this.b.getWindowInsetsController();
        if (!this.f6821a.f20097c) {
            windowInsetsController.setSystemBarsAppearance(0, 8);
            return;
        }
        if (this.f6816a != null) {
            unsetSystemUiFlag(8192);
        }
        windowInsetsController.setSystemBarsAppearance(8, 8);
    }

    public e j3() {
        ul0 ul0Var = this.f6821a;
        ul0Var.K = 0;
        ul0Var.L = 0;
        ul0Var.f20094a = true;
        return this;
    }

    public e k(boolean z) {
        this.f6821a.i = !z;
        V1(this.f32550a, z);
        return this;
    }

    public e k3() {
        ul0 ul0Var = this.f6821a;
        ul0Var.L = 0;
        ul0Var.f20094a = true;
        return this;
    }

    public e l(boolean z) {
        return m(z, 0.2f);
    }

    public com.gyf.immersionbar.a l0() {
        if (this.f6818a == null) {
            this.f6818a = new com.gyf.immersionbar.a(this.f32550a);
        }
        return this.f6818a;
    }

    public e l3() {
        this.f6821a.K = 0;
        return this;
    }

    public e m(boolean z, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.f20099e = z;
        ul0Var.e = f;
        ul0Var.f20100f = z;
        ul0Var.f = f;
        return this;
    }

    public ul0 m0() {
        return this.f6821a;
    }

    public final void m3() {
        com.gyf.immersionbar.a aVar = new com.gyf.immersionbar.a(this.f32550a);
        this.f6818a = aVar;
        if (!this.d || this.e) {
            this.M = aVar.a();
        }
    }

    public e n(boolean z) {
        return o(z, 0.2f);
    }

    public Fragment n0() {
        return this.f6814a;
    }

    public final void n3() {
        j();
        if (!this.d || this.f6823a) {
            m3();
        }
        e eVar = this.f6819a;
        if (eVar != null) {
            if (this.f6823a) {
                eVar.f6821a = this.f6821a;
            }
            if (this.c && eVar.f) {
                eVar.f6821a.k = false;
            }
        }
    }

    public e o(boolean z, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.f20100f = z;
        ul0Var.f = f;
        return this;
    }

    public e o3(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        this.f6821a.g = f;
        return this;
    }

    public e p(boolean z) {
        return q(z, 0.2f);
    }

    public e q(boolean z, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.f20099e = z;
        ul0Var.e = f;
        return this;
    }

    public e q1(boolean z) {
        return r1(z, this.f6821a.T);
    }

    public e r(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.f45169a = f;
        ul0Var.b = f;
        ul0Var.c = f;
        ul0Var.d = f;
        return this;
    }

    public e r1(boolean z, int i) {
        ul0 ul0Var = this.f6821a;
        ul0Var.k = z;
        ul0Var.T = i;
        this.f = z;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        O1();
    }

    public e s(@ColorRes int i) {
        return y(ContextCompat.getColor(this.f32550a, i));
    }

    public e s1(int i) {
        this.f6821a.T = i;
        return this;
    }

    public e t(@ColorRes int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return z(ContextCompat.getColor(this.f32550a, i), i);
    }

    public e t1(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.c = f;
        ul0Var.d = f;
        return this;
    }

    public e u(@ColorRes int i, @ColorRes int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return A(ContextCompat.getColor(this.f32550a, i), ContextCompat.getColor(this.f32550a, i2), f);
    }

    public e u1(@ColorRes int i) {
        return A1(ContextCompat.getColor(this.f32550a, i));
    }

    public void unsetSystemUiFlag(int i) {
        View decorView = this.f6816a.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    public e v(String str) {
        return y(Color.parseColor(str));
    }

    public e v1(@ColorRes int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return B1(ContextCompat.getColor(this.f32550a, i), f);
    }

    public e w(String str, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return z(Color.parseColor(str), f);
    }

    public e w1(@ColorRes int i, @ColorRes int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return C1(ContextCompat.getColor(this.f32550a, i), ContextCompat.getColor(this.f32550a, i2), f);
    }

    public e x(String str, String str2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return A(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public e x1(String str) {
        return A1(Color.parseColor(str));
    }

    public e y(@ColorInt int i) {
        ul0 ul0Var = this.f6821a;
        ul0Var.K = i;
        ul0Var.L = i;
        return this;
    }

    public e y1(String str, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return B1(Color.parseColor(str), f);
    }

    public e z(@ColorInt int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        ul0 ul0Var = this.f6821a;
        ul0Var.K = i;
        ul0Var.L = i;
        ul0Var.f45169a = f;
        ul0Var.c = f;
        return this;
    }

    public e z1(String str, String str2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return C1(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public e(androidx.fragment.app.Fragment fragment) {
        this.f6823a = false;
        this.f6824b = false;
        this.c = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.f6820a = null;
        this.f6822a = new HashMap();
        this.N = 0;
        this.d = false;
        this.e = false;
        this.f = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.f6823a = true;
        FragmentActivity activity = fragment.getActivity();
        this.f32550a = activity;
        this.f6817a = fragment;
        H();
        d1(activity.getWindow());
    }

    public e(Fragment fragment) {
        this.f6823a = false;
        this.f6824b = false;
        this.c = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.f6820a = null;
        this.f6822a = new HashMap();
        this.N = 0;
        this.d = false;
        this.e = false;
        this.f = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.f6823a = true;
        Activity activity = fragment.getActivity();
        this.f32550a = activity;
        this.f6814a = fragment;
        H();
        d1(activity.getWindow());
    }

    public e(androidx.fragment.app.DialogFragment dialogFragment) {
        this.f6823a = false;
        this.f6824b = false;
        this.c = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.f6820a = null;
        this.f6822a = new HashMap();
        this.N = 0;
        this.d = false;
        this.e = false;
        this.f = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.c = true;
        this.f6824b = true;
        this.f32550a = dialogFragment.getActivity();
        this.f6817a = dialogFragment;
        this.f6813a = dialogFragment.getDialog();
        H();
        d1(this.f6813a.getWindow());
    }

    public e(DialogFragment dialogFragment) {
        this.f6823a = false;
        this.f6824b = false;
        this.c = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.f6820a = null;
        this.f6822a = new HashMap();
        this.N = 0;
        this.d = false;
        this.e = false;
        this.f = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.c = true;
        this.f6824b = true;
        this.f32550a = dialogFragment.getActivity();
        this.f6814a = dialogFragment;
        this.f6813a = dialogFragment.getDialog();
        H();
        d1(this.f6813a.getWindow());
    }

    public e(Activity activity, Dialog dialog) {
        this.f6823a = false;
        this.f6824b = false;
        this.c = false;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.f6820a = null;
        this.f6822a = new HashMap();
        this.N = 0;
        this.d = false;
        this.e = false;
        this.f = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.c = true;
        this.f32550a = activity;
        this.f6813a = dialog;
        H();
        d1(this.f6813a.getWindow());
    }
}
