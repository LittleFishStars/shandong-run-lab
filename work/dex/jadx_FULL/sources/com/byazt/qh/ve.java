package com.byazt.qh;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 54})
public class ve {
    public String c;
    public String tt;
    public volatile String uj;
    public String ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 24})
    public static class c {
        public static ve c = new ve();
    }

    public static ve c() {
        return c.c;
    }

    public static Map<String, Object> da() {
        com.byazt.dj.uj ujVarNu;
        JSONObject jSONObjectVe;
        if (p.uj < 6408 || (ujVarNu = x.m().nu()) == null) {
            return null;
        }
        Map<String, Object> mapUserPrivacyConfig = ujVarNu.userPrivacyConfig();
        return ((mapUserPrivacyConfig == null || mapUserPrivacyConfig.isEmpty()) && x.m().hd() && m.ve() && (jSONObjectVe = com.byazt.edv.c.ve("compliance.json")) != null) ? c(jSONObjectVe) : mapUserPrivacyConfig;
    }

    private String sl() {
        Map<String, Object> mapDa = da();
        if (mapDa == null) {
            return null;
        }
        Object obj = mapDa.get("od");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private boolean t() {
        String strRl = x.m().rl();
        if (TextUtils.isEmpty(strRl)) {
            return false;
        }
        strRl.hashCode();
        switch (strRl) {
            case "5001121":
            case "5002213":
            case "5437586":
            case "5634951":
                return true;
            default:
                return false;
        }
    }

    public boolean a() {
        return !TextUtils.equals(tt(), "0");
    }

    public boolean i() {
        return tt(uj());
    }

    public void n() {
        if (t()) {
            String strSl = sl();
            if (TextUtils.equals(strSl, this.tt)) {
                return;
            }
            com.byazt.apd.tt.c().c("setOaidEnabled", c(strSl));
            this.tt = strSl;
        }
    }

    public boolean sp() {
        if (t()) {
            return c(sl());
        }
        return true;
    }

    public String tt() {
        try {
            Map<String, Object> mapDa = da();
            if (mapDa == null) {
                ve(null);
                return null;
            }
            Object obj = mapDa.get("motion_info");
            if (obj instanceof String) {
                if (TextUtils.equals("0", (String) obj)) {
                    ve("0");
                    return "0";
                }
                ve("1");
                return "1";
            }
            ve(null);
            return null;
        } catch (Exception e) {
            m.c(e);
        }
    }

    public String uj() {
        Map<String, Object> mapDa = da();
        if (mapDa == null) {
            return null;
        }
        Object obj = mapDa.get("blt");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean ve() {
        if (!TextUtils.isEmpty(this.uj)) {
            return !TextUtils.equals("0", this.uj);
        }
        Map<String, Object> mapDa = da();
        if (mapDa != null) {
            Object obj = mapDa.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                this.uj = str;
                return !TextUtils.equals("0", str);
            }
        }
        this.uj = "1";
        return true;
    }

    public boolean x() {
        if (gt.tt().bx()) {
            return false;
        }
        Map<String, Object> mapDa = da();
        if (mapDa != null) {
            Object obj = mapDa.get("mcod");
            if (obj instanceof String) {
                String str = (String) obj;
                this.ve = str;
                return !TextUtils.equals(str, "0");
            }
        }
        return true;
    }

    private ve() {
    }

    public static HashMap<String, Object> c(JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next));
            }
        } catch (Exception unused) {
        }
        return map;
    }

    private boolean c(String str) {
        return !TextUtils.equals(str, "0");
    }

    private void ve(String str) {
        if (!TextUtils.equals(this.c, str)) {
            com.byazt.apd.tt.c().c("setSensorEnable", !TextUtils.equals(str, "0"));
        }
        this.c = str;
    }

    private boolean tt(String str) {
        return !TextUtils.equals(str, "0");
    }
}
