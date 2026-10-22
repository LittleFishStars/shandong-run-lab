package com.kwad.sdk.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@KsJson
public class MediaMessageInfo extends com.kwad.sdk.commercial.c.a {
    public String Nq;
    public String bjd;
    public String bje;
    public int bjf;

    @KsJson
    public static class MediaPermissionInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 2237785211846936343L;
        public int canReadICCID;
        public int canReadInstalledPackages;
        public int canReadLocation;
        public int canReadMacAddress;
        public int canReadNearbyWifiList;
        public int canUseMacAddress;
        public int canUseNetworkState;
        public int canUseOaid;
        public int canUsePhoneState;
        public int canUseStoragePermission;
        public int getAndroidId;
        public int getImei;
        public int getImeis;
        public int getInstalledPackages;
        public int getKsLocation;
        public int getLocation;
        public int getMacAddress;
        public int getOaid;
    }

    public static MediaMessageInfo Sw() {
        return new MediaMessageInfo();
    }

    public final MediaMessageInfo fi(int i) {
        this.bjf = 2;
        return this;
    }

    public final MediaMessageInfo hh(String str) {
        this.Nq = str;
        return this;
    }

    public final MediaMessageInfo hi(String str) {
        this.bjd = str;
        return this;
    }

    public final MediaMessageInfo hj(String str) {
        this.bje = str;
        return this;
    }
}
