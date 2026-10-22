package com.alipay.sdk.m.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {
    public static volatile f g = null;
    public static boolean h = false;
    public BroadcastReceiver f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f25474a = new a("udid");
    public a b = new a(DeviceIdType.OAID);
    public a d = new a("vaid");
    public a c = new a("aaid");
    public c e = new c();

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    dVar.f25473a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    public static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static void a(String str) {
        if (h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        h = z;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057 A[PHI: r7
      0x0057: PHI (r7v3 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:18:0x0055, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean a(Context context) {
        a("querySupport version : 1.0.8");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursorQuery != null) {
                    d dVarA = a(cursorQuery);
                    boolean z = 1000 != dVarA.b || "0".equals(dVarA.f25473a);
                    cursorQuery.close();
                    return z;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                a("querySupport, Exception : " + e.getMessage());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return false;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            a("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final boolean a(Context context, boolean z) {
        if (this.e.a() && !z) {
            return this.e.b();
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
        if (this.e.a() && this.e.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.e.b();
        }
        this.e.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.e.a(zA);
        return zA;
    }

    public final String b(Context context, a aVar) throws Throwable {
        String str;
        Cursor cursorQuery;
        String str2;
        String strValueOf;
        a("queryId : " + aVar.c);
        Cursor cursor = null;
        str = null;
        str = null;
        String str3 = null;
        cursor = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{aVar.c}, null);
                try {
                    if (cursorQuery != null) {
                        d dVarA = a(cursorQuery);
                        str3 = dVarA.f25473a;
                        aVar.a(str3);
                        aVar.a(dVarA.c);
                        aVar.a(dVarA.b);
                        a(aVar.c + " errorCode : " + aVar.d);
                        if (dVarA.b != 1000) {
                            b(context);
                            if (!a(context, false)) {
                                str2 = "not support, forceQuery isSupported: ";
                                strValueOf = String.valueOf(a(context, true));
                                a(str2.concat(strValueOf));
                            }
                        }
                    } else if (a(context, false)) {
                        str2 = "forceQuery isSupported : ";
                        strValueOf = String.valueOf(a(context, true));
                        a(str2.concat(strValueOf));
                    }
                    if (cursorQuery == null) {
                        return str3;
                    }
                } catch (Exception e) {
                    e = e;
                    str = str3;
                    cursor = cursorQuery;
                    a("queryId, Exception : " + e.getMessage());
                    if (cursor == null) {
                        return str;
                    }
                    cursorQuery = cursor;
                    str3 = str;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            cursorQuery.close();
            return str3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized void b(Context context) {
        if (this.f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
