package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.mapapi.UIMsg;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.dk.u;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.byazt.sgn.da;
import com.byazt.sgn.i;
import com.byazt.sgn.m;
import com.byazt.sgn.n;
import com.byazt.sgn.sl;
import com.byazt.sgn.tt;
import com.byazt.sgn.uj;
import com.byazt.sgn.ve;
import com.byazt.sgn.x;
import com.byazt.ux.sp;
import com.byazt.xgx.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hjq.permissions.Permission;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTDelegateActivity extends Activity {
    public static ic c;
    private static sp m;
    private static String nu;
    private static String rh;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uj f29299a;
    private Activity da;
    private x i;
    private da n;
    private ve sl;
    private n sp;
    private tt t;
    private Intent tt;
    private sl u;
    private com.byazt.dyf.tt uj;
    private AlertDialog ve;
    private Dialog x;
    private i yp;
    private m z;

    @com.byazt.zqa.c(c = {0, 80, 81, 82, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, 331, MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, UIMsg.f_FUN.FUN_ID_UTIL_ACTION})
    public static class c extends com.byazt.bwm.sp {
        public c(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.byazt.dk.uj ujVarUj = u.uj();
            if (ujVarUj != null) {
                Function<SparseArray<Object>, Object> functionNb = com.byazt.omf.x.m().nb();
                if (functionNb != null) {
                    ujVarUj.c(com.byazt.yxi.ve.tt(functionNb).booleanValue(1));
                }
                ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getImsi(null);
            }
        }
    }

    private void a() {
        ApplicationInfo applicationInfo;
        int i = Build.VERSION.SDK_INT;
        try {
            com.byazt.dj.uj ujVarMy = com.byazt.omf.x.m().my();
            boolean zIsCanUsePhoneState = ujVarMy.isCanUsePhoneState();
            boolean zIsCanUseWriteExternal = ujVarMy.isCanUseWriteExternal();
            ArrayList arrayList = new ArrayList();
            com.byazt.qh.tt.c(ujVarMy, arrayList);
            if (zIsCanUsePhoneState) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
            Context context = gt.getContext();
            if (context != null && (applicationInfo = context.getApplicationInfo()) != null) {
                if (applicationInfo.targetSdkVersion >= 33 && i >= 33) {
                    arrayList.add(Permission.POST_NOTIFICATIONS);
                } else if (zIsCanUseWriteExternal) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            com.byazt.xgx.n.c().c(this.da, strArr, new a() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                @Override // com.byazt.xgx.a
                public void c() {
                    com.byazt.bwm.n.c(new c("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.xgx.a
                public void c(String str) {
                    "android.permission.READ_PHONE_STATE".equals(str);
                    com.byazt.bwm.n.c(new c("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void n() {
        try {
            Intent intent = this.tt;
            if (intent == null) {
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.tt.getStringExtra("app_download_url");
            this.tt.getStringExtra("app_name");
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    a();
                    break;
                case 3:
                    ve(stringExtra, this.tt.getStringExtra("dialog_title"), this.tt.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    tt(this.tt.getStringExtra("permission_id_key"), this.tt.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    tt(stringExtra, this.tt.getStringExtra("dialog_title"), this.tt.getStringExtra("dialog_content_key"), this.tt.getStringExtra("dialog_btn_yes_key"), this.tt.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    n(this.tt.getStringExtra("materialmeta"));
                    break;
                case 7:
                    ve(stringExtra);
                    break;
                case 8:
                    c(this.tt.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    ve(this.tt.getStringExtra("dialog_app_privacy_url"), stringExtra);
                    break;
                case 10:
                    tt(this.tt.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    uj(this.tt.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    tt(this.tt.getStringExtra("web_url"), this.tt.getStringExtra("web_title"));
                    break;
                case 13:
                    tt();
                    break;
                case 14:
                    c(this.tt.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                    break;
                case 15:
                    c(this.tt.getStringExtra("web_url"));
                    break;
                case 16:
                    c(this.tt.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ve veVar = this.sl;
        if (veVar == null || veVar.isShowing()) {
            return;
        }
        this.sl.c();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.da = this;
        uj();
        this.tt = getIntent();
        if (gt.getContext() == null) {
            gt.c(this.da);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            c = null;
            AlertDialog alertDialog = this.ve;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.ve.dismiss();
            }
            x xVar = this.i;
            if (xVar == null || !xVar.isShowing()) {
                com.byazt.aas.n.c(nu);
            } else {
                com.byazt.aas.n.c(this.i.c());
                if (this.i.isShowing()) {
                    this.i.dismiss();
                }
            }
            uj ujVar = this.f29299a;
            if (ujVar != null && ujVar.isShowing()) {
                this.f29299a.dismiss();
            }
            ve veVar = this.sl;
            if (veVar != null) {
                if (veVar.isShowing()) {
                    this.sl.dismiss();
                }
                com.byazt.aas.n.c(this.sl.uj());
            } else {
                com.byazt.aas.n.c(rh);
            }
            tt ttVar = this.t;
            if (ttVar != null && ttVar.isShowing()) {
                this.t.dismiss();
            }
            n nVar = this.sp;
            if (nVar != null && nVar.isShowing()) {
                this.sp.dismiss();
            }
            sl slVar = this.u;
            if (slVar != null && slVar.isShowing()) {
                this.u.dismiss();
            }
            Dialog dialog = this.x;
            if (dialog != null && dialog.isShowing()) {
                this.x.dismiss();
            }
            nu = null;
            rh = null;
        } catch (Throwable th) {
            com.byazt.nr.m.ve("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (gt.getContext() == null) {
            gt.c(this.da);
        }
        try {
            setIntent(intent);
            this.tt = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        x xVar = this.i;
        if (xVar != null) {
            nu = xVar.c();
        }
        ve veVar = this.sl;
        if (veVar != null) {
            rh = veVar.uj();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.byazt.xgx.n.c().c(this.da, strArr, iArr);
        com.byazt.bwm.n.c(new c("onRequestPermissionsResult"), 1);
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            n();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        ve();
    }

    public static void tt(Context context, String str, String str2) {
        if (context == null) {
            context = gt.getContext();
        }
        com.byazt.ete.a aVarC = com.byazt.wz.x.c(str2);
        if (aVarC == null) {
            return;
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 9);
        intentC.putExtra("dialog_app_privacy_url", aVarC.x());
        intentC.putExtra("app_download_url", str);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void uj(Context context, String str, String str2) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 12);
        intentC.putExtra("web_url", str);
        intentC.putExtra("web_title", str2);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void ve(Context context, String str, String str2) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 14);
        intentC.putExtra("dialog_app_desc_url", str2);
        intentC.putExtra("app_download_url", str);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void c(String str, String[] strArr) {
        Intent intent = new Intent(gt.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (gt.getContext() != null) {
            com.byazt.nr.tt.c(gt.getContext(), intent, new com.byazt.nr.tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.byazt.nr.tt.c
                public void c() {
                }

                @Override // com.byazt.nr.tt.c
                public void c(Throwable th) {
                    com.byazt.nr.m.ve("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    private void uj() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void ve() {
        if (com.byazt.omf.x.m().to()) {
            if (this.sl == null && this.i == null && this.u == null) {
                return;
            }
            com.byazt.omf.x.m().da(false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.byazt.ddx.uj.c(str, "click_other", str3, str2, new com.byazt.ya.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
            }
        });
    }

    public static void tt(Context context, String str) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 11);
        intentC.putExtra("dialog_app_ad_info", str);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    private void uj(String str) {
        try {
            if (pf.i(this.da)) {
                sl slVar = this.u;
                if (slVar != null) {
                    slVar.dismiss();
                }
                sl slVar2 = new sl(this.da, str);
                this.u = slVar2;
                slVar2.c(new sl.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.byazt.sgn.sl.c
                    public void c(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.u.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void ve(final String str) {
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strSl;
        String str8;
        String str9;
        float fVe;
        String str10;
        Intent intent = this.tt;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.tt.getStringExtra("event_adId");
        final String stringExtra3 = this.tt.getStringExtra("event_TAG");
        String stringExtra4 = this.tt.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.tt.getStringExtra("dialog_title");
        final String stringExtra6 = this.tt.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.tt.getStringExtra("dialog_app_description");
        boolean z = false;
        boolean booleanExtra = this.tt.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        try {
            JSONArray jSONArray2 = null;
            String strOptString = "";
            float f = 0.0f;
            if (TextUtils.isEmpty(stringExtra4)) {
                str2 = stringExtra4;
                jSONArray = null;
                str3 = null;
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = str6;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                com.byazt.ete.a aVarC = com.byazt.wz.x.c(stringExtra4);
                if (aVarC != null) {
                    String strN = aVarC.n();
                    String strSp = aVarC.sp();
                    String strDa = aVarC.da();
                    String strYp = aVarC.yp();
                    if (!TextUtils.isEmpty(strYp)) {
                        stringExtra5 = strYp;
                    }
                    JSONArray jSONArrayUj = aVarC.uj();
                    fVe = aVarC.ve();
                    strSl = aVarC.sl();
                    strOptString = stringExtra5;
                    str8 = strN;
                    str10 = strSp;
                    jSONArray2 = jSONArrayUj;
                    str9 = strDa;
                } else {
                    strSl = null;
                    str8 = "";
                    str9 = str8;
                    fVe = 0.0f;
                    str10 = str9;
                }
                String strOptString2 = jSONObject.optString("ugen_url");
                String strOptString3 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    jSONObject.put("app_name", strOptString);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put("description", stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z = true;
                }
                str2 = stringExtra4;
                str6 = strOptString;
                str3 = strSl;
                str7 = str9;
                str4 = str8;
                strOptString = jSONObject.optString("hand_icon_url");
                jSONArray = jSONArray2;
                float f2 = fVe;
                str5 = str10;
                f = f2;
            }
            if (booleanExtra) {
                c(str, str2, stringExtra6, stringExtra7, str4, str5, str6, jSONArray, f, str7, str3, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            if (z) {
                final String str11 = str2;
                final float f3 = f;
                final String str12 = strOptString;
                final JSONArray jSONArray3 = jSONArray;
                final String str13 = str4;
                final String str14 = str5;
                final String str15 = str6;
                final String str16 = str7;
                final String str17 = str3;
                c(str, str2, new sp() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.byazt.ux.sp
                    public void c(int i, String str18) {
                        TTDelegateActivity.this.c(str, str11, stringExtra6, f3, stringExtra7, str12, jSONArray3, str13, str14, str15, str16, str17, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.i != null) {
                            TTDelegateActivity.this.i.c((sp) null);
                        }
                        if (TTDelegateActivity.m != null) {
                            TTDelegateActivity.m.c(i, str18);
                        }
                    }

                    @Override // com.byazt.ux.sp
                    public void c(com.byazt.xj.ve<View> veVar) {
                        if (TTDelegateActivity.m != null) {
                            TTDelegateActivity.m.c(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
                return;
            }
            c(str, str2, stringExtra6, f, stringExtra7, strOptString, jSONArray, str4, str5, str6, str7, str3, stringExtra2, stringExtra3, stringExtra);
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 3);
        intentC.putExtra("app_download_url", str);
        intentC.putExtra("dialog_title", str2);
        intentC.putExtra("dialog_content_key", str3);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    private void tt() {
        try {
            if (this.yp == null) {
                this.yp = new i(this.da, getIntent());
            }
            if (this.yp.isShowing()) {
                this.yp.dismiss();
            }
            this.yp.c(new i.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.byazt.sgn.i.c
                public void c(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.yp.show();
        } catch (Throwable unused) {
        }
    }

    private static Intent c(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private void tt(String str) {
        try {
            if (pf.i(this.da)) {
                Dialog dialog = this.x;
                if (dialog == null || !dialog.isShowing()) {
                    com.byazt.sgn.c cVar = new com.byazt.sgn.c(this.da, str);
                    this.x = cVar;
                    cVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.x.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(sp spVar) {
        m = spVar;
    }

    public static void c(Context context, String str, String str2, String str3, sp spVar, ic icVar) {
        try {
            c = icVar;
            m = spVar;
            if (context == null) {
                context = gt.getContext();
            }
            Intent intentC = c(context);
            JSONObject jSONObject = new JSONObject(str3);
            intentC.putExtra("type", 7);
            intentC.putExtra("app_download_url", str);
            intentC.putExtra("dialog_app_manage_model", str2);
            if (icVar != null) {
                intentC.putExtra("event_adId", icVar.uj());
                intentC.putExtra("event_extInfo", icVar.w_());
                intentC.putExtra("event_TAG", nb.tt(icVar));
            }
            intentC.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            intentC.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            intentC.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            intentC.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.byazt.nr.tt.c(context, intentC, null);
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    private void tt(String str, String str2) {
        try {
            if (pf.i(this.da)) {
                uj ujVar = this.f29299a;
                if (ujVar != null) {
                    ujVar.dismiss();
                }
                uj ujVar2 = new uj(this.da, str, str2);
                this.f29299a = ujVar2;
                ujVar2.c(new uj.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.byazt.sgn.uj.c
                    public void c(Dialog dialog) {
                        if (TTDelegateActivity.this.f29299a != null) {
                            TTDelegateActivity.this.f29299a.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.f29299a.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void tt(final String str, String str2, String str3, String str4, String str5) {
        if (pf.i(this.da)) {
            AlertDialog alertDialog = this.ve;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.n == null) {
                this.n = new da(this.da).c(str2).tt(str3).ve(str4).uj(str5).c(new da.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.byazt.sgn.da.c
                    public void c(Dialog dialog) {
                        com.byazt.aas.n.tt(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.sgn.da.c
                    public void tt(Dialog dialog) {
                        com.byazt.aas.n.ve(str);
                        TTDelegateActivity.this.finish();
                    }
                }).c(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        com.byazt.aas.n.uj(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.n.isShowing()) {
                this.n.show();
            }
            this.ve = this.n;
        }
    }

    private void n(String str) {
        if (pf.i(this.da)) {
            if (str != null && this.uj == null) {
                try {
                    ic icVarC = com.byazt.omf.c.c(new JSONObject(str));
                    if (icVarC != null) {
                        com.byazt.dyf.tt ttVar = new com.byazt.dyf.tt(this.da, icVarC.wq(), false, com.byazt.xky.tt.c());
                        this.uj = ttVar;
                        com.byazt.tl.ve.c(this.da, icVarC, ttVar);
                        this.uj.setDislikeInteractionCallback(new com.byazt.dyf.tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.byazt.dyf.tt.c
                            public void c() {
                            }

                            @Override // com.byazt.dyf.tt.c
                            public void c(int i, String str2, boolean z) {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.byazt.dyf.tt.c
                            public void tt() {
                                TTDelegateActivity.this.finish();
                            }
                        });
                    }
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }
            com.byazt.dyf.tt ttVar2 = this.uj;
            if (ttVar2 != null) {
                ttVar2.showDislikeDialog();
            }
        }
    }

    public static void c(Context context, String str, String str2, String str3, ic icVar) {
        if (context == null) {
            try {
                context = gt.getContext();
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                return;
            }
        }
        Intent intentC = c(context);
        JSONObject jSONObject = new JSONObject(str3);
        intentC.putExtra("type", 7);
        intentC.putExtra("app_download_url", str);
        intentC.putExtra("dialog_app_manage_model", str2);
        if (icVar != null) {
            intentC.putExtra("event_adId", icVar.uj());
            intentC.putExtra("event_extInfo", icVar.w_());
            intentC.putExtra("event_TAG", nb.tt(icVar));
        }
        intentC.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        intentC.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        intentC.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        intentC.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.byazt.nr.tt.c(context, intentC, null);
    }

    private void ve(String str, String str2) {
        if (this.tt == null) {
            return;
        }
        c(str, str2, 2, true, (Dialog) null);
    }

    private void ve(final String str, String str2, String str3) {
        if (pf.i(this.da)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "提示";
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            c(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.byazt.aas.n.tt(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.byazt.aas.n.ve(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.byazt.aas.n.uj(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void tt(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            try {
                com.byazt.xgx.n.c().c(this.da, strArr, new a() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                    @Override // com.byazt.xgx.a
                    public void c() {
                        com.byazt.aas.a.c(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.xgx.a
                    public void c(String str2) {
                        com.byazt.aas.a.c(str, str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        finish();
    }

    public static void c(Context context, String str, String str2) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 8);
        intentC.putExtra("app_download_url", str);
        intentC.putExtra("dialog_app_manage_model", str2);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void c(Context context, String str) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 10);
        intentC.putExtra("dialog_content_key", str);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void c(Context context, String str, String str2, ic icVar) {
        if (context == null) {
            context = gt.getContext();
        }
        com.byazt.ete.a aVarC = com.byazt.wz.x.c(str2);
        if (aVarC == null) {
            return;
        }
        if (icVar != null) {
            tt(nb.tt(icVar), icVar.w_(), icVar.uj());
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 16);
        intentC.putExtra("dialog_app_registration_url", aVarC.sl());
        intentC.putExtra("app_download_url", str);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 5);
        intentC.putExtra("app_download_url", str);
        intentC.putExtra("dialog_title", str2);
        intentC.putExtra("dialog_content_key", str3);
        intentC.putExtra("dialog_btn_yes_key", str4);
        intentC.putExtra("dialog_btn_no_key", str5);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void c(Context context, ic icVar) {
        JSONObject jSONObjectYg;
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 6);
        if (icVar != null && (jSONObjectYg = icVar.yg()) != null) {
            intentC.putExtra("materialmeta", jSONObjectYg.toString());
        }
        if (context != null) {
            try {
                context.startActivity(intentC);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(String str) {
        if (this.z == null) {
            this.z = new m(this.da, str);
        }
        if (this.z.isShowing()) {
            this.z.dismiss();
        }
        this.z.c(new m.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.byazt.sgn.m.c
            public void c(String str2) {
                com.byazt.aas.n.tt(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.sgn.m.c
            public void tt(String str2) {
                com.byazt.aas.n.uj(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.z.show();
    }

    public static void c(Context context, String str, boolean z) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 15);
        if (!z) {
            intentC.putExtra("web_url", str);
        }
        com.byazt.nr.tt.c(context, intentC, null);
    }

    public static void c(Context context, String str, ic icVar) {
        if (context == null) {
            context = gt.getContext();
        }
        Intent intentC = c(context);
        intentC.putExtra("type", 13);
        c = icVar;
        intentC.putExtra("event_tag", str);
        com.byazt.nr.tt.c(context, intentC, null);
    }

    private void c(String str, String str2, sp spVar, String str3, String str4, String str5) {
        if (pf.i(this.da)) {
            if (TextUtils.isEmpty(str2)) {
                spVar.c(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                ve veVar = this.sl;
                if (veVar == null || !veVar.isShowing()) {
                    ve veVarI = new com.byazt.sgn.u(this.da, jSONObject, spVar).i(str);
                    this.sl = veVarI;
                    ((com.byazt.sgn.u) veVarI).tt(c(str, str2, str3, str4, str5));
                    this.sl.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void c(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        c(str, str2, str7, f, new sp() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.byazt.ux.sp
            public void c(int i, String str13) {
                TTDelegateActivity.this.c(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.i != null) {
                    TTDelegateActivity.this.i.c((sp) null);
                }
                if (TTDelegateActivity.m != null) {
                    TTDelegateActivity.m.c(i, str13);
                }
            }

            @Override // com.byazt.ux.sp
            public void c(com.byazt.xj.ve<View> veVar) {
                if (TTDelegateActivity.m != null) {
                    TTDelegateActivity.m.c(null);
                }
            }
        }, str10, str11, str12);
    }

    private void c(final String str, final String str2, String str3, float f, sp spVar, final String str4, final String str5, final String str6) {
        if (pf.i(this.da)) {
            if (TextUtils.isEmpty(str2)) {
                spVar.c(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f);
                JSONObject jSONObjectC = com.byazt.xs.da.c(jSONObject.getString("ugen_dialog_url"), jSONObject.getString("ugen_dialog_md5"), (com.byazt.xs.ve) null);
                if (jSONObjectC == null) {
                    spVar.c(8, "uegnTemplate is empty");
                    return;
                }
                x xVar = this.i;
                if (xVar == null || !xVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    x xVar2 = new x(str, this.da, jSONObjectC, jSONObject2, spVar, c);
                    this.i = xVar2;
                    xVar2.c(new com.byazt.sgn.sp.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        public com.byazt.ete.a sp = null;

                        @Override // com.byazt.sgn.sp.c
                        public void c(Dialog dialog) {
                            com.byazt.aas.n.tt(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.byazt.sgn.sp.c
                        public void tt(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.c(str2, str, false, (Dialog) tTDelegateActivity.i);
                            if (TTDelegateActivity.this.i != null) {
                                TTDelegateActivity.this.i.hide();
                            }
                        }

                        @Override // com.byazt.sgn.sp.c
                        public void uj(Dialog dialog) {
                            if (this.sp == null) {
                                this.sp = com.byazt.wz.x.c(str2);
                            }
                            com.byazt.ete.a aVar = this.sp;
                            if (aVar != null) {
                                TTDelegateActivity.this.c(aVar.x(), str, 2, false, (Dialog) TTDelegateActivity.this.i);
                            }
                            if (TTDelegateActivity.this.i != null) {
                                TTDelegateActivity.this.i.hide();
                            }
                        }

                        @Override // com.byazt.sgn.sp.c
                        public void ve(Dialog dialog) {
                            com.byazt.aas.n.uj(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.byazt.sgn.sp.c
                        public void c() {
                            if (this.sp == null) {
                                this.sp = com.byazt.wz.x.c(str2);
                            }
                            com.byazt.ete.a aVar = this.sp;
                            if (aVar != null) {
                                TTDelegateActivity.this.c(aVar.i(), str, 1, false, (Dialog) TTDelegateActivity.this.i);
                            }
                            if (TTDelegateActivity.this.i != null) {
                                TTDelegateActivity.this.i.hide();
                            }
                        }
                    });
                    this.i.show();
                }
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (pf.i(this.da)) {
            ve veVar = this.sl;
            if (veVar == null || !veVar.isShowing()) {
                ve veVarC = new ve(this.da).c(str8).n(str6).a(str9).tt(str3).x(str7).i(str).ve(str5).c(f).c(jSONArray).sp(str10).uj(str4).c(c(str, str2, str11, str12, str13));
                this.sl = veVarC;
                veVarC.show();
            }
        }
    }

    private ve.c c(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new ve.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            public com.byazt.ete.a sp = null;

            @Override // com.byazt.sgn.ve.c
            public void a(Dialog dialog) {
                TTDelegateActivity.tt(str4, str5, str3);
                if (this.sp == null) {
                    this.sp = com.byazt.wz.x.c(str2);
                }
                com.byazt.ete.a aVar = this.sp;
                if (aVar == null) {
                    return;
                }
                TTDelegateActivity.this.c(aVar.sl(), str, 3, false, (Dialog) null);
            }

            @Override // com.byazt.sgn.ve.c
            public void c(Dialog dialog) {
                com.byazt.aas.n.tt(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.byazt.sgn.ve.c
            public void n(Dialog dialog) {
                if (this.sp == null) {
                    this.sp = com.byazt.wz.x.c(str2);
                }
                com.byazt.ete.a aVar = this.sp;
                if (aVar == null) {
                    return;
                }
                TTDelegateActivity.this.c(aVar.i(), str, 1, false, (Dialog) null);
            }

            @Override // com.byazt.sgn.ve.c
            public void tt(Dialog dialog) {
                TTDelegateActivity.this.c(str2, str, false, (Dialog) null);
            }

            @Override // com.byazt.sgn.ve.c
            public void uj(Dialog dialog) {
                if (this.sp == null) {
                    this.sp = com.byazt.wz.x.c(str2);
                }
                com.byazt.ete.a aVar = this.sp;
                if (aVar != null) {
                    TTDelegateActivity.this.c(aVar.x(), str, 2, false, (Dialog) null);
                }
            }

            @Override // com.byazt.sgn.ve.c
            public void ve(Dialog dialog) {
                com.byazt.aas.n.uj(str);
                TTDelegateActivity.this.finish();
            }
        };
    }

    private void c(String str, String str2) {
        if (this.tt == null) {
            return;
        }
        c(str, str2, true, (Dialog) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final String str2, int i, final boolean z, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (pf.i(this.da)) {
                n nVar = this.sp;
                if (nVar != null) {
                    nVar.dismiss();
                }
                if (i == 1) {
                    str3 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                    str4 = "应用简介";
                } else if (i == 2) {
                    str3 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                    str4 = "隐私政策";
                } else if (i == 3) {
                    str4 = "备案信息";
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
                n nVar2 = new n(this.da, str, str3, str4);
                this.sp = nVar2;
                nVar2.c(new n.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.byazt.sgn.n.c
                    public void c(Dialog dialog2) {
                        com.byazt.aas.n.tt(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.sgn.n.c
                    public void tt(Dialog dialog2) {
                        com.byazt.aas.n.uj(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.sgn.n.c
                    public void ve(Dialog dialog2) {
                        if (TTDelegateActivity.this.sp != null) {
                            if (z) {
                                com.byazt.aas.n.uj(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.sp.dismiss();
                            }
                        }
                    }
                });
                this.sp.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, final String str2, final boolean z, final Dialog dialog) {
        try {
            if (pf.i(this.da)) {
                tt ttVar = this.t;
                if (ttVar != null) {
                    ttVar.dismiss();
                }
                tt ttVar2 = new tt(this.da, str);
                this.t = ttVar2;
                ttVar2.c(new tt.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.byazt.sgn.tt.c
                    public void c(Dialog dialog2) {
                        com.byazt.aas.n.tt(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.sgn.tt.c
                    public void tt(Dialog dialog2) {
                        com.byazt.aas.n.uj(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.sgn.tt.c
                    public void ve(Dialog dialog2) {
                        if (TTDelegateActivity.this.t != null) {
                            if (z) {
                                com.byazt.aas.n.uj(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.t.dismiss();
                            }
                        }
                    }
                });
                this.t.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void c(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.ve == null) {
                this.ve = new AlertDialog.Builder(this.da, R.style.Theme.DeviceDefault.Light.Dialog).create();
            }
            Window window = this.ve.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 17;
                window.setAttributes(attributes);
            }
            this.ve.setTitle(String.valueOf(str));
            this.ve.setMessage(String.valueOf(str2));
            this.ve.setButton(-1, "确定", onClickListener);
            this.ve.setButton(-2, OptionsPickerHelper.e, onClickListener2);
            this.ve.setOnCancelListener(onCancelListener);
            if (this.ve.isShowing()) {
                return;
            }
            this.ve.show();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }
}
