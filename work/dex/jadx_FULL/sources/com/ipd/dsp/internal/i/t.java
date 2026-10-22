package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.zj.adlib.c25;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class t<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<Data> f38343a;
    public final Pools.Pool<List<Throwable>> b;
    public final List<? extends i<Data, ResourceType, Transcode>> c;
    public final String d;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f38343a = cls;
        this.b = pool;
        this.c = (List) com.ipd.dsp.internal.d0.m.a(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + c25.j + cls2.getSimpleName() + c25.j + cls3.getSimpleName() + "}";
    }

    public v<Transcode> a(com.ipd.dsp.internal.components.glide.load.data.a<Data> aVar, @NonNull com.ipd.dsp.internal.f.i iVar, int i, int i2, i.a<ResourceType> aVar2) throws q {
        List<Throwable> list = (List) com.ipd.dsp.internal.d0.m.a(this.b.acquire());
        try {
            return a(aVar, iVar, i, i2, aVar2, list);
        } finally {
            this.b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }

    public final v<Transcode> a(com.ipd.dsp.internal.components.glide.load.data.a<Data> aVar, @NonNull com.ipd.dsp.internal.f.i iVar, int i, int i2, i.a<ResourceType> aVar2, List<Throwable> list) throws q {
        int size = this.c.size();
        v<Transcode> vVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                vVarA = this.c.get(i3).a(aVar, i, i2, iVar, aVar2);
            } catch (q e) {
                list.add(e);
            }
            if (vVarA != null) {
                break;
            }
        }
        if (vVarA != null) {
            return vVarA;
        }
        throw new q(this.d, new ArrayList(list));
    }

    public Class<Data> a() {
        return this.f38343a;
    }
}
