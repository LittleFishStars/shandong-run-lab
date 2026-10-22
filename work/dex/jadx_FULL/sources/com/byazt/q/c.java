package com.byazt.q;

import java.net.DatagramSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 956, 20})
public abstract class c {
    public static final tt n = new ve();
    public int c;
    public DatagramSocket tt;
    public tt uj;
    public boolean ve;

    public void c() throws SocketException {
        DatagramSocket datagramSocketC = this.uj.c();
        this.tt = datagramSocketC;
        datagramSocketC.setSoTimeout(this.c);
        this.ve = true;
    }

    public boolean tt() {
        return this.ve;
    }
}
