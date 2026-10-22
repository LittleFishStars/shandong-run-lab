package com.kwad.sdk.liteapi;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KsSecSDKWrapper {
    private static final String TAG = "KsSecSDKWrapper";

    public static String doSign(Context context, String str) {
        return a.doSign(context, str);
    }

    public static void getEGidByCallback(Context context, boolean z, final ResponseDfpCallbackProxy responseDfpCallbackProxy) {
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.sdk.liteapi.KsSecSDKWrapper.1
            public final void onFailed(int i, String str) {
                ResponseDfpCallbackProxy responseDfpCallbackProxy2 = responseDfpCallbackProxy;
                if (responseDfpCallbackProxy2 != null) {
                    responseDfpCallbackProxy2.onFailed(i, str);
                }
                Log.e(KsSecSDKWrapper.TAG, "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            public final void onSuccess(String str, String str2) {
                ResponseDfpCallbackProxy responseDfpCallbackProxy2 = responseDfpCallbackProxy;
                if (responseDfpCallbackProxy2 != null) {
                    responseDfpCallbackProxy2.onSuccess(str, str2);
                }
                Log.d(KsSecSDKWrapper.TAG, "initGId onSuccessdeviceInfo：" + str2);
            }
        });
    }

    public static void handlePolicy(JSONObject jSONObject) {
        a.handlePolicy(jSONObject);
    }

    public static boolean setEgid(Context context, String str) {
        return KWEGIDDFP.instance().setEgid(context, str);
    }
}
