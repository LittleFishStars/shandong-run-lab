package com.zj.adlib;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class gv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StringBuilder f41990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Charset f16882a;
    public StringBuilder b;

    public gv2() {
        this.f16882a = StandardCharsets.ISO_8859_1;
        this.f41990a = new StringBuilder();
    }

    public void a(byte b) {
        this.f41990a.append((char) (b & 255));
    }

    public void b(char c) {
        this.f41990a.append((char) (c & 255));
    }

    public void c(int i) {
        d(String.valueOf(i));
    }

    public void d(String str) {
        this.f41990a.append(str);
    }

    public void e(StringBuilder sb) {
        g();
        this.b.append((CharSequence) sb);
    }

    public void f(int i) throws FormatException {
        g();
        CharacterSetECI characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(i);
        if (characterSetECIByValue == null) {
            throw FormatException.getFormatInstance();
        }
        this.f16882a = characterSetECIByValue.getCharset();
    }

    public final void g() {
        if (this.f16882a.equals(StandardCharsets.ISO_8859_1)) {
            if (this.f41990a.length() > 0) {
                StringBuilder sb = this.b;
                if (sb == null) {
                    this.b = this.f41990a;
                    this.f41990a = new StringBuilder();
                    return;
                } else {
                    sb.append((CharSequence) this.f41990a);
                    this.f41990a = new StringBuilder();
                    return;
                }
            }
            return;
        }
        if (this.f41990a.length() > 0) {
            byte[] bytes = this.f41990a.toString().getBytes(StandardCharsets.ISO_8859_1);
            this.f41990a = new StringBuilder();
            StringBuilder sb2 = this.b;
            if (sb2 == null) {
                this.b = new StringBuilder(new String(bytes, this.f16882a));
            } else {
                sb2.append(new String(bytes, this.f16882a));
            }
        }
    }

    public boolean h() {
        StringBuilder sb;
        return this.f41990a.length() == 0 && ((sb = this.b) == null || sb.length() == 0);
    }

    public int i() {
        return toString().length();
    }

    public String toString() {
        g();
        StringBuilder sb = this.b;
        return sb == null ? "" : sb.toString();
    }

    public gv2(int i) {
        this.f16882a = StandardCharsets.ISO_8859_1;
        this.f41990a = new StringBuilder(i);
    }
}
