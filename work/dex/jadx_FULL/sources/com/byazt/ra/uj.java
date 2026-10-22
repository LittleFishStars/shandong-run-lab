package com.byazt.ra;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION, 15})
public class uj {
    public static Bundle c(com.byazt.bo.c cVar) {
        Bundle bundle = new Bundle();
        if (cVar == null) {
            return bundle;
        }
        float fTt = cVar.tt();
        String strVe = cVar.ve();
        Map<String, Object> mapUj = cVar.uj();
        if (mapUj == null) {
            mapUj = new HashMap<>();
        }
        Object obj = mapUj.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj instanceof Bundle) {
            Bundle bundle2 = (Bundle) obj;
            bundle2.putFloat("reward_extra_key_reward_amount", fTt);
            bundle2.putString("reward_extra_key_reward_name", strVe);
            return bundle2;
        }
        bundle.putString("reward_extra_key_reward_name", strVe);
        bundle.putFloat("reward_extra_key_reward_amount", fTt);
        Object obj2 = mapUj.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj2 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj2).booleanValue());
        }
        Object obj3 = mapUj.get("transId");
        if (obj3 instanceof String) {
            bundle.putString("transId", (String) obj3);
        }
        Object obj4 = mapUj.get(MediationConstant.KEY_REASON);
        if (obj4 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj4).intValue());
        }
        Object obj5 = mapUj.get("gromoreExtra");
        if (obj5 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj5);
        }
        Object obj6 = mapUj.get("errorCode");
        if (obj6 instanceof Integer) {
            bundle.putInt("errorCode", ((Integer) obj6).intValue());
        }
        Object obj7 = mapUj.get("errorMsg");
        if (obj7 instanceof String) {
            bundle.putString("errorMsg", (String) obj7);
        }
        Object obj8 = mapUj.get(MediationConstant.KEY_ADN_NAME);
        if (!(obj8 instanceof String)) {
            return bundle;
        }
        bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj8);
        return bundle;
    }
}
