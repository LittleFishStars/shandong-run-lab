package com.zj.adlib;

import android.app.Activity;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.util.Size;
import com.alibaba.triver.embed.video.video.h;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.pose_estimation.ResolutionPreset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/wc1;", "", "", "cameraName", "Lcom/huachenjie/pose_estimation/ResolutionPreset;", "resolutionPreset", "Landroid/util/Size;", "b", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "streamConfigurationMap", "a", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "", "c", "", "lensFacing", "e", "preset", "Landroid/media/CamcorderProfile;", "d", "<init>", "()V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class wc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final wc1 f45568a = new wc1();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/zj/adlib/wc1$a;", "Ljava/util/Comparator;", "Landroid/util/Size;", "lhs", "rhs", "", "a", "<init>", "()V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements Comparator<Size> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NotNull Size lhs, @NotNull Size rhs) {
            Intrinsics.checkNotNullParameter(lhs, "lhs");
            Intrinsics.checkNotNullParameter(rhs, "rhs");
            return Long.signum((((long) lhs.getWidth()) * ((long) lhs.getHeight())) - (((long) rhs.getWidth()) * ((long) rhs.getHeight())));
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45569a;

        static {
            int[] iArr = new int[ResolutionPreset.values().length];
            iArr[ResolutionPreset.max.ordinal()] = 1;
            iArr[ResolutionPreset.ultraHigh.ordinal()] = 2;
            iArr[ResolutionPreset.veryHigh.ordinal()] = 3;
            iArr[ResolutionPreset.high.ordinal()] = 4;
            iArr[ResolutionPreset.medium.ordinal()] = 5;
            iArr[ResolutionPreset.low.ordinal()] = 6;
            f45569a = iArr;
        }
    }

    @NotNull
    public final Size a(@NotNull StreamConfigurationMap streamConfigurationMap) {
        Intrinsics.checkNotNullParameter(streamConfigurationMap, "streamConfigurationMap");
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(256);
        Object objMax = Collections.max(Arrays.asList(Arrays.copyOf(outputSizes, outputSizes.length)), new a());
        Intrinsics.checkNotNullExpressionValue(objMax, "max(\n            Arrays.…reSizesByArea()\n        )");
        return (Size) objMax;
    }

    @NotNull
    public final Size b(@NotNull String cameraName, @NotNull ResolutionPreset resolutionPreset) {
        Intrinsics.checkNotNullParameter(cameraName, "cameraName");
        Intrinsics.checkNotNullParameter(resolutionPreset, "resolutionPreset");
        int iOrdinal = resolutionPreset.ordinal();
        ResolutionPreset resolutionPreset2 = ResolutionPreset.high;
        if (iOrdinal > resolutionPreset2.ordinal()) {
            resolutionPreset = resolutionPreset2;
        }
        CamcorderProfile camcorderProfileD = d(cameraName, resolutionPreset);
        return new Size(camcorderProfileD.videoFrameWidth, camcorderProfileD.videoFrameHeight);
    }

    @NotNull
    public final List<Map<String, Object>> c(@NotNull Activity activity) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Object systemService = activity.getSystemService(h.d);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        String[] cameraIdList = cameraManager.getCameraIdList();
        Intrinsics.checkNotNullExpressionValue(cameraIdList, "cameraManager.cameraIdList");
        ArrayList arrayList = new ArrayList();
        for (String str : cameraIdList) {
            HashMap map = new HashMap();
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraName)");
            Intrinsics.checkNotNullExpressionValue(str, "cameraName");
            map.put("name", str);
            Object obj = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
            Intrinsics.checkNotNull(obj);
            map.put("sensorOrientation", Integer.valueOf(((Number) obj).intValue()));
            Object obj2 = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            Intrinsics.checkNotNull(obj2);
            int iIntValue = ((Number) obj2).intValue();
            if (iIntValue == 0) {
                map.put("lensFacing", "front");
            } else if (iIntValue == 1) {
                map.put("lensFacing", "back");
            } else if (iIntValue == 2) {
                map.put("lensFacing", "external");
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    @NotNull
    public final CamcorderProfile d(@NotNull String cameraName, @Nullable ResolutionPreset preset) {
        Intrinsics.checkNotNullParameter(cameraName, "cameraName");
        int i = Integer.parseInt(cameraName);
        switch (preset == null ? -1 : b.f45569a[preset.ordinal()]) {
            case 1:
                if (CamcorderProfile.hasProfile(i, 1)) {
                    CamcorderProfile camcorderProfile = CamcorderProfile.get(i, 1);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile, "get(cameraId, CamcorderProfile.QUALITY_HIGH)");
                    return camcorderProfile;
                }
                if (CamcorderProfile.hasProfile(i, 8)) {
                    CamcorderProfile camcorderProfile2 = CamcorderProfile.get(i, 8);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile2, "get(cameraId, CamcorderProfile.QUALITY_2160P)");
                    return camcorderProfile2;
                }
                if (CamcorderProfile.hasProfile(i, 6)) {
                    CamcorderProfile camcorderProfile3 = CamcorderProfile.get(i, 6);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile3, "get(cameraId, CamcorderProfile.QUALITY_1080P)");
                    return camcorderProfile3;
                }
                if (CamcorderProfile.hasProfile(i, 5)) {
                    CamcorderProfile camcorderProfile4 = CamcorderProfile.get(i, 5);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile4, "get(cameraId, CamcorderProfile.QUALITY_720P)");
                    return camcorderProfile4;
                }
                if (CamcorderProfile.hasProfile(i, 4)) {
                    CamcorderProfile camcorderProfile5 = CamcorderProfile.get(i, 4);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile5, "get(cameraId, CamcorderProfile.QUALITY_480P)");
                    return camcorderProfile5;
                }
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile6 = CamcorderProfile.get(i, 7);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile6, "get(cameraId, CamcorderProfile.QUALITY_QVGA)");
                    return camcorderProfile6;
                }
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile7 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile7, "{\n                if (Ca…          }\n            }");
                return camcorderProfile7;
            case 2:
                if (CamcorderProfile.hasProfile(i, 8)) {
                    CamcorderProfile camcorderProfile8 = CamcorderProfile.get(i, 8);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile8, "get(cameraId, CamcorderProfile.QUALITY_2160P)");
                    return camcorderProfile8;
                }
                if (CamcorderProfile.hasProfile(i, 6)) {
                    CamcorderProfile camcorderProfile9 = CamcorderProfile.get(i, 6);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile9, "get(cameraId, CamcorderProfile.QUALITY_1080P)");
                    return camcorderProfile9;
                }
                if (CamcorderProfile.hasProfile(i, 5)) {
                    CamcorderProfile camcorderProfile10 = CamcorderProfile.get(i, 5);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile10, "get(cameraId, CamcorderProfile.QUALITY_720P)");
                    return camcorderProfile10;
                }
                if (CamcorderProfile.hasProfile(i, 4)) {
                    CamcorderProfile camcorderProfile11 = CamcorderProfile.get(i, 4);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile11, "get(cameraId, CamcorderProfile.QUALITY_480P)");
                    return camcorderProfile11;
                }
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile12 = CamcorderProfile.get(i, 7);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile12, "get(cameraId, CamcorderProfile.QUALITY_QVGA)");
                    return camcorderProfile12;
                }
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile13 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile13, "{\n                if (Ca…          }\n            }");
                return camcorderProfile13;
            case 3:
                if (CamcorderProfile.hasProfile(i, 6)) {
                    CamcorderProfile camcorderProfile14 = CamcorderProfile.get(i, 6);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile14, "get(cameraId, CamcorderProfile.QUALITY_1080P)");
                    return camcorderProfile14;
                }
                if (CamcorderProfile.hasProfile(i, 5)) {
                    CamcorderProfile camcorderProfile15 = CamcorderProfile.get(i, 5);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile15, "get(cameraId, CamcorderProfile.QUALITY_720P)");
                    return camcorderProfile15;
                }
                if (CamcorderProfile.hasProfile(i, 4)) {
                    CamcorderProfile camcorderProfile16 = CamcorderProfile.get(i, 4);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile16, "get(cameraId, CamcorderProfile.QUALITY_480P)");
                    return camcorderProfile16;
                }
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile17 = CamcorderProfile.get(i, 7);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile17, "get(cameraId, CamcorderProfile.QUALITY_QVGA)");
                    return camcorderProfile17;
                }
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile18 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile18, "{\n                if (Ca…          }\n            }");
                return camcorderProfile18;
            case 4:
                if (CamcorderProfile.hasProfile(i, 5)) {
                    CamcorderProfile camcorderProfile19 = CamcorderProfile.get(i, 5);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile19, "get(cameraId, CamcorderProfile.QUALITY_720P)");
                    return camcorderProfile19;
                }
                if (CamcorderProfile.hasProfile(i, 4)) {
                    CamcorderProfile camcorderProfile20 = CamcorderProfile.get(i, 4);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile20, "get(cameraId, CamcorderProfile.QUALITY_480P)");
                    return camcorderProfile20;
                }
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile21 = CamcorderProfile.get(i, 7);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile21, "get(cameraId, CamcorderProfile.QUALITY_QVGA)");
                    return camcorderProfile21;
                }
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile22 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile22, "{\n                if (Ca…          }\n            }");
                return camcorderProfile22;
            case 5:
                if (CamcorderProfile.hasProfile(i, 4)) {
                    CamcorderProfile camcorderProfile23 = CamcorderProfile.get(i, 4);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile23, "get(cameraId, CamcorderProfile.QUALITY_480P)");
                    return camcorderProfile23;
                }
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile24 = CamcorderProfile.get(i, 7);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile24, "get(cameraId, CamcorderProfile.QUALITY_QVGA)");
                    return camcorderProfile24;
                }
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile25 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile25, "{\n                if (Ca…          }\n            }");
                return camcorderProfile25;
            case 6:
                if (CamcorderProfile.hasProfile(i, 7)) {
                    CamcorderProfile camcorderProfile26 = CamcorderProfile.get(i, 7);
                    Intrinsics.checkNotNullExpressionValue(camcorderProfile26, "get(cameraId, CamcorderProfile.QUALITY_QVGA)");
                    return camcorderProfile26;
                }
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile27 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile27, "{\n                if (Ca…          }\n            }");
                return camcorderProfile27;
            default:
                if (!CamcorderProfile.hasProfile(i, 0)) {
                    throw new IllegalArgumentException("No capture session available for current capture session.");
                }
                CamcorderProfile camcorderProfile28 = CamcorderProfile.get(i, 0);
                Intrinsics.checkNotNullExpressionValue(camcorderProfile28, "if (CamcorderProfile.has…          )\n            }");
                return camcorderProfile28;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0043  */
    @NotNull
    public final String e(@NotNull Activity activity, int lensFacing) throws CameraAccessException {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Object systemService = activity.getSystemService(h.d);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        String[] cameraIdList = cameraManager.getCameraIdList();
        Intrinsics.checkNotNullExpressionValue(cameraIdList, "cameraManager.cameraIdList");
        for (String str : cameraIdList) {
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraName)");
            Object obj = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            Intrinsics.checkNotNull(obj);
            if (((Number) obj).intValue() == lensFacing) {
                if (str != null) {
                    return str;
                }
                throw new CameraAccessException(3, "Camera not found");
            }
        }
        str = null;
        if (str != null) {
            return str;
        }
        throw new CameraAccessException(3, "Camera not found");
    }
}
