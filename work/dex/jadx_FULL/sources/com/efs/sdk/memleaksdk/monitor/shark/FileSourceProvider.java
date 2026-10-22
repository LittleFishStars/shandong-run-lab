package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ao, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/FileSourceProvider;", "Lcom/efs/sdk/memleaksdk/monitor/shark/DualSourceProvider;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "openRandomAccessSource", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;", "openStreamingSource", "Lcom/efs/sdk/memleaksdk/monitor/io/BufferedSource;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class FileSourceProvider implements DualSourceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f29724a;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ao$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/efs/sdk/memleaksdk/monitor/shark/FileSourceProvider$openRandomAccessSource$1", "Lcom/efs/sdk/memleaksdk/monitor/shark/RandomAccessSource;", "close", "", OperatePopupWindow.h, "", "sink", "Lcom/efs/sdk/memleaksdk/monitor/io/Buffer;", "position", "byteCount", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a implements RandomAccessSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileChannel f29725a;

        public a(FileChannel fileChannel) {
            this.f29725a = fileChannel;
        }

        @Override // com.efs.sdk.memleaksdk.monitor.shark.RandomAccessSource
        public long a(@NotNull l lVar, long j, long j2) {
            Intrinsics.checkNotNullParameter(lVar, "sink");
            return this.f29725a.transferTo(j, j2, lVar);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f29725a.close();
        }
    }

    public FileSourceProvider(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.f29724a = file;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.StreamingSourceProvider
    @NotNull
    public n a() {
        n nVarA = p.a(p.a(new FileInputStream(this.f29724a)));
        Intrinsics.checkNotNullExpressionValue(nVarA, "Okio.buffer(\n    Okio.source(file.inputStream()))");
        return nVarA;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.RandomAccessSourceProvider
    @NotNull
    public RandomAccessSource b() {
        return new a(new FileInputStream(this.f29724a).getChannel());
    }
}
