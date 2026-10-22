package com.byazt.ev;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.baichuan.log.TLogConstant;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.fl.saas.base.cache.DatabaseHelper;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ve {
    public static final String[] c = {DatabaseHelper.COLUMN_ID, "url", "savePath", "tempPath", "name", "chunkCount", "status", "curBytes", "totalBytes", "eTag", "onlyWifi", "force", "retryCount", "extra", "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", ALPParamConstant.PACKAGENAME, TKDownloadReason.KSAD_TK_MD5, "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", TLogConstant.PERSIST_TASK_ID};
    public static final String[] tt = {DatabaseHelper.COLUMN_ID};
    public static final String[] ve = {DatabaseHelper.COLUMN_ID, "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};
    public static final String[] uj = {DatabaseHelper.COLUMN_ID};
    public static final String[] n = {DatabaseHelper.COLUMN_ID, AliyunLogCommon.LogLevel.INFO};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f28533a = {DatabaseHelper.COLUMN_ID};
}
