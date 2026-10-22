package com.baidu.location.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.googlecode.mp4parser.boxes.dece.BaseLocationBox;
import com.zj.adlib.u15;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k {
    private static k d;
    private static Object c = new Object();
    private static final String e = com.baidu.location.e.h.g() + "/hst.db";
    private SQLiteDatabase f = null;
    private boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f26364a = null;
    a b = null;
    private String h = null;
    private int i = -2;

    public class a extends com.baidu.location.e.f {
        private String b = null;
        private String c = null;
        private boolean d = true;
        private boolean e = false;

        public a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.ei = 1;
            String strQ = com.baidu.location.c.f.a().q();
            if (strQ != null) {
                this.er = Jni.encodeTp4(strQ);
            }
            String strEncodeTp4 = Jni.encodeTp4(this.c);
            this.c = null;
            this.el.put(BaseLocationBox.TYPE, strEncodeTp4);
        }

        public void a(String str, String str2) {
            if (k.this.g) {
                return;
            }
            k.this.g = true;
            this.b = str;
            if (n.a().b()) {
                this.c = str2 + "&enc=2";
            } else {
                this.c = str2;
            }
            ExecutorService executorServiceC = x.a().c();
            if (executorServiceC != null) {
                a(executorServiceC, com.baidu.location.e.d.e);
            } else {
                b(com.baidu.location.e.d.e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003c A[Catch: Exception -> 0x00ff, PHI: r11
          0x003c: PHI (r11v6 java.lang.String) = 
          (r11v5 java.lang.String)
          (r11v5 java.lang.String)
          (r11v5 java.lang.String)
          (r11v5 java.lang.String)
          (r11v17 java.lang.String)
         binds: [B:7:0x0014, B:9:0x001e, B:15:0x0039, B:11:0x0029, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x00ff, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0039, B:16:0x003c, B:18:0x0044, B:19:0x0048, B:21:0x004c, B:23:0x0058, B:26:0x0060, B:28:0x0066, B:30:0x008e, B:34:0x00dd, B:10:0x0020, B:12:0x002b), top: B:46:0x0010, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:18:0x0044 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0039, B:16:0x003c, B:18:0x0044, B:19:0x0048, B:21:0x004c, B:23:0x0058, B:26:0x0060, B:28:0x0066, B:30:0x008e, B:34:0x00dd, B:10:0x0020, B:12:0x002b), top: B:46:0x0010, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x004c A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0039, B:16:0x003c, B:18:0x0044, B:19:0x0048, B:21:0x004c, B:23:0x0058, B:26:0x0060, B:28:0x0066, B:30:0x008e, B:34:0x00dd, B:10:0x0020, B:12:0x002b), top: B:46:0x0010, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0058 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0039, B:16:0x003c, B:18:0x0044, B:19:0x0048, B:21:0x004c, B:23:0x0058, B:26:0x0060, B:28:0x0066, B:30:0x008e, B:34:0x00dd, B:10:0x0020, B:12:0x002b), top: B:46:0x0010, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x005d  */
        /* JADX WARN: Code duplicated, block: B:26:0x0060 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0039, B:16:0x003c, B:18:0x0044, B:19:0x0048, B:21:0x004c, B:23:0x0058, B:26:0x0060, B:28:0x0066, B:30:0x008e, B:34:0x00dd, B:10:0x0020, B:12:0x002b), top: B:46:0x0010, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x008e A[Catch: Exception -> 0x00ff, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ff, blocks: (B:6:0x0010, B:8:0x0016, B:15:0x0039, B:16:0x003c, B:18:0x0044, B:19:0x0048, B:21:0x004c, B:23:0x0058, B:26:0x0060, B:28:0x0066, B:30:0x008e, B:34:0x00dd, B:10:0x0020, B:12:0x002b), top: B:46:0x0010, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00cf A[Catch: Exception -> 0x00dd, TRY_LEAVE, TryCatch #1 {Exception -> 0x00dd, blocks: (B:31:0x00ad, B:33:0x00cf), top: B:48:0x00ad }] */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
        
            r11 = r10.ej;
         */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            String strD;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            Long lValueOf;
            int i;
            ContentValues contentValues;
            if (z && strD != null) {
                try {
                    if (strD.contains("enc") && n.a().b()) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(strD);
                            if (jSONObject3.has("enc")) {
                                strD = n.a().b(jSONObject3.getString("enc"));
                                if (strD.contains("enc3")) {
                                    strD = com.baidu.location.e.h.d(strD);
                                }
                                if (this.d) {
                                    jSONObject = new JSONObject(strD);
                                    if (jSONObject.has("content")) {
                                        jSONObject2 = jSONObject.getJSONObject("content");
                                    } else {
                                        jSONObject2 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                                        i = jSONObject2.getJSONObject("imo").getInt("mv");
                                        if (Jni.encode3(this.b).longValue() == lValueOf.longValue()) {
                                            contentValues = new ContentValues();
                                            contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                            contentValues.put("hst", Integer.valueOf(i));
                                            if (k.this.f.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                                                contentValues.put("id", lValueOf);
                                                k.this.f.insert("hstdata", null, contentValues);
                                            }
                                            Bundle bundle = new Bundle();
                                            bundle.putByteArray("mac", this.b.getBytes());
                                            bundle.putInt("hotspot", i);
                                            k.this.a(bundle);
                                        }
                                    }
                                }
                            } else {
                                if (strD.contains("enc3")) {
                                    strD = com.baidu.location.e.h.d(strD);
                                }
                                if (this.d) {
                                    jSONObject = new JSONObject(strD);
                                    if (jSONObject.has("content")) {
                                        jSONObject2 = jSONObject.getJSONObject("content");
                                    } else {
                                        jSONObject2 = null;
                                    }
                                    if (jSONObject2 != null) {
                                        lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                                        i = jSONObject2.getJSONObject("imo").getInt("mv");
                                        if (Jni.encode3(this.b).longValue() == lValueOf.longValue()) {
                                            contentValues = new ContentValues();
                                            contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                            contentValues.put("hst", Integer.valueOf(i));
                                            if (k.this.f.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                                                contentValues.put("id", lValueOf);
                                                k.this.f.insert("hstdata", null, contentValues);
                                            }
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putByteArray("mac", this.b.getBytes());
                                            bundle2.putInt("hotspot", i);
                                            k.this.a(bundle2);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (strD.contains("enc3")) {
                            strD = com.baidu.location.e.h.d(strD);
                        }
                        if (this.d) {
                            jSONObject = new JSONObject(strD);
                            if (jSONObject.has("content")) {
                                jSONObject2 = jSONObject.getJSONObject("content");
                            } else {
                                jSONObject2 = null;
                            }
                            if (jSONObject2 != null && jSONObject2.has("imo")) {
                                lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                                i = jSONObject2.getJSONObject("imo").getInt("mv");
                                if (Jni.encode3(this.b).longValue() == lValueOf.longValue()) {
                                    contentValues = new ContentValues();
                                    contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                    contentValues.put("hst", Integer.valueOf(i));
                                    try {
                                        if (k.this.f.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                                            contentValues.put("id", lValueOf);
                                            k.this.f.insert("hstdata", null, contentValues);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putByteArray("mac", this.b.getBytes());
                                    bundle3.putInt("hotspot", i);
                                    k.this.a(bundle3);
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.d) {
                k.this.f();
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            k.this.g = false;
        }
    }

    public static k a() {
        k kVar;
        synchronized (c) {
            if (d == null) {
                d = new k();
            }
            kVar = d;
        }
        return kVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050  */
    /* JADX WARN: Code duplicated, block: B:19:0x0096  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:24:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:26:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:27:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x00cf, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x00e8, please report this as an issue */
    private String a(boolean z) {
        String strO;
        int iB;
        String string;
        String[] strArrSplit;
        String[] strArrSplit2;
        com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
        com.baidu.location.c.k kVarR = com.baidu.location.c.f.a().r();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (aVarF != null && aVarF.b()) {
            stringBuffer.append(com.baidu.location.c.f.a().b(aVarF));
        }
        if (kVarR == null || kVarR.a() <= 1) {
            strO = com.baidu.location.c.f.a().o();
            if (strO != null) {
            }
            if (z) {
                stringBuffer.append("&imo=1");
            }
            stringBuffer.append(com.baidu.location.c.d.a().m());
            stringBuffer.append(com.baidu.location.e.b.a().a(false));
            stringBuffer.append(b.a().c());
            stringBuffer.append(e.a().c());
            stringBuffer.append(com.baidu.location.e.h.d(com.baidu.location.f.getServiceContext()));
            iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
            if (iB >= 0) {
                stringBuffer.append("&lmd=");
                stringBuffer.append(iB);
            }
            stringBuffer.append("&cnloc=");
            stringBuffer.append(l.a().b());
            string = stringBuffer.toString();
            if (string.length() > com.baidu.location.e.h.aN) {
                return string;
            }
            strArrSplit = string.split("&cl_list=");
            if (strArrSplit.length == 2) {
                return string;
            }
            strArrSplit2 = strArrSplit[1].split("&", 2);
            if (strArrSplit2.length == 2) {
                return strArrSplit[0] + "&cl_list=null";
            }
            return strArrSplit[0] + "&cl_list=null&" + strArrSplit2[1];
        }
        strO = com.baidu.location.c.f.a().a(15, false, kVarR, com.baidu.location.e.h.ay);
        stringBuffer.append(strO);
        if (z) {
            stringBuffer.append("&imo=1");
        }
        stringBuffer.append(com.baidu.location.c.d.a().m());
        stringBuffer.append(com.baidu.location.e.b.a().a(false));
        stringBuffer.append(b.a().c());
        stringBuffer.append(e.a().c());
        stringBuffer.append(com.baidu.location.e.h.d(com.baidu.location.f.getServiceContext()));
        iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB >= 0) {
            stringBuffer.append("&lmd=");
            stringBuffer.append(iB);
        }
        stringBuffer.append("&cnloc=");
        stringBuffer.append(l.a().b());
        string = stringBuffer.toString();
        if (string.length() > com.baidu.location.e.h.aN) {
            return string;
        }
        strArrSplit = string.split("&cl_list=");
        if (strArrSplit.length == 2) {
            return string;
        }
        strArrSplit2 = strArrSplit[1].split("&", 2);
        if (strArrSplit2.length == 2) {
            return strArrSplit[0] + "&cl_list=null";
        }
        return strArrSplit[0] + "&cl_list=null&" + strArrSplit2[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        b.a().a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void a(String str) {
        if (this.g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i));
            if (this.f.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                contentValues.put("id", lValueOf);
                this.f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        try {
            File file = new File(e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f = sQLiteDatabaseOpenOrCreateDatabase;
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } finally {
                this.f = null;
            }
        }
    }

    public synchronized int d() {
        int i;
        int i2 = -3;
        if (this.g) {
            return -3;
        }
        try {
            if (com.baidu.location.c.f.a().l() && this.f != null) {
                WifiInfo wifiInfoP = com.baidu.location.c.f.a().p();
                Cursor cursorRawQuery = null;
                String strA = com.baidu.location.c.f.a().a(wifiInfoP, (String) null);
                if (wifiInfoP != null && strA != null) {
                    String strReplace = strA.replace(u15.f19942b, "");
                    Long lEncode3 = Jni.encode3(strReplace);
                    String str = this.h;
                    if (str == null || !strReplace.equals(str) || (i = this.i) <= -2) {
                        try {
                            cursorRawQuery = this.f.rawQuery("select * from hstdata where id = ?", new String[]{String.valueOf(lEncode3)});
                            if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                                i2 = -2;
                            } else {
                                i2 = cursorRawQuery.getInt(1);
                                this.h = strReplace;
                                this.i = i2;
                            }
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                        } catch (Exception unused) {
                            if (cursorRawQuery != null) {
                            }
                        } catch (Throwable th) {
                            if (cursorRawQuery != null) {
                                try {
                                    cursorRawQuery.close();
                                } catch (Exception unused2) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        i2 = i;
                    }
                }
            }
        } catch (Exception unused3) {
        }
        this.i = i2;
        return i2;
    }

    public void e() {
        WifiInfo wifiInfoP;
        if (this.g) {
            return;
        }
        try {
            if (!com.baidu.location.c.f.a().l() || this.f == null || (wifiInfoP = com.baidu.location.c.f.a().p()) == null || wifiInfoP.getBSSID() == null) {
                f();
                return;
            }
            String strReplace = wifiInfoP.getBSSID().replace(u15.f19942b, "");
            boolean z = false;
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = this.f.rawQuery("select * from hstdata where id = ?", new String[]{String.valueOf(Jni.encode3(strReplace))});
                if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                    z = true;
                } else {
                    int i = cursorRawQuery.getInt(1);
                    if ((System.currentTimeMillis() / 1000) - ((long) cursorRawQuery.getInt(2)) > 259200) {
                        z = true;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("mac", strReplace.getBytes());
                        bundle.putInt("hotspot", i);
                        a(bundle);
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            if (z) {
                if (this.f26364a == null) {
                    this.f26364a = new a();
                }
                a aVar = this.f26364a;
                if (aVar != null) {
                    aVar.a(strReplace, a(true));
                }
            }
        } catch (Exception unused4) {
        }
    }
}
