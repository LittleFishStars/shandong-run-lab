package com.alibaba.ariver.resource.subpackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ZipUtils;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.zj.adlib.c49;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24472a = "AriverRes:SubPackageDownloader";
    private RVTransportService b = (RVTransportService) RVProxy.get(RVTransportService.class);
    private AppModel c;
    private String d;
    private App e;
    private InterfaceC0153a f;

    /* JADX INFO: renamed from: com.alibaba.ariver.resource.subpackage.a$a, reason: collision with other inner class name */
    public interface InterfaceC0153a {
        void a(String str);

        void b(String str);
    }

    public a(App app, AppModel appModel, String str, InterfaceC0153a interfaceC0153a) {
        this.e = app;
        this.c = appModel;
        this.f = interfaceC0153a;
        this.d = str;
    }

    private void d(String str) {
        if (FileUtils.exists(str)) {
            RVLogger.d(f24472a, "deleteOldPkgByFullInstall " + str);
            FileUtils.delete(str);
        }
    }

    private String e(String str) {
        return RVConstants.SUB_PACKAGE_DIR_PREFIX + this.c.getAppId() + c49.f40900a + FileUtils.getMD5(str);
    }

    private String f(String str) {
        String strB = b();
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(str)) {
            return "";
        }
        String strCombinePath = FileUtils.combinePath(strB, e(str));
        RVLogger.d(f24472a, "downloadedFilePath:" + strCombinePath);
        return strCombinePath;
    }

    private boolean g(String str) {
        String strF = f(str);
        boolean zExists = FileUtils.exists(strF);
        RVLogger.d(f24472a, "isPkgAvailable: path:" + strF + " isExist:" + zExists);
        return zExists;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String string = JSONUtils.getString(this.c.getAppInfoModel().getSubPackages(), this.d);
        if (TextUtils.isEmpty(str)) {
            str = f(string);
        }
        if (!g(string)) {
            return e();
        }
        boolean zC = c(str);
        if (zC) {
            return zC;
        }
        ((EventTracker) RVProxy.get(EventTracker.class)).error(this.e, TrackId.Error_Resource_SubPackageFail, "install failed!");
        return zC;
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24472a, "installSubPackage failed, download file path is null");
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            if (e()) {
                return true;
            }
            d(c());
            if (ZipUtils.unZip(str, c()) && e()) {
                RVLogger.d(f24472a, "installSubPackage success!");
                FileUtils.delete(file);
                return true;
            }
            RVLogger.e(f24472a, "subpackage unzip fail");
            FileUtils.delete(file);
            RVLogger.e(f24472a, "installSubPackage unZipResult || isInstalled() return false");
            return false;
        } catch (Exception e) {
            RVLogger.e(f24472a, "subpackage parse error: ", e);
            return false;
        }
    }

    private boolean e() {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            RVLogger.e(f24472a, "getInstalledPath() is empty");
            return false;
        }
        try {
            File file = new File(strC);
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                int length = fileArrListFiles.length;
                RVLogger.d(f24472a, "isInstalled length:" + length);
                if (length > 0) {
                    boolean z = false;
                    for (File file2 : fileArrListFiles) {
                        String name = file2.getName();
                        RVLogger.d(f24472a, "installed dir file " + name);
                        if (name.contains("tar")) {
                            z = true;
                        }
                    }
                    if (length < 4 && !z) {
                        RVLogger.e(f24472a, "installSubPackage files broken, delete broken files");
                        d(strC);
                        return false;
                    }
                    if (z) {
                        return true;
                    }
                    RVLogger.e(f24472a, "installSubPackage files broken, delete broken files");
                    d(strC);
                    return false;
                }
            }
        } catch (Exception e) {
            RVLogger.e(f24472a, e);
        }
        return false;
    }

    public void a() {
        String string = JSONUtils.getString(this.c.getAppInfoModel().getSubPackages(), this.d);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (e()) {
            RVLogger.d(f24472a, "prepareSubpackage Package has been downloaded and installed, mAppModel: " + this.c + " url:" + string);
            this.f.a(c());
            return;
        }
        if (g(string)) {
            RVLogger.d(f24472a, "prepareSubpackage Package downloaded not installed, to install, mAppModel: " + this.c + " url:" + string);
            if (b((String) null)) {
                this.f.a(c());
                return;
            } else {
                this.f.b("install failed!");
                RVLogger.e(f24472a, "prepareSubpackage install failed");
                return;
            }
        }
        RVLogger.d(f24472a, "prepareSubpackage Package not downloaded not installed, to download and install, mAppModel: " + this.c + " url:" + string);
        a(string);
    }

    private String d() {
        if (TextUtils.isEmpty(this.d)) {
            return "";
        }
        return RVConstants.SUB_PACKAGE_DIR_PREFIX + this.d.replace('/', '_');
    }

    private String b() {
        String path = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getCacheDir().getPath();
        return !TextUtils.isEmpty(path) ? path : "";
    }

    private void a(String str) {
        RVLogger.d(f24472a, "addDownload subpackage url:" + str);
        if (!str.startsWith("http") || this.b == null) {
            return;
        }
        RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
        rVDownloadRequest.setDownloadUrl(str);
        rVDownloadRequest.setDownloadDir(b());
        rVDownloadRequest.setDownloadFileName(e(str));
        rVDownloadRequest.setIsUrgentResource(true);
        this.b.addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.ariver.resource.subpackage.a.1
            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onCancel(String str2) {
                ((EventTracker) RVProxy.get(EventTracker.class)).error(a.this.e, TrackId.Error_Resource_SubPackageFail, "download canceled!");
                a.this.f.b("download canceled!");
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onFailed(String str2, int i, String str3) {
                ((EventTracker) RVProxy.get(EventTracker.class)).error(a.this.e, TrackId.Error_Resource_SubPackageFail, "download failed!" + str3);
                a.this.f.b("download failed!" + str3);
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onFinish(@Nullable String str2) {
                if (a.this.b(str2)) {
                    a.this.f.a(a.this.c());
                } else {
                    a.this.f.b("install failed!");
                }
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onPrepare(String str2) {
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onProgress(String str2, int i) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        File extDirectory = RVResourceUtils.getExtDirectory(this.c, true);
        return extDirectory == null ? "" : FileUtils.combinePath(extDirectory.getAbsolutePath(), d());
    }
}
