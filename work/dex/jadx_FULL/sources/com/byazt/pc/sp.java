package com.byazt.pc;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 91})
public class sp extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "check_duplicate";
    }

    @Override // com.byazt.pc.i
    public void c(com.byazt.oz.ve veVar) {
        List<com.byazt.oz.ve> linkedList;
        String strNu = veVar.nu();
        Map<String, List<com.byazt.oz.ve>> mapSp = veVar.u().sp();
        synchronized (mapSp) {
            linkedList = mapSp.get(strNu);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
        }
        synchronized (linkedList) {
            linkedList.add(veVar);
            mapSp.put(strNu, linkedList);
            if (linkedList.size() <= 1) {
                veVar.c(new uj());
            }
        }
    }
}
