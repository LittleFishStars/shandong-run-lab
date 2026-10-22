package com.byazt.yhr;

import com.byazt.lz.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, 20})
public class c implements com.byazt.lz.c {
    public final com.byazt.dj.uj c;
    public com.byazt.lz.uj tt;
    public da ve;

    public c(com.byazt.dj.uj ujVar) {
        this.c = ujVar;
    }

    @Override // com.byazt.lz.c
    public boolean alist() {
        return this.c.alist();
    }

    @Override // com.byazt.lz.c
    public String getAndroidId() {
        return this.c.getAndroidId();
    }

    @Override // com.byazt.lz.c
    public String getDevImei() {
        return this.c.getDevImei();
    }

    @Override // com.byazt.lz.c
    public String getDevOaid() {
        return this.c.getDevOaid();
    }

    @Override // com.byazt.lz.c
    public String getMacAddress() {
        return this.c.getMacAddress();
    }

    @Override // com.byazt.lz.c
    public da getMediationPrivacyConfig() {
        if (this.ve == null) {
            com.byazt.je.tt mediationPrivacyConfig = this.c.getMediationPrivacyConfig();
            if (mediationPrivacyConfig == null) {
                return null;
            }
            this.ve = new uj(mediationPrivacyConfig);
        }
        return this.ve;
    }

    @Override // com.byazt.lz.c
    public com.byazt.lz.uj getTTLocation() {
        if (this.tt == null) {
            final com.byazt.dj.ve tTLocation = this.c.getTTLocation();
            if (tTLocation == null) {
                return null;
            }
            this.tt = new com.byazt.lz.uj() { // from class: com.byazt.yhr.c.1
                @Override // com.byazt.lz.uj
                public double getLatitude() {
                    return tTLocation.c();
                }

                @Override // com.byazt.lz.uj
                public double getLongitude() {
                    return tTLocation.tt();
                }
            };
        }
        return this.tt;
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseAndroidId() {
        return this.c.isCanUseAndroidId();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseLocation() {
        return this.c.isCanUseLocation();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseMessage() {
        return this.c.isCanUseMessage();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUsePermissionRecordAudio() {
        return this.c.isCanUsePermissionRecordAudio();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUsePhoneState() {
        return this.c.isCanUsePhoneState();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseWifiState() {
        return this.c.isCanUseWifiState();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseWriteExternal() {
        return this.c.isCanUseWriteExternal();
    }

    @Override // com.byazt.lz.c
    public Map<String, Object> userPrivacyConfig() {
        return this.c.userPrivacyConfig();
    }
}
