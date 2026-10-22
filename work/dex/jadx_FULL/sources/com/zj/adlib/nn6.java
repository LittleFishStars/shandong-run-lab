package com.zj.adlib;

import android.media.AudioRecord;
import com.google.common.base.a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class nn6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43566a;
    public int b;
    public int c;
    public int d;
    public int e;

    public nn6() {
        this.b = 8000;
        this.c = 12;
        this.d = 2;
        this.e = 2;
        this.f43566a = AudioRecord.getMinBufferSize(8000, 12, 2);
    }

    public void a(String str, String str2) {
        int i = this.b;
        long j = i;
        int i2 = this.d;
        long j2 = ((i * 16) * i2) / 8;
        byte[] bArr = new byte[this.f43566a];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            long size = fileInputStream.getChannel().size();
            b(fileOutputStream, size, size + 36, j, i2, j2);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void b(FileOutputStream fileOutputStream, long j, long j2, long j3, int i, long j4) throws IOException {
        fileOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (j2 & 255), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, a.r, 0, 0, 0, 1, 0, (byte) i, 0, (byte) (j3 & 255), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), (byte) (j4 & 255), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255), 4, 0, a.r, 0, 100, 97, 116, 97, (byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)}, 0, 44);
    }

    public nn6(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f43566a = AudioRecord.getMinBufferSize(i, i2, i4);
    }
}
