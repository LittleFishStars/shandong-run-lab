package com.igexin.push.core.c;

import android.app.AppOpsManager;
import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import com.hjq.permissions.Permission;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.d;
import com.igexin.push.core.b;
import com.igexin.push.core.b.w;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.core.e.f.AnonymousClass12;
import com.igexin.push.g.c;
import com.igexin.push.g.k;
import com.igexin.push.g.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements com.igexin.push.core.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37979a = "BIDataManager";
    private static a b;

    /* JADX INFO: renamed from: com.igexin.push.core.c.a$2, reason: invalid class name */
    public class AnonymousClass2 implements Comparator<w> {
        public AnonymousClass2() {
        }

        private static int a(w wVar, w wVar2) {
            if (wVar.c.equals(wVar2.c)) {
                return 0;
            }
            return wVar.c.compareTo(wVar2.c);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(w wVar, w wVar2) {
            w wVar3 = wVar;
            w wVar4 = wVar2;
            if (wVar3.c.equals(wVar4.c)) {
                return 0;
            }
            return wVar3.c.compareTo(wVar4.c);
        }
    }

    private static int a(ApplicationInfo applicationInfo, AppOpsManager appOpsManager, PackageManager packageManager) {
        try {
            if (applicationInfo.packageName.equals(e.g)) {
                return c.b(e.l) ? 1 : 0;
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 31 || !d.ai) {
                return -1;
            }
            if (i >= 33 && applicationInfo.targetSdkVersion >= 33) {
                try {
                    return packageManager.checkPermission(Permission.POST_NOTIFICATIONS, applicationInfo.packageName) == 0 ? 1 : 0;
                } catch (Throwable unused) {
                    String[] strArr = k.a(applicationInfo.packageName, 4096).requestedPermissions;
                    if (strArr == null || !new HashSet(Arrays.asList(strArr)).contains(Permission.POST_NOTIFICATIONS)) {
                        return 0;
                    }
                }
            }
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            int iIntValue = ((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(iIntValue), Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue() != 0 ? 0 : 1;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", (Integer) 10);
        contentValues.put("data", str);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        return com.igexin.push.core.d.a.f37984a.i.a(b.af, contentValues);
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public static /* synthetic */ void a(a aVar, List list) {
        AnonymousClass2 anonymousClass2 = aVar.new AnonymousClass2();
        AppOpsManager appOpsManager = (AppOpsManager) e.l.getSystemService("appops");
        PackageManager packageManager = e.l.getPackageManager();
        List<PackageInfo> listA = n.a();
        for (int i = 0; i < listA.size(); i++) {
            try {
                PackageInfo packageInfo = listA.get(i);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    w wVar = new w();
                    wVar.f37975a = applicationInfo.loadLabel(packageManager).toString();
                    wVar.c = applicationInfo.packageName;
                    wVar.b = String.valueOf(packageInfo.versionCode);
                    wVar.d = packageInfo.versionName;
                    wVar.e = a(applicationInfo, appOpsManager, packageManager);
                    list.add(wVar);
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        Collections.sort(list, anonymousClass2);
    }

    public static void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || "null".equals(str) || !d.R.booleanValue()) {
                return;
            }
            if ((System.currentTimeMillis() - e.aw) - (d.S * 1000) < 0) {
                com.igexin.c.a.c.a.b(f37979a, "type253 in Interval = " + d.S);
                return;
            }
            Boolean bool = d.R;
            long j = d.S;
            com.igexin.c.a.c.a.a(f37979a, "start up id type253Enable = " + d.R + " ，type253Interval = " + d.S);
            String strM = n.m();
            String strH = n.h();
            String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("|");
            sb.append(e.C);
            sb.append("|");
            sb.append(e.f38001a);
            sb.append("|");
            sb.append(str);
            sb.append("|");
            if (strH == null || "null".equals(strH)) {
                strH = "";
            }
            sb.append(strH);
            sb.append("|");
            if (strM == null || "null".equals(strM)) {
                strM = "";
            }
            sb.append(strM);
            sb.append("|");
            sb.append(str2);
            String string = sb.toString();
            SDKUrlConfig.getBiUploadServiceUrl();
            com.igexin.c.a.c.a.a("BIDataManager| upload253 = ".concat(String.valueOf(string)), new Object[0]);
            byte[] bytes = string.getBytes();
            f.a().d(System.currentTimeMillis());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.e(SDKUrlConfig.getBiUploadServiceUrl(), bytes, 253)), false, true);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(ArrayList<String> arrayList) {
        com.igexin.push.core.d.a.f37984a.i.a(b.af, new String[]{"id"}, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    private void a(List<w> list) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        AppOpsManager appOpsManager = (AppOpsManager) e.l.getSystemService("appops");
        PackageManager packageManager = e.l.getPackageManager();
        List<PackageInfo> listA = n.a();
        for (int i = 0; i < listA.size(); i++) {
            try {
                PackageInfo packageInfo = listA.get(i);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    w wVar = new w();
                    wVar.f37975a = applicationInfo.loadLabel(packageManager).toString();
                    wVar.c = applicationInfo.packageName;
                    wVar.b = String.valueOf(packageInfo.versionCode);
                    wVar.d = packageInfo.versionName;
                    wVar.e = a(applicationInfo, appOpsManager, packageManager);
                    list.add(wVar);
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        Collections.sort(list, anonymousClass2);
    }

    public static void b() {
        String str;
        if (!c.e()) {
            str = " upload type144 network false";
        } else if (d.V) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if ((jCurrentTimeMillis - e.ay) - (d.W * 1000) >= 0) {
                try {
                    String[] strArrB = com.igexin.assist.sdk.a.a().b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                    sb.append("|");
                    sb.append(e.A);
                    sb.append("|");
                    sb.append(e.f38001a);
                    sb.append("|");
                    sb.append(e.C);
                    sb.append("|");
                    sb.append(d.T ? n.q() : "");
                    sb.append("|");
                    sb.append(n.d());
                    sb.append("|");
                    sb.append(AssistUtils.getDeviceBrand().toLowerCase());
                    sb.append("|");
                    sb.append(strArrB[0]);
                    sb.append("|");
                    sb.append(strArrB[1]);
                    sb.append("|");
                    sb.append(n.n());
                    sb.append("|");
                    sb.append(n.o());
                    f.a().e(jCurrentTimeMillis);
                    com.igexin.c.a.c.a.b("UploadBITask", "upload type144 data = " + sb.toString());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.e(SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes(), 144)), false, true);
                    return;
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
            }
            str = "type144 in Interval = " + d.W;
        } else {
            str = " isUpload type144 Enable false";
        }
        com.igexin.c.a.c.a.b(f37979a, str);
    }

    private static void b(ArrayList<String> arrayList) {
        com.igexin.push.core.d.a.f37984a.i.a(b.af, new String[]{"rowid"}, (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0051 A[DONT_GENERATE, PHI: r1
      0x0051: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:13:0x004f, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<com.igexin.push.core.b.c> c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorA = null;
        try {
            cursorA = com.igexin.push.core.d.a.f37984a.i.a(b.af, new String[]{"type"}, new String[]{"10"}, null, "");
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    arrayList.add(new com.igexin.push.core.b.c(cursorA.getInt(0), cursorA.getString(1), cursorA.getInt(2), cursorA.getLong(3)));
                }
            }
            if (cursorA != null) {
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return arrayList;
    }

    private static void d() {
        Cursor cursor = null;
        try {
            Cursor cursorA = com.igexin.push.core.d.a.f37984a.i.a(b.af, null, null, new String[]{"COUNT(*)"}, null);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            cursorA.moveToNext();
            long j = cursorA.getLong(0);
            cursorA.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.core.d.a.f37984a.i.a(b.af, "id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT " + j2 + ")");
                com.igexin.c.a.c.a.b(f37979a, "delete bidata " + j2 + " old expired data");
            }
            cursorA.close();
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    public final void a(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis() - e.R;
        if (!z || jCurrentTimeMillis - 86400000 >= 0) {
            StringBuilder sb = new StringBuilder(f37979a);
            sb.append(z ? ", over 24h, start upload AL" : "data change start upload AL");
            com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.core.c.a.1
                @Override // com.igexin.push.f.d
                public final void b() {
                    try {
                        f fVarA = f.a();
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (jCurrentTimeMillis2 != e.R) {
                            e.R = jCurrentTimeMillis2;
                            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass12(), false, true);
                        }
                        ArrayList arrayList = new ArrayList();
                        a.a(a.this, arrayList);
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("action", "reportapplist");
                            jSONObject.put("session_last", e.z);
                            JSONArray jSONArray = new JSONArray();
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("appid", ((w) arrayList.get(i)).c);
                                jSONObject2.put("name", ((w) arrayList.get(i)).f37975a);
                                jSONObject2.put("version", ((w) arrayList.get(i)).b);
                                jSONObject2.put("versionName", ((w) arrayList.get(i)).d);
                                jSONObject2.put("notificationEnabled", ((w) arrayList.get(i)).e);
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("applist", jSONArray);
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.a(SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
                        com.igexin.c.a.c.a.a("reportAL", new Object[0]);
                        if (d.ak) {
                            com.igexin.c.a.c.a.a("reportAL = " + jSONObject.toString(), new Object[0]);
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }, false, true);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor cursorA = com.igexin.push.core.d.a.f37984a.i.a(b.af, null, null, new String[]{"COUNT(*)"}, null);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            cursorA.moveToNext();
            long j = cursorA.getLong(0);
            cursorA.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.core.d.a.f37984a.i.a(b.af, "id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT " + j2 + ")");
                com.igexin.c.a.c.a.b(f37979a, "delete bidata " + j2 + " old expired data");
            }
            cursorA.close();
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }
}
