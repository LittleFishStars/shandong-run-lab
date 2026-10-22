package com.byazt.eg;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 17})
public class gu implements Cloneable {
    public static final List<gr> c = com.byazt.kh.ve.c(gr.HTTP_2, gr.HTTP_1_1);
    public static final List<sl> tt = com.byazt.kh.ve.c(sl.c, sl.ve);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<sl> f28447a;
    public Set<String> d;
    public final ProxySelector da;
    public final boolean gr;
    public final tt gt;
    public final boolean gu;
    public final int h;
    public final m.c i;
    public final com.byazt.wt.ve m;
    public final int md;
    public final tt my;
    public final List<gr> n;
    public final HostnameVerifier nu;
    public final int p;
    public final z qy;
    public final sp rh;
    public final da rl;
    public final u sl;
    public final List<gt> sp;
    public final ve t;
    public final com.byazt.umr.a u;
    public final Proxy uj;
    public final yp ve;
    public final List<gt> x;
    public final SocketFactory yp;
    public final int yv;
    public final SSLSocketFactory z;
    public final boolean zm;

    @com.byazt.zqa.c(c = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<gt> f28448a;
        public yp c;
        public TimeUnit d;
        public ve da;
        public TimeUnit eo;
        public int gr;
        public z gt;
        public boolean gu;
        public Set<String> h;
        public u i;
        public sp m;
        public Bundle md;
        public da my;
        public final List<gt> n;
        public tt nu;
        public int p;
        public boolean qy;
        public tt rh;
        public boolean rl;
        public com.byazt.umr.a sl;
        public m.c sp;
        public SocketFactory t;
        public Proxy tt;
        public SSLSocketFactory u;
        public List<sl> uj;
        public List<gr> ve;
        public ProxySelector x;
        public com.byazt.wt.ve yp;
        public int yv;
        public HostnameVerifier z;
        public TimeUnit zb;
        public int zm;

        public c() {
            this("");
        }

        public c c(gt gtVar) {
            if (gtVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.n.add(gtVar);
            return this;
        }

        public c(String str) {
            this.n = new ArrayList();
            this.f28448a = new ArrayList();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.d = timeUnit;
            this.eo = timeUnit;
            this.zb = timeUnit;
            this.c = new yp(str);
            this.ve = gu.c;
            this.uj = gu.tt;
            this.sp = m.c(m.c);
            this.x = ProxySelector.getDefault();
            this.i = u.c;
            this.t = SocketFactory.getDefault();
            this.z = com.byazt.wt.n.c;
            this.m = sp.c;
            tt ttVar = tt.c;
            this.nu = ttVar;
            this.rh = ttVar;
            this.my = new da();
            this.gt = z.c;
            this.rl = true;
            this.qy = true;
            this.gu = true;
            this.gr = 10000;
            this.zm = 10000;
            this.yv = 10000;
            this.p = 0;
        }

        public c c(m mVar) {
            if (mVar != null) {
                this.sp = m.c(mVar);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public gu c() {
            return new gu(this);
        }
    }

    static {
        com.byazt.kh.c.c = new com.byazt.kh.c() { // from class: com.byazt.eg.gu.1
            @Override // com.byazt.kh.c
            public void c(rh.c cVar, String str) {
                cVar.c(str);
            }

            @Override // com.byazt.kh.c
            public void tt(da daVar, com.byazt.iq.ve veVar) {
                daVar.c(veVar);
            }

            @Override // com.byazt.kh.c
            public void c(rh.c cVar, String str, String str2) {
                cVar.tt(str, str2);
            }

            @Override // com.byazt.kh.c
            public boolean c(da daVar, com.byazt.iq.ve veVar) {
                return daVar.tt(veVar);
            }

            @Override // com.byazt.kh.c
            public com.byazt.iq.ve c(da daVar, com.byazt.eg.c cVar, com.byazt.iq.sp spVar, eo eoVar) {
                return daVar.c(cVar, spVar, eoVar);
            }

            @Override // com.byazt.kh.c
            public boolean c(com.byazt.eg.c cVar, com.byazt.eg.c cVar2) {
                return cVar.c(cVar2);
            }

            @Override // com.byazt.kh.c
            public Socket c(da daVar, com.byazt.eg.c cVar, com.byazt.iq.sp spVar) {
                return daVar.c(cVar, spVar);
            }

            @Override // com.byazt.kh.c
            public com.byazt.iq.uj c(da daVar) {
                return daVar.c;
            }

            @Override // com.byazt.kh.c
            public int c(h.c cVar) {
                return cVar.ve;
            }

            @Override // com.byazt.kh.c
            public void c(sl slVar, SSLSocket sSLSocket, boolean z) {
                slVar.c(sSLSocket, z);
            }
        };
    }

    public gu() {
        this(new c());
    }

    private SSLSocketFactory c(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.byazt.kh.ve.c("No System TLS", (Exception) e);
        }
    }

    private X509TrustManager zm() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.byazt.kh.ve.c("No System TLS", (Exception) e);
        }
    }

