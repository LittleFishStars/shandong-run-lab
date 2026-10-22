package com.byazt.bl;

import androidx.camera.video.AudioStats;
import com.byazt.yj.zb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 177, 54})
public class ve implements zb {
    public int c;
    public int tt;
    public com.byazt.ep.ve<String, byte[]> ve;

    public ve(int i, int i2) {
        this.tt = i;
        this.c = i2;
        this.ve = new com.byazt.ep.ve<String, byte[]>(i) { // from class: com.byazt.bl.ve.1
            @Override // com.byazt.ep.ve
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int tt(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.byazt.yj.c
    public boolean tt(String str) {
        return this.ve.c(str) != null;
    }

    @Override // com.byazt.yj.c
    public boolean c(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.ve.c(str, bArr);
        return true;
    }

    @Override // com.byazt.yj.c
    public byte[] c(String str) {
        return this.ve.c(str);
    }

    @Override // com.byazt.yj.c
    public void c() {
        c(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.byazt.yj.c
    public void c(double d) {
        this.ve.c((int) (((double) this.tt) * d));
    }
}
