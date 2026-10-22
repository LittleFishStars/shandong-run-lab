package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcv;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.zj.adlib.bwc;
import com.zj.adlib.g73;
import com.zj.adlib.hq5;
import com.zj.adlib.src;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class BarcodeRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f32481a = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public final List getComponents() {
        return zzcv.zzh(Component.builder(bwc.class).add(Dependency.required(hq5.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.kec
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new bwc((hq5) componentContainer.get(hq5.class));
            }
        }).build(), Component.builder(src.class).add(Dependency.required(bwc.class)).add(Dependency.required(g73.class)).add(Dependency.required(hq5.class)).factory(new ComponentFactory() { // from class: com.zj.adlib.phc
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new src((bwc) componentContainer.get(bwc.class), (g73) componentContainer.get(g73.class), (hq5) componentContainer.get(hq5.class));
            }
        }).build());
    }
}
