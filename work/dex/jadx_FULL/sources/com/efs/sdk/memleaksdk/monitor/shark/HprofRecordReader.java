package com.efs.sdk.memleaksdk.monitor.shark;

import com.coremedia.iso.boxes.FreeSpaceBox;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bb, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0080\u0001B\u0019\b\u0000\u0012\u0006\u0010}\u001a\u00020|\u0012\u0006\u0010x\u001a\u00020w¢\u0006\u0004\b~\u0010\u007fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020!J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020*J\u0006\u0010-\u001a\u00020,J\u0006\u0010/\u001a\u00020.J\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u000202J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u00020!J\u000e\u00107\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u00109\u001a\u000208J\u0006\u0010;\u001a\u00020:J\u0006\u0010=\u001a\u00020<J\u0006\u0010?\u001a\u00020>J\u0006\u0010A\u001a\u00020@J\u0006\u0010C\u001a\u00020BJ\u000e\u0010E\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010G\u001a\u00020FJ\u0006\u0010I\u001a\u00020HJ\u0006\u0010K\u001a\u00020JJ\u0016\u0010O\u001a\u00020N2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010M\u001a\u00020LJ\u000e\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020!J\u0006\u0010T\u001a\u00020SJ\u0006\u0010V\u001a\u00020UJ\u0006\u0010X\u001a\u00020WJ\u0006\u0010Z\u001a\u00020YJ\u0006\u0010[\u001a\u00020\u0004J\u0006\u0010\\\u001a\u00020!J\u0006\u0010]\u001a\u00020\u0004J\u000e\u0010^\u001a\u00020N2\u0006\u0010\n\u001a\u00020!J\u000e\u0010a\u001a\u00020`2\u0006\u0010_\u001a\u00020\u0004J\u0006\u0010c\u001a\u00020bJ\u000e\u0010d\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010f\u001a\u00020e2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010f\u001a\u00020e2\u0006\u0010\n\u001a\u00020!J\u0006\u0010g\u001a\u00020eJ\u0006\u0010h\u001a\u00020eJ\u0006\u0010i\u001a\u00020eJ\u0006\u0010j\u001a\u00020eJ\u0006\u0010k\u001a\u00020eJ\u0006\u0010l\u001a\u00020eJ\u0006\u0010m\u001a\u00020eJ\u0006\u0010n\u001a\u00020eJ\u0006\u0010o\u001a\u00020eR$\u0010q\u001a\u00020!2\u0006\u0010p\u001a\u00020!8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010u\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{¨\u0006\u0081\u0001"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "", "", "readBoolean", "", "arrayLength", "", "readBooleanArray", "", "readByte", "byteCount", "", "readByteArray", "", "readChar", "", "readCharArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readClassDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Debugger;", "readDebuggerGcRootRecord", "", "readDouble", "", "readDoubleArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Finalizing;", "readFinalizingGcRootRecord", "", "readFloat", "", "readFloatArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "readHeapDumpInfoRecord", "", "readId", "", "readIdArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "readInstanceDumpRecord", "readInt", "", "readIntArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$InternedString;", "readInternedStringGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JavaFrame;", "readJavaFrameGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniGlobal;", "readJniGlobalGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniLocal;", "readJniLocalGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$JniMonitor;", "readJniMonitorGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$LoadClassRecord;", "readLoadClassRecord", "readLong", "readLongArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$MonitorUsed;", "readMonitorUsedGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$NativeStack;", "readNativeStackGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArrayDumpRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ReferenceCleanup;", "readReferenceCleanupGcRootRecord", "", "readShort", "", "readShortArray", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StackFrameRecord;", "readStackFrameRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StackTraceRecord;", "readStackTraceRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$StickyClass;", "readStickyClassGcRootRecord", "Ljava/nio/charset/Charset;", "charset", "", "readString", "length", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecord$StringRecord;", "readStringRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadBlock;", "readThreadBlockGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$ThreadObject;", "readThreadObjectGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unknown;", "readUnknownGcRootRecord", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$Unreachable;", "readUnreachableGcRootRecord", "readUnsignedByte", "readUnsignedInt", "readUnsignedShort", "readUtf8", "type", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "readValue", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot$VmInternal;", "readVmInternalGcRootRecord", "sizeOf", "", FreeSpaceBox.TYPE, "skipClassDumpConstantPool", "skipClassDumpFields", "skipClassDumpHeader", "skipClassDumpRecord", "skipClassDumpStaticFields", "skipHeapDumpInfoRecord", "skipInstanceDumpRecord", "skipObjectArrayDumpRecord", "skipPrimitiveArrayDumpRecord", "<set-?>", "bytesRead", "J", "getBytesRead", "()J", "identifierByteSize", "I", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", "source", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", "typeSizes", "[I", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "header", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class HprofRecordReader {

    @NotNull
    public static final a c = new a(0);
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    private static final int n;
    private static final int o;
    private static final int p;
    private static final int q;
    private static final int r;
    private static final int s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29789a;
    final int[] b;
    private final int d;
    private final n e;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bb$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader$Companion;", "", "()V", "BOOLEAN_SIZE", "", "BOOLEAN_TYPE", "BYTE_MASK", "BYTE_SIZE", "BYTE_TYPE", "CHAR_SIZE", "CHAR_TYPE", "DOUBLE_TYPE", "FLOAT_TYPE", "INT_MASK", "", "INT_SIZE", "INT_TYPE", "LONG_SIZE", "LONG_TYPE", "SHORT_SIZE", "SHORT_TYPE", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        PrimitiveType primitiveType = PrimitiveType.BOOLEAN;
        f = primitiveType.j;
        PrimitiveType primitiveType2 = PrimitiveType.CHAR;
        g = primitiveType2.j;
        PrimitiveType primitiveType3 = PrimitiveType.BYTE;
        h = primitiveType3.j;
        PrimitiveType primitiveType4 = PrimitiveType.SHORT;
        i = primitiveType4.j;
        PrimitiveType primitiveType5 = PrimitiveType.INT;
        j = primitiveType5.j;
        PrimitiveType primitiveType6 = PrimitiveType.LONG;
        k = primitiveType6.j;
        l = primitiveType.i;
        m = primitiveType2.i;
        n = PrimitiveType.FLOAT.i;
        o = PrimitiveType.DOUBLE.i;
        p = primitiveType3.i;
        q = primitiveType4.i;
        r = primitiveType5.i;
        s = primitiveType6.i;
    }

    public HprofRecordReader(@NotNull HprofHeader hprofHeader, @NotNull n nVar) {
        Intrinsics.checkNotNullParameter(hprofHeader, "header");
        Intrinsics.checkNotNullParameter(nVar, "source");
        this.e = nVar;
        int i2 = hprofHeader.identifierByteSize;
        this.d = i2;
        PrimitiveType.a aVar = PrimitiveType.k;
        Map mapPlus = MapsKt.plus(PrimitiveType.m, TuplesKt.to(2, Integer.valueOf(i2)));
        Object objMax = CollectionsKt.max(mapPlus.keySet());
        Intrinsics.checkNotNull(objMax);
        int iIntValue = ((Number) objMax).intValue() + 1;
        int[] iArr = new int[iIntValue];
        for (int i3 = 0; i3 < iIntValue; i3++) {
            Integer num = (Integer) mapPlus.get(Integer.valueOf(i3));
            iArr[i3] = num != null ? num.intValue() : 0;
        }
        this.b = iArr;
    }

    public final void A() throws IOException {
        a(this.d + j);
        int iG = G();
        int i2 = this.d;
        a(i2 + (iG * i2));
    }

    public final void B() throws IOException {
        a(this.d + j);
        a(G() * this.b[E()]);
    }

    public final void C() throws IOException {
        int i2 = this.d;
        a(i2 + i2);
    }

    public final long D() {
        return ((long) G()) & 4294967295L;
    }

    public final int E() {
        return I() & 255;
    }

    public final short F() {
        this.f29789a += (long) i;
        return this.e.d();
    }

    public final int G() {
        this.f29789a += (long) j;
        return this.e.e();
    }

    public final long H() {
        this.f29789a += (long) k;
        return this.e.f();
    }

    public final byte I() {
        this.f29789a += (long) h;
        return this.e.c();
    }

    public final boolean J() {
        this.f29789a += (long) f;
        return this.e.c() != 0;
    }

    public final char K() {
        return a(g, Charsets.UTF_16BE).charAt(0);
    }

    public final float L() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(G());
    }

    public final double M() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(H());
    }

    public final long N() {
        int I;
        int i2 = this.d;
        if (i2 == 1) {
            I = I();
        } else if (i2 == 2) {
            I = F();
        } else {
            if (i2 != 4) {
                if (i2 == 8) {
                    return H();
                }
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
            }
            I = G();
        }
        return I;
    }

    public final int O() {
        return F() & 65535;
    }

    @NotNull
    public final GcRoot.n a() {
        return new GcRoot.n(N());
    }

    @NotNull
    public final GcRoot.e b() {
        return new GcRoot.e(N(), N());
    }

    @NotNull
    public final GcRoot.f c() {
        return new GcRoot.f(N(), G(), G());
    }

    @NotNull
    public final GcRoot.d d() {
        return new GcRoot.d(N(), G(), G());
    }

    @NotNull
    public final GcRoot.i e() {
        return new GcRoot.i(N(), G());
    }

    @NotNull
    public final GcRoot.k f() {
        return new GcRoot.k(N());
    }

    @NotNull
    public final GcRoot.l g() {
        return new GcRoot.l(N(), G());
    }

    @NotNull
    public final GcRoot.h h() {
        return new GcRoot.h(N());
    }

    @NotNull
    public final GcRoot.m i() {
        return new GcRoot.m(N(), G(), G());
    }

    @NotNull
    public final GcRoot.c j() {
        return new GcRoot.c(N());
    }

    @NotNull
    public final GcRoot.b k() {
        return new GcRoot.b(N());
    }

    @NotNull
    public final GcRoot.a l() {
        return new GcRoot.a(N());
    }

    @NotNull
    public final GcRoot.j m() {
        return new GcRoot.j(N());
    }

    @NotNull
    public final GcRoot.p n() {
        return new GcRoot.p(N());
    }

    @NotNull
    public final GcRoot.g o() {
        return new GcRoot.g(N(), G(), G());
    }

    @NotNull
    public final GcRoot.o p() {
        return new GcRoot.o(N());
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.b q() {
        return new HprofRecord.a.AbstractC0624a.b(N(), G(), N(), k(G()));
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.C0625a r() throws IOException {
        HprofRecordReader hprofRecordReader = this;
        long jN = N();
        int iG = G();
        long jN2 = N();
        long jN3 = N();
        long jN4 = N();
        long jN5 = N();
        N();
        N();
        int iG2 = G();
        int iO = O();
        for (int i2 = 0; i2 < iO; i2++) {
            hprofRecordReader.a(i);
            hprofRecordReader.a(hprofRecordReader.b[E()]);
        }
        int iO2 = O();
        ArrayList arrayList = new ArrayList(iO2);
        int i3 = 0;
        while (i3 < iO2) {
            long j2 = jN5;
            long jN6 = N();
            int i4 = iO2;
            int iE = E();
            arrayList.add(new HprofRecord.a.AbstractC0624a.C0625a.StaticFieldRecord(jN6, iE, hprofRecordReader.b(iE)));
            i3++;
            hprofRecordReader = this;
            jN5 = j2;
            iO2 = i4;
            iG2 = iG2;
        }
        long j3 = jN5;
        int i5 = iG2;
        int iO3 = O();
        ArrayList arrayList2 = new ArrayList(iO3);
        int i6 = 0;
        while (i6 < iO3) {
            arrayList2.add(new HprofRecord.a.AbstractC0624a.C0625a.FieldRecord(N(), E()));
            i6++;
            iO3 = iO3;
        }
        return new HprofRecord.a.AbstractC0624a.C0625a(jN, iG, jN2, jN3, jN4, j3, i5, arrayList, arrayList2);
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.d s() {
        long jN = N();
        int iG = G();
        int iG2 = G();
        int iE = E();
        if (iE == l) {
            return new HprofRecord.a.AbstractC0624a.d.C0627a(jN, iG, d(iG2));
        }
        if (iE == m) {
            return new HprofRecord.a.AbstractC0624a.d.c(jN, iG, e(iG2));
        }
        if (iE == n) {
            return new HprofRecord.a.AbstractC0624a.d.e(jN, iG, f(iG2));
        }
        if (iE == o) {
            return new HprofRecord.a.AbstractC0624a.d.C0628d(jN, iG, g(iG2));
        }
        if (iE == p) {
            return new HprofRecord.a.AbstractC0624a.d.b(jN, iG, k(iG2));
        }
        if (iE == q) {
            return new HprofRecord.a.AbstractC0624a.d.h(jN, iG, h(iG2));
        }
        if (iE == r) {
            return new HprofRecord.a.AbstractC0624a.d.f(jN, iG, i(iG2));
        }
        if (iE == s) {
            return new HprofRecord.a.AbstractC0624a.d.g(jN, iG, j(iG2));
        }
        throw new IllegalStateException("Unexpected type " + iE);
    }

    @NotNull
    public final HprofRecord.a.AbstractC0624a.c t() {
        return new HprofRecord.a.AbstractC0624a.c(N(), G(), N(), c(G()));
    }

    public final void u() throws IOException {
        a((j * 2) + (this.d * 7));
        v();
    }

    public final void v() throws IOException {
        int iO = O();
        for (int i2 = 0; i2 < iO; i2++) {
            a(PrimitiveType.SHORT.j);
            a(this.b[E()]);
        }
    }

    public final void w() throws IOException {
        int iIntValue;
        int iO = O();
        for (int i2 = 0; i2 < iO; i2++) {
            a(this.d);
            int iE = E();
            if (iE == 2) {
                iIntValue = this.d;
            } else {
                PrimitiveType.a aVar = PrimitiveType.k;
                iIntValue = ((Number) MapsKt.getValue(PrimitiveType.m, Integer.valueOf(iE))).intValue();
            }
            a(iIntValue);
        }
    }

    public final void x() throws IOException {
        a((this.d + 1) * O());
    }

    public final void y() throws IOException {
        int i2 = this.d;
        a(j + i2 + i2);
        a(G());
    }

    public final void z() throws IOException {
        int i2 = this.d;
        int i3 = j;
        a(i2 + i3 + i2 + i2 + i2 + i2 + i2 + i2 + i3);
        int iO = O();
        for (int i4 = 0; i4 < iO; i4++) {
            a(i);
            a(this.b[E()]);
        }
        int iO2 = O();
        for (int i5 = 0; i5 < iO2; i5++) {
            a(this.d);
            a(this.b[E()]);
        }
        a(O() * (this.d + h));
    }

    public final void a(int i2) throws IOException {
        long j2 = i2;
        this.f29789a += j2;
        this.e.c(j2);
    }

    @NotNull
    public final float[] f(int i2) {
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = L();
        }
        return fArr;
    }

    @NotNull
    public final double[] g(int i2) {
        double[] dArr = new double[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            dArr[i3] = M();
        }
        return dArr;
    }

    @NotNull
    public final short[] h(int i2) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = F();
        }
        return sArr;
    }

    @NotNull
    public final long[] j(int i2) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = H();
        }
        return jArr;
    }

    @NotNull
    public final byte[] k(int i2) throws IOException {
        long j2 = i2;
        this.f29789a += j2;
        byte[] bArrB = this.e.b(j2);
        Intrinsics.checkNotNullExpressionValue(bArrB, "source.readByteArray(byteCount.toLong())");
        return bArrB;
    }

    public final void a(long j2) throws IOException {
        this.f29789a += j2;
        this.e.c(j2);
    }

    @NotNull
    public final ValueHolder b(int i2) {
        if (i2 == 2) {
            return new ValueHolder.ReferenceHolder(N());
        }
        if (i2 == l) {
            return new ValueHolder.BooleanHolder(J());
        }
        if (i2 == m) {
            return new ValueHolder.CharHolder(K());
        }
        if (i2 == n) {
            return new ValueHolder.FloatHolder(L());
        }
        if (i2 == o) {
            return new ValueHolder.DoubleHolder(M());
        }
        if (i2 == p) {
            return new ValueHolder.ByteHolder(I());
        }
        if (i2 == q) {
            return new ValueHolder.ShortHolder(F());
        }
        if (i2 == r) {
            return new ValueHolder.IntHolder(G());
        }
        if (i2 == s) {
            return new ValueHolder.LongHolder(H());
        }
        throw new IllegalStateException("Unknown type " + i2);
    }

    @NotNull
    public final char[] e(int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = K();
        }
        return cArr;
    }

    @NotNull
    public final String a(int i2, @NotNull Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        long j2 = i2;
        this.f29789a += j2;
        String strA = this.e.a(j2, charset);
        Intrinsics.checkNotNullExpressionValue(strA, "source.readString(byteCount.toLong(), charset)");
        return strA;
    }

    @NotNull
    public final long[] c(int i2) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = N();
        }
        return jArr;
    }

    @NotNull
    public final boolean[] d(int i2) {
        boolean[] zArr = new boolean[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            zArr[i3] = I() != 0;
        }
        return zArr;
    }

    @NotNull
    public final int[] i(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = G();
        }
        return iArr;
    }

    @NotNull
    public final String b(long j2) throws IOException {
        this.f29789a += j2;
        String strA = this.e.a(j2);
        Intrinsics.checkNotNullExpressionValue(strA, "source.readUtf8(byteCount)");
        return strA;
    }
}
