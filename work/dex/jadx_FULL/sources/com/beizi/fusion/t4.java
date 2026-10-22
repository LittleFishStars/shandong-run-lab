package com.beizi.fusion;

import com.ali.auth.third.login.LoginConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class t4 implements kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f27774a = new HashMap();
    private final Map b = new HashMap();

    @Override // com.beizi.fusion.kb
    public void a(String str, List list, List list2) {
        if (list != null && !list.isEmpty()) {
            this.b.put(str, list);
        }
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                lb lbVar = (lb) it.next();
                this.f27774a.put(lbVar.getBetaTestPlanID() + LoginConstants.UNDER_LINE + lbVar.getSDKBizID(), new a(lbVar));
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final lb f27775a;
        private Boolean b;

        private a(lb lbVar) {
            this.b = null;
            this.f27775a = lbVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i) {
            if (i == 9) {
                return a();
            }
            if (i != 8) {
                return false;
            }
            if (this.b == null) {
                this.b = Boolean.valueOf(a());
            }
            return this.b.booleanValue();
        }

        private boolean a() {
            lb lbVar = this.f27775a;
            if (lbVar != null && ml.a(lbVar.getRandomProbability())) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long startTimestamp = this.f27775a.getStartTimestamp();
                long endTimestamp = this.f27775a.getEndTimestamp();
                long durationMillisecond = this.f27775a.getDurationMillisecond();
                if (startTimestamp > 0 && endTimestamp > 0 && jCurrentTimeMillis >= startTimestamp && jCurrentTimeMillis <= endTimestamp) {
                    return true;
                }
                if (jCurrentTimeMillis >= startTimestamp && jCurrentTimeMillis <= startTimestamp + durationMillisecond) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.beizi.fusion.kb
    public boolean a(String str, String str2, int i) {
        a aVar;
        List list = (List) this.b.get(str2);
        if (list != null && !list.isEmpty()) {
            return list.contains(str);
        }
        String str3 = str + LoginConstants.UNDER_LINE + str2;
        if (!this.f27774a.containsKey(str3) || (aVar = (a) this.f27774a.get(str3)) == null) {
            return false;
        }
        return aVar.a(i);
    }
}
