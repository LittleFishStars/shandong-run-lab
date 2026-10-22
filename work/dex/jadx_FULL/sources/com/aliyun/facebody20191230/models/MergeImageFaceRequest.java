package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MergeImageFaceRequest extends TeaModel {

    @NameInMap("AddWatermark")
    public Boolean addWatermark;

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("MergeInfos")
    public List<MergeImageFaceRequestMergeInfos> mergeInfos;

    @NameInMap("ModelVersion")
    public String modelVersion;

    @NameInMap("TemplateId")
    public String templateId;

    @NameInMap("WatermarkType")
    public String watermarkType;

    public static class MergeImageFaceRequestMergeInfos extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("TemplateFaceID")
        public String templateFaceID;

        public static MergeImageFaceRequestMergeInfos build(Map<String, ?> map) throws Exception {
            return (MergeImageFaceRequestMergeInfos) TeaModel.build(map, new MergeImageFaceRequestMergeInfos());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public String getTemplateFaceID() {
            return this.templateFaceID;
        }

        public MergeImageFaceRequestMergeInfos setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public MergeImageFaceRequestMergeInfos setTemplateFaceID(String str) {
            this.templateFaceID = str;
            return this;
        }
    }

    public static MergeImageFaceRequest build(Map<String, ?> map) throws Exception {
        return (MergeImageFaceRequest) TeaModel.build(map, new MergeImageFaceRequest());
    }

    public Boolean getAddWatermark() {
        return this.addWatermark;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public List<MergeImageFaceRequestMergeInfos> getMergeInfos() {
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

    public MergeImageFaceRequest setAddWatermark(Boolean bool) {
        this.addWatermark = bool;
        return this;
    }

    public MergeImageFaceRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public MergeImageFaceRequest setMergeInfos(List<MergeImageFaceRequestMergeInfos> list) {
        this.mergeInfos = list;
        return this;
    }

    public MergeImageFaceRequest setModelVersion(String str) {
        this.modelVersion = str;
        return this;
    }

    public MergeImageFaceRequest setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public MergeImageFaceRequest setWatermarkType(String str) {
        this.watermarkType = str;
        return this;
    }
}
