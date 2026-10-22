package com.igexin.c.a.b;

import android.taobao.windvane.util.WVNativeCallbackUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class f extends com.igexin.c.a.d.f {
    protected static final int e = -2048;
    public String b;
    public d c;
    public Object d;

    private f(int i, d dVar) {
        this(i, null, dVar);
    }

    public f(int i, String str, d dVar) {
        super(i);
        if (str != null) {
            String[] strArrA = g.a(str);
            StringBuilder sb = new StringBuilder();
            if (!strArrA[0].equals("")) {
                sb.append(strArrA[0]);
                sb.append("://");
            }
            if (!strArrA[1].equals("")) {
                sb.append(strArrA[1]);
            }
            if (!strArrA[2].equals("")) {
                sb.append(com.google.common.net.c.b);
                sb.append(strArrA[2]);
            }
            if (!strArrA[3].equals("")) {
                sb.append(strArrA[3]);
                if (!strArrA[3].equals(WVNativeCallbackUtil.SEPERATER)) {
                    sb.append('/');
                }
            }
            if (!strArrA[4].equals("")) {
                sb.append(strArrA[4]);
            }
            if (!strArrA[5].equals("")) {
                sb.append('?');
                sb.append(strArrA[5]);
            }
            this.b = sb.toString();
        }
        this.c = dVar;
    }

    public f(String str, d dVar) {
        this(0, str, dVar);
    }

    private static String a(String str) {
        String[] strArrA = g.a(str);
        StringBuilder sb = new StringBuilder();
        if (!strArrA[0].equals("")) {
            sb.append(strArrA[0]);
            sb.append("://");
        }
        if (!strArrA[1].equals("")) {
            sb.append(strArrA[1]);
        }
        if (!strArrA[2].equals("")) {
            sb.append(com.google.common.net.c.b);
            sb.append(strArrA[2]);
        }
        if (!strArrA[3].equals("")) {
            sb.append(strArrA[3]);
            if (!strArrA[3].equals(WVNativeCallbackUtil.SEPERATER)) {
                sb.append('/');
            }
        }
        if (!strArrA[4].equals("")) {
            sb.append(strArrA[4]);
        }
        if (!strArrA[5].equals("")) {
            sb.append('?');
            sb.append(strArrA[5]);
        }
        return sb.toString();
    }

    private void a(f fVar) {
        super.a((com.igexin.c.a.d.f) fVar);
        this.b = fVar.b;
        this.c = fVar.c;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public void a() {
        d dVar = this.c;
        if (dVar != null) {
            dVar.b();
        }
        super.a();
    }
}
