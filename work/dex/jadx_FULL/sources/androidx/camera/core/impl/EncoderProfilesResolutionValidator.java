package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class EncoderProfilesResolutionValidator {

    @NonNull
    private final List<ProfileResolutionQuirk> mQuirks;

    @NonNull
    private final Set<Size> mSupportedResolutions;

    public EncoderProfilesResolutionValidator(@Nullable List<ProfileResolutionQuirk> list) {
        ArrayList arrayList = new ArrayList();
        this.mQuirks = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.mSupportedResolutions = generateSupportedResolutions(list);
    }

    @NonNull
    private Set<Size> generateSupportedResolutions(@Nullable List<ProfileResolutionQuirk> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(list.get(0).getSupportedResolutions());
        for (int i = 1; i < list.size(); i++) {
            hashSet.retainAll(list.get(i).getSupportedResolutions());
        }
        return hashSet;
    }

    @Nullable
    public EncoderProfilesProxy filterInvalidVideoResolution(@Nullable EncoderProfilesProxy encoderProfilesProxy) {
        if (encoderProfilesProxy == null) {
            return null;
        }
        if (!hasQuirk()) {
            return encoderProfilesProxy;
        }
        ArrayList arrayList = new ArrayList();
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : encoderProfilesProxy.getVideoProfiles()) {
            if (this.mSupportedResolutions.contains(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight()))) {
                arrayList.add(videoProfileProxy);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    public boolean hasQuirk() {
        return !this.mQuirks.isEmpty();
    }

    public boolean hasValidVideoResolution(@Nullable EncoderProfilesProxy encoderProfilesProxy) {
        if (encoderProfilesProxy == null) {
            return false;
        }
        if (!hasQuirk()) {
            return !encoderProfilesProxy.getVideoProfiles().isEmpty();
        }
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : encoderProfilesProxy.getVideoProfiles()) {
            if (this.mSupportedResolutions.contains(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight()))) {
                return true;
            }
        }
        return false;
    }
}
