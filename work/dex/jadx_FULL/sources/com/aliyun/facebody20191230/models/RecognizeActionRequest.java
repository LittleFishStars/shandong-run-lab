package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeActionRequest extends TeaModel {

    @NameInMap("URLList")
    public List<RecognizeActionRequestURLList> URLList;

    @NameInMap("Type")
    public Integer type;

    @NameInMap("VideoData")
    public String videoData;

    @NameInMap("VideoUrl")
    public String videoUrl;

    public static class RecognizeActionRequestURLList extends TeaModel {

        @NameInMap("URL")
        public String URL;

        @NameInMap("imageData")
        public String imageData;

        public static RecognizeActionRequestURLList build(Map<String, ?> map) throws Exception {
            return (RecognizeActionRequestURLList) TeaModel.build(map, new RecognizeActionRequestURLList());
        }

        public String getImageData() {
            return this.imageData;
        }

        public String getURL() {
            return this.URL;
        }

        public RecognizeActionRequestURLList setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public RecognizeActionRequestURLList setURL(String str) {
            this.URL = str;
            return this;
        }
    }

    public static RecognizeActionRequest build(Map<String, ?> map) throws Exception {
        return (RecognizeActionRequest) TeaModel.build(map, new RecognizeActionRequest());
    }

    public Integer getType() {
        return this.type;
    }

    public List<RecognizeActionRequestURLList> getURLList() {
        return this.URLList;
    }

    public String getVideoData() {
        return this.videoData;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public RecognizeActionRequest setType(Integer num) {
        this.type = num;
        return this;
    }

    public RecognizeActionRequest setURLList(List<RecognizeActionRequestURLList> list) {
        this.URLList = list;
        return this;
    }

    public RecognizeActionRequest setVideoData(String str) {
        this.videoData = str;
        return this;
    }

    public RecognizeActionRequest setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }
}
