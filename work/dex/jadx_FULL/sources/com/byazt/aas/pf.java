package com.byazt.aas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.gyf.immersionbar.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 577})
public class pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f28276a = -1;
    public static volatile int c = -1;
    public static volatile int n = -1;
    public static int sp = 13;
    public static volatile float tt = -1.0f;
    public static volatile float uj = -1.0f;
    public static volatile int ve = -1;
    public static float x;

    public interface c {
        void c(View view);
    }

    public static float a(Context context) {
        c(context);
        return tt;
    }

    public static int c(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    public static String c(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    public static void c(Context context) {
        Resources resources;
        if (context == null) {
            context = com.byazt.omf.gt.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (sp()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            tt = displayMetrics.density;
            ve = displayMetrics.densityDpi;
            uj = displayMetrics.scaledDensity;
            n = displayMetrics.widthPixels;
            f28276a = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (n > f28276a) {
                    int i = n;
                    n = f28276a;
                    f28276a = i;
                    return;
                }
                return;
            }
            if (n < f28276a) {
                int i2 = n;
                n = f28276a;
                f28276a = i2;
            }
        }
    }

    public static float da(Context context) {
        if (context == null) {
            context = com.byazt.omf.gt.getContext();
        }
        try {
            int identifier = context.getApplicationContext().getResources().getIdentifier(b.f6802a, "dimen", "android");
            if (identifier > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            }
            return 0.0f;
        } catch (Throwable th) {
            com.byazt.nr.m.tt("TTUtils", "Get StatusBarHeight failed:" + th.getMessage());
            return 0.0f;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            context = com.byazt.omf.gt.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static float m(Context context) {
        if (context == null) {
            context = com.byazt.omf.gt.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int n(Context context) {
        c(context);
        return f28276a;
    }

    public static boolean sl(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean sp() {
        return tt < 0.0f || ve < 0 || uj < 0.0f || n < 0 || f28276a < 0;
    }

    public static boolean t(Context context) {
        try {
            if ("V1938CT".equals(((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getDeviceModel())) {
                return false;
            }
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int tt(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    public static int tt(Context context, float f) {
        c(context);
        float fSp = sp(context);
        if (fSp <= 0.0f) {
            fSp = 1.0f;
        }
        return (int) ((f / fSp) + 0.5f);
    }

    private static boolean tt(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static boolean u(Context context) {
        String strU = nb.u("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(strU);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int uj(Context context, float f) {
        c(context);
        float fM = m(context);
        if (fM <= 0.0f) {
            fM = 1.0f;
        }
        return (int) ((f / fM) + 0.5f);
    }

    public static int ve(Context context, float f) {
        c(context);
        return (int) ((f * m(context)) + 0.5f);
    }

    public static int x(Context context) {
        if (context == null) {
            context = com.byazt.omf.gt.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static TextView yp(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.pr.c.tt().c(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (((double) n(context)) * (-0.3d));
        int iVe = ve(context, 20.0f);
        int iVe2 = ve(context, 11.0f);
        textView.setPadding(iVe, iVe2, iVe, iVe2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(sp);
        textView.setGravity(17);
        return textView;
    }

    public static int z(Context context) {
        int identifier = context.getResources().getIdentifier(b.f6803b, "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float sp(Context context) {
        c(context);
        return uj;
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        c(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.aas.pf.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static void n(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.aas.pf.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                pf.c(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static int[] tt(Context context) {
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int uj(Context context) {
        c(context);
        return n;
    }

    public static int[] ve(Context context) {
        c(context);
        return new int[]{n, f28276a};
    }

    public static Bitmap sp(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        canvas.save();
        return bitmapCreateBitmap;
    }

    private static boolean da(Activity activity) {
        try {
            if (activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                return x((Context) activity) - activity.getWindow().getDecorView().getHeight() > 0 || i((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static void sl(Activity activity) {
        Object objInvoke;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            objInvoke = null;
        }
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, objInvoke);
        } catch (Throwable unused2) {
        }
    }

    public static boolean uj(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static int[] ve(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean uj(Activity activity) {
        return a(activity) || c("ro.miui.notch") == 1 || sl((Context) activity) || t(activity) || uj() || n() || da(activity) || u(activity);
    }

    public static boolean i(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static void n(@ForbidWrapParam Activity activity) {
        if (ve()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.byazt.aas.pf.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.bzd.x.c(new com.byazt.bwm.sp("check_notch") { // from class: com.byazt.aas.pf.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !pf.ve()) {
                                    pf.c = pf.uj(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void ve(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(2050);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static void x(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return false;
        }
    }

    public static boolean n() {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static boolean ve() {
        return c != -1;
    }

    public static String a() {
        return c(((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi());
    }

    public static void x(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void sp(Activity activity) {
        try {
            sl(activity);
        } catch (Throwable unused) {
        }
    }

    public static boolean uj() {
        String deviceModel = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getDeviceModel();
        return deviceModel.equals("IN2010") || deviceModel.equals("IN2020") || deviceModel.equals("KB2000");
    }

    public static int[] tt(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void tt(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        c(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    public static float c(Context context, float f) {
        c(context);
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static void tt(Activity activity) {
        try {
            ve(activity);
            activity.getWindow().addFlags(134217728);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new com.byazt.nr.i(rect, view));
    }

    public static boolean tt() {
        return c == 1 || c == -1;
    }

    public static void tt(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.aas.pf.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static int[] c(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void c(View view, int i) {
        if (view == null || view.getVisibility() == i || !tt(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void c(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static boolean c(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void c(final com.byazt.nl.uj ujVar) {
        if (ujVar == null) {
            return;
        }
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.aas.pf.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = ujVar.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void c(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void c(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean c() {
        try {
            return !((KeyguardManager) com.byazt.omf.gt.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.byazt.omf.x.m().c() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!c())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            com.byazt.nr.m.ve("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void c(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            tt(activity);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static void c(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && x == 0.0f) {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (displayCutout != null) {
                    x = displayCutout.getSafeInsetTop();
                }
            }
            if (x == 0.0f) {
                return;
            }
            float fMax = Math.max(da(view2.getContext()), x);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = (int) (layoutParams2.topMargin + fMax);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.topMargin = (int) (layoutParams3.topMargin + fMax);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams4.topMargin = (int) (layoutParams4.topMargin + fMax);
            }
            view2.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static int c(String str) {
        com.byazt.dna.or orVar;
        if (!zm.gt() || (orVar = (com.byazt.dna.or) com.byazt.ut.uj.getService("system_info")) == null) {
            return 0;
        }
        return orVar.getInt(str);
    }

    public static void c(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.byazt.nr.m.uj("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void c(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.byazt.nr.m.uj("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void c(final View view, final c cVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.aas.pf.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view);
                }
            }
        });
    }

    public static void c(View view, final ic icVar) {
        if (view == null || icVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.aas.pf.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                n.c(com.byazt.omf.gt.getContext(), icVar);
            }
        });
    }

    public static void c(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(ve(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(-1073741825);
        textView.setGravity(17);
        textView.setPadding(ve(context, 2.0f), ve(context, 3.0f), ve(context, 2.0f), ve(context, 3.0f));
    }

    public static void c(TextView textView, ic icVar) {
        if (textView != null && icVar != null) {
            String strDn = icVar.dn();
            if (TextUtils.isEmpty(strDn)) {
                c(textView);
                c((View) textView, icVar);
                return;
            } else {
                c(textView, strDn, com.byazt.omf.gt.getContext());
                return;
            }
        }
        c(textView);
    }

    public static void c(TextView textView, ic icVar, int i, int i2) {
        if (textView != null && icVar != null) {
            String strDn = icVar.dn();
            if (TextUtils.isEmpty(strDn)) {
                c(textView, i, i2);
                c((View) textView, icVar);
                return;
            } else {
                c(textView, strDn, com.byazt.omf.gt.getContext());
                return;
            }
        }
        c(textView, i, i2);
    }

    private static void c(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = ve(com.byazt.omf.gt.getContext(), 32.0f);
        layoutParams.height = ve(com.byazt.omf.gt.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void c(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = ve(com.byazt.omf.gt.getContext(), i);
        layoutParams.height = ve(com.byazt.omf.gt.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    @Deprecated
    public static void c(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.pr.c.tt().c(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iVe = ve(context, 20.0f);
        int iVe2 = ve(context, 11.0f);
        textView.setPadding(iVe, iVe2, iVe, iVe2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(sp);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }
}
