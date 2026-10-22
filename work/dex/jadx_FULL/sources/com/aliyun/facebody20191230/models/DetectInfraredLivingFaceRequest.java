package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectInfraredLivingFaceRequest extends TeaModel {

    @NameInMap("Tasks")
    public List<DetectInfraredLivingFaceRequestTasks> tasks;

    public static class DetectInfraredLivingFaceRequestTasks extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static DetectInfraredLivingFaceRequestTasks build(Map<String, ?> map) throws Exception {
            return (DetectInfraredLivingFaceRequestTasks) TeaModel.build(map, new DetectInfraredLivingFaceRequestTasks());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public DetectInfraredLivingFaceRequestTasks setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static DetectInfraredLivingFaceRequest build(Map<String, ?> map) throws Exception {
        return (DetectInfraredLivingFaceRequest) TeaModel.build(map, new DetectInfraredLivingFaceRequest());
    }

    public List<DetectInfraredLivingFaceRequestTasks> getTasks() {
        return this.tasks;
    }

    public DetectInfraredLivingFaceRequest setTasks(List<DetectInfraredLivingFaceRequestTasks> list) {
        this.tasks = list;
        return this;
    }
}
