package com.kc.dw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.kc.dw.core.safe.SafeActivity;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.a2;
import com.kc.dw.core.utils.b2;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.m0;
import com.kc.dw.core.utils.p0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdOpenDeepLinkActivity extends SafeActivity {
    public static final String KEY_DEEP_LINK = "deep_link";
    public static final String KEY_DEEP_SIGN = "dp_sign";
    public static final String KEY_DEEP_START = "dp_start";
    public static final String KEY_DP_SIGN = "dp_d_sign";
    public static final int REQUEST_CODE_DEEP_LINK = 10010;
    private static final String TAG = "SsdOpenDeepLinkActivity";
    private String DPSIGN;
    private String dpSign;
    private String[] dpStartUrls;
    private boolean hasAppBackground;
    private boolean isBackground = false;
    private final com.kc.dw.core.router.service.a.InterfaceC1044a onAppStateListener = new com.kc.dw.core.router.service.a.InterfaceC1044a(this) { // from class: com.kc.dw.activity.SsdOpenDeepLinkActivity.2
        public final SsdOpenDeepLinkActivity this$0;

        {
            this.this$0 = this;
        }

        @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
        public void onActivityPause(Activity activity) {
        }

        @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
        public void onActivityResume(Activity activity) {
        }

        @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
        public void onAppStateUpdate(boolean z) {
            if (z) {
                return;
            }
            this.this$0.hasAppBackground = true;
        }
    };
    private Boolean openDeepLinkRes;

    private void dpReport(int i) {
        String[] strArr = this.dpStartUrls;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        f.a(g0.b(strArr, i));
    }

    private void goOrigin(String str) {
        try {
            if (!TextUtils.isEmpty(this.dpSign)) {
                try {
                    dpReport(1);
                    startActivityForResult(a2.a(str, this), 10010);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    dpReport(3);
                    jdl(str);
                }
            }
            dpReport(4);
            jdl(str);
        } catch (Throwable unused) {
            m0.a(false);
            finish();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002d A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:8:0x0023, B:9:0x002d), top: B:15:0x0000 }] */
    private void handleSIGN(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strA = b2.a(str, str2);
                if (TextUtils.isEmpty(strA)) {
                    goOrigin(str2);
                } else {
                    Intent uri = Intent.parseUri(strA, 0);
                    if (uri.resolveActivity(com.kc.dw.base.a.getContext().getPackageManager()) != null) {
                        dpReport(1);
                        startActivityForResult(uri, 10010);
                    } else {
                        goOrigin(str2);
                    }
                }
            }
        } catch (Throwable th) {
            goOrigin(str2);
            th.printStackTrace();
        }
    }

    private void jdl(String str) throws URISyntaxException {
        Intent uri = Intent.parseUri(str, 0);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        uri.setFlags(268435456);
        if (p0.i != null) {
            f.a(str, uri);
        }
        startActivityForResult(uri, 10010);
    }

    private void jumpDeepLink(String str) {
        try {
            if (TextUtils.isEmpty(this.DPSIGN)) {
                goOrigin(str);
            } else {
                handleSIGN(this.DPSIGN, str);
            }
        } catch (Throwable th) {
            LogUtil.d(TAG, "jumpDeepLink error");
            th.printStackTrace();
            m0.a(false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJumpDeepLinkRes() {
        if (this.isBackground || this.openDeepLinkRes == null) {
            return;
        }
        String str = TAG;
        StringBuilder sbA = a.a("notifyJumpDeepLinkRes:");
        sbA.append(this.openDeepLinkRes);
        LogUtil.d(str, sbA.toString());
        m0.a(this.openDeepLinkRes.booleanValue());
        com.kc.dw.core.router.helper.a.b(this.onAppStateListener);
        finish();
    }

    public static void startOpenDeepLinkActivity(Context context, String str, String str2, String[] strArr, String str3) {
        try {
            Intent intent = new Intent(context, (Class<?>) SsdOpenDeepLinkActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra("deep_link", str);
            intent.putExtra("dp_sign", str2);
            intent.putExtra("dp_start", strArr);
            intent.putExtra("dp_d_sign", str3);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnActivityResult(int i, int i2, Intent intent) {
        super.safeOnActivityResult(i, i2, intent);
        if (i == 10010) {
            if (i2 == 0) {
                SdkHandler.getInstance().postDelay(new j(this) { // from class: com.kc.dw.activity.SsdOpenDeepLinkActivity.1
                    public final SsdOpenDeepLinkActivity this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.safe.j
                    public void notifyRunnableCatch(Exception exc) {
                        super.notifyRunnableCatch(exc);
                        this.this$0.safeFinish();
                    }

                    @Override // com.kc.dw.core.safe.j
                    public void safeRun() {
                        SsdOpenDeepLinkActivity ssdOpenDeepLinkActivity;
                        Boolean boolValueOf;
                        if (this.this$0.hasAppBackground) {
                            ssdOpenDeepLinkActivity = this.this$0;
                            boolValueOf = Boolean.TRUE;
                        } else {
                            ssdOpenDeepLinkActivity = this.this$0;
                            boolValueOf = Boolean.valueOf(ssdOpenDeepLinkActivity.isBackground);
                        }
                        ssdOpenDeepLinkActivity.openDeepLinkRes = boolValueOf;
                        this.this$0.notifyJumpDeepLinkRes();
                    }
                }, 100L);
            } else {
                this.openDeepLinkRes = Boolean.TRUE;
                notifyJumpDeepLinkRes();
            }
        }
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        getWindow().setStatusBarColor(0);
        String stringExtra = getIntent().getStringExtra("deep_link");
        this.dpSign = getIntent().getStringExtra("dp_sign");
        try {
            this.DPSIGN = getIntent().getStringExtra("dp_d_sign");
        } catch (Throwable unused) {
        }
        this.dpStartUrls = getIntent().getStringArrayExtra("dp_start");
        com.kc.dw.core.router.helper.a.a(this.onAppStateListener);
        jumpDeepLink(stringExtra);
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        com.kc.dw.core.router.helper.a.b(this.onAppStateListener);
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnPause() {
        super.safeOnPause();
        this.isBackground = true;
    }

    @Override // com.kc.dw.core.safe.SafeActivity
    public void safeOnResume() {
        super.safeOnResume();
        this.isBackground = false;
        notifyJumpDeepLinkRes();
    }
}
