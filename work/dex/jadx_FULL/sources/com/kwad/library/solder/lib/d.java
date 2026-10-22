package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> aEk = new ConcurrentHashMap<>();
    private final Context mContext;

    public d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aEk.put(str, aVar);
            }
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.dg(7);
        eVar.DX().DO().r(eVar);
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.DX().DO().q(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.dg(0);
        eVar.DX().DO().n(eVar);
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) throws PluginError.LoadError {
        b(eVar);
        com.kwad.library.solder.lib.a.a aVarA = eVar.cH(eVar.Ee()).a(eVar.Ej());
        String strDV = aVarA.DV();
        File file = new File(strDV);
        eVar.Eb();
        com.kwad.library.solder.lib.a.d dVarDX = eVar.DX();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String strEb = eVar.Eb();
        String version = eVar.getVersion();
        com.kwad.library.solder.lib.a.a aVarCy = cy(strEb);
        if (aVarCy != null) {
            a(eVar);
            return aVarCy;
        }
        aVarA.cC(strEb);
        aVarA.cB(version);
        if (dVarDX.DN().a(strEb, version, eVar.Ei())) {
            String strI = dVarDX.DN().I(strEb, version);
            if (y.hG(strI)) {
                aVarA.cD(strI);
                aVarA.q(this.mContext, strI);
                a(strEb, aVarA);
                a(eVar);
                return aVarA;
            }
        }
        String strB = dVarDX.DN().b(aVarA);
        aVarA.cD(strB);
        aVarA.q(this.mContext, strB);
        a(strEb, aVarA);
        if (strDV.endsWith(dVarDX.DK().Eq())) {
            y.delete(strDV);
        }
        a(eVar);
        return aVarA;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a cy(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.aEk.get(str);
        if (aVar == null || aVar.isLoaded()) {
            return aVar;
        }
        return null;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.Eb();
        eVar.cE("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.aEk.get(eVar.Eb());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            eVar.Eb();
            aVar.DV();
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b bVarEj = eVar.Ej();
        if (bVarEj == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", 2006));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> listEk = eVar.Ek();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (listEk != null && !listEk.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : listEk) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.DX().DN().G(eVar.Eb(), aVar3.version);
                }
            }
        }
        if (aVar2 != null) {
            String strI = eVar.DX().DN().I(aVar2.aFr, aVar2.version);
            eVar.cF(strI);
            eVar.cG(strI);
            eVar.dg(2);
            eVar.cB(aVar2.version);
        } else {
            if (!aq.isWifiConnected(this.mContext) && (bVarEj.aFv || (bVarEj.aFw && eVar.Ed() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", 2007));
                return;
            }
            try {
                if (!eVar.DX().DM().k(eVar)) {
                    return;
                }
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, 2006));
                return;
            }
        }
        if (eVar.getState() != 2 && eVar.getState() != 3 && eVar.getState() != 4) {
            b(eVar, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String strEe = eVar.Ee();
        eVar.Eb();
        if (TextUtils.isEmpty(strEe)) {
            b(eVar, new PluginError.LoadError("path not found", 2009));
            return;
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        try {
            com.kwad.library.solder.lib.a.a aVarH = h(eVar);
            eVar.c(aVarH);
            eVar.Eb();
            a(eVar, aVarH);
        } catch (PluginError.InstallError e) {
            e = e;
            b(eVar, e);
        } catch (PluginError.LoadError e2) {
            e = e2;
            b(eVar, e);
        } catch (Throwable th2) {
            a.e("PluginLoaderImpl", "load plugin failed, path = " + strEe, th2);
            b(eVar, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
        }
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.dg(8);
        eVar.DX().DO().a(eVar);
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        eVar.getState();
        eVar.dg(6);
        eVar.q(pluginError);
        eVar.DX().DO().c(eVar, pluginError);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        eVar.getState();
        eVar.dg(5);
        eVar.DX().DO().b(eVar, aVar);
    }
}
