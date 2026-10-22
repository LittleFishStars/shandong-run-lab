package com.google.zxing.multi.qrcode.detector;

import androidx.camera.video.AudioStats;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.zj.adlib.ah3;
import com.zj.adlib.ch3;
import com.zj.adlib.tv0;
import com.zj.adlib.xg7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f32514a = 180.0f;
    public static final float b = 9.0f;
    public static final float c = 0.05f;
    public static final float d = 0.5f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ch3[] f6746a = new ch3[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ah3[] f6745a = new ah3[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ah3[][] f6747a = new ah3[0][];

    public static final class ModuleSizeComparator implements Comparator<ah3>, Serializable {
        private ModuleSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ah3 ah3Var, ah3 ah3Var2) {
            double dI = ah3Var2.i() - ah3Var.i();
            if (dI < AudioStats.AUDIO_AMPLITUDE_NONE) {
                return -1;
            }
            return dI > AudioStats.AUDIO_AMPLITUDE_NONE ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(tv0 tv0Var, ResultPointCallback resultPointCallback) {
        super(tv0Var, resultPointCallback);
    }

    public ch3[] k(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        tv0 image = getImage();
        int iO = image.o();
        int iT = image.t();
        int i = (iO * 3) / MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        for (int i2 = i - 1; i2 < iO; i2 += i) {
            FinderPatternFinder.doClearCounts(iArr);
            int i3 = 0;
            for (int i4 = 0; i4 < iT; i4++) {
                if (image.k(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 != 4) {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                } else if (FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i4)) {
                    FinderPatternFinder.doClearCounts(iArr);
                    i3 = 0;
                } else {
                    FinderPatternFinder.doShiftCounts2(iArr);
                    i3 = 3;
                }
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i2, iT);
            }
        }
        ah3[][] ah3VarArrL = l();
        ArrayList arrayList = new ArrayList();
        for (ah3[] ah3VarArr : ah3VarArrL) {
            xg7.e(ah3VarArr);
            arrayList.add(new ch3(ah3VarArr));
        }
        return arrayList.isEmpty() ? f6746a : (ch3[]) arrayList.toArray(f6746a);
    }

    public final ah3[][] l() throws NotFoundException {
        List<ah3> possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i = 3;
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new ah3[][]{(ah3[]) possibleCenters.toArray(f6745a)};
        }
        Collections.sort(possibleCenters, new ModuleSizeComparator());
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < size - 2) {
            ah3 ah3Var = possibleCenters.get(i2);
            if (ah3Var != null) {
                int i3 = i2 + 1;
                while (i3 < size - 1) {
                    ah3 ah3Var2 = possibleCenters.get(i3);
                    if (ah3Var2 != null) {
                        float fI = (ah3Var.i() - ah3Var2.i()) / Math.min(ah3Var.i(), ah3Var2.i());
                        float f = 0.5f;
                        float f2 = 0.05f;
                        if (Math.abs(ah3Var.i() - ah3Var2.i()) > 0.5f && fI >= 0.05f) {
                            break;
                        }
                        int i4 = i3 + 1;
                        while (i4 < size) {
                            ah3 ah3Var3 = possibleCenters.get(i4);
                            if (ah3Var3 != null) {
                                float fI2 = (ah3Var2.i() - ah3Var3.i()) / Math.min(ah3Var2.i(), ah3Var3.i());
                                if (Math.abs(ah3Var2.i() - ah3Var3.i()) > f && fI2 >= f2) {
                                    break;
                                }
                                ah3[] ah3VarArr = new ah3[i];
                                ah3VarArr[c2] = ah3Var;
                                ah3VarArr[1] = ah3Var2;
                                ah3VarArr[2] = ah3Var3;
                                xg7.e(ah3VarArr);
                                ch3 ch3Var = new ch3(ah3VarArr);
                                float fB = xg7.b(ch3Var.b(), ch3Var.a());
                                float fB2 = xg7.b(ch3Var.c(), ch3Var.a());
                                float fB3 = xg7.b(ch3Var.b(), ch3Var.c());
                                float fI3 = (fB + fB3) / (ah3Var.i() * 2.0f);
                                if (fI3 <= 180.0f && fI3 >= 9.0f && Math.abs((fB - fB3) / Math.min(fB, fB3)) < 0.1f) {
                                    double d2 = fB;
                                    double d3 = fB3;
                                    float fSqrt = (float) Math.sqrt((d2 * d2) + (d3 * d3));
                                    if (Math.abs((fB2 - fSqrt) / Math.min(fB2, fSqrt)) < 0.1f) {
                                        arrayList.add(ah3VarArr);
                                    }
                                }
                            }
                            i4++;
                            i = 3;
                            c2 = 0;
                            f = 0.5f;
                            f2 = 0.05f;
                        }
                    }
                    i3++;
                    i = 3;
                    c2 = 0;
                }
            }
            i2++;
            i = 3;
            c2 = 0;
        }
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (ah3[][]) arrayList.toArray(f6747a);
    }
}
