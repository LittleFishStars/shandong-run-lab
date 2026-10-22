package com.ali.auth.third.login;

import android.app.Activity;
import android.graphics.Bitmap;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.callback.NQrCodeLoginCallback;
import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.model.KernelMessageConstants;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.task.LoadQrCodePicTask;
import com.ali.auth.third.login.task.LoginByQrCodeTask;
import com.ali.auth.third.ui.QRView;
import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QRComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Timer f23460a;
    private static long b;

    public static class a implements LoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NQrCodeLoginCallback f23461a;

        public a(NQrCodeLoginCallback nQrCodeLoginCallback) {
            this.f23461a = nQrCodeLoginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
        }

        @Override // com.ali.auth.third.core.callback.LoginCallback
        public void onSuccess(Session session) {
            QRComponent.d();
            this.f23461a.onSuccess(session);
        }
    }

    public static class b implements ResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NQrCodeLoginCallback f23462a;

        public class a extends TimerTask {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f23463a;
            final /* synthetic */ String b;

            /* JADX INFO: renamed from: com.ali.auth.third.login.QRComponent$b$a$a, reason: collision with other inner class name */
            public class C0119a extends com.ali.auth.third.ui.context.a {
                public C0119a() {
                }

                @Override // com.ali.auth.third.ui.context.a
                public Activity a() {
                    return null;
                }

                @Override // com.ali.auth.third.ui.context.a
                public void a(int i, String str) {
                    b.this.f23462a.onFailure(i, str);
                }

                @Override // com.ali.auth.third.ui.context.a
                public void a(String str) {
                    b.this.f23462a.onFailure(1, str);
                }

                @Override // com.ali.auth.third.ui.context.a
                public void b(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (System.currentTimeMillis() - QRComponent.b > com.heytap.mcssdk.constant.a.h) {
                            QRComponent.d();
                            a aVar = a.this;
                            b.this.f23462a.onQrImageStatusChanged(aVar.f23463a, KernelMessageConstants.QRCODE_CLIENT_EXPIRED);
                        } else {
                            a aVar2 = a.this;
                            b.this.f23462a.onQrImageStatusChanged(aVar2.f23463a, jSONObject.getInt("code"));
                            if (jSONObject.getInt("code") == 6) {
                                QRComponent.d();
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            }

            public a(String str, String str2) {
                this.f23463a = str;
                this.b = str2;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                new LoginByQrCodeTask(new C0119a(), false).execute(this.b);
            }
        }

        /* JADX INFO: renamed from: com.ali.auth.third.login.QRComponent$b$b, reason: collision with other inner class name */
        public class C0120b implements NQrCodeLoginCallback.NQrCodeLoginController {
            public C0120b(b bVar) {
            }

            @Override // com.ali.auth.third.core.callback.NQrCodeLoginCallback.NQrCodeLoginController
            public void cancle() {
                QRComponent.d();
            }
        }

        public b(NQrCodeLoginCallback nQrCodeLoginCallback) {
            this.f23462a = nQrCodeLoginCallback;
        }

        @Override // com.ali.auth.third.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            this.f23462a.onFailure(i, str);
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
            if (QRComponent.f23460a == null) {
                Timer unused = QRComponent.f23460a = new Timer();
                long unused2 = QRComponent.b = System.currentTimeMillis();
            }
            QRComponent.f23460a.schedule(new a(str, string), 3000L, 2000L);
            this.f23462a.onQrImageLoaded(str, bitmap, new C0120b(this));
        }
    }

    private static void a(int i, int i2, NQrCodeLoginCallback nQrCodeLoginCallback) {
        QRView.mLoginCallback = new a(nQrCodeLoginCallback);
        new LoadQrCodePicTask(new b(nQrCodeLoginCallback)).execute(Integer.valueOf(i), Integer.valueOf(i2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        Timer timer = f23460a;
        if (timer != null) {
            timer.cancel();
            f23460a = null;
        }
    }

    public static void start(int i, int i2, NQrCodeLoginCallback nQrCodeLoginCallback) {
        a(i, i2, nQrCodeLoginCallback);
    }
}
