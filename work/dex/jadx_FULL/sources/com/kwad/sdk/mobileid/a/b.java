package com.kwad.sdk.mobileid.a;

import android.annotation.SuppressLint;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.i;
import com.kwad.sdk.utils.an;
import com.zj.adlib.c49;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class b extends d {
    private static String biY;

    private static String Ss() {
        return UUID.randomUUID().toString().replace(c49.f40900a, "");
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String St() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    private static String Su() {
        return "300012755841";
    }

    private static String Sv() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    private static String ao(String str, String str2) {
        return an.md5(Su() + str + str2 + "2.0" + Sv());
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            biY = Ss();
            String strSt = St();
            String strAo = ao(strSt, biY);
            putBody("timestamp", strSt);
            putBody(UserTrackConstant.SIGN, strAo);
            putBody("traceId", biY);
            putBody("appId", Su());
            putBody("interfaceVersion", "2.0");
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.Fe();
    }
}
