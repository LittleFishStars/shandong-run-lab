package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BridgeDSLRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<BridgeDSL> f24201a;

    public List<BridgeDSL> getBridgeDSLs() {
        List<BridgeDSL> list = this.f24201a;
        return list != null ? list : new ArrayList();
    }

    public void register(List<BridgeDSL> list) {
        if (this.f24201a == null) {
            this.f24201a = new ArrayList();
        }
        this.f24201a.addAll(list);
    }

    public void unRegister(BridgeDSL bridgeDSL) {
        List<BridgeDSL> list = this.f24201a;
        if (list != null) {
            list.remove(bridgeDSL);
        }
    }
}
