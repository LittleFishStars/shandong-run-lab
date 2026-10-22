package com.kc.aw.lib.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.kc.aw._b5;
import com.kc.aw._c0;
import com.kc.aw._c1;
import com.kc.aw._dk;
import com.kc.aw._fu;
import com.kc.aw._g2;
import com.kc.aw._jf;
import com.kc.aw._l2;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
final class Decoder {
    private static final String DOODLE_LOG_TAG = "PtgImageDecoder";
    private static final String TAG = "Decoder";

    private static Bitmap centerCrop(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = width * i2;
        int i4 = i * height;
        int i5 = i3 - i4;
        if (i5 > 0) {
            float f = width;
            float f2 = (f - (i4 / i2)) * 0.5f;
            if (f2 <= 0.0f) {
                return bitmap;
            }
            float f3 = 2.0f * f2;
            return f3 < f ? Bitmap.createBitmap(bitmap, Math.round(f2), 0, Math.round(f - f3), height) : bitmap;
        }
        if (i5 >= 0) {
            return bitmap;
        }
        float f4 = height;
        float f5 = (f4 - (i3 / i)) * 0.5f;
        if (f5 <= 0.0f) {
            return bitmap;
        }
        float f6 = 2.0f * f5;
        return f6 < f4 ? Bitmap.createBitmap(bitmap, 0, Math.round(f5), width, Math.round(f4 - f6)) : bitmap;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    public static Bitmap decode(_c1 _c1Var, _l2 _l2Var) {
        int i_c = _c1Var._c();
        boolean z = true;
        if (i_c != 1) {
            if (i_c != 2 && i_c != 3 && i_c != 4 && i_c != 5) {
                z = false;
            }
        } else if (!_c1Var._a.startsWith("content://media/external/video/")) {
            int length = _c1Var._a.length();
            if (length > 3) {
                String lowerCase = _c1Var._a.substring(length - 3, length).toLowerCase();
                if (!lowerCase.equals("mp4") && !lowerCase.equals("mov")) {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z ? decodeVideo(_c1Var, _l2Var) : decodeImage(_c1Var, _l2Var);
    }

    public static Bitmap decodeFile(String str, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0141  */
    /* JADX WARN: Failed to find 'out' block for switch in B:94:0x0159. Please report as an issue. */
    private static Bitmap decodeImage(_c1 _c1Var, _l2 _l2Var) {
        int i_a;
        boolean z;
        Bitmap bitmap_b;
        int iRound;
        int iMin;
        int iRound2;
        int iMin2;
        int i_c;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inMutable = true;
        int i = _l2Var._g;
        if (i != 0) {
            boolean z2 = i == 2 || (i == 3 && ((i_c = _c1Var._c()) == 7 || i_c == 9 || i_c == 11 || i_c == 13));
            options.inPreferredConfig = z2 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
            if (z2) {
                _l2Var._g = 2;
                options.inDither = true;
            }
        }
        if (_c1Var._d()) {
            i_a = _c1Var._f != null ? _dk._a(new ByteArrayInputStream(_c1Var._f)) : _c1Var._b._a();
            z = i_a >= 5;
        } else {
            i_a = 0;
            z = false;
        }
        _b5 _b5Var = _l2Var._f;
        if (_b5Var == _b5.NOT_SET) {
            _b5Var = _b5.NO_CLIP;
        }
        _b5 _b5Var2 = _b5.NO_CLIP;
        if (_b5Var != _b5Var2) {
            options.inJustDecodeBounds = true;
            _c1Var._b(options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                _b5Var = _b5Var2;
            }
            options.inJustDecodeBounds = false;
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int i4 = z ? _l2Var._e : _l2Var._d;
        int i5 = z ? _l2Var._d : _l2Var._e;
        int iOrdinal = _b5Var.ordinal();
        if (iOrdinal == 1) {
            bitmap_b = _c1Var._b(options);
        } else if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                int i6 = i2 * i5;
                int i7 = i4 * i3;
                if (iOrdinal != 5) {
                    if (i6 > i7) {
                        if (i2 > i4) {
                            options.inScaled = true;
                            options.inTargetDensity = i4;
                            options.inDensity = i2;
                        }
                    } else if (i3 > i5) {
                        options.inScaled = true;
                        options.inTargetDensity = i5;
                        options.inDensity = i3;
                    }
                    bitmap_b = _c1Var._b(options);
                } else {
                    if (i6 > i7) {
                        if (i3 > i5) {
                            options.inScaled = true;
                            options.inTargetDensity = i5;
                            options.inDensity = i3;
                        }
                    } else if (i2 > i4) {
                        options.inScaled = true;
                        options.inTargetDensity = i4;
                        options.inDensity = i2;
                    }
                    bitmap_b = _c1Var._b(options);
                    if (bitmap_b != null) {
                        bitmap_b = centerCrop(bitmap_b, i4, i5);
                    }
                }
            } else if (i2 > i4 || i3 > i5) {
                if (i2 > i4) {
                    iRound = Math.round((i2 - i4) * 0.5f);
                    iMin = Math.min(i4 + iRound, i2);
                } else {
                    iRound = 0;
                    iMin = i2;
                }
                if (i3 > i5) {
                    iRound2 = Math.round((i3 - i5) * 0.5f);
                    iMin2 = Math.min(i5 + iRound2, i3);
                } else {
                    iRound2 = 0;
                    iMin2 = i3;
                }
                Rect rect = new Rect(iRound, iRound2, iMin, iMin2);
                byte[] bArr = _c1Var._f;
                bitmap_b = bArr != null ? BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, options) : _c1Var._b._a(rect, options);
            } else {
                bitmap_b = _c1Var._b(options);
            }
        } else if (i2 > i4 || i3 > i5) {
            Rect rect2 = new Rect(0, 0, Math.min(i2, i4), Math.min(i3, i5));
            byte[] bArr2 = _c1Var._f;
            bitmap_b = bArr2 != null ? BitmapRegionDecoder.newInstance(bArr2, 0, bArr2.length, false).decodeRegion(rect2, options) : _c1Var._b._a(rect2, options);
        } else {
            bitmap_b = _c1Var._b(options);
        }
        Bitmap bitmapCreateBitmap = bitmap_b;
        if (bitmapCreateBitmap == null) {
            StringBuilder sb_a = _jf._a("Not support to decode the file: ");
            sb_a.append(_g2._a(_c1Var._c()));
            throw new IllegalArgumentException(sb_a.toString());
        }
        if (i_a > 1) {
            Matrix matrix = new Matrix();
            switch (i_a) {
                case 2:
                    matrix.setScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 3:
                    matrix.setRotate(180.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 4:
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 5:
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 6:
                    matrix.setRotate(90.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 7:
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
                case 8:
                    matrix.setRotate(-90.0f);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix, false);
                    break;
            }
        }
        if (_fu._a()) {
            logResult(bitmapCreateBitmap, _l2Var, i2, i3);
        }
        return bitmapCreateBitmap;
    }

    private static Bitmap decodeVideo(_c1 _c1Var, _l2 _l2Var) throws IOException {
        int i;
        int i2;
        Throwable th;
        int i3;
        int i4;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (_c1Var._f != null) {
                mediaMetadataRetriever.setDataSource(new _c0(_c1Var));
            } else {
                _c1Var._b._a(mediaMetadataRetriever);
            }
            int i5 = _l2Var._d;
            int i6 = _l2Var._e;
            _b5 _b5Var = _l2Var._f;
            Bitmap frameAtTime = null;
            if (Build.VERSION.SDK_INT < 27 || i5 <= 0 || i6 <= 0 || _b5Var == _b5.NO_CLIP || _b5Var == _b5.MATRIX || _b5Var == _b5.CENTER) {
                i = 0;
                i2 = 0;
            } else {
                try {
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                    if (TextUtils.isEmpty(strExtractMetadata) || TextUtils.isEmpty(strExtractMetadata2) || TextUtils.isEmpty(strExtractMetadata3)) {
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                    } else {
                        i = Integer.parseInt(strExtractMetadata);
                        try {
                            i2 = Integer.parseInt(strExtractMetadata2);
                            try {
                                i3 = Integer.parseInt(strExtractMetadata3);
                            } catch (Throwable th2) {
                                th = th2;
                                _fu._a(TAG, th);
                                i3 = 0;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i2 = 0;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i = 0;
                    i2 = 0;
                }
                if (i > 0 && i2 > 0) {
                    if (i3 == 90 || i3 == 270) {
                        i4 = i;
                        i = i2;
                    } else {
                        i4 = i2;
                    }
                    float fMin = Math.min(getScale(i, i4, i5, i6, _b5Var, false), 1.0f);
                    try {
                        frameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(-1L, 2, Math.round(i * fMin), Math.round(fMin * i4));
                    } catch (Throwable th5) {
                        _fu._a(TAG, th5);
                    }
                    i2 = i4;
                }
            }
            if (frameAtTime == null) {
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L, 2);
            }
            Bitmap bitmapHandleScaleAndCrop = handleScaleAndCrop(frameAtTime, _l2Var);
            if (_fu._a()) {
                logResult(bitmapHandleScaleAndCrop, _l2Var, i, i2);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    mediaMetadataRetriever.getClass().getMethod("close", new Class[0]).invoke(mediaMetadataRetriever, new Object[0]);
                } catch (Exception e) {
                    _fu._a(TAG, e);
                }
            } else {
                mediaMetadataRetriever.release();
            }
            if (bitmapHandleScaleAndCrop != null) {
                return bitmapHandleScaleAndCrop;
            }
            throw new IllegalArgumentException("Not support to decode the file");
        } catch (Throwable th6) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    mediaMetadataRetriever.getClass().getMethod("close", new Class[0]).invoke(mediaMetadataRetriever, new Object[0]);
                } catch (Exception e2) {
                    _fu._a(TAG, e2);
                }
            } else {
                mediaMetadataRetriever.release();
            }
            throw th6;
        }
    }

    private static byte[] decompressZlib(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 4);
        byte[] bArr2 = new byte[8192];
        while (!inflater.finished()) {
            try {
                try {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                } catch (DataFormatException e) {
                    printELog("Decompression failed:" + e.getMessage());
                    inflater.end();
                    return null;
                }
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        printDLog("Decompressed: " + bArr.length + " bytes → " + byteArray.length + " bytes");
        inflater.end();
        return byteArray;
    }

    private static byte[] extractZtxtChunk(byte[] bArr, String str) {
        int i;
        printELog("extractZtxtChunk:" + str);
        int i2 = 8;
        while (i2 + 12 <= bArr.length) {
            int i3 = ByteBuffer.wrap(bArr, i2, 4).order(ByteOrder.BIG_ENDIAN).getInt();
            int i4 = i2 + 4;
            String str2 = new String(bArr, i4, 4);
            int i5 = i4 + 4;
            int i6 = i5 + i3;
            if (i6 + 4 > bArr.length) {
                printELog("Truncated PNG chunk");
                break;
            }
            if ("zTXt".equals(str2)) {
                printELog("zTXt chunk ");
                int i7 = i5;
                while (true) {
                    if (i7 >= i6) {
                        i7 = -1;
                        break;
                    }
                    if (bArr[i7] == 0) {
                        break;
                    }
                    i7++;
                }
                if (i7 == -1 || (i = i7 + 2) > i6) {
                    printWLog("Invalid zTXt chunk format (no null terminator or too short)");
                    i2 = i5 + i3 + 4;
                } else {
                    String str3 = new String(bArr, i5, i7 - i5);
                    if (str.equals(str3)) {
                        int i8 = bArr[i7 + 1] & 255;
                        if (i8 == 0) {
                            int i9 = i6 - i;
                            byte[] bArr2 = new byte[i9];
                            System.arraycopy(bArr, i, bArr2, 0, i9);
                            return bArr2;
                        }
                        printELog("Unsupported compression method: " + i8);
                        return null;
                    }
                    printELog("unknown keyword: " + str3);
                }
            }
            i2 = i5 + i3 + 4;
            if ("IEND".equals(str2)) {
                break;
            }
        }
        return null;
    }

    public static int findResourceId(Context context, String str) {
        Resources resources;
        if (context == null || TextUtils.isEmpty(str) || (resources = context.getResources()) == null) {
            return -1;
        }
        return resources.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static String getPngResourceName(Context context, int i) {
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception e) {
            printELog("Failed to get resource name for drawable ID: " + i + " error:" + e.getMessage());
            return null;
        }
    }

    public static float getScale(int i, int i2, int i3, int i4, _b5 _b5Var, boolean z) {
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0) {
            return 1.0f;
        }
        if (_b5Var == _b5.CENTER_CROP) {
            if (i * i4 > i3 * i2) {
                if (z) {
                    if (i2 == i4) {
                        return 1.0f;
                    }
                } else if (i2 <= i4) {
                    return 1.0f;
                }
                return i4 / i2;
            }
            if (z) {
                if (i == i3) {
                    return 1.0f;
                }
            } else if (i <= i3) {
                return 1.0f;
            }
            return i3 / i;
        }
        boolean z2 = _b5Var == _b5.CENTER_INSIDE;
        if (i * i4 > i3 * i2) {
            if (z2 || !z) {
                if (i <= i3) {
                    return 1.0f;
                }
            } else if (i == i3) {
                return 1.0f;
            }
            return i3 / i;
        }
        if (z2 || !z) {
            if (i2 <= i4) {
                return 1.0f;
            }
        } else if (i2 == i4) {
            return 1.0f;
        }
        return i4 / i2;
    }

    public static Bitmap handleScaleAndCrop(Bitmap bitmap, _l2 _l2Var) {
        Bitmap bitmapCreateBitmap;
        if (bitmap == null) {
            return null;
        }
        int i = _l2Var._d;
        int i2 = _l2Var._e;
        _b5 _b5Var = _l2Var._f;
        if (i <= 0 || i2 <= 0 || _b5Var == _b5.NO_CLIP || _b5Var == _b5.MATRIX || _b5Var == _b5.CENTER) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scale = getScale(width, height, i, i2, _b5Var, false);
        if (scale != 1.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(scale, scale);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } else {
            bitmapCreateBitmap = bitmap;
        }
        return (bitmapCreateBitmap == null || _b5Var != _b5.CENTER_CROP) ? bitmapCreateBitmap : centerCrop(bitmapCreateBitmap, i, i2);
    }

    private static boolean isPngSignature(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    public static String loadPngData(Context context, String str) {
        return loadPngData(context, str, "ColorTable");
    }

    public static String loadPngData(Context context, String str, String str2) throws Throwable {
        Throwable th;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            try {
                byte[] allBytes = readAllBytes(inputStreamOpen);
                if (allBytes.length >= 8 && isPngSignature(allBytes)) {
                    byte[] bArrExtractZtxtChunk = extractZtxtChunk(allBytes, str2);
                    if (bArrExtractZtxtChunk == null) {
                        printELog("zTXt chunk '" + str2 + "' not found in PNG");
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused) {
                            }
                        }
                        return null;
                    }
                    byte[] bArrDecompressZlib = decompressZlib(bArrExtractZtxtChunk);
                    if (bArrDecompressZlib == null) {
                        printELog("Failed to decompress zTXt chunk data");
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return null;
                    }
                    String strEncodeToString = Base64.encodeToString(bArrDecompressZlib, 2);
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return strEncodeToString;
                }
                printELog("Invalid PNG signature");
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Exception unused5) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException unused6) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpen;
                if (inputStream == null) {
                    throw th;
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException unused7) {
                    throw th;
                }
            }
        } catch (Exception unused8) {
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void logResult(Bitmap bitmap, _l2 _l2Var, int i, int i2) {
        if (bitmap != null) {
            Log.i(TAG, "source:" + i + "x" + i2 + " target:" + _l2Var._d + "x" + _l2Var._e + " result:" + bitmap.getWidth() + "x" + bitmap.getHeight());
        }
    }

    private static void printDLog(String str) {
    }

    private static void printELog(String str) {
    }

    private static void printWLog(String str) {
    }

    public static void ptgOnDecodeFailure(int i) {
        printELog("ptgOnDecodeFailure failed: code=" + i);
    }

    private static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr, 0, 8192);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
