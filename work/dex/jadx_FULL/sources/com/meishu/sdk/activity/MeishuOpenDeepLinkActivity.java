package com.meishu.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.aliyun.openapiutil.Client;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.safe.SafeActivity;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.service.d;
import com.meishu.sdk.core.service.e;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.g1;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.p0;
import com.meishu.sdk.core.utils.r0;
import com.meishu.sdk.core.utils.v1;
import com.meishu.sdk.core.utils.w1;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class MeishuOpenDeepLinkActivity extends SafeActivity {
    public static final String KEY_DEEP_LINK = "deep_link";
    public static final String KEY_DEEP_SIGN = "dp_sign";
    public static final String KEY_DEEP_START = "dp_start";
    public static final String KEY_DP_SIGN = "dp_d_sign";
    public static final int REQUEST_CODE_DEEP_LINK = 10010;
    private static final String TAG = "MeishuOpenDeepLinkActivity";
    private String DPSIGN;
    private String dpSign;
    private String[] dpStartUrls;
    private boolean hasAppBackground;
    private boolean isBackground = false;
    private boolean isInner = true;
    private final e onAppStateListener = new com.meishu.sdk.core.service.a() { // from class: com.meishu.sdk.activity.MeishuOpenDeepLinkActivity.2
        public void onActivityPause(Activity activity) {
        }

        public void onActivityResume(Activity activity) {
        }

        public boolean onAppStateUpdate(boolean z) {
            if (z) {
                return false;
            }
            MeishuOpenDeepLinkActivity.this.hasAppBackground = true;
            return false;
        }
    };
    private Boolean openDeepLinkRes;

    private void dpReport(int i) {
        String[] strArr = this.dpStartUrls;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        f.a(i0.b(strArr, i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void goOrigin(String str) {
        byte[] bArrDigest;
        try {
            if (TextUtils.isEmpty(this.dpSign)) {
                dpReport(4);
                jdl(str);
                return;
            }
            try {
                byte[] bArrA = g1.a(this.dpSign);
                if (bArrA != null && bArrA.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    AdSdk.adConfig();
                    sb.append(MSAdConfig.initUUID());
                    try {
                        bArrDigest = MessageDigest.getInstance(Client.HASH_SHA256).digest(sb.toString().getBytes("UTF-8"));
                    } catch (Exception unused) {
                        bArrDigest = null;
                    }
                    if (Arrays.equals(bArrA, bArrDigest)) {
                        dpReport(1);
                        startActivityForResult(v1.a(str, this), 10010);
                        return;
                    }
                }
                dpReport(2);
                startActivityForResult(v1.a(str, this), 10010);
            } catch (Throwable th) {
                th.printStackTrace();
                dpReport(3);
                jdl(str);
            }
        } catch (Throwable unused2) {
            p0.a(false);
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleSIGN(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strA = w1.a(str, str2);
                if (TextUtils.isEmpty(strA)) {
                    goOrigin(str2);
                } else {
                    Intent uri = Intent.parseUri(strA, 0);
                    if (uri.resolveActivity(AdSdk.getContext().getPackageManager()) != null) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void jdl(String str) throws URISyntaxException {
        Intent uri = Intent.parseUri(str, 0);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        uri.setFlags(268435456);
        if (r0.f != null) {
            f.a(str, uri);
        }
        startActivityForResult(uri, 10010);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            p0.a(false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void notifyJumpDeepLinkRes() {
        Boolean bool;
        if (this.isBackground || (bool = this.openDeepLinkRes) == null) {
            return;
        }
        p0.a(bool.booleanValue());
        d.b(this.onAppStateListener);
        finish();
    }

    public static void startOpenDeepLinkActivity(Context context, String str, String str2, String[] strArr, String str3) {
        try {
            Intent intent = new Intent(context, (Class<?>) MeishuOpenDeepLinkActivity.class);
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

    public void safeOnActivityResult(int i, int i2, Intent intent) {
        super.safeOnActivityResult(i, i2, intent);
        if (i == 10010) {
            if (i2 == 0) {
                SdkHandler.getInstance().postDelay(new l() { // from class: com.meishu.sdk.activity.MeishuOpenDeepLinkActivity.1
                    public void notifyRunnableCatch(Throwable th) {
                        super.notifyRunnableCatch(th);
                        MeishuOpenDeepLinkActivity.this.safeFinish();
                    }

                    public void safeRun() {
                        if (MeishuOpenDeepLinkActivity.this.hasAppBackground) {
                            MeishuOpenDeepLinkActivity.this.openDeepLinkRes = Boolean.TRUE;
                        } else {
                            MeishuOpenDeepLinkActivity meishuOpenDeepLinkActivity = MeishuOpenDeepLinkActivity.this;
                            meishuOpenDeepLinkActivity.openDeepLinkRes = Boolean.valueOf(meishuOpenDeepLinkActivity.isBackground);
                        }
                        MeishuOpenDeepLinkActivity.this.notifyJumpDeepLinkRes();
                    }
                }, 100L);
            } else {
                this.openDeepLinkRes = Boolean.TRUE;
                notifyJumpDeepLinkRes();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        d.a(this.onAppStateListener);
        jumpDeepLink(stringExtra);
    }

    public void safeOnDestroy() {
        super.safeOnDestroy();
        d.b(this.onAppStateListener);
    }

    public void safeOnPause() {
        super.safeOnPause();
        this.isBackground = true;
    }

    public void safeOnResume() {
        super.safeOnResume();
        this.isBackground = false;
        notifyJumpDeepLinkRes();
    }
}
