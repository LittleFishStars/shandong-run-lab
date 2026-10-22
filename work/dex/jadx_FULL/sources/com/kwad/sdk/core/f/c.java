package com.kwad.sdk.core.f;

import android.content.Context;
import android.util.Log;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    public static void a(Context context, final a aVar) {
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.sdk.core.f.c.1
            public final void onFailed(int i, String str) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed(i, str);
                }
                Log.e("KsSecSDKWrapper", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            public final void onSuccess(String str, String str2) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.aw(str2);
                }
                Log.d("KsSecSDKWrapper", "initGId onSuccessdeviceInfo：" + str2);
            }
        });
    }

    public static String doSign(Context context, String str) {
        return b.doSign(context, str);
    }

    public static void handlePolicy(JSONObject jSONObject) {
        b.handlePolicy(jSONObject);
    }

    public static boolean setEgid(Context context, String str) {
        return KWEGIDDFP.instance().setEgid(context, str);
    }
}
