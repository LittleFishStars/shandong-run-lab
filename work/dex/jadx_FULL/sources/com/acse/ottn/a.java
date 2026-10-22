package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.acse.ottn.activity.TransparentGreenActivity;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static a e = null;
    public static String f = "AccessibilityUtil";
    public static final int g = 3;
    public static final long h = 60000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22774a = false;
    public boolean b = false;
    public boolean c = false;
    public long[] d = new long[3];

    /* JADX INFO: renamed from: com.acse.ottn.a$a, reason: collision with other inner class name */
    public class C0088a extends AccessibilityService.GestureResultCallback {
        public C0088a() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    public class b extends AccessibilityService.GestureResultCallback {
        public b() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    public class c extends AccessibilityService.GestureResultCallback {
        public c() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22778a;

        public d(Activity activity) {
            this.f22778a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f22778a, (Class<?>) TransparentGreenActivity.class);
                intent.setFlags(268435456);
                this.f22778a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22779a;

        public e(Activity activity) {
            this.f22779a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f22779a, (Class<?>) TransparentGreenActivity.class);
                intent.setFlags(268435456);
                this.f22779a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22780a;

        public f(Activity activity) {
            this.f22780a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f22780a, (Class<?>) TransparentGreenActivity.class);
                intent.setFlags(268435456);
                this.f22780a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class g implements z0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22781a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        /* JADX INFO: renamed from: com.acse.ottn.a$g$a, reason: collision with other inner class name */
        public class RunnableC0089a implements Runnable {
            public RunnableC0089a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(g.this.f22781a, (Class<?>) TransparentGreenActivity.class);
                    intent.setFlags(268435456);
                    g.this.f22781a.startActivity(intent);
                } catch (Throwable unused) {
                }
            }
        }

        public g(Activity activity, int i, int i2) {
            this.f22781a = activity;
            this.b = i;
            this.c = i2;
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            if (this.c >= 1) {
                this.f22781a.finish();
            }
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            n3.a().a("oppo_start_white_list", Boolean.TRUE);
            new Handler().postDelayed(new RunnableC0089a(), 500L);
            try {
                this.f22781a.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), this.b);
            } catch (Exception e) {
                this.f22781a.startActivityForResult(new Intent("android.settings.SETTINGS"), this.b);
                e.printStackTrace();
            }
        }
    }

    public static a c() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    public void a(boolean z) {
        this.f22774a = z;
    }

    public String b(Context context) {
        if (n3.a() == null) {
            return "";
        }
        if (TextUtils.isEmpty(n3.a().e("appName"))) {
            try {
                n3.a().b("appName", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName);
            } catch (Exception e2) {
                h2.a("error", e2.getMessage());
            }
        }
        return n3.a().e("appName");
    }

    public boolean d() {
        return n3.a().a("red_package_state");
    }

    @RequiresApi(api = 18)
    public void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(childCount);
                if (child != null) {
                    CharSequence text = child.getText();
                    if (text != null && (text.toString().equals("微信红包") || text.toString().contains("[微信红包]"))) {
                        for (AccessibilityNodeInfo parent = child.getParent(); parent != null; parent = parent.getParent()) {
                            if (parent.getChildCount() == 2) {
                                parent.performAction(16);
                                break;
                            }
                        }
                    }
                    if (this.c) {
                        return;
                    } else {
                        e(child);
                    }
                }
            }
        }
    }

    public boolean f() {
        return this.f22774a;
    }

    public final Object g() throws ObjectStreamException {
        return e;
    }

    @RequiresApi(api = 16)
    public boolean h(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean i(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    public void a(Activity activity, boolean z) {
        if (activity != null) {
            if (z) {
                q2.b().a("close_shophelp");
            } else {
                q2.b().a("open_shophelp");
            }
        }
        n3.a().a("AccessiblityOnOrOff", Boolean.valueOf(z));
    }

    @RequiresApi(api = 16)
    public boolean d(AccessibilityService accessibilityService, String str, int i) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        ArrayList arrayList = new ArrayList();
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return arrayList.size() > i ? f((AccessibilityNodeInfo) arrayList.get(i)) : f((AccessibilityNodeInfo) arrayList.get(0));
    }

    public final boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isLongClickable()) {
            return accessibilityNodeInfo.performAction(32);
        }
        f(accessibilityNodeInfo.getParent());
        return false;
    }

    public void g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        while (accessibilityNodeInfo != null) {
            if (accessibilityNodeInfo.isClickable()) {
                accessibilityNodeInfo.performAction(16);
                return;
            }
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
        }
    }

    public boolean a() {
        return i1.b().a(HelpShopAppUtil.getContext());
    }

    @RequiresApi(api = 16)
    public void f(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    @TargetApi(18)
    public List<AccessibilityNodeInfo> g(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    public void a(AppCompatActivity appCompatActivity, int i) {
        i1.b().b(appCompatActivity, i);
    }

    public boolean a(Context context, Class cls) {
        if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
            return false;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (!TextUtils.isEmpty(string)) {
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(com.google.common.net.c.b);
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(context.getPackageName() + WVNativeCallbackUtil.SEPERATER + cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean c(AccessibilityService accessibilityService, String str, int i) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        if (listFindAccessibilityNodeInfosByViewId != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.size() > i) {
            return f((AccessibilityNodeInfo) arrayList.get(i));
        }
        return f((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
    }

    public void b(Activity activity, boolean z) {
        n3.a().a("red_package_state", Boolean.valueOf(z));
    }

    public boolean b() {
        return n3.a().a("AccessiblityOnOrOff");
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str, int i) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        ArrayList arrayList = new ArrayList();
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.size() > i) {
            return c((AccessibilityNodeInfo) arrayList.get(i));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public void e(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str, int i) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        if (listFindAccessibilityNodeInfosByViewId != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.size() > i) {
            return c((AccessibilityNodeInfo) arrayList.get(i));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
    }

    @TargetApi(18)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) == null || listFindAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                g(accessibilityNodeInfo);
                return;
            }
        }
    }

    public final boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        c(accessibilityNodeInfo.getParent());
        return false;
    }

    public final boolean e() {
        return ((AppOpsManager) HelpShopAppUtil.getContext().getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", HelpShopAppUtil.getContext().getApplicationInfo().uid, HelpShopAppUtil.getContext().getPackageName()) == 0 && HelpShopAppUtil.getContext().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public final void c(AccessibilityService accessibilityService) {
        if (n3.a() == null && n3.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.d;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.d;
        long j = jArr2[1];
        long j2 = jArr2[2];
        if (j == j2 || j2 == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.d;
        long j3 = jArr3[jArr3.length - 1];
        long j4 = jArr3[0];
    }

    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo accessibilityNodeInfoA = a(accessibilityNodeInfo.getChild(i), "com.tencent.mm:id/e7t");
            if (accessibilityNodeInfoA != null && accessibilityNodeInfoA.getText() != null && accessibilityNodeInfoA.getText().toString().contains("[微信红包]")) {
                g(accessibilityNodeInfoA);
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    return c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @TargetApi(18)
    public void c(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) == null || listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
            if (accessibilityNodeInfo != null) {
                g(accessibilityNodeInfo);
                return;
            }
        }
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i, int i2) {
        Path path = new Path();
        path.moveTo(i, i2);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new C0088a(), null);
    }

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i, int i2) {
        Path path = new Path();
        path.moveTo(i, i2);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new b(), null);
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i, int i2, int i3, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i, i2);
        path.lineTo(i3, i4);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i5)).build(), new c(), null);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean b(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return accessibilityService.performGlobalAction(2);
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    public void b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        accessibilityNodeInfo.performAction(2097152, bundle);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityService == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        return accessibilityNodeInfo.performAction(2097152, bundle);
    }

    public void b(Activity activity, int i, int i2) {
        try {
            q2.b().a("show_accessiblity_open_view");
            n3.a().a("battery_white_accessiblity", Boolean.TRUE);
            String strB = p4.b();
            Intent intent = new Intent("android.intent.action.MAIN");
            if (!"redmi".equals(strB) && !"xiaomi".equals(strB)) {
                if ("vivo".equals(strB)) {
                    if (Build.VERSION.SDK_INT >= 37) {
                        new Handler(Looper.getMainLooper()).postDelayed(new d(activity), 500L);
                        try {
                            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i);
                            return;
                        } catch (Exception e2) {
                            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i);
                            e2.printStackTrace();
                            return;
                        }
                    }
                    intent.setClassName("com.android.settings", "com.vivo.settings.VivoSubSettings");
                    intent.putExtra(":settings:show_fragment", "com.android.settings.accessibility.ToggleAccessibilityServicePreferenceFragment");
                    Bundle bundle = new Bundle();
                    ComponentName componentName = new ComponentName(activity, (Class<?>) ShopHelperService.class);
                    bundle.putParcelable("component_name", componentName);
                    bundle.putString("preference_key", componentName.flattenToString());
                    bundle.putString("title", h0.a().a(activity));
                    bundle.putString("summary", activity.getString(R.string.accessibility_description));
                    intent.putExtra(":settings:show_fragment_args", bundle);
                    activity.startActivity(intent);
                    return;
                    activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i);
                    e.printStackTrace();
                    return;
                }
                if (!"oppo".equals(strB) && !"realme".equals(strB) && !"oneplus".equals(strB)) {
                    if (g3.a().b() || "samsung".equals(strB)) {
                        new Handler().postDelayed(new f(activity), 500L);
                    }
                    try {
                        try {
                            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i);
                            return;
                        } catch (Exception e3) {
                            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i);
                            e3.printStackTrace();
                            return;
                        }
                    } catch (Exception e4) {
                        activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i);
                        e4.printStackTrace();
                        return;
                    }
                }
                new Handler().postDelayed(new e(activity), 500L);
                try {
                    activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i);
                    return;
                } catch (Exception e5) {
                    activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i);
                    e5.printStackTrace();
                    return;
                }
                activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i);
            }
            intent.setClassName("com.android.settings", "com.android.settings.SubSettings");
            intent.putExtra(":settings:show_fragment", "com.android.settings.accessibility.ToggleAccessibilityServicePreferenceFragment");
            Bundle bundle2 = new Bundle();
            ComponentName componentName2 = new ComponentName(activity, (Class<?>) ShopHelperService.class);
            bundle2.putParcelable("component_name", componentName2);
            bundle2.putString("preference_key", componentName2.flattenToString());
            bundle2.putString("title", h0.a().a(activity));
            bundle2.putString("summary", activity.getString(R.string.accessibility_description));
            intent.putExtra(":settings:show_fragment_args", bundle2);
            activity.startActivity(intent);
        } catch (Exception unused) {
            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean a(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return accessibilityService.performGlobalAction(1);
    }

    public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.performAction(8192);
    }

    public void a(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception unused) {
            System.exit(0);
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getParcelableData() == null || !(accessibilityEvent.getParcelableData() instanceof Notification)) {
            return;
        }
        try {
            ((Notification) accessibilityEvent.getParcelableData()).contentIntent.send();
        } catch (PendingIntent.CanceledException e2) {
            e2.printStackTrace();
        }
    }

    public void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if ("android.widget.Button".equals(child.getClassName())) {
                child.performAction(16);
            }
            a(accessibilityService, child);
        }
    }

    public void a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, float f2, float f3, int i, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f2, f3);
        a(accessibilityService, path, 0L, i, gestureResultCallback);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, Path path, long j, long j2, AccessibilityService.GestureResultCallback gestureResultCallback) {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path, j, j2));
        accessibilityService.dispatchGesture(builder.build(), gestureResultCallback, null);
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            h2.b("AccessibilityUtil", "accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.isClickable() == z) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        if (accessibilityNodeInfo != null && (listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isClickable() == z) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            if (accessibilityNodeInfo.getChild(childCount) != null && !str2.equals(accessibilityNodeInfo.getChild(childCount).getText())) {
                return accessibilityNodeInfo.getChild(childCount);
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        if (accessibilityNodeInfo != null && (listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str)) != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo2 != null) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    public final void a(Activity activity, int i, int i2) {
        z0.a(activity, "提示", "会帮你关闭 体适能的 支付保护（文案后期定）", "好的", false, new g(activity, i, i2));
    }
}
