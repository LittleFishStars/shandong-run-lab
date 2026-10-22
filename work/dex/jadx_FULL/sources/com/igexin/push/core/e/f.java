package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.g.g;
import com.igexin.push.g.j;
import com.zj.adlib.c49;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements a {
    private static final int A = 48;
    private static final int B = 49;
    private static final int C = 50;
    private static final int D = 51;
    private static final int E = 53;
    private static final int F = 54;
    private static final int G = 60;
    private static final int H = 61;
    private static final int I = 63;
    private static final int J = 64;
    private static final int K = 65;
    private static final int L = 66;
    private static final int M = 67;
    private static volatile f N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38011a = "com.igexin.push.core.e.f";
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 6;
    private static final int h = 8;
    private static final int i = 12;
    private static final int j = 13;
    private static final int k = 14;
    private static final int l = 15;
    private static final int m = 16;
    private static final int n = 17;
    private static final int o = 18;
    private static final int p = 20;
    private static final int q = 21;
    private static final int r = 22;
    private static final int s = 23;
    private static final int t = 25;
    private static final int u = 30;
    private static final int v = 31;
    private static final int w = 32;
    private static final int x = 40;
    private static final int y = 46;
    private static final int z = 47;
    public boolean b;

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.b.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Throwable {
            f.this.c(this.d);
            j.b();
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$12, reason: invalid class name */
    public class AnonymousClass12 extends com.igexin.push.b.d {
        public AnonymousClass12() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 8, String.valueOf(com.igexin.push.core.e.R));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$13, reason: invalid class name */
    public class AnonymousClass13 extends com.igexin.push.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38016a;

        public AnonymousClass13(String str) {
            this.f38016a = str;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 3, this.f38016a);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$17, reason: invalid class name */
    public class AnonymousClass17 extends com.igexin.push.b.d {
        public AnonymousClass17() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 67, String.valueOf(com.igexin.push.core.e.J));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$20, reason: invalid class name */
    public class AnonymousClass20 extends com.igexin.push.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38024a;
        final /* synthetic */ String b;

        public AnonymousClass20(String str, String str2) {
            this.f38024a = str;
            this.b = str2;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            if (!TextUtils.isEmpty(this.f38024a)) {
                f.a();
                f.b(this.d, 53, this.f38024a);
            }
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            f.a();
            f.b(this.d, 54, this.b);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$21, reason: invalid class name */
    public class AnonymousClass21 extends com.igexin.push.b.d {
        public AnonymousClass21() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 60, String.valueOf(com.igexin.push.core.e.c));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$25, reason: invalid class name */
    public class AnonymousClass25 extends com.igexin.push.b.d {
        public AnonymousClass25() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 64, String.valueOf(com.igexin.push.core.e.ax));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$27, reason: invalid class name */
    public class AnonymousClass27 extends com.igexin.push.b.d {
        public AnonymousClass27() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.a(this.d, 66, com.igexin.c.a.a.a.b(com.igexin.push.a.j.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$28, reason: invalid class name */
    public class AnonymousClass28 extends com.igexin.push.b.d {
        public AnonymousClass28() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.e(this.d);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$3, reason: invalid class name */
    public class AnonymousClass3 extends com.igexin.push.b.d {
        public AnonymousClass3() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 13, com.igexin.push.core.e.V);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$31, reason: invalid class name */
    public class AnonymousClass31 extends com.igexin.push.b.d {
        public AnonymousClass31() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 51, com.igexin.push.core.e.C);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$5, reason: invalid class name */
    public class AnonymousClass5 extends com.igexin.push.b.d {
        public AnonymousClass5() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 16, String.valueOf(com.igexin.push.core.e.X));
        }
    }

    private f() {
    }

    public static f a() {
        if (N == null) {
            synchronized (f.class) {
                if (N == null) {
                    N = new f();
                }
            }
        }
        return N;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace(com.igexin.push.core.b.Z, null, contentValues);
    }

    private boolean a(String str, String str2) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass20(str, str2), false, true);
    }

    private boolean a(String str, String str2, long j2) {
        com.igexin.push.core.e.z = j2;
        if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.push.core.e.H = str2;
        }
        com.igexin.push.core.e.A = str;
        return c();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046 A[PHI: r10
      0x0046: PHI (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:19:0x0044, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x004e  */
    public static byte[] a(SQLiteDatabase sQLiteDatabase, int i2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{"value"}, "id=".concat(String.valueOf(i2)), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            byte[] bArrA = com.igexin.c.a.a.a.a(cursorQuery.getBlob(cursorQuery.getColumnIndex("value")), com.igexin.push.core.e.M);
                            cursorQuery.close();
                            return bArrA;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.igexin.c.a.c.a.a(e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0040 A[PHI: r10
      0x0040: PHI (r10v3 android.database.Cursor) = (r10v2 android.database.Cursor), (r10v4 android.database.Cursor) binds: [B:19:0x003e, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static String b(SQLiteDatabase sQLiteDatabase, int i2) throws Throwable {
        Cursor cursorQuery;
        ?? r1 = 0;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{"value"}, "id=".concat(String.valueOf(i2)), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.igexin.c.a.c.a.a(e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                r1 = sQLiteDatabase;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SQLiteDatabase sQLiteDatabase, int i2, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put("value", str);
        sQLiteDatabase.replace(com.igexin.push.core.b.Z, null, contentValues);
    }

    private boolean c(int i2) {
        if (com.igexin.push.core.e.J == i2) {
            return false;
        }
        com.igexin.push.core.e.J = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass17(), false, true);
    }

    public static void d() {
        try {
            String string = com.igexin.push.core.e.D;
            UUID uuidRandomUUID = UUID.randomUUID();
            if (TextUtils.isEmpty(string) || string.length() <= 8) {
                StringBuilder sb = new StringBuilder("V");
                sb.append(com.igexin.c.b.a.b(com.igexin.push.core.e.g + uuidRandomUUID));
                string = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder("A-");
            sb2.append(string);
            sb2.append(c49.f40900a);
            sb2.append(com.igexin.c.b.a.b(System.currentTimeMillis() + uuidRandomUUID + com.igexin.push.core.e.g));
            String string2 = sb2.toString();
            com.igexin.push.core.e.L = string2;
            if (string2.length() >= 64) {
                com.igexin.push.core.e.L = com.igexin.push.core.e.L.substring(0, 62);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            StringBuilder sb3 = new StringBuilder("A-V");
            sb3.append(com.igexin.push.core.e.g);
            sb3.append(c49.f40900a);
            sb3.append(com.igexin.c.b.a.b(System.currentTimeMillis() + com.igexin.push.core.e.g));
            com.igexin.push.core.e.L = sb3.toString();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004b A[PHI: r1
      0x004b: PHI (r1v3 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:14:0x0049, B:8:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    public static void d(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{"value"}, "id=?", new String[]{"25"}, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    com.igexin.push.core.e.M = new String(com.igexin.c.a.a.a.a(cursorQuery.getBlob(cursorQuery.getColumnIndex("value")), com.igexin.c.b.a.b(ServiceManager.b.getPackageName())));
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            if (com.igexin.push.core.e.M == null) {
                String str = com.igexin.push.core.e.D;
                if (str == null) {
                    str = com.igexin.push.core.b.am;
                }
                com.igexin.push.core.e.M = com.igexin.c.b.a.b(str);
            }
            com.igexin.c.a.c.a.a(f38011a + "|storageKey = " + com.igexin.push.core.e.M, new Object[0]);
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static /* synthetic */ void e() throws Throwable {
        j.b();
        String strD = j.d();
        if (strD == null || strD.length() <= 5) {
            j.f();
        }
    }

    public static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 66);
        if (bArrA != null) {
            String str = new String(bArrA);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.a(f38011a, "readRedirectAes null");
                return;
            }
            g.c = str;
            com.igexin.c.a.c.a.b(f38011a, " readRedirectAes set success " + g.c);
        }
    }

    private void f() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
    }

    private void f(SQLiteDatabase sQLiteDatabase) throws Throwable {
        this.b = true;
        d(sQLiteDatabase);
        byte[] bArrA = a(sQLiteDatabase, 1);
        if (bArrA != null) {
            try {
                String str = new String(bArrA);
                com.igexin.push.core.e.z = str.equals("null") ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f38011a + "|db version changed, save session = " + com.igexin.push.core.e.z, new Object[0]);
        }
        byte[] bArrA2 = a(sQLiteDatabase, 20);
        if (bArrA2 != null) {
            String str2 = new String(bArrA2);
            if (str2.equals("null")) {
                str2 = null;
            }
            com.igexin.push.core.e.B = str2;
            com.igexin.push.core.e.A = str2;
            com.igexin.c.a.c.a.a(f38011a + "|db version changed, save cid = " + str2, new Object[0]);
        }
        String strB = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(strB)) {
            if (strB.equals("null")) {
                strB = null;
            }
            com.igexin.push.core.e.L = strB;
        }
        String str3 = com.igexin.push.core.e.L;
        String strB2 = b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(strB2)) {
            if (strB2.equals("null")) {
                strB2 = null;
            }
            com.igexin.push.core.e.H = strB2;
        }
        String strB3 = b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(strB3)) {
            if (strB3.equals("null")) {
                strB3 = null;
            }
            com.igexin.push.core.e.I = strB3;
        }
        String strB4 = b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(strB4)) {
            if (strB4.equals("null")) {
                strB4 = null;
            }
            com.igexin.push.core.e.K = strB4;
        }
        String strB5 = b(sQLiteDatabase, 51);
        if (TextUtils.isEmpty(strB5) || strB5.length() == 13) {
            return;
        }
        com.igexin.push.core.e.C = strB5.equals("null") ? null : strB5;
    }

    private boolean f(long j2) {
        if (j2 == com.igexin.push.core.e.R) {
            return false;
        }
        com.igexin.push.core.e.R = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass12(), false, true);
    }

    public static /* synthetic */ byte[] f(String str) {
        return g.a(str.getBytes());
    }

    private static void g() throws Throwable {
        j.b();
        String strD = j.d();
        if (strD == null || strD.length() <= 5) {
            j.f();
        }
    }

    private static void g(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 2);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (strB.equals("null")) {
            strB = null;
        }
        com.igexin.push.core.e.H = strB;
    }

    private boolean g(long j2) {
        if (com.igexin.push.core.e.T == j2) {
            return false;
        }
        com.igexin.push.core.e.T = j2;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.34
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 12, String.valueOf(com.igexin.push.core.e.T));
            }
        }, false, true);
        return true;
    }

    private static byte[] g(String str) {
        return g.a(str.getBytes());
    }

    private static void h() {
        String str = com.igexin.push.core.e.A;
        com.igexin.c.a.c.a.a(f38011a + "| found a duplicate cid " + com.igexin.push.core.e.A, new Object[0]);
        com.igexin.push.core.e.L = null;
        d();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a().new AnonymousClass13(com.igexin.push.core.e.L), false, true);
        a().b();
        com.igexin.push.core.e.r = 0;
        com.igexin.push.f.b.e.g().f38125a = SystemClock.elapsedRealtime();
    }

    private static void h(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 51);
        if (TextUtils.isEmpty(strB) || strB.length() == 13) {
            return;
        }
        if (strB.equals("null")) {
            strB = null;
        }
        com.igexin.push.core.e.C = strB;
    }

    private boolean h(long j2) {
        if (com.igexin.push.core.e.X == j2) {
            return false;
        }
        com.igexin.push.core.e.X = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass5(), false, true);
    }

    private boolean h(String str) {
        com.igexin.push.core.e.C = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass31(), false, true);
    }

    private void i() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass25(), false, true);
    }

    private static void i(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 46);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (strB.equals("null")) {
            strB = null;
        }
        com.igexin.push.core.e.I = strB;
    }

    private boolean i(long j2) {
        if (com.igexin.push.core.e.U == j2) {
            return false;
        }
        com.igexin.push.core.e.U = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.14
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 32, String.valueOf(com.igexin.push.core.e.U));
            }
        }, false, true);
    }

    private boolean i(String str) {
        if (str.equals(com.igexin.push.core.e.V)) {
            return false;
        }
        com.igexin.push.core.e.V = str;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass3(), false, true);
        return true;
    }

    private void j() {
        if (TextUtils.isEmpty(g.c)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass27(), true, false);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass28(), true, false);
        }
    }

    private static void j(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 48);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (strB.equals("null")) {
            strB = null;
        }
        com.igexin.push.core.e.K = strB;
    }

    private boolean j(long j2) {
        if (com.igexin.push.core.e.c == j2) {
            return false;
        }
        com.igexin.push.core.e.c = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass21(), false, true);
    }

    private boolean j(String str) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass13(str), false, true);
    }

    private static void k(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(strB)) {
            if (strB.equals("null")) {
                strB = null;
            }
            com.igexin.push.core.e.L = strB;
        }
        String str = com.igexin.push.core.e.L;
    }

    private static void l(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 1);
        if (bArrA != null) {
            try {
                String str = new String(bArrA);
                com.igexin.push.core.e.z = str.equals("null") ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f38011a + "|db version changed, save session = " + com.igexin.push.core.e.z, new Object[0]);
        }
    }

    private static void m(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 20);
        if (bArrA != null) {
            String str = new String(bArrA);
            if (str.equals("null")) {
                str = null;
            }
            com.igexin.push.core.e.B = str;
            com.igexin.push.core.e.A = str;
            com.igexin.c.a.c.a.a(f38011a + "|db version changed, save cid = " + str, new Object[0]);
        }
    }

    private static void n(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 66);
        if (bArrA != null) {
            String str = new String(bArrA);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.a(f38011a, "readRedirectAes null");
                return;
            }
            g.c = str;
            com.igexin.c.a.c.a.b(f38011a, " readRedirectAes set success " + g.c);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    public final void a(boolean z2) {
        com.igexin.push.core.e.W = z2;
        com.igexin.c.a.c.a.a(z2);
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.4
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 15, String.valueOf(com.igexin.push.core.e.W));
            }
        }, false, true);
    }

    public final boolean a(int i2) {
        com.igexin.push.core.e.ab = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.7
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 18, String.valueOf(com.igexin.push.core.e.ab));
            }
        }, false, true);
    }

    public final boolean a(long j2) {
        com.igexin.push.core.e.a(j2);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.29
            @Override // com.igexin.push.b.d
            public final void a_() throws Throwable {
                f.a();
                f.a(this.d, 1, g.a(String.valueOf(com.igexin.push.core.e.z).getBytes()));
                f.a();
                f.a(this.d, 20, f.f(com.igexin.push.core.e.A));
                j.b();
            }
        }, false, true);
    }

    public final boolean a(String str) {
        com.igexin.push.core.e.H = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.30
            @Override // com.igexin.push.b.d
            public final void a_() throws Throwable {
                f.a();
                f.b(this.d, 2, com.igexin.push.core.e.H);
                String strD = j.d();
                if (strD == null || strD.length() <= 5) {
                    j.f();
                }
            }
        }, false, true);
    }

    public final boolean a(final String str, boolean z2) {
        com.igexin.c.a.b.e eVarA;
        com.igexin.push.b.d dVar;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z2) {
            if (!str.equals(com.igexin.push.core.e.ar)) {
                com.igexin.push.core.e.ar = str.equals("null") ? null : str;
                eVarA = com.igexin.c.a.b.e.a();
                dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.8
                    @Override // com.igexin.push.b.d
                    public final void a_() throws Exception {
                        f.a();
                        f.a(this.d, 31, f.f(str));
                    }
                };
                return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
            }
            return false;
        }
        if (!str.equals(com.igexin.push.core.e.as)) {
            com.igexin.push.core.e.as = str.equals("null") ? null : str;
            eVarA = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.9
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 30, f.f(str));
                }
            };
            return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0179  */
    /* JADX WARN: Code duplicated, block: B:108:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:113:0x01af A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:122:0x01cb A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x01de  */
    /* JADX WARN: Code duplicated, block: B:130:0x020c  */
    /* JADX WARN: Code duplicated, block: B:134:0x023a  */
    /* JADX WARN: Code duplicated, block: B:138:0x0268  */
    /* JADX WARN: Code duplicated, block: B:142:0x0291  */
    /* JADX WARN: Code duplicated, block: B:143:0x0294 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:151:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:152:0x02b6 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:160:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:161:0x02d2 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:173:0x0304  */
    /* JADX WARN: Code duplicated, block: B:174:0x0307 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x031a  */
    /* JADX WARN: Code duplicated, block: B:182:0x0325  */
    /* JADX WARN: Code duplicated, block: B:183:0x0328 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0336  */
    /* JADX WARN: Code duplicated, block: B:191:0x0341  */
    /* JADX WARN: Code duplicated, block: B:195:0x034c A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x0354  */
    /* JADX WARN: Code duplicated, block: B:204:0x037b  */
    /* JADX WARN: Code duplicated, block: B:205:0x037e A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x038c  */
    /* JADX WARN: Code duplicated, block: B:210:0x038f A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x039d A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:222:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:226:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:231:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:232:0x03d1 A[Catch: Exception -> 0x03d8, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:256:0x041b A[PHI: r3 r5 r7 r13 r15
      0x041b: PHI (r3v3 int) = (r3v2 int), (r3v12 int) binds: [B:255:0x0419, B:245:0x03fb] A[DONT_GENERATE, DONT_INLINE]
      0x041b: PHI (r5v5 android.database.Cursor) = (r5v4 android.database.Cursor), (r5v8 android.database.Cursor) binds: [B:255:0x0419, B:245:0x03fb] A[DONT_GENERATE, DONT_INLINE]
      0x041b: PHI (r7v4 int) = (r7v3 int), (r7v14 int) binds: [B:255:0x0419, B:245:0x03fb] A[DONT_GENERATE, DONT_INLINE]
      0x041b: PHI (r13v3 int) = (r13v2 int), (r13v5 int) binds: [B:255:0x0419, B:245:0x03fb] A[DONT_GENERATE, DONT_INLINE]
      0x041b: PHI (r15v3 boolean) = (r15v2 boolean), (r15v5 boolean) binds: [B:255:0x0419, B:245:0x03fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:259:0x0424  */
    /* JADX WARN: Code duplicated, block: B:261:0x042c  */
    /* JADX WARN: Code duplicated, block: B:264:0x0441  */
    /* JADX WARN: Code duplicated, block: B:269:0x045a  */
    /* JADX WARN: Code duplicated, block: B:271:0x0460  */
    /* JADX WARN: Code duplicated, block: B:274:0x0486  */
    /* JADX WARN: Code duplicated, block: B:280:0x0495  */
    /* JADX WARN: Code duplicated, block: B:282:0x049b  */
    /* JADX WARN: Code duplicated, block: B:283:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:286:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:288:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:291:0x04dd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:297:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:300:0x050c  */
    /* JADX WARN: Code duplicated, block: B:304:0x051e  */
    /* JADX WARN: Code duplicated, block: B:307:0x0525  */
    /* JADX WARN: Code duplicated, block: B:310:0x0534  */
    /* JADX WARN: Code duplicated, block: B:312:0x053e  */
    /* JADX WARN: Code duplicated, block: B:315:0x055d  */
    /* JADX WARN: Code duplicated, block: B:318:0x0574  */
    /* JADX WARN: Code duplicated, block: B:321:0x0589  */
    /* JADX WARN: Code duplicated, block: B:326:0x059f  */
    /* JADX WARN: Code duplicated, block: B:329:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:332:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:335:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:339:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:351:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:354:0x008f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:356:0x03c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:357:0x03b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:358:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:359:0x0397 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x0375 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:363:0x033b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:364:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:365:0x031f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:366:0x030f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:368:0x02be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:369:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:370:0x02da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:371:0x02ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:372:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:373:0x02fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:374:0x022f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:375:0x025d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:376:0x028b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:377:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:379:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0083 A[Catch: all -> 0x03ea, TRY_LEAVE, TryCatch #5 {all -> 0x03ea, blocks: (B:33:0x0074, B:35:0x007d, B:37:0x0083), top: B:347:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:380:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:381:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:382:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:383:0x016e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:384:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:385:0x01a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:386:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:387:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:389:0x010a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:390:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:391:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:392:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:393:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:394:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:395:0x02e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:396:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:398:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:0x036c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:403:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:406:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:407:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:429:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:438:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:456:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:463:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00df  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:80:0x0102 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0110  */
    /* JADX WARN: Code duplicated, block: B:85:0x0113 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0121  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0132 A[Catch: Exception -> 0x03f1, all -> 0x05d2, TryCatch #0 {all -> 0x05d2, blocks: (B:7:0x003d, B:9:0x0043, B:68:0x00c4, B:72:0x00d0, B:71:0x00cc, B:73:0x00d4, B:76:0x00e0, B:77:0x00f9, B:81:0x0106, B:80:0x0102, B:82:0x010a, B:86:0x0117, B:85:0x0113, B:87:0x011b, B:91:0x0128, B:90:0x0124, B:254:0x040d, B:92:0x012c, B:94:0x0132, B:96:0x013a, B:97:0x013c, B:98:0x0140, B:101:0x014c, B:102:0x016e, B:105:0x017a, B:106:0x019c, B:109:0x01a3, B:110:0x01a7, B:114:0x01b3, B:113:0x01af, B:115:0x01b7, B:118:0x01be, B:119:0x01c2, B:123:0x01cf, B:122:0x01cb, B:124:0x01d3, B:127:0x01df, B:128:0x0201, B:131:0x020d, B:132:0x022f, B:135:0x023b, B:136:0x025d, B:139:0x0269, B:140:0x028b, B:144:0x0298, B:143:0x0294, B:145:0x029c, B:148:0x02a8, B:149:0x02ae, B:153:0x02ba, B:152:0x02b6, B:154:0x02be, B:157:0x02c5, B:158:0x02c9, B:162:0x02d6, B:161:0x02d2, B:163:0x02da, B:165:0x02e0, B:166:0x02ea, B:167:0x02f3, B:170:0x02fa, B:171:0x02fe, B:175:0x030b, B:174:0x0307, B:176:0x030f, B:179:0x031b, B:180:0x031f, B:184:0x032c, B:183:0x0328, B:185:0x0330, B:188:0x0337, B:189:0x033b, B:192:0x0342, B:193:0x0346, B:195:0x034c, B:199:0x0355, B:201:0x036c, B:202:0x0375, B:206:0x0382, B:205:0x037e, B:207:0x0386, B:211:0x0393, B:210:0x038f, B:212:0x0397, B:214:0x039d, B:219:0x03a7, B:220:0x03ab, B:223:0x03b2, B:224:0x03b6, B:227:0x03be, B:228:0x03c2, B:229:0x03c8, B:233:0x03d5, B:236:0x03e6, B:232:0x03d1, B:235:0x03d8, B:238:0x03eb), top: B:341:0x0015 }] */
    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        boolean z2;
        int i2;
        int i3;
        int i4;
        Cursor cursorQuery;
        String str;
        String strD;
        d dVarA;
        JSONObject jSONObjectC;
        String strOptString;
        long j2;
        String str2;
        String str3;
        long j3;
        String strC;
        long jE;
        byte[] blob;
        String string;
        long j4;
        long j5;
        long j6;
        String str4;
        int i5;
        int i6;
        String str5;
        String str6;
        String str7;
        String str8;
        long j7;
        String str9;
        long j8;
        String str10;
        String str11;
        long j9;
        long j10;
        int i7;
        String str12;
        long j11;
        boolean z3;
        long j12;
        long j13;
        boolean z4;
        String str13;
        long j14;
        d(sQLiteDatabase);
        Cursor cursor = null;
        try {
            try {
                try {
                    z2 = false;
                    i2 = 1;
                    try {
                        cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{"id", "value"}, null, null, null, null, "id");
                        if (cursorQuery != null) {
                            while (cursorQuery.moveToNext()) {
                                try {
                                    int i8 = cursorQuery.getInt(0);
                                    if (i8 == 1 || i8 == 14) {
                                        i3 = 20;
                                        blob = cursorQuery.getBlob(1);
                                        if (blob != null) {
                                            blob = com.igexin.c.a.a.a.a(blob, com.igexin.push.core.e.M);
                                        }
                                        string = null;
                                        if (blob == null || string != null) {
                                            if (i8 == 1) {
                                                str13 = new String(blob);
                                                try {
                                                    if (str13.equals("null")) {
                                                        j14 = 0;
                                                    } else {
                                                        j14 = Long.parseLong(str13);
                                                    }
                                                    com.igexin.push.core.e.z = j14;
                                                } catch (Exception unused) {
                                                    com.igexin.c.a.c.a.a(f38011a, "session formate error! session : ".concat(str13));
                                                    com.igexin.push.core.e.z = 0L;
                                                }
                                                long j15 = com.igexin.push.core.e.z;
                                            } else if (i8 != 2) {
                                                i4 = 3;
                                                if (i8 == 3) {
                                                    if (string.equals("null")) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.L = string;
                                                } else if (i8 == 4) {
                                                    if (!string.equals("null") || Boolean.parseBoolean(string)) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    com.igexin.push.core.e.t = z4;
                                                } else if (i8 == 6) {
                                                    if (string.equals("null")) {
                                                        j13 = 0;
                                                    } else {
                                                        j13 = Long.parseLong(string);
                                                    }
                                                    com.igexin.push.core.e.Q = j13;
                                                } else if (i8 == 8) {
                                                    if (string.equals("null")) {
                                                        j12 = 0;
                                                    } else {
                                                        j12 = Long.parseLong(string);
                                                    }
                                                    com.igexin.push.core.e.R = j12;
                                                } else if (i8 == 40) {
                                                    if (string.equals("null") && Boolean.parseBoolean(string)) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    com.igexin.push.d.c.b.f38095a.b = z3;
                                                    com.igexin.c.a.c.a.a("ConnectModelCoordinator|init, current is polling mdl = ".concat(String.valueOf(z3)), new Object[0]);
                                                    if (z3) {
                                                        com.igexin.push.f.b.d.a.f38124a.g();
                                                    }
                                                } else if (i8 == 53) {
                                                    if ("null".equals(string)) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.aK = string;
                                                } else if (i8 == 54) {
                                                    if ("null".equals(string)) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.aL = string;
                                                } else if (i8 == 60) {
                                                    if (string.equals("null")) {
                                                        j11 = 0;
                                                    } else {
                                                        j11 = Long.parseLong(string);
                                                    }
                                                    com.igexin.push.core.e.c = j11;
                                                } else {
                                                    if (i8 != 61) {
                                                        switch (i8) {
                                                            case 12:
                                                                if (string.equals("null")) {
                                                                    j9 = 0;
                                                                } else {
                                                                    j9 = Long.parseLong(string);
                                                                }
                                                                com.igexin.push.core.e.T = j9;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 13:
                                                                if (string.equals("null")) {
                                                                    string = null;
                                                                }
                                                                com.igexin.push.core.e.V = string;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 14:
                                                                com.igexin.push.core.e.an = new String(blob);
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 15:
                                                                if (!string.equals("null")) {
                                                                    com.igexin.push.core.e.W = Boolean.parseBoolean(string);
                                                                    boolean z5 = com.igexin.push.core.e.t;
                                                                } else {
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                }
                                                                break;
                                                            case 16:
                                                                if (string.equals("null")) {
                                                                    j10 = 0;
                                                                } else {
                                                                    j10 = Long.parseLong(string);
                                                                }
                                                                com.igexin.push.core.e.X = j10;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 17:
                                                                if (string.equals("null")) {
                                                                    string = null;
                                                                }
                                                                com.igexin.push.core.e.Z = string;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 18:
                                                                if (string.equals("null")) {
                                                                    i7 = 0;
                                                                } else {
                                                                    i7 = Integer.parseInt(string);
                                                                }
                                                                com.igexin.push.core.e.ab = i7;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            default:
                                                                switch (i8) {
                                                                    case 20:
                                                                        str9 = new String(blob);
                                                                        if (str9.equals("null")) {
                                                                            str9 = null;
                                                                        }
                                                                        com.igexin.push.core.e.B = str9;
                                                                        com.igexin.push.core.e.A = str9;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    case 21:
                                                                        if (string.equals("null")) {
                                                                            j8 = 0;
                                                                        } else {
                                                                            j8 = Long.parseLong(string);
                                                                        }
                                                                        com.igexin.push.core.e.ao = j8;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    case 22:
                                                                        str10 = new String(blob);
                                                                        if (str10.equals("null")) {
                                                                            str10 = null;
                                                                        }
                                                                        com.igexin.push.core.e.aq = str10;
                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last wf result = " + com.igexin.push.core.e.aq, new Object[0]);
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    case 23:
                                                                        str11 = new String(blob);
                                                                        if (str11.equals("null")) {
                                                                            str11 = null;
                                                                        }
                                                                        com.igexin.push.core.e.ap = str11;
                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last mobile result = " + com.igexin.push.core.e.ap, new Object[0]);
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    default:
                                                                        switch (i8) {
                                                                            case 30:
                                                                                str7 = new String(blob);
                                                                                if (str7.equals("null")) {
                                                                                    str7 = null;
                                                                                }
                                                                                com.igexin.push.core.e.as = str7;
                                                                                com.igexin.c.a.c.a.a(f38011a + "|read last domainWfStatus = " + com.igexin.push.core.e.as, new Object[0]);
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                            case 31:
                                                                                str8 = new String(blob);
                                                                                if (str8.equals("null")) {
                                                                                    str8 = null;
                                                                                }
                                                                                com.igexin.push.core.e.ar = str8;
                                                                                com.igexin.c.a.c.a.a(f38011a + "|read last domainMobileStatus = " + com.igexin.push.core.e.ar, new Object[0]);
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                            case 32:
                                                                                if (string.equals("null")) {
                                                                                    j7 = 0;
                                                                                } else {
                                                                                    j7 = Long.parseLong(string);
                                                                                }
                                                                                com.igexin.push.core.e.U = j7;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                            default:
                                                                                switch (i8) {
                                                                                    case 46:
                                                                                        if (string.equals("null")) {
                                                                                            string = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.I = string;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 47:
                                                                                        if (string.equals("null")) {
                                                                                            i6 = 0;
                                                                                        } else {
                                                                                            i6 = Integer.parseInt(string);
                                                                                        }
                                                                                        com.igexin.push.core.e.aA = i6;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 48:
                                                                                        if (string.equals("null")) {
                                                                                            string = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.K = string;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 49:
                                                                                        str5 = new String(blob);
                                                                                        if (str5.equals("null")) {
                                                                                            str5 = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.at = str5;
                                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last wfRedirectCmList = " + com.igexin.push.core.e.at, new Object[0]);
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 50:
                                                                                        str6 = new String(blob);
                                                                                        if (str6.equals("null")) {
                                                                                            str6 = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.au = str6;
                                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last mobileRedirectCmList = " + com.igexin.push.core.e.au, new Object[0]);
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 51:
                                                                                        if (!string.equals("null") && string.length() != 13) {
                                                                                            com.igexin.push.core.e.C = string;
                                                                                        }
                                                                                        String str14 = com.igexin.push.core.e.C;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    default:
                                                                                        switch (i8) {
                                                                                            case 63:
                                                                                                if ("null".equals(string)) {
                                                                                                    j4 = 0;
                                                                                                } else {
                                                                                                    j4 = Long.parseLong(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.aw = j4;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 64:
                                                                                                if ("null".equals(string)) {
                                                                                                    j5 = 0;
                                                                                                } else {
                                                                                                    j5 = Long.parseLong(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.ax = j5;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 65:
                                                                                                if ("null".equals(string)) {
                                                                                                    j6 = 0;
                                                                                                } else {
                                                                                                    j6 = Long.parseLong(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.ay = j6;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 66:
                                                                                                str4 = new String(blob);
                                                                                                if (str4.equals("null")) {
                                                                                                    str4 = "";
                                                                                                }
                                                                                                g.c = str4;
                                                                                                com.igexin.c.a.c.a.b(f38011a, "read from db last redirectAes  = " + g.c);
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 67:
                                                                                                try {
                                                                                                    if (string.equals("null")) {
                                                                                                        i5 = -1;
                                                                                                    } else {
                                                                                                        i5 = Integer.parseInt(string);
                                                                                                    }
                                                                                                    com.igexin.push.core.e.J = i5;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                } catch (Exception e2) {
                                                                                                    e = e2;
                                                                                                }
                                                                                                break;
                                                                                            default:
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                        }
                                                                                        break;
                                                                                }
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        com.igexin.c.a.c.a.a(e);
                                                        com.igexin.c.a.c.a.a(f38011a, e.toString());
                                                        if (cursorQuery != null) {
                                                            cursorQuery.close();
                                                        }
                                                        if (com.igexin.push.core.e.z == 0) {
                                                            jE = j.e();
                                                            if (jE != 0) {
                                                                com.igexin.push.core.e.z = jE;
                                                                a(sQLiteDatabase, i2, g.a(String.valueOf(jE).getBytes()));
                                                            }
                                                        }
                                                        if (com.igexin.push.core.e.A == null && (strC = j.c()) != null) {
                                                            com.igexin.push.core.e.B = strC;
                                                            com.igexin.push.core.e.A = strC;
                                                            a(sQLiteDatabase, i3, g.a(strC.getBytes()));
                                                        }
                                                        if (com.igexin.push.core.e.A == null) {
                                                            j3 = com.igexin.push.core.e.z;
                                                            if (j3 != 0) {
                                                                com.igexin.push.core.e.B = com.igexin.c.b.a.b(String.valueOf(j3));
                                                                com.igexin.push.core.e.a(com.igexin.push.core.e.z);
                                                                a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
                                                            }
                                                        }
                                                        if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.e.A) && ((str3 = com.igexin.push.core.e.A) == null || str3.matches("([a-f]|[0-9]){32}"))) {
                                                            str = null;
                                                        } else if (com.igexin.push.core.e.z != 0) {
                                                            a().a(com.igexin.push.core.e.z);
                                                            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                                                            j.g();
                                                            str = null;
                                                        } else {
                                                            str = null;
                                                            com.igexin.push.core.e.B = null;
                                                            com.igexin.push.core.e.A = "null";
                                                            com.igexin.push.core.e.z = 0L;
                                                        }
                                                        if (TextUtils.isEmpty(com.igexin.push.core.e.an) || "null".equals(com.igexin.push.core.e.an)) {
                                                            String strA = com.igexin.c.b.a.a();
                                                            com.igexin.push.core.e.an = strA;
                                                            a(sQLiteDatabase, 14, g.a(strA.getBytes()));
                                                        }
                                                        strD = j.d();
                                                        if (com.igexin.push.core.e.H == null && strD != null && strD.length() > 5) {
                                                            com.igexin.push.core.e.H = strD;
                                                            b(sQLiteDatabase, 2, strD);
                                                        }
                                                        if (com.igexin.push.core.e.L == null) {
                                                            d();
                                                            b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
                                                            String str15 = com.igexin.push.core.e.L;
                                                        }
                                                        dVarA = d.a(com.igexin.push.core.e.l);
                                                        jSONObjectC = dVarA.c();
                                                        strOptString = jSONObjectC.optString("token", str);
                                                        if (strOptString != null && !strOptString.equals(com.igexin.push.core.e.I)) {
                                                            com.igexin.push.core.e.I = strOptString;
                                                            if (jSONObjectC.optBoolean("isForce")) {
                                                                c("");
                                                            }
                                                            str2 = com.igexin.push.core.e.I;
                                                            if (str2 != null) {
                                                                b(str2);
                                                                dVarA.a(new JSONObject());
                                                            }
                                                        }
                                                        if (this.b) {
                                                            this.b = z2;
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.M)) {
                                                                a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
                                                            }
                                                            j2 = com.igexin.push.core.e.z;
                                                            if (j2 != 0) {
                                                                a(sQLiteDatabase, i2, g.a(String.valueOf(j2).getBytes()));
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                                                                a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.H) && com.igexin.push.core.e.H.length() > 5) {
                                                                b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.L)) {
                                                                b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.I)) {
                                                                b(sQLiteDatabase, 46, com.igexin.push.core.e.I);
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.C)) {
                                                                b(sQLiteDatabase, 51, com.igexin.push.core.e.C);
                                                            }
                                                            if (TextUtils.isEmpty(com.igexin.push.core.e.K)) {
                                                            }
                                                            b(sQLiteDatabase, 48, com.igexin.push.core.e.K);
                                                        }
                                                    }
                                                    str12 = new String(blob);
                                                    if (str12.equals("null")) {
                                                        str12 = null;
                                                    }
                                                    com.igexin.push.core.e.d = str12;
                                                }
                                            } else {
                                                if (string.equals("null")) {
                                                    string = null;
                                                }
                                                com.igexin.push.core.e.H = string;
                                            }
                                        }
                                    } else {
                                        i3 = 20;
                                        if (i8 == 20 || i8 == 25 || i8 == 22 || i8 == 23 || i8 == 31 || i8 == 30 || i8 == 49 || i8 == 50 || i8 == 66 || i8 == 61) {
                                            blob = cursorQuery.getBlob(1);
                                            if (blob != null) {
                                                blob = com.igexin.c.a.a.a.a(blob, com.igexin.push.core.e.M);
                                            }
                                            string = null;
                                            if (blob == null) {
                                            }
                                            if (i8 == 1) {
                                                str13 = new String(blob);
                                                if (str13.equals("null")) {
                                                    j14 = 0;
                                                } else {
                                                    j14 = Long.parseLong(str13);
                                                }
                                                com.igexin.push.core.e.z = j14;
                                                long j16 = com.igexin.push.core.e.z;
                                            } else if (i8 != 2) {
                                                i4 = 3;
                                                if (i8 == 3) {
                                                    if (string.equals("null")) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.L = string;
                                                } else if (i8 == 4) {
                                                    if (string.equals("null")) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = true;
                                                    }
                                                    com.igexin.push.core.e.t = z4;
                                                } else if (i8 == 6) {
                                                    if (string.equals("null")) {
                                                        j13 = 0;
                                                    } else {
                                                        j13 = Long.parseLong(string);
                                                    }
                                                    com.igexin.push.core.e.Q = j13;
                                                } else if (i8 == 8) {
                                                    if (string.equals("null")) {
                                                        j12 = 0;
                                                    } else {
                                                        j12 = Long.parseLong(string);
                                                    }
                                                    com.igexin.push.core.e.R = j12;
                                                } else if (i8 == 40) {
                                                    if (string.equals("null")) {
                                                        z3 = false;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    com.igexin.push.d.c.b.f38095a.b = z3;
                                                    com.igexin.c.a.c.a.a("ConnectModelCoordinator|init, current is polling mdl = ".concat(String.valueOf(z3)), new Object[0]);
                                                    if (z3) {
                                                        com.igexin.push.f.b.d.a.f38124a.g();
                                                    }
                                                } else if (i8 == 53) {
                                                    if ("null".equals(string)) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.aK = string;
                                                } else if (i8 == 54) {
                                                    if ("null".equals(string)) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.aL = string;
                                                } else if (i8 == 60) {
                                                    if (string.equals("null")) {
                                                        j11 = 0;
                                                    } else {
                                                        j11 = Long.parseLong(string);
                                                    }
                                                    com.igexin.push.core.e.c = j11;
                                                } else {
                                                    if (i8 != 61) {
                                                        switch (i8) {
                                                            case 12:
                                                                if (string.equals("null")) {
                                                                    j9 = 0;
                                                                } else {
                                                                    j9 = Long.parseLong(string);
                                                                }
                                                                com.igexin.push.core.e.T = j9;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 13:
                                                                if (string.equals("null")) {
                                                                    string = null;
                                                                }
                                                                com.igexin.push.core.e.V = string;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 14:
                                                                com.igexin.push.core.e.an = new String(blob);
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 15:
                                                                if (!string.equals("null")) {
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                } else {
                                                                    com.igexin.push.core.e.W = Boolean.parseBoolean(string);
                                                                    boolean z6 = com.igexin.push.core.e.t;
                                                                }
                                                                break;
                                                            case 16:
                                                                if (string.equals("null")) {
                                                                    j10 = 0;
                                                                } else {
                                                                    j10 = Long.parseLong(string);
                                                                }
                                                                com.igexin.push.core.e.X = j10;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 17:
                                                                if (string.equals("null")) {
                                                                    string = null;
                                                                }
                                                                com.igexin.push.core.e.Z = string;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            case 18:
                                                                if (string.equals("null")) {
                                                                    i7 = 0;
                                                                } else {
                                                                    i7 = Integer.parseInt(string);
                                                                }
                                                                com.igexin.push.core.e.ab = i7;
                                                                continue;
                                                                continue;
                                                                continue;
                                                            default:
                                                                switch (i8) {
                                                                    case 20:
                                                                        str9 = new String(blob);
                                                                        if (str9.equals("null")) {
                                                                            str9 = null;
                                                                        }
                                                                        com.igexin.push.core.e.B = str9;
                                                                        com.igexin.push.core.e.A = str9;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    case 21:
                                                                        if (string.equals("null")) {
                                                                            j8 = 0;
                                                                        } else {
                                                                            j8 = Long.parseLong(string);
                                                                        }
                                                                        com.igexin.push.core.e.ao = j8;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    case 22:
                                                                        str10 = new String(blob);
                                                                        if (str10.equals("null")) {
                                                                            str10 = null;
                                                                        }
                                                                        com.igexin.push.core.e.aq = str10;
                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last wf result = " + com.igexin.push.core.e.aq, new Object[0]);
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    case 23:
                                                                        str11 = new String(blob);
                                                                        if (str11.equals("null")) {
                                                                            str11 = null;
                                                                        }
                                                                        com.igexin.push.core.e.ap = str11;
                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last mobile result = " + com.igexin.push.core.e.ap, new Object[0]);
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    default:
                                                                        switch (i8) {
                                                                            case 30:
                                                                                str7 = new String(blob);
                                                                                if (str7.equals("null")) {
                                                                                    str7 = null;
                                                                                }
                                                                                com.igexin.push.core.e.as = str7;
                                                                                com.igexin.c.a.c.a.a(f38011a + "|read last domainWfStatus = " + com.igexin.push.core.e.as, new Object[0]);
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                            case 31:
                                                                                str8 = new String(blob);
                                                                                if (str8.equals("null")) {
                                                                                    str8 = null;
                                                                                }
                                                                                com.igexin.push.core.e.ar = str8;
                                                                                com.igexin.c.a.c.a.a(f38011a + "|read last domainMobileStatus = " + com.igexin.push.core.e.ar, new Object[0]);
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                            case 32:
                                                                                if (string.equals("null")) {
                                                                                    j7 = 0;
                                                                                } else {
                                                                                    j7 = Long.parseLong(string);
                                                                                }
                                                                                com.igexin.push.core.e.U = j7;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                                continue;
                                                                            default:
                                                                                switch (i8) {
                                                                                    case 46:
                                                                                        if (string.equals("null")) {
                                                                                            string = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.I = string;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 47:
                                                                                        if (string.equals("null")) {
                                                                                            i6 = 0;
                                                                                        } else {
                                                                                            i6 = Integer.parseInt(string);
                                                                                        }
                                                                                        com.igexin.push.core.e.aA = i6;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 48:
                                                                                        if (string.equals("null")) {
                                                                                            string = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.K = string;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 49:
                                                                                        str5 = new String(blob);
                                                                                        if (str5.equals("null")) {
                                                                                            str5 = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.at = str5;
                                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last wfRedirectCmList = " + com.igexin.push.core.e.at, new Object[0]);
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 50:
                                                                                        str6 = new String(blob);
                                                                                        if (str6.equals("null")) {
                                                                                            str6 = null;
                                                                                        }
                                                                                        com.igexin.push.core.e.au = str6;
                                                                                        com.igexin.c.a.c.a.a(f38011a + "|read last mobileRedirectCmList = " + com.igexin.push.core.e.au, new Object[0]);
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    case 51:
                                                                                        if (!string.equals("null")) {
                                                                                            com.igexin.push.core.e.C = string;
                                                                                        }
                                                                                        String str16 = com.igexin.push.core.e.C;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                        continue;
                                                                                    default:
                                                                                        switch (i8) {
                                                                                            case 63:
                                                                                                if ("null".equals(string)) {
                                                                                                    j4 = 0;
                                                                                                } else {
                                                                                                    j4 = Long.parseLong(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.aw = j4;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 64:
                                                                                                if ("null".equals(string)) {
                                                                                                    j5 = 0;
                                                                                                } else {
                                                                                                    j5 = Long.parseLong(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.ax = j5;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 65:
                                                                                                if ("null".equals(string)) {
                                                                                                    j6 = 0;
                                                                                                } else {
                                                                                                    j6 = Long.parseLong(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.ay = j6;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 66:
                                                                                                str4 = new String(blob);
                                                                                                if (str4.equals("null")) {
                                                                                                    str4 = "";
                                                                                                }
                                                                                                g.c = str4;
                                                                                                com.igexin.c.a.c.a.b(f38011a, "read from db last redirectAes  = " + g.c);
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            case 67:
                                                                                                if (string.equals("null")) {
                                                                                                    i5 = -1;
                                                                                                } else {
                                                                                                    i5 = Integer.parseInt(string);
                                                                                                }
                                                                                                com.igexin.push.core.e.J = i5;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                            default:
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                                continue;
                                                                                        }
                                                                                        break;
                                                                                }
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        com.igexin.c.a.c.a.a(e);
                                                        com.igexin.c.a.c.a.a(f38011a, e.toString());
                                                        if (cursorQuery != null) {
                                                            cursorQuery.close();
                                                        }
                                                        if (com.igexin.push.core.e.z == 0) {
                                                            jE = j.e();
                                                            if (jE != 0) {
                                                                com.igexin.push.core.e.z = jE;
                                                                a(sQLiteDatabase, i2, g.a(String.valueOf(jE).getBytes()));
                                                            }
                                                        }
                                                        if (com.igexin.push.core.e.A == null) {
                                                            com.igexin.push.core.e.B = strC;
                                                            com.igexin.push.core.e.A = strC;
                                                            a(sQLiteDatabase, i3, g.a(strC.getBytes()));
                                                        }
                                                        if (com.igexin.push.core.e.A == null) {
                                                            j3 = com.igexin.push.core.e.z;
                                                            if (j3 != 0) {
                                                                com.igexin.push.core.e.B = com.igexin.c.b.a.b(String.valueOf(j3));
                                                                com.igexin.push.core.e.a(com.igexin.push.core.e.z);
                                                                a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
                                                            }
                                                        }
                                                        if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.e.A)) {
                                                            if (com.igexin.push.core.e.z != 0) {
                                                                a().a(com.igexin.push.core.e.z);
                                                                com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                                                                j.g();
                                                                str = null;
                                                            } else {
                                                                str = null;
                                                                com.igexin.push.core.e.B = null;
                                                                com.igexin.push.core.e.A = "null";
                                                                com.igexin.push.core.e.z = 0L;
                                                            }
                                                        } else if (com.igexin.push.core.e.z != 0) {
                                                            a().a(com.igexin.push.core.e.z);
                                                            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                                                            j.g();
                                                            str = null;
                                                        } else {
                                                            str = null;
                                                            com.igexin.push.core.e.B = null;
                                                            com.igexin.push.core.e.A = "null";
                                                            com.igexin.push.core.e.z = 0L;
                                                        }
                                                        if (TextUtils.isEmpty(com.igexin.push.core.e.an)) {
                                                            String strA2 = com.igexin.c.b.a.a();
                                                            com.igexin.push.core.e.an = strA2;
                                                            a(sQLiteDatabase, 14, g.a(strA2.getBytes()));
                                                        } else {
                                                            String strA3 = com.igexin.c.b.a.a();
                                                            com.igexin.push.core.e.an = strA3;
                                                            a(sQLiteDatabase, 14, g.a(strA3.getBytes()));
                                                        }
                                                        strD = j.d();
                                                        if (com.igexin.push.core.e.H == null) {
                                                            com.igexin.push.core.e.H = strD;
                                                            b(sQLiteDatabase, 2, strD);
                                                        }
                                                        if (com.igexin.push.core.e.L == null) {
                                                            d();
                                                            b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
                                                            String str17 = com.igexin.push.core.e.L;
                                                        }
                                                        dVarA = d.a(com.igexin.push.core.e.l);
                                                        jSONObjectC = dVarA.c();
                                                        strOptString = jSONObjectC.optString("token", str);
                                                        if (strOptString != null) {
                                                            com.igexin.push.core.e.I = strOptString;
                                                            if (jSONObjectC.optBoolean("isForce")) {
                                                                c("");
                                                            }
                                                            str2 = com.igexin.push.core.e.I;
                                                            if (str2 != null) {
                                                                b(str2);
                                                                dVarA.a(new JSONObject());
                                                            }
                                                        }
                                                        if (this.b) {
                                                            this.b = z2;
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.M)) {
                                                                a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
                                                            }
                                                            j2 = com.igexin.push.core.e.z;
                                                            if (j2 != 0) {
                                                                a(sQLiteDatabase, i2, g.a(String.valueOf(j2).getBytes()));
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                                                                a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                                                                b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.L)) {
                                                                b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.I)) {
                                                                b(sQLiteDatabase, 46, com.igexin.push.core.e.I);
                                                            }
                                                            if (!TextUtils.isEmpty(com.igexin.push.core.e.C)) {
                                                                b(sQLiteDatabase, 51, com.igexin.push.core.e.C);
                                                            }
                                                            if (TextUtils.isEmpty(com.igexin.push.core.e.K)) {
                                                                b(sQLiteDatabase, 48, com.igexin.push.core.e.K);
                                                            }
                                                        }
                                                    }
                                                    str12 = new String(blob);
                                                    if (str12.equals("null")) {
                                                        str12 = null;
                                                    }
                                                    com.igexin.push.core.e.d = str12;
                                                }
                                            } else {
                                                if (string.equals("null")) {
                                                    string = null;
                                                }
                                                com.igexin.push.core.e.H = string;
                                            }
                                        } else {
                                            try {
                                                string = cursorQuery.getString(1);
                                                blob = null;
                                                if (blob == null) {
                                                }
                                                if (i8 == 1) {
                                                    str13 = new String(blob);
                                                    if (str13.equals("null")) {
                                                        j14 = 0;
                                                    } else {
                                                        j14 = Long.parseLong(str13);
                                                    }
                                                    com.igexin.push.core.e.z = j14;
                                                    long j17 = com.igexin.push.core.e.z;
                                                } else if (i8 != 2) {
                                                    i4 = 3;
                                                    if (i8 == 3) {
                                                        if (string.equals("null")) {
                                                            string = null;
                                                        }
                                                        com.igexin.push.core.e.L = string;
                                                    } else if (i8 == 4) {
                                                        if (string.equals("null")) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = true;
                                                        }
                                                        com.igexin.push.core.e.t = z4;
                                                    } else if (i8 == 6) {
                                                        if (string.equals("null")) {
                                                            j13 = 0;
                                                        } else {
                                                            j13 = Long.parseLong(string);
                                                        }
                                                        com.igexin.push.core.e.Q = j13;
                                                    } else if (i8 == 8) {
                                                        if (string.equals("null")) {
                                                            j12 = 0;
                                                        } else {
                                                            j12 = Long.parseLong(string);
                                                        }
                                                        com.igexin.push.core.e.R = j12;
                                                    } else if (i8 == 40) {
                                                        if (string.equals("null")) {
                                                            z3 = false;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        com.igexin.push.d.c.b.f38095a.b = z3;
                                                        com.igexin.c.a.c.a.a("ConnectModelCoordinator|init, current is polling mdl = ".concat(String.valueOf(z3)), new Object[0]);
                                                        if (z3) {
                                                            com.igexin.push.f.b.d.a.f38124a.g();
                                                        }
                                                    } else if (i8 == 53) {
                                                        if ("null".equals(string)) {
                                                            string = null;
                                                        }
                                                        com.igexin.push.core.e.aK = string;
                                                    } else if (i8 == 54) {
                                                        if ("null".equals(string)) {
                                                            string = null;
                                                        }
                                                        com.igexin.push.core.e.aL = string;
                                                    } else if (i8 == 60) {
                                                        if (string.equals("null")) {
                                                            j11 = 0;
                                                        } else {
                                                            j11 = Long.parseLong(string);
                                                        }
                                                        com.igexin.push.core.e.c = j11;
                                                    } else {
                                                        if (i8 != 61) {
                                                            switch (i8) {
                                                                case 12:
                                                                    if (string.equals("null")) {
                                                                        j9 = 0;
                                                                    } else {
                                                                        j9 = Long.parseLong(string);
                                                                    }
                                                                    com.igexin.push.core.e.T = j9;
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                case 13:
                                                                    if (string.equals("null")) {
                                                                        string = null;
                                                                    }
                                                                    com.igexin.push.core.e.V = string;
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                case 14:
                                                                    com.igexin.push.core.e.an = new String(blob);
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                case 15:
                                                                    if (!string.equals("null")) {
                                                                        continue;
                                                                        continue;
                                                                        continue;
                                                                    } else {
                                                                        com.igexin.push.core.e.W = Boolean.parseBoolean(string);
                                                                        boolean z7 = com.igexin.push.core.e.t;
                                                                    }
                                                                    break;
                                                                case 16:
                                                                    if (string.equals("null")) {
                                                                        j10 = 0;
                                                                    } else {
                                                                        j10 = Long.parseLong(string);
                                                                    }
                                                                    com.igexin.push.core.e.X = j10;
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                case 17:
                                                                    if (string.equals("null")) {
                                                                        string = null;
                                                                    }
                                                                    com.igexin.push.core.e.Z = string;
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                case 18:
                                                                    if (string.equals("null")) {
                                                                        i7 = 0;
                                                                    } else {
                                                                        i7 = Integer.parseInt(string);
                                                                    }
                                                                    com.igexin.push.core.e.ab = i7;
                                                                    continue;
                                                                    continue;
                                                                    continue;
                                                                default:
                                                                    switch (i8) {
                                                                        case 20:
                                                                            str9 = new String(blob);
                                                                            if (str9.equals("null")) {
                                                                                str9 = null;
                                                                            }
                                                                            com.igexin.push.core.e.B = str9;
                                                                            com.igexin.push.core.e.A = str9;
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                        case 21:
                                                                            if (string.equals("null")) {
                                                                                j8 = 0;
                                                                            } else {
                                                                                j8 = Long.parseLong(string);
                                                                            }
                                                                            com.igexin.push.core.e.ao = j8;
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                        case 22:
                                                                            str10 = new String(blob);
                                                                            if (str10.equals("null")) {
                                                                                str10 = null;
                                                                            }
                                                                            com.igexin.push.core.e.aq = str10;
                                                                            com.igexin.c.a.c.a.a(f38011a + "|read last wf result = " + com.igexin.push.core.e.aq, new Object[0]);
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                        case 23:
                                                                            str11 = new String(blob);
                                                                            if (str11.equals("null")) {
                                                                                str11 = null;
                                                                            }
                                                                            com.igexin.push.core.e.ap = str11;
                                                                            com.igexin.c.a.c.a.a(f38011a + "|read last mobile result = " + com.igexin.push.core.e.ap, new Object[0]);
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                            continue;
                                                                        default:
                                                                            switch (i8) {
                                                                                case 30:
                                                                                    str7 = new String(blob);
                                                                                    if (str7.equals("null")) {
                                                                                        str7 = null;
                                                                                    }
                                                                                    com.igexin.push.core.e.as = str7;
                                                                                    com.igexin.c.a.c.a.a(f38011a + "|read last domainWfStatus = " + com.igexin.push.core.e.as, new Object[0]);
                                                                                    continue;
                                                                                    continue;
                                                                                    continue;
                                                                                case 31:
                                                                                    str8 = new String(blob);
                                                                                    if (str8.equals("null")) {
                                                                                        str8 = null;
                                                                                    }
                                                                                    com.igexin.push.core.e.ar = str8;
                                                                                    com.igexin.c.a.c.a.a(f38011a + "|read last domainMobileStatus = " + com.igexin.push.core.e.ar, new Object[0]);
                                                                                    continue;
                                                                                    continue;
                                                                                    continue;
                                                                                case 32:
                                                                                    if (string.equals("null")) {
                                                                                        j7 = 0;
                                                                                    } else {
                                                                                        j7 = Long.parseLong(string);
                                                                                    }
                                                                                    com.igexin.push.core.e.U = j7;
                                                                                    continue;
                                                                                    continue;
                                                                                    continue;
                                                                                    continue;
                                                                                    continue;
                                                                                    continue;
                                                                                default:
                                                                                    switch (i8) {
                                                                                        case 46:
                                                                                            if (string.equals("null")) {
                                                                                                string = null;
                                                                                            }
                                                                                            com.igexin.push.core.e.I = string;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                        case 47:
                                                                                            if (string.equals("null")) {
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                i6 = Integer.parseInt(string);
                                                                                            }
                                                                                            com.igexin.push.core.e.aA = i6;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                        case 48:
                                                                                            if (string.equals("null")) {
                                                                                                string = null;
                                                                                            }
                                                                                            com.igexin.push.core.e.K = string;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                        case 49:
                                                                                            str5 = new String(blob);
                                                                                            if (str5.equals("null")) {
                                                                                                str5 = null;
                                                                                            }
                                                                                            com.igexin.push.core.e.at = str5;
                                                                                            com.igexin.c.a.c.a.a(f38011a + "|read last wfRedirectCmList = " + com.igexin.push.core.e.at, new Object[0]);
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                        case 50:
                                                                                            str6 = new String(blob);
                                                                                            if (str6.equals("null")) {
                                                                                                str6 = null;
                                                                                            }
                                                                                            com.igexin.push.core.e.au = str6;
                                                                                            com.igexin.c.a.c.a.a(f38011a + "|read last mobileRedirectCmList = " + com.igexin.push.core.e.au, new Object[0]);
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                        case 51:
                                                                                            if (!string.equals("null")) {
                                                                                                com.igexin.push.core.e.C = string;
                                                                                            }
                                                                                            String str18 = com.igexin.push.core.e.C;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                            continue;
                                                                                        default:
                                                                                            switch (i8) {
                                                                                                case 63:
                                                                                                    if ("null".equals(string)) {
                                                                                                        j4 = 0;
                                                                                                    } else {
                                                                                                        j4 = Long.parseLong(string);
                                                                                                    }
                                                                                                    com.igexin.push.core.e.aw = j4;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                case 64:
                                                                                                    if ("null".equals(string)) {
                                                                                                        j5 = 0;
                                                                                                    } else {
                                                                                                        j5 = Long.parseLong(string);
                                                                                                    }
                                                                                                    com.igexin.push.core.e.ax = j5;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                case 65:
                                                                                                    if ("null".equals(string)) {
                                                                                                        j6 = 0;
                                                                                                    } else {
                                                                                                        j6 = Long.parseLong(string);
                                                                                                    }
                                                                                                    com.igexin.push.core.e.ay = j6;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                case 66:
                                                                                                    str4 = new String(blob);
                                                                                                    if (str4.equals("null")) {
                                                                                                        str4 = "";
                                                                                                    }
                                                                                                    g.c = str4;
                                                                                                    com.igexin.c.a.c.a.b(f38011a, "read from db last redirectAes  = " + g.c);
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                case 67:
                                                                                                    if (string.equals("null")) {
                                                                                                        i5 = -1;
                                                                                                    } else {
                                                                                                        i5 = Integer.parseInt(string);
                                                                                                    }
                                                                                                    com.igexin.push.core.e.J = i5;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                default:
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                                    continue;
                                                                                            }
                                                                                            break;
                                                                                    }
                                                                                    break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            com.igexin.c.a.c.a.a(e);
                                                            com.igexin.c.a.c.a.a(f38011a, e.toString());
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                            if (com.igexin.push.core.e.z == 0) {
                                                                jE = j.e();
                                                                if (jE != 0) {
                                                                    com.igexin.push.core.e.z = jE;
                                                                    a(sQLiteDatabase, i2, g.a(String.valueOf(jE).getBytes()));
                                                                }
                                                            }
                                                            if (com.igexin.push.core.e.A == null) {
                                                                com.igexin.push.core.e.B = strC;
                                                                com.igexin.push.core.e.A = strC;
                                                                a(sQLiteDatabase, i3, g.a(strC.getBytes()));
                                                            }
                                                            if (com.igexin.push.core.e.A == null) {
                                                                j3 = com.igexin.push.core.e.z;
                                                                if (j3 != 0) {
                                                                    com.igexin.push.core.e.B = com.igexin.c.b.a.b(String.valueOf(j3));
                                                                    com.igexin.push.core.e.a(com.igexin.push.core.e.z);
                                                                    a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
                                                                }
                                                            }
                                                            if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.e.A)) {
                                                                if (com.igexin.push.core.e.z != 0) {
                                                                    a().a(com.igexin.push.core.e.z);
                                                                    com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                                                                    j.g();
                                                                    str = null;
                                                                } else {
                                                                    str = null;
                                                                    com.igexin.push.core.e.B = null;
                                                                    com.igexin.push.core.e.A = "null";
                                                                    com.igexin.push.core.e.z = 0L;
                                                                }
                                                            } else if (com.igexin.push.core.e.z != 0) {
                                                                a().a(com.igexin.push.core.e.z);
                                                                com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                                                                j.g();
                                                                str = null;
                                                            } else {
                                                                str = null;
                                                                com.igexin.push.core.e.B = null;
                                                                com.igexin.push.core.e.A = "null";
                                                                com.igexin.push.core.e.z = 0L;
                                                            }
                                                            if (TextUtils.isEmpty(com.igexin.push.core.e.an)) {
                                                                String strA4 = com.igexin.c.b.a.a();
                                                                com.igexin.push.core.e.an = strA4;
                                                                a(sQLiteDatabase, 14, g.a(strA4.getBytes()));
                                                            } else {
                                                                String strA5 = com.igexin.c.b.a.a();
                                                                com.igexin.push.core.e.an = strA5;
                                                                a(sQLiteDatabase, 14, g.a(strA5.getBytes()));
                                                            }
                                                            strD = j.d();
                                                            if (com.igexin.push.core.e.H == null) {
                                                                com.igexin.push.core.e.H = strD;
                                                                b(sQLiteDatabase, 2, strD);
                                                            }
                                                            if (com.igexin.push.core.e.L == null) {
                                                                d();
                                                                b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
                                                                String str19 = com.igexin.push.core.e.L;
                                                            }
                                                            dVarA = d.a(com.igexin.push.core.e.l);
                                                            jSONObjectC = dVarA.c();
                                                            strOptString = jSONObjectC.optString("token", str);
                                                            if (strOptString != null) {
                                                                com.igexin.push.core.e.I = strOptString;
                                                                if (jSONObjectC.optBoolean("isForce")) {
                                                                    c("");
                                                                }
                                                                str2 = com.igexin.push.core.e.I;
                                                                if (str2 != null) {
                                                                    b(str2);
                                                                    dVarA.a(new JSONObject());
                                                                }
                                                            }
                                                            if (this.b) {
                                                                this.b = z2;
                                                                if (!TextUtils.isEmpty(com.igexin.push.core.e.M)) {
                                                                    a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
                                                                }
                                                                j2 = com.igexin.push.core.e.z;
                                                                if (j2 != 0) {
                                                                    a(sQLiteDatabase, i2, g.a(String.valueOf(j2).getBytes()));
                                                                }
                                                                if (!TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                                                                    a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
                                                                }
                                                                if (!TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                                                                    b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
                                                                }
                                                                if (!TextUtils.isEmpty(com.igexin.push.core.e.L)) {
                                                                    b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
                                                                }
                                                                if (!TextUtils.isEmpty(com.igexin.push.core.e.I)) {
                                                                    b(sQLiteDatabase, 46, com.igexin.push.core.e.I);
                                                                }
                                                                if (!TextUtils.isEmpty(com.igexin.push.core.e.C)) {
                                                                    b(sQLiteDatabase, 51, com.igexin.push.core.e.C);
                                                                }
                                                                if (TextUtils.isEmpty(com.igexin.push.core.e.K)) {
                                                                    b(sQLiteDatabase, 48, com.igexin.push.core.e.K);
                                                                }
                                                            }
                                                        }
                                                        str12 = new String(blob);
                                                        if (str12.equals("null")) {
                                                            str12 = null;
                                                        }
                                                        com.igexin.push.core.e.d = str12;
                                                    }
                                                } else {
                                                    if (string.equals("null")) {
                                                        string = null;
                                                    }
                                                    com.igexin.push.core.e.H = string;
                                                }
                                            } catch (Throwable th) {
                                                com.igexin.c.a.c.a.a(th);
                                            }
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    i3 = 20;
                                    i4 = 3;
                                }
                            }
                        }
                        i3 = 20;
                        i4 = 3;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i3 = 20;
                        i4 = 3;
                        cursorQuery = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            z2 = false;
            i2 = 1;
            i3 = 20;
            i4 = 3;
        }
        if (com.igexin.push.core.e.z == 0) {
            jE = j.e();
            if (jE != 0) {
                com.igexin.push.core.e.z = jE;
                a(sQLiteDatabase, i2, g.a(String.valueOf(jE).getBytes()));
            }
        }
        if (com.igexin.push.core.e.A == null) {
            com.igexin.push.core.e.B = strC;
            com.igexin.push.core.e.A = strC;
            a(sQLiteDatabase, i3, g.a(strC.getBytes()));
        }
        if (com.igexin.push.core.e.A == null) {
            j3 = com.igexin.push.core.e.z;
            if (j3 != 0) {
                com.igexin.push.core.e.B = com.igexin.c.b.a.b(String.valueOf(j3));
                com.igexin.push.core.e.a(com.igexin.push.core.e.z);
                a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
            }
        }
        if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.e.A)) {
            if (com.igexin.push.core.e.z != 0) {
                a().a(com.igexin.push.core.e.z);
                com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                j.g();
                str = null;
            } else {
                str = null;
                com.igexin.push.core.e.B = null;
                com.igexin.push.core.e.A = "null";
                com.igexin.push.core.e.z = 0L;
            }
        } else if (com.igexin.push.core.e.z != 0) {
            a().a(com.igexin.push.core.e.z);
            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
            j.g();
            str = null;
        } else {
            str = null;
            com.igexin.push.core.e.B = null;
            com.igexin.push.core.e.A = "null";
            com.igexin.push.core.e.z = 0L;
        }
        if (TextUtils.isEmpty(com.igexin.push.core.e.an)) {
            String strA6 = com.igexin.c.b.a.a();
            com.igexin.push.core.e.an = strA6;
            a(sQLiteDatabase, 14, g.a(strA6.getBytes()));
        } else {
            String strA7 = com.igexin.c.b.a.a();
            com.igexin.push.core.e.an = strA7;
            a(sQLiteDatabase, 14, g.a(strA7.getBytes()));
        }
        strD = j.d();
        if (com.igexin.push.core.e.H == null) {
            com.igexin.push.core.e.H = strD;
            b(sQLiteDatabase, 2, strD);
        }
        if (com.igexin.push.core.e.L == null) {
            d();
            b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
            String str110 = com.igexin.push.core.e.L;
        }
        dVarA = d.a(com.igexin.push.core.e.l);
        jSONObjectC = dVarA.c();
        strOptString = jSONObjectC.optString("token", str);
        if (strOptString != null) {
            com.igexin.push.core.e.I = strOptString;
            if (jSONObjectC.optBoolean("isForce")) {
                c("");
            }
            str2 = com.igexin.push.core.e.I;
            if (str2 != null) {
                b(str2);
                dVarA.a(new JSONObject());
            }
        }
        if (this.b) {
            this.b = z2;
            if (!TextUtils.isEmpty(com.igexin.push.core.e.M)) {
                a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
            }
            j2 = com.igexin.push.core.e.z;
            if (j2 != 0) {
                a(sQLiteDatabase, i2, g.a(String.valueOf(j2).getBytes()));
            }
            if (!TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                a(sQLiteDatabase, i3, g.a(com.igexin.push.core.e.A.getBytes()));
            }
            if (!TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
            }
            if (!TextUtils.isEmpty(com.igexin.push.core.e.L)) {
                b(sQLiteDatabase, i4, com.igexin.push.core.e.L);
            }
            if (!TextUtils.isEmpty(com.igexin.push.core.e.I)) {
                b(sQLiteDatabase, 46, com.igexin.push.core.e.I);
            }
            if (!TextUtils.isEmpty(com.igexin.push.core.e.C)) {
                b(sQLiteDatabase, 51, com.igexin.push.core.e.C);
            }
            if (TextUtils.isEmpty(com.igexin.push.core.e.K)) {
                b(sQLiteDatabase, 48, com.igexin.push.core.e.K);
            }
        }
    }

    public final boolean b() {
        com.igexin.push.core.e.z = 0L;
        com.igexin.push.core.e.A = "null";
        d();
        return c();
    }

    public final boolean b(int i2) {
        if (com.igexin.push.core.e.aA == i2) {
            return false;
        }
        com.igexin.push.core.e.aA = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.16
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 47, String.valueOf(com.igexin.push.core.e.aA));
            }
        }, false, true);
    }

    public final boolean b(final long j2) {
        com.igexin.push.core.e.ao = j2;
        com.igexin.c.a.c.a.a(f38011a + "|save idc config failed time : " + j2, new Object[0]);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.2
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 21, String.valueOf(j2));
            }
        }, false, true);
    }

    public final boolean b(String str) {
        com.igexin.push.core.e.I = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.32
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 46, com.igexin.push.core.e.I);
            }
        }, false, true);
    }

    public final boolean b(final String str, boolean z2) {
        com.igexin.c.a.b.e eVarA;
        com.igexin.push.b.d dVar;
        if (str == null) {
            return false;
        }
        if (z2) {
            if (!str.equals(com.igexin.push.core.e.ap)) {
                com.igexin.push.core.e.ap = str.equals("null") ? null : str;
                eVarA = com.igexin.c.a.b.e.a();
                dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.10
                    @Override // com.igexin.push.b.d
                    public final void a_() throws Exception {
                        f.a();
                        f.a(this.d, 23, f.f(str));
                    }
                };
                return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
            }
            return false;
        }
        if (!str.equals(com.igexin.push.core.e.aq)) {
            com.igexin.push.core.e.aq = str.equals("null") ? null : str;
            eVarA = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.11
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 22, f.f(str));
                }
            };
            return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
        }
        return false;
    }

    public final boolean b(final boolean z2) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.18
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 40, String.valueOf(z2));
            }
        }, false, true);
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
        byte[] bArrB = com.igexin.c.a.a.a.b(String.valueOf(com.igexin.push.core.e.z).getBytes(), com.igexin.push.core.e.M);
        long j2 = com.igexin.push.core.e.z;
        a(sQLiteDatabase, 1, bArrB);
        b(sQLiteDatabase, 4, String.valueOf(com.igexin.push.core.e.t));
        b(sQLiteDatabase, 8, String.valueOf(com.igexin.push.core.e.R));
        b(sQLiteDatabase, 32, String.valueOf(com.igexin.push.core.e.U));
        b(sQLiteDatabase, 3, com.igexin.push.core.e.L);
        b(sQLiteDatabase, 12, String.valueOf(com.igexin.push.core.e.T));
        a(sQLiteDatabase, 20, com.igexin.c.a.a.a.b(com.igexin.push.core.e.A.getBytes(), com.igexin.push.core.e.M));
        b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
        a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
    }

    public final boolean c() {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.23
            @Override // com.igexin.push.b.d
            public final void a_() throws Throwable {
                f.a();
                f.b(this.d, 2, com.igexin.push.core.e.H);
                f.a(this.d, 1, f.f(String.valueOf(com.igexin.push.core.e.z)));
                f.a(this.d, 20, f.f(com.igexin.push.core.e.A));
                f.b(this.d, 3, com.igexin.push.core.e.L);
                f.e();
            }
        }, false, true);
    }

    public final boolean c(long j2) {
        if (com.igexin.push.core.e.Q == j2) {
            return false;
        }
        com.igexin.push.core.e.Q = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.15
            @Override // com.igexin.push.b.d
            public final void a_() {
                if (this.d != null) {
                    f.a();
                    f.b(this.d, 6, String.valueOf(com.igexin.push.core.e.Q));
                }
            }
        }, false, true);
    }

    public final boolean c(String str) {
        com.igexin.push.core.e.K = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.33
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 48, com.igexin.push.core.e.K);
            }
        }, false, true);
    }

    public final boolean c(final String str, final boolean z2) {
        if (str == null) {
            return false;
        }
        String str2 = str.equals("null") ? null : str;
        if (z2 && !TextUtils.equals(com.igexin.push.core.e.au, str)) {
            com.igexin.push.core.e.au = str2;
        } else {
            if (z2 || TextUtils.equals(com.igexin.push.core.e.at, str)) {
                return false;
            }
            com.igexin.push.core.e.at = str2;
        }
        com.igexin.c.a.c.a.a(f38011a + "|saveLastRedirectCmList isMobile = " + z2 + ", lastRedirectCmList = " + str, new Object[0]);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.19
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                f.a();
                f.a(this.d, z2 ? 50 : 49, f.f(str));
            }
        }, false, true);
    }

    public final boolean d(long j2) {
        if (com.igexin.push.core.e.aw == j2) {
            return false;
        }
        com.igexin.push.core.e.aw = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.24
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                f.a();
                f.b(this.d, 63, String.valueOf(com.igexin.push.core.e.aw));
            }
        }, false, true);
    }

    public final boolean d(String str) {
        if (str.equals(com.igexin.push.core.e.Z)) {
            return false;
        }
        com.igexin.push.core.e.Z = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.6
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 17, String.valueOf(com.igexin.push.core.e.Z));
            }
        }, false, true);
    }

    public final void e(long j2) {
        if (com.igexin.push.core.e.ay != j2) {
            com.igexin.push.core.e.ay = j2;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.26
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    f.a();
                    f.b(this.d, 65, String.valueOf(com.igexin.push.core.e.ay));
                }
            }, false, true);
        }
    }

    public final boolean e(final String str) {
        com.igexin.push.core.e.d = str.equals("null") ? null : str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.22
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                f.a();
                f.a(this.d, 61, g.a(str.getBytes()));
            }
        }, false, true);
    }
}
