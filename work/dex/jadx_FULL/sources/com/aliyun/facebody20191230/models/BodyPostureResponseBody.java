package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BodyPostureResponseBody extends TeaModel {

    @NameInMap("Data")
    public BodyPostureResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class BodyPostureResponseBodyData extends TeaModel {

        @NameInMap("MetaObject")
        public BodyPostureResponseBodyDataMetaObject metaObject;

        @NameInMap("Outputs")
        public List<BodyPostureResponseBodyDataOutputs> outputs;

        public static BodyPostureResponseBodyData build(Map<String, ?> map) throws Exception {
            return (BodyPostureResponseBodyData) TeaModel.build(map, new BodyPostureResponseBodyData());
        }

        public BodyPostureResponseBodyDataMetaObject getMetaObject() {
            return this.metaObject;
        }

        public List<BodyPostureResponseBodyDataOutputs> getOutputs() {
            return this.outputs;
        }

        public BodyPostureResponseBodyData setMetaObject(BodyPostureResponseBodyDataMetaObject bodyPostureResponseBodyDataMetaObject) {
            this.metaObject = bodyPostureResponseBodyDataMetaObject;
            return this;
        }

        public BodyPostureResponseBodyData setOutputs(List<BodyPostureResponseBodyDataOutputs> list) {
            this.outputs = list;
            return this;
        }
    }

    public static class BodyPostureResponseBodyDataMetaObject extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Integer height;

        @NameInMap("Width")
        public Integer width;

        public static BodyPostureResponseBodyDataMetaObject build(Map<String, ?> map) throws Exception {
            return (BodyPostureResponseBodyDataMetaObject) TeaModel.build(map, new BodyPostureResponseBodyDataMetaObject());
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public BodyPostureResponseBodyDataMetaObject setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public BodyPostureResponseBodyDataMetaObject setWidth(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static class BodyPostureResponseBodyDataOutputs extends TeaModel {

        @NameInMap("HumanCount")
        public Integer humanCount;

        @NameInMap("Results")
        public List<BodyPostureResponseBodyDataOutputsResults> results;

        public static BodyPostureResponseBodyDataOutputs build(Map<String, ?> map) throws Exception {
            return (BodyPostureResponseBodyDataOutputs) TeaModel.build(map, new BodyPostureResponseBodyDataOutputs());
        }

        public Integer getHumanCount() {
            return this.humanCount;
        }

        public List<BodyPostureResponseBodyDataOutputsResults> getResults() {
            return this.results;
        }

        public BodyPostureResponseBodyDataOutputs setHumanCount(Integer num) {
            this.humanCount = num;
            return this;
        }

        public BodyPostureResponseBodyDataOutputs setResults(List<BodyPostureResponseBodyDataOutputsResults> list) {
            this.results = list;
            return this;
        }
    }

    public static class BodyPostureResponseBodyDataOutputsResults extends TeaModel {

        @NameInMap("Bodies")
        public List<BodyPostureResponseBodyDataOutputsResultsBodies> bodies;

        public static BodyPostureResponseBodyDataOutputsResults build(Map<String, ?> map) throws Exception {
            return (BodyPostureResponseBodyDataOutputsResults) TeaModel.build(map, new BodyPostureResponseBodyDataOutputsResults());
        }

        public List<BodyPostureResponseBodyDataOutputsResultsBodies> getBodies() {
            return this.bodies;
        }

        public BodyPostureResponseBodyDataOutputsResults setBodies(List<BodyPostureResponseBodyDataOutputsResultsBodies> list) {
            this.bodies = list;
            return this;
        }
    }

    public static class BodyPostureResponseBodyDataOutputsResultsBodies extends TeaModel {

        @NameInMap("Confident")
        public Float confident;

        @NameInMap("Label")
        public String label;

        @NameInMap("Positions")
        public List<BodyPostureResponseBodyDataOutputsResultsBodiesPositions> positions;

        public static BodyPostureResponseBodyDataOutputsResultsBodies build(Map<String, ?> map) throws Exception {
            return (BodyPostureResponseBodyDataOutputsResultsBodies) TeaModel.build(map, new BodyPostureResponseBodyDataOutputsResultsBodies());
        }

        public Float getConfident() {
            return this.confident;
        }

        public String getLabel() {
            return this.label;
        }

        public List<BodyPostureResponseBodyDataOutputsResultsBodiesPositions> getPositions() {
            return this.positions;
        }

        public BodyPostureResponseBodyDataOutputsResultsBodies setConfident(Float f) {
            this.confident = f;
            return this;
        }

        public BodyPostureResponseBodyDataOutputsResultsBodies setLabel(String str) {
            this.label = str;
            return this;
        }

        public BodyPostureResponseBodyDataOutputsResultsBodies setPositions(List<BodyPostureResponseBodyDataOutputsResultsBodiesPositions> list) {
            this.positions = list;
            return this;
        }
    }

    public static class BodyPostureResponseBodyDataOutputsResultsBodiesPositions extends TeaModel {

        @NameInMap("Points")
        public List<Float> points;

        public static BodyPostureResponseBodyDataOutputsResultsBodiesPositions build(Map<String, ?> map) throws Exception {
            return (BodyPostureResponseBodyDataOutputsResultsBodiesPositions) TeaModel.build(map, new BodyPostureResponseBodyDataOutputsResultsBodiesPositions());
        }

        public List<Float> getPoints() {
            return this.points;
        }

        public BodyPostureResponseBodyDataOutputsResultsBodiesPositions setPoints(List<Float> list) {
            this.points = list;
            return this;
        }
    }

    public static BodyPostureResponseBody build(Map<String, ?> map) throws Exception {
        return (BodyPostureResponseBody) TeaModel.build(map, new BodyPostureResponseBody());
    }

    public BodyPostureResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public BodyPostureResponseBody setData(BodyPostureResponseBodyData bodyPostureResponseBodyData) {
        this.data = bodyPostureResponseBodyData;
        return this;
    }

    public BodyPostureResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
