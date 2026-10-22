package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MergeImageFaceAdvanceRequest extends TeaModel {

    @NameInMap("AddWatermark")
    public Boolean addWatermark;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("MergeInfos")
    public List<MergeImageFaceAdvanceRequestMergeInfos> mergeInfos;

    @NameInMap("ModelVersion")
    public String modelVersion;

    @NameInMap("TemplateId")
    public String templateId;

    @NameInMap("WatermarkType")
    public String watermarkType;

    public static class MergeImageFaceAdvanceRequestMergeInfos extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("TemplateFaceID")
        public String templateFaceID;

        public static MergeImageFaceAdvanceRequestMergeInfos build(Map<String, ?> map) throws Exception {
            return (MergeImageFaceAdvanceRequestMergeInfos) TeaModel.build(map, new MergeImageFaceAdvanceRequestMergeInfos());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public String getTemplateFaceID() {
            return this.templateFaceID;
        }

        public MergeImageFaceAdvanceRequestMergeInfos setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public MergeImageFaceAdvanceRequestMergeInfos setTemplateFaceID(String str) {
            this.templateFaceID = str;
            return this;
        }
    }

    public static MergeImageFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (MergeImageFaceAdvanceRequest) TeaModel.build(map, new MergeImageFaceAdvanceRequest());
    }

    public Boolean getAddWatermark() {
        return this.addWatermark;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public List<MergeImageFaceAdvanceRequestMergeInfos> getMergeInfos() {
        return this.mergeInfos;
    }

    public String getModelVersion() {
        return this.modelVersion;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getWatermarkType() {
        return this.watermarkType;
    }

    public MergeImageFaceAdvanceRequest setAddWatermark(Boolean bool) {
        this.addWatermark = bool;
        return this;
    }

    public MergeImageFaceAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public MergeImageFaceAdvanceRequest setMergeInfos(List<MergeImageFaceAdvanceRequestMergeInfos> list) {
        this.mergeInfos = list;
        return this;
    }

    public MergeImageFaceAdvanceRequest setModelVersion(String str) {
        this.modelVersion = str;
        return this;
    }

    public MergeImageFaceAdvanceRequest setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public MergeImageFaceAdvanceRequest setWatermarkType(String str) {
        this.watermarkType = str;
        return this;
    }
}
