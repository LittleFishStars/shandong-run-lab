package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizePublicFaceAdvanceRequest extends TeaModel {

    @NameInMap("Task")
    public List<RecognizePublicFaceAdvanceRequestTask> task;

    public static class RecognizePublicFaceAdvanceRequestTask extends TeaModel {

        @NameInMap("ImageData")
        public String imageData;

        @NameInMap("ImageURL")
        public InputStream imageURLObject;

        public static RecognizePublicFaceAdvanceRequestTask build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceAdvanceRequestTask) TeaModel.build(map, new RecognizePublicFaceAdvanceRequestTask());
        }

        public String getImageData() {
            return this.imageData;
        }

        public InputStream getImageURLObject() {
            return this.imageURLObject;
        }

        public RecognizePublicFaceAdvanceRequestTask setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public RecognizePublicFaceAdvanceRequestTask setImageURLObject(InputStream inputStream) {
            this.imageURLObject = inputStream;
            return this;
        }
    }

    public static RecognizePublicFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (RecognizePublicFaceAdvanceRequest) TeaModel.build(map, new RecognizePublicFaceAdvanceRequest());
    }

    public List<RecognizePublicFaceAdvanceRequestTask> getTask() {
        return this.task;
    }

    public RecognizePublicFaceAdvanceRequest setTask(List<RecognizePublicFaceAdvanceRequestTask> list) {
        this.task = list;
        return this;
    }
}
