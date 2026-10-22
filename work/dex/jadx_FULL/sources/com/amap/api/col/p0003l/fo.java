package com.amap.api.col.p0003l;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import com.zj.adlib.c49;
import com.zj.adlib.h7b;
import com.zj.adlib.i9b;
import com.zj.adlib.j4b;
import com.zj.adlib.r4b;
import com.zj.adlib.r8b;
import com.zj.adlib.s4b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fo {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile b f901a = b.Unknow;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile d f902a = d.Unknow;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile String f903a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static volatile String f905b = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f25954a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile a f900a = a.Unknow;
    public static volatile long b = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static volatile String f907c = "";

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static volatile String f908d = "";
    public static volatile long c = 0;
    public static volatile long d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile boolean f904a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static volatile boolean f906b = true;

    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);

        private int d;

        a(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }

        public static a a(int i) {
            a aVar = NotAgree;
            if (i == aVar.a()) {
                return aVar;
            }
            a aVar2 = DidAgree;
            return i == aVar2.a() ? aVar2 : Unknow;
        }
    }

    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);

        private int d;

        b(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }

        public static b a(int i) {
            b bVar = NotContain;
            if (i == bVar.a()) {
                return bVar;
            }
            b bVar2 = DidContain;
            return i == bVar2.a() ? bVar2 : Unknow;
        }
    }

    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);

        private final int j;

        c(int i) {
            this.j = i;
        }

        public final int a() {
            return this.j;
        }
    }

    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);

        private int d;

        d(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }

        public static d a(int i) {
            d dVar = NotShow;
            if (i == dVar.a()) {
                return dVar;
            }
            d dVar2 = DidShow;
            return i == dVar2.a() ? dVar2 : Unknow;
        }
    }

    public static class e extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25959a;

        public e(Context context) {
            this.f25959a = context;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            Iterator it = fo.m(fo.t(this.f25959a)).iterator();
            while (it.hasNext()) {
                fo.g(this.f25959a, ((File) it.next()).getName());
            }
            fo.n(this.f25959a);
        }
    }

    public static class f extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f25960a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Context f909a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JSONObject f910a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f911a;

        public f(boolean z, Context context, long j, JSONObject jSONObject) {
            this.f911a = z;
            this.f909a = context;
            this.f25960a = j;
            this.f910a = jSONObject;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            if (this.f911a) {
                Iterator it = fo.m(fo.t(this.f909a)).iterator();
                while (it.hasNext()) {
                    fo.g(this.f909a, ((File) it.next()).getName());
                }
            }
            fo.r(this.f909a);
            fo.h(this.f909a, this.f910a, this.f25960a);
            boolean zP = fo.p(this.f909a, this.f910a);
            if (zP) {
                fo.o(this.f909a, fo.l(this.f25960a));
            }
            if (this.f911a) {
                fo.n(this.f909a);
            }
            if (zP) {
                return;
            }
            fo.g(this.f909a, fo.l(this.f25960a));
        }
    }

    public static synchronized m a(Context context, r4b r4bVar) {
        boolean z;
        try {
            if (context == null || r4bVar == null) {
                return new m(c.IllegalArgument, r4bVar);
            }
            if (!f904a) {
                s(context);
                f904a = true;
            }
            m mVar = null;
            if (f902a != d.DidShow) {
                if (f902a == d.Unknow) {
                    mVar = new m(c.ShowUnknowCode, r4bVar);
                } else if (f902a == d.NotShow) {
                    mVar = new m(c.ShowNoShowCode, r4bVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && f901a != b.DidContain) {
                if (f901a == b.Unknow) {
                    mVar = new m(c.InfoUnknowCode, r4bVar);
                } else if (f901a == b.NotContain) {
                    mVar = new m(c.InfoNotContainCode, r4bVar);
                }
                z = false;
            }
            if (z && f900a != a.DidAgree) {
                if (f900a == a.Unknow) {
                    mVar = new m(c.AgreeUnknowCode, r4bVar);
                } else if (f900a == a.NotAgree) {
                    mVar = new m(c.AgreeNotAgreeCode, r4bVar);
                }
                z = false;
            }
            if (d != c) {
                long j = c;
                d = c;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("privacyInfo", f901a.a());
                    jSONObject.put("privacyShow", f902a.a());
                    jSONObject.put("showTime", f25954a);
                    jSONObject.put("show2SDK", f903a);
                    jSONObject.put("show2SDKVer", f905b);
                    jSONObject.put("privacyAgree", f900a.a());
                    jSONObject.put("agreeTime", b);
                    jSONObject.put("agree2SDK", f907c);
                    jSONObject.put("agree2SDKVer", f908d);
                    z.g().b(new f(f906b, context, j, jSONObject));
                } catch (Throwable unused) {
                }
            } else if (f906b) {
                z.g().b(new e(context));
            }
            f906b = false;
            String strJ = j4b.j(context);
            if (strJ == null || strJ.length() <= 0) {
                mVar = new m(c.InvaildUserKeyCode, r4bVar);
                Log.e(r4bVar.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(mVar.f26036a.a()), mVar.f1069a));
            }
            if (z) {
                mVar = new m(c.SuccessCode, r4bVar);
            } else {
                Log.e(r4bVar.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(mVar.f26036a.a()), mVar.f1069a));
            }
            return mVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void e(Context context, a aVar, r4b r4bVar) {
        if (context == null || r4bVar == null) {
            return;
        }
        if (!f904a) {
            s(context);
            f904a = true;
        }
        if (aVar != f900a) {
            f900a = aVar;
            f907c = r4bVar.a();
            f908d = r4bVar.e();
            long jCurrentTimeMillis = System.currentTimeMillis();
            b = jCurrentTimeMillis;
            c = jCurrentTimeMillis;
            r(context);
        }
    }

    public static synchronized void f(Context context, d dVar, b bVar, r4b r4bVar) {
        if (context == null || r4bVar == null) {
            return;
        }
        if (!f904a) {
            s(context);
            f904a = true;
        }
        Boolean bool = Boolean.FALSE;
        if (dVar != f902a) {
            bool = Boolean.TRUE;
            f902a = dVar;
        }
        if (bVar != f901a) {
            bool = Boolean.TRUE;
            f901a = bVar;
        }
        if (bool.booleanValue()) {
            f903a = r4bVar.a();
            f905b = r4bVar.e();
            long jCurrentTimeMillis = System.currentTimeMillis();
            f25954a = jCurrentTimeMillis;
            c = jCurrentTimeMillis;
            r(context);
        }
    }

    public static /* synthetic */ void g(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(t(context) + WVNativeCallbackUtil.SEPERATER + str);
            if (file.exists()) {
                File file2 = new File(u(context) + WVNativeCallbackUtil.SEPERATER + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void h(Context context, JSONObject jSONObject, long j) {
        FileOutputStream fileOutputStream = null;
        try {
            byte[] bArrM = r8b.m(context, jSONObject.toString().getBytes());
            String strL = l(j);
            File file = new File(t(context) + WVNativeCallbackUtil.SEPERATER + strL);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArrM);
                try {
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                fileOutputStream = fileOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void i(Context context, boolean z, r4b r4bVar) {
        e(context, z ? a.DidAgree : a.NotAgree, r4bVar);
    }

    public static void j(Context context, boolean z, boolean z2, r4b r4bVar) {
        f(context, z2 ? d.DidShow : d.NotShow, z ? b.DidContain : b.NotContain, r4bVar);
    }

    public static String l(long j) {
        return String.format("%d-%s", Long.valueOf(j), "privacy.data");
    }

    public static ArrayList<File> m(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            File[] fileArrListFiles = file.listFiles();
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void n(Context context) {
        try {
            for (File file : m(u(context))) {
                try {
                    String name = file.getName();
                    if (name.endsWith("-privacy.data")) {
                        String[] strArrSplit = name.split(c49.f40900a);
                        if (strArrSplit == null && strArrSplit.length != 2) {
                            file.delete();
                        } else if (Long.parseLong(strArrSplit[0]) <= 0) {
                            file.delete();
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (p(context, new JSONObject(new String(r8b.q(context, bArr))))) {
                                file.delete();
                            }
                        }
                    } else {
                        file.delete();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void o(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(t(context) + WVNativeCallbackUtil.SEPERATER + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean p(Context context, JSONObject jSONObject) {
        try {
            h7b h7bVar = new h7b();
            h7bVar.b = context;
            h7bVar.f42068a = jSONObject;
            new hl();
            i9b i9bVarE = hl.e(h7bVar);
            if (i9bVarE == null) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(s4b.g(i9bVarE.f17171a));
            return jSONObject2.has("status") && jSONObject2.getInt("status") == 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static synchronized void r(Context context) {
        if (context == null) {
            return;
        }
        if (!f904a) {
            s(context);
            f904a = true;
        }
        try {
            r8b.d(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f901a.a()), Integer.valueOf(f902a.a()), Long.valueOf(f25954a), f903a, f905b, Integer.valueOf(f900a.a()), Long.valueOf(b), f907c, f908d, Long.valueOf(c), Long.valueOf(d)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void s(Context context) {
        String strC;
        if (context == null) {
            return;
        }
        try {
            strC = r8b.c(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
            strC = null;
        }
        if (strC == null) {
            return;
        }
        String[] strArrSplit = strC.split("&");
        if (strArrSplit.length != 11) {
            return;
        }
        try {
            f901a = b.a(Integer.parseInt(strArrSplit[0]));
            f902a = d.a(Integer.parseInt(strArrSplit[1]));
            f25954a = Long.parseLong(strArrSplit[2]);
            f905b = strArrSplit[3];
            f905b = strArrSplit[4];
            f900a = a.a(Integer.parseInt(strArrSplit[5]));
            b = Long.parseLong(strArrSplit[6]);
            f907c = strArrSplit[7];
            f908d = strArrSplit[8];
            c = Long.parseLong(strArrSplit[9]);
            d = Long.parseLong(strArrSplit[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static String t(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    public static String u(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
