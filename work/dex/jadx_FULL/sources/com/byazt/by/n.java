package com.byazt.by;

import android.content.SharedPreferences;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f28335a;
    public String c;
    public volatile String m;
    public volatile String sp;
    public volatile int ve = -1;
    public volatile long uj = -1;
    public volatile float n = -1.0f;
    public volatile int x = -1;
    public volatile int i = -1;
    public volatile int da = -1;
    public volatile int sl = -1;
    public volatile int t = 0;
    public volatile int u = -1;
    public volatile int yp = -1;
    public volatile int z = -1;
    public volatile com.byazt.it.n tt = com.byazt.vif.uj.tt(com.byazt.vxy.c.uj(), nu());

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 151})
    public static class c {
        public static n c = new n();
    }

    private static String nu() {
        return "sp_exec_getad_config_bst";
    }

    public void m() {
        try {
            this.tt.clear();
        } catch (Throwable unused) {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 934})
    public static class tt {
        public Map<String, Object> c = new HashMap();

        public tt a(int i) {
            if (n.c().i == i) {
                return this;
            }
            n.c().i = i;
            this.c.put("spl_cache_expired", Integer.valueOf(i));
            return this;
        }

        public tt c(long j) {
            if (n.c().uj == j) {
                return this;
            }
            n.c().uj = j;
            this.c.put("duration", Long.valueOf(j));
            return this;
        }

        public tt n(int i) {
            if (n.c().sl == i) {
                return this;
            }
            n.c().sl = i;
            this.c.put("spl_common_conf", Integer.valueOf(i));
            return this;
        }

        public tt sp(int i) {
            if (n.c().t == i) {
                return this;
            }
            n.c().t = i;
            this.c.put("splash_render_timeout_backup", Integer.valueOf(i));
            return this;
        }

        public tt tt(String str) {
            if (str != null && str.equals(n.c().sp)) {
                return this;
            }
            n.c().sp = str;
            Map<String, Object> map = this.c;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public tt uj(int i) {
            if (n.c().da == i) {
                return this;
            }
            this.c.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public tt ve(int i) {
            if (n.c().x == i) {
                return this;
            }
            n.c().x = i;
            this.c.put("spl_cache_conf", Integer.valueOf(i));
            return this;
        }

        public tt x(int i) {
            if (n.c().u == i) {
                return this;
            }
            n.c().u = i;
            this.c.put("dl_storage_internal", Integer.valueOf(i));
            return this;
        }

        public tt uj(String str) {
            if (str != null && str.equals(n.c().m)) {
                return this;
            }
            n.c().m = str;
            this.c.put("cache_strategy_splash", str);
            return this;
        }

        public tt c(int i) {
            if (n.c().ve == i) {
                return this;
            }
            n.c().ve = i;
            this.c.put("max", Integer.valueOf(i));
            return this;
        }

        public tt tt(int i) {
            if (n.c().yp == i) {
                return this;
            }
            n.c().yp = i;
            this.c.put("cypher_version", Integer.valueOf(i));
            return this;
        }

        public tt ve(String str) {
            if (str != null && str.equals(n.c().c)) {
                return this;
            }
            n.c().c = str;
            Map<String, Object> map = this.c;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public tt c(float f) {
            if (n.c().n == f) {
                return this;
            }
            n.c().n = f;
            this.c.put("aggMultiple", Float.valueOf(f));
            return this;
        }

        public tt c(String str) {
            if (str != null && str.equals(n.c().f28335a)) {
                return this;
            }
            n.c().f28335a = str;
            Map<String, Object> map = this.c;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public tt c(boolean z) {
            this.c.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public tt c(JSONObject jSONObject) {
            int iOptInt;
            if (jSONObject == null || n.c().z == (iOptInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            n.c().z = iOptInt;
            this.c.put("splash_policy", Integer.valueOf(iOptInt));
            return this;
        }

        public void c() {
            try {
                com.byazt.it.n nVar = n.c().tt;
                SharedPreferences.Editor editorEdit = nVar.edit();
                if (editorEdit == null) {
                    for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            nVar.put(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            nVar.put(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            nVar.put(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            nVar.put(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            nVar.put(key, (String) value);
                        }
                    }
                    return;
                }
                for (Map.Entry<String, Object> entry2 : this.c.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.commit();
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public boolean da() {
        return c("is_spl_cache_remove_change", false);
    }

    public int i() {
        if (this.yp == -1) {
            this.yp = c("cypher_version", 40001);
        }
        return this.yp;
    }

    public int sl() {
        if (this.x == -1) {
            this.x = c("spl_cache_conf", 30);
        }
        return this.x;
    }

    public int t() {
        if (this.da == -1) {
            this.da = c("spl_thread_conf", 1);
        }
        return this.da;
    }

    public int u() {
        if (this.sl == -1) {
            this.sl = c("spl_common_conf", 0);
        }
        return this.sl;
    }

    public int yp() {
        if (this.t <= 0) {
            this.t = c("splash_render_timeout_backup", 100);
        }
        return this.t;
    }

    public String z() {
        if (this.m == null) {
            this.m = c("cache_strategy_splash", "");
        }
        return this.m;
    }

    public String a() {
        if (this.sp == null) {
            this.sp = c("ab_test_param", "");
        }
        return this.sp;
    }

    public String n() {
        if (this.f28335a == null) {
            this.f28335a = c("ab_test_version", "");
        }
        return this.f28335a;
    }

    public void sp() {
        this.sp = "";
        this.f28335a = "";
        this.tt.remove("ab_test_version");
        this.tt.remove("ab_test_param");
    }

    public float uj() {
        if (this.n == -1.0f) {
            this.n = c("aggMultiple", -1.0f);
        }
        return this.n;
    }

    public boolean x() {
        if (this.u == -1) {
            this.u = c("dl_storage_internal", 1);
        }
        return this.u == 1;
    }

    public long tt() {
        if (this.uj == -1) {
            this.uj = c("duration", 10000L);
        }
        return this.uj;
    }

    public int ve() {
        if (this.ve == -1) {
            this.ve = c("max", 50);
        }
        return this.ve;
    }

    public static n c() {
        return c.c;
    }

    public boolean c(String str, boolean z) {
        try {
            return this.tt.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public long c(String str, long j) {
        try {
            return this.tt.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float c(String str, float f) {
        try {
            return this.tt.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int c(String str, int i) {
        try {
            return this.tt.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public String c(String str, String str2) {
        try {
            return this.tt.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
