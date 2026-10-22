package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {
    public a() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @Nullable
    public static Drawable A(@NonNull Activity activity) {
        return B(activity.getComponentName());
    }

    @Nullable
    public static Drawable B(@NonNull ComponentName componentName) {
        try {
            return Utils.a().getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static Drawable C(@NonNull Class<? extends Activity> cls) {
        return B(new ComponentName(Utils.a(), cls));
    }

    public static List<Activity> D() {
        return i.I();
    }

    @Nullable
    public static Drawable E(@NonNull Activity activity) {
        return F(activity.getComponentName());
    }

    @Nullable
    public static Drawable F(@NonNull ComponentName componentName) {
        try {
            return Utils.a().getPackageManager().getActivityLogo(componentName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static Drawable G(@NonNull Class<? extends Activity> cls) {
        return F(new ComponentName(Utils.a(), cls));
    }

    public static String H() {
        return I(Utils.a().getPackageName());
    }

    public static String I(@NonNull String str) {
        if (i.C0(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = Utils.a().getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) ? "" : listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static List<String> J() {
        return K(Utils.a().getPackageName());
    }

    public static List<String> K(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = Utils.a().getPackageManager().queryIntentActivities(intent, 0);
        int size = listQueryIntentActivities.size();
        if (size == 0) {
            return arrayList;
        }
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = listQueryIntentActivities.get(i);
            if (resolveInfo.activityInfo.processName.equals(str)) {
                arrayList.add(resolveInfo.activityInfo.name);
            }
        }
        return arrayList;
    }

    public static Bundle L(Activity activity, View[] viewArr) {
        int length;
        if (viewArr == null || (length = viewArr.length) <= 0) {
            return null;
        }
        Pair[] pairArr = new Pair[length];
        for (int i = 0; i < length; i++) {
            View view = viewArr[i];
            pairArr[i] = Pair.create(view, view.getTransitionName());
        }
        return ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairArr).toBundle();
    }

    public static Bundle M(Context context, int i, int i2) {
        return ActivityOptionsCompat.makeCustomAnimation(context, i, i2).toBundle();
    }

    public static Bundle N(Fragment fragment, int i, int i2) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return ActivityOptionsCompat.makeCustomAnimation(activity, i, i2).toBundle();
    }

    public static Bundle O(Fragment fragment, View[] viewArr) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return L(activity, viewArr);
    }

    public static Activity P() {
        return i.g0();
    }

    public static Context Q() {
        Activity activityP;
        return (!i.q0() || (activityP = P()) == null) ? Utils.a() : activityP;
    }

    public static boolean R(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean S(Context context) {
        return R(x(context));
    }

    public static boolean T(@NonNull String str, @NonNull String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        PackageManager packageManager = Utils.a().getPackageManager();
        return (packageManager.resolveActivity(intent, 0) == null || intent.resolveActivity(packageManager) == null || packageManager.queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static boolean U(@NonNull Activity activity) {
        Iterator<Activity> it = i.I().iterator();
        while (it.hasNext()) {
            if (it.next().equals(activity)) {
                return true;
            }
        }
        return false;
    }

    public static boolean V(@NonNull Class<? extends Activity> cls) {
        Iterator<Activity> it = i.I().iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    public static boolean W(Intent intent) {
        return Utils.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void X(@Nullable Activity activity) {
        i.Q0(activity);
    }

    public static void Y(@Nullable Activity activity, @Nullable Utils.a aVar) {
        i.R0(activity, aVar);
    }

    public static void Z(@Nullable Utils.a aVar) {
        i.S0(aVar);
    }

    public static void a(@Nullable Activity activity, @Nullable Utils.a aVar) {
        i.a(activity, aVar);
    }

    public static void a0(@NonNull Activity activity, @NonNull Intent[] intentArr) {
        f0(intentArr, activity, null);
    }

    public static void b(@Nullable Utils.a aVar) {
        i.b(aVar);
    }

    public static void b0(@NonNull Activity activity, @NonNull Intent[] intentArr, @AnimRes int i, @AnimRes int i2) {
        f0(intentArr, activity, M(activity, i, i2));
    }

    public static void c(@NonNull Activity activity) {
        e(activity, false);
    }

    public static void c0(@NonNull Activity activity, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        f0(intentArr, activity, bundle);
    }

    public static void d(@NonNull Activity activity, @AnimRes int i, @AnimRes int i2) {
        activity.finish();
        activity.overridePendingTransition(i, i2);
    }

    public static void d0(@NonNull Intent[] intentArr) {
        f0(intentArr, Q(), null);
    }

    public static void e(@NonNull Activity activity, boolean z) {
        activity.finish();
        if (z) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static void e0(@NonNull Intent[] intentArr, @AnimRes int i, @AnimRes int i2) {
        Context contextQ = Q();
        f0(intentArr, contextQ, M(contextQ, i, i2));
    }

    public static void f(@NonNull Class<? extends Activity> cls) {
        h(cls, false);
    }

    public static void f0(Intent[] intentArr, Context context, @Nullable Bundle bundle) {
        if (!(context instanceof Activity)) {
            for (Intent intent : intentArr) {
                intent.addFlags(268435456);
            }
        }
        if (bundle != null) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
    }

    public static void g(@NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        for (Activity activity : i.I()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                activity.overridePendingTransition(i, i2);
            }
        }
    }

    public static void g0(@NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        f0(intentArr, Q(), bundle);
    }

    public static void h(@NonNull Class<? extends Activity> cls, boolean z) {
        for (Activity activity : i.I()) {
            if (activity.getClass().equals(cls)) {
                activity.finish();
                if (!z) {
                    activity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static void h0() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public static void i() {
        k(false);
    }

    public static void i0() {
        j0(Utils.a().getPackageName());
    }

    public static void j(@AnimRes int i, @AnimRes int i2) {
        for (Activity activity : i.I()) {
            activity.finish();
            activity.overridePendingTransition(i, i2);
        }
    }

    public static void j0(@NonNull String str) {
        String strI = I(str);
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        startActivity(str, strI);
    }

    public static void k(boolean z) {
        for (Activity activity : i.I()) {
            activity.finish();
            if (!z) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    public static void l() {
        n(false);
    }

    public static void m(@AnimRes int i, @AnimRes int i2) {
        List<Activity> listI = i.I();
        for (int i3 = 1; i3 < listI.size(); i3++) {
            d(listI.get(i3), i, i2);
        }
    }

    public static void n(boolean z) {
        List<Activity> listI = i.I();
        for (int i = 1; i < listI.size(); i++) {
            e(listI.get(i), z);
        }
    }

    public static void o(@NonNull Class<? extends Activity> cls) {
        q(cls, false);
    }

    public static void p(@NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        for (Activity activity : i.I()) {
            if (!activity.getClass().equals(cls)) {
                d(activity, i, i2);
            }
        }
    }

    public static void q(@NonNull Class<? extends Activity> cls, boolean z) {
        for (Activity activity : i.I()) {
            if (!activity.getClass().equals(cls)) {
                e(activity, z);
            }
        }
    }

    public static boolean r(@NonNull Activity activity, boolean z) {
        return t(activity, z, false);
    }

    public static boolean s(@NonNull Activity activity, boolean z, @AnimRes int i, @AnimRes int i2) {
        for (Activity activity2 : i.I()) {
            if (activity2.equals(activity)) {
                if (!z) {
                    return true;
                }
                d(activity2, i, i2);
                return true;
            }
            d(activity2, i, i2);
        }
        return false;
    }

    public static void startActivity(@NonNull Class<? extends Activity> cls) {
        Context contextQ = Q();
        startActivity(contextQ, (Bundle) null, contextQ.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, (Bundle) null);
    }

    public static boolean t(@NonNull Activity activity, boolean z, boolean z2) {
        for (Activity activity2 : i.I()) {
            if (activity2.equals(activity)) {
                if (!z) {
                    return true;
                }
                e(activity2, z2);
                return true;
            }
            e(activity2, z2);
        }
        return false;
    }

    public static boolean u(@NonNull Class<? extends Activity> cls, boolean z) {
        return w(cls, z, false);
    }

    public static boolean v(@NonNull Class<? extends Activity> cls, boolean z, @AnimRes int i, @AnimRes int i2) {
        for (Activity activity : i.I()) {
            if (activity.getClass().equals(cls)) {
                if (!z) {
                    return true;
                }
                d(activity, i, i2);
                return true;
            }
            d(activity, i, i2);
        }
        return false;
    }

    public static boolean w(@NonNull Class<? extends Activity> cls, boolean z, boolean z2) {
        for (Activity activity : i.I()) {
            if (activity.getClass().equals(cls)) {
                if (!z) {
                    return true;
                }
                e(activity, z2);
                return true;
            }
            e(activity, z2);
        }
        return false;
    }

    @Nullable
    public static Activity x(@NonNull Context context) {
        Activity activityY = y(context);
        if (R(activityY)) {
            return activityY;
        }
        return null;
    }

    @Nullable
    public static Activity y(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (context instanceof ContextWrapper) {
            if (!(context instanceof Activity)) {
                Activity activityZ = z(context);
                if (activityZ == null) {
                    arrayList.add(context);
                    context = ((ContextWrapper) context).getBaseContext();
                    if (context == null || arrayList.contains(context)) {
                        break;
                    }
                } else {
                    return activityZ;
                }
            } else {
                return (Activity) context;
            }
        }
        return null;
    }

    @Nullable
    public static Activity z(@Nullable Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivityContext");
                declaredField.setAccessible(true);
                return (Activity) ((WeakReference) declaredField.get(context)).get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, bundle);
    }

    public static void startActivity(@NonNull Class<? extends Activity> cls, @Nullable Bundle bundle) {
        Context contextQ = Q();
        startActivity(contextQ, (Bundle) null, contextQ.getPackageName(), cls.getName(), bundle);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, L(activity, viewArr));
    }

    public static void startActivity(@NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        Context contextQ = Q();
        startActivity(contextQ, (Bundle) null, contextQ.getPackageName(), cls.getName(), M(contextQ, i, i2));
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i, M(activity, i2, i3));
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> cls) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i, (Bundle) null);
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), bundle);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle2) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i, bundle2);
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, View... viewArr) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), L(activity, viewArr));
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i, L(activity, viewArr));
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        startActivity(activity, (Bundle) null, activity.getPackageName(), cls.getName(), M(activity, i, i2));
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i, M(activity, i2, i3));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Class<? extends Activity> cls) {
        Context contextQ = Q();
        startActivity(contextQ, bundle, contextQ.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i) {
        startActivityForResult(activity, bundle, str, str2, i, (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, @Nullable Bundle bundle2) {
        startActivityForResult(activity, bundle, str, str2, i, bundle2);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle2) {
        Context contextQ = Q();
        startActivity(contextQ, bundle, contextQ.getPackageName(), cls.getName(), bundle2);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, View... viewArr) {
        startActivityForResult(activity, bundle, str, str2, i, L(activity, viewArr));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        Context contextQ = Q();
        startActivity(contextQ, bundle, contextQ.getPackageName(), cls.getName(), M(contextQ, i, i2));
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(activity, bundle, str, str2, i, M(activity, i2, i3));
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i) {
        startActivityForResult(intent, activity, i, (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        startActivityForResult(intent, activity, i, bundle);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i, View... viewArr) {
        startActivityForResult(intent, activity, i, L(activity, viewArr));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle2) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), bundle2);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, View... viewArr) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), L(activity, viewArr));
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(intent, activity, i, M(activity, i2, i3));
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i) {
        startActivityForResult(fragment, (Bundle) null, Utils.a().getPackageName(), cls.getName(), i, (Bundle) null);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull Class<? extends Activity> cls, @AnimRes int i, @AnimRes int i2) {
        startActivity(activity, bundle, activity.getPackageName(), cls.getName(), M(activity, i, i2));
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle) {
        startActivityForResult(fragment, (Bundle) null, Utils.a().getPackageName(), cls.getName(), i, bundle);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        startActivityForResult(fragment, (Bundle) null, Utils.a().getPackageName(), cls.getName(), i, O(fragment, viewArr));
    }

    public static void startActivity(@NonNull String str, @NonNull String str2) {
        startActivity(Q(), (Bundle) null, str, str2, (Bundle) null);
    }

    public static void startActivity(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        startActivity(Q(), (Bundle) null, str, str2, bundle);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(fragment, (Bundle) null, Utils.a().getPackageName(), cls.getName(), i, N(fragment, i2, i3));
    }

    public static void startActivity(@NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        Context contextQ = Q();
        startActivity(contextQ, (Bundle) null, str, str2, M(contextQ, i, i2));
    }

    public static void startActivity(@NonNull Activity activity, @NonNull String str, @NonNull String str2) {
        startActivity(activity, (Bundle) null, str, str2, (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i) {
        startActivityForResult(fragment, bundle, Utils.a().getPackageName(), cls.getName(), i, (Bundle) null);
    }

    public static void startActivity(@NonNull Activity activity, @NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        startActivity(activity, (Bundle) null, str, str2, bundle);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @Nullable Bundle bundle2) {
        startActivityForResult(fragment, bundle, Utils.a().getPackageName(), cls.getName(), i, bundle2);
    }

    public static void startActivity(@NonNull Activity activity, @NonNull String str, @NonNull String str2, View... viewArr) {
        startActivity(activity, (Bundle) null, str, str2, L(activity, viewArr));
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, View... viewArr) {
        startActivityForResult(fragment, bundle, Utils.a().getPackageName(), cls.getName(), i, O(fragment, viewArr));
    }

    public static void startActivity(@NonNull Activity activity, @NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        startActivity(activity, (Bundle) null, str, str2, M(activity, i, i2));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2) {
        startActivity(Q(), bundle, str, str2, (Bundle) null);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2, @Nullable Bundle bundle2) {
        startActivity(Q(), bundle, str, str2, bundle2);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull Class<? extends Activity> cls, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(fragment, bundle, Utils.a().getPackageName(), cls.getName(), i, N(fragment, i2, i3));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        Context contextQ = Q();
        startActivity(contextQ, bundle, str, str2, M(contextQ, i, i2));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2) {
        startActivity(activity, bundle, str, str2, (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i) {
        startActivityForResult(fragment, bundle, str, str2, i, (Bundle) null);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, @Nullable Bundle bundle2) {
        startActivity(activity, bundle, str, str2, bundle2);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i, @Nullable Bundle bundle2) {
        startActivityForResult(fragment, bundle, str, str2, i, bundle2);
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, View... viewArr) {
        startActivity(activity, bundle, str, str2, L(activity, viewArr));
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i, View... viewArr) {
        startActivityForResult(fragment, bundle, str, str2, i, O(fragment, viewArr));
    }

    public static void startActivity(@NonNull Bundle bundle, @NonNull Activity activity, @NonNull String str, @NonNull String str2, @AnimRes int i, @AnimRes int i2) {
        startActivity(activity, bundle, str, str2, M(activity, i, i2));
    }

    public static boolean startActivity(@NonNull Intent intent) {
        return startActivity(intent, Q(), (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Bundle bundle, @NonNull Fragment fragment, @NonNull String str, @NonNull String str2, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(fragment, bundle, str, str2, i, N(fragment, i2, i3));
    }

    public static boolean startActivity(@NonNull Intent intent, @Nullable Bundle bundle) {
        return startActivity(intent, Q(), bundle);
    }

    public static boolean startActivity(@NonNull Intent intent, @AnimRes int i, @AnimRes int i2) {
        Context contextQ = Q();
        return startActivity(intent, contextQ, M(contextQ, i, i2));
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Intent intent, int i) {
        startActivityForResult(intent, fragment, i, (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        startActivityForResult(intent, fragment, i, bundle);
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Intent intent) {
        startActivity(intent, activity, (Bundle) null);
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Intent intent, int i, View... viewArr) {
        startActivityForResult(intent, fragment, i, O(fragment, viewArr));
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Intent intent, @Nullable Bundle bundle) {
        startActivity(intent, activity, bundle);
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Intent intent, View... viewArr) {
        startActivity(intent, activity, L(activity, viewArr));
    }

    public static void startActivityForResult(@NonNull Fragment fragment, @NonNull Intent intent, int i, @AnimRes int i2, @AnimRes int i3) {
        startActivityForResult(intent, fragment, i, N(fragment, i2, i3));
    }

    public static void startActivity(@NonNull Activity activity, @NonNull Intent intent, @AnimRes int i, @AnimRes int i2) {
        startActivity(intent, activity, M(activity, i, i2));
    }

    private static void startActivity(Context context, Bundle bundle, String str, String str2, @Nullable Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        startActivity(intent, context, bundle2);
    }

    private static boolean startActivityForResult(Activity activity, Bundle bundle, String str, String str2, int i, @Nullable Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return startActivityForResult(intent, activity, i, bundle2);
    }

    private static boolean startActivity(Intent intent, Context context, Bundle bundle) {
        if (!W(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (bundle != null) {
            context.startActivity(intent, bundle);
            return true;
        }
        context.startActivity(intent);
        return true;
    }

    private static boolean startActivityForResult(Intent intent, Activity activity, int i, @Nullable Bundle bundle) {
        if (!W(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (bundle != null) {
            activity.startActivityForResult(intent, i, bundle);
            return true;
        }
        activity.startActivityForResult(intent, i);
        return true;
    }

    private static boolean startActivityForResult(Fragment fragment, Bundle bundle, String str, String str2, int i, @Nullable Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return startActivityForResult(intent, fragment, i, bundle2);
    }

    private static boolean startActivityForResult(Intent intent, Fragment fragment, int i, @Nullable Bundle bundle) {
        if (!W(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (fragment.getActivity() != null) {
            if (bundle != null) {
                fragment.startActivityForResult(intent, i, bundle);
                return true;
            }
            fragment.startActivityForResult(intent, i);
            return true;
        }
        Log.e("ActivityUtils", "Fragment " + fragment + " not attached to Activity");
        return false;
    }
}
