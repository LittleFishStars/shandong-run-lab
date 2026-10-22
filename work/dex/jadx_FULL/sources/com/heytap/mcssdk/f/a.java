package com.heytap.mcssdk.f;

import android.content.Context;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a implements c {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.heytap.mcssdk.c.b bVar, PushService pushService) {
        int i;
        if (bVar == null) {
            d.e("message is null , please check param of parseCommandMessage(2)");
        }
        if (pushService == null) {
            d.e("pushService is null , please check param of parseCommandMessage(2)");
            return;
        }
        if (pushService.getPushCallback() == null) {
            d.e("pushService.getPushCallback() is null , please check param of parseCommandMessage(2)");
            return;
        }
        int iE = bVar.e();
        if (iE == 12287) {
            ICallBackResultService pushCallback = pushService.getPushCallback();
            if (pushCallback != null) {
                pushCallback.onError(bVar.g(), bVar.f(), bVar.i(), bVar.h());
                return;
            }
            return;
        }
        if (iE == 12298) {
            pushService.getPushCallback().onSetPushTime(bVar.g(), bVar.f());
            return;
        }
        if (iE == 12306) {
            pushService.getPushCallback().onGetPushStatus(bVar.g(), Utils.parseInt(bVar.f()));
            return;
        }
        if (iE == 12309) {
            pushService.getPushCallback().onGetNotificationStatus(bVar.g(), Utils.parseInt(bVar.f()));
            return;
        }
        if (iE == 12289) {
            if (bVar.g() == 0) {
                pushService.setRegisterID(bVar.f());
            }
            pushService.getPushCallback().onRegister(bVar.g(), bVar.f(), bVar.i(), bVar.h());
            return;
        }
        if (iE == 12290) {
            pushService.getPushCallback().onUnRegister(bVar.g(), bVar.i(), bVar.h());
            return;
        }
        switch (iE) {
            case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
            case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                ISetAppNotificationCallBackService pushSetAppNotificationCallBack = pushService.getPushSetAppNotificationCallBack();
                if (pushSetAppNotificationCallBack != null) {
                    pushSetAppNotificationCallBack.onSetAppNotificationSwitch(bVar.g());
                }
                break;
            case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                try {
                    i = Integer.parseInt(bVar.f());
                } catch (Exception unused) {
                    i = 0;
                }
                IGetAppNotificationCallBackService pushGetAppNotificationCallBack = pushService.getPushGetAppNotificationCallBack();
                if (pushGetAppNotificationCallBack != null) {
                    pushGetAppNotificationCallBack.onGetAppNotificationSwitch(bVar.g(), i);
                }
                break;
        }
    }

    @Override // com.heytap.mcssdk.f.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            final com.heytap.mcssdk.c.b bVar = (com.heytap.mcssdk.c.b) baseMode;
            d.b("mcssdk-CallBackResultProcessor:" + bVar.toString());
            f.b(new Runnable() { // from class: com.heytap.mcssdk.f.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(bVar, PushService.getInstance());
                }
            });
        }
    }
}
