package com.kc.openset.pine.entry;

import androidx.camera.video.AudioStats;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.utils.ThreeTuple;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class Arm64Entry {
    private static final long BYTE_BITS = 255;
    private static final int CR_SIZE = 7;
    private static final int FPR_SIZE = 8;
    private static final long INT_BITS = 4294967295L;
    private static final long SHORT_BITS = 65535;
    private static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    /* JADX INFO: renamed from: com.kc.openset.pine.entry.Arm64Entry$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {
    }

    @Keep
    public static class ParamTypesCache {
        int crLength;
        int fprLength;
        int stackLength;
        boolean[] typeWides;

        private ParamTypesCache() {
        }

        public /* synthetic */ ParamTypesCache(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private Arm64Entry() {
    }

    public static boolean booleanBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Boolean) handleBridge(j, j2, j3, j4, j5, j6, j7)).booleanValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return false;
        }
    }

    public static byte byteBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Byte) handleBridge(j, j2, j3, j4, j5, j6, j7)).byteValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return (byte) 0;
        }
    }

    public static char charBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Character) handleBridge(j, j2, j3, j4, j5, j6, j7)).charValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return ' ';
        }
    }

    public static double doubleBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Double) handleBridge(j, j2, j3, j4, j5, j6, j7)).doubleValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public static float floatBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Float) handleBridge(j, j2, j3, j4, j5, j6, j7)).floatValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return 0.0f;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0044  */
    /* JADX WARN: Code duplicated, block: B:31:0x0047  */
    /* JADX WARN: Code duplicated, block: B:33:0x004a  */
    /* JADX WARN: Code duplicated, block: B:36:0x004f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0055  */
    /* JADX WARN: Code duplicated, block: B:40:0x0058  */
    private static ThreeTuple<long[], long[], double[]> getArgs(Pine.HookRecord hookRecord, long j, long j2, long j3, long j4, long j5, long j6) {
        int i;
        int i2;
        int i3;
        boolean[] zArr;
        boolean z;
        boolean z2;
        if (hookRecord.paramTypesCache == null) {
            int i4 = hookRecord.paramNumber;
            boolean z3 = hookRecord.isStatic;
            if (z3) {
                i = 0;
            } else {
                i4++;
                i = 1;
            }
            i2 = i;
            if (i4 != 0) {
                zArr = new boolean[i4];
                if (!z3) {
                    zArr[0] = false;
                }
                i3 = 0;
                for (int i5 = 0; i5 < hookRecord.paramNumber; i5++) {
                    Class<?> cls = hookRecord.paramTypes[i5];
                    if (cls == Double.TYPE) {
                        z = true;
                    } else {
                        if (cls == Float.TYPE) {
                            z2 = false;
                            z = true;
                        } else if (cls == Long.TYPE) {
                            z = false;
                            z2 = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            if (i3 < 8) {
                                i3++;
                            }
                        } else if (i < 7) {
                            i++;
                        }
                        i2 += z2 ? 8 : 4;
                        if (hookRecord.isStatic) {
                            zArr[i5] = z2;
                        } else {
                            zArr[i5 + 1] = z2;
                        }
                    }
                    z2 = z;
                    if (z) {
                        if (i3 < 8) {
                            i3++;
                        }
                    } else if (i < 7) {
                        i++;
                    }
                    i2 += z2 ? 8 : 4;
                    if (hookRecord.isStatic) {
                        zArr[i5] = z2;
                    } else {
                        zArr[i5 + 1] = z2;
                    }
                }
            } else {
                zArr = EMPTY_BOOLEAN_ARRAY;
                i3 = 0;
            }
            ParamTypesCache paramTypesCache = new ParamTypesCache(null);
            paramTypesCache.crLength = i;
            paramTypesCache.stackLength = i2;
            paramTypesCache.fprLength = i3;
            paramTypesCache.typeWides = (boolean[]) zArr.clone();
            hookRecord.paramTypesCache = paramTypesCache;
        } else {
            ParamTypesCache paramTypesCache2 = (ParamTypesCache) hookRecord.paramTypesCache;
            i = paramTypesCache2.crLength;
            i2 = paramTypesCache2.stackLength;
            i3 = paramTypesCache2.fprLength;
            zArr = (boolean[]) paramTypesCache2.typeWides.clone();
        }
        boolean[] zArr2 = zArr;
        int i6 = j2 != 0 ? i2 : 0;
        long[] jArr = i != 0 ? new long[i] : EMPTY_LONG_ARRAY;
        long[] jArr2 = i6 != 0 ? new long[i6] : EMPTY_LONG_ARRAY;
        double[] dArr = i3 != 0 ? new double[i3] : EMPTY_DOUBLE_ARRAY;
        Pine.getArgsArm64(j, j2, zArr2, jArr, jArr2, dArr);
        if (i >= 4) {
            jArr[3] = j3;
            if (i != 4) {
                jArr[4] = j4;
                if (i != 5) {
                    jArr[5] = j5;
                    if (i != 6) {
                        jArr[6] = j6;
                    }
                }
            }
        }
        return new ThreeTuple<>(jArr, jArr2, dArr);
    }

    private static Object handleBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) throws Throwable {
        Object object;
        int i;
        Object[] objArr;
        long j8;
        Object object2;
        long jDoubleToLongBits;
        int i2;
        Object objValueOf;
        long jCloneExtras = Pine.cloneExtras(j2);
        Pine.log("handleBridge: artMethod=%#x originExtras=%#x extras=%#x sp=%#x", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(jCloneExtras), Long.valueOf(j3));
        Pine.HookRecord hookRecord = Pine.getHookRecord(j);
        ThreeTuple<long[], long[], double[]> args = getArgs(hookRecord, jCloneExtras, j3, j4, j5, j6, j7);
        long[] jArr = args.f39808a;
        long[] jArr2 = args.b;
        double[] dArr = args.c;
        long jCurrentArtThread0 = Pine.currentArtThread0();
        if (hookRecord.isStatic) {
            object = null;
            i = 0;
        } else {
            object = Pine.getObject(jCurrentArtThread0, jArr[0]);
            i = 1;
        }
        int i3 = i;
        int i4 = hookRecord.paramNumber;
        if (i4 > 0) {
            objArr = new Object[i4];
            int i5 = 0;
            int i6 = 0;
            while (i5 < hookRecord.paramNumber) {
                Class<?> cls = hookRecord.paramTypes[i5];
                if (cls == Double.TYPE) {
                    if (i6 < dArr.length) {
                        i2 = i6 + 1;
                        objValueOf = Double.valueOf(dArr[i6]);
                    } else {
                        object2 = Double.valueOf(Double.longBitsToDouble(jArr2[i]));
                    }
                    objArr[i5] = objValueOf;
                    i++;
                    i5++;
                    i6 = i2;
                } else if (cls == Float.TYPE) {
                    if (i6 < dArr.length) {
                        jDoubleToLongBits = Double.doubleToLongBits(dArr[i6]);
                        i6++;
                    } else {
                        jDoubleToLongBits = jArr2[i];
                    }
                    object2 = Float.valueOf(Float.intBitsToFloat((int) (jDoubleToLongBits & 4294967295L)));
                } else {
                    if (i3 < jArr.length) {
                        j8 = jArr[i3];
                        i3++;
                    } else {
                        j8 = jArr2[i];
                    }
                    if (!cls.isPrimitive()) {
                        object2 = Pine.getObject(jCurrentArtThread0, j8 & 4294967295L);
                    } else if (cls == Integer.TYPE) {
                        object2 = Integer.valueOf((int) (j8 & 4294967295L));
                    } else if (cls == Long.TYPE) {
                        object2 = Long.valueOf(j8);
                    } else if (cls == Boolean.TYPE) {
                        object2 = Boolean.valueOf((j8 & 4294967295L) != 0);
                    } else if (cls == Short.TYPE) {
                        object2 = Short.valueOf((short) (j8 & SHORT_BITS));
                    } else if (cls == Character.TYPE) {
                        object2 = Character.valueOf((char) (j8 & SHORT_BITS));
                    } else {
                        if (cls != Byte.TYPE) {
                            throw new AssertionError("Unknown primitive type: " + cls);
                        }
                        object2 = Byte.valueOf((byte) (j8 & BYTE_BITS));
                    }
                }
                Object obj = object2;
                i2 = i6;
                objValueOf = obj;
                objArr[i5] = objValueOf;
                i++;
                i5++;
                i6 = i2;
            }
        } else {
            objArr = Pine.EMPTY_OBJECT_ARRAY;
        }
        return Pine.handleCall(hookRecord, object, objArr);
    }

    public static int intBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Integer) handleBridge(j, j2, j3, j4, j5, j6, j7)).intValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return 0;
        }
    }

    public static long longBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Long) handleBridge(j, j2, j3, j4, j5, j6, j7)).longValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return 0L;
        }
    }

    public static Object objectBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return handleBridge(j, j2, j3, j4, j5, j6, j7);
        } catch (Throwable th) {
            Pine.requestError(th);
            return null;
        }
    }

    public static short shortBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            return ((Short) handleBridge(j, j2, j3, j4, j5, j6, j7)).shortValue();
        } catch (Throwable th) {
            Pine.requestError(th);
            return (short) 0;
        }
    }

    public static void voidBridge(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        try {
            handleBridge(j, j2, j3, j4, j5, j6, j7);
        } catch (Throwable th) {
            Pine.requestError(th);
        }
    }
}
