package cj.mobile.wm;

import android.util.Log;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class x8 {
    public static final x8 dexb = new x8();
    public final Queue<byte[]> dexa = e9.dexa(0);

    public static x8 dexb() {
        return dexb;
    }

    public boolean dexa(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.dexa) {
            if (this.dexa.size() < 32) {
                this.dexa.offer(bArr);
                z = true;
            }
        }
        return z;
    }

    public byte[] dexa() {
        byte[] bArrPoll;
        synchronized (this.dexa) {
            bArrPoll = this.dexa.poll();
        }
        if (bArrPoll == null) {
            bArrPoll = new byte[65536];
            if (Log.isLoggable(com.ipd.dsp.internal.j.g.f38350a, 3)) {
                f1.dexa(com.ipd.dsp.internal.j.g.f38350a, "Created temp bytes");
            }
        }
        return bArrPoll;
    }
}
