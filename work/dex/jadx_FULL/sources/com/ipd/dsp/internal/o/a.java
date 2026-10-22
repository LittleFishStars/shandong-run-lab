package com.ipd.dsp.internal.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.n.h;
import com.ipd.dsp.internal.n.n;
import com.ipd.dsp.internal.n.o;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a<Model> implements o<Model, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<h, InputStream> f38467a;

    @Nullable
    public final n<Model, h> b;

    public a(o<h, InputStream> oVar) {
        this(oVar, null);
    }

    @Override // com.ipd.dsp.internal.n.o
    @Nullable
    public o.a<InputStream> a(@NonNull Model model, int i, int i2, @NonNull i iVar) {
        n<Model, h> nVar = this.b;
        h hVarA = nVar != null ? nVar.a(model, i, i2) : null;
        if (hVarA == null) {
            String strD = d(model, i, i2, iVar);
            if (TextUtils.isEmpty(strD)) {
                return null;
            }
            h hVar = new h(strD, c(model, i, i2, iVar));
            n<Model, h> nVar2 = this.b;
            if (nVar2 != null) {
                nVar2.a(model, i, i2, hVar);
            }
            hVarA = hVar;
        }
        List<String> listB = b(model, i, i2, iVar);
        o.a<InputStream> aVarA = this.f38467a.a(hVarA, i, i2, iVar);
        return (aVarA == null || listB.isEmpty()) ? aVarA : new o.a<>(aVarA.f38436a, a((Collection<String>) listB), aVarA.c);
    }

    public List<String> b(Model model, int i, int i2, i iVar) {
        return Collections.EMPTY_LIST;
    }

    @Nullable
    public com.ipd.dsp.internal.n.i c(Model model, int i, int i2, i iVar) {
        return com.ipd.dsp.internal.n.i.b;
    }

    public abstract String d(Model model, int i, int i2, i iVar);

    public a(o<h, InputStream> oVar, @Nullable n<Model, h> nVar) {
        this.f38467a = oVar;
        this.b = nVar;
    }

    public static List<com.ipd.dsp.internal.f.f> a(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new h(it.next()));
        }
        return arrayList;
    }
}
