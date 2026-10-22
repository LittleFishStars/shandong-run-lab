package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import com.zj.adlib.jv0;
import com.zj.adlib.qv0;
import com.zj.adlib.ug7;
import com.zj.adlib.xg7;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class OneDReader implements Reader {
    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void recordPattern(qv0 qv0Var, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iS = qv0Var.s();
        if (i >= iS) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !qv0Var.m(i);
        while (i < iS) {
            if (qv0Var.m(i) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != iS) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void recordPatternInReverse(qv0 qv0Var, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zM = qv0Var.m(i);
        while (i > 0 && length >= 0) {
            i--;
            if (qv0Var.m(i) != zM) {
                length--;
                zM = !zM;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(qv0Var, i + 1, iArr);
    }

    @Override // com.google.zxing.Reader
    public ug7 a(jv0 jv0Var) throws NotFoundException, FormatException {
        return d(jv0Var, null);
    }

    public abstract ug7 b(int i, qv0 qv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    public final ug7 c(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2;
        int i;
        int i2;
        Map<DecodeHintType, ?> map3 = map;
        int iE = jv0Var.e();
        int iD = jv0Var.d();
        qv0 qv0Var = new qv0(iE);
        int i3 = 0;
        int i4 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, iD >> (z ? 8 : 5));
        int i5 = z ? iD : 15;
        int i6 = iD / 2;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (((i7 & 1) == 0 ? i4 : i3) == 0) {
                i9 = -i9;
            }
            int i10 = (i9 * iMax) + i6;
            if (i10 < 0 || i10 >= iD) {
                break;
            }
            try {
                qv0Var = jv0Var.c(i10, qv0Var);
                int i11 = i3;
                while (i11 < 2) {
                    if (i11 == i4) {
                        qv0Var.x();
                        if (map3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        ug7 ug7VarB = b(i10, qv0Var, map3);
                        if (i11 == i4) {
                            try {
                                ug7VarB.j(ResultMetadataType.ORIENTATION, 180);
                                xg7[] xg7VarArrF = ug7VarB.f();
                                if (xg7VarArrF != null) {
                                    map2 = map3;
                                    float f = iE;
                                    try {
                                        i = iE;
                                        try {
                                            xg7VarArrF[0] = new xg7((f - xg7VarArrF[i3].c()) - 1.0f, xg7VarArrF[i3].d());
                                            i2 = 1;
                                            try {
                                                xg7VarArrF[1] = new xg7((f - xg7VarArrF[1].c()) - 1.0f, xg7VarArrF[1].d());
                                            } catch (ReaderException unused) {
                                                continue;
                                                i11++;
                                                i4 = i2;
                                                map3 = map2;
                                                iE = i;
                                                i3 = 0;
                                            }
                                        } catch (ReaderException unused2) {
                                            i2 = 1;
                                            i11++;
                                            i4 = i2;
                                            map3 = map2;
                                            iE = i;
                                            i3 = 0;
                                        }
                                    } catch (ReaderException unused3) {
                                        i = iE;
                                        i2 = 1;
                                        i11++;
                                        i4 = i2;
                                        map3 = map2;
                                        iE = i;
                                        i3 = 0;
                                    }
                                }
                            } catch (ReaderException unused4) {
                                map2 = map3;
                            }
                        }
                        return ug7VarB;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                        i = iE;
                        i2 = i4;
                    }
                }
            } catch (NotFoundException unused6) {
            }
            i7 = i8;
            i4 = i4;
            iE = iE;
            i3 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.Reader
    public ug7 d(jv0 jv0Var, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return c(jv0Var, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !jv0Var.g()) {
                throw e;
            }
            jv0 jv0VarH = jv0Var.h();
            ug7 ug7VarC = c(jv0VarH, map);
            Map<ResultMetadataType, Object> mapE = ug7VarC.e();
            int iIntValue = 270;
            if (mapE != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (mapE.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) mapE.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            ug7VarC.j(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            xg7[] xg7VarArrF = ug7VarC.f();
            if (xg7VarArrF != null) {
                int iD = jv0VarH.d();
                for (int i = 0; i < xg7VarArrF.length; i++) {
                    xg7VarArrF[i] = new xg7((iD - xg7VarArrF[i].d()) - 1.0f, xg7VarArrF[i].c());
                }
            }
            return ug7VarC;
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
