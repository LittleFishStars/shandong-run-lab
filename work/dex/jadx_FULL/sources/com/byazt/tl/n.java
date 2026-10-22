package com.byazt.tl;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.by.a;
import com.byazt.ete.bm;
import com.byazt.ete.ic;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.omf.gr;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.zj.adlib.u15;
import com.zj.adlib.ze1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 467, 46})
public class n implements com.byazt.sif.c {
    public final ic c;
    public boolean n;
    public final WeakReference<Context> tt;
    public String uj;
    public final uj ve;

    public n(ic icVar, Context context, uj ujVar, boolean z) {
        this.c = icVar;
        this.tt = new WeakReference<>(context);
        this.ve = ujVar;
        this.n = z;
    }

    private String ve(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", x.m().qy());
            jSONObject.putOpt("app_id", x.m().rl());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt(ze1.p, Build.MANUFACTURER);
            jSONObject.putOpt("did", ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid());
            jSONObject.putOpt("sdk_version", 7611);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(p.uj));
            jSONObject.putOpt("live_sdk_version", com.byazt.apd.tt.c().sp());
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("ad_info", this.c.mk());
            com.byazt.dj.tt ttVarIj = this.c.ij();
            if (ttVarIj != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(ttVarIj.gt()));
                jSONObject.putOpt("rit", ttVarIj.my());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            m.tt("#oncall#", e);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final String str) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.tl.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.tt.get() != null) {
                    h.c((Context) n.this.tt.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str, String str2) throws Throwable {
        HashMap map = null;
        File file = new File(sp.tt(gt.getContext(), false, null), str);
        file.mkdirs();
        gr grVar = (gr) gt.c();
        com.byazt.dj.tt ttVarIj = this.c.ij();
        JSONObject jSONObjectC = grVar.c(ttVarIj, new bm(), ttVarIj.gt(), false, 6, false);
        if (jSONObjectC == null) {
            return;
        }
        com.byazt.bzd.n.c(a.c().tt(jSONObjectC.toString()).uj().toString(), new File(file, "request.info"));
        com.byazt.bzd.n.c(com.byazt.nr.c.c(com.byazt.ogz.x.c((com.byazt.ogz.n) null).a()).toString(), new File(file, "setting.info"));
        com.byazt.bzd.n.c(com.byazt.nr.c.c(this.c.yg()).toString(), new File(file, "meta.info"));
        File fileC = com.byazt.bzd.n.c(file, str + ".zip");
        String strVe = ve(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairC = a.c().c(strVe, false);
        if (pairC != null) {
            map = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairC.second).optString("message"));
            map.put("x-pglcypher", String.valueOf(pairC.first));
        }
        new com.byazt.sml.c().c(this.ve.ve(), fileC, map2, new com.byazt.sml.c.InterfaceC0524c() { // from class: com.byazt.tl.n.5
            @Override // com.byazt.sml.c.InterfaceC0524c
            public void c(String str3) {
                n nVar = n.this;
                nVar.tt(nVar.n ? "已复制广告ID\r\n请前往应用内上报问题" : "反馈上传成功！");
            }

            @Override // com.byazt.sml.c.InterfaceC0524c
            public void c(int i, String str3) {
                n nVar = n.this;
                nVar.tt(nVar.n ? "反馈失败\r\n 请重新复制" : "反馈失败");
            }
        }, map);
        fileC.delete();
        com.byazt.bzd.n.tt(file);
    }

    @Override // com.byazt.sif.c
    public boolean c(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.tt.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return c(this.tt.get(), str, dialog);
    }

    @Override // com.byazt.sif.c
    public boolean c(com.byazt.nc.a aVar, String str, Dialog dialog) {
        com.byazt.vo.ve veVarC = uj.c();
        if (veVarC == null || !TextUtils.equals(aVar.getId(), veVarC.getId()) || !TextUtils.equals(aVar.getName(), veVarC.getName())) {
            return false;
        }
        m.tt("TTAdDislikeImpl", "click feedback :" + aVar.getName() + u15.f19942b + aVar.getId());
        if (this.n) {
            if (this.uj != null) {
                return true;
            }
            String string = UUID.randomUUID().toString();
            this.uj = string;
            c(string, str);
            c(this.uj);
            return true;
        }
        return c(this.tt.get(), str, dialog);
    }

    private void c(String str) {
        try {
            Context context = this.tt.get();
            if (context == null) {
                return;
            }
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Throwable unused) {
        }
    }

    public boolean c(Context context, final String str, Dialog dialog) {
        try {
            if (this.uj == null) {
                this.uj = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.tl.n.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    n nVar = n.this;
                    nVar.c(nVar.uj, str);
                }
            }).setNegativeButton(OptionsPickerHelper.e, new DialogInterface.OnClickListener() { // from class: com.byazt.tl.n.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.ve.uj() + "\n\n您此次反馈的id为：" + this.uj).setCancelable(true).create().show();
            return true;
        } catch (Exception e) {
            m.c(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2) {
        tt("反馈上传中，请您稍等！");
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("upload_oncall") { // from class: com.byazt.tl.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.tt(str, str2);
                } catch (Throwable th) {
                    m.tt("#oncall#", th);
                }
            }
        });
    }

    public static void c(Context context, com.byazt.dyf.tt ttVar, ic icVar) {
        if (ttVar == null || icVar == null) {
            return;
        }
        boolean zCg = gt.tt().cg();
        uj ujVarIj = gt.tt().ij();
        if (ujVarIj == null || TextUtils.isEmpty(ujVarIj.ve())) {
            return;
        }
        if (ujVarIj.tt() || zCg) {
            ttVar.addInterceptor(new n(icVar, context, ujVarIj, zCg));
        }
    }
}
