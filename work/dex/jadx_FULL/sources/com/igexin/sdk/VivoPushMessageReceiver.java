package com.igexin.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {
    public static final String TAG = "Assist_VV";

    public void onReceiveRegId(Context context, String str) {
        try {
            Log.d("Assist_VV", "onReceiveRegId :".concat(String.valueOf(str)));
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.VIVO_PREFIX.concat(String.valueOf(str))));
        } catch (Throwable th) {
            Log.d("Assist_VV", th.getMessage());
        }
    }
}
