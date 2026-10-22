package com.byazt.jzl;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.huawei.hms.adapter.internal.CommonCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1574, 15})
public class uj implements com.byazt.fk.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28716a;
    public int c;
    public String da;
    public String i;
    public String n;
    public double sl;
    public String sp;
    public int t;
    public int tt;
    public int u;
    public double uj;
    public long ve;
    public String x;
    public float yp = -1.0f;
    public int z = 0;
    public int m = 0;
    public int nu = 0;
    public int rh = 0;
    public int my = 307200;
    public int gt = 1;

    @Override // com.byazt.fk.n
    public int getCover_height() {
        return this.c;
    }

    @Override // com.byazt.fk.n
    public String getCover_url() {
        return this.f28716a;
    }

    @Override // com.byazt.fk.n
    public int getCover_width() {
        return this.tt;
    }

    @Override // com.byazt.fk.n
    public String getEndcard() {
        return this.x;
    }

    @Override // com.byazt.fk.n
    public int getEndcardRender() {
        return this.u;
    }

    @Override // com.byazt.fk.n
    public int getExecuteCachedType() {
        return this.rh;
    }

    @Override // com.byazt.fk.n
    public int getFallbackEndCardJudge() {
        return this.t;
    }

    @Override // com.byazt.fk.n
    public String getFileHash() {
        if (TextUtils.isEmpty(this.da)) {
            this.da = com.byazt.lt.c.c(this.sp);
        }
        return this.da;
    }

    @Override // com.byazt.fk.n
    public float getPlay_speed_ratio() {
        return this.yp;
    }

    @Override // com.byazt.fk.n
    public int getPlayableLoadingHide() {
        return this.m;
    }

    @Override // com.byazt.fk.n
    public int getPlayableLoadingShow() {
        return this.z;
    }

    @Override // com.byazt.fk.n
    public String getPlayableZipUrl() {
        return this.i;
    }

    @Override // com.byazt.fk.n
    public int getReplayTime() {
        return this.gt;
    }

    @Override // com.byazt.fk.n
    public String getResolution() {
        return this.n;
    }

    @Override // com.byazt.fk.n
    public int getRewardVideoCachedType() {
        return this.nu;
    }

    @Override // com.byazt.fk.n
    public long getSize() {
        return this.ve;
    }

    @Override // com.byazt.fk.n
    public double getStart() {
        return this.sl;
    }

    @Override // com.byazt.fk.n
    public int getVideoPreloadSize() {
        if (this.my < 0) {
            this.my = 307200;
        }
        long j = this.my;
        long j2 = this.ve;
        if (j > j2) {
            this.my = (int) j2;
        }
        return this.my;
    }

    @Override // com.byazt.fk.n
    public double getVideo_duration() {
        return this.uj;
    }

    @Override // com.byazt.fk.n
    public String getVideo_url() {
        return this.sp;
    }

    @Override // com.byazt.fk.n
    public int[] getWidthAndHeight() {
        try {
            int iIndexOf = this.n.indexOf("x");
            return new int[]{Integer.parseInt(this.n.substring(0, iIndexOf).trim()), Integer.parseInt(this.n.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.byazt.lt.tt.ve("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    @Override // com.byazt.fk.n
    public boolean isCacheAllVideo() {
        return this.nu == 0;
    }

    @Override // com.byazt.fk.n
    public boolean isExecCallbackWhenFail() {
        return this.rh == 1;
    }

    @Override // com.byazt.fk.n
    public void setCover_height(int i) {
        this.c = i;
    }

    @Override // com.byazt.fk.n
    public void setCover_url(String str) {
        this.f28716a = str;
    }

    @Override // com.byazt.fk.n
    public void setCover_width(int i) {
        this.tt = i;
    }

    @Override // com.byazt.fk.n
    public void setEndcard(String str) {
        this.x = str;
    }

    @Override // com.byazt.fk.n
    public void setEndcardRender(int i) {
        this.u = i;
    }

    @Override // com.byazt.fk.n
    public void setExecuteCachedType(int i) {
        this.rh = i;
    }

    @Override // com.byazt.fk.n
    public void setFallbackEndCardJudge(int i) {
        this.t = i;
    }

    @Override // com.byazt.fk.n
    public void setFileHash(String str) {
        this.da = str;
    }

    @Override // com.byazt.fk.n
    public void setPlay_speed_ratio(float f) {
        this.yp = f;
    }

    @Override // com.byazt.fk.n
    public void setPlayableLoadingHide(int i) {
        this.m = i;
    }

    @Override // com.byazt.fk.n
    public void setPlayableLoadingShow(int i) {
        this.z = i;
    }

    @Override // com.byazt.fk.n
    public void setPlayableZipUrl(String str) {
        this.i = str;
    }

    @Override // com.byazt.fk.n
    public void setReplayTime(int i) {
        this.gt = Math.min(4, Math.max(1, i));
    }

    @Override // com.byazt.fk.n
    public void setResolution(String str) {
        this.n = str;
    }

    @Override // com.byazt.fk.n
    public void setRewardVideoCachedType(int i) {
        this.nu = i;
    }

    @Override // com.byazt.fk.n
    public void setSize(long j) {
        this.ve = j;
    }

    @Override // com.byazt.fk.n
    public void setStart(double d) {
        this.sl = d;
    }

    @Override // com.byazt.fk.n
    public void setVideoPreloadSize(int i) {
        this.my = i;
    }

    @Override // com.byazt.fk.n
    public void setVideo_duration(double d) {
        this.uj = d;
    }

    @Override // com.byazt.fk.n
    public void setVideo_url(String str) {
        this.sp = str;
    }

    @Override // com.byazt.fk.n
    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", getCover_height());
            jSONObject.put("cover_url", getCover_url());
            jSONObject.put("cover_width", getCover_width());
            jSONObject.put("endcard", getEndcard());
            jSONObject.put("file_hash", getFileHash());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, getResolution());
            jSONObject.put("size", getSize());
            jSONObject.put(CropKey.VIDEO_DURATION, getVideo_duration());
            jSONObject.put("video_url", getVideo_url());
            jSONObject.put("playable_download_url", getPlayableZipUrl());
            jSONObject.put("if_playable_loading_show", getPlayableLoadingShow());
            jSONObject.put("remove_loading_page_type", getPlayableLoadingHide());
            jSONObject.put("fallback_endcard_judge", getFallbackEndCardJudge());
            jSONObject.put("video_preload_size", getVideoPreloadSize());
            jSONObject.put("reward_video_cached_type", getRewardVideoCachedType());
            jSONObject.put("execute_cached_type", getExecuteCachedType());
            jSONObject.put("endcard_render", getEndcardRender());
            jSONObject.put("replay_time", getReplayTime());
            jSONObject.put("play_speed_ratio", getPlay_speed_ratio());
            if (getStart() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                jSONObject.put("start", getStart());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
