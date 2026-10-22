package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.Analyse2ConfigModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.crash.Crash2ConfigModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k {
    private static volatile k d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27455a;
    private final mc b = new a();
    private final g c;

    public class a implements mc {
        private a() {
        }

        @Override // com.beizi.fusion.mc
        public void a(ConfigResponseModel configResponseModel, g.a aVar, boolean z) {
            g gVar;
            Crash2ConfigModel crash;
            if (configResponseModel == null || g.a.EXPIRED.equals(aVar) || (gVar = k.this.c) == null) {
                return;
            }
            v vVarA = gVar.a();
            if (s.a(vVarA != null ? vVarA.p() : null, "forbid_collect_crash", false)) {
                k.this.c.b(this);
                return;
            }
            Analyse2ConfigModel analyse2ConfigModel = configResponseModel.getAnalyse2ConfigModel();
            boolean zIsClose = true;
            if (analyse2ConfigModel != null && (crash = analyse2ConfigModel.getCrash()) != null) {
                zIsClose = true ^ crash.isClose();
            }
            if (zIsClose) {
                new j(k.this.f27455a).a();
                k.this.c.b(this);
            }
        }
    }

    private k(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f27455a = applicationContext;
        this.c = (g) h.a().b(applicationContext);
    }

    public static k a(Context context) {
        if (d == null) {
            synchronized (k.class) {
                if (d == null) {
                    d = new k(context);
                }
            }
        }
        return d;
    }

    public void a() {
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(this.b);
        }
    }
}
