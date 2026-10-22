package com.alibaba.alibclinkpartner.linkpartner.param.jump;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.linkpartner.param.a;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALPTBJumpParam extends a {
    public String bcFlSrc;
    public String currentViewName;
    protected String d;
    public String module;
    public HashMap<String, String> extraParams = new HashMap<>();
    private String e = "lp";

    public void d(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.extraParams.put(str, str2);
    }

    public HashMap<String, String> getExtraParams() {
        d("time", String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(this.currentViewName)) {
            d(ALPParamConstant.SOURCE_VC, this.currentViewName);
        }
        return this.extraParams;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getH5DegradeParams() {
        String str;
        String str2;
        for (Map.Entry<String, String> entry : getExtraParams().entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                b(entry.getKey(), entry.getValue());
            }
        }
        if (this.f23565a.get("tag") != null) {
            b("tag", this.f23565a.get("tag"));
        }
        if (this.f23565a.get(ALPParamConstant.TTID) == null) {
            if (ALSLContext.instance().TTID != null) {
                str = ALSLContext.instance().TTID;
            }
            str2 = this.e;
            if (str2 != null) {
                b("source", str2);
            }
            return super.getH5DegradeParams();
        }
        str = this.f23565a.get(ALPParamConstant.TTID);
        b(ALPParamConstant.TTID, str);
        str2 = this.e;
        if (str2 != null) {
            b("source", str2);
        }
        return super.getH5DegradeParams();
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public String getModule() {
        return "nav";
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getParams() {
        String str = this.module;
        if (str != null) {
            a("module", str);
        }
        String str2 = this.d;
        if (str2 != null) {
            a("action", str2);
        }
        String str3 = this.e;
        if (str3 != null) {
            a("source", str3);
        }
        if (ALSLContext.instance().appkey != null) {
            a("appkey", ALSLContext.instance().appkey);
        }
        if (ALSLContext.instance().TTID != null) {
            a(ALPParamConstant.TTID, ALSLContext.instance().TTID);
        }
        if (TextUtils.isEmpty(this.linkKey) || !(this.linkKey.equals("tmall") || this.linkKey.equals(ALPParamConstant.TMALL_SCHEME_COMPAT))) {
            getExtraParams();
            HashMap<String, String> map = this.extraParams;
            if (map != null && map.size() > 0) {
                a("params", com.alibaba.alibclinkpartner.linkpartner.a.a.a(this.extraParams));
            }
        } else {
            a(ALPParamConstant.PARAMS_KV_ENCODE, "ture");
        }
        return super.getParams();
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public HashMap<String, String> getUnUrlEnCodeParams() {
        if (!TextUtils.isEmpty(this.linkKey) && (this.linkKey.equals("tmall") || this.linkKey.equals(ALPParamConstant.TMALL_SCHEME_COMPAT))) {
            getExtraParams();
            HashMap<String, String> map = this.extraParams;
            if (map != null && map.size() > 0) {
                c("params", com.alibaba.alibclinkpartner.linkpartner.a.a.b(this.extraParams));
            }
        }
        return super.getUnUrlEnCodeParams();
    }

    public boolean isInFirstParam(String str) {
        if (str != null) {
            for (String str2 : ALPParamConstant.FIRST_PARAM_KEYS) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public void putParam(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (isInFirstParam(str)) {
            a(str, str2);
        } else {
            d(str, str2);
        }
    }

    @Override // com.alibaba.alibclinkpartner.linkpartner.param.a
    public void putParams(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                if (isInFirstParam(entry.getKey())) {
                    a(entry.getKey(), entry.getValue());
                } else {
                    d(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
