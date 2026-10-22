package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.beta.BetaPlanModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {
    private static volatile f e;
    public static final List f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27258a;
    private final g b;
    private final mc c = new a();
    private final Set d = new HashSet();

    public class a implements mc {
        private a() {
        }

        @Override // com.beizi.fusion.mc
        public void a(ConfigResponseModel configResponseModel, g.a aVar, boolean z) {
            if (configResponseModel == null || !g.a.VALID.equals(aVar)) {
                return;
            }
            kb kbVar = (kb) u4.a().b(f.this.f27258a);
            BetaPlanModel betaPlanModel = configResponseModel.getBetaPlanModel();
            if (betaPlanModel == null || betaPlanModel.getUnitTestModelList() == null) {
                return;
            }
            kbVar.a(m0.e(), betaPlanModel.getRelease(), new ArrayList(betaPlanModel.getUnitTestModelList()));
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f = arrayList;
        arrayList.add("4dcfae5406670c0ebd29c13c287229d7");
    }

    private f(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f27258a = applicationContext;
        this.b = (g) h.a().b(applicationContext);
    }

    public JSONArray a() {
        JSONArray jSONArrayA;
        synchronized (this.d) {
            jSONArrayA = mg.a();
            if (!this.d.isEmpty()) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    jSONArrayA.put((String) it.next());
                }
            }
        }
        return jSONArrayA;
    }

    public void b() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.a(this.c);
        }
    }

    public void a(String str) {
        synchronized (this.d) {
            this.d.add(str);
        }
    }

    public static f a(Context context) {
        if (e == null) {
            synchronized (f.class) {
                if (e == null) {
                    e = new f(context);
                }
            }
        }
        return e;
    }
}
