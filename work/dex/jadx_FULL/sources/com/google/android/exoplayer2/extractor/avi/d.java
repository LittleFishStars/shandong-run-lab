package com.google.android.exoplayer2.extractor.avi;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<AviChunk> f2732a;

    public d(int i, ImmutableList<AviChunk> immutableList) {
        this.f30634a = i;
        this.f2732a = immutableList;
    }

    @Nullable
    public static AviChunk a(int i, int i2, om6 om6Var) {
        switch (i) {
            case 1718776947:
                return e.d(i2, om6Var);
            case 1751742049:
                return b.b(om6Var);
            case 1752331379:
                return c.d(om6Var);
            case 1852994675:
                return f.a(om6Var);
            default:
                return null;
        }
    }

    public static d c(int i, om6 om6Var) {
        ImmutableList.a aVar = new ImmutableList.a();
        int iF = om6Var.f();
        int iC = -2;
        while (om6Var.a() > 8) {
            int iR = om6Var.r();
            int iE = om6Var.e() + om6Var.r();
            om6Var.R(iE);
            AviChunk aviChunkC = iR == 1414744396 ? c(om6Var.r(), om6Var) : a(iR, iC, om6Var);
            if (aviChunkC != null) {
                if (aviChunkC.getType() == 1752331379) {
                    iC = ((c) aviChunkC).c();
                }
                aVar.a(aviChunkC);
            }
            om6Var.S(iE);
            om6Var.R(iF);
        }
        return new d(i, aVar.e());
    }

    @Nullable
    public <T extends AviChunk> T b(Class<T> cls) {
        UnmodifiableIterator<AviChunk> it = this.f2732a.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return this.f30634a;
    }
}
