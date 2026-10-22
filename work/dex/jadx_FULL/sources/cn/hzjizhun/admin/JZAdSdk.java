package cn.hzjizhun.admin;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.hzjizhun.admin.ad.listener.DeviceParamsController;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.bean.ExtendChannel;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.AppStoreInfoUtils;
import cn.hzjizhun.admin.util.DeviceUtil;
import cn.hzjizhun.admin.util.LocationUtils;
import cn.hzjizhun.admin.util.OAIDUtil;
import cn.hzjizhun.admin.util.SRUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JZAdSdk {
    private static volatile JZAdSdk mInstance;
    private static boolean mIsAccelerate;
    private List<ExtendChannel> extendChannelList;
    private String mBaseHttp;
    private Context mContext;
    private float mDensity;
    private int mDensityDpi;
    private DeviceParamsController mDeviceController;
    private volatile boolean mIsInitEd;
    private boolean mNoAd;
    private String mOaid;
    private String mWxAppId;
    private String TAG = "JZAdSdk";
    private String mAppId = "0";
    private volatile boolean sOaidStatus = false;
    private String mPopUpDesc = "是否跳转详情页或第三方应用？";

    public static abstract class JZInitCallback {
        public void onInitResult(boolean z) {
        }

        public void onOaidSuccess() {
        }
    }

    public class a extends JZInitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JZInitCallback f22672a;

        public a(JZInitCallback jZInitCallback) {
            this.f22672a = jZInitCallback;
        }

        @Override // cn.hzjizhun.admin.JZAdSdk.JZInitCallback
        public void onInitResult(boolean z) {
            try {
                JZInitCallback jZInitCallback = this.f22672a;
                if (jZInitCallback != null) {
                    jZInitCallback.onInitResult(z);
                }
                if (ApiManager.getInnerCallback() == null) {
                    return;
                }
                Iterator<JZInitCallback> it = ApiManager.getInnerCallback().iterator();
                while (it.hasNext()) {
                    it.next().onInitResult(z);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public interface akdsd {
        void a(String str);
    }

    public class b implements akdsd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JZInitCallback f22673a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f268a;

        public b(boolean z, JZInitCallback jZInitCallback) {
            this.f268a = z;
            this.f22673a = jZInitCallback;
        }

        @Override // cn.hzjizhun.admin.JZAdSdk.akdsd
        public void a(String str) {
            try {
                if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
                    FunctionConfig.instance().saveBaseUrl("");
                } else {
                    FunctionConfig.instance().saveBaseUrl(str);
                    if (!this.f268a) {
                        JZAdSdk.this.mBaseHttp = str;
                    }
                }
                if (!this.f268a) {
                    dsda.e(JZAdSdk.this.mBaseHttp);
                }
                ApiManager.requestInitConfigData(this.f22673a);
            } catch (Throwable unused) {
            }
        }
    }

    public class c implements OAIDUtil.OaidCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22674a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JZInitCallback f269a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f271a;

        public c(Context context, String str, JZInitCallback jZInitCallback) {
            this.f22674a = context;
            this.f271a = str;
            this.f269a = jZInitCallback;
        }

        @Override // cn.hzjizhun.admin.util.OAIDUtil.OaidCallback
        public void onOaidGet() {
            JZAdSdk.this.sOaidStatus = true;
            JZAdSdk.this.startInit(this.f22674a, this.f271a, this.f269a);
        }
    }

    private JZAdSdk() {
    }

    private static void accelerate() {
        try {
            RcSdk.startAccelerate();
        } catch (Throwable unused) {
        }
    }

    private void fixWebViewDataDirectoryBug(Context context) {
        if (Build.VERSION.SDK_INT < 28 || context == null) {
            return;
        }
        try {
            String processName = Application.getProcessName();
            if (context.getPackageName().equals(processName)) {
                return;
            }
            WebView.setDataDirectorySuffix(processName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static JZAdSdk getInstance() {
        if (mInstance == null) {
            synchronized (JZAdSdk.class) {
                if (mInstance == null) {
                    mInstance = new JZAdSdk();
                }
            }
        }
        return mInstance;
    }

    public static String getPackageName(Application application) {
        if (application == null) {
            throw new NullPointerException("getPackageName params not null");
        }
        try {
            try {
                return RcSdk.getPackageName(application);
            } catch (Throwable unused) {
                return application.getApplicationInfo().packageName;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String getSdkVersion() {
        return "2.5.0";
    }

    public static boolean isInitSuccess() {
        return ApiManager.checkAdSdkInitStatus() && getInstance().isCallInit();
    }

    private void singleInit(Context context) {
        try {
            this.mDensity = context.getResources().getDisplayMetrics().density;
            this.mDensityDpi = context.getResources().getDisplayMetrics().densityDpi;
            LocationUtils.getInstance().getLocation(this.mContext);
            fixWebViewDataDirectoryBug(context);
            DeviceUtil.getDefaultUAString(context);
            AppStoreInfoUtils.getStoreInfo(context);
            SRUtils.startCheck(context);
        } catch (Throwable unused) {
        }
    }

    public static void startAccelerate() {
        mIsAccelerate = true;
        accelerate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInit(Context context, String str, JZInitCallback jZInitCallback) {
        if (!this.mIsInitEd) {
            singleInit(context);
        }
        this.mIsInitEd = true;
        if (getInstance().isNoAd()) {
            FunctionConfig.instance().saveInitConfig("");
        }
        FunctionConfig.instance().getLocalInitConfig();
        if (jZInitCallback != null) {
            jZInitCallback.onOaidSuccess();
        }
        boolean zHasInitData = FunctionConfig.instance().hasInitData();
        if (zHasInitData) {
            String baseUrl = FunctionConfig.instance().getBaseUrl();
            if (!TextUtils.isEmpty(baseUrl)) {
                this.mBaseHttp = baseUrl;
            }
            dsda.e(this.mBaseHttp);
            ApiManager.runInit(jZInitCallback);
        }
        ApiManager.requestBaseDomain(str, new b(zHasInitData, new a(jZInitCallback)));
    }

    public void addChannel(ExtendChannel extendChannel) {
        if (this.extendChannelList == null) {
            this.extendChannelList = new LinkedList();
        }
        this.extendChannelList.add(extendChannel);
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getBaseHttp() {
        return this.mBaseHttp;
    }

    public Context getContext() {
        return this.mContext;
    }

    public float getDensity() {
        return this.mDensity;
    }

    public int getDensityDpi() {
        return this.mDensityDpi;
    }

    public DeviceParamsController getDeviceController() {
        return this.mDeviceController;
    }

    public List<ExtendChannel> getExtendChannelList() {
        return this.extendChannelList;
    }

    public String getOAID() {
        return this.mOaid;
    }

    public String getPopUpDesc() {
        return this.mPopUpDesc;
    }

    public String getWxAppId() {
        return this.mWxAppId;
    }

    public void initJZ(Context context, String str) {
        initJZ(context, str, null);
    }

    public boolean isCallInit() {
        return this.mIsInitEd;
    }

    public boolean isNoAd() {
        return this.mNoAd;
    }

    public void noNeedLatLng() {
        LocationUtils.getInstance().notAllowLoadLocation();
    }

    public void release() {
        this.mDeviceController = null;
    }

    public void setDeviceParamsController(DeviceParamsController deviceParamsController) {
        this.mDeviceController = deviceParamsController;
    }

    public void setIsInitLoadLocation(boolean z) {
        LocationUtils.getInstance().setIsInitLoadLocation(z);
    }

    public void setJZBaseHttp(String str) {
        this.mBaseHttp = str;
    }

    public void setJZDebug(boolean z) {
        if (z) {
            ALog.openLog();
        }
    }

    public void setJZPopUpDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mPopUpDesc = str;
    }

    public void setJZWxAppId(String str) {
        this.mWxAppId = str;
    }

    public void setLocation(float f, float f2) {
        LocationUtils.getInstance().setLocation(f, f2);
    }

    public void setNoAd() {
        this.mNoAd = true;
    }

    public void setOAID(String str) {
        this.mOaid = str;
    }

    public void initJZ(Context context, String str, JZInitCallback jZInitCallback) {
        this.mAppId = str;
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            ALog.e(this.TAG, "init appId is empty");
            if (jZInitCallback != null) {
                jZInitCallback.onInitResult(false);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mBaseHttp)) {
            ALog.e(this.TAG, "需要调用 JZAdSdk.getInstance().setBaseHttp()");
            if (jZInitCallback != null) {
                jZInitCallback.onInitResult(false);
                return;
            }
            return;
        }
        if (this.sOaidStatus) {
            startInit(context, str, jZInitCallback);
        } else {
            OAIDUtil.requestOaid(context, new c(context, str, jZInitCallback));
        }
    }
}
