package com.alibaba.ariver.app.api.mtop;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.ariver.mtop.SendMtopProxyImpl")
public interface IMtopProxy extends Proxiable {

    public interface Callback {
        void onResult(SendMtopResponse sendMtopResponse);
    }

    void requestAsync(App app, SendMtopParams sendMtopParams, Callback callback);

    void requestInnerAsync(SendMtopParams sendMtopParams, Callback callback);

    SendMtopResponse requestInnerSync(SendMtopParams sendMtopParams);

    SendMtopResponse requestSync(App app, SendMtopParams sendMtopParams);
}
