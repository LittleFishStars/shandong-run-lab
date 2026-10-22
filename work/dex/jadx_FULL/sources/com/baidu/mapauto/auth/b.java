package com.baidu.mapauto.auth;

import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f26593a;
    public final /* synthetic */ ILicenseAuthListener b;
    public final /* synthetic */ AuthCore.AuthParam c;
    public final /* synthetic */ AuthCore d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f26594a;
        public final /* synthetic */ BaseLicenseAuthDataStandardProcess b;
        public final /* synthetic */ AtomicReference c;
        public final /* synthetic */ CountDownLatch d;

        public a(HashMap map, BaseLicenseAuthDataStandardProcess baseLicenseAuthDataStandardProcess, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            this.f26594a = map;
            this.b = baseLicenseAuthDataStandardProcess;
            this.c = atomicReference;
            this.d = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                try {
                    this.f26594a.putAll(this.b.a(b.this.c.a()));
                } catch (BaseLicenseAuthDataStandardProcess.ProcessException e) {
                    this.c.set(e);
                }
            } finally {
                this.d.countDown();
            }
        }
    }

    public b(AuthCore authCore, int i, AuthCore.b bVar, AuthCore.AuthParam authParam) {
        this.d = authCore;
        this.f26593a = i;
        this.b = bVar;
        this.c = authParam;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (AuthCore.class) {
            ArrayList arrayList = new ArrayList(2);
            if ((this.f26593a & 1) == 1) {
                arrayList.add(this.d.e);
                LogUtil.getInstance().i(AuthCore.TAG, "添加 license file 授权流程");
            }
            if ((this.f26593a & 2) == 2) {
                arrayList.add(this.d.f);
                LogUtil.getInstance().i(AuthCore.TAG, "添加 license function 授权流程");
            }
            if (arrayList.isEmpty()) {
                this.b.onSuccess(new HashMap(0));
                return;
            }
            HashMap map = new HashMap();
            CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
            AtomicReference atomicReference = new AtomicReference();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.d.d.submit(new a(map, (BaseLicenseAuthDataStandardProcess) it.next(), atomicReference, countDownLatch));
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                atomicReference.set(new BaseLicenseAuthDataStandardProcess.ProcessException(-1001, "获取数据取消异常"));
            }
            BaseLicenseAuthDataStandardProcess.ProcessException processException = (BaseLicenseAuthDataStandardProcess.ProcessException) atomicReference.get();
            if (processException != null) {
                this.b.onError(processException.getCode(), processException.getMessage());
            } else {
                this.b.onSuccess(map);
            }
        }
    }
}
