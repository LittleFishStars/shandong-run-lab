package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface CameraFilter {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    @NonNull
    List<CameraInfo> filter(@NonNull List<CameraInfo> list);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    default Identifier getIdentifier() {
        return DEFAULT_ID;
    }
}
