package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizePublicFaceRequest extends TeaModel {

    @NameInMap("Task")
    public List<RecognizePublicFaceRequestTask> task;

    public static class RecognizePublicFaceRequestTask extends TeaModel {

        @NameInMap("ImageData")
        public String imageData;

        @NameInMap("ImageURL")
        public String imageURL;

        public static RecognizePublicFaceRequestTask build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceRequestTask) TeaModel.build(map, new RecognizePublicFaceRequestTask());
        }

        public String getImageData() {
            return this.imageData;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public RecognizePublicFaceRequestTask setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public RecognizePublicFaceRequestTask setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static RecognizePublicFaceRequest build(Map<String, ?> map) throws Exception {
        return (RecognizePublicFaceRequest) TeaModel.build(map, new RecognizePublicFaceRequest());
    }

    public List<RecognizePublicFaceRequestTask> getTask() {
        return this.task;
    }

    public RecognizePublicFaceRequest setTask(List<RecognizePublicFaceRequestTask> list) {
        this.task = list;
        return this;
    }
}
