package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeepfakeFaceAdvanceRequest extends TeaModel {

    @NameInMap("Tasks")
    public List<DeepfakeFaceAdvanceRequestTasks> tasks;

    public static class DeepfakeFaceAdvanceRequestTasks extends TeaModel {

        @NameInMap("ImageData")
        public String imageData;

        @NameInMap("ImageURL")
        public InputStream imageURLObject;

        public static DeepfakeFaceAdvanceRequestTasks build(Map<String, ?> map) throws Exception {
            return (DeepfakeFaceAdvanceRequestTasks) TeaModel.build(map, new DeepfakeFaceAdvanceRequestTasks());
        }

        public String getImageData() {
            return this.imageData;
        }

        public InputStream getImageURLObject() {
            return this.imageURLObject;
        }

        public DeepfakeFaceAdvanceRequestTasks setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public DeepfakeFaceAdvanceRequestTasks setImageURLObject(InputStream inputStream) {
            this.imageURLObject = inputStream;
            return this;
        }
    }

    public static DeepfakeFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DeepfakeFaceAdvanceRequest) TeaModel.build(map, new DeepfakeFaceAdvanceRequest());
    }

    public List<DeepfakeFaceAdvanceRequestTasks> getTasks() {
        return this.tasks;
    }

    public DeepfakeFaceAdvanceRequest setTasks(List<DeepfakeFaceAdvanceRequestTasks> list) {
        this.tasks = list;
        return this;
    }
}
