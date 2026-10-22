package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class AeFpsRange {

    @Nullable
    private final Range<Integer> mAeTargetFpsRange;

    public AeFpsRange(@NonNull Quirks quirks) {
        AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk = (AeFpsRangeLegacyQuirk) quirks.get(AeFpsRangeLegacyQuirk.class);
        if (aeFpsRangeLegacyQuirk == null) {
            this.mAeTargetFpsRange = null;
        } else {
            this.mAeTargetFpsRange = aeFpsRangeLegacyQuirk.getRange();
        }
    }

    public void addAeFpsRangeOptions(@NonNull Camera2ImplConfig.Builder builder) {
        Range<Integer> range = this.mAeTargetFpsRange;
        if (range != null) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
    }
}
