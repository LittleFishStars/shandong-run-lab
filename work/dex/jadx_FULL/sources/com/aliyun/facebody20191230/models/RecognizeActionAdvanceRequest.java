package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeActionAdvanceRequest extends TeaModel {

    @NameInMap("URLList")
    public List<RecognizeActionAdvanceRequestURLList> URLList;

    @NameInMap("Type")
    public Integer type;

    @NameInMap("VideoData")
    public String videoData;

    @NameInMap("VideoUrl")
    public InputStream videoUrlObject;

    public static class RecognizeActionAdvanceRequestURLList extends TeaModel {

        @NameInMap("URL")
        public InputStream URLObject;

        @NameInMap("imageData")
        public String imageData;

        public static RecognizeActionAdvanceRequestURLList build(Map<String, ?> map) throws Exception {
            return (RecognizeActionAdvanceRequestURLList) TeaModel.build(map, new RecognizeActionAdvanceRequestURLList());
        }

        public String getImageData() {
            return this.imageData;
        }

        public InputStream getURLObject() {
            return this.URLObject;
        }

        public RecognizeActionAdvanceRequestURLList setImageData(String str) {
            this.imageData = str;
            return this;
        }

        public RecognizeActionAdvanceRequestURLList setURLObject(InputStream inputStream) {
            this.URLObject = inputStream;
            return this;
        }
    }

    public static RecognizeActionAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (RecognizeActionAdvanceRequest) TeaModel.build(map, new RecognizeActionAdvanceRequest());
    }

    public Integer getType() {
        return this.type;
    }

    public List<RecognizeActionAdvanceRequestURLList> getURLList() {
        return this.URLList;
    }

    public String getVideoData() {
        return this.videoData;
    }

    public InputStream getVideoUrlObject() {
        return this.videoUrlObject;
    }

    public RecognizeActionAdvanceRequest setType(Integer num) {
        this.type = num;
        return this;
    }

    public RecognizeActionAdvanceRequest setURLList(List<RecognizeActionAdvanceRequestURLList> list) {
        this.URLList = list;
        return this;
    }

    public RecognizeActionAdvanceRequest setVideoData(String str) {
        this.videoData = str;
        return this;
    }

    public RecognizeActionAdvanceRequest setVideoUrlObject(InputStream inputStream) {
        this.videoUrlObject = inputStream;
        return this;
    }
}
