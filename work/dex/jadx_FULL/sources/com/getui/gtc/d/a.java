package com.getui.gtc.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.api.GtcIdCallback;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.c.b;
import com.getui.gtc.g.c;
import com.getui.gtc.server.ServerManager;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c f30291a;
    private final Handler b;

    /* JADX INFO: renamed from: com.getui.gtc.d.a$a, reason: collision with other inner class name */
    public static class C0648a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f30297a = new a(0);
    }

    private a() {
        HandlerThread handlerThread = new HandlerThread("Gtc HandlerThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.b = handler;
        this.f30291a = c.a.f30372a;
        b.a();
        com.getui.gtc.i.d.b unused = com.getui.gtc.i.d.b.C0659b.f30388a;
        com.getui.gtc.a.a.a();
        handler.post(new Runnable() { // from class: com.getui.gtc.d.a.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    SdkInfo.Builder builderPsUrl = new SdkInfo.Builder().moduleName("GTC").version(BuildConfig.VERSION_NAME).appid(b.f30289a).cid(b.d).psUrl(String.format("%s/api.php?format=json&t=1", ServerManager.getServer("gtc.cs")));
                    try {
                        Class.forName("com.getui.gtc.extension.distribution.gbd.stub.PushExtension");
                        builderPsUrl.addStub("com.getui.gtc.extension.distribution.gbd.stub.PushExtension", false);
                    } catch (ClassNotFoundException unused2) {
                        com.getui.gtc.i.c.a.a("no local gbd");
                    }
                    try {
                        Class.forName("com.getui.gtc.extension.distribution.gws.stub.PushExtension");
                        builderPsUrl.addStub("com.getui.gtc.extension.distribution.gws.stub.PushExtension", false);
                    } catch (ClassNotFoundException unused3) {
                        com.getui.gtc.i.c.a.a("no local gws");
                    }
                    a.this.f30291a.a(builderPsUrl.build());
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
        });
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public final String a(final GtcIdCallback gtcIdCallback) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.a(gtcIdCallback);
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.c(e);
                }
            }
        });
        com.getui.gtc.i.c.a.a("gtcid is " + b.d);
        return b.d;
    }

    public final void a(final int i) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.getui.gtc.a.a.a(i);
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
        });
    }

    public final void a(final SdkInfo sdkInfo) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.f30291a.a(sdkInfo);
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
        });
    }

    public final void a(final int[] iArr) {
        this.b.post(new Runnable() { // from class: com.getui.gtc.d.a.5
            @Override // java.lang.Runnable
            public final void run() {
                com.getui.gtc.entity.a aVarA;
                com.getui.gtc.entity.a.C0657a c0657aB;
                try {
                    if (iArr == null) {
                        return;
                    }
                    com.getui.gtc.i.c.a.a("remove gtcFile id: " + Arrays.toString(iArr));
                    for (int i : iArr) {
                        Map<String, Map<String, String>> mapA = com.getui.gtc.dyc.b.a.a(GtcProvider.context());
                        if (mapA == null) {
                            return;
                        }
                        for (Map.Entry<String, Map<String, String>> entry : mapA.entrySet()) {
                            Map<String, String> value = entry.getValue();
                            if (value != null && (aVarA = com.getui.gtc.entity.a.a(value)) != null && (c0657aB = aVarA.b(i)) != null) {
                                com.getui.gtc.i.c.a.a("found gtcFile id: " + i + ", remove it");
                                a.this.f30291a.a(c0657aB.c);
                                aVarA.f30354a.remove(i);
                                value.put("ext_infos", aVarA.a());
                                com.getui.gtc.dyc.b.a.a(GtcProvider.context(), entry.getKey(), value);
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
        });
    }
}
