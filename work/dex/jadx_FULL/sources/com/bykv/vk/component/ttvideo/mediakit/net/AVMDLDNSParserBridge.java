package com.bykv.vk.component.ttvideo.mediakit.net;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j, String str, String str2, long j2, String str3);

    private static native void _notifyParserResultV2(long j, String str, String str2, long j2, String str3, int i);

    private int parserResult(long j, String str, int i) {
        boolean z;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        this.lock.lock();
        this.handle = j;
        AVMDLDNSParserBridge aVMDLDNSParserBridge = null;
        try {
            try {
                this.host = str;
                AVMDLDNSInfo aVMDLDNSInfo = IPCache.getInstance().get(str);
                if (aVMDLDNSInfo != null) {
                    this.ipList = aVMDLDNSInfo.mIpList;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String.format("get result from cache expiredT:%d curT:%d ", Long.valueOf(aVMDLDNSInfo.mExpiredTime), Long.valueOf(jCurrentTimeMillis));
                    if (aVMDLDNSInfo.mExpiredTime <= jCurrentTimeMillis) {
                        String.format("cache has expired need try call but not need listener", new Object[0]);
                        z = true;
                    } else {
                        z = false;
                    }
                    try {
                        long j2 = this.handle;
                        if (j2 != 0) {
                            if (i == 1) {
                                v2Usable = false;
                                _notifyParserResult(j2, str, this.ipList, aVMDLDNSInfo.mExpiredTime, null);
                            } else {
                                v2Usable = true;
                                _notifyParserResultV2(j2, str, this.ipList, aVMDLDNSInfo.mExpiredTime, null, aVMDLDNSInfo.mType);
                            }
                        }
                        i2 = 1;
                    } catch (UnsatisfiedLinkError e) {
                        e = e;
                        AVMDLLog.e(TAG, e.toString());
                        if (v2Usable) {
                            v2Usable = false;
                        }
                        this.lock.unlock();
                        i2 = 0;
                    }
                } else {
                    aVMDLDNSParserBridge = this;
                    z = true;
                    i2 = 0;
                }
                this.lock.unlock();
            } catch (UnsatisfiedLinkError e2) {
                e = e2;
                z = true;
            }
            if (z) {
                String.format("call add host to parser listener:%s", aVMDLDNSParserBridge);
                AVMDLDNSParser.getInstance().addHost(str, aVMDLDNSParserBridge);
            }
            String.format("****call start end, listener:%s", aVMDLDNSParserBridge);
            return i2;
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        if (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) {
            return null;
        }
        return backUpIp.mIpList;
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.ipList;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3, int i2) {
        if (!this.isFinish && v2Usable) {
            parserResult(i, str, str2, j, str3, i2, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i, str, str2, j, str3, i2, 1);
    }

    public void release() {
        String.format("----start release:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            String.format("remove host:%s", this.host);
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public int start(long j, String str) {
        int i = v2Usable ? parserResult(j, str, 2) : 0;
        return i <= 0 ? parserResult(j, str, 1) : i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0075  */
    /* JADX WARN: Code duplicated, block: B:22:0x0079 A[Catch: all -> 0x00aa, UnsatisfiedLinkError -> 0x00ac, TryCatch #1 {UnsatisfiedLinkError -> 0x00ac, blocks: (B:3:0x0008, B:5:0x000f, B:9:0x0026, B:11:0x0039, B:13:0x0040, B:15:0x004c, B:18:0x006b, B:22:0x0079, B:23:0x0083, B:24:0x008d), top: B:36:0x0008, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0083 A[Catch: all -> 0x00aa, UnsatisfiedLinkError -> 0x00ac, TryCatch #1 {UnsatisfiedLinkError -> 0x00ac, blocks: (B:3:0x0008, B:5:0x000f, B:9:0x0026, B:11:0x0039, B:13:0x0040, B:15:0x004c, B:18:0x006b, B:22:0x0079, B:23:0x0083, B:24:0x008d), top: B:36:0x0008, outer: #0 }] */
    private void parserResult(int i, String str, String str2, long j, String str3, int i2, int i3) {
        String str4;
        long j2;
        int i4;
        long j3;
        this.lock.lock();
        try {
            try {
                if (!this.isFinish) {
                    Locale locale = Locale.ENGLISH;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = TextUtils.isEmpty(str2) ? "null" : str2;
                    objArr[2] = Integer.valueOf(i2);
                    String.format(locale, "receive completion code:%d result:%s type:%d", objArr);
                    if (TextUtils.isEmpty(str2) && AVMDLDNSParser.getIntValue(5) == 1) {
                        AVMDLDNSInfo backUpIp = IPCache.getInstance().getBackUpIp(str);
                        if (backUpIp != null) {
                            String str5 = backUpIp.mIpList;
                            int i5 = backUpIp.mType;
                            String.format(locale, "get backup ip, result:%s type:%d", str5, Integer.valueOf(i5));
                            i4 = i5;
                            j2 = 0;
                            str4 = str5;
                        }
                        this.ipList = str4;
                        this.isFinish = true;
                        j3 = this.handle;
                        if (j3 != 0) {
                            if (i3 == 2) {
                                v2Usable = true;
                                _notifyParserResultV2(j3, str, str4, j2, str3, i4);
                            } else {
                                v2Usable = false;
                                _notifyParserResult(j3, str, str4, j2, str3);
                            }
                        }
                    }
                    str4 = str2;
                    j2 = j;
                    i4 = i2;
                    this.ipList = str4;
                    this.isFinish = true;
                    j3 = this.handle;
                    if (j3 != 0) {
                        if (i3 == 2) {
                            v2Usable = true;
                            _notifyParserResultV2(j3, str, str4, j2, str3, i4);
                        } else {
                            v2Usable = false;
                            _notifyParserResult(j3, str, str4, j2, str3);
                        }
                    }
                } else {
                    String.format(Locale.ENGLISH, "has finished not nedd cur completion code:%d result:%s expiredTime:%d", Integer.valueOf(i), str2, Long.valueOf(j));
                }
            } catch (UnsatisfiedLinkError unused) {
                if (v2Usable) {
                    v2Usable = false;
                }
                this.isFinish = false;
            }
        } finally {
            this.lock.unlock();
        }
    }
}
