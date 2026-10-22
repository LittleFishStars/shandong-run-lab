package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface VideoCapabilities {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final VideoCapabilities EMPTY = new VideoCapabilities() { // from class: androidx.camera.video.VideoCapabilities.1
        @Override // androidx.camera.video.VideoCapabilities
        @NonNull
        public Set<DynamicRange> getSupportedDynamicRanges() {
            return new HashSet();
        }

        @Override // androidx.camera.video.VideoCapabilities
        @NonNull
        public List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange) {
            return new ArrayList();
        }

        @Override // androidx.camera.video.VideoCapabilities
        public boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
            return false;
        }
    };

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default VideoValidatedEncoderProfilesProxy findHighestSupportedEncoderProfilesFor(@NonNull Size size, @NonNull DynamicRange dynamicRange) {
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default Quality findHighestSupportedQualityFor(@NonNull Size size, @NonNull DynamicRange dynamicRange) {
        return Quality.NONE;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    default VideoValidatedEncoderProfilesProxy getProfiles(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
        return null;
    }

    @NonNull
    Set<DynamicRange> getSupportedDynamicRanges();

    @NonNull
    List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange);

    boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange);
}
