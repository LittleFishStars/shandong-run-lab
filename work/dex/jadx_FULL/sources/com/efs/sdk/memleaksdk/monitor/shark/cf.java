package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010%\u001a\u00020\u0016\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020 H\u0002R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006+"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ClassFieldsReader;", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/IndexedObject$IndexedClass;", "indexedClass", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "classDumpFields", "", "classDumpHasReferenceFields", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "classDumpStaticFields", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "", "readShort", "readUnsignedByte", "readUnsignedShort", "type", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "readValue", "", "skipStaticFields", "", "classFieldBytes", "[B", "identifierByteSize", "I", "position", "<init>", "(I[B)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29824a = new a(0);
    private static final int e = PrimitiveType.BOOLEAN.i;
    private static final int f = PrimitiveType.CHAR.i;
    private static final int g = PrimitiveType.FLOAT.i;
    private static final int h = PrimitiveType.DOUBLE.i;
    private static final int i = PrimitiveType.BYTE.i;
    private static final int j = PrimitiveType.SHORT.i;
    private static final int k = PrimitiveType.INT.i;
    private static final int l = PrimitiveType.LONG.i;
    private int b;
    private final int c;
    private final byte[] d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/ClassFieldsReader$Companion;", "", "()V", "BOOLEAN_TYPE", "", "BYTE_TYPE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_TYPE", "LONG_TYPE", "SHORT_TYPE", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public cf(int i2, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "classFieldBytes");
        this.c = i2;
        this.d = bArr;
    }

    private final ValueHolder a(int i2) {
        if (i2 == 2) {
            return new ValueHolder.ReferenceHolder(g());
        }
        if (i2 == e) {
            return new ValueHolder.BooleanHolder(h());
        }
        if (i2 == f) {
            return new ValueHolder.CharHolder((char) e());
        }
        if (i2 == g) {
            return new ValueHolder.FloatHolder(i());
        }
        if (i2 == h) {
            return new ValueHolder.DoubleHolder(j());
        }
        if (i2 == i) {
            return new ValueHolder.ByteHolder(b());
        }
        if (i2 == j) {
            return new ValueHolder.ShortHolder(e());
        }
        if (i2 == k) {
            return new ValueHolder.IntHolder(c());
        }
        if (i2 == l) {
            return new ValueHolder.LongHolder(d());
        }
        throw new IllegalStateException("Unknown type " + i2);
    }

    private final byte b() {
        byte[] bArr = this.d;
        int i2 = this.b;
        this.b = i2 + 1;
        return bArr[i2];
    }

    private final int c() {
        byte[] bArr = this.d;
        int i2 = this.b;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.b = i6 + 1;
        return (bArr[i6] & 255) | i7;
    }

    private final long d() {
        byte[] bArr = this.d;
        int i2 = this.b;
        int i3 = i2 + 1;
        long j2 = (((long) bArr[i2]) & 255) << 56;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        this.b = i9 + 1;
        return j7 | (((long) bArr[i9]) & 255);
    }

    private final short e() {
        byte[] bArr = this.d;
        int i2 = this.b;
        int i3 = i2 + 1;
        int i4 = (bArr[i2] & 255) << 8;
        this.b = i3 + 1;
        return (short) ((bArr[i3] & 255) | i4);
    }

    private final int f() {
        return b() & 255;
    }

    private final long g() {
        int iB;
        int i2 = this.c;
        if (i2 == 1) {
            iB = b();
        } else if (i2 == 2) {
            iB = e();
        } else {
            if (i2 != 4) {
                if (i2 == 8) {
                    return d();
                }
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
            }
            iB = c();
        }
        return iB;
    }

    private final boolean h() {
        return b() != 0;
    }

    private final float i() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(c());
    }

    private final double j() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(d());
    }

    @NotNull
    public final List<HprofRecord.a.AbstractC0624a.C0625a.FieldRecord> b(@NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedClass");
        this.b = aVar.c;
        a();
        int iE = e() & 65535;
        ArrayList arrayList = new ArrayList(iE);
        for (int i2 = 0; i2 < iE; i2++) {
            arrayList.add(new HprofRecord.a.AbstractC0624a.C0625a.FieldRecord(g(), f()));
        }
        return arrayList;
    }

    public final boolean c(@NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedClass");
        this.b = aVar.c;
        a();
        int iE = e() & 65535;
        for (int i2 = 0; i2 < iE; i2++) {
            this.b += this.c;
            if (f() == 2) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<HprofRecord.a.AbstractC0624a.C0625a.StaticFieldRecord> a(@NotNull cm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "indexedClass");
        this.b = aVar.c;
        int iE = e() & 65535;
        ArrayList arrayList = new ArrayList(iE);
        for (int i2 = 0; i2 < iE; i2++) {
            long jG = g();
            int iF = f();
            arrayList.add(new HprofRecord.a.AbstractC0624a.C0625a.StaticFieldRecord(jG, iF, a(iF)));
        }
        return arrayList;
    }

    private final void a() {
        int iIntValue;
        int iE = e() & 65535;
        for (int i2 = 0; i2 < iE; i2++) {
            this.b += this.c;
            int iF = f();
            int i3 = this.b;
            if (iF == 2) {
                iIntValue = this.c;
            } else {
                PrimitiveType.a aVar = PrimitiveType.k;
                iIntValue = ((Number) MapsKt.getValue(PrimitiveType.m, Integer.valueOf(iF))).intValue();
            }
            this.b = i3 + iIntValue;
        }
    }
}
