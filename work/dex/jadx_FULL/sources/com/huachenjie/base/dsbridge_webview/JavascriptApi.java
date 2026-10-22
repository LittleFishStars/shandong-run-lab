package com.huachenjie.base.dsbridge_webview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.location.LocationClientOption;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.gson.Gson;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.base.bean.JackpotBean;
import com.huachenjie.base.dialog.lottery.LotteryDialog;
import com.huachenjie.base.dsbridge_webview.JavascriptApi;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.base.module_bridge.interfaces.IMMethodLoader;
import com.huachenjie.base.module_bridge.interfaces.MallMethodLoader;
import com.huachenjie.base.share.ShareLinkCallback;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.callback.ValueCallback;
import com.huachenjie.common.callback.VoidCallback;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.HttpDownloader;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.push.interfaces.InternalShareLink;
import com.igexin.assist.sdk.AssistPushConsts;
import com.zj.adlib.ai9;
import com.zj.adlib.ba1;
import com.zj.adlib.cr2;
import com.zj.adlib.ee1;
import com.zj.adlib.en6;
import com.zj.adlib.ew;
import com.zj.adlib.fe9;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.gv1;
import com.zj.adlib.h44;
import com.zj.adlib.i4a;
import com.zj.adlib.il0;
import com.zj.adlib.it9;
import com.zj.adlib.j14;
import com.zj.adlib.jd4;
import com.zj.adlib.kq5;
import com.zj.adlib.lj0;
import com.zj.adlib.p59;
import com.zj.adlib.q65;
import com.zj.adlib.qa6;
import com.zj.adlib.r57;
import com.zj.adlib.s91;
import com.zj.adlib.su9;
import com.zj.adlib.t14;
import com.zj.adlib.t47;
import com.zj.adlib.vo6;
import com.zj.adlib.wf3;
import com.zj.adlib.y88;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.ImageBody;
import huachenjie.sdk.share.sharebody.MessageBody;
import huachenjie.sdk.share.sharebody.WebPageBody;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class JavascriptApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DWebView f32913a;

    public class a implements ShareLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f32915a;

        public a(final CompletionHandler val$handler) {
            this.f32915a = val$handler;
        }

        @Override // com.huachenjie.base.share.ShareLinkCallback
        public void a(boolean success) {
            JavascriptApi.this.V(this.f32915a, "result", Boolean.valueOf(success));
        }
    }

    public class b implements ShareLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f32916a;

        public b(final CompletionHandler val$handler) {
            this.f32916a = val$handler;
        }

        @Override // com.huachenjie.base.share.ShareLinkCallback
        public void a(boolean success) {
            JavascriptApi.this.V(this.f32916a, "result", Boolean.valueOf(success));
        }
    }

    public class c implements HttpDownloader.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f32917a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompletionHandler f7192a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f7194a;

        public c(final List val$imageList, final int val$index, final CompletionHandler val$handler) {
            this.f7194a = val$imageList;
            this.f32917a = val$index;
            this.f7192a = val$handler;
        }

        @Override // com.huachenjie.common.util.HttpDownloader.Callback
        public void onFailed(int code, String message) {
            i4a.a(code + message);
            JavascriptApi.this.Q0(this.f7194a, this.f32917a + 1, this.f7192a);
        }

        @Override // com.huachenjie.common.util.HttpDownloader.Callback
        public void onSuccess(File file) {
            wf3.n(file.getPath(), JavascriptApi.this.f32913a.getContext());
            JavascriptApi.this.Q0(this.f7194a, this.f32917a + 1, this.f7192a);
        }
    }

    public class d extends RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f32918a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f7196a = false;

        public d(final CompletionHandler val$handler) {
            this.f32918a = val$handler;
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void b(int i) {
            JavascriptApi.this.V(this.f32918a, "result", Integer.valueOf(!this.f7196a ? 1 : 0));
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void c(int loadSupplier, String code, String message) {
            JavascriptApi.this.V(this.f32918a, "result", 2);
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void d(int loadSupplier, String platform) {
            this.f7196a = true;
        }
    }

    public class e implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f32919a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JSONObject f7198a;

        public e(final JSONObject val$jsonObject, final CompletionHandler val$handler) {
            this.f7198a = val$jsonObject;
            this.f32919a = val$handler;
        }

        public void onLocationListener(int i, HCJAddressInfo hcjAddressInfo) {
            try {
                this.f7198a.put("latitude", hcjAddressInfo.getLat());
                this.f7198a.put("longitude", hcjAddressInfo.getLng());
                this.f7198a.put("province", hcjAddressInfo.getProvinceName());
                this.f7198a.put("city", hcjAddressInfo.getCityName());
                this.f32919a.a(this.f7198a);
            } catch (Exception unused) {
                this.f32919a.a(this.f7198a);
            }
        }
    }

    public class f implements DWebView.ChooseImageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionHandler f32920a;

        public f(final CompletionHandler val$handler) {
            this.f32920a = val$handler;
        }

        @Override // com.huachenjie.base.dsbridge_webview.DWebView.ChooseImageListener
        public void onCancel() {
            JavascriptApi.this.V(this.f32920a, "files", new ArrayList());
        }

        @Override // com.huachenjie.base.dsbridge_webview.DWebView.ChooseImageListener
        public void onResult(List<String> paths) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = paths.iterator();
            while (it.hasNext()) {
                jSONArray.put(s91.f19553a + it.next());
            }
            JavascriptApi.this.V(this.f32920a, "files", jSONArray);
        }
    }

    public JavascriptApi(DWebView webView) {
        this.f32913a = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(RoutePathConstants.SocialContact.g).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(Object obj, CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(RoutePathConstants.SocialContact.f).withString(UserConstants.SOCIAL_CONTACT_PARAMS.c, ((JSONObject) obj).optString("packCode")).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(CompletionHandler completionHandler, Object obj) {
        JSONObject jSONObject;
        try {
            try {
                Activity activity = gv1.getActivity(this.f32913a);
                if (activity == null) {
                    V(completionHandler, "result", Boolean.TRUE);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("result", true);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    completionHandler.a(jSONObject2);
                    return;
                }
                il0.f42382a.d(activity, ((JSONObject) obj).optString("link"));
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", true);
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                }
                completionHandler.a(jSONObject);
            } catch (Exception e4) {
                e4.printStackTrace();
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", true);
                } catch (JSONException e5) {
                    e = e5;
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result", true);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            completionHandler.a(jSONObject3);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x003b  */
    public /* synthetic */ void E0(Object obj, CompletionHandler completionHandler) {
        FragmentActivity fragmentActivity;
        try {
            String strOptString = ((JSONObject) obj).optString("posId");
            if (TextUtils.isEmpty(strOptString)) {
                V(completionHandler, "result", 2);
                return;
            }
            Context context = this.f32913a.getContext();
            if (context == null) {
                return;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                if (baseContext instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) baseContext;
                } else {
                    fragmentActivity = null;
                }
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity == null) {
                return;
            }
            ew.j().i(strOptString, fragmentActivity, this.f32913a.getLifecycle(), new d(completionHandler));
        } catch (Exception unused) {
            V(completionHandler, "result", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(CompletionHandler completionHandler) {
        V(completionHandler, "result", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(CompletionHandler completionHandler) {
        V(completionHandler, "result", Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(Object obj, final CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            qa6.a().b().b(this.f32913a.getContext(), jSONObject.optString("userName"), jSONObject.optString("path"), new VoidCallback() { // from class: com.zj.adlib.xj4
                @Override // com.huachenjie.common.callback.VoidCallback
                public final void a() {
                    this.f20669a.F0(completionHandler);
                }
            }, new VoidCallback() { // from class: com.zj.adlib.yj4
                @Override // com.huachenjie.common.callback.VoidCallback
                public final void a() {
                    this.f20860a.G0(completionHandler);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(String str, final String str2, final CompletionHandler completionHandler) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Glide.with(this.f32913a.getContext()).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(new SimpleTarget<Bitmap>() { // from class: com.huachenjie.base.dsbridge_webview.JavascriptApi.4
                @Override // com.bumptech.glide.request.target.Target
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                    y88.i(JavascriptApi.this.f32913a.getContext(), new ImageBody("Wechat".equals(str2) ? FlavourName.WX_SESSION : FlavourName.WX_MOMENT, "", resource), new ShareListener() { // from class: com.huachenjie.base.dsbridge_webview.JavascriptApi.4.1
                        public void onCancel(@Nullable FlavourName flavour) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("result", false);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            completionHandler.a(jSONObject);
                        }

                        public void onFailed(FlavourName flavour, int code, String message) {
                            JSONObject jSONObject = new JSONObject();
                            if (code == 1) {
                                try {
                                    fv5.b(message);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            jSONObject.put("result", false);
                            completionHandler.a(jSONObject);
                        }

                        public void onSuccess(FlavourName flavour) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("result", true);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            completionHandler.a(jSONObject);
                        }
                    });
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", false);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            completionHandler.a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void J0(String str, String str2, String str3, String str4, String str5, final CompletionHandler completionHandler) {
        byte b2;
        try {
            FlavourName flavourName = null;
            Bitmap bitmap = !TextUtils.isEmpty(str) ? (Bitmap) Glide.with(this.f32913a.getContext()).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).submit(100, 100).get() : null;
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
                y88.i(this.f32913a.getContext(), new WebPageBody(flavourName, "", str3, str4, str5, bitmap), new ShareListener() { // from class: com.huachenjie.base.dsbridge_webview.JavascriptApi.3
                    public void onCancel(@Nullable FlavourName flavour) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", false);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        completionHandler.a(jSONObject);
                    }

                    public void onFailed(FlavourName flavour, int code, String message) {
                        JSONObject jSONObject = new JSONObject();
                        if (code == 1) {
                            try {
                                fv5.b(message);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        jSONObject.put("result", false);
                        completionHandler.a(jSONObject);
                    }

                    public void onSuccess(FlavourName flavour) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", true);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        completionHandler.a(jSONObject);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(JSONObject jSONObject, CompletionHandler completionHandler) {
        InternalShareLink internalShareLinkB = jd4.a().b();
        if (internalShareLinkB != null) {
            internalShareLinkB.b((FragmentActivity) this.f32913a.getContext(), jSONObject.toString(), new a(completionHandler));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(JSONObject jSONObject, CompletionHandler completionHandler) {
        InternalShareLink internalShareLinkB = jd4.a().b();
        if (internalShareLinkB != null) {
            internalShareLinkB.a((FragmentActivity) this.f32913a.getContext(), jSONObject.toString(), new b(completionHandler));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(CompletionHandler completionHandler, Integer num) {
        V(completionHandler, "result", num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(final CompletionHandler completionHandler, Object obj) {
        try {
            Context context = this.f32913a.getContext();
            if (context == null) {
                V(completionHandler, "result", 0);
                return;
            }
            FragmentActivity fragmentActivityA = gv1.a(context);
            if (fragmentActivityA == null) {
                V(completionHandler, "result", 0);
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            String strOptString = jSONObject.optString("price");
            String strOptString2 = jSONObject.optString("tradeNo");
            int iOptInt = jSONObject.optInt("payRemainTime");
            String strOptString3 = jSONObject.optString("orderNo");
            String strOptString4 = jSONObject.optString("shopNo");
            if (TextUtils.isEmpty(strOptString)) {
                V(completionHandler, "result", 0);
                return;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                V(completionHandler, "result", 0);
                return;
            }
            if (TextUtils.isEmpty(strOptString3)) {
                V(completionHandler, "result", 0);
                return;
            }
            if (TextUtils.isEmpty(strOptString4)) {
                V(completionHandler, "result", 0);
                return;
            }
            MallMethodLoader mallMethodLoaderB = q65.a().b();
            if (mallMethodLoaderB == null) {
                V(completionHandler, "result", 0);
            } else {
                mallMethodLoaderB.a(fragmentActivityA, strOptString, strOptString2, Integer.valueOf(iOptInt), strOptString3, strOptString4, new ValueCallback() { // from class: com.zj.adlib.zj4
                    @Override // com.huachenjie.common.callback.ValueCallback
                    public final void onCallback(Object obj2) {
                        this.f21067a.M0(completionHandler, (Integer) obj2);
                    }
                });
            }
        } catch (Exception unused) {
            V(completionHandler, "result", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(CompletionHandler completionHandler, JSONObject jSONObject) {
        try {
            try {
                ViewParent parent = this.f32913a.getParent();
                if (parent != null && (parent instanceof SpineWebView)) {
                    ((SpineWebView) parent).loadSpineFinish();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            completionHandler.a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Object obj, CompletionHandler completionHandler) throws JSONException {
        JSONObject jSONObject = (JSONObject) obj;
        ((PayWebViewActivity) this.f32913a.getContext()).J0(jSONObject.optInt("type"), jSONObject.optInt("goodsSubType"), jSONObject.optInt("payType"), jSONObject.optString("goodsCode"), completionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(CompletionHandler completionHandler) {
        try {
            t14.a(this.f32913a.getContext());
            completionHandler.a(new JSONObject());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    public /* synthetic */ void Z(Object obj, CompletionHandler completionHandler) {
        byte b2;
        try {
            JSONObject jSONObject = (JSONObject) obj;
            String strOptString = jSONObject.optString(IpcMessageConstants.EXTRA_EVENT);
            int iHashCode = strOptString.hashCode();
            if (iHashCode != -749172007) {
                if (iHashCode == 726184773 && strOptString.equals("checkResult")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (strOptString.equals("getSecretKey")) {
                b2 = 0;
            } else {
                b2 = -1;
            }
            if (b2 == 0) {
                V(completionHandler, "secretKey", "Ukp3hmSe7BmMcgbE");
            } else {
                if (b2 != 1) {
                    return;
                }
                ee1.a(this.f32913a.getContext(), jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD));
                V(completionHandler, "result", Boolean.TRUE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Object obj, CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            this.f32913a.showChooseImage(jSONObject.optInt("count", 1), jSONObject.optInt("size", 1000), new f(completionHandler));
        } catch (Exception unused) {
            V(completionHandler, "files", new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(CompletionHandler completionHandler) {
        try {
            Context context = this.f32913a.getContext();
            if (context != null) {
                ba1.j(context.getFilesDir().getAbsolutePath());
            }
            this.f32913a.clearHistory();
            this.f32913a.clearFormData();
            this.f32913a.clearSslPreferences();
            this.f32913a.clearMatches();
            this.f32913a.clearCache(true);
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(JSONObject jSONObject, CompletionHandler completionHandler) {
        try {
            jSONObject.put("version", com.blankj.utilcode.util.b.C());
            Activity activity = gv1.getActivity(this.f32913a);
            if (activity == null) {
                completionHandler.a(jSONObject);
                return;
            }
            jSONObject.put("statusBarHeight", cr2.b(activity, com.gyf.immersionbar.e.H0(activity)));
            jSONObject.put("navigationBarHeight", cr2.b(activity, com.gyf.immersionbar.e.o0(activity)));
            completionHandler.a(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(CompletionHandler completionHandler, JSONObject jSONObject, boolean z, boolean z2) {
        if (z2) {
            lj0.o(this.f32913a.getContext(), z, LocationClientOption.LocationMode.Hight_Accuracy, new e(jSONObject, completionHandler));
        } else {
            completionHandler.a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(String str, final CompletionHandler completionHandler, final boolean z) {
        final JSONObject jSONObject = new JSONObject();
        vo6.j(this.f32913a.getContext(), "android.permission.ACCESS_FINE_LOCATION", str, new PermissionResultListener() { // from class: com.zj.adlib.bk4
            @Override // com.huachenjie.common.util.permission.PermissionResultListener
            public final void onResult(boolean z2) {
                this.f15542a.d0(completionHandler, jSONObject, z, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(CompletionHandler completionHandler, JSONArray jSONArray) {
        V(completionHandler, GoodsSpecificationPreviewActivity.z, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(final CompletionHandler completionHandler) {
        IMMethodLoader iMMethodLoaderB = h44.a().b();
        if (iMMethodLoaderB == null) {
            V(completionHandler, GoodsSpecificationPreviewActivity.z, new ArrayList());
        } else {
            iMMethodLoaderB.a(new ValueCallback() { // from class: com.zj.adlib.ej4
                @Override // com.huachenjie.common.callback.ValueCallback
                public final void onCallback(Object obj) {
                    this.f16324a.f0(completionHandler, (JSONArray) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Object obj, CompletionHandler completionHandler) {
        try {
            String strOptString = ((JSONObject) obj).optString("type");
            if (TextUtils.isEmpty(strOptString)) {
                V(completionHandler, "status", Boolean.FALSE);
                return;
            }
            Context context = this.f32913a.getContext();
            if (context == null) {
                V(completionHandler, "status", Boolean.FALSE);
                return;
            }
            if (((strOptString.hashCode() == -213840400 && strOptString.equals("PUSH_NOTIFICATION")) ? (byte) 0 : (byte) -1) != 0) {
                return;
            }
            V(completionHandler, "status", Boolean.valueOf(t47.d(context)));
        } catch (Exception unused) {
            V(completionHandler, "status", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f32913a.canGoBack()) {
                this.f32913a.goBack();
                jSONObject.put("result", true);
            } else {
                jSONObject.put("result", false);
            }
            completionHandler.a(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(zj7.c.HW_HEALTH).navigation();
            V(completionHandler, "result", Boolean.TRUE);
            Activity activity = gv1.getActivity(this.f32913a);
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.finish();
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public /* synthetic */ void k0(Object obj, CompletionHandler completionHandler) {
        byte b2;
        try {
            i4a.c("luckyDrawEvent");
            JSONObject jSONObject = (JSONObject) obj;
            String strOptString = jSONObject.optString(IpcMessageConstants.EXTRA_EVENT);
            i4a.c("eventName:" + strOptString);
            switch (strOptString.hashCode()) {
                case -473810896:
                    if (!strOptString.equals("allReward")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case -289381720:
                    if (!strOptString.equals("dailyReward")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case -134624513:
                    if (!strOptString.equals("changeReward")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 3091780:
                    if (!strOptString.equals(MediationConstant.RIT_TYPE_DRAW)) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 1564195625:
                    if (!strOptString.equals("character")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                ARouter.getInstance().build(zj7.e.CHANGE_REWARD).withBoolean(yj7.c.KEY_CHANGE_IMPORTANT_REWARD, true).navigation();
            } else if (b2 == 1) {
                j14.b(this.f32913a.getContext(), "全部宝物");
                ARouter.getInstance().build(zj7.e.CHANGE_REWARD).navigation();
            } else if (b2 == 2) {
                j14.b(this.f32913a.getContext(), "每日必修");
                ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
            } else if (b2 == 3) {
                j14.a(this.f32913a.getContext());
                ARouter.getInstance().build(zj7.i.DORMITORY).navigation();
            } else if (b2 == 4) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(AssistPushConsts.MSG_TYPE_PAYLOAD);
                i4a.c("payload:" + jSONObject2);
                FragmentManager fragmentManagerB = gv1.b(this.f32913a.getContext());
                if (fragmentManagerB == null) {
                    V(completionHandler, "result", Boolean.FALSE);
                    return;
                }
                JackpotBean jackpotBean = (JackpotBean) new Gson().fromJson(jSONObject2.toString(), JackpotBean.class);
                j14.e(this.f32913a.getContext(), jackpotBean.getLotteryType());
                if (jackpotBean.getJackpotUse() > jackpotBean.getTotalInspiration()) {
                    fv5.b("闪金币不足，前往每日必修完成任务后领取闪金币");
                } else {
                    LotteryDialog.INSTANCE.a(fragmentManagerB, jackpotBean.getLotteryDesc(), jackpotBean.getJackpotNo(), jackpotBean.getJackpotUse(), jackpotBean.getAwardNo(), 1);
                    HashMap map = new HashMap();
                    map.put("jackpotName", jackpotBean.getJackpotName());
                    kq5.b(this.f32913a.getContext(), MobClickConstants.i, map);
                }
            }
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(CompletionHandler completionHandler) {
        V(completionHandler, "result", Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(CompletionHandler completionHandler) {
        V(completionHandler, "result", Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(Object obj, final CompletionHandler completionHandler) {
        try {
            try {
                String strOptString = ((JSONObject) obj).optString("link");
                i4a.a(strOptString);
                qa6.a().b().a(this.f32913a.getContext(), strOptString, new VoidCallback() { // from class: com.zj.adlib.aj4
                    @Override // com.huachenjie.common.callback.VoidCallback
                    public final void a() {
                        this.f15278a.l0(completionHandler);
                    }
                }, new VoidCallback() { // from class: com.zj.adlib.bj4
                    @Override // com.huachenjie.common.callback.VoidCallback
                    public final void a() {
                        this.f15540a.m0(completionHandler);
                    }
                });
            } catch (Exception e2) {
                fv5.b("您暂未安装相关APP");
                e2.printStackTrace();
            }
        } finally {
            V(completionHandler, "result", Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(CompletionHandler completionHandler, String str, String str2, String str3, Boolean bool) {
        if (bool.booleanValue()) {
            ARouter.getInstance().build(zj7.b.BUDDY_CHAT).withString("buddyCode", str).withString("buddyTitle", str2).withString(yj7.b.BUDDY_ROOM_ID, str3).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } else {
            fv5.b("创建聊天失败,请重试");
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(Object obj, final CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            final String strOptString = jSONObject.optString("buddyCode");
            final String strOptString2 = jSONObject.optString(UserConstants.CHAT_TEAM_PARAMS.b);
            final String strOptString3 = jSONObject.optString("chatTeamId");
            IMMethodLoader iMMethodLoaderB = h44.a().b();
            if (iMMethodLoaderB == null) {
                V(completionHandler, "result", Boolean.FALSE);
            } else {
                iMMethodLoaderB.b(new ValueCallback() { // from class: com.zj.adlib.xi4
                    @Override // com.huachenjie.common.callback.ValueCallback
                    public final void onCallback(Object obj2) {
                        this.f20666a.o0(completionHandler, strOptString, strOptString2, strOptString3, (Boolean) obj2);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(CompletionHandler completionHandler) {
        DWebView dWebView;
        try {
            Object objNavigation = ARouter.getInstance().build(RoutePathConstants.SocialContact.h).navigation();
            if ((objNavigation instanceof BaseDialogFragment) && (dWebView = this.f32913a) != null && (dWebView.getContext() instanceof FragmentActivity)) {
                ((BaseDialogFragment) objNavigation).show(((FragmentActivity) this.f32913a.getContext()).getSupportFragmentManager(), "EXCHANGE_WORLD_CRYSTALS_DIALOG");
                V(completionHandler, "result", Boolean.TRUE);
            } else {
                V(completionHandler, "result", Boolean.FALSE);
            }
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(Object obj, CompletionHandler completionHandler) {
        try {
            try {
                String strOptString = ((JSONObject) obj).optString("link");
                i4a.a(strOptString);
                ARouter.getInstance().build(RoutePathConstants.Base.b).withString("url", strOptString).navigation();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            V(completionHandler, "result", Boolean.TRUE);
        }
    }

    public static /* synthetic */ void s0(Object obj, CompletionHandler completionHandler) {
        JSONObject jSONObject;
        try {
            try {
                ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", ((JSONObject) obj).optString("link")).navigation();
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", true);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", true);
                } catch (JSONException e4) {
                    e = e4;
                    e.printStackTrace();
                }
            }
            completionHandler.a(jSONObject);
        } catch (Throwable th) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", true);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            completionHandler.a(jSONObject2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(Object obj, CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(zj7.g.MALL_CAT).withString("catNo", ((JSONObject) obj).optString("catNo")).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(CompletionHandler completionHandler) {
        try {
            Activity activity = gv1.getActivity(this.f32913a);
            if (activity == null) {
                V(completionHandler, "result", 0);
            } else {
                r57.i(activity);
                V(completionHandler, "result", Boolean.TRUE);
            }
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(Object obj, CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", jSONObject.optString("goodsNo")).withInt("squareType", jSONObject.optInt("squareType")).withString("cooperationNo", jSONObject.optString("cooperationNo")).withString("source", jSONObject.optString("source")).withString("traceNo", jSONObject.optString("traceNo")).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(zj7.g.SHOPPING_MESSAGE).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Object obj, CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(zj7.g.ORDER_DETAIL).withString("orderNo", ((JSONObject) obj).optString("orderNo")).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(Object obj, CompletionHandler completionHandler) {
        try {
            ARouter.getInstance().build(zj7.g.MERCHANTS).withString("shopNo", ((JSONObject) obj).optString("shopNo")).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            e2.printStackTrace();
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(Object obj, CompletionHandler completionHandler) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            String strOptString = jSONObject.optString("accId");
            jSONObject.optString("shopName");
            ARouter.getInstance().build(RoutePathConstants.IM.b).withString(UserConstants.CHAT_PARAMS.f33725a, strOptString).withInt(UserConstants.CHAT_PARAMS.b, 4).navigation();
            V(completionHandler, "result", Boolean.TRUE);
        } catch (Exception unused) {
            V(completionHandler, "result", Boolean.FALSE);
        }
    }

    public void P0() {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        ViewParent parent = dWebView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f32913a);
        }
        this.f32913a.removeAllViews();
        this.f32913a.destroy();
        this.f32913a = null;
    }

    public final void Q0(List<String> imageList, final int index, final CompletionHandler<Object> handler) {
        if (index >= imageList.size()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", true);
                handler.a(jSONObject);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        String str = imageList.get(index);
        if (this.f32913a == null) {
            Q0(imageList, index + 1, handler);
            return;
        }
        String str2 = en6.K() + File.separator + System.currentTimeMillis();
        i4a.a(str2);
        HttpDownloader.a(str, str2, new c(imageList, index, handler));
    }

    public final void V(CompletionHandler<Object> handler, String key, Object value) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, value);
        W(handler, linkedHashMap);
    }

    public final void W(CompletionHandler<Object> handler, Map<String, Object> params) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : params.keySet()) {
                jSONObject.put(str, params.get(str));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        handler.a(jSONObject);
    }

    @JavascriptInterface
    @Keep
    public void androidPay(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView != null && (args instanceof JSONObject) && (dWebView.getContext() instanceof PayWebViewActivity)) {
            this.f32913a.post(new Runnable() { // from class: com.zj.adlib.ui4
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f20077a.X(args, handler);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void backToHome(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.hk4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16996a.Y(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void bindWeixinAccount(Object args, CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        try {
            dWebView.cacheWechatAuth(handler);
            it9.h().r();
        } catch (Exception unused) {
            W(handler, new LinkedHashMap());
        }
    }

    @JavascriptInterface
    @Keep
    public void captchaVerify(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.nj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18419a.Z(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void chooseImage(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.wj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20455a.a0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void clearWebCache(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            V(handler, "result", Boolean.FALSE);
        } else {
            dWebView.post(new Runnable() { // from class: com.zj.adlib.lj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17975a.b0(handler);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void copyToClipboard(Object args, CompletionHandler<Object> handler) {
        if (this.f32913a == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                gm1.b(((JSONObject) args).optString("text"));
                jSONObject.put("result", true);
            } catch (Exception e2) {
                try {
                    jSONObject.put("result", false);
                    e2.printStackTrace();
                } catch (JSONException e3) {
                    throw new RuntimeException(e3);
                }
            }
            handler.a(jSONObject);
        } catch (Throwable th) {
            handler.a(jSONObject);
            throw th;
        }
    }

    @JavascriptInterface
    @Keep
    public void deleteFilmMoment(Object args, CompletionHandler<Object> handler) {
        if (this.f32913a == null || !(args instanceof JSONObject)) {
            return;
        }
        try {
            Intent intent = new Intent(su9.b);
            JSONObject jSONObject = (JSONObject) args;
            intent.putExtra("momentDailyRecordCode", jSONObject.optString("momentDailyRecordCode"));
            if (jSONObject.optBoolean("isEmpty", false)) {
                intent.putExtra("isEmpty", true);
            } else {
                intent.putExtra("thumbnail", jSONObject.optString("thumbnail"));
                intent.putExtra("releaseTime", jSONObject.optString("releaseTime"));
                intent.putExtra("content", jSONObject.optString("content"));
                intent.putExtra("momentType", jSONObject.optInt("momentType", -1));
                intent.putExtra("picNumber", jSONObject.optInt("picNumber", -1));
                intent.putExtra("voiceImg", jSONObject.optString("voiceImg"));
                intent.putExtra("momentProductionStatus", jSONObject.optBoolean("momentProductionStatus", false));
            }
            LocalBroadcastManager.getInstance(this.f32913a.getContext()).sendBroadcast(intent);
            V(handler, "result", Boolean.TRUE);
        } catch (Exception e2) {
            i4a.a("deleteFilmMoment fail:" + e2.getMessage());
        }
    }

    @JavascriptInterface
    @Keep
    public void getAppInfo(Object args, final CompletionHandler<Object> handler) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            handler.a(jSONObject);
        } else {
            dWebView.post(new Runnable() { // from class: com.zj.adlib.dj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16027a.c0(jSONObject, handler);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void getAppVersion(Object args, CompletionHandler<Object> handler) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", com.blankj.utilcode.util.b.C());
        handler.a(jSONObject);
    }

    @JavascriptInterface
    @Keep
    public void getAuthInfo(Object args, CompletionHandler<Object> handler) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        CommonUserInfo commonUserInfoE = ai9.e();
        jSONObject.put("token", commonUserInfoE.getToken());
        jSONObject.put("satoken", commonUserInfoE.getSatoken());
        jSONObject.put("userId", commonUserInfoE.getUserId());
        jSONObject.put(UserConstants.USER_PARAMS.b, commonUserInfoE.getNickName());
        jSONObject.put("avatar", commonUserInfoE.getAvatar());
        jSONObject.put("sex", commonUserInfoE.getSex());
        jSONObject.put(AliyunLogCommon.TERMINAL_TYPE, commonUserInfoE.getPhone());
        handler.a(jSONObject);
    }

    @JavascriptInterface
    @Keep
    public void getLocationInfo(Object args, final CompletionHandler<Object> handler) {
        if (this.f32913a == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) args;
        final String strOptString = jSONObject.optString("locPermitDes");
        final boolean zOptBoolean = jSONObject.optBoolean("needAddress");
        this.f32913a.post(new Runnable() { // from class: com.zj.adlib.uj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20081a.e0(strOptString, handler, zOptBoolean);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void getNIMFriendList(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.tj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f19829a.g0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void getPermissionStatus(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.gj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16785a.h0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void getUserInfo(Object args, CompletionHandler<Object> handler) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        CommonUserInfo commonUserInfoE = ai9.e();
        jSONObject.put("schoolCode", commonUserInfoE.getSchoolCode());
        jSONObject.put("schoolName", commonUserInfoE.getSchoolName());
        handler.a(jSONObject);
    }

    @JavascriptInterface
    @Keep
    public void goBack(Object args, final CompletionHandler<Object> handler) throws JSONException {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            handler.a(new JSONObject());
        } else {
            dWebView.post(new Runnable() { // from class: com.zj.adlib.jj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17407a.i0(handler);
                }
            });
        }
    }

    @JavascriptInterface
    @Keep
    public void goHWHealthHome(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.yi4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20858a.j0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void luckyDrawEvent(final Object args, final CompletionHandler<Object> handler) {
        i4a.c("luckyDrawEvent");
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.ij4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17216a.k0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void modelLoaded(Object args, CompletionHandler<Object> handler) throws JSONException {
        handler.a(new JSONObject());
    }

    @JavascriptInterface
    @Keep
    public void openApplication(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.kj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17710a.n0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openBuddyTeamChat(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.pj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18858a.p0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openCrystalExchange(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.zi4
            @Override // java.lang.Runnable
            public final void run() {
                this.f21066a.q0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openInternalLink(final Object args, final CompletionHandler<Object> handler) throws JSONException {
        DWebView dWebView = this.f32913a;
        if (dWebView == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.ak4
            @Override // java.lang.Runnable
            public final void run() {
                this.f15282a.r0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openLink(final Object args, final CompletionHandler<Object> handler) throws JSONException {
        DWebView dWebView = this.f32913a;
        if (dWebView == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.fj4
            @Override // java.lang.Runnable
            public final void run() {
                JavascriptApi.s0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMallCatPage(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.vi4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20222a.t0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMallCustomerService(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.wi4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20449a.u0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMallGoodsDetail(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.jk4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17414a.v0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMallMessage(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.oj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18647a.w0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMallOrderDetail(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.qj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f19115a.x0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMallShopDetail(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.cj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f15822a.y0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openMerchantCustomerService(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.rj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f19337a.z0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openStarDrillRecharge(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.hj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16990a.A0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openSuperPack(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.gk4
            @Override // java.lang.Runnable
            public final void run() {
                this.f16802a.B0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openTaskList(Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.kk4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17719a.C0(handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openTkLink(final Object args, final CompletionHandler<Object> handler) throws JSONException {
        DWebView dWebView = this.f32913a;
        if (dWebView == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.sj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f19593a.D0(handler, args);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openToBidRewardAD(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.ik4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17219a.E0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void openWeixinMiniProgram(final Object args, final CompletionHandler<Object> handler) throws JSONException {
        DWebView dWebView = this.f32913a;
        if (dWebView == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.ck4
            @Override // java.lang.Runnable
            public final void run() {
                this.f15827a.H0(args, handler);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void saveToPhotoAlbum(Object args, CompletionHandler<Object> handler) {
        if (this.f32913a == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = ((JSONObject) args).optJSONArray("imageList");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                i4a.a(strOptString);
                arrayList.add(strOptString);
            }
            if (!arrayList.isEmpty()) {
                Q0(arrayList, 0, handler);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", false);
                handler.a(jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", false);
                handler.a(jSONObject2);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            e3.printStackTrace();
        }
    }

    @JavascriptInterface
    @Keep
    public void shareFilm(Object args, CompletionHandler<Object> handler) {
        if (this.f32913a == null || !(args instanceof JSONObject)) {
            return;
        }
        Intent intent = new Intent(su9.f44781a);
        intent.putExtra("code", ((JSONObject) args).optString("code"));
        LocalBroadcastManager.getInstance(this.f32913a.getContext()).sendBroadcast(intent);
        V(handler, "result", Boolean.TRUE);
    }

    @JavascriptInterface
    @Keep
    public void shareImage(Object args, final CompletionHandler<Object> handler) throws JSONException {
        if (this.f32913a == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) args;
            final String strOptString = jSONObject.optString("to");
            final String strOptString2 = jSONObject.optString("imageUrl");
            p59.a().execute(new Runnable() { // from class: com.zj.adlib.mj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18230a.I0(strOptString2, strOptString, handler);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", false);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            handler.a(jSONObject2);
        }
    }

    @JavascriptInterface
    @Keep
    public void shareLink(Object args, final CompletionHandler<Object> handler) throws JSONException {
        if (this.f32913a == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        try {
            final JSONObject jSONObject = (JSONObject) args;
            final String strOptString = jSONObject.optString("to");
            final String strOptString2 = jSONObject.optString("title");
            final String strOptString3 = jSONObject.optString("desc");
            final String strOptString4 = jSONObject.optString("url");
            final String strOptString5 = jSONObject.optString("imageUrl");
            if (TextUtils.equals(strOptString, "Friend")) {
                this.f32913a.post(new Runnable() { // from class: com.zj.adlib.dk4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16031a.K0(jSONObject, handler);
                    }
                });
            } else if (TextUtils.equals(strOptString, "Group")) {
                this.f32913a.post(new Runnable() { // from class: com.zj.adlib.ek4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16333a.L0(jSONObject, handler);
                    }
                });
            } else {
                p59.a().execute(new Runnable() { // from class: com.zj.adlib.fk4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16538a.J0(strOptString5, strOptString, strOptString4, strOptString2, strOptString3, handler);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    @Keep
    public void shareText(Object args, final CompletionHandler<Object> handler) throws JSONException {
        if (this.f32913a == null || args == null || !(args instanceof JSONObject)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) args;
            String strOptString = jSONObject.optString("to");
            y88.i(this.f32913a.getContext(), new MessageBody("Wechat".equals(strOptString) ? FlavourName.WX_SESSION : FlavourName.WX_MOMENT, jSONObject.optString("text")), new ShareListener() { // from class: com.huachenjie.base.dsbridge_webview.JavascriptApi.6
                public void onCancel(@Nullable FlavourName flavour) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("result", false);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    handler.a(jSONObject2);
                }

                public void onFailed(FlavourName flavour, int code, String message) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (code == 1) {
                        try {
                            fv5.b(message);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    jSONObject2.put("result", false);
                    handler.a(jSONObject2);
                }

                public void onSuccess(FlavourName flavour) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("result", true);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    handler.a(jSONObject2);
                }
            });
        } catch (Exception unused) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", false);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            handler.a(jSONObject2);
        }
    }

    @JavascriptInterface
    @Keep
    public void showTradePay(final Object args, final CompletionHandler<Object> handler) {
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.vj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20226a.N0(handler, args);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void spineReady(Object args, final CompletionHandler<Object> handler) {
        final JSONObject jSONObject = new JSONObject();
        DWebView dWebView = this.f32913a;
        if (dWebView == null) {
            return;
        }
        dWebView.post(new Runnable() { // from class: com.zj.adlib.lk4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17983a.O0(handler, jSONObject);
            }
        });
    }

    @JavascriptInterface
    @Keep
    public void suitLoaded(Object args, CompletionHandler<Object> handler) throws JSONException {
        handler.a(new JSONObject());
    }
}
