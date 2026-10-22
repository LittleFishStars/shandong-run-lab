package androidx.camera.video.internal;

import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class BackupHdrProfileEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "BackupHdrProfileEncoderProfilesProvider";
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final EncoderProfilesProvider mEncoderProfilesProvider;
    private final Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> mVideoProfileValidator;
    public static final Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> DEFAULT_VALIDATOR = new Function() { // from class: com.zj.adlib.fl0
        @Override // androidx.arch.core.util.Function
        public final Object apply(Object obj) {
        }
    };
    private static final Timebase DEFAULT_TIME_BASE = Timebase.UPTIME;

    public BackupHdrProfileEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> function) {
        this.mEncoderProfilesProvider = encoderProfilesProvider;
        this.mVideoProfileValidator = function;
    }

    @Nullable
    private EncoderProfilesProxy appendBackupVideoProfile(@Nullable EncoderProfilesProxy encoderProfilesProxy, int i, int i2) {
        EncoderProfilesProxy.VideoProfileProxy next;
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(encoderProfilesProxy.getVideoProfiles());
        Iterator<EncoderProfilesProxy.VideoProfileProxy> it = encoderProfilesProxy.getVideoProfiles().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getHdrFormat() != 0);
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxyApply = this.mVideoProfileValidator.apply(generateBackupProfile(next, i, i2));
        if (videoProfileProxyApply != null) {
            arrayList.add(videoProfileProxyApply);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    private static int deriveCodec(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return 5;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i);
    }

    @NonNull
    private static String deriveMediaType(int i) {
        return EncoderProfilesProxy.getVideoCodecMimeType(i);
    }

    private static int deriveProfile(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 4096;
        }
        if (i == 3) {
            return 8192;
        }
        if (i == 4) {
            return -1;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i);
    }

    @Nullable
    private static EncoderProfilesProxy.VideoProfileProxy generateBackupProfile(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i, int i2) {
        if (videoProfileProxy == null) {
            return null;
        }
        int codec = videoProfileProxy.getCodec();
        String mediaType = videoProfileProxy.getMediaType();
        int profile = videoProfileProxy.getProfile();
        if (i != videoProfileProxy.getHdrFormat()) {
            codec = deriveCodec(i);
            mediaType = deriveMediaType(codec);
            profile = deriveProfile(i);
        }
        return EncoderProfilesProxy.VideoProfileProxy.create(codec, mediaType, scaleBitrate(videoProfileProxy.getBitrate(), i2, videoProfileProxy.getBitDepth()), videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), profile, i2, videoProfileProxy.getChromaSubsampling(), i);
    }

    @Nullable
    private EncoderProfilesProxy getProfilesInternal(int i) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i));
        }
        if (!this.mEncoderProfilesProvider.hasProfile(i)) {
            return null;
        }
        EncoderProfilesProxy encoderProfilesProxyAppendBackupVideoProfile = appendBackupVideoProfile(this.mEncoderProfilesProvider.getAll(i), 1, 10);
        this.mEncoderProfilesCache.put(Integer.valueOf(i), encoderProfilesProxyAppendBackupVideoProfile);
        return encoderProfilesProxyAppendBackupVideoProfile;
    }

    @NonNull
    private static EncoderProfilesProxy.VideoProfileProxy modifyBitrate(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i) {
        return EncoderProfilesProxy.VideoProfileProxy.create(videoProfileProxy.getCodec(), videoProfileProxy.getMediaType(), i, videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), videoProfileProxy.getProfile(), videoProfileProxy.getBitDepth(), videoProfileProxy.getChromaSubsampling(), videoProfileProxy.getHdrFormat());
    }

    private static int scaleBitrate(int i, int i2, int i3) {
        if (i2 == i3) {
            return i;
        }
        int iDoubleValue = (int) (((double) i) * new Rational(i2, i3).doubleValue());
        if (Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iDoubleValue)));
        }
        return iDoubleValue;
    }

    @NonNull
    @VisibleForTesting
    public static VideoEncoderConfig toVideoEncoderConfig(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        return VideoEncoderConfig.builder().setMimeType(videoProfileProxy.getMediaType()).setProfile(videoProfileProxy.getProfile()).setResolution(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight())).setFrameRate(videoProfileProxy.getFrameRate()).setBitrate(videoProfileProxy.getBitrate()).setInputTimebase(DEFAULT_TIME_BASE).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static EncoderProfilesProxy.VideoProfileProxy validateOrAdapt(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        if (videoProfileProxy == null) {
            return null;
        }
        VideoEncoderConfig videoEncoderConfig = toVideoEncoderConfig(videoProfileProxy);
        try {
            VideoEncoderInfoImpl videoEncoderInfoImplFrom = VideoEncoderInfoImpl.from(videoEncoderConfig);
            int bitrate = videoEncoderConfig.getBitrate();
            int iIntValue = ((Integer) videoEncoderInfoImplFrom.getSupportedBitrateRange().clamp(Integer.valueOf(bitrate))).intValue();
            return iIntValue == bitrate ? videoProfileProxy : modifyBitrate(videoProfileProxy, iIntValue);
        } catch (InvalidConfigException unused) {
            return null;
        }
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i) {
        return getProfilesInternal(i);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i) {
        return this.mEncoderProfilesProvider.hasProfile(i) && getProfilesInternal(i) != null;
    }
}
