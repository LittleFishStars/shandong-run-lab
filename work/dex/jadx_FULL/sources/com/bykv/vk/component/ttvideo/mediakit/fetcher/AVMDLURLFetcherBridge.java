package com.bykv.vk.component.ttvideo.mediakit.fetcher;

import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLURLFetcherBridge implements AVMDLURLFetcherListener {
    private static final String TAG = "AVMDLURLFetcherBridge";
    private static AVMDLFetcherMakerInterface fetcherMaker;
    public String rawKey = null;
    public String fileKey = null;
    public String oldURL = null;
    String newURL = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyFetcherResult(long j, String str, String str2, String str3);

    public static void setFetcherMaker(AVMDLFetcherMakerInterface aVMDLFetcherMakerInterface) {
        if (aVMDLFetcherMakerInterface != null) {
            fetcherMaker = aVMDLFetcherMakerInterface;
        }
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.newURL;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.fetcher.AVMDLURLFetcherListener
    public void onCompletion(int i, String str, String str2, String[] strArr) {
        this.lock.lock();
        try {
            if (this.isFinish) {
                String.format(Locale.ENGLISH, "has fetch finished not need cur completion code:%d result:%s", Integer.valueOf(i), this.newURL);
            } else {
                if (strArr != null && strArr.length > 0) {
                    this.newURL = strArr[0];
                }
                String.format(Locale.ENGLISH, "receive completion code:%d result:%s", Integer.valueOf(i), this.newURL);
                this.isFinish = true;
                long j = this.handle;
                if (j != 0) {
                    _notifyFetcherResult(j, str, str2, this.newURL);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void release() {
        String.format("----start release fetcher:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            String.format("remove fetcher rawkey:%s, fileKey:%s", this.rawKey, this.fileKey);
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public int start(long j, String str, String str2, String str3) {
        int i;
        if (fetcherMaker == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        try {
            this.rawKey = str;
            this.fileKey = str2;
            this.oldURL = str3;
            AVMDLURLFetcherInterface fetcher = fetcherMaker.getFetcher(str, str2, str3);
            if (fetcher == null) {
                this.lock.unlock();
                return -1;
            }
            int iStart = fetcher.start(str, str2, str3, this);
            if (iStart > 0) {
                String[] uRLs = fetcher.getURLs();
                if (uRLs != null && uRLs.length != 0) {
                    long j2 = this.handle;
                    if (j2 != 0) {
                        String str4 = uRLs[0];
                        this.newURL = str4;
                        _notifyFetcherResult(j2, str, str2, str4);
                        i = 1;
                    }
                    this.lock.unlock();
                    String.format(Locale.ENGLISH, "****call start end, result:%d", Integer.valueOf(i));
                    return i;
                }
                String.format(Locale.ENGLISH, "****end fail start ret:%d, but getURLs null", Integer.valueOf(iStart));
                this.lock.unlock();
                return -2;
            }
            if (iStart < 0) {
                String.format(Locale.ENGLISH, "****end fail start ret:%d, not need wait result", Integer.valueOf(iStart));
                this.lock.unlock();
                return -3;
            }
            i = 0;
            this.lock.unlock();
            String.format(Locale.ENGLISH, "****call start end, result:%d", Integer.valueOf(i));
            return i;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }
}
