package com.byazt.vx;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.bv9;
import com.zj.adlib.c49;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 47})
public class eo {
    public static String c = null;
    public static String tt = null;
    public static String uj = "ToolUtils";
    public static String ve;

    public static com.byazt.dna.n a() {
        return (com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service");
    }

    public static synchronized String c() {
        if (TextUtils.isEmpty(c) && com.byazt.bp.tt.getContext() != null) {
            try {
                c = com.byazt.bp.tt.getContext().getPackageName();
            } catch (Throwable th) {
                com.byazt.eu.tt.uj(uj, "ToolUtils getPackageName throws exception :" + th);
            }
        }
        return c;
    }

    public static String n() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return sl.c(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized String tt() {
        if (TextUtils.isEmpty(tt) && com.byazt.bp.tt.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.bp.tt.getContext().getPackageManager().getPackageInfo(c(), 0);
                tt = String.valueOf(packageInfo.versionCode);
                ve = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.eu.tt.uj(uj, "ToolUtils getVersionCode throws exception :" + th);
            }
        }
        return tt;
    }

    public static String uj() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(l.b);
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            String strSubstring = strConcat.substring(0, i);
            strConcat = strSubstring.concat(" " + Locale.getDefault().getLanguage() + c49.f40900a + Locale.getDefault().getCountry() + l.b).concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static synchronized String ve() {
        if (TextUtils.isEmpty(ve) && com.byazt.bp.tt.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.bp.tt.getContext().getPackageManager().getPackageInfo(c(), 0);
                tt = String.valueOf(packageInfo.versionCode);
                ve = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.eu.tt.uj(uj, "ToolUtils getVersionName throws exception :" + th);
            }
        }
        return ve;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return c.tt(str.substring(17), ve(str.substring(1, 17)));
    }

    public static boolean c(com.byazt.hm.tt ttVar) {
        if (ttVar == null || !com.byazt.lf.c.c(ttVar.uj())) {
            return (ttVar == null || ttVar.n() == null || ttVar.n().startsWith(bv9.b) || ttVar.n().endsWith("}")) ? false : true;
        }
        return true;
    }

    public static byte[] tt(String str) {
        com.byazt.dna.n nVarA = a();
        if (nVarA == null) {
            return null;
        }
        return nVarA.encrypt(uj(str));
    }

    private static String ve(String str) {
        String strC = c.c(str);
        if (str != null) {
            return strC;
        }
        String strC2 = tt.c();
        return strC2.concat(strC2).substring(8, 24);
    }

    public static String c(byte[] bArr) {
        com.byazt.dna.n nVarA;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (nVarA = a()) == null) {
                    return null;
                }
                String strTt = com.byazt.aas.da.tt(nVarA.decrypt(bArr));
                if (TextUtils.isEmpty(strTt)) {
                    return null;
                }
                return strTt;
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
        return null;
    }

    private static byte[] uj(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.byazt.nr.m.c(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception e2) {
                                com.byazt.nr.m.c(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            com.byazt.nr.m.c(e4);
        }
    }

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strC = c.c();
                String str = "2" + strC + c.c(jSONObject.toString(), c.c(strC));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static void c(String str, Object obj, boolean z) {
        if (com.byazt.omf.x.m().lr()) {
            com.byazt.lx.tt.getInstance().reportRequestResult(str, obj, z);
        }
    }
}
