package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VerifyFaceMaskRequest extends TeaModel {

    @NameInMap("ImageData")
    public byte[] imageData;

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("RefData")
    public byte[] refData;

    @NameInMap("RefUrl")
    public String refUrl;

    public static VerifyFaceMaskRequest build(Map<String, ?> map) throws Exception {
        return (VerifyFaceMaskRequest) TeaModel.build(map, new VerifyFaceMaskRequest());
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public byte[] getRefData() {
        return this.refData;
    }

    public String getRefUrl() {
        return this.refUrl;
    }

    public VerifyFaceMaskRequest setImageData(byte[] bArr) {
        this.imageData = bArr;
        return this;
    }

    public VerifyFaceMaskRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public VerifyFaceMaskRequest setRefData(byte[] bArr) {
        this.refData = bArr;
        return this;
    }

    public VerifyFaceMaskRequest setRefUrl(String str) {
        this.refUrl = str;
        return this;
    }
}
