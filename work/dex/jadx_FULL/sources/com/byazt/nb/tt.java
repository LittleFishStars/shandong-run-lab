package com.byazt.nb;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.ColorInt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28809a;
    public String c;
    public float da;

    @ColorInt
    public int i;
    public String m;
    public int n;
    public boolean sl;
    public float sp;
    public PointF t;
    public String tt;
    public PointF u;
    public c uj;
    public float ve;

    @ColorInt
    public int x;
    public n yp;
    public String z;

    public enum c {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public tt(String str, String str2, float f, c cVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2, n nVar, String str3, String str4) {
        c(str, str2, f, cVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2, nVar, str3, str4);
    }

    public void c(String str, String str2, float f, c cVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2, n nVar, String str3, String str4) {
        this.c = str;
        this.tt = str2;
        this.ve = f;
        this.uj = cVar;
        this.n = i;
        this.f28809a = f2;
        this.sp = f3;
        this.x = i2;
        this.i = i3;
        this.da = f4;
        this.sl = z;
        this.t = pointF;
        this.u = pointF2;
        this.yp = nVar;
        this.z = str3;
        this.m = str4;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.c.hashCode() * 31) + this.tt.hashCode()) * 31) + this.ve)) * 31) + this.uj.ordinal()) * 31) + this.n;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f28809a);
        int i = ((((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.x) * 31;
        n nVar = this.yp;
        return ((i + nVar.c) * 31) + nVar.tt;
    }

    public tt() {
        this.yp = new n();
    }
}
