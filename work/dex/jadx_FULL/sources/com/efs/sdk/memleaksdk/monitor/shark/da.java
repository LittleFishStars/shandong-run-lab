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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J \u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u0011\u0010%\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0086\u0002J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0019\u0010.\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001aH\u0086\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap;", "", "expectedElements", "", "(I)V", "assigned", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "containsKey", CachedContentIndex.a.e, "ensureCapacity", "entrySequence", "Lkotlin/sequences/Sequence;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongPair;", "forEach", "forEachCallback", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap$ForEachCallback;", p3.f, "getSlot", "getSlotValue", "hashKey", "rehash", "fromKeys", "fromValues", "release", "remove", p3.h, "value", "shiftConflictingKeys", "gapSlotArg", "ForEachCallback", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long[] f29866a;
    public long[] b;
    boolean c;
    private int d;
    private int e;
    private int f;
    private double g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongScatterMap$ForEachCallback;", "", "onEntry", "", CachedContentIndex.a.e, "", "value", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public interface a {
        void a(long j, long j2);
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongPair;", BridgeDSL.INVOKE, "()Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongPair;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class b extends Lambda implements Function0<LongLongPair> {
        final /* synthetic */ Ref.IntRef b;
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, int i) {
            super(0);
            this.b = intRef;
            this.c = i;
        }

        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LongLongPair invoke() {
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
                    da daVar = da.this;
                    long j = daVar.f29866a[i2];
                    if (j != 0) {
                        return de.a(j, daVar.b[i2]);
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
            da daVar2 = da.this;
            if (!daVar2.c) {
                return null;
            }
            intRef3.element = i3 + 1;
            return de.a(0L, daVar2.b[i4]);
        }
    }

    public da() {
        this(0, 1);
    }

    public da(int i) {
        this.f29866a = new long[0];
        this.b = new long[0];
        this.g = 0.75d;
        a(i);
    }

    public final boolean a() {
        return d() == 0;
    }

    public final long b(long j) {
        int iA = a(j);
        if (iA != -1) {
            return this.b[iA];
        }
        throw new IllegalArgumentException(("Unknown key " + j).toString());
    }

    public final void c() {
        this.d = 0;
        this.c = false;
        b(cx.f29861a.a(4, this.g));
    }

    public final int d() {
        return this.d + (this.c ? 1 : 0);
    }

    public final long a(long j, long j2) {
        int i = this.e;
        if (j == 0) {
            this.c = true;
            long[] jArr = this.b;
            int i2 = i + 1;
            long j3 = jArr[i2];
            jArr[i2] = j2;
            return j3;
        }
        long[] jArr2 = this.f29866a;
        int iA = cx.f29861a.a(j) & i;
        long j4 = jArr2[iA];
        while (j4 != 0) {
            if (j4 == j) {
                long[] jArr3 = this.b;
                long j5 = jArr3[iA];
                jArr3[iA] = j2;
                return j5;
            }
            iA = (iA + 1) & i;
            j4 = jArr2[iA];
        }
        if (this.d == this.f) {
            a(iA, j, j2);
        } else {
            jArr2[iA] = j;
            this.b[iA] = j2;
        }
        this.d++;
        return 0L;
    }

    @NotNull
    public final Sequence<LongLongPair> b() {
        int i = this.e + 1;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        return SequencesKt.generateSequence(new b(intRef, i));
    }

    public /* synthetic */ da(int i, int i2) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    private final void b(int i) {
        long[] jArr = this.f29866a;
        long[] jArr2 = this.b;
        int i2 = i + 1;
        try {
            this.f29866a = new long[i2];
            this.b = new long[i2];
            this.f = cx.f29861a.b(i, this.g);
            this.e = i - 1;
        } catch (OutOfMemoryError e) {
            this.f29866a = jArr;
            this.b = jArr2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(new Object[]{Integer.valueOf(this.e + 1), Integer.valueOf(i)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
            throw new RuntimeException(str, e);
        }
    }

    public final int a(long j) {
        if (j == 0) {
            if (this.c) {
                return this.e + 1;
            }
            return -1;
        }
        long[] jArr = this.f29866a;
        int i = this.e;
        int iA = cx.f29861a.a(j) & i;
        long j2 = jArr[iA];
        while (j2 != 0) {
            if (j2 == j) {
                return iA;
            }
            iA = (iA + 1) & i;
            j2 = jArr[iA];
        }
        return -1;
    }

    public final void a(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "forEachCallback");
        int i = this.e + 1;
        int i2 = -1;
        while (true) {
            if (i2 < i) {
                while (true) {
                    i2++;
                    if (i2 < i) {
                        long j = this.f29866a[i2];
                        if (j != 0) {
                            aVar.a(j, this.b[i2]);
                        }
                    }
                }
            }
            if (i2 != i || !this.c) {
                return;
            }
            i2++;
            aVar.a(0L, this.b[i]);
        }
    }

    public final void a(int i) {
        if (i > this.f) {
            long[] jArr = this.f29866a;
            long[] jArr2 = this.b;
            b(cx.f29861a.a(i, this.g));
            if (a()) {
                return;
            }
            a(jArr, jArr2);
        }
    }

    private final void a(long[] jArr, long[] jArr2) {
        int i;
        long[] jArr3 = this.f29866a;
        long[] jArr4 = this.b;
        int i2 = this.e;
        int length = jArr.length - 1;
        jArr3[jArr3.length - 1] = jArr[length];
        jArr4[jArr4.length - 1] = jArr2[length];
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
                    if (jArr3[i] == 0) {
                        break;
                    } else {
                        iA = i + 1;
                    }
                }
                jArr3[i] = j;
                jArr4[i] = jArr2[length];
            }
        }
    }

    private final void a(int i, long j, long j2) {
        long[] jArr = this.f29866a;
        long[] jArr2 = this.b;
        b(cx.f29861a.a(this.e + 1, d(), this.g));
        jArr[i] = j;
        jArr2[i] = j2;
        a(jArr, jArr2);
    }
}
