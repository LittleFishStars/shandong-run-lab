package com.google.android.inner_exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.Bundleable;
import com.google.android.inner_exoplayer2.DeviceInfo;
import com.google.android.inner_exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DeviceInfo implements Bundleable {
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;
    public static final DeviceInfo UNKNOWN = new DeviceInfo(0, 0, 0);
    private static final String FIELD_PLAYBACK_TYPE = Util.intToStringMaxRadix(0);
    private static final String FIELD_MIN_VOLUME = Util.intToStringMaxRadix(1);
    private static final String FIELD_MAX_VOLUME = Util.intToStringMaxRadix(2);
    public static final Bundleable.Creator<DeviceInfo> CREATOR = new Bundleable.Creator() { // from class: com.zj.adlib.yl2
        @Override // com.google.android.inner_exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return DeviceInfo.lambda$static$0(bundle);
        }
    };

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    public DeviceInfo(int i, int i2, int i3) {
        this.playbackType = i;
        this.minVolume = i2;
        this.maxVolume = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DeviceInfo lambda$static$0(Bundle bundle) {
        return new DeviceInfo(bundle.getInt(FIELD_PLAYBACK_TYPE, 0), bundle.getInt(FIELD_MIN_VOLUME, 0), bundle.getInt(FIELD_MAX_VOLUME, 0));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.playbackType == deviceInfo.playbackType && this.minVolume == deviceInfo.minVolume && this.maxVolume == deviceInfo.maxVolume;
    }

    public int hashCode() {
        return ((((this.playbackType + 527) * 31) + this.minVolume) * 31) + this.maxVolume;
    }

    @Override // com.google.android.inner_exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_PLAYBACK_TYPE, this.playbackType);
        bundle.putInt(FIELD_MIN_VOLUME, this.minVolume);
        bundle.putInt(FIELD_MAX_VOLUME, this.maxVolume);
        return bundle;
    }
}
