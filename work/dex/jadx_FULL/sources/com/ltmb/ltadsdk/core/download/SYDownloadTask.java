package com.ltmb.ltadsdk.core.download;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.service.LocationService;
import com.kuaishou.weapon.p0.t;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.h8;
import com.ltmb.ltadsdk.pkg.k0;
import com.ltmb.ltadsdk.pkg.p7;
import com.ltmb.ltadsdk.pkg.u6;
import com.zj.adlib.y6b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010%\n\u0002\b\f\u0018\u0000 o2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\bl\u0010mB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bl\u0010nJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\"\u0010+\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\"\u0010/\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\"\u00103\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0013\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R\"\u0010;\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\"\u0010?\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0013\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\"\u0010O\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010B\u001a\u0004\bM\u0010D\"\u0004\bN\u0010FR\"\u0010S\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0013\u001a\u0004\bQ\u0010\u0015\"\u0004\bR\u0010\u0017R\"\u0010W\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0013\u001a\u0004\bU\u0010\u0015\"\u0004\bV\u0010\u0017R\"\u0010[\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0013\u001a\u0004\bY\u0010\u0015\"\u0004\bZ\u0010\u0017R\"\u0010_\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u001a\u001a\u0004\b]\u0010\u001c\"\u0004\b^\u0010\u001eR\"\u0010c\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0013\u001a\u0004\ba\u0010\u0015\"\u0004\bb\u0010\u0017R.\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006p"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadTask;", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "other", "compareTo", "Lcom/ltmb/ltadsdk/pkg/p7;", "convertToInsertRecord", "", "getUniqueKey", "", "isDownloadApk", "a", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "url", "b", "I", "getPriority", "()I", "setPriority", "(I)V", "priority", "c", "getRetryCount", "setRetryCount", "retryCount", "d", "getStatus", "setStatus", "status", "e", "getAppPkgName", "setAppPkgName", "appPkgName", "f", "getAppVersion", "setAppVersion", "appVersion", y6b.f, "getAppIcon", "setAppIcon", "appIcon", y6b.g, "getChecksum", "setChecksum", "checksum", "i", "getAllowNetType", "setAllowNetType", "allowNetType", "j", "getDownloadId", "setDownloadId", "downloadId", "", "k", "J", "getCreateTime", "()J", "setCreateTime", "(J)V", "createTime", t.d, "getTotalBytes", "setTotalBytes", "totalBytes", "m", "getDownloadedBytes", "setDownloadedBytes", "downloadedBytes", "n", "getFilePath", "setFilePath", "filePath", j.b, "getAppName", "setAppName", "appName", "p", "getSuffixType", "setSuffixType", "suffixType", "q", "getNotificationId", "setNotificationId", LocationService.f, "r", "getRequestId", "setRequestId", "requestId", "", "s", "Ljava/util/Map;", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "headers", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYDownloadTask implements Comparable<SYDownloadTask>, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public String url;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int priority;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int retryCount;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int status;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public String appPkgName;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String appVersion;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String appIcon;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public String checksum;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public int allowNetType;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public String downloadId;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public long createTime;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public long totalBytes;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public long downloadedBytes;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public String filePath;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public String appName;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public String suffixType;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public int notificationId;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public String requestId;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public Map<String, String> headers;

    /* JADX INFO: renamed from: com.ltmb.ltadsdk.core.download.SYDownloadTask$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<SYDownloadTask> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SYDownloadTask createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SYDownloadTask(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SYDownloadTask[] newArray(int i) {
            return new SYDownloadTask[i];
        }
    }

    public SYDownloadTask() {
        this.url = "";
        this.priority = 5;
        this.status = 1;
        this.appPkgName = "";
        this.appVersion = "";
        this.appIcon = "";
        this.checksum = "";
        this.allowNetType = 2;
        this.downloadId = "";
        this.createTime = System.currentTimeMillis();
        this.filePath = "";
        this.appName = "";
        this.suffixType = SYDownloadManager.DOWNLOAD_TYPE_APK;
        this.requestId = "";
        this.headers = new HashMap();
    }

    @NotNull
    public final p7 convertToInsertRecord() {
        Context contextA;
        String str;
        if (TextUtils.isEmpty(this.downloadId)) {
            this.downloadId = h8.a.a();
        }
        if (this.notificationId == 0) {
            this.notificationId = ((int) System.currentTimeMillis()) & 268435455;
        }
        if (TextUtils.isEmpty(this.filePath) && (contextA = u6.n.a()) != null) {
            if (TextUtils.equals(this.suffixType, SYDownloadManager.DOWNLOAD_TYPE_APK)) {
                if (TextUtils.isEmpty(this.appPkgName)) {
                    str = k0.e(this.url) + '.' + this.suffixType;
                } else {
                    str = this.appPkgName + '_' + k0.e(this.url) + '.' + this.suffixType;
                }
                Intrinsics.checkNotNullParameter(contextA, "context");
                File file = new File(contextA.getFilesDir(), "yltmbad/apk");
                d9 d9Var = d9.d;
                d9Var.a("DownloadApkDirectory: " + file.getAbsolutePath() + ", exists=" + file.exists());
                if (!file.exists()) {
                    d9Var.a("创建成功 " + file.mkdirs());
                }
                String absolutePath = new File(file, str).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "File(SYDownloadFileHelpe…y(it), name).absolutePath");
                this.filePath = absolutePath;
            } else {
                String strE = k0.e(this.url);
                Intrinsics.checkNotNullParameter(contextA, "context");
                File file2 = new File(contextA.getFilesDir(), "yltmbad/dld");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                String absolutePath2 = new File(file2, strE).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath2, "File(SYDownloadFileHelpe…y(it), name).absolutePath");
                this.filePath = absolutePath2;
            }
        }
        p7 p7Var = new p7((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0L, 0L, 0L, 0L, (String) null, 0, 0, 0, 0, (String) null, (String) null, 524287);
        String str2 = this.downloadId;
        Intrinsics.checkNotNullParameter(str2, "<set-?>");
        p7Var.a = str2;
        String str3 = this.url;
        Intrinsics.checkNotNullParameter(str3, "<set-?>");
        p7Var.b = str3;
        p7Var.n = this.priority;
        String str4 = this.appName;
        Intrinsics.checkNotNullParameter(str4, "<set-?>");
        p7Var.e = str4;
        String str5 = this.appPkgName;
        Intrinsics.checkNotNullParameter(str5, "<set-?>");
        p7Var.c = str5;
        String str6 = this.appVersion;
        Intrinsics.checkNotNullParameter(str6, "<set-?>");
        p7Var.d = str6;
        String str7 = this.appIcon;
        Intrinsics.checkNotNullParameter(str7, "<set-?>");
        p7Var.f = str7;
        String str8 = this.checksum;
        Intrinsics.checkNotNullParameter(str8, "<set-?>");
        p7Var.m = str8;
        long j = this.createTime;
        p7Var.k = j;
        p7Var.l = j;
        p7Var.q = this.notificationId;
        p7Var.h = this.status;
        String str9 = this.filePath;
        Intrinsics.checkNotNullParameter(str9, "<set-?>");
        p7Var.g = str9;
        p7Var.o = this.retryCount;
        p7Var.p = this.allowNetType;
        String str10 = this.requestId;
        Intrinsics.checkNotNullParameter(str10, "<set-?>");
        p7Var.r = str10;
        String str11 = this.suffixType;
        Intrinsics.checkNotNullParameter(str11, "<set-?>");
        p7Var.s = str11;
        return p7Var;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAllowNetType() {
        return this.allowNetType;
    }

    @NotNull
    public final String getAppIcon() {
        return this.appIcon;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getAppPkgName() {
        return this.appPkgName;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getChecksum() {
        return this.checksum;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getDownloadId() {
        return this.downloadId;
    }

    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getSuffixType() {
        return this.suffixType;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    @NotNull
    public final String getUniqueKey() {
        return TextUtils.equals(this.suffixType, SYDownloadManager.DOWNLOAD_TYPE_APK) ? this.appPkgName : this.url;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final boolean isDownloadApk() {
        return TextUtils.equals(this.suffixType, SYDownloadManager.DOWNLOAD_TYPE_APK);
    }

    public final void setAllowNetType(int i) {
        this.allowNetType = i;
    }

    public final void setAppIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appIcon = str;
    }

    public final void setAppName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appName = str;
    }

    public final void setAppPkgName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appPkgName = str;
    }

    public final void setAppVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersion = str;
    }

    public final void setChecksum(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checksum = str;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setDownloadId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.downloadId = str;
    }

    public final void setDownloadedBytes(long j) {
        this.downloadedBytes = j;
    }

    public final void setFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filePath = str;
    }

    public final void setHeaders(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    public final void setNotificationId(int i) {
        this.notificationId = i;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final void setRequestId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestId = str;
    }

    public final void setRetryCount(int i) {
        this.retryCount = i;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setSuffixType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.suffixType = str;
    }

    public final void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeInt(this.priority);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.status);
        parcel.writeString(this.appPkgName);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.appIcon);
        parcel.writeString(this.checksum);
        parcel.writeInt(this.allowNetType);
        parcel.writeString(this.downloadId);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.totalBytes);
        parcel.writeLong(this.downloadedBytes);
        parcel.writeString(this.filePath);
        parcel.writeString(this.appName);
        parcel.writeString(this.suffixType);
        parcel.writeInt(this.notificationId);
        parcel.writeString(this.requestId);
        parcel.writeMap(this.headers);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull SYDownloadTask other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.priority - this.priority;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SYDownloadTask(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        this.url = string == null ? "" : string;
        this.priority = parcel.readInt();
        this.retryCount = parcel.readInt();
        this.status = parcel.readInt();
        String string2 = parcel.readString();
        this.appPkgName = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        this.appVersion = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        this.appIcon = string4 == null ? "" : string4;
        String string5 = parcel.readString();
        this.checksum = string5 == null ? "" : string5;
        this.allowNetType = parcel.readInt();
        String string6 = parcel.readString();
        this.downloadId = string6 == null ? "" : string6;
        this.createTime = parcel.readLong();
        this.totalBytes = parcel.readLong();
        this.downloadedBytes = parcel.readLong();
        String string7 = parcel.readString();
        this.filePath = string7 == null ? "" : string7;
        String string8 = parcel.readString();
        this.appName = string8 == null ? "" : string8;
        String string9 = parcel.readString();
        this.suffixType = string9 == null ? "" : string9;
        this.notificationId = parcel.readInt();
        String string10 = parcel.readString();
        this.requestId = string10 != null ? string10 : "";
        parcel.readMap(this.headers, HashMap.class.getClassLoader());
    }
}
