package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class m extends FutureTask<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f25330a;
    public final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Callable callable, q qVar) {
        super(callable);
        this.b = lVar;
        this.f25330a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        String msg;
        int code;
        o oVarE = this.f25330a.e();
        ae aeVarF = oVarE.f();
        if (aeVarF == null) {
            super.done();
            return;
        }
        try {
            v vVar = get();
            if (!isCancelled() && !oVarE.h()) {
                if (vVar != null) {
                    aeVarF.a(oVarE, vVar);
                    return;
                }
                return;
            }
            oVarE.g();
            if (!isCancelled() || !isDone()) {
                cancel(false);
            }
            aeVarF.a(oVarE);
        } catch (InterruptedException e) {
            aeVarF.a(oVarE, 7, e + "");
        } catch (CancellationException unused) {
            oVarE.g();
            aeVarF.a(oVarE);
        } catch (ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof HttpException)) {
                msg = e2 + "";
                code = 6;
            } else {
                HttpException httpException = (HttpException) e2.getCause();
                code = httpException.getCode();
                msg = httpException.getMsg();
            }
            aeVarF.a(oVarE, code, msg);
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
