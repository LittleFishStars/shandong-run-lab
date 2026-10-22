package com.baidu.mapauto.auth.org.spongycastle.util.io.pem;

import com.baidu.mapauto.auth.org.spongycastle.util.d;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c extends BufferedWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f26666a;

    public c(StringWriter stringWriter) {
        super(stringWriter);
        this.f26666a = new char[64];
        int i = d.f26659a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x010d  */
    public final void a(b bVar) throws IOException {
        int i;
        byte[] byteArray;
        int length;
        int i2;
        char[] cArr;
        int i3;
        write("-----BEGIN RSA PUBLIC KEY-----");
        newLine();
        if (!bVar.f26665a.isEmpty()) {
            Iterator it = bVar.f26665a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).getClass();
                write((String) null);
                write(": ");
                write((String) null);
                newLine();
            }
            newLine();
        }
        byte[] bArr = bVar.b;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.b bVar2 = com.baidu.mapauto.auth.org.spongycastle.util.encoders.a.f26660a;
        int length2 = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((length2 + 2) / 3) * 4);
        try {
            bVar2.getClass();
            int i4 = length2 % 3;
            int i5 = length2 - i4;
            int i6 = 0;
            while (true) {
                i = 0 + i5;
                if (i6 >= i) {
                    break;
                }
                int i7 = bArr[i6] & 255;
                int i8 = bArr[i6 + 1] & 255;
                int i9 = bArr[i6 + 2] & 255;
                byteArrayOutputStream.write(bVar2.f26661a[(i7 >>> 2) & 63]);
                byteArrayOutputStream.write(bVar2.f26661a[((i7 << 4) | (i8 >>> 4)) & 63]);
                byteArrayOutputStream.write(bVar2.f26661a[((i8 << 2) | (i9 >>> 6)) & 63]);
                byteArrayOutputStream.write(bVar2.f26661a[i9 & 63]);
                i6 += 3;
            }
            if (i4 != 1) {
                if (i4 == 2) {
                    int i10 = bArr[i] & 255;
                    int i11 = bArr[i + 1] & 255;
                    byteArrayOutputStream.write(bVar2.f26661a[(i10 >>> 2) & 63]);
                    byteArrayOutputStream.write(bVar2.f26661a[((i10 << 4) | (i11 >>> 4)) & 63]);
                    byteArrayOutputStream.write(bVar2.f26661a[(i11 << 2) & 63]);
                }
                int i12 = i5 / 3;
                byteArray = byteArrayOutputStream.toByteArray();
                length = 0;
                while (length < byteArray.length) {
                    i2 = 0;
                    while (true) {
                        cArr = this.f26666a;
                        if (i2 == cArr.length || (i3 = length + i2) >= byteArray.length) {
                            break;
                        }
                        cArr[i2] = (char) byteArray[i3];
                        i2++;
                    }
                    write(cArr, 0, i2);
                    newLine();
                    length += this.f26666a.length;
                }
                write("-----END RSA PUBLIC KEY-----");
                newLine();
            }
            int i13 = bArr[i] & 255;
            byteArrayOutputStream.write(bVar2.f26661a[(i13 >>> 2) & 63]);
            byteArrayOutputStream.write(bVar2.f26661a[(i13 << 4) & 63]);
            byteArrayOutputStream.write(61);
            byteArrayOutputStream.write(61);
            int i14 = i5 / 3;
            byteArray = byteArrayOutputStream.toByteArray();
            length = 0;
            while (length < byteArray.length) {
                i2 = 0;
                while (true) {
                    cArr = this.f26666a;
                    if (i2 == cArr.length) {
                        break;
                    }
                    cArr[i2] = (char) byteArray[i3];
                    i2++;
                }
                write(cArr, 0, i2);
                newLine();
                length += this.f26666a.length;
            }
            write("-----END RSA PUBLIC KEY-----");
            newLine();
        } catch (Exception e) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("exception encoding base64 string: ");
            sbA.append(e.getMessage());
            throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(sbA.toString(), e);
        }
    }
}
