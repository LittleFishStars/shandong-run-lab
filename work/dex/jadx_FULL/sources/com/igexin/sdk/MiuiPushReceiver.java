package com.igexin.sdk;

import android.content.Context;
import android.util.Log;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class MiuiPushReceiver extends PushMessageReceiver {
    public static final String TAG = "Assist_XM";

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        Log.d("Assist_XM", "onCommandResult receive command:".concat(String.valueOf(miPushCommandMessage)));
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        Log.d("Assist_XM", "onNotificationArrived receive message ...");
        Log.d("Assist_XM", "onNotificationArrived receive message:".concat(String.valueOf(miPushMessage)));
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        try {
            Log.d("Assist_XM", "onNotificationMessageClicked receive message ...");
            Log.d("Assist_XM", "onNotificationMessageClicked receive message:".concat(String.valueOf(miPushMessage)));
            if (context != null && miPushMessage != null) {
                MessageBean messageBean = new MessageBean(context, AssistPushConsts.MSG_TYPE_PAYLOAD, miPushMessage.getContent());
                messageBean.setMessageSource(AssistPushConsts.XM_PREFIX);
                MessageManger.getInstance().addMessage(messageBean);
            }
            AssistUtils.startGetuiService(context);
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        try {
            Log.d("Assist_XM", "onReceivePassThroughMessage receive message ...");
            Log.d("Assist_XM", "onReceivePassThroughMessage receive message:".concat(String.valueOf(miPushMessage)));
            if (context != null && miPushMessage != null) {
                MessageBean messageBean = new MessageBean(context, AssistPushConsts.MSG_TYPE_PAYLOAD, miPushMessage.getContent());
                messageBean.setMessageSource(AssistPushConsts.XM_PREFIX);
                MessageManger.getInstance().addMessage(messageBean);
            }
            AssistUtils.startGetuiService(context);
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        try {
            Log.d("Assist_XM", "onReceiveRegisterResult receiver message:".concat(String.valueOf(miPushCommandMessage)));
            if (context == null || miPushCommandMessage == null) {
                return;
            }
            String command = miPushCommandMessage.getCommand();
            List commandArguments = miPushCommandMessage.getCommandArguments();
            String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
            if ("register".equals(command) && miPushCommandMessage.getResultCode() == 0) {
                MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.XM_PREFIX.concat(String.valueOf(str))));
            }
        } catch (Throwable th) {
            Log.d("Assist_XM", th.getMessage());
        }
    }
}
