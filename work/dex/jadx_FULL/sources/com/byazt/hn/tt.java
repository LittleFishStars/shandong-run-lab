package com.byazt.hn;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.cd.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 13})
public final class tt {
    public final ve c;
    public final List<uj> tt;

    @com.byazt.zqa.c(c = {0, 1, 25, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {
        public final String c;
        public final int n;
        public final int tt;
        public final float uj;
        public final float ve;

        private c(String str, float f, float f2, int i) {
            this.c = str;
            this.tt = tt.ve(str);
            this.ve = f;
            this.uj = f2;
            this.n = i;
        }

        public static c c(Context context, JSONObject jSONObject) {
            return jSONObject == null ? new c("circle", x.c(context, 6.0f), x.c(context, 6.0f), -1) : new c(jSONObject.optString("shape", "circle"), x.c(context, (float) jSONObject.optDouble("width", 6.0d)), x.c(context, (float) jSONObject.optDouble("height", 6.0d)), com.byazt.cd.c.c(jSONObject.optString("color", "#FFFFFF"), -1));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 25, 1886})
    public static final class uj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f28616a;
        public final String c;
        public final float da;
        public final float i;
        public final float n;
        public final float sl;
        public final float sp;
        public final c t;
        public final float tt;
        public final float uj;
        public final float ve;
        public final float x;

        private uj(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, c cVar) {
            this.c = str;
            this.tt = f;
            this.ve = f2;
            this.uj = f3;
            this.n = f4;
            this.f28616a = f5;
            this.sp = f6;
            this.x = f7;
            this.i = f8;
            this.da = f9;
            this.sl = f10;
            this.t = cVar;
        }

        public static uj c(Context context, JSONObject jSONObject) {
            return new uj(jSONObject.optString("name", ""), (float) jSONObject.optDouble("birthRate", 1.0d), (float) jSONObject.optDouble("lifetime", 1.0d), (float) jSONObject.optDouble("lifetimeRange", AudioStats.AUDIO_AMPLITUDE_NONE), (float) jSONObject.optDouble("scale", 1.0d), (float) jSONObject.optDouble("scaleRange", AudioStats.AUDIO_AMPLITUDE_NONE), (float) jSONObject.optDouble("velocity", AudioStats.AUDIO_AMPLITUDE_NONE), (float) jSONObject.optDouble("velocityRange", AudioStats.AUDIO_AMPLITUDE_NONE), (float) jSONObject.optDouble("emissionRange", AudioStats.AUDIO_AMPLITUDE_NONE), (float) jSONObject.optDouble("alphaRange", AudioStats.AUDIO_AMPLITUDE_NONE), (float) jSONObject.optDouble("alphaSpeed", AudioStats.AUDIO_AMPLITUDE_NONE), c.c(context, jSONObject.optJSONObject("content")));
        }
    }

    private tt(ve veVar, List<uj> list) {
        this.c = veVar;
        this.tt = list;
    }

    public static int c(String str) {
        if ("line".equals(str)) {
            return 1;
        }
        if ("rectangle".equals(str)) {
            return 2;
        }
        if ("circle".equals(str)) {
            return 3;
        }
        return "sphere".equals(str) ? 4 : 0;
    }

    public static int tt(String str) {
        if ("outline".equals(str)) {
            return 1;
        }
        return "surface".equals(str) ? 2 : 0;
    }

    public static int uj(String str) {
        if ("additive".equals(str)) {
            return 1;
        }
        if ("backToFront".equals(str) || "oldestFirst".equals(str)) {
            return 3;
        }
        return "oldestLast".equals(str) ? 4 : 0;
    }

    public static int ve(String str) {
        if ("rect".equals(str)) {
            return 1;
        }
        return "star".equals(str) ? 2 : 0;
    }

    public List<uj> tt() {
        return this.tt;
    }

    public boolean ve() {
        List<uj> list = this.tt;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public ve c() {
        return this.c;
    }

    public static tt c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(context, new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.hn.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 25, 240})
    public static final class C0423tt {
        public final float c;
        public final boolean tt;

        public C0423tt(float f, boolean z) {
            this.c = f;
            this.tt = z;
        }

        public static C0423tt c(Object obj, C0423tt c0423tt) {
            if (obj == null) {
                return c0423tt;
            }
            if (obj instanceof Number) {
                return new C0423tt(((Number) obj).floatValue(), false);
            }
            String strTrim = obj.toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                return c0423tt;
            }
            try {
                return strTrim.endsWith("%") ? new C0423tt(Float.parseFloat(strTrim.substring(0, strTrim.length() - 1)) / 100.0f, true) : new C0423tt(Float.parseFloat(strTrim), false);
            } catch (NumberFormatException unused) {
                return c0423tt;
            }
        }

        public float c(float f) {
            return this.tt ? f * this.c : this.c;
        }
    }

    public static tt c(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ve veVarC = ve.c(jSONObject.optJSONObject("layer"));
        List<uj> listC = c(context, jSONObject.optJSONArray("particles"));
        if (listC.isEmpty()) {
            return null;
        }
        return new tt(veVarC, listC);
    }

    @com.byazt.zqa.c(c = {0, 1, 25, 519})
    public static final class ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28617a;
        public final String c;
        public final C0423tt da;
        public final C0423tt i;
        public final int n;
        public final C0423tt sp;
        public final String tt;
        public final int uj;
        public final String ve;
        public final C0423tt x;

        private ve(String str, String str2, String str3, C0423tt c0423tt, C0423tt c0423tt2, C0423tt c0423tt3, C0423tt c0423tt4) {
            this.c = str;
            this.tt = str2;
            this.ve = str3;
            this.uj = tt.c(str);
            this.n = tt.tt(str2);
            this.f28617a = tt.uj(str3);
            this.sp = c0423tt;
            this.x = c0423tt2;
            this.i = c0423tt3;
            this.da = c0423tt4;
        }

        public static ve c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            String strOptString = jSONObject.optString("emitterShape", SQLiteMTAHelper.TABLE_POINT);
            String strOptString2 = jSONObject.optString("emitterMode", "points");
            String strOptString3 = jSONObject.optString("renderMode", "unordered");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("emitterPosition");
            C0423tt c0423ttC = C0423tt.c(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("x") : null, new C0423tt(0.5f, true));
            C0423tt c0423ttC2 = C0423tt.c(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("y") : null, new C0423tt(0.0f, true));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("emitterSize");
            return new ve(strOptString, strOptString2, strOptString3, c0423ttC, c0423ttC2, C0423tt.c(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt("w") : null, new C0423tt(1.0f, true)), C0423tt.c(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt(y6b.g) : null, new C0423tt(1.0f, true)));
        }

        private static ve c() {
            return new ve(SQLiteMTAHelper.TABLE_POINT, "points", "unordered", new C0423tt(0.5f, true), new C0423tt(0.0f, true), new C0423tt(1.0f, true), new C0423tt(1.0f, true));
        }
    }

    private static List<uj> c(Context context, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(uj.c(context, jSONObjectOptJSONObject));
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }
}
