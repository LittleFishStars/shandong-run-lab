package com.bwt.top.api;

import com.bwt.top.api.bean.BaseBean;
import com.bwt.top.api.bean.InitConfigBean;
import com.bwt.top.exception.AdError;
import com.bwt.top.http.RequestCallback;
import com.easyjson.JSON;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class dkkd implements RequestCallback {
    public abstract void a(InitConfigBean initConfigBean);

    public abstract void b(AdError adError);

    @Override // com.bwt.top.http.RequestCallback
    public void onFail(Throwable th) {
        b(new AdError(102, th.getMessage()));
    }

    @Override // com.bwt.top.http.RequestCallback
    public void onSuccess(String str) {
        AdError adError;
        if (str == null || str.length() <= 0) {
            adError = new AdError(101, "response data null");
        } else {
            try {
                BaseBean baseBean = (BaseBean) JSON.parseObject(str, BaseBean.class);
                if (baseBean.isOk()) {
                    a(baseBean.getInitConfig());
                } else {
                    b(new AdError(101, "response data not ok"));
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                adError = new AdError(101, "response data error");
            }
        }
        b(adError);
    }
}
