package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.callback.NQrCodeLoginCallback;
import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.model.KernelMessageConstants;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.task.LoadQrCodePicTask;
import com.ali.auth.third.login.task.LoginByIVTokenTask;
import com.ali.auth.third.login.task.LoginByQrCodeTask;
import com.ali.auth.third.ui.iv.DataRepository;
import com.ali.auth.third.ui.iv.SMSVerificationView;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NQRView extends FrameLayout {
    private static long m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f23502a;
    private LinearLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private ImageView e;
    private TextView f;
    private Button g;
    private LoginCallback h;
    private RelativeLayout i;
    private LinearLayout j;
    private boolean k;
    private NQrCodeLoginCallback l;
    Handler mHandler;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NQRView.this.f23502a.setVisibility(8);
            NQRView.this.b.setVisibility(8);
            NQRView.this.c.setVisibility(8);
            NQRView.this.d.setVisibility(0);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NQRView.this.a();
            NQRView.this.f23502a.setVisibility(8);
            NQRView.this.b.setVisibility(8);
            NQRView.this.d.setVisibility(8);
            NQRView.this.c.setVisibility(0);
        }
    }

    public class c implements NQrCodeLoginCallback {
        public c() {
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            NQRView.this.a(R.string.auth_sdk_message_10010_message);
            NQRView.this.h.onFailure(i, str);
        }

        @Override // com.ali.auth.third.core.callback.NQrCodeLoginCallback
        public void onQrImageLoaded(String str, Bitmap bitmap, NQrCodeLoginCallback.NQrCodeLoginController nQrCodeLoginController) {
            NQRView.this.e.setImageBitmap(bitmap);
            NQRView.this.b();
        }

        @Override // com.ali.auth.third.core.callback.NQrCodeLoginCallback
        public void onQrImageStatusChanged(String str, int i) {
            NQRView nQRView;
            int i2;
            if (i != 4) {
                if (i == 5) {
                    NQRView.this.c();
                    return;
                }
                if (i != 6) {
                    NQRView.this.e();
                    nQRView = NQRView.this;
                    i2 = R.string.auth_sdk_message_10010_message;
                } else {
                    NQRView.this.e();
                    nQRView = NQRView.this;
                    i2 = R.string.auth_sdk_message_qr_expired;
                }
                nQRView.a(i2);
            }
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            NQRView.this.e();
            NQRView.this.d();
            NQRView.this.h.onSuccess(session);
        }
    }

    public class d implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NQrCodeLoginCallback f23506a;

        public d(NQrCodeLoginCallback nQrCodeLoginCallback) {
            this.f23506a = nQrCodeLoginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            NQRView.this.e();
            this.f23506a.onSuccess(session);
        }
    }

    public class e implements ResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NQrCodeLoginCallback f23507a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f23508a;
            final /* synthetic */ String b;

            public a(String str, String str2) {
                this.f23508a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (NQRView.this.k) {
                    return;
                }
                e eVar = e.this;
                NQRView.this.a(this.f23508a, this.b, eVar.f23507a);
                NQRView.this.mHandler.postDelayed(this, 2000L);
            }
        }

        public e(NQrCodeLoginCallback nQrCodeLoginCallback) {
            this.f23507a = nQrCodeLoginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            this.f23507a.onFailure(i, str);
        }

        @Override // com.ali.auth.third.core.callback.ResultCallback
        public void onSuccess(Object obj) {
            Map map = (Map) obj;
            Bitmap bitmap = (Bitmap) map.remove("imageBitMap");
            String str = (String) map.get(t.u);
            HashMap map2 = new HashMap();
            map2.put("qrCodeInfo", map);
            HashMap map3 = new HashMap();
            map3.put("params", map2);
            String string = JSONUtils.toJsonObject(map3).toString();
            this.f23507a.onQrImageLoaded(str, bitmap, null);
            long unused = NQRView.m = System.currentTimeMillis();
            NQRView.this.mHandler.postDelayed(new a(str, string), 3000L);
            NQRView.this.k = false;
        }
    }

    public class f extends com.ali.auth.third.ui.context.a {
        final /* synthetic */ NQrCodeLoginCallback c;
        final /* synthetic */ String d;

        public f(NQrCodeLoginCallback nQrCodeLoginCallback, String str) {
            this.c = nQrCodeLoginCallback;
            this.d = str;
        }

        @Override // com.ali.auth.third.ui.context.a
        public Activity a() {
            return null;
        }

        @Override // com.ali.auth.third.ui.context.a
        public void a(int i, String str) {
            if (i != 13060) {
                this.c.onFailure(i, str);
            } else {
                NQRView.this.e();
                NQRView.this.a(str);
            }
        }

        @Override // com.ali.auth.third.ui.context.a
        public void a(String str) {
            this.c.onFailure(1, str);
        }

        @Override // com.ali.auth.third.ui.context.a
        public void b(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (System.currentTimeMillis() - NQRView.m > com.heytap.mcssdk.constant.a.h) {
                    NQRView.this.e();
                    this.c.onQrImageStatusChanged(this.d, KernelMessageConstants.QRCODE_CLIENT_EXPIRED);
                } else {
                    this.c.onQrImageStatusChanged(this.d, jSONObject.getInt("code"));
                    if (jSONObject.getInt("code") == 6) {
                        NQRView.this.e();
                    }
                }
            } catch (JSONException e) {
                Log.e("NQRView", "check qrcode status error ", e);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NQRView.this.b.setVisibility(8);
            NQRView nQRView = NQRView.this;
            nQRView.a(nQRView.getWidth(), NQRView.this.getHeight(), NQRView.this.l);
        }
    }

    public class h implements RpcRequestCallbackWithCode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23510a;
        final /* synthetic */ String b;

        public class a implements LoginCallback {
            public a() {
            }

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                NQRView.this.a(R.string.auth_sdk_message_10010_message);
                NQRView.this.h.onFailure(1003, "");
            }

            @Override // com.ali.auth.third.core.callback.LoginCallback
            public void onSuccess(Session session) {
                NQRView.this.d();
                NQRView.this.h.onSuccess(session);
            }
        }

        public h(String str, String str2) {
            this.f23510a = str;
            this.b = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onError(String str, RpcResponse rpcResponse) {
            if (rpcResponse != null && rpcResponse.code == 13078) {
                try {
                    String strOptString = new JSONObject((String) rpcResponse.returnValue).optString(Constants.PARAM_HAVANA_IV_TOKEN);
                    LoginByIVTokenTask loginByIVTokenTask = new LoginByIVTokenTask(null, new a());
                    Executor executor = ExecutorServiceImpl.mExecutor;
                    if (executor == null) {
                        executor = AsyncTask.THREAD_POOL_EXECUTOR;
                    }
                    loginByIVTokenTask.executeOnExecutor(executor, this.b, this.f23510a, "havana_iv_token=" + strOptString);
                    return;
                } catch (Throwable unused) {
                }
            }
            NQRView.this.a(R.string.auth_sdk_message_10010_message);
            NQRView.this.h.onFailure(1004, "");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onSuccess(RpcResponse rpcResponse) {
            try {
                JSONObject jSONObject = new JSONObject((String) rpcResponse.returnValue);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("products");
                String strOptString = jSONObject.optString("hToken");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (TextUtils.equals(PrepareException.ERROR_AUTH_FAIL, jSONObjectOptJSONObject.optString("tag"))) {
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("validatorList");
                            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                                break;
                                break;
                            }
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2).getJSONObject("valueAttrbute");
                                if (jSONObject2 != null) {
                                    String next = jSONObject2.keys().next();
                                    HashMap map = new HashMap();
                                    map.put("mobile", next);
                                    map.put(Constants.PARAM_IV_TOKEN, strOptString);
                                    map.put("iv_type", PrepareException.ERROR_AUTH_FAIL);
                                    map.put("scene", this.f23510a);
                                    NQRView.this.showIVPage(map, this.f23510a, this.b);
                                    return;
                                }
                            }
                            break;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            NQRView.this.a(R.string.auth_sdk_message_10010_message);
            NQRView.this.h.onFailure(1001, "");
        }

        @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
        public void onSystemError(String str, RpcResponse rpcResponse) {
            NQRView.this.a(R.string.auth_sdk_message_10010_message);
            NQRView.this.h.onFailure(1002, "");
        }
    }

    public class i implements ResultCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23512a;
        final /* synthetic */ String b;

        public class a implements LoginCallback {
            public a() {
            }

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                NQRView.this.a(R.string.auth_sdk_message_10010_message);
                NQRView.this.h.onFailure(1003, "");
            }

            @Override // com.ali.auth.third.core.callback.LoginCallback
            public void onSuccess(Session session) {
                NQRView.this.d();
                NQRView.this.h.onSuccess(session);
            }
        }

        public i(String str, String str2) {
            this.f23512a = str;
            this.b = str2;
        }

        @Override // com.ali.auth.third.core.callback.ResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            LoginByIVTokenTask loginByIVTokenTask = new LoginByIVTokenTask(null, new a());
            Executor executor = ExecutorServiceImpl.mExecutor;
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            loginByIVTokenTask.executeOnExecutor(executor, this.f23512a, this.b, "havana_iv_token=" + str);
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            NQRView.this.a(R.string.auth_sdk_message_10010_message);
            NQRView.this.h.onFailure(i, str);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NQRView.this.a();
            NQRView.this.f23502a.setVisibility(0);
            NQRView.this.b.setVisibility(8);
            NQRView.this.d.setVisibility(8);
            NQRView.this.c.setVisibility(8);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23515a;

        public k(int i) {
            this.f23515a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NQRView.this.a();
            NQRView.this.f23502a.setVisibility(8);
            NQRView.this.d.setVisibility(8);
            NQRView.this.f.setText(this.f23515a);
            NQRView.this.b.setVisibility(0);
            NQRView.this.c.setVisibility(8);
        }
    }

    public NQRView(Context context) {
        this(context, null);
    }

    public NQRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.k = true;
        this.l = new c();
        LayoutInflater.from(context).inflate(getLayoutId(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.j.setVisibility(0);
        this.i.setVisibility(8);
        this.i.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        KernelContext.executorService.postUITask(new k(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, NQrCodeLoginCallback nQrCodeLoginCallback) {
        QRView.mLoginCallback = new d(nQrCodeLoginCallback);
        this.j.setVisibility(0);
        this.i.setVisibility(8);
        new LoadQrCodePicTask(new e(nQrCodeLoginCallback)).execute(Integer.valueOf(i2), Integer.valueOf(i3), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("scene");
            String strOptString2 = jSONObject.optString(Constants.PARAM_IV_TOKEN);
            String strOptString3 = jSONObject.optString("login_token");
            if (!TextUtils.equals("true", jSONObject.optString("nativeIv")) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            DataRepository.fetchIVStrategys(strOptString2, PrepareException.ERROR_AUTH_FAIL, new h(strOptString, strOptString3));
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, NQrCodeLoginCallback nQrCodeLoginCallback) {
        new LoginByQrCodeTask(new f(nQrCodeLoginCallback, str), true).execute(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        KernelContext.executorService.postUITask(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        KernelContext.executorService.postUITask(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        KernelContext.executorService.postUITask(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.mHandler != null) {
            this.k = true;
        }
    }

    public int getLayoutId() {
        return R.layout.ali_auth_nqrview;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        if (this.e != null) {
            this.e = null;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.j = (LinearLayout) findViewById(R.id.ali_auth_nqrview);
        this.e = (ImageView) findViewById(R.id.ali_auth_nqrview_qr_image);
        this.g = (Button) findViewById(R.id.ali_auth_nqrview_error_refresh);
        this.f23502a = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_qr);
        this.b = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_errortips);
        this.d = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_scanedtips);
        this.c = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_successedtips);
        this.f = (TextView) findViewById(R.id.ali_auth_nqrview_error_main);
        this.g.setOnClickListener(new g());
        this.i = (RelativeLayout) findViewById(R.id.ali_auth_verify_rl);
    }

    public void setNQrCodeLoginCallback(NQrCodeLoginCallback nQrCodeLoginCallback) {
        if (nQrCodeLoginCallback != null) {
            this.l = nQrCodeLoginCallback;
        }
    }

    public void showIVPage(Map map, String str, String str2) {
        this.j.setVisibility(8);
        this.i.setVisibility(0);
        SMSVerificationView sMSVerificationView = com.ali.auth.third.ui.a.f23521a;
        if (sMSVerificationView == null) {
            sMSVerificationView = new SMSVerificationView(getContext());
        }
        this.i.addView(sMSVerificationView, new FrameLayout.LayoutParams(-1, -1));
        invalidate();
        sMSVerificationView.init(map);
        sMSVerificationView.setResultCallback(new i(str2, str));
    }

    public void showQR(LoginCallback loginCallback) {
        this.h = loginCallback;
        a(getWidth(), getHeight(), this.l);
    }

    public void showQR(Map<String, String> map, LoginCallback loginCallback) {
        this.h = loginCallback;
        a(Integer.parseInt(map.get("width")), Integer.parseInt(map.get("height")), this.l);
    }
}
