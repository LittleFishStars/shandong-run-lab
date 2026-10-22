package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.beizi.fusion.unified.BZUnifiedAdDownloadAppInfo;
import com.beizi.fusion.unified.BZUnifiedAdImageInfo;
import com.beizi.fusion.unified.BZUnifiedAdResponse;
import com.beizi.fusion.unified.BZUnifiedAdTemplateBeanModel;
import com.beizi.fusion.unified.BZUnifiedAdVideoInfo;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.bv9;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class jj extends k3 {
    private ij P;
    private d5 Q;

    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27432a;

        public a(View view) {
            this.f27432a = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            try {
                View view = this.f27432a;
                if (view == null) {
                    return true;
                }
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                jj.this.a(this.f27432a);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27433a;

        public class a implements yn {

            /* JADX INFO: renamed from: com.beizi.fusion.jj$b$a$a, reason: collision with other inner class name */
            public class RunnableC0312a implements Runnable {
                public RunnableC0312a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ij ijVar = jj.this.P;
                    if (ijVar != null) {
                        ijVar.onAdShown();
                    }
                }
            }

            public a() {
            }

            @Override // com.beizi.fusion.yn
            public void a() {
                try {
                    if (jj.this.c != null) {
                        Log.e("BeiZisAd", "enter BeiZi ad show");
                        on onVar = jj.this.c;
                        b bVar = b.this;
                        onVar.f(bVar.f27433a, jj.this.l);
                        if (jj.this.t) {
                            jj.this.u = true;
                            u3.b().a(jj.this.r);
                        }
                        b.this.f27433a.post(new RunnableC0312a());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public b(View view) {
            this.f27433a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                jj jjVar = jj.this;
                if (jjVar.P == null || jjVar.c == null) {
                    return;
                }
                jj.this.Q = new d5(this.f27433a, new a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27436a;

        public c(int i) {
            this.f27436a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            jj.this.P.onAdFailed(this.f27436a);
        }
    }

    public class d implements BZUnifiedAdResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ on f27437a;
        final /* synthetic */ BZUnifiedAdTemplateBeanModel b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        public d(on onVar, BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel, String str, String str2, String str3) {
            this.f27437a = onVar;
            this.b = bZUnifiedAdTemplateBeanModel;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getActionText() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getActionText();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getAdBrand() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getAdBrand();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getCreativeId() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getCreativeId();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getDeeplink() {
            return this.c;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getDesc() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getDesc();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public BZUnifiedAdDownloadAppInfo getDownloadAppInfo() {
            if (!jj.this.d || this.f27437a == null) {
                return null;
            }
            BZUnifiedAdDownloadAppInfo bZUnifiedAdDownloadAppInfo = new BZUnifiedAdDownloadAppInfo();
            bZUnifiedAdDownloadAppInfo.setAppName(this.f27437a.j());
            bZUnifiedAdDownloadAppInfo.setAppVersion(this.f27437a.q());
            bZUnifiedAdDownloadAppInfo.setAppDeveloper(this.f27437a.k());
            String strO = this.f27437a.o();
            if (TextUtils.isEmpty(strO)) {
                bZUnifiedAdDownloadAppInfo.setAppPermission(this.f27437a.n());
            } else {
                bZUnifiedAdDownloadAppInfo.setAppPermission(strO);
            }
            bZUnifiedAdDownloadAppInfo.setAppPrivacy(this.f27437a.p());
            bZUnifiedAdDownloadAppInfo.setAppIntro(this.f27437a.r());
            return bZUnifiedAdDownloadAppInfo;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getDownloadUrl() {
            return this.d;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public int getEcpm() {
            try {
                return Integer.parseInt(this.f27437a.U());
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public BZUnifiedAdImageInfo getIcon() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getIcon();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public BZUnifiedAdImageInfo getImage() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getImage();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public List getImageList() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getImageList();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public int getImageMode() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel == null) {
                return -1;
            }
            if (bZUnifiedAdTemplateBeanModel.getVideo() != null) {
                return 3;
            }
            if (this.b.getImageList() == null || this.b.getImageList().size() <= 1) {
                return this.b.getImage() != null ? 1 : -1;
            }
            return 2;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public int getInteractionType() {
            if (!TextUtils.isEmpty(this.c)) {
                return 1;
            }
            if (!TextUtils.isEmpty(this.d) && this.d.contains("market://")) {
                return 1;
            }
            if (jj.this.d && !TextUtils.isEmpty(this.d) && this.d.startsWith("http")) {
                return 2;
            }
            return !TextUtils.isEmpty(this.e) ? 3 : 0;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getLandingPage() {
            return this.e;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public BZUnifiedAdImageInfo getLogo() {
            on onVar = this.f27437a;
            if (onVar == null) {
                return null;
            }
            on.e eVarH = onVar.H();
            BZUnifiedAdImageInfo bZUnifiedAdImageInfo = new BZUnifiedAdImageInfo();
            if (eVarH != null) {
                bZUnifiedAdImageInfo.setUrl(eVarH.a());
            }
            return bZUnifiedAdImageInfo;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public String getTitle() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getTitle();
            }
            return null;
        }

        @Override // com.beizi.fusion.unified.BZUnifiedAdResponse
        public BZUnifiedAdVideoInfo getVideo() {
            BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = this.b;
            if (bZUnifiedAdTemplateBeanModel != null) {
                return bZUnifiedAdTemplateBeanModel.getVideo();
            }
            return null;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BZUnifiedAdResponse f27438a;

        public e(BZUnifiedAdResponse bZUnifiedAdResponse) {
            this.f27438a = bZUnifiedAdResponse;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jj.this.P != null) {
                Log.e("BeiZisAd", "enter BeiZi ad load");
                jj.this.P.onAdLoaded(this.f27438a);
            }
        }
    }

    public jj(Context context, String str, th thVar) {
        super(context, str, thVar);
    }

    private BZUnifiedAdTemplateBeanModel g(String str) {
        String str2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject3;
        String str3 = RemoteMessageConst.Notification.ICON;
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(bv9.b)) {
                JSONObject jSONObject = new JSONObject(str);
                BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModel = new BZUnifiedAdTemplateBeanModel();
                if (jSONObject.has("creativeId")) {
                    bZUnifiedAdTemplateBeanModel.setCreativeId(jSONObject.optString("creativeId"));
                }
                if (jSONObject.has("adBrand")) {
                    bZUnifiedAdTemplateBeanModel.setAdBrand(jSONObject.optString("adBrand"));
                }
                if (jSONObject.has("title")) {
                    bZUnifiedAdTemplateBeanModel.setTitle(jSONObject.optString("title"));
                }
                if (jSONObject.has("desc")) {
                    bZUnifiedAdTemplateBeanModel.setDesc(jSONObject.optString("desc"));
                }
                if (jSONObject.has("actionText")) {
                    bZUnifiedAdTemplateBeanModel.setActionText(jSONObject.optString("actionText"));
                }
                if (jSONObject.has("image") && (jSONObjectOptJSONObject3 = jSONObject.optJSONObject("image")) != null) {
                    BZUnifiedAdImageInfo bZUnifiedAdImageInfo = new BZUnifiedAdImageInfo();
                    if (jSONObjectOptJSONObject3.has("width")) {
                        bZUnifiedAdImageInfo.setWidth(jSONObjectOptJSONObject3.optInt("width"));
                    }
                    if (jSONObjectOptJSONObject3.has("height")) {
                        bZUnifiedAdImageInfo.setHeight(jSONObjectOptJSONObject3.optInt("height"));
                    }
                    if (jSONObjectOptJSONObject3.has("url")) {
                        bZUnifiedAdImageInfo.setUrl(jSONObjectOptJSONObject3.optString("url"));
                    }
                    bZUnifiedAdTemplateBeanModel.setImage(bZUnifiedAdImageInfo);
                }
                if (!jSONObject.has("imageList") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("imageList")) == null || jSONArrayOptJSONArray.length() <= 0) {
                    str2 = RemoteMessageConst.Notification.ICON;
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        JSONArray jSONArray = jSONArrayOptJSONArray;
                        BZUnifiedAdImageInfo bZUnifiedAdImageInfo2 = new BZUnifiedAdImageInfo();
                        if (jSONObject2.has("width")) {
                            bZUnifiedAdImageInfo2.setWidth(jSONObject2.optInt("width"));
                        }
                        if (jSONObject2.has("height")) {
                            bZUnifiedAdImageInfo2.setHeight(jSONObject2.optInt("height"));
                        }
                        if (jSONObject2.has("url")) {
                            bZUnifiedAdImageInfo2.setUrl(jSONObject2.optString("url"));
                        }
                        arrayList.add(bZUnifiedAdImageInfo2);
                        i++;
                        jSONArrayOptJSONArray = jSONArray;
                        str3 = str3;
                    }
                    str2 = str3;
                    bZUnifiedAdTemplateBeanModel.setImageList(arrayList);
                }
                if (jSONObject.has("video") && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject("video")) != null) {
                    BZUnifiedAdVideoInfo bZUnifiedAdVideoInfo = new BZUnifiedAdVideoInfo();
                    if (jSONObjectOptJSONObject2.has("coverWidth")) {
                        bZUnifiedAdVideoInfo.setCoverWidth(jSONObjectOptJSONObject2.optInt("coverWidth"));
                    }
                    if (jSONObjectOptJSONObject2.has("coverHeight")) {
                        bZUnifiedAdVideoInfo.setCoverHeight(jSONObjectOptJSONObject2.optInt("coverHeight"));
                    }
                    if (jSONObjectOptJSONObject2.has("coverUrl")) {
                        bZUnifiedAdVideoInfo.setCoverUrl(jSONObjectOptJSONObject2.optString("coverUrl"));
                    }
                    if (jSONObjectOptJSONObject2.has("coverHeight")) {
                        bZUnifiedAdVideoInfo.setCoverHeight(jSONObjectOptJSONObject2.optInt("coverHeight"));
                    }
                    if (jSONObjectOptJSONObject2.has("url")) {
                        bZUnifiedAdVideoInfo.setUrl(jSONObjectOptJSONObject2.optString("url"));
                    }
                    if (jSONObjectOptJSONObject2.has("duration")) {
                        bZUnifiedAdVideoInfo.setDuration(jSONObjectOptJSONObject2.optInt("duration"));
                    }
                    if (jSONObjectOptJSONObject2.has(CommonCode.MapKey.HAS_RESOLUTION)) {
                        bZUnifiedAdVideoInfo.setResolution(jSONObjectOptJSONObject2.optString(CommonCode.MapKey.HAS_RESOLUTION));
                    }
                    bZUnifiedAdTemplateBeanModel.setVideo(bZUnifiedAdVideoInfo);
                }
                String str4 = str2;
                if (jSONObject.has(str4) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(str4)) != null) {
                    BZUnifiedAdImageInfo bZUnifiedAdImageInfo3 = new BZUnifiedAdImageInfo();
                    if (jSONObjectOptJSONObject.has("width")) {
                        bZUnifiedAdImageInfo3.setWidth(jSONObjectOptJSONObject.optInt("width"));
                    }
                    if (jSONObjectOptJSONObject.has("height")) {
                        bZUnifiedAdImageInfo3.setHeight(jSONObjectOptJSONObject.optInt("height"));
                    }
                    if (jSONObjectOptJSONObject.has("url")) {
                        bZUnifiedAdImageInfo3.setUrl(jSONObjectOptJSONObject.optString("url"));
                    }
                    bZUnifiedAdTemplateBeanModel.setIcon(bZUnifiedAdImageInfo3);
                }
                if ((bZUnifiedAdTemplateBeanModel.getImageList() == null || bZUnifiedAdTemplateBeanModel.getImageList().size() <= 1) && bZUnifiedAdTemplateBeanModel.getImage() == null && bZUnifiedAdTemplateBeanModel.getVideo() == null) {
                    return null;
                }
                return bZUnifiedAdTemplateBeanModel;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnPreDrawListener(new a(view));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.k3
    public void d() {
        super.d();
        d5 d5Var = this.Q;
        if (d5Var != null) {
            d5Var.a();
        }
        this.Q = null;
    }

    public void a(ij ijVar) {
        this.P = ijVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        view.post(new b(view));
    }

    public void a(ViewGroup viewGroup, hj hjVar) {
        try {
            if (this.P != null && viewGroup != null && hjVar != null) {
                int iA = hjVar.a();
                on onVar = this.c;
                if (onVar == null) {
                    return;
                }
                onVar.e(this.N);
                this.c.c(true);
                g5 g5Var = new g5();
                if (!TextUtils.isEmpty(hjVar.d())) {
                    g5Var.g(hjVar.d());
                }
                if (!TextUtils.isEmpty(hjVar.e())) {
                    g5Var.h(hjVar.e());
                }
                if (!TextUtils.isEmpty(hjVar.b())) {
                    g5Var.e(hjVar.b());
                }
                if (!TextUtils.isEmpty(hjVar.c())) {
                    g5Var.f(hjVar.c());
                }
                if (!TextUtils.isEmpty(hjVar.h())) {
                    g5Var.c(hjVar.h());
                }
                if (!TextUtils.isEmpty(hjVar.i())) {
                    g5Var.d(hjVar.i());
                }
                if (!TextUtils.isEmpty(hjVar.f())) {
                    g5Var.a(hjVar.f());
                }
                if (!TextUtils.isEmpty(hjVar.g())) {
                    g5Var.b(hjVar.g());
                }
                this.c.a(viewGroup, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.i, this.l, iA);
                this.i = true;
                this.P.onAdClick();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(int i) {
        if (this.P == null || this.j || this.g) {
            return;
        }
        this.j = true;
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new c(i));
        }
    }

    @Override // com.beizi.fusion.k3
    public void a(on onVar) {
        e(onVar.U());
        a(onVar.c());
        b(onVar.i0());
        String strZ = onVar.z();
        String strF = onVar.F();
        String strL = onVar.l();
        BZUnifiedAdTemplateBeanModel bZUnifiedAdTemplateBeanModelG = g(onVar.a0());
        if (bZUnifiedAdTemplateBeanModelG == null) {
            a(3);
            return;
        }
        d dVar = new d(onVar, bZUnifiedAdTemplateBeanModelG, strZ, strL, strF);
        Handler handler = this.J;
        if (handler != null) {
            handler.post(new e(dVar));
        }
    }
}
