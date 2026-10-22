package com.efs.sdk.memleaksdk.monitor.shark;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bz, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader;", "", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "recordTags", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "readRecords", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "header", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;", "sourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class StreamingHprofReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29818a = new a(0);
    private final StreamingSourceProvider b;
    private final HprofHeader c;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bz$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader$Companion;", "", "()V", "readerFor", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingHprofReader;", "hprofSourceProvider", "Lcom/efs/sdk/memleaksdk/monitor/shark/StreamingSourceProvider;", "hprofHeader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofHeader;", "hprofFile", "Ljava/io/File;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        @NotNull
        public final StreamingHprofReader a(@NotNull StreamingSourceProvider streamingSourceProvider, @NotNull HprofHeader hprofHeader) {
            Intrinsics.checkNotNullParameter(streamingSourceProvider, "hprofSourceProvider");
            Intrinsics.checkNotNullParameter(hprofHeader, "hprofHeader");
            return new StreamingHprofReader(streamingSourceProvider, hprofHeader, (byte) 0);
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private StreamingHprofReader(StreamingSourceProvider streamingSourceProvider, HprofHeader hprofHeader) {
        this.b = streamingSourceProvider;
        this.c = hprofHeader;
    }

    public final long a(@NotNull Set<? extends HprofRecordTag> set, @NotNull OnHprofRecordTagListener onHprofRecordTagListener) {
        Intrinsics.checkNotNullParameter(set, "recordTags");
        Intrinsics.checkNotNullParameter(onHprofRecordTagListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        n nVarA = this.b.a();
        try {
            HprofRecordReader hprofRecordReader = new HprofRecordReader(this.c, nVarA);
            hprofRecordReader.a(this.c.f29764a);
            int i = PrimitiveType.INT.j;
            int i2 = hprofRecordReader.b[2];
            while (!nVarA.b()) {
                int iE = hprofRecordReader.E();
                hprofRecordReader.a(i);
                long jD = hprofRecordReader.D();
                HprofRecordTag hprofRecordTag = HprofRecordTag.STRING_IN_UTF8;
                if (iE != hprofRecordTag.K) {
                    HprofRecordTag hprofRecordTag2 = HprofRecordTag.LOAD_CLASS;
                    if (iE != hprofRecordTag2.K) {
                        HprofRecordTag hprofRecordTag3 = HprofRecordTag.STACK_FRAME;
                        if (iE != hprofRecordTag3.K) {
                            HprofRecordTag hprofRecordTag4 = HprofRecordTag.STACK_TRACE;
                            if (iE != hprofRecordTag4.K) {
                                if (iE == HprofRecordTag.HEAP_DUMP.K || iE == HprofRecordTag.HEAP_DUMP_SEGMENT.K) {
                                    long j = hprofRecordReader.f29789a;
                                    long j2 = 0;
                                    int i3 = 0;
                                    while (true) {
                                        long j3 = hprofRecordReader.f29789a;
                                        if (j3 - j >= jD) {
                                            break;
                                        }
                                        int iE2 = hprofRecordReader.E();
                                        HprofRecordTag hprofRecordTag5 = HprofRecordTag.ROOT_UNKNOWN;
                                        long j4 = j;
                                        int i4 = i3;
                                        if (iE2 != hprofRecordTag5.K) {
                                            HprofRecordTag hprofRecordTag6 = HprofRecordTag.ROOT_JNI_GLOBAL;
                                            if (iE2 != hprofRecordTag6.K) {
                                                HprofRecordTag hprofRecordTag7 = HprofRecordTag.ROOT_JNI_LOCAL;
                                                if (iE2 != hprofRecordTag7.K) {
                                                    HprofRecordTag hprofRecordTag8 = HprofRecordTag.ROOT_JAVA_FRAME;
                                                    if (iE2 != hprofRecordTag8.K) {
                                                        HprofRecordTag hprofRecordTag9 = HprofRecordTag.ROOT_NATIVE_STACK;
                                                        if (iE2 != hprofRecordTag9.K) {
                                                            HprofRecordTag hprofRecordTag10 = HprofRecordTag.ROOT_STICKY_CLASS;
                                                            if (iE2 != hprofRecordTag10.K) {
                                                                HprofRecordTag hprofRecordTag11 = HprofRecordTag.ROOT_THREAD_BLOCK;
                                                                if (iE2 != hprofRecordTag11.K) {
                                                                    HprofRecordTag hprofRecordTag12 = HprofRecordTag.ROOT_MONITOR_USED;
                                                                    if (iE2 != hprofRecordTag12.K) {
                                                                        HprofRecordTag hprofRecordTag13 = HprofRecordTag.ROOT_THREAD_OBJECT;
                                                                        if (iE2 != hprofRecordTag13.K) {
                                                                            HprofRecordTag hprofRecordTag14 = HprofRecordTag.ROOT_INTERNED_STRING;
                                                                            if (iE2 != hprofRecordTag14.K) {
                                                                                HprofRecordTag hprofRecordTag15 = HprofRecordTag.ROOT_FINALIZING;
                                                                                if (iE2 != hprofRecordTag15.K) {
                                                                                    HprofRecordTag hprofRecordTag16 = HprofRecordTag.ROOT_DEBUGGER;
                                                                                    if (iE2 != hprofRecordTag16.K) {
                                                                                        HprofRecordTag hprofRecordTag17 = HprofRecordTag.ROOT_REFERENCE_CLEANUP;
                                                                                        if (iE2 != hprofRecordTag17.K) {
                                                                                            HprofRecordTag hprofRecordTag18 = HprofRecordTag.ROOT_VM_INTERNAL;
                                                                                            if (iE2 != hprofRecordTag18.K) {
                                                                                                HprofRecordTag hprofRecordTag19 = HprofRecordTag.ROOT_JNI_MONITOR;
                                                                                                if (iE2 != hprofRecordTag19.K) {
                                                                                                    HprofRecordTag hprofRecordTag20 = HprofRecordTag.ROOT_UNREACHABLE;
                                                                                                    if (iE2 != hprofRecordTag20.K) {
                                                                                                        HprofRecordTag hprofRecordTag21 = HprofRecordTag.CLASS_DUMP;
                                                                                                        if (iE2 != hprofRecordTag21.K) {
                                                                                                            HprofRecordTag hprofRecordTag22 = HprofRecordTag.INSTANCE_DUMP;
                                                                                                            if (iE2 != hprofRecordTag22.K) {
                                                                                                                HprofRecordTag hprofRecordTag23 = HprofRecordTag.OBJECT_ARRAY_DUMP;
                                                                                                                if (iE2 != hprofRecordTag23.K) {
                                                                                                                    HprofRecordTag hprofRecordTag24 = HprofRecordTag.PRIMITIVE_ARRAY_DUMP;
                                                                                                                    if (iE2 != hprofRecordTag24.K) {
                                                                                                                        HprofRecordTag hprofRecordTag25 = HprofRecordTag.PRIMITIVE_ARRAY_NODATA;
                                                                                                                        if (iE2 == hprofRecordTag25.K) {
                                                                                                                            throw new UnsupportedOperationException(hprofRecordTag25 + " cannot be parsed");
                                                                                                                        }
                                                                                                                        HprofRecordTag hprofRecordTag26 = HprofRecordTag.HEAP_DUMP_INFO;
                                                                                                                        if (iE2 != hprofRecordTag26.K) {
                                                                                                                            StringBuilder sb = new StringBuilder();
                                                                                                                            sb.append("Unknown tag ");
                                                                                                                            String str = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(iE2)}, 1));
                                                                                                                            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
                                                                                                                            sb.append(str);
                                                                                                                            sb.append(" at ");
                                                                                                                            sb.append(j3);
                                                                                                                            sb.append(" after ");
                                                                                                                            String str2 = String.format("0x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
                                                                                                                            Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(this, *args)");
                                                                                                                            sb.append(str2);
                                                                                                                            sb.append(" at ");
                                                                                                                            sb.append(j2);
                                                                                                                            throw new IllegalStateException(sb.toString());
                                                                                                                        }
                                                                                                                        if (set.contains(hprofRecordTag26)) {
                                                                                                                            onHprofRecordTagListener.a(hprofRecordTag26, -1L, hprofRecordReader);
                                                                                                                        } else {
                                                                                                                            hprofRecordReader.C();
                                                                                                                        }
                                                                                                                    } else if (set.contains(hprofRecordTag24)) {
                                                                                                                        onHprofRecordTagListener.a(hprofRecordTag24, -1L, hprofRecordReader);
                                                                                                                    } else {
                                                                                                                        hprofRecordReader.B();
                                                                                                                    }
                                                                                                                } else if (set.contains(hprofRecordTag23)) {
                                                                                                                    onHprofRecordTagListener.a(hprofRecordTag23, -1L, hprofRecordReader);
                                                                                                                } else {
                                                                                                                    hprofRecordReader.A();
                                                                                                                }
                                                                                                            } else if (set.contains(hprofRecordTag22)) {
                                                                                                                onHprofRecordTagListener.a(hprofRecordTag22, -1L, hprofRecordReader);
                                                                                                            } else {
                                                                                                                hprofRecordReader.y();
                                                                                                            }
                                                                                                        } else if (set.contains(hprofRecordTag21)) {
                                                                                                            onHprofRecordTagListener.a(hprofRecordTag21, -1L, hprofRecordReader);
                                                                                                        } else {
                                                                                                            hprofRecordReader.z();
                                                                                                        }
                                                                                                    } else if (set.contains(hprofRecordTag20)) {
                                                                                                        onHprofRecordTagListener.a(hprofRecordTag20, -1L, hprofRecordReader);
                                                                                                    } else {
                                                                                                        hprofRecordReader.a(i2);
                                                                                                    }
                                                                                                } else if (set.contains(hprofRecordTag19)) {
                                                                                                    onHprofRecordTagListener.a(hprofRecordTag19, -1L, hprofRecordReader);
                                                                                                } else {
                                                                                                    hprofRecordReader.a(i2 + i + i);
                                                                                                }
                                                                                            } else if (set.contains(hprofRecordTag18)) {
                                                                                                onHprofRecordTagListener.a(hprofRecordTag18, -1L, hprofRecordReader);
                                                                                            } else {
                                                                                                hprofRecordReader.a(i2);
                                                                                            }
                                                                                        } else if (set.contains(hprofRecordTag17)) {
                                                                                            onHprofRecordTagListener.a(hprofRecordTag17, -1L, hprofRecordReader);
                                                                                        } else {
                                                                                            hprofRecordReader.a(i2);
                                                                                        }
                                                                                    } else if (set.contains(hprofRecordTag16)) {
                                                                                        onHprofRecordTagListener.a(hprofRecordTag16, -1L, hprofRecordReader);
                                                                                    } else {
                                                                                        hprofRecordReader.a(i2);
                                                                                    }
                                                                                } else if (set.contains(hprofRecordTag15)) {
                                                                                    onHprofRecordTagListener.a(hprofRecordTag15, -1L, hprofRecordReader);
                                                                                } else {
                                                                                    hprofRecordReader.a(i2);
                                                                                }
                                                                            } else if (set.contains(hprofRecordTag14)) {
                                                                                onHprofRecordTagListener.a(hprofRecordTag14, -1L, hprofRecordReader);
                                                                            } else {
                                                                                hprofRecordReader.a(i2);
                                                                            }
                                                                        } else if (set.contains(hprofRecordTag13)) {
                                                                            onHprofRecordTagListener.a(hprofRecordTag13, -1L, hprofRecordReader);
                                                                        } else {
                                                                            hprofRecordReader.a(i2 + i + i);
                                                                        }
                                                                    } else if (set.contains(hprofRecordTag12)) {
                                                                        onHprofRecordTagListener.a(hprofRecordTag12, -1L, hprofRecordReader);
                                                                    } else {
                                                                        hprofRecordReader.a(i2);
                                                                    }
                                                                } else if (set.contains(hprofRecordTag11)) {
                                                                    onHprofRecordTagListener.a(hprofRecordTag11, -1L, hprofRecordReader);
                                                                } else {
                                                                    hprofRecordReader.a(i2 + i);
                                                                }
                                                            } else if (set.contains(hprofRecordTag10)) {
                                                                onHprofRecordTagListener.a(hprofRecordTag10, -1L, hprofRecordReader);
                                                            } else {
                                                                hprofRecordReader.a(i2);
                                                            }
                                                        } else if (set.contains(hprofRecordTag9)) {
                                                            onHprofRecordTagListener.a(hprofRecordTag9, -1L, hprofRecordReader);
                                                        } else {
                                                            hprofRecordReader.a(i2 + i);
                                                        }
                                                    } else if (set.contains(hprofRecordTag8)) {
                                                        onHprofRecordTagListener.a(hprofRecordTag8, -1L, hprofRecordReader);
                                                    } else {
                                                        hprofRecordReader.a(i2 + i + i);
                                                    }
                                                } else if (set.contains(hprofRecordTag7)) {
                                                    onHprofRecordTagListener.a(hprofRecordTag7, -1L, hprofRecordReader);
                                                } else {
                                                    hprofRecordReader.a(i2 + i + i);
                                                }
                                            } else if (set.contains(hprofRecordTag6)) {
                                                onHprofRecordTagListener.a(hprofRecordTag6, -1L, hprofRecordReader);
                                            } else {
                                                hprofRecordReader.a(i2 + i2);
                                            }
                                        } else if (set.contains(hprofRecordTag5)) {
                                            onHprofRecordTagListener.a(hprofRecordTag5, -1L, hprofRecordReader);
                                        } else {
                                            hprofRecordReader.a(i2);
                                        }
                                        j2 = j3;
                                        i3 = iE2;
                                        j = j4;
                                    }
                                } else {
                                    HprofRecordTag hprofRecordTag27 = HprofRecordTag.HEAP_DUMP_END;
                                    if (iE != hprofRecordTag27.K) {
                                        hprofRecordReader.a(jD);
                                    } else if (set.contains(hprofRecordTag27)) {
                                        onHprofRecordTagListener.a(hprofRecordTag27, jD, hprofRecordReader);
                                    }
                                }
                            } else if (set.contains(hprofRecordTag4)) {
                                onHprofRecordTagListener.a(hprofRecordTag4, jD, hprofRecordReader);
                            } else {
                                hprofRecordReader.a(jD);
                            }
                        } else if (set.contains(hprofRecordTag3)) {
                            onHprofRecordTagListener.a(hprofRecordTag3, jD, hprofRecordReader);
                        } else {
                            hprofRecordReader.a(jD);
                        }
                    } else if (set.contains(hprofRecordTag2)) {
                        onHprofRecordTagListener.a(hprofRecordTag2, jD, hprofRecordReader);
                    } else {
                        hprofRecordReader.a(jD);
                    }
                } else if (set.contains(hprofRecordTag)) {
                    onHprofRecordTagListener.a(hprofRecordTag, jD, hprofRecordReader);
                } else {
                    hprofRecordReader.a(jD);
                }
            }
            long j5 = hprofRecordReader.f29789a;
            CloseableKt.closeFinally(nVarA, (Throwable) null);
            return j5;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(nVarA, th);
                throw th2;
            }
        }
    }

    public /* synthetic */ StreamingHprofReader(StreamingSourceProvider streamingSourceProvider, HprofHeader hprofHeader, byte b) {
        this(streamingSourceProvider, hprofHeader);
    }
}
