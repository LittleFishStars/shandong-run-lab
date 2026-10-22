package android.support.v4.media;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplApi26;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi26Parcelizer extends androidx.media.AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel parcel) {
        return androidx.media.AudioAttributesImplApi26Parcelizer.read(parcel);
    }

    public static void write(AudioAttributesImplApi26 obj, VersionedParcel parcel) {
        androidx.media.AudioAttributesImplApi26Parcelizer.write(obj, parcel);
    }
}
