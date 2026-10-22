package com.byazt.wz;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.dna.u;
import com.byazt.ete.gt;
import com.byazt.ete.i;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ete.pu;
import com.byazt.nr.h;
import com.byazt.omf.rh;
import com.byazt.t.DownloadInfo;
import com.byazt.ukr.yp;
import com.byazt.zz.da;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 65, 71})
public class x {
    public static boolean a(ic icVar) {
        return (icVar == null || icVar.u_() == null || icVar.by() != 1 || !n(icVar) || my.u(icVar)) ? false : true;
    }

    public static int c(ic icVar) {
        if (icVar == null || icVar.en() != 1) {
            return 0;
        }
        if (icVar.st() == 0) {
            return 1;
        }
        if (icVar.st() == 1) {
            return sp(icVar) ? 0 : 1;
        }
        return icVar.st() == 2 ? 2 : 1;
    }

    public static boolean n(ic icVar) {
        gt gtVarU_;
        if (icVar != null && (gtVarU_ = icVar.u_()) != null && gtVarU_.ve() && icVar.by() == 1) {
            return uj(icVar);
        }
        return false;
    }

    private static boolean sp(ic icVar) {
        if (icVar == null) {
            return false;
        }
        return x(icVar);
    }

    public static int tt(ic icVar) {
        DownloadInfo downloadInfoTt;
        if (icVar == null) {
            return Integer.MIN_VALUE;
        }
        try {
            da daVarZm = com.byazt.zz.ve.zm();
            if (daVarZm == null) {
                return Integer.MIN_VALUE;
            }
            if (icVar.z() == null || TextUtils.isEmpty(icVar.z().tt())) {
                String strP = nb.p(icVar);
                List<DownloadInfo> listTt = daVarZm.tt();
                if (listTt == null) {
                    downloadInfoTt = null;
                    break;
                }
                Iterator<DownloadInfo> it = listTt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        downloadInfoTt = null;
                        break;
                    }
                    DownloadInfo next = it.next();
                    if (next != null && TextUtils.equals(strP, next.getPackageName())) {
                        downloadInfoTt = next;
                        break;
                    }
                }
            } else {
                String strTt = icVar.z().tt();
                downloadInfoTt = daVarZm.tt(com.byazt.zz.ve.c(strTt, c(icVar, strTt, true)));
            }
            if (downloadInfoTt == null) {
                return Integer.MIN_VALUE;
            }
            int status = downloadInfoTt.getStatus();
            downloadInfoTt.getStatusAtDbInit();
            downloadInfoTt.getRealStatus();
            return status;
        } catch (Exception e) {
            yp.c().c("createAdDownloadModel", e);
            return Integer.MIN_VALUE;
        }
    }

    private static boolean x(ic icVar) {
        com.byazt.ete.a aVarRh = icVar.rh();
        return (aVarRh == null || TextUtils.isEmpty(aVarRh.yp()) || TextUtils.isEmpty(aVarRh.n()) || TextUtils.isEmpty(aVarRh.sp()) || aVarRh.c() == null || aVarRh.c().size() <= 0 || TextUtils.isEmpty(aVarRh.x()) || TextUtils.isEmpty(aVarRh.i())) ? false : true;
    }

    public static boolean uj(ic icVar) {
        int iSl;
        return (icVar == null || icVar.gy() == null || pu.c(icVar) == 1 || icVar.by() != 1 || (iSl = nb.sl(icVar)) == 1 || iSl == 2 || iSl == 5 || iSl == 6) ? false : true;
    }

    public static String ve(ic icVar) {
        if (icVar == null) {
            return "";
        }
        com.byazt.ete.n nVarZ = icVar.z();
        if (nVarZ != null && !TextUtils.isEmpty(nVarZ.ve())) {
            return nVarZ.ve();
        }
        if (!TextUtils.isEmpty(icVar.an())) {
            return icVar.an();
        }
        if (TextUtils.isEmpty(icVar.op())) {
            return !TextUtils.isEmpty(icVar.ls()) ? icVar.ls() : "";
        }
        return icVar.op();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ic icVar, String str, Context context, String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        c(context, icVar);
        com.byazt.aas.n.tt(icVar, str, context, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(ic icVar, String str, Context context, String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        c(context, icVar);
        com.byazt.aas.n.ve(icVar, str, context, str2);
    }

    public static String c(ic icVar, String str, boolean z) {
        int iYp = gt.yp(icVar);
        String strC = com.byazt.omf.x.m().c(icVar);
        if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(str) && iYp > 0) {
            strC = strC + File.separator + com.byazt.nr.a.tt(str);
        }
        if (TextUtils.isEmpty(str) && !z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", "download_url is null");
                if (icVar != null) {
                    jSONObject.put("reqId", icVar.qy());
                    jSONObject.put("cid", icVar.uj());
                    jSONObject.put("rit", nb.c(icVar, ""));
                }
            } catch (Exception unused) {
            }
            yp.c().c("dl_download_url_empty", jSONObject, (Throwable) null);
        }
        return strC;
    }

    public static void tt(ic icVar, String str, Context context, String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        c(context, icVar);
        com.byazt.aas.n.c(context, str, icVar, str2);
    }

    public static void c(final Context context, ic icVar, String str) {
        if (context == null) {
            context = com.byazt.omf.gt.getContext();
        }
        c(icVar, str);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            h.c(context, "应用信息缺失，暂无法响应下载", 1);
        } else {
            rh.a().post(new com.byazt.bwm.sp("tt_download_toast") { // from class: com.byazt.wz.x.1
                @Override // java.lang.Runnable
                public void run() {
                    h.c(context, "应用信息缺失，暂无法响应下载", 1);
                }
            });
        }
    }

    public static void tt(ic icVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (icVar == null) {
                jSONObject.put("message", "meta is null");
            } else {
                gt gtVarU_ = icVar.u_();
                if (gtVarU_ == null) {
                    jSONObject.put("message", "download_conf is null");
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    gtVarU_.c(jSONObject2);
                    jSONObject.put("message", jSONObject2);
                }
                jSONObject.put("req_id", icVar.qy());
                jSONObject.put("cid", icVar.uj());
                jSONObject.put("rit", nb.c(icVar, ""));
            }
            jSONObject.put("dl_type", str);
        } catch (Exception unused) {
        }
        yp.c().c("download_no_suspend", jSONObject, (Throwable) null);
    }

    public static void c(ic icVar, String str) {
        if (icVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("reqId", icVar.qy());
                jSONObject.putOpt("cid", icVar.uj());
                jSONObject.putOpt("adId", icVar.gu());
                jSONObject.putOpt("dlscene", str);
            } catch (Exception unused) {
            }
            yp.c().c("download_no_response", jSONObject, (Throwable) null);
        }
    }

    public static com.byazt.ete.a c(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
        }
        return com.byazt.omf.c.n(jSONObject);
    }

    public static void c(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectYf = com.byazt.omf.gt.tt().yf();
            int iOptInt = jSONObjectYf != null ? jSONObjectYf.optInt("resume_download_max_count", 5) : 5;
            if ((i & 1) != 0) {
                jSONObject.put("failed_resume_max_count", iOptInt);
            }
            if ((i & 2) != 0) {
                jSONObject.put("paused_resume_max_count", iOptInt);
                jSONObject.put("enable_notification_ui", 2);
            }
            if ((i & 4) != 0) {
                jSONObject.put("uninstall_resume_max_count", iOptInt);
            }
            if ((i & 8) != 0) {
                jSONObject.put("install_queue_enable", 1);
            }
        } catch (Exception unused) {
        }
    }

    public static FrameLayout c(final Context context, final ic icVar, com.byazt.ete.uj ujVar, int i) {
        String strC;
        String strVe;
        String strTt;
        String strSl;
        String str;
        String strN;
        int i2;
        int i3;
        if (context == null) {
            return null;
        }
        com.byazt.ete.a aVarRh = icVar.rh();
        final String strTt2 = nb.tt(icVar);
        if (ujVar != null) {
            strC = ujVar.c();
            strVe = ujVar.ve();
            strTt = ujVar.tt();
            strSl = ujVar.a();
            String strX = ujVar.x();
            strN = ujVar.n();
            str = strX;
        } else if (aVarRh != null) {
            String strYp = aVarRh.yp();
            String strSp = aVarRh.sp();
            String strN2 = aVarRh.n();
            str = null;
            strN = null;
            strSl = aVarRh.sl();
            strC = strYp;
            strVe = strSp;
            strTt = strN2;
        } else {
            strC = null;
            strVe = null;
            strTt = null;
            strSl = null;
            str = null;
            strN = null;
        }
        if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strVe)) {
            return null;
        }
        final int color = Color.parseColor("#99FFFFFF");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("点击");
        sb2.append(i == 8 ? "下" : "上");
        sb2.append("方按钮 立即下载应用");
        sb.append(sb2.toString());
        sb.append("\n应用名称：");
        sb.append(strC);
        sb.append("   |   开发者：");
        sb.append(strVe);
        sb.append("\n版本号：");
        sb.append(strTt);
        if (TextUtils.isEmpty(strSl)) {
            sb.append("  |  功能  |  权限  |  隐私  ");
        } else {
            sb.append("  |  功能  |  权限  |  隐私  |  备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int iIndexOf = sb.indexOf("功能");
        int i4 = iIndexOf + 2;
        int iIndexOf2 = sb.indexOf("隐私");
        int i5 = iIndexOf2 + 2;
        int iIndexOf3 = sb.indexOf("权限");
        int i6 = iIndexOf3 + 2;
        if (TextUtils.isEmpty(strSl)) {
            i2 = i6;
            i3 = 34;
        } else {
            int iIndexOf4 = sb.indexOf("备案");
            int i7 = iIndexOf4 + 2;
            spannableString.setSpan(new StyleSpan(1), iIndexOf4, i7, 34);
            i3 = 34;
            final String str2 = str;
            i2 = i6;
            spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.wz.x.2
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    x.c(icVar, str2, context, strTt2);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(color);
                        textPaint.setUnderlineText(false);
                        textPaint.bgColor = 0;
                    }
                }
            }, iIndexOf4, i7, 34);
        }
        spannableString.setSpan(new StyleSpan(1), iIndexOf, i4, i3);
        final String str3 = strN;
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.wz.x.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                x.tt(icVar, str3, context, strTt2);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(color);
                    textPaint.setUnderlineText(false);
                    textPaint.bgColor = 0;
                }
            }
        }, iIndexOf, i4, i3);
        spannableString.setSpan(new StyleSpan(1), iIndexOf2, i5, i3);
        final String str4 = str;
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.wz.x.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                x.a(icVar, str4, context, strTt2);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(color);
                    textPaint.setUnderlineText(false);
                    textPaint.bgColor = 0;
                }
            }
        }, iIndexOf2, i5, i3);
        int i8 = i2;
        spannableString.setSpan(new StyleSpan(1), iIndexOf3, i8, i3);
        spannableString.setSpan(new ClickableSpan() { // from class: com.byazt.wz.x.5
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                x.n(icVar, str4, context, strTt2);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(color);
                    textPaint.setUnderlineText(false);
                    textPaint.bgColor = 0;
                }
            }
        }, iIndexOf3, i8, i3);
        TextView textView = new TextView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextColor(color);
        textView.setTextSize(1, 10.0f);
        textView.setLineSpacing(9.0f, 1.0f);
        textView.setText(spannableString);
        textView.setGravity(17);
        textView.setHighlightColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(textView, layoutParams);
        return frameLayout;
    }

    private static void c(Context context, ic icVar) {
        HashMap map = new HashMap();
        map.put("downloadstatuscontroller_type", 2);
        String strTt = nb.tt(icVar);
        i.c cVar = new i.c();
        float fA = pf.a(context);
        int displayDpi = ((u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi();
        com.byazt.ddx.uj.c("click", icVar, cVar.c(fA).tt(displayDpi).c((byte) 3).tt(pf.sp(context)).c(tt(icVar)).c(), strTt, true, map, 1, false, false);
    }

    public static void c(ic icVar, String str, Context context, String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        c(context, icVar);
        com.byazt.aas.n.c(icVar, str, context, str2);
    }
}
