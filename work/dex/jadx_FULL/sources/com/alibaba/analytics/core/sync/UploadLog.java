package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UploadLog {
    protected int z = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected d f660a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected NetworkStatus f23789a = NetworkStatus.ALL;

    public enum NetworkStatus {
        ALL,
        WIFI,
        TWO_GENERATION,
        THRID_GENERATION,
        FOUR_GENERATION,
        NONE
    }

    public void L(String str) {
        JSONObject jSONObject;
        Iterator<String> itKeys;
        String str2;
        if (TextUtils.isEmpty(str)) {
            com.alibaba.analytics.a.j.w(null, "Config Is Empty");
            return;
        }
        try {
            com.alibaba.analytics.core.a.e eVarM111a = com.alibaba.analytics.core.d.a().m111a();
            if (eVarM111a == null || (jSONObject = new JSONObject(str).getJSONObject("config")) == null) {
                return;
            }
            Iterator<String> itKeys2 = jSONObject.keys();
            if (itKeys2 == null || !itKeys2.hasNext()) {
                com.alibaba.analytics.a.j.i(null, "No Config Update");
                return;
            }
            while (itKeys2.hasNext()) {
                String next = itKeys2.next();
                if (!TextUtils.isEmpty(next)) {
                    HashMap map = new HashMap();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null && (itKeys = jSONObject2.keys()) != null) {
                        while (itKeys.hasNext()) {
                            String next2 = itKeys.next();
                            if (jSONObject2.get(next2) == null) {
                                str2 = null;
                            } else {
                                str2 = jSONObject2.get(next2) + "";
                            }
                            map.put(next2, str2);
                        }
                    }
                    com.alibaba.analytics.a.j.d("Config Update", "namespace", next, "configs", map);
                    eVarM111a.b(next, map);
                }
            }
            com.alibaba.analytics.core.a.e.n("1");
        } catch (Throwable th) {
            com.alibaba.analytics.a.j.e("", th, new Object[0]);
        }
    }

    public void a(NetworkStatus networkStatus) {
        this.f23789a = networkStatus;
    }

    public void a(d dVar) {
        this.f660a = dVar;
    }

    public NetworkStatus a() {
        String strV = com.alibaba.analytics.core.e.b.v();
        if (NetworkUtil.NETWORK_TYPE_2G.equalsIgnoreCase(strV)) {
            return NetworkStatus.TWO_GENERATION;
        }
        if (NetworkUtil.NETWORK_TYPE_3G.equalsIgnoreCase(strV)) {
            return NetworkStatus.THRID_GENERATION;
        }
        if (NetworkUtil.NETWORK_TYPE_4G.equalsIgnoreCase(strV)) {
            return NetworkStatus.FOUR_GENERATION;
        }
        if (com.efs.sdk.base.core.util.NetworkUtil.WIFI.equalsIgnoreCase(strV)) {
            return NetworkStatus.WIFI;
        }
        return NetworkStatus.NONE;
    }
}
