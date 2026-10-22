package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final /* synthetic */ class ComponentDiscovery$$Lambda$1 implements Provider {
    private final String arg$1;

    private ComponentDiscovery$$Lambda$1(String str) {
        this.arg$1 = str;
    }

    public static Provider lambdaFactory$(String str) {
        return new ComponentDiscovery$$Lambda$1(str);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return ComponentDiscovery.instantiate(this.arg$1);
    }
}
