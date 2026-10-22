package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.PtgSDKConfig;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URLDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ed implements _hn {
    public String _a;

    public _ed() {
        try {
            this._a = URLDecoder.decode("https%3A%2F%2Fmpcfg.fancydsp.com%2FinAppBidding%2Fv5%2Fcdn%3Fplatform%3D5", "UTF-8");
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.aw._hn
    public final void _a(_ho _hoVar) {
        _b(_hoVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.aw._hn
    public final void _b(_ho _hoVar) {
        String str_c;
        AdErrorImpl adErrorImpl;
        String str;
        String str2;
        int iIntValue;
        if (TextUtils.isEmpty(this._a)) {
            PtgAdSdk.getConfig().getClass();
            Context context = PtgAdSdk.getContext();
            str_c = context != null ? _jw._c(context, "ptg_policy_url") : "";
            if (str_c == null) {
                str_c = "";
            }
        } else {
            str_c = this._a;
        }
        if (TextUtils.isEmpty(str_c)) {
            str = "Policy url无效";
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "Policy url无效", (Object) null);
        } else {
            StringBuilder sb = new StringBuilder();
            try {
                PtgSDKConfig config = PtgAdSdk.getConfig();
                if (config != null) {
                    String strTrim = config._a.trim();
                    if (TextUtils.isEmpty(strTrim) || !TextUtils.isDigitsOnly(strTrim)) {
                        str2 = "buildUrlWithParams MediaID is invalid";
                    } else {
                        String str3 = config._j;
                        if (TextUtils.isEmpty(str3)) {
                            str2 = "buildUrlWithParams keyToken is null";
                        } else {
                            _c9 _c9Var = _m4._a;
                            _c9Var.getClass();
                            String sdkVersionName = PtgAdSdk.getConfig().getSdkVersionName();
                            String str4 = _c9Var._r;
                            String str5 = _c9Var._g;
                            String str6 = _c9Var._i;
                            String str7 = _c9Var._t;
                            sb.append("&i=");
                            sb.append(com.kc.aw.lib.utils._a._d(strTrim));
                            sb.append("&tk=");
                            if (str3 == null) {
                                str3 = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(str3));
                            sb.append("&sv=");
                            if (sdkVersionName == null) {
                                sdkVersionName = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(sdkVersionName));
                            sb.append("&svc=");
                            sb.append(com.kc.aw.lib.utils._a._d(PtgAdSdk.getConfig().getSdkVersionCode()));
                            sb.append("&avc=");
                            sb.append(com.kc.aw.lib.utils._a._d(_c9Var._s));
                            sb.append("&av=");
                            if (str4 == null) {
                                str4 = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(str4));
                            sb.append("&md=");
                            if (str5 == null) {
                                str5 = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(str5));
                            sb.append("&osv=");
                            if (str6 == null) {
                                str6 = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(str6));
                            sb.append("&ts=");
                            sb.append(System.currentTimeMillis());
                            sb.append("&d=");
                            String str8 = _c9Var._d;
                            if (str8 == null) {
                                str8 = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(str8));
                            sb.append("&b=");
                            sb.append(_c9Var._y);
                            sb.append("&w=");
                            sb.append(_c9Var._n);
                            sb.append("&h=");
                            sb.append(_c9Var._o);
                            sb.append("&n=");
                            sb.append(_h2._a(PtgAdSdk.getContext()));
                            sb.append("&mcc=");
                            if (str7 == null) {
                                str7 = "";
                            }
                            sb.append(com.kc.aw.lib.utils._a._d(str7));
                            sb.append("&sp=");
                            sb.append(1);
                            sb.append("&sh=");
                            Boolean bool = PtgAdSdk.getConfig()._F;
                            if (bool != null) {
                                iIntValue = bool.booleanValue();
                            } else {
                                if (com.kc.aw.lib.utils._b._a == null) {
                                    com.kc.aw.lib.utils._b._a();
                                }
                                iIntValue = com.kc.aw.lib.utils._b._a.intValue();
                            }
                            sb.append(iIntValue);
                            sb.append("&sg=");
                            String str9 = _c9Var._A;
                            sb.append(com.kc.aw.lib.utils._a._d(str9 != null ? str9 : ""));
                            sb.append("&ch=");
                            sb.append(com.kc.aw.lib.utils._a._d("ss"));
                            sb.append("&os=2");
                            str_c = str_c + sb.toString();
                        }
                    }
                    Logger.e(str2);
                }
            } catch (Exception e) {
                StringBuilder sb_a = _jf._a("buildUrlWithParams error: ");
                sb_a.append(e.getMessage());
                Logger.e(sb_a.toString());
                str_c = str_c + sb.toString();
            }
            if (!TextUtils.isEmpty(str_c)) {
                _ec _ecVar = new _ec(this, _hoVar, str_c);
                _h1._f _fVar = _h1._a;
                _ee _eeVar = new _ee(str_c);
                _eeVar._d = "GET";
                _eeVar._h = _ecVar;
                _h1._b.offer(_eeVar);
                return;
            }
            str = "Policy url参数拼接失败";
            adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, "Policy url参数拼接失败", (Object) null);
        }
        Logger.e(adErrorImpl.getMessage());
        _hoVar._c(str);
    }
}
