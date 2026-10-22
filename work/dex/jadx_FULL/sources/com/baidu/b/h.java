package com.baidu.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h {
    private static String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c f26301a;
    private Context c;
    private com.baidu.b.e.a.C0258a d;
    private com.baidu.b.b.c e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f26302a = {"V", "O", "0"};
        private String b;
        private String c;
        private String d;
        private long e;
        private String f;
        private int g = 1;

        public String a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.b);
                jSONObject.put("v270fk", this.c);
                jSONObject.put("cck", this.d);
                jSONObject.put("vsk", this.g);
                jSONObject.put("ctk", this.e);
                jSONObject.put("ek", this.f);
                return jSONObject.toString();
            } catch (JSONException e) {
                com.baidu.b.f.c.a(e);
                return null;
            }
        }

        public String b() {
            String str = this.c;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append("|");
            sb.append(str);
            if ("V".equals(str)) {
                sb.append(this.d);
            }
            if (!TextUtils.isEmpty(this.f)) {
                sb.append(this.f);
            }
            return sb.toString().trim();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.g == aVar.g && this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.d.equals(aVar.d)) {
                String str = this.f;
                String str2 = aVar.f;
                if (str == str2) {
                    return true;
                }
                if (str != null && str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.f, Integer.valueOf(this.g)});
        }
    }

    public h(Context context, com.baidu.b.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.c = context.getApplicationContext();
        com.baidu.b.e.a.C0258a c0258aA = aVar.b().a("bohrium");
        this.d = c0258aA;
        c0258aA.a();
        this.f26301a = cVar;
        a(aVar);
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("dik", "");
            String strOptString2 = jSONObject.optString("cck", "");
            long jOptLong = jSONObject.optLong("ctk", 0L);
            int iOptInt = jSONObject.optInt("vsk", 1);
            String strOptString3 = jSONObject.optString("ek", "");
            String strOptString4 = jSONObject.optString("v270fk", "V");
            if (!TextUtils.isEmpty(strOptString)) {
                a aVar = new a();
                aVar.b = strOptString;
                aVar.d = strOptString2;
                aVar.e = jOptLong;
                aVar.g = iOptInt;
                aVar.f = strOptString3;
                aVar.c = strOptString4;
                return aVar;
            }
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
        }
        return null;
    }

    public static a a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String strD = d(str);
                long jCurrentTimeMillis = System.currentTimeMillis();
                a aVar = new a();
                aVar.b = str;
                aVar.d = strD;
                aVar.e = jCurrentTimeMillis;
                aVar.g = 1;
                aVar.f = str3;
                aVar.c = str2;
                return aVar;
            } catch (Exception e) {
                com.baidu.b.f.c.a(e);
            }
        }
        return null;
    }

    private String a(Context context) {
        String str = b;
        return TextUtils.isEmpty(str) ? "123456" : str;
    }

    private void a(com.baidu.b.e.a aVar) {
        com.baidu.b.b.c cVar = new com.baidu.b.b.c(new com.baidu.b.a());
        com.baidu.b.b.a.C0256a c0256a = new com.baidu.b.b.a.C0256a();
        c0256a.f26262a = this.c;
        c0256a.b = aVar;
        com.baidu.b.b.a.c cVar2 = new com.baidu.b.b.a.c();
        for (com.baidu.b.b.a aVar2 : cVar.a()) {
            aVar2.a(c0256a);
            aVar2.a(cVar2);
        }
        this.e = cVar;
    }

    public static void b(String str) {
        b = str;
    }

    private static String d(String str) {
        try {
            return new com.baidu.b.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.b.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public a a() {
        a aVar;
        com.baidu.b.b.a.d dVar = new com.baidu.b.b.a.d();
        dVar.f26264a = true;
        List listA = this.e.a();
        Collections.sort(listA, com.baidu.b.b.a.f26261a);
        List<b> listB = this.f26301a.b(this.c);
        if (listB == null) {
            return null;
        }
        for (b bVar : listB) {
            if (!bVar.d && bVar.c) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    com.baidu.b.b.a.e eVarA = ((com.baidu.b.b.a) it.next()).a(bVar.f26260a.packageName, dVar);
                    if (eVarA != null && eVarA.b() && (aVar = eVarA.f26265a) != null) {
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    public a a(f fVar) {
        String str;
        if (fVar == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        a aVar = new a();
        aVar.e = System.currentTimeMillis();
        aVar.g = 1;
        try {
            boolean z = false;
            aVar.c = fVar.b.substring(0, 1);
            aVar.b = fVar.f26297a;
            aVar.d = d(fVar.f26297a);
            String[] strArr = a.f26302a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                }
                if (strArr[i].equals(aVar.c)) {
                    break;
                }
                i++;
            }
            if (z && (str = fVar.b) != null && str.length() >= 2) {
                aVar.f = fVar.b.substring(1);
            }
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public a c(String str) {
        String strA = com.baidu.b.d.b.a(("com.baidu" + a(this.c)).getBytes(), true);
        a aVar = new a();
        aVar.e = System.currentTimeMillis();
        aVar.g = 1;
        aVar.b = strA;
        aVar.c = "E";
        aVar.d = d(strA);
        aVar.f = "RO";
        return aVar;
    }
}
