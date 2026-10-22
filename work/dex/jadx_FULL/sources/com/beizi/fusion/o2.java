package com.beizi.fusion;

import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseSimpleLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.init.AnalyseEventModel;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList f27573a = new LinkedList();

    public o2(String str, String str2, String str3, List list, n2.c cVar) {
        Collections.reverse(list);
        Iterator it = list.iterator();
        n2 n2Var = null;
        while (it.hasNext()) {
            AnalyseEventModel analyseEventModel = (AnalyseEventModel) it.next();
            n2 n2Var2 = new n2(str, str2, str3);
            n2Var2.a(cVar);
            n2Var2.a(analyseEventModel);
            if (n2Var != null) {
                n2Var2.a(n2Var);
            }
            this.f27573a.addFirst(n2Var2);
            n2Var = n2Var2;
        }
    }

    public void a(AnalyseSimpleLog analyseSimpleLog) {
        LinkedList linkedList = this.f27573a;
        if (linkedList == null || linkedList.getFirst() == null) {
            return;
        }
        ((n2) this.f27573a.getFirst()).c(analyseSimpleLog);
    }
}
