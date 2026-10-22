package com.alibaba.triver.inside.impl;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.monitor.RVCountDispatcher;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverCountDispatcher implements RVCountDispatcher {
    protected HashMap<Integer, ArrayList<RVCountDispatcher.b>> listeners = new HashMap<>();

    @Override // com.alibaba.ariver.mtop.monitor.RVCountDispatcher
    public void addListener(int i, RVCountDispatcher.b bVar) {
        ArrayList<RVCountDispatcher.b> arrayList = this.listeners.get(Integer.valueOf(i));
        if (arrayList != null) {
            arrayList.add(bVar);
            return;
        }
        ArrayList<RVCountDispatcher.b> arrayList2 = new ArrayList<>();
        arrayList2.add(bVar);
        this.listeners.put(Integer.valueOf(i), arrayList2);
    }

    @Override // com.alibaba.ariver.mtop.monitor.RVCountDispatcher
    public void dispatch(RVCountDispatcher.a aVar) {
        ArrayList<RVCountDispatcher.b> arrayList = this.listeners.get(Integer.valueOf(aVar.a()));
        if (arrayList == null) {
            RVLogger.e("TriverCountDispatcher", "limbo!!");
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            RVCountDispatcher.b bVar = arrayList.get(i);
            if (bVar != null) {
                bVar.onEvent(aVar);
            }
        }
    }

    @Override // com.alibaba.ariver.mtop.monitor.RVCountDispatcher
    public void removeListener(int i, RVCountDispatcher.b bVar) {
        ArrayList<RVCountDispatcher.b> arrayList = this.listeners.get(Integer.valueOf(i));
        if (arrayList != null) {
            arrayList.remove(bVar);
        }
    }
}
