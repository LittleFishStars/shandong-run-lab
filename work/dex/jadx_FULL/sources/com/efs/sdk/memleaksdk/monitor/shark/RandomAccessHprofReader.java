package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bt, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0019\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J<\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", "Ljava/io/Closeable;", "", "close", "T", "", "recordPosition", "recordSize", "Lkotlin/Function1;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lkotlin/ExtensionFunctionType;", "withRecordReader", "readRecord", "(JJLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/efs/sdk/memleaksdk/monitor/io/Buffer;", "buffer", "Lcom/efs/sdk/memleaksdk/monitor/io/Buffer;", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;", "source", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "hprofHeader", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class RandomAccessHprofReader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29815a = new a(0);
    private final l b;
    private final HprofRecordReader c;
    private final RandomAccessSource d;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bt$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader$Companion;", "", "()V", "openReaderFor", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessHprofReader;", "hprofSourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSourceProvider;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "hprofFile", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        @NotNull
        public final RandomAccessHprofReader a(@NotNull RandomAccessSourceProvider randomAccessSourceProvider, @NotNull HprofHeader hprofHeader) {
            Intrinsics.checkNotNullParameter(randomAccessSourceProvider, "hprofSourceProvider");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            return new RandomAccessHprofReader(randomAccessSourceProvider.b(), hprofHeader, (byte) 0);
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private RandomAccessHprofReader(RandomAccessSource randomAccessSource, HprofHeader hprofHeader) {
        this.d = randomAccessSource;
        l lVar = new l();
        this.b = lVar;
        this.c = new HprofRecordReader(hprofHeader, lVar);
    }

    public final <T> T a(long j, long j2, @NotNull Function1<? super HprofRecordReader, ? extends T> function1) throws IOException {
        long j3 = j2;
        Intrinsics.checkNotNullParameter(function1, "withRecordReader");
        if (!(j3 > 0)) {
            throw new IllegalArgumentException(("recordSize " + j3 + " must be > 0").toString());
        }
        long j4 = j;
        while (j3 > 0) {
            long jA = this.d.a(this.b, j4, j3);
            if (!(jA > 0)) {
                throw new IllegalStateException(("Requested " + j3 + " bytes after reading " + (j4 - j) + ", got 0 bytes instead.").toString());
            }
            j4 += jA;
            j3 -= jA;
        }
        T t = (T) function1.invoke(this.c);
        if (this.b.a() == 0) {
            return t;
        }
        throw new IllegalStateException(("Buffer not fully consumed: " + this.b.a() + " bytes left").toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    public /* synthetic */ RandomAccessHprofReader(RandomAccessSource randomAccessSource, HprofHeader hprofHeader, byte b) {
        this(randomAccessSource, hprofHeader);
    }
}
