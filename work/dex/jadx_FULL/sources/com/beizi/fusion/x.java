package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.basic.ADNConfigResponse;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class x extends za implements ia {
    private final g b;
    private v c;
    private final d d;
    private final c e;
    private final lc f;
    private final fb g;

    public class a implements lc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f27995a;
        private boolean b;

        private a() {
            this.f27995a = new C0331a(false);
            this.b = false;
        }

        @Override // com.beizi.fusion.lc
        public void a() {
            if (this.b || x.this.g == null) {
                return;
            }
            om.a("ASNPInitRouter", "请求强制更新Global配置...");
            this.b = true;
            x.this.g.e(this.f27995a);
        }

        /* JADX INFO: renamed from: com.beizi.fusion.x$a$a, reason: collision with other inner class name */
        public class C0331a extends b {
            public C0331a(boolean z) {
                super(z);
            }

            @Override // com.beizi.fusion.x.b
            public void a(w wVar) {
                a.this.b = false;
                super.a(wVar);
            }

            @Override // com.beizi.fusion.x.b
            public void a() {
                a.this.b = false;
                super.a();
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f27998a;
        private final f b;

        /* JADX WARN: Multi-variable type inference failed */
        private c() {
            this.f27998a = new b(true);
            this.b = new f(new e(new b(false)));
        }

        private boolean a() {
            g gVar = x.this.b;
            if (gVar != null) {
                return gVar.f();
            }
            return false;
        }

        private void b() {
            this.b.d();
        }

        private void c() {
            this.f27998a.run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.c(x.this.f28103a)) {
                c();
                return;
            }
            b();
            if (a()) {
                x.this.b();
                return;
            }
            x xVar = x.this;
            if (xVar.b == null) {
                xVar.a(w.ERROR_UNEXPECTED);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!x.this.b.d()) {
                c();
                return;
            }
            if (x.this.b.b(jCurrentTimeMillis)) {
                c();
            } else {
                if (!x.this.b.c(jCurrentTimeMillis)) {
                    x.this.b();
                    return;
                }
                this.f27998a.c();
                c();
                x.this.b();
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private sc f27999a;

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(sc scVar) {
            this.f27999a = scVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            sc scVar = this.f27999a;
            if (scVar != null) {
                scVar.a();
            }
        }

        public void a() {
        }

        public void a(w wVar) {
            sc scVar = this.f27999a;
            if (scVar != null) {
                scVar.a(wVar);
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f28000a;

        private e(b bVar) {
            this.f28000a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((g) h.a().b(x.this.f28103a)).a(System.currentTimeMillis()) != g.a.VALID) {
                if (b0.a().a(x.this.f28103a) || b0.a().b(x.this.f28103a)) {
                    this.f28000a.run();
                }
            }
        }
    }

    public class f extends be {
        private final mc d;

        private f(Runnable runnable) {
            super(runnable);
            this.d = new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            g gVar = x.this.b;
            if (gVar != null) {
                gVar.a(this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConfigResponseModel configResponseModel) {
            if (configResponseModel == null || configResponseModel.getUpdate() == null) {
                return;
            }
            int checkInterval = configResponseModel.getUpdate().getCheckInterval();
            if (checkInterval <= 0) {
                a(60000L, 60000L, TimeUnit.MILLISECONDS);
            } else {
                long j = checkInterval;
                a(j, j, TimeUnit.MILLISECONDS);
            }
        }

        public class a implements mc {
            public a() {
            }

            @Override // com.beizi.fusion.mc
            public void a(ConfigResponseModel configResponseModel, g.a aVar, boolean z) {
                f.this.c();
                f.this.a(configResponseModel);
                if (z) {
                    p0.b(x.this.f28103a, p0.b(), "asnpCfgPattern", "101,1001");
                    String strA = a(configResponseModel, "101,1001");
                    if (TextUtils.isEmpty(strA)) {
                        return;
                    }
                    p0.b(x.this.f28103a, p0.b(), "asnpConfigV3", strA);
                }
            }

            private String a(ConfigResponseModel configResponseModel, String str) {
                return configResponseModel != null ? ((id) dh.a().b(x.this.f28103a)).b(configResponseModel.toJsonString(), str, id.a.STEP_BY_STEP, false) : "";
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(Context context) {
        super(context);
        this.b = (g) h.a().b(this.f28103a);
        this.e = new c();
        this.d = new d();
        this.f = new a();
        this.g = (fb) cn.a().b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        this.d.b();
    }

    private void c() {
        this.d.a();
    }

    private void d() {
        this.b.a(this.f);
    }

    @Override // com.beizi.fusion.ia
    public void a(sc scVar) {
        this.d.a(scVar);
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qb f27996a;
        private boolean b;

        public class a extends qb {
            final /* synthetic */ x c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, x xVar) {
                super(j);
                this.c = xVar;
            }

            @Override // com.beizi.fusion.qb
            public void b() {
                b.this.a(w.ERROR_CONFIG_REQUEST_TIMEOUT);
                b.this.f27996a.a();
            }
        }

        private b(boolean z) {
            this.b = z;
            this.f27996a = new a(10000L, x.this);
        }

        private String b() {
            v vVar = x.this.c;
            return f3.c(((vVar == null || !vVar.z()) ? "aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FwaS92My9jZmcvZ2V0Q29uZmln" : "aHR0cHM6Ly9zZGstYXBpLmFkbi1wbHVzLmNvbS5jbi9hcGkvdjMvY2ZnL2dldENvbmZpZw==").getBytes());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.b = false;
        }

        public void a() {
            qb qbVar = this.f27996a;
            if (qbVar != null) {
                qbVar.a();
            }
            if (this.b) {
                x.this.b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27996a.c();
            x.this.a(no.a(a(x.this.b.a(false)), x.this.c.z()), new x5(x.this.f28103a, x.this.c.e()), new C0332b());
        }

        public void a(w wVar) {
            qb qbVar = this.f27996a;
            if (qbVar != null) {
                qbVar.a();
            }
            if (this.b) {
                x.this.a(wVar);
            }
        }

        /* JADX INFO: renamed from: com.beizi.fusion.x$b$b, reason: collision with other inner class name */
        public class C0332b implements sa {
            private C0332b() {
            }

            @Override // com.beizi.fusion.sa
            public void a(int i, InputStream inputStream) {
                try {
                    w[] wVarArr = new w[1];
                    ConfigResponseModel configResponseModelA = a(new String(((id) dh.a().b(x.this.f28103a)).a(zd.b(inputStream), "101,1001", id.a.NOT_APPEND, true)), wVarArr);
                    if (configResponseModelA != null) {
                        x.this.b.a(configResponseModelA, true, false);
                        b.this.a();
                        return;
                    }
                    b bVar = b.this;
                    w wVar = wVarArr[0];
                    if (wVar == null) {
                        wVar = w.ERROR_CONFIG_PARSE_FAIL;
                    }
                    bVar.a(wVar);
                } catch (IOException e) {
                    om.a(e);
                    b.this.a(w.ERROR_CONFIG_RESPONSE_ERROR);
                }
            }

            @Override // com.beizi.fusion.sa
            public void a(nc ncVar) {
                om.b("ASNPInitRouter", "服务器请求失败 " + ncVar.b() + " " + ncVar.a());
                b.this.a(w.ERROR_CONFIG_RESPONSE_ERROR);
            }

            private ConfigResponseModel a(String str, w[] wVarArr) {
                if (!TextUtils.isEmpty(str)) {
                    ADNConfigResponse aDNConfigResponse = new ADNConfigResponse(mg.c(str));
                    if (aDNConfigResponse.isResponseValid()) {
                        ConfigResponseModel data = aDNConfigResponse.getData();
                        if (!data.hasParseException()) {
                            return data;
                        }
                        if (wVarArr != null && wVarArr.length > 0) {
                            wVarArr[0] = w.ERROR_CONFIG_PARSE_FAIL;
                        }
                        return null;
                    }
                }
                if (wVarArr != null && wVarArr.length > 0) {
                    wVarArr[0] = w.ERROR_CONFIG_RESPONSE_ERROR;
                }
                return null;
            }
        }

        private String a(ConfigResponseModel configResponseModel) {
            if (configResponseModel != null && configResponseModel.getRequestUrl() != null) {
                String configURL = configResponseModel.getRequestUrl().getConfigURL();
                if (!TextUtils.isEmpty(configURL)) {
                    return configURL;
                }
            }
            return b();
        }
    }

    @Override // com.beizi.fusion.ia
    public void a(v vVar) {
        this.c = vVar;
        d();
        a();
    }

    private void a() {
        fb fbVar = this.g;
        if (fbVar != null) {
            fbVar.e(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar) {
        this.d.a(wVar);
    }
}
