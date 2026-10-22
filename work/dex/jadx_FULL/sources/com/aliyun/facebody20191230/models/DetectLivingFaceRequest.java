package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectLivingFaceRequest extends TeaModel {

    @NameInMap("Tasks")
    public List<DetectLivingFaceRequestTasks> tasks;

    public static class DetectLivingFaceRequestTasks extends TeaModel {

        @NameInMap("ImageData")
        public String imageData;

        @NameInMap("ImageURL")
        public String imageURL;

        public static DetectLivingFaceRequestTasks build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceRequestTasks) TeaModel.build(map, new DetectLivingFaceRequestTasks());
        }

        public String getImageData() {
            return this.imageData;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public DetectLivingFaceRequestTasks setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public DetectLivingFaceRequestTasks setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static DetectLivingFaceRequest build(Map<String, ?> map) throws Exception {
        return (DetectLivingFaceRequest) TeaModel.build(map, new DetectLivingFaceRequest());
    }

    public List<DetectLivingFaceRequestTasks> getTasks() {
        return this.tasks;
    }

    public DetectLivingFaceRequest setTasks(List<DetectLivingFaceRequestTasks> list) {
        this.tasks = list;
        return this;
    }
}
