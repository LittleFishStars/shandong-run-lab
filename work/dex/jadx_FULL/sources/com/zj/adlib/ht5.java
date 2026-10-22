package com.zj.adlib;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ht5 implements Writer {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42198a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f42198a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42198a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42198a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42198a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42198a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42198a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42198a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f42198a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f42198a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f42198a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f42198a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f42198a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f42198a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.Writer
    public tv0 a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        Writer au2Var;
        switch (a.f42198a[barcodeFormat.ordinal()]) {
            case 1:
                au2Var = new au2();
                break;
            case 2:
                au2Var = new jf9();
                break;
            case 3:
                au2Var = new yt2();
                break;
            case 4:
                au2Var = new ef9();
                break;
            case 5:
                au2Var = new e57();
                break;
            case 6:
                au2Var = new zm1();
                break;
            case 7:
                au2Var = new bn1();
                break;
            case 8:
                au2Var = new Code128Writer();
                break;
            case 9:
                au2Var = new f54();
                break;
            case 10:
                au2Var = new th6();
                break;
            case 11:
                au2Var = new wm1();
                break;
            case 12:
                au2Var = new y62();
                break;
            case 13:
                au2Var = new yi0();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return au2Var.a(str, barcodeFormat, i, i2, map);
    }

    @Override // com.google.zxing.Writer
    public tv0 b(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return a(str, barcodeFormat, i, i2, null);
    }
}
