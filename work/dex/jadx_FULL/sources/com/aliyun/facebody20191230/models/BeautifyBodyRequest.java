package com.aliyun.facebody20191230.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.common.net.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BeautifyBodyRequest extends TeaModel {

    @NameInMap("AgeRange")
    public BeautifyBodyRequestAgeRange ageRange;

    @NameInMap("BodyBoxes")
    public List<BeautifyBodyRequestBodyBoxes> bodyBoxes;

    @NameInMap(TypedValues.Custom.NAME)
    public Long custom;

    @NameInMap("FaceList")
    public List<BeautifyBodyRequestFaceList> faceList;

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
    public List<BeautifyBodyRequestPoseList> poseList;

    public static class BeautifyBodyRequestAgeRange extends TeaModel {

        @NameInMap("AgeMax")
        public Long ageMax;

        @NameInMap("AgeMinimum")
        public Long ageMinimum;

        public static BeautifyBodyRequestAgeRange build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyRequestAgeRange) TeaModel.build(map, new BeautifyBodyRequestAgeRange());
        }

        public Long getAgeMax() {
            return this.ageMax;
        }

        public Long getAgeMinimum() {
            return this.ageMinimum;
        }

        public BeautifyBodyRequestAgeRange setAgeMax(Long l) {
            this.ageMax = l;
            return this;
        }

        public BeautifyBodyRequestAgeRange setAgeMinimum(Long l) {
            this.ageMinimum = l;
            return this;
        }
    }

    public static class BeautifyBodyRequestBodyBoxes extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Float height;

        @NameInMap("Width")
        public Float width;

        @NameInMap("X")
        public Float x;

        @NameInMap("Y")
        public Float y;

        public static BeautifyBodyRequestBodyBoxes build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyRequestBodyBoxes) TeaModel.build(map, new BeautifyBodyRequestBodyBoxes());
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

        public BeautifyBodyRequestBodyBoxes setHeight(Float f) {
            this.height = f;
            return this;
        }

        public BeautifyBodyRequestBodyBoxes setWidth(Float f) {
            this.width = f;
            return this;
        }

        public BeautifyBodyRequestBodyBoxes setX(Float f) {
            this.x = f;
            return this;
        }

        public BeautifyBodyRequestBodyBoxes setY(Float f) {
            this.y = f;
            return this;
        }
    }

    public static class BeautifyBodyRequestFaceList extends TeaModel {

        @NameInMap(b.X)
        public Long age;

        @NameInMap("FaceBox")
        public BeautifyBodyRequestFaceListFaceBox faceBox;

        @NameInMap("Gender")
        public Long gender;

        public static BeautifyBodyRequestFaceList build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyRequestFaceList) TeaModel.build(map, new BeautifyBodyRequestFaceList());
        }

        public Long getAge() {
            return this.age;
        }

        public BeautifyBodyRequestFaceListFaceBox getFaceBox() {
            return this.faceBox;
        }

        public Long getGender() {
            return this.gender;
        }

        public BeautifyBodyRequestFaceList setAge(Long l) {
            this.age = l;
            return this;
        }

        public BeautifyBodyRequestFaceList setFaceBox(BeautifyBodyRequestFaceListFaceBox beautifyBodyRequestFaceListFaceBox) {
            this.faceBox = beautifyBodyRequestFaceListFaceBox;
            return this;
        }

        public BeautifyBodyRequestFaceList setGender(Long l) {
            this.gender = l;
            return this;
        }
    }

    public static class BeautifyBodyRequestFaceListFaceBox extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Float height;

        @NameInMap("Width")
        public Float width;

        @NameInMap("X")
        public Float x;

        @NameInMap("Y")
        public Float y;

        public static BeautifyBodyRequestFaceListFaceBox build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyRequestFaceListFaceBox) TeaModel.build(map, new BeautifyBodyRequestFaceListFaceBox());
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

        public BeautifyBodyRequestFaceListFaceBox setHeight(Float f) {
            this.height = f;
            return this;
        }

        public BeautifyBodyRequestFaceListFaceBox setWidth(Float f) {
            this.width = f;
            return this;
        }

        public BeautifyBodyRequestFaceListFaceBox setX(Float f) {
            this.x = f;
            return this;
        }

        public BeautifyBodyRequestFaceListFaceBox setY(Float f) {
            this.y = f;
            return this;
        }
    }

    public static class BeautifyBodyRequestPoseList extends TeaModel {

        @NameInMap("Pose")
        public List<BeautifyBodyRequestPoseListPose> pose;

        public static BeautifyBodyRequestPoseList build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyRequestPoseList) TeaModel.build(map, new BeautifyBodyRequestPoseList());
        }

        public List<BeautifyBodyRequestPoseListPose> getPose() {
            return this.pose;
        }

        public BeautifyBodyRequestPoseList setPose(List<BeautifyBodyRequestPoseListPose> list) {
            this.pose = list;
            return this;
        }
    }

    public static class BeautifyBodyRequestPoseListPose extends TeaModel {

        @NameInMap("Score")
        public Float score;

        @NameInMap("X")
        public Long x;

        @NameInMap("Y")
        public Long y;

        public static BeautifyBodyRequestPoseListPose build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyRequestPoseListPose) TeaModel.build(map, new BeautifyBodyRequestPoseListPose());
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

        public BeautifyBodyRequestPoseListPose setScore(Float f) {
            this.score = f;
            return this;
        }

        public BeautifyBodyRequestPoseListPose setX(Long l) {
            this.x = l;
            return this;
        }

        public BeautifyBodyRequestPoseListPose setY(Long l) {
            this.y = l;
            return this;
        }
    }

    public static BeautifyBodyRequest build(Map<String, ?> map) throws Exception {
        return (BeautifyBodyRequest) TeaModel.build(map, new BeautifyBodyRequest());
    }

    public BeautifyBodyRequestAgeRange getAgeRange() {
        return this.ageRange;
    }

    public List<BeautifyBodyRequestBodyBoxes> getBodyBoxes() {
        return this.bodyBoxes;
    }

    public Long getCustom() {
        return this.custom;
    }

    public List<BeautifyBodyRequestFaceList> getFaceList() {
        return this.faceList;
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

    public List<BeautifyBodyRequestPoseList> getPoseList() {
        return this.poseList;
    }

    public BeautifyBodyRequest setAgeRange(BeautifyBodyRequestAgeRange beautifyBodyRequestAgeRange) {
        this.ageRange = beautifyBodyRequestAgeRange;
        return this;
    }

    public BeautifyBodyRequest setBodyBoxes(List<BeautifyBodyRequestBodyBoxes> list) {
        this.bodyBoxes = list;
        return this;
    }

    public BeautifyBodyRequest setCustom(Long l) {
        this.custom = l;
        return this;
    }

    public BeautifyBodyRequest setFaceList(List<BeautifyBodyRequestFaceList> list) {
        this.faceList = list;
        return this;
    }

    public BeautifyBodyRequest setFemaleLiquifyDegree(Float f) {
        this.femaleLiquifyDegree = f;
        return this;
    }

    public BeautifyBodyRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public BeautifyBodyRequest setIsPregnant(Boolean bool) {
        this.isPregnant = bool;
        return this;
    }

    public BeautifyBodyRequest setLengthenDegree(Float f) {
        this.lengthenDegree = f;
        return this;
    }

    public BeautifyBodyRequest setMaleLiquifyDegree(Float f) {
        this.maleLiquifyDegree = f;
        return this;
    }

    public BeautifyBodyRequest setOriginalHeight(Long l) {
        this.originalHeight = l;
        return this;
    }

    public BeautifyBodyRequest setOriginalWidth(Long l) {
        this.originalWidth = l;
        return this;
    }

    public BeautifyBodyRequest setPoseList(List<BeautifyBodyRequestPoseList> list) {
        this.poseList = list;
        return this;
    }
}
