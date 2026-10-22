package cj.mobile.wm;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x6 implements u2<p6> {
    public static final dexa dexd = new dexa();
    public final j2.dexa dexa;
    public final r3 dexb;
    public final dexa dexc;

    public static class dexa {
        public j2 dexa(j2.dexa dexaVar) {
            return new j2(dexaVar);
        }

        public n2 dexa() {
            return new n2();
        }

        public n3<Bitmap> dexa(Bitmap bitmap, r3 r3Var) {
            return new t5(bitmap, r3Var);
        }

        public m2 dexb() {
            return new m2();
        }
    }

    public x6(r3 r3Var) {
        this(r3Var, dexd);
    }

    public x6(r3 r3Var, dexa dexaVar) {
        this.dexb = r3Var;
        this.dexa = new o6(r3Var);
        this.dexc = dexaVar;
    }

    private j2 dexa(byte[] bArr) {
        m2 m2VarDexb = this.dexc.dexb();
        m2VarDexb.dexa(bArr);
        l2 l2VarDexb = m2VarDexb.dexb();
        j2 j2VarDexa = this.dexc.dexa(this.dexa);
        j2VarDexa.dexa(l2VarDexb, bArr);
        j2VarDexa.dexa();
        return j2VarDexa;
    }

    private n3<Bitmap> dexa(Bitmap bitmap, v2<Bitmap> v2Var, p6 p6Var) {
        n3<Bitmap> n3VarDexa = this.dexc.dexa(bitmap, this.dexb);
        n3<Bitmap> n3VarDexa2 = v2Var.dexa(n3VarDexa, p6Var.getIntrinsicWidth(), p6Var.getIntrinsicHeight());
        if (!n3VarDexa.equals(n3VarDexa2)) {
            n3VarDexa.b();
        }
        return n3VarDexa2;
    }

    private boolean dexa(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable(com.ipd.dsp.internal.u.d.f38547a, 3)) {
                f1.dexa(com.ipd.dsp.internal.u.d.f38547a, "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    @Override // cj.mobile.wm.q2
    public boolean dexa(n3<p6> n3Var, OutputStream outputStream) {
        long jDexa = a9.dexa();
        p6 p6Var = n3Var.get();
        v2<Bitmap> v2VarDexd = p6Var.dexd();
        if (v2VarDexd instanceof q5) {
            return dexa(p6Var.dexa(), outputStream);
        }
        j2 j2VarDexa = dexa(p6Var.dexa());
        n2 n2VarDexa = this.dexc.dexa();
        if (!n2VarDexa.dexa(outputStream)) {
            return false;
        }
        for (int i = 0; i < j2VarDexa.dexd(); i++) {
            n3<Bitmap> n3VarDexa = dexa(j2VarDexa.dexf(), v2VarDexd, p6Var);
            try {
                if (!n2VarDexa.dexa(n3VarDexa.get())) {
                    n3VarDexa.b();
                    return false;
                }
                n2VarDexa.dexa(j2VarDexa.dexa(j2VarDexa.dexc()));
                j2VarDexa.dexa();
                n3VarDexa.b();
            } catch (Throwable th) {
                n3VarDexa.b();
                throw th;
            }
        }
        boolean zDexa = n2VarDexa.dexa();
        if (Log.isLoggable(com.ipd.dsp.internal.u.d.f38547a, 2)) {
            Log.v(com.ipd.dsp.internal.u.d.f38547a, "Encoded gif with " + j2VarDexa.dexd() + " frames and " + p6Var.dexa().length + " bytes in " + a9.dexa(jDexa) + " ms");
        }
        return zDexa;
    }

    @Override // cj.mobile.wm.q2
    public String getId() {
        return "";
    }
}
