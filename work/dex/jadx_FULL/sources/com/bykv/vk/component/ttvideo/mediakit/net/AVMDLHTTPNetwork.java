package com.bykv.vk.component.ttvideo.mediakit.net;

import com.byazt.gqp.da;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.t;
import com.byazt.gqp.tt;
import com.byazt.gqp.ve;
import com.byazt.gqp.yp;
import com.byazt.gqp.z;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final da JSON = da.c(ze1.g);
    private static t mClient;
    private tt mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        tt ttVar = this.mCall;
        if (ttVar == null || ttVar.uj()) {
            return;
        }
        this.mCall.ve();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                t.c cVarTt = new t().tt();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mClient = cVarTt.c(10L, timeUnit).ve(10L, timeUnit).tt(10L, timeUnit).c();
            }
        }
        yp.c cVarC = new yp.c().c(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                cVarC.c(str2, map.get(str2));
            }
        }
        tt ttVarC = mClient.c(cVarC.tt());
        this.mCall = ttVarC;
        ttVarC.c(new ve() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.byazt.gqp.ve
            public void onFailure(tt ttVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.byazt.gqp.ve
            public void onResponse(tt ttVar, m mVar) throws Throwable {
                nu nuVarA;
                Throwable th;
                JSONObject jSONObject;
                try {
                    nuVarA = mVar.a();
                    try {
                        try {
                            jSONObject = new JSONObject(nuVarA.tt());
                            e = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (nuVarA != null) {
                                try {
                                    nuVarA.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.byazt.nr.m.c(e);
                        jSONObject = null;
                    }
                    if (e == null && !mVar.uj()) {
                        e = new Exception("http fail");
                        mVar.ve();
                    }
                    if (nuVarA != null) {
                        try {
                            nuVarA.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    nuVarA = null;
                    th = th3;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                t.c cVarTt = new t().tt();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                mClient = cVarTt.c(10L, timeUnit).ve(10L, timeUnit).tt(10L, timeUnit).c();
            }
        }
        yp.c cVarC = new yp.c().c(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                cVarC.tt(str2, map.get(str2));
            }
        }
        if (i == 1) {
            cVarC.c(z.c(JSON, String.valueOf(jSONObject)));
        }
        tt ttVarC = mClient.c(cVarC.tt());
        this.mCall = ttVarC;
        ttVarC.c(new ve() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.byazt.gqp.ve
            public void onFailure(tt ttVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.byazt.gqp.ve
            public void onResponse(tt ttVar, m mVar) throws Throwable {
                nu nuVarA;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    nuVarA = mVar.a();
                    try {
                        try {
                            jSONObject2 = new JSONObject(nuVarA.tt());
                            string = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (nuVarA != null) {
                                try {
                                    nuVarA.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        string = e.toString();
                        com.byazt.nr.m.c(e);
                        jSONObject2 = null;
                    }
                    if (!mVar.uj()) {
                        string = mVar.n();
                        mVar.ve();
                    }
                    if (nuVarA != null) {
                        try {
                            nuVarA.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string));
                    }
                } catch (Throwable th3) {
                    nuVarA = null;
                    th = th3;
                }
            }
        });
    }
}
