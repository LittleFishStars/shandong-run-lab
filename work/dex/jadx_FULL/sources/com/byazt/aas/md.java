package com.byazt.aas;

import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md {
    public static com.byazt.dj.tt c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.byazt.dj.tt.c cVar = new com.byazt.dj.tt.c(str2);
            cVar.c(jSONObject.optString("mAdId", ""));
            cVar.tt(jSONObject.optString("mCreativeId", ""));
            cVar.ve(jSONObject.optString("mExt", ""));
            cVar.uj(jSONObject.optString("mCodeId", ""));
            cVar.i(jSONObject.optString("mUserData"));
            cVar.c(jSONObject.optBoolean("mIsAutoPlay", true));
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 640);
            cVar.tt(jSONObject.optInt("mImgAcceptedHeight", 320));
            cVar.c(iOptInt);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", AudioStats.AUDIO_AMPLITUDE_NONE);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", AudioStats.AUDIO_AMPLITUDE_NONE);
            cVar.tt(Double.valueOf(dOptDouble).floatValue());
            cVar.c(Double.valueOf(dOptDouble2).floatValue());
            cVar.tt(jSONObject.optBoolean("mSupportDeepLink", true));
            cVar.ve(jSONObject.optInt("mAdCount", 1));
            cVar.n(jSONObject.optString("mMediaExtra", ""));
            cVar.a(jSONObject.optString("mUserID", ""));
            cVar.uj(jSONObject.optInt("mOrientation", 2));
            cVar.sp(jSONObject.optInt("mAdType", 0));
            cVar.n(jSONObject.optInt("mNativeAdType"));
            cVar.c(nb.yp(jSONObject.optString("mExternalABVid", "")));
            cVar.a(jSONObject.optInt("mAdLoadSeq", 0));
            cVar.sp(jSONObject.optString("mPrimeRit", ""));
            cVar.x(jSONObject.optString("mBidAdm"));
            cVar.x(jSONObject.optInt("mRewardAmount", 0));
            cVar.da(jSONObject.optString("mRewardName", ""));
            return cVar.c();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final com.byazt.dj.tt.c tt(com.byazt.dj.tt ttVar) {
        return new com.byazt.dj.tt.c(ttVar);
    }

    public static JSONObject c(com.byazt.dj.tt ttVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", ttVar.c());
            jSONObject.put("mCreativeId", ttVar.tt());
            jSONObject.put("mExt", ttVar.ve());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", ttVar.qy());
            jSONObject.put("mIsAutoPlay", ttVar.n());
            jSONObject.put("mImgAcceptedWidth", ttVar.a());
            jSONObject.put("mImgAcceptedHeight", ttVar.sp());
            jSONObject.put("mExpressViewAcceptedWidth", ttVar.x());
            jSONObject.put("mExpressViewAcceptedHeight", ttVar.i());
            jSONObject.put("mSupportDeepLink", ttVar.da());
            jSONObject.put("mSupportRenderControl", ttVar.sl());
            if (com.byazt.omf.p.uj >= 5900) {
                jSONObject.put("mSupportIconStyle", ttVar.yv());
            }
            jSONObject.put("mAdCount", ttVar.t());
            jSONObject.put("mMediaExtra", ttVar.u());
            jSONObject.put("mUserID", ttVar.yp());
            jSONObject.put("mOrientation", ttVar.z());
            jSONObject.put("mAdType", ttVar.gt());
            jSONObject.put("mNativeAdType", ttVar.m());
            jSONObject.put("mExternalABVid", nb.c(ttVar.nu()));
            jSONObject.put("mAdLoadSeq", ttVar.rh());
            jSONObject.put("mPrimeRit", ttVar.my());
            jSONObject.put("mBidAdm", ttVar.rl());
            jSONObject.put("mRewardAmount", ttVar.zm());
            jSONObject.put("mRewardName", ttVar.gr());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject c(com.byazt.dj.tt ttVar) {
        return c(ttVar, ttVar.uj());
    }

    public static com.byazt.dj.tt c(int i, String str, float f, float f2, ic icVar) {
        return c(icVar == null ? null : icVar.jl()).uj(str).sp(i).tt(f2).c(f).c();
    }

    public static com.byazt.dj.tt c(int i, String str) {
        return c(str).sp(i).c();
    }

    public static com.byazt.dj.tt c(int i, PluginValueSet pluginValueSet) {
        com.byazt.dj.tt ttVar = new com.byazt.dj.tt(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>(), com.byazt.vxy.c.tt());
        com.byazt.dj.tt.c cVar = new com.byazt.dj.tt.c(ttVar);
        float fX = ttVar.x();
        float fI = ttVar.i();
        if (fX <= 0.0f) {
            fX = pf.uj(com.byazt.omf.gt.getContext(), ttVar.a());
            fI = pf.uj(com.byazt.omf.gt.getContext(), ttVar.sp());
        }
        if (fX > 0.0f || fI > 0.0f) {
            int iUj = pf.uj(com.byazt.omf.gt.getContext(), pf.n(com.byazt.omf.gt.getContext()));
            int iUj2 = pf.uj(com.byazt.omf.gt.getContext(), pf.uj(com.byazt.omf.gt.getContext()));
            int iMax = Math.max(iUj, iUj2);
            int iMin = Math.min(iUj, iUj2);
            if (fX > fI) {
                if (iUj2 > 0 && fX > ((double) iMax) * 1.3d) {
                    fX = iMax;
                    fI = iMin;
                }
            } else if (iUj > 0 && fI > ((double) iMax) * 1.3d) {
                fX = iMin;
                fI = iMax;
            }
        }
        cVar.c(fX).tt(fI);
        return new com.byazt.ete.ve(tt(cVar.c()).sp(i).c());
    }

    private static final com.byazt.dj.tt.c c(String str) {
        return new com.byazt.dj.tt.c(str).ve(1).tt(320).c(640).tt(true).a("defaultUser").uj(2).c(true);
    }

    public static boolean c(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) com.byazt.omf.gt.tt().c(str, Boolean.valueOf(z))).booleanValue();
    }

    public static long c(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) com.byazt.omf.gt.tt().c(str, Long.valueOf(j))).longValue();
    }

    public static int c(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) com.byazt.omf.gt.tt().c(str, Integer.valueOf(i))).intValue();
    }
}
