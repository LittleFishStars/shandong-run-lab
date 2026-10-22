package com.alibaba.alibclinkpartner.linkpartner;

import android.content.Context;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPDetailParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPShopParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPURIParam;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static void a(Context context, ALPTBJumpParam aLPTBJumpParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        ALSLUri.ALSLdegradeType aLSLdegradeType;
        ALSLUri aLSLUri = new ALSLUri();
        aLSLUri.url = aLPTBJumpParam.getBackUpH5Url();
        aLSLUri.module = aLPTBJumpParam.getModule();
        aLSLUri.target = aLPTBJumpParam.linkKey;
        aLSLUri.degradeH5Url = aLPTBJumpParam.h5Url;
        aLSLUri.backUrl = aLPTBJumpParam.backUrl;
        aLSLUri.packageName = aLPTBJumpParam.packageName;
        aLSLUri.intentProcessor = aLPTBJumpParam.intentProcessor;
        aLSLUri.extraParam.putAll(aLPTBJumpParam.extraParams);
        aLSLUri.extraParam.put("visa", aLPTBJumpParam.visa);
        aLSLUri.bcFlSrc = aLPTBJumpParam.bcFlSrc;
        if (aLPTBJumpParam instanceof ALPDetailParam) {
            aLSLUri.extraParam.put(ALPParamConstant.ITMEID, ((ALPDetailParam) aLPTBJumpParam).itemID);
        }
        if (aLPTBJumpParam instanceof ALPShopParam) {
            aLSLUri.extraParam.put(ALPParamConstant.SHOPID, ((ALPShopParam) aLPTBJumpParam).shopID);
        }
        if (aLPTBJumpParam instanceof ALPURIParam) {
            aLSLUri.url = ((ALPURIParam) aLPTBJumpParam).url;
        }
        if (aLPJumpFailedStrategy != null) {
            int i = aLPJumpFailedStrategy.mode;
            if (i == 5) {
                aLSLdegradeType = ALSLUri.ALSLdegradeType.NONE;
            } else if (i == 4 || i == 6) {
                aLSLdegradeType = ALSLUri.ALSLdegradeType.H5;
            } else if (i == 3) {
                aLSLdegradeType = ALSLUri.ALSLdegradeType.Download;
            }
            aLSLUri.degradeType = aLSLdegradeType;
        }
        ALSLSmartLinkSDK.openUrl(context, aLSLUri, aLPSmartLinkCallback);
    }
}
