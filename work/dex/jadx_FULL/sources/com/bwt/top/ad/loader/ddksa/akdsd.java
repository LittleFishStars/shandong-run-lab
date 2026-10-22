package com.bwt.top.ad.loader.ddksa;

import com.bwt.top.ad.adapter.AdapterAdLoader;
import com.bwt.top.ad.adapter.AdapterAdLoaderCallback;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class akdsd implements AdapterAdLoaderCallback {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdapterAdLoader f1467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kdsksdda f1468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1469a = akdsd.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28242a = 0;

    public interface kdsksdda {
        void a();
    }

    public akdsd(AdapterAdLoader adapterAdLoader, kdsksdda kdsksddaVar) {
        this.f1467a = adapterAdLoader;
        this.f1468a = kdsksddaVar;
    }

    public boolean a() {
        return this.f28242a != 0;
    }

    public boolean b() {
        return this.f28242a == 1;
    }

    public AdapterAdLoader c() {
        return this.f1467a;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderCallback
    public void onLoadAdObjectFailed(PosInfoBean posInfoBean) {
        ALog.i(this.f1469a, "onLoadAdObjectFailed: " + posInfoBean);
        this.f28242a = -1;
        kdsksdda kdsksddaVar = this.f1468a;
        if (kdsksddaVar != null) {
            kdsksddaVar.a();
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderCallback
    public void onLoadAdObjectSucceed(PosInfoBean posInfoBean) {
        ALog.i(this.f1469a, "onLoadAdObjectSucceed: " + posInfoBean);
        this.f28242a = 1;
        kdsksdda kdsksddaVar = this.f1468a;
        if (kdsksddaVar != null) {
            kdsksddaVar.a();
        }
    }
}
