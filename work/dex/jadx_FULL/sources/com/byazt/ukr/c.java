package com.byazt.ukr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byakv.z.TTEncryptUtils;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.gr;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.z;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huachenjie.common.constants.UserConstants;
import com.huawei.hms.adapter.internal.CommonCode;
import com.kc.openset.advertisers.hl.HLADNID;
import com.kc.openset.constant.DeviceIdType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 20})
public class c implements com.byazt.vb.x {
    public static final c c = new c();
    public long tt;
    public String uj;
    public int ve;

    private c() {
    }

    public static String c(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    @Override // com.byazt.vb.x
    public String a() {
        return nb.gr();
    }

    public String c(Context context) {
        try {
            if (DeviceUtils.tt(context)) {
                return "tv";
            }
            return DeviceUtils.c(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    @Override // com.byazt.vb.x
    public int da() {
        return gt.tt().di() ? 4 : 3;
    }

    @Override // com.byazt.vb.x
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", z.c());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.byazt.vb.x
    public com.byazt.gs.a n() {
        return new t(com.byazt.hy.n.c().tt().tt());
    }

    @Override // com.byazt.vb.x
    public String sp() {
        return nb.t("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.byazt.vb.x
    public byte[] tt(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrTt = tt(jSONObject);
        com.byazt.dna.n nVarTt = gr.tt();
        if (bArrTt == null || nVarTt == null || !nVarTt.getArmorLoadStatus() || i <= 3) {
            return null;
        }
        byte[] bArrEncrypt = nVarTt.encrypt(bArrTt);
        if (bArrEncrypt != null) {
            return bArrEncrypt;
        }
        yp.c().c(3, -1L, "stats", nVarTt.getSpecificArmorLoadStatus());
        return bArrEncrypt;
    }

    @Override // com.byazt.vb.x
    public int uj() {
        int iNb = gt.tt().nb();
        if (iNb < 0 || iNb == Integer.MAX_VALUE) {
            return 10;
        }
        return iNb;
    }

    @Override // com.byazt.vb.x
    public long ve() {
        long jCu = gt.tt().cu();
        if (jCu < 0 || jCu == 2147483647L) {
            return 5000L;
        }
        return jCu;
    }

    @Override // com.byazt.vb.x
    public boolean x() {
        return p.c();
    }

    @SuppressLint({"HardwareIds"})
    private JSONObject c(List<com.byazt.vb.tt> list, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        Context context = gt.getContext();
        try {
            com.byazt.dna.u uVar = (com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new");
            int i = 0;
            if (z) {
                jSONObject.put("sdk_version", p.n);
                jSONObject.put("display_name", com.byazt.fh.c.a());
                jSONObject.put(AlibcCommonConstant.APP_VERSION, com.byazt.fh.c.n());
                jSONObject.put("package", nb.x());
                jSONObject.put("region", Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> arrayListC = com.byazt.nr.ve.c(context, "MD5");
                if (arrayListC != null && !arrayListC.isEmpty()) {
                    jSONObject.put("sig_hash", arrayListC.get(0));
                }
                jSONObject.put("version_code", nb.i());
            }
            jSONObject.put("ua", uVar.getWebViewUA(false));
            com.byazt.qh.tt.c(context, jSONObject);
            jSONObject.put("openudid", DeviceUtils.tt());
            jSONObject.put(DeviceIdType.OAID, ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getOAID(false));
            jSONObject.put("ad_sdk_version", p.n);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject.put("is_plugin", p.c());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("client_ipv4", my.tt((String) null));
            jSONObject2.put("client_ipv6", my.tt());
            jSONObject.put("custom", jSONObject2);
            jSONObject.put("sim_op", uVar.getSimOperator());
            jSONObject.put("root", z2 ? 1 : 0);
            jSONObject.put("timezone", uVar.getTimeZoneInt());
            jSONObject.put("access", rh.sp(context));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            if (TextUtils.isEmpty(this.uj)) {
                this.uj = c(context);
            }
            jSONObject.put("device_type", this.uj);
            jSONObject.put("device_model", uVar.getDeviceModel());
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, pf.n(context) + "x" + pf.uj(context));
            jSONObject.put("display_density", c(uVar.getDisplayDpi()));
            jSONObject.put("density_dpi", uVar.getDisplayDpi());
            jSONObject.put("device_id", z.c());
            int iVe = com.byazt.ml.c.ve(list, com.byazt.epi.c.uj("csj"));
            if (iVe != 0) {
                jSONObject.put("aid", String.valueOf(iVe));
            } else {
                jSONObject.put("aid", "1371");
            }
            jSONObject.put("rom", uVar.getRom());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", uVar.getBuildSerial());
            jSONObject.put("ut", this.ve);
            jSONObject.put(UserConstants.URL_PARAMS.b, this.tt);
            jSONObject.put("locale_language", uVar.getLocalLanguage());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.n() * 10.0f) / 10.0d);
            if (!DeviceUtils.c()) {
                i = 1;
            }
            jSONObject.put("is_screen_off", i);
            jSONObject.put("download_channel", com.byazt.fh.c.i());
            jSONObject.put("mnc", uVar.getMnc());
            jSONObject.put("mcc", uVar.getMcc());
            jSONObject.put("pan_code_serial", HLADNID.Reason.OTHER);
        } catch (Throwable th) {
            m.uj("log_net", th.getMessage());
        }
        return jSONObject;
    }

    private byte[] tt(JSONObject jSONObject) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(jSONObject.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        m.c(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                m.c(e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            m.c(e4);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.byazt.vb.x
    public String tt() {
        return nb.zm();
    }

    @Override // com.byazt.vb.x
    public JSONObject c(List<com.byazt.vb.tt> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z2 = false;
            try {
                c(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.byazt.vb.tt> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectSp = it.next().sp();
                    if (TextUtils.equals("pangle_live_sdk_monitor", jSONObjectSp.optString("event"))) {
                        if (!z2) {
                            z2 = true;
                        }
                        jSONObjectSp.putOpt("nt", Integer.valueOf(rh.ve(gt.getContext())));
                    }
                    jSONArray.put(jSONObjectSp);
                }
                jSONObject.put("header", c(list, z2, z));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e) {
                m.ve(e.getMessage());
            }
        }
        return null;
    }

    @Override // com.byazt.vb.x
    public byte[] c(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrTt = tt(jSONObject);
        if (bArrTt == null) {
            return null;
        }
        com.byazt.dna.n nVarTt = gr.tt();
        if (i > 3 && nVarTt != null) {
            byte[] bArrEncrypt = nVarTt.encrypt(bArrTt);
            if (bArrEncrypt != null) {
                return bArrEncrypt;
            }
            yp.c().c(3, -1L, "applog", nVarTt.getSpecificArmorLoadStatus());
            return bArrEncrypt;
        }
        return TTEncryptUtils.c(bArrTt, bArrTt.length);
    }

    @Override // com.byazt.vb.x
    public boolean c() {
        return com.byazt.omf.x.m().bm();
    }

    @Override // com.byazt.vb.x
    public JSONObject c(JSONObject jSONObject) {
        if (gt.tt().jf() == 1) {
            return new JSONObject();
        }
        return com.byazt.nr.c.c(jSONObject);
    }

    private void c(com.byazt.vb.tt ttVar) {
        String strOptString;
        if (ttVar == null) {
            return;
        }
        JSONObject jSONObjectSp = ttVar.sp();
        JSONObject jSONObjectOptJSONObject = jSONObjectSp.optJSONObject("params");
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString("log_extra", "");
        } else {
            strOptString = jSONObjectSp.optString("log_extra", "");
        }
        long jA = nb.a(strOptString);
        int iSp = nb.sp(strOptString);
        if (jA == 0) {
            jA = this.tt;
        }
        this.tt = jA;
        if (iSp == 0) {
            iSp = this.ve;
        }
        this.ve = iSp;
    }
}
