package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.ImInitHelper;
import com.huachenjie.im.OperateCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.bean.RemoteExtBean;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.StatusCode;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;
import huachenjie.sdk.http.BaseEntity;
import rx.Observer;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class p44 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IMTokenBean f43891a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static LoginInfo f18766a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f18767a = "imLog";

    public class a extends DefaultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43892a;

        public a(OperateCallback operateCallback) {
            this.f43892a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, Object obj, Throwable th) {
            if (i == 200) {
                p44.k(this.f43892a);
                return;
            }
            i4a.b(p44.f18767a, "initSDK fail :" + i);
            this.f43892a.onFailed(i);
        }
    }

    public class b extends DefaultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43893a;

        public b(OperateCallback operateCallback) {
            this.f43893a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, Object obj, Throwable th) {
            if (i == 200) {
                p44.p(this.f43893a);
                return;
            }
            i4a.b(p44.f18767a, "initSDK fail :" + i);
            this.f43893a.onFailed(i);
        }
    }

    public class c extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43894a;

        public c(OperateCallback operateCallback) {
            this.f43894a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i == 200 && iMTokenBean != null) {
                p44.w(iMTokenBean, this.f43894a);
            } else {
                this.f43894a.onFailed(404);
                i4a.b(p44.f18767a, "获取token操作失败");
            }
        }
    }

    public class d implements RequestCallback<LoginInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43895a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ IMTokenBean f18768a;

        public d(OperateCallback operateCallback, IMTokenBean iMTokenBean) {
            this.f43895a = operateCallback;
            this.f18768a = iMTokenBean;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(LoginInfo loginInfo) {
            i4a.b(p44.f18767a, "login success");
            this.f43895a.onSuccess(this.f18768a);
        }

        public void onException(Throwable th) {
            i4a.b(p44.f18767a, "login exception:" + th.getMessage());
            i4a.a(String.format("im key:%s", NIMClient.getAppKey()));
            i4a.a(String.format("token :%s", this.f18768a.getToken()));
            i4a.a(String.format("accid :%s", this.f18768a.getAccid()));
            this.f43895a.onException(th);
            th.printStackTrace();
        }

        public void onFailed(int i) {
            i4a.b(p44.f18767a, "login fail");
            i4a.a(String.format("im key:%s", NIMClient.getAppKey()));
            if (i == 302) {
                i4a.b(p44.f18767a, "账号密码错误");
            } else if (i == 408) {
                i4a.b(p44.f18767a, "连接超时");
            } else if (i == 415) {
                i4a.b(p44.f18767a, "网络断开或者与云信服务器建立连接失败");
            } else if (i == 416) {
                i4a.b(p44.f18767a, "调用频次过高");
            } else {
                i4a.b(p44.f18767a, AlibcProtocolConstant.UNKNOWN_ERROR);
            }
            this.f43895a.onFailed(i);
        }
    }

    public class e implements Observer<BaseEntity<IMTokenBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43896a;

        public e(OperateCallback operateCallback) {
            this.f43896a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseEntity<IMTokenBean> baseEntity) {
            if (baseEntity == null) {
                i4a.b(p44.f18767a, "getToken base is null");
                this.f43896a.onFailed(404);
                return;
            }
            Object obj = baseEntity.data;
            if (obj == null) {
                i4a.b(p44.f18767a, "getToken bean.data is null");
                this.f43896a.onFailed(404);
                return;
            }
            p44.f43891a = (IMTokenBean) obj;
            i4a.b(p44.f18767a, "getToken:" + p44.f43891a.getToken());
            i4a.b(p44.f18767a, "getAccid:" + p44.f43891a.getAccid());
            this.f43896a.onSuccess((IMTokenBean) baseEntity.data);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th) {
            i4a.b(p44.f18767a, "getToken onError");
            this.f43896a.onException(th);
            th.printStackTrace();
        }
    }

    public class f implements Observer<BaseEntity<RemoteExtBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43897a;

        public f(OperateCallback operateCallback) {
            this.f43897a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseEntity<RemoteExtBean> baseEntity) {
            if (baseEntity == null) {
                i4a.b(p44.f18767a, "getMetaverseUserInfo : bean is null");
                this.f43897a.onFailed(404);
                return;
            }
            if (baseEntity.data == null) {
                i4a.b(p44.f18767a, "getMetaverseUserInfo bean.data is null");
                this.f43897a.onFailed(404);
                return;
            }
            String avatar = ai9.e().getAvatar();
            String nickName = ai9.e().getNickName();
            String userId = ai9.e().getUserId();
            ((RemoteExtBean) baseEntity.data).setAvatar(avatar);
            ((RemoteExtBean) baseEntity.data).setNickName(nickName);
            ((RemoteExtBean) baseEntity.data).setAppUserCode(userId);
            this.f43897a.onSuccess((RemoteExtBean) baseEntity.data);
        }

        public void onCompleted() {
            i4a.b(p44.f18767a, "getMetaverseUserInfo onCompleted");
        }

        public void onError(Throwable th) {
            i4a.b(p44.f18767a, "getMetaverseUserInfo onError");
            this.f43897a.onException(th);
            th.printStackTrace();
        }
    }

    public class g implements Observer<BaseEntity<JSONObject>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f43898a;

        public g(OperateCallback operateCallback) {
            this.f43898a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseEntity<JSONObject> baseEntity) {
            Object obj;
            if (baseEntity == null || (obj = baseEntity.data) == null) {
                this.f43898a.onFailed(404);
            } else if (((JSONObject) obj).containsKey("serverTime")) {
                this.f43898a.onSuccess(Long.valueOf(((JSONObject) baseEntity.data).getLongValue("serverTime")));
            } else {
                this.f43898a.onFailed(404);
            }
        }

        public void onCompleted() {
            i4a.b(p44.f18767a, "getSystemTime onCompleted");
        }

        public void onError(Throwable th) {
            i4a.b(p44.f18767a, "getSystemTime onError");
            this.f43898a.onException(th);
            th.printStackTrace();
        }
    }

    public class h implements Observer<BaseEntity<Object>> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseEntity<Object> baseEntity) {
            i4a.b(p44.f18767a, "updateAlias success");
        }

        public void onCompleted() {
            i4a.b(p44.f18767a, "updateAlias onCompleted");
        }

        public void onError(Throwable th) {
            i4a.b(p44.f18767a, "updateAlias onError");
        }
    }

    public static void A(final String str, final String str2) {
        i4a.b(f18767a, "updateAlias");
        final h hVar = new h();
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.n44
            @Override // java.lang.Runnable
            public final void run() {
                p44.v(str, str2, hVar);
            }
        });
    }

    @UiThread
    public static void j(OperateCallback<IMTokenBean> operateCallback) {
        i4a.b(f18767a, "checkLoginIM: 检测是否登录");
        ImInitHelper.c().d(new a(operateCallback));
    }

    public static void k(OperateCallback<IMTokenBean> operateCallback) {
        i4a.b(f18767a, "checkTokenWithLogin");
        if (!r()) {
            p(operateCallback);
        } else {
            i4a.b(f18767a, "已登录");
            operateCallback.onSuccess(f43891a);
        }
    }

    public static void l(Context context) {
        i4a.b(f18767a, "configSDK");
        NIMClient.config(context, (LoginInfo) null, z(context));
    }

    public static void m(OperateCallback<RemoteExtBean> operateCallback) {
        i4a.b(f18767a, "getRemoteExt");
        final f fVar = new f(operateCallback);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.l44
            @Override // java.lang.Runnable
            public final void run() {
                p44.s(fVar);
            }
        });
    }

    public static void n(OperateCallback<Long> operateCallback) {
        i4a.b(f18767a, "getSystemTime");
        final g gVar = new g(operateCallback);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.m44
            @Override // java.lang.Runnable
            public final void run() {
                p44.t(gVar);
            }
        });
    }

    public static void o(OperateCallback<IMTokenBean> operateCallback) {
        i4a.b(f18767a, "getToken");
        final e eVar = new e(operateCallback);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.o44
            @Override // java.lang.Runnable
            public final void run() {
                p44.u(eVar);
            }
        });
    }

    public static void p(OperateCallback<IMTokenBean> operateCallback) {
        i4a.b(f18767a, "getTokenWithLogin: 每次需要校验禁言状态，getToken需要称查接口");
        o(new c(operateCallback));
    }

    @UiThread
    public static void q(OperateCallback operateCallback) {
        i4a.b(f18767a, "initSDK");
        ImInitHelper.c().d(operateCallback);
    }

    public static boolean r() {
        return NIMClient.getStatus().getValue() == StatusCode.LOGINED.getValue();
    }

    public static /* synthetic */ void s(Observer observer) {
        new j44().h().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public static /* synthetic */ void t(Observer observer) {
        new gq1().C().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public static /* synthetic */ void u(Observer observer) {
        new j44().g().I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public static /* synthetic */ void v(String str, String str2, Observer observer) {
        new j44().p(str, str2).I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public static void w(IMTokenBean iMTokenBean, @NonNull OperateCallback<IMTokenBean> operateCallback) {
        i4a.b(f18767a, "login");
        if (r()) {
            i4a.b(f18767a, "Already logged in");
            operateCallback.onSuccess(iMTokenBean);
            return;
        }
        f18766a = new LoginInfo(iMTokenBean.getAccid(), iMTokenBean.getToken());
        d dVar = new d(operateCallback, iMTokenBean);
        AuthService authService = (AuthService) k44.a(AuthService.class);
        if (authService == null) {
            operateCallback.onFailed(404);
            return;
        }
        try {
            authService.login(f18766a).setCallback(dVar);
        } catch (Throwable th) {
            operateCallback.onException(th);
        }
    }

    @UiThread
    public static void x(OperateCallback<IMTokenBean> operateCallback) {
        ImInitHelper.c().d(new b(operateCallback));
    }

    public static void y() {
        AuthService authService = (AuthService) k44.a(AuthService.class);
        if (authService != null) {
            try {
                wt1.h().p();
                authService.logout();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static SDKOptions z(Context context) {
        SDKOptions sDKOptions = new SDKOptions();
        sDKOptions.appKey = l43.b;
        i4a.a(String.format("im key:%s", l43.b));
        sDKOptions.preloadAttach = false;
        sDKOptions.reducedIM = true;
        sDKOptions.disableAwake = true;
        sDKOptions.checkManifestConfig = false;
        sDKOptions.sdkStorageRootPath = context.getCacheDir().getPath();
        i4a.a(String.format("日志缓存地址:%s", context.getCacheDir().getPath()));
        return sDKOptions;
    }
}
