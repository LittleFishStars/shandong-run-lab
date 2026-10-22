package com.blankj.utilcode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.constant.PermissionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class PermissionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PermissionUtils f28167a;
    public static SimpleCallback b;
    public static SimpleCallback c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FullCallback f1325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnExplainListener f1326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRationaleListener f1327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SimpleCallback f1328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SingleCallback f1329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ThemeCallback f1330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f1331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Set<String> f1332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f1333a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<String> f1334b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<String> f1335c;
    public List<String> d;

    public interface FullCallback {
        void a(@NonNull List<String> list);

        void b(@NonNull List<String> list, @NonNull List<String> list2);
    }

    public interface OnExplainListener {

        public interface ShouldRequest {
            void a(boolean z);
        }

        void a(@NonNull UtilsTransActivity utilsTransActivity, @NonNull List<String> list, @NonNull ShouldRequest shouldRequest);
    }

    public interface OnRationaleListener {

        public interface ShouldRequest {
            void a(boolean z);
        }

        void a(@NonNull UtilsTransActivity utilsTransActivity, @NonNull ShouldRequest shouldRequest);
    }

    @RequiresApi(api = 23)
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        public class a implements Utils.Consumer<Intent> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f28168a;

            public a(int i) {
                this.f28168a = i;
            }

            @Override // com.blankj.utilcode.util.Utils.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra("TYPE", this.f28168a);
            }
        }

        public class b implements OnExplainListener.ShouldRequest {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ UtilsTransActivity f1336a;

            public b(UtilsTransActivity utilsTransActivity) {
                this.f1336a = utilsTransActivity;
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.OnExplainListener.ShouldRequest
            public void a(boolean z) {
                if (z) {
                    PermissionActivityImpl.this.requestPermissions(this.f1336a);
                } else {
                    this.f1336a.finish();
                }
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ UtilsTransActivity f1337a;

            public c(UtilsTransActivity utilsTransActivity) {
                this.f1337a = utilsTransActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f1337a.requestPermissions((String[]) PermissionUtils.f28167a.f1331a.toArray(new String[0]), 1);
            }
        }

        private void checkRequestCallback(int i) {
            if (i == 2) {
                if (PermissionUtils.b == null) {
                    return;
                }
                if (PermissionUtils.B()) {
                    PermissionUtils.b.onGranted();
                } else {
                    PermissionUtils.b.onDenied();
                }
                PermissionUtils.b = null;
                return;
            }
            if (i != 3 || PermissionUtils.c == null) {
                return;
            }
            if (PermissionUtils.A()) {
                PermissionUtils.c.onGranted();
            } else {
                PermissionUtils.c.onDenied();
            }
            PermissionUtils.c = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestPermissions(UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.f28167a.M(utilsTransActivity, new c(utilsTransActivity))) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.f28167a.f1331a.toArray(new String[0]), 1);
        }

        public static void start(int i) {
            UtilsTransActivity.U(new a(i), INSTANCE);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(@NonNull UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra("TYPE", -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    currentRequestCode = 2;
                    PermissionUtils.P(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    currentRequestCode = 3;
                    PermissionUtils.N(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.f28167a == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f28167a.f1331a == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f28167a.f1331a.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f28167a.f1330a != null) {
                PermissionUtils.f28167a.f1330a.onActivityCreate(utilsTransActivity);
            }
            if (PermissionUtils.f28167a.f1326a == null) {
                requestPermissions(utilsTransActivity);
            } else {
                PermissionUtils.f28167a.f1326a.a(utilsTransActivity, PermissionUtils.f28167a.f1331a, new b(utilsTransActivity));
                PermissionUtils.f28167a.f1326a = null;
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(@NonNull UtilsTransActivity utilsTransActivity) {
            int i = currentRequestCode;
            if (i != -1) {
                checkRequestCallback(i);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(@NonNull UtilsTransActivity utilsTransActivity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.f28167a == null || PermissionUtils.f28167a.f1331a == null) {
                return;
            }
            PermissionUtils.f28167a.D(utilsTransActivity);
        }
    }

    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    public interface SingleCallback {
        void a(boolean z, @NonNull List<String> list, @NonNull List<String> list2, @NonNull List<String> list3);
    }

    public interface ThemeCallback {
        void onActivityCreate(@NonNull Activity activity);
    }

    public class a implements OnRationaleListener.ShouldRequest {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UtilsTransActivity f1338a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f1339a;

        public a(Runnable runnable, UtilsTransActivity utilsTransActivity) {
            this.f1339a = runnable;
            this.f1338a = utilsTransActivity;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.OnRationaleListener.ShouldRequest
        public void a(boolean z) {
            if (!z) {
                this.f1338a.finish();
                PermissionUtils.this.J();
                return;
            }
            PermissionUtils.this.f1335c = new ArrayList();
            PermissionUtils.this.d = new ArrayList();
            this.f1339a.run();
        }
    }

    public PermissionUtils(String... strArr) {
        this.f1333a = strArr;
        f28167a = this;
    }

    @RequiresApi(api = 23)
    public static boolean A() {
        return Settings.canDrawOverlays(Utils.a());
    }

    @RequiresApi(api = 23)
    public static boolean B() {
        return Settings.System.canWrite(Utils.a());
    }

    public static void C() {
        Intent intentW = i.W(Utils.a().getPackageName(), true);
        if (i.w0(intentW)) {
            Utils.a().startActivity(intentW);
        }
    }

    public static PermissionUtils E(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public static PermissionUtils F(String... strArr) {
        return E(strArr);
    }

    @RequiresApi(api = 23)
    public static void K(SimpleCallback simpleCallback) {
        if (!A()) {
            c = simpleCallback;
            PermissionActivityImpl.start(3);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    @RequiresApi(api = 23)
    public static void L(SimpleCallback simpleCallback) {
        if (!B()) {
            b = simpleCallback;
            PermissionActivityImpl.start(2);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    @TargetApi(23)
    public static void N(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (i.w0(intent)) {
            activity.startActivityForResult(intent, i);
        } else {
            C();
        }
    }

    @TargetApi(23)
    public static void P(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (i.w0(intent)) {
            activity.startActivityForResult(intent, i);
        } else {
            C();
        }
    }

    public static List<String> u() {
        return v(Utils.a().getPackageName());
    }

    public static List<String> v(String str) {
        try {
            String[] strArr = Utils.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Pair<List<String>, List<String>> x(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> listU = u();
        for (String str : strArr) {
            boolean z = false;
            for (String str2 : PermissionConstants.a(str)) {
                if (listU.contains(str2)) {
                    arrayList.add(str2);
                    z = true;
                }
            }
            if (!z) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    public static boolean y(String str) {
        return ContextCompat.checkSelfPermission(Utils.a(), str) == 0;
    }

    public static boolean z(String... strArr) {
        Pair<List<String>, List<String>> pairX = x(strArr);
        if (!((List) pairX.second).isEmpty()) {
            return false;
        }
        Iterator it = ((List) pairX.first).iterator();
        while (it.hasNext()) {
            if (!y((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void D(Activity activity) {
        w(activity);
        J();
    }

    public final void G(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        w(utilsTransActivity);
        this.f1327a.a(utilsTransActivity, new a(runnable, utilsTransActivity));
    }

    public PermissionUtils H(OnRationaleListener onRationaleListener) {
        this.f1327a = onRationaleListener;
        return this;
    }

    public void I() {
        String[] strArr = this.f1333a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.f1332a = new LinkedHashSet();
        this.f1331a = new ArrayList();
        this.f1334b = new ArrayList();
        this.f1335c = new ArrayList();
        this.d = new ArrayList();
        Pair<List<String>, List<String>> pairX = x(this.f1333a);
        this.f1332a.addAll((Collection) pairX.first);
        this.f1335c.addAll((Collection) pairX.second);
        for (String str : this.f1332a) {
            if (y(str)) {
                this.f1334b.add(str);
            } else {
                this.f1331a.add(str);
            }
        }
        if (this.f1331a.isEmpty()) {
            J();
        } else {
            O();
        }
    }

    public final void J() {
        SingleCallback singleCallback = this.f1329a;
        if (singleCallback != null) {
            singleCallback.a(this.f1335c.isEmpty(), this.f1334b, this.d, this.f1335c);
            this.f1329a = null;
        }
        if (this.f1328a != null) {
            if (this.f1335c.isEmpty()) {
                this.f1328a.onGranted();
            } else {
                this.f1328a.onDenied();
            }
            this.f1328a = null;
        }
        if (this.f1325a != null) {
            if (this.f1331a.size() == 0 || this.f1334b.size() > 0) {
                this.f1325a.a(this.f1334b);
            }
            if (!this.f1335c.isEmpty()) {
                this.f1325a.b(this.d, this.f1335c);
            }
            this.f1325a = null;
        }
        this.f1327a = null;
        this.f1330a = null;
    }

    @RequiresApi(api = 23)
    public final boolean M(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        boolean z = false;
        if (this.f1327a != null) {
            Iterator<String> it = this.f1331a.iterator();
            while (it.hasNext()) {
                if (utilsTransActivity.shouldShowRequestPermissionRationale(it.next())) {
                    G(utilsTransActivity, runnable);
                    z = true;
                    break;
                }
            }
            this.f1327a = null;
        }
        return z;
    }

    @RequiresApi(api = 23)
    public final void O() {
        PermissionActivityImpl.start(1);
    }

    public PermissionUtils Q(ThemeCallback themeCallback) {
        this.f1330a = themeCallback;
        return this;
    }

    public PermissionUtils q(FullCallback fullCallback) {
        this.f1325a = fullCallback;
        return this;
    }

    public PermissionUtils r(SimpleCallback simpleCallback) {
        this.f1328a = simpleCallback;
        return this;
    }

    public PermissionUtils s(SingleCallback singleCallback) {
        this.f1329a = singleCallback;
        return this;
    }

    public PermissionUtils t(OnExplainListener onExplainListener) {
        this.f1326a = onExplainListener;
        return this;
    }

    public final void w(Activity activity) {
        for (String str : this.f1331a) {
            if (y(str)) {
                this.f1334b.add(str);
            } else {
                this.f1335c.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.d.add(str);
                }
            }
        }
    }
}
