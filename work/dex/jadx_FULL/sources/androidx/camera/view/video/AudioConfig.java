package androidx.camera.view.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class AudioConfig {

    @NonNull
    public static final AudioConfig AUDIO_DISABLED = new AudioConfig(false);
    private final boolean mIsAudioEnabled;

    public AudioConfig(boolean z) {
        this.mIsAudioEnabled = z;
    }

    @NonNull
    @RequiresPermission(Permission.RECORD_AUDIO)
    public static AudioConfig create(boolean z) {
        return new AudioConfig(z);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }
}
