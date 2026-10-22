package com.byazt.ku;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.permission.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1781, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, c> f28756a = new ConcurrentHashMap();
    public String c;
    public tt n;
    public String tt;
    public List<C0458c> uj;
    public String ve;

    /* JADX INFO: renamed from: com.byazt.ku.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1781, 44})
    public static class C0458c {
        public String c;
        public String tt;
        public int ve;

        public String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0458c)) {
                return super.equals(obj);
            }
            String str2 = this.c;
            if (str2 != null) {
                C0458c c0458c = (C0458c) obj;
                if (str2.equals(c0458c.c()) && (str = this.tt) != null && str.equals(c0458c.tt())) {
                    return true;
                }
            }
            return false;
        }

        public String tt() {
            return this.tt;
        }

        public int ve() {
            return this.ve;
        }

        public void c(String str) {
            this.c = str;
        }

        public void tt(String str) {
            this.tt = str;
        }

        public void c(int i) {
            this.ve = i;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1781, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt {
        public String c;
        public String tt;
        public List<Pair<String, String>> ve;

        public String c() {
            return this.c;
        }

        public void tt(String str) {
            this.tt = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public List<Pair<String, String>> tt() {
            return this.ve;
        }

        public void c(List<Pair<String, String>> list) {
            this.ve = list;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(uj()) || TextUtils.isEmpty(ve()) || TextUtils.isEmpty(tt())) ? false : true;
    }

    public Map<String, c> c() {
        return this.f28756a;
    }

    public List<C0458c> getResources() {
        if (this.uj == null) {
            this.uj = new ArrayList();
        }
        return this.uj;
    }

    public tt n() {
        return this.n;
    }

    public JSONObject sp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", tt());
            jSONObject.putOpt("version", ve());
            jSONObject.putOpt("main", uj());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0458c c0458c : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0458c.c());
                    jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0458c.tt());
                    jSONObject2.putOpt(b.b, Integer.valueOf(c0458c.ve()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.f28756a.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.f28756a.keySet()) {
                    c cVar = this.f28756a.get(str);
                    if (cVar != null) {
                        jSONObject3.put(str, cVar.sp());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            tt ttVarN = n();
            if (ttVarN != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", ttVarN.c);
                jSONObject4.put(TKDownloadReason.KSAD_TK_MD5, ttVarN.tt);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listTt = ttVarN.tt();
                if (listTt != null) {
                    for (Pair<String, String> pair : listTt) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String tt() {
        return this.c;
    }

    public String uj() {
        return this.ve;
    }

    public String ve() {
        return this.tt;
    }

    public String x() {
        JSONObject jSONObjectSp;
        if (!a() || (jSONObjectSp = sp()) == null) {
            return null;
        }
        return jSONObjectSp.toString();
    }

    public static c uj(String str) {
        if (str == null) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(String str) {
        this.tt = str;
    }

    public void ve(String str) {
        this.ve = str;
    }

    public void c(tt ttVar) {
        this.n = ttVar;
    }

    public void c(List<C0458c> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.uj = list;
    }

    public static c c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.c(jSONObject.optString("name"));
        cVar.tt(jSONObject.optString("version"));
        cVar.ve(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0458c c0458c = new C0458c();
                c0458c.c(jSONObjectOptJSONObject2.optString("url"));
                c0458c.tt(jSONObjectOptJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
                c0458c.c(jSONObjectOptJSONObject2.optInt(b.b));
                arrayList.add(c0458c);
            }
        }
        cVar.c(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    c cVarC = c(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (cVarC != null) {
                        cVar.c().put(next, cVarC);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            tt ttVar = new tt();
            ttVar.c(jSONObjectOptJSONObject.optString("url"));
            ttVar.tt(jSONObjectOptJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                ttVar.c(arrayList2);
            }
            cVar.c(ttVar);
        }
        if (cVar.a()) {
            return cVar;
        }
        return null;
    }
}
