package com.kc.cw.ad.c.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d {
    private static volatile d e = null;
    private static boolean f = false;
    private BroadcastReceiver g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f38741a = new b("udid");
    b b = new b(DeviceIdType.OAID);
    b c = new b("vaid");
    b d = new b("aaid");
    private e h = new e();

    private d() {
    }

    public static final d a() {
        if (e == null) {
            synchronized (d.class) {
                try {
                    if (e == null) {
                        e = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    private static f a(Cursor cursor) {
        f fVar = new f(null, 0);
        if (cursor == null || cursor.isClosed()) {
            return fVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            fVar.f38743a = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            fVar.b = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            fVar.c = cursor.getLong(columnIndex3);
        }
        return fVar;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    private static boolean a(Context context) {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
            f fVarA = a(cursorQuery);
            boolean z = (1000 == fVarA.b && "0".equals(fVarA.f38743a)) ? false : true;
            cursorQuery.close();
            return z;
        } catch (Exception unused) {
            if (0 != 0) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private String b(Context context, b bVar) {
        String str = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{bVar.c}, null);
            if (cursorQuery != null) {
                f fVarA = a(cursorQuery);
                str = fVarA.f38743a;
                bVar.a(str);
                bVar.a(fVarA.c);
                bVar.a(fVarA.b);
                if (fVarA.b != 1000) {
                    b(context);
                    a(context, false);
                }
                return str;
            }
            a(context, false);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void b(Context context) {
        synchronized (this) {
            if (this.g != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            g gVar = new g();
            this.g = gVar;
            context.registerReceiver(gVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    public final String a(Context context, b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.a()) {
            return bVar.b;
        }
        if (a(context, true)) {
            return b(context, bVar);
        }
        return null;
    }

    public final boolean a(Context context, boolean z) {
        if (this.h.a() && !z) {
            return this.h.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.h.a() && this.h.a(strB)) {
            return this.h.b();
        }
        this.h.b(strB);
        boolean zA = a(context);
        this.h.a(zA);
        return zA;
    }
}
