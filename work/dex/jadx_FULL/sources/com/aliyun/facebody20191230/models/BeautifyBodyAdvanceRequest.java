package com.aliyun.facebody20191230.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.common.net.b;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BeautifyBodyAdvanceRequest extends TeaModel {

    @NameInMap("AgeRange")
    public BeautifyBodyAdvanceRequestAgeRange ageRange;

    @NameInMap("BodyBoxes")
    public List<BeautifyBodyAdvanceRequestBodyBoxes> bodyBoxes;

    @NameInMap(TypedValues.Custom.NAME)
    public Long custom;

    @NameInMap("FaceList")
    public List<BeautifyBodyAdvanceRequestFaceList> faceList;

    @NameInMap("FemaleLiquifyDegree")
    public Float femaleLiquifyDegree;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

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
    public List<BeautifyBodyAdvanceRequestPoseList> poseList;

    public static class BeautifyBodyAdvanceRequestAgeRange extends TeaModel {

        @NameInMap("AgeMax")
        public Long ageMax;

        @NameInMap("AgeMinimum")
        public Long ageMinimum;

        public static BeautifyBodyAdvanceRequestAgeRange build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyAdvanceRequestAgeRange) TeaModel.build(map, new BeautifyBodyAdvanceRequestAgeRange());
        }

        public Long getAgeMax() {
            return this.ageMax;
        }

        public Long getAgeMinimum() {
            return this.ageMinimum;
        }

        public BeautifyBodyAdvanceRequestAgeRange setAgeMax(Long l) {
            this.ageMax = l;
            return this;
        }

        public BeautifyBodyAdvanceRequestAgeRange setAgeMinimum(Long l) {
            this.ageMinimum = l;
            return this;
        }
    }

    public static class BeautifyBodyAdvanceRequestBodyBoxes extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Float height;

        @NameInMap("Width")
        public Float width;

        @NameInMap("X")
        public Float x;

        @NameInMap("Y")
        public Float y;

        public static BeautifyBodyAdvanceRequestBodyBoxes build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyAdvanceRequestBodyBoxes) TeaModel.build(map, new BeautifyBodyAdvanceRequestBodyBoxes());
        }

        public Float getHeight() {
            return this.height;
        }

        public Float getWidth() {
            return this.width;
        }

        public Float getX() {
            return this.x;
        }

        public Float getY() {
            return this.y;
        }

        public BeautifyBodyAdvanceRequestBodyBoxes setHeight(Float f) {
            this.height = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestBodyBoxes setWidth(Float f) {
            this.width = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestBodyBoxes setX(Float f) {
            this.x = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestBodyBoxes setY(Float f) {
            this.y = f;
            return this;
        }
    }

    public static class BeautifyBodyAdvanceRequestFaceList extends TeaModel {

        @NameInMap(b.X)
        public Long age;

        @NameInMap("FaceBox")
        public BeautifyBodyAdvanceRequestFaceListFaceBox faceBox;

        @NameInMap("Gender")
        public Long gender;

        public static BeautifyBodyAdvanceRequestFaceList build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyAdvanceRequestFaceList) TeaModel.build(map, new BeautifyBodyAdvanceRequestFaceList());
        }

        public Long getAge() {
            return this.age;
        }

        public BeautifyBodyAdvanceRequestFaceListFaceBox getFaceBox() {
            return this.faceBox;
        }

        public Long getGender() {
            return this.gender;
        }

        public BeautifyBodyAdvanceRequestFaceList setAge(Long l) {
            this.age = l;
            return this;
        }

        public BeautifyBodyAdvanceRequestFaceList setFaceBox(BeautifyBodyAdvanceRequestFaceListFaceBox beautifyBodyAdvanceRequestFaceListFaceBox) {
            this.faceBox = beautifyBodyAdvanceRequestFaceListFaceBox;
            return this;
        }

        public BeautifyBodyAdvanceRequestFaceList setGender(Long l) {
            this.gender = l;
            return this;
        }
    }

    public static class BeautifyBodyAdvanceRequestFaceListFaceBox extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Float height;

        @NameInMap("Width")
        public Float width;

        @NameInMap("X")
        public Float x;

        @NameInMap("Y")
        public Float y;

        public static BeautifyBodyAdvanceRequestFaceListFaceBox build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyAdvanceRequestFaceListFaceBox) TeaModel.build(map, new BeautifyBodyAdvanceRequestFaceListFaceBox());
        }

        public Float getHeight() {
            return this.height;
        }

        public Float getWidth() {
            return this.width;
        }

        public Float getX() {
            return this.x;
        }

        public Float getY() {
            return this.y;
        }

        public BeautifyBodyAdvanceRequestFaceListFaceBox setHeight(Float f) {
            this.height = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestFaceListFaceBox setWidth(Float f) {
            this.width = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestFaceListFaceBox setX(Float f) {
            this.x = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestFaceListFaceBox setY(Float f) {
            this.y = f;
            return this;
        }
    }

    public static class BeautifyBodyAdvanceRequestPoseList extends TeaModel {

        @NameInMap("Pose")
        public List<BeautifyBodyAdvanceRequestPoseListPose> pose;

        public static BeautifyBodyAdvanceRequestPoseList build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyAdvanceRequestPoseList) TeaModel.build(map, new BeautifyBodyAdvanceRequestPoseList());
        }

        public List<BeautifyBodyAdvanceRequestPoseListPose> getPose() {
            return this.pose;
        }

        public BeautifyBodyAdvanceRequestPoseList setPose(List<BeautifyBodyAdvanceRequestPoseListPose> list) {
            this.pose = list;
            return this;
        }
    }

    public static class BeautifyBodyAdvanceRequestPoseListPose extends TeaModel {

        @NameInMap("Score")
        public Float score;

        @NameInMap("X")
        public Long x;

        @NameInMap("Y")
        public Long y;

        public static BeautifyBodyAdvanceRequestPoseListPose build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyAdvanceRequestPoseListPose) TeaModel.build(map, new BeautifyBodyAdvanceRequestPoseListPose());
        }

        public Float getScore() {
            return this.score;
        }

        public Long getX() {
            return this.x;
        }

        public Long getY() {
            return this.y;
        }

        public BeautifyBodyAdvanceRequestPoseListPose setScore(Float f) {
            this.score = f;
            return this;
        }

        public BeautifyBodyAdvanceRequestPoseListPose setX(Long l) {
            this.x = l;
            return this;
        }

        public BeautifyBodyAdvanceRequestPoseListPose setY(Long l) {
            this.y = l;
            return this;
        }
    }

    public static BeautifyBodyAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (BeautifyBodyAdvanceRequest) TeaModel.build(map, new BeautifyBodyAdvanceRequest());
    }

    public BeautifyBodyAdvanceRequestAgeRange getAgeRange() {
        return this.ageRange;
    }

    public List<BeautifyBodyAdvanceRequestBodyBoxes> getBodyBoxes() {
        return this.bodyBoxes;
    }

    public Long getCustom() {
        return this.custom;
    }

    public List<BeautifyBodyAdvanceRequestFaceList> getFaceList() {
        return this.faceList;
    }

    public Float getFemaleLiquifyDegree() {
        return this.femaleLiquifyDegree;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
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

    public List<BeautifyBodyAdvanceRequestPoseList> getPoseList() {
        return this.poseList;
    }

    public BeautifyBodyAdvanceRequest setAgeRange(BeautifyBodyAdvanceRequestAgeRange beautifyBodyAdvanceRequestAgeRange) {
        this.ageRange = beautifyBodyAdvanceRequestAgeRange;
        return this;
    }

    public BeautifyBodyAdvanceRequest setBodyBoxes(List<BeautifyBodyAdvanceRequestBodyBoxes> list) {
        this.bodyBoxes = list;
        return this;
    }

    public BeautifyBodyAdvanceRequest setCustom(Long l) {
        this.custom = l;
        return this;
    }

    public BeautifyBodyAdvanceRequest setFaceList(List<BeautifyBodyAdvanceRequestFaceList> list) {
        this.faceList = list;
        return this;
    }

    public BeautifyBodyAdvanceRequest setFemaleLiquifyDegree(Float f) {
        this.femaleLiquifyDegree = f;
        return this;
    }

    public BeautifyBodyAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public BeautifyBodyAdvanceRequest setIsPregnant(Boolean bool) {
        this.isPregnant = bool;
        return this;
    }

    public BeautifyBodyAdvanceRequest setLengthenDegree(Float f) {
        this.lengthenDegree = f;
        return this;
    }

    public BeautifyBodyAdvanceRequest setMaleLiquifyDegree(Float f) {
        this.maleLiquifyDegree = f;
        return this;
    }

    public BeautifyBodyAdvanceRequest setOriginalHeight(Long l) {
        this.originalHeight = l;
        return this;
    }

    public BeautifyBodyAdvanceRequest setOriginalWidth(Long l) {
        this.originalWidth = l;
        return this;
    }

    public BeautifyBodyAdvanceRequest setPoseList(List<BeautifyBodyAdvanceRequestPoseList> list) {
        this.poseList = list;
        return this;
    }
}
