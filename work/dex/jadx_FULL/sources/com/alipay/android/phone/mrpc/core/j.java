package com.alipay.android.phone.mrpc.core;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j extends a {
    private g g;

    public j(g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.g = gVar;
    }

    private int a(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 15;
            case 9:
                return 16;
            default:
                return i;
        }
    }

    private void a(o oVar) {
        oVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> listB = this.g.c().b();
        if (listB == null || listB.isEmpty()) {
            return;
        }
        Iterator<Header> it = listB.iterator();
        while (it.hasNext()) {
            oVar.a(it.next());
        }
    }

    private ad b() {
        return this.g.b();
    }

    @Override // com.alipay.android.phone.mrpc.core.w
    public Object a() {
        o oVar = new o(this.g.a());
        oVar.a(this.b);
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a("id", String.valueOf(this.d));
        oVar.a("operationType", this.c);
        oVar.a("gzip", String.valueOf(this.g.d()));
        a(oVar);
        Log.i("HttpCaller", "threadid = " + Thread.currentThread().getId() + "; " + oVar.toString());
        try {
            v vVar = b().a(oVar).get();
            if (vVar != null) {
                return vVar.b();
            }
            throw new RpcException((Integer) 9, "response is null");
        } catch (InterruptedException e) {
            throw new RpcException(13, "", e);
        } catch (CancellationException e2) {
            throw new RpcException(13, "", e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(9, "", e3);
            }
            HttpException httpException = (HttpException) cause;
            throw new RpcException(Integer.valueOf(a(httpException.getCode())), httpException.getMsg());
        }
    }
}
