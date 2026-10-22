package com.byazt.ds;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.xh9;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 91})
public class sp extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f28429a;
    public final Context n;

    public sp(Context context, x xVar) {
        super(false, false);
        this.n = context;
        this.f28429a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put("sdk_version_name", "7.5.0.0.baseChina-alpha.3");
        jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, this.f28429a.sl());
        i.c(jSONObject, "aid", this.f28429a.da());
        i.c(jSONObject, "release_build", this.f28429a.yv());
        i.c(jSONObject, "app_region", this.f28429a.u());
        i.c(jSONObject, "app_language", this.f28429a.t());
        i.c(jSONObject, "user_agent", this.f28429a.p());
        i.c(jSONObject, "ab_sdk_version", this.f28429a.z());
        i.c(jSONObject, "ab_version", this.f28429a.my());
        i.c(jSONObject, "aliyun_uuid", this.f28429a.tt());
        String strZm = this.f28429a.zm();
        if (!TextUtils.isEmpty(strZm)) {
            try {
                jSONObject.put("app_track", new JSONObject(strZm));
            } catch (Throwable th) {
                com.byazt.yv.da.tt(th);
            }
        }
        String strYp = this.f28429a.yp();
        if (strYp != null && strYp.length() > 0) {
            jSONObject.put("custom", new JSONObject(strYp));
        }
        i.c(jSONObject, "user_unique_id", this.f28429a.m());
        return true;
    }
}
