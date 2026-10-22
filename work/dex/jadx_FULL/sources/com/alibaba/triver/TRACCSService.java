package com.alibaba.triver;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IRouterProxy;
import com.taobao.accs.base.TaoBaseService;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRACCSService extends TaoBaseService implements Serializable {
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        JSONObject object;
        RVEnvironmentService rVEnvironmentService;
        try {
            if (TROrangeController.enableIDEPush()) {
                String str4 = new String(bArr);
                if (!TextUtils.isEmpty(str4) && (object = JSON.parseObject(str4)) != null && object.containsKey("from") && object.containsKey("url") && TextUtils.equals("miniapp_ide", object.getString("from"))) {
                    String string = object.getString("url");
                    if (TextUtils.isEmpty(string) || (rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)) == null) {
                        return;
                    }
                    WeakReference<Activity> topActivity = rVEnvironmentService.getTopActivity();
                    Context applicationContext = (topActivity == null || topActivity.get() == null) ? rVEnvironmentService.getApplicationContext() : topActivity.get();
                    ((IRouterProxy) RVProxy.get(IRouterProxy.class)).openURL(applicationContext, null, string, null, ActivityOptionsCompat.makeCustomAnimation(applicationContext, R.anim.ariver_fragment_translate_in_left, R.anim.ariver_fragment_translate_out_left).toBundle());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
