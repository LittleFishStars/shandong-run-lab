package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdCommon;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdEventLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseSimpleLog;
import com.beizi.fusion.asnp.common.analyse2.db.AnalyseEventDBModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class l2 {
    public static AnalyseEventDBModel a(Context context, String str, String str2, j2 j2Var, List list) {
        if (j2Var == null || list == null || list.isEmpty()) {
            return null;
        }
        j2Var.a(list);
        return a(context, str, str2, j2Var.a());
    }

    public static AnalyseEventDBModel b(Context context, String str, String str2, j2 j2Var, List list) {
        if (j2Var == null || list.isEmpty()) {
            return null;
        }
        return a(context, str, str2, a(j2Var, list).a());
    }

    private static AnalyseEventDBModel a(Context context, String str, String str2, byte[] bArr) {
        AnalyseEventDBModel analyseEventDBModel = new AnalyseEventDBModel();
        analyseEventDBModel.b(str);
        analyseEventDBModel.a(str2);
        analyseEventDBModel.setEventTime(System.currentTimeMillis() + "");
        byte[] bArrB = ((id) dh.a().b(context)).b(bArr, str2, id.a.NOT_APPEND, false);
        if (bArrB == null) {
            return null;
        }
        analyseEventDBModel.a(bArrB);
        return analyseEventDBModel;
    }

    private static j2 a(j2 j2Var, List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            AnalyseSimpleLog analyseSimpleLog = (AnalyseSimpleLog) it.next();
            if (analyseSimpleLog instanceof AnalyseAdEventLog) {
                AnalyseAdCommon analyseAdCommonB = ((AnalyseAdEventLog) analyseSimpleLog).b();
                if (analyseAdCommonB != null && !TextUtils.isEmpty(analyseAdCommonB.b())) {
                    hashSet.add(analyseAdCommonB.b());
                }
            } else {
                i++;
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Map map = new HashMap((int) ((((double) hashSet.size()) / 0.75d) + 1.0d));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            AnalyseSimpleLog analyseSimpleLog2 = (AnalyseSimpleLog) it2.next();
            if (analyseSimpleLog2 instanceof AnalyseAdEventLog) {
                AnalyseAdEventLog analyseAdEventLog = (AnalyseAdEventLog) analyseSimpleLog2;
                AnalyseAdCommon analyseAdCommonB2 = analyseAdEventLog.b();
                if (analyseAdCommonB2 != null && !TextUtils.isEmpty(analyseAdCommonB2.b())) {
                    String strB = analyseAdCommonB2.b();
                    LinkedList linkedList = (LinkedList) map.get(strB);
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        map.put(strB, linkedList);
                    }
                    linkedList.add(analyseAdEventLog);
                }
            } else {
                arrayList.add(analyseSimpleLog2);
            }
        }
        if (!arrayList.isEmpty()) {
            j2Var.c(arrayList);
        }
        if (!map.isEmpty()) {
            j2Var.a(map);
        }
        return j2Var;
    }
}
