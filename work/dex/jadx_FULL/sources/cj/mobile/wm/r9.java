package cj.mobile.wm;

import com.kc.openset.constant.DeviceIdType;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r9 extends s9 {
    public Map<String, Object> dexc = new HashMap();
    public List<String> dexd = new ArrayList();
    public String dexe;

    public void dexa(List<String> list) {
        this.dexd = list;
    }

    @Override // cj.mobile.wm.s9
    public Map<String, Object> dexb() {
        HashMap map = new HashMap();
        String strDexa = tc.dexa(g1.dexc().dexa());
        dexx systemInfo = InsightProxy.getInstance().getSystemInfo();
        map.put("utdid", strDexa);
        map.put("ua", systemInfo.dexm());
        map.put("os", "android");
        map.put("osv", systemInfo.dexi());
        map.put("device_type", Integer.valueOf(systemInfo.dexe()));
        map.put("connection_type", Integer.valueOf(systemInfo.dexd()));
        map.put("carrier", systemInfo.dexc());
        map.put(ze1.k, systemInfo.dexg());
        map.put("brand", systemInfo.dexb());
        map.put("width", Integer.valueOf(systemInfo.dexp()));
        map.put("height", Integer.valueOf(systemInfo.dexf()));
        map.put(DeviceIdType.OAID, systemInfo.dexh());
        map.put("sdkv", systemInfo.dexl());
        map.put("app_id", g1.dexc().dexb().getAppId());
        map.put("aa", this.dexd);
        String strB = dex04.b(map);
        Map<String, Object> map2 = this.dexc;
        String strDexb = ae.dexb(strB, "ykaduscNO7X8D5Ny");
        Objects.requireNonNull(strDexb);
        map2.put("data", strDexb);
        return this.dexc;
    }

    public void dexb(String str) {
        this.dexe = str;
    }

    @Override // cj.mobile.wm.s9
    public String dexd() {
        return this.dexe;
    }

    @Override // cj.mobile.wm.s9
    public boolean dexe() {
        return true;
    }
}
