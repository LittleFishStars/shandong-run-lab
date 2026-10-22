package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.common.analyse2.db.AnalyseEventDBModel;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class q2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ja f27675a;
    private final p2 b;
    private final Context c;
    private List d;
    private List e;
    private String f;
    private String g;
    private String h;
    private List i;
    private a j;
    private List k;

    public interface a {
        void a();
    }

    public q2(Context context, ja jaVar, p2 p2Var) {
        this.f27675a = jaVar;
        this.b = p2Var;
        this.c = context.getApplicationContext();
    }

    public void a(String str, String str2, List list, String str3) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.k = list;
    }

    public void b(List list) {
        this.i = list;
    }

    public void c(List list) {
        this.e = list;
    }

    public void d(List list) {
        this.d = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        j2 j2VarB;
        AnalyseEventDBModel analyseEventDBModelB;
        AnalyseEventDBModel analyseEventDBModelA;
        if (a(this.e)) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a((AnalyseEventDBModel) it.next());
            }
        }
        if (a(this.d) || a(this.i)) {
            ve veVar = (ve) ym.a().b(this.c);
            if (veVar instanceof t7) {
                j2VarB = ((t7) veVar).b(this.h);
                List list = this.k;
                String[] strArr = list != null ? (String[]) list.toArray(new String[0]) : new String[0];
                if (j2VarB != null) {
                    j2VarB.a(strArr);
                }
            } else {
                j2VarB = null;
            }
            if (j2VarB != null) {
                if (a(this.i) && (analyseEventDBModelA = l2.a(this.c, this.f, this.g, j2VarB, this.i)) != null) {
                    a(analyseEventDBModelA);
                }
                if (!a(this.d) || (analyseEventDBModelB = l2.b(this.c, this.f, this.g, j2VarB, this.d)) == null) {
                    return;
                }
                a(analyseEventDBModelB);
            }
        }
    }

    public class b extends b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AnalyseEventDBModel f27676a;

        private b(AnalyseEventDBModel analyseEventDBModel) {
            this.f27676a = analyseEventDBModel;
        }

        private void a() {
            AnalyseEventDBModel analyseEventDBModel;
            if (q2.this.f27675a == null || (analyseEventDBModel = this.f27676a) == null || analyseEventDBModel.f()) {
                return;
            }
            this.f27676a.b();
            q2.this.f27675a.a(this.f27676a);
        }

        private void b(ra raVar) {
            a aVar;
            if (raVar == null || raVar.a() != 200 || !c(raVar) || (aVar = q2.this.j) == null) {
                return;
            }
            aVar.a();
        }

        private boolean c(ra raVar) {
            JSONObject jSONObjectC;
            JSONObject jSONObjectB;
            String strB = raVar.b();
            return (TextUtils.isEmpty(strB) || (jSONObjectC = mg.c(strB)) == null || mg.a(jSONObjectC, "code", 0) != 200 || (jSONObjectB = mg.b(jSONObjectC, "data")) == null || 1 != mg.a(jSONObjectB, "isUpdate", 0)) ? false : true;
        }

        @Override // com.beizi.fusion.b1
        public void a(ra raVar) {
            AnalyseEventDBModel analyseEventDBModel = this.f27676a;
            if (analyseEventDBModel != null && analyseEventDBModel.f()) {
                q2.this.f27675a.a(AnalyseEventDBModel.class, this.f27676a.getPrimaryID());
            }
            b(raVar);
            this.f27676a = null;
        }

        @Override // com.beizi.fusion.sa
        public void a(nc ncVar) {
            a();
            this.f27676a = null;
        }
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    private boolean a(List list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    private void a(AnalyseEventDBModel analyseEventDBModel) {
        if (analyseEventDBModel != null) {
            String strE = analyseEventDBModel.e();
            String strC = analyseEventDBModel.c();
            b bVar = new b(analyseEventDBModel);
            byte[] bArrD = analyseEventDBModel.d();
            if (bArrD != null) {
                this.b.a(strE, strC, bArrD, bVar);
            }
        }
    }
}
