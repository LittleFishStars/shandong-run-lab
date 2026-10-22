package com.kc.openset.pine.entry;

import androidx.camera.video.AudioStats;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.PineConfig;
import com.kc.openset.pine.utils.Primitives;
import com.kc.openset.pine.utils.ThreeTuple;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class Arm32Entry {
    private static final int CR_SIZE = 3;
    private static final boolean DISALLOW_LONG_CROSS_CR_AND_STACK;
    private static final int FPR_SIZE = 16;
    private static final boolean USE_HARDFP;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final float[] EMPTY_FLOAT_ARRAY = new float[0];

    /* JADX INFO: renamed from: com.kc.openset.pine.entry.Arm32Entry$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {
    }

    @Keep
    public static class ParamTypesCache {
        int crLength;
        int fpLength;
        int stackLength;

        private ParamTypesCache() {
        }

        public /* synthetic */ ParamTypesCache(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        int i = PineConfig.sdkLevel;
        USE_HARDFP = i >= 23;
        DISALLOW_LONG_CROSS_CR_AND_STACK = i >= 31;
    }

    private Arm32Entry() {
    }

    private static boolean booleanBridge(int i, int i2, int i3) {
        try {
            return ((Boolean) handleBridge(i, i2, i3)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static byte byteBridge(int i, int i2, int i3) {
        try {
            return ((Byte) handleBridge(i, i2, i3)).byteValue();
        } catch (Throwable unused) {
            return (byte) 0;
        }
    }

    private static char charBridge(int i, int i2, int i3) {
        try {
            return ((Character) handleBridge(i, i2, i3)).charValue();
        } catch (Throwable unused) {
            return ' ';
        }
    }

    private static double doubleBridge(int i, int i2, int i3) {
        try {
            return ((Double) handleBridge(i, i2, i3)).doubleValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    private static float floatBridge(int i, int i2, int i3) {
        try {
            return ((Float) handleBridge(i, i2, i3)).floatValue();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    private static ThreeTuple<int[], int[], float[]> getArgs(Pine.HookRecord hookRecord, int i, int i2) {
        int iMin;
        int i3;
        int i4;
        if (hookRecord.paramTypesCache == null) {
            iMin = !hookRecord.isStatic ? 1 : 0;
            int i5 = 0;
            int i6 = 0;
            i3 = iMin;
            for (Class<?> cls : hookRecord.paramTypes) {
                if (cls == Double.TYPE) {
                    i5++;
                    i3++;
                } else if (cls == Float.TYPE) {
                    i6++;
                } else {
                    if (cls == Long.TYPE) {
                        if (iMin == 0) {
                            iMin++;
                        }
                        if (iMin < 3) {
                            iMin++;
                        }
                        i3++;
                    }
                    if (iMin < 3) {
                        iMin++;
                    }
                }
                i3++;
            }
            i4 = (i5 * 2) + i6;
            ParamTypesCache paramTypesCache = new ParamTypesCache(null);
            paramTypesCache.crLength = iMin;
            paramTypesCache.stackLength = i3;
            paramTypesCache.fpLength = i4;
            hookRecord.paramTypesCache = paramTypesCache;
        } else {
            ParamTypesCache paramTypesCache2 = (ParamTypesCache) hookRecord.paramTypesCache;
            iMin = paramTypesCache2.crLength;
            i3 = paramTypesCache2.stackLength;
            i4 = paramTypesCache2.fpLength;
        }
        float[] fArr = EMPTY_FLOAT_ARRAY;
        if (!USE_HARDFP) {
            iMin = Math.min(iMin + i4, 3);
        } else if (i4 != 0) {
            fArr = new float[Math.min(Primitives.evenUp(i4), 16)];
        }
        int[] iArr = iMin != 0 ? new int[iMin] : EMPTY_INT_ARRAY;
        int[] iArr2 = i3 != 0 ? new int[i3] : EMPTY_INT_ARRAY;
        Pine.getArgsArm32(i, i2, iArr, iArr2, fArr);
        return new ThreeTuple<>(iArr, iArr2, fArr);
    }

    private static Object handleBridge(int i, int i2, int i3) throws Throwable {
        Object object;
        int i4;
        Object[] objArr;
        int i5;
        int i6;
        Object object2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iCloneExtras = (int) Pine.cloneExtras(i2);
        int i15 = 1;
        Pine.log("handleBridge: artMethod=%#x originExtras=%#x extras=%#x sp=%#x", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iCloneExtras), Integer.valueOf(i3));
        Pine.HookRecord hookRecord = Pine.getHookRecord(i);
        ThreeTuple<int[], int[], float[]> args = getArgs(hookRecord, iCloneExtras, i3);
        int[] iArr = args.f39808a;
        int[] iArr2 = args.b;
        float[] fArr = args.c;
        long jCurrentArtThread0 = Pine.currentArtThread0();
        if (hookRecord.isStatic) {
            object = null;
            i4 = 0;
        } else {
            object = Pine.getObject(jCurrentArtThread0, iArr[0]);
            i4 = 1;
        }
        int i16 = i4;
        int i17 = hookRecord.paramNumber;
        if (i17 > 0) {
            objArr = new Object[i17];
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (i19 < hookRecord.paramNumber) {
                Class<?> cls = hookRecord.paramTypes[i19];
                if (cls == Double.TYPE) {
                    int iMax = Math.max(i20, Primitives.evenUp(i18));
                    if (iMax < fArr.length) {
                        int i21 = iMax + 1;
                        i16++;
                        object2 = Double.valueOf(Primitives.floats2Double(fArr[iMax], fArr[i21]));
                        i20 = i21 + i15;
                    } else {
                        if (i4 >= iArr.length || USE_HARDFP) {
                            i12 = iArr2[i16];
                        } else {
                            i12 = iArr[i4];
                            i4++;
                        }
                        i16++;
                        if (i4 >= iArr.length || USE_HARDFP) {
                            i13 = i4;
                            i14 = iArr2[i16];
                        } else {
                            i13 = i4 + 1;
                            i14 = iArr[i4];
                        }
                        Double dValueOf = Double.valueOf(Primitives.ints2Double(i12, i14));
                        i4 = i13;
                        i20 = iMax;
                        object2 = dValueOf;
                    }
                    i5 = i18;
                } else if (cls == Float.TYPE) {
                    int i22 = i18;
                    int iMax2 = i22 % 2 == 0 ? Math.max(i20, i22) : i22;
                    if (iMax2 < fArr.length) {
                        i5 = iMax2 + 1;
                        object2 = Float.valueOf(fArr[iMax2]);
                    } else {
                        if (i4 >= iArr.length || USE_HARDFP) {
                            int i23 = i4;
                            i10 = iArr2[i16];
                            i11 = i23;
                        } else {
                            i11 = i4 + 1;
                            i10 = iArr[i4];
                        }
                        int i24 = i11;
                        i5 = iMax2;
                        object2 = Float.valueOf(Float.intBitsToFloat(i10));
                        i4 = i24;
                    }
                } else {
                    i5 = i18;
                    if (cls == Long.TYPE) {
                        if (i4 == 0 && hookRecord.isStatic && USE_HARDFP) {
                            objArr[i19] = Long.valueOf(Primitives.ints2Long(iArr[i15], iArr[2]));
                            i16 += 2;
                            i4 = 3;
                        } else {
                            if (i4 == 2 && DISALLOW_LONG_CROSS_CR_AND_STACK) {
                                i4 = 3;
                            }
                            if (i4 < iArr.length) {
                                i7 = iArr[i4];
                                i4++;
                            } else {
                                i7 = iArr2[i16];
                            }
                            i16++;
                            if (i4 < iArr.length) {
                                i9 = i4 + 1;
                                i8 = iArr[i4];
                            } else {
                                int i25 = i4;
                                i8 = iArr2[i16];
                                i9 = i25;
                            }
                            object2 = Long.valueOf(Primitives.ints2Long(i7, i8));
                            i4 = i9;
                        }
                        i19++;
                        i18 = i5;
                    } else {
                        if (i4 < iArr.length) {
                            i6 = iArr[i4];
                            i4++;
                        } else {
                            i6 = iArr2[i16];
                        }
                        if (!cls.isPrimitive()) {
                            object2 = Pine.getObject(jCurrentArtThread0, i6);
                        } else if (cls == Integer.TYPE) {
                            object2 = Integer.valueOf(i6);
                        } else if (cls == Boolean.TYPE) {
                            object2 = Boolean.valueOf(i6 != 0);
                        } else if (cls == Short.TYPE) {
                            object2 = Short.valueOf((short) i6);
                        } else if (cls == Character.TYPE) {
                            object2 = Character.valueOf((char) i6);
                        } else {
                            if (cls != Byte.TYPE) {
                                throw new AssertionError("Unknown primitive type: " + cls);
                            }
                            object2 = Byte.valueOf((byte) i6);
                        }
                    }
                }
                objArr[i19] = object2;
                i15 = 1;
                i16++;
                i19++;
                i18 = i5;
            }
        } else {
            objArr = Pine.EMPTY_OBJECT_ARRAY;
        }
        return Pine.handleCall(hookRecord, object, objArr);
    }

    private static int intBridge(int i, int i2, int i3) {
        try {
            return ((Integer) handleBridge(i, i2, i3)).intValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return 0;
        }
    }

    private static long longBridge(int i, int i2, int i3) {
        try {
            return ((Long) handleBridge(i, i2, i3)).longValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return 0L;
        }
    }

    private static Object objectBridge(int i, int i2, int i3) {
        try {
            return handleBridge(i, i2, i3);
        } catch (Throwable th) {
            Pine.requestError(th);
            return null;
        }
    }

    private static short shortBridge(int i, int i2, int i3) {
        try {
            return ((Short) handleBridge(i, i2, i3)).shortValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return (short) 0;
        }
    }

    private static void voidBridge(int i, int i2, int i3) {
        try {
            handleBridge(i, i2, i3);
        } catch (Throwable th) {
            Pine.requestError(th);
        }
    }
}
