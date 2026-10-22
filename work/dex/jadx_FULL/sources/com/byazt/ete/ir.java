package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME})
public class ir extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28497a;
    public int da;
    public int i;
    public String n;
    public int sl;
    public int sp;
    public int t;
    public int tt;
    public int u;
    public String uj;
    public int ve;
    public int x;
    public int yp;
    public Map<String, ir> z;

    public ir(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        this.tt = jSONObject.optInt("render_sequence");
        this.ve = jSONObject.optInt("displayAreaAndroid");
        this.uj = jSONObject.optString("ugen_md5");
        this.n = jSONObject.optString("ugen_id");
        this.f28497a = jSONObject.optString("ugen_url");
        this.sl = jSONObject.optInt("if_stay_top", 0);
        this.sp = jSONObject.optInt("need_backup_convert_area", 0);
        this.x = jSONObject.optInt("min_height", 0);
        this.i = jSONObject.optInt("min_width", 0);
        this.da = jSONObject.optInt("min_ratio", 0);
        this.t = jSONObject.optInt("mode");
        this.u = jSONObject.optInt("render_control", 0);
        this.yp = jSONObject.optInt("creative_type", 0);
        this.c = i;
        c(jSONObject.optJSONObject("config"));
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.z = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                this.z.put(next, new ir(jSONObjectOptJSONObject, 5));
            }
        }
    }

    public int a() {
        return this.sl;
    }

    public String da() {
        return this.f28497a;
    }

    public String i() {
        return this.uj;
    }

    @Override // com.byazt.ete.u
    public String n() {
        return this.n;
    }

    public boolean sl() {
        return this.sp == 1;
    }

    public int sp() {
        return this.t;
    }

    public boolean t() {
        return !TextUtils.isEmpty(this.f28497a);
    }

    @Override // com.byazt.ete.u
    public int uj() {
        return this.ve;
    }

    @Override // com.byazt.ete.u
    public int ve() {
        return this.tt;
    }

    public int x() {
        return this.u;
    }

    public boolean c(int i, int i2) {
        int iUj = com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), i);
        int iUj2 = com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), i2);
        int i3 = this.i;
        if (i3 != 0 && iUj < i3) {
            return false;
        }
        int i4 = this.x;
        if (i4 == 0 || iUj2 >= i4) {
            return iUj == 0 || iUj2 == 0 || ((float) iUj2) / ((float) iUj) >= ((float) this.da);
        }
        return false;
    }
}
