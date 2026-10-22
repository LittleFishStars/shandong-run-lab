package com.huachenjie.pose_estimation.ml;

import androidx.camera.core.ImageProxy;
import com.zj.adlib.PoseEstimationResult;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH&¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/pose_estimation/ml/PoseDetector;", "Ljava/lang/AutoCloseable;", "Landroidx/camera/core/ImageProxy;", "image", "", "imageFlipped", "", "sensorRotation", "Lcom/zj/adlib/fv6;", "n", "", "", "", "Y", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public interface PoseDetector extends AutoCloseable {
    @NotNull
    Map<String, Object> Y();

    @NotNull
    PoseEstimationResult n(@NotNull ImageProxy image, boolean imageFlipped, int sensorRotation);
}
