package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class hb implements md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f27361a;
    private final a b = new a();

    public class a implements mc {
        private a() {
        }

        @Override // com.beizi.fusion.mc
        public void a(ConfigResponseModel configResponseModel, g.a aVar, boolean z) {
            if (g.a.EXPIRED != aVar) {
                hb.this.a(configResponseModel, aVar);
            }
        }
    }

    public hb(Context context) {
        this.f27361a = context.getApplicationContext();
    }

    @Override // com.beizi.fusion.md
    public final void a() {
        g gVar = (g) h.a().b(this.f27361a);
        if (gVar != null) {
            gVar.a(this.b);
        }
    }

    public abstract void a(ConfigResponseModel configResponseModel, g.a aVar);
}
