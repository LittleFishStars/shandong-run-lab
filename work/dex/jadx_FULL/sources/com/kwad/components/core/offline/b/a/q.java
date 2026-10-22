package com.kwad.components.core.offline.b.a;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class q {
    public final String acq;
    public final String acr;
    public final int acs;
    public final String act;
    public final String errorMsg;

    private q(String str, String str2, String str3, int i, String str4) {
        this.errorMsg = str;
        this.acq = str2;
        this.acr = str3;
        this.acs = i;
        this.act = str4;
    }

    public static q a(Bundle bundle) {
        return bundle == null ? new q("", "", "", 0, "") : new q(bundle.getString("result_key_error_msg", ""), bundle.getString("result_key_order_no", ""), bundle.getString("result_key_merchant_id", ""), bundle.getInt("result_key_original_result_code", 0), bundle.getString("result_key_ext_data", ""));
    }

    public static q n(String str, String str2) {
        return new q("", str, str2, 0, "");
    }

    public final String toString() {
        return "PayResultData{, errorMsg='" + this.errorMsg + "', outOrderNo='" + this.acq + "', merchantId='" + this.acr + "', originalResultCode=" + this.acs + ", extData='" + this.act + "'}";
    }
}
