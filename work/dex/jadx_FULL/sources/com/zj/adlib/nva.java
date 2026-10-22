package com.zj.adlib;

import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.ddk;
import cn.hzjizhun.admin.dkkd;
import cn.hzjizhun.admin.k;
import cn.hzjizhun.admin.util.ClassUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class nva extends ghb {
    public boolean b;

    public nva(JZSplashAd jZSplashAd) {
        super(jZSplashAd);
        this.b = false;
    }

    @Override // com.zj.adlib.ghb
    public AdapterAdLoaderImp c(String str, PosInfoBean posInfoBean) {
        Object objCreateInstanceByClass;
        try {
            if (this.b) {
                return super.c(str, posInfoBean);
            }
            String str2 = (String) ddk.f.get(AdPlatforms.zhike.name());
            if (str2 == null || str2.isEmpty() || (objCreateInstanceByClass = ClassUtil.createInstanceByClass(str2)) == null) {
                return null;
            }
            AdapterAdLoaderImp adapterAdLoaderImp = (AdapterAdLoaderImp) objCreateInstanceByClass;
            adapterAdLoaderImp.setAd(((ghb) this).f41907a);
            return adapterAdLoaderImp;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void e(boolean z) {
        this.b = z;
    }

    @Override // com.zj.adlib.ghb
    public dkkd kdsksdda(String str) {
        return !this.b ? new k(str, this) : super.kdsksdda(str);
    }
}
