package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel parcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.mUsage = parcel.readInt(audioAttributesImplBase.mUsage, 1);
        audioAttributesImplBase.mContentType = parcel.readInt(audioAttributesImplBase.mContentType, 2);
        audioAttributesImplBase.mFlags = parcel.readInt(audioAttributesImplBase.mFlags, 3);
        audioAttributesImplBase.mLegacyStream = parcel.readInt(audioAttributesImplBase.mLegacyStream, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase obj, VersionedParcel parcel) {
        parcel.setSerializationFlags(false, false);
        parcel.writeInt(obj.mUsage, 1);
        parcel.writeInt(obj.mContentType, 2);
        parcel.writeInt(obj.mFlags, 3);
        parcel.writeInt(obj.mLegacyStream, 4);
    }
}
