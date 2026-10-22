package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.alibaba.ariver.kernel.RVParams;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.zj.adlib.y6b;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public static final Interpolator c = new LinearInterpolator();
    public static SparseArray<WeakReference<Interpolator>> tt;

    private static SparseArray<WeakReference<Interpolator>> c() {
        if (tt == null) {
            tt = new SparseArray<>();
        }
        return tt;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0273  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static <T> com.byazt.vc.c<T> tt(com.byazt.ga.a aVar, JsonReader jsonReader, float f, aw<T> awVar) throws IOException {
        Interpolator interpolatorC;
        Interpolator interpolatorC2;
        T t;
        Interpolator interpolatorC3;
        com.byazt.vc.c<T> cVar;
        float f2;
        PointF pointF;
        PointF pointF2;
        T t2;
        String str;
        String str2;
        jsonReader.beginObject();
        PointF pointFTt = null;
        boolean z = false;
        PointF pointFTt2 = null;
        PointF pointFTt3 = null;
        PointF pointF3 = null;
        T tTt = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fNextDouble = 0.0f;
        PointF pointFTt4 = null;
        T tTt2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 101:
                    if (strNextName.equals("e")) {
                        b = 0;
                    }
                    break;
                case 104:
                    if (strNextName.equals(y6b.g)) {
                        b = 1;
                    }
                    break;
                case 105:
                    if (strNextName.equals("i")) {
                        b = 2;
                    }
                    break;
                case 111:
                    if (strNextName.equals(j.b)) {
                        b = 3;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b = 4;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 5;
                    }
                    break;
                case 3701:
                    if (strNextName.equals(RVParams.TITLE_IMAGE)) {
                        b = 6;
                    }
                    break;
                case 3707:
                    if (strNextName.equals("to")) {
                        b = 7;
                    }
                    break;
            }
            String str3 = "y";
            String str4 = "x";
            switch (b) {
                case 0:
                    f2 = fNextDouble;
                    tTt2 = awVar.tt(jsonReader, f);
                    fNextDouble = f2;
                    break;
                case 1:
                    pointF = pointFTt;
                    f2 = fNextDouble;
                    pointF2 = pointFTt4;
                    t2 = tTt;
                    z = jsonReader.nextInt() == 1;
                    tTt = t2;
                    pointFTt4 = pointF2;
                    pointFTt = pointF;
                    fNextDouble = f2;
                    break;
                case 2:
                    pointF = pointFTt;
                    f2 = fNextDouble;
                    pointF2 = pointFTt4;
                    t2 = tTt;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals(str4)) {
                                str = str3;
                                str2 = str4;
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (!strNextName2.equals(str3)) {
                                jsonReader.skipValue();
                            } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                str = str3;
                                str2 = str4;
                                fNextDouble5 = (float) jsonReader.nextDouble();
                                fNextDouble3 = fNextDouble5;
                            } else {
                                str = str3;
                                str2 = str4;
                                jsonReader.beginArray();
                                fNextDouble3 = (float) jsonReader.nextDouble();
                                fNextDouble5 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble3;
                                jsonReader.endArray();
                            }
                            str3 = str;
                            str4 = str2;
                        }
                        PointF pointF7 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF8 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF6 = pointF8;
                        pointF5 = pointF7;
                    } else {
                        pointFTt3 = my.tt(jsonReader, f);
                    }
                    tTt = t2;
                    pointFTt4 = pointF2;
                    pointFTt = pointF;
                    fNextDouble = f2;
                    break;
                case 3:
                    pointF2 = pointFTt4;
                    pointF = pointFTt;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        float fNextDouble8 = 0.0f;
                        float fNextDouble9 = 0.0f;
                        while (jsonReader.hasNext()) {
                            float f3 = fNextDouble;
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("x")) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble8 = (float) jsonReader.nextDouble();
                                    fNextDouble6 = fNextDouble8;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble8 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                }
                                tTt = tTt;
                            } else if (!strNextName3.equals("y")) {
                                jsonReader.skipValue();
                            } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                fNextDouble9 = (float) jsonReader.nextDouble();
                                fNextDouble7 = fNextDouble9;
                            } else {
                                jsonReader.beginArray();
                                fNextDouble7 = (float) jsonReader.nextDouble();
                                fNextDouble9 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble7;
                                jsonReader.endArray();
                            }
                            fNextDouble = f3;
                        }
                        f2 = fNextDouble;
                        PointF pointF9 = new PointF(fNextDouble6, fNextDouble7);
                        PointF pointF10 = new PointF(fNextDouble8, fNextDouble9);
                        jsonReader.endObject();
                        pointF4 = pointF10;
                        pointF3 = pointF9;
                    } else {
                        f2 = fNextDouble;
                        pointFTt2 = my.tt(jsonReader, f);
                    }
                    pointFTt4 = pointF2;
                    pointFTt = pointF;
                    fNextDouble = f2;
                    break;
                case 4:
                    tTt = awVar.tt(jsonReader, f);
                    break;
                case 5:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    pointFTt = my.tt(jsonReader, f);
                    break;
                case 7:
                    pointFTt4 = my.tt(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF11 = pointFTt;
        float f4 = fNextDouble;
        PointF pointF12 = pointFTt4;
        T t3 = tTt;
        jsonReader.endObject();
        if (!z) {
            if (pointFTt2 != null && pointFTt3 != null) {
                interpolatorC3 = c(pointFTt2, pointFTt3);
                t = tTt2;
                interpolatorC = null;
                interpolatorC2 = null;
            } else if (pointF3 != null && pointF4 != null && pointF5 != null && pointF6 != null) {
                interpolatorC = c(pointF3, pointF5);
                interpolatorC2 = c(pointF4, pointF6);
                t = tTt2;
                interpolatorC3 = null;
            }
            if (interpolatorC != null || interpolatorC2 == null) {
                cVar = new com.byazt.vc.c<>(aVar, t3, t, interpolatorC3, f4, null);
            } else {
                cVar = new com.byazt.vc.c<>(aVar, t3, t, interpolatorC, interpolatorC2, f4, null);
            }
            cVar.x = pointF12;
            cVar.i = pointF11;
            return cVar;
        }
        tTt2 = t3;
        interpolatorC3 = c;
        t = tTt2;
        interpolatorC = null;
        interpolatorC2 = null;
        if (interpolatorC != null) {
            cVar = new com.byazt.vc.c<>(aVar, t3, t, interpolatorC3, f4, null);
        } else {
            cVar = new com.byazt.vc.c<>(aVar, t3, t, interpolatorC3, f4, null);
        }
        cVar.x = pointF12;
        cVar.i = pointF11;
        return cVar;
    }

    private static WeakReference<Interpolator> c(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (gt.class) {
            weakReference = c().get(i);
        }
        return weakReference;
    }

    private static void c(int i, WeakReference<Interpolator> weakReference) {
        synchronized (gt.class) {
            tt.put(i, weakReference);
        }
    }

    public static <T> com.byazt.vc.c<T> c(JsonReader jsonReader, com.byazt.ga.a aVar, float f, aw<T> awVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return tt(aVar, jsonReader, f, awVar);
        }
        if (z) {
            return c(aVar, jsonReader, f, awVar);
        }
        return c(jsonReader, f, awVar);
    }

    private static <T> com.byazt.vc.c<T> c(com.byazt.ga.a aVar, JsonReader jsonReader, float f, aw<T> awVar) throws IOException {
        Interpolator interpolatorC;
        jsonReader.beginObject();
        PointF pointFTt = null;
        T tTt = null;
        T tTt2 = null;
        PointF pointFTt2 = null;
        PointF pointFTt3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFTt4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tTt = awVar.tt(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFTt4 = my.tt(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFTt = my.tt(jsonReader, 1.0f);
                    break;
                case "s":
                    tTt2 = awVar.tt(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFTt3 = my.tt(jsonReader, f);
                    break;
                case "to":
                    pointFTt2 = my.tt(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFTt != null && pointFTt4 != null) {
                interpolatorC = c(pointFTt, pointFTt4);
            }
            com.byazt.vc.c<T> cVar = new com.byazt.vc.c<>(aVar, tTt2, tTt, interpolatorC, fNextDouble, null);
            cVar.x = pointFTt2;
            cVar.i = pointFTt3;
            return cVar;
        }
        tTt = tTt2;
        interpolatorC = c;
        com.byazt.vc.c<T> cVar2 = new com.byazt.vc.c<>(aVar, tTt2, tTt, interpolatorC, fNextDouble, null);
        cVar2.x = pointFTt2;
        cVar2.i = pointFTt3;
        return cVar2;
    }

    private static Interpolator c(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.byazt.kk.i.tt(pointF.x, -1.0f, 1.0f);
        pointF.y = com.byazt.kk.i.tt(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.byazt.kk.i.tt(pointF2.x, -1.0f, 1.0f);
        float fTt = com.byazt.kk.i.tt(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fTt;
        int iC = com.byazt.kk.da.c(pointF.x, pointF.y, pointF2.x, fTt);
        WeakReference<Interpolator> weakReferenceC = com.byazt.ga.n.c() ? null : c(iC);
        Interpolator interpolator = weakReferenceC != null ? weakReferenceC.get() : null;
        if (weakReferenceC == null || interpolator == null) {
            try {
                linearInterpolator = com.byazt.ga.nu.c(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.byazt.ga.nu.c(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.byazt.ga.n.c()) {
                try {
                    c(iC, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.byazt.vc.c<T> c(JsonReader jsonReader, float f, aw<T> awVar) throws IOException {
        return new com.byazt.vc.c<>(awVar.tt(jsonReader, f));
    }
}
