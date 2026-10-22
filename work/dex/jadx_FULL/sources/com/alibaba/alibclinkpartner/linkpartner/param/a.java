package com.alibaba.alibclinkpartner.linkpartner.param;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.ALPTBLinkPartnerSDK;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLConfigConstants;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLSystemUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<String, String> f23565a;
    protected HashMap<String, String> b;
    public String backUrl;
    protected HashMap<String, String> c;
    private String d;
    public String h5Url;
    public ALPTBLinkPartnerSDK.JumpIntentProcessor intentProcessor;
    public String linkKey;
    public String packageName;
    public String pluginRules;
    public String visa;

    public a() {
        this.linkKey = "taobao";
        this.d = ALSLConfigConstants.LINKPARTNER;
        this.f23565a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
    }

    public a(String str, String str2, String str3) {
        this.linkKey = "taobao";
        this.d = ALSLConfigConstants.LINKPARTNER;
        this.f23565a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.linkKey = str;
        this.backUrl = str2;
        this.h5Url = str3;
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f23565a.put(str, str2);
    }

    public void b(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.c.put(str, str2);
    }

    public void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.b.put(str, str2);
    }

    public boolean checkParam() {
        return this.linkKey != null;
    }

    public String getBackUpH5Url() {
        return this.h5Url;
    }

    public HashMap<String, String> getH5DegradeParams() {
        return this.c;
    }

    public String getModule() {
        return "";
    }

    public HashMap<String, String> getParams() {
        String str = this.backUrl;
        if (str != null) {
            a(ALPParamConstant.BACKURL, str);
        }
        String str2 = this.d;
        if (str2 != null) {
            a(ALPParamConstant.SDKNAME, str2);
        }
        String str3 = this.pluginRules;
        if (str3 != null) {
            a(ALPParamConstant.PLUGIN_RULES, str3);
        }
        a("appName", ALSLSystemUtil.getAppName(ALSLContext.instance().mApplication));
        a(ALPParamConstant.PACKAGENAME, ALSLSystemUtil.getPackageName(ALSLContext.instance().mApplication));
        a("v", ALSLContext.instance().ALSLSDKVersion);
        return this.f23565a;
    }

    public String getPostfix() {
        return "";
    }

    public HashMap<String, String> getUnUrlEnCodeParams() {
        return this.b;
    }

    public boolean isTaobaoOrTmall() {
        if (TextUtils.isEmpty(this.linkKey)) {
            return false;
        }
        String[] strArr = {ALPParamConstant.TAOBAO_SCHEME_COMPAT, "taobao", ALPParamConstant.TMALL_SCHEME_COMPAT, "tmall"};
        for (int i = 0; i < 4; i++) {
            if (strArr[i].equals(this.linkKey)) {
                return true;
            }
        }
        return false;
    }

    public void putParam(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        a(str, str2);
    }

    public void putParams(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }
}
