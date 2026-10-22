package com.bwt.top;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.bwt.top.api.ApiManager;
import com.bwt.top.bean.ExtendChannel;
import com.bwt.top.util.ALog;
import com.rc.base.RcSdk;
import com.zj.adlib.zgb;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdSdk {
    private static volatile AdSdk mInstance;
    private static boolean mIsAccelerate;
    private String TAG = "AdSdk";
    private List<ExtendChannel> extendChannelList;
    private String mAppId;
    private String mBaseHttp;
    private Context mContext;
    private float mDensity;
    private int mDensityDpi;
    private DeviceParamsController mDeviceController;
    private boolean mNoAd;
    private String mOaid;

    public interface InitCallback {
        void onInitResult(boolean z);
    }

    private static void accelerate() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AdSdk getInstance() {
        if (mInstance == null) {
            synchronized (AdSdk.class) {
                if (mInstance == null) {
                    mInstance = new AdSdk();
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
            } catch (Exception unused) {
                return "";
            }
        } catch (Exception unused2) {
            return application.getApplicationInfo().packageName;
        }
    }

    public static String getSdkVersion() {
        return "1.0.1";
    }

    public static boolean isInitSuccess() {
        return ApiManager.checkAdSdkInitStatus();
    }

    private void preInit(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mAppId = str;
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mDensityDpi = context.getResources().getDisplayMetrics().densityDpi;
        fixWebViewDataDirectoryBug(context);
        zgb.c(str, this.mBaseHttp);
    }

    public static void startAccelerate() {
        mIsAccelerate = true;
        accelerate();
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

    public void init(Context context, String str) {
        preInit(context, str);
        ApiManager.requestInitConfigData(null);
    }

    public void init(Context context, String str, InitCallback initCallback) {
        preInit(context, str);
        ApiManager.requestInitConfigData(initCallback);
    }

    public boolean isNoAd() {
        return this.mNoAd;
    }

    public void release() {
        this.mDeviceController = null;
    }

    public void setBaseHttp(String str) {
        this.mBaseHttp = str;
    }

    public void setDebug(boolean z) {
        if (z) {
            ALog.openLog();
        }
    }

    public void setDeviceParamsController(DeviceParamsController deviceParamsController) {
        this.mDeviceController = deviceParamsController;
    }

    public void setNoAd() {
        this.mNoAd = true;
    }

    public void setOAID(String str) {
        this.mOaid = str;
    }
}
