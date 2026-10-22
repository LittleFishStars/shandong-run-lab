package com.alibaba.ariver.resource.parser.a;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24453a = 100;
    public static final int b = 8;
    public static final int c = 8;
    public static final int d = 8;
    public static final int e = 12;
    public static final int f = 12;
    public static final int g = 8;
    public static final byte h = 0;
    public static final byte i = 48;
    public static final byte j = 49;
    public static final byte k = 50;
    public static final byte l = 51;
    public static final byte m = 52;
    public static final byte n = 53;
    public static final byte o = 54;
    public static final byte p = 55;
    public static final String q = "ustar";
    public static final int r = 8;
    public static final int s = 32;
    public static final int t = 32;
    public static final int u = 8;
    public static final int v = 155;
    public long A;
    public long B;
    public int C;
    public byte D;
    public StringBuffer G;
    public StringBuffer H;
    public int I;
    public int J;
    public StringBuffer K;
    public int x;
    public int y;
    public int z;
    public StringBuffer F = new StringBuffer(q);
    public StringBuffer w = new StringBuffer();
    public StringBuffer E = new StringBuffer();

    public e() {
        String property = System.getProperty("user.name", "");
        property = property.length() > 31 ? property.substring(0, 31) : property;
        this.y = 0;
        this.z = 0;
        this.G = new StringBuffer(property);
        this.H = new StringBuffer("");
        this.K = new StringBuffer();
    }

    public static StringBuffer a(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3);
        int i4 = i3 + i2;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 == 0) {
                break;
            }
            stringBuffer.append((char) b2);
            i2++;
        }
        return stringBuffer;
    }

    public static int a(StringBuffer stringBuffer, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3 && i4 < stringBuffer.length()) {
            bArr[i2 + i4] = (byte) stringBuffer.charAt(i4);
            i4++;
        }
        while (i4 < i3) {
            bArr[i2 + i4] = 0;
            i4++;
        }
        return i2 + i3;
    }

    public static e a(String str, long j2, long j3, boolean z) {
        String strA = a(str.replace(File.separatorChar, '/'), '/');
        e eVar = new e();
        eVar.E = new StringBuffer("");
        if (strA.length() > 100) {
            eVar.K = new StringBuffer(strA.substring(0, strA.lastIndexOf(47)));
            eVar.w = new StringBuffer(strA.substring(strA.lastIndexOf(47) + 1));
        } else {
            eVar.w = new StringBuffer(strA);
        }
        if (z) {
            eVar.x = 40755;
            eVar.D = n;
            StringBuffer stringBuffer = eVar.w;
            if (stringBuffer.charAt(stringBuffer.length() - 1) != '/') {
                eVar.w.append(WVNativeCallbackUtil.SEPERATER);
            }
            eVar.A = 0L;
        } else {
            eVar.x = 100644;
            eVar.D = i;
            eVar.A = j2;
        }
        eVar.B = j3;
        eVar.C = 0;
        eVar.I = 0;
        eVar.J = 0;
        return eVar;
    }

    public static String a(String str, char c2) {
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i2 = 0; i2 < stringBuffer.length() && stringBuffer.charAt(i2) == c2; i2++) {
            stringBuffer.deleteCharAt(i2);
        }
        for (int length = stringBuffer.length() - 1; length >= 0 && stringBuffer.charAt(length) == c2; length--) {
            stringBuffer.deleteCharAt(length);
        }
        return stringBuffer.toString();
    }
}
