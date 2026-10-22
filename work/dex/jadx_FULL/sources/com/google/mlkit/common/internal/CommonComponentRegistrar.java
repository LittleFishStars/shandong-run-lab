package com.google.mlkit.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.a;
import com.zj.adlib.csc;
import com.zj.adlib.e98;
import com.zj.adlib.g73;
import com.zj.adlib.hq5;
import com.zj.adlib.iq5;
import com.zj.adlib.qq5;
import com.zj.adlib.re7;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class CommonComponentRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f32446a = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public final List getComponents() {
        return zzar.zzi(e98.f41378a, Component.builder(qq5.class).add(Dependency.required(hq5.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.p6c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new qq5((hq5) componentContainer.get(hq5.class));
            }
        }).build(), Component.builder(iq5.class).factory(new ComponentFactory() { // from class: com.zj.adlib.qbc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new iq5();
            }
        }).build(), Component.builder(re7.class).add(Dependency.setOf(re7.a.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.fec
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new re7(componentContainer.setOf(re7.a.class));
            }
        }).build(), Component.builder(g73.class).add(Dependency.requiredProvider(iq5.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.aic
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new g73(componentContainer.getProvider(iq5.class));
            }
        }).build(), Component.builder(Cleaner.class).factory(new ComponentFactory() { // from class: com.zj.adlib.clc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return Cleaner.a();
            }
        }).build(), Component.builder(a.C0763a.class).add(Dependency.required(Cleaner.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.loc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new a.C0763a((Cleaner) componentContainer.get(Cleaner.class));
            }
        }).build(), Component.builder(csc.class).add(Dependency.required(hq5.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.bsc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new csc((hq5) componentContainer.get(hq5.class));
            }
        }).build(), Component.intoSetBuilder(re7.a.class).add(Dependency.requiredProvider(csc.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.zvc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new re7.a(kz1.class, componentContainer.getProvider(csc.class));
            }
        }).build());
    }
}
