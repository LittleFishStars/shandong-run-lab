package cj.mobile.wm;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y4 implements q2<InputStream> {
    @Override // cj.mobile.wm.q2
    public boolean dexa(InputStream inputStream, OutputStream outputStream) {
        byte[] bArrDexa = x8.dexb().dexa();
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArrDexa);
                    if (i == -1) {
                        x8.dexb().dexa(bArrDexa);
                        return true;
                    }
                    outputStream.write(bArrDexa, 0, i);
                } catch (IOException e) {
                    if (Log.isLoggable(com.ipd.dsp.internal.n.v.b, 3)) {
                        f1.dexa(com.ipd.dsp.internal.n.v.b, "Failed to encode data onto the OutputStream", e);
                    }
                    x8.dexb().dexa(bArrDexa);
                    return false;
                }
            } catch (Throwable th) {
                x8.dexb().dexa(bArrDexa);
                throw th;
            }
            x8.dexb().dexa(bArrDexa);
            throw th;
        }
    }

    @Override // cj.mobile.wm.q2
    public String getId() {
        return "";
    }
}
