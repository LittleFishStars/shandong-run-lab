package android.support.v4.media;

import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer extends androidx.media.AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel parcel) {
        return androidx.media.AudioAttributesImplApi21Parcelizer.read(parcel);
    }

    public static void write(AudioAttributesImplApi21 obj, VersionedParcel parcel) {
        androidx.media.AudioAttributesImplApi21Parcelizer.write(obj, parcel);
    }
}
