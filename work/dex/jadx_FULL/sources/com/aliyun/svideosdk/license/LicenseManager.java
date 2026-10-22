package com.aliyun.svideosdk.license;

import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.common.utils.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class LicenseManager implements ILicenseNativeInitCallback {
    private static final String TAG = "LicenseManager";
    private static LicenseManager _singleton;
    private long mCertExpireTime;
    private long mCertSignTime;
    private int mErrorCode;
    private String mErrorMessage;
    private long mExpireTime;
    private ILicenseNativeInitCallback mInitCallback;
    private String mLicenseFeatures;

    public interface Feature {
        public static final int CROP_COMPOSE = 4;
        public static final int EDITOR_CAPTION = 5;
        public static final int EDITOR_MV = 1;
        public static final int EDITOR_PHOTOALBUM = 3;
        public static final int EDITOR_STICKER = 2;
        public static final int VIDEO_STITCHING = 6;
    }

    public static LicenseManager getInstance() {
        if (_singleton == null) {
            synchronized (LicenseManager.class) {
                if (_singleton == null) {
                    _singleton = new LicenseManager();
                }
            }
        }
        return _singleton;
    }

    public long getCertExpireTime() {
        return this.mCertExpireTime;
    }

    public long getCertSignTime() {
        return this.mCertSignTime;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public long getExpireTime() {
        return this.mExpireTime;
    }

    public String getLicenseFeatures() {
        return this.mLicenseFeatures;
    }

    @Override // com.aliyun.svideosdk.license.ILicenseNativeInitCallback
    public void onError(final int i, final String str) {
        this.mErrorCode = i;
        this.mErrorMessage = str;
        Log.v(TAG, "license check fail : errorCode " + i + ",errorMsg : " + str);
        if (this.mInitCallback != null) {
            r.b(new Runnable() { // from class: com.aliyun.svideosdk.license.LicenseManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LicenseManager.this.mInitCallback == null) {
                        return;
                    }
                    LicenseManager.this.mInitCallback.onError(i, str);
                    LicenseManager.this.removeCallback();
                }
            });
        }
    }

    @Override // com.aliyun.svideosdk.license.ILicenseNativeInitCallback
    public void onSuccess(String str, long j, long j2, long j3) {
        Log.v(TAG, "license check success : feaature " + str + ",certSignTime : " + j + ",certExpireTime:" + j2);
        this.mErrorCode = 0;
        this.mErrorMessage = "";
        this.mLicenseFeatures = str;
        this.mCertSignTime = j;
        this.mCertExpireTime = j2;
        this.mExpireTime = j3;
        if (this.mInitCallback != null) {
            r.b(new Runnable() { // from class: com.aliyun.svideosdk.license.LicenseManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LicenseManager.this.mInitCallback == null) {
                        return;
                    }
                    LicenseManager.this.mInitCallback.onSuccess(LicenseManager.this.mLicenseFeatures, LicenseManager.this.mCertSignTime, LicenseManager.this.mCertExpireTime, LicenseManager.this.mExpireTime);
                    LicenseManager.this.removeCallback();
                }
            });
        }
    }

    public void removeCallback() {
        this.mInitCallback = null;
    }

    public LicenseManager setCallback(ILicenseNativeInitCallback iLicenseNativeInitCallback) {
        this.mInitCallback = iLicenseNativeInitCallback;
        return this;
    }
}
