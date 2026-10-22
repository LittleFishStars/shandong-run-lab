package com.alibaba.ariver.resource.parser.a;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected File f24451a;
    private e b;

    private c() {
        this.f24451a = null;
        this.b = new e();
    }

    public boolean a(c cVar) {
        return this.b.w.toString().equals(cVar.b.w.toString());
    }

    public boolean b(c cVar) {
        return cVar.b.w.toString().startsWith(this.b.w.toString());
    }

    public int c() {
        return this.b.y;
    }

    public int d() {
        return this.b.z;
    }

    public String e() {
        return this.b.G.toString();
    }

    public String f() {
        return this.b.H.toString();
    }

    public Date g() {
        return new Date(this.b.B * 1000);
    }

    public File h() {
        return this.f24451a;
    }

    public long i() {
        return this.b.A;
    }

    public boolean j() {
        File file = this.f24451a;
        if (file != null) {
            return file.isDirectory();
        }
        e eVar = this.b;
        if (eVar != null) {
            return eVar.D == 53 || eVar.w.toString().endsWith(WVNativeCallbackUtil.SEPERATER);
        }
        return false;
    }

    public e a() {
        return this.b;
    }

    public String b() {
        String string = this.b.w.toString();
        StringBuffer stringBuffer = this.b.K;
        if (stringBuffer == null || stringBuffer.toString().equals("")) {
            return string;
        }
        return this.b.K.toString() + WVNativeCallbackUtil.SEPERATER + string;
    }

    public void c(String str) {
        this.b.H = new StringBuffer(str);
    }

    public void d(String str) {
        this.b = e.a(str, this.f24451a.length(), this.f24451a.lastModified() / 1000, this.f24451a.isDirectory());
    }

    public void a(String str) {
        this.b.w = new StringBuffer(str);
    }

    public void c(byte[] bArr) {
        this.b.w = e.a(bArr, 0, 100);
        this.b.x = (int) a.a(bArr, 100, 8);
        this.b.y = (int) a.a(bArr, 108, 8);
        this.b.z = (int) a.a(bArr, 116, 8);
        this.b.A = a.a(bArr, 124, 12);
        this.b.B = a.a(bArr, 136, 12);
        this.b.C = (int) a.a(bArr, 148, 8);
        e eVar = this.b;
        eVar.D = bArr[156];
        eVar.E = e.a(bArr, 157, 100);
        this.b.F = e.a(bArr, 257, 8);
        this.b.G = e.a(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 32);
        this.b.H = e.a(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 32);
        this.b.I = (int) a.a(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION, 8);
        this.b.J = (int) a.a(bArr, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 8);
        this.b.K = e.a(bArr, 345, 155);
    }

    public c(byte[] bArr) {
        this();
        c(bArr);
    }

    public void a(int i) {
        this.b.y = i;
    }

    public void a(int i, int i2) {
        a(i);
        b(i2);
    }

    public c(e eVar) {
        this.f24451a = null;
        this.b = eVar;
    }

    public void b(int i) {
        this.b.z = i;
    }

    public void a(long j) {
        this.b.B = j / 1000;
    }

    public void b(String str) {
        this.b.G = new StringBuffer(str);
    }

    public void a(Date date) {
        this.b.B = date.getTime() / 1000;
    }

    public void b(long j) {
        this.b.A = j;
    }

    public long a(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j += (long) (b & 255);
        }
        return j;
    }

    public void b(byte[] bArr) {
        int iC = a.c(this.b.B, bArr, a.c(this.b.A, bArr, a.a(this.b.z, bArr, a.a(this.b.y, bArr, a.a(this.b.x, bArr, e.a(this.b.w, bArr, 0, 100), 8), 8), 8), 12), 12);
        int i = iC;
        int i2 = 0;
        while (i2 < 8) {
            bArr[i] = 32;
            i2++;
            i++;
        }
        e eVar = this.b;
        bArr[i] = eVar.D;
        for (int iA = e.a(this.b.K, bArr, a.a(this.b.J, bArr, a.a(this.b.I, bArr, e.a(this.b.H, bArr, e.a(this.b.G, bArr, e.a(this.b.F, bArr, e.a(eVar.E, bArr, i + 1, 100), 8), 32), 32), 8), 8), 155); iA < bArr.length; iA++) {
            bArr[iA] = 0;
        }
        a.b(a(bArr), bArr, iC, 8);
    }
}
