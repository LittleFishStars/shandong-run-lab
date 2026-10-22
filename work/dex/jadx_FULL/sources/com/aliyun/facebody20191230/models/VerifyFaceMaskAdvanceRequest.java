package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VerifyFaceMaskAdvanceRequest extends TeaModel {

    @NameInMap("ImageData")
    public byte[] imageData;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("RefData")
    public byte[] refData;

    @NameInMap("RefUrl")
    public InputStream refUrlObject;

    public static VerifyFaceMaskAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (VerifyFaceMaskAdvanceRequest) TeaModel.build(map, new VerifyFaceMaskAdvanceRequest());
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public byte[] getRefData() {
        return this.refData;
    }

    public InputStream getRefUrlObject() {
        return this.refUrlObject;
    }

    public VerifyFaceMaskAdvanceRequest setImageData(byte[] bArr) {
        this.imageData = bArr;
        return this;
    }

    public VerifyFaceMaskAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public VerifyFaceMaskAdvanceRequest setRefData(byte[] bArr) {
        this.refData = bArr;
        return this;
    }

    public VerifyFaceMaskAdvanceRequest setRefUrlObject(InputStream inputStream) {
        this.refUrlObject = inputStream;
        return this;
    }
}
