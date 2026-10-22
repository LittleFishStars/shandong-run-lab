package com.alibaba.alibclinkpartner.linkpartner;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPDetailParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPShopParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPURIParam;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import com.alibaba.alibclinkpartner.smartlink.data.MAtrixAppData;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import com.alibaba.alibclinkpartner.smartlink.manager.ALSLAppCheckManager;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALPTBLinkPartnerSDK extends b {
    public static volatile boolean isSupportJumpFailedOpenTaobao = false;

    public interface JumpIntentProcessor {
        boolean process(Intent intent, String str, String str2, Context context);
    }

    private static void a(ALPTBJumpParam aLPTBJumpParam) {
        String str;
        if (aLPTBJumpParam == null || TextUtils.isEmpty(aLPTBJumpParam.linkKey)) {
            return;
        }
        if (aLPTBJumpParam.linkKey.equals(ALPParamConstant.TAOBAO_SCHEME_COMPAT)) {
            str = "taobao";
        } else if (!aLPTBJumpParam.linkKey.equals(ALPParamConstant.TMALL_SCHEME_COMPAT)) {
            return;
        } else {
            str = "tmall";
        }
        aLPTBJumpParam.linkKey = str;
    }

    public static boolean isSupportLinkKey(String str) {
        Map<String, MatrixAppInfoDetail> map;
        MatrixAppInfoDetail matrixAppInfoDetail;
        if (!ALSLContext.instance().isInit() || str == null) {
            return false;
        }
        if (str.equals(ALPParamConstant.TAOBAO_SCHEME_COMPAT)) {
            str = "taobao";
        } else if (str.equals(ALPParamConstant.TMALL_SCHEME_COMPAT)) {
            str = "tmall";
        }
        MAtrixAppData mAtrixAppData = ALSLConfigration.sMatrixAPPData;
        return (mAtrixAppData == null || (map = mAtrixAppData.appinfo) == null || (matrixAppInfoDetail = map.get(str)) == null || !ALSLAppCheckManager.isAppCanOpen(ALSLContext.instance().mContext, matrixAppInfoDetail.packageName)) ? false : true;
    }

    @Deprecated
    public static void jumpDetail(Context context, ALPDetailParam aLPDetailParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a(aLPDetailParam);
        a.a(context, aLPDetailParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }

    @Deprecated
    public static void jumpShop(Context context, ALPShopParam aLPShopParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a(aLPShopParam);
        a.a(context, aLPShopParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }

    @Deprecated
    public static void jumpURI(Context context, ALPURIParam aLPURIParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a(aLPURIParam);
        a.a(context, aLPURIParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }

    public static void setDebugStatus(boolean z, boolean z2) {
        ALSLSmartLinkSDK.turnOnDebug(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0007, code lost:
    
        if (r2 != 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setEnvironment(int i) {
        if (i != 1) {
            int i2 = i != 2 ? 3 : 2;
            ALSLContext.setEnvironment(i2);
            return;
        }
        ALSLContext.setEnvironment(1);
    }

    public static void setSupportJumpFailedOpenTaobao(boolean z) {
        isSupportJumpFailedOpenTaobao = z;
    }

    public static int setTTID(String str) {
        if (ALSLContext.instance().isInit()) {
            if (TextUtils.isEmpty(str)) {
                return 100213;
            }
        } else if (TextUtils.isEmpty(str)) {
            return 100213;
        }
        ALSLContext.instance().tempVal = str;
        return 100102;
    }
}
