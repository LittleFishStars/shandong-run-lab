package com.byazt.ete;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 569})
public class pu {
    public static JSONObject i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dz f28509a;
    public int c;
    public int n;
    public ma sp;
    public int tt;
    public int uj;
    public int ve;
    public JSONObject x;

    public pu(JSONObject jSONObject, String str, bm bmVar) {
        this.c = 2;
        this.tt = 0;
        this.ve = 1;
        this.uj = 0;
        this.n = 100;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optInt("render_control", bmVar != null ? bmVar.sp : 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject != null) {
            this.tt = jSONObjectOptJSONObject.optInt("render_sequence", 0);
            this.ve = jSONObjectOptJSONObject.optInt("backup_render_control", 1);
            this.uj = jSONObjectOptJSONObject.optInt("render_thread", 0);
            this.n = jSONObjectOptJSONObject.optInt("reserve_time", 100);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject2 != null) {
            dz dzVar = new dz();
            dzVar.tt(jSONObjectOptJSONObject2.optString("id"));
            dzVar.ve(jSONObjectOptJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
            dzVar.uj(jSONObjectOptJSONObject2.optString("url"));
            dzVar.n(jSONObjectOptJSONObject2.optString("data"));
            dzVar.a(jSONObjectOptJSONObject2.optString("diff_data"));
            dzVar.sp(jSONObjectOptJSONObject2.optString("dynamic_creative"));
            dzVar.c(jSONObjectOptJSONObject2.optString("version"));
            dzVar.x(jSONObjectOptJSONObject2.optString("material_type"));
            dzVar.i(jSONObjectOptJSONObject2.optString("ugen_url"));
            dzVar.da(jSONObjectOptJSONObject2.optString("ugen_md5"));
            dzVar.t(jSONObjectOptJSONObject2.optString("express_gesture_priority"));
            dzVar.sl(jSONObjectOptJSONObject2.optString("engine_version"));
            this.f28509a = dzVar;
            com.byazt.ku.uj ujVarC = c(str);
            if (ujVarC != null) {
                com.byazt.six.tt.c(ujVarC);
            }
            com.byazt.xs.da.c(dzVar.i(), dzVar.da(), (com.byazt.xs.ve) null);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject3 != null) {
            ma maVarC = ma.c(jSONObjectOptJSONObject3);
            this.sp = maVarC;
            com.byazt.nq.tt.c().c(maVarC, str, "ad");
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject4 != null) {
            this.x = jSONObjectOptJSONObject4;
        }
    }

    public static dz a(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return null;
        }
        return puVarYp.f28509a;
    }

