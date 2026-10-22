package cj.mobile.wm;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class w6 implements t2<InputStream, p6> {
    public static final dexb dexf = new dexb();
    public static final dexa dexg = new dexa();
    public final Context dexa;
    public final dexb dexb;
    public final r3 dexc;
    public final dexa dexd;
    public final o6 dexe;

    public static class dexa {
        public final Queue<j2> dexa = e9.dexa(0);

        public synchronized j2 dexa(j2.dexa dexaVar) {
            j2 j2VarPoll;
            j2VarPoll = this.dexa.poll();
            if (j2VarPoll == null) {
                j2VarPoll = new j2(dexaVar);
            }
            return j2VarPoll;
        }

        public synchronized void dexa(j2 j2Var) {
            j2Var.dexb();
            this.dexa.offer(j2Var);
        }
    }

    public static class dexb {
        public final Queue<m2> dexa = e9.dexa(0);

        public synchronized m2 dexa(byte[] bArr) {
            m2 m2VarPoll;
            m2VarPoll = this.dexa.poll();
            if (m2VarPoll == null) {
                m2VarPoll = new m2();
            }
            return m2VarPoll.dexa(bArr);
        }

        public synchronized void dexa(m2 m2Var) {
            m2Var.dexa();
            this.dexa.offer(m2Var);
        }
    }

    public w6(Context context, r3 r3Var) {
        this(context, r3Var, dexf, dexg);
    }

    public w6(Context context, r3 r3Var, dexb dexbVar, dexa dexaVar) {
        this.dexa = context.getApplicationContext();
        this.dexc = r3Var;
        this.dexd = dexaVar;
        this.dexe = new o6(r3Var);
        this.dexb = dexbVar;
    }

    private Bitmap dexa(j2 j2Var, l2 l2Var, byte[] bArr) {
        j2Var.dexa(l2Var, bArr);
        j2Var.dexa();
        return j2Var.dexf();
    }

    private r6 dexa(byte[] bArr, int i, int i2, m2 m2Var, j2 j2Var) {
        Bitmap bitmapDexa;
        l2 l2VarDexb = m2Var.dexb();
        if (l2VarDexb.dexa() <= 0 || l2VarDexb.dexb() != 0 || (bitmapDexa = dexa(j2Var, l2VarDexb, bArr)) == null) {
            return null;
        }
        return new r6(new p6(this.dexa, this.dexe, this.dexc, q5.dexa(), i, i2, l2VarDexb, bArr, bitmapDexa));
    }

    public static byte[] dexa(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // cj.mobile.wm.t2
    public r6 dexa(InputStream inputStream, int i, int i2) {
        byte[] bArrDexa = dexa(inputStream);
        m2 m2VarDexa = this.dexb.dexa(bArrDexa);
        j2 j2VarDexa = this.dexd.dexa(this.dexe);
        try {
            return dexa(bArrDexa, i, i2, m2VarDexa, j2VarDexa);
        } finally {
            this.dexb.dexa(m2VarDexa);
            this.dexd.dexa(j2VarDexa);
        }
    }

    @Override // cj.mobile.wm.t2
    public String getId() {
        return "";
    }
}
