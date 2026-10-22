package cj.mobile.wm.common.bean;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InstReportBean {
    public String androidId;
    public String app_version;
    public String ctzid;
    public String imei;
    public List<String> install_app_bundles;
    public List<Integer> install_app_ids;
    public String model;
    public String oaid;
    public int os_type = 1;
    public String os_version;
    public long track_time;
    public int track_type;
    public List<Integer> uninstall_app_ids;
    public String vendor;

    public String getAndroidId() {
        return this.androidId;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getCtzid() {
        return this.ctzid;
    }

    public String getImei() {
        return this.imei;
    }

    public List<String> getInstall_app_bundles() {
        return this.install_app_bundles;
    }

    public List<Integer> getInstall_app_ids() {
        return this.install_app_ids;
    }

    public String getModel() {
        return this.model;
    }

    public String getOaid() {
        return this.oaid;
    }

    public int getOs_type() {
        return this.os_type;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public long getTrack_time() {
        return this.track_time;
    }

    public int getTrack_type() {
        return this.track_type;
    }

    public List<Integer> getUninstall_app_ids() {
        return this.uninstall_app_ids;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setAndroidId(String str) {
        this.androidId = str;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setCtzid(String str) {
        this.ctzid = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setInstall_app_bundles(List<String> list) {
        this.install_app_bundles = list;
    }

    public void setInstall_app_ids(List<Integer> list) {
        this.install_app_ids = list;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOs_type(int i) {
        this.os_type = i;
    }

    public void setOs_version(String str) {
        this.os_version = str;
    }

    public void setTrack_time(long j) {
        this.track_time = j;
    }

    public void setTrack_type(int i) {
        this.track_type = i;
    }

    public void setUninstall_app_ids(List<Integer> list) {
        this.uninstall_app_ids = list;
    }

    public void setVendor(String str) {
        this.vendor = str;
    }
}
