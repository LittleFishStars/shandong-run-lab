package com.alibaba.appmonitor.c;

import com.alibaba.analytics.a.j;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("ap_alarm")
public class c extends a {

    @com.alibaba.analytics.core.b.a.a("scp")
    protected int S = 0;

    @com.alibaba.analytics.core.b.a.a("fcp")
    protected int T = 0;

    public boolean a(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return a(i, arrayList, bool.booleanValue());
    }

    @Override // com.alibaba.appmonitor.c.a
    public void setSampling(int i) {
        this.S = i;
        this.T = i;
    }

    public String toString() {
        return "AlarmConfig{module=" + this.module + ", monitorPoint=" + this.monitorPoint + ", offline=" + this.bo + ", failSampling=" + this.T + ", successSampling=" + this.S + '}';
    }

    private boolean a(int i, ArrayList<String> arrayList, boolean z) {
        if (arrayList != null && arrayList.size() != 0) {
            String strRemove = arrayList.remove(0);
            if (h(strRemove)) {
                return ((c) b(strRemove)).a(i, arrayList, z);
            }
            return a(i, z);
        }
        return a(i, z);
    }

    private boolean a(int i, boolean z) {
        if (z) {
            j.d("", "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.S));
            return i < this.S;
        }
        j.d("", "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.T));
        return i < this.T;
    }
}
