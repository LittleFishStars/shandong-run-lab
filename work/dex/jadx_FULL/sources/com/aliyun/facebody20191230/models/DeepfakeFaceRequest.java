package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeepfakeFaceRequest extends TeaModel {

    @NameInMap("Tasks")
    public List<DeepfakeFaceRequestTasks> tasks;

    public static class DeepfakeFaceRequestTasks extends TeaModel {

        @NameInMap("ImageData")
        public String imageData;

        @NameInMap("ImageURL")
        public String imageURL;

        public static DeepfakeFaceRequestTasks build(Map<String, ?> map) throws Exception {
            return (DeepfakeFaceRequestTasks) TeaModel.build(map, new DeepfakeFaceRequestTasks());
        }

        public String getImageData() {
            return this.imageData;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public DeepfakeFaceRequestTasks setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public DeepfakeFaceRequestTasks setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static DeepfakeFaceRequest build(Map<String, ?> map) throws Exception {
        return (DeepfakeFaceRequest) TeaModel.build(map, new DeepfakeFaceRequest());
    }

    public List<DeepfakeFaceRequestTasks> getTasks() {
        return this.tasks;
    }

    public DeepfakeFaceRequest setTasks(List<DeepfakeFaceRequestTasks> list) {
        this.tasks = list;
        return this;
    }
}
