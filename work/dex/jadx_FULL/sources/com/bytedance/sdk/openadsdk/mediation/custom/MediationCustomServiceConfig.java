package com.bytedance.sdk.openadsdk.mediation.custom;

import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 1625})
public final class MediationCustomServiceConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f29312a = new HashMap();
    private String c;
    private String n;
    private String tt;
    private int uj;
    private int ve;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.c = str;
        this.tt = str2;
        this.ve = i;
        this.uj = i2;
        this.n = str3;
    }

    public String getADNNetworkName() {
        return this.c;
    }

    public String getADNNetworkSlotId() {
        return this.tt;
    }

    public int getAdStyleType() {
        return this.ve;
    }

    public String getCustomAdapterJson() {
        return this.n;
    }

    public Map<String, Object> getExtraData() {
        return this.f29312a;
    }

    public int getSubAdtype() {
        return this.uj;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.c + "', mADNNetworkSlotId='" + this.tt + "', mAdStyleType=" + this.ve + ", mSubAdtype=" + this.uj + ", mCustomAdapterJson='" + this.n + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.c = valueSet.stringValue(8003);
            this.tt = valueSet.stringValue(2);
            this.ve = valueSet.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
            this.uj = valueSet.intValue(8094);
            this.n = valueSet.stringValue(8547);
            Map<? extends String, ? extends Object> map = (Map) valueSet.objectValue(8075, Map.class);
            if (map == null || map.size() <= 0) {
                return;
            }
            this.f29312a.putAll(map);
        }
    }
}
