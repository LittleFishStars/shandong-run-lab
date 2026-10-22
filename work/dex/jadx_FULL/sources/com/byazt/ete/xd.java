package com.byazt.ete;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.huawei.hms.adapter.internal.CommonCode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 520})
public class xd {
    public com.byazt.jzl.uj c;
    public com.byazt.jzl.uj tt;
    public com.byazt.jzl.c ve;

    public xd() {
    }

    public static boolean a(ic icVar) {
        return icVar != null && icVar.xx() == 1 && com.byazt.omf.p.n() && icVar.hc() == 1 && m(icVar) != null;
    }

    public static int da(ic icVar) {
        if (my(icVar) == null) {
            return 413;
        }
        if (TextUtils.isEmpty(c(icVar))) {
            return 414;
        }
        return TextUtils.isEmpty(tt(icVar)) ? 415 : 200;
    }

    public static String i(ic icVar) {
        com.byazt.jzl.uj ujVar;
        xd xdVarMy = my(icVar);
        return (xdVarMy == null || (ujVar = xdVarMy.c) == null) ? "" : ujVar.getEndcard();
    }

    public static com.byazt.jzl.uj m(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return null;
        }
        return xdVarMy.tt;
    }

    private static xd my(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.o();
    }

    public static int[] n(ic icVar) {
        if (icVar == null) {
            return null;
        }
        if (icVar.id() == 166 && bx.c(icVar)) {
            return new int[]{bx.t(icVar), bx.u(icVar)};
        }
        com.byazt.jzl.uj ujVarM = m(icVar);
        if (a(icVar) && ujVarM != null) {
            return ujVarM.getWidthAndHeight();
        }
        com.byazt.jzl.uj ujVarZ = z(icVar);
        if (ujVarZ != null) {
            return ujVarZ.getWidthAndHeight();
        }
        return null;
    }

    public static com.byazt.jzl.c nu(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return null;
        }
        return xdVarMy.ve;
    }

    public static com.byazt.jzl.a rh(ic icVar) {
        xd xdVarO;
        com.byazt.jzl.a aVarC = c(4, icVar);
        aVarC.setAudio(true);
        if (icVar != null && (xdVarO = icVar.o()) != null) {
            com.byazt.fk.n currentVideoInfo = aVarC.getCurrentVideoInfo();
            com.byazt.jzl.c cVar = xdVarO.ve;
            if (cVar != null && currentVideoInfo != null) {
                currentVideoInfo.setVideo_url(cVar.n());
                currentVideoInfo.setRewardVideoCachedType(0);
                currentVideoInfo.setVideoPreloadSize(0);
                currentVideoInfo.setFileHash(xdVarO.ve.tt());
                currentVideoInfo.setSize(xdVarO.ve.ve());
                currentVideoInfo.setStart(xdVarO.ve.uj());
                currentVideoInfo.setVideo_duration(xdVarO.ve.a() * ((double) (xdVarO.ve.sp() + 1)));
            }
        }
        return aVarC;
    }

    public static boolean sl(ic icVar) {
        com.byazt.jzl.uj ujVar;
        xd xdVarMy = my(icVar);
        return (xdVarMy == null || (ujVar = xdVarMy.c) == null || ujVar.getFallbackEndCardJudge() != 1) ? false : true;
    }

    public static double sp(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (!com.byazt.ex.c.c(icVar)) {
            if (com.byazt.bzd.t.c(icVar)) {
                return ((int) nu(icVar).a()) * (nu(icVar).sp() + 1);
            }
            com.byazt.jzl.uj ujVar = xdVarMy.c;
            return ujVar == null ? AudioStats.AUDIO_AMPLITUDE_NONE : ujVar.getVideo_duration();
        }
        int iTt = bx.tt(icVar);
        com.byazt.dj.tt ttVarIj = icVar.ij();
        if (ttVarIj != null && ttVarIj.gt() == 9) {
            iTt *= 2;
        }
        return iTt;
    }

    public static boolean t(ic icVar) {
        xd xdVarMy = my(icVar);
        return (xdVarMy == null || xdVarMy.ve == null) ? false : true;
    }

    public static String tt(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return "";
        }
        if (com.byazt.ex.c.c(icVar)) {
            return bx.x(icVar);
        }
        com.byazt.jzl.uj ujVar = xdVarMy.c;
        return ujVar == null ? "" : ujVar.getCover_url();
    }

    public static boolean u(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return false;
        }
        return xdVarMy.c.isExecCallbackWhenFail();
    }

    public static int uj(ic icVar) {
        com.byazt.jzl.uj ujVar;
        xd xdVarMy = my(icVar);
        if (xdVarMy == null || (ujVar = xdVarMy.c) == null) {
            return 0;
        }
        return ujVar.getCover_width();
    }

    public static int ve(ic icVar) {
        com.byazt.jzl.uj ujVar;
        xd xdVarMy = my(icVar);
        if (xdVarMy == null || (ujVar = xdVarMy.c) == null) {
            return 0;
        }
        return ujVar.getCover_height();
    }

    public static String x(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return "";
        }
        if (com.byazt.ex.c.c(icVar)) {
            return com.byazt.lt.c.c(bx.sp(icVar));
        }
        return com.byazt.bzd.t.c(icVar) ? nu(icVar).tt() : xdVarMy.c.getFileHash();
    }

    public static com.byazt.jzl.uj yp(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return null;
        }
        com.byazt.jzl.uj ujVar = new com.byazt.jzl.uj();
        com.byazt.jzl.uj ujVar2 = xdVarMy.c;
        if (ujVar2 != null) {
            ujVar.setCover_height(ujVar2.getCover_height());
            ujVar.setCover_width(xdVarMy.c.getCover_width());
            ujVar.setResolution(xdVarMy.c.getResolution());
            ujVar.setSize(xdVarMy.c.getSize());
            ujVar.setVideo_duration(xdVarMy.c.getVideo_duration());
            ujVar.setCover_url(xdVarMy.c.getCover_url());
            ujVar.setVideo_url(xdVarMy.c.getVideo_url());
            ujVar.setEndcard(xdVarMy.c.getEndcard());
            ujVar.setFileHash(xdVarMy.c.getFileHash());
            ujVar.setFallbackEndCardJudge(xdVarMy.c.getFallbackEndCardJudge());
            ujVar.setVideoPreloadSize(xdVarMy.c.getVideoPreloadSize());
            ujVar.setRewardVideoCachedType(xdVarMy.c.getRewardVideoCachedType());
            ujVar.setExecuteCachedType(xdVarMy.c.getExecuteCachedType());
            ujVar.setPlay_speed_ratio(xdVarMy.c.getPlay_speed_ratio());
            ujVar.setStart(xdVarMy.c.getStart());
        }
        if (com.byazt.ex.c.c(icVar)) {
            ujVar.setCover_url(bx.x(icVar));
            ujVar.setVideo_url(bx.sp(icVar));
            ujVar.setFileHash(com.byazt.lt.c.c(bx.sp(icVar)));
            ujVar.setSize(-1L);
            ujVar.setVideo_duration(bx.tt(icVar));
            ujVar.setVideoPreloadSize(0);
            ujVar.setRewardVideoCachedType(1);
        }
        if (com.byazt.bzd.t.c(icVar)) {
            ujVar.setVideo_url(xdVarMy.ve.n());
            ujVar.setRewardVideoCachedType(0);
            ujVar.setVideoPreloadSize(0);
            ujVar.setFileHash(xdVarMy.ve.tt());
            ujVar.setSize(xdVarMy.ve.ve());
            ujVar.setStart(xdVarMy.ve.uj());
            ujVar.setVideo_duration(xdVarMy.ve.a() * ((double) (xdVarMy.ve.sp() + 1)));
        }
        return ujVar;
    }

    public static com.byazt.jzl.uj z(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return null;
        }
        com.byazt.jzl.uj ujVar = xdVarMy.c;
        if (ujVar != null) {
            return ujVar;
        }
        if (com.byazt.bzd.t.c(icVar) && pu.tt(icVar) == 3) {
            return ujVar;
        }
        if (!com.byazt.bzd.t.c(icVar)) {
            return xdVarMy.c;
        }
        com.byazt.jzl.uj ujVar2 = new com.byazt.jzl.uj();
        if (com.byazt.bzd.t.c(icVar)) {
            ujVar2.setVideo_url(xdVarMy.ve.n());
            ujVar2.setRewardVideoCachedType(0);
            ujVar2.setVideoPreloadSize(0);
            ujVar2.setFileHash(xdVarMy.ve.tt());
            ujVar2.setSize(xdVarMy.ve.ve());
            ujVar2.setVideo_duration(xdVarMy.ve.a() * ((double) (xdVarMy.ve.sp() + 1)));
        }
        xdVarMy.c = ujVar2;
        return ujVar2;
    }

    public void c(JSONObject jSONObject) {
        try {
            com.byazt.jzl.uj ujVar = this.c;
            if (ujVar != null) {
                jSONObject.put("video", ujVar.toJsonObj());
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        try {
            com.byazt.jzl.uj ujVar2 = this.tt;
            if (ujVar2 != null) {
                jSONObject.put("h265_video", ujVar2.toJsonObj());
            }
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
        try {
            com.byazt.jzl.c cVar = this.ve;
            if (cVar != null) {
                jSONObject.put("audio", cVar.c());
            }
        } catch (JSONException e3) {
            com.byazt.nr.m.c(e3);
        }
    }

    public xd(JSONObject jSONObject) {
        String str;
        xd xdVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject != null) {
            com.byazt.jzl.uj ujVar = new com.byazt.jzl.uj();
            ujVar.setCover_height(jSONObjectOptJSONObject.optInt("cover_height"));
            ujVar.setCover_width(jSONObjectOptJSONObject.optInt("cover_width"));
            ujVar.setResolution(jSONObjectOptJSONObject.optString(CommonCode.MapKey.HAS_RESOLUTION));
            ujVar.setSize(jSONObjectOptJSONObject.optLong("size"));
            ujVar.setVideo_duration(jSONObjectOptJSONObject.optDouble(CropKey.VIDEO_DURATION));
            ujVar.setCover_url(jSONObjectOptJSONObject.optString("cover_url"));
            ujVar.setVideo_url(jSONObjectOptJSONObject.optString("video_url"));
            ujVar.setEndcard(jSONObjectOptJSONObject.optString("endcard"));
            ujVar.setFileHash(jSONObjectOptJSONObject.optString("file_hash"));
            ujVar.setPlay_speed_ratio((float) jSONObjectOptJSONObject.optDouble("play_speed_ratio", -1.0d));
            ujVar.setFallbackEndCardJudge(jSONObjectOptJSONObject.optInt("fallback_endcard_judge", 0));
            ujVar.setVideoPreloadSize(jSONObjectOptJSONObject.optInt("video_preload_size", 307200));
            ujVar.setRewardVideoCachedType(jSONObjectOptJSONObject.optInt("reward_video_cached_type", 0));
            ujVar.setExecuteCachedType(jSONObjectOptJSONObject.optInt("execute_cached_type", 0));
            ujVar.setStart(jSONObjectOptJSONObject.optDouble("start", -1.0d));
            xdVar = this;
            str = "size";
            xdVar.c = ujVar;
        } else {
            str = "size";
            xdVar = this;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject2 != null) {
            com.byazt.jzl.uj ujVar2 = new com.byazt.jzl.uj();
            ujVar2.setCover_height(jSONObjectOptJSONObject2.optInt("cover_height"));
            ujVar2.setCover_width(jSONObjectOptJSONObject2.optInt("cover_width"));
            ujVar2.setResolution(jSONObjectOptJSONObject2.optString(CommonCode.MapKey.HAS_RESOLUTION));
            ujVar2.setSize(jSONObjectOptJSONObject2.optLong(str));
            ujVar2.setVideo_duration(jSONObjectOptJSONObject2.optDouble(CropKey.VIDEO_DURATION));
            ujVar2.setCover_url(jSONObjectOptJSONObject2.optString("cover_url"));
            ujVar2.setVideo_url(jSONObjectOptJSONObject2.optString("video_url"));
            ujVar2.setEndcard(jSONObjectOptJSONObject2.optString("endcard"));
            ujVar2.setFileHash(jSONObjectOptJSONObject2.optString("file_hash"));
            ujVar2.setPlay_speed_ratio((float) jSONObjectOptJSONObject2.optDouble("play_speed_ratio", -1.0d));
            ujVar2.setFallbackEndCardJudge(jSONObjectOptJSONObject2.optInt("fallback_endcard_judge", 0));
            ujVar2.setVideoPreloadSize(jSONObjectOptJSONObject2.optInt("video_preload_size", 307200));
            ujVar2.setRewardVideoCachedType(jSONObjectOptJSONObject2.optInt("reward_video_cached_type", 0));
            ujVar2.setExecuteCachedType(jSONObjectOptJSONObject2.optInt("execute_cached_type", 0));
            ujVar2.setStart(jSONObjectOptJSONObject2.optDouble("start", -1.0d));
            xdVar.tt = ujVar2;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("audio");
        if (jSONObjectOptJSONObject3 != null) {
            com.byazt.jzl.c cVar = new com.byazt.jzl.c();
            cVar.tt(jSONObjectOptJSONObject3.optString("audio_url"));
            cVar.c(jSONObjectOptJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            cVar.tt(jSONObjectOptJSONObject3.optLong("audio_preload_size", -2147483648L));
            cVar.c(jSONObjectOptJSONObject3.optLong(str, -2147483648L));
            cVar.c(jSONObjectOptJSONObject3.optString("file_hash"));
            cVar.tt(jSONObjectOptJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            cVar.c(jSONObjectOptJSONObject3.optDouble("start", -1.0d));
            cVar.tt(jSONObjectOptJSONObject3.optInt("repeat_count", 0));
            xdVar.ve = cVar;
        }
    }

    public void c(com.byazt.jzl.uj ujVar) {
        this.c = ujVar;
    }

    public static String c(ic icVar) {
        xd xdVarMy = my(icVar);
        if (xdVarMy == null) {
            return "";
        }
        if (com.byazt.ex.c.c(icVar)) {
            return bx.sp(icVar);
        }
        if (com.byazt.bzd.t.c(icVar)) {
            return nu(icVar).n();
        }
        com.byazt.jzl.uj ujVar = xdVarMy.c;
        return ujVar == null ? "" : ujVar.getVideo_url();
    }

    public static com.byazt.jzl.a c(int i, ic icVar) {
        String rewardFullCacheDir;
        if (icVar.xx() == 1 && !com.byazt.omf.p.n()) {
            icVar.q(0);
        }
        if (com.byazt.bzd.t.c(icVar)) {
            icVar.q(0);
        }
        if (i == 1) {
            rewardFullCacheDir = com.byazt.bzd.sl.c(icVar.xx()).getRewardFullCacheDir();
        } else if (i == 2) {
            rewardFullCacheDir = com.byazt.bzd.sl.c(icVar.xx()).getBrandCacheDir();
        } else if (i != 3) {
            rewardFullCacheDir = i != 4 ? "" : com.byazt.bzd.sl.c(icVar.xx()).getOtherCacheDir();
        } else {
            rewardFullCacheDir = com.byazt.bzd.sl.c(icVar.xx()).getSplashCacheDir();
        }
        com.byazt.jzl.a aVar = new com.byazt.jzl.a(rewardFullCacheDir, yp(icVar), m(icVar), icVar.xx(), icVar.hc());
        aVar.setVideoSkipResult(icVar.wn());
        return aVar;
    }
}
