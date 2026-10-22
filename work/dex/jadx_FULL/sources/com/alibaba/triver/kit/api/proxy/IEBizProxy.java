package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.Page;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IEBizProxy extends Extension {

    public interface IEBizCallback {
        void onFail(String str, String str2, JSONObject jSONObject);

        void onSuccess(JSONObject jSONObject);
    }

    void chooseAddress(Context context, Page page, IEBizCallback iEBizCallback);

    void confirmOrder(Context context, Page page, String str, IEBizCallback iEBizCallback);

    void hideSKU(Context context, IEBizCallback iEBizCallback);

    void openCart(Context context, Page page, Map<String, Object> map, IEBizCallback iEBizCallback);

    void openChat(Context context, Page page, Map<String, Object> map, IEBizCallback iEBizCallback);

    void openSKU(Context context, Map<String, Object> map, IEBizCallback iEBizCallback);
}
