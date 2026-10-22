package cn.hzjizhun.admin;

import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.util.ALog;
import com.zj.adlib.nva;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k extends dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public assa f22747a;
    public boolean c;

    public k(String str, nva nvaVar) {
        super(str, nvaVar);
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        assa assaVar;
        if (c() || (assaVar = this.f22747a) == null || !assaVar.a()) {
            kdsksdda("all third ad no data");
        } else {
            this.c = true;
            this.f22747a.b().showAdObject();
        }
    }

    @Override // cn.hzjizhun.admin.dkkd
    public void a() {
        try {
            PosInfoBean posInfoBeanM = m();
            AdapterAdLoaderImp adapterAdLoaderImpC = ((nva) ((dkkd) this).f22715a).c(this.e, posInfoBeanM);
            if (adapterAdLoaderImpC == null) {
                kdsksdda("adapterAdLoader is null");
                return;
            }
            ALog.i(((dkkd) this).f291a, " createAdapterLoader succeed " + adapterAdLoaderImpC.getClass().getSimpleName());
            assa assaVar = new assa(adapterAdLoaderImpC, new assa.kdsksdda() { // from class: com.zj.adlib.nqb
                @Override // cn.hzjizhun.admin.assa.kdsksdda
                public final void a() {
                    this.f43592a.n();
                }
            });
            this.f22747a = assaVar;
            adapterAdLoaderImpC.loadAdObject(posInfoBeanM, assaVar);
            ((dkkd) this).f293a.put(posInfoBeanM, this.f22747a);
        } catch (Throwable unused) {
            kdsksdda("adapterAdLoader is null");
        }
    }

    @Override // cn.hzjizhun.admin.dkkd
    public void d() {
        try {
            if (c() || dkkd()) {
                return;
            }
            l();
        } catch (Throwable th) {
            kdsksdda("showad is error" + th.getMessage());
        }
    }

    @Override // cn.hzjizhun.admin.dkkd
    public void e() {
        try {
            if (this.c) {
                this.f22747a.b().shakeClick();
            }
        } catch (Throwable unused) {
        }
    }

    public final void l() {
        try {
            if (this.c) {
                this.f22747a.b().showAdObject();
            } else {
                kdsksdda("all third ad no data");
            }
        } catch (Throwable unused) {
        }
    }

    public final PosInfoBean m() {
        String appId = JZAdSdk.getInstance().getAppId();
        PosInfoBean posInfoBean = new PosInfoBean();
        posInfoBean.setPosId(this.e);
        posInfoBean.setPosPlatform(AdPlatforms.zhike.name());
        posInfoBean.setAppid(appId);
        posInfoBean.setThirdPosId(this.e);
        posInfoBean.setThirdAppId(appId);
        return posInfoBean;
    }
}
