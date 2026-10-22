package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down;

import android.text.TextUtils;
import com.aliyun.credentials.utils.AuthConstant;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.permission.PermissionModel;
import com.beizi.fusion.kg;
import com.huawei.hms.push.AttributionReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DownloadInfoModel extends ASNPJsonResponseModel {

    @kg(key = TKDownloadReason.KSAD_TK_MD5)
    private String apkMD5;

    @kg(key = "appIntro")
    private String appIntroduction;

    @kg(key = "bundle")
    private String bundle;

    @kg(key = "developer")
    private String developer;

    @kg(key = "iconUrl")
    private String iconUrl;

    @kg(key = "name")
    private String name;

    @kg(key = AttributionReporter.SYSTEM_PERMISSION)
    private List<PermissionModel> permission;

    @kg(key = "permissionUrl")
    private String permissionUrl;

    @kg(key = AuthConstant.INI_POLICY)
    private String policy;

    @kg(key = "policyUrl")
    private String policyUrl;

    @kg(key = "size")
    private String size;

    @kg(key = "version")
    private String version;

    public DownloadInfoModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getApkMD5() {
        return this.apkMD5;
    }

    public String getAppIntroduction() {
        return this.appIntroduction;
    }

    public String getBundle() {
        return this.bundle;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public List<PermissionModel> getPermission() {
        return this.permission;
    }

    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getPolicyUrl() {
        return this.policyUrl;
    }

    public String getSize() {
        return this.size;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isConformanceByDlInfo() {
        if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.developer) || TextUtils.isEmpty(this.version)) {
            return false;
        }
        if (TextUtils.isEmpty(this.policy) && TextUtils.isEmpty(this.policyUrl)) {
            return false;
        }
        List<PermissionModel> list = this.permission;
        return (((list == null || list.isEmpty()) && TextUtils.isEmpty(this.permissionUrl)) || TextUtils.isEmpty(this.appIntroduction)) ? false : true;
    }
}
