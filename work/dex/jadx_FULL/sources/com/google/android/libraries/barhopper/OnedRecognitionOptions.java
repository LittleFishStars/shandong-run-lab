package com.google.android.libraries.barhopper;

import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.UsedByNative;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@UsedByNative("jni_common.cc")
public class OnedRecognitionOptions {

    @UsedByNative("jni_common.cc")
    private int ean13UpcaMinConsistentLines = 1;

    @UsedByNative("jni_common.cc")
    private int ean8MinConsistentLines = 3;

    @UsedByNative("jni_common.cc")
    private int upceMinConsistentLines = 3;

    @UsedByNative("jni_common.cc")
    private int code128MinConsistentLines = 1;

    @UsedByNative("jni_common.cc")
    private int code39MinConsistentLines = 2;

    @UsedByNative("jni_common.cc")
    private int code93MinConsistentLines = 2;

    @UsedByNative("jni_common.cc")
    private int itfMinConsistentLines = 3;

    @UsedByNative("jni_common.cc")
    private int codabarMinConsistentLines = 2;

    @UsedByNative("jni_common.cc")
    private int code128MinCodeLength = 2;

    @UsedByNative("jni_common.cc")
    private int code39MinCodeLength = 2;

    @UsedByNative("jni_common.cc")
    private int code93MinCodeLength = 2;

    @UsedByNative("jni_common.cc")
    private int itfMinCodeLength = 6;

    @UsedByNative("jni_common.cc")
    private int codabarMinCodeLength = 6;

    @UsedByNative("jni_common.cc")
    private boolean code39UseCheckDigit = false;

    @UsedByNative("jni_common.cc")
    private boolean code39UseExtendedMode = false;

    @NonNull
    public OnedRecognitionOptions A(int i) {
        this.ean8MinConsistentLines = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions B(int i) {
        this.itfMinCodeLength = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions C(int i) {
        this.itfMinConsistentLines = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions D(int i) {
        this.upceMinConsistentLines = i;
        return this;
    }

    public int a() {
        return this.codabarMinCodeLength;
    }

    public int b() {
        return this.codabarMinConsistentLines;
    }

    public int c() {
        return this.code128MinCodeLength;
    }

    public int d() {
        return this.code128MinConsistentLines;
    }

    public int e() {
        return this.code39MinCodeLength;
    }

    public int f() {
        return this.code39MinConsistentLines;
    }

    public boolean g() {
        return this.code39UseCheckDigit;
    }

    public boolean h() {
        return this.code39UseExtendedMode;
    }

    public int i() {
        return this.code93MinCodeLength;
    }

    public int j() {
        return this.code93MinConsistentLines;
    }

    public int k() {
        return this.ean13UpcaMinConsistentLines;
    }

    public int l() {
        return this.ean8MinConsistentLines;
    }

    public int m() {
        return this.itfMinCodeLength;
    }

    public int n() {
        return this.itfMinConsistentLines;
    }

    public int o() {
        return this.upceMinConsistentLines;
    }

    @NonNull
    public OnedRecognitionOptions p(int i) {
        this.codabarMinCodeLength = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions q(int i) {
        this.codabarMinConsistentLines = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions r(int i) {
        this.code128MinCodeLength = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions s(int i) {
        this.code128MinConsistentLines = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions t(int i) {
        this.code39MinCodeLength = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions u(int i) {
        this.code39MinConsistentLines = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions v(boolean z) {
        this.code39UseCheckDigit = z;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions w(boolean z) {
        this.code39UseExtendedMode = z;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions x(int i) {
        this.code93MinCodeLength = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions y(int i) {
        this.code93MinConsistentLines = i;
        return this;
    }

    @NonNull
    public OnedRecognitionOptions z(int i) {
        this.ean13UpcaMinConsistentLines = i;
        return this;
    }
}
