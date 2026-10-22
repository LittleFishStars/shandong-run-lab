package com.beizi.fusion;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a4 {
    private static a4 D;
    public static String E;
    private List A;
    private String B;
    private boolean C;
    private String c;
    private String d;
    public List e;
    private boolean p;
    private boolean q;
    public Context u;
    private DisplayMetrics v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26994a = false;
    public String b = null;
    public boolean f = false;
    public String g = "";
    public HashMap h = new HashMap();
    private HashSet i = new HashSet();
    private HashSet j = new HashSet();
    private HashSet k = new HashSet();
    private HashSet l = new HashSet();
    private HashSet m = new HashSet();
    private HashSet n = new HashSet();
    private int o = -1;
    private Handler r = new a(Looper.getMainLooper());
    private Handler s = null;
    private HandlerThread t = null;
    private boolean w = false;
    private boolean x = false;
    private int y = 0;
    private List z = new ArrayList();

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Log.e("openDeeplink", "count:" + a4.this.y + ";onActivityDestroyed" + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                List list = a4.this.z;
                if (list == null || list.size() <= 0) {
                    return;
                }
                Iterator it = a4.this.z.iterator();
                while (it.hasNext()) {
                    m1 m1Var = (m1) it.next();
                    if (m1Var != null) {
                        m1Var.b();
                    }
                    it.remove();
                }
                a4.this.z.clear();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a4.this.y++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            List list;
            try {
                a4 a4Var = a4.this;
                int i = a4Var.y - 1;
                a4Var.y = i;
                if (i < 0) {
                    a4Var.y = 0;
                }
                if (a4Var.y != 0 || (list = a4Var.z) == null || list.size() <= 0) {
                    return;
                }
                Iterator it = a4.this.z.iterator();
                while (it.hasNext()) {
                    m1 m1Var = (m1) it.next();
                    if (m1Var != null) {
                        m1Var.a();
                    }
                    it.remove();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x4 f26997a;

        public c(x4 x4Var) {
            this.f26997a = x4Var;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                if (TextUtils.isEmpty(h3.b(this.f26997a.toString()))) {
                    return;
                }
                b8.a(a4.this.u, "blackList", h3.b(this.f26997a.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static a4 j() {
        a4 a4Var;
        synchronized (a4.class) {
            if (D == null) {
                D = new a4();
            }
            a4Var = D;
        }
        return a4Var;
    }

    private void k() throws Throwable {
        ArrayList arrayListA;
        try {
            Context context = this.u;
            if (context == null) {
                return;
            }
            String strA = b8.a(context, "blackList");
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            String strA2 = h3.a(strA);
            if (TextUtils.isEmpty(strA2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA2);
            if (jSONObject.has(GoodsSpecificationPreviewActivity.z) && (arrayListA = a(jSONObject.optJSONArray(GoodsSpecificationPreviewActivity.z))) != null && arrayListA.size() > 0) {
                this.A = arrayListA;
            }
            if (jSONObject.has("version")) {
                String strOptString = jSONObject.optString("version");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                this.B = strOptString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean o() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME");
    }

    public void a(Context context, String str) {
        synchronized (a4.class) {
            try {
                if (context == null) {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
                Log.i("lance", "SDK_VERSION:5.5.0.2");
                this.u = context.getApplicationContext();
                try {
                    E = str;
                    u3.b().a();
                    r();
                    k();
                    n();
                } catch (Throwable unused) {
                }
                this.v = context.getResources().getDisplayMetrics();
                this.x = true;
                if (Build.VERSION.SDK_INT >= 28) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return E;
    }

    public String d() {
        String strA = h3.a("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        return this.f26994a ? strA.replace("http:", "https:") : strA;
    }

    public List e() {
        return this.A;
    }

    public String f() {
        return TextUtils.isEmpty(this.B) ? "0" : this.B;
    }

    public Context g() {
        return this.u;
    }

    public int h() {
        return this.o;
    }

    public List i() {
        return this.e;
    }

    public String l() {
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        return this.c;
    }

    public String m() {
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        return this.d;
    }

    public void n() {
        try {
            if (!o()) {
                this.C = false;
                return;
            }
            zh zhVar = new zh();
            boolean zB = zhVar.b();
            this.C = zB;
            if (zB) {
                zhVar.a(this.u, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean p() {
        return this.C;
    }

    public boolean q() {
        if (this.q) {
            return this.p;
        }
        this.q = true;
        boolean zD = hq.d();
        this.p = zD;
        return zD;
    }

    public void r() {
        try {
            ((Application) this.u.getApplicationContext()).registerActivityLifecycleCallbacks(new b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        return d() + "/mb/sdk0/json";
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    private void a() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused) {
        }
    }

    public void a(m1 m1Var) {
        this.z.add(m1Var);
    }

    public void a(List list) {
        this.e = list;
    }

    public String a(String str) {
        w1 w1Var = new w1();
        w1Var.d(str);
        w1Var.c(po.a());
        w1Var.a(false);
        w1Var.a(2);
        return new vi().b(w1Var);
    }

    public void a(Context context) {
        this.u = context;
    }

    public void a(x4 x4Var) {
        if (x4Var == null) {
            return;
        }
        try {
            String strB = x4Var.b();
            if (TextUtils.isEmpty(strB) || strB.equals(this.B)) {
                return;
            }
            this.A = x4Var.a();
            this.B = strB;
            w3.c().g().execute(new c(x4Var));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList a(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
