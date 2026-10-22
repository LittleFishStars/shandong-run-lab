package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.Page;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.api.proxy.impl.DefaultShareProxyImpl")
public interface IShareProxy extends Proxiable {
    public static final String ACTION_ON_SHARE = "com.taobao.triver.api.taobao.onShare.Broadcast";
    public static final String APP_ID = "app_id";
    public static final String RESULT_CODE = "result_code";

    public interface IShareListener {
        void onFail(int i, String str);

        void onShare();

        void onShareFinish(boolean z);
    }

    public static class ShareInfo {
        public static final int FROM_API = 2;
        public static final int FROM_FRAME = 1;
        public String bgImgUrl;
        public String bizCode;
        public String content;
        public String desc;
        public JSONObject extraParams;
        public int from = 0;
        public String imageUrl;
        public String originFrom;
        public String path;
        public String shareType;
        public JSONArray targets;
        public String title;
        public String url;
    }

    void share(Context context, Page page, ShareInfo shareInfo, IShareListener iShareListener);
}
