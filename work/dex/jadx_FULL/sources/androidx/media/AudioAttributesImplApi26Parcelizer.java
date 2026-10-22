package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel parcel) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.mAudioAttributes = (AudioAttributes) parcel.readParcelable(audioAttributesImplApi26.mAudioAttributes, 1);
        audioAttributesImplApi26.mLegacyStreamType = parcel.readInt(audioAttributesImplApi26.mLegacyStreamType, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 obj, VersionedParcel parcel) {
        parcel.setSerializationFlags(false, false);
        parcel.writeParcelable(obj.mAudioAttributes, 1);
        parcel.writeInt(obj.mLegacyStreamType, 2);
    }
}
