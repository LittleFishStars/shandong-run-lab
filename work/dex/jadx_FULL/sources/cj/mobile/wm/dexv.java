package cj.mobile.wm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cj.mobile.wm.dexq;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexv {
    public static final dexv dexd = new dexv();
    public dexc dexa;
    public final dexw dexb = new dexw();
    public final Handler dexc = new dexb(Looper.getMainLooper());

    public class dexa implements k9 {
        public dexa() {
        }

        @Override // cj.mobile.wm.k9
        public void a(int i, String str) {
            if (dexv.this.dexa != null) {
                dexv.this.dexa.dexa(false, -1);
            }
        }

        @Override // cj.mobile.wm.k9
        public void dexa(h9 h9Var) {
            int iDexa = dexv.this.dexa(h9Var);
            boolean z = iDexa == 200;
            if (dexv.this.dexa != null) {
                dexv.this.dexa.dexa(z, iDexa);
            }
            dexv.this.dexc.removeCallbacksAndMessages(null);
            dexv.this.dexc.postDelayed(new Runnable() { // from class: com.zj.adlib.zva
                @Override // java.lang.Runnable
                public final void run() {
                    dexq.dexb().dexa();
                }
            }, 10000L);
        }
    }

    public class dexb extends Handler {
        public dexb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public interface dexc {
        void dexa(boolean z, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dexa(h9 h9Var) {
        String strDexa = h9Var.dexa();
        try {
            f1.dexa("ConfigManager", "fileOneConfig data : " + strDexa);
            JSONObject jSONObject = new JSONObject(strDexa);
            String strOptString = jSONObject.optString("msg_code");
            boolean zOptBoolean = jSONObject.optBoolean("success");
            if (!"200".equals(strOptString) || !zOptBoolean) {
                if (TextUtils.isEmpty(strOptString)) {
                    return 200;
                }
                return be.dexc(strOptString);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                return 200;
            }
            String strOptString2 = jSONObjectOptJSONObject.optString("ad_enable");
            String strOptString3 = jSONObjectOptJSONObject.optString("ad_splash_enable");
            je.dexc("sp_enable_ad", strOptString2);
            je.dexc("sp_enable_splash_ad", strOptString3);
            String strOptString4 = jSONObjectOptJSONObject.optString("show_time");
            if (!TextUtils.isEmpty(strOptString4)) {
                je.dexa("exp_show_time", Long.parseLong(strOptString4));
            }
            String strOptString5 = jSONObjectOptJSONObject.optString("show_area");
            if (!TextUtils.isEmpty(strOptString5)) {
                je.dexc("exp_show_area", strOptString5);
            }
            String strOptString6 = jSONObjectOptJSONObject.optString("enable_oaid");
            if (!TextUtils.isEmpty(strOptString6)) {
                je.dexc("sp_enable_oaid", strOptString6);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("xt");
            if (jSONObjectOptJSONObject2 == null) {
                return 200;
            }
            int iDexa = dexa(jSONObjectOptJSONObject2.optString("interval"));
            dexu dexuVar = new dexu();
            if (iDexa > 0) {
                dexuVar.dexa(iDexa);
            }
            dexuVar.dexa(true);
            dexuVar.dexa(jSONObjectOptJSONObject2.optString("pUrl"));
            dexuVar.dexa(dexa(jSONObjectOptJSONObject2));
            this.dexb.dexa(dexuVar);
            return 200;
        } catch (Exception unused) {
            return 200;
        }
    }

    private int dexa(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    private List<String> dexa(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            String strOptString = jSONObject.optString("aa");
            if (TextUtils.isEmpty(strOptString)) {
                return arrayList;
            }
            String strDexa = ae.dexa(strOptString, "ykaduscNO7X8D5Ny");
            if (!TextUtils.isEmpty(strDexa) && (jSONArrayOptJSONArray = new JSONObject(strDexa).optJSONArray("android")) != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static dexv dexj() {
        return dexd;
    }

    private void dexk() {
        String strDexb = je.dexb("sp_enable_ad", "1");
        String strDexb2 = je.dexb("sp_enable_splash_ad", "1");
        this.dexb.dexa("1".equals(strDexb));
        this.dexb.dexc("1".equals(strDexb2));
        this.dexb.dexa(je.dexa("exp_show_time"));
        this.dexb.dexa(je.dexa("exp_show_area", 0.5f));
        this.dexb.dexb("1".equals(je.dexb("sp_enable_oaid", "1")));
    }

    private void dexl() {
        dexk();
        InsightProxy.getInstance().getNetworkProxy().dexa(new t9().dexa(new q9()), new dexa());
    }

    public void dexa(dexc dexcVar) {
        this.dexa = dexcVar;
        dexl();
    }

    public boolean dexa() {
        if (this.dexb.dexa() != null) {
            return this.dexb.dexa().dexd();
        }
        return false;
    }

    public boolean dexb() {
        return this.dexb.dexd();
    }

    public boolean dexc() {
        return this.dexb.dexf();
    }

    public long dexd() {
        if (this.dexb.dexa() != null) {
            return this.dexb.dexa().dexb();
        }
        return 604800000L;
    }

    public List<String> dexe() {
        if (this.dexb.dexa() != null) {
            return this.dexb.dexa().dexa();
        }
        return null;
    }

    public String dexf() {
        if (this.dexb.dexa() != null) {
            return this.dexb.dexa().dexc();
        }
        return null;
    }

    public float dexg() {
        return this.dexb.dexb();
    }

    public long dexh() {
        return this.dexb.dexc();
    }

    public boolean dexi() {
        return this.dexb.dexe();
    }
}
