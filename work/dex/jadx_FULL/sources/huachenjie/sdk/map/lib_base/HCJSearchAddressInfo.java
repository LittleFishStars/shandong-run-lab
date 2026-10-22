package huachenjie.sdk.map.lib_base;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class HCJSearchAddressInfo extends HCJAddressInfo {
    private String Snippet;
    private String subPoiTitle;
    private List<HCJSearchAddressInfo> subPois;
    private String typeCode;

    public String getSnippet() {
        return this.Snippet;
    }

    public String getSubPoiTitle() {
        return this.subPoiTitle;
    }

    public List<HCJSearchAddressInfo> getSubPois() {
        return this.subPois;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setSnippet(String str) {
        this.Snippet = str;
    }

    public void setSubPoiTitle(String str) {
        this.subPoiTitle = str;
    }

    public void setSubPois(List<HCJSearchAddressInfo> list) {
        this.subPois = list;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }
}
