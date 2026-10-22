package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.core.util.Supplier;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class VideoEncoderConfigVideoProfileResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncVdPrflRslvr";
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final EncoderProfilesProxy.VideoProfileProxy mVideoProfile;
    private final VideoSpec mVideoSpec;

    public VideoEncoderConfigVideoProfileResolver(@NonNull String str, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, @NonNull DynamicRange dynamicRange, @NonNull Range<Integer> range) {
        this.mMimeType = str;
        this.mInputTimebase = timebase;
        this.mVideoSpec = videoSpec;
        this.mSurfaceSize = size;
        this.mVideoProfile = videoProfileProxy;
        this.mDynamicRange = dynamicRange;
        this.mExpectedFrameRateRange = range;
    }

    private int resolveFrameRate() {
        int frameRate = this.mVideoProfile.getFrameRate();
        Range<Integer> range = this.mExpectedFrameRateRange;
        Range<Integer> range2 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        int iIntValue = !Objects.equals(range, range2) ? ((Integer) this.mExpectedFrameRateRange.clamp(Integer.valueOf(frameRate))).intValue() : frameRate;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(iIntValue);
        objArr[1] = Integer.valueOf(frameRate);
        objArr[2] = Objects.equals(this.mExpectedFrameRateRange, range2) ? this.mExpectedFrameRateRange : "<UNSPECIFIED>";
        Logger.d(TAG, String.format("Resolved frame rate %dfps [Video profile frame rate: %dfps, Expected operating range: %s]", objArr));
        return iIntValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public VideoEncoderConfig get() {
        int iResolveFrameRate = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + iResolveFrameRate + AliyunLogKey.KEY_FPS);
        Range<Integer> bitrate = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using resolved VIDEO bitrate from EncoderProfiles");
        int iScaleAndClampBitrate = VideoConfigUtil.scaleAndClampBitrate(this.mVideoProfile.getBitrate(), this.mDynamicRange.getBitDepth(), this.mVideoProfile.getBitDepth(), iResolveFrameRate, this.mVideoProfile.getFrameRate(), this.mSurfaceSize.getWidth(), this.mVideoProfile.getWidth(), this.mSurfaceSize.getHeight(), this.mVideoProfile.getHeight(), bitrate);
        int profile = this.mVideoProfile.getProfile();
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(iScaleAndClampBitrate).setFrameRate(iResolveFrameRate).setProfile(profile).setDataSpace(VideoConfigUtil.mimeAndProfileToEncoderDataSpace(this.mMimeType, profile)).build();
    }
}
