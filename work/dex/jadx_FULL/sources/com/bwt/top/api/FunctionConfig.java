package com.bwt.top.api;

import com.bwt.top.AdPlatforms;
import com.bwt.top.api.bean.InitConfigBean;
import com.bwt.top.api.bean.PlatformInfoBean;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.api.bean.ReportInfoBean;
import com.bwt.top.util.ALog;
import com.easyjson.JSON;
import com.zj.adlib.hja;
import com.zj.adlib.lva;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FunctionConfig {
    private static final String init_config_key = "init_config";
    private static FunctionConfig instance = new FunctionConfig();
    private String TAG = "FunctionConfig";
    private InitConfigBean mInitConfig;

    private FunctionConfig() {
    }

    private synchronized void getLocalInitConfig() {
        String str;
        String str2;
        try {
            if (this.mInitConfig == null) {
                String strD = hja.c().d(init_config_key);
                if (strD == null || strD.length() <= 0) {
                    str = this.TAG;
                    str2 = "获取本地InitConfig 失败";
                } else {
                    try {
                        this.mInitConfig = (InitConfigBean) JSON.parseObject(strD, InitConfigBean.class);
                    } catch (Throwable unused) {
                        str = this.TAG;
                        str2 = "获取本地InitConfig 失败 e";
                        ALog.e(str, str2);
                    }
                }
                ALog.e(str, str2);
            }
        } catch (Throwable unused2) {
        }
    }

    public static FunctionConfig instance() {
        return instance;
    }

    public String getExpand(String str) {
        getLocalInitConfig();
        if (str != null && str.length() != 0) {
            for (PlatformInfoBean platformInfoBean : this.mInitConfig.getPlatformInfoList()) {
                if (str.equals(platformInfoBean.getPlatformType())) {
                    return platformInfoBean.getExpand();
                }
            }
        }
        return null;
    }

    public int getFirstPosInfoPrice(String str) {
        InitConfigBean initConfigBean;
        getLocalInitConfig();
        if (str != null && str.length() != 0 && (initConfigBean = this.mInitConfig) != null) {
            for (PosInfoBean posInfoBean : initConfigBean.getPosInfoList()) {
                if (str.equals(posInfoBean.getPosId()) && (AdPlatforms.channel.name().equals(posInfoBean.getPosPlatform()) || AdPlatforms.zhike.name().equals(posInfoBean.getPosPlatform()))) {
                    ALog.i(this.TAG, "当前 price 渠道" + posInfoBean.getPosPlatform() + "--" + posInfoBean.getPrice());
                    return posInfoBean.getPrice();
                }
            }
        }
        return 0;
    }

    public List<PlatformInfoBean> getPlatformInfo() {
        getLocalInitConfig();
        InitConfigBean initConfigBean = this.mInitConfig;
        if (initConfigBean != null) {
            return initConfigBean.getPlatformInfoList();
        }
        return null;
    }

    public PosInfoBean getPosInfo(String str, String str2) {
        InitConfigBean initConfigBean;
        getLocalInitConfig();
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0 && (initConfigBean = this.mInitConfig) != null) {
            for (PosInfoBean posInfoBean : initConfigBean.getPosInfoList()) {
                if (str.equals(posInfoBean.getPosId()) && str2.equals(posInfoBean.getPosPlatform())) {
                    lva.a(posInfoBean);
                    return posInfoBean;
                }
            }
        }
        return null;
    }

    public List<PosInfoBean> getPosInfo(String str) {
        getLocalInitConfig();
        LinkedList linkedList = null;
        if (str != null && str.length() != 0 && this.mInitConfig != null) {
            linkedList = new LinkedList();
            for (PosInfoBean posInfoBean : this.mInitConfig.getPosInfoList()) {
                if (str.equals(posInfoBean.getPosId())) {
                    linkedList.add(posInfoBean);
                }
                lva.a(posInfoBean);
            }
        }
        return linkedList;
    }

    public List<ReportInfoBean> getReportInfo(String str) {
        getLocalInitConfig();
        if (this.mInitConfig == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ReportInfoBean reportInfoBean : this.mInitConfig.getReportInfoList()) {
            if (str.equals(reportInfoBean.getPlatformType())) {
                linkedList.add(reportInfoBean);
            }
        }
        return linkedList;
    }

    public boolean isWebApkDownload(String str) {
        List<PlatformInfoBean> platformInfo = getPlatformInfo();
        if (platformInfo != null && platformInfo.size() != 0) {
            for (PlatformInfoBean platformInfoBean : platformInfo) {
                if (platformInfoBean.getDownload() != null && platformInfoBean.getPlatformType().equals(str)) {
                    return !platformInfoBean.getDownload().equals("no");
                }
            }
        }
        return false;
    }

    public void saveInitConfig(InitConfigBean initConfigBean) {
        if (initConfigBean != null) {
            try {
                this.mInitConfig = initConfigBean;
                hja.c().b(init_config_key, JSON.toJSONString(initConfigBean));
                ALog.i(this.TAG, "保存本地InitConfig 数据");
            } catch (Throwable unused) {
            }
        }
    }
}
