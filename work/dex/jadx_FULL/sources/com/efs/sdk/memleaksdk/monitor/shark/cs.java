package com.efs.sdk.memleaksdk.monitor.shark;

import com.acse.ottn.p3;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0005R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/SortedBytesMap;", "", "longIdentifiers", "", "bytesPerValue", "", "sortedEntries", "", "(ZI[B)V", "bytesPerEntry", "bytesPerKey", "size", "getSize", "()I", "binarySearch", CachedContentIndex.a.e, "", "contains", "entrySequence", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ByteSubArray;", p3.f, "getAtIndex", "keyIndex", "indexOf", "keyAt", "index", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f29854a;
    final int b;
    public final int c;
    final boolean d;
    final int e;
    final byte[] f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "keyIndex", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ByteSubArray;", BridgeDSL.INVOKE, "(I)Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class a extends Lambda implements Function1<Integer, LongObjectPair<? extends cd>> {
        public a() {
            super(1);
        }

        @NotNull
        public final LongObjectPair<cd> a(int i) {
            cs csVar = cs.this;
            int i2 = (csVar.b * i) + csVar.f29854a;
            long jB = csVar.b(i);
            cs csVar2 = cs.this;
            return de.a(jB, new cd(csVar2.f, i2, csVar2.e, csVar2.d));
        }

        public /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public cs(boolean z, int i, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sortedEntries");
        this.d = z;
        this.e = i;
        this.f = bArr;
        int i2 = z ? 8 : 4;
        this.f29854a = i2;
        int i3 = i2 + i;
        this.b = i3;
        this.c = bArr.length / i3;
    }

    @Nullable
    public final cd a(long j) {
        int iB = b(j);
        if (iB < 0) {
            return null;
        }
        return a(iB);
    }

    public final int b(long j) {
        int i = this.c - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            long jB = b(i3);
            if (jB < j) {
                i2 = i3 + 1;
            } else {
                if (jB <= j) {
                    return i3;
                }
                i = i3 - 1;
            }
        }
        return ~i2;
    }

    @NotNull
    public final cd a(int i) {
        return new cd(this.f, (i * this.b) + this.f29854a, this.e, this.d);
    }

    public final long b(int i) {
        int i2 = i * this.b;
        if (this.d) {
            return ce.c(this.f, i2);
        }
        return ce.b(this.f, i2);
    }

    @NotNull
    public final Sequence<LongObjectPair<cd>> a() {
        return SequencesKt.map(CollectionsKt.asSequence(RangesKt.until(0, this.c)), new a());
    }
}
