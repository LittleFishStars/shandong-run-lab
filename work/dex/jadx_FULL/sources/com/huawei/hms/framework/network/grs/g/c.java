package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    private static final String l = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f37525a;
    private final Context b;
    private final com.huawei.hms.framework.network.grs.e.a c;
    private d d;
    private final com.huawei.hms.framework.network.grs.g.j.c i;
    private final Map<String, Future<d>> e = new ConcurrentHashMap(16);
    private final List<d> f = new CopyOnWriteArrayList();
    private final JSONArray g = new JSONArray();
    private final List<String> h = new CopyOnWriteArrayList();
    private String j = "";
    private long k = 1;

    public c(com.huawei.hms.framework.network.grs.g.j.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.i = cVar;
        this.f37525a = cVar.b();
        this.b = cVar.a();
        this.c = aVar;
        b();
        c();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009b A[LOOP:0: B:3:0x0005->B:33:0x009b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0093 A[SYNTHETIC] */
    private d a(ExecutorService executorService, List<String> list, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        boolean z;
        d dVar = null;
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            if (!TextUtils.isEmpty(str2)) {
                Future<d> futureSubmit = executorService.submit(new a(str2, i, this, this.b, str, this.f37525a, cVar).g());
                this.e.put(str2, futureSubmit);
                z = true;
                try {
                    d dVar2 = futureSubmit.get(this.k, TimeUnit.SECONDS);
                    if (dVar2 != null) {
                        try {
                            if (dVar2.o() || dVar2.m()) {
                                Logger.i(l, "grs request return body is not null and is OK.");
                                dVar = dVar2;
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            dVar = dVar2;
                            Logger.w(l, "the current thread was interrupted while waiting", e);
                        } catch (CancellationException unused) {
                            dVar = dVar2;
                            Logger.i(l, "{requestServer} the computation was cancelled");
                        } catch (ExecutionException e2) {
                            e = e2;
                            dVar = dVar2;
                            Logger.w(l, "the computation threw an ExecutionException", e);
                        } catch (TimeoutException unused2) {
                            dVar = dVar2;
                            Logger.w(l, "the wait timed out");
                        }
                        if (z) {
                            Logger.v(l, "needBreak is true so need break current circulation");
                            break;
                        }
                    }
                    dVar = dVar2;
                } catch (InterruptedException e3) {
                    e = e3;
                } catch (CancellationException unused3) {
                } catch (ExecutionException e4) {
                    e = e4;
                } catch (TimeoutException unused4) {
                }
            }
            z = false;
            if (z) {
                Logger.v(l, "needBreak is true so need break current circulation");
                break;
            }
        }
        return b(dVar);
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.f37525a.getGrsReqParamJoint(false, false, d(), this.b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.h.add(sb.toString());
    }

    private d b(d dVar) throws ExecutionException, InterruptedException, TimeoutException {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e = e;
                str = l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e2) {
                e = e2;
                str = l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    private void b() {
        com.huawei.hms.framework.network.grs.g.j.d dVarA = com.huawei.hms.framework.network.grs.g.i.a.a(this.b);
        if (dVarA == null) {
            Logger.w(l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(dVarA);
        List<String> listA = dVarA.a();
        if (listA == null || listA.size() <= 0) {
            Logger.v(l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (listA.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String strB = dVarA.b();
        if (listA.size() > 0) {
            for (String str : listA) {
                if (str.startsWith("https://")) {
                    a(strB, str);
                } else {
                    Logger.w(l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.v(l, "request to GRS server url is {%s}", this.h);
    }

    private void c() {
        String grsParasKey = this.f37525a.getGrsParasKey(true, true, this.b);
        this.j = this.c.a().a(grsParasKey + "ETag", "");
    }

    private String d() {
        com.huawei.hms.framework.network.grs.f.b bVarA = com.huawei.hms.framework.network.grs.f.b.a(this.b.getPackageName());
        com.huawei.hms.framework.network.grs.local.model.a aVarA = bVarA != null ? bVarA.a() : null;
        if (aVarA == null) {
            return "";
        }
        String strA = aVarA.a();
        Logger.v(l, "get appName from local assets is{%s}", strA);
        return strA;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        if (this.h.isEmpty()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        d dVarA = a(executorService, this.h, str, cVar);
        Logger.i(l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(dVarA == null ? 0 : dVarA.b()));
        e.a(new ArrayList(this.f), SystemClock.elapsedRealtime() - jElapsedRealtime, this.g, this.b);
        this.f.clear();
        return dVarA;
    }

    public String a() {
        return this.j;
    }

    public synchronized void a(d dVar) {
        this.f.add(dVar);
        d dVar2 = this.d;
        if (dVar2 != null && (dVar2.o() || this.d.m())) {
            Logger.v(l, "grsResponseResult is ok");
            return;
        }
        if (dVar.n()) {
            Logger.i(l, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.f37525a.getGrsParasKey(true, true, this.b), new com.huawei.hms.framework.network.grs.h.d.a(dVar.k(), SystemClock.elapsedRealtime()));
            return;
        }
        if (dVar.m()) {
            Logger.i(l, "GRS server open 304 Not Modified.");
        }
        if (!dVar.o() && !dVar.m()) {
            Logger.v(l, "grsResponseResult has exception so need return");
            return;
        }
        this.d = dVar;
        this.c.a(this.f37525a, dVar, this.b, this.i);
        for (Map.Entry<String, Future<d>> entry : this.e.entrySet()) {
            if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                Logger.i(l, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d dVar) {
    }
}
