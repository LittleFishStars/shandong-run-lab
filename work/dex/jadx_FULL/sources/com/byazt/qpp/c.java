package com.byazt.qpp;

import android.content.SharedPreferences;
import com.byazt.by.ve;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 460, 20})
public class c {
    public volatile int c = -1;
    public volatile SharedPreferences tt = com.byazt.nys.tt.tt(gt.getContext(), "sp_ad_common_config", 0);

    @com.byazt.zqa.c(c = {0, 1, 460, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt {
        public static c c = new c();
    }

    public int tt() {
        if (this.c == -1) {
            this.c = c("store_isolate_conf", 3);
        }
        return this.c;
    }

    public static c c() {
        return tt.c;
    }

    /* JADX INFO: renamed from: com.byazt.qpp.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 460, 44})
    public static class C0512c {
        public Map<String, Object> c = new HashMap();

        public C0512c c(int i) {
            if (c.c().c == i) {
                return this;
            }
            c.c().c = i;
            this.c.put("store_isolate_conf", Integer.valueOf(i));
            return this;
        }

        public void c() {
            try {
                if (!ve.c().tt()) {
                    SharedPreferences.Editor editorEdit = c.c().tt.edit();
                    for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            editorEdit.putLong(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            editorEdit.putFloat(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            editorEdit.putInt(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            editorEdit.putString(key, (String) value);
                        }
                    }
                    editorEdit.apply();
                    return;
                }
                for (Map.Entry<String, Object> entry2 : this.c.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        com.byazt.ti.tt.c("sp_ad_common_config", key2, (Boolean) value2);
                    } else if (value2 instanceof Long) {
                        com.byazt.ti.tt.c("sp_ad_common_config", key2, (Long) value2);
                    } else if (value2 instanceof Float) {
                        com.byazt.ti.tt.c("sp_ad_common_config", key2, (Float) value2);
                    } else if (value2 instanceof Integer) {
                        com.byazt.ti.tt.c("sp_ad_common_config", key2, (Integer) value2);
                    } else if (value2 instanceof String) {
                        com.byazt.ti.tt.c("sp_ad_common_config", key2, (String) value2);
                    }
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public int c(String str, int i) {
        try {
            if (ve.c().tt()) {
                return com.byazt.ti.tt.c("sp_ad_common_config", str, i);
            }
            return this.tt.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }
}
