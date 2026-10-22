package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.local.AppInstallModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.apps.AppsModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.apps.pkg.PkgModel;
import com.beizi.fusion.asnp.common.analyse.model.IBaseEventReportModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b3 extends hb {
    public b3(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.hb
    public void a(ConfigResponseModel configResponseModel, g.a aVar) {
        AppsModel appsModel;
        fb fbVar;
        if (configResponseModel == null || configResponseModel.getStatistics() == null || (appsModel = configResponseModel.getStatistics().getAppsModel()) == null || (fbVar = (fb) cn.a().b(this.f27361a)) == null) {
            return;
        }
        fbVar.a(new a(this.f27361a, appsModel));
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27088a;
        private final AppsModel b;

        private a(Context context, AppsModel appsModel) {
            this.f27088a = context.getApplicationContext();
            this.b = appsModel;
        }

        private void a(AppsModel appsModel) {
            if (appsModel != null) {
                int delay = appsModel.getDelay();
                fb fbVar = (fb) cn.a().b(this.f27088a);
                if (fbVar != null) {
                    fbVar.a(new RunnableC0300a(appsModel), delay, TimeUnit.MILLISECONDS);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AppsModel appsModel = this.b;
            if (appsModel != null) {
                a(appsModel);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List a() {
            Set setC = p0.c(this.f27088a, p0.a(), "appInstall");
            if (setC == null || setC.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long jA = l6.a(7);
            Iterator it = setC.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectC = mg.c((String) it.next());
                if (jSONObjectC != null) {
                    AppInstallModel appInstallModel = new AppInstallModel(jSONObjectC);
                    long updateTime = appInstallModel.getUpdateTime();
                    if (updateTime > 0 && updateTime > jA) {
                        arrayList.add(appInstallModel);
                    }
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: com.beizi.fusion.b3$a$a, reason: collision with other inner class name */
        public class RunnableC0300a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AppsModel f27089a;

            /* JADX INFO: renamed from: com.beizi.fusion.b3$a$a$a, reason: collision with other inner class name */
            public class C0301a implements pb {
                public C0301a() {
                }

                @Override // com.beizi.fusion.pb
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean fetch(AppInstallModel appInstallModel, String str) {
                    return appInstallModel != null && appInstallModel.getLinkId().equals(str);
                }
            }

            private RunnableC0300a(AppsModel appsModel) {
                this.f27089a = appsModel;
            }

            private List a(List list, List list2) {
                if (list == null || list.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    PkgModel pkgModel = (PkgModel) it.next();
                    AppInstallModel appInstallModel = (AppInstallModel) k5.a(list2, pkgModel.getLinkID(), new C0301a());
                    if (appInstallModel == null) {
                        appInstallModel = new AppInstallModel();
                        appInstallModel.setLinkId(pkgModel.getLinkID());
                        appInstallModel.setUpdateTime(System.currentTimeMillis());
                        appInstallModel.setInstall(xk.c(a.this.f27088a, pkgModel.getLink()));
                    }
                    arrayList.add(appInstallModel);
                }
                return arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                List<PkgModel> pkgModelList;
                AppsModel appsModel = this.f27089a;
                if (appsModel == null || (pkgModelList = appsModel.getPkgModelList()) == null || pkgModelList.isEmpty()) {
                    return;
                }
                int taskReport = this.f27089a.getTaskReport();
                List listA = a.this.a();
                if (taskReport == 1) {
                    a(a(pkgModelList, listA));
                } else if (taskReport == 2) {
                    a(a.this.a(a(pkgModelList, listA), listA));
                } else {
                    if (taskReport != 999) {
                        return;
                    }
                    a(this.f27089a, a(pkgModelList, listA));
                }
            }

            private void a(List list) {
                p0.a(a.this.f27088a, p0.a(), "appInstall", no.a(list));
                ((n) o.a().b(a.this.f27088a)).a(list);
            }

            private void a(AppsModel appsModel, List list) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                IBaseEventReportModel iBaseEventReportModelA = k0.a(a.this.f27088a, u7.EVENT_REPORT_APP_INSTALLS_CODE, no.a(no.a(list, "[]")));
                String macros = appsModel.getMacros();
                String strA = !TextUtils.isEmpty(macros) ? rl.a(macros, iBaseEventReportModelA.getMacrosReplaceMap()) : "";
                String strB = ((id) dh.a().b(a.this.f27088a)).b(strA, "101,1001", id.a.AS_LAST_OR_FIRST, false);
                String reportUrl = appsModel.getReportUrl();
                if (TextUtils.isEmpty(reportUrl) || TextUtils.isEmpty(strA)) {
                    return;
                }
                new xm(a.this.f27088a, true).a(reportUrl, strB, (sa) null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List a(List list, List list2) {
            if (list == null || list.isEmpty()) {
                return list2;
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(list);
            hashSet.addAll(list2);
            return new ArrayList(hashSet);
        }
    }
}
