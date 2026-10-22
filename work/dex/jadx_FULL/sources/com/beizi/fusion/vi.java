package com.beizi.fusion;

import android.net.Uri;
import android.text.TextUtils;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vi {
    private boolean a(int i) {
        return i == 200;
    }

    public void a(w1 w1Var, ti tiVar, th thVar) {
        String strM;
        if (w1Var == null || tiVar == null) {
            return;
        }
        try {
            String strB = a4.j().b();
            if (thVar == th.REWARDEDVIDEO) {
                strM = a4.j().l();
                if (!TextUtils.isEmpty(strM)) {
                    w1Var.a("5.0.0");
                    strB = strM;
                }
            } else if (thVar == th.NATIVE) {
                strM = a4.j().m();
                if (!TextUtils.isEmpty(strM)) {
                    w1Var.a("5.0.0");
                    strB = strM;
                }
            }
            kh.b("lance", "getRequestBaseUrl:" + strB);
            HttpURLConnection httpURLConnectionA = a(new URL(strB));
            byte[] bArrA = a(w1Var);
            if (bArrA == null) {
                tiVar.a(4);
                return;
            }
            a(httpURLConnectionA, bArrA);
            httpURLConnectionA.connect();
            if (!a(httpURLConnectionA.getResponseCode())) {
                tiVar.a(2);
                return;
            }
            InputStream inputStream = httpURLConnectionA.getInputStream();
            String strA = x1.i.a(inputStream);
            inputStream.close();
            if (TextUtils.isEmpty(strA)) {
                tiVar.a(3);
            } else {
                tiVar.a(strA);
            }
        } catch (Exception unused) {
        }
    }

    public String b(w1 w1Var) {
        a4 a4VarJ = a4.j();
        u6 u6VarM = u6.m();
        boolean z = (w1Var == null || TextUtils.isEmpty(w1Var.c())) ? false : true;
        String strEncode = null;
        if (w1Var != null) {
            try {
                if (w1Var.a() == 2) {
                    strEncode = a4.j().g;
                    if (!TextUtils.isEmpty(strEncode)) {
                        strEncode = Uri.encode(strEncode);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        n5 n5VarA = new n5.a().u(u6VarM.B()).d(u6VarM.h()).l(u6VarM.r()).g(u6VarM.l()).x(u6VarM.p()).h("").o(u6VarM.u()).a(m7.PLATFORM_ANDROID).a(u6VarM.i()).c(u6VarM.g()).k(u6VarM.q()).j(u6VarM.o()).q(u6VarM.w()).t(u6VarM.A()).i(u6VarM.n()).s(u6VarM.y()).a(u6VarM.a()).b(u6VarM.J()).n(u6VarM.t()).m(u6VarM.s()).y(u6VarM.F()).p(u6VarM.v()).e(u6VarM.j()).f(u6VarM.k()).r(u6VarM.x()).a(a4.j().h()).b(u6VarM.b()).v(u6VarM.D()).a(z).w(strEncode).a();
        rp rpVarA = rp.a();
        rpVarA.g();
        p5.a aVar = new p5.a();
        aVar.a(rpVarA.e());
        aVar.a(rpVarA.c());
        aVar.a(z);
        aVar.a(rpVarA.b());
        if (!TextUtils.isEmpty(rpVarA.e) && !TextUtils.isEmpty(rpVarA.f)) {
            aVar.a(new o5.a().a(rpVarA.f).b(rpVarA.e).c(rpVarA.g).a(rpVarA.h).a());
        }
        u1.a aVarA = new u1.a().d(u6VarM.C()).a(p7.SRC_APP).a(o7.REQ_AD).c(to.a()).c(a4VarJ.c()).a(n5VarA).a(aVar.a()).b(u6VarM.f()).a(u6VarM.d()).a(u6VarM.c()).b(u6VarM.e()).a(z);
        t1.a aVar2 = new t1.a();
        if (w1Var != null) {
            aVar2.e(w1Var.g());
            aVar2.d(w1Var.f());
            if (w1Var.h()) {
                aVar2.b(1);
            } else {
                aVar2.b(0);
            }
            aVar2.a(w1Var.e());
            aVar2.a(w1Var.b());
            aVar2.b(w1Var.c());
            aVar2.a(a4.j().f());
            aVar2.c(w1Var.d());
        }
        aVarA.a(aVar2.a());
        u1 u1VarA = aVarA.a();
        String strB = h2.b(rg.a(), u1VarA.toString());
        kh.b("lance", "sdkRequest:" + u1VarA.toString());
        return strB;
    }

    private byte[] a(w1 w1Var) {
        String strB = b(w1Var);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return strB.getBytes();
    }

    private HttpURLConnection a(URL url) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", a4.j().g);
        httpURLConnection.setRequestProperty("Content-Type", ze1.g);
        httpURLConnection.setRequestProperty("Accept", ze1.g);
        String strA = kq.a();
        if (!TextUtils.isEmpty(strA)) {
            httpURLConnection.setRequestProperty(com.google.common.net.b.p, strA);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public String a(String str, boolean z) {
        u6 u6VarM = u6.m();
        n5 n5VarA = new n5.a().u(u6VarM.B()).d(u6VarM.h()).l(u6VarM.r()).g(u6VarM.l()).x(u6VarM.p()).h("").o(u6VarM.u()).a(m7.PLATFORM_ANDROID).a(u6VarM.i()).c(u6VarM.g()).k(u6VarM.q()).j(u6VarM.o()).q(u6VarM.w()).t(u6VarM.A()).i(u6VarM.n()).s(u6VarM.y()).a(u6VarM.a()).b(u6VarM.J()).n(u6VarM.t()).m(u6VarM.s()).y(u6VarM.F()).p(u6VarM.v()).e(u6VarM.j()).f(u6VarM.k()).r(u6VarM.x()).a(a4.j().h()).b(u6VarM.b()).v(u6VarM.D()).a();
        rp rpVarA = rp.a();
        rpVarA.g();
        p5.a aVar = new p5.a();
        aVar.a(rpVarA.e());
        aVar.a(rpVarA.c());
        aVar.a(rpVarA.b());
        if (!TextUtils.isEmpty(rpVarA.e) && !TextUtils.isEmpty(rpVarA.f)) {
            aVar.a(new o5.a().a(rpVarA.f).b(rpVarA.e).c(rpVarA.g).a(rpVarA.h).a());
        }
        u1.a aVarB = new u1.a().d(u6VarM.C()).a(p7.SRC_APP).a(o7.REQ_AD).c(to.a()).a(n5VarA).a(aVar.a()).b(u6VarM.f()).a(u6VarM.d()).a(u6VarM.c()).b(u6VarM.e());
        aVarB.a(new t1.a().d(str).b(z ? 1 : 0).a(a4.j().f()).a());
        u1 u1VarA = aVarB.a();
        String strB = h2.b(rg.a(), u1VarA.toString());
        kh.b("lance", "sdkRequest:" + u1VarA.toString());
        return strB;
    }
}
