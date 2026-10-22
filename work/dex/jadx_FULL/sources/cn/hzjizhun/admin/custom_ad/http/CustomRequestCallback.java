package cn.hzjizhun.admin.custom_ad.http;

import android.text.TextUtils;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.http.RequestCallback;
import cn.hzjizhun.admin.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class CustomRequestCallback implements RequestCallback {
    private String TAG = getClass().getSimpleName();

    @Override // cn.hzjizhun.admin.http.RequestCallback
    public void onFail(Throwable th) {
        ALog.i(this.TAG, "onFail:" + th.getMessage());
        onFailed(new JZAdError(301, "" + th.getMessage()));
    }

    public abstract void onFailed(JZAdError jZAdError);

    public abstract void onSucceed(CustomAdPosResult customAdPosResult);

    @Override // cn.hzjizhun.admin.http.RequestCallback
    public void onSuccess(String str) {
        ALog.i(this.TAG, "onSuccess:" + str);
        if (TextUtils.isEmpty(str)) {
            onFailed(new JZAdError(301, "request callback is empty"));
            return;
        }
        try {
            CustomAdBase bean = CustomAdBase.toBean(str);
            if (bean == null || bean.getMsg() == null || !bean.getMsg().toLowerCase().equals("ok") || bean.getAdPosResult() == null) {
                onFailed(new JZAdError(301, "result data is empty"));
            } else {
                onSucceed(bean.getAdPosResult());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            onFailed(new JZAdError(301, "request callback is empty t " + th.getMessage()));
        }
    }
}
