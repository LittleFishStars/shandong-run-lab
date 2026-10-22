package com.alibaba.ariver.resource.template;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements Future<TemplateExtModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24474a = "AriverRes:TemplateExtLoader";
    private static final String b = "template_ext_";
    private AppModel c;
    private TemplateConfigModel d;
    private TemplateExtModel e;

    public a(AppModel appModel) {
        this.c = appModel;
        this.d = appModel.getAppInfoModel().getTemplateConfig();
    }

    private TemplateExtModel b() {
        if (!this.d.isTemplateValid()) {
            return null;
        }
        if (TextUtils.isEmpty(this.d.getExtUrl())) {
            this.e = this.d.getExtModel();
        } else {
            File extDirectory = RVResourceUtils.getExtDirectory(this.c, true);
            if (extDirectory == null) {
                return null;
            }
            String str = b + FileUtils.getMD5(this.d.getExtUrl());
            final String strCombinePath = FileUtils.combinePath(extDirectory.getAbsolutePath(), str);
            if (FileUtils.exists(strCombinePath)) {
                String str2 = IOUtils.read(strCombinePath);
                if (str2 == null) {
                    FileUtils.delete(strCombinePath);
                } else {
                    this.e = (TemplateExtModel) JSONUtils.parseObject(str2.getBytes(), TemplateExtModel.class);
                    RVLogger.d(f24474a, "got downloaded template from " + strCombinePath + ", value: " + this.e);
                    TemplateExtModel templateExtModel = this.e;
                    if (templateExtModel != null) {
                        return templateExtModel;
                    }
                }
            }
            RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
            rVDownloadRequest.setDownloadDir(extDirectory.getAbsolutePath());
            rVDownloadRequest.setDownloadFileName(str);
            rVDownloadRequest.setDownloadUrl(this.d.getExtUrl());
            rVDownloadRequest.setIsUrgentResource(true);
            RVLogger.d(f24474a, "begin download template config to " + strCombinePath);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ((RVTransportService) RVProxy.get(RVTransportService.class)).addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.ariver.resource.template.a.1
                @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                public void onCancel(String str3) {
                    RVLogger.w(a.f24474a, "download onCancel");
                    FileUtils.delete(strCombinePath);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                public void onFailed(String str3, int i, String str4) {
                    RVLogger.e(a.f24474a, "download onFailed: " + i + " " + str4);
                    FileUtils.delete(strCombinePath);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                public void onFinish(@Nullable String str3) {
                    String str4 = IOUtils.read(strCombinePath);
                    if (str4 == null) {
                        onFailed(str3, 0, "extObject read exception!");
                        return;
                    }
                    a.this.e = (TemplateExtModel) JSONUtils.parseObject(str4.getBytes(), TemplateExtModel.class);
                    if (a.this.e == null) {
                        onFailed(str3, 0, "extObject parse fail!");
                        return;
                    }
                    RVLogger.d(a.f24474a, "download onFinish extObject: " + a.this.e);
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                public void onPrepare(String str3) {
                }

                @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                public void onProgress(String str3, int i) {
                }
            });
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                RVLogger.e(f24474a, "await exception!", e);
                return null;
            }
        }
        return this.e;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.e != null;
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TemplateExtModel get() {
        return b();
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TemplateExtModel get(long j, @NonNull TimeUnit timeUnit) {
        return b();
    }
}
