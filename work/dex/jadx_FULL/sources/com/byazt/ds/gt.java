package com.byazt.ds;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt extends ve {
    public final Context n;

    public gt(Context context) {
        super(true, false);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        i.c(jSONObject, "sim_region", ((TelephonyManager) this.n.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimCountryIso());
        return true;
    }
}
