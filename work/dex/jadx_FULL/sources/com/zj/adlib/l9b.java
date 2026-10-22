package com.zj.adlib;

import com.amap.api.col.p0003l.hl;
import com.amap.api.col.p0003l.ip;
import com.amap.api.col.p0003l.s;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class l9b {
    public static int a(k9b k9bVar) {
        e9b e9bVar = null;
        try {
            if (k9bVar.f17615a.d()) {
                k9bVar.f17615a.c(true);
                e9b e9bVarC = e9b.c(new File(k9bVar.f17616a), k9bVar.f17612a);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] bArrE = e(e9bVarC, k9bVar, arrayList);
                    if (bArrE != null && bArrE.length != 0) {
                        s sVar = new s(bArrE, k9bVar.f17617b);
                        hl.b();
                        JSONObject jSONObject = new JSONObject(new String(hl.e(sVar).f17171a));
                        if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                            ip ipVar = k9bVar.f17615a;
                            if (ipVar != null) {
                                ipVar.b(bArrE.length);
                            }
                            if (k9bVar.f17615a.a() < Integer.MAX_VALUE) {
                                b(e9bVarC, arrayList);
                            } else {
                                try {
                                    e9bVarC.H();
                                } catch (Throwable th) {
                                    a7b.m(th, "ofm", "dlo");
                                }
                            }
                            return bArrE.length;
                        }
                        e9bVar = e9bVarC;
                    }
                    if (e9bVarC != null) {
                        try {
                            e9bVarC.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    e9bVar = e9bVarC;
                    try {
                        a7b.m(th, "leg", "uts");
                        if (e9bVar != null) {
                            e9bVar.close();
                        }
                        return -1;
                    } catch (Throwable th4) {
                        if (e9bVar != null) {
                            try {
                                e9bVar.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        throw th4;
                    }
                }
            }
            if (e9bVar != null) {
                e9bVar.close();
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        return -1;
    }

    public static void b(e9b e9bVar, List<String> list) {
        if (e9bVar != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    e9bVar.E(it.next());
                }
                e9bVar.close();
            } catch (Throwable th) {
                a7b.m(th, "ofm", "dlo");
            }
        }
    }

    public static void c(String str, byte[] bArr, k9b k9bVar) throws Throwable {
        e9b e9bVarC;
        OutputStream outputStreamB = null;
        try {
            if (d(k9bVar.f17616a, str)) {
                return;
            }
            File file = new File(k9bVar.f17616a);
            if (!file.exists()) {
                file.mkdirs();
            }
            e9bVarC = e9b.c(file, k9bVar.f17612a);
            try {
                e9bVarC.h(k9bVar.f42769a);
                byte[] bArrB = k9bVar.f17613a.b(bArr);
                e9b.d dVarQ = e9bVarC.q(str);
                outputStreamB = dVarQ.b();
                outputStreamB.write(bArrB);
                dVarQ.c();
                e9bVarC.w();
                try {
                    outputStreamB.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    e9bVarC.close();
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            e9bVarC = null;
        }
        if (outputStreamB != null) {
            try {
                outputStreamB.close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (e9bVarC == null) {
            throw th;
        }
        try {
            e9bVarC.close();
            throw th;
        } catch (Throwable th6) {
            th6.printStackTrace();
            throw th;
        }
    }

    public static boolean d(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            a7b.m(th, "leg", "fet");
            return false;
        }
    }

    public static byte[] e(e9b e9bVar, k9b k9bVar, List<String> list) {
        try {
            File fileR = e9bVar.r();
            if (fileR != null && fileR.exists()) {
                int length = 0;
                for (String str : fileR.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] bArrG = nbb.g(e9bVar, str2);
                        length += bArrG.length;
                        list.add(str2);
                        if (length > k9bVar.f17615a.a()) {
                            break;
                        }
                        k9bVar.f17614a.b(bArrG);
                    }
                }
                if (length <= 0) {
                    return null;
                }
                return k9bVar.f17614a.a();
            }
        } catch (Throwable th) {
            a7b.m(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
