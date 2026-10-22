package com.zj.adlib;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.baichuan.log.TLogConstant;
import com.alipay.sdk.m.y.l;
import com.google.common.net.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class ub1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f45106a = 0.05d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final float f20022a = 1.5f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f20023a = 153600;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f20024a = Pattern.compile(l.b);
    public static final float b = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f20025b = 10;
    public static final int c = 20;
    public static final int d = 400;

    public static List<Camera.Area> a(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    public static String b(Camera.Parameters parameters) {
        return c(parameters.flatten());
    }

    public static String c(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(Build.BRAND);
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(Build.CPU_ABI);
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(Build.MANUFACTURER);
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(Build.MODEL);
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(Build.PRODUCT);
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] strArrSplit = f20024a.split(charSequence);
            Arrays.sort(strArrSplit);
            for (String str : strArrSplit) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static Point d(Camera.Parameters parameters, Point point) {
        Camera.Size size;
        Iterator<Camera.Size> it;
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            u15.z("Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        if (u15.o()) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size2 : supportedPreviewSizes) {
                sb.append(size2.width);
                sb.append('x');
                sb.append(size2.height);
                sb.append(' ');
            }
            u15.a("Supported preview sizes: " + ((Object) sb));
        }
        int i = point.x;
        int i2 = point.y;
        double d2 = i < i2 ? ((double) i) / ((double) i2) : ((double) i2) / ((double) i);
        u15.a("screenAspectRatio: " + d2);
        Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
        char c2 = 0;
        Camera.Size size3 = null;
        int i3 = 0;
        while (it2.hasNext()) {
            Camera.Size next = it2.next();
            int i4 = next.width;
            int i5 = next.height;
            int i6 = i4 * i5;
            if (i6 < 153600) {
                it = it2;
                str = str2;
                size = size3;
            } else {
                char c3 = i4 < i5 ? (char) 1 : c2;
                int i7 = c3 != 0 ? i4 : i5;
                int i8 = c3 != 0 ? i5 : i4;
                Object[] objArr = new Object[2];
                objArr[c2] = Integer.valueOf(i7);
                objArr[1] = Integer.valueOf(i8);
                u15.a(String.format("maybeFlipped:%d * %d", objArr));
                size = size3;
                it = it2;
                str = str2;
                double d3 = ((double) i7) / ((double) i8);
                u15.a("aspectRatio: " + d3);
                double dAbs = Math.abs(d3 - d2);
                u15.a("distortion: " + dAbs);
                if (dAbs <= 0.05d) {
                    if (i7 == point.x && i8 == point.y) {
                        Point point2 = new Point(i4, i5);
                        u15.a("Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    if (i6 > i3) {
                        size3 = next;
                        i3 = i6;
                    }
                }
                str2 = str;
                it2 = it;
                c2 = 0;
            }
            size3 = size;
            str2 = str;
            it2 = it;
            c2 = 0;
        }
        String str3 = str2;
        Camera.Size size4 = size3;
        if (size4 != null) {
            Point point3 = new Point(size4.width, size4.height);
            u15.a("Using largest suitable preview size: " + point3);
            return point3;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 == null) {
            throw new IllegalStateException(str3);
        }
        Point point4 = new Point(previewSize2.width, previewSize2.height);
        u15.a("No suitable preview sizes, using default: " + point4);
        return point4;
    }

    public static String e(String str, Collection<String> collection, String... strArr) {
        u15.a("Requesting " + str + " value from among: " + Arrays.toString(strArr));
        u15.a("Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    u15.a("Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        u15.a("No supported values match");
        return null;
    }

    public static Integer f(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        u15.a("Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            u15.z("Invalid zoom ratios!");
            return null;
        }
        double d3 = d2 * 100.0d;
        double d4 = Double.POSITIVE_INFINITY;
        int i = 0;
        for (int i2 = 0; i2 < zoomRatios.size(); i2++) {
            double dAbs = Math.abs(((double) zoomRatios.get(i2).intValue()) - d3);
            if (dAbs < d4) {
                i = i2;
                d4 = dAbs;
            }
        }
        u15.a("Chose zoom ratio of " + (((double) zoomRatios.get(i).intValue()) / 100.0d));
        return Integer.valueOf(i);
    }

    public static void g(Camera.Parameters parameters) {
        if (kd6.v.equals(parameters.getSceneMode())) {
            u15.a("Barcode scene mode already set");
            return;
        }
        String strE = e("scene mode", parameters.getSupportedSceneModes(), kd6.v);
        if (strE != null) {
            parameters.setSceneMode(strE);
        }
    }

    public static void h(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int iRound = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
                float f = exposureCompensationStep * iRound;
                int iMax = Math.max(Math.min(iRound, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == iMax) {
                    u15.a("Exposure compensation already set to " + iMax + " / " + f);
                    return;
                }
                u15.a("Setting exposure compensation to " + iMax + " / " + f);
                parameters.setExposureCompensation(iMax);
                return;
            }
        }
        u15.a("Camera does not support exposure compensation");
    }

    public static void i(Camera.Parameters parameters) {
        j(parameters, 10, 20);
    }

    public static void j(Camera.Parameters parameters, int i, int i2) {
        int[] next;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        u15.a("Supported FPS ranges: " + s(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int i3 = next[0];
            int i4 = next[1];
            if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                break;
            }
        }
        if (next == null) {
            u15.a("No suitable FPS range?");
            return;
        }
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        if (Arrays.equals(iArr, next)) {
            u15.a("FPS range already set to " + Arrays.toString(next));
            return;
        }
        u15.a("Setting FPS range to " + Arrays.toString(next));
        parameters.setPreviewFpsRange(next[0], next[1]);
    }

    public static void k(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        String strE;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (z) {
            strE = (z3 || z2) ? e("focus mode", supportedFocusModes, "auto") : e("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        } else {
            strE = null;
        }
        if (!z3 && strE == null) {
            strE = e("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strE != null) {
            if (!strE.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(strE);
                return;
            }
            u15.a("Focus mode already set to " + strE);
        }
    }

    public static void l(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            u15.a("Device does not support focus areas");
            return;
        }
        u15.a("Old focus areas: " + r(parameters.getFocusAreas()));
        List<Camera.Area> listA = a(400);
        u15.a("Setting focus area to : " + r(listA));
        parameters.setFocusAreas(listA);
    }

    public static void m(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            u15.a("Negative effect already set");
            return;
        }
        String strE = e("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strE != null) {
            parameters.setColorEffect(strE);
        }
    }

    public static void n(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            u15.a("Device does not support metering areas");
            return;
        }
        u15.a("Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listA = a(400);
        u15.a("Setting metering area to : " + r(listA));
        parameters.setMeteringAreas(listA);
    }

    public static void o(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strE = z ? e("flash mode", supportedFlashModes, "torch", "on") : e("flash mode", supportedFlashModes, TLogConstant.TLOG_MODULE_OFF);
        if (strE != null) {
            if (strE.equals(parameters.getFlashMode())) {
                u15.a("Flash mode already set to " + strE);
                return;
            }
            u15.a("Setting flash mode to " + strE);
            parameters.setFlashMode(strE);
        }
    }

    public static void p(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            u15.a("This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            u15.a("Video stabilization already enabled");
        } else {
            u15.a("Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void q(Camera.Parameters parameters, double d2) {
        if (!parameters.isZoomSupported()) {
            u15.a("Zoom is not supported");
            return;
        }
        Integer numF = f(parameters, d2);
        if (numF == null) {
            return;
        }
        if (parameters.getZoom() == numF.intValue()) {
            u15.a("Zoom is already set to " + numF);
            return;
        }
        u15.a("Setting zoom to " + numF);
        parameters.setZoom(numF.intValue());
    }

    public static String r(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(c.b);
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String s(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
