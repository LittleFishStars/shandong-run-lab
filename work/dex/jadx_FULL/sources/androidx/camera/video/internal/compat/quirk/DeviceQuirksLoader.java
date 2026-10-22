package androidx.camera.video.internal.compat.quirk;

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
        if (MediaFormatMustNotUseFrameRateToFindEncoderQuirk.load()) {
            arrayList.add(new MediaFormatMustNotUseFrameRateToFindEncoderQuirk());
        }
        if (MediaCodecInfoReportIncorrectInfoQuirk.load()) {
            arrayList.add(new MediaCodecInfoReportIncorrectInfoQuirk());
        }
        if (DeactivateEncoderSurfaceBeforeStopEncoderQuirk.load()) {
            arrayList.add(new DeactivateEncoderSurfaceBeforeStopEncoderQuirk());
        }
        if (CameraUseInconsistentTimebaseQuirk.load()) {
            arrayList.add(new CameraUseInconsistentTimebaseQuirk());
        }
        if (ReportedVideoQualityNotSupportedQuirk.load()) {
            arrayList.add(new ReportedVideoQualityNotSupportedQuirk());
        }
        if (EncoderNotUsePersistentInputSurfaceQuirk.load()) {
            arrayList.add(new EncoderNotUsePersistentInputSurfaceQuirk());
        }
        if (VideoEncoderCrashQuirk.load()) {
            arrayList.add(new VideoEncoderCrashQuirk());
        }
        if (ExcludeStretchedVideoQualityQuirk.load()) {
            arrayList.add(new ExcludeStretchedVideoQualityQuirk());
        }
        if (MediaStoreVideoCannotWrite.load()) {
            arrayList.add(new MediaStoreVideoCannotWrite());
        }
        if (AudioEncoderIgnoresInputTimestampQuirk.load()) {
            arrayList.add(new AudioEncoderIgnoresInputTimestampQuirk());
        }
        if (VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.load()) {
            arrayList.add(new VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk());
        }
        if (NegativeLatLongSavesIncorrectlyQuirk.load()) {
            arrayList.add(new NegativeLatLongSavesIncorrectlyQuirk());
        }
        if (PreviewStretchWhenVideoCaptureIsBoundQuirk.load()) {
            arrayList.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
        }
        if (PreviewDelayWhenVideoCaptureIsBoundQuirk.load()) {
            arrayList.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
        }
        if (AudioTimestampFramePositionIncorrectQuirk.load()) {
            arrayList.add(new AudioTimestampFramePositionIncorrectQuirk());
        }
        if (ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.load()) {
            arrayList.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
        }
        if (ExtraSupportedResolutionQuirk.load()) {
            arrayList.add(new ExtraSupportedResolutionQuirk());
        }
        return arrayList;
    }
}
