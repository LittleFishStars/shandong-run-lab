package com.efs.sdk.memleaksdk.monitor.shark;

import com.acse.ottn.p3;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J%\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0005J\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&0%J\u0018\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001dH\u0086\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dH\u0002J%\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u0018J\u0015\u0010/\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0002\u0010(J \u00100\u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\u001d2\u0006\u00101\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014X\u0082\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\b\u0015\u0010\u0003¨\u00065"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectScatterMap;", "T", "", "()V", "assigned", "", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "(IJLjava/lang/Object;)V", "containsKey", CachedContentIndex.a.e, "ensureCapacity", "expectedElements", "entrySequence", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", p3.f, "(J)Ljava/lang/Object;", "hashKey", "rehash", "fromKeys", "fromValues", "([J[Ljava/lang/Object;)V", "release", "remove", p3.h, "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "shiftConflictingKeys", "gapSlotArg", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class dc<T> {
    boolean c;
    private int d;
    private int e;
    private int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long[] f29869a = new long[0];
    T[] b = (T[]) new Object[0];
    private double g = 0.75d;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", BridgeDSL.INVOKE, "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class a extends Lambda implements Function0<LongObjectPair<? extends T>> {
        final /* synthetic */ Ref.IntRef b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Ref.IntRef intRef, int i) {
            super(0);
            this.b = intRef;
            this.c = i;
        }

        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LongObjectPair<T> invoke() {
            Ref.IntRef intRef = this.b;
            int i = intRef.element;
            if (i < this.c) {
                intRef.element = i + 1;
                while (true) {
                    Ref.IntRef intRef2 = this.b;
                    int i2 = intRef2.element;
                    if (i2 >= this.c) {
                        break;
                    }
                    dc dcVar = dc.this;
                    long j = dcVar.f29869a[i2];
                    if (j != 0) {
                        T t = dcVar.b[i2];
                        Intrinsics.checkNotNull(t);
                        return de.a(j, t);
                    }
                    intRef2.element = i2 + 1;
                }
            }
            Ref.IntRef intRef3 = this.b;
            int i3 = intRef3.element;
            int i4 = this.c;
            if (i3 != i4) {
                return null;
            }
            dc dcVar2 = dc.this;
            if (!dcVar2.c) {
                return null;
            }
            intRef3.element = i3 + 1;
            T t2 = dcVar2.b[i4];
            Intrinsics.checkNotNull(t2);
            return de.a(0L, t2);
        }
    }

    public dc() {
        a(4);
    }

    public final boolean a() {
        return c() == 0;
    }

    @NotNull
    public final Sequence<LongObjectPair<T>> b() {
        int i = this.e + 1;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        return SequencesKt.generateSequence(new a(intRef, i));
    }

    public final int c() {
        return this.d + (this.c ? 1 : 0);
    }

    @Nullable
    public final T a(long j, T t) {
        int i = this.e;
        if (j == 0) {
            this.c = true;
            T[] tArr = this.b;
            int i2 = i + 1;
            T t2 = tArr[i2];
            tArr[i2] = t;
            return t2;
        }
        long[] jArr = this.f29869a;
        int iA = cx.f29861a.a(j) & i;
        long j2 = jArr[iA];
        while (j2 != 0) {
            if (j2 == j) {
                T[] tArr2 = this.b;
                T t3 = tArr2[iA];
                tArr2[iA] = t;
                return t3;
            }
            iA = (iA + 1) & i;
            j2 = jArr[iA];
        }
        if (this.d == this.f) {
            a(iA, j, t);
        } else {
            jArr[iA] = j;
            this.b[iA] = t;
        }
        this.d++;
        return null;
    }

    private final void b(int i) {
        long[] jArr = this.f29869a;
        T[] tArr = this.b;
        int i2 = i + 1;
        try {
            this.f29869a = new long[i2];
            this.b = (T[]) new Object[i2];
            this.f = cx.f29861a.b(i, this.g);
            this.e = i - 1;
        } catch (OutOfMemoryError e) {
            this.f29869a = jArr;
            this.b = tArr;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(this.e + 1), Integer.valueOf(i)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(str, e);
        }
    }

    @Nullable
    public final T a(long j) {
        if (j == 0) {
            if (this.c) {
                return this.b[this.e + 1];
            }
            return null;
        }
        long[] jArr = this.f29869a;
        int i = this.e;
        int iA = cx.f29861a.a(j) & i;
        long j2 = jArr[iA];
        while (j2 != 0) {
            if (j2 == j) {
                return this.b[iA];
            }
            iA = (iA + 1) & i;
            j2 = jArr[iA];
        }
        return null;
    }

    public final void a(int i) {
        if (i > this.f) {
            long[] jArr = this.f29869a;
            T[] tArr = this.b;
            b(cx.f29861a.a(i, this.g));
            if (a()) {
                return;
            }
            a(jArr, tArr);
        }
    }

    private final void a(long[] jArr, T[] tArr) {
        int i;
        long[] jArr2 = this.f29869a;
        T[] tArr2 = this.b;
        int i2 = this.e;
        int length = jArr.length - 1;
        jArr2[jArr2.length - 1] = jArr[length];
        tArr2[tArr2.length - 1] = tArr[length];
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            long j = jArr[length];
            if (j != 0) {
                int iA = cx.f29861a.a(j);
                while (true) {
                    i = iA & i2;
                    if (jArr2[i] == 0) {
                        break;
                    } else {
                        iA = i + 1;
                    }
                }
                jArr2[i] = j;
                tArr2[i] = tArr[length];
            }
        }
    }

    private final void a(int i, long j, T t) {
        long[] jArr = this.f29869a;
        T[] tArr = this.b;
        b(cx.f29861a.a(this.e + 1, c(), this.g));
        jArr[i] = j;
        tArr[i] = t;
        a(jArr, tArr);
    }
}
