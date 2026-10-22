package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class b extends c {
    @Override // com.heytap.mcssdk.e.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4103 != i && 4098 != i && 4108 != i) {
            return null;
        }
        BaseMode baseModeA = a(intent, i);
        com.heytap.mcssdk.g.a.a(context, com.heytap.mcssdk.constant.c.a.b, (DataMessage) baseModeA);
        return baseModeA;
    }

    @Override // com.heytap.mcssdk.e.c
    public BaseMode a(Intent intent, int i) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.c)));
            dataMessage.setTaskID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.d)));
            dataMessage.setGlobalId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.h)));
            dataMessage.setAppPackage(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.e)));
            dataMessage.setTitle(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("title")));
            dataMessage.setContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
            dataMessage.setDescription(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("description")));
            String strD = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.j));
            int i2 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(strD) ? 0 : Integer.parseInt(strD));
            dataMessage.setMiniProgramPkg(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i);
            dataMessage.setEventId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.k)));
            dataMessage.setStatisticsExtra(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.l)));
            String strD2 = com.heytap.mcssdk.utils.b.d(intent.getStringExtra("data_extra"));
            dataMessage.setDataExtra(strD2);
            String strA = a(strD2);
            if (!TextUtils.isEmpty(strA)) {
                i2 = Integer.parseInt(strA);
            }
            dataMessage.setMsgCommand(i2);
            dataMessage.setBalanceTime(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.n)));
            dataMessage.setStartDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.s)));
            dataMessage.setEndDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.t)));
            dataMessage.setTimeRanges(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.o)));
            dataMessage.setRule(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.p)));
            dataMessage.setForcedDelivery(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.q)));
            dataMessage.setDistinctContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.r)));
            dataMessage.setAppId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.u)));
            return dataMessage;
        } catch (Exception e) {
            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(com.heytap.mcssdk.constant.b.v);
        } catch (JSONException e) {
            com.heytap.mcssdk.utils.d.b(e.getMessage());
            return "";
        }
    }
}
