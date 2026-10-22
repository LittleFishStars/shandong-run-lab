package cn.hzjizhun.admin;

import cn.hzjizhun.admin.ad.adapter.AdapterAdLoader;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderCallback;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class assa implements AdapterAdLoaderCallback {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdapterAdLoader f276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kdsksdda f277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f278a = getClass().getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22692a = 0;

    public interface kdsksdda {
        void a();
    }

    public assa(AdapterAdLoader adapterAdLoader, kdsksdda kdsksddaVar) {
        this.f276a = adapterAdLoader;
        this.f277a = kdsksddaVar;
    }

    public boolean a() {
        return this.f22692a == 1;
    }

    public AdapterAdLoader b() {
        return this.f276a;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderCallback
    public void onLoadAdObjectFailed(PosInfoBean posInfoBean) {
        ALog.i(this.f278a, "onLoadAdObjectFailed: " + posInfoBean);
        this.f22692a = -1;
        kdsksdda kdsksddaVar = this.f277a;
        if (kdsksddaVar != null) {
            kdsksddaVar.a();
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderCallback
    public void onLoadAdObjectSucceed(PosInfoBean posInfoBean) {
        ALog.i(this.f278a, "onLoadAdObjectSucceed: " + posInfoBean);
        this.f22692a = 1;
        kdsksdda kdsksddaVar = this.f277a;
        if (kdsksddaVar != null) {
            kdsksddaVar.a();
        }
    }
}
