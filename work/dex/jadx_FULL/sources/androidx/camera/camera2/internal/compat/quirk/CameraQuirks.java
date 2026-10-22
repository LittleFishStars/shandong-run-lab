package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirks;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class CameraQuirks {
    private CameraQuirks() {
    }

    @NonNull
    public static Quirks get(@NonNull String str, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        ArrayList arrayList = new ArrayList();
        if (AeFpsRangeLegacyQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new AeFpsRangeLegacyQuirk(cameraCharacteristicsCompat));
        }
        if (AspectRatioLegacyApi21Quirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new AspectRatioLegacyApi21Quirk());
        }
        if (JpegHalCorruptImageQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new JpegHalCorruptImageQuirk());
        }
        if (CamcorderProfileResolutionQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new CamcorderProfileResolutionQuirk(cameraCharacteristicsCompat));
        }
        if (ImageCaptureWashedOutImageQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new ImageCaptureWashedOutImageQuirk());
        }
        if (CameraNoResponseWhenEnablingFlashQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
        }
        if (YuvImageOnePixelShiftQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new YuvImageOnePixelShiftQuirk());
        }
        if (FlashTooSlowQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new FlashTooSlowQuirk());
        }
        if (AfRegionFlipHorizontallyQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new AfRegionFlipHorizontallyQuirk());
        }
        if (ConfigureSurfaceToSecondarySessionFailQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
        }
        if (PreviewOrientationIncorrectQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new PreviewOrientationIncorrectQuirk());
        }
        if (CaptureSessionStuckQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new CaptureSessionStuckQuirk());
        }
        if (ImageCaptureFlashNotFireQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new ImageCaptureFlashNotFireQuirk());
        }
        if (ImageCaptureWithFlashUnderexposureQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
        }
        if (ImageCaptureFailWithAutoFlashQuirk.load(cameraCharacteristicsCompat)) {
            arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
        }
        return new Quirks(arrayList);
    }
}
