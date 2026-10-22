package com.byazt.feb;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nr.m;
import com.byazt.pik.n;
import com.byazt.pik.uj;
import com.byazt.pik.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, 20})
public class c {
    public static volatile c c;
    public final JSONObject ve = new JSONObject();
    public final Map<String, Map<String, C0401c>> tt = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.byazt.feb.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, 44})
    public static class C0401c {
        public String c;
        public String tt;
        public List<Long> uj;
        public String ve;

        private C0401c() {
            this.uj = new CopyOnWriteArrayList();
        }
    }

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public JSONObject tt() {
        return this.ve;
    }

    private String tt(ve veVar, JSONObject jSONObject) {
        String strVe = veVar.ve();
        if (strVe != null && !strVe.isEmpty()) {
            try {
                Object objC = com.byazt.kx.c.c(com.byazt.jze.tt.c(strVe)).c(jSONObject);
                return objC != null ? objC.toString() : "default";
            } catch (Exception e) {
                m.uj("Tmee_TTFeaCalCenter", "calculateGroupKey error:" + e.toString());
            }
        }
        return "default";
    }

    public void c(JSONObject jSONObject) {
        List<ve> listTt = tt.c().tt();
        if (listTt == null || listTt.isEmpty()) {
            return;
        }
        for (ve veVar : listTt) {
            if (veVar.sp()) {
                try {
                    c(veVar, jSONObject);
                } catch (Throwable th) {
                    m.uj("Tmee_TTFeaCalCenter", "processEvent error:" + th.toString());
                }
            }
        }
    }

    private void tt(ve veVar, com.byazt.pik.c cVar, String str, JSONObject jSONObject) {
        if (veVar == null || cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jOptLong = jSONObject.optLong("ts");
        String strC = veVar.c();
        Map<String, C0401c> concurrentHashMap = this.tt.get(strC);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.tt.put(strC, concurrentHashMap);
        }
        String str2 = cVar.tt() + LoginConstants.UNDER_LINE + str;
        C0401c c0401c = concurrentHashMap.get(str2);
        if (c0401c == null) {
            c0401c = new C0401c();
            c0401c.c = "count";
            c0401c.tt = str;
            c0401c.ve = cVar.tt();
            concurrentHashMap.put(str2, c0401c);
        }
        c0401c.uj.add(Long.valueOf(jOptLong));
        c(veVar, concurrentHashMap);
    }

    private void c(ve veVar, JSONObject jSONObject) {
        if (veVar.c(jSONObject)) {
            c(veVar, tt(veVar, jSONObject), jSONObject);
            c(veVar);
        }
    }

    private void c(ve veVar, String str, JSONObject jSONObject) {
        List<com.byazt.pik.c> listN = veVar.n();
        if (listN != null) {
            Iterator<com.byazt.pik.c> it = listN.iterator();
            while (it.hasNext()) {
                c(veVar, it.next(), str, jSONObject);
            }
        }
    }

    private void c(ve veVar, com.byazt.pik.c cVar, String str, JSONObject jSONObject) {
        uj ujVarVe = cVar.ve();
        if ((ujVarVe == null || c(ujVarVe, jSONObject)) && cVar.c(jSONObject)) {
            String strC = cVar.c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            strC.hashCode();
            if (strC.equals("count")) {
                tt(veVar, cVar, str, jSONObject);
            }
        }
    }

    private void c(ve veVar, Map<String, C0401c> map) {
        n nVarUj;
        if (map == null || map.isEmpty() || (nVarUj = veVar.uj()) == null || !"time".equals(nVarUj.getType())) {
            return;
        }
        long jC = nVarUj.c() * 1000;
        for (C0401c c0401c : map.values()) {
            Iterator<Long> it = c0401c.uj.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (jLongValue < System.currentTimeMillis() - jC) {
                    c0401c.uj.remove(Long.valueOf(jLongValue));
                }
            }
        }
    }

    public void c(String str) {
        Map<String, C0401c> map;
        ve veVarC;
        n nVarUj;
        if (TextUtils.isEmpty(str) || (map = this.tt.get(str)) == null || map.isEmpty() || (veVarC = tt.c().c(str)) == null || (nVarUj = veVarC.uj()) == null) {
            return;
        }
        long jC = nVarUj.c() * 1000;
        for (C0401c c0401c : map.values()) {
            Iterator<Long> it = c0401c.uj.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (jLongValue < System.currentTimeMillis() - jC) {
                    c0401c.uj.remove(Long.valueOf(jLongValue));
                }
            }
        }
        c(veVarC);
    }

    private boolean c(uj ujVar, JSONObject jSONObject) {
        String type = ujVar.getType();
        String strC = ujVar.c();
        if ("event".equals(type)) {
            Object objOpt = jSONObject.opt("type");
            if (strC != null && objOpt != null && strC.equals(objOpt.toString())) {
                return true;
            }
        }
        return false;
    }

    private void c(ve veVar) {
        try {
            Map<String, C0401c> map = this.tt.get(veVar.c());
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (C0401c c0401c : map.values()) {
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(c0401c.tt);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    jSONObjectOptJSONObject.putOpt(c0401c.ve, Integer.valueOf(c0401c.uj.size()));
                    jSONObject2.putOpt(c0401c.tt, jSONObjectOptJSONObject);
                }
                jSONObject.putOpt("results", jSONObject2);
                List<com.byazt.pik.tt> listA = veVar.a();
                if (listA != null) {
                    for (com.byazt.pik.tt ttVar : listA) {
                        Object objC = c(ttVar, jSONObject);
                        if (objC != null) {
                            this.ve.put(ttVar.tt(), objC);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            m.uj("Tmee_TTFeaCalCenter", "generateOutputs error:" + th.toString());
        }
    }

    private Object c(com.byazt.pik.tt ttVar, JSONObject jSONObject) {
        String strC = ttVar.c();
        if (strC != null && !strC.isEmpty()) {
            try {
                return com.byazt.kx.c.c(com.byazt.jze.tt.c(strC)).c(jSONObject);
            } catch (Throwable th) {
                m.uj("Tmee_TTFeaCalCenter", "calculateOutput error:" + th.toString());
            }
        }
        return null;
    }
}
