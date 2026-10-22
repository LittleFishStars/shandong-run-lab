package com.byazt.ete;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zj.adlib.xh9;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 512})
public class d {
    public static final Set<ve> tt = new CopyOnWriteArraySet();
    public static boolean c = false;
    public static final Object ve = new Object();

    public interface c {
        void c(ve veVar);

        void tt(ve veVar);
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 321})
    public static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f28486a;
        public final long c;
        public final String n;
        public final String tt;
        public final String uj;
        public final String ve;

        public tt(JSONObject jSONObject) {
            this.c = jSONObject.optLong("size", 0L);
            this.tt = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.ve = jSONObject.optString("content_hash");
            this.uj = jSONObject.optString("url");
            this.n = jSONObject.optString(com.google.android.exoplayer2.offline.a.f3586e);
            this.f28486a = jSONObject.optString("file_name");
        }

        public String c() {
            return this.n;
        }

        public String tt() {
            return this.f28486a;
        }

        public JSONObject ve() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("size", this.c);
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.tt);
                jSONObject.put("content_hash", this.ve);
                jSONObject.put(com.google.android.exoplayer2.offline.a.f3586e, this.n);
                jSONObject.put("file_name", this.f28486a);
                jSONObject.put("url", this.uj);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
            return jSONObject;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 307})
    public static class uj {
        public final String c;
        public final String tt;
        public final List<tt> ve = new ArrayList();

        public uj(JSONObject jSONObject) {
            this.c = jSONObject.optString("resource_url");
            this.tt = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.ve.add(new tt(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public String c() {
            return this.c;
        }

        public String tt() {
            return this.tt;
        }

        public JSONObject uj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.c);
                jSONObject.put("content_hash", this.tt);
                JSONArray jSONArray = new JSONArray();
                Iterator<tt> it = this.ve.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().ve());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
            return jSONObject;
        }

        public List<tt> ve() {
            return this.ve;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
    public static class ve {
        public final String c;
        public final String tt;
        public final List<uj> ve = new ArrayList();

        public ve(JSONObject jSONObject) {
            this.c = jSONObject.optString(xh9.WEBSITE_PARAMS_CHANNEL);
            this.tt = jSONObject.optString(RequestParameters.PREFIX);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.ve.add(new uj(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                ve veVar = (ve) obj;
                if (!Objects.equals(this.c, veVar.c) || !Objects.equals(this.tt, veVar.tt)) {
                    return false;
                }
                uj ujVarVe = ve();
                uj ujVarVe2 = veVar.ve();
                if (ujVarVe != null && ujVarVe2 != null) {
                    return Objects.equals(ujVarVe.c(), ujVarVe2.c()) && Objects.equals(ujVarVe.tt(), ujVarVe2.tt());
                }
                if (ujVarVe == ujVarVe2) {
                    return true;
                }
            }
            return false;
        }

        public List<uj> getResources() {
            return this.ve;
        }

        public int hashCode() {
            String str = this.c;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.tt;
            int iHashCode2 = iHashCode + (str2 != null ? str2.hashCode() : 0);
            uj ujVarVe = ve();
            if (ujVarVe == null) {
                return iHashCode2;
            }
            String strC = ujVarVe.c();
            String strTt = ujVarVe.tt();
            return (((iHashCode2 * 31) + (strC != null ? strC.hashCode() : 0)) * 31) + (strTt != null ? strTt.hashCode() : 0);
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, this.c);
                jSONObject.put(RequestParameters.PREFIX, this.tt);
                JSONArray jSONArray = new JSONArray();
                Iterator<uj> it = this.ve.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().uj());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
            return jSONObject;
        }

        public String uj() {
            String str = this.c;
            if (ve() == null) {
                return str;
            }
            return str + "$" + com.byazt.nr.a.tt(ve().tt());
        }

        public uj ve() {
            if (this.ve.isEmpty()) {
                return null;
            }
            return this.ve.get(0);
        }

        public String c() {
            return this.c;
        }

        public String tt() {
            return this.tt;
        }
    }

    public static void c(JSONObject jSONObject, c cVar) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.aas.aw.c().c(cVar);
        c = jSONObject.optBoolean("h5_cache_resources_enable", false);
        tt(jSONObject, cVar);
    }

    private static void tt(JSONObject jSONObject, final c cVar) {
        if (c) {
            final HashSet hashSet = new HashSet();
            String str = "h5_cache_resources";
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        hashSet.add(new ve(jSONObjectOptJSONObject));
                    }
                }
            }
            com.byazt.bzd.x.c(new com.byazt.bwm.sp(str) { // from class: com.byazt.ete.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.aas.aw.c().c(hashSet, cVar);
                }
            });
        }
    }

    private static void ve(com.byazt.it.n nVar) {
        JSONArray jSONArray = new JSONArray();
        final JSONObject jSONObject = new JSONObject();
        try {
            Set<ve> set = tt;
            jSONObject.put("res_length", set.size());
            JSONArray jSONArray2 = new JSONArray();
            for (ve veVar : set) {
                jSONArray.put(veVar.n());
                StringBuilder sb = new StringBuilder();
                sb.append(veVar.c);
                sb.append("$");
                sb.append(veVar.tt);
                sb.append("$");
                sb.append(veVar.ve() == null ? "" : veVar.ve().c());
                jSONArray2.put(sb.toString());
            }
            jSONObject.put("res_infos", jSONArray2);
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.d.2
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() {
                    com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("h5_resource_report");
                    ttVarC.tt(jSONObject.toString());
                    return ttVarC;
                }
            }, "h5_resource_report");
            nVar.put("h5_cache_resources", jSONArray.toString());
        } catch (OutOfMemoryError e) {
            com.byazt.ukr.yp.c().c("h5_resource_oom", jSONObject, e);
        } catch (JSONException unused) {
        }
    }

    public static Set<ve> c() {
        return tt;
    }

    public static void c(com.byazt.it.n nVar) {
        synchronized (ve) {
            try {
                c = nVar.get("h5_cache_resources_enable", false);
                JSONArray jSONArray = new JSONArray(nVar.get("h5_cache_resources", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        tt.add(new ve(jSONObjectOptJSONObject));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void tt(com.byazt.it.n nVar) {
        nVar.put("h5_cache_resources_enable", c);
    }

    public static void tt(com.byazt.it.n nVar, ve veVar) {
        synchronized (ve) {
            tt.remove(veVar);
            ve(nVar);
        }
    }

    public static void c(com.byazt.it.n nVar, ve veVar) {
        synchronized (ve) {
            tt.add(veVar);
            ve(nVar);
        }
    }
}
