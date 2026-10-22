package com.aliyun.facebody20191230.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BeautifyBodyShrinkRequest extends TeaModel {

    @NameInMap("AgeRange")
    public String ageRangeShrink;

    @NameInMap("BodyBoxes")
    public String bodyBoxesShrink;

    @NameInMap(TypedValues.Custom.NAME)
    public Long custom;

    @NameInMap("FaceList")
    public String faceListShrink;

    @NameInMap("FemaleLiquifyDegree")
    public Float femaleLiquifyDegree;

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("IsPregnant")
    public Boolean isPregnant;

    @NameInMap("LengthenDegree")
    public Float lengthenDegree;

    @NameInMap("MaleLiquifyDegree")
    public Float maleLiquifyDegree;

    @NameInMap("OriginalHeight")
    public Long originalHeight;

    @NameInMap("OriginalWidth")
    public Long originalWidth;

    @NameInMap("PoseList")
    public String poseListShrink;

    public static BeautifyBodyShrinkRequest build(Map<String, ?> map) throws Exception {
        return (BeautifyBodyShrinkRequest) TeaModel.build(map, new BeautifyBodyShrinkRequest());
    }

    public String getAgeRangeShrink() {
        return this.ageRangeShrink;
    }

    public String getBodyBoxesShrink() {
        return this.bodyBoxesShrink;
    }

    public Long getCustom() {
        return this.custom;
    }

    public String getFaceListShrink() {
        return this.faceListShrink;
    }

    public Float getFemaleLiquifyDegree() {
        return this.femaleLiquifyDegree;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Boolean getIsPregnant() {
        return this.isPregnant;
    }

    public Float getLengthenDegree() {
        return this.lengthenDegree;
    }

    public Float getMaleLiquifyDegree() {
        return this.maleLiquifyDegree;
    }

    public Long getOriginalHeight() {
        return this.originalHeight;
    }

    public Long getOriginalWidth() {
        return this.originalWidth;
    }

    public String getPoseListShrink() {
        return this.poseListShrink;
    }

    public BeautifyBodyShrinkRequest setAgeRangeShrink(String str) {
        this.ageRangeShrink = str;
        return this;
    }

    public BeautifyBodyShrinkRequest setBodyBoxesShrink(String str) {
        this.bodyBoxesShrink = str;
        return this;
    }

    public BeautifyBodyShrinkRequest setCustom(Long l) {
        this.custom = l;
        return this;
    }

    public BeautifyBodyShrinkRequest setFaceListShrink(String str) {
        this.faceListShrink = str;
        return this;
    }

    public BeautifyBodyShrinkRequest setFemaleLiquifyDegree(Float f) {
        this.femaleLiquifyDegree = f;
        return this;
    }

    public BeautifyBodyShrinkRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public BeautifyBodyShrinkRequest setIsPregnant(Boolean bool) {
        this.isPregnant = bool;
        return this;
    }

    public BeautifyBodyShrinkRequest setLengthenDegree(Float f) {
        this.lengthenDegree = f;
        return this;
    }

    public BeautifyBodyShrinkRequest setMaleLiquifyDegree(Float f) {
        this.maleLiquifyDegree = f;
        return this;
    }

    public BeautifyBodyShrinkRequest setOriginalHeight(Long l) {
        this.originalHeight = l;
        return this;
    }

    public BeautifyBodyShrinkRequest setOriginalWidth(Long l) {
        this.originalWidth = l;
        return this;
    }

    public BeautifyBodyShrinkRequest setPoseListShrink(String str) {
        this.poseListShrink = str;
        return this;
    }
}
