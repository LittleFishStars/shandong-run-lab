package com.byazt.pro;

import com.byazt.nc.da;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 199, 20})
public class c extends com.byazt.vvt.c<com.byazt.nh.ve, List<da>> {
    public static final c tt = new c();

    private c() {
    }

    public static c uj() {
        return tt;
    }

    @Override // com.byazt.vvt.c
    public int c() {
        return 5;
    }

    @Override // com.byazt.vvt.c
    /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
    public List<String> c(List<da> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<da> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLifecycleId());
        }
        return arrayList;
    }

    @Override // com.byazt.vvt.c
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public String tt(List<da> list) {
        Map<String, Object> mediaExtraInfo;
        if (list == null || list.isEmpty() || (mediaExtraInfo = list.get(0).getMediaExtraInfo()) == null || mediaExtraInfo.get("request_id") == null) {
            return null;
        }
        return (String) mediaExtraInfo.get("request_id");
    }

    @Override // com.byazt.vvt.c
    public void c(com.byazt.nh.ve veVar, List<da> list) {
        if (veVar != null) {
            veVar.c(list);
        }
    }

    @Override // com.byazt.vvt.c
    public void c(com.byazt.nh.ve veVar, int i, String str) {
        if (veVar != null) {
            veVar.c(i, str);
        }
    }
}
