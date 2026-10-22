package com.acse.ottn;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.hjq.permissions.Permission;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g2 {
    public static g2 c = null;
    public static String d = "acse_LocationRequsesPermissionUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationManager f23011a;
    public LocationListener b = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g2 g2Var = g2.this;
            LocationManager locationManager = g2Var.f23011a;
            if (locationManager != null) {
                locationManager.removeUpdates(g2Var.b);
                g2.this.f23011a = null;
            }
        }
    }

    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull Location location) {
            g2 g2Var = g2.this;
            LocationManager locationManager = g2Var.f23011a;
            if (locationManager != null) {
                locationManager.removeUpdates(g2Var.b);
                g2.this.f23011a = null;
            }
            String strA = g2.this.a(location.getLongitude());
            String strA2 = g2.this.a(location.getLatitude());
            n3.a().b("longitude", strA2);
            n3.a().b("latitude", strA);
            h2.a("liuqiang-->", strA2 + "|" + strA);
            r4.a().b(6, "获取到定位", " lat + lon=" + strA + strA2);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NonNull String str) {
            r4.a().b(6, "获取到定位", "定位结束");
            h2.a("liuqiang-->", "定位结束");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String str) {
            r4.a().b(6, "获取到定位", "定位完成");
            h2.a("liuqiang-->", "定位完成");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            r4.a().b(6, "获取到定位", "位置变化");
            h2.a("liuqiang-->", "位置变化");
        }
    }

    public static void e(Activity activity) {
        n3.a().b("OpenPermissionName", "权限管理");
        n3 n3VarA = n3.a();
        Boolean bool = Boolean.TRUE;
        n3VarA.a("battery_white", bool);
        n3.a().a("location_permission", bool);
        int i = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        try {
            try {
                intent.setComponent(i >= 28 ? ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity") : ComponentName.unflattenFromString("com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivityForResult(intent, 10010);
            }
        } catch (Exception unused2) {
        }
    }

    public final Object b() throws ObjectStreamException {
        return c;
    }

    public void c(Context context) {
        if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return;
        }
        ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1000);
    }

    public void d(Activity activity) {
        Intent intent = new Intent();
        try {
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.HWSettings"));
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void f(Activity activity) {
        String strB = p4.b();
        if (o1.c().e()) {
            e(activity);
            return;
        }
        if ("vivo".equals(strB)) {
            h(activity);
            return;
        }
        if ("oppo".equals(strB) || "realme".equals(strB)) {
            g(activity);
            return;
        }
        if ("xiaomi".equals(strB) || "redmi".equals(strB) || "blackshark".equals(strB)) {
            i(activity);
            return;
        }
        if ("oneplus".equals(strB)) {
            g(activity);
            return;
        }
        int iC = n3.a().c("location_permission_size");
        if (iC == 1) {
            n3.a().a("location_permission_size", 2);
            a().c(activity);
        } else if (iC == 2) {
            n3.a().a("location_permission_size", 3);
        }
        a().b(activity);
    }

    public final void g(Activity activity) {
        Intent intent = new Intent();
        n3 n3VarA = n3.a();
        Boolean bool = Boolean.TRUE;
        n3VarA.a("location_permission", bool);
        n3.a().a("battery_white", bool);
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(ALPParamConstant.PACKAGENAME, activity.getPackageName());
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10010);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivityForResult(intent2, 10010);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", activity.getPackageName());
            intent.putExtra("app_name", o1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10010);
        }
    }

    public final void h(Activity activity) {
        n3 n3VarA = n3.a();
        Boolean bool = Boolean.TRUE;
        n3VarA.a("battery_white", bool);
        n3.a().b("location_permission_state", "2");
        try {
            n3.a().a("location_permission", bool);
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.putExtra("packagename", activity.getPackageName());
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10010);
        } catch (Exception unused) {
            n3.a().a("location_permission", Boolean.FALSE);
        }
    }

    public final void i(Activity activity) {
        n3 n3VarA = n3.a();
        Boolean bool = Boolean.TRUE;
        n3VarA.a("location_permission", bool);
        n3.a().a("battery_white", bool);
        n3.a().b("location_permission_state", "2");
        try {
            String strB = p4.b();
            if ("xiaomi".equals(strB) || "redmi".equals(strB) || "blackshark".equals(strB)) {
                n3.a().b("OpenPermissionName", "定位");
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                activity.startActivityForResult(intent, 10010);
            }
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent2.setData(Uri.parse("package:" + activity.getPackageName()));
            n3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent2, 10010);
        }
    }

    public boolean b(Context context) {
        return context.checkSelfPermission(Permission.ACCESS_BACKGROUND_LOCATION) == 0;
    }

    public static g2 a() {
        if (c == null) {
            synchronized (g2.class) {
                if (c == null) {
                    c = new g2();
                }
            }
        }
        return c;
    }

    public void b(Activity activity) {
        n3.a().b("location_permission_state", "2");
        ActivityCompat.requestPermissions(activity, new String[]{Permission.ACCESS_BACKGROUND_LOCATION}, 1000);
    }

    public void c(Activity activity) {
        n3.a().b("location_permission_state", "1");
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1018);
    }

    public void c() {
        String str;
        if (HelpShopAppUtil.getContext() != null && a("request_startLocation", 10000)) {
            r4.a().b(4, "开始定位", " 0000");
            h2.a("liuqiang-->", "开始定位=");
            this.f23011a = (LocationManager) HelpShopAppUtil.getContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            boolean z = ContextCompat.checkSelfPermission(HelpShopAppUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0;
            boolean z2 = ContextCompat.checkSelfPermission(HelpShopAppUtil.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0;
            if (z) {
                str = "1";
            } else {
                str = z2 ? "2" : "3";
            }
            n3.a().b("location_state", str);
            if (z || z2) {
                this.f23011a.requestLocationUpdates("network", 0L, 0.0f, this.b);
                new Handler().postDelayed(new a(), 5000L);
            }
        }
    }

    public boolean a(Context context) {
        return context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public void a(Activity activity) {
        if (activity.checkSelfPermission(Permission.ACCESS_BACKGROUND_LOCATION) == 0) {
            return;
        }
        n3.a().a("battery_white", Boolean.TRUE);
        n3.a().b("location_permission_state", "2");
        ActivityCompat.requestPermissions(activity, new String[]{Permission.ACCESS_BACKGROUND_LOCATION}, 10019);
    }

    public final boolean a(String str, int i) {
        if (i == 0) {
            i = 500;
        }
        Long lValueOf = Long.valueOf(n3.a().d("coupon_" + str));
        h2.a(d, "controlCouponShow appPageName =" + str + "-----" + (System.currentTimeMillis() - lValueOf.longValue()));
        if (System.currentTimeMillis() - lValueOf.longValue() < i) {
            h2.a(d, "controlCouponShow return false ");
            return false;
        }
        n3.a().a("coupon_" + str, System.currentTimeMillis());
        h2.a(d, "controlCouponShow return true");
        return true;
    }

    public final String a(double d2) {
        String str;
        Double dValueOf = Double.valueOf(Math.abs(d2));
        String strReplace = String.valueOf(dValueOf).replace(Consts.DOT, "");
        if (dValueOf.doubleValue() >= 100.0d) {
            str = "3";
        } else if (dValueOf.doubleValue() >= 10.0d) {
            str = "2";
        } else {
            str = dValueOf.doubleValue() > 1.0d ? "1" : "0";
        }
        if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return "1" + str + strReplace;
        }
        return "0" + str + strReplace;
    }
}
