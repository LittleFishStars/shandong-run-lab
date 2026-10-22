package com.efs.sdk.net;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.b;
import com.efs.sdk.net.a.c;
import com.efs.sdk.net.a.d;
import com.zj.adlib.u15;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class OkHttpListener extends EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f29904a = new AtomicInteger(0);
    private String b;
    private boolean c;
    private List d = new ArrayList();

    private void a(String str) {
        Map<String, Long> map;
        try {
            d dVarC = a.a().c(this.b);
            if (dVarC == null || (map = dVarC.E) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        try {
            final d dVarC = a.a().c(this.b);
            final c cVarA = a.a().a(this.b);
            if (dVarC == null || cVarA == null) {
                return;
            }
            Map<String, Long> map = dVarC.E;
            Map<String, Long> map2 = dVarC.F;
            Log.i("NetTrace-Listener", cVarA.toString());
            if (TextUtils.isEmpty(dVarC.B)) {
                Log.d("NetTrace-Listener", "url is null.");
                return;
            }
            final EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
            if (map.containsKey(d.d)) {
                efsJSONLog.put("wd_dns", map.get(d.d));
            }
            if (map.containsKey(d.e)) {
                efsJSONLog.put("wd_dnstm", map.get(d.e));
            }
            if (map2.containsKey(d.t)) {
                efsJSONLog.put("wl_dns", map2.get(d.t));
            }
            if (map.containsKey(d.f)) {
                efsJSONLog.put("wd_tcp", map.get(d.f));
            }
            if (map.containsKey(d.i)) {
                efsJSONLog.put("wd_tcptm", map.get(d.i));
            }
            if (map2.containsKey(d.v)) {
                efsJSONLog.put("wl_tcp", map2.get(d.v));
            }
            if (map.containsKey(d.g)) {
                efsJSONLog.put("wd_ssl", map.get(d.g));
            }
            if (map.containsKey(d.h)) {
                efsJSONLog.put("wd_ssltm", map.get(d.h));
            }
            if (map2.containsKey(d.u)) {
                efsJSONLog.put("wl_ssl", map2.get(d.u));
            }
            if (map.containsKey(d.k)) {
                efsJSONLog.put("wd_ds", map.get(d.k));
            }
            if (map.containsKey(d.n)) {
                efsJSONLog.put("wd_dstm", map.get(d.n));
            }
            if (map2.containsKey(d.w) && map2.containsKey(d.x)) {
                efsJSONLog.put("wl_ds", Long.valueOf(map2.get(d.w).longValue() + map2.get(d.x).longValue()));
            }
            if (map.containsKey(d.o)) {
                efsJSONLog.put("wd_srt", map.get(d.o));
            }
            if (map.containsKey(d.r)) {
                efsJSONLog.put("wd_srttm", map.get(d.r));
            }
            if (map2.containsKey(d.y) && map2.containsKey(d.z)) {
                efsJSONLog.put("wl_srt", Long.valueOf(map2.get(d.y).longValue() + map2.get(d.z).longValue()));
            }
            String[] strArrSplit = dVarC.B.split("\\?");
            String str = strArrSplit != null ? strArrSplit[0] : null;
            List list = this.d;
            if (list == null || str == null || list.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                efsJSONLog.put("wl_ttfb", 0);
            } else {
                this.d.add(str);
                if (map.containsKey(d.n)) {
                    efsJSONLog.put("wd_ttfb", map.get(d.n));
                } else if (map.containsKey(d.l)) {
                    efsJSONLog.put("wd_ttfb", map.get(d.l));
                }
                if (map.containsKey(d.o)) {
                    efsJSONLog.put("wd_ttfbtm", map.get(d.o));
                }
                if (map.containsKey(d.o)) {
                    if (map.containsKey(d.n)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(d.o).longValue() - map.get(d.n).longValue()));
                    } else if (map.containsKey(d.l)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(d.o).longValue() - map.get(d.l).longValue()));
                    }
                }
            }
            if (map.containsKey(d.f29917a)) {
                efsJSONLog.put("wd_rt", map.get(d.f29917a));
            }
            if (map.containsKey(d.b)) {
                efsJSONLog.put("wd_rttm", map.get(d.b));
            }
            if (map2.containsKey(d.s)) {
                efsJSONLog.put("wl_rt", map2.get(d.s));
            }
            efsJSONLog.put("wk_res", cVarA.c);
            efsJSONLog.put("wk_res_ori", dVarC.B);
            efsJSONLog.put("wk_ip", dVarC.C);
            efsJSONLog.put("wk_method", cVarA.e);
            efsJSONLog.put("wk_rc", Integer.valueOf(cVarA.i));
            efsJSONLog.put("wl_up", Long.valueOf(cVarA.g));
            efsJSONLog.put("wl_down", Long.valueOf(cVarA.m));
            efsJSONLog.put("wl_total", Long.valueOf(cVarA.g + cVarA.m));
            b.a(new Runnable() { // from class: com.efs.sdk.net.OkHttpListener.2
                @Override // java.lang.Runnable
                public final void run() {
                    Map<String, String> map3;
                    Map<String, String> map4;
                    try {
                        try {
                            String strA = com.efs.sdk.net.b.a.a((dVarC.E.containsKey(d.f29917a) ? String.valueOf(dVarC.E.get(d.f29917a)) : "") + ControllerCenter.getGlobalEnvStruct().getAppid() + ControllerCenter.getGlobalEnvStruct().getSecret());
                            if (NetManager.getNetConfigManager().getNetRequestBodyCollectState() && !TextUtils.isEmpty(cVarA.h)) {
                                efsJSONLog.put("wk_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(cVarA.h.getBytes(), strA.getBytes())));
                            }
                            if (NetManager.getNetConfigManager().getNetResponseBodyCollectState() && !TextUtils.isEmpty(cVarA.k)) {
                                efsJSONLog.put("wk_res_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(cVarA.k.getBytes(), strA.getBytes())));
                            }
                            if (NetManager.getNetConfigManager().getNetRequestHeaderCollectState() && (map4 = cVarA.f) != null && !map4.isEmpty()) {
                                efsJSONLog.put("wk_req_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new JSONObject(cVarA.f).toString().getBytes(), strA.getBytes())));
                            }
                            if (NetManager.getNetConfigManager().getNetResponseHeaderCollectState() && (map3 = cVarA.l) != null && !map3.isEmpty()) {
                                efsJSONLog.put("wk_res_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new JSONObject(cVarA.l).toString().getBytes(), strA.getBytes())));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        OkHttpListener.a(dVarC, cVarA, efsJSONLog);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
            a.a().d(this.b);
            a.a().b(this.b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static EventListener.Factory get() {
        return new EventListener.Factory() { // from class: com.efs.sdk.net.OkHttpListener.1
            @NotNull
            public final EventListener create(@NotNull Call call) {
                return new OkHttpListener();
            }
        };
    }

    public void callEnd(@NotNull Call call) {
        super.callEnd(call);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(d.b);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void callFailed(@NotNull Call call, @NotNull IOException iOException) {
        super.callFailed(call, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(d.c);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void callStart(@NotNull Call call) {
        super.callStart(call);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.c = true;
            }
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.b = String.valueOf(f29904a.getAndIncrement());
            Log.i("NetTrace-Listener", "requestId is" + this.b);
            a(d.f29917a);
            String string = call.request().url().toString();
            try {
                d dVarC = a.a().c(this.b);
                if (dVarC != null) {
                    dVarC.B = string;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(d.i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol, @NotNull IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(d.j);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(d.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        super.connectionAcquired(call, connection);
        try {
            Log.d("NetTrace-Listener", "connectionAcquired");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            InetAddress inetAddress = connection.socket().getInetAddress();
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                try {
                    d dVarC = a.a().c(this.b);
                    if (dVarC != null) {
                        dVarC.C = hostAddress;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void dnsEnd(@NotNull Call call, @NotNull String str, @NotNull List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(d.e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dnsStart(@NotNull Call call, @NotNull String str) {
        super.dnsStart(call, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(d.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestBodyEnd(@NotNull Call call, long j) {
        super.requestBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            call.request().body();
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(d.n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestBodyStart(@NotNull Call call) {
        super.requestBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(d.m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        super.requestHeadersEnd(call, request);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(d.l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestHeadersStart(@NotNull Call call) {
        super.requestHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(d.k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseBodyEnd(@NotNull Call call, long j) {
        super.responseBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(d.r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseBodyStart(@NotNull Call call) {
        super.responseBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(d.q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        super.responseHeadersEnd(call, response);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(d.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseHeadersStart(@NotNull Call call) {
        super.responseHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(d.o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(d.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void secureConnectStart(@NotNull Call call) {
        super.secureConnectStart(call);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(d.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        try {
            d dVarC = a.a().c(this.b);
            if (dVarC != null) {
                Map<String, Long> map = dVarC.E;
                Map<String, Long> map2 = dVarC.F;
                map2.put(d.s, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f29917a, d.b)));
                map2.put(d.t, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.d, d.e)));
                map2.put(d.u, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.g, d.h)));
                map2.put(d.v, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f, d.i)));
                map2.put(d.w, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.k, d.l)));
                map2.put(d.x, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.m, d.n)));
                map2.put(d.y, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.o, d.p)));
                map2.put(d.z, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.q, d.r)));
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(EfsJSONLog efsJSONLog) {
        try {
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                if (SamplingWhiteListUtil.isHitWL()) {
                    return;
                }
                SharedPreferences sharedPreferences = ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
                String str = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
                if (sharedPreferences != null) {
                    int i = sharedPreferences.getInt(str, 0);
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (editorEdit != null) {
                        editorEdit.putInt(str, i + 1);
                        editorEdit.apply();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String a(Map<String, String> map, boolean z, boolean z2) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!SamplingWhiteListUtil.isHitWL()) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append("|");
            sb.append(NetManager.getNetConfigManager().getExtraRateFlag());
            if (map.size() != 0 && !z && z2) {
                sb.append("|1");
            } else {
                sb.append("|0");
            }
            sb.append("|");
            sb.append(new JSONObject(map).toString());
            return com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(sb.toString().getBytes(), ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01db  */
    /* JADX WARN: Code duplicated, block: B:102:0x01de  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:113:0x0207  */
    /* JADX WARN: Code duplicated, block: B:115:0x020b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x020d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b4 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d5 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0106 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0127  */
    /* JADX WARN: Code duplicated, block: B:47:0x0128 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0130 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0138  */
    /* JADX WARN: Code duplicated, block: B:63:0x015e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0163 A[Catch: all -> 0x0196, TryCatch #2 {all -> 0x0196, blocks: (B:25:0x0098, B:27:0x00a7, B:30:0x00ae, B:32:0x00b4, B:34:0x00c0, B:36:0x00cc, B:38:0x00d5, B:42:0x00e6, B:44:0x011d, B:49:0x0130, B:53:0x013b, B:66:0x0163, B:67:0x0178, B:58:0x0149, B:60:0x0153, B:43:0x0106, B:47:0x0128, B:68:0x017d), top: B:123:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0183  */
    /* JADX WARN: Code duplicated, block: B:71:0x0185  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:97:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d9  */
    /* JADX WARN: Instruction removed from duplicated block: B:43:0x0106, please report this as an issue */
    public static /* synthetic */ void a(d dVar, c cVar, EfsJSONLog efsJSONLog) {
        boolean z;
        boolean zA;
        boolean z2;
        boolean z3;
        int extraDataRate;
        JSONArray jSONArray;
        HashMap map;
        int i;
        JSONObject jSONObjectOptJSONObject;
        boolean z4;
        String strOptString;
        int iOptInt;
        Uri uri;
        int port;
        String str;
        try {
            SharedPreferences sharedPreferences = ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
            String str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
            if (sharedPreferences != null) {
                int i2 = sharedPreferences.getInt(str2, 0);
                if (!SamplingWhiteListUtil.isHitWL() && NetManager.getNetConfigManager().getDayLimit() != -1 && i2 >= NetManager.getNetConfigManager().getDayLimit()) {
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        Map<String, Object> strategyMap = NetManager.getReporter().getStrategyMap();
        boolean zA2 = com.efs.sdk.net.b.a.a(NetManager.getNetConfigManager().getDataRate());
        String strA = "";
        if (strategyMap == null || strategyMap.size() != 2) {
            z = false;
            zA = false;
        } else {
            try {
                zA = com.efs.sdk.net.b.a.a(((Integer) strategyMap.get("rate")).intValue());
                if (!zA2 && !zA) {
                    try {
                        if (!SamplingWhiteListUtil.isHitWL()) {
                            return;
                        }
                        jSONArray = (JSONArray) strategyMap.get("stra");
                        map = new HashMap();
                        if (jSONArray != null) {
                            for (i = 0; i < jSONArray.length(); i++) {
                                jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                                if (TextUtils.isEmpty(dVar.B)) {
                                    z4 = false;
                                } else {
                                    strOptString = jSONObjectOptJSONObject.optString("u");
                                    if (TextUtils.isEmpty(strOptString)) {
                                        z4 = false;
                                    } else {
                                        if (!strOptString.startsWith("^")) {
                                            uri = Uri.parse(dVar.B);
                                            port = uri.getPort();
                                            if (port < 0) {
                                                str = uri.getHost() + uri.getPath();
                                            } else {
                                                str = uri.getHost() + uri.getPath();
                                            }
                                            if (com.efs.sdk.net.b.a.a(str).equalsIgnoreCase(strOptString)) {
                                                iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                                if (iOptInt == -1) {
                                                }
                                            }
                                            z4 = false;
                                        } else if (Pattern.matches(strOptString, dVar.B)) {
                                            iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                            if (iOptInt == -1) {
                                            }
                                        }
                                        z4 = false;
                                    }
                                }
                                if (z4) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(jSONObjectOptJSONObject.optInt("i"));
                                    map.put(sb.toString(), "");
                                }
                            }
                        }
                        if (map.size() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            NetManager.getNetConfigManager().setStrategyHitCurrentProcess(true);
                        }
                        strA = a(map, zA2, zA);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        th.printStackTrace();
                        if (TextUtils.isEmpty(strA)) {
                            z2 = false;
                            strA = a((Map<String, String>) new HashMap(), zA2, false);
                        } else {
                            z2 = false;
                        }
                        efsJSONLog.put("dx", strA);
                        if (SamplingWhiteListUtil.isHitWL()) {
                            a(efsJSONLog);
                            return;
                        }
                        if (z) {
                            if (zA2) {
                            }
                            a(efsJSONLog);
                            return;
                        }
                        if (NetManager.getNetConfigManager().getExtraRateFlag() == 1) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (z3) {
                            if (zA2) {
                                a(efsJSONLog);
                            }
                        } else if (NetManager.getNetConfigManager().isStrategyHitCurrentProcess()) {
                            extraDataRate = NetManager.getNetConfigManager().getExtraDataRate();
                            if (extraDataRate != 0) {
                                z2 = true;
                            }
                            if (z2) {
                                a(efsJSONLog);
                            }
                        }
                    }
                } else {
                    try {
                        jSONArray = (JSONArray) strategyMap.get("stra");
                        map = new HashMap();
                        if (jSONArray != null && jSONArray.length() > 0) {
                            while (i < jSONArray.length()) {
                                jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                                if (TextUtils.isEmpty(dVar.B)) {
                                    strOptString = jSONObjectOptJSONObject.optString("u");
                                    if (TextUtils.isEmpty(strOptString)) {
                                        z4 = false;
                                    } else {
                                        if (!strOptString.startsWith("^")) {
                                            uri = Uri.parse(dVar.B);
                                            port = uri.getPort();
                                            if (port < 0 && port <= 65535) {
                                                str = uri.getHost() + u15.f19942b + port + uri.getPath();
                                            } else {
                                                str = uri.getHost() + uri.getPath();
                                            }
                                            if (com.efs.sdk.net.b.a.a(str).equalsIgnoreCase(strOptString)) {
                                                iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                                if (iOptInt == -1 && iOptInt <= 3) {
                                                    int iOptInt2 = jSONObjectOptJSONObject.optInt("s", -1);
                                                    if (iOptInt2 != 0) {
                                                        if (iOptInt2 == 2 && NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                                                            if (!TextUtils.isEmpty(cVar.h)) {
                                                            }
                                                        }
                                                    }
                                                    z4 = true;
                                                }
                                            }
                                            z4 = false;
                                        } else if (Pattern.matches(strOptString, dVar.B)) {
                                            iOptInt = jSONObjectOptJSONObject.optInt("v", -1);
                                            if (iOptInt == -1) {
                                            }
                                        }
                                        z4 = false;
                                    }
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(jSONObjectOptJSONObject.optInt("i"));
                                    map.put(sb2.toString(), "");
                                }
                            }
                        }
                        if (map.size() != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            try {
                                NetManager.getNetConfigManager().setStrategyHitCurrentProcess(true);
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                            }
                        }
                        strA = a(map, zA2, zA);
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                z = false;
                zA = false;
            }
        }
        if (TextUtils.isEmpty(strA)) {
            z2 = false;
            strA = a((Map<String, String>) new HashMap(), zA2, false);
        } else {
            z2 = false;
        }
        efsJSONLog.put("dx", strA);
        if (SamplingWhiteListUtil.isHitWL()) {
            a(efsJSONLog);
            return;
        }
        if (z) {
            if (!zA2 || zA) {
                a(efsJSONLog);
                return;
            }
            return;
        }
        if (NetManager.getNetConfigManager().getExtraRateFlag() == 1) {
            z3 = true;
        } else {
            z3 = z2;
        }
        if (z3) {
            if (zA2) {
                a(efsJSONLog);
            }
        } else if (NetManager.getNetConfigManager().isStrategyHitCurrentProcess()) {
            extraDataRate = NetManager.getNetConfigManager().getExtraDataRate();
            if (extraDataRate != 0 && (extraDataRate == 100000 || new Random().nextInt(100000) <= extraDataRate)) {
                z2 = true;
            }
            if (z2) {
                a(efsJSONLog);
            }
        }
    }
}
