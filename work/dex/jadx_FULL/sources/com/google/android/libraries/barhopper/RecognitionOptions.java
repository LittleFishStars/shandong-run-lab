package com.google.android.libraries.barhopper;

import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.UsedByNative;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@UsedByNative("jni_common.cc")
public class RecognitionOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31508a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    public static final int h = 64;
    public static final int i = 128;
    public static final int j = 256;
    public static final int k = 512;
    public static final int l = 1024;
    public static final int m = 2048;
    public static final int n = 4096;
    public static final int o = 32768;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 4;
    public static final int s = 8;
    public static final int t = 16;
    public static final int u = 32;

    @UsedByNative("jni_common.cc")
    private int barcodeFormats = 0;

    @UsedByNative("jni_common.cc")
    private boolean outputUnrecognizedBarcodes = false;

    @UsedByNative("jni_common.cc")
    private boolean useQrMobilenetV3 = false;

    @UsedByNative("jni_common.cc")
    private boolean enableQrAlignmentGrid = false;

    @UsedByNative("jni_common.cc")
    private boolean enableUseKeypointAsFinderPattern = false;

    @UsedByNative("jni_common.cc")
    private int binarizerOptions = 3;

    @UsedByNative("jni_common.cc")
    private OnedRecognitionOptions onedRecognitionOptions = new OnedRecognitionOptions();

    public int a() {
        return this.barcodeFormats;
    }

    public int b() {
        return this.binarizerOptions;
    }

    public boolean c() {
        return this.enableQrAlignmentGrid;
    }

    public boolean d() {
        return this.enableUseKeypointAsFinderPattern;
    }

    @NonNull
    public OnedRecognitionOptions e() {
        return this.onedRecognitionOptions;
    }

    public boolean f() {
        return this.outputUnrecognizedBarcodes;
    }

    public boolean g() {
        return this.useQrMobilenetV3;
    }

    public void h(int i2) {
        this.barcodeFormats = i2;
    }

    public void i(int i2) {
        this.binarizerOptions = i2;
    }

    public void j(boolean z) {
        this.enableQrAlignmentGrid = z;
    }

    public void k(boolean z) {
        this.enableUseKeypointAsFinderPattern = z;
    }

    public void l(@NonNull OnedRecognitionOptions onedRecognitionOptions) {
        this.onedRecognitionOptions = onedRecognitionOptions;
    }

    public void m(boolean z) {
        this.outputUnrecognizedBarcodes = z;
    }

    public void n(boolean z) {
        this.useQrMobilenetV3 = z;
    }
}
