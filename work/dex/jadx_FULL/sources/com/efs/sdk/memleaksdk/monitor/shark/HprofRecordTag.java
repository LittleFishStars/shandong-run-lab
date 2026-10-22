package com.efs.sdk.memleaksdk.monitor.shark;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bc, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "", "", "tag", "I", "getTag", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public enum HprofRecordTag {
    STRING_IN_UTF8(1),
    LOAD_CLASS(2),
    UNLOAD_CLASS(3),
    STACK_FRAME(4),
    STACK_TRACE(5),
    ALLOC_SITES(6),
    HEAP_SUMMARY(7),
    START_THREAD(10),
    END_THREAD(11),
    HEAP_DUMP(12),
    HEAP_DUMP_SEGMENT(28),
    HEAP_DUMP_END(44),
    CPU_SAMPLES(13),
    CONTROL_SETTINGS(14),
    ROOT_UNKNOWN(255),
    ROOT_JNI_GLOBAL(1),
    ROOT_JNI_LOCAL(2),
    ROOT_JAVA_FRAME(3),
    ROOT_NATIVE_STACK(4),
    ROOT_STICKY_CLASS(5),
    ROOT_THREAD_BLOCK(6),
    ROOT_MONITOR_USED(7),
    ROOT_THREAD_OBJECT(8),
    HEAP_DUMP_INFO(254),
    ROOT_INTERNED_STRING(137),
    ROOT_FINALIZING(138),
    ROOT_DEBUGGER(139),
    ROOT_REFERENCE_CLEANUP(140),
    ROOT_VM_INTERNAL(141),
    ROOT_JNI_MONITOR(142),
    ROOT_UNREACHABLE(144),
    PRIMITIVE_ARRAY_NODATA(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO),
    CLASS_DUMP(32),
    INSTANCE_DUMP(33),
    OBJECT_ARRAY_DUMP(34),
    PRIMITIVE_ARRAY_DUMP(35);


    @NotNull
    public static final a L;

    @NotNull
    private static final EnumSet<HprofRecordTag> N;
    final int K;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bc$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag$Companion;", "", "()V", "rootTags", "Ljava/util/EnumSet;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "getRootTags", "()Ljava/util/EnumSet;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        HprofRecordTag hprofRecordTag = ROOT_UNKNOWN;
        HprofRecordTag hprofRecordTag2 = ROOT_JNI_GLOBAL;
        HprofRecordTag hprofRecordTag3 = ROOT_JNI_LOCAL;
        HprofRecordTag hprofRecordTag4 = ROOT_JAVA_FRAME;
        HprofRecordTag hprofRecordTag5 = ROOT_NATIVE_STACK;
        HprofRecordTag hprofRecordTag6 = ROOT_STICKY_CLASS;
        HprofRecordTag hprofRecordTag7 = ROOT_THREAD_BLOCK;
        HprofRecordTag hprofRecordTag8 = ROOT_MONITOR_USED;
        HprofRecordTag hprofRecordTag9 = ROOT_THREAD_OBJECT;
        HprofRecordTag hprofRecordTag10 = ROOT_INTERNED_STRING;
        HprofRecordTag hprofRecordTag11 = ROOT_FINALIZING;
        HprofRecordTag hprofRecordTag12 = ROOT_DEBUGGER;
        HprofRecordTag hprofRecordTag13 = ROOT_REFERENCE_CLEANUP;
        HprofRecordTag hprofRecordTag14 = ROOT_VM_INTERNAL;
        HprofRecordTag hprofRecordTag15 = ROOT_JNI_MONITOR;
        HprofRecordTag hprofRecordTag16 = ROOT_UNREACHABLE;
        L = new a((byte) 0);
        EnumSet<HprofRecordTag> enumSetOf = EnumSet.of(hprofRecordTag, hprofRecordTag2, hprofRecordTag3, hprofRecordTag4, hprofRecordTag5, hprofRecordTag6, hprofRecordTag7, hprofRecordTag8, hprofRecordTag9, hprofRecordTag10, hprofRecordTag11, hprofRecordTag12, hprofRecordTag13, hprofRecordTag14, hprofRecordTag15, hprofRecordTag16);
        Intrinsics.checkNotNullExpressionValue(enumSetOf, "EnumSet.of(\n      ROOT_U…   ROOT_UNREACHABLE\n    )");
        N = enumSetOf;
    }

    HprofRecordTag(int i) {
        this.K = i;
    }
}
