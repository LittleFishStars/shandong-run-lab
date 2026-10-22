package com.alipay.android.phone.mobilesdk.socketcraft.d.b;

import com.alipay.android.phone.mobilesdk.socketcraft.e.c;
import com.alipay.android.phone.mobilesdk.socketcraft.e.d;
import com.alipay.mobile.common.logging.api.LogCategory;
import com.alipay.mobile.common.logging.api.LoggerFactory;
import com.alipay.mobile.common.logging.api.monitor.DataflowID;
import com.alipay.mobile.common.logging.api.monitor.DataflowModel;
import com.alipay.mobile.common.logging.api.monitor.Performance;
import com.alipay.mobile.common.transport.utils.MiscUtils;
import com.alipay.mobile.common.transport.utils.TransportEnvUtil;
import com.alipay.mobile.monitor.api.MonitorFactory;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.alipay.android.phone.mobilesdk.socketcraft.f.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25292a = "MonitorPrinter";

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.b.a, com.alipay.android.phone.mobilesdk.socketcraft.f.b.b
    public void a(d dVar) {
        try {
            if (dVar.b.isEmpty()) {
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(f25292a, "itemMap is empty!");
                return;
            }
            Performance performance = new Performance();
            performance.setSubType(c.f25296a);
            performance.setParam1(c.b);
            performance.setParam2("INFO");
            performance.setParam3(dVar.f25297a);
            dVar.b.entrySet();
            for (Map.Entry<String, String> entry : dVar.b.entrySet()) {
                performance.getExtPramas().put(entry.getKey(), entry.getValue());
            }
            LoggerFactory.getMonitorLogger().performance(LogCategory.CATEGORY_NETWORK, performance);
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.c(performance.getSubType() + "_PERF", a(performance) + "\n");
        } catch (Throwable th) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(f25292a, "monitorLog exception. ", th);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.b.a, com.alipay.android.phone.mobilesdk.socketcraft.f.b.b
    public void a(com.alipay.android.phone.mobilesdk.socketcraft.e.a aVar) {
        try {
            if (aVar == null) {
                com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(f25292a, "[noteTraficConsume] dataflowMonitorModel is null");
                return;
            }
            String str = aVar.g;
            if (str != null && str.trim().length() > 0) {
                DataflowModel dataflowModelObtain = DataflowModel.obtain(DataflowID.WEB_SOCKET, aVar.e, aVar.h, aVar.i, aVar.g);
                dataflowModelObtain.appId = aVar.f;
                if ("send".equals(aVar.g)) {
                    dataflowModelObtain.isUpload = true;
                }
                MonitorFactory.getMonitorContext().noteTraficConsume(dataflowModelObtain);
                if (MiscUtils.isDebugger(TransportEnvUtil.getContext())) {
                    com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.a(f25292a, "[noteTraficConsume]  dataflowMonitorModel: " + aVar.toString());
                    return;
                }
                return;
            }
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.d(f25292a, "[noteTraficConsume] methodName is empty.");
        } catch (Throwable th) {
            com.alipay.android.phone.mobilesdk.socketcraft.f.a.d.b(f25292a, "[noteTraficConsume] exception. ", th);
        }
    }

    public String a(Performance performance) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(performance.getSubType());
        stringBuffer.append(",");
        stringBuffer.append(performance.getParam1());
        stringBuffer.append(",");
        stringBuffer.append(performance.getParam2());
        stringBuffer.append(",");
        stringBuffer.append(performance.getParam3());
        stringBuffer.append(",");
        for (String str : performance.getExtPramas().keySet()) {
            stringBuffer.append(str + "=" + ((String) performance.getExtPramas().get(str)) + "^");
        }
        return stringBuffer.toString();
    }
}
