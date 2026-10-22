package com.kc.aw.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.kc.aw._ju;
import com.kc.aw._jw;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgSDKConfig {
    public int _A;
    public int _B;
    public int _C;
    public int _D;
    public int _E;
    public Boolean _F;
    public String _G;
    public List<String> _H;
    public volatile Integer _I;
    public int _c;
    public String _e;
    public String _g;
    public PtgCustomController _m;
    public Map<String, String> _p;
    public List<String> _r;
    public long _s;
    public long _t;
    public String _u;
    public long _v;
    public int _w;
    public int _x;
    public int _y;
    public int _z;
    public String _b = "";
    public String _d = "";
    public String _f = "";
    public String _h = "";
    public String _i = "UTF-8";
    public String _j = "";
    public boolean _k = false;
    public boolean _l = false;
    public String _n = "";
    public String _o = "";
    public String _q = "";
    public String _a = "undefined";

    @Keep
    public static class Builder {
        private boolean allowMobileDownload;
        private boolean allowWifiDownload;
        private Map<String, String> appIdMap;
        private Map<String, String> appKeyMap;
        private boolean debug;
        private String[] providers;
        private PtgCustomController ptgCustomController;
        private int sdkLogoId;
        private Boolean supportHttp;
        private boolean supportMultiProcess;
        private String mediaId = "";
        private String appName = "";
        private String vendorId = "";
        private String sdkLogoUrl = "";
        private String mediaSecret = "";
        private String appVersion = "";
        private String appVersionCode = "";
        private boolean sensorStatus = true;
        private String localPolicyEncode = "UTF-8";

        private String buildKeyToken(String str, String str2) {
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : com.kc.aw.lib.utils._a._c(String.format("%s%s", str, str2)).toUpperCase();
        }

        public PtgSDKConfig build() {
            PtgSDKConfig ptgSDKConfig = new PtgSDKConfig();
            ptgSDKConfig._a = this.mediaId;
            ptgSDKConfig._b = this.vendorId;
            if (this.debug) {
                Logger.openDebug();
            }
            ptgSDKConfig._c = this.sdkLogoId;
            ptgSDKConfig._d = this.sdkLogoUrl;
            ptgSDKConfig._k = this.allowMobileDownload;
            ptgSDKConfig._l = this.allowWifiDownload;
            String str = this.mediaSecret;
            ptgSDKConfig._h = str;
            ptgSDKConfig._i = this.localPolicyEncode;
            ptgSDKConfig._j = buildKeyToken(ptgSDKConfig._a, str);
            PtgCustomController ptgCustomController = this.ptgCustomController;
            if (ptgCustomController != null) {
                ptgSDKConfig._m = ptgCustomController;
            }
            ptgSDKConfig._n = this.appVersion;
            ptgSDKConfig._o = this.appVersionCode;
            boolean z = this.sensorStatus;
            Context context = PtgAdSdk.getContext();
            ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _jw._a;
            if (context != null) {
                _jw._b(Boolean.valueOf(z), "ptg_sensor_status");
                com.kc.aw.lib.utils._d._b(new _ju(context, z));
            }
            ptgSDKConfig._p = this.appIdMap;
            ptgSDKConfig._F = this.supportHttp;
            return ptgSDKConfig;
        }

        public Builder setAllowMobileDownload(boolean z) {
            this.allowMobileDownload = z;
            return this;
        }

        public Builder setAllowWifiDownload(boolean z) {
            this.allowWifiDownload = z;
            return this;
        }

        public Builder setAppIdMap(Map<String, String> map) {
            this.appIdMap = map;
            return this;
        }

        public Builder setAppKeyMap(Map<String, String> map) {
            this.appKeyMap = map;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setAppVersionCode(String str) {
            this.appVersionCode = str;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setMediaId(String str) {
            this.mediaId = str;
            return this;
        }

        public Builder setMediaSecret(String str) {
            this.mediaSecret = str;
            return this;
        }

        public Builder setProviders(String... strArr) {
            this.providers = strArr;
            return this;
        }

        @Deprecated
        public Builder setPtgAppId(String str) {
            this.vendorId = str;
            return this;
        }

        public Builder setPtgCustomController(PtgCustomController ptgCustomController) {
            this.ptgCustomController = ptgCustomController;
            return this;
        }

        public Builder setSdkLogo(int i) {
            this.sdkLogoId = i;
            return this;
        }

        public Builder setSdkLogo(String str) {
            this.sdkLogoUrl = str;
            return this;
        }

        public Builder setSensorStatus(boolean z) {
            this.sensorStatus = z;
            return this;
        }

        public Builder setSupportHttp(Boolean bool) {
            this.supportHttp = bool;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }

        public boolean supportMultiProcess() {
            return this.supportMultiProcess;
        }
    }

    public PtgSDKConfig() {
        this._e = "";
        this._g = "";
        try {
            this._e = URLDecoder.decode("https%3A%2F%2Fg.fancyapi.com%2Fs2s", "UTF-8");
        } catch (Exception unused) {
        }
        this._g = "1";
    }

    public final String _a() {
        return this._q;
    }

    public final String _a(String str) {
        Map<String, String> map = this._p;
        return map != null ? map.get(str) : "";
    }

    public final boolean _b() {
        return this._E == 0;
    }

    public String getSdkVersionCode() {
        return "200900015";
    }

    public String getSdkVersionName() {
        return OSSConstants.SDK_VERSION;
    }
}
