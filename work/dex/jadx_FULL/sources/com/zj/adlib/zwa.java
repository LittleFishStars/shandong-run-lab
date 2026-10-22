package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class zwa {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static FPoint[] f21121a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static List<Float> f21120a = new ArrayList(4);
    public static List<Float> b = new ArrayList(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f46359a = 0;

    public static String A(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static void B(Bitmap bitmap) {
    }

    public static void C(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static void D(Throwable th) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean E(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 - d;
        double d9 = d7 - d6;
        double d10 = d4 - d2;
        double d11 = 180.0d - d5;
        double d12 = (d8 * d9) - (d10 * d11);
        if (d12 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            double d13 = d2 - d6;
            double d14 = d - d5;
            double d15 = ((d11 * d13) - (d9 * d14)) / d12;
            double d16 = ((d13 * d8) - (d14 * d10)) / d12;
            if (d15 >= AudioStats.AUDIO_AMPLITUDE_NONE && d15 <= 1.0d && d16 >= AudioStats.AUDIO_AMPLITUDE_NONE && d16 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    public static boolean F(double d, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            a7b.m(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    public static boolean G(double d, LatLng latLng, List<BaseHoleOptions> list, LatLng latLng2) throws RemoteException {
        if (list != null && list.size() > 0) {
            Iterator<BaseHoleOptions> it = list.iterator();
            while (it.hasNext()) {
                if (K(it.next(), latLng2)) {
                    return false;
                }
            }
        }
        return d >= ((double) AMapUtils.calculateLineDistance(latLng, latLng2));
    }

    public static boolean H(double d, LatLng latLng, List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean zG = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            for (int i = 0; i < points.size() && (zG = G(d, latLng, list, points.get(i))); i++) {
            }
        } catch (Throwable th) {
            a7b.m(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return zG;
    }

    public static boolean I(int i, int i2) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w("3dmap", "the map must have a size");
        return false;
    }

    public static boolean J(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static boolean K(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return M(latLng, points);
    }

    public static boolean L(CircleHoleOptions circleHoleOptions, CircleHoleOptions circleHoleOptions2) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions2.getCenter(), circleHoleOptions.getCenter())) < circleHoleOptions.getRadius() + circleHoleOptions2.getRadius();
        } catch (Throwable th) {
            a7b.m(th, gj9.e, "isPolygon2CircleIntersect");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean M(LatLng latLng, List<LatLng> list) {
        boolean z;
        if (latLng == null || list == null) {
            return false;
        }
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z = false;
        } else {
            list.add(list.get(0));
            z = true;
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            try {
                double d3 = list.get(i).longitude;
                double d4 = list.get(i).latitude;
                i++;
                double d5 = list.get(i).longitude;
                double d6 = list.get(i).latitude;
                double d7 = d2;
                double d8 = d;
                if (Z(d, d2, d3, d4, d5, d6)) {
                    if (z) {
                        list.remove(list.size() - 1);
                    }
                    return true;
                }
                if (Math.abs(d6 - d4) >= 1.0E-9d) {
                    if (Z(d3, d4, d8, d7, 180.0d, d7)) {
                        if (d4 > d6) {
                            i2++;
                        }
                    } else if (Z(d5, d6, d8, d7, 180.0d, d7)) {
                        if (d6 > d4) {
                            i2++;
                        }
                    } else if (E(d3, d4, d5, d6, d8, d7, d7)) {
                        i2++;
                    }
                }
                d2 = d7;
                d = d8;
            } catch (Throwable th) {
                if (z) {
                    list.remove(list.size() - 1);
                }
                throw th;
            }
        }
        boolean z2 = i2 % 2 != 0;
        if (z) {
            list.remove(list.size() - 1);
        }
        return z2;
    }

    public static boolean N(List<BaseHoleOptions> list, CircleHoleOptions circleHoleOptions) {
        boolean zL = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                zL = a0(((PolygonHoleOptions) baseHoleOptions).getPoints(), circleHoleOptions);
                if (zL) {
                    return true;
                }
            } else if ((baseHoleOptions instanceof CircleHoleOptions) && (zL = L(circleHoleOptions, (CircleHoleOptions) baseHoleOptions))) {
                return true;
            }
        }
        return zL;
    }

    public static boolean O(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean zA0 = false;
        for (int i = 0; i < list.size(); i++) {
            BaseHoleOptions baseHoleOptions = list.get(i);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                zA0 = P(((PolygonHoleOptions) baseHoleOptions).getPoints(), polygonHoleOptions.getPoints());
                if (zA0) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                zA0 = a0(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (zA0) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return zA0;
    }

    public static boolean P(List<LatLng> list, List<LatLng> list2) {
        for (int i = 0; i < list2.size(); i++) {
            try {
                if (M(list2.get(i), list)) {
                    return true;
                }
            } catch (Throwable th) {
                a7b.m(th, gj9.e, "isPolygon2PolygonIntersect");
                th.printStackTrace();
                return false;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (M(list.get(i2), list2)) {
                return true;
            }
        }
        return c0(list, list2);
    }

    public static boolean Q(List<LatLng> list, List<BaseHoleOptions> list2, CircleHoleOptions circleHoleOptions) {
        try {
            return !a0(list, circleHoleOptions) && R(list, list2, circleHoleOptions.getCenter());
        } catch (Throwable th) {
            a7b.m(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
            return false;
        }
    }

    public static boolean R(List<LatLng> list, List<BaseHoleOptions> list2, LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    Iterator<BaseHoleOptions> it = list2.iterator();
                    while (it.hasNext()) {
                        if (K(it.next(), latLng)) {
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                a7b.m(th, "PolygonDelegateImp", "contains");
                th.printStackTrace();
                return false;
            }
        }
        return M(latLng, list);
    }

    public static byte[] S(byte[] bArr, int i) {
        return T(bArr, i, i, true);
    }

    public static byte[] T(byte[] bArr, int i, int i2, boolean z) {
        try {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Bitmap bitmapCopy = bitmapDecodeByteArray.copy(bitmapDecodeByteArray.getConfig(), true);
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            for (int i3 = 0; i3 < width; i3++) {
                for (int i4 = 0; i4 < height; i4++) {
                    if (i3 != 0 && i4 != 0) {
                        bitmapCopy.setPixel(i3, i4, i);
                    } else if (!z) {
                        bitmapCopy.setPixel(i3, i4, i2);
                    }
                }
            }
            byte[] bArrD0 = d0(bitmapCopy);
            if (bArrD0 == null) {
                bArrD0 = bArr;
            }
            B(bitmapCopy);
            B(bitmapDecodeByteArray);
            return bArrD0;
        } catch (Throwable th) {
            th.printStackTrace();
            return bArr;
        }
    }

    public static synchronized int[] U(int i, int i2, int i3, int i4, IMapConfig iMapConfig, IGLMapState iGLMapState, int i5, int i6) {
        int mapWidth;
        int mapHeight;
        int anchorX;
        int anchorY;
        mapWidth = iMapConfig.getMapWidth();
        mapHeight = iMapConfig.getMapHeight();
        anchorX = iMapConfig.getAnchorX();
        anchorY = iMapConfig.getAnchorY();
        return new int[]{(int) Math.max(i3 + d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorX), Math.min(i5, i - d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - anchorX))), (int) Math.max(i2 + d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorY), Math.min(i6, i4 - d(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - anchorY)))};
    }

    public static synchronized int V() {
        int i = f46359a + 1;
        f46359a = i;
        if (i == Integer.MAX_VALUE) {
            f46359a = 0;
        }
        return f46359a;
    }

    public static Pair<Float, Boolean> W(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float fMin;
        iMapConfig.getSZ();
        boolean z = true;
        if (i == i3 && i2 == i4) {
            fMin = iMapConfig.getMaxZoomLevel();
        } else {
            float fB = (float) b(iMapConfig.getMapZoomScale(), i6, Math.abs(i4 - i2));
            float fB2 = (float) b(iMapConfig.getMapZoomScale(), i5, Math.abs(i3 - i));
            float fMin2 = Math.min(fB2, fB);
            z = fMin2 == fB2;
            fMin = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), fMin2));
        }
        return new Pair<>(Float.valueOf(fMin), Boolean.valueOf(z));
    }

    public static String X(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb.append(str);
        sb.append("data");
        sb.append(str);
        return sb.toString();
    }

    public static String Y(View view) {
        StringBuilder sb = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        String strY = Y(((ViewGroup) view).getChildAt(i));
                        if (!TextUtils.isEmpty(strY)) {
                            sb.append("--");
                            sb.append(strY);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static boolean Z(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= AudioStats.AUDIO_AMPLITUDE_NONE && (d2 - d4) * (d2 - d6) <= AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static boolean a0(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(list.get(i2));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < arrayList.size() && (i = i3 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i3)) && circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i3));
                    arrayList2.add(arrayList.get(i));
                    if (circleHoleOptions.getRadius() >= ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second))) {
                        return true;
                    }
                    i3 = i;
                }
                return true;
            }
        } catch (Throwable th) {
            a7b.m(th, gj9.e, "isPolygon2CircleIntersect");
            th.printStackTrace();
        }
        return false;
    }

    public static double b(float f, double d, double d2) {
        return 20.0d - (Math.log(d2 / (d * ((double) f))) / Math.log(2.0d));
    }

    public static boolean b0(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z = false;
        if (list == null || polygonHoleOptions == null) {
            return false;
        }
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            boolean zM = false;
            for (int i = 0; i < points.size(); i++) {
                try {
                    zM = M(points.get(i), list);
                    if (!zM) {
                        return zM;
                    }
                } catch (Throwable th) {
                    th = th;
                    z = zM;
                    a7b.m(th, "PolygonDelegateImp", "isPolygonInPolygon");
                    th.printStackTrace();
                    return z;
                }
            }
            return zM;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static float c(float f, float f2, double d) {
        return (float) (d / (Math.pow(2.0d, 20.0f - f2) * ((double) f)));
    }

    public static boolean c0(List<LatLng> list, List<LatLng> list2) {
        int i;
        int i2;
        int i3 = 0;
        while (i3 < list.size() && (i = i3 + 1) < list.size()) {
            try {
                int i4 = 0;
                while (i4 < list2.size() && (i2 = i4 + 1) < list2.size()) {
                    boolean zB = uwa.b(list.get(i3), list.get(i), list2.get(i4), list2.get(i2));
                    if (zB) {
                        return zB;
                    }
                    i4 = i2;
                }
                i3 = i;
            } catch (Throwable th) {
                a7b.m(th, gj9.e, "isSegmentsIntersect");
                th.printStackTrace();
            }
        }
        return false;
    }

    public static float d(float f, float f2, float f3) {
        return (float) (((double) f3) * Math.pow(2.0d, 20.0f - f2) * ((double) f));
    }

    public static byte[] d0(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
    }

    public static float e(IGLMapState iGLMapState, int i, int i2, double d, double d2, int i3) {
        IPoint iPointObtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d, d2, 20, iPointObtain);
        float f = f(iGLMapState, i, i2, ((Point) iPointObtain).x, ((Point) iPointObtain).y, i3);
        iPointObtain.recycle();
        return f;
    }

    public static byte[] e0(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int i = inputStream.read(bArr, 0, 2048);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static float f(IGLMapState iGLMapState, int i, int i2, int i3, int i4, int i5) {
        if (iGLMapState != null) {
            return iGLMapState.calculateMapZoomer(i, i2, i3, i4, i5);
        }
        return 3.0f;
    }

    public static String f0(Context context) {
        String strV = v(context);
        if (strV == null) {
            return null;
        }
        File file = new File(strV, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static float g(DPoint dPoint, DPoint dPoint2) {
        if (dPoint == null || dPoint2 == null) {
            return 0.0f;
        }
        double d = dPoint.x;
        double d2 = dPoint2.x;
        return (float) ((Math.atan2(dPoint2.y - dPoint.y, d2 - d) / 3.141592653589793d) * 180.0d);
    }

    public static void g0(View view) {
        int i = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
            }
        } else {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return;
                }
                g0(viewGroup.getChildAt(i));
                i++;
            }
        }
    }

    public static float h(IMapConfig iMapConfig, float f) {
        if (iMapConfig != null) {
            if (f > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            return f < iMapConfig.getMinZoomLevel() ? iMapConfig.getMinZoomLevel() : f;
        }
        float f2 = 20.0f;
        if (f <= 20.0f) {
            f2 = 3.0f;
            if (f >= 3.0f) {
                return f;
            }
        }
        return f2;
    }

    public static boolean h0(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static float i(IMapConfig iMapConfig, float f, float f2) {
        boolean z;
        int i;
        boolean z2 = false;
        if (iMapConfig != null) {
            boolean zIsAbroadEnable = iMapConfig.isAbroadEnable();
            z = iMapConfig.getAbroadState() != 1;
            z2 = zIsAbroadEnable;
        } else {
            z = false;
        }
        float f3 = f >= 0.0f ? f : 0.0f;
        if (z2 && z) {
            if (f3 > 40.0f) {
                return 40.0f;
            }
            return f3;
        }
        if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            if (f3 > 80.0f) {
                return 80.0f;
            }
            return f3;
        }
        if (f <= 40.0f) {
            return f3;
        }
        if (f2 <= 15.0f) {
            i = 40;
        } else if (f2 <= 16.0f) {
            i = 56;
        } else if (f2 <= 17.0f) {
            i = 66;
        } else if (f2 <= 18.0f) {
            i = 74;
        } else {
            i = f2 <= 18.0f ? 78 : 80;
        }
        float f4 = i;
        return f3 > f4 ? f4 : f3;
    }

    public static boolean i0(Context context) {
        File file = new File(X(context));
        if (file.exists()) {
            return FileUtil.deleteFile(file);
        }
        return true;
    }

    public static float j(IMapConfig iMapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float sz = iMapConfig.getSZ();
        if (i == i3 || i2 == i4) {
            return sz;
        }
        return Math.max((float) b(iMapConfig.getMapZoomScale(), i5, Math.abs(i3 - i)), (float) b(iMapConfig.getMapZoomScale(), i6, Math.abs(i4 - i2)));
    }

    public static int k(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap l(Context context, String str) {
        try {
            InputStream inputStreamOpen = twa.b(context).open(str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeStream;
        } catch (Throwable th) {
            a7b.m(th, gj9.e, "fromAsset");
            D(th);
            return null;
        }
    }

    public static Bitmap m(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), true);
    }

    public static Bitmap n(View view) {
        try {
            g0(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            a7b.m(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap o(int[] iArr, int i, int i2) {
        return p(iArr, i, i2, false);
    }

    public static Bitmap p(int[] iArr, int i, int i2, boolean z) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    int i5 = (i3 * i) + i4;
                    int i6 = iArr[i5];
                    int i7 = (i6 & (-16711936)) | ((i6 << 16) & xd9.p) | ((i6 >> 16) & 255);
                    if (z) {
                        iArr2[(((i2 - i3) - 1) * i) + i4] = i7;
                    } else {
                        iArr2[i5] = i7;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            a7b.m(th, gj9.e, "rgbaToArgb");
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Float, IPoint> q(AbstractCameraUpdateMessage abstractCameraUpdateMessage, IMapConfig iMapConfig) {
        return r(iMapConfig, Math.max(abstractCameraUpdateMessage.paddingLeft, 1), Math.max(abstractCameraUpdateMessage.paddingRight, 1), Math.max(abstractCameraUpdateMessage.paddingTop, 1), Math.max(abstractCameraUpdateMessage.paddingBottom, 1), abstractCameraUpdateMessage.bounds, abstractCameraUpdateMessage.width, abstractCameraUpdateMessage.height);
    }

    public static Pair<Float, IPoint> r(IMapConfig iMapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        LatLng latLng;
        int i7;
        float f;
        float f2;
        int i8;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point pointLatLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        Point pointLatLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i9 = pointLatLongToPixels.x;
        int i10 = pointLatLongToPixels2.x;
        int i11 = i9 - i10;
        int i12 = pointLatLongToPixels2.y;
        int i13 = pointLatLongToPixels.y;
        int i14 = i12 - i13;
        int i15 = i5 - (i + i2);
        int i16 = i6 - (i3 + i4);
        if (i11 < 0 && i14 < 0) {
            return null;
        }
        if (i11 <= 0) {
            i11 = 1;
        }
        int i17 = i14 <= 0 ? 1 : i14;
        if (i15 <= 0) {
            i15 = 1;
        }
        if (i16 <= 0) {
            i16 = 1;
        }
        Pair<Float, Boolean> pairW = W(iMapConfig, i9, i13, i10, i12, i15, i16);
        float fFloatValue = ((Float) pairW.first).floatValue();
        boolean zBooleanValue = ((Boolean) pairW.second).booleanValue();
        float fC = c(iMapConfig.getMapZoomScale(), fFloatValue, i11);
        float fC2 = c(iMapConfig.getMapZoomScale(), fFloatValue, i17);
        if (fFloatValue < iMapConfig.getMaxZoomLevel()) {
            if (zBooleanValue) {
                i7 = (int) (pointLatLongToPixels2.x + ((((i5 / 2) - i) / fC) * i11));
                i8 = pointLatLongToPixels.y;
            } else {
                i7 = (int) (pointLatLongToPixels2.x + ((((i2 - i) + fC) * i11) / (fC * 2.0f)));
                f = pointLatLongToPixels.y;
                f2 = (((i6 / 2) - i3) / fC2) * i17;
            }
            return new Pair<>(Float.valueOf(fFloatValue), IPoint.obtain((int) (i7 + d(iMapConfig.getMapZoomScale(), fFloatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f + f2)) + d(iMapConfig.getMapZoomScale(), fFloatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
        }
        i7 = (int) (pointLatLongToPixels2.x + ((((i2 - i) + fC) * i11) / (fC * 2.0f)));
        i8 = pointLatLongToPixels.y;
        f = i8;
        f2 = (((i4 - i3) + fC2) * i17) / (fC2 * 2.0f);
        return new Pair<>(Float.valueOf(fFloatValue), IPoint.obtain((int) (i7 + d(iMapConfig.getMapZoomScale(), fFloatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f + f2)) + d(iMapConfig.getMapZoomScale(), fFloatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
    }

    public static DPoint s(LatLng latLng) {
        double d = (latLng.longitude / 360.0d) + 0.5d;
        double dSin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(d * 1.0d, (((Math.log((dSin + 1.0d) / (1.0d - dSin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static r4b t() {
        try {
            if (qwb.f19195a == null) {
                qwb.f19195a = new r4b.a("3dmap", "9.5.0", qwb.b).b(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("9.5.0").c();
            }
            return qwb.f19195a;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String u(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static String v(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.toString());
        String str = File.separator;
        sb.append(str);
        File file2 = new File(sb.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x00e4 A[Catch: IOException -> 0x00d2, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x00d2, blocks: (B:104:0x00e4, B:93:0x00ce), top: B:106:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0087 A[Catch: IOException -> 0x002b, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x002b, blocks: (B:10:0x0026, B:18:0x0037, B:58:0x0087, B:49:0x0076, B:80:0x00b6, B:71:0x00a5, B:9:0x0023, B:64:0x0099), top: B:116:0x0008, inners: #1, #14 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00b6 A[Catch: IOException -> 0x002b, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x002b, blocks: (B:10:0x0026, B:18:0x0037, B:58:0x0087, B:49:0x0076, B:80:0x00b6, B:71:0x00a5, B:9:0x0023, B:64:0x0099), top: B:116:0x0008, inners: #1, #14 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v5 */
    public static String w(File file) throws Throwable {
        ?? r7;
        FileInputStream fileInputStream;
        IOException e;
        BufferedReader bufferedReader;
        FileNotFoundException e2;
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line != null) {
                                    stringBuffer.append(line);
                                } else {
                                    try {
                                        try {
                                            break;
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            bufferedReader.close();
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                        throw th;
                                    }
                                }
                            } catch (FileNotFoundException e5) {
                                e2 = e5;
                                a7b.m(e2, gj9.e, "readFile fileNotFound");
                                e2.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        try {
                                            fileInputStream.close();
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e7) {
                                                e7.printStackTrace();
                                            }
                                        }
                                        throw th2;
                                    }
                                } else if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (IOException e8) {
                                e = e8;
                                a7b.m(e, gj9.e, "readFile io");
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        try {
                                            fileInputStream.close();
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e10) {
                                                e10.printStackTrace();
                                            }
                                        }
                                        throw th3;
                                    }
                                } else if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                        }
                        fileInputStream.close();
                        bufferedReader.close();
                    } catch (FileNotFoundException e11) {
                        e2 = e11;
                        bufferedReader = null;
                    } catch (IOException e12) {
                        e = e12;
                        bufferedReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        file = null;
                        fileInputStream2 = fileInputStream;
                        r7 = file;
                        try {
                            try {
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                        if (r7 != 0) {
                                            r7.close();
                                        }
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                        if (r7 != 0) {
                                            r7.close();
                                        }
                                        throw th;
                                    }
                                } else if (r7 != 0) {
                                    r7.close();
                                }
                            } catch (Throwable th5) {
                                if (r7 != 0) {
                                    try {
                                        r7.close();
                                    } catch (IOException e14) {
                                        e14.printStackTrace();
                                    }
                                }
                                throw th5;
                            }
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            } catch (FileNotFoundException e17) {
                fileInputStream = null;
                e2 = e17;
                bufferedReader = null;
            } catch (IOException e18) {
                fileInputStream = null;
                e = e18;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                r7 = 0;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                    if (r7 != 0) {
                        r7.close();
                    }
                } else if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
            return stringBuffer.toString();
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static String x(InputStream inputStream) {
        try {
            return new String(e0(inputStream), "utf-8");
        } catch (Throwable th) {
            a7b.m(th, gj9.e, "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    public static String y(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri.getAuthority() != null && uri.getAuthority().startsWith("dualstack-")) {
                return str;
            }
            if (uri.getAuthority() != null && uri.getAuthority().startsWith("restsdk.amap.com")) {
                return uri.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
            }
            return uri.buildUpon().authority("dualstack-" + uri.getAuthority()).build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String z(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }
}
