package com.igexin.push.core.b;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.sdk.message.GTPopupMessage;
import com.zj.adlib.c49;
import com.zj.adlib.nd9;
import com.zj.adlib.y6b;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m extends BaseActionBean implements Serializable {
    private static boolean k = true;
    private static int l;
    private static int m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f37963a;
    public b b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public GTPopupMessage j;

    public enum a {
        closePopup,
        intent,
        url
    }

    public static class b implements Serializable {
        private String A;
        private String B;
        private String C;
        private String D;
        private String E;
        private float F;
        private float G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f37965a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public ArrayList<b> g;
        public String h;
        public boolean i;
        public String j;
        public String k;
        public int l;
        public int m;
        public int n;
        public GTPopupMessage o;
        public String p;
        float q = 0.0f;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private String w;
        private String x;
        private String y;
        private String z;

        public b(JSONObject jSONObject, String str, String str2, float f, float f2) {
            JSONObject jSONObjectOptJSONObject;
            if (jSONObject == null) {
                return;
            }
            this.F = f;
            this.G = f2;
            this.f37965a = jSONObject.optString("type");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("layout");
            if (jSONObjectOptJSONObject2 != null) {
                this.b = jSONObjectOptJSONObject2.optString("align");
                this.r = jSONObjectOptJSONObject2.optString("width", null);
                this.s = jSONObjectOptJSONObject2.optString("height", null);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("margin");
                if (jSONObjectOptJSONObject3 != null) {
                    this.u = jSONObjectOptJSONObject3.optString(com.ipd.dsp.internal.e1.f.l, null);
                    this.v = jSONObjectOptJSONObject3.optString(com.ipd.dsp.internal.e1.f.n, null);
                    this.w = jSONObjectOptJSONObject3.optString("right", null);
                    this.x = jSONObjectOptJSONObject3.optString("left", null);
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("padding");
                if (jSONObjectOptJSONObject4 != null) {
                    this.y = jSONObjectOptJSONObject4.optString(com.ipd.dsp.internal.e1.f.l, null);
                    this.z = jSONObjectOptJSONObject4.optString(com.ipd.dsp.internal.e1.f.n, null);
                    this.A = jSONObjectOptJSONObject4.optString("right", null);
                    this.B = jSONObjectOptJSONObject4.optString("left", null);
                }
                this.t = jSONObjectOptJSONObject2.optString("maxHeight");
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("properties");
            String str3 = "";
            if (jSONObjectOptJSONObject5 != null) {
                this.d = jSONObjectOptJSONObject5.optString("name", "");
                this.e = jSONObjectOptJSONObject5.optString("elementType");
                this.f = jSONObjectOptJSONObject5.optString("elementId", "");
                this.h = jSONObjectOptJSONObject5.optString("image");
                this.C = jSONObjectOptJSONObject5.optString("cornerRadius", null);
                this.k = jSONObjectOptJSONObject5.optString("text");
                this.D = jSONObjectOptJSONObject5.optString(com.google.common.net.e.f6416j, null);
                this.c = jSONObjectOptJSONObject5.optString("textAlign", null);
                this.i = "bold".equals(jSONObjectOptJSONObject5.optString("fontWeight"));
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("color");
                if (jSONObjectOptJSONObject6 != null) {
                    this.l = Color.argb((int) (jSONObjectOptJSONObject6.optDouble("a") * 255.0d), (int) jSONObjectOptJSONObject6.optDouble("r"), (int) jSONObjectOptJSONObject6.optDouble(y6b.f), (int) jSONObjectOptJSONObject6.optDouble("b"));
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject("backgroundColor");
                if (jSONObjectOptJSONObject7 != null) {
                    this.m = Color.argb((int) (jSONObjectOptJSONObject7.optDouble("a") * 255.0d), (int) jSONObjectOptJSONObject7.optDouble("r"), (int) jSONObjectOptJSONObject7.optDouble(y6b.f), (int) jSONObjectOptJSONObject7.optDouble("b"));
                }
                this.E = jSONObjectOptJSONObject5.optString("borderWidth", null);
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject5.optJSONObject("borderColor");
                if (jSONObjectOptJSONObject8 != null) {
                    this.n = Color.argb((int) (jSONObjectOptJSONObject8.optDouble("a") * 255.0d), (int) jSONObjectOptJSONObject8.optDouble("r"), (int) jSONObjectOptJSONObject8.optDouble(y6b.f), (int) jSONObjectOptJSONObject8.optDouble("b"));
                }
                this.j = jSONObjectOptJSONObject5.optString(nd9.i);
            } else {
                str3 = "";
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("action");
            if (jSONObjectOptJSONObject9 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject9.optJSONObject("ANDROID")) != null) {
                GTPopupMessage gTPopupMessage = new GTPopupMessage();
                gTPopupMessage.setElementType(this.e);
                GTPopupMessage.GtAction gtAction = new GTPopupMessage.GtAction(jSONObjectOptJSONObject.optString("actionType"), jSONObjectOptJSONObject.optString("intent"), jSONObjectOptJSONObject.optString("url"), jSONObjectOptJSONObject.optBoolean("closePopup", false));
                String str4 = this.f;
                StringBuilder sb = new StringBuilder();
                sb.append(this.d);
                sb.append(TextUtils.isEmpty(this.k) ? str3 : c49.f40900a + this.k);
                GTPopupMessage.EventProperties eventProperties = new GTPopupMessage.EventProperties(str, str2, str4, sb.toString());
                gTPopupMessage.setAction(gtAction);
                gTPopupMessage.setEventProperties(eventProperties);
                this.o = gTPopupMessage;
                this.p = jSONObjectOptJSONObject.optString("clickActionId", str3);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subviews");
            if (jSONArrayOptJSONArray != null) {
                this.g = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.g.add(new b(jSONArrayOptJSONArray.optJSONObject(i), str, str2, f, f2));
                }
            }
        }

        private static float a(String str) {
            if (str == null || !str.contains("px")) {
                return 0.0f;
            }
            return (float) (((double) com.igexin.push.core.e.l.getResources().getDisplayMetrics().scaledDensity) * Double.parseDouble(str.substring(0, str.length() - 2)));
        }

        private static int a(String str, float f, float f2) {
            if (str == null || !str.contains("px")) {
                return -2;
            }
            return (int) ((((double) (m.k ? Math.min(m.m / f2, m.l / f) : Math.min(m.m / f, m.l / f2))) * Double.parseDouble(str.substring(0, str.length() - 2))) + 0.5d);
        }

        private Object a(String str, Object obj) {
            if (this.q == 0.0f) {
                this.q = com.igexin.push.core.e.l.getResources().getDisplayMetrics().density;
            }
            if (str == null || !str.contains("px")) {
                return obj;
            }
            double d = Double.parseDouble(str.substring(0, str.length() - 2));
            if (obj instanceof Float) {
                return Double.valueOf(d * ((double) this.q));
            }
            return obj instanceof Integer ? Integer.valueOf((int) ((d * ((double) this.q)) + 0.5d)) : Integer.valueOf((int) ((d * ((double) this.q)) + 0.5d));
        }

        private static Object a(String str, Object obj, float f, float f2) {
            float f3;
            int i;
            if (str == null || !str.contains("px")) {
                return obj;
            }
            if (m.k) {
                f3 = m.m / f2;
                i = m.l;
            } else {
                f3 = m.l / f2;
                i = m.m;
            }
            float fMin = Math.min(f3, i / f);
            float f4 = Float.parseFloat(str.substring(0, str.length() - 2));
            if (obj instanceof Float) {
                return Float.valueOf(f4 * fMin);
            }
            boolean z = obj instanceof Integer;
            return Integer.valueOf((int) ((f4 * fMin) + 0.5f));
        }

        public final int a() {
            return a(this.r, this.F, this.G);
        }

        public final int b() {
            return a(this.s, this.F, this.G);
        }

        public final int c() {
            return ((Integer) a(this.u, 0, this.F, this.G)).intValue();
        }

        public final int d() {
            return ((Integer) a(this.v, 0, this.F, this.G)).intValue();
        }

        public final int e() {
            return ((Integer) a(this.w, 0, this.F, this.G)).intValue();
        }

        public final int f() {
            return ((Integer) a(this.x, 0, this.F, this.G)).intValue();
        }

        public final int g() {
            return ((Integer) a(this.y, 0, this.F, this.G)).intValue();
        }

        public final int h() {
            return ((Integer) a(this.z, 0, this.F, this.G)).intValue();
        }

        public final int i() {
            return ((Integer) a(this.A, 0, this.F, this.G)).intValue();
        }

        public final int j() {
            return ((Integer) a(this.B, 0, this.F, this.G)).intValue();
        }

        public final int k() {
            return ((Integer) a(this.C, 0, this.F, this.G)).intValue();
        }

        public final float l() {
            return ((Float) a(this.D, Float.valueOf(0.0f), this.F, this.G)).floatValue();
        }

        public final int m() {
            return ((Integer) a(this.E, 0, this.F, this.G)).intValue();
        }

        public final int n() {
            return ((Integer) a(this.t, 0, this.F, this.G)).intValue();
        }
    }

    public static void a(Context context) {
        int i;
        int i2 = context.getResources().getConfiguration().orientation;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int iMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (i2 == 1) {
            k = true;
            l = iMin;
            i = displayMetrics.heightPixels;
        } else {
            k = false;
            l = iMin;
            i = displayMetrics.widthPixels;
        }
        m = i;
    }

    private void a(String str) {
        this.e = str;
    }

    private void a(JSONObject jSONObject) {
        float f;
        float f2;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("statisticsInfo");
        if (jSONObjectOptJSONObject != null) {
            this.c = jSONObjectOptJSONObject.optString("planName", "");
            this.d = jSONObjectOptJSONObject.optString("nodeName", "");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("properties");
        if (jSONObjectOptJSONObject2 != null) {
            String strOptString = jSONObjectOptJSONObject2.optString("baseWidth");
            String strOptString2 = jSONObjectOptJSONObject2.optString("baseHeight");
            f = Float.parseFloat(strOptString.substring(0, strOptString.length() - 2));
            f2 = Float.parseFloat(strOptString2.substring(0, strOptString2.length() - 2));
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        this.i = jSONObject.optString("showActionId", "");
        float f3 = f;
        float f4 = f2;
        this.f37963a = new b(jSONObject.optJSONObject("mask"), this.c, this.d, f3, f4);
        this.b = new b(jSONObject.optJSONObject("template"), this.c, this.d, f3, f4);
        GTPopupMessage.EventProperties eventProperties = new GTPopupMessage.EventProperties(this.c, this.d, "", "");
        GTPopupMessage gTPopupMessage = new GTPopupMessage();
        gTPopupMessage.setEventProperties(eventProperties);
        this.j = gTPopupMessage;
    }

    private void b(String str) {
        this.f = str;
    }

    private void c(String str) {
        this.g = str;
    }

    private String d() {
        return this.g;
    }

    private void d(String str) {
        this.h = str;
    }

    private String e() {
        return this.i;
    }

    private GTPopupMessage f() {
        return this.j;
    }

    private b g() {
        return this.b;
    }

    private b h() {
        return this.f37963a;
    }

    private String i() {
        return this.e;
    }

    private String j() {
        return this.h;
    }

    private String k() {
        return this.f;
    }
}
