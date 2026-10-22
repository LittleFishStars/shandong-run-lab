package com.acse.ottn;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.byazt.hv.TTDownloadField;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i1 {
    public static final String b = "FloatWindowManager";
    public static volatile i1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f23048a;

    public class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23049a;
        public final /* synthetic */ int b;

        public a(AppCompatActivity appCompatActivity, int i) {
            this.f23049a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (!z) {
                q2.b().a("cancle_flow_window_list");
                h2.b(i1.b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
                return;
            }
            q2.b().a("open_flow_window_list");
            try {
                String strA = n3.a().a("flow_window_state", "1");
                String strB = p4.b();
                if (("xiaomi".equals(strB) || "redmi".equals(strB) || "blackshark".equals(strB)) && !strA.equals("2")) {
                    n3.a().b("flow_window_state", "2");
                    n3.a().b("OpenPermissionName", "显示悬浮窗");
                    Intent intent = new Intent();
                    n3.a().a("battery_white", Boolean.TRUE);
                    ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                    intent.putExtra("extra_pkgname", this.f23049a.getPackageName());
                    intent.setComponent(componentName);
                    intent.addFlags(268435456);
                    this.f23049a.startActivityForResult(intent, this.b);
                    return;
                }
                if (strB.equals("vivo") && !strA.equals("2")) {
                    n3.a().b("flow_window_state", "2");
                    n3.a().a("battery_white", Boolean.TRUE);
                    Intent intent2 = new Intent();
                    intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                    intent2.putExtra("packagename", this.f23049a.getPackageName());
                    intent2.putExtra("tabId", "1");
                    this.f23049a.startActivity(intent2);
                    return;
                }
                Intent intent3 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                n3.a().b("flow_window_state", "3");
                intent3.setData(Uri.parse("package:" + this.f23049a.getPackageName()));
                n3.a().a("battery_white", Boolean.TRUE);
                this.f23049a.startActivityForResult(intent3, this.b);
            } catch (Exception unused) {
                Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                n3.a().b("flow_window_state", "3");
                intent4.setData(Uri.parse("package:" + this.f23049a.getPackageName()));
                n3.a().a("battery_white", Boolean.TRUE);
                this.f23049a.startActivityForResult(intent4, this.b);
            }
        }
    }

    public class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23050a;
        public final /* synthetic */ int b;

        public b(AppCompatActivity appCompatActivity, int i) {
            this.f23050a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (z) {
                m3.a((Activity) this.f23050a, this.b);
            } else {
                h2.b(i1.b, "ROM:360, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    public class c implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23051a;
        public final /* synthetic */ int b;

        public c(AppCompatActivity appCompatActivity, int i) {
            this.f23051a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (z) {
                s1.a((Activity) this.f23051a, this.b);
            } else {
                h2.b(i1.b, "ROM:huawei, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    public class d implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23052a;
        public final /* synthetic */ int b;

        public d(AppCompatActivity appCompatActivity, int i) {
            this.f23052a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (z) {
                o2.a(this.f23052a, this.b);
            } else {
                h2.b(i1.b, "ROM:meizu, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    public class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23053a;
        public final /* synthetic */ int b;

        public e(AppCompatActivity appCompatActivity, int i) {
            this.f23053a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (z) {
                p2.a((Activity) this.f23053a, this.b);
            } else {
                h2.b(i1.b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    public class f implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23054a;
        public final /* synthetic */ int b;

        public f(AppCompatActivity appCompatActivity, int i) {
            this.f23054a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (z) {
                h3.a((Activity) this.f23054a, this.b);
            } else {
                h2.b(i1.b, "ROM:miui, user manually refuse OVERLAY_PERMISSION");
            }
        }
    }

    public class g implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f23055a;
        public final /* synthetic */ int b;

        public g(AppCompatActivity appCompatActivity, int i) {
            this.f23055a = appCompatActivity;
            this.b = i;
        }

        @Override // com.acse.ottn.i1.i
        public void a(boolean z) {
            if (!z) {
                h2.a(i1.b, "user manually refuse OVERLAY_PERMISSION");
                return;
            }
            try {
                i1.e(this.f23055a, this.b);
            } catch (Exception e) {
                h2.b(i1.b, Log.getStackTraceString(e));
            }
        }
    }

    public class h implements z0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f23056a;

        public h(i iVar) {
            this.f23056a = iVar;
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            i1.this.f23048a.dismiss();
            this.f23056a.a(false);
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            this.f23056a.a(true);
            i1.this.f23048a.dismiss();
        }
    }

    public interface i {
        void a(boolean z);
    }

    public static i1 b() {
        if (c == null) {
            synchronized (i1.class) {
                if (c == null) {
                    c = new i1();
                }
            }
        }
        return c;
    }

    public final boolean c(Context context) {
        return s1.a(context);
    }

    public final boolean d(Context context) {
        return o2.a(context);
    }

    public final boolean e(Context context) {
        return p2.a(context);
    }

    public final boolean f(Context context) {
        return h3.a(context);
    }

    public final boolean g(Context context) {
        return m3.a(context);
    }

    public final void h(AppCompatActivity appCompatActivity, int i2) {
        a(appCompatActivity, new e(appCompatActivity, i2));
    }

    public final void i(AppCompatActivity appCompatActivity, int i2) {
        a(appCompatActivity, new f(appCompatActivity, i2));
    }

    public static Boolean a(Context context, String str) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(100).iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().service.getClassName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void e(AppCompatActivity appCompatActivity, int i2) throws IllegalAccessException, NoSuchFieldException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + appCompatActivity.getPackageName()));
        appCompatActivity.startActivityForResult(intent, i2);
    }

    public final void c(AppCompatActivity appCompatActivity, int i2) {
        d(appCompatActivity, i2);
    }

    public final void d(AppCompatActivity appCompatActivity, int i2) {
        if (r3.c()) {
            g(appCompatActivity, i2);
        } else {
            a(appCompatActivity, new g(appCompatActivity, i2));
        }
    }

    public final void f(AppCompatActivity appCompatActivity, int i2) {
        a(appCompatActivity, new c(appCompatActivity, i2));
    }

    public final void g(AppCompatActivity appCompatActivity, int i2) {
        a(appCompatActivity, new d(appCompatActivity, i2));
    }

    public void b(AppCompatActivity appCompatActivity, int i2) {
        com.acse.ottn.b.c().a(false);
        a(appCompatActivity, new a(appCompatActivity, i2));
    }

    public boolean a(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public final boolean b(Context context) {
        if (r3.c()) {
            return d(context);
        }
        Boolean bool = Boolean.TRUE;
        try {
            bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context);
        } catch (Exception e2) {
            h2.b(b, Log.getStackTraceString(e2));
        }
        return bool.booleanValue();
    }

    public final void a(AppCompatActivity appCompatActivity, int i2) {
        a(appCompatActivity, new b(appCompatActivity, i2));
    }

    public final void a(AppCompatActivity appCompatActivity, i iVar) {
        a(appCompatActivity, "您的手机没有授予悬浮窗权限，请开启后再试", iVar);
    }

    public boolean a() {
        AlertDialog alertDialog = this.f23048a;
        return alertDialog != null && alertDialog.isShowing();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, i iVar) {
        AlertDialog alertDialog = this.f23048a;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f23048a.dismiss();
        }
        this.f23048a = z0.a(appCompatActivity, appCompatActivity.getResources().getString(R.string.dialog_flow_title), appCompatActivity.getResources().getString(R.string.dialog_flow_message), "好的", false, new h(iVar));
    }

    public void a(Activity activity, int i2) {
        q2.b().a("open_flow_window_list");
        try {
            String strB = p4.b();
            String strA = n3.a().a("flow_window_state", "1");
            if (("xiaomi".equals(strB) || "redmi".equals(strB) || "blackshark".equals(strB)) && !strA.equals("2")) {
                n3.a().b("flow_window_state", "2");
                n3.a().b("OpenPermissionName", "显示悬浮窗");
                Intent intent = new Intent();
                n3.a().a("battery_white", Boolean.TRUE);
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                activity.startActivityForResult(intent, i2);
                return;
            }
            if (strB.equals("vivo") && !strA.equals("2")) {
                Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                n3.a().b("flow_window_state", "2");
                intent2.setData(Uri.parse("package:" + activity.getPackageName()));
                n3.a().a("battery_white", Boolean.TRUE);
                activity.startActivityForResult(intent2, i2);
                return;
            }
            b5.c = "0";
            n3.a().b("flow_window_state", "3");
            n3.a().a("battery_white", Boolean.TRUE);
            Intent intent3 = new Intent();
            intent3.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent3.putExtra("packagename", activity.getPackageName());
            intent3.putExtra("tabId", "1");
            activity.startActivity(intent3);
        } catch (Exception unused) {
            Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            n3.a().b("flow_window_state", "3");
            intent4.setData(Uri.parse("package:" + activity.getPackageName()));
            n3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent4, i2);
        }
    }
}
