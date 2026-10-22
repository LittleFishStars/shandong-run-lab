package com.byazt.lr;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.ou.my;
import com.byazt.su.DownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 13})
public class tt {
    public SoftReference<Activity> c;

    @com.byazt.zqa.c(c = {0, 1, 155, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public static tt c = new tt();
    }

    public void tt(long j) {
        com.byazt.gq.n nVarC = com.byazt.di.x.c().c(com.byazt.nn.a.c().n(j).tt.getDownloadUrl());
        if (nVarC != null) {
            nVarC.c(true, true);
        } else {
            sp.c(11, j);
            com.byazt.dm.ve.c().tt("startDownload handler null");
        }
    }

    private tt() {
    }

    public static tt c() {
        return c.c;
    }

    public void c(long j) {
        TTDelegateActivity.c(j);
    }

    public boolean c(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || t.i().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(t.i().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public boolean c(@NonNull com.byazt.nn.n nVar) {
        long jC;
        long j;
        if (!TextUtils.isEmpty(nVar.tt.getLogExtra())) {
            try {
                jC = u.c(new JSONObject(nVar.tt.getLogExtra()), "convert_id");
            } catch (Exception e) {
                m.c(e);
                jC = 0;
            }
            if (jC <= 0) {
                sp.c(3, nVar);
            }
            j = jC;
        } else {
            sp.c(9, nVar);
            com.byazt.dm.ve.c().c("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = nVar.c;
        com.byazt.nn.tt ttVarC = ve.c().c(j, j2);
        if (ttVarC != null) {
            uj.c().c(ttVarC.c(), j2, ttVarC.uj);
            c(ttVarC.c());
            sp.c("lp_app_dialog_try_show", nVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=");
            sb.append(j);
        }
        if (!TextUtils.isEmpty(nVar.tt.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(nVar.tt.getPackageName());
        }
        if (sb.length() <= 0) {
            sp.c(6, nVar);
            return false;
        }
        final long j3 = j;
        com.byazt.hu.ve.c((com.byazt.hu.ve.c<String, R>) new com.byazt.hu.ve.c<String, Boolean>() { // from class: com.byazt.lr.tt.2
            @Override // com.byazt.hu.ve.c
            public Boolean c(String str) {
                final boolean[] zArr = {false};
                t.uj().c("GET", str, new HashMap(), new my() { // from class: com.byazt.lr.tt.2.1
                    @Override // com.byazt.ou.my
                    public void c(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = tt.this.c(j3, j2, str2);
                    }

                    @Override // com.byazt.ou.my
                    public void c(Throwable th) {
                        sp.c(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).c(new com.byazt.hu.ve.c<Boolean, Object>() { // from class: com.byazt.lr.tt.1
            @Override // com.byazt.hu.ve.c
            public Object c(Boolean bool) {
                if (!bool.booleanValue()) {
                    tt.this.tt(j2);
                    return null;
                }
                tt.this.c(com.byazt.nn.tt.c(j3, j2));
                sp.tt("lp_app_dialog_try_show", j2);
                return null;
            }
        }).c();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("package");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.byazt.nn.tt ttVar = new com.byazt.nn.tt();
                ttVar.c = j;
                ttVar.tt = j2;
                ttVar.uj = jSONObjectOptJSONObject.optString("icon_url");
                ttVar.n = jSONObjectOptJSONObject.optString("app_name");
                ttVar.ve = jSONObjectOptJSONObject.optString("package_name");
                ttVar.f28839a = jSONObjectOptJSONObject.optString("version_name");
                ttVar.sp = jSONObjectOptJSONObject.optString("developer_name");
                ttVar.i = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(RequestPermission.PERMISSIONS);
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        ttVar.x.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                ve.c().c(ttVar);
                uj.c().c(ttVar.c(), j2, ttVar.uj);
                return true;
            }
            sp.c(7, j2);
            return false;
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "AdLpComplianceManager parseResponse");
            sp.c(7, j2);
            return false;
        }
    }

    public void c(Activity activity) {
        this.c = new SoftReference<>(activity);
    }
}
