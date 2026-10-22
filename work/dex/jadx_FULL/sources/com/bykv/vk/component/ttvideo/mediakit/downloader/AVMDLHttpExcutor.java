package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.byazt.gqp.a;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.tt;
import com.byazt.gqp.u;
import com.byazt.gqp.yp;
import com.byazt.gqp.z;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.zj.adlib.c49;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static t okHttpClient;

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        if (strFormRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(strFormRangeStrBySize);
    }

    @SuppressLint({"CI_DefaultLocale"})
    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        yp.c cVar = new yp.c();
        cVar.c(aVMDLRequest.urls[i]);
        cVar.c("GET", (z) null);
        cVar.c(toOkHttpHeaders(aVMDLRequest));
        tt ttVarC = getOkHttpClient().c(cVar.tt());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m mVarTt = ttVarC.tt();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, mVarTt, ttVarC);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + c49.f40900a + j2;
        }
        if (j >= 0) {
            return j + c49.f40900a;
        }
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return c49.f40900a.concat(String.valueOf(j2));
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    private static synchronized t getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j2 = 10000;
            if (config != null) {
                int i = config.mOpenTimeOut;
                long j3 = i > 0 ? i * 1000 : 10000L;
                int i2 = config.mRWTimeOut;
                j2 = j3;
                j = i2 > 0 ? i2 * 1000 : 10000L;
            } else {
                j = 10000;
            }
            t.c cVar = new t.c();
            cVar.c(Collections.singletonList(u.HTTP_1_1));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            cVar.c(j2, timeUnit).tt(j, timeUnit).ve(j, timeUnit);
            okHttpClient = cVar.c();
        }
        return okHttpClient;
    }

    private static a toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        a.c cVar = new a.c();
        HashMap<String, String> map = aVMDLRequest.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                entry.getKey();
                entry.getValue();
                cVar.tt(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            cVar.tt("Range", strBuildRangeHeader);
        }
        cVar.tt("Accept-Encoding", HlsPlaylistParser.V);
        return cVar.c();
    }
}
