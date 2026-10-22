package com.byazt.xs;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.byazt.aas.eo;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ete.zm;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 468, 72})
public class da {
    public static boolean a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        return sp(icVar) || x(icVar);
    }

    public static boolean i(ic icVar) {
        return (icVar == null || icVar.po() == null) ? false : true;
    }

    public static boolean n(ic icVar) {
        if (icVar == null) {
            return false;
        }
        int iTx = icVar.tx();
        com.byazt.seg.c cVarV = icVar.v();
        return cVarV != null && iTx == 1 && cVarV.uj() == 2;
    }

    public static boolean sp(ic icVar) {
        return (icVar == null || icVar.tx() != 1 || my.c(icVar)) ? false : true;
    }

    public static boolean tt(ic icVar) {
        com.byazt.lo.c cVarOs;
        JSONObject jSONObjectVe;
        return (icVar == null || (cVarOs = icVar.os()) == null || (jSONObjectVe = cVarOs.ve()) == null || jSONObjectVe.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean uj(ic icVar) {
        if (icVar == null) {
            return false;
        }
        int iTx = icVar.tx();
        com.byazt.seg.c cVarV = icVar.v();
        return cVarV != null && iTx == 1 && cVarV.uj() == 3;
    }

    public static boolean ve(ic icVar) {
        if (icVar == null) {
            return false;
        }
        int iTx = icVar.tx();
        com.byazt.seg.c cVarV = icVar.v();
        return cVarV != null && iTx == 1 && cVarV.uj() == 4;
    }

    public static boolean x(ic icVar) {
        return icVar != null && icVar.pu() > 0;
    }

    public static int c(ic icVar) {
        com.byazt.lo.c cVarOs;
        JSONObject jSONObjectVe;
        int iOptInt;
        if (icVar == null || (cVarOs = icVar.os()) == null || (jSONObjectVe = cVarOs.ve()) == null || (iOptInt = jSONObjectVe.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return iOptInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final boolean z, final String str, final ve veVar) {
        if (veVar != null) {
            com.byazt.nr.da.tt().post(new com.byazt.bwm.sp("tt_ugen_tpl") { // from class: com.byazt.xs.da.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        veVar.c(str);
                    } else {
                        veVar.c();
                    }
                }
            });
        }
    }

    public static JSONObject c(ic icVar, View view, boolean z) {
        JSONObject jSONObjectYg = icVar.yg();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            boolean z2 = false;
            jSONObject.put("voice_control", icVar.ab() == 1);
            Context context = gt.getContext();
            jSONObject3.put("width", pf.uj(context, pf.uj(context)));
            jSONObject3.put("height", pf.uj(context, pf.n(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", pf.uj(context, width) * 1.0f);
                jSONObject4.put("height", pf.uj(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            jSONObjectYg.put("env_info", jSONObject2);
            jSONObjectYg.put(com.alipay.sdk.m.w.a.x, jSONObject);
            jSONObjectYg.put("meta_hashcode", icVar.eo());
            if (z && gt.tt().nx()) {
                z2 = true;
            }
            jSONObjectYg.put("gesture_through_enable", z2);
            jSONObjectYg.put("is_adapt_two_finger", gt.tt().tw());
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObjectYg;
    }

    private static void tt(String str, final String str2, final ve veVar) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            tt(false, (String) null, veVar);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
        if (veVarVe == null) {
            tt(false, (String) null, veVar);
        } else {
            veVarVe.c(str);
            veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.xs.da.2
                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                    if (ttVar != null) {
                        try {
                            if (ttVar.i() && ttVar.n() != null) {
                                com.byazt.iy.n nVarC = eo.c("ugeno_template_kv");
                                String strN = ttVar.n();
                                nVarC.put(str2, strN);
                                da.tt(true, strN, veVar);
                                return;
                            }
                        } catch (Exception unused) {
                            da.tt(false, (String) null, veVar);
                            return;
                        }
                    }
                    da.tt(false, (String) null, veVar);
                }

                @Override // com.byazt.mh.c
                public void c(com.byazt.va.uj ujVar, IOException iOException) {
                    da.tt(false, (String) null, veVar);
                }
            });
        }
    }

    public static int tt(Context context, ic icVar, String str) {
        if (icVar == null) {
            return -1;
        }
        zm zmVarPo = icVar.po();
        if (zmVarPo == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String strTt = zmVarPo.tt();
        if (c(strTt, zmVarPo.ve(), (ve) null) == null) {
            return TextUtils.isEmpty(strTt) ? 2 : 3;
        }
        return 1;
    }

    public static boolean c(Context context, ic icVar, String str) {
        return tt(context, icVar, str) == 1;
    }

    public static String c(Context context, String str, ic icVar, String str2) {
        zm zmVarPo = icVar.po();
        JSONObject jSONObjectLa = icVar.la();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String strOp = icVar.op();
            if (!TextUtils.isEmpty(strOp)) {
                jSONObject.put("description", strOp);
            }
            if (jSONObjectLa != null) {
                jSONObject.put("easy_pl_material", jSONObjectLa.toString());
            }
            if (zmVarPo != null) {
                jSONObject.put("ugen_dialog_url", zmVarPo.tt());
                jSONObject.put("ugen_dialog_md5", zmVarPo.ve());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            m.c(e);
            return "";
        }
    }

    public static JSONObject c(String str, String str2, ve veVar) {
        if (TextUtils.isEmpty(str)) {
            if (veVar != null) {
                veVar.c();
            }
            return null;
        }
        com.byazt.iy.n nVarC = eo.c("ugeno_template_kv");
        if (nVarC == null) {
            if (veVar != null) {
                veVar.c();
            }
            return null;
        }
        try {
            String str3 = nVarC.get(str2, "");
            if (!TextUtils.isEmpty(str3)) {
                if (veVar != null) {
                    veVar.c(str3);
                }
                return new JSONObject(str3);
            }
            if (!TextUtils.isEmpty(str)) {
                tt(str, str2, veVar);
                return null;
            }
            if (veVar != null) {
                veVar.c();
            }
            return null;
        } catch (Exception unused) {
            if (veVar != null) {
                veVar.c();
            }
        }
    }
}
