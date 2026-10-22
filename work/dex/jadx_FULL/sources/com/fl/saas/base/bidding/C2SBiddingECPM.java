package com.fl.saas.base.bidding;

import com.alipay.sdk.m.y.l;
import com.fl.saas.config.utils.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface C2SBiddingECPM {
    static int getC2SBiddingECPM(Object... objArr) {
        C2SBiddingECPM c2SBiddingECPM;
        String string;
        if (objArr.length == 0) {
            string = "C2S Bid Ad but ad Object is empty";
        } else {
            StringBuffer stringBuffer = new StringBuffer("C2S Bid Ad but all fail:");
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    c2SBiddingECPM = null;
                    break;
                }
                Object obj = objArr[i];
                if (obj instanceof C2SBiddingECPM) {
                    c2SBiddingECPM = (C2SBiddingECPM) obj;
                    break;
                }
                if (obj != null) {
                    stringBuffer.append(obj.getClass().getSimpleName());
                    stringBuffer.append(l.b);
                }
                i++;
            }
            if (c2SBiddingECPM != null) {
                return c2SBiddingECPM.getC2SBiddingECPM();
            }
            LogcatUtil.e("YdSDK-C2SBiddingECPM", "C2S Bid Ad but ad Object is null");
            string = stringBuffer.toString();
        }
        LogcatUtil.e("YdSDK-C2SBiddingECPM", string);
        return 0;
    }

    int getC2SBiddingECPM();
}
