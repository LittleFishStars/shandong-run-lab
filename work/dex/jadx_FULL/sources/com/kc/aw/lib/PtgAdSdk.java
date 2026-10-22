package com.kc.aw.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.aliyun.credentials.utils.AuthConstant;
import com.google.android.exoplayer2.text.cea.a;
import com.kc.aw._c9;
import com.kc.aw._cc;
import com.kc.aw._ez;
import com.kc.aw._fp;
import com.kc.aw._i;
import com.kc.aw._i8;
import com.kc.aw._ia;
import com.kc.aw._jf;
import com.kc.aw._ju;
import com.kc.aw._jw;
import com.kc.aw._kt;
import com.kc.aw._kw;
import com.kc.aw._m4;
import com.kc.aw._m5;
import com.kc.aw._ny;
import com.kc.aw._nz;
import com.kc.aw._o1;
import com.kc.aw._oh;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.oaid.OaidManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgAdSdk {
    private static Context mContext;
    private static _i sAppLifecycleListener;
    public static PtgCustomController tempPtgCustomController;
    public static PtgSDKConfig config = new PtgSDKConfig();
    public static PtgAdNative globalProvider = new com.kc.aw.lib.provider._a();
    private static final AtomicBoolean isInitializing = new AtomicBoolean();
    private static final AtomicBoolean isInitialized = new AtomicBoolean();

    /* JADX INFO: renamed from: com.kc.aw.lib.PtgAdSdk$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Callback {
        public final Callback val$callback;

        public AnonymousClass1(Callback callback) {
            this.val$callback = callback;
        }

        @Override // com.kc.aw.lib.PtgAdSdk.Callback
        public void fail(int i, String str) {
            PtgAdSdk.isInitializing.set(false);
            PtgAdSdk.isInitialized.set(false);
            com.kc.aw.lib.utils._d._c(new Runnable(this, i, str) { // from class: com.kc.aw.lib.PtgAdSdk.1.2
                public final AnonymousClass1 this$0;
                public final int val$code;
                public final String val$msg;

                {
                    this.this$0 = this;
                    this.val$code = i;
                    this.val$msg = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Callback callback = this.this$0.val$callback;
                    if (callback != null) {
                        callback.fail(this.val$code, this.val$msg);
                    }
                }
            });
        }

        @Override // com.kc.aw.lib.PtgAdSdk.Callback
        public void success() {
            PtgAdSdk.isInitializing.set(false);
            PtgAdSdk.isInitialized.set(true);
            com.kc.aw.lib.utils._d._c(new Runnable(this) { // from class: com.kc.aw.lib.PtgAdSdk.1.1
                public final AnonymousClass1 this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Callback callback = this.this$0.val$callback;
                    if (callback != null) {
                        callback.success();
                    }
                }
            });
        }
    }

    @Keep
    public interface Callback {
        void fail(int i, String str);

        void success();
    }

    private static PtgAdNative[] automaticIntegrationProviders() {
        ArrayList arrayList = new ArrayList();
        for (int i : _i8._b(4)) {
            try {
                if (_kw._a(_ia._a(i))) {
                    arrayList.add((PtgAdNative) Class.forName(_ia._b(i)).newInstance());
                }
            } catch (Exception unused) {
            }
        }
        return (PtgAdNative[]) arrayList.toArray(new PtgAdNative[0]);
    }

    private static boolean checkParametersValidity(PtgSDKConfig ptgSDKConfig, Callback callback) {
        String str;
        String str2;
        if (ptgSDKConfig != null && (str = ptgSDKConfig._a) != null && !str.isEmpty() && (str2 = ptgSDKConfig._h) != null && !str2.isEmpty()) {
            return true;
        }
        if (callback == null) {
            throw new IllegalArgumentException("MediaId 或 MediaSecret 未配置！");
        }
        callback.fail(101, "MediaId 或 MediaSecret 未配置！");
        return false;
    }

    private static void clearConfigSp() {
        _jw._a(mContext, AuthConstant.INI_POLICY, "");
        _jw._a(mContext, "config", "");
    }

    public static PtgAdNative get() {
        return globalProvider;
    }

    public static _i getAppLifecycleListener() {
        if (sAppLifecycleListener == null) {
            sAppLifecycleListener = new _i();
        }
        return sAppLifecycleListener;
    }

    public static PtgSDKConfig getConfig() {
        return config;
    }

    public static Context getContext() {
        return mContext;
    }

    public static boolean getIsInitializing() {
        return isInitializing.get();
    }

    public static boolean getSensorStatus() {
        getConfig().getClass();
        return _jw._a(getContext());
    }

    public static void init(Context context, PtgSDKConfig ptgSDKConfig) {
        init(context, ptgSDKConfig, null, automaticIntegrationProviders());
    }

    public static void init(Context context, PtgSDKConfig ptgSDKConfig, Callback callback) {
        init(context, ptgSDKConfig, callback, automaticIntegrationProviders());
    }

    @Deprecated
    public static void init(Context context, PtgSDKConfig ptgSDKConfig, Callback callback, PtgAdNative... ptgAdNativeArr) {
        try {
            if (checkParametersValidity(ptgSDKConfig, callback)) {
                if (isInitialized()) {
                    if (callback != null) {
                        callback.success();
                        return;
                    }
                    return;
                }
                AtomicBoolean atomicBoolean = isInitializing;
                if (atomicBoolean.get()) {
                    return;
                }
                boolean z = true;
                atomicBoolean.set(true);
                mContext = context.getApplicationContext();
                _fp._c._a(mContext, getAppLifecycleListener());
                _ez._a(mContext);
                config = ptgSDKConfig;
                clearConfigSp();
                ptgSDKConfig.getClass();
                ptgSDKConfig._s = System.currentTimeMillis();
                Logger.LogDispatcher.addLogReceiver(new _oh());
                Logger.LogDispatcher.addLogReceiver(new com.kc.aw.lib.utils._c(new Logger.PlainLogger(Logger.ILogger.TAG)));
                mergeCustomController();
                initDeviceInfo();
                Context context2 = mContext;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(callback);
                if (callback != null) {
                    z = false;
                }
                if (z) {
                    _a._a(context2, ptgSDKConfig, anonymousClass1, ptgAdNativeArr);
                } else {
                    com.kc.aw.lib.utils._d._b(new _b(context2, ptgSDKConfig, anonymousClass1, ptgAdNativeArr));
                }
            }
        } catch (Exception e) {
            isInitializing.set(false);
            isInitialized.set(false);
            com.kc.aw.lib.utils._d._c(new Runnable(callback, e) { // from class: com.kc.aw.lib.PtgAdSdk.2
                public final Callback val$callback;
                public final Exception val$e;

                {
                    this.val$callback = callback;
                    this.val$e = e;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Callback callback2 = this.val$callback;
                    if (callback2 != null) {
                        callback2.fail(100, this.val$e.getMessage());
                    }
                }
            });
        }
    }

    private static void initDeviceInfo() {
        Runnable _nzVar;
        boolean z = true;
        _kt._a[1] = a.e;
        _m4._a = _cc._b();
        ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _jw._a;
        if (_m4._a != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str = _m4._a._s;
                long j_a = _jw._a(getContext(), "sdk_local_f_i_t");
                if (j_a == 0) {
                    _jw._a(getContext(), "sdk_local_f_i_t", jCurrentTimeMillis);
                    j_a = jCurrentTimeMillis;
                }
                long j_a2 = _jw._a(getContext(), "sdk_local_i_t" + str);
                if (j_a2 == 0) {
                    _jw._a(getContext(), "sdk_local_i_t" + str, jCurrentTimeMillis);
                } else {
                    jCurrentTimeMillis = j_a2;
                }
                _c9 _c9Var = _m4._a;
                _c9Var._B = j_a;
                _c9Var._C = jCurrentTimeMillis;
            } catch (Exception unused) {
            }
        }
        Context context = mContext;
        byte[] bArr = _kt._a;
        bArr[0] = 82;
        bArr[2] = 12;
        PtgCustomController ptgCustomController = getConfig()._m;
        if (ptgCustomController == null || ptgCustomController.isAllowSDKObtainOaId()) {
            try {
                String str2 = OaidManager.TAG;
                OaidManager.class.getMethod("init", Context.class).invoke(OaidManager.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Context context2 = mContext;
        AtomicBoolean atomicBoolean = _o1._a;
        if (TextUtils.isEmpty(getConfig()._u) && _jw._a(context2, "ru_la_bu_ti") <= 0) {
            try {
                getConfig()._u = _m5._a("86F8039660DDDF2141BA72C515EF950439D1B83E597E5E29D2E7E2A2C37A936A8AA043845CEB54BD2B9DC7D9535658D26BE1DE2CBD5BAADBB0B227F1EAC9B2DD3004772AF4F2D2CDBF2FCA683D62E7B24114DE1B1C47386D9B5634831FE0A0D9F8BA84F957CEC22969F25789217760DFC3C39C7B7F5E6CED5586224A904DA1BB291838FB045F6DB846DD9B096436014EEBB6D868B599792E3FA0829D677210845C8467EEC088EB3733CC957D348800AB1437E327EF2CCC0E103BAB208BE4575BAA359705A13A94682F0D9008A96509C707C09C6D2BED0E4FF96496F0B7733CF8CA35C137BEAAE22A5F30CAC763FCEB49A3E7B01136ACA392B40EC54EE528922BAFDEDC1B49C9A8B5C8FDD1644EA4F0308E680626920F8787F3A2D87054D52B03BB15B5549919B723F8F038AA8B2FDB47A6C0AFAF8B6D86F0320690577382A9016BB2A88EEAE79844CD5336DEB92DB99C09C3655B8BDB6B456C6196AFC41AA4B23C6DA5983CF8F7894D4165CA3B88EE193D2B949CF93092867A9B2E56D965B3A9D1080C808D443B9132F447056E9BB81080338F5C14A1479DF41BC88C1B52D7652C6585972FD2FCC57F36BF20AD97E5AACA2CE600A8CC269DEB785F98850E502937CB4E99A38DA620F4D26E37E3DCF087E703AB9EE10797BDC3261FCB1602C5668423615CCFFD6E6772AA0CD706BDE6D9A62DE2168632DB44D231D99801713CA7BD9E9467C213DC68502D06E3C2149FB4887A65352F7094A7815AC7CF56093B74672487E3453F9C19D09C4EFBE6AB3FC90E767B41491DE2E91433C07D6F92976E6D1DFAD1C61436A3C31A616990A49F89DE061B7FC920D35462BA7900B90C5C6AF97E762C6238537F50D33FB84E052EA5E5104D1CA8623A4F2503B7CA58AD7510DC74247A08C17BCE6D9DB181714FE60A9A9AED79F8859B61F3B0AC08D5CC839B4F15AF969C7D7967661E268030B976795DFEBA021EB1F16F5CEF59E8D7B342D2BD7DFB1D0A9367813558A7555E28D3CB5A246D3C76BEEA33943B3DE1C05CC4F7494069244866EFB16992804CC6B5B2F26A3486AA65CAAEC4D46C3684782937F73C0CE60D707E2CD03A921B15935CD86B665B81929B8253A67F8FB7FFC60C812C5554B30D08E8E8116F0D7BD7B49B1996004283399187434B950AA991DBEC6EB015C338368921F0FA812AB1F77FAC8220E821328EEBA191B8C7979963D3FFEA6EC422722AD7BAAED31A814725D3DC8661E2505B63328D7029995D9578391ED9DF56C4C560B608AA1E6791D2071A71551FD5A7FEAB57D76DBBCE1900AD280BD45142F4E31018025059B37B9B0E323D4213536A248447D64FE1A9A708F62BC44EB223731F526C62B2B33793932E0F98AB6BF40C936299941B25EF6D17E7CF0EE93ACDA28BB9350C8E4D639DDF2A6BB20A33CD288FD3E490D1D2564A711E0159960B637A144785101C0D34E3BC424578F08E8F2678F1DAE4E7737AEE1E9C562ACBE5DE4251F1107410EE9A126B92A6A26C195A2A0DBEE899596A7EADFB8EA923FC00D0E758467E285FBD30B22260673560D84D6C661E66B92901C0DC1F0268B8F4A22A344D0D4743156B89BFD835001D5EA188E5753D6C1309A51752B9BBE8B76987462D19DF1DD6A3E9D8942EF465A048DD8E6FDE1D8BFD50630E9814426A0F5197910B4BA35AA7D44EE6D32A51348753B6F3E8D2DB898A49BE7DA42F18A05E0915D5F6F37BD2503584EAC5A93E238B3F5B36745B6F93F30A57718D398695D23D7CC5E9D22031233903E34CFFDB36681459E47687EB374F5AE62506D898F883C595A0A46B58A3C1BCF1F82CD9941FDCBA8FE59227895FBD52F3ACE051C58310EE916F3D61662A363AB09C566DC911940C21A07608F17DE0FED04C347B46DAB497345296E8A15B845771D2C43572AFFE8236B95DB96C2A66F9BFF1852A978B9A7808D5F819036705DAD48912FFAF8AE1C54DD5F34625D08B47D1B0AA0B58969881EDC559A58FEBC604477480D706C72ADF86");
                PtgCustomController ptgCustomController2 = getConfig()._m;
                int i = getConfig()._w;
                if (ptgCustomController2 == null || !ptgCustomController2.isAllowSDKInstallList()) {
                    z = false;
                }
                if (i <= 0 && !z) {
                    _nzVar = new _ny();
                } else {
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        _o1._b(_o1._a(false));
                        return;
                    }
                    _nzVar = new _nz(false);
                }
                com.kc.aw.lib.utils._d._b(_nzVar);
            } catch (Exception e2) {
                StringBuilder sb_a = _jf._a("ru_err: ");
                sb_a.append(e2.getMessage());
                Logger.e(sb_a.toString());
            }
        }
    }

    public static boolean isInitialized() {
        return isInitialized.get();
    }

    public static void mergeCustomController() {
        if (tempPtgCustomController != null) {
            PtgSDKConfig config2 = getConfig();
            PtgCustomController ptgCustomController = tempPtgCustomController;
            if (ptgCustomController != null) {
                config2._m = ptgCustomController;
            } else {
                config2.getClass();
            }
        }
    }

    public static void setPtgCustomController(PtgCustomController ptgCustomController) {
        tempPtgCustomController = ptgCustomController;
    }

    public static void setSensorStatus(boolean z) {
        getConfig().getClass();
        Context context = getContext();
        ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _jw._a;
        if (context != null) {
            _jw._b(Boolean.valueOf(z), "ptg_sensor_status");
            com.kc.aw.lib.utils._d._b(new _ju(context, z));
        }
    }
}
