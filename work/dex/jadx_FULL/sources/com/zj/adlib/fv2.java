package com.zj.adlib;

import com.google.zxing.common.CharacterSetECI;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class fv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<CharsetEncoder> f41763a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final /* synthetic */ boolean f16628a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f16629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharsetEncoder[] f16630a;

    static {
        String[] strArr = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        for (int i = 0; i < 20; i++) {
            String str = strArr[i];
            if (CharacterSetECI.getCharacterSetECIByName(str) != null) {
                try {
                    f41763a.add(Charset.forName(str).newEncoder());
                } catch (UnsupportedCharsetException unused) {
                }
            }
        }
    }

    public fv2(String str, Charset charset, int i) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(StandardCharsets.ISO_8859_1.newEncoder());
        int i2 = 0;
        boolean z2 = charset != null && charset.name().startsWith("UTF");
        for (int i3 = 0; i3 < str.length(); i3++) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                CharsetEncoder charsetEncoder = (CharsetEncoder) it.next();
                char cCharAt = str.charAt(i3);
                if (cCharAt == i || charsetEncoder.canEncode(cCharAt)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                for (CharsetEncoder charsetEncoder2 : f41763a) {
                    if (charsetEncoder2.canEncode(str.charAt(i3))) {
                        arrayList.add(charsetEncoder2);
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                z2 = true;
            }
        }
        if (arrayList.size() != 1 || z2) {
            this.f16630a = new CharsetEncoder[arrayList.size() + 2];
            Iterator it2 = arrayList.iterator();
            int i4 = 0;
            while (it2.hasNext()) {
                this.f16630a[i4] = (CharsetEncoder) it2.next();
                i4++;
            }
            this.f16630a[i4] = StandardCharsets.UTF_8.newEncoder();
            this.f16630a[i4 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        } else {
            this.f16630a = new CharsetEncoder[]{(CharsetEncoder) arrayList.get(0)};
        }
        if (charset != null) {
            while (true) {
                CharsetEncoder[] charsetEncoderArr = this.f16630a;
                if (i2 >= charsetEncoderArr.length) {
                    break;
                } else if (charsetEncoderArr[i2] == null || !charset.name().equals(this.f16630a[i2].charset().name())) {
                    i2++;
                }
            }
            i2 = -1;
        } else {
            i2 = -1;
        }
        this.f16629a = i2;
    }

    public boolean a(char c, int i) {
        return this.f16630a[i].canEncode("" + c);
    }

    public byte[] b(char c, int i) {
        return ("" + c).getBytes(this.f16630a[i].charset());
    }

    public byte[] c(String str, int i) {
        return str.getBytes(this.f16630a[i].charset());
    }

    public Charset d(int i) {
        return this.f16630a[i].charset();
    }

    public String e(int i) {
        return this.f16630a[i].charset().name();
    }

    public int f(int i) {
        return CharacterSetECI.getCharacterSetECI(this.f16630a[i].charset()).getValue();
    }

    public int g() {
        return this.f16629a;
    }

    public int h() {
        return this.f16630a.length;
    }
}
