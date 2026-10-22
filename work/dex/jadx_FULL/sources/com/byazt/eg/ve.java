package com.byazt.eg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 54})
public final class ve implements Closeable, Flushable {
    public final com.byazt.umr.a c;
    public final com.byazt.umr.uj tt;

    @com.byazt.zqa.c(c = {0, 1, 16, 24})
    public static class c extends d {
        public final com.byazt.umr.uj.ve c;
        public final com.byazt.mk.n tt;
        public final String uj;
        public final String ve;

        @Override // com.byazt.eg.d
        public rl c() {
            String str = this.ve;
            if (str != null) {
                return rl.c(str);
            }
            return null;
        }

        @Override // com.byazt.eg.d
        public long tt() {
            try {
                String str = this.uj;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.byazt.eg.d
        public com.byazt.mk.n ve() {
            return this.tt;
        }
    }

    private void c(com.byazt.umr.uj.c cVar) {
        if (cVar != null) {
            try {
                cVar.ve();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.tt.close();
    }

    public void delete() throws IOException {
        this.tt.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.tt.flush();
    }

    public void update(h hVar, h hVar2) {
        com.byazt.umr.uj.c cVarC;
        tt ttVar = new tt(hVar2);
        try {
            cVarC = ((c) hVar.x()).c.c();
            if (cVarC != null) {
                try {
                    ttVar.c(cVarC);
                    cVarC.tt();
                } catch (IOException unused) {
                    c(cVarC);
                }
            }
        } catch (IOException unused2) {
            cVarC = null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static final class tt {
        public static final String c = com.byazt.xb.n.tt().ve() + "-Sent-Millis";
        public static final String tt = com.byazt.xb.n.tt().ve() + "-Received-Millis";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gr f28461a;
        public final nu da;
        public final rh i;
        public final String n;
        public final long sl;
        public final int sp;
        public final long t;
        public final rh uj;
        public final String ve;
        public final String x;

        public tt(h hVar) {
            this.ve = hVar.c().c().toString();
            this.uj = com.byazt.yx.n.tt(hVar);
            this.n = hVar.c().tt();
            this.f28461a = hVar.tt();
            this.sp = hVar.ve();
            this.x = hVar.n();
            this.i = hVar.sp();
            this.da = hVar.a();
            this.sl = hVar.u();
            this.t = hVar.yp();
        }

        public void c(com.byazt.umr.uj.c cVar) throws IOException {
            com.byazt.mk.uj ujVarC = com.byazt.mk.t.c(cVar.c(0));
            ujVarC.tt(this.ve).i(10);
            ujVarC.tt(this.n).i(10);
            ujVarC.t(this.uj.c()).i(10);
            int iC = this.uj.c();
            for (int i = 0; i < iC; i++) {
                ujVarC.tt(this.uj.c(i)).tt(": ").tt(this.uj.tt(i)).i(10);
            }
            ujVarC.tt(new com.byazt.yx.sl(this.f28461a, this.sp, this.x).toString()).i(10);
            ujVarC.t(this.i.c() + 2).i(10);
            int iC2 = this.i.c();
            for (int i2 = 0; i2 < iC2; i2++) {
                ujVarC.tt(this.i.c(i2)).tt(": ").tt(this.i.tt(i2)).i(10);
            }
            ujVarC.tt(c).tt(": ").t(this.sl).i(10);
            ujVarC.tt(tt).tt(": ").t(this.t).i(10);
            if (c()) {
                ujVarC.i(10);
                ujVarC.tt(this.da.tt().c()).i(10);
                c(ujVarC, this.da.ve());
                c(ujVarC, this.da.uj());
                ujVarC.tt(this.da.c().c()).i(10);
            }
            ujVarC.close();
        }

        private boolean c() {
            return this.ve.startsWith("https://");
        }

        private void c(com.byazt.mk.uj ujVar, List<Certificate> list) throws IOException {
            try {
                ujVar.t(list.size()).i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ujVar.tt(com.byazt.mk.a.c(list.get(i).getEncoded()).tt()).i(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
