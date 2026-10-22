package com.aliyun.openplatform20191219.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthorizeFileUploadRequest extends TeaModel {

    @NameInMap("Product")
    public String product;

    @NameInMap("RegionId")
    public String regionId;

    public static AuthorizeFileUploadRequest build(Map<String, ?> map) throws Exception {
        return (AuthorizeFileUploadRequest) TeaModel.build(map, new AuthorizeFileUploadRequest());
    }

    public String getProduct() {
        return this.product;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public AuthorizeFileUploadRequest setProduct(String str) {
        this.product = str;
        return this;
    }

    public AuthorizeFileUploadRequest setRegionId(String str) {
        this.regionId = str;
        return this;
    }
}
