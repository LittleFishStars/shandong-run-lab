package com.fl.saas;

import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.fl.saas.adx.util.DeviceStateUtil;
import com.fl.saas.adx.util.DeviceUtil;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class e1 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30160a;
        private String b;

        public a(int i, String str) {
            this.f30160a = i;
            this.b = str;
        }

        public int a() {
            return this.f30160a;
        }

        public String b() {
            return this.b;
        }
    }

    public static a a(double d) {
        boolean zIsDeveloperOptionsEnabled = DeviceStateUtil.isDeveloperOptionsEnabled(DeviceUtil.getContext());
        boolean zIsNetworkProxyEnabled = DeviceStateUtil.isNetworkProxyEnabled(DeviceUtil.getContext());
        boolean zIsVPNConnected = DeviceStateUtil.isVPNConnected(DeviceUtil.getContext());
        if (zIsDeveloperOptionsEnabled || zIsNetworkProxyEnabled || zIsVPNConnected) {
            return new a(1, "developer");
        }
        double dNextDouble = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE && d < 100.0d) {
            dNextDouble = new Random().nextDouble() * 100.0d;
            if (dNextDouble >= d) {
                return new a(0, "");
            }
        }
        return new a(1, dNextDouble + LoginConstants.UNDER_LINE + d);
    }
}
