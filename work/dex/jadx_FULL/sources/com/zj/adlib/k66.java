package com.zj.adlib;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.huachenjie.common.aliyun.base.AliyunTokenConfig;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.OssTokenInfo;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k66 extends AliyunTokenConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile k66 f42751a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f17594a = "https://oss-cn-hangzhou.aliyuncs.com";
    public static final String b = "sd-campus-badge";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OssTokenInfo f17595a;

    public static k66 k() {
        if (f42751a == null) {
            synchronized (k66.class) {
                if (f42751a == null) {
                    f42751a = new k66();
                }
            }
        }
        return f42751a;
    }

    @Override // com.huachenjie.common.aliyun.base.AliyunTokenConfig
    public OssTokenInfo e() {
        if (this.f17595a == null) {
            this.f17595a = new OssTokenInfo();
        }
        return this.f17595a;
    }

    @Override // com.huachenjie.common.aliyun.base.AliyunTokenConfig
    public String f() {
        return "";
    }

    @Override // com.huachenjie.common.aliyun.base.AliyunTokenConfig
    public void i(OssTokenInfo tokenInfo) {
        this.f17595a = tokenInfo;
    }

    public String j(UploadFileType uploadType) {
        if (this.f17595a == null) {
            return "";
        }
        String value = uploadType.getValue();
        String directory = this.f17595a.getDirectory();
        String domain = this.f17595a.getDomain();
        if (TextUtils.isEmpty(directory)) {
            if (domain != null && domain.endsWith(WVNativeCallbackUtil.SEPERATER)) {
                return value;
            }
            return File.separator + value;
        }
        if (directory != null && directory.endsWith(WVNativeCallbackUtil.SEPERATER)) {
            return directory + value;
        }
        return directory + File.separator + value;
    }
}
