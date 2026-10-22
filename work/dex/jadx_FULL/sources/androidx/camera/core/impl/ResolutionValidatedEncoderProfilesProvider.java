package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class ResolutionValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesResolutionValidator mEncoderProfilesResolutionValidator;
    private final EncoderProfilesProvider mProvider;

    public ResolutionValidatedEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mEncoderProfilesResolutionValidator = new EncoderProfilesResolutionValidator(quirks.getAll(ProfileResolutionQuirk.class));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i) {
        if (!this.mProvider.hasProfile(i)) {
            return null;
        }
        EncoderProfilesProxy all = this.mProvider.getAll(i);
        return this.mEncoderProfilesResolutionValidator.hasQuirk() ? this.mEncoderProfilesResolutionValidator.filterInvalidVideoResolution(all) : all;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i) {
        if (!this.mProvider.hasProfile(i)) {
            return false;
        }
        if (!this.mEncoderProfilesResolutionValidator.hasQuirk()) {
            return true;
        }
        return this.mEncoderProfilesResolutionValidator.hasValidVideoResolution(this.mProvider.getAll(i));
    }
}
