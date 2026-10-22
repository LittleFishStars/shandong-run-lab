package com.alibaba.analytics.core.sync;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.a.m;
import com.alibaba.fastjson.JSON;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends UploadLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f23792a = new e();
    private volatile boolean P = false;
    private int A = -1;
    private int B = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private float f663a = 200.0f;
    private int C = 0;
    private long f = 0;
    private boolean Q = false;
    private int D = 0;
    private int E = this.z;
    private int F = 10;
    private boolean R = false;
    public final com.alibaba.analytics.core.selfmonitor.g mMonitor = new com.alibaba.analytics.core.selfmonitor.g();

    private void G() {
        com.alibaba.analytics.a.j.d();
        if (!com.alibaba.analytics.core.e.b.isConnectInternet(com.alibaba.analytics.core.d.a().getContext())) {
            com.alibaba.analytics.a.j.d("UploadLogFromDB", "Network is Disconnected");
            return;
        }
        UploadLog.NetworkStatus networkStatus = UploadLog.NetworkStatus.ALL;
        UploadLog.NetworkStatus networkStatus2 = ((UploadLog) this).f23789a;
        if (networkStatus != networkStatus2 && networkStatus2 != a()) {
            com.alibaba.analytics.a.j.w("UploadLogFromDB", "current networkstatus", a(), "mAllowedNetworkStatus", ((UploadLog) this).f23789a);
            return;
        }
        if (this.P) {
            return;
        }
        this.P = true;
        try {
            this.f = 0L;
            if (!m.c(com.alibaba.analytics.core.d.a().getContext())) {
                com.alibaba.analytics.a.j.d("UploadLogFromDB", "Other Process is Uploading, break");
                this.P = false;
                m.release();
                return;
            }
            List<com.alibaba.analytics.core.model.a> list = com.alibaba.analytics.core.f.d.a().get(d());
            if (list != null && list.size() != 0) {
                if (b(list)) {
                    this.E = this.z;
                } else {
                    int i = this.E - 1;
                    this.E = i;
                    if (i > 0) {
                        g.a().M("i");
                    } else {
                        this.E = this.z;
                    }
                }
                return;
            }
            com.alibaba.analytics.a.j.d("UploadLogFromDB", "logs is null");
            this.P = false;
            this.P = false;
            m.release();
        } catch (Throwable th) {
            try {
                com.alibaba.analytics.a.j.e("UploadLogFromDB", th.toString());
            } finally {
                this.P = false;
                m.release();
            }
        }
    }

    private void H() {
        I();
        J();
    }

    private void I() {
        if (this.R) {
            return;
        }
        String strA = com.alibaba.analytics.a.a.a(com.alibaba.analytics.core.d.a().getContext(), "utanalytics_tnet_downgrade");
        if (!TextUtils.isEmpty(strA)) {
            try {
                int iIntValue = Integer.valueOf(strA).intValue();
                if (iIntValue >= 1 && iIntValue <= 10) {
                    this.F = iIntValue;
                }
            } catch (Throwable unused) {
            }
        }
        this.R = true;
    }

    private void J() {
        int i = com.alibaba.analytics.core.a.d.a().getInt("tnet_downgrade");
        if (i < 1 || i > 10) {
            return;
        }
        this.F = i;
    }

    private void K() {
        int i = this.A / 2;
        this.A = i;
        if (i < 1) {
            this.A = 1;
            this.B = 0;
        } else if (i > 350) {
            this.A = 350;
        }
        com.alibaba.analytics.a.j.d("UploadLogFromDB", "winsize", Integer.valueOf(this.A));
    }

    public static e a() {
        return f23792a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v20 */
    private boolean b(List<com.alibaba.analytics.core.model.a> list) throws Exception {
        int i;
        byte[] bArrA;
        com.alibaba.analytics.a.j.d();
        Map<String, String> mapA = a(list);
        if (mapA == null) {
            i = 1;
        } else {
            if (mapA.size() != 0) {
                try {
                    bArrA = a.a(mapA);
                } catch (Exception e) {
                    com.alibaba.analytics.a.j.e(null, e.toString());
                    bArrA = null;
                }
                if (bArrA == null) {
                    K();
                    return false;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b bVarA = i.a(bArrA);
                boolean zT = bVarA.t();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime2 - jElapsedRealtime;
                a(Boolean.valueOf(zT), j);
                H();
                if (zT) {
                    com.alibaba.analytics.core.d.a().m119j();
                    this.Q = true;
                    this.D = 0;
                    this.f += (long) com.alibaba.analytics.core.f.d.a().delete(list);
                    this.mMonitor.a(com.alibaba.analytics.core.selfmonitor.f.a(com.alibaba.analytics.core.selfmonitor.f.l, null, Double.valueOf(this.C)));
                    try {
                        L(bVarA.ba);
                    } catch (Exception unused) {
                    }
                } else {
                    int i2 = this.D + 1;
                    this.D = i2;
                    if (i2 > this.F) {
                        com.alibaba.analytics.core.d.a().a(true);
                        com.alibaba.analytics.a.j.d("UploadLogFromDB", "setHttpService");
                        return true;
                    }
                    if (com.alibaba.analytics.core.d.a().m115g()) {
                        if (!this.Q || this.D > this.F) {
                            com.alibaba.analytics.core.d.a().m121k();
                        } else {
                            HashMap map = new HashMap();
                            map.put("rt", String.valueOf(bVarA.rt));
                            map.put("pSize", String.valueOf(this.C));
                            map.put("errCode", String.valueOf(bVarA.w));
                            map.put("type", "1");
                            this.mMonitor.a(com.alibaba.analytics.core.selfmonitor.f.a(com.alibaba.analytics.core.selfmonitor.f.k, JSON.toJSONString(map), Double.valueOf(1.0d)));
                        }
                    }
                }
                com.alibaba.analytics.a.j.i("UploadLogFromDB", "isSendSuccess", Boolean.valueOf(zT), "upload log count", Integer.valueOf(list.size()), "upload consume", Long.valueOf(j), "delete consume", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime2));
                try {
                    Thread.sleep(100L);
                    return false;
                } catch (Throwable th) {
                    com.alibaba.analytics.a.j.w("UploadLogFromDB", th, new Object[0]);
                    return false;
                }
            }
            i = 1;
        }
        Object[] objArr = new Object[i];
        objArr[r3] = "postDataMap is null";
        com.alibaba.analytics.a.j.d("UploadLogFromDB", objArr);
        this.P = 0;
        return i;
    }

    private int d() {
        if (this.A == -1) {
            String strV = com.alibaba.analytics.core.e.b.v();
            if (NetworkUtil.WIFI.equalsIgnoreCase(strV)) {
                this.A = 20;
            } else if (com.alibaba.ariver.kernel.common.network.NetworkUtil.NETWORK_TYPE_4G.equalsIgnoreCase(strV)) {
                this.A = 16;
            } else if (com.alibaba.ariver.kernel.common.network.NetworkUtil.NETWORK_TYPE_3G.equalsIgnoreCase(strV)) {
                this.A = 12;
            } else {
                this.A = 8;
            }
        }
        return this.A;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001d -> B:17:0x0022). Please report as a decompilation issue!!! */
    public void F() {
        try {
            if (com.alibaba.analytics.core.d.a().m118i()) {
                com.alibaba.analytics.a.j.w("UploadLogFromDB", "isAllServiceClosed");
            } else {
                G();
            }
        } catch (Throwable th) {
            com.alibaba.analytics.a.j.e("UploadLogFromDB", th, new Object[0]);
        }
        try {
            d dVar = ((UploadLog) this).f660a;
            if (dVar != null) {
                dVar.b(this.f);
            }
        } catch (Throwable th2) {
            com.alibaba.analytics.a.j.e("UploadLogFromDB", th2, new Object[0]);
        }
    }

    public boolean u() {
        return this.Q;
    }

    public Map<String, String> a(List<com.alibaba.analytics.core.model.a> list) {
        HashMap map = null;
        List<com.alibaba.analytics.core.model.a> listA = null;
        map = null;
        if (list != null && list.size() != 0) {
            HashMap map2 = new HashMap();
            ArrayList arrayList = null;
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                com.alibaba.analytics.core.model.a aVar = list.get(i);
                if (length > 5242880) {
                    listA = a(listA, aVar);
                    com.alibaba.analytics.a.j.d("UploadLogFromDB", "log delay to upload because totalUploadSize Exceed. log", aVar, "totalUploadSize", Integer.valueOf(length));
                } else if (com.alibaba.analytics.core.a.d.a().m99a(com.alibaba.analytics.core.d.c.a(aVar.getContent()))) {
                    listA = a(listA, aVar);
                    if (list.get(i).priority.compareToIgnoreCase("3") >= 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(list.get(i));
                    }
                    com.alibaba.analytics.a.j.d("UploadLogFromDB", "log delay to upload because delay config. log", aVar);
                } else {
                    StringBuilder sb = (StringBuilder) map2.get(aVar.aD);
                    if (sb == null) {
                        sb = new StringBuilder();
                        map2.put(aVar.aD, sb);
                    } else {
                        sb.append((char) 1);
                        length++;
                    }
                    String content = list.get(i).getContent();
                    sb.append(content);
                    length += content.length();
                }
            }
            if (listA != null) {
                list.removeAll(listA);
            }
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((com.alibaba.analytics.core.model.a) arrayList.get(i2)).priority = "2";
                }
                com.alibaba.analytics.core.f.d.a().updateLogPriority(arrayList);
            }
            map = new HashMap();
            this.C = length;
            for (String str : map2.keySet()) {
                map.put(str, ((StringBuilder) map2.get(str)).toString());
            }
            if (list.size() > 0) {
                this.f663a = this.C / list.size();
            }
            com.alibaba.analytics.a.j.d("UploadLogFromDB", "averagePackageSize", Float.valueOf(this.f663a), "mUploadByteSize", Integer.valueOf(this.C), "count", Integer.valueOf(list.size()));
        }
        return map;
    }

    private List<com.alibaba.analytics.core.model.a> a(List<com.alibaba.analytics.core.model.a> list, com.alibaba.analytics.core.model.a aVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(aVar);
        return list;
    }

    private int a(Boolean bool, long j) {
        if (j < 0) {
            return this.A;
        }
        float f = this.C / j;
        if (!bool.booleanValue()) {
            this.A /= 2;
            this.B++;
        } else {
            if (j > 45000) {
                return this.A;
            }
            this.A = (int) ((((double) (f * 45000.0f)) / ((double) this.f663a)) - ((double) this.B));
        }
        int i = this.A;
        if (i < 1) {
            this.A = 1;
            this.B = 0;
        } else if (i > 350) {
            this.A = 350;
        }
        com.alibaba.analytics.a.j.d("UploadLogFromDB", "winsize", Integer.valueOf(this.A));
        return this.A;
    }
}
