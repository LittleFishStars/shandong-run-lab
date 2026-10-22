package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bu, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;", "Ljava/io/Closeable;", "asStreamingSource", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", OperatePopupWindow.h, "", "sink", "Lcom/efs/sdk/memleaksdk/monitor/io/Buffer;", "position", "byteCount", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public interface RandomAccessSource extends Closeable {
    long a(@NotNull l lVar, long j, long j2) throws IOException;
}
