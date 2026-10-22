package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceImageTemplateResponseBody extends TeaModel {

    @NameInMap("Data")
    public AddFaceImageTemplateResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class AddFaceImageTemplateResponseBodyData extends TeaModel {

        @NameInMap("FaceInfos")
        public List<AddFaceImageTemplateResponseBodyDataFaceInfos> faceInfos;

        @NameInMap("TemplateId")
        public String templateId;

        public static AddFaceImageTemplateResponseBodyData build(Map<String, ?> map) throws Exception {
            return (AddFaceImageTemplateResponseBodyData) TeaModel.build(map, new AddFaceImageTemplateResponseBodyData());
        }

        public List<AddFaceImageTemplateResponseBodyDataFaceInfos> getFaceInfos() {
            return this.faceInfos;
        }

        public String getTemplateId() {
            return this.templateId;
        }

        public AddFaceImageTemplateResponseBodyData setFaceInfos(List<AddFaceImageTemplateResponseBodyDataFaceInfos> list) {
            this.faceInfos = list;
            return this;
        }

        public AddFaceImageTemplateResponseBodyData setTemplateId(String str) {
            this.templateId = str;
            return this;
        }
    }

    public static class AddFaceImageTemplateResponseBodyDataFaceInfos extends TeaModel {

        @NameInMap("FaceRect")
        public AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect faceRect;

        @NameInMap("TemplateFaceID")
        public String templateFaceID;

        public static AddFaceImageTemplateResponseBodyDataFaceInfos build(Map<String, ?> map) throws Exception {
            return (AddFaceImageTemplateResponseBodyDataFaceInfos) TeaModel.build(map, new AddFaceImageTemplateResponseBodyDataFaceInfos());
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect getFaceRect() {
            return this.faceRect;
        }

        public String getTemplateFaceID() {
            return this.templateFaceID;
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfos setFaceRect(AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect addFaceImageTemplateResponseBodyDataFaceInfosFaceRect) {
            this.faceRect = addFaceImageTemplateResponseBodyDataFaceInfosFaceRect;
            return this;
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfos setTemplateFaceID(String str) {
            this.templateFaceID = str;
            return this;
        }
    }

    public static class AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public String height;

        @NameInMap("Width")
        public String width;

        @NameInMap("X")
        public String x;

        @NameInMap("Y")
        public String y;

        public static AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect build(Map<String, ?> map) throws Exception {
            return (AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect) TeaModel.build(map, new AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect());
        }

        public String getHeight() {
            return this.height;
        }

        public String getWidth() {
            return this.width;
        }

        public String getX() {
            return this.x;
        }

        public String getY() {
            return this.y;
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect setHeight(String str) {
            this.height = str;
            return this;
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect setWidth(String str) {
            this.width = str;
            return this;
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect setX(String str) {
            this.x = str;
            return this;
        }

        public AddFaceImageTemplateResponseBodyDataFaceInfosFaceRect setY(String str) {
            this.y = str;
            return this;
        }
    }

    public static AddFaceImageTemplateResponseBody build(Map<String, ?> map) throws Exception {
        return (AddFaceImageTemplateResponseBody) TeaModel.build(map, new AddFaceImageTemplateResponseBody());
    }

    public AddFaceImageTemplateResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AddFaceImageTemplateResponseBody setData(AddFaceImageTemplateResponseBodyData addFaceImageTemplateResponseBodyData) {
        this.data = addFaceImageTemplateResponseBodyData;
        return this;
    }

    public AddFaceImageTemplateResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
