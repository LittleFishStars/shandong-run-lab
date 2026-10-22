package com.alipay.sdk.m.k0;

import com.ali.auth.third.login.LoginConstants;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static c a(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f25453a = dataReportResult.success;
        cVar.b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.c = map.get("apdid");
            cVar.d = map.get("apdidToken");
            cVar.g = map.get("dynamicKey");
            cVar.h = map.get("timeInterval");
            cVar.i = map.get("webrtcUrl");
            cVar.j = "";
            String str = map.get("drmSwitch");
            if (com.alipay.sdk.m.d0.a.b(str)) {
                if (str.length() >= 1) {
                    cVar.e = "" + str.charAt(0);
                }
                if (str.length() >= 3) {
                    cVar.f = "" + str.charAt(2);
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.k = map.get("apse_degrade");
            }
        }
        return cVar;
    }

    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f25454a;
        dataReportRequest.rpcVersion = dVar.j;
        dataReportRequest.bizType = "1";
        HashMap map = new HashMap();
        dataReportRequest.bizData = map;
        map.put("apdid", dVar.b);
        dataReportRequest.bizData.put("apdidToken", dVar.c);
        dataReportRequest.bizData.put(LoginConstants.UMID_TOKEN, dVar.d);
        dataReportRequest.bizData.put("dynamicKey", dVar.e);
        dataReportRequest.deviceData = dVar.f;
        return dataReportRequest;
    }
}
