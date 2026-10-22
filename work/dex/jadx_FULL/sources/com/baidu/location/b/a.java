package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    private static String A = "BDLocConfigManager";
    private SharedPreferences B;
    private long C;
    private String D;
    private C0259a E;
    private boolean F;
    private String G;
    private String H;
    private String I;
    private Context J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26330a;
    public int b;
    public double c;
    public int d;
    public int e;
    public double f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public double[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float t;
    public int u;
    public int[] v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* JADX INFO: renamed from: com.baidu.location.b.a$a, reason: collision with other inner class name */
    public class C0259a extends com.baidu.location.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26331a = null;
        boolean b = false;

        public C0259a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.ei = 2;
            String strEncode = Jni.encode(this.f26331a);
            this.f26331a = null;
            this.el.put("qt", "conf");
            this.el.put(HiAnalyticsConstant.Direction.REQUEST, strEncode);
        }

        public void a(String str) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f26331a = str;
            b(com.baidu.location.e.d.f);
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.ej != null) {
                try {
                    new JSONObject(this.ej);
                    if (a.this.B != null) {
                        SharedPreferences.Editor editorEdit = a.this.B.edit();
                        editorEdit.putString(a.A + "_newConfig", Base64.encodeToString(com.baidu.location.e.h.a(this.ej.getBytes()), 0));
                        editorEdit.apply();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.b = false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f26332a = new a();
    }

    private a() {
        this.B = null;
        this.f26330a = false;
        this.b = 16;
        this.C = 300L;
        this.c = 0.75d;
        this.d = 0;
        this.e = 1;
        this.f = -0.10000000149011612d;
        this.g = 0;
        this.h = 1;
        this.i = 1;
        this.j = 10;
        this.k = 3;
        this.l = 40;
        this.n = 1;
        this.o = 0;
        this.p = 1;
        this.q = 1;
        this.r = 0;
        this.s = 0.2f;
        this.t = 0.8f;
        this.u = 0;
        this.v = null;
        this.w = 8;
        this.x = 4000;
        this.y = 1;
        this.z = 1;
        this.D = null;
        this.E = null;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
    }

    public static a a() {
        return b.f26332a;
    }

    private void a(LocationClientOption locationClientOption) throws Throwable {
        String str = "&ver=" + com.baidu.location.e.h.x + "&usr=" + c() + "&app=" + this.G + "&prod=" + locationClientOption.prodName + "&newwf=1";
        String strSubstring = Build.VERSION.RELEASE;
        if (strSubstring != null && strSubstring.length() > 6) {
            strSubstring = strSubstring.substring(0, 6);
        }
        String str2 = str + "&sv=" + strSubstring;
        String strB = com.baidu.location.e.h.b(XmSystemUtils.KEY_VERSION_MIUI);
        if (!TextUtils.isEmpty(strB)) {
            str2 = str2 + "&miui=" + strB;
        }
        String strJ = com.baidu.location.e.h.j();
        if (!TextUtils.isEmpty(strJ)) {
            str2 = str2 + "&mtk=" + strJ;
        }
        SharedPreferences sharedPreferencesA = s.a(this.J);
        String string = sharedPreferencesA != null ? sharedPreferencesA.getString("mapcity", null) : null;
        if (!TextUtils.isEmpty(string)) {
            str2 = str2 + "&city=" + string;
        }
        String str3 = (str2 + "&sdk=9.643") + "&stp=1";
        String string2 = this.B.getString(A + "_loc", null);
        if (!TextUtils.isEmpty(string2)) {
            try {
                str3 = str3 + "&loc=" + new String(Base64.decode(string2, 0), "UTF-8");
            } catch (Exception unused) {
            }
        }
        String str4 = str3 + "&cnloc=" + l.a().b();
        if (this.E == null) {
            this.E = new C0259a();
        }
        this.E.a(str4);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.f26330a = true;
            }
            if (jSONObject.has("wfnum")) {
                this.b = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.C = jSONObject.getLong("freq");
            }
            if (jSONObject.has("wfsm")) {
                this.c = jSONObject.getDouble("wfsm");
            }
            if (jSONObject.has("idmoc")) {
                this.d = jSONObject.getInt("idmoc");
            }
            if (jSONObject.has("gnmcrm")) {
                this.f = jSONObject.getDouble("gnmcrm");
            }
            if (jSONObject.has("gnmcon")) {
                this.g = jSONObject.getInt("gnmcon");
            }
            if (jSONObject.has("lpcs")) {
                this.e = jSONObject.getInt("lpcs");
            }
            if (jSONObject.has("iupl")) {
                this.h = jSONObject.getInt("iupl");
            }
            if (jSONObject.has("opetco")) {
                this.i = jSONObject.getInt("opetco");
            }
            if (jSONObject.has("ct")) {
                this.j = jSONObject.getInt("ct");
            }
            if (jSONObject.has("suci")) {
                this.k = jSONObject.getInt("suci");
            }
            if (jSONObject.has("smn")) {
                this.l = jSONObject.getInt("smn");
            }
            if (jSONObject.has("bcar")) {
                a(jSONObject);
            }
            if (jSONObject.has("ums")) {
                this.n = jSONObject.getInt("ums");
            }
            if (jSONObject.has("hpdts")) {
                this.o = jSONObject.getInt("hpdts");
            }
            if (jSONObject.has("oldts")) {
                this.p = jSONObject.getInt("oldts");
            }
            if (jSONObject.has("nlp_loc_coarse")) {
                this.q = jSONObject.optInt("nlp_loc_coarse");
            }
            if (jSONObject.has("new_loc_cache_switch")) {
                this.r = jSONObject.optInt("new_loc_cache_switch");
            }
            if (jSONObject.has("nc_same_rate")) {
                this.s = (float) jSONObject.optDouble("nc_same_rate", 0.8d);
            }
            if (jSONObject.has("cl_str_change_rate")) {
                this.t = (float) jSONObject.optDouble("cl_str_change_rate", 0.2d);
            }
            if (jSONObject.has("cl_list_switch")) {
                this.u = jSONObject.optInt("cl_list_switch", 0);
            }
            if (jSONObject.has("cl_str_switch")) {
                String[] strArrSplit = jSONObject.optString("cl_str_switch", "").split(",");
                this.v = new int[strArrSplit.length];
                int i = 0;
                for (String str2 : strArrSplit) {
                    this.v[i] = 0;
                    if (str2.length() > 0) {
                        try {
                            this.v[i] = Integer.parseInt(str2);
                        } catch (Throwable unused) {
                        }
                    }
                    i++;
                }
            }
            if (jSONObject.has("cell_number")) {
                this.w = jSONObject.optInt("cell_number", 10);
            }
            if (jSONObject.has("loc_str_length")) {
                this.x = jSONObject.optInt("loc_str_length", 4000);
            }
            if (jSONObject.has("loc_to_foreground")) {
                this.y = jSONObject.optInt("loc_to_foreground", 1);
            }
            if (jSONObject.has("hils")) {
                this.z = jSONObject.optInt("hils", 1);
            }
            this.D = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("v9.643|");
        sb.append(this.H);
        sb.append("|");
        String str = Build.MODEL;
        sb.append(str);
        sb.append("&cu=");
        sb.append(this.H);
        sb.append("&mb=");
        sb.append(str);
        return sb.toString();
    }

    public synchronized void a(double d, double d2, String str) {
        SharedPreferences sharedPreferences;
        if (this.I == null && str != null) {
            try {
                if (str.equals("bd09") || str.equals("wgs84mc")) {
                    double[] dArrCoorEncrypt = Jni.coorEncrypt(d2, d, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double d3 = dArrCoorEncrypt[1];
                    double d4 = dArrCoorEncrypt[0];
                    d = d3;
                    d2 = d4;
                }
                String str2 = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                this.I = str2;
                String strEncodeToString = Base64.encodeToString(str2.getBytes("UTF-8"), 0);
                if (strEncodeToString != null && (sharedPreferences = this.B) != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString(A + "_loc", strEncodeToString);
                    editorEdit.apply();
                }
            } catch (Exception unused) {
                this.I = null;
            }
        }
    }

    public synchronized void a(Context context, LocationClientOption locationClientOption, String str) {
        if (!this.F && context != null) {
            this.F = true;
            this.J = context;
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            this.G = context.getPackageName();
            l.a().a(this.J);
            try {
                this.H = LBSAuthManager.getInstance(context).getCUID();
            } catch (Throwable unused) {
                this.H = null;
            }
            if (this.B == null) {
                this.B = context.getSharedPreferences(A + "BDLocConfig", 0);
            }
            SharedPreferences sharedPreferences = this.B;
            if (sharedPreferences != null) {
                long j = sharedPreferences.getLong(A + "_lastCheckTime", 0L);
                String string = this.B.getString(A + "_config", "");
                String string2 = this.B.getString(A + "_newConfig", "");
                if (!TextUtils.isEmpty(string2)) {
                    a(new String(com.baidu.location.e.h.b(Base64.decode(string2, 0))));
                } else if (!TextUtils.isEmpty(string)) {
                    a(string);
                    SharedPreferences.Editor editorEdit = this.B.edit();
                    editorEdit.remove(A + "_config");
                    editorEdit.apply();
                }
                if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.C) {
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    SharedPreferences.Editor editorEdit2 = this.B.edit();
                    editorEdit2.putLong(A + "_lastCheckTime", jCurrentTimeMillis);
                    editorEdit2.apply();
                    a(locationClientOption);
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            double[] dArr = this.m;
            if (dArr != null && dArr.length > 0) {
                this.m = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.m == null) {
                    this.m = new double[jSONArray.length() * 4];
                }
                int i = 0;
                int i2 = 0;
                while (i < jSONArray.length()) {
                    int i3 = i2 + 1;
                    this.m[i2] = jSONArray.getJSONObject(i).getDouble("x1");
                    int i4 = i3 + 1;
                    this.m[i3] = jSONArray.getJSONObject(i).getDouble("y1");
                    int i5 = i4 + 1;
                    this.m[i4] = jSONArray.getJSONObject(i).getDouble("x2");
                    int i6 = i5 + 1;
                    this.m[i5] = jSONArray.getJSONObject(i).getDouble("y2");
                    i++;
                    i2 = i6;
                }
            } catch (Exception unused) {
            }
        }
    }
}
