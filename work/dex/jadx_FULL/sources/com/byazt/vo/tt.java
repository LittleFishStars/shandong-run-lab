package com.byazt.vo;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nc.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29140a;
    public final int c;
    public final String n;
    public String sp;
    public final List<a> tt = new ArrayList();
    public final boolean uj;
    public String ve;
    public boolean x;

    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0077 A[SYNTHETIC] */
    public tt(JSONObject jSONObject, ve veVar) {
        boolean z = false;
        this.c = jSONObject.optInt("dislike_control", 0);
        this.uj = jSONObject.optBoolean("close_on_dislike", false);
        String id = veVar != null ? veVar.getId() : "";
        this.x = veVar != null ? veVar.isNewUi() : false;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ve fromJson = ve.parseFromJson(jSONArrayOptJSONArray.optJSONObject(i));
                fromJson.setNewUi(this.x);
                if (this.x) {
                    String id2 = fromJson.getId();
                    if (!"8:1".equals(id2) && !"99:1".equals(id2)) {
                        if (fromJson.isValid()) {
                            this.tt.add(fromJson);
                            if (!zEquals) {
                                zEquals = TextUtils.equals(fromJson.getId(), id);
                            }
                        }
                    }
                } else if (fromJson.isValid()) {
                    this.tt.add(fromJson);
                    if (!zEquals) {
                        zEquals = TextUtils.equals(fromJson.getId(), id);
                    }
                }
            }
            z = zEquals;
        }
        if (veVar != null && !z) {
            this.tt.add(veVar);
        }
        this.n = jSONObject.optString(MediationConstant.EXTRA_ADID);
        this.f29140a = jSONObject.optString(LoginConstants.EXT);
    }

    public boolean a() {
        return this.c == 1;
    }

    public void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.c);
        jSONObject.put("filter_words", sp());
        jSONObject.put("close_on_dislike", i());
    }

    public boolean i() {
        return this.uj;
    }

    public String n() {
        return this.f29140a;
    }

    public JSONArray sp() {
        JSONObject json;
        JSONArray jSONArray = new JSONArray();
        List<a> list = this.tt;
        if (list != null) {
            for (a aVar : list) {
                if ((aVar instanceof ve) && (json = ((ve) aVar).toJson()) != null) {
                    jSONArray.put(json);
                }
            }
        }
        return jSONArray;
    }

    public boolean tt() {
        return this.x;
    }

    public String uj() {
        return this.n;
    }

    public String ve() {
        return this.ve;
    }

    public String x() {
        return this.sp;
    }

    public void tt(String str) {
        this.sp = str;
    }

    public List<a> c() {
        return this.tt;
    }

    public void c(String str) {
        this.ve = str;
    }
}
