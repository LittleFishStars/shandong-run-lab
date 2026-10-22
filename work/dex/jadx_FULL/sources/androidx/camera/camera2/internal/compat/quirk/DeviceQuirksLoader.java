package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    @NonNull
    public static List<Quirk> loadQuirks() {
        ArrayList arrayList = new ArrayList();
        if (ImageCapturePixelHDRPlusQuirk.load()) {
            arrayList.add(new ImageCapturePixelHDRPlusQuirk());
        }
        if (ExtraCroppingQuirk.load()) {
            arrayList.add(new ExtraCroppingQuirk());
        }
        if (Nexus4AndroidLTargetAspectRatioQuirk.load()) {
            arrayList.add(new Nexus4AndroidLTargetAspectRatioQuirk());
        }
        if (ExcludedSupportedSizesQuirk.load()) {
            arrayList.add(new ExcludedSupportedSizesQuirk());
        }
        if (CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.load()) {
            arrayList.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
        }
        if (PreviewPixelHDRnetQuirk.load()) {
            arrayList.add(new PreviewPixelHDRnetQuirk());
        }
        if (StillCaptureFlashStopRepeatingQuirk.load()) {
            arrayList.add(new StillCaptureFlashStopRepeatingQuirk());
        }
        if (ExtraSupportedSurfaceCombinationsQuirk.load()) {
            arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
        }
        if (FlashAvailabilityBufferUnderflowQuirk.load()) {
            arrayList.add(new FlashAvailabilityBufferUnderflowQuirk());
        }
        if (RepeatingStreamConstraintForVideoRecordingQuirk.load()) {
            arrayList.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
        }
        if (TextureViewIsClosedQuirk.load()) {
            arrayList.add(new TextureViewIsClosedQuirk());
        }
        if (CaptureSessionOnClosedNotCalledQuirk.load()) {
            arrayList.add(new CaptureSessionOnClosedNotCalledQuirk());
        }
        if (TorchIsClosedAfterImageCapturingQuirk.load()) {
            arrayList.add(new TorchIsClosedAfterImageCapturingQuirk());
        }
        if (ZslDisablerQuirk.load()) {
            arrayList.add(new ZslDisablerQuirk());
        }
        if (ExtraSupportedOutputSizeQuirk.load()) {
            arrayList.add(new ExtraSupportedOutputSizeQuirk());
        }
        if (InvalidVideoProfilesQuirk.load()) {
            arrayList.add(new InvalidVideoProfilesQuirk());
        }
        if (SmallDisplaySizeQuirk.load()) {
            arrayList.add(new SmallDisplaySizeQuirk());
        }
        return arrayList;
    }
}
