package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalZeroShutterLag;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class TemplateTypeUtil {

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.TemplateTypeUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType = iArr;
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private TemplateTypeUtil() {
    }

    @OptIn(markerClass = {ExperimentalZeroShutterLag.class})
    public static int getCaptureConfigTemplateType(@NonNull UseCaseConfigFactory.CaptureType captureType, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[captureType.ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? 3 : 1;
        }
        return i == 2 ? 5 : 2;
    }

    @OptIn(markerClass = {ExperimentalZeroShutterLag.class})
    public static int getSessionConfigTemplateType(@NonNull UseCaseConfigFactory.CaptureType captureType, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType[captureType.ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? 3 : 1;
        }
        return i == 2 ? 5 : 1;
    }
}