    public u a() {
        return this.sl;
    }

    public SSLSocketFactory da() {
        return this.z;
    }

    public m.c gr() {
        return this.i;
    }

    public List<gr> gt() {
        return this.n;
    }

    public List<gt> gu() {
        return this.x;
    }

    public SocketFactory i() {
        return this.yp;
    }

    public boolean m() {
        return this.gu;
    }

    public yp my() {
        return this.ve;
    }

    public ProxySelector n() {
        return this.da;
    }

    public boolean nu() {
        return this.gr;
    }

    public List<gt> qy() {
        return this.sp;
    }

    public boolean rh() {
        return this.zm;
    }

    public List<sl> rl() {
        return this.f28447a;
    }

    public HostnameVerifier sl() {
        return this.nu;
    }

    public com.byazt.umr.a sp() {
        ve veVar = this.t;
        return veVar != null ? veVar.c : this.u;
    }

    public sp t() {
        return this.rh;
    }

    public int tt() {
        return this.p;
    }

    public tt u() {
        return this.gt;
    }

    public Proxy uj() {
        return this.uj;
    }

    public int ve() {
        return this.md;
    }

    public z x() {
        return this.qy;
    }

    public tt yp() {
        return this.my;
    }

    public da z() {
        return this.rl;
    }

    public gu(c cVar) {
        boolean z;
        this.ve = cVar.c;
        this.uj = cVar.tt;
        this.n = cVar.ve;
        List<sl> list = cVar.uj;
        this.f28447a = list;
        this.sp = com.byazt.kh.ve.c(cVar.n);
        this.x = com.byazt.kh.ve.c(cVar.f28448a);
        this.i = cVar.sp;
        this.da = cVar.x;
        this.sl = cVar.i;
        this.t = cVar.da;
        this.u = cVar.sl;
        this.yp = cVar.t;
        this.d = cVar.h;
        Iterator<sl> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = (z || it.next().c()) ? true : z;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = cVar.u;
        if (sSLSocketFactory == null && z) {
            X509TrustManager x509TrustManagerZm = zm();
            this.z = c(x509TrustManagerZm);
            this.m = com.byazt.wt.ve.c(x509TrustManagerZm);
        } else {
            this.z = sSLSocketFactory;
            this.m = cVar.yp;
        }
        this.nu = cVar.z;
        this.rh = cVar.m.c(this.m);
        this.my = cVar.nu;
        this.gt = cVar.rh;
        da daVar = cVar.my;
        this.rl = daVar;
        if (daVar != null) {
            daVar.c(cVar.md);
        }
        this.qy = cVar.gt;
        this.gu = cVar.rl;
        this.gr = cVar.qy;
        this.zm = cVar.gu;
        this.yv = cVar.gr;
        this.p = cVar.zm;
        this.md = cVar.yv;
        this.h = cVar.p;
        if (this.sp.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.sp);
        }
        if (this.x.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.x);
        }
    }

    public int c() {
        return this.yv;
    }

    public n c(yv yvVar) {
        return zm.c(this, yvVar, false);
    }
}
