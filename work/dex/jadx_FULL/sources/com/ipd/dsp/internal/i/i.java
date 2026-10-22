package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.ipd.dsp.Dsp;
import com.zj.adlib.c25;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i<DataType, ResourceType, Transcode> {
    public static final String f = "DecodePath";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<DataType> f38332a;
    public final List<? extends com.ipd.dsp.internal.f.k<DataType, ResourceType>> b;
    public final com.ipd.dsp.internal.v.e<ResourceType, Transcode> c;
    public final Pools.Pool<List<Throwable>> d;
    public final String e;

    public interface a<ResourceType> {
        @NonNull
        v<ResourceType> a(@NonNull v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.ipd.dsp.internal.f.k<DataType, ResourceType>> list, com.ipd.dsp.internal.v.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f38332a = cls;
        this.b = list;
        this.c = eVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + c25.j + cls2.getSimpleName() + c25.j + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.ipd.dsp.internal.components.glide.load.data.a<DataType> aVar, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar, a<ResourceType> aVar2) throws q {
        return this.c.a(aVar2.a(a(aVar, i, i2, iVar)), iVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f38332a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }

    @NonNull
    public final v<ResourceType> a(com.ipd.dsp.internal.components.glide.load.data.a<DataType> aVar, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws q {
        List<Throwable> list = (List) com.ipd.dsp.internal.d0.m.a(this.d.acquire());
        try {
            return a(aVar, i, i2, iVar, list);
        } finally {
            this.d.release(list);
        }
    }

    @NonNull
    public final v<ResourceType> a(com.ipd.dsp.internal.components.glide.load.data.a<DataType> aVar, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar, List<Throwable> list) throws q {
        int size = this.b.size();
        v<ResourceType> vVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.ipd.dsp.internal.f.k<DataType, ResourceType> kVar = this.b.get(i3);
            try {
                if (kVar.a(aVar.c(), iVar)) {
                    vVarA = kVar.a(aVar.c(), i, i2, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.d(f, "Failed to decode data for " + kVar, e);
                }
                list.add(e);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.e, new ArrayList(list));
    }
}
