package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class c {
    public static void a(final Context context, final Intent intent, final IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            d.e("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            d.e("intent is null , please check param of parseIntent()");
            return;
        }
        if (iDataMessageCallBackService == null) {
            d.e("callback is null , please check param of parseIntent()");
        } else if (Utils.isSupportPushByClient(context)) {
            f.a(new Runnable() { // from class: com.heytap.mcssdk.c.1
                @Override // java.lang.Runnable
                public void run() {
                    List<BaseMode> listA = com.heytap.mcssdk.e.c.a(context, intent);
                    if (listA == null) {
                        return;
                    }
                    for (BaseMode baseMode : listA) {
                        if (baseMode != null) {
                            for (com.heytap.mcssdk.f.c cVar : PushService.getInstance().getProcessors()) {
                                if (cVar != null) {
                                    cVar.a(context, baseMode, iDataMessageCallBackService);
                                }
                            }
                        }
                    }
                }
            });
        } else {
            d.e("push is null ,please check system has push");
        }
    }
}
