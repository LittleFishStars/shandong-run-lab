package com.autonavi.aps.amapapi.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.android.arouter.utils.Consts;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.d;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.utils.i;
import com.zj.adlib.bv9;
import com.zj.adlib.m4b;
import com.zj.adlib.mm9;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<C0253a>> f26191a = new Hashtable<>();
    private long i = 0;
    private boolean j = false;
    private String k = "2.0.201501131131".replace(Consts.DOT, "");
    private String l = null;
    boolean b = true;
    long c = 0;
    String d = null;
    d e = null;
    private String m = null;
    private long n = 0;
    boolean f = true;
    boolean g = true;
    String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* JADX INFO: renamed from: com.autonavi.aps.amapapi.storage.a$a, reason: collision with other inner class name */
    public static class C0253a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.autonavi.aps.amapapi.model.a f26192a = null;
        private String b = null;

        public final com.autonavi.aps.amapapi.model.a a() {
            return this.f26192a;
        }

        public final String b() {
            return this.b;
        }

        public final void a(com.autonavi.aps.amapapi.model.a aVar) {
            this.f26192a = aVar;
        }

        public final void a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = null;
            } else {
                this.b = str.replace("##", "#");
            }
        }
    }

    private boolean b() {
        long jB = i.b();
        long j = this.i;
        long j2 = jB - j;
        if (j == 0) {
            return false;
        }
        return this.f26191a.size() > 360 || j2 > 172800000;
    }

    private void c() {
        this.i = 0L;
        if (!this.f26191a.isEmpty()) {
            this.f26191a.clear();
        }
        this.j = false;
    }

    public final void a(String str, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar, Context context, boolean z) {
        try {
            if (i.a(aVar)) {
                String str2 = str + "&" + aVar.isOffset() + "&" + aVar.i() + "&" + aVar.j();
                if (!a(str2, aVar) || aVar.e().equals("mem") || aVar.e().equals("file") || aVar.e().equals("wifioff") || "-3".equals(aVar.d())) {
                    return;
                }
                if (b()) {
                    c();
                }
                JSONObject jSONObjectF = aVar.f();
                if (i.a(jSONObjectF, "offpct")) {
                    jSONObjectF.remove("offpct");
                    aVar.a(jSONObjectF);
                }
                if (str2.contains("wifi")) {
                    if (TextUtils.isEmpty(sb)) {
                        return;
                    }
                    if (aVar.getAccuracy() >= 300.0f) {
                        int i = 0;
                        for (String str3 : sb.toString().split("#")) {
                            if (str3.contains(",")) {
                                i++;
                            }
                        }
                        if (i >= 8) {
                            return;
                        }
                    } else if (aVar.getAccuracy() <= 3.0f) {
                        return;
                    }
                    if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aVar.g())) {
                        String strReplace = str2.replace("cgiwifi", "cgi");
                        com.autonavi.aps.amapapi.model.a aVarH = aVar.h();
                        if (i.a(aVarH)) {
                            a(strReplace, new StringBuilder(), aVarH, context, true);
                        }
                    }
                } else if (str2.contains("cgi") && ((sb != null && sb.indexOf(",") != -1) || "4".equals(aVar.d()))) {
                    return;
                }
                com.autonavi.aps.amapapi.model.a aVarA = a(str2, sb, false);
                if (i.a(aVarA) && aVarA.toStr().equals(aVar.toStr(3))) {
                    return;
                }
                this.i = i.b();
                C0253a c0253a = new C0253a();
                c0253a.a(aVar);
                c0253a.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                if (this.f26191a.containsKey(str2)) {
                    this.f26191a.get(str2).add(c0253a);
                } else {
                    ArrayList<C0253a> arrayList = new ArrayList<>();
                    arrayList.add(c0253a);
                    this.f26191a.put(str2, arrayList);
                }
                if (z) {
                    try {
                        a(str2, aVar, sb, context);
                    } catch (Throwable th) {
                        com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "add");
                    }
                }
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "Cache", "add");
        }
    }

    public final void b(Context context) {
        try {
            c();
            c(context);
            this.j = false;
            this.d = null;
            this.n = 0L;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "destroy part");
        }
    }

    private void c(Context context) throws Exception {
        if (context == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        try {
            sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            if (!i.a(sQLiteDatabaseOpenOrCreateDatabase, "hist")) {
                if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    return;
                }
                sQLiteDatabaseOpenOrCreateDatabase.close();
                return;
            }
            try {
                sQLiteDatabaseOpenOrCreateDatabase.delete("hist" + this.k, "time<?", new String[]{String.valueOf(i.a() - 172800000)});
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "clearHist");
                String message = th.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    message.contains("no such table");
                }
            }
            if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                return;
            }
            sQLiteDatabaseOpenOrCreateDatabase.close();
        } catch (Throwable th2) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th2, "DB", "clearHist p2");
            } finally {
                if (sQLiteDatabaseOpenOrCreateDatabase != null && sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                }
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(Context context, String str, StringBuilder sb, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str) || !com.autonavi.aps.amapapi.utils.a.e()) {
            return null;
        }
        String str2 = str + "&" + this.f + "&" + this.g + "&" + this.h;
        if (str2.contains("gps") || !com.autonavi.aps.amapapi.utils.a.e() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z && !this.j) {
            try {
                String strA = a(str2, sb, context);
                c();
                a(context, strA, z2);
            } catch (Throwable unused) {
            }
        }
        if (this.f26191a.isEmpty()) {
            return null;
        }
        return a(str2, sb, z2);
    }

    private com.autonavi.aps.amapapi.model.a a(String str, StringBuilder sb, boolean z) {
        C0253a c0253aA;
        try {
            if (!str.contains("cgiwifi") && !str.contains("wifi")) {
                c0253aA = (str.contains("cgi") && this.f26191a.containsKey(str) && this.f26191a.get(str).size() > 0) ? this.f26191a.get(str).get(0) : null;
            } else {
                c0253aA = a(sb, str);
            }
            if (c0253aA != null && i.a(c0253aA.a())) {
                com.autonavi.aps.amapapi.model.a aVarA = c0253aA.a();
                aVarA.e("mem");
                aVarA.h(c0253aA.b());
                if (!z && !com.autonavi.aps.amapapi.utils.a.a(aVarA.getTime())) {
                    Hashtable<String, ArrayList<C0253a>> hashtable = this.f26191a;
                    if (hashtable != null && hashtable.containsKey(str)) {
                        this.f26191a.get(str).remove(c0253aA);
                    }
                }
                if (i.a(aVarA)) {
                    this.c = 0L;
                }
                aVarA.setLocationType(4);
                return aVarA;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "get1");
        }
        return null;
    }

    private static boolean a(String str, com.autonavi.aps.amapapi.model.a aVar) {
        if (TextUtils.isEmpty(str) || !i.a(aVar) || str.startsWith("#")) {
            return false;
        }
        return str.contains("network");
    }

    private C0253a a(StringBuilder sb, String str) {
        C0253a c0253a;
        char c;
        C0253a c0253a2;
        if (this.f26191a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!this.f26191a.containsKey(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        ArrayList<C0253a> arrayList = this.f26191a.get(str);
        char c2 = 1;
        int size = arrayList.size() - 1;
        while (true) {
            if (size >= 0) {
                C0253a c0253a3 = arrayList.get(size);
                if (!TextUtils.isEmpty(c0253a3.b())) {
                    if (a(c0253a3.b(), sb)) {
                        if (!i.a(c0253a3.b(), sb.toString())) {
                            c = c2;
                        }
                        c0253a2 = c0253a3;
                        break;
                    }
                    c = 0;
                    a(c0253a3.b(), (Hashtable<String, String>) hashtable);
                    a(sb.toString(), (Hashtable<String, String>) hashtable2);
                    hashtable3.clear();
                    Iterator it = hashtable.keySet().iterator();
                    while (it.hasNext()) {
                        hashtable3.put((String) it.next(), "");
                    }
                    Iterator it2 = hashtable2.keySet().iterator();
                    while (it2.hasNext()) {
                        hashtable3.put((String) it2.next(), "");
                    }
                    Set setKeySet = hashtable3.keySet();
                    double[] dArr = new double[setKeySet.size()];
                    double[] dArr2 = new double[setKeySet.size()];
                    Iterator it3 = setKeySet.iterator();
                    int i = 0;
                    while (it3 != null && it3.hasNext()) {
                        String str2 = (String) it3.next();
                        double d = 1.0d;
                        dArr[i] = hashtable.containsKey(str2) ? 1.0d : 0.0d;
                        if (!hashtable2.containsKey(str2)) {
                            d = 0.0d;
                        }
                        dArr2[i] = d;
                        i++;
                    }
                    setKeySet.clear();
                    double[] dArrA = a(dArr, dArr2);
                    if (dArrA[0] < 0.800000011920929d) {
                        c0253a2 = c0253a3;
                        if (dArrA[c2] >= Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d) || (c != 0 && dArrA[0] >= Math.min(com.autonavi.aps.amapapi.utils.a.g(), 0.618d))) {
                            break;
                        }
                    } else {
                        c0253a2 = c0253a3;
                        break;
                    }
                }
                size--;
                c2 = 1;
            } else {
                c0253a = null;
            }
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
            return c0253a;
        }
        c0253a = c0253a2;
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return c0253a;
    }

    private static boolean a(String str, StringBuilder sb) {
        String strSubstring;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] strArrSplit = str.split(",access");
        if (strArrSplit[0].contains("#")) {
            String str2 = strArrSplit[0];
            strSubstring = str2.substring(str2.lastIndexOf("#") + 1);
        } else {
            strSubstring = strArrSplit[0];
        }
        if (TextUtils.isEmpty(strSubstring)) {
            return false;
        }
        return sb.toString().contains(strSubstring + ",access");
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                hashtable.put(str2, "");
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            double d4 = dArr[i3];
            d2 += d4 * d4;
            double d5 = dArr2[i3];
            d3 += d5 * d5;
            d += d4 * d5;
            if (d5 == 1.0d) {
                i2++;
                if (d4 == 1.0d) {
                    i++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d2) * Math.sqrt(d3));
        double d6 = i;
        dArr3[1] = (d6 * 1.0d) / ((double) i2);
        dArr3[2] = d6;
        for (int i4 = 0; i4 < 2; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
        }
        return dArr3;
    }

    public final void a(Context context) {
        if (this.j) {
            return;
        }
        try {
            c();
            a(context, (String) null, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cache", "loadDB");
        }
        this.j = true;
    }

    private String a(String str, StringBuilder sb, Context context) {
        String strSubstring;
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            this.l = i.l(context);
            if (str.contains("&")) {
                str = str.substring(0, str.indexOf("&"));
            }
            String strSubstring2 = str.substring(str.lastIndexOf("#") + 1);
            if (strSubstring2.equals("cgi")) {
                jSONObject.put("cgi", str.substring(0, str.length() - 12));
            } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
                jSONObject.put("cgi", str.substring(0, str.length() - (strSubstring2.length() + 9)));
                String[] strArrSplit = sb.toString().split(",access");
                if (strArrSplit[0].contains("#")) {
                    String str2 = strArrSplit[0];
                    strSubstring = str2.substring(str2.lastIndexOf("#") + 1);
                } else {
                    strSubstring = strArrSplit[0];
                }
                jSONObject.put("mmac", strSubstring);
            }
            return m4b.f(com.autonavi.aps.amapapi.security.a.a(jSONObject.toString().getBytes("UTF-8"), this.l));
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context == null) {
            return;
        }
        if (this.l == null) {
            this.l = i.l(context);
        }
        String strA = a(str, sb, context);
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = null;
        try {
            sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
            sb2.append("CREATE TABLE IF NOT EXISTS hist");
            sb2.append(this.k);
            sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
            sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb2.toString());
            sb2.delete(0, sb2.length());
            sb2.append("REPLACE INTO ");
            sb2.append("hist");
            sb2.append(this.k);
            sb2.append(" VALUES (?, ?, ?, ?)");
            Object[] objArr = new Object[4];
            objArr[0] = strA;
            byte[] bArrA = com.autonavi.aps.amapapi.security.a.a(sb.toString().getBytes("UTF-8"), this.l);
            objArr[1] = bArrA;
            objArr[2] = com.autonavi.aps.amapapi.security.a.a(aMapLocation.toStr().getBytes("UTF-8"), this.l);
            objArr[3] = Long.valueOf(aMapLocation.getTime());
            for (int i = 1; i < 3; i++) {
                objArr[i] = m4b.f((byte[]) objArr[i]);
            }
            sQLiteDatabaseOpenOrCreateDatabase.execSQL(sb2.toString(), objArr);
            sb2.delete(0, sb2.length());
            sb2.delete(0, sb2.length());
            if (sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                sQLiteDatabaseOpenOrCreateDatabase.close();
            }
        } catch (Throwable th) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "updateHist");
            } finally {
                sb2.delete(0, sb2.length());
                if (sQLiteDatabaseOpenOrCreateDatabase != null && sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                    sQLiteDatabaseOpenOrCreateDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x02a5 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:108:0x02aa A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:110:0x02b0 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:133:0x026b A[EDGE_INSN: B:133:0x026b->B:85:0x026b BREAK  A[LOOP:0: B:40:0x00d1->B:87:0x027b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x027b A[LOOP:0: B:40:0x00d1->B:87:0x027b, LOOP_END] */
    private void a(Context context, String str, boolean z) throws Exception {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str2;
        if (com.autonavi.aps.amapapi.utils.a.e() && context != null) {
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                int i = 0;
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                try {
                    try {
                        if (!i.a(sQLiteDatabaseOpenOrCreateDatabase, "hist")) {
                            if (sQLiteDatabaseOpenOrCreateDatabase == null || !sQLiteDatabaseOpenOrCreateDatabase.isOpen()) {
                                return;
                            }
                            sQLiteDatabaseOpenOrCreateDatabase.close();
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        if (!z) {
                            long jA = i.a() - com.autonavi.aps.amapapi.utils.a.d();
                            sb.append("time >");
                            sb.append(jA);
                            if (str != null) {
                                sb.append(" and feature = '");
                                sb.append(str + "'");
                            }
                        } else {
                            long jA2 = i.a() - 172800000;
                            sb.append("time >");
                            sb.append(jA2);
                            if (str != null) {
                                sb.append(" and feature = '");
                                sb.append(str + "'");
                            }
                        }
                        cursorQuery = sQLiteDatabaseOpenOrCreateDatabase.query("hist" + this.k, new String[]{mm9.f18258b, " nb", "loc"}, sb.toString(), null, null, null, "time ASC", null);
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.l == null) {
                                try {
                                    this.l = i.l(context);
                                } catch (Throwable th) {
                                    th = th;
                                    sQLiteDatabase2 = sQLiteDatabaseOpenOrCreateDatabase;
                                    com.autonavi.aps.amapapi.utils.b.a(th, "DB", "fetchHist p2");
                                }
                            }
                            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                                sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                            } else {
                                while (true) {
                                    if (cursorQuery.getString(i).startsWith(bv9.b)) {
                                        jSONObject2 = new JSONObject(cursorQuery.getString(i));
                                        sb2.delete(i, sb2.length());
                                        if (!TextUtils.isEmpty(cursorQuery.getString(1))) {
                                            sb2.append(cursorQuery.getString(1));
                                        } else if (i.a(jSONObject2, "mmac")) {
                                            sb2.append("#");
                                            sb2.append(jSONObject2.getString("mmac"));
                                            sb2.append(",access");
                                        }
                                        jSONObject = new JSONObject(cursorQuery.getString(2));
                                        if (i.a(jSONObject, "type")) {
                                            jSONObject.put("type", "new");
                                        }
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject(new String(com.autonavi.aps.amapapi.security.a.b(m4b.g(cursorQuery.getString(i)), this.l), "UTF-8"));
                                        sb2.delete(0, sb2.length());
                                        if (!TextUtils.isEmpty(cursorQuery.getString(1))) {
                                            sb2.append(new String(com.autonavi.aps.amapapi.security.a.b(m4b.g(cursorQuery.getString(1)), this.l), "UTF-8"));
                                        } else if (i.a(jSONObject3, "mmac")) {
                                            sb2.append("#");
                                            sb2.append(jSONObject3.getString("mmac"));
                                            sb2.append(",access");
                                        }
                                        jSONObject = new JSONObject(new String(com.autonavi.aps.amapapi.security.a.b(m4b.g(cursorQuery.getString(2)), this.l), "UTF-8"));
                                        if (i.a(jSONObject, "type")) {
                                            jSONObject.put("type", "new");
                                        }
                                        jSONObject2 = jSONObject3;
                                    }
                                    com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
                                    aVar.b(jSONObject);
                                    try {
                                        if (i.a(jSONObject2, "mmac") && i.a(jSONObject2, "cgi")) {
                                            String str3 = (jSONObject2.getString("cgi") + "#") + "network#";
                                            if (jSONObject2.getString("cgi").contains("#")) {
                                                str2 = str3 + "cgiwifi";
                                            } else {
                                                str2 = str3 + "wifi";
                                            }
                                        } else {
                                            if (i.a(jSONObject2, "cgi")) {
                                                String str4 = (jSONObject2.getString("cgi") + "#") + "network#";
                                                if (jSONObject2.getString("cgi").contains("#")) {
                                                    str2 = str4 + "cgi";
                                                }
                                                if (!cursorQuery.moveToNext()) {
                                                    break;
                                                }
                                                sb = sb;
                                                sQLiteDatabaseOpenOrCreateDatabase = sQLiteDatabase;
                                                i = 0;
                                            }
                                            sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                                            if (!cursorQuery.moveToNext()) {
                                                break;
                                                break;
                                            } else {
                                                sb = sb;
                                                sQLiteDatabaseOpenOrCreateDatabase = sQLiteDatabase;
                                                i = 0;
                                            }
                                        }
                                        a(str2, sb2, aVar, context, false);
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                            break;
                                        } else {
                                            sb = sb;
                                            sQLiteDatabaseOpenOrCreateDatabase = sQLiteDatabase;
                                            i = 0;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                                }
                                sb2.delete(0, sb2.length());
                                sb.delete(0, sb.length());
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        cursorQuery = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = sQLiteDatabaseOpenOrCreateDatabase;
                    cursorQuery = null;
                }
                sQLiteDatabase2 = sQLiteDatabase;
            } catch (Throwable th6) {
                th = th6;
                cursorQuery = null;
            }
            try {
                com.autonavi.aps.amapapi.utils.b.a(th, "DB", "fetchHist p2");
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                    sQLiteDatabase2.close();
                }
            }
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
        this.h = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void a(d dVar) {
        this.e = dVar;
    }

    private boolean a(com.autonavi.aps.amapapi.model.a aVar, boolean z) {
        if (a(z)) {
            return aVar == null || com.autonavi.aps.amapapi.utils.a.a(aVar.getTime()) || z;
        }
        return false;
    }

    private boolean a(boolean z) {
        if (com.autonavi.aps.amapapi.utils.a.e() || z) {
            return this.b || com.autonavi.aps.amapapi.utils.a.f() || z;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e0  */
    public final com.autonavi.aps.amapapi.model.a a(e eVar, boolean z, com.autonavi.aps.amapapi.model.a aVar, com.autonavi.aps.amapapi.restruct.i iVar, StringBuilder sb, String str, Context context, boolean z2) {
        d dVar;
        boolean z3;
        boolean zA;
        String str2;
        com.autonavi.aps.amapapi.model.a aVarA;
        boolean z4;
        String str3;
        if (!a(aVar, z2)) {
            return null;
        }
        try {
            d dVarE = eVar.e();
            boolean z5 = !(dVarE == null && this.e == null) && ((dVar = this.e) == null || !dVar.equals(dVarE));
            if (aVar != null) {
                z3 = aVar.getAccuracy() > 299.0f && iVar.e().size() > 5;
            } else {
                z3 = false;
            }
            if (aVar == null || (str3 = this.d) == null || z3 || z5) {
                zA = false;
            } else {
                zA = i.a(str3, sb.toString());
                boolean z6 = this.c != 0 && i.b() - this.c < 3000;
                if ((zA || z6) && i.a(aVar)) {
                    aVar.e("mem");
                    aVar.setLocationType(2);
                    return aVar;
                }
            }
            if (!zA) {
                this.c = i.b();
            } else {
                this.c = 0L;
            }
            String str4 = this.m;
            if (str4 == null || str.equals(str4)) {
                if (this.m == null) {
                    this.n = i.a();
                    this.m = str;
                } else {
                    this.n = i.a();
                }
            } else {
                if (i.a() - this.n < 3000) {
                    str2 = this.m;
                } else {
                    this.n = i.a();
                    this.m = str;
                }
                if (!z3 || z) {
                    aVarA = null;
                } else {
                    aVarA = a(context, str2, sb, false, false);
                }
                if (!z || i.a(aVarA)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!z4 || z3 || z) {
                    return null;
                }
                this.c = 0L;
                aVarA.setLocationType(4);
                return aVarA;
            }
            str2 = str;
            if (z3) {
                aVarA = null;
            } else {
                aVarA = null;
            }
            if (z) {
                z4 = false;
            } else {
                z4 = false;
            }
            if (z4) {
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a() {
        this.c = 0L;
        this.d = null;
    }
}