    public static void c(ic icVar, int i2) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return;
        }
        puVarYp.c = i2;
    }

    public static boolean da(ic icVar) {
        return icVar != null && tt(icVar) == 7;
    }

    public static com.byazt.ku.uj i(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return null;
        }
        return puVarYp.c(String.valueOf(com.byazt.aas.nb.t(icVar)));
    }

    public static int n(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return 100;
        }
        return puVarYp.n;
    }

    public static boolean sl(ic icVar) {
        return icVar != null && tt(icVar) == 3;
    }

    public static ma sp(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return null;
        }
        return puVarYp.sp;
    }

    public static boolean t(ic icVar) {
        return icVar != null && tt(icVar) == 10;
    }

    public static void tt(com.byazt.it.n nVar) {
        try {
            i = new JSONObject(nVar.getString("dark_mode_config", ""));
        } catch (Exception unused) {
        }
    }

    public static JSONObject u(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return null;
        }
        return puVarYp.x;
    }

    public static int uj(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return 0;
        }
        return puVarYp.uj;
    }

    public static int ve(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return 1;
        }
        return puVarYp.ve;
    }

    public static boolean x(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return false;
        }
        dz dzVar = puVarYp.f28509a;
        if (dzVar != null) {
            return !TextUtils.isEmpty(dzVar.sl());
        }
        int i2 = puVarYp.tt;
        return i2 == 9 || i2 == 10;
    }

    private static pu yp(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.gy();
    }

    public void tt(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.tt);
            jSONObject2.put("backup_render_control", this.ve);
            jSONObject2.put("render_thread", this.uj);
            jSONObject2.put("reserve_time", this.n);
            jSONObject.put("render", jSONObject2);
            if (this.f28509a != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", this.f28509a.tt());
                jSONObject3.put(TKDownloadReason.KSAD_TK_MD5, this.f28509a.ve());
                jSONObject3.put("url", this.f28509a.uj());
                jSONObject3.put("data", this.f28509a.n());
                jSONObject3.put("diff_data", this.f28509a.a());
                jSONObject3.put("version", this.f28509a.c());
                jSONObject3.put("dynamic_creative", this.f28509a.sp());
                jSONObject3.put("material_type", this.f28509a.x());
                jSONObject3.put("ugen_url", this.f28509a.i());
                jSONObject3.put("ugen_md5", this.f28509a.da());
                jSONObject3.put("engine_version", this.f28509a.sl());
                jSONObject3.put("express_gesture_priority", this.f28509a.t());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.x);
            ma maVar = this.sp;
            if (maVar != null) {
                jSONObject.put("tpl_info_v3", maVar.i());
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                if (jSONObjectOptJSONObject != null) {
                    i = jSONObjectOptJSONObject.optJSONObject("dark_mode_config");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(com.byazt.it.n nVar) {
        try {
            nVar.put("dark_mode_config", i.toString());
        } catch (Exception unused) {
        }
    }

    public static JSONObject c() {
        return i;
    }

    private com.byazt.ku.uj c(String str) {
        dz dzVar = this.f28509a;
        if (dzVar == null) {
            return null;
        }
        String strTt = dzVar.tt();
        String strUj = this.f28509a.uj();
        String strVe = this.f28509a.ve();
        String strN = this.f28509a.n();
        return com.byazt.ku.uj.c().c(strTt).tt(strVe).ve(strUj).uj(strN).n(this.f28509a.c()).a(String.valueOf(str));
    }

    public static int c(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return 2;
        }
        return puVarYp.c;
    }

    public static boolean c(int i2) {
        JSONObject jSONObject = i;
        if (jSONObject == null) {
            return i2 == 1 || i2 == 5 || i2 == 8;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("support_slot_type");
            if (jSONArrayOptJSONArray == null) {
                return i2 == 1 || i2 == 5 || i2 == 8;
            }
            int length = jSONArrayOptJSONArray.length();
            if (length == 0) {
                return i2 == 1 || i2 == 5 || i2 == 8;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 == jSONArrayOptJSONArray.optInt(i3)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return i2 == 1 || i2 == 5 || i2 == 8;
        }
    }

    public static double c(ic icVar, double d) {
        JSONObject jSONObject;
        double d2;
        pu puVarYp = yp(icVar);
        if (puVarYp == null || puVarYp.c != 2) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int i2 = puVarYp.tt;
        if ((i2 != 10 && i2 != 9) || (jSONObject = puVarYp.x) == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        try {
            int iOptInt = jSONObject.optInt("layout_type");
            if (iOptInt <= 0) {
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            switch (iOptInt) {
                case 1:
                case 2:
                    d2 = 0.8999999761581421d;
                    break;
                case 3:
                    d2 = 1.0d;
                    break;
                case 4:
                    d2 = 0.5d;
                    break;
                case 5:
                case 6:
                    d2 = 2.4000000953674316d;
                    break;
                case 7:
                    d2 = 2.0d;
                    break;
                default:
                    return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            return d / d2;
        } catch (Exception unused) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public static int tt(ic icVar) {
        pu puVarYp = yp(icVar);
        if (puVarYp == null) {
            return 0;
        }
        return puVarYp.tt;
    }
}
