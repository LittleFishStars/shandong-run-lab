package android.taobao.windvane.runtimepermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.alibaba.triver.basic.api.RequestPermission;
import com.hjq.permissions.Permission;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C0013a f21240a;

    /* JADX INFO: renamed from: android.taobao.windvane.runtimepermission.a$a, reason: collision with other inner class name */
    public static class C0013a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f21241a;
        private String[] b;
        private String c;
        private Runnable d;
        private Runnable e;

        private void c() {
            this.f21241a = null;
            this.d = null;
            this.e = null;
        }

        public C0013a b(Runnable runnable) {
            this.e = runnable;
            return this;
        }

        public void b() {
            String[] strArr = this.b;
            if (strArr.length == 1 && strArr[0].equals(Permission.SYSTEM_ALERT_WINDOW)) {
                if (Settings.canDrawOverlays(this.f21241a)) {
                    this.d.run();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this.f21241a, PermissionActivity.class);
                intent.putExtra(RequestPermission.PERMISSIONS, this.b);
                C0013a unused = a.f21240a = this;
                this.f21241a.startActivity(intent);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : this.b) {
                try {
                    if (ContextCompat.checkSelfPermission(this.f21241a, str) != 0) {
                        arrayList.add(str);
                    }
                } catch (Throwable unused2) {
                    this.d.run();
                    return;
                }
            }
            if (arrayList.size() == 0) {
                this.d.run();
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClass(this.f21241a, PermissionActivity.class);
            if (!(this.f21241a instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            intent2.putExtra(RequestPermission.PERMISSIONS, this.b);
            intent2.putExtra("explain", this.c);
            C0013a unused3 = a.f21240a = this;
            this.f21241a.startActivity(intent2);
        }

        public Context a() {
            return this.f21241a;
        }

        public C0013a a(String str) {
            this.c = str;
            return this;
        }

        public C0013a a(Runnable runnable) {
            if (runnable != null) {
                this.d = runnable;
                return this;
            }
            throw new NullPointerException("permissionGrantedRunnable is null");
        }

        public void a(boolean z) {
            if (z) {
                Runnable runnable = this.d;
                if (runnable != null) {
                    runnable.run();
                }
            } else {
                Runnable runnable2 = this.e;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
            c();
        }
    }

    public static synchronized C0013a a(Context context, String[] strArr) {
        C0013a c0013a;
        try {
            if (context == null) {
                throw new NullPointerException("context can not be null");
            }
            if (strArr == null || strArr.length == 0) {
                throw new NullPointerException("permissions can not be null");
            }
            c0013a = new C0013a();
            c0013a.f21241a = context;
            c0013a.b = strArr;
        } catch (Throwable th) {
            throw th;
        }
        return c0013a;
    }

    public static synchronized C0013a a(Activity activity) {
        return a(activity, new String[]{Permission.SYSTEM_ALERT_WINDOW});
    }

    public static void a(int i, String[] strArr, int[] iArr) {
        C0013a c0013a = f21240a;
        if (c0013a != null) {
            c0013a.a(a(iArr));
            f21240a = null;
        }
    }

    public static void a(int i, int i2, Intent intent) {
        C0013a c0013a = f21240a;
        c0013a.a(Settings.canDrawOverlays(c0013a.a()));
        f21240a = null;
    }

    private static boolean a(int[] iArr) {
        if (iArr.length < 1) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
