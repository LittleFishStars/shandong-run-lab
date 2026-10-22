package com.kc.aw;

import android.content.Context;
import android.text.TextUtils;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o9 {
    /* JADX WARN: Code duplicated, block: B:13:0x001d  */
    public static void _a(_h _hVar, AdSlot adSlot, String str) {
        boolean z;
        List<String> list;
        _cl dispatchPolicyCustomerItem;
        if (adSlot == null) {
            z = false;
        } else {
            try {
                if (adSlot.getTrackingData() == null || adSlot.getDispatchPolicyCustomerItem() == null || adSlot.getDispatchPolicyCustomerItem()._e() == null) {
                    z = false;
                } else {
                    z = !adSlot.getDispatchPolicyCustomerItem()._e().isEmpty();
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (z && (dispatchPolicyCustomerItem = adSlot.getDispatchPolicyCustomerItem()) != null) {
            _nt._a()._a(dispatchPolicyCustomerItem._e(), "", adSlot.getTrackingData(), null);
        }
        if (_hVar != null && (list = _hVar._f) != null && !list.isEmpty()) {
            List<String> list2 = _hVar._f;
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(_hVar._p)) {
                map.put("User-Agent", _hVar._p);
                map.put("Referer", "");
            }
            _h1._a(list2, (HashMap<String, String>) map);
            Logger.d("PtgAdTrackManager", "AdTrackManager do clk ", _hVar._f);
        }
        _c _cVar_a = _c._a();
        String str_a = _hj._a(_hVar);
        _cVar_a.getClass();
        com.kc.aw.lib.utils._d._b(new _d(_cVar_a, str_a, str));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0090 A[Catch: all -> 0x009c, TryCatch #1 {all -> 0x009c, blocks: (B:18:0x0040, B:20:0x004e, B:21:0x0052, B:23:0x0058, B:25:0x005e, B:34:0x0077, B:36:0x0090, B:37:0x0092), top: B:54:0x0040 }] */
    public static boolean _a(Context context, _h _hVar, AdSlot adSlot) {
        String str;
        int i;
        String str_b;
        WXLaunchMiniProgram.Req req;
        if (!_kw._a(_ku._a("MU5hfFVpPEJpPFUiP0wiPVFpPFJoOQ9jIkRiM1FlfHZUE3FFFEBvJk5+Kw=="))) {
            str = "call program, media wechat not support";
        } else if (context == null || _hVar == null) {
            str = "call program, context or ad is null";
        } else {
            String str_a = _ku._a("MU5hfFVpPEJpPFUiP0w=");
            if (!_cb._a(context, str_a)) {
                str = "call program, wechat not installed";
            } else if (_hVar._c() == null) {
                str = "call program, app is null";
            } else {
                _od wechatExt = _hVar._c().getWechatExt();
                if (wechatExt != null) {
                    IWXAPI iwxapi = null;
                    try {
                        String str_a2 = PtgAdSdk.getConfig()._a();
                        if (TextUtils.isEmpty(str_a2)) {
                            str_a2 = wechatExt._a();
                        }
                        if (TextUtils.isEmpty(str_a2)) {
                            Logger.e("call program, weChatAppId is null");
                            return false;
                        }
                        String str_c = wechatExt._c();
                        String str_d = wechatExt._d();
                        int i_e = wechatExt._e();
                        if (i_e != 0) {
                            if (i_e == 1) {
                                i = 1;
                            } else {
                                i = 2;
                                if (i_e == 2) {
                                }
                            }
                            str_b = wechatExt._b();
                            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, str_a2);
                            req = new WXLaunchMiniProgram.Req();
                            req.userName = str_c;
                            req.path = str_d;
                            req.miniprogramType = i;
                            if (!TextUtils.isEmpty(str_b)) {
                                req.extData = str_b;
                            }
                            iwxapiCreateWXAPI.sendReq(req);
                            _a(_hVar, adSlot, str_a);
                            iwxapiCreateWXAPI.detach();
                            return true;
                        }
                        i = 0;
                        str_b = wechatExt._b();
                        IWXAPI iwxapiCreateWXAPI2 = WXAPIFactory.createWXAPI(context, str_a2);
                        req = new WXLaunchMiniProgram.Req();
                        req.userName = str_c;
                        req.path = str_d;
                        req.miniprogramType = i;
                        if (!TextUtils.isEmpty(str_b)) {
                            req.extData = str_b;
                        }
                        iwxapiCreateWXAPI2.sendReq(req);
                        _a(_hVar, adSlot, str_a);
                        iwxapiCreateWXAPI2.detach();
                        return true;
                    } catch (Throwable th) {
                        try {
                            Logger.e("call program, wechat error " + th.getMessage());
                            return false;
                        } finally {
                            if (0 != 0) {
                                iwxapi.detach();
                            }
                        }
                    }
                }
                str = "call program, wechatExt is null";
            }
        }
        Logger.e(str);
        return false;
    }
}
