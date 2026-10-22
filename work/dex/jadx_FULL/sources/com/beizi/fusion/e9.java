package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.GlobalConfig;
import com.beizi.fusion.model.IncentiveConfig;
import com.beizi.fusion.model.ResponseInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27230a;
    private boolean b = true;

    public e9(Context context, String str) {
        if (str == null) {
            return;
        }
        this.f27230a = context;
        a(str);
    }

    private void a(String str) {
        try {
            String strA = i2.a(qg.b(), str);
            if (TextUtils.isEmpty(strA)) {
                this.b = false;
                return;
            }
            String strB = t8.b(strA);
            if (!TextUtils.isEmpty(strB) && !strB.equalsIgnoreCase("null")) {
                String str2 = (String) co.a(this.f27230a, "globalConfig", (Object) "");
                if (TextUtils.isEmpty(str2)) {
                    co.b(this.f27230a, "globalConfig", i2.b(qg.b(), strB));
                }
                String strA2 = i2.a(qg.b(), str2);
                GlobalConfig globalConfigObjectFromData = GlobalConfig.objectFromData(strB);
                GlobalConfig globalConfigObjectFromData2 = GlobalConfig.objectFromData(strA2);
                if (globalConfigObjectFromData != null) {
                    ResponseInfo.getInstance(this.f27230a).setGlobalConfig(globalConfigObjectFromData);
                    if (!TextUtils.isEmpty(globalConfigObjectFromData.getConfigVersion())) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setConfigVersion(globalConfigObjectFromData.getConfigVersion());
                        }
                        if (ResponseInfo.getInstance(this.f27230a).getManager() == null) {
                            ResponseInfo.getInstance(this.f27230a).setConfigVersion(globalConfigObjectFromData.getConfigVersion());
                        }
                    }
                    if (globalConfigObjectFromData.getExpireTime() > 0) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setExpireTime(globalConfigObjectFromData.getExpireTime());
                        }
                        ResponseInfo.getInstance(this.f27230a).setExpireTime(globalConfigObjectFromData.getExpireTime());
                    }
                    if (globalConfigObjectFromData.getMaxValidTime() > 0) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setMaxValidTime(globalConfigObjectFromData.getMaxValidTime());
                        }
                        ResponseInfo.getInstance(this.f27230a).setMaxValidTime(globalConfigObjectFromData.getMaxValidTime());
                    }
                    if (globalConfigObjectFromData.getConfigurator() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setConfigurator(globalConfigObjectFromData.getConfigurator());
                        }
                        if (ResponseInfo.getInstance(this.f27230a).getManager() == null) {
                            ResponseInfo.getInstance(this.f27230a).setConfigurator(globalConfigObjectFromData.getConfigurator());
                        }
                    }
                    if (globalConfigObjectFromData.getMessenger() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setMessenger(globalConfigObjectFromData.getMessenger());
                        }
                        if (ResponseInfo.getInstance(this.f27230a).getManager() == null) {
                            ResponseInfo.getInstance(this.f27230a).setMessenger(globalConfigObjectFromData.getMessenger());
                        }
                    }
                    if (globalConfigObjectFromData.getManager() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setManager(globalConfigObjectFromData.getManager());
                        }
                        if (ResponseInfo.getInstance(this.f27230a).getManager() == null) {
                            ResponseInfo.getInstance(this.f27230a).setManager(globalConfigObjectFromData.getManager());
                        }
                    }
                    if (globalConfigObjectFromData.getTaskConfig() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setTaskConfig(globalConfigObjectFromData.getTaskConfig());
                        }
                        ResponseInfo.getInstance(this.f27230a).setTaskConfig(globalConfigObjectFromData.getTaskConfig());
                    }
                    if (globalConfigObjectFromData.getAdPlusConfig() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setAdPlusConfig(globalConfigObjectFromData.getAdPlusConfig());
                        }
                        ResponseInfo.getInstance(this.f27230a).setAdPlusConfig(globalConfigObjectFromData.getAdPlusConfig());
                        vq.a(this.f27230a);
                    }
                    IncentiveConfig incentiveConfig = globalConfigObjectFromData.getIncentiveConfig();
                    if (incentiveConfig != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setIncentiveConfig(incentiveConfig);
                        }
                        ResponseInfo.getInstance(this.f27230a).setIncentiveConfig(incentiveConfig);
                    }
                    if (!TextUtils.isEmpty(globalConfigObjectFromData.getCrashUrl())) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setCrashUrl(globalConfigObjectFromData.getCrashUrl());
                        }
                        ResponseInfo.getInstance(this.f27230a).setCrashUrl(globalConfigObjectFromData.getCrashUrl());
                    }
                    String strObjectToJson = GlobalConfig.objectToJson(globalConfigObjectFromData2);
                    if (TextUtils.isEmpty(strObjectToJson)) {
                        return;
                    }
                    co.b(this.f27230a, "globalConfig", i2.b(qg.b(), strObjectToJson));
                    return;
                }
                return;
            }
            this.b = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a() {
        return this.b;
    }
}
