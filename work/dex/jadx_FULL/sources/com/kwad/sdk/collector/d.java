package com.kwad.sdk.collector;

import android.content.Context;
import android.util.Log;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.AbiUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);

    public interface a {
        void dk(String str);

        void onLoaded();
    }

    public static boolean HZ() {
        return ISLOADED.get();
    }

    public static void a(Context context, final a aVar) {
        String str;
        String str2;
        String str3;
        if (ISLOADED.get()) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            map.put("libkwappstatus.so", "40eb0d1d346cab7ced4d02a3065b7a94");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArm64v8aRelease-3.3.14.apk";
            str2 = "kwappstatus-v8a";
            str3 = "c66bf3f78bd997bbd5b6e5038a23dff6";
        } else {
            map.put("libkwappstatus.so", "b60d5c17b0cc4aa03e8180bc5cedaf3d");
            str = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/ks_so-appStatusArmeabiv7aRelease-3.3.14.apk";
            str2 = "kwappstatus-v7a";
            str3 = "b9c0eff152a62bd5062844255107f3e0";
        }
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.aFs = com.kwad.sdk.core.network.idc.a.Mo().eQ(str);
        bVar.enable = true;
        bVar.aFr = str2;
        bVar.version = "3.1";
        bVar.aFv = false;
        bVar.aFu = str3;
        bVar.aFx = map;
        com.kwad.library.solder.a.a.a(context, bVar, new com.kwad.library.solder.lib.ext.b.c() { // from class: com.kwad.sdk.collector.d.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.dk("load canceled");
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, com.kwad.library.solder.lib.h hVar) {
                super.a(cVar, hVar);
                d.a(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                super.a(cVar, pluginError);
                if (aVar != null) {
                    aVar.dk(pluginError == null ? "load error" : pluginError.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        try {
            System.loadLibrary("kwappstatus");
            ISLOADED.set(true);
            if (aVar != null) {
                aVar.onLoaded();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.dk(Log.getStackTraceString(th));
            }
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            if (th instanceof UnsatisfiedLinkError) {
                return;
            }
            com.kwad.sdk.service.d.gatherException(th);
        }
    }
}
