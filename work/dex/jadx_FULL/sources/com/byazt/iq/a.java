package com.byazt.iq;

import com.byazt.eg.eo;
import com.byazt.eg.m;
import com.byazt.eg.my;
import com.zj.adlib.u15;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 179, 34})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28662a;
    public final com.byazt.eg.c c;
    public final uj tt;
    public final m uj;
    public final com.byazt.eg.n ve;
    public List<Proxy> n = Collections.emptyList();
    public List<InetSocketAddress> sp = Collections.emptyList();
    public final List<eo> x = new ArrayList();

    @com.byazt.zqa.c(c = {0, 1, 179, 464})
    public static final class c {
        public final List<eo> c;
        public int tt = 0;

        public c(List<eo> list) {
            this.c = list;
        }

        public boolean c() {
            return this.tt < this.c.size();
        }

        public eo tt() {
            if (!c()) {
                throw new NoSuchElementException();
            }
            List<eo> list = this.c;
            int i = this.tt;
            this.tt = i + 1;
            return list.get(i);
        }

        public List<eo> ve() {
            return new ArrayList(this.c);
        }
    }

    public a(com.byazt.eg.c cVar, uj ujVar, com.byazt.eg.n nVar, m mVar) throws IOException {
        this.c = cVar;
        this.tt = ujVar;
        this.ve = nVar;
        this.uj = mVar;
        c(cVar.c(), cVar.x());
    }

    private Proxy uj() throws IOException {
        if (!ve()) {
            throw new SocketException("No route to " + this.c.c().sp() + "; exhausted proxy configurations: " + this.n);
        }
        List<Proxy> list = this.n;
        int i = this.f28662a;
        this.f28662a = i + 1;
        Proxy proxy = list.get(i);
        c(proxy);
        return proxy;
    }

    private boolean ve() {
        return this.f28662a < this.n.size();
    }

    public boolean c() {
        return ve() || !this.x.isEmpty();
    }

    public c tt() throws IOException {
        if (!c()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (ve()) {
            Proxy proxyUj = uj();
            int size = this.sp.size();
            for (int i = 0; i < size; i++) {
                eo eoVar = new eo(this.c, proxyUj, this.sp.get(i));
                if (this.tt.ve(eoVar)) {
                    this.x.add(eoVar);
                } else {
                    arrayList.add(eoVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.x);
            this.x.clear();
        }
        return new c(arrayList);
    }

    public void c(eo eoVar, IOException iOException) {
        if (eoVar.tt().type() != Proxy.Type.DIRECT && this.c.sp() != null) {
            this.c.sp().connectFailed(this.c.c().tt(), eoVar.tt().address(), iOException);
        }
        this.tt.c(eoVar);
    }

    private void c(my myVar, Proxy proxy) throws IOException {
        List<Proxy> listC;
        if (proxy != null) {
            this.n = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.c.sp().select(myVar.tt());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listC = com.byazt.kh.ve.c(listSelect);
                } else {
                    listC = com.byazt.kh.ve.c(Proxy.NO_PROXY);
                }
                this.n = listC;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.f28662a = 0;
    }

    private void c(Proxy proxy) throws IOException {
        String strSp;
        int iX;
        this.sp = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddressAddress = proxy.address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                strSp = c(inetSocketAddress);
                iX = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
        } else {
            strSp = this.c.c().sp();
            iX = this.c.c().x();
        }
        if (iX > 0 && iX <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.sp.add(InetSocketAddress.createUnresolved(strSp, iX));
                return;
            }
            List<InetAddress> listC = this.c.tt().c(strSp);
            if (listC.isEmpty()) {
                return;
            }
            int size = listC.size();
            for (int i = 0; i < size; i++) {
                this.sp.add(new InetSocketAddress(listC.get(i), iX));
            }
            return;
        }
        throw new SocketException("No route to " + strSp + u15.f19942b + iX + "; port is out of range");
    }

    public static String c(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
