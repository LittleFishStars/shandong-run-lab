package com.kc.dw.core.loader.strategy;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements Comparator<com.kc.dw.core.loader.loadbean.a> {
    public f(e eVar) {
    }

    @Override // java.util.Comparator
    public int compare(com.kc.dw.core.loader.loadbean.a aVar, com.kc.dw.core.loader.loadbean.a aVar2) {
        return aVar2.a() - aVar.a();
    }
}
