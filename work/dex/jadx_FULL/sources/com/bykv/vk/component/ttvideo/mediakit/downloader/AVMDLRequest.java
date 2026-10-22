package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.byazt.gqp.m;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLRequest {
    public static final int UrlStateIsForbidden = 1;
    public static final int UrlStateIsNormal = 0;
    public HashMap<String, String> headers;
    public int mCurlUrlIndex;
    public int mMaxTryCout;
    public int mOpenTimeOut;
    public int mRWTimeOut;
    public int[] mUrlErrCount;
    public int[] mUrlState;
    public long reqOff;
    public m response;
    public long size;
    public String[] urls;

    public AVMDLRequest() {
        this.urls = null;
        this.headers = new HashMap<>();
        this.reqOff = -1L;
        this.size = 0L;
        this.response = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
    }

    public AVMDLRequest(long j, long j2, String[] strArr, Object obj, int i, int i2, int i3) {
        this.urls = strArr;
        this.headers = (HashMap) obj;
        this.reqOff = j;
        this.size = j2;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = i;
        this.mOpenTimeOut = i2;
        this.mRWTimeOut = i3;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mUrlState = new int[strArr.length];
        int i4 = 0;
        while (true) {
            int[] iArr = this.mUrlState;
            if (i4 >= iArr.length) {
                break;
            }
            iArr[i4] = 0;
            i4++;
        }
        this.mUrlErrCount = new int[this.urls.length];
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.mUrlErrCount;
            if (i5 >= iArr2.length) {
                return;
            }
            iArr2[i5] = 0;
            i5++;
        }
    }

    public AVMDLRequest(long j, long j2, String[] strArr, HashMap<String, String> map) {
        this.urls = strArr;
        this.headers = map;
        this.reqOff = j;
        this.size = j2;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.mUrlState = new int[strArr.length];
        int i = 0;
        while (true) {
            int[] iArr = this.mUrlState;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }
}
