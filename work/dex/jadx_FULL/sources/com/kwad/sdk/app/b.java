package com.kwad.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class b {
    private static final Map<String, String> aIQ = new HashMap();
    private final AtomicBoolean SW;
    private final AtomicBoolean aIR;
    private final AtomicBoolean aIS;
    private final AtomicBoolean aIT;
    private final List<String> aIU;
    private final List<String> aIV;
    private final d aIW;
    private final BroadcastReceiver aIX;
    private Context mContext;
    private final List<com.kwad.sdk.app.a> mListeners;

    public static class a {
        private static final b aJa = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Context context, @NonNull String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        G(context, str);
        dh(str);
        E(context, str);
    }

    private void E(Context context, String str) {
        com.kwad.sdk.core.c.b.LW();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            F(context, str);
            return;
        }
        this.aIU.add(str);
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.aIU.size() > 0) {
                    for (int i = 0; i < b.this.aIU.size(); i++) {
                        b.F(b.this.mContext, (String) b.this.aIU.get(i));
                    }
                    b.this.aIU.clear();
                }
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Context context, @NonNull String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !t.UK()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.e(context, str), 1);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static void G(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                aIQ.put("com.tencent.mm", n.S(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                aIQ.put("com.kuaishou.nebula", n.S(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                aIQ.put("com.smile.gifmaker", n.S(context, "com.smile.gifmaker"));
                break;
        }
    }

    public static b HO() {
        return a.aJa;
    }

    private void HP() {
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.2
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.HT();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.HS();
                    b.this.HU();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        });
    }

    private void HQ() {
        if (this.aIT.get()) {
            return;
        }
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(this.aIW);
        this.aIT.set(true);
    }

    private void HR() {
        if (this.aIT.get()) {
            com.kwad.sdk.core.c.b.LW();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.aIW);
            this.aIT.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HS() {
        Context contextUd = ServiceProvider.Ud();
        bx(contextUd);
        Iterator<AdTemplate> it = ((f) ServiceProvider.get(f.class)).FA().iterator();
        while (it.hasNext()) {
            AdInfo adInfoEO = e.eO(it.next());
            int iBH = com.kwad.sdk.core.response.helper.a.bH(adInfoEO);
            String strAE = com.kwad.sdk.core.response.helper.a.aE(adInfoEO);
            if (iBH != 12) {
                if (au.ax(contextUd, strAE)) {
                    D(contextUd, strAE);
                }
            } else if (!au.ax(contextUd, strAE)) {
                de(strAE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HT() {
        if (this.SW.get()) {
            ServiceProvider.Ud().unregisterReceiver(this.aIX);
            this.SW.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU() {
        if (this.SW.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.Ud().registerReceiver(this.aIX, intentFilter);
        this.SW.set(true);
    }

    private synchronized void bw(Context context) {
        if (this.aIR.get()) {
            return;
        }
        G(context, "com.smile.gifmaker");
        G(context, "com.kuaishou.nebula");
        G(context, "com.tencent.mm");
        this.aIR.set(true);
    }

    private void bx(Context context) {
        if (this.aIR.get()) {
            for (String str : aIQ.keySet()) {
                String str2 = aIQ.get(str);
                String strS = n.S(context, str);
                if (!TextUtils.isEmpty(strS) && !TextUtils.equals(str2, strS)) {
                    D(context, str);
                } else if (TextUtils.isEmpty(strS) && !TextUtils.isEmpty(str2)) {
                    de(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(@NonNull String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        dj(str);
        di(str);
        df(str);
    }

    private void df(String str) {
        com.kwad.sdk.core.c.b.LW();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            dg(str);
            return;
        }
        this.aIV.add(str);
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.app.b.5
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.aIV.size() > 0) {
                    for (int i = 0; i < b.this.aIV.size(); i++) {
                        b.dg((String) b.this.aIV.get(i));
                    }
                    b.this.aIV.clear();
                }
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dg(@NonNull String str) {
        try {
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            if (pVar == null || !t.UK()) {
                return;
            }
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(pVar.D(str), 2);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private void dh(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().V(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void di(String str) {
        Iterator<com.kwad.sdk.app.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().W(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private static void dj(String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                aIQ.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                aIQ.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                aIQ.put("com.smile.gifmaker", "");
                break;
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        bw(context);
        return aIQ.get(str);
    }

    public final synchronized void init() {
        try {
            if (this.aIS.get()) {
                return;
            }
            if (((h) ServiceProvider.get(h.class)).Ge()) {
                HR();
                if (((h) ServiceProvider.get(h.class)).Gd()) {
                    com.kwad.sdk.core.c.b.LW();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        HU();
                    }
                    HP();
                } else {
                    HU();
                }
                this.aIS.set(true);
            }
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    private b() {
        this.aIR = new AtomicBoolean();
        this.aIS = new AtomicBoolean();
        this.SW = new AtomicBoolean();
        this.aIT = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.aIU = new CopyOnWriteArrayList();
        this.aIV = new CopyOnWriteArrayList();
        this.aIW = new d() { // from class: com.kwad.sdk.app.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.HS();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.aIX = new BroadcastReceiver() { // from class: com.kwad.sdk.app.b.3
            Intent aIZ;

            private boolean d(Intent intent) {
                boolean z = TextUtils.equals(this.aIZ.getAction(), intent.getAction()) && this.aIZ.getFlags() == intent.getFlags() && TextUtils.equals(this.aIZ.getDataString(), intent.getDataString());
                this.aIZ = intent;
                return z;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    if (this.aIZ == null) {
                        this.aIZ = intent;
                    } else if (d(intent)) {
                        return;
                    }
                    c.d("AppInstallManager", "onReceive intent: " + intent.toString());
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    b.this.mContext = context;
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        b.this.D(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        b.this.de(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
        };
    }

    public final void b(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        HQ();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.app.a aVar) {
        if (aVar == null) {
            return;
        }
        HQ();
        this.mListeners.add(aVar);
    }
}
