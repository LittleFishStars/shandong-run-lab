package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
interface CamcorderProfileHelper {
    CamcorderProfile get(int i, int i2);

    boolean hasProfile(int i, int i2);
}
