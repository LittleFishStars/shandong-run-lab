package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class c implements d {
    public static List<BaseMode> a(Context context, Intent intent) {
        int i;
        BaseMode baseModeA;
        if (intent == null) {
            return null;
        }
        try {
            i = Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("type")));
        } catch (Exception e) {
            com.heytap.mcssdk.utils.d.e("MessageParser--getMessageByIntent--Exception:" + e.getMessage());
            i = 4096;
        }
        com.heytap.mcssdk.utils.d.b("MessageParser--getMessageByIntent--type:".concat(String.valueOf(i)));
        ArrayList arrayList = new ArrayList();
        for (d dVar : PushService.getInstance().getParsers()) {
            if (dVar != null && (baseModeA = dVar.a(context, i, intent)) != null) {
                arrayList.add(baseModeA);
            }
        }
        return arrayList;
    }

    public abstract BaseMode a(Intent intent, int i);
}
