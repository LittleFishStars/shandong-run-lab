package com.beizi.fusion;

import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdCommon;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdEventLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseSimpleLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.init.AnalyseEventModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27548a;
    private final String b;
    private final String c;
    private AnalyseEventModel d;
    private n2 e;
    private b f;
    private c g;
    private final d h = new a();

    public class a implements d {
        public a() {
        }

        @Override // com.beizi.fusion.n2.d
        public void a(List list) {
            n2 n2Var = n2.this;
            n2Var.a(list, n2Var.d, n2Var.f27548a, n2Var.b);
        }
    }

    public static final class b extends CopyOnWriteArrayList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27550a;
        private final a b;
        private d c;

        public class a extends qb {
            public a(long j) {
                super(j);
            }

            @Override // com.beizi.fusion.qb
            public void b() {
                synchronized (b.this) {
                    b.this.b();
                }
            }
        }

        public b(int i, long j) {
            this.f27550a = i <= 0 ? 1 : i;
            this.b = new a(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.b.a();
            a(a());
        }

        public void a(d dVar) {
            this.c = dVar;
        }

        @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
        public boolean add(Object obj) {
            boolean zAdd;
            synchronized (this) {
                zAdd = super.add(obj);
                if (zAdd && size() == 1) {
                    this.b.c();
                }
                if (zAdd && size() == this.f27550a) {
                    b();
                }
            }
            return zAdd;
        }

        private void a(List list) {
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(list);
            }
        }

        private List a() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this);
                clear();
            }
            return arrayList;
        }
    }

    public interface c {
        void a(List list, AnalyseEventModel analyseEventModel, String str, String str2);
    }

    public interface d {
        void a(List list);
    }

    public n2(String str, String str2, String str3) {
        this.f27548a = str;
        this.b = str2;
        this.c = str3;
    }

    private void b(AnalyseSimpleLog analyseSimpleLog) {
        n2 n2Var = this.e;
        if (n2Var != null) {
            n2Var.c(analyseSimpleLog);
        }
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void c(AnalyseSimpleLog analyseSimpleLog) {
        this.f.a(this.h);
        if (!a(analyseSimpleLog)) {
            b(analyseSimpleLog);
            return;
        }
        if (analyseSimpleLog != null) {
            analyseSimpleLog.a(this.d.c() + "");
        }
        this.f.add(analyseSimpleLog);
    }

    public void a(AnalyseEventModel analyseEventModel) {
        long j;
        this.d = analyseEventModel;
        try {
            j = Long.parseLong(analyseEventModel.d());
        } catch (NumberFormatException unused) {
            j = 0;
        }
        this.f = new b(analyseEventModel.getCount(), j);
    }

    public void a(n2 n2Var) {
        this.e = n2Var;
    }

    private boolean a(AnalyseSimpleLog analyseSimpleLog) {
        AnalyseAdCommon analyseAdCommonB;
        AnalyseEventModel analyseEventModel = this.d;
        if (analyseEventModel == null || analyseEventModel.b() == null || this.d.b().isEmpty() || !this.d.b().contains(analyseSimpleLog.getEventCode())) {
            return false;
        }
        int iC = this.d.c();
        String strB = this.c;
        if ((analyseSimpleLog instanceof AnalyseAdEventLog) && (analyseAdCommonB = ((AnalyseAdEventLog) analyseSimpleLog).b()) != null) {
            strB = analyseAdCommonB.b();
        }
        return ml.a(iC, strB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list, AnalyseEventModel analyseEventModel, String str, String str2) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(list, analyseEventModel, str, str2);
        }
    }
}
