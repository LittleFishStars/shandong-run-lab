package com.efs.sdk.memleaksdk.monitor.shark;

import com.aliyun.vod.log.core.AliyunLogCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader;", "", "", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "", "readShort", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "field", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "readValue", "identifierByteSize", "I", "position", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", AliyunLogCommon.SubModule.RECORD, "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29828a = new a(0);
    private static final int e = PrimitiveType.BOOLEAN.i;
    private static final int f = PrimitiveType.CHAR.i;
    private static final int g = PrimitiveType.FLOAT.i;
    private static final int h = PrimitiveType.DOUBLE.i;
    private static final int i = PrimitiveType.BYTE.i;
    private static final int j = PrimitiveType.SHORT.i;
    private static final int k = PrimitiveType.INT.i;
    private static final int l = PrimitiveType.LONG.i;
    private int b;
    private final HprofRecord.a.AbstractC0624a.b c;
    private final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/FieldValuesReader$Companion;", "", "()V", "BOOLEAN_TYPE", "", "BYTE_TYPE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_TYPE", "LONG_TYPE", "SHORT_TYPE", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public ci(@NotNull HprofRecord.a.AbstractC0624a.b bVar, int i2) {
        Intrinsics.checkNotNullParameter(bVar, AliyunLogCommon.SubModule.RECORD);
        this.c = bVar;
        this.d = i2;
    }

    private final long a() {
        int iC;
        int i2 = this.d;
        if (i2 == 1) {
            iC = c();
        } else if (i2 == 2) {
            iC = e();
        } else {
            if (i2 != 4) {
                if (i2 == 8) {
                    return f();
                }
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
            }
            iC = d();
        }
        return iC;
    }

    private final boolean b() {
        byte[] bArr = this.c.f29779a;
        int i2 = this.b;
        byte b = bArr[i2];
        this.b = i2 + 1;
        return b != ((byte) 0);
    }

    private final byte c() {
        byte[] bArr = this.c.f29779a;
        int i2 = this.b;
        byte b = bArr[i2];
        this.b = i2 + 1;
        return b;
    }

    private final int d() {
        int iB = ce.b(this.c.f29779a, this.b);
        this.b += 4;
        return iB;
    }

    private final short e() {
        short sA = ce.a(this.c.f29779a, this.b);
        this.b += 2;
        return sA;
    }

    private final long f() {
        long jC = ce.c(this.c.f29779a, this.b);
        this.b += 8;
        return jC;
    }

    private final float g() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(d());
    }

    private final double h() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(f());
    }

    private final char i() {
        String str = new String(this.c.f29779a, this.b, 2, Charsets.UTF_16BE);
        this.b += 2;
        return str.charAt(0);
    }

    @NotNull
    public final ValueHolder a(@NotNull HprofRecord.a.AbstractC0624a.C0625a.FieldRecord fieldRecord) {
        Intrinsics.checkNotNullParameter(fieldRecord, "field");
        int i2 = fieldRecord.type;
        if (i2 == 2) {
            return new ValueHolder.ReferenceHolder(a());
        }
        if (i2 == e) {
            return new ValueHolder.BooleanHolder(b());
        }
        if (i2 == f) {
            return new ValueHolder.CharHolder(i());
        }
        if (i2 == g) {
            return new ValueHolder.FloatHolder(g());
        }
        if (i2 == h) {
            return new ValueHolder.DoubleHolder(h());
        }
        if (i2 == i) {
            return new ValueHolder.ByteHolder(c());
        }
        if (i2 == j) {
            return new ValueHolder.ShortHolder(e());
        }
        if (i2 == k) {
            return new ValueHolder.IntHolder(d());
        }
        if (i2 == l) {
            return new ValueHolder.LongHolder(f());
        }
        throw new IllegalStateException("Unknown type " + fieldRecord.type);
    }
}
