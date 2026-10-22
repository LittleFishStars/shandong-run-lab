package com.byazt.hnr;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.byazt.dy.UGFrameLayout;
import com.byazt.sz.m;
import com.byazt.xj.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.igexin.assist.sdk.AssistPushConsts;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 20})
public class c extends com.byazt.ro.c {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout c() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.tt);
        uGFrameLayout.c(this);
        return uGFrameLayout;
    }

    @Override // com.byazt.ro.c, com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
    }

    public void c(long j, long j2) {
        m mVar;
        JSONObject jSONObjectVe;
        if (!c(12) || (mVar = this.gx.get(12)) == null || (jSONObjectVe = mVar.ve()) == null) {
            return;
        }
        jSONObjectVe.optString("type");
        JSONArray jSONArrayOptJSONArray = jSONObjectVe.optJSONArray(AssistPushConsts.MSG_TYPE_ACTIONS);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                int iOptInt = jSONObjectOptJSONObject.optInt("progress") * 1000;
                if (iOptInt > j2) {
                    iOptInt = (int) j2;
                }
                if (j == iOptInt && TextUtils.equals(strOptString, "onShow")) {
                    ve veVarTt = tt(this);
                    String strOptString2 = jSONObjectOptJSONObject.optString(IpcMessageConstants.EXTRA_NODE_ID);
                    if (veVarTt != null) {
                        veVarTt.uj(strOptString2).tt(0);
                    }
                }
            }
        }
    }
}
