package com.huachenjie.base.aliyun.detect_face.analyzer;

import com.zj.adlib.TrackingInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/analyzer/AnalyzerCallback;", "", "", "tip", "", "d", "b", "c", "", "sim", "Lcom/zj/adlib/xa9;", "trackingInfo", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public interface AnalyzerCallback {
    boolean a(float sim, @NotNull TrackingInfo trackingInfo);

    void b();

    void c();

    void d(@NotNull String tip);
}
