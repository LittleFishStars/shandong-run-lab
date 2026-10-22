package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.zj.adlib.c49;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40142a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 0;
    public static final int e = 8;
    public static final int f = 1;
    public static final int g = 3;
    public static final int h = 4;
    private static long o;
    private Context j;
    private q k;
    private t l;
    private File m;
    private dn n;
    private int p;
    private boolean r;
    private int q = 0;
    List<Integer> i = new ArrayList();
    private Map<Integer, a> s = new HashMap();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f40143a;

        public a(int i) {
            this.f40143a = i;
        }
    }

    public u(Context context, int i, boolean z) {
        this.p = 0;
        this.r = false;
        this.j = context;
        this.k = q.a(context);
        this.l = t.a(context);
        this.n = dn.a(context);
        this.m = new File(context.getFilesDir(), ".tmp");
        this.p = i;
        this.r = z;
    }

    public JSONObject a() {
        try {
            String str = cs.f40095a + cs.g;
            String strA = ct.a(this.j);
            if (!TextUtils.isEmpty(strA)) {
                str = str + "?" + strA;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObjectC = ct.c(this.j);
            if (jSONObjectC != null) {
                jSONObject.put("data", new bl(this.j).c(jSONObjectC.toString()));
            }
            l lVarA = l.a(this.j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(lVarA.a(mVar));
            int iOptInt = jSONObject2.optInt("result", 0);
            if (iOptInt != 1) {
                if (iOptInt != -7) {
                    return null;
                }
                dn.a(this.j).a(dn.f40122a, 1, false);
                return null;
            }
            String strA2 = new bl(this.j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(strA2)) {
                if (this.q == 0) {
                    this.q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(strA2);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            dn dnVar = this.n;
            if (dnVar == null) {
                return null;
            }
            dnVar.a(dn.b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (u.class) {
                try {
                    int i = this.p;
                    if (i != 1 && i != 2 && i != 4 && !this.r && System.currentTimeMillis() - o < 300000) {
                        WeaponHI.iD();
                        return;
                    }
                    this.l.d();
                    o = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.n.a(dn.b)) - (((long) this.n.a(dn.c, 6)) * 3600000) > 0) {
                        List<s> listA = this.l.a();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<s> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject jSONObjectA = a();
                        if (jSONObjectA == null) {
                            throw new Exception("pluginJsonObject is null ");
                        }
                        boolean z = false;
                        try {
                            boolean zB = dk.b(this.j);
                            Iterator<String> itKeys = jSONObjectA.keys();
                            HashSet hashSet = new HashSet();
                            boolean z2 = false;
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                if (zB && next.endsWith("64")) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                } else if (zB || !next.endsWith("32")) {
                                    if (zB && next.endsWith("v8")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                            z2 = true;
                                        }
                                    } else if (!zB && next.endsWith("v7")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                        }
                                    }
                                    z2 = true;
                                } else if (next.length() > 3) {
                                    hashSet.add(next.substring(0, next.length() - 3));
                                    hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                Iterator it = hashSet.iterator();
                                while (it.hasNext()) {
                                    jSONObjectA.remove((String) it.next());
                                }
                            }
                            z = z2;
                        } catch (Throwable unused) {
                        }
                        Iterator<String> itKeys2 = jSONObjectA.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            s sVarA = o.a(jSONObjectA.optJSONObject(next2));
                            if (sVarA != null) {
                                if (z && !sVarA.y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                    sVarA.y = true;
                                }
                                if (sVarA.v) {
                                    arrayList4.add(next2);
                                }
                                if (!sVarA.y) {
                                    arrayList3.add(sVarA);
                                }
                                int iIndexOf = listA.indexOf(sVarA);
                                if (iIndexOf < 0 || !sVarA.y) {
                                    itKeys2 = itKeys2;
                                    jSONObjectA = jSONObjectA;
                                    z = z;
                                    if (sVarA.y) {
                                        arrayList2.add(sVarA);
                                    }
                                } else {
                                    s sVar = listA.get(iIndexOf);
                                    if (dl.b(sVarA.d, sVar.d)) {
                                        int i2 = sVarA.x;
                                        if (i2 != sVar.x) {
                                            this.l.c(sVarA.f40139a, i2);
                                        }
                                        if (!this.l.d(sVarA.f40139a)) {
                                            arrayList2.add(sVarA);
                                        }
                                    } else {
                                        this.n.a(dn.b, System.currentTimeMillis(), true);
                                        int i3 = sVarA.x;
                                        if (i3 != sVar.x) {
                                            this.l.c(sVarA.f40139a, i3);
                                        }
                                        arrayList.add(sVarA);
                                    }
                                    listA.remove(iIndexOf);
                                }
                                jSONObjectA = jSONObjectA;
                                z = z;
                                itKeys2 = itKeys2;
                            }
                        }
                        for (s sVar2 : listA) {
                            if (!arrayList4.contains(sVar2.c)) {
                                List<Integer> list = this.i;
                                if (list != null) {
                                    list.add(Integer.valueOf(sVar2.f40139a));
                                }
                                this.k.a(sVar2.c);
                            }
                        }
                        for (s sVar3 : arrayList3) {
                            if (!arrayList4.contains(sVar3.c)) {
                                List<Integer> list2 = this.i;
                                if (list2 != null) {
                                    list2.add(Integer.valueOf(sVar3.f40139a));
                                }
                                this.k.a(sVar3.c);
                            }
                        }
                        ArrayList<s> arrayList5 = new ArrayList();
                        if (arrayList2.size() != 0) {
                            arrayList5.addAll(arrayList2);
                        }
                        if (arrayList.size() != 0) {
                            arrayList5.addAll(arrayList);
                        }
                        for (s sVar4 : arrayList5) {
                            if (sVar4 != null) {
                                if (arrayList.contains(sVar4)) {
                                    this.k.a(sVar4.f40139a, sVar4.d, (PackageInfo) null);
                                } else if (arrayList2.contains(sVar4)) {
                                    a(sVar4);
                                }
                            }
                        }
                    } else {
                        this.k.c();
                        this.l.b();
                    }
                    WeaponHI.iD();
                } finally {
                    WeaponHI.iD();
                }
            }
        } catch (Throwable unused2) {
            this.k.c();
            this.l.b();
        }
    }

    private void a(s sVar) {
        try {
            if (!TextUtils.isEmpty(sVar.j) && sVar.j.length() >= 10) {
                if (!this.m.exists()) {
                    this.m.mkdir();
                }
                File file = new File(this.m, sVar.f40139a + c49.f40900a + sVar.d + ".tmp");
                File file2 = new File(this.m, sVar.f40139a + c49.f40900a + sVar.d + ".zip");
                boolean zA = l.a(this.j).a(sVar.i, file);
                if (!zA) {
                    zA = l.a(this.j).a(sVar.i, file);
                }
                if (zA) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    int iC = b.c(file.getAbsolutePath(), file2.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (iC != 0) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        zA = false;
                    }
                    if (iC == 0 && file.exists()) {
                        file.delete();
                    }
                } else {
                    this.s.put(Integer.valueOf(sVar.f40139a), new a(3));
                }
                String strA = f.a(file2);
                if (zA && sVar.j.equals(strA)) {
                    dl.a(file2.getAbsolutePath(), Boolean.TRUE);
                    sVar.e = file2.getAbsolutePath();
                    if (this.k.a(sVar, (String) null, (String) null)) {
                        Map<Integer, a> map = this.s;
                        if (map != null && !map.containsKey(Integer.valueOf(sVar.f40139a))) {
                            this.s.put(Integer.valueOf(sVar.f40139a), new a(1));
                        }
                        this.n.a(dn.b, System.currentTimeMillis(), true);
                        return;
                    }
                    Map<Integer, a> map2 = this.s;
                    if (map2 != null && !map2.containsKey(Integer.valueOf(sVar.f40139a))) {
                        this.s.put(Integer.valueOf(sVar.f40139a), new a(4));
                    }
                    this.k.a(sVar.f40139a, sVar.d, (PackageInfo) null);
                    return;
                }
                if (file.exists()) {
                    file.length();
                    file.delete();
                }
                this.k.a(sVar.f40139a, sVar.d, (PackageInfo) null);
                return;
            }
            this.k.a(sVar.f40139a, sVar.d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.k.a(sVar.f40139a, sVar.d, (PackageInfo) null);
        }
    }
}
