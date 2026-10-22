package com.fl.saas.util;

import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.fl.saas.common.util.DeviceStateUtil;
import com.fl.saas.config.utils.DeviceUtil;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TypeUtil {

    public static class TypeBean {
        private int type;
        private String value;

        public TypeBean(int i, String str) {
            this.type = i;
            this.value = str;
        }

        public int getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static TypeBean getType(double d) {
        boolean zIsDeveloperOptionsEnabled = DeviceStateUtil.isDeveloperOptionsEnabled(DeviceUtil.getContext());
        boolean zIsNetworkProxyEnabled = DeviceStateUtil.isNetworkProxyEnabled(DeviceUtil.getContext());
        boolean zIsVPNConnected = DeviceStateUtil.isVPNConnected(DeviceUtil.getContext());
        if (zIsDeveloperOptionsEnabled || zIsNetworkProxyEnabled || zIsVPNConnected) {
            return new TypeBean(1, "developer");
        }
        double dNextDouble = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE && d < 100.0d) {
            dNextDouble = new Random().nextDouble() * 100.0d;
            if (dNextDouble >= d) {
                return new TypeBean(0, "");
            }
        }
        return new TypeBean(1, dNextDouble + LoginConstants.UNDER_LINE + d);
    }
}
