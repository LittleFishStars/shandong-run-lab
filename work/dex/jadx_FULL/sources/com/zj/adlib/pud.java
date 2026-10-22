package com.zj.adlib;

import com.google.android.gms.internal.common.c;
import com.google.android.gms.internal.common.d;
import com.google.android.gms.internal.common.zzo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NullMarked
public final class pud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzo f44064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final psd f18940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18941a;

    public pud(psd psdVar, boolean z, zzo zzoVar, int i, byte[] bArr) {
        this.f18940a = psdVar;
        this.f18941a = z;
        this.f44064a = zzoVar;
    }

    public static pud c(zzo zzoVar) {
        return new pud(new psd(zzoVar), false, c.f31330a, Integer.MAX_VALUE, null);
    }

    public final pud b() {
        return new pud(this.f18940a, true, this.f44064a, Integer.MAX_VALUE, null);
    }

    public final Iterable d(CharSequence charSequence) {
        return new otd(this, charSequence);
    }

    public final List f(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itH = h(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itH.hasNext()) {
            arrayList.add((String) itH.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator h(CharSequence charSequence) {
        return new d(this.f18940a, this, charSequence);
    }
}
