package cn.hzjizhun.admin.api;

import android.text.TextUtils;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.api.bean.ChannelUrlBean;
import cn.hzjizhun.admin.api.bean.InitConfigBean;
import cn.hzjizhun.admin.api.bean.PlatformInfoBean;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.api.bean.ReportInfoBean;
import cn.hzjizhun.admin.dsad;
import cn.hzjizhun.admin.util.ALog;
import com.zj.adlib.eva;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FunctionConfig {
    private static final String init_base_url_key = "init_base_url";
    private static final String init_config_key = "init_config";
    private static FunctionConfig instance = new FunctionConfig();
    private static HashMap<String, String> mChannelUrlMap;
    private InitConfigBean mInitConfig;
    private String TAG = "FunctionConfig";
    private HashMap<String, Boolean> mInitResults = new HashMap<>();

    private FunctionConfig() {
    }

    public static FunctionConfig instance() {
        return instance;
    }

    private static void parseChannelUrlList(List<ChannelUrlBean> list) {
        if (list == null || list.size() <= 0) {
            ALog.e("", "parseChannelUrlList list is empty");
            return;
        }
        mChannelUrlMap = new HashMap<>();
        for (ChannelUrlBean channelUrlBean : list) {
            String name = channelUrlBean.getName();
            String baseUrl = channelUrlBean.getBaseUrl();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(baseUrl)) {
                ALog.e("", "parseChannelUrlList name or url is empty,name" + name + "--url: " + baseUrl);
                return;
            }
            mChannelUrlMap.put(name, baseUrl);
        }
    }

    public String getBaseUrl() {
        try {
            return eva.e().c(init_base_url_key);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getChannelUrl(String str) {
        HashMap<String, String> map;
        if (TextUtils.isEmpty(str) || (map = mChannelUrlMap) == null || TextUtils.isEmpty(map.get(str))) {
            return (TextUtils.isEmpty(str) || !str.equals(AdPlatforms.inner.name())) ? "https://ad.shunchangzhixing.com" : "https://inner.shunchangzhixing.com";
        }
        return mChannelUrlMap.get(str);
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

    public boolean getInitResult(String str) {
        try {
            return this.mInitResults.get(str).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public synchronized void getLocalInitConfig() {
        try {
            if (this.mInitConfig == null) {
                String strC = eva.e().c(init_config_key);
                if (TextUtils.isEmpty(strC)) {
                    ALog.e(this.TAG, "获取本地InitConfig 失败");
                    return;
                }
                InitConfigBean bean = InitConfigBean.toBean(strC);
                this.mInitConfig = bean;
                List<PlatformInfoBean> platformInfoList = bean.getPlatformInfoList();
                if (platformInfoList != null && !platformInfoList.isEmpty()) {
                    List<PosInfoBean> posInfoList = this.mInitConfig.getPosInfoList();
                    if (posInfoList != null && !posInfoList.isEmpty()) {
                        List<ChannelUrlBean> channelUrlList = this.mInitConfig.getChannelUrlList();
                        if (channelUrlList != null && !channelUrlList.isEmpty()) {
                            parseChannelUrlList(channelUrlList);
                            return;
                        }
                        this.mInitConfig = null;
                        return;
                    }
                    this.mInitConfig = null;
                    return;
                }
                this.mInitConfig = null;
            }
        } catch (Throwable unused) {
        }
    }

    public List<PlatformInfoBean> getPlatformInfo() {
        getLocalInitConfig();
        InitConfigBean initConfigBean = this.mInitConfig;
        if (initConfigBean != null) {
            return initConfigBean.getPlatformInfoList();
        }
        return null;
    }

    public List<PosInfoBean> getPosInfo(String str) {
        getLocalInitConfig();
        if (TextUtils.isEmpty(str) || this.mInitConfig == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (PosInfoBean posInfoBean : this.mInitConfig.getPosInfoList()) {
            if (str.equals(posInfoBean.getPosId())) {
                linkedList.add(posInfoBean);
            }
            dsad.a(posInfoBean);
        }
        return linkedList;
    }

    public List<String> getQList() {
        getLocalInitConfig();
        InitConfigBean initConfigBean = this.mInitConfig;
        if (initConfigBean != null) {
            return initConfigBean.getqAppList();
        }
        return null;
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

    public boolean hasInitData() {
        return this.mInitConfig != null;
    }

    public boolean isShowSecondarySureDialog(String str) {
        List<PlatformInfoBean> platformInfo = getPlatformInfo();
        if (platformInfo != null && platformInfo.size() != 0) {
            for (PlatformInfoBean platformInfoBean : platformInfo) {
                if (platformInfoBean.getTip() != null && platformInfoBean.getPlatformType().equals(str)) {
                    return !platformInfoBean.getTip().equals("no");
                }
            }
        }
        return false;
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

    public void saveBaseUrl(String str) {
        try {
            eva.e().b(init_base_url_key, str);
        } catch (Throwable unused) {
        }
    }

    public void saveInitConfig(String str) {
        try {
            eva.e().b(init_config_key, str);
        } catch (Throwable unused) {
        }
    }

    public void setInitResult(String str, boolean z) {
        try {
            this.mInitResults.put(str, Boolean.valueOf(z));
        } catch (Throwable unused) {
        }
    }

    public String getExpand() {
        getLocalInitConfig();
        Iterator<PlatformInfoBean> it = this.mInitConfig.getPlatformInfoList().iterator();
        while (it.hasNext()) {
            String expand = it.next().getExpand();
            if (!TextUtils.isEmpty(expand)) {
                return expand;
            }
        }
        return null;
    }

    public PosInfoBean getPosInfo(String str, String str2) {
        InitConfigBean initConfigBean;
        getLocalInitConfig();
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0 && (initConfigBean = this.mInitConfig) != null) {
            for (PosInfoBean posInfoBean : initConfigBean.getPosInfoList()) {
                if (str.equals(posInfoBean.getPosId()) && str2.equals(posInfoBean.getPosPlatform())) {
                    dsad.a(posInfoBean);
                    return posInfoBean;
                }
            }
        }
        return null;
    }
}
