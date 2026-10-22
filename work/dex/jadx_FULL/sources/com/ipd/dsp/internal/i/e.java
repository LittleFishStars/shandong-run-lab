package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e<DataType> implements com.ipd.dsp.internal.k.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.f.d<DataType> f38326a;
    public final DataType b;
    public final com.ipd.dsp.internal.f.i c;

    public e(com.ipd.dsp.internal.f.d<DataType> dVar, DataType datatype, com.ipd.dsp.internal.f.i iVar) {
        this.f38326a = dVar;
        this.b = datatype;
        this.c = iVar;
    }

    @Override // com.ipd.dsp.internal.k.a.b
    public boolean a(@NonNull File file) {
        return this.f38326a.a(this.b, file, this.c);
    }
}
