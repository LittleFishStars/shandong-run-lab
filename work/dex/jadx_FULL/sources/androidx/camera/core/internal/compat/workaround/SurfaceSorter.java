package androidx.camera.core.internal.compat.workaround;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class SurfaceSorter {
    private static final int PRIORITY_MEDIA_CODEC_SURFACE = 2;
    private static final int PRIORITY_OTHERS = 1;
    private static final int PRIORITY_PREVIEW_SURFACE = 0;
    private final boolean mHasQuirk;

    public SurfaceSorter() {
        this.mHasQuirk = DeviceQuirks.get(SurfaceOrderQuirk.class) != null;
    }

    private int getSurfacePriority(@NonNull DeferrableSurface deferrableSurface) {
        if (deferrableSurface.getContainerClass() == MediaCodec.class) {
            return 2;
        }
        return deferrableSurface.getContainerClass() == Preview.class ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$sort$0(SessionConfig.OutputConfig outputConfig, SessionConfig.OutputConfig outputConfig2) {
        return getSurfacePriority(outputConfig.getSurface()) - getSurfacePriority(outputConfig2.getSurface());
    }

    public void sort(@NonNull List<SessionConfig.OutputConfig> list) {
        if (this.mHasQuirk) {
            Collections.sort(list, new Comparator(this) { // from class: com.zj.adlib.sx8

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SurfaceSorter f44806a;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                }
            });
        }
    }
}
