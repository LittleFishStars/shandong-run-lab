package com.ipd.dsp.internal.h1;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38319a = "Log";

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f38322a;
        public final String b;

        public /* synthetic */ c(String str, String str2, C0881a c0881a) {
            this(str, str2);
        }

        public c(String str, String str2) {
            this.f38322a = str;
            this.b = str2;
        }
    }

    public interface d<T> {
        void a(T t);
    }

    public static final class e {
        public static final c A;
        public static final c B;
        public static final c C;
        public static final c D;
        public static HashMap<String, c> E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38323a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        public static final c f;
        public static final c g;
        public static final c h;
        public static final c i;
        public static final c j;
        public static final c k;
        public static final c l;
        public static final c m;
        public static final c n;
        public static final c o;
        public static final c p;
        public static final c q;
        public static final c r;
        public static final c s;
        public static final c t;
        public static final c u;
        public static final c v;
        public static final c w;
        public static final c x;
        public static final c y;
        public static final c z;

        static {
            C0881a c0881a = null;
            f38323a = new c("compete_succ", com.ipd.dsp.internal.y1.c.E(), c0881a);
            b = new c("compete_fail", com.ipd.dsp.internal.y1.c.D(), c0881a);
            c = new c("show_fail", com.ipd.dsp.internal.y1.c.n(), c0881a);
            d = new c("sichtteil", com.ipd.dsp.internal.y1.c.m(), c0881a);
            e = new c("show", com.ipd.dsp.internal.y1.c.h(), c0881a);
            f = new c("click", com.ipd.dsp.internal.y1.c.a(), c0881a);
            g = new c("dl_start", com.ipd.dsp.internal.y1.c.f(), c0881a);
            h = new c("dl_succ", com.ipd.dsp.internal.y1.c.g(), c0881a);
            i = new c("inst_start", com.ipd.dsp.internal.y1.c.j(), c0881a);
            j = new c("inst_succ", com.ipd.dsp.internal.y1.c.k(), c0881a);
            k = new c("inst_open", com.ipd.dsp.internal.y1.c.i(), c0881a);
            l = new c("dpl_invoke", com.ipd.dsp.internal.y1.c.d(), c0881a);
            m = new c("dpl_succ", com.ipd.dsp.internal.y1.c.e(), c0881a);
            n = new c("dpl_fail", com.ipd.dsp.internal.y1.c.c(), c0881a);
            o = new c("start", com.ipd.dsp.internal.y1.c.z(), c0881a);
            p = new c("first_quartile", com.ipd.dsp.internal.y1.c.q(), c0881a);
            q = new c("mid_point", com.ipd.dsp.internal.y1.c.s(), c0881a);
            r = new c("third_quartile", com.ipd.dsp.internal.y1.c.A(), c0881a);
            s = new c("complete", com.ipd.dsp.internal.y1.c.p(), c0881a);
            t = new c("replay", com.ipd.dsp.internal.y1.c.w(), c0881a);
            u = new c("play_n_seconds", com.ipd.dsp.internal.y1.c.v(), c0881a);
            v = new c("pause", com.ipd.dsp.internal.y1.c.u(), c0881a);
            w = new c("resume", com.ipd.dsp.internal.y1.c.x(), c0881a);
            x = new c(com.alibaba.ariver.jsapi.multimedia.video.a.f, com.ipd.dsp.internal.y1.c.t(), c0881a);
            y = new c("unmute", com.ipd.dsp.internal.y1.c.B(), c0881a);
            z = new c("fullscreen", com.ipd.dsp.internal.y1.c.r(), c0881a);
            A = new c(FreeSpaceBox.TYPE, com.ipd.dsp.internal.y1.c.y(), c0881a);
            B = new c("close_linear", com.ipd.dsp.internal.y1.c.o(), c0881a);
            C = new c("demand_fin", com.ipd.dsp.internal.y1.c.l(), c0881a);
            D = new c("close", com.ipd.dsp.internal.y1.c.b(), c0881a);
        }

        @Nullable
        public static synchronized c a(String str) {
            if (E == null) {
                HashMap<String, c> map = new HashMap<>();
                E = map;
                c cVar = f38323a;
                map.put(cVar.f38322a, cVar);
                HashMap<String, c> map2 = E;
                c cVar2 = b;
                map2.put(cVar2.f38322a, cVar2);
                HashMap<String, c> map3 = E;
                c cVar3 = c;
                map3.put(cVar3.f38322a, cVar3);
                HashMap<String, c> map4 = E;
                c cVar4 = d;
                map4.put(cVar4.f38322a, cVar4);
                HashMap<String, c> map5 = E;
                c cVar5 = e;
                map5.put(cVar5.f38322a, cVar5);
                HashMap<String, c> map6 = E;
                c cVar6 = f;
                map6.put(cVar6.f38322a, cVar6);
                HashMap<String, c> map7 = E;
                c cVar7 = g;
                map7.put(cVar7.f38322a, cVar7);
                HashMap<String, c> map8 = E;
                c cVar8 = h;
                map8.put(cVar8.f38322a, cVar8);
                HashMap<String, c> map9 = E;
                c cVar9 = i;
                map9.put(cVar9.f38322a, cVar9);
                HashMap<String, c> map10 = E;
                c cVar10 = j;
                map10.put(cVar10.f38322a, cVar10);
                HashMap<String, c> map11 = E;
                c cVar11 = k;
                map11.put(cVar11.f38322a, cVar11);
                HashMap<String, c> map12 = E;
                c cVar12 = l;
                map12.put(cVar12.f38322a, cVar12);
                HashMap<String, c> map13 = E;
                c cVar13 = m;
                map13.put(cVar13.f38322a, cVar13);
                HashMap<String, c> map14 = E;
                c cVar14 = n;
                map14.put(cVar14.f38322a, cVar14);
                HashMap<String, c> map15 = E;
                c cVar15 = o;
                map15.put(cVar15.f38322a, cVar15);
                HashMap<String, c> map16 = E;
                c cVar16 = p;
                map16.put(cVar16.f38322a, cVar16);
                HashMap<String, c> map17 = E;
                c cVar17 = q;
                map17.put(cVar17.f38322a, cVar17);
                HashMap<String, c> map18 = E;
                c cVar18 = r;
                map18.put(cVar18.f38322a, cVar18);
                HashMap<String, c> map19 = E;
                c cVar19 = s;
                map19.put(cVar19.f38322a, cVar19);
                HashMap<String, c> map20 = E;
                c cVar20 = t;
                map20.put(cVar20.f38322a, cVar20);
                HashMap<String, c> map21 = E;
                c cVar21 = u;
                map21.put(cVar21.f38322a, cVar21);
                HashMap<String, c> map22 = E;
                c cVar22 = v;
                map22.put(cVar22.f38322a, cVar22);
                HashMap<String, c> map23 = E;
                c cVar23 = w;
                map23.put(cVar23.f38322a, cVar23);
                HashMap<String, c> map24 = E;
                c cVar24 = x;
                map24.put(cVar24.f38322a, cVar24);
                HashMap<String, c> map25 = E;
                c cVar25 = y;
                map25.put(cVar25.f38322a, cVar25);
                HashMap<String, c> map26 = E;
                c cVar26 = z;
                map26.put(cVar26.f38322a, cVar26);
                HashMap<String, c> map27 = E;
                c cVar27 = A;
                map27.put(cVar27.f38322a, cVar27);
                HashMap<String, c> map28 = E;
                c cVar28 = B;
                map28.put(cVar28.f38322a, cVar28);
                HashMap<String, c> map29 = E;
                c cVar29 = C;
                map29.put(cVar29.f38322a, cVar29);
                HashMap<String, c> map30 = E;
                c cVar30 = D;
                map30.put(cVar30.f38322a, cVar30);
            }
            return E.get(str);
        }
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, int i) {
        try {
            Map<String, Object> mapC = bVar.c();
            mapC.put("trans_price", Integer.valueOf(i));
            a(e.d, bVar.a(), mapC, "show");
            a(e.e, bVar.a(), mapC, "exposure");
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public class b implements com.ipd.dsp.internal.y1.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f38321a;

        public b(String str) {
            this.f38321a = str;
        }

        @Override // com.ipd.dsp.internal.y1.b.a
        public void a(String str) {
            if (Dsp.isDebugLogEnable()) {
                k.d(a.f38319a, "[" + this.f38321a + "] posted");
            }
        }

        @Override // com.ipd.dsp.internal.y1.b.a
        public void a(int i, String str, Throwable th) {
            if (Dsp.isDebugLogEnable()) {
                k.b(a.f38319a, "[" + this.f38321a + "] " + i + c49.f40900a + str, th);
            }
        }
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, int i, int i2, @Nullable float[] fArr, @Nullable Map<String, Object> map, d<String> dVar) {
        try {
            if (map != null) {
                bVar.a(map.get("click_ts"));
            } else {
                bVar.a(Long.valueOf(System.currentTimeMillis()));
            }
            Map<String, Object> mapC = bVar.c();
            mapC.put("trans_price", Integer.valueOf(i));
            long jCurrentTimeMillis = System.currentTimeMillis();
            mapC.put("report_ts", Long.valueOf(jCurrentTimeMillis / 1000));
            mapC.put("report_ms", Long.valueOf(jCurrentTimeMillis));
            mapC.put("click_action", String.valueOf(i2));
            if (fArr != null && fArr.length == 3) {
                if (i2 == 3) {
                    mapC.put("shake_shake_x", Float.valueOf(a(fArr[0])));
                    mapC.put("shake_shake_y", Float.valueOf(a(fArr[1])));
                    mapC.put("shake_shake_z", Float.valueOf(a(fArr[2])));
                } else if (i2 == 4) {
                    mapC.put("twist_twist_x", Float.valueOf(a(fArr[0])));
                    mapC.put("twist_twist_y", Float.valueOf(a(fArr[1])));
                    mapC.put("twist_twist_z", Float.valueOf(a(fArr[2])));
                }
            }
            if (map != null) {
                mapC.putAll(map);
            }
            String string = UUID.randomUUID().toString();
            if (Dsp.isDebugLogEnable()) {
                k.d(f38319a, "[" + string + "] click");
            }
            c cVar = e.f;
            com.ipd.dsp.internal.y1.b.a(new com.ipd.dsp.internal.b2.d(cVar.b, mapC, new C0881a(string, dVar)));
            a(cVar, bVar.a(), mapC);
        } catch (Throwable th) {
            r.a(th);
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.h1.a$a, reason: collision with other inner class name */
    public class C0881a implements com.ipd.dsp.internal.y1.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f38320a;
        public final /* synthetic */ d b;

        public C0881a(String str, d dVar) {
            this.f38320a = str;
            this.b = dVar;
        }

        @Override // com.ipd.dsp.internal.y1.b.a
        public void a(String str) {
            String strOptString;
            if (Dsp.isDebugLogEnable()) {
                k.d(a.f38319a, "[" + this.f38320a + "] posted");
            }
            try {
                strOptString = new JSONObject(str).optString("dl_url");
            } catch (JSONException unused) {
                k.a(a.f38319a, "parse json error");
                strOptString = null;
            }
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(strOptString);
            }
        }

        @Override // com.ipd.dsp.internal.y1.b.a
        public void a(int i, String str, Throwable th) {
            if (Dsp.isDebugLogEnable()) {
                k.b(a.f38319a, "[" + this.f38320a + "] " + i + c49.f40900a + str, th);
            }
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(null);
            }
        }
    }

    public static float a(float f) {
        return (float) (((double) Math.round(f * 100.0f)) / 100.0d);
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, c cVar) {
        a(bVar, cVar, (String) null);
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, c cVar, String str) {
        try {
            a(cVar, bVar.a(), bVar.a(str), "comm");
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, int i, int i2, String str) {
        try {
            Map<String, Object> mapA = bVar.a(str);
            mapA.put("win_price", Integer.valueOf(i));
            mapA.put("loss_price", Integer.valueOf(i2));
            a(e.f38323a, bVar.a(), mapA, "bs");
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, BidFailedReason bidFailedReason, String str) {
        try {
            Map<String, Object> mapA = bVar.a(str);
            mapA.put("win_price", Integer.valueOf(bidFailedReason.winECPM));
            mapA.put("loss_code", Integer.valueOf(bidFailedReason.reasonCode));
            mapA.put("adn_type", Integer.valueOf(bidFailedReason.adnName));
            mapA.put("ad_user_name", o.b(bidFailedReason.adUserName));
            mapA.put("ad_title", o.b(bidFailedReason.adTitle));
            mapA.put("ad_request_id", o.b(bidFailedReason.requestId));
            mapA.put("winner_exposure_status", Integer.valueOf(bidFailedReason.exposureStatus));
            mapA.put("winner_click_status", Integer.valueOf(bidFailedReason.clickStatus));
            a(e.b, bVar.a(), mapA, "bf");
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar, int i, String str) {
        try {
            Map<String, Object> mapA = bVar.a(str);
            mapA.put("dpl_fail_reason", Integer.valueOf(i));
            a(e.n, bVar.a(), mapA, "comm");
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public static void a(com.ipd.dsp.internal.j1.b bVar) {
        com.ipd.dsp.internal.e1.k kVarA;
        LinkedList<String> linkedListA;
        if (bVar == null || bVar.b() == null || (kVarA = bVar.a()) == null || (linkedListA = kVarA.a(bVar.b().a())) == null || linkedListA.isEmpty()) {
            return;
        }
        Map<String, Object> mapC = bVar.c();
        a(e.u, (com.ipd.dsp.internal.e1.k) null, mapC, "vpp");
        HashMap<String, Object> mapA = a(mapC);
        if (mapA == null || mapA.isEmpty()) {
            return;
        }
        Iterator<String> it = linkedListA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (Map.Entry<String, Object> entry : mapA.entrySet()) {
                if (next.contains(entry.getKey())) {
                    next = next.replace(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            a(next);
        }
    }

    public static void a(c cVar, com.ipd.dsp.internal.e1.k kVar, Map<String, Object> map, String str) {
        try {
            String string = UUID.randomUUID().toString();
            if (Dsp.isDebugLogEnable()) {
                k.d(f38319a, "[" + string + "] " + str);
            }
            com.ipd.dsp.internal.y1.b.a(new com.ipd.dsp.internal.b2.d(cVar.b, map, new b(string)));
            if (kVar != null) {
                a(cVar, kVar, map);
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public static void a(c cVar, com.ipd.dsp.internal.e1.k kVar, Map<String, Object> map) {
        LinkedList<String> linkedListA;
        if (kVar == null || cVar == null || (linkedListA = kVar.a(cVar.f38322a)) == null || linkedListA.isEmpty()) {
            return;
        }
        try {
            for (String string : linkedListA) {
                if (o.c(string)) {
                    HashMap<String, Object> mapA = a(map);
                    if (mapA != null && !mapA.isEmpty()) {
                        Uri uri = Uri.parse(string);
                        Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
                        for (String str : uri.getQueryParameterNames()) {
                            String queryParameter = uri.getQueryParameter(str);
                            if (queryParameter != null && queryParameter.startsWith("ZJ_")) {
                                queryParameter = mapA.containsKey(queryParameter) ? String.valueOf(mapA.get(queryParameter)) : "";
                            }
                            builderClearQuery.appendQueryParameter(str, queryParameter);
                        }
                        string = builderClearQuery.build().toString();
                    }
                    a(string);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static HashMap<String, Object> a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals("ad_item_id")) {
                map2.put("ZJ_ORDER_NO", entry.getValue());
            } else {
                map2.put("ZJ_" + entry.getKey().toUpperCase(), entry.getValue());
            }
        }
        return map2;
    }

    public static void a(@NonNull String str) {
        try {
            com.ipd.dsp.internal.y1.b.a(new com.ipd.dsp.internal.b2.e(str, null));
        } catch (Throwable th) {
            r.a(th);
        }
    }
}
