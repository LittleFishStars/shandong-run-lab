package com.bytedance.sdk.openadsdk.mediation.manager;

import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME})
public class MediationAdEcpmInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29316a;
    private String c;
    private String da;
    private String i;
    private String m;
    private String n;
    private Map<String, String> nu;
    private String sl;
    private String sp;
    private String t;
    private String tt;
    private String u;
    private String uj;
    private String ve;
    private String x;
    private String yp;
    private String z;

    public MediationAdEcpmInfo() {
        this.nu = new HashMap();
    }

    public String getAbTestId() {
        return this.yp;
    }

    public String getChannel() {
        return this.t;
    }

    public Map<String, String> getCustomData() {
        return this.nu;
    }

    public String getCustomSdkName() {
        return this.tt;
    }

    public String getDiscount() {
        return this.m;
    }

    public String getEcpm() {
        return this.n;
    }

    public String getErrorMsg() {
        return this.sp;
    }

    public String getLevelTag() {
        return this.uj;
    }

    public int getReqBiddingType() {
        return this.f29316a;
    }

    public String getRequestId() {
        return this.x;
    }

    public String getRitType() {
        return this.i;
    }

    public String getScenarioId() {
        return this.z;
    }

    public String getSdkName() {
        return this.c;
    }

    public String getSegmentId() {
        return this.sl;
    }

    public String getSlotId() {
        return this.ve;
    }

    public String getSubChannel() {
        return this.u;
    }

    public String getSubRitType() {
        return this.da;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map, String str15) {
        HashMap map2 = new HashMap();
        this.nu = map2;
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        this.uj = str4;
        this.n = str5;
        this.f29316a = i;
        this.sp = str6;
        this.x = str7;
        this.i = str8;
        this.da = str9;
        this.sl = str10;
        this.t = str11;
        this.u = str12;
        this.yp = str13;
        this.z = str14;
        this.m = str15;
        if (map != null) {
            this.nu = map;
        } else {
            map2.clear();
        }
    }
}
