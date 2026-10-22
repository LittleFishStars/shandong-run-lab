package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.event.EventModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.ClkModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.ShowModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27106a;
    private ReportModel3 b;
    private List c;
    private boolean d = false;

    public class a implements pb {
        public a() {
        }

        @Override // com.beizi.fusion.pb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(EventModel eventModel, xa xaVar) {
            return (eventModel == null || xaVar == null || eventModel.getType() != xaVar.getEventCode()) ? false : true;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdTraceModel f27108a;

        private b(AdTraceModel adTraceModel) {
            this.f27108a = adTraceModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            AdTraceModel adTraceModel = this.f27108a;
            if (adTraceModel != null) {
                adTraceModel.setClickDelay(-1);
            }
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ai f27109a;
        private final String b;
        private final u9 c;
        private final cm d;
        private b e;

        private c(Context context, String str, int i, xa xaVar, AdTraceModel adTraceModel) {
            this.f27109a = h0.a(context, xaVar, adTraceModel);
            this.b = str;
            this.d = i == 0 ? cm.GET : cm.POST;
            this.c = (u9) o0.a().b(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b bVar) {
            this.e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(this.b)) {
                String strA = rl.a(this.b, this.f27109a.getMacrosReplaceMap());
                if (cm.POST == this.d) {
                    this.c.a(strA.substring(0, strA.indexOf("?")), strA.substring(strA.indexOf("?") + 1), null);
                } else {
                    this.c.a(strA, null);
                }
            }
            b bVar = this.e;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public bi(Context context) {
        this.f27106a = context.getApplicationContext();
    }

    private List b(xa xaVar) {
        synchronized (this) {
            List list = this.c;
            if (list == null || list.isEmpty()) {
                return null;
            }
            return k5.b(this.c, xaVar, new a());
        }
    }

    public void a(AdItemModel adItemModel) {
        if (adItemModel != null) {
            this.b = adItemModel.getReport();
            this.c = adItemModel.getEventModels();
            this.d = true;
        }
    }

    public boolean a() {
        return this.d;
    }

    public void a(xa xaVar, AdTraceModel adTraceModel) {
        int clickMonitorDelay;
        List<EventModel> listB = b(xaVar);
        if (listB == null || listB.isEmpty()) {
            return;
        }
        fb fbVar = (fb) cn.a().b(this.f27106a);
        int iA = a(xaVar);
        x9.a aVar = x9.a.AD_CLICK;
        if (xaVar == aVar) {
            a(adTraceModel, iA);
        }
        if (xaVar.getEventCode() > aVar.getEventCode() && (clickMonitorDelay = adTraceModel.getClickMonitorDelay()) > 0 && iA < clickMonitorDelay) {
            iA = clickMonitorDelay;
        }
        for (EventModel eventModel : listB) {
            c cVar = new c(this.f27106a, eventModel.getUrl(), eventModel.getMethod(), xaVar, adTraceModel.m165deepCopy());
            if (xaVar == x9.a.AD_CLICK) {
                cVar.a(new b(adTraceModel));
            }
            fbVar.a(cVar, iA, TimeUnit.MILLISECONDS);
        }
    }

    private void a(AdTraceModel adTraceModel, int i) {
        if (adTraceModel != null) {
            adTraceModel.setClickDelay(i);
        }
    }

    private int a(xa xaVar) {
        ShowModel show;
        ClkModel clk;
        return (xaVar != gc.a.ADN_RECOGNIZE || (show = this.b.getShow()) == null) ? (xaVar != x9.a.AD_CLICK || (clk = this.b.getClk()) == null) ? 0 : clk.getRt() : show.getRt();
    }
}
