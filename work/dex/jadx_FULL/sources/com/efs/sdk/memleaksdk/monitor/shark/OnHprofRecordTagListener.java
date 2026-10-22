package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bq, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\nJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "tag", "", "length", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "reader", "", "onHprofRecord", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public interface OnHprofRecordTagListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29811a = a.f29812a;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bq$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042 \b\u0004\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006H\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener$Companion;", "", "()V", BridgeDSL.INVOKE, "Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "block", "Lkotlin/Function3;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f29812a = new a();

        private a() {
        }
    }

    void a(@NotNull HprofRecordTag hprofRecordTag, long j, @NotNull HprofRecordReader hprofRecordReader);
}
