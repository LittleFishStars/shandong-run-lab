package com.kc.aw;

import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.provider.PtgApiProvider;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g1 {
    public static void _a(AdError adError, AdSlot adSlot) {
        if (adError == null || adSlot == null || adError.getErrorCode() == 10000) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("code = ");
        stringBuffer.append(adError.getErrorCode());
        stringBuffer.append(",");
        stringBuffer.append("message = ");
        stringBuffer.append(adError.getMessage());
        stringBuffer.append(",");
        stringBuffer.append("domain = ");
        stringBuffer.append(adSlot.getDispatchPolicyCustomerItem()._c);
        String string = stringBuffer.toString();
        _nr _nrVar = new _nr("", adSlot.getCodeId(), adSlot);
        _nrVar._h = _nrVar._h;
        _nq _nqVar = _nrVar._t;
        int errorCode = adError.getErrorCode();
        String str = adSlot.getDispatchPolicyCustomerItem()._c;
        int i = 1;
        boolean z = errorCode == 20001 || errorCode == 5004 || errorCode == 40003 || errorCode == 3000 || errorCode == 100001 || errorCode == 20001 || errorCode == 10000;
        boolean z2 = errorCode == 10001;
        boolean z3 = !("tt".equals(str) || "gdt".equals(str) || PtgApiProvider.providerName.equals(str) || "qm".equals(str) || "ubix_non_agg".equals(str)) || errorCode == 40025 || errorCode == 5011 || errorCode == 5022 || errorCode == 33017 || errorCode == 33018 || errorCode == 30004 || errorCode == 10000;
        if (!z2) {
            if (z) {
                i = 2;
            } else {
                i = z3 ? 4 : 3;
            }
        }
        _nqVar._f(i);
        _nrVar._t._e(10000);
        _nrVar._t._g(string);
        _nrVar._t._m(adSlot.getPtgSlotID());
        _nrVar._t._a(adSlot.getCategoryType());
        _nrVar._t._c(PtgAdSdk.getConfig()._n);
        _nrVar._t._b(PtgAdSdk.getConfig()._o);
        _nrVar._t._l(PtgAdSdk.getConfig().getSdkVersionName());
        _nrVar._t._k(PtgAdSdk.getConfig().getSdkVersionCode());
        _nrVar._t._i(PtgAdSdk.getConfig()._a);
        _nrVar._t._j(PtgAdSdk.getConfig()._g);
        _nrVar._t._c(adSlot.getDispatchPolicyCustomerItem()._T);
        _nt._a()._a(adSlot.getDispatchPolicyCustomerItem()._f(), "inAppErr", _nrVar, null);
    }
}
