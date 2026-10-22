package androidx.camera.video.internal.workaround;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.compat.quirk.MediaFormatMustNotUseFrameRateToFindEncoderQuirk;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.core.util.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class EncoderFinder {
    private static final String TAG = "EncoderFinder";
    private final boolean mShouldRemoveKeyFrameRate;

    public EncoderFinder() {
        this.mShouldRemoveKeyFrameRate = ((MediaFormatMustNotUseFrameRateToFindEncoderQuirk) DeviceQuirks.get(MediaFormatMustNotUseFrameRateToFindEncoderQuirk.class)) != null;
    }

    @Nullable
    private String findEncoderWithNearestCompatibleBitrate(@NonNull MediaFormat mediaFormat, @NonNull MediaCodecInfo[] mediaCodecInfoArr) throws Throwable {
        Integer numValueOf;
        int iIntValue;
        String string = mediaFormat.getString("mime");
        Integer num = null;
        if (string == null) {
            Logger.w(TAG, "MediaFormat does not contain mime info.");
            return null;
        }
        int length = mediaCodecInfoArr.length;
        for (int i = 0; i < length; i++) {
            MediaCodecInfo mediaCodecInfo = mediaCodecInfoArr[i];
            if (mediaCodecInfo.isEncoder()) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    Preconditions.checkArgument(capabilitiesForType != null, "MIME type is not supported");
                    if (mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE)) {
                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        Preconditions.checkArgument(videoCapabilities != null, "Not video codec");
                        numValueOf = Integer.valueOf(mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE));
                        try {
                            iIntValue = ((Integer) videoCapabilities.getBitrateRange().clamp(numValueOf)).intValue();
                            mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, iIntValue);
                        } catch (IllegalArgumentException unused) {
                            if (numValueOf != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            num = numValueOf;
                            if (num != null) {
                                mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, num.intValue());
                            }
                            throw th;
                        }
                    } else {
                        iIntValue = -1;
                        numValueOf = null;
                    }
                    if (capabilitiesForType.isFormatSupported(mediaFormat)) {
                        Logger.w(TAG, String.format("No encoder found that supports requested bitrate. Adjusting bitrate to nearest supported bitrate [requested: %dbps, nearest: %dbps]", numValueOf, Integer.valueOf(iIntValue)));
                        String name = mediaCodecInfo.getName();
                        if (numValueOf != null) {
                            mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, numValueOf.intValue());
                        }
                        return name;
                    }
                    if (numValueOf != null) {
                        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, numValueOf.intValue());
                    }
                } catch (IllegalArgumentException unused2) {
                    numValueOf = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    private boolean shouldCreateCodecByType(@NonNull MediaFormat mediaFormat) {
        MediaCodecInfoReportIncorrectInfoQuirk mediaCodecInfoReportIncorrectInfoQuirk = (MediaCodecInfoReportIncorrectInfoQuirk) DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class);
        if (mediaCodecInfoReportIncorrectInfoQuirk == null) {
            return false;
        }
        return mediaCodecInfoReportIncorrectInfoQuirk.isUnSupportMediaCodecInfo(mediaFormat);
    }

    @NonNull
    public MediaCodec findEncoder(@NonNull MediaFormat mediaFormat) throws Throwable {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        String strFindEncoderForFormat = findEncoderForFormat(mediaFormat, mediaCodecList);
        try {
            if (!TextUtils.isEmpty(strFindEncoderForFormat)) {
                return MediaCodec.createByCodecName(strFindEncoderForFormat);
            }
            String string = mediaFormat.getString("mime");
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(string);
            Logger.w(TAG, String.format("No encoder found that supports requested MediaFormat %s. Create encoder by MIME type. Dump codec info:\n%s", mediaFormat, DebugUtils.dumpCodecCapabilities(string, mediaCodecCreateEncoderByType, mediaFormat)));
            return mediaCodecCreateEncoderByType;
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            throw new InvalidConfigException("Encoder cannot created: " + strFindEncoderForFormat + ", isMediaFormatInQuirk: " + shouldCreateCodecByType(mediaFormat) + "\n" + DebugUtils.dumpMediaCodecListForFormat(mediaCodecList, mediaFormat), e);
        }
    }

    @Nullable
    @VisibleForTesting
    public String findEncoderForFormat(@NonNull MediaFormat mediaFormat, @NonNull MediaCodecList mediaCodecList) throws Throwable {
        Integer num = null;
        try {
            if (this.mShouldRemoveKeyFrameRate && mediaFormat.containsKey("frame-rate")) {
                Integer numValueOf = Integer.valueOf(mediaFormat.getInteger("frame-rate"));
                try {
                    mediaFormat.setString("frame-rate", null);
                    num = numValueOf;
                } catch (Throwable th) {
                    th = th;
                    num = numValueOf;
                    if (num != null) {
                        mediaFormat.setInteger("frame-rate", num.intValue());
                    }
                    throw th;
                }
            }
            String strFindEncoderForFormat = mediaCodecList.findEncoderForFormat(mediaFormat);
            if (strFindEncoderForFormat == null) {
                strFindEncoderForFormat = findEncoderWithNearestCompatibleBitrate(mediaFormat, mediaCodecList.getCodecInfos());
            }
            if (num != null) {
                mediaFormat.setInteger("frame-rate", num.intValue());
            }
            return strFindEncoderForFormat;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
