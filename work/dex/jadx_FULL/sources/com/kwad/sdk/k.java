package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class k {

    public static class a implements com.kwad.sdk.service.a.a {
        private a() {
        }

        @Override // com.kwad.sdk.service.a.a
        public final void k(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(context).aJ(adTemplate).au(true));
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b implements com.kwad.sdk.service.a.f {
        private b() {
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.response.helper.g Ai() {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            if (aVar != null) {
                return aVar.Ai();
            }
            return null;
        }

        @Override // com.kwad.sdk.service.a.f
        public final List<AdTemplate> FA() {
            return com.kwad.sdk.core.download.b.Lz().FA();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String FB() {
            return i.EQ();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject FC() {
            return com.kwad.components.core.p.a.vL().o("", "").toJson();
        }

        @Override // com.kwad.sdk.service.a.f
        public final JSONObject FD() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getBodyParams();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Map<String, String> FE() {
            return new com.kwad.sdk.core.report.f((List<com.kwad.sdk.core.report.n>) null).getHeader();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Fu() {
            return o.Gs().Fu();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Fv() {
            return o.Gs().Fv();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Fw() {
            return o.Gs().Fw();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean Fx() {
            return o.Gs().Fx();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String Fy() {
            return com.kwad.sdk.kgeo.a.Fy();
        }

        @Override // com.kwad.sdk.service.a.f
        public final com.kwad.sdk.core.b Fz() {
            return com.kwad.sdk.kgeo.a.RB();
        }

        @Override // com.kwad.sdk.service.a.f
        public final void a(String str, Map<String, String> map, String str2) {
            com.kwad.sdk.core.a.d.a(str, map, str2);
        }

        @Override // com.kwad.sdk.service.a.f
        public final String ax(String str) {
            return com.kwad.sdk.core.a.d.ax(str);
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean bn(AdTemplate adTemplate) {
            com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            return aVar != null && aVar.Ah();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getApiVersion() {
            return o.Gs().getApiVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final int getApiVersionCode() {
            return o.Gs().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getAppName() {
            return ServiceProvider.getAppName();
        }

        @Override // com.kwad.sdk.service.a.f
        public final Context getContext() {
            return ServiceProvider.getContext();
        }

        @Override // com.kwad.sdk.service.a.f
        public final String getSDKVersion() {
            o.Gs();
            return o.getSDKVersion();
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean tr() {
            com.kwad.components.core.offline.a.a.a aVar = (com.kwad.components.core.offline.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.a.a.class);
            if (aVar != null) {
                return aVar.tr();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean tt() {
            com.kwad.components.core.offline.a.b.a aVar = (com.kwad.components.core.offline.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.b.a.class);
            if (aVar != null) {
                return aVar.tt();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.a.f
        public final boolean tu() {
            com.kwad.components.core.offline.a.c.a aVar = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
            if (aVar != null) {
                return aVar.tu();
            }
            return false;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class c implements com.kwad.sdk.service.a.h {
        private c() {
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Dv() {
            return com.kwad.sdk.core.config.e.Dv();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FF() {
            return com.kwad.sdk.core.config.e.FF();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FG() {
            return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aOe);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FH() {
            return com.kwad.sdk.core.config.e.FH();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FI() {
            return com.kwad.sdk.core.config.e.FI();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String FJ() {
            return com.kwad.sdk.core.config.e.FJ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String FK() {
            return com.kwad.sdk.core.config.e.FK();
        }

        @Override // com.kwad.sdk.service.a.h
        public final List<String> FL() {
            return com.kwad.sdk.core.config.e.FL();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FM() {
            return com.kwad.sdk.core.config.e.FM();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FN() {
            return com.kwad.sdk.core.config.e.FN();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FO() {
            return com.kwad.sdk.core.config.e.FO();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FP() {
            return com.kwad.sdk.core.config.e.JX();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FQ() {
            return com.kwad.sdk.core.config.e.FQ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FR() {
            return com.kwad.sdk.core.config.e.FR();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int FS() {
            return com.kwad.sdk.core.config.e.FS();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int FT() {
            return com.kwad.sdk.core.config.e.FT();
        }

        @Override // com.kwad.sdk.service.a.h
        public final double FU() {
            return com.kwad.sdk.core.config.e.FU();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FV() {
            return com.kwad.sdk.core.config.e.FV();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FW() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPM);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FX() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPN);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FY() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPO);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean FZ() {
            return com.kwad.sdk.core.config.e.FZ();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Ga() {
            return com.kwad.sdk.core.config.e.Ga();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Gb() {
            return com.kwad.sdk.core.config.e.Gb();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Gc() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPW);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Gd() {
            return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQa);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Ge() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aQu);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Gf() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aOr);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Gg() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aOs);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String Gh() {
            return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aQg);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Gi() {
            return com.kwad.sdk.core.config.c.aQm.getValue().booleanValue();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Gj() {
            return com.kwad.sdk.core.config.c.aQn.getValue().intValue();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean Gk() {
            return com.kwad.sdk.core.config.e.Gk();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Gl() {
            return com.kwad.sdk.core.config.e.Gl();
        }

        @Override // com.kwad.sdk.service.a.h
        public final int Gm() {
            return com.kwad.sdk.core.config.e.Gm();
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean ao(long j) {
            return com.kwad.sdk.core.config.e.ao(j);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int bf(Context context) {
            return com.kwad.sdk.core.config.item.c.bO(context);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean cP(String str) {
            return com.kwad.sdk.core.config.a.cP(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int cQ(String str) {
            return com.kwad.sdk.core.config.e.cQ(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final int cR(String str) {
            return com.kwad.sdk.core.config.e.cR(str);
        }

        @Override // com.kwad.sdk.service.a.h
        public final boolean enableInflaterOptimize() {
            return com.kwad.sdk.core.config.e.enableInflaterOptimize();
        }

        @Override // com.kwad.sdk.service.a.h
        public final <T> T getAppConfigData(T t, com.kwad.sdk.g.b<JSONObject, T> bVar) {
            return (T) com.kwad.sdk.core.config.e.JS().getAppConfigData(null, bVar);
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getAppId() {
            return ServiceProvider.getAppId();
        }

        @Override // com.kwad.sdk.service.a.h
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.e.getUserAgent();
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    public static void Fo() {
        byte b2 = 0;
        ServiceProvider.put(com.kwad.sdk.service.a.f.class, new b(b2));
        ServiceProvider.put(com.kwad.sdk.service.a.h.class, new c(b2));
        ServiceProvider.put(com.kwad.sdk.service.a.e.class, new com.kwad.sdk.service.a.e() { // from class: com.kwad.sdk.k.1
            @Override // com.kwad.sdk.service.a.e
            public final void J(String str, String str2) {
                com.kwad.components.core.d.a.j(str, str2);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.c cVar) {
                com.kwad.components.core.d.a.a(new com.kwad.components.core.d.a.b() { // from class: com.kwad.sdk.k.1.1
                    @Override // com.kwad.components.core.d.a.b
                    public final String getKey() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.components.core.d.a.b
                    public final JSONObject getValue() {
                        com.kwad.sdk.service.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            return cVar2.getValue();
                        }
                        return null;
                    }
                });
            }

            @Override // com.kwad.sdk.service.a.e
            public final void gatherException(Throwable th) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
            }

            @Override // com.kwad.sdk.service.a.e
            public final void a(final com.kwad.sdk.service.a.g gVar) {
                com.kwad.components.core.d.a.a(new com.kwad.components.core.d.a.c() { // from class: com.kwad.sdk.k.1.2
                    @Override // com.kwad.components.core.d.a.c
                    public final void onCrashOccur(int i, String str) {
                        com.kwad.sdk.service.a.g gVar2 = gVar;
                        if (gVar2 != null) {
                            gVar2.p(i, str);
                        }
                    }
                });
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.d.class, new com.kwad.sdk.service.a.d() { // from class: com.kwad.sdk.k.2
            @Override // com.kwad.sdk.service.a.d
            public final void a(boolean z, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.b.a.Lx().eq(str);
            }

            @Override // com.kwad.sdk.service.a.d
            public final File cO(String str) {
                return com.kwad.sdk.core.diskcache.b.a.Lx().cO(str);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.j.class, new com.kwad.sdk.service.a.j() { // from class: com.kwad.sdk.k.3
            @Override // com.kwad.sdk.service.a.j
            public final boolean wg() {
                com.kwad.components.core.q.b.wf();
                return com.kwad.components.core.q.b.wg();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int wh() {
                com.kwad.components.core.q.b.wf();
                return com.kwad.components.core.q.b.wh();
            }

            @Override // com.kwad.sdk.service.a.j
            public final int wi() {
                return com.kwad.components.core.q.b.wf().wi();
            }

            @Override // com.kwad.sdk.service.a.j
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.q.b.wf();
                return com.kwad.components.core.q.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.network.k.class, new com.kwad.sdk.core.network.k() { // from class: com.kwad.sdk.k.4
            @Override // com.kwad.sdk.core.network.k
            public final com.kwad.sdk.core.b Fp() {
                return com.kwad.components.core.request.model.b.we();
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.j jVar) {
                com.kwad.sdk.commercial.c.b(jVar);
            }

            @Override // com.kwad.sdk.core.network.k
            public final void a(com.kwad.sdk.core.network.i iVar) {
                com.kwad.sdk.commercial.c.b(iVar);
            }
        });
        ImageLoaderProxy imageLoaderProxy = ImageLoaderProxy.INSTANCE;
        ServiceProvider.put(com.kwad.sdk.service.a.i.class, imageLoaderProxy);
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPA);
        if (iA > 0) {
            imageLoaderProxy.setCacheSize(iA);
        }
        ServiceProvider.put(com.kwad.sdk.service.a.b.class, new com.kwad.sdk.service.a.b() { // from class: com.kwad.sdk.k.5
            @Override // com.kwad.sdk.service.a.b
            public final void Fq() {
                com.kwad.components.core.p.a.vL().aL(ServiceProvider.getContext());
            }

            @Override // com.kwad.sdk.service.a.b
            public final void K(String str, String str2) {
                com.kwad.sdk.core.d.c.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void bm(AdTemplate adTemplate) {
                com.kwad.components.core.p.a.vL().j(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.a.b
            public final void e(@NonNull JSONObject jSONObject, int i) {
                com.kwad.components.core.p.a.vL().e(jSONObject, i);
            }
        });
        ServiceProvider.put(s.class, new s() { // from class: com.kwad.sdk.k.6
            @Override // com.kwad.sdk.core.report.s
            public final int Af() {
                com.kwad.components.a.a.a aVar = (com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                if (aVar != null) {
                    return aVar.Af();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.s
            public final int Fr() {
                return com.kwad.sdk.core.config.e.Fr();
            }

            @Override // com.kwad.sdk.core.report.s
            public final boolean an(long j) {
                com.kwad.sdk.core.config.item.q qVar = com.kwad.sdk.core.config.c.aNR;
                return com.kwad.sdk.core.config.item.q.an(j);
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.video.a.f.class, new com.kwad.sdk.core.video.a.f() { // from class: com.kwad.sdk.k.7
            @Override // com.kwad.sdk.core.video.a.f
            public final boolean Ag() {
                return ((com.kwad.components.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class)).Ag();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean Fs() {
                return com.kwad.sdk.core.config.e.Fs();
            }

            @Override // com.kwad.sdk.core.video.a.f
            public final boolean Ft() {
                return com.kwad.sdk.core.config.e.Ft();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.b.b.class, new com.kwad.sdk.utils.b.b() { // from class: com.kwad.sdk.k.8
            @Override // com.kwad.sdk.utils.b.b
            public final void a(com.kwad.sdk.utils.b.a aVar) {
                if (aVar == null) {
                    return;
                }
                com.kwad.sdk.commercial.c.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.a.a.class, new a(b2));
    }
}
