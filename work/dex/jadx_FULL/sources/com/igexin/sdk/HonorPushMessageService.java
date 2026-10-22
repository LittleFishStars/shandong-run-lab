package com.igexin.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.HonorPushDataMsg;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class HonorPushMessageService extends HonorMessageService {
    public static final String TAG = "Assist_Honor";

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
        try {
            if (honorPushDataMsg == null) {
                Log.e("Assist_Honor", "Received message entity is null!");
                return;
            }
            Log.i("Assist_Honor", "Received payload");
            if (TextUtils.isEmpty(honorPushDataMsg.getData())) {
                return;
            }
            MessageBean messageBean = new MessageBean(getApplicationContext(), AssistPushConsts.MSG_TYPE_PAYLOAD, honorPushDataMsg.getData());
            messageBean.setMessageSource(AssistPushConsts.HONOR_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        } catch (Throwable th) {
            Log.d("Assist_Honor", th.getMessage());
        }
    }

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onNewToken(String str) {
        try {
            Log.i("Assist_Honor", "onNewToken :".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MessageManger.getInstance().addMessage(new MessageBean(getApplicationContext(), "token", AssistPushConsts.HONOR_PREFIX.concat(String.valueOf(str))));
        } catch (Throwable th) {
            Log.d("Assist_Honor", th.getMessage());
        }
    }
}
