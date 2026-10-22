package cj.mobile.wm;

import android.os.ParcelFileDescriptor;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r4 implements q2<q4> {
    public final q2<InputStream> dexa;
    public final q2<ParcelFileDescriptor> dexb;
    public String dexc;

    public r4(q2<InputStream> q2Var, q2<ParcelFileDescriptor> q2Var2) {
        this.dexa = q2Var;
        this.dexb = q2Var2;
    }

    @Override // cj.mobile.wm.q2
    public boolean dexa(q4 q4Var, OutputStream outputStream) {
        q2 q2Var;
        Closeable closeableDexa;
        if (q4Var.dexb() != null) {
            q2Var = this.dexa;
            closeableDexa = q4Var.dexb();
        } else {
            q2Var = this.dexb;
            closeableDexa = q4Var.dexa();
        }
        return q2Var.dexa(closeableDexa, outputStream);
    }

    @Override // cj.mobile.wm.q2
    public String getId() {
        if (this.dexc == null) {
            this.dexc = this.dexa.getId() + this.dexb.getId();
        }
        return this.dexc;
    }
}
