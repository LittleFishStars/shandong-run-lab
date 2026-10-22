package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static b f = null;
    public static String g = "acse_AccessibilityUtil";
    public static final int h = 3;
    public static final long i = 60000;
    public CountDownTimer d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22868a = false;
    public boolean b = false;
    public boolean c = false;
    public long[] e = new long[3];

    public class a extends AccessibilityService.GestureResultCallback {
        public a() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
            h2.a("samonp-->", "点击回调");
        }
    }

    /* JADX INFO: renamed from: com.acse.ottn.b$b, reason: collision with other inner class name */
    public class C0097b extends AccessibilityService.GestureResultCallback {
        public C0097b() {
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

    public class e implements Consumer<String> {
        public e() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    public class f implements Consumer<Throwable> {
        public f() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public static b c() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b();
                }
            }
        }
        return f;
    }

    public void a(boolean z) {
        this.f22868a = z;
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str, int i2) {
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
        return arrayList.size() > i2 ? c((AccessibilityNodeInfo) arrayList.get(i2)) : c((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public boolean d(AccessibilityService accessibilityService, String str, int i2) {
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
        return arrayList.size() > i2 ? f((AccessibilityNodeInfo) arrayList.get(i2)) : f((AccessibilityNodeInfo) arrayList.get(0));
    }

    public boolean e() {
        int i2;
        String string;
        String strB = com.acse.ottn.a.c().b(HelpShopAppUtil.getContext());
        try {
            i2 = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e2) {
            h2.b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e2.getMessage());
            i2 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(com.google.common.net.c.b);
        if (i2 == 1 && (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().contains(strB)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean f() {
        return this.f22868a;
    }

    public final Object g() throws ObjectStreamException {
        return f;
    }

    public void h(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                accessibilityNodeInfo.getText().toString().trim();
                return;
            } else {
                if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
                    return;
                }
                accessibilityNodeInfo.getContentDescription().toString();
                return;
            }
        }
        if (accessibilityNodeInfo != null) {
            for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
                try {
                    if (accessibilityNodeInfo.getChild(i2) != null) {
                        h(accessibilityNodeInfo.getChild(i2));
                    }
                } catch (Throwable th) {
                    h2.a(g, th.getMessage());
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public void i(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            h2.a(g, "findViewByText2 accessibilityNodeInfo is null");
            return;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText == null || listFindAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        h2.a(g, "nodeInfoList size =" + listFindAccessibilityNodeInfosByText.size());
        for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                c().g(accessibilityNodeInfo);
            }
        }
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo j(AccessibilityService accessibilityService, String str) {
        return c(accessibilityService.getRootInActiveWindow(), str);
    }

    @TargetApi(18)
    public List<AccessibilityNodeInfo> k(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    @RequiresApi(api = 16)
    public boolean l(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean m(AccessibilityService accessibilityService, String str) {
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

    public boolean a() {
        return i1.b().a(HelpShopAppUtil.getContext());
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

    public void a(AppCompatActivity appCompatActivity, int i2) {
        i1.b().b(appCompatActivity, i2);
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

    @RequiresApi(api = 16)
    public void f(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 16)
    public void g(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f22872a;

        public d(AccessibilityService accessibilityService) {
            this.f22872a = accessibilityService;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            if (this.f22872a == null || b.c().f(this.f22872a, "com.tencent.mm:id/gix") == null) {
                return;
            }
            b.c().a(this.f22872a, "com.tencent.mm:id/gix");
            CountDownTimer countDownTimer = b.this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                b.this.d = null;
            }
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            b.this.d = null;
        }
    }

    @RequiresApi(api = 18)
    public boolean c(AccessibilityService accessibilityService, String str, int i2) {
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
        if (arrayList.size() > i2) {
            return f((AccessibilityNodeInfo) arrayList.get(i2));
        }
        return f((AccessibilityNodeInfo) arrayList.get(0));
    }

    @TargetApi(18)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
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
    public AccessibilityNodeInfo g(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str, int i2) {
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
        if (arrayList.size() > i2) {
            return c((AccessibilityNodeInfo) arrayList.get(i2));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo h(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            h2.b(g, "findViewByText1 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d = null;
        }
        CountDownTimer countDownTimerA = n0.a().a(2000, 50, new d(accessibilityService));
        this.d = countDownTimerA;
        countDownTimerA.start();
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

    public boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        c(accessibilityNodeInfo.getParent());
        return false;
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

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i2, int i3) {
        Path path = new Path();
        path.moveTo(i2, i3);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new C0097b(), null);
    }

    public final void c(AccessibilityService accessibilityService) {
        if (n3.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.e;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.e;
        long j = jArr2[1];
        long j2 = jArr2[2];
        if (j == j2 || j2 == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.e;
        long j3 = jArr3[jArr3.length - 1];
        long j4 = jArr3[0];
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

    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i2 = 0; i2 < accessibilityNodeInfo.getChildCount(); i2++) {
            AccessibilityNodeInfo accessibilityNodeInfoA = a(accessibilityNodeInfo.getChild(i2), "com.tencent.mm:id/e7t");
            if (accessibilityNodeInfoA != null && accessibilityNodeInfoA.getText() != null && accessibilityNodeInfoA.getText().toString().contains("[微信红包]")) {
                g(accessibilityNodeInfoA);
                return;
            }
        }
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

    @RequiresApi(api = 16)
    public void e(AccessibilityService accessibilityService) {
        try {
            h2.a("openOppenBatteryButton", "调用返回");
            Thread.sleep(150L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
    }

    public AccessibilityNodeInfo c(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null) {
            h2.b(g, "findViewByText3 accessibilityNodeInfo is null");
            return null;
        }
        h(accessibilityNodeInfo);
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2 != null && ((accessibilityNodeInfo2.getText() != null && str.equals(accessibilityNodeInfo2.getText().toString().trim())) || (accessibilityNodeInfo2.getContentDescription() != null && str.equals(accessibilityNodeInfo2.getContentDescription().toString().trim())))) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i2, int i3) {
        try {
            Path path = new Path();
            path.moveTo(i2, i3);
            return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new a(), null);
        } catch (Throwable unused) {
            h2.a("samonp-->", "点击失败 x= " + i2 + "   y = " + i3);
            return false;
        }
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    public String d() {
        return TextUtils.isEmpty(n3.a().e("plunin_id")) ? "" : n3.a().e("plunin_id");
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            h2.b(g, "findViewByText3 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        return a(accessibilityNodeInfo, str, false);
    }

    public void b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        accessibilityNodeInfo.performAction(2097152, bundle);
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i2, int i3, int i4, int i5, int i6) {
        try {
            Path path = new Path();
            path.moveTo(i2, i3);
            path.lineTo(i4, i5);
            return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i6)).build(), new c(), null);
        } catch (Throwable unused) {
            return false;
        }
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

    public void b() {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) HelpShopAppUtil.getContext().getSystemService("accessibility")).getInstalledAccessibilityServiceList();
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            String str = accessibilityServiceInfo.getResolveInfo().serviceInfo.name;
            String str2 = accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName;
            arrayList.add("应用名称：" + accessibilityServiceInfo.getResolveInfo().loadLabel(HelpShopAppUtil.getContext().getPackageManager()).toString() + "--->app包名：" + str2 + "---->service路径：" + str);
        }
        q2.b().b("accessiblity_list", JSON.toJSONString(arrayList));
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

    public void a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, float f2, float f3, int i2, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f2, f3);
        a(accessibilityService, path, 0L, i2, gestureResultCallback);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, Path path, long j, long j2, AccessibilityService.GestureResultCallback gestureResultCallback) {
        try {
            GestureDescription.Builder builder = new GestureDescription.Builder();
            builder.addStroke(new GestureDescription.StrokeDescription(path, j, j2));
            accessibilityService.dispatchGesture(builder.build(), gestureResultCallback, null);
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            h2.b(g, "findViewByText accessibilityNodeInfo is null text =" + str);
            return null;
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && str.equals(accessibilityNodeInfo.getText().toString().trim()) && accessibilityNodeInfo.isClickable() == z) {
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
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, String str2, String str3) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (listFindAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().toString().contains(str2) && accessibilityNodeInfo.getText().toString().contains(str3)) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityWindowInfo accessibilityWindowInfo, String str) {
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
        if (root != null && (listFindAccessibilityNodeInfosByViewId = root.findAccessibilityNodeInfosByViewId(str)) != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : listFindAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
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

    public void a(String str, String str2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("is_snt", "0");
        treeMap.put("sdk_version", f0.f);
        if (TextUtils.isEmpty(str)) {
            str = "n";
        }
        treeMap.put("state", str);
        treeMap.put("schoolId", str2);
        new g0().j(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).s5(new e(), new f());
    }

    public void a(String str) {
        if (n3.a() != null) {
            n3.a().b("plunin_id", str);
        }
    }
}
