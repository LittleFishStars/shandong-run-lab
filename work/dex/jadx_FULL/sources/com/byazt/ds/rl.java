package com.byazt.ds;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.zj.adlib.ze1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 117})
public class rl extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f28428a;
    public final Context n;

    public rl(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f28428a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager != null) {
            try {
                i.c(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                i.c(jSONObject, ze1.t, telephonyManager.getNetworkOperator());
                i.c(jSONObject, "udid", this.f28428a.aw() ? com.byazt.yv.a.c(telephonyManager) : this.f28428a.bx());
                return true;
            } catch (Exception e) {
                com.byazt.yv.da.tt(e);
            }
        }
        return false;
    }
}
