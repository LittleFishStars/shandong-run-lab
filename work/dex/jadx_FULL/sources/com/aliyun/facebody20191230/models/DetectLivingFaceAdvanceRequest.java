package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectLivingFaceAdvanceRequest extends TeaModel {

    @NameInMap("Tasks")
    public List<DetectLivingFaceAdvanceRequestTasks> tasks;

    public static class DetectLivingFaceAdvanceRequestTasks extends TeaModel {

        @NameInMap("ImageData")
        public String imageData;

        @NameInMap("ImageURL")
        public InputStream imageURLObject;

        public static DetectLivingFaceAdvanceRequestTasks build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceAdvanceRequestTasks) TeaModel.build(map, new DetectLivingFaceAdvanceRequestTasks());
        }

        public String getImageData() {
            return this.imageData;
        }

        public InputStream getImageURLObject() {
            return this.imageURLObject;
        }

        public DetectLivingFaceAdvanceRequestTasks setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public DetectLivingFaceAdvanceRequestTasks setImageURLObject(InputStream inputStream) {
            this.imageURLObject = inputStream;
            return this;
        }
    }

    public static DetectLivingFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DetectLivingFaceAdvanceRequest) TeaModel.build(map, new DetectLivingFaceAdvanceRequest());
    }

    public List<DetectLivingFaceAdvanceRequestTasks> getTasks() {
        return this.tasks;
    }

    public DetectLivingFaceAdvanceRequest setTasks(List<DetectLivingFaceAdvanceRequestTasks> list) {
        this.tasks = list;
        return this;
    }
}
