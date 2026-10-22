package com.bwt.top.custom_ad.http;

import android.text.TextUtils;
import com.bwt.top.exception.AdError;
import com.bwt.top.http.RequestCallback;
import com.bwt.top.util.ALog;
import com.easyjson.JSON;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class CustomRequestCallback implements RequestCallback {
    private String TAG = getClass().getSimpleName();

    @Override // com.bwt.top.http.RequestCallback
    public void onFail(Throwable th) {
        ALog.i(this.TAG, "onFail:" + th.getMessage());
        onFailed(new AdError(301, "" + th.getMessage()));
    }

    public abstract void onFailed(AdError adError);

    public abstract void onSucceed(CustomAdPosResult customAdPosResult);

    @Override // com.bwt.top.http.RequestCallback
    public void onSuccess(String str) {
        AdError adError;
        ALog.i(this.TAG, "onSuccess:" + str);
        if (TextUtils.isEmpty(str)) {
            adError = new AdError(301, "request callback is empty");
        } else {
            try {
                CustomAdBase customAdBase = (CustomAdBase) JSON.parseObject(str, CustomAdBase.class);
                if (customAdBase == null || customAdBase.getMsg() == null || !customAdBase.getMsg().toLowerCase().equals("ok") || customAdBase.getAdPosResult() == null) {
                    onFailed(new AdError(301, "result data is empty"));
                } else {
                    onSucceed(customAdBase.getAdPosResult());
                }
                return;
            } catch (Throwable unused) {
                adError = new AdError(301, "request callback is empty t");
            }
        }
        onFailed(adError);
    }
}
