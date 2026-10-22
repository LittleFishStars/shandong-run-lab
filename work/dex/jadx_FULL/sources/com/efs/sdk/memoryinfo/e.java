package com.efs.sdk.memoryinfo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class e {
    final List<EfsJSONLog> B = new ArrayList();
    volatile boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EfsReporter f29894a;

    public e(final Context context, EfsReporter efsReporter) {
        this.f29894a = efsReporter;
        String uMId = UMUtils.getUMId(context);
        this.C = !TextUtils.isEmpty(uMId);
        if (!this.C) {
            ImprintHandler.getImprintService(context).registImprintCallback("umid", new UMImprintChangeCallback() { // from class: com.efs.sdk.memoryinfo.e.1
                public final void onImprintValueChanged(String str, String str2) {
                    try {
                        if ("umid".equals(str)) {
                            HashMap map = new HashMap(1);
                            map.put("um_umid_header", str2);
                            e.this.f29894a.addPublicParams(map);
                            synchronized (e.class) {
                                e.b(e.this);
                            }
                            Iterator it = e.this.B.iterator();
                            while (it.hasNext()) {
                                e.this.a((EfsJSONLog) it.next());
                            }
                            String str3 = "send cache:" + e.this.B.size();
                            if (a.DEBUG) {
                                Log.d("MemoryCollect", str3);
                            }
                            e.this.B.clear();
                            ImprintHandler.getImprintService(context).unregistImprintCallback("umid", this);
                        }
                    } catch (Throwable th) {
                        f.a("umid ", th);
                    }
                }
            });
            return;
        }
        HashMap map = new HashMap(1);
        map.put("um_umid_header", uMId);
        efsReporter.addPublicParams(map);
    }

    public static /* synthetic */ boolean b(e eVar) {
        eVar.C = true;
        return true;
    }

    public final void a(EfsJSONLog efsJSONLog) {
        try {
            this.f29894a.send(efsJSONLog);
        } catch (Throwable th) {
            f.a("send", th);
        }
    }
}
