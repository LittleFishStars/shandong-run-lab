package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectInfraredLivingFaceAdvanceRequest extends TeaModel {

    @NameInMap("Tasks")
    public List<DetectInfraredLivingFaceAdvanceRequestTasks> tasks;

    public static class DetectInfraredLivingFaceAdvanceRequestTasks extends TeaModel {

        @NameInMap("ImageURL")
        public InputStream imageURLObject;

        public static DetectInfraredLivingFaceAdvanceRequestTasks build(Map<String, ?> map) throws Exception {
            return (DetectInfraredLivingFaceAdvanceRequestTasks) TeaModel.build(map, new DetectInfraredLivingFaceAdvanceRequestTasks());
        }

        public InputStream getImageURLObject() {
            return this.imageURLObject;
        }

        public DetectInfraredLivingFaceAdvanceRequestTasks setImageURLObject(InputStream inputStream) {
            this.imageURLObject = inputStream;
            return this;
        }
    }

    public static DetectInfraredLivingFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DetectInfraredLivingFaceAdvanceRequest) TeaModel.build(map, new DetectInfraredLivingFaceAdvanceRequest());
    }

    public List<DetectInfraredLivingFaceAdvanceRequestTasks> getTasks() {
        return this.tasks;
    }

    public DetectInfraredLivingFaceAdvanceRequest setTasks(List<DetectInfraredLivingFaceAdvanceRequestTasks> list) {
        this.tasks = list;
        return this;
    }
}
