package cn.hzjizhun.admin;

import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.util.ALog;
import com.zj.adlib.ghb;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public assa f297a;
    public boolean c;
    public boolean d;

    public f(String str, ghb ghbVar) {
        super(str, ghbVar);
        this.c = false;
        this.d = false;
        this.f22719a = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(List list) {
        if (c()) {
            return;
        }
        n(list);
    }

    @Override // cn.hzjizhun.admin.dkkd
    public void a() {
        List listG = g();
        if (listG == null || listG.isEmpty()) {
            kdsksdda("posInfoList is null");
            return;
        }
        ALog.i(((dkkd) this).f291a, "loadAdByStrategy size: " + listG.size());
        try {
            l(listG);
        } catch (Throwable th) {
            kdsksdda("adapterAdLoader is null" + th.getMessage());
        }
    }

    @Override // cn.hzjizhun.admin.dkkd
    public void d() {
        try {
            if (c() || dkkd()) {
                return;
            }
            m();
        } catch (Throwable th) {
            kdsksdda("showad is error" + th.getMessage());
        }
    }

    @Override // cn.hzjizhun.admin.dkkd
    public void e() {
        assa assaVar;
        try {
            if (this.d && (assaVar = this.f297a) != null && assaVar.a()) {
                this.f297a.b().shakeClick();
            }
        } catch (Throwable unused) {
        }
    }

    public final void l(final List list) {
        if (this.f22719a >= list.size()) {
            this.d = true;
            if (this.c) {
                kdsksdda("all third ad no data");
                return;
            } else {
                kdsksdda("adapterAdLoader is null");
                ApiManager.reportError("20003", this.e);
                return;
            }
        }
        PosInfoBean posInfoBean = (PosInfoBean) list.get(this.f22719a);
        ALog.i(((dkkd) this).f291a, "loadAdByStrategy posInfo: " + posInfoBean);
        AdapterAdLoaderImp adapterAdLoaderImpC = ((dkkd) this).f22715a.c(this.e, posInfoBean);
        if (adapterAdLoaderImpC == null) {
            this.f22719a++;
            l(list);
            ALog.e(((dkkd) this).f291a, " createAdapterLoader failed");
            return;
        }
        this.c = true;
        ALog.i(((dkkd) this).f291a, " createAdapterLoader succeed " + adapterAdLoaderImpC.getClass().getSimpleName());
        assa assaVar = new assa(adapterAdLoaderImpC, new assa.kdsksdda() { // from class: com.zj.adlib.hva
            @Override // cn.hzjizhun.admin.assa.kdsksdda
            public final void a() {
                this.f42216a.o(list);
            }
        });
        this.f297a = assaVar;
        adapterAdLoaderImpC.loadAdObject(posInfoBean, assaVar);
        ((dkkd) this).f293a.put(posInfoBean, this.f297a);
    }

    public final void m() {
        assa assaVar;
        try {
            if (this.d && (assaVar = this.f297a) != null && assaVar.a()) {
                this.f297a.b().showAdObject();
            } else if (this.d) {
                kdsksdda("all third ad no data");
            }
        } catch (Throwable unused) {
        }
    }

    public final void n(List list) {
        try {
            assa assaVar = this.f297a;
            if (assaVar == null || !assaVar.a()) {
                ALog.i(((dkkd) this).f291a, " checkLoadAdObjectResult succeed 请求失败 " + this.f22719a);
                this.f22719a = this.f22719a + 1;
                l(list);
                return;
            }
            ALog.i(((dkkd) this).f291a, " checkLoadAdObjectResult succeed 请求成功 " + this.f22719a);
            this.d = true;
            this.f297a.b().showAdObject();
        } catch (Throwable unused) {
        }
    }
}
