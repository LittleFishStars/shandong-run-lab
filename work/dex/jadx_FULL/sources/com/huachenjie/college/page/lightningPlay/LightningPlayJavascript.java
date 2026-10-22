package com.huachenjie.college.page.lightningPlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.base.dsbridge_webview.CompletionHandler;
import com.huachenjie.base.dsbridge_webview.DWebView;
import com.huachenjie.base.share.ShareLinkCallback;
import com.huachenjie.college.page.lightningPlay.LightningPlayJavascript;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import com.huachenjie.push.interfaces.InternalShareLink;
import com.zj.adlib.ai9;
import com.zj.adlib.ew;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.gv1;
import com.zj.adlib.jd4;
import com.zj.adlib.p59;
import com.zj.adlib.vb8;
import com.zj.adlib.y88;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.WebPageBody;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class LightningPlayJavascript {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<ILightningPlayProvider> f33602a;

    public interface ILightningPlayProvider {
        void a(Runnable runnable);

        default void b(long j, int i, boolean z) {
        }

        DWebView c();

        default String d() {
            return "";
        }

        Context getContext();

        Lifecycle getLifecycle();
    }

    public class a extends RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f33603a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ILightningPlayProvider f8460a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long[] f8463a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f8462a = false;
        public boolean b = false;

        public a(long[] jArr, CompletionHandler completionHandler, ILightningPlayProvider iLightningPlayProvider) {
            this.f8463a = jArr;
            this.f33603a = completionHandler;
            this.f8460a = iLightningPlayProvider;
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void b(int i) {
            LightningPlayJavascript lightningPlayJavascript = LightningPlayJavascript.this;
            CompletionHandler completionHandler = this.f33603a;
            boolean z = this.f8462a;
            lightningPlayJavascript.j(completionHandler, z, this.b, z ? "播放成功" : "播放时长不足");
            long[] jArr = this.f8463a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long[] jArr2 = this.f8463a;
            long j = jArr2[0];
            jArr[1] = (jCurrentTimeMillis - j) / 1000;
            this.f8460a.b(j, (int) jArr2[1], this.f8462a);
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void c(int i, String str, String str2) {
            LightningPlayJavascript.this.j(this.f33603a, false, false, "播放失败,视频加载错误");
            this.f8460a.b(this.f8463a[0], 0, false);
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void d(int i, String str) {
            this.f8462a = true;
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void e(int i, String str) {
            this.f8463a[0] = System.currentTimeMillis();
            this.b = true;
        }
    }

    public class b implements ShareLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f33604a;

        public b(CompletionHandler completionHandler) {
            this.f33604a = completionHandler;
        }

        @Override // com.huachenjie.base.share.ShareLinkCallback
        public void a(boolean z) {
            LightningPlayJavascript.this.k(this.f33604a, "result", Boolean.valueOf(z));
        }
    }

    public class c implements ShareLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f33605a;

        public c(CompletionHandler completionHandler) {
            this.f33605a = completionHandler;
        }

        @Override // com.huachenjie.base.share.ShareLinkCallback
        public void a(boolean z) {
            LightningPlayJavascript.this.k(this.f33605a, "result", Boolean.valueOf(z));
        }
    }

    public LightningPlayJavascript(ILightningPlayProvider iLightningPlayProvider) {
        this.f33602a = new WeakReference<>(iLightningPlayProvider);
    }

    public static /* synthetic */ void n(ILightningPlayProvider iLightningPlayProvider) {
        try {
            Activity activity = gv1.getActivity(iLightningPlayProvider.getContext());
            if (activity != null) {
                activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void o(JSONObject jSONObject, ILightningPlayProvider iLightningPlayProvider, CompletionHandler completionHandler) {
        try {
            CommonUserInfo commonUserInfoE = ai9.e();
            jSONObject.put(UserConstants.URL_PARAMS.b, iLightningPlayProvider.d());
            jSONObject.put("avatar", commonUserInfoE.getAvatar());
            jSONObject.put(NicknameFragment.NICKNAME, commonUserInfoE.getUserName());
            completionHandler.a(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void p(ILightningPlayProvider iLightningPlayProvider, JSONObject jSONObject, CompletionHandler completionHandler) {
        try {
            if (iLightningPlayProvider.c().canGoBack()) {
                iLightningPlayProvider.c().goBack();
                jSONObject.put("result", true);
            } else {
                jSONObject.put("result", false);
            }
            completionHandler.a(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void q(ILightningPlayProvider iLightningPlayProvider, Object obj) {
        try {
            Activity activity = gv1.getActivity(iLightningPlayProvider.getContext());
            if (activity != null) {
                LightningPlayActivity.INSTANCE.a(activity, ((JSONObject) obj).optString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x006d  */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void r(String str, Context context, String str2, String str3, String str4, String str5, final CompletionHandler completionHandler) {
        byte b2;
        try {
            FlavourName flavourName = null;
            Bitmap bitmap = !TextUtils.isEmpty(str) ? (Bitmap) Glide.with(context).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).submit(100, 100).get() : null;
            int iHashCode = str2.hashCode();
            if (iHashCode != -1718220377) {
                if (iHashCode != -1707903162) {
                    if (iHashCode != 2592) {
                        if (iHashCode == 83459272 && str2.equals("Weibo")) {
                            b2 = 3;
                        } else {
                            b2 = -1;
                        }
                    } else if (str2.equals("QQ")) {
                        b2 = 2;
                    } else {
                        b2 = -1;
                    }
                } else if (str2.equals("Wechat")) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (str2.equals("WechatTimeline")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                flavourName = FlavourName.WX_SESSION;
            } else if (b2 == 1) {
                flavourName = FlavourName.WX_MOMENT;
            } else if (b2 == 2) {
                flavourName = FlavourName.QQ;
            } else if (b2 == 3) {
                flavourName = FlavourName.SINA;
            }
            if (flavourName == null) {
                fv5.b("平台参数错误");
            } else {
                y88.i(context, new WebPageBody(flavourName, "", str3, str4, str5, bitmap), new ShareListener() { // from class: com.huachenjie.college.page.lightningPlay.LightningPlayJavascript.4
                    public void onCancel(@Nullable FlavourName flavourName2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        completionHandler.a(jSONObject);
                    }

                    public void onFailed(FlavourName flavourName2, int i, String str6) {
                        JSONObject jSONObject = new JSONObject();
                        if (i == 1) {
                            try {
                                fv5.b(str6);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        jSONObject.put("result", false);
                        completionHandler.a(jSONObject);
                    }

                    public void onSuccess(FlavourName flavourName2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", true);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        completionHandler.a(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Object obj, ILightningPlayProvider iLightningPlayProvider, final CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            final String strOptString = jSONObject.optString("to");
            final String strOptString2 = jSONObject.optString("title");
            final String strOptString3 = jSONObject.optString("desc");
            final String strOptString4 = jSONObject.optString("url");
            final String strOptString5 = jSONObject.optString("imageUrl");
            final Context context = iLightningPlayProvider.getContext();
            FragmentActivity fragmentActivityA = gv1.a(context);
            if (TextUtils.equals(strOptString, "Friend")) {
                InternalShareLink internalShareLinkB = jd4.a().b();
                if (internalShareLinkB == null || fragmentActivityA == null) {
                    return;
                }
                internalShareLinkB.b(fragmentActivityA, jSONObject.toString(), new b(completionHandler));
                return;
            }
            if (!TextUtils.equals(strOptString, "Group")) {
                p59.a().execute(new Runnable() { // from class: com.zj.adlib.qx4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19198a.r(strOptString5, context, strOptString, strOptString4, strOptString2, strOptString3, completionHandler);
                    }
                });
                return;
            }
            InternalShareLink internalShareLinkB2 = jd4.a().b();
            if (internalShareLinkB2 != null) {
                internalShareLinkB2.a(fragmentActivityA, jSONObject.toString(), new c(completionHandler));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ILightningPlayProvider iLightningPlayProvider, CompletionHandler completionHandler) {
        Activity activity = gv1.getActivity(iLightningPlayProvider.getContext());
        if (activity == null || activity.isFinishing()) {
            j(completionHandler, false, false, "界面参数错误");
            return;
        }
        long[] jArr = {0, 0};
        jArr[0] = System.currentTimeMillis();
        ew.j().i(vb8.i, activity, iLightningPlayProvider.getLifecycle(), new a(jArr, completionHandler, iLightningPlayProvider));
    }

    @JavascriptInterface
    @Keep
    public void closePage(Object obj, CompletionHandler<Object> completionHandler) {
        if (m().booleanValue()) {
            return;
        }
        final ILightningPlayProvider iLightningPlayProvider = this.f33602a.get();
        iLightningPlayProvider.a(new Runnable() { // from class: com.zj.adlib.mx4
            @Override // java.lang.Runnable
            public final void run() {
                LightningPlayJavascript.n(iLightningPlayProvider);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void copyToClipboard(Object obj, CompletionHandler<Object> completionHandler) {
        if (obj == null || !(obj instanceof JSONObject) || m().booleanValue()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                gm1.b(((JSONObject) obj).optString("text"));
                jSONObject.put("result", true);
            } catch (Exception e) {
                try {
                    jSONObject.put("result", false);
                    e.printStackTrace();
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                }
            }
            completionHandler.a(jSONObject);
        } catch (Throwable th) {
            completionHandler.a(jSONObject);
            throw th;
        }
    }

    @JavascriptInterface
    @Keep
    public void getAppUserInfo(Object obj, final CompletionHandler<Object> completionHandler) {
        final JSONObject jSONObject = new JSONObject();
        if (m().booleanValue()) {
            completionHandler.a(jSONObject);
        } else {
            final ILightningPlayProvider iLightningPlayProvider = this.f33602a.get();
            iLightningPlayProvider.a(new Runnable() { // from class: com.zj.adlib.ox4
                @Override // java.lang.Runnable
                public final void run() {
                    LightningPlayJavascript.o(jSONObject, iLightningPlayProvider, completionHandler);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void goBack(Object obj, final CompletionHandler<Object> completionHandler) {
        final JSONObject jSONObject = new JSONObject();
        if (m().booleanValue()) {
            completionHandler.a(jSONObject);
        } else {
            final ILightningPlayProvider iLightningPlayProvider = this.f33602a.get();
            iLightningPlayProvider.a(new Runnable() { // from class: com.zj.adlib.lx4
                @Override // java.lang.Runnable
                public final void run() {
                    LightningPlayJavascript.p(iLightningPlayProvider, jSONObject, completionHandler);
                }
            });
        }
    }

    public final void j(CompletionHandler<Object> completionHandler, boolean z, boolean z2, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("result", Boolean.valueOf(z));
        linkedHashMap.put("message", str);
        linkedHashMap.put("loadSuccess", Boolean.valueOf(z2));
        l(completionHandler, linkedHashMap);
    }

    public final void k(CompletionHandler<Object> completionHandler, String str, Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, obj);
        l(completionHandler, linkedHashMap);
    }

    public final void l(CompletionHandler<Object> completionHandler, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        completionHandler.a(jSONObject);
    }

    public final Boolean m() {
        return Boolean.valueOf(this.f33602a.get() == null);
    }

    @JavascriptInterface
    @Keep
    public void openMoxiWebview(final Object obj, CompletionHandler<Object> completionHandler) {
        JSONObject jSONObject = new JSONObject();
        if (m().booleanValue()) {
            completionHandler.a(jSONObject);
        } else {
            final ILightningPlayProvider iLightningPlayProvider = this.f33602a.get();
            iLightningPlayProvider.a(new Runnable() { // from class: com.zj.adlib.nx4
                @Override // java.lang.Runnable
                public final void run() {
                    LightningPlayJavascript.q(iLightningPlayProvider, obj);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void shareLink(final Object obj, final CompletionHandler<Object> completionHandler) {
        if (obj == null || !(obj instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (m().booleanValue()) {
            completionHandler.a(jSONObject);
        } else {
            final ILightningPlayProvider iLightningPlayProvider = this.f33602a.get();
            iLightningPlayProvider.a(new Runnable() { // from class: com.zj.adlib.kx4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17819a.s(obj, iLightningPlayProvider, completionHandler);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void showRewardVideo(Object obj, final CompletionHandler<Object> completionHandler) {
        if (m().booleanValue()) {
            j(completionHandler, false, false, "播放失败,视频加载错误");
        } else {
            final ILightningPlayProvider iLightningPlayProvider = this.f33602a.get();
            iLightningPlayProvider.a(new Runnable() { // from class: com.zj.adlib.px4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18950a.t(iLightningPlayProvider, completionHandler);
                }
            });
        }
    }
}
