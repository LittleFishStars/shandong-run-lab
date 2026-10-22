package com.baidu.entity.pb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class WalkPlan extends MessageMicro {
    public static final int APPEND_ROUTEINF_LIST_FIELD_NUMBER = 8;
    public static final int AR_GUIDE_FIELD_NUMBER = 7;
    public static final int CURRENT_CITY_FIELD_NUMBER = 4;
    public static final int INDOOR_NAVIS_FIELD_NUMBER = 5;
    public static final int OPTION_FIELD_NUMBER = 3;
    public static final int ROUTES_FIELD_NUMBER = 1;
    public static final int SESSION_FIELD_NUMBER = 9;
    public static final int TAXI_FIELD_NUMBER = 2;
    public static final int VEHICLE_FIELD_NUMBER = 10;
    public static final int YAW_STATUS_FIELD_NUMBER = 6;
    private boolean hasAppendRouteinfList;
    private boolean hasCurrentCity;
    private boolean hasOption;
    private boolean hasSession;
    private boolean hasTaxi;
    private boolean hasVehicle;
    private boolean hasYawStatus;
    private Taxi taxi_ = null;
    private List<Routes> routes_ = Collections.emptyList();
    private Option option_ = null;
    private CurrentCity currentCity_ = null;
    private List<IndoorNavi> indoorNavis_ = Collections.emptyList();
    private int yawStatus_ = 0;
    private List<ARGuide> arGuide_ = Collections.emptyList();
    private AppendRouteInf appendRouteinfList_ = null;
    private Session session_ = null;
    private int vehicle_ = 0;
    private int cachedSize = -1;

    public static final class ARGuide extends MessageMicro {
        public static final int GUIDE_V1_FIELD_NUMBER = 4;
        public static final int LEG_IDX_FIELD_NUMBER = 3;
        public static final int ROUTE_IDX_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 1;
        private boolean hasGuideV1;
        private boolean hasLegIdx;
        private boolean hasRouteIdx;
        private boolean hasVersion;
        private int version_ = 0;
        private int routeIdx_ = 0;
        private int legIdx_ = 0;
        private GuideV1 guideV1_ = null;
        private int cachedSize = -1;

        public static final class GuideV1 extends MessageMicro {
            public static final int BASE_INFO_FIELD_NUMBER = 1;
            private List<BaseInfo> baseInfo_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class BaseInfo extends MessageMicro {
                public static final int MODEL_TYPE_FIELD_NUMBER = 1;
                public static final int SP_IDX_FIELD_NUMBER = 3;
                public static final int STEP_IDX_FIELD_NUMBER = 2;
                private boolean hasModelType;
                private boolean hasSpIdx;
                private boolean hasStepIdx;
                private int modelType_ = 0;
                private int stepIdx_ = 0;
                private int spIdx_ = 0;
                private int cachedSize = -1;

                public static BaseInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new BaseInfo().mergeFrom(codedInputStreamMicro);
                }

                public static BaseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (BaseInfo) new BaseInfo().mergeFrom(bArr);
                }

                public final BaseInfo clear() {
                    clearModelType();
                    clearStepIdx();
                    clearSpIdx();
                    this.cachedSize = -1;
                    return this;
                }

                public BaseInfo clearModelType() {
                    this.hasModelType = false;
                    this.modelType_ = 0;
                    return this;
                }

                public BaseInfo clearSpIdx() {
                    this.hasSpIdx = false;
                    this.spIdx_ = 0;
                    return this;
                }

                public BaseInfo clearStepIdx() {
                    this.hasStepIdx = false;
                    this.stepIdx_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getModelType() {
                    return this.modelType_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeInt32Size = hasModelType() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getModelType()) : 0;
                    if (hasStepIdx()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getStepIdx());
                    }
                    if (hasSpIdx()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getSpIdx());
                    }
                    this.cachedSize = iComputeInt32Size;
                    return iComputeInt32Size;
                }

                public int getSpIdx() {
                    return this.spIdx_;
                }

                public int getStepIdx() {
                    return this.stepIdx_;
                }

                public boolean hasModelType() {
                    return this.hasModelType;
                }

                public boolean hasSpIdx() {
                    return this.hasSpIdx;
                }

                public boolean hasStepIdx() {
                    return this.hasStepIdx;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public BaseInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 8) {
                            setModelType(codedInputStreamMicro.readInt32());
                        } else if (tag == 16) {
                            setStepIdx(codedInputStreamMicro.readInt32());
                        } else if (tag == 24) {
                            setSpIdx(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public BaseInfo setModelType(int i) {
                    this.hasModelType = true;
                    this.modelType_ = i;
                    return this;
                }

                public BaseInfo setSpIdx(int i) {
                    this.hasSpIdx = true;
                    this.spIdx_ = i;
                    return this;
                }

                public BaseInfo setStepIdx(int i) {
                    this.hasStepIdx = true;
                    this.stepIdx_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasModelType()) {
                        codedOutputStreamMicro.writeInt32(1, getModelType());
                    }
                    if (hasStepIdx()) {
                        codedOutputStreamMicro.writeInt32(2, getStepIdx());
                    }
                    if (hasSpIdx()) {
                        codedOutputStreamMicro.writeInt32(3, getSpIdx());
                    }
                }
            }

            public static GuideV1 parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new GuideV1().mergeFrom(codedInputStreamMicro);
            }

            public static GuideV1 parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (GuideV1) new GuideV1().mergeFrom(bArr);
            }

            public GuideV1 addBaseInfo(BaseInfo baseInfo) {
                if (baseInfo == null) {
                    return this;
                }
                if (this.baseInfo_.isEmpty()) {
                    this.baseInfo_ = new ArrayList();
                }
                this.baseInfo_.add(baseInfo);
                return this;
            }

            public final GuideV1 clear() {
                clearBaseInfo();
                this.cachedSize = -1;
                return this;
            }

            public GuideV1 clearBaseInfo() {
                this.baseInfo_ = Collections.emptyList();
                return this;
            }

            public BaseInfo getBaseInfo(int i) {
                return this.baseInfo_.get(i);
            }

            public int getBaseInfoCount() {
                return this.baseInfo_.size();
            }

            public List<BaseInfo> getBaseInfoList() {
                return this.baseInfo_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<BaseInfo> it = getBaseInfoList().iterator();
                int iComputeMessageSize = 0;
                while (it.hasNext()) {
                    iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                }
                this.cachedSize = iComputeMessageSize;
                return iComputeMessageSize;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public GuideV1 mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        BaseInfo baseInfo = new BaseInfo();
                        codedInputStreamMicro.readMessage(baseInfo);
                        addBaseInfo(baseInfo);
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public GuideV1 setBaseInfo(int i, BaseInfo baseInfo) {
                if (baseInfo == null) {
                    return this;
                }
                this.baseInfo_.set(i, baseInfo);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<BaseInfo> it = getBaseInfoList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(1, it.next());
                }
            }
        }

        public static ARGuide parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ARGuide().mergeFrom(codedInputStreamMicro);
        }

        public static ARGuide parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ARGuide) new ARGuide().mergeFrom(bArr);
        }

        public final ARGuide clear() {
            clearVersion();
            clearRouteIdx();
            clearLegIdx();
            clearGuideV1();
            this.cachedSize = -1;
            return this;
        }

        public ARGuide clearGuideV1() {
            this.hasGuideV1 = false;
            this.guideV1_ = null;
            return this;
        }

        public ARGuide clearLegIdx() {
            this.hasLegIdx = false;
            this.legIdx_ = 0;
            return this;
        }

        public ARGuide clearRouteIdx() {
            this.hasRouteIdx = false;
            this.routeIdx_ = 0;
            return this;
        }

        public ARGuide clearVersion() {
            this.hasVersion = false;
            this.version_ = 0;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public GuideV1 getGuideV1() {
            return this.guideV1_;
        }

        public int getLegIdx() {
            return this.legIdx_;
        }

        public int getRouteIdx() {
            return this.routeIdx_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int iComputeInt32Size = hasVersion() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getVersion()) : 0;
            if (hasRouteIdx()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getRouteIdx());
            }
            if (hasLegIdx()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getLegIdx());
            }
            if (hasGuideV1()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, getGuideV1());
            }
            this.cachedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean hasGuideV1() {
            return this.hasGuideV1;
        }

        public boolean hasLegIdx() {
            return this.hasLegIdx;
        }

        public boolean hasRouteIdx() {
            return this.hasRouteIdx;
        }

        public boolean hasVersion() {
            return this.hasVersion;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public ARGuide mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int tag = codedInputStreamMicro.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    setVersion(codedInputStreamMicro.readInt32());
                } else if (tag == 16) {
                    setRouteIdx(codedInputStreamMicro.readInt32());
                } else if (tag == 24) {
                    setLegIdx(codedInputStreamMicro.readInt32());
                } else if (tag == 34) {
                    GuideV1 guideV1 = new GuideV1();
                    codedInputStreamMicro.readMessage(guideV1);
                    setGuideV1(guideV1);
                } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                    return this;
                }
            }
        }

        public ARGuide setGuideV1(GuideV1 guideV1) {
            if (guideV1 == null) {
                return clearGuideV1();
            }
            this.hasGuideV1 = true;
            this.guideV1_ = guideV1;
            return this;
        }

        public ARGuide setLegIdx(int i) {
            this.hasLegIdx = true;
            this.legIdx_ = i;
            return this;
        }

        public ARGuide setRouteIdx(int i) {
            this.hasRouteIdx = true;
            this.routeIdx_ = i;
            return this;
        }

        public ARGuide setVersion(int i) {
            this.hasVersion = true;
            this.version_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasVersion()) {
                codedOutputStreamMicro.writeInt32(1, getVersion());
            }
            if (hasRouteIdx()) {
                codedOutputStreamMicro.writeInt32(2, getRouteIdx());
            }
            if (hasLegIdx()) {
                codedOutputStreamMicro.writeInt32(3, getLegIdx());
            }
            if (hasGuideV1()) {
                codedOutputStreamMicro.writeMessage(4, getGuideV1());
            }
        }
    }

    public static final class AppendRouteInf extends MessageMicro {
        public static final int ROUTEINF_LIST_FIELD_NUMBER = 1;
        private List<RouteInf> routeinfList_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class RouteInf extends MessageMicro {
            public static final int FIRST_SCRN_INF_LIST_FIELD_NUMBER = 2;
            public static final int POSITIVE_FAC_NUM_FIELD_NUMBER = 1;
            public static final int SECOND_SCRN_INF_LIST_FIELD_NUMBER = 3;
            private boolean hasPositiveFacNum;
            private int positiveFacNum_ = 0;
            private List<FirstScreenInf> firstScrnInfList_ = Collections.emptyList();
            private List<SecondScreenInf> secondScrnInfList_ = Collections.emptyList();
            private int cachedSize = -1;

            public static final class FirstScreenInf extends MessageMicro {
                public static final int IS_HIGHLIGHT_FIELD_NUMBER = 3;
                public static final int TEXT_FIELD_NUMBER = 2;
                public static final int TEXT_NAME_FIELD_NUMBER = 1;
                private boolean hasIsHighlight;
                private boolean hasText;
                private boolean hasTextName;
                private String textName_ = "";
                private String text_ = "";
                private int isHighlight_ = 0;
                private int cachedSize = -1;

                public static FirstScreenInf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new FirstScreenInf().mergeFrom(codedInputStreamMicro);
                }

                public static FirstScreenInf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (FirstScreenInf) new FirstScreenInf().mergeFrom(bArr);
                }

                public final FirstScreenInf clear() {
                    clearTextName();
                    clearText();
                    clearIsHighlight();
                    this.cachedSize = -1;
                    return this;
                }

                public FirstScreenInf clearIsHighlight() {
                    this.hasIsHighlight = false;
                    this.isHighlight_ = 0;
                    return this;
                }

                public FirstScreenInf clearText() {
                    this.hasText = false;
                    this.text_ = "";
                    return this;
                }

                public FirstScreenInf clearTextName() {
                    this.hasTextName = false;
                    this.textName_ = "";
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIsHighlight() {
                    return this.isHighlight_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeStringSize = hasTextName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getTextName()) : 0;
                    if (hasText()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getText());
                    }
                    if (hasIsHighlight()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getIsHighlight());
                    }
                    this.cachedSize = iComputeStringSize;
                    return iComputeStringSize;
                }

                public String getText() {
                    return this.text_;
                }

                public String getTextName() {
                    return this.textName_;
                }

                public boolean hasIsHighlight() {
                    return this.hasIsHighlight;
                }

                public boolean hasText() {
                    return this.hasText;
                }

                public boolean hasTextName() {
                    return this.hasTextName;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public FirstScreenInf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 10) {
                            setTextName(codedInputStreamMicro.readString());
                        } else if (tag == 18) {
                            setText(codedInputStreamMicro.readString());
                        } else if (tag == 24) {
                            setIsHighlight(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public FirstScreenInf setIsHighlight(int i) {
                    this.hasIsHighlight = true;
                    this.isHighlight_ = i;
                    return this;
                }

                public FirstScreenInf setText(String str) {
                    this.hasText = true;
                    this.text_ = str;
                    return this;
                }

                public FirstScreenInf setTextName(String str) {
                    this.hasTextName = true;
                    this.textName_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasTextName()) {
                        codedOutputStreamMicro.writeString(1, getTextName());
                    }
                    if (hasText()) {
                        codedOutputStreamMicro.writeString(2, getText());
                    }
                    if (hasIsHighlight()) {
                        codedOutputStreamMicro.writeInt32(3, getIsHighlight());
                    }
                }
            }

            public static final class SecondScreenInf extends MessageMicro {
                public static final int GROUPS_DETAIL_INF_FIELD_NUMBER = 2;
                public static final int GROUP_NAME_FIELD_NUMBER = 1;
                private boolean hasGroupName;
                private String groupName_ = "";
                private List<GroupDetailInf> groupsDetailInf_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class GroupDetailInf extends MessageMicro {
                    public static final int IS_HIGHLIGHT_FIELD_NUMBER = 3;
                    public static final int TEXT_FIELD_NUMBER = 2;
                    public static final int TEXT_NAME_FIELD_NUMBER = 1;
                    private boolean hasIsHighlight;
                    private boolean hasText;
                    private boolean hasTextName;
                    private String textName_ = "";
                    private String text_ = "";
                    private int isHighlight_ = 0;
                    private int cachedSize = -1;

                    public static GroupDetailInf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new GroupDetailInf().mergeFrom(codedInputStreamMicro);
                    }

                    public static GroupDetailInf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (GroupDetailInf) new GroupDetailInf().mergeFrom(bArr);
                    }

                    public final GroupDetailInf clear() {
                        clearTextName();
                        clearText();
                        clearIsHighlight();
                        this.cachedSize = -1;
                        return this;
                    }

                    public GroupDetailInf clearIsHighlight() {
                        this.hasIsHighlight = false;
                        this.isHighlight_ = 0;
                        return this;
                    }

                    public GroupDetailInf clearText() {
                        this.hasText = false;
                        this.text_ = "";
                        return this;
                    }

                    public GroupDetailInf clearTextName() {
                        this.hasTextName = false;
                        this.textName_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getIsHighlight() {
                        return this.isHighlight_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasTextName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getTextName()) : 0;
                        if (hasText()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getText());
                        }
                        if (hasIsHighlight()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getIsHighlight());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public String getText() {
                        return this.text_;
                    }

                    public String getTextName() {
                        return this.textName_;
                    }

                    public boolean hasIsHighlight() {
                        return this.hasIsHighlight;
                    }

                    public boolean hasText() {
                        return this.hasText;
                    }

                    public boolean hasTextName() {
                        return this.hasTextName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public GroupDetailInf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 10) {
                                setTextName(codedInputStreamMicro.readString());
                            } else if (tag == 18) {
                                setText(codedInputStreamMicro.readString());
                            } else if (tag == 24) {
                                setIsHighlight(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public GroupDetailInf setIsHighlight(int i) {
                        this.hasIsHighlight = true;
                        this.isHighlight_ = i;
                        return this;
                    }

                    public GroupDetailInf setText(String str) {
                        this.hasText = true;
                        this.text_ = str;
                        return this;
                    }

                    public GroupDetailInf setTextName(String str) {
                        this.hasTextName = true;
                        this.textName_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasTextName()) {
                            codedOutputStreamMicro.writeString(1, getTextName());
                        }
                        if (hasText()) {
                            codedOutputStreamMicro.writeString(2, getText());
                        }
                        if (hasIsHighlight()) {
                            codedOutputStreamMicro.writeInt32(3, getIsHighlight());
                        }
                    }
                }

                public static SecondScreenInf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new SecondScreenInf().mergeFrom(codedInputStreamMicro);
                }

                public static SecondScreenInf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (SecondScreenInf) new SecondScreenInf().mergeFrom(bArr);
                }

                public SecondScreenInf addGroupsDetailInf(GroupDetailInf groupDetailInf) {
                    if (groupDetailInf == null) {
                        return this;
                    }
                    if (this.groupsDetailInf_.isEmpty()) {
                        this.groupsDetailInf_ = new ArrayList();
                    }
                    this.groupsDetailInf_.add(groupDetailInf);
                    return this;
                }

                public final SecondScreenInf clear() {
                    clearGroupName();
                    clearGroupsDetailInf();
                    this.cachedSize = -1;
                    return this;
                }

                public SecondScreenInf clearGroupName() {
                    this.hasGroupName = false;
                    this.groupName_ = "";
                    return this;
                }

                public SecondScreenInf clearGroupsDetailInf() {
                    this.groupsDetailInf_ = Collections.emptyList();
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getGroupName() {
                    return this.groupName_;
                }

                public GroupDetailInf getGroupsDetailInf(int i) {
                    return this.groupsDetailInf_.get(i);
                }

                public int getGroupsDetailInfCount() {
                    return this.groupsDetailInf_.size();
                }

                public List<GroupDetailInf> getGroupsDetailInfList() {
                    return this.groupsDetailInf_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeStringSize = hasGroupName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getGroupName()) : 0;
                    Iterator<GroupDetailInf> it = getGroupsDetailInfList().iterator();
                    while (it.hasNext()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeMessageSize(2, it.next());
                    }
                    this.cachedSize = iComputeStringSize;
                    return iComputeStringSize;
                }

                public boolean hasGroupName() {
                    return this.hasGroupName;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public SecondScreenInf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 10) {
                            setGroupName(codedInputStreamMicro.readString());
                        } else if (tag == 18) {
                            GroupDetailInf groupDetailInf = new GroupDetailInf();
                            codedInputStreamMicro.readMessage(groupDetailInf);
                            addGroupsDetailInf(groupDetailInf);
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public SecondScreenInf setGroupName(String str) {
                    this.hasGroupName = true;
                    this.groupName_ = str;
                    return this;
                }

                public SecondScreenInf setGroupsDetailInf(int i, GroupDetailInf groupDetailInf) {
                    if (groupDetailInf == null) {
                        return this;
                    }
                    this.groupsDetailInf_.set(i, groupDetailInf);
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasGroupName()) {
                        codedOutputStreamMicro.writeString(1, getGroupName());
                    }
                    Iterator<GroupDetailInf> it = getGroupsDetailInfList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(2, it.next());
                    }
                }
            }

            public static RouteInf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new RouteInf().mergeFrom(codedInputStreamMicro);
            }

            public static RouteInf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (RouteInf) new RouteInf().mergeFrom(bArr);
            }

            public RouteInf addFirstScrnInfList(FirstScreenInf firstScreenInf) {
                if (firstScreenInf == null) {
                    return this;
                }
                if (this.firstScrnInfList_.isEmpty()) {
                    this.firstScrnInfList_ = new ArrayList();
                }
                this.firstScrnInfList_.add(firstScreenInf);
                return this;
            }

            public RouteInf addSecondScrnInfList(SecondScreenInf secondScreenInf) {
                if (secondScreenInf == null) {
                    return this;
                }
                if (this.secondScrnInfList_.isEmpty()) {
                    this.secondScrnInfList_ = new ArrayList();
                }
                this.secondScrnInfList_.add(secondScreenInf);
                return this;
            }

            public final RouteInf clear() {
                clearPositiveFacNum();
                clearFirstScrnInfList();
                clearSecondScrnInfList();
                this.cachedSize = -1;
                return this;
            }

            public RouteInf clearFirstScrnInfList() {
                this.firstScrnInfList_ = Collections.emptyList();
                return this;
            }

            public RouteInf clearPositiveFacNum() {
                this.hasPositiveFacNum = false;
                this.positiveFacNum_ = 0;
                return this;
            }

            public RouteInf clearSecondScrnInfList() {
                this.secondScrnInfList_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public FirstScreenInf getFirstScrnInfList(int i) {
                return this.firstScrnInfList_.get(i);
            }

            public int getFirstScrnInfListCount() {
                return this.firstScrnInfList_.size();
            }

            public List<FirstScreenInf> getFirstScrnInfListList() {
                return this.firstScrnInfList_;
            }

            public int getPositiveFacNum() {
                return this.positiveFacNum_;
            }

            public SecondScreenInf getSecondScrnInfList(int i) {
                return this.secondScrnInfList_.get(i);
            }

            public int getSecondScrnInfListCount() {
                return this.secondScrnInfList_.size();
            }

            public List<SecondScreenInf> getSecondScrnInfListList() {
                return this.secondScrnInfList_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasPositiveFacNum() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getPositiveFacNum()) : 0;
                Iterator<FirstScreenInf> it = getFirstScrnInfListList().iterator();
                while (it.hasNext()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(2, it.next());
                }
                Iterator<SecondScreenInf> it2 = getSecondScrnInfListList().iterator();
                while (it2.hasNext()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, it2.next());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public boolean hasPositiveFacNum() {
                return this.hasPositiveFacNum;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public RouteInf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setPositiveFacNum(codedInputStreamMicro.readInt32());
                    } else if (tag == 18) {
                        FirstScreenInf firstScreenInf = new FirstScreenInf();
                        codedInputStreamMicro.readMessage(firstScreenInf);
                        addFirstScrnInfList(firstScreenInf);
                    } else if (tag == 26) {
                        SecondScreenInf secondScreenInf = new SecondScreenInf();
                        codedInputStreamMicro.readMessage(secondScreenInf);
                        addSecondScrnInfList(secondScreenInf);
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public RouteInf setFirstScrnInfList(int i, FirstScreenInf firstScreenInf) {
                if (firstScreenInf == null) {
                    return this;
                }
                this.firstScrnInfList_.set(i, firstScreenInf);
                return this;
            }

            public RouteInf setPositiveFacNum(int i) {
                this.hasPositiveFacNum = true;
                this.positiveFacNum_ = i;
                return this;
            }

            public RouteInf setSecondScrnInfList(int i, SecondScreenInf secondScreenInf) {
                if (secondScreenInf == null) {
                    return this;
                }
                this.secondScrnInfList_.set(i, secondScreenInf);
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPositiveFacNum()) {
                    codedOutputStreamMicro.writeInt32(1, getPositiveFacNum());
                }
                Iterator<FirstScreenInf> it = getFirstScrnInfListList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(2, it.next());
                }
                Iterator<SecondScreenInf> it2 = getSecondScrnInfListList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeMessage(3, it2.next());
                }
            }
        }

        public static AppendRouteInf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AppendRouteInf().mergeFrom(codedInputStreamMicro);
        }

        public static AppendRouteInf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AppendRouteInf) new AppendRouteInf().mergeFrom(bArr);
        }

        public AppendRouteInf addRouteinfList(RouteInf routeInf) {
            if (routeInf == null) {
                return this;
            }
            if (this.routeinfList_.isEmpty()) {
                this.routeinfList_ = new ArrayList();
            }
            this.routeinfList_.add(routeInf);
            return this;
        }

        public final AppendRouteInf clear() {
            clearRouteinfList();
            this.cachedSize = -1;
            return this;
        }

        public AppendRouteInf clearRouteinfList() {
            this.routeinfList_ = Collections.emptyList();
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public RouteInf getRouteinfList(int i) {
            return this.routeinfList_.get(i);
        }

        public int getRouteinfListCount() {
            return this.routeinfList_.size();
        }

        public List<RouteInf> getRouteinfListList() {
            return this.routeinfList_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            Iterator<RouteInf> it = getRouteinfListList().iterator();
            int iComputeMessageSize = 0;
            while (it.hasNext()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(1, it.next());
            }
            this.cachedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public AppendRouteInf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int tag = codedInputStreamMicro.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    RouteInf routeInf = new RouteInf();
                    codedInputStreamMicro.readMessage(routeInf);
                    addRouteinfList(routeInf);
                } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                    return this;
                }
            }
        }

        public AppendRouteInf setRouteinfList(int i, RouteInf routeInf) {
            if (routeInf == null) {
                return this;
            }
            this.routeinfList_.set(i, routeInf);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            Iterator<RouteInf> it = getRouteinfListList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(1, it.next());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int AVOID_JAM_FIELD_NUMBER = 6;
        public static final int DIS_SY_FIELD_NUMBER = 9;
        public static final int END_CITY_FIELD_NUMBER = 8;
        public static final int END_FIELD_NUMBER = 5;
        public static final int EXPTIME_FIELD_NUMBER = 2;
        public static final int REQ_TM_FIELD_NUMBER = 10;
        public static final int SESSIONID_FIELD_NUMBER = 12;
        public static final int SPATH_TYPE_FIELD_NUMBER = 11;
        public static final int START_CITY_FIELD_NUMBER = 7;
        public static final int START_FIELD_NUMBER = 4;
        public static final int SY_FIELD_NUMBER = 3;
        public static final int TOTAL_FIELD_NUMBER = 1;
        private boolean hasAvoidJam;
        private boolean hasDisSy;
        private boolean hasExptime;
        private boolean hasReqTm;
        private boolean hasSessionid;
        private boolean hasSpathType;
        private boolean hasStart;
        private boolean hasStartCity;
        private boolean hasSy;
        private boolean hasTotal;
        private int total_ = 0;
        private String exptime_ = "";
        private int sy_ = 0;
        private Start start_ = null;
        private List<End> end_ = Collections.emptyList();
        private int avoidJam_ = 0;
        private StartCity startCity_ = null;
        private List<EndCity> endCity_ = Collections.emptyList();
        private int disSy_ = 0;
        private String reqTm_ = "";
        private int spathType_ = 0;
        private String sessionid_ = "";
        private int cachedSize = -1;

        public static final class End extends MessageMicro {
            public static final int BUILDINGNAME_FIELD_NUMBER = 8;
            public static final int BUILDING_FIELD_NUMBER = 7;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int FLOOR_FIELD_NUMBER = 6;
            public static final int FLOOR_INFO_FIELD_NUMBER = 9;
            public static final int INDOOR_LOC_TECH_FIELD_NUMBER = 10;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int RT_BUS_FIELD_NUMBER = 11;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            private boolean hasBuilding;
            private boolean hasBuildingname;
            private boolean hasBusStop;
            private boolean hasFloor;
            private boolean hasFloorInfo;
            private boolean hasIndoorLocTech;
            private boolean hasPt;
            private boolean hasRtBus;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String wd_ = "";
            private String uid_ = "";
            private boolean busStop_ = false;
            private List<Integer> spt_ = Collections.emptyList();
            private String floor_ = "";
            private String building_ = "";
            private String buildingname_ = "";
            private String floorInfo_ = "";
            private int indoorLocTech_ = 0;
            private int rtBus_ = 0;
            private int cachedSize = -1;

            public static End parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new End().mergeFrom(codedInputStreamMicro);
            }

            public static End parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (End) new End().mergeFrom(bArr);
            }

            public End addSpt(int i) {
                if (this.spt_.isEmpty()) {
                    this.spt_ = new ArrayList();
                }
                this.spt_.add(Integer.valueOf(i));
                return this;
            }

            public final End clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                clearFloor();
                clearBuilding();
                clearBuildingname();
                clearFloorInfo();
                clearIndoorLocTech();
                clearRtBus();
                this.cachedSize = -1;
                return this;
            }

            public End clearBuilding() {
                this.hasBuilding = false;
                this.building_ = "";
                return this;
            }

            public End clearBuildingname() {
                this.hasBuildingname = false;
                this.buildingname_ = "";
                return this;
            }

            public End clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = false;
                return this;
            }

            public End clearFloor() {
                this.hasFloor = false;
                this.floor_ = "";
                return this;
            }

            public End clearFloorInfo() {
                this.hasFloorInfo = false;
                this.floorInfo_ = "";
                return this;
            }

            public End clearIndoorLocTech() {
                this.hasIndoorLocTech = false;
                this.indoorLocTech_ = 0;
                return this;
            }

            public End clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public End clearRtBus() {
                this.hasRtBus = false;
                this.rtBus_ = 0;
                return this;
            }

            public End clearSpt() {
                this.spt_ = Collections.emptyList();
                return this;
            }

            public End clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public End clearWd() {
                this.hasWd = false;
                this.wd_ = "";
                return this;
            }

            public String getBuilding() {
                return this.building_;
            }

            public String getBuildingname() {
                return this.buildingname_;
            }

            public boolean getBusStop() {
                return this.busStop_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getFloor() {
                return this.floor_;
            }

            public String getFloorInfo() {
                return this.floorInfo_;
            }

            public int getIndoorLocTech() {
                return this.indoorLocTech_;
            }

            public String getPt() {
                return this.pt_;
            }

            public int getRtBus() {
                return this.rtBus_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeSInt32SizeNoTag = 0;
                int iComputeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasWd()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                if (hasUid()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                if (hasBusStop()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeBoolSize(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = iComputeStringSize + iComputeSInt32SizeNoTag + (getSptList().size() * 1);
                if (hasFloor()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (hasBuilding()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, getBuilding());
                }
                if (hasBuildingname()) {
                    size += CodedOutputStreamMicro.computeStringSize(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    size += CodedOutputStreamMicro.computeStringSize(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    size += CodedOutputStreamMicro.computeInt32Size(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    size += CodedOutputStreamMicro.computeInt32Size(11, getRtBus());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpt(int i) {
                return this.spt_.get(i).intValue();
            }

            public int getSptCount() {
                return this.spt_.size();
            }

            public List<Integer> getSptList() {
                return this.spt_;
            }

            public String getUid() {
                return this.uid_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasBuilding() {
                return this.hasBuilding;
            }

            public boolean hasBuildingname() {
                return this.hasBuildingname;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasFloor() {
                return this.hasFloor;
            }

            public boolean hasFloorInfo() {
                return this.hasFloorInfo;
            }

            public boolean hasIndoorLocTech() {
                return this.hasIndoorLocTech;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasRtBus() {
                return this.hasRtBus;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public boolean hasWd() {
                return this.hasWd;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public End mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    switch (tag) {
                        case 0:
                            return this;
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            setWd(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            setBusStop(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            setFloor(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setBuilding(codedInputStreamMicro.readString());
                            break;
                        case 66:
                            setBuildingname(codedInputStreamMicro.readString());
                            break;
                        case 74:
                            setFloorInfo(codedInputStreamMicro.readString());
                            break;
                        case 80:
                            setIndoorLocTech(codedInputStreamMicro.readInt32());
                            break;
                        case 88:
                            setRtBus(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                            break;
                            break;
                    }
                }
            }

            public End setBuilding(String str) {
                this.hasBuilding = true;
                this.building_ = str;
                return this;
            }

            public End setBuildingname(String str) {
                this.hasBuildingname = true;
                this.buildingname_ = str;
                return this;
            }

            public End setBusStop(boolean z) {
                this.hasBusStop = true;
                this.busStop_ = z;
                return this;
            }

            public End setFloor(String str) {
                this.hasFloor = true;
                this.floor_ = str;
                return this;
            }

            public End setFloorInfo(String str) {
                this.hasFloorInfo = true;
                this.floorInfo_ = str;
                return this;
            }

            public End setIndoorLocTech(int i) {
                this.hasIndoorLocTech = true;
                this.indoorLocTech_ = i;
                return this;
            }

            public End setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public End setRtBus(int i) {
                this.hasRtBus = true;
                this.rtBus_ = i;
                return this;
            }

            public End setSpt(int i, int i2) {
                this.spt_.set(i, Integer.valueOf(i2));
                return this;
            }

            public End setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            public End setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeBool(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(5, it.next().intValue());
                }
                if (hasFloor()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (hasBuilding()) {
                    codedOutputStreamMicro.writeString(7, getBuilding());
                }
                if (hasBuildingname()) {
                    codedOutputStreamMicro.writeString(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    codedOutputStreamMicro.writeString(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    codedOutputStreamMicro.writeInt32(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    codedOutputStreamMicro.writeInt32(11, getRtBus());
                }
            }
        }

        public static final class EndCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            private boolean hasCname;
            private boolean hasCode;
            private int code_ = 0;
            private String cname_ = "";
            private int cachedSize = -1;

            public static EndCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new EndCity().mergeFrom(codedInputStreamMicro);
            }

            public static EndCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (EndCity) new EndCity().mergeFrom(bArr);
            }

            public final EndCity clear() {
                clearCode();
                clearCname();
                this.cachedSize = -1;
                return this;
            }

            public EndCity clearCname() {
                this.hasCname = false;
                this.cname_ = "";
                return this;
            }

            public EndCity clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCname() {
                return this.cname_;
            }

            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasCode() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasCname()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public boolean hasCname() {
                return this.hasCname;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public EndCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setCode(codedInputStreamMicro.readInt32());
                    } else if (tag == 18) {
                        setCname(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public EndCity setCname(String str) {
                this.hasCname = true;
                this.cname_ = str;
                return this;
            }

            public EndCity setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static final class Start extends MessageMicro {
            public static final int BUILDINGNAME_FIELD_NUMBER = 8;
            public static final int BUILDING_FIELD_NUMBER = 7;
            public static final int BUS_STOP_FIELD_NUMBER = 4;
            public static final int FLOOR_FIELD_NUMBER = 6;
            public static final int FLOOR_INFO_FIELD_NUMBER = 9;
            public static final int INDOOR_LOC_TECH_FIELD_NUMBER = 10;
            public static final int PT_FIELD_NUMBER = 1;
            public static final int RT_BUS_FIELD_NUMBER = 11;
            public static final int SPT_FIELD_NUMBER = 5;
            public static final int UID_FIELD_NUMBER = 3;
            public static final int WD_FIELD_NUMBER = 2;
            private boolean hasBuilding;
            private boolean hasBuildingname;
            private boolean hasBusStop;
            private boolean hasFloor;
            private boolean hasFloorInfo;
            private boolean hasIndoorLocTech;
            private boolean hasPt;
            private boolean hasRtBus;
            private boolean hasUid;
            private boolean hasWd;
            private String pt_ = "";
            private String wd_ = "";
            private String uid_ = "";
            private boolean busStop_ = false;
            private List<Integer> spt_ = Collections.emptyList();
            private String floor_ = "";
            private String building_ = "";
            private String buildingname_ = "";
            private String floorInfo_ = "";
            private int indoorLocTech_ = 0;
            private int rtBus_ = 0;
            private int cachedSize = -1;

            public static Start parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Start().mergeFrom(codedInputStreamMicro);
            }

            public static Start parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Start) new Start().mergeFrom(bArr);
            }

            public Start addSpt(int i) {
                if (this.spt_.isEmpty()) {
                    this.spt_ = new ArrayList();
                }
                this.spt_.add(Integer.valueOf(i));
                return this;
            }

            public final Start clear() {
                clearPt();
                clearWd();
                clearUid();
                clearBusStop();
                clearSpt();
                clearFloor();
                clearBuilding();
                clearBuildingname();
                clearFloorInfo();
                clearIndoorLocTech();
                clearRtBus();
                this.cachedSize = -1;
                return this;
            }

            public Start clearBuilding() {
                this.hasBuilding = false;
                this.building_ = "";
                return this;
            }

            public Start clearBuildingname() {
                this.hasBuildingname = false;
                this.buildingname_ = "";
                return this;
            }

            public Start clearBusStop() {
                this.hasBusStop = false;
                this.busStop_ = false;
                return this;
            }

            public Start clearFloor() {
                this.hasFloor = false;
                this.floor_ = "";
                return this;
            }

            public Start clearFloorInfo() {
                this.hasFloorInfo = false;
                this.floorInfo_ = "";
                return this;
            }

            public Start clearIndoorLocTech() {
                this.hasIndoorLocTech = false;
                this.indoorLocTech_ = 0;
                return this;
            }

            public Start clearPt() {
                this.hasPt = false;
                this.pt_ = "";
                return this;
            }

            public Start clearRtBus() {
                this.hasRtBus = false;
                this.rtBus_ = 0;
                return this;
            }

            public Start clearSpt() {
                this.spt_ = Collections.emptyList();
                return this;
            }

            public Start clearUid() {
                this.hasUid = false;
                this.uid_ = "";
                return this;
            }

            public Start clearWd() {
                this.hasWd = false;
                this.wd_ = "";
                return this;
            }

            public String getBuilding() {
                return this.building_;
            }

            public String getBuildingname() {
                return this.buildingname_;
            }

            public boolean getBusStop() {
                return this.busStop_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getFloor() {
                return this.floor_;
            }

            public String getFloorInfo() {
                return this.floorInfo_;
            }

            public int getIndoorLocTech() {
                return this.indoorLocTech_;
            }

            public String getPt() {
                return this.pt_;
            }

            public int getRtBus() {
                return this.rtBus_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeSInt32SizeNoTag = 0;
                int iComputeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                if (hasWd()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getWd());
                }
                if (hasUid()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                }
                if (hasBusStop()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeBoolSize(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = iComputeStringSize + iComputeSInt32SizeNoTag + (getSptList().size() * 1);
                if (hasFloor()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getFloor());
                }
                if (hasBuilding()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, getBuilding());
                }
                if (hasBuildingname()) {
                    size += CodedOutputStreamMicro.computeStringSize(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    size += CodedOutputStreamMicro.computeStringSize(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    size += CodedOutputStreamMicro.computeInt32Size(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    size += CodedOutputStreamMicro.computeInt32Size(11, getRtBus());
                }
                this.cachedSize = size;
                return size;
            }

            public int getSpt(int i) {
                return this.spt_.get(i).intValue();
            }

            public int getSptCount() {
                return this.spt_.size();
            }

            public List<Integer> getSptList() {
                return this.spt_;
            }

            public String getUid() {
                return this.uid_;
            }

            public String getWd() {
                return this.wd_;
            }

            public boolean hasBuilding() {
                return this.hasBuilding;
            }

            public boolean hasBuildingname() {
                return this.hasBuildingname;
            }

            public boolean hasBusStop() {
                return this.hasBusStop;
            }

            public boolean hasFloor() {
                return this.hasFloor;
            }

            public boolean hasFloorInfo() {
                return this.hasFloorInfo;
            }

            public boolean hasIndoorLocTech() {
                return this.hasIndoorLocTech;
            }

            public boolean hasPt() {
                return this.hasPt;
            }

            public boolean hasRtBus() {
                return this.hasRtBus;
            }

            public boolean hasUid() {
                return this.hasUid;
            }

            public boolean hasWd() {
                return this.hasWd;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Start mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    switch (tag) {
                        case 0:
                            return this;
                        case 10:
                            setPt(codedInputStreamMicro.readString());
                            break;
                        case 18:
                            setWd(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            setUid(codedInputStreamMicro.readString());
                            break;
                        case 32:
                            setBusStop(codedInputStreamMicro.readBool());
                            break;
                        case 40:
                            addSpt(codedInputStreamMicro.readSInt32());
                            break;
                        case 50:
                            setFloor(codedInputStreamMicro.readString());
                            break;
                        case 58:
                            setBuilding(codedInputStreamMicro.readString());
                            break;
                        case 66:
                            setBuildingname(codedInputStreamMicro.readString());
                            break;
                        case 74:
                            setFloorInfo(codedInputStreamMicro.readString());
                            break;
                        case 80:
                            setIndoorLocTech(codedInputStreamMicro.readInt32());
                            break;
                        case 88:
                            setRtBus(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                            break;
                            break;
                    }
                }
            }

            public Start setBuilding(String str) {
                this.hasBuilding = true;
                this.building_ = str;
                return this;
            }

            public Start setBuildingname(String str) {
                this.hasBuildingname = true;
                this.buildingname_ = str;
                return this;
            }

            public Start setBusStop(boolean z) {
                this.hasBusStop = true;
                this.busStop_ = z;
                return this;
            }

            public Start setFloor(String str) {
                this.hasFloor = true;
                this.floor_ = str;
                return this;
            }

            public Start setFloorInfo(String str) {
                this.hasFloorInfo = true;
                this.floorInfo_ = str;
                return this;
            }

            public Start setIndoorLocTech(int i) {
                this.hasIndoorLocTech = true;
                this.indoorLocTech_ = i;
                return this;
            }

            public Start setPt(String str) {
                this.hasPt = true;
                this.pt_ = str;
                return this;
            }

            public Start setRtBus(int i) {
                this.hasRtBus = true;
                this.rtBus_ = i;
                return this;
            }

            public Start setSpt(int i, int i2) {
                this.spt_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Start setUid(String str) {
                this.hasUid = true;
                this.uid_ = str;
                return this;
            }

            public Start setWd(String str) {
                this.hasWd = true;
                this.wd_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPt()) {
                    codedOutputStreamMicro.writeString(1, getPt());
                }
                if (hasWd()) {
                    codedOutputStreamMicro.writeString(2, getWd());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(3, getUid());
                }
                if (hasBusStop()) {
                    codedOutputStreamMicro.writeBool(4, getBusStop());
                }
                Iterator<Integer> it = getSptList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(5, it.next().intValue());
                }
                if (hasFloor()) {
                    codedOutputStreamMicro.writeString(6, getFloor());
                }
                if (hasBuilding()) {
                    codedOutputStreamMicro.writeString(7, getBuilding());
                }
                if (hasBuildingname()) {
                    codedOutputStreamMicro.writeString(8, getBuildingname());
                }
                if (hasFloorInfo()) {
                    codedOutputStreamMicro.writeString(9, getFloorInfo());
                }
                if (hasIndoorLocTech()) {
                    codedOutputStreamMicro.writeInt32(10, getIndoorLocTech());
                }
                if (hasRtBus()) {
                    codedOutputStreamMicro.writeInt32(11, getRtBus());
                }
            }
        }

        public static final class StartCity extends MessageMicro {
            public static final int CNAME_FIELD_NUMBER = 2;
            public static final int CODE_FIELD_NUMBER = 1;
            private boolean hasCname;
            private boolean hasCode;
            private int code_ = 0;
            private String cname_ = "";
            private int cachedSize = -1;

            public static StartCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new StartCity().mergeFrom(codedInputStreamMicro);
            }

            public static StartCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (StartCity) new StartCity().mergeFrom(bArr);
            }

            public final StartCity clear() {
                clearCode();
                clearCname();
                this.cachedSize = -1;
                return this;
            }

            public StartCity clearCname() {
                this.hasCname = false;
                this.cname_ = "";
                return this;
            }

            public StartCity clearCode() {
                this.hasCode = false;
                this.code_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getCname() {
                return this.cname_;
            }

            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasCode() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode()) : 0;
                if (hasCname()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getCname());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public boolean hasCname() {
                return this.hasCname;
            }

            public boolean hasCode() {
                return this.hasCode;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public StartCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setCode(codedInputStreamMicro.readInt32());
                    } else if (tag == 18) {
                        setCname(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public StartCity setCname(String str) {
                this.hasCname = true;
                this.cname_ = str;
                return this;
            }

            public StartCity setCode(int i) {
                this.hasCode = true;
                this.code_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCode()) {
                    codedOutputStreamMicro.writeInt32(1, getCode());
                }
                if (hasCname()) {
                    codedOutputStreamMicro.writeString(2, getCname());
                }
            }
        }

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public Option addEnd(End end) {
            if (end == null) {
                return this;
            }
            if (this.end_.isEmpty()) {
                this.end_ = new ArrayList();
            }
            this.end_.add(end);
            return this;
        }

        public Option addEndCity(EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            if (this.endCity_.isEmpty()) {
                this.endCity_ = new ArrayList();
            }
            this.endCity_.add(endCity);
            return this;
        }

        public final Option clear() {
            clearTotal();
            clearExptime();
            clearSy();
            clearStart();
            clearEnd();
            clearAvoidJam();
            clearStartCity();
            clearEndCity();
            clearDisSy();
            clearReqTm();
            clearSpathType();
            clearSessionid();
            this.cachedSize = -1;
            return this;
        }

        public Option clearAvoidJam() {
            this.hasAvoidJam = false;
            this.avoidJam_ = 0;
            return this;
        }

        public Option clearDisSy() {
            this.hasDisSy = false;
            this.disSy_ = 0;
            return this;
        }

        public Option clearEnd() {
            this.end_ = Collections.emptyList();
            return this;
        }

        public Option clearEndCity() {
            this.endCity_ = Collections.emptyList();
            return this;
        }

        public Option clearExptime() {
            this.hasExptime = false;
            this.exptime_ = "";
            return this;
        }

        public Option clearReqTm() {
            this.hasReqTm = false;
            this.reqTm_ = "";
            return this;
        }

        public Option clearSessionid() {
            this.hasSessionid = false;
            this.sessionid_ = "";
            return this;
        }

        public Option clearSpathType() {
            this.hasSpathType = false;
            this.spathType_ = 0;
            return this;
        }

        public Option clearStart() {
            this.hasStart = false;
            this.start_ = null;
            return this;
        }

        public Option clearStartCity() {
            this.hasStartCity = false;
            this.startCity_ = null;
            return this;
        }

        public Option clearSy() {
            this.hasSy = false;
            this.sy_ = 0;
            return this;
        }

        public Option clearTotal() {
            this.hasTotal = false;
            this.total_ = 0;
            return this;
        }

        public int getAvoidJam() {
            return this.avoidJam_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getDisSy() {
            return this.disSy_;
        }

        public End getEnd(int i) {
            return this.end_.get(i);
        }

        public EndCity getEndCity(int i) {
            return this.endCity_.get(i);
        }

        public int getEndCityCount() {
            return this.endCity_.size();
        }

        public List<EndCity> getEndCityList() {
            return this.endCity_;
        }

        public int getEndCount() {
            return this.end_.size();
        }

        public List<End> getEndList() {
            return this.end_;
        }

        public String getExptime() {
            return this.exptime_;
        }

        public String getReqTm() {
            return this.reqTm_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int iComputeInt32Size = hasTotal() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal()) : 0;
            if (hasExptime()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getExptime());
            }
            if (hasSy()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getSy());
            }
            if (hasStart()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, it.next());
            }
            if (hasAvoidJam()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getAvoidJam());
            }
            if (hasStartCity()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(7, getStartCity());
            }
            Iterator<EndCity> it2 = getEndCityList().iterator();
            while (it2.hasNext()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(8, it2.next());
            }
            if (hasDisSy()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(9, getDisSy());
            }
            if (hasReqTm()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(10, getReqTm());
            }
            if (hasSpathType()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(11, getSpathType());
            }
            if (hasSessionid()) {
                iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(12, getSessionid());
            }
            this.cachedSize = iComputeInt32Size;
            return iComputeInt32Size;
        }

        public String getSessionid() {
            return this.sessionid_;
        }

        public int getSpathType() {
            return this.spathType_;
        }

        public Start getStart() {
            return this.start_;
        }

        public StartCity getStartCity() {
            return this.startCity_;
        }

        public int getSy() {
            return this.sy_;
        }

        public int getTotal() {
            return this.total_;
        }

        public boolean hasAvoidJam() {
            return this.hasAvoidJam;
        }

        public boolean hasDisSy() {
            return this.hasDisSy;
        }

        public boolean hasExptime() {
            return this.hasExptime;
        }

        public boolean hasReqTm() {
            return this.hasReqTm;
        }

        public boolean hasSessionid() {
            return this.hasSessionid;
        }

        public boolean hasSpathType() {
            return this.hasSpathType;
        }

        public boolean hasStart() {
            return this.hasStart;
        }

        public boolean hasStartCity() {
            return this.hasStartCity;
        }

        public boolean hasSy() {
            return this.hasSy;
        }

        public boolean hasTotal() {
            return this.hasTotal;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int tag = codedInputStreamMicro.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        setTotal(codedInputStreamMicro.readInt32());
                        break;
                    case 18:
                        setExptime(codedInputStreamMicro.readString());
                        break;
                    case 24:
                        setSy(codedInputStreamMicro.readInt32());
                        break;
                    case 34:
                        Start start = new Start();
                        codedInputStreamMicro.readMessage(start);
                        setStart(start);
                        break;
                    case 42:
                        End end = new End();
                        codedInputStreamMicro.readMessage(end);
                        addEnd(end);
                        break;
                    case 48:
                        setAvoidJam(codedInputStreamMicro.readInt32());
                        break;
                    case 58:
                        StartCity startCity = new StartCity();
                        codedInputStreamMicro.readMessage(startCity);
                        setStartCity(startCity);
                        break;
                    case 66:
                        EndCity endCity = new EndCity();
                        codedInputStreamMicro.readMessage(endCity);
                        addEndCity(endCity);
                        break;
                    case 72:
                        setDisSy(codedInputStreamMicro.readInt32());
                        break;
                    case 82:
                        setReqTm(codedInputStreamMicro.readString());
                        break;
                    case 88:
                        setSpathType(codedInputStreamMicro.readInt32());
                        break;
                    case 98:
                        setSessionid(codedInputStreamMicro.readString());
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }

        public Option setAvoidJam(int i) {
            this.hasAvoidJam = true;
            this.avoidJam_ = i;
            return this;
        }

        public Option setDisSy(int i) {
            this.hasDisSy = true;
            this.disSy_ = i;
            return this;
        }

        public Option setEnd(int i, End end) {
            if (end == null) {
                return this;
            }
            this.end_.set(i, end);
            return this;
        }

        public Option setEndCity(int i, EndCity endCity) {
            if (endCity == null) {
                return this;
            }
            this.endCity_.set(i, endCity);
            return this;
        }

        public Option setExptime(String str) {
            this.hasExptime = true;
            this.exptime_ = str;
            return this;
        }

        public Option setReqTm(String str) {
            this.hasReqTm = true;
            this.reqTm_ = str;
            return this;
        }

        public Option setSessionid(String str) {
            this.hasSessionid = true;
            this.sessionid_ = str;
            return this;
        }

        public Option setSpathType(int i) {
            this.hasSpathType = true;
            this.spathType_ = i;
            return this;
        }

        public Option setStart(Start start) {
            if (start == null) {
                return clearStart();
            }
            this.hasStart = true;
            this.start_ = start;
            return this;
        }

        public Option setStartCity(StartCity startCity) {
            if (startCity == null) {
                return clearStartCity();
            }
            this.hasStartCity = true;
            this.startCity_ = startCity;
            return this;
        }

        public Option setSy(int i) {
            this.hasSy = true;
            this.sy_ = i;
            return this;
        }

        public Option setTotal(int i) {
            this.hasTotal = true;
            this.total_ = i;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            if (hasExptime()) {
                codedOutputStreamMicro.writeString(2, getExptime());
            }
            if (hasSy()) {
                codedOutputStreamMicro.writeInt32(3, getSy());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeMessage(4, getStart());
            }
            Iterator<End> it = getEndList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(5, it.next());
            }
            if (hasAvoidJam()) {
                codedOutputStreamMicro.writeInt32(6, getAvoidJam());
            }
            if (hasStartCity()) {
                codedOutputStreamMicro.writeMessage(7, getStartCity());
            }
            Iterator<EndCity> it2 = getEndCityList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(8, it2.next());
            }
            if (hasDisSy()) {
                codedOutputStreamMicro.writeInt32(9, getDisSy());
            }
            if (hasReqTm()) {
                codedOutputStreamMicro.writeString(10, getReqTm());
            }
            if (hasSpathType()) {
                codedOutputStreamMicro.writeInt32(11, getSpathType());
            }
            if (hasSessionid()) {
                codedOutputStreamMicro.writeString(12, getSessionid());
            }
        }
    }

    public static final class Routes extends MessageMicro {
        public static final int CLIMB_FIELD_NUMBER = 2;
        public static final int GUIDE_INFO_FIELD_NUMBER = 8;
        public static final int LEGS_FIELD_NUMBER = 1;
        public static final int MAP_DRAW_INFO_FIELD_NUMBER = 10;
        public static final int MS_INFO_FIELD_NUMBER = 6;
        public static final int OTHERINFO_FIELD_NUMBER = 4;
        public static final int PLCY_INFO_FIELD_NUMBER = 5;
        public static final int ROUTE_IDF_FIELD_NUMBER = 7;
        public static final int TIP_FIELD_NUMBER = 3;
        public static final int UGC_INFO_FIELD_NUMBER = 9;
        private boolean hasClimb;
        private boolean hasOtherinfo;
        private boolean hasPlcyInfo;
        private boolean hasRouteIdf;
        private boolean hasTip;
        private List<Legs> legs_ = Collections.emptyList();
        private Climb climb_ = null;
        private Tip tip_ = null;
        private OtherInfo otherinfo_ = null;
        private PolicyInfo plcyInfo_ = null;
        private List<Milestone> msInfo_ = Collections.emptyList();
        private String routeIdf_ = "";
        private List<Guideinfo> guideInfo_ = Collections.emptyList();
        private List<UgcInfo> ugcInfo_ = Collections.emptyList();
        private List<MapDrawInfo> mapDrawInfo_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class Climb extends MessageMicro {
            public static final int CLIMB_HEIGHT_FIELD_NUMBER = 3;
            public static final int DOWN_DIS_FIELD_NUMBER = 2;
            public static final int UP_DIS_FIELD_NUMBER = 1;
            private boolean hasClimbHeight;
            private boolean hasDownDis;
            private boolean hasUpDis;
            private int upDis_ = 0;
            private int downDis_ = 0;
            private int climbHeight_ = 0;
            private int cachedSize = -1;

            public static Climb parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Climb().mergeFrom(codedInputStreamMicro);
            }

            public static Climb parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Climb) new Climb().mergeFrom(bArr);
            }

            public final Climb clear() {
                clearUpDis();
                clearDownDis();
                clearClimbHeight();
                this.cachedSize = -1;
                return this;
            }

            public Climb clearClimbHeight() {
                this.hasClimbHeight = false;
                this.climbHeight_ = 0;
                return this;
            }

            public Climb clearDownDis() {
                this.hasDownDis = false;
                this.downDis_ = 0;
                return this;
            }

            public Climb clearUpDis() {
                this.hasUpDis = false;
                this.upDis_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getClimbHeight() {
                return this.climbHeight_;
            }

            public int getDownDis() {
                return this.downDis_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasUpDis() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getUpDis()) : 0;
                if (hasDownDis()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDownDis());
                }
                if (hasClimbHeight()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getClimbHeight());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public int getUpDis() {
                return this.upDis_;
            }

            public boolean hasClimbHeight() {
                return this.hasClimbHeight;
            }

            public boolean hasDownDis() {
                return this.hasDownDis;
            }

            public boolean hasUpDis() {
                return this.hasUpDis;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Climb mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setUpDis(codedInputStreamMicro.readInt32());
                    } else if (tag == 16) {
                        setDownDis(codedInputStreamMicro.readInt32());
                    } else if (tag == 24) {
                        setClimbHeight(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public Climb setClimbHeight(int i) {
                this.hasClimbHeight = true;
                this.climbHeight_ = i;
                return this;
            }

            public Climb setDownDis(int i) {
                this.hasDownDis = true;
                this.downDis_ = i;
                return this;
            }

            public Climb setUpDis(int i) {
                this.hasUpDis = true;
                this.upDis_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasUpDis()) {
                    codedOutputStreamMicro.writeInt32(1, getUpDis());
                }
                if (hasDownDis()) {
                    codedOutputStreamMicro.writeInt32(2, getDownDis());
                }
                if (hasClimbHeight()) {
                    codedOutputStreamMicro.writeInt32(3, getClimbHeight());
                }
            }
        }

        public static final class GraphItemInfo extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            private boolean hasContent;
            private String content_ = "";
            private List<Integer> pt_ = Collections.emptyList();
            private int cachedSize = -1;

            public static GraphItemInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new GraphItemInfo().mergeFrom(codedInputStreamMicro);
            }

            public static GraphItemInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (GraphItemInfo) new GraphItemInfo().mergeFrom(bArr);
            }

            public GraphItemInfo addPt(int i) {
                if (this.pt_.isEmpty()) {
                    this.pt_ = new ArrayList();
                }
                this.pt_.add(Integer.valueOf(i));
                return this;
            }

            public final GraphItemInfo clear() {
                clearContent();
                clearPt();
                this.cachedSize = -1;
                return this;
            }

            public GraphItemInfo clearContent() {
                this.hasContent = false;
                this.content_ = "";
                return this;
            }

            public GraphItemInfo clearPt() {
                this.pt_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getContent() {
                return this.content_;
            }

            public int getPt(int i) {
                return this.pt_.get(i).intValue();
            }

            public int getPtCount() {
                return this.pt_.size();
            }

            public List<Integer> getPtList() {
                return this.pt_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeSInt32SizeNoTag = 0;
                int iComputeStringSize = hasContent() ? CodedOutputStreamMicro.computeStringSize(1, getContent()) + 0 : 0;
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = iComputeStringSize + iComputeSInt32SizeNoTag + (getPtList().size() * 1);
                this.cachedSize = size;
                return size;
            }

            public boolean hasContent() {
                return this.hasContent;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public GraphItemInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        setContent(codedInputStreamMicro.readString());
                    } else if (tag == 16) {
                        addPt(codedInputStreamMicro.readSInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public GraphItemInfo setContent(String str) {
                this.hasContent = true;
                this.content_ = str;
                return this;
            }

            public GraphItemInfo setPt(int i, int i2) {
                this.pt_.set(i, Integer.valueOf(i2));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(2, it.next().intValue());
                }
            }
        }

        public static final class Guideinfo extends MessageMicro {
            public static final int GUIDE_STR_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 1;
            private boolean hasGuideStr;
            private boolean hasType;
            private int type_ = 0;
            private String guideStr_ = "";
            private int cachedSize = -1;

            public static Guideinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Guideinfo().mergeFrom(codedInputStreamMicro);
            }

            public static Guideinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Guideinfo) new Guideinfo().mergeFrom(bArr);
            }

            public final Guideinfo clear() {
                clearType();
                clearGuideStr();
                this.cachedSize = -1;
                return this;
            }

            public Guideinfo clearGuideStr() {
                this.hasGuideStr = false;
                this.guideStr_ = "";
                return this;
            }

            public Guideinfo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getGuideStr() {
                return this.guideStr_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasType() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                if (hasGuideStr()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getGuideStr());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasGuideStr() {
                return this.hasGuideStr;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Guideinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (tag == 18) {
                        setGuideStr(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public Guideinfo setGuideStr(String str) {
                this.hasGuideStr = true;
                this.guideStr_ = str;
                return this;
            }

            public Guideinfo setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(1, getType());
                }
                if (hasGuideStr()) {
                    codedOutputStreamMicro.writeString(2, getGuideStr());
                }
            }
        }

        public static final class Legs extends MessageMicro {
            public static final int CONNECTED_POIS_FIELD_NUMBER = 11;
            public static final int DISTANCE_FIELD_NUMBER = 5;
            public static final int DURATION_FIELD_NUMBER = 6;
            public static final int END_ADDRESS_FIELD_NUMBER = 4;
            public static final int END_DIST_FIELD_NUMBER = 9;
            public static final int LEG_LINKED_FIELD_NUMBER = 12;
            public static final int SEND_LOCATION_FIELD_NUMBER = 2;
            public static final int SIDE_FIELD_NUMBER = 7;
            public static final int SSTART_LOCATION_FIELD_NUMBER = 1;
            public static final int START_ADDRESS_FIELD_NUMBER = 3;
            public static final int START_DIST_FIELD_NUMBER = 8;
            public static final int STEPS_FIELD_NUMBER = 10;
            public static final int TYPE_FIELD_NUMBER = 13;
            private boolean hasDistance;
            private boolean hasDuration;
            private boolean hasEndAddress;
            private boolean hasEndDist;
            private boolean hasLegLinked;
            private boolean hasSide;
            private boolean hasStartAddress;
            private boolean hasStartDist;
            private boolean hasType;
            private List<Steps> steps_ = Collections.emptyList();
            private List<Integer> sstartLocation_ = Collections.emptyList();
            private List<Integer> sendLocation_ = Collections.emptyList();
            private String startAddress_ = "";
            private String endAddress_ = "";
            private int distance_ = 0;
            private int duration_ = 0;
            private int side_ = 0;
            private int startDist_ = 0;
            private int endDist_ = 0;
            private List<ConnectedPois> connectedPois_ = Collections.emptyList();
            private LegLinked legLinked_ = null;
            private int type_ = 0;
            private int cachedSize = -1;

            public static final class ConnectedPois extends MessageMicro {
                public static final int BUILDING_FIELD_NUMBER = 6;
                public static final int FLOOR_FIELD_NUMBER = 5;
                public static final int INFO_FIELD_NUMBER = 3;
                public static final int LOCATION_FIELD_NUMBER = 4;
                public static final int TYPE_DIR_FIELD_NUMBER = 2;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasBuilding;
                private boolean hasFloor;
                private boolean hasInfo;
                private boolean hasType;
                private boolean hasTypeDir;
                private int type_ = 0;
                private int typeDir_ = 0;
                private String info_ = "";
                private List<Integer> location_ = Collections.emptyList();
                private String floor_ = "";
                private String building_ = "";
                private int cachedSize = -1;

                public static ConnectedPois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ConnectedPois().mergeFrom(codedInputStreamMicro);
                }

                public static ConnectedPois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ConnectedPois) new ConnectedPois().mergeFrom(bArr);
                }

                public ConnectedPois addLocation(int i) {
                    if (this.location_.isEmpty()) {
                        this.location_ = new ArrayList();
                    }
                    this.location_.add(Integer.valueOf(i));
                    return this;
                }

                public final ConnectedPois clear() {
                    clearType();
                    clearTypeDir();
                    clearInfo();
                    clearLocation();
                    clearFloor();
                    clearBuilding();
                    this.cachedSize = -1;
                    return this;
                }

                public ConnectedPois clearBuilding() {
                    this.hasBuilding = false;
                    this.building_ = "";
                    return this;
                }

                public ConnectedPois clearFloor() {
                    this.hasFloor = false;
                    this.floor_ = "";
                    return this;
                }

                public ConnectedPois clearInfo() {
                    this.hasInfo = false;
                    this.info_ = "";
                    return this;
                }

                public ConnectedPois clearLocation() {
                    this.location_ = Collections.emptyList();
                    return this;
                }

                public ConnectedPois clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public ConnectedPois clearTypeDir() {
                    this.hasTypeDir = false;
                    this.typeDir_ = 0;
                    return this;
                }

                public String getBuilding() {
                    return this.building_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getFloor() {
                    return this.floor_;
                }

                public String getInfo() {
                    return this.info_;
                }

                public int getLocation(int i) {
                    return this.location_.get(i).intValue();
                }

                public int getLocationCount() {
                    return this.location_.size();
                }

                public List<Integer> getLocationList() {
                    return this.location_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeInt32SizeNoTag = 0;
                    int iComputeInt32Size = hasType() ? CodedOutputStreamMicro.computeInt32Size(1, getType()) + 0 : 0;
                    if (hasTypeDir()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTypeDir());
                    }
                    if (hasInfo()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getInfo());
                    }
                    Iterator<Integer> it = getLocationList().iterator();
                    while (it.hasNext()) {
                        iComputeInt32SizeNoTag += CodedOutputStreamMicro.computeInt32SizeNoTag(it.next().intValue());
                    }
                    int size = iComputeInt32Size + iComputeInt32SizeNoTag + (getLocationList().size() * 1);
                    if (hasFloor()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (hasBuilding()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, getBuilding());
                    }
                    this.cachedSize = size;
                    return size;
                }

                public int getType() {
                    return this.type_;
                }

                public int getTypeDir() {
                    return this.typeDir_;
                }

                public boolean hasBuilding() {
                    return this.hasBuilding;
                }

                public boolean hasFloor() {
                    return this.hasFloor;
                }

                public boolean hasInfo() {
                    return this.hasInfo;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public boolean hasTypeDir() {
                    return this.hasTypeDir;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ConnectedPois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 8) {
                            setType(codedInputStreamMicro.readInt32());
                        } else if (tag == 16) {
                            setTypeDir(codedInputStreamMicro.readInt32());
                        } else if (tag == 26) {
                            setInfo(codedInputStreamMicro.readString());
                        } else if (tag == 32) {
                            addLocation(codedInputStreamMicro.readInt32());
                        } else if (tag == 42) {
                            setFloor(codedInputStreamMicro.readString());
                        } else if (tag == 50) {
                            setBuilding(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public ConnectedPois setBuilding(String str) {
                    this.hasBuilding = true;
                    this.building_ = str;
                    return this;
                }

                public ConnectedPois setFloor(String str) {
                    this.hasFloor = true;
                    this.floor_ = str;
                    return this;
                }

                public ConnectedPois setInfo(String str) {
                    this.hasInfo = true;
                    this.info_ = str;
                    return this;
                }

                public ConnectedPois setLocation(int i, int i2) {
                    this.location_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public ConnectedPois setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                public ConnectedPois setTypeDir(int i) {
                    this.hasTypeDir = true;
                    this.typeDir_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(1, getType());
                    }
                    if (hasTypeDir()) {
                        codedOutputStreamMicro.writeInt32(2, getTypeDir());
                    }
                    if (hasInfo()) {
                        codedOutputStreamMicro.writeString(3, getInfo());
                    }
                    Iterator<Integer> it = getLocationList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeInt32(4, it.next().intValue());
                    }
                    if (hasFloor()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (hasBuilding()) {
                        codedOutputStreamMicro.writeString(6, getBuilding());
                    }
                }
            }

            public static final class LegLinked extends MessageMicro {
                public static final int NEXT_FIELD_NUMBER = 2;
                public static final int PREV_FIELD_NUMBER = 1;
                private boolean hasNext;
                private boolean hasPrev;
                private int prev_ = 0;
                private int next_ = 0;
                private int cachedSize = -1;

                public static LegLinked parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new LegLinked().mergeFrom(codedInputStreamMicro);
                }

                public static LegLinked parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (LegLinked) new LegLinked().mergeFrom(bArr);
                }

                public final LegLinked clear() {
                    clearPrev();
                    clearNext();
                    this.cachedSize = -1;
                    return this;
                }

                public LegLinked clearNext() {
                    this.hasNext = false;
                    this.next_ = 0;
                    return this;
                }

                public LegLinked clearPrev() {
                    this.hasPrev = false;
                    this.prev_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getNext() {
                    return this.next_;
                }

                public int getPrev() {
                    return this.prev_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeInt32Size = hasPrev() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getPrev()) : 0;
                    if (hasNext()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getNext());
                    }
                    this.cachedSize = iComputeInt32Size;
                    return iComputeInt32Size;
                }

                public boolean hasNext() {
                    return this.hasNext;
                }

                public boolean hasPrev() {
                    return this.hasPrev;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public LegLinked mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 8) {
                            setPrev(codedInputStreamMicro.readInt32());
                        } else if (tag == 16) {
                            setNext(codedInputStreamMicro.readInt32());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public LegLinked setNext(int i) {
                    this.hasNext = true;
                    this.next_ = i;
                    return this;
                }

                public LegLinked setPrev(int i) {
                    this.hasPrev = true;
                    this.prev_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasPrev()) {
                        codedOutputStreamMicro.writeInt32(1, getPrev());
                    }
                    if (hasNext()) {
                        codedOutputStreamMicro.writeInt32(2, getNext());
                    }
                }
            }

            public static final class Steps extends MessageMicro {
                public static final int CIRCLE_ROAD_FIELD_NUMBER = 9;
                public static final int CLOUD_GUIDE_V1_FIELD_NUMBER = 24;
                public static final int CLOUD_GUIDE_V2_FIELD_NUMBER = 25;
                public static final int CLOUD_GUIDE_V3_FIELD_NUMBER = 27;
                public static final int DIRECTION_FIELD_NUMBER = 15;
                public static final int DISTANCE_FIELD_NUMBER = 11;
                public static final int DURATION_FIELD_NUMBER = 12;
                public static final int FIRST_LINK_END_INDEX_FIELD_NUMBER = 5;
                public static final int GUIDE_TYPE_FIELD_NUMBER = 26;
                public static final int HAS_PANID_FIELD_NUMBER = 16;
                public static final int INSTRUCTIONS_FIELD_NUMBER = 2;
                public static final int LIGHT_FIELD_NUMBER = 8;
                public static final int LINKS_FIELD_NUMBER = 13;
                public static final int NAME_FIELD_NUMBER = 4;
                public static final int POIREF_POIS_FIELD_NUMBER = 23;
                public static final int POIS_FIELD_NUMBER = 14;
                public static final int ROAD_WIDTH_FIELD_NUMBER = 10;
                public static final int SEND_LOCATION_FIELD_NUMBER = 18;
                public static final int SPATH_4_NAVI_FIELD_NUMBER = 21;
                public static final int SPATH_FIELD_NUMBER = 1;
                public static final int SSTART_LOCATION_FIELD_NUMBER = 17;
                public static final int STEP_STATUS_FIELD_NUMBER = 22;
                public static final int STRAFFICMARK_LOC_FIELD_NUMBER = 19;
                public static final int TRAFFIC_TYPE_FIELD_NUMBER = 20;
                public static final int TURN_TYPE_FIELD_NUMBER = 6;
                public static final int TYPE_FIELD_NUMBER = 3;
                public static final int WALK_TYPE_FIELD_NUMBER = 7;
                private boolean hasCircleRoad;
                private boolean hasDirection;
                private boolean hasDistance;
                private boolean hasDuration;
                private boolean hasFirstLinkEndIndex;
                private boolean hasGuideType;
                private boolean hasHasPanid;
                private boolean hasInstructions;
                private boolean hasLight;
                private boolean hasName;
                private boolean hasRoadWidth;
                private boolean hasStepStatus;
                private boolean hasTrafficType;
                private boolean hasTurnType;
                private boolean hasType;
                private boolean hasWalkType;
                private List<Links> links_ = Collections.emptyList();
                private List<Pois> pois_ = Collections.emptyList();
                private List<Integer> spath_ = Collections.emptyList();
                private String instructions_ = "";
                private int type_ = 0;
                private String name_ = "";
                private int firstLinkEndIndex_ = 0;
                private int turnType_ = 0;
                private int walkType_ = 0;
                private int light_ = 0;
                private int circleRoad_ = 0;
                private int roadWidth_ = 0;
                private int distance_ = 0;
                private int duration_ = 0;
                private int direction_ = 0;
                private int hasPanid_ = 0;
                private List<Integer> sstartLocation_ = Collections.emptyList();
                private List<Integer> sendLocation_ = Collections.emptyList();
                private List<Integer> strafficmarkLoc_ = Collections.emptyList();
                private int trafficType_ = 0;
                private List<Integer> spath4Navi_ = Collections.emptyList();
                private int stepStatus_ = 0;
                private List<Pois> poirefPois_ = Collections.emptyList();
                private List<DetailGuideInfoV1> cloudGuideV1_ = Collections.emptyList();
                private List<DetailGuideInfoV2> cloudGuideV2_ = Collections.emptyList();
                private int guideType_ = 0;
                private List<DetailGuideInfoV3> cloudGuideV3_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class DetailGuideInfoV1 extends MessageMicro {
                    public static final int ADD_DIST_FIELD_NUMBER = 1;
                    public static final int AFTER_DIST_FIELD_NUMBER = 6;
                    public static final int BROADCAST_CONTENT_FIELD_NUMBER = 3;
                    public static final int BROADCAST_CONTENT_TYPE_FIELD_NUMBER = 2;
                    public static final int CIRCLE_ROAD_FIELD_NUMBER = 10;
                    public static final int NOTIFY_NPC_FIELD_NUMBER = 7;
                    public static final int PRE_DIST_FIELD_NUMBER = 5;
                    public static final int PRIOROTY_FIELD_NUMBER = 4;
                    public static final int TURN_TYPE_FIELD_NUMBER = 8;
                    public static final int VIBRATE_FIELD_NUMBER = 11;
                    public static final int WALK_TYPE_FIELD_NUMBER = 9;
                    private boolean hasAddDist;
                    private boolean hasAfterDist;
                    private boolean hasBroadcastContent;
                    private boolean hasBroadcastContentType;
                    private boolean hasCircleRoad;
                    private boolean hasNotifyNpc;
                    private boolean hasPreDist;
                    private boolean hasPrioroty;
                    private boolean hasTurnType;
                    private boolean hasVibrate;
                    private boolean hasWalkType;
                    private int addDist_ = 0;
                    private int broadcastContentType_ = 0;
                    private String broadcastContent_ = "";
                    private int prioroty_ = 0;
                    private int preDist_ = 0;
                    private int afterDist_ = 0;
                    private int notifyNpc_ = 0;
                    private int turnType_ = 0;
                    private int walkType_ = 0;
                    private int circleRoad_ = 0;
                    private int vibrate_ = 0;
                    private int cachedSize = -1;

                    public static DetailGuideInfoV1 parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DetailGuideInfoV1().mergeFrom(codedInputStreamMicro);
                    }

                    public static DetailGuideInfoV1 parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DetailGuideInfoV1) new DetailGuideInfoV1().mergeFrom(bArr);
                    }

                    public final DetailGuideInfoV1 clear() {
                        clearAddDist();
                        clearBroadcastContentType();
                        clearBroadcastContent();
                        clearPrioroty();
                        clearPreDist();
                        clearAfterDist();
                        clearNotifyNpc();
                        clearTurnType();
                        clearWalkType();
                        clearCircleRoad();
                        clearVibrate();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DetailGuideInfoV1 clearAddDist() {
                        this.hasAddDist = false;
                        this.addDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearAfterDist() {
                        this.hasAfterDist = false;
                        this.afterDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearBroadcastContent() {
                        this.hasBroadcastContent = false;
                        this.broadcastContent_ = "";
                        return this;
                    }

                    public DetailGuideInfoV1 clearBroadcastContentType() {
                        this.hasBroadcastContentType = false;
                        this.broadcastContentType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearCircleRoad() {
                        this.hasCircleRoad = false;
                        this.circleRoad_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearNotifyNpc() {
                        this.hasNotifyNpc = false;
                        this.notifyNpc_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearPreDist() {
                        this.hasPreDist = false;
                        this.preDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearPrioroty() {
                        this.hasPrioroty = false;
                        this.prioroty_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearTurnType() {
                        this.hasTurnType = false;
                        this.turnType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearVibrate() {
                        this.hasVibrate = false;
                        this.vibrate_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV1 clearWalkType() {
                        this.hasWalkType = false;
                        this.walkType_ = 0;
                        return this;
                    }

                    public int getAddDist() {
                        return this.addDist_;
                    }

                    public int getAfterDist() {
                        return this.afterDist_;
                    }

                    public String getBroadcastContent() {
                        return this.broadcastContent_;
                    }

                    public int getBroadcastContentType() {
                        return this.broadcastContentType_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getCircleRoad() {
                        return this.circleRoad_;
                    }

                    public int getNotifyNpc() {
                        return this.notifyNpc_;
                    }

                    public int getPreDist() {
                        return this.preDist_;
                    }

                    public int getPrioroty() {
                        return this.prioroty_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeInt32Size = hasAddDist() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getAddDist()) : 0;
                        if (hasBroadcastContentType()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getBroadcastContentType());
                        }
                        if (hasBroadcastContent()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getBroadcastContent());
                        }
                        if (hasPrioroty()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getCircleRoad());
                        }
                        if (hasVibrate()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(11, getVibrate());
                        }
                        this.cachedSize = iComputeInt32Size;
                        return iComputeInt32Size;
                    }

                    public int getTurnType() {
                        return this.turnType_;
                    }

                    public int getVibrate() {
                        return this.vibrate_;
                    }

                    public int getWalkType() {
                        return this.walkType_;
                    }

                    public boolean hasAddDist() {
                        return this.hasAddDist;
                    }

                    public boolean hasAfterDist() {
                        return this.hasAfterDist;
                    }

                    public boolean hasBroadcastContent() {
                        return this.hasBroadcastContent;
                    }

                    public boolean hasBroadcastContentType() {
                        return this.hasBroadcastContentType;
                    }

                    public boolean hasCircleRoad() {
                        return this.hasCircleRoad;
                    }

                    public boolean hasNotifyNpc() {
                        return this.hasNotifyNpc;
                    }

                    public boolean hasPreDist() {
                        return this.hasPreDist;
                    }

                    public boolean hasPrioroty() {
                        return this.hasPrioroty;
                    }

                    public boolean hasTurnType() {
                        return this.hasTurnType;
                    }

                    public boolean hasVibrate() {
                        return this.hasVibrate;
                    }

                    public boolean hasWalkType() {
                        return this.hasWalkType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DetailGuideInfoV1 mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            switch (tag) {
                                case 0:
                                    return this;
                                case 8:
                                    setAddDist(codedInputStreamMicro.readInt32());
                                    break;
                                case 16:
                                    setBroadcastContentType(codedInputStreamMicro.readInt32());
                                    break;
                                case 26:
                                    setBroadcastContent(codedInputStreamMicro.readString());
                                    break;
                                case 32:
                                    setPrioroty(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    setPreDist(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    setAfterDist(codedInputStreamMicro.readInt32());
                                    break;
                                case 56:
                                    setNotifyNpc(codedInputStreamMicro.readInt32());
                                    break;
                                case 64:
                                    setTurnType(codedInputStreamMicro.readInt32());
                                    break;
                                case 72:
                                    setWalkType(codedInputStreamMicro.readInt32());
                                    break;
                                case 80:
                                    setCircleRoad(codedInputStreamMicro.readInt32());
                                    break;
                                case 88:
                                    setVibrate(codedInputStreamMicro.readInt32());
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                        return this;
                                    }
                                    break;
                                    break;
                            }
                        }
                    }

                    public DetailGuideInfoV1 setAddDist(int i) {
                        this.hasAddDist = true;
                        this.addDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setAfterDist(int i) {
                        this.hasAfterDist = true;
                        this.afterDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setBroadcastContent(String str) {
                        this.hasBroadcastContent = true;
                        this.broadcastContent_ = str;
                        return this;
                    }

                    public DetailGuideInfoV1 setBroadcastContentType(int i) {
                        this.hasBroadcastContentType = true;
                        this.broadcastContentType_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setCircleRoad(int i) {
                        this.hasCircleRoad = true;
                        this.circleRoad_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setNotifyNpc(int i) {
                        this.hasNotifyNpc = true;
                        this.notifyNpc_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setPreDist(int i) {
                        this.hasPreDist = true;
                        this.preDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setPrioroty(int i) {
                        this.hasPrioroty = true;
                        this.prioroty_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setTurnType(int i) {
                        this.hasTurnType = true;
                        this.turnType_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setVibrate(int i) {
                        this.hasVibrate = true;
                        this.vibrate_ = i;
                        return this;
                    }

                    public DetailGuideInfoV1 setWalkType(int i) {
                        this.hasWalkType = true;
                        this.walkType_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasAddDist()) {
                            codedOutputStreamMicro.writeInt32(1, getAddDist());
                        }
                        if (hasBroadcastContentType()) {
                            codedOutputStreamMicro.writeInt32(2, getBroadcastContentType());
                        }
                        if (hasBroadcastContent()) {
                            codedOutputStreamMicro.writeString(3, getBroadcastContent());
                        }
                        if (hasPrioroty()) {
                            codedOutputStreamMicro.writeInt32(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            codedOutputStreamMicro.writeInt32(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            codedOutputStreamMicro.writeInt32(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            codedOutputStreamMicro.writeInt32(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            codedOutputStreamMicro.writeInt32(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            codedOutputStreamMicro.writeInt32(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            codedOutputStreamMicro.writeInt32(10, getCircleRoad());
                        }
                        if (hasVibrate()) {
                            codedOutputStreamMicro.writeInt32(11, getVibrate());
                        }
                    }
                }

                public static final class DetailGuideInfoV2 extends MessageMicro {
                    public static final int AFTER_DIST_FIELD_NUMBER = 6;
                    public static final int BROADCAST_CONTENT_TYPE_FIELD_NUMBER = 2;
                    public static final int BROADCAST_TEMPLATE_FIELD_NUMBER = 3;
                    public static final int CIRCLE_ROAD_FIELD_NUMBER = 10;
                    public static final int NOTIFY_NPC_FIELD_NUMBER = 7;
                    public static final int PRE_DIST_FIELD_NUMBER = 5;
                    public static final int PRIOROTY_FIELD_NUMBER = 4;
                    public static final int SUB_INFO_FIELD_NUMBER = 1;
                    public static final int TURN_TYPE_FIELD_NUMBER = 8;
                    public static final int WALK_TYPE_FIELD_NUMBER = 9;
                    private boolean hasAfterDist;
                    private boolean hasBroadcastContentType;
                    private boolean hasCircleRoad;
                    private boolean hasNotifyNpc;
                    private boolean hasPreDist;
                    private boolean hasPrioroty;
                    private boolean hasTurnType;
                    private boolean hasWalkType;
                    private List<SubGuideInfo> subInfo_ = Collections.emptyList();
                    private int broadcastContentType_ = 0;
                    private List<String> broadcastTemplate_ = Collections.emptyList();
                    private int prioroty_ = 0;
                    private int preDist_ = 0;
                    private int afterDist_ = 0;
                    private int notifyNpc_ = 0;
                    private int turnType_ = 0;
                    private int walkType_ = 0;
                    private int circleRoad_ = 0;
                    private int cachedSize = -1;

                    public static final class SubGuideInfo extends MessageMicro {
                        public static final int ADD_DIST_FIELD_NUMBER = 1;
                        public static final int AFTER_DIST_FIELD_NUMBER = 6;
                        public static final int BROADCAST_CONTENT_FIELD_NUMBER = 3;
                        public static final int BROADCAST_CONTENT_TYPE_FIELD_NUMBER = 2;
                        public static final int CIRCLE_ROAD_FIELD_NUMBER = 10;
                        public static final int NOTIFY_NPC_FIELD_NUMBER = 7;
                        public static final int PRE_DIST_FIELD_NUMBER = 5;
                        public static final int PRIOROTY_FIELD_NUMBER = 4;
                        public static final int TURN_TYPE_FIELD_NUMBER = 8;
                        public static final int WALK_TYPE_FIELD_NUMBER = 9;
                        private boolean hasAddDist;
                        private boolean hasAfterDist;
                        private boolean hasBroadcastContentType;
                        private boolean hasCircleRoad;
                        private boolean hasNotifyNpc;
                        private boolean hasPreDist;
                        private boolean hasPrioroty;
                        private boolean hasTurnType;
                        private boolean hasWalkType;
                        private int addDist_ = 0;
                        private int broadcastContentType_ = 0;
                        private List<String> broadcastContent_ = Collections.emptyList();
                        private int prioroty_ = 0;
                        private int preDist_ = 0;
                        private int afterDist_ = 0;
                        private int notifyNpc_ = 0;
                        private int turnType_ = 0;
                        private int walkType_ = 0;
                        private int circleRoad_ = 0;
                        private int cachedSize = -1;

                        public static SubGuideInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new SubGuideInfo().mergeFrom(codedInputStreamMicro);
                        }

                        public static SubGuideInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (SubGuideInfo) new SubGuideInfo().mergeFrom(bArr);
                        }

                        public SubGuideInfo addBroadcastContent(String str) {
                            str.getClass();
                            if (this.broadcastContent_.isEmpty()) {
                                this.broadcastContent_ = new ArrayList();
                            }
                            this.broadcastContent_.add(str);
                            return this;
                        }

                        public final SubGuideInfo clear() {
                            clearAddDist();
                            clearBroadcastContentType();
                            clearBroadcastContent();
                            clearPrioroty();
                            clearPreDist();
                            clearAfterDist();
                            clearNotifyNpc();
                            clearTurnType();
                            clearWalkType();
                            clearCircleRoad();
                            this.cachedSize = -1;
                            return this;
                        }

                        public SubGuideInfo clearAddDist() {
                            this.hasAddDist = false;
                            this.addDist_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearAfterDist() {
                            this.hasAfterDist = false;
                            this.afterDist_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearBroadcastContent() {
                            this.broadcastContent_ = Collections.emptyList();
                            return this;
                        }

                        public SubGuideInfo clearBroadcastContentType() {
                            this.hasBroadcastContentType = false;
                            this.broadcastContentType_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearCircleRoad() {
                            this.hasCircleRoad = false;
                            this.circleRoad_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearNotifyNpc() {
                            this.hasNotifyNpc = false;
                            this.notifyNpc_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearPreDist() {
                            this.hasPreDist = false;
                            this.preDist_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearPrioroty() {
                            this.hasPrioroty = false;
                            this.prioroty_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearTurnType() {
                            this.hasTurnType = false;
                            this.turnType_ = 0;
                            return this;
                        }

                        public SubGuideInfo clearWalkType() {
                            this.hasWalkType = false;
                            this.walkType_ = 0;
                            return this;
                        }

                        public int getAddDist() {
                            return this.addDist_;
                        }

                        public int getAfterDist() {
                            return this.afterDist_;
                        }

                        public String getBroadcastContent(int i) {
                            return this.broadcastContent_.get(i);
                        }

                        public int getBroadcastContentCount() {
                            return this.broadcastContent_.size();
                        }

                        public List<String> getBroadcastContentList() {
                            return this.broadcastContent_;
                        }

                        public int getBroadcastContentType() {
                            return this.broadcastContentType_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getCircleRoad() {
                            return this.circleRoad_;
                        }

                        public int getNotifyNpc() {
                            return this.notifyNpc_;
                        }

                        public int getPreDist() {
                            return this.preDist_;
                        }

                        public int getPrioroty() {
                            return this.prioroty_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int iComputeStringSizeNoTag = 0;
                            int iComputeInt32Size = hasAddDist() ? CodedOutputStreamMicro.computeInt32Size(1, getAddDist()) + 0 : 0;
                            if (hasBroadcastContentType()) {
                                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getBroadcastContentType());
                            }
                            Iterator<String> it = getBroadcastContentList().iterator();
                            while (it.hasNext()) {
                                iComputeStringSizeNoTag += CodedOutputStreamMicro.computeStringSizeNoTag(it.next());
                            }
                            int size = iComputeInt32Size + iComputeStringSizeNoTag + (getBroadcastContentList().size() * 1);
                            if (hasPrioroty()) {
                                size += CodedOutputStreamMicro.computeInt32Size(4, getPrioroty());
                            }
                            if (hasPreDist()) {
                                size += CodedOutputStreamMicro.computeInt32Size(5, getPreDist());
                            }
                            if (hasAfterDist()) {
                                size += CodedOutputStreamMicro.computeInt32Size(6, getAfterDist());
                            }
                            if (hasNotifyNpc()) {
                                size += CodedOutputStreamMicro.computeInt32Size(7, getNotifyNpc());
                            }
                            if (hasTurnType()) {
                                size += CodedOutputStreamMicro.computeInt32Size(8, getTurnType());
                            }
                            if (hasWalkType()) {
                                size += CodedOutputStreamMicro.computeInt32Size(9, getWalkType());
                            }
                            if (hasCircleRoad()) {
                                size += CodedOutputStreamMicro.computeInt32Size(10, getCircleRoad());
                            }
                            this.cachedSize = size;
                            return size;
                        }

                        public int getTurnType() {
                            return this.turnType_;
                        }

                        public int getWalkType() {
                            return this.walkType_;
                        }

                        public boolean hasAddDist() {
                            return this.hasAddDist;
                        }

                        public boolean hasAfterDist() {
                            return this.hasAfterDist;
                        }

                        public boolean hasBroadcastContentType() {
                            return this.hasBroadcastContentType;
                        }

                        public boolean hasCircleRoad() {
                            return this.hasCircleRoad;
                        }

                        public boolean hasNotifyNpc() {
                            return this.hasNotifyNpc;
                        }

                        public boolean hasPreDist() {
                            return this.hasPreDist;
                        }

                        public boolean hasPrioroty() {
                            return this.hasPrioroty;
                        }

                        public boolean hasTurnType() {
                            return this.hasTurnType;
                        }

                        public boolean hasWalkType() {
                            return this.hasWalkType;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public SubGuideInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int tag = codedInputStreamMicro.readTag();
                                switch (tag) {
                                    case 0:
                                        return this;
                                    case 8:
                                        setAddDist(codedInputStreamMicro.readInt32());
                                        break;
                                    case 16:
                                        setBroadcastContentType(codedInputStreamMicro.readInt32());
                                        break;
                                    case 26:
                                        addBroadcastContent(codedInputStreamMicro.readString());
                                        break;
                                    case 32:
                                        setPrioroty(codedInputStreamMicro.readInt32());
                                        break;
                                    case 40:
                                        setPreDist(codedInputStreamMicro.readInt32());
                                        break;
                                    case 48:
                                        setAfterDist(codedInputStreamMicro.readInt32());
                                        break;
                                    case 56:
                                        setNotifyNpc(codedInputStreamMicro.readInt32());
                                        break;
                                    case 64:
                                        setTurnType(codedInputStreamMicro.readInt32());
                                        break;
                                    case 72:
                                        setWalkType(codedInputStreamMicro.readInt32());
                                        break;
                                    case 80:
                                        setCircleRoad(codedInputStreamMicro.readInt32());
                                        break;
                                    default:
                                        if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                            return this;
                                        }
                                        break;
                                        break;
                                }
                            }
                        }

                        public SubGuideInfo setAddDist(int i) {
                            this.hasAddDist = true;
                            this.addDist_ = i;
                            return this;
                        }

                        public SubGuideInfo setAfterDist(int i) {
                            this.hasAfterDist = true;
                            this.afterDist_ = i;
                            return this;
                        }

                        public SubGuideInfo setBroadcastContent(int i, String str) {
                            str.getClass();
                            this.broadcastContent_.set(i, str);
                            return this;
                        }

                        public SubGuideInfo setBroadcastContentType(int i) {
                            this.hasBroadcastContentType = true;
                            this.broadcastContentType_ = i;
                            return this;
                        }

                        public SubGuideInfo setCircleRoad(int i) {
                            this.hasCircleRoad = true;
                            this.circleRoad_ = i;
                            return this;
                        }

                        public SubGuideInfo setNotifyNpc(int i) {
                            this.hasNotifyNpc = true;
                            this.notifyNpc_ = i;
                            return this;
                        }

                        public SubGuideInfo setPreDist(int i) {
                            this.hasPreDist = true;
                            this.preDist_ = i;
                            return this;
                        }

                        public SubGuideInfo setPrioroty(int i) {
                            this.hasPrioroty = true;
                            this.prioroty_ = i;
                            return this;
                        }

                        public SubGuideInfo setTurnType(int i) {
                            this.hasTurnType = true;
                            this.turnType_ = i;
                            return this;
                        }

                        public SubGuideInfo setWalkType(int i) {
                            this.hasWalkType = true;
                            this.walkType_ = i;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasAddDist()) {
                                codedOutputStreamMicro.writeInt32(1, getAddDist());
                            }
                            if (hasBroadcastContentType()) {
                                codedOutputStreamMicro.writeInt32(2, getBroadcastContentType());
                            }
                            Iterator<String> it = getBroadcastContentList().iterator();
                            while (it.hasNext()) {
                                codedOutputStreamMicro.writeString(3, it.next());
                            }
                            if (hasPrioroty()) {
                                codedOutputStreamMicro.writeInt32(4, getPrioroty());
                            }
                            if (hasPreDist()) {
                                codedOutputStreamMicro.writeInt32(5, getPreDist());
                            }
                            if (hasAfterDist()) {
                                codedOutputStreamMicro.writeInt32(6, getAfterDist());
                            }
                            if (hasNotifyNpc()) {
                                codedOutputStreamMicro.writeInt32(7, getNotifyNpc());
                            }
                            if (hasTurnType()) {
                                codedOutputStreamMicro.writeInt32(8, getTurnType());
                            }
                            if (hasWalkType()) {
                                codedOutputStreamMicro.writeInt32(9, getWalkType());
                            }
                            if (hasCircleRoad()) {
                                codedOutputStreamMicro.writeInt32(10, getCircleRoad());
                            }
                        }
                    }

                    public static DetailGuideInfoV2 parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DetailGuideInfoV2().mergeFrom(codedInputStreamMicro);
                    }

                    public static DetailGuideInfoV2 parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DetailGuideInfoV2) new DetailGuideInfoV2().mergeFrom(bArr);
                    }

                    public DetailGuideInfoV2 addBroadcastTemplate(String str) {
                        str.getClass();
                        if (this.broadcastTemplate_.isEmpty()) {
                            this.broadcastTemplate_ = new ArrayList();
                        }
                        this.broadcastTemplate_.add(str);
                        return this;
                    }

                    public DetailGuideInfoV2 addSubInfo(SubGuideInfo subGuideInfo) {
                        if (subGuideInfo == null) {
                            return this;
                        }
                        if (this.subInfo_.isEmpty()) {
                            this.subInfo_ = new ArrayList();
                        }
                        this.subInfo_.add(subGuideInfo);
                        return this;
                    }

                    public final DetailGuideInfoV2 clear() {
                        clearSubInfo();
                        clearBroadcastContentType();
                        clearBroadcastTemplate();
                        clearPrioroty();
                        clearPreDist();
                        clearAfterDist();
                        clearNotifyNpc();
                        clearTurnType();
                        clearWalkType();
                        clearCircleRoad();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DetailGuideInfoV2 clearAfterDist() {
                        this.hasAfterDist = false;
                        this.afterDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearBroadcastContentType() {
                        this.hasBroadcastContentType = false;
                        this.broadcastContentType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearBroadcastTemplate() {
                        this.broadcastTemplate_ = Collections.emptyList();
                        return this;
                    }

                    public DetailGuideInfoV2 clearCircleRoad() {
                        this.hasCircleRoad = false;
                        this.circleRoad_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearNotifyNpc() {
                        this.hasNotifyNpc = false;
                        this.notifyNpc_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearPreDist() {
                        this.hasPreDist = false;
                        this.preDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearPrioroty() {
                        this.hasPrioroty = false;
                        this.prioroty_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearSubInfo() {
                        this.subInfo_ = Collections.emptyList();
                        return this;
                    }

                    public DetailGuideInfoV2 clearTurnType() {
                        this.hasTurnType = false;
                        this.turnType_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV2 clearWalkType() {
                        this.hasWalkType = false;
                        this.walkType_ = 0;
                        return this;
                    }

                    public int getAfterDist() {
                        return this.afterDist_;
                    }

                    public int getBroadcastContentType() {
                        return this.broadcastContentType_;
                    }

                    public String getBroadcastTemplate(int i) {
                        return this.broadcastTemplate_.get(i);
                    }

                    public int getBroadcastTemplateCount() {
                        return this.broadcastTemplate_.size();
                    }

                    public List<String> getBroadcastTemplateList() {
                        return this.broadcastTemplate_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getCircleRoad() {
                        return this.circleRoad_;
                    }

                    public int getNotifyNpc() {
                        return this.notifyNpc_;
                    }

                    public int getPreDist() {
                        return this.preDist_;
                    }

                    public int getPrioroty() {
                        return this.prioroty_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        Iterator<SubGuideInfo> it = getSubInfoList().iterator();
                        int iComputeStringSizeNoTag = 0;
                        int iComputeInt32Size = 0;
                        while (it.hasNext()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(1, it.next());
                        }
                        if (hasBroadcastContentType()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getBroadcastContentType());
                        }
                        Iterator<String> it2 = getBroadcastTemplateList().iterator();
                        while (it2.hasNext()) {
                            iComputeStringSizeNoTag += CodedOutputStreamMicro.computeStringSizeNoTag(it2.next());
                        }
                        int size = iComputeInt32Size + iComputeStringSizeNoTag + (getBroadcastTemplateList().size() * 1);
                        if (hasPrioroty()) {
                            size += CodedOutputStreamMicro.computeInt32Size(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            size += CodedOutputStreamMicro.computeInt32Size(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            size += CodedOutputStreamMicro.computeInt32Size(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            size += CodedOutputStreamMicro.computeInt32Size(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            size += CodedOutputStreamMicro.computeInt32Size(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            size += CodedOutputStreamMicro.computeInt32Size(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            size += CodedOutputStreamMicro.computeInt32Size(10, getCircleRoad());
                        }
                        this.cachedSize = size;
                        return size;
                    }

                    public SubGuideInfo getSubInfo(int i) {
                        return this.subInfo_.get(i);
                    }

                    public int getSubInfoCount() {
                        return this.subInfo_.size();
                    }

                    public List<SubGuideInfo> getSubInfoList() {
                        return this.subInfo_;
                    }

                    public int getTurnType() {
                        return this.turnType_;
                    }

                    public int getWalkType() {
                        return this.walkType_;
                    }

                    public boolean hasAfterDist() {
                        return this.hasAfterDist;
                    }

                    public boolean hasBroadcastContentType() {
                        return this.hasBroadcastContentType;
                    }

                    public boolean hasCircleRoad() {
                        return this.hasCircleRoad;
                    }

                    public boolean hasNotifyNpc() {
                        return this.hasNotifyNpc;
                    }

                    public boolean hasPreDist() {
                        return this.hasPreDist;
                    }

                    public boolean hasPrioroty() {
                        return this.hasPrioroty;
                    }

                    public boolean hasTurnType() {
                        return this.hasTurnType;
                    }

                    public boolean hasWalkType() {
                        return this.hasWalkType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DetailGuideInfoV2 mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            switch (tag) {
                                case 0:
                                    return this;
                                case 10:
                                    SubGuideInfo subGuideInfo = new SubGuideInfo();
                                    codedInputStreamMicro.readMessage(subGuideInfo);
                                    addSubInfo(subGuideInfo);
                                    break;
                                case 16:
                                    setBroadcastContentType(codedInputStreamMicro.readInt32());
                                    break;
                                case 26:
                                    addBroadcastTemplate(codedInputStreamMicro.readString());
                                    break;
                                case 32:
                                    setPrioroty(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    setPreDist(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    setAfterDist(codedInputStreamMicro.readInt32());
                                    break;
                                case 56:
                                    setNotifyNpc(codedInputStreamMicro.readInt32());
                                    break;
                                case 64:
                                    setTurnType(codedInputStreamMicro.readInt32());
                                    break;
                                case 72:
                                    setWalkType(codedInputStreamMicro.readInt32());
                                    break;
                                case 80:
                                    setCircleRoad(codedInputStreamMicro.readInt32());
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                        return this;
                                    }
                                    break;
                                    break;
                            }
                        }
                    }

                    public DetailGuideInfoV2 setAfterDist(int i) {
                        this.hasAfterDist = true;
                        this.afterDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setBroadcastContentType(int i) {
                        this.hasBroadcastContentType = true;
                        this.broadcastContentType_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setBroadcastTemplate(int i, String str) {
                        str.getClass();
                        this.broadcastTemplate_.set(i, str);
                        return this;
                    }

                    public DetailGuideInfoV2 setCircleRoad(int i) {
                        this.hasCircleRoad = true;
                        this.circleRoad_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setNotifyNpc(int i) {
                        this.hasNotifyNpc = true;
                        this.notifyNpc_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setPreDist(int i) {
                        this.hasPreDist = true;
                        this.preDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setPrioroty(int i) {
                        this.hasPrioroty = true;
                        this.prioroty_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setSubInfo(int i, SubGuideInfo subGuideInfo) {
                        if (subGuideInfo == null) {
                            return this;
                        }
                        this.subInfo_.set(i, subGuideInfo);
                        return this;
                    }

                    public DetailGuideInfoV2 setTurnType(int i) {
                        this.hasTurnType = true;
                        this.turnType_ = i;
                        return this;
                    }

                    public DetailGuideInfoV2 setWalkType(int i) {
                        this.hasWalkType = true;
                        this.walkType_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        Iterator<SubGuideInfo> it = getSubInfoList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(1, it.next());
                        }
                        if (hasBroadcastContentType()) {
                            codedOutputStreamMicro.writeInt32(2, getBroadcastContentType());
                        }
                        Iterator<String> it2 = getBroadcastTemplateList().iterator();
                        while (it2.hasNext()) {
                            codedOutputStreamMicro.writeString(3, it2.next());
                        }
                        if (hasPrioroty()) {
                            codedOutputStreamMicro.writeInt32(4, getPrioroty());
                        }
                        if (hasPreDist()) {
                            codedOutputStreamMicro.writeInt32(5, getPreDist());
                        }
                        if (hasAfterDist()) {
                            codedOutputStreamMicro.writeInt32(6, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            codedOutputStreamMicro.writeInt32(7, getNotifyNpc());
                        }
                        if (hasTurnType()) {
                            codedOutputStreamMicro.writeInt32(8, getTurnType());
                        }
                        if (hasWalkType()) {
                            codedOutputStreamMicro.writeInt32(9, getWalkType());
                        }
                        if (hasCircleRoad()) {
                            codedOutputStreamMicro.writeInt32(10, getCircleRoad());
                        }
                    }
                }

                public static final class DetailGuideInfoV3 extends MessageMicro {
                    public static final int ADD_DIST_FIELD_NUMBER = 2;
                    public static final int AFTER_DIST_FIELD_NUMBER = 5;
                    public static final int BROADCAST_TEMPLATE_FIELD_NUMBER = 1;
                    public static final int NOTIFY_NPC_FIELD_NUMBER = 6;
                    public static final int PRE_DIST_FIELD_NUMBER = 4;
                    public static final int PRIOROTY_FIELD_NUMBER = 3;
                    public static final int VIBRATE_FIELD_NUMBER = 7;
                    private boolean hasAddDist;
                    private boolean hasAfterDist;
                    private boolean hasBroadcastTemplate;
                    private boolean hasNotifyNpc;
                    private boolean hasPreDist;
                    private boolean hasPrioroty;
                    private boolean hasVibrate;
                    private String broadcastTemplate_ = "";
                    private int addDist_ = 0;
                    private int prioroty_ = 0;
                    private int preDist_ = 0;
                    private int afterDist_ = 0;
                    private int notifyNpc_ = 0;
                    private int vibrate_ = 0;
                    private int cachedSize = -1;

                    public static DetailGuideInfoV3 parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new DetailGuideInfoV3().mergeFrom(codedInputStreamMicro);
                    }

                    public static DetailGuideInfoV3 parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (DetailGuideInfoV3) new DetailGuideInfoV3().mergeFrom(bArr);
                    }

                    public final DetailGuideInfoV3 clear() {
                        clearBroadcastTemplate();
                        clearAddDist();
                        clearPrioroty();
                        clearPreDist();
                        clearAfterDist();
                        clearNotifyNpc();
                        clearVibrate();
                        this.cachedSize = -1;
                        return this;
                    }

                    public DetailGuideInfoV3 clearAddDist() {
                        this.hasAddDist = false;
                        this.addDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearAfterDist() {
                        this.hasAfterDist = false;
                        this.afterDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearBroadcastTemplate() {
                        this.hasBroadcastTemplate = false;
                        this.broadcastTemplate_ = "";
                        return this;
                    }

                    public DetailGuideInfoV3 clearNotifyNpc() {
                        this.hasNotifyNpc = false;
                        this.notifyNpc_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearPreDist() {
                        this.hasPreDist = false;
                        this.preDist_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearPrioroty() {
                        this.hasPrioroty = false;
                        this.prioroty_ = 0;
                        return this;
                    }

                    public DetailGuideInfoV3 clearVibrate() {
                        this.hasVibrate = false;
                        this.vibrate_ = 0;
                        return this;
                    }

                    public int getAddDist() {
                        return this.addDist_;
                    }

                    public int getAfterDist() {
                        return this.afterDist_;
                    }

                    public String getBroadcastTemplate() {
                        return this.broadcastTemplate_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getNotifyNpc() {
                        return this.notifyNpc_;
                    }

                    public int getPreDist() {
                        return this.preDist_;
                    }

                    public int getPrioroty() {
                        return this.prioroty_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasBroadcastTemplate() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getBroadcastTemplate()) : 0;
                        if (hasAddDist()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getAddDist());
                        }
                        if (hasPrioroty()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getPrioroty());
                        }
                        if (hasPreDist()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getPreDist());
                        }
                        if (hasAfterDist()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getNotifyNpc());
                        }
                        if (hasVibrate()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getVibrate());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public int getVibrate() {
                        return this.vibrate_;
                    }

                    public boolean hasAddDist() {
                        return this.hasAddDist;
                    }

                    public boolean hasAfterDist() {
                        return this.hasAfterDist;
                    }

                    public boolean hasBroadcastTemplate() {
                        return this.hasBroadcastTemplate;
                    }

                    public boolean hasNotifyNpc() {
                        return this.hasNotifyNpc;
                    }

                    public boolean hasPreDist() {
                        return this.hasPreDist;
                    }

                    public boolean hasPrioroty() {
                        return this.hasPrioroty;
                    }

                    public boolean hasVibrate() {
                        return this.hasVibrate;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public DetailGuideInfoV3 mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 10) {
                                setBroadcastTemplate(codedInputStreamMicro.readString());
                            } else if (tag == 16) {
                                setAddDist(codedInputStreamMicro.readInt32());
                            } else if (tag == 24) {
                                setPrioroty(codedInputStreamMicro.readInt32());
                            } else if (tag == 32) {
                                setPreDist(codedInputStreamMicro.readInt32());
                            } else if (tag == 40) {
                                setAfterDist(codedInputStreamMicro.readInt32());
                            } else if (tag == 48) {
                                setNotifyNpc(codedInputStreamMicro.readInt32());
                            } else if (tag == 56) {
                                setVibrate(codedInputStreamMicro.readInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public DetailGuideInfoV3 setAddDist(int i) {
                        this.hasAddDist = true;
                        this.addDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV3 setAfterDist(int i) {
                        this.hasAfterDist = true;
                        this.afterDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV3 setBroadcastTemplate(String str) {
                        this.hasBroadcastTemplate = true;
                        this.broadcastTemplate_ = str;
                        return this;
                    }

                    public DetailGuideInfoV3 setNotifyNpc(int i) {
                        this.hasNotifyNpc = true;
                        this.notifyNpc_ = i;
                        return this;
                    }

                    public DetailGuideInfoV3 setPreDist(int i) {
                        this.hasPreDist = true;
                        this.preDist_ = i;
                        return this;
                    }

                    public DetailGuideInfoV3 setPrioroty(int i) {
                        this.hasPrioroty = true;
                        this.prioroty_ = i;
                        return this;
                    }

                    public DetailGuideInfoV3 setVibrate(int i) {
                        this.hasVibrate = true;
                        this.vibrate_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasBroadcastTemplate()) {
                            codedOutputStreamMicro.writeString(1, getBroadcastTemplate());
                        }
                        if (hasAddDist()) {
                            codedOutputStreamMicro.writeInt32(2, getAddDist());
                        }
                        if (hasPrioroty()) {
                            codedOutputStreamMicro.writeInt32(3, getPrioroty());
                        }
                        if (hasPreDist()) {
                            codedOutputStreamMicro.writeInt32(4, getPreDist());
                        }
                        if (hasAfterDist()) {
                            codedOutputStreamMicro.writeInt32(5, getAfterDist());
                        }
                        if (hasNotifyNpc()) {
                            codedOutputStreamMicro.writeInt32(6, getNotifyNpc());
                        }
                        if (hasVibrate()) {
                            codedOutputStreamMicro.writeInt32(7, getVibrate());
                        }
                    }
                }

                public static final class Links extends MessageMicro {
                    public static final int FCROSS_DIS_TO_TURN_FIELD_NUMBER = 8;
                    public static final int FCROSS_NUM_TO_TURN_FIELD_NUMBER = 7;
                    public static final int HAS_PANID_FIELD_NUMBER = 4;
                    public static final int IDX_FIELD_NUMBER = 2;
                    public static final int ID_FIELD_NUMBER = 1;
                    public static final int INNER_CROSS_LINK_FIELD_NUMBER = 12;
                    public static final int IS_BIND_TRAFFIC_LIGHT_FIELD_NUMBER = 13;
                    public static final int LENGTH_FIELD_NUMBER = 3;
                    public static final int LINK_ATTR_FIELD_NUMBER = 6;
                    public static final int LINK_TYPE_FIELD_NUMBER = 5;
                    public static final int ROAD_LEVEL_FIELD_NUMBER = 9;
                    public static final int ROAD_WIDTH_FIELD_NUMBER = 10;
                    public static final int TRAFFIC_LIGHT_FIELD_NUMBER = 11;
                    public static final int TURN_LEFT_LAMP_INFO_FIELD_NUMBER = 14;
                    private boolean hasFcrossDisToTurn;
                    private boolean hasFcrossNumToTurn;
                    private boolean hasHasPanid;
                    private boolean hasId;
                    private boolean hasIdx;
                    private boolean hasInnerCrossLink;
                    private boolean hasIsBindTrafficLight;
                    private boolean hasLength;
                    private boolean hasLinkAttr;
                    private boolean hasLinkType;
                    private boolean hasRoadLevel;
                    private boolean hasRoadWidth;
                    private boolean hasTrafficLight;
                    private boolean hasTurnLeftLampInfo;
                    private String id_ = "";
                    private int idx_ = 0;
                    private int length_ = 0;
                    private int hasPanid_ = 0;
                    private int linkType_ = 0;
                    private int linkAttr_ = 0;
                    private int fcrossNumToTurn_ = 0;
                    private int fcrossDisToTurn_ = 0;
                    private int roadLevel_ = 0;
                    private int roadWidth_ = 0;
                    private int trafficLight_ = 0;
                    private int innerCrossLink_ = 0;
                    private int isBindTrafficLight_ = 0;
                    private TurnLeftLampInfo turnLeftLampInfo_ = null;
                    private int cachedSize = -1;

                    public static final class TurnLeftLampInfo extends MessageMicro {
                        public static final int TURN_LEFT_LAMP_LINKID_FIELD_NUMBER = 2;
                        public static final int TURN_LEFT_ROUTE_LINKID_FIELD_NUMBER = 1;
                        private boolean hasTurnLeftLampLinkid;
                        private boolean hasTurnLeftRouteLinkid;
                        private String turnLeftRouteLinkid_ = "";
                        private String turnLeftLampLinkid_ = "";
                        private int cachedSize = -1;

                        public static TurnLeftLampInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new TurnLeftLampInfo().mergeFrom(codedInputStreamMicro);
                        }

                        public static TurnLeftLampInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (TurnLeftLampInfo) new TurnLeftLampInfo().mergeFrom(bArr);
                        }

                        public final TurnLeftLampInfo clear() {
                            clearTurnLeftRouteLinkid();
                            clearTurnLeftLampLinkid();
                            this.cachedSize = -1;
                            return this;
                        }

                        public TurnLeftLampInfo clearTurnLeftLampLinkid() {
                            this.hasTurnLeftLampLinkid = false;
                            this.turnLeftLampLinkid_ = "";
                            return this;
                        }

                        public TurnLeftLampInfo clearTurnLeftRouteLinkid() {
                            this.hasTurnLeftRouteLinkid = false;
                            this.turnLeftRouteLinkid_ = "";
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int iComputeStringSize = hasTurnLeftRouteLinkid() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getTurnLeftRouteLinkid()) : 0;
                            if (hasTurnLeftLampLinkid()) {
                                iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getTurnLeftLampLinkid());
                            }
                            this.cachedSize = iComputeStringSize;
                            return iComputeStringSize;
                        }

                        public String getTurnLeftLampLinkid() {
                            return this.turnLeftLampLinkid_;
                        }

                        public String getTurnLeftRouteLinkid() {
                            return this.turnLeftRouteLinkid_;
                        }

                        public boolean hasTurnLeftLampLinkid() {
                            return this.hasTurnLeftLampLinkid;
                        }

                        public boolean hasTurnLeftRouteLinkid() {
                            return this.hasTurnLeftRouteLinkid;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public TurnLeftLampInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int tag = codedInputStreamMicro.readTag();
                                if (tag == 0) {
                                    return this;
                                }
                                if (tag == 10) {
                                    setTurnLeftRouteLinkid(codedInputStreamMicro.readString());
                                } else if (tag == 18) {
                                    setTurnLeftLampLinkid(codedInputStreamMicro.readString());
                                } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                    return this;
                                }
                            }
                        }

                        public TurnLeftLampInfo setTurnLeftLampLinkid(String str) {
                            this.hasTurnLeftLampLinkid = true;
                            this.turnLeftLampLinkid_ = str;
                            return this;
                        }

                        public TurnLeftLampInfo setTurnLeftRouteLinkid(String str) {
                            this.hasTurnLeftRouteLinkid = true;
                            this.turnLeftRouteLinkid_ = str;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasTurnLeftRouteLinkid()) {
                                codedOutputStreamMicro.writeString(1, getTurnLeftRouteLinkid());
                            }
                            if (hasTurnLeftLampLinkid()) {
                                codedOutputStreamMicro.writeString(2, getTurnLeftLampLinkid());
                            }
                        }
                    }

                    public static Links parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Links().mergeFrom(codedInputStreamMicro);
                    }

                    public static Links parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Links) new Links().mergeFrom(bArr);
                    }

                    public final Links clear() {
                        clearId();
                        clearIdx();
                        clearLength();
                        clearHasPanid();
                        clearLinkType();
                        clearLinkAttr();
                        clearFcrossNumToTurn();
                        clearFcrossDisToTurn();
                        clearRoadLevel();
                        clearRoadWidth();
                        clearTrafficLight();
                        clearInnerCrossLink();
                        clearIsBindTrafficLight();
                        clearTurnLeftLampInfo();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Links clearFcrossDisToTurn() {
                        this.hasFcrossDisToTurn = false;
                        this.fcrossDisToTurn_ = 0;
                        return this;
                    }

                    public Links clearFcrossNumToTurn() {
                        this.hasFcrossNumToTurn = false;
                        this.fcrossNumToTurn_ = 0;
                        return this;
                    }

                    public Links clearHasPanid() {
                        this.hasHasPanid = false;
                        this.hasPanid_ = 0;
                        return this;
                    }

                    public Links clearId() {
                        this.hasId = false;
                        this.id_ = "";
                        return this;
                    }

                    public Links clearIdx() {
                        this.hasIdx = false;
                        this.idx_ = 0;
                        return this;
                    }

                    public Links clearInnerCrossLink() {
                        this.hasInnerCrossLink = false;
                        this.innerCrossLink_ = 0;
                        return this;
                    }

                    public Links clearIsBindTrafficLight() {
                        this.hasIsBindTrafficLight = false;
                        this.isBindTrafficLight_ = 0;
                        return this;
                    }

                    public Links clearLength() {
                        this.hasLength = false;
                        this.length_ = 0;
                        return this;
                    }

                    public Links clearLinkAttr() {
                        this.hasLinkAttr = false;
                        this.linkAttr_ = 0;
                        return this;
                    }

                    public Links clearLinkType() {
                        this.hasLinkType = false;
                        this.linkType_ = 0;
                        return this;
                    }

                    public Links clearRoadLevel() {
                        this.hasRoadLevel = false;
                        this.roadLevel_ = 0;
                        return this;
                    }

                    public Links clearRoadWidth() {
                        this.hasRoadWidth = false;
                        this.roadWidth_ = 0;
                        return this;
                    }

                    public Links clearTrafficLight() {
                        this.hasTrafficLight = false;
                        this.trafficLight_ = 0;
                        return this;
                    }

                    public Links clearTurnLeftLampInfo() {
                        this.hasTurnLeftLampInfo = false;
                        this.turnLeftLampInfo_ = null;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getFcrossDisToTurn() {
                        return this.fcrossDisToTurn_;
                    }

                    public int getFcrossNumToTurn() {
                        return this.fcrossNumToTurn_;
                    }

                    public int getHasPanid() {
                        return this.hasPanid_;
                    }

                    public String getId() {
                        return this.id_;
                    }

                    public int getIdx() {
                        return this.idx_;
                    }

                    public int getInnerCrossLink() {
                        return this.innerCrossLink_;
                    }

                    public int getIsBindTrafficLight() {
                        return this.isBindTrafficLight_;
                    }

                    public int getLength() {
                        return this.length_;
                    }

                    public int getLinkAttr() {
                        return this.linkAttr_;
                    }

                    public int getLinkType() {
                        return this.linkType_;
                    }

                    public int getRoadLevel() {
                        return this.roadLevel_;
                    }

                    public int getRoadWidth() {
                        return this.roadWidth_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getId()) : 0;
                        if (hasIdx()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getIdx());
                        }
                        if (hasLength()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(3, getLength());
                        }
                        if (hasHasPanid()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getHasPanid());
                        }
                        if (hasLinkType()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(5, getLinkType());
                        }
                        if (hasLinkAttr()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(6, getLinkAttr());
                        }
                        if (hasFcrossNumToTurn()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(7, getFcrossNumToTurn());
                        }
                        if (hasFcrossDisToTurn()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(8, getFcrossDisToTurn());
                        }
                        if (hasRoadLevel()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(9, getRoadLevel());
                        }
                        if (hasRoadWidth()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(10, getRoadWidth());
                        }
                        if (hasTrafficLight()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(11, getTrafficLight());
                        }
                        if (hasInnerCrossLink()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(12, getInnerCrossLink());
                        }
                        if (hasIsBindTrafficLight()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(13, getIsBindTrafficLight());
                        }
                        if (hasTurnLeftLampInfo()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeMessageSize(14, getTurnLeftLampInfo());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public int getTrafficLight() {
                        return this.trafficLight_;
                    }

                    public TurnLeftLampInfo getTurnLeftLampInfo() {
                        return this.turnLeftLampInfo_;
                    }

                    public boolean hasFcrossDisToTurn() {
                        return this.hasFcrossDisToTurn;
                    }

                    public boolean hasFcrossNumToTurn() {
                        return this.hasFcrossNumToTurn;
                    }

                    public boolean hasHasPanid() {
                        return this.hasHasPanid;
                    }

                    public boolean hasId() {
                        return this.hasId;
                    }

                    public boolean hasIdx() {
                        return this.hasIdx;
                    }

                    public boolean hasInnerCrossLink() {
                        return this.hasInnerCrossLink;
                    }

                    public boolean hasIsBindTrafficLight() {
                        return this.hasIsBindTrafficLight;
                    }

                    public boolean hasLength() {
                        return this.hasLength;
                    }

                    public boolean hasLinkAttr() {
                        return this.hasLinkAttr;
                    }

                    public boolean hasLinkType() {
                        return this.hasLinkType;
                    }

                    public boolean hasRoadLevel() {
                        return this.hasRoadLevel;
                    }

                    public boolean hasRoadWidth() {
                        return this.hasRoadWidth;
                    }

                    public boolean hasTrafficLight() {
                        return this.hasTrafficLight;
                    }

                    public boolean hasTurnLeftLampInfo() {
                        return this.hasTurnLeftLampInfo;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Links mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            switch (tag) {
                                case 0:
                                    return this;
                                case 10:
                                    setId(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    setIdx(codedInputStreamMicro.readInt32());
                                    break;
                                case 24:
                                    setLength(codedInputStreamMicro.readInt32());
                                    break;
                                case 32:
                                    setHasPanid(codedInputStreamMicro.readInt32());
                                    break;
                                case 40:
                                    setLinkType(codedInputStreamMicro.readInt32());
                                    break;
                                case 48:
                                    setLinkAttr(codedInputStreamMicro.readInt32());
                                    break;
                                case 56:
                                    setFcrossNumToTurn(codedInputStreamMicro.readInt32());
                                    break;
                                case 64:
                                    setFcrossDisToTurn(codedInputStreamMicro.readInt32());
                                    break;
                                case 72:
                                    setRoadLevel(codedInputStreamMicro.readInt32());
                                    break;
                                case 80:
                                    setRoadWidth(codedInputStreamMicro.readInt32());
                                    break;
                                case 88:
                                    setTrafficLight(codedInputStreamMicro.readInt32());
                                    break;
                                case 96:
                                    setInnerCrossLink(codedInputStreamMicro.readInt32());
                                    break;
                                case 104:
                                    setIsBindTrafficLight(codedInputStreamMicro.readInt32());
                                    break;
                                case 114:
                                    TurnLeftLampInfo turnLeftLampInfo = new TurnLeftLampInfo();
                                    codedInputStreamMicro.readMessage(turnLeftLampInfo);
                                    setTurnLeftLampInfo(turnLeftLampInfo);
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                        return this;
                                    }
                                    break;
                                    break;
                            }
                        }
                    }

                    public Links setFcrossDisToTurn(int i) {
                        this.hasFcrossDisToTurn = true;
                        this.fcrossDisToTurn_ = i;
                        return this;
                    }

                    public Links setFcrossNumToTurn(int i) {
                        this.hasFcrossNumToTurn = true;
                        this.fcrossNumToTurn_ = i;
                        return this;
                    }

                    public Links setHasPanid(int i) {
                        this.hasHasPanid = true;
                        this.hasPanid_ = i;
                        return this;
                    }

                    public Links setId(String str) {
                        this.hasId = true;
                        this.id_ = str;
                        return this;
                    }

                    public Links setIdx(int i) {
                        this.hasIdx = true;
                        this.idx_ = i;
                        return this;
                    }

                    public Links setInnerCrossLink(int i) {
                        this.hasInnerCrossLink = true;
                        this.innerCrossLink_ = i;
                        return this;
                    }

                    public Links setIsBindTrafficLight(int i) {
                        this.hasIsBindTrafficLight = true;
                        this.isBindTrafficLight_ = i;
                        return this;
                    }

                    public Links setLength(int i) {
                        this.hasLength = true;
                        this.length_ = i;
                        return this;
                    }

                    public Links setLinkAttr(int i) {
                        this.hasLinkAttr = true;
                        this.linkAttr_ = i;
                        return this;
                    }

                    public Links setLinkType(int i) {
                        this.hasLinkType = true;
                        this.linkType_ = i;
                        return this;
                    }

                    public Links setRoadLevel(int i) {
                        this.hasRoadLevel = true;
                        this.roadLevel_ = i;
                        return this;
                    }

                    public Links setRoadWidth(int i) {
                        this.hasRoadWidth = true;
                        this.roadWidth_ = i;
                        return this;
                    }

                    public Links setTrafficLight(int i) {
                        this.hasTrafficLight = true;
                        this.trafficLight_ = i;
                        return this;
                    }

                    public Links setTurnLeftLampInfo(TurnLeftLampInfo turnLeftLampInfo) {
                        if (turnLeftLampInfo == null) {
                            return clearTurnLeftLampInfo();
                        }
                        this.hasTurnLeftLampInfo = true;
                        this.turnLeftLampInfo_ = turnLeftLampInfo;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasId()) {
                            codedOutputStreamMicro.writeString(1, getId());
                        }
                        if (hasIdx()) {
                            codedOutputStreamMicro.writeInt32(2, getIdx());
                        }
                        if (hasLength()) {
                            codedOutputStreamMicro.writeInt32(3, getLength());
                        }
                        if (hasHasPanid()) {
                            codedOutputStreamMicro.writeInt32(4, getHasPanid());
                        }
                        if (hasLinkType()) {
                            codedOutputStreamMicro.writeInt32(5, getLinkType());
                        }
                        if (hasLinkAttr()) {
                            codedOutputStreamMicro.writeInt32(6, getLinkAttr());
                        }
                        if (hasFcrossNumToTurn()) {
                            codedOutputStreamMicro.writeInt32(7, getFcrossNumToTurn());
                        }
                        if (hasFcrossDisToTurn()) {
                            codedOutputStreamMicro.writeInt32(8, getFcrossDisToTurn());
                        }
                        if (hasRoadLevel()) {
                            codedOutputStreamMicro.writeInt32(9, getRoadLevel());
                        }
                        if (hasRoadWidth()) {
                            codedOutputStreamMicro.writeInt32(10, getRoadWidth());
                        }
                        if (hasTrafficLight()) {
                            codedOutputStreamMicro.writeInt32(11, getTrafficLight());
                        }
                        if (hasInnerCrossLink()) {
                            codedOutputStreamMicro.writeInt32(12, getInnerCrossLink());
                        }
                        if (hasIsBindTrafficLight()) {
                            codedOutputStreamMicro.writeInt32(13, getIsBindTrafficLight());
                        }
                        if (hasTurnLeftLampInfo()) {
                            codedOutputStreamMicro.writeMessage(14, getTurnLeftLampInfo());
                        }
                    }
                }

                public static final class Pois extends MessageMicro {
                    public static final int DISPLAY_PT_FIELD_NUMBER = 8;
                    public static final int DIST_TO_STEP_ST_FIELD_NUMBER = 17;
                    public static final int END_ADDDIST_FIELD_NUMBER = 15;
                    public static final int FACE_PICTURE_URL_FIELD_NUMBER = 10;
                    public static final int FACE_PIC_LONG_FIELD_NUMBER = 12;
                    public static final int FACE_PIC_WIDE_FIELD_NUMBER = 13;
                    public static final int HEADING_FIELD_NUMBER = 4;
                    public static final int ICON_URL_FIELD_NUMBER = 9;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int PANOID_FIELD_NUMBER = 6;
                    public static final int PITCH_FIELD_NUMBER = 5;
                    public static final int SIDE_FIELD_NUMBER = 3;
                    public static final int SLOCATION_FIELD_NUMBER = 2;
                    public static final int START_ADDDIST_FIELD_NUMBER = 14;
                    public static final int STD_TAG_FIELD_NUMBER = 11;
                    public static final int TYPE_FIELD_NUMBER = 16;
                    public static final int UID_FIELD_NUMBER = 7;
                    private boolean hasDistToStepSt;
                    private boolean hasEndAdddist;
                    private boolean hasFacePicLong;
                    private boolean hasFacePicWide;
                    private boolean hasFacePictureUrl;
                    private boolean hasHeading;
                    private boolean hasIconUrl;
                    private boolean hasName;
                    private boolean hasPanoid;
                    private boolean hasPitch;
                    private boolean hasSide;
                    private boolean hasStartAdddist;
                    private boolean hasStdTag;
                    private boolean hasType;
                    private boolean hasUid;
                    private String name_ = "";
                    private List<Integer> slocation_ = Collections.emptyList();
                    private int side_ = 0;
                    private String heading_ = "";
                    private String pitch_ = "";
                    private String panoid_ = "";
                    private String uid_ = "";
                    private List<Integer> displayPt_ = Collections.emptyList();
                    private String iconUrl_ = "";
                    private String facePictureUrl_ = "";
                    private String stdTag_ = "";
                    private int facePicLong_ = 0;
                    private int facePicWide_ = 0;
                    private int startAdddist_ = 0;
                    private int endAdddist_ = 0;
                    private int type_ = 0;
                    private int distToStepSt_ = 0;
                    private int cachedSize = -1;

                    public static Pois parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Pois().mergeFrom(codedInputStreamMicro);
                    }

                    public static Pois parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Pois) new Pois().mergeFrom(bArr);
                    }

                    public Pois addDisplayPt(int i) {
                        if (this.displayPt_.isEmpty()) {
                            this.displayPt_ = new ArrayList();
                        }
                        this.displayPt_.add(Integer.valueOf(i));
                        return this;
                    }

                    public Pois addSlocation(int i) {
                        if (this.slocation_.isEmpty()) {
                            this.slocation_ = new ArrayList();
                        }
                        this.slocation_.add(Integer.valueOf(i));
                        return this;
                    }

                    public final Pois clear() {
                        clearName();
                        clearSlocation();
                        clearSide();
                        clearHeading();
                        clearPitch();
                        clearPanoid();
                        clearUid();
                        clearDisplayPt();
                        clearIconUrl();
                        clearFacePictureUrl();
                        clearStdTag();
                        clearFacePicLong();
                        clearFacePicWide();
                        clearStartAdddist();
                        clearEndAdddist();
                        clearType();
                        clearDistToStepSt();
                        this.cachedSize = -1;
                        return this;
                    }

                    public Pois clearDisplayPt() {
                        this.displayPt_ = Collections.emptyList();
                        return this;
                    }

                    public Pois clearDistToStepSt() {
                        this.hasDistToStepSt = false;
                        this.distToStepSt_ = 0;
                        return this;
                    }

                    public Pois clearEndAdddist() {
                        this.hasEndAdddist = false;
                        this.endAdddist_ = 0;
                        return this;
                    }

                    public Pois clearFacePicLong() {
                        this.hasFacePicLong = false;
                        this.facePicLong_ = 0;
                        return this;
                    }

                    public Pois clearFacePicWide() {
                        this.hasFacePicWide = false;
                        this.facePicWide_ = 0;
                        return this;
                    }

                    public Pois clearFacePictureUrl() {
                        this.hasFacePictureUrl = false;
                        this.facePictureUrl_ = "";
                        return this;
                    }

                    public Pois clearHeading() {
                        this.hasHeading = false;
                        this.heading_ = "";
                        return this;
                    }

                    public Pois clearIconUrl() {
                        this.hasIconUrl = false;
                        this.iconUrl_ = "";
                        return this;
                    }

                    public Pois clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public Pois clearPanoid() {
                        this.hasPanoid = false;
                        this.panoid_ = "";
                        return this;
                    }

                    public Pois clearPitch() {
                        this.hasPitch = false;
                        this.pitch_ = "";
                        return this;
                    }

                    public Pois clearSide() {
                        this.hasSide = false;
                        this.side_ = 0;
                        return this;
                    }

                    public Pois clearSlocation() {
                        this.slocation_ = Collections.emptyList();
                        return this;
                    }

                    public Pois clearStartAdddist() {
                        this.hasStartAdddist = false;
                        this.startAdddist_ = 0;
                        return this;
                    }

                    public Pois clearStdTag() {
                        this.hasStdTag = false;
                        this.stdTag_ = "";
                        return this;
                    }

                    public Pois clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    public Pois clearUid() {
                        this.hasUid = false;
                        this.uid_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public int getDisplayPt(int i) {
                        return this.displayPt_.get(i).intValue();
                    }

                    public int getDisplayPtCount() {
                        return this.displayPt_.size();
                    }

                    public List<Integer> getDisplayPtList() {
                        return this.displayPt_;
                    }

                    public int getDistToStepSt() {
                        return this.distToStepSt_;
                    }

                    public int getEndAdddist() {
                        return this.endAdddist_;
                    }

                    public int getFacePicLong() {
                        return this.facePicLong_;
                    }

                    public int getFacePicWide() {
                        return this.facePicWide_;
                    }

                    public String getFacePictureUrl() {
                        return this.facePictureUrl_;
                    }

                    public String getHeading() {
                        return this.heading_;
                    }

                    public String getIconUrl() {
                        return this.iconUrl_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    public String getPanoid() {
                        return this.panoid_;
                    }

                    public String getPitch() {
                        return this.pitch_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeSInt32SizeNoTag = 0;
                        int iComputeStringSize = hasName() ? CodedOutputStreamMicro.computeStringSize(1, getName()) + 0 : 0;
                        Iterator<Integer> it = getSlocationList().iterator();
                        int iComputeSInt32SizeNoTag2 = 0;
                        while (it.hasNext()) {
                            iComputeSInt32SizeNoTag2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                        }
                        int size = iComputeStringSize + iComputeSInt32SizeNoTag2 + (getSlocationList().size() * 1);
                        if (hasSide()) {
                            size += CodedOutputStreamMicro.computeInt32Size(3, getSide());
                        }
                        if (hasHeading()) {
                            size += CodedOutputStreamMicro.computeStringSize(4, getHeading());
                        }
                        if (hasPitch()) {
                            size += CodedOutputStreamMicro.computeStringSize(5, getPitch());
                        }
                        if (hasPanoid()) {
                            size += CodedOutputStreamMicro.computeStringSize(6, getPanoid());
                        }
                        if (hasUid()) {
                            size += CodedOutputStreamMicro.computeStringSize(7, getUid());
                        }
                        Iterator<Integer> it2 = getDisplayPtList().iterator();
                        while (it2.hasNext()) {
                            iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it2.next().intValue());
                        }
                        int size2 = size + iComputeSInt32SizeNoTag + (getDisplayPtList().size() * 1);
                        if (hasIconUrl()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(9, getIconUrl());
                        }
                        if (hasFacePictureUrl()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(10, getFacePictureUrl());
                        }
                        if (hasStdTag()) {
                            size2 += CodedOutputStreamMicro.computeStringSize(11, getStdTag());
                        }
                        if (hasFacePicLong()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(12, getFacePicLong());
                        }
                        if (hasFacePicWide()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(13, getFacePicWide());
                        }
                        if (hasStartAdddist()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(14, getStartAdddist());
                        }
                        if (hasEndAdddist()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(15, getEndAdddist());
                        }
                        if (hasType()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(16, getType());
                        }
                        if (hasDistToStepSt()) {
                            size2 += CodedOutputStreamMicro.computeInt32Size(17, getDistToStepSt());
                        }
                        this.cachedSize = size2;
                        return size2;
                    }

                    public int getSide() {
                        return this.side_;
                    }

                    public int getSlocation(int i) {
                        return this.slocation_.get(i).intValue();
                    }

                    public int getSlocationCount() {
                        return this.slocation_.size();
                    }

                    public List<Integer> getSlocationList() {
                        return this.slocation_;
                    }

                    public int getStartAdddist() {
                        return this.startAdddist_;
                    }

                    public String getStdTag() {
                        return this.stdTag_;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public String getUid() {
                        return this.uid_;
                    }

                    public boolean hasDistToStepSt() {
                        return this.hasDistToStepSt;
                    }

                    public boolean hasEndAdddist() {
                        return this.hasEndAdddist;
                    }

                    public boolean hasFacePicLong() {
                        return this.hasFacePicLong;
                    }

                    public boolean hasFacePicWide() {
                        return this.hasFacePicWide;
                    }

                    public boolean hasFacePictureUrl() {
                        return this.hasFacePictureUrl;
                    }

                    public boolean hasHeading() {
                        return this.hasHeading;
                    }

                    public boolean hasIconUrl() {
                        return this.hasIconUrl;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasPanoid() {
                        return this.hasPanoid;
                    }

                    public boolean hasPitch() {
                        return this.hasPitch;
                    }

                    public boolean hasSide() {
                        return this.hasSide;
                    }

                    public boolean hasStartAdddist() {
                        return this.hasStartAdddist;
                    }

                    public boolean hasStdTag() {
                        return this.hasStdTag;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public boolean hasUid() {
                        return this.hasUid;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public Pois mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            switch (tag) {
                                case 0:
                                    return this;
                                case 10:
                                    setName(codedInputStreamMicro.readString());
                                    break;
                                case 16:
                                    addSlocation(codedInputStreamMicro.readSInt32());
                                    break;
                                case 24:
                                    setSide(codedInputStreamMicro.readInt32());
                                    break;
                                case 34:
                                    setHeading(codedInputStreamMicro.readString());
                                    break;
                                case 42:
                                    setPitch(codedInputStreamMicro.readString());
                                    break;
                                case 50:
                                    setPanoid(codedInputStreamMicro.readString());
                                    break;
                                case 58:
                                    setUid(codedInputStreamMicro.readString());
                                    break;
                                case 64:
                                    addDisplayPt(codedInputStreamMicro.readSInt32());
                                    break;
                                case 74:
                                    setIconUrl(codedInputStreamMicro.readString());
                                    break;
                                case 82:
                                    setFacePictureUrl(codedInputStreamMicro.readString());
                                    break;
                                case 90:
                                    setStdTag(codedInputStreamMicro.readString());
                                    break;
                                case 96:
                                    setFacePicLong(codedInputStreamMicro.readInt32());
                                    break;
                                case 104:
                                    setFacePicWide(codedInputStreamMicro.readInt32());
                                    break;
                                case 112:
                                    setStartAdddist(codedInputStreamMicro.readInt32());
                                    break;
                                case 120:
                                    setEndAdddist(codedInputStreamMicro.readInt32());
                                    break;
                                case 128:
                                    setType(codedInputStreamMicro.readInt32());
                                    break;
                                case 136:
                                    setDistToStepSt(codedInputStreamMicro.readInt32());
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                        return this;
                                    }
                                    break;
                                    break;
                            }
                        }
                    }

                    public Pois setDisplayPt(int i, int i2) {
                        this.displayPt_.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Pois setDistToStepSt(int i) {
                        this.hasDistToStepSt = true;
                        this.distToStepSt_ = i;
                        return this;
                    }

                    public Pois setEndAdddist(int i) {
                        this.hasEndAdddist = true;
                        this.endAdddist_ = i;
                        return this;
                    }

                    public Pois setFacePicLong(int i) {
                        this.hasFacePicLong = true;
                        this.facePicLong_ = i;
                        return this;
                    }

                    public Pois setFacePicWide(int i) {
                        this.hasFacePicWide = true;
                        this.facePicWide_ = i;
                        return this;
                    }

                    public Pois setFacePictureUrl(String str) {
                        this.hasFacePictureUrl = true;
                        this.facePictureUrl_ = str;
                        return this;
                    }

                    public Pois setHeading(String str) {
                        this.hasHeading = true;
                        this.heading_ = str;
                        return this;
                    }

                    public Pois setIconUrl(String str) {
                        this.hasIconUrl = true;
                        this.iconUrl_ = str;
                        return this;
                    }

                    public Pois setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public Pois setPanoid(String str) {
                        this.hasPanoid = true;
                        this.panoid_ = str;
                        return this;
                    }

                    public Pois setPitch(String str) {
                        this.hasPitch = true;
                        this.pitch_ = str;
                        return this;
                    }

                    public Pois setSide(int i) {
                        this.hasSide = true;
                        this.side_ = i;
                        return this;
                    }

                    public Pois setSlocation(int i, int i2) {
                        this.slocation_.set(i, Integer.valueOf(i2));
                        return this;
                    }

                    public Pois setStartAdddist(int i) {
                        this.hasStartAdddist = true;
                        this.startAdddist_ = i;
                        return this;
                    }

                    public Pois setStdTag(String str) {
                        this.hasStdTag = true;
                        this.stdTag_ = str;
                        return this;
                    }

                    public Pois setType(int i) {
                        this.hasType = true;
                        this.type_ = i;
                        return this;
                    }

                    public Pois setUid(String str) {
                        this.hasUid = true;
                        this.uid_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        Iterator<Integer> it = getSlocationList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeSInt32(2, it.next().intValue());
                        }
                        if (hasSide()) {
                            codedOutputStreamMicro.writeInt32(3, getSide());
                        }
                        if (hasHeading()) {
                            codedOutputStreamMicro.writeString(4, getHeading());
                        }
                        if (hasPitch()) {
                            codedOutputStreamMicro.writeString(5, getPitch());
                        }
                        if (hasPanoid()) {
                            codedOutputStreamMicro.writeString(6, getPanoid());
                        }
                        if (hasUid()) {
                            codedOutputStreamMicro.writeString(7, getUid());
                        }
                        Iterator<Integer> it2 = getDisplayPtList().iterator();
                        while (it2.hasNext()) {
                            codedOutputStreamMicro.writeSInt32(8, it2.next().intValue());
                        }
                        if (hasIconUrl()) {
                            codedOutputStreamMicro.writeString(9, getIconUrl());
                        }
                        if (hasFacePictureUrl()) {
                            codedOutputStreamMicro.writeString(10, getFacePictureUrl());
                        }
                        if (hasStdTag()) {
                            codedOutputStreamMicro.writeString(11, getStdTag());
                        }
                        if (hasFacePicLong()) {
                            codedOutputStreamMicro.writeInt32(12, getFacePicLong());
                        }
                        if (hasFacePicWide()) {
                            codedOutputStreamMicro.writeInt32(13, getFacePicWide());
                        }
                        if (hasStartAdddist()) {
                            codedOutputStreamMicro.writeInt32(14, getStartAdddist());
                        }
                        if (hasEndAdddist()) {
                            codedOutputStreamMicro.writeInt32(15, getEndAdddist());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeInt32(16, getType());
                        }
                        if (hasDistToStepSt()) {
                            codedOutputStreamMicro.writeInt32(17, getDistToStepSt());
                        }
                    }
                }

                public static Steps parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Steps().mergeFrom(codedInputStreamMicro);
                }

                public static Steps parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Steps) new Steps().mergeFrom(bArr);
                }

                public Steps addCloudGuideV1(DetailGuideInfoV1 detailGuideInfoV1) {
                    if (detailGuideInfoV1 == null) {
                        return this;
                    }
                    if (this.cloudGuideV1_.isEmpty()) {
                        this.cloudGuideV1_ = new ArrayList();
                    }
                    this.cloudGuideV1_.add(detailGuideInfoV1);
                    return this;
                }

                public Steps addCloudGuideV2(DetailGuideInfoV2 detailGuideInfoV2) {
                    if (detailGuideInfoV2 == null) {
                        return this;
                    }
                    if (this.cloudGuideV2_.isEmpty()) {
                        this.cloudGuideV2_ = new ArrayList();
                    }
                    this.cloudGuideV2_.add(detailGuideInfoV2);
                    return this;
                }

                public Steps addCloudGuideV3(DetailGuideInfoV3 detailGuideInfoV3) {
                    if (detailGuideInfoV3 == null) {
                        return this;
                    }
                    if (this.cloudGuideV3_.isEmpty()) {
                        this.cloudGuideV3_ = new ArrayList();
                    }
                    this.cloudGuideV3_.add(detailGuideInfoV3);
                    return this;
                }

                public Steps addLinks(Links links) {
                    if (links == null) {
                        return this;
                    }
                    if (this.links_.isEmpty()) {
                        this.links_ = new ArrayList();
                    }
                    this.links_.add(links);
                    return this;
                }

                public Steps addPoirefPois(Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    if (this.poirefPois_.isEmpty()) {
                        this.poirefPois_ = new ArrayList();
                    }
                    this.poirefPois_.add(pois);
                    return this;
                }

                public Steps addPois(Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    if (this.pois_.isEmpty()) {
                        this.pois_ = new ArrayList();
                    }
                    this.pois_.add(pois);
                    return this;
                }

                public Steps addSendLocation(int i) {
                    if (this.sendLocation_.isEmpty()) {
                        this.sendLocation_ = new ArrayList();
                    }
                    this.sendLocation_.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSpath(int i) {
                    if (this.spath_.isEmpty()) {
                        this.spath_ = new ArrayList();
                    }
                    this.spath_.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSpath4Navi(int i) {
                    if (this.spath4Navi_.isEmpty()) {
                        this.spath4Navi_ = new ArrayList();
                    }
                    this.spath4Navi_.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addSstartLocation(int i) {
                    if (this.sstartLocation_.isEmpty()) {
                        this.sstartLocation_ = new ArrayList();
                    }
                    this.sstartLocation_.add(Integer.valueOf(i));
                    return this;
                }

                public Steps addStrafficmarkLoc(int i) {
                    if (this.strafficmarkLoc_.isEmpty()) {
                        this.strafficmarkLoc_ = new ArrayList();
                    }
                    this.strafficmarkLoc_.add(Integer.valueOf(i));
                    return this;
                }

                public final Steps clear() {
                    clearLinks();
                    clearPois();
                    clearSpath();
                    clearInstructions();
                    clearType();
                    clearName();
                    clearFirstLinkEndIndex();
                    clearTurnType();
                    clearWalkType();
                    clearLight();
                    clearCircleRoad();
                    clearRoadWidth();
                    clearDistance();
                    clearDuration();
                    clearDirection();
                    clearHasPanid();
                    clearSstartLocation();
                    clearSendLocation();
                    clearStrafficmarkLoc();
                    clearTrafficType();
                    clearSpath4Navi();
                    clearStepStatus();
                    clearPoirefPois();
                    clearCloudGuideV1();
                    clearCloudGuideV2();
                    clearGuideType();
                    clearCloudGuideV3();
                    this.cachedSize = -1;
                    return this;
                }

                public Steps clearCircleRoad() {
                    this.hasCircleRoad = false;
                    this.circleRoad_ = 0;
                    return this;
                }

                public Steps clearCloudGuideV1() {
                    this.cloudGuideV1_ = Collections.emptyList();
                    return this;
                }

                public Steps clearCloudGuideV2() {
                    this.cloudGuideV2_ = Collections.emptyList();
                    return this;
                }

                public Steps clearCloudGuideV3() {
                    this.cloudGuideV3_ = Collections.emptyList();
                    return this;
                }

                public Steps clearDirection() {
                    this.hasDirection = false;
                    this.direction_ = 0;
                    return this;
                }

                public Steps clearDistance() {
                    this.hasDistance = false;
                    this.distance_ = 0;
                    return this;
                }

                public Steps clearDuration() {
                    this.hasDuration = false;
                    this.duration_ = 0;
                    return this;
                }

                public Steps clearFirstLinkEndIndex() {
                    this.hasFirstLinkEndIndex = false;
                    this.firstLinkEndIndex_ = 0;
                    return this;
                }

                public Steps clearGuideType() {
                    this.hasGuideType = false;
                    this.guideType_ = 0;
                    return this;
                }

                public Steps clearHasPanid() {
                    this.hasHasPanid = false;
                    this.hasPanid_ = 0;
                    return this;
                }

                public Steps clearInstructions() {
                    this.hasInstructions = false;
                    this.instructions_ = "";
                    return this;
                }

                public Steps clearLight() {
                    this.hasLight = false;
                    this.light_ = 0;
                    return this;
                }

                public Steps clearLinks() {
                    this.links_ = Collections.emptyList();
                    return this;
                }

                public Steps clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public Steps clearPoirefPois() {
                    this.poirefPois_ = Collections.emptyList();
                    return this;
                }

                public Steps clearPois() {
                    this.pois_ = Collections.emptyList();
                    return this;
                }

                public Steps clearRoadWidth() {
                    this.hasRoadWidth = false;
                    this.roadWidth_ = 0;
                    return this;
                }

                public Steps clearSendLocation() {
                    this.sendLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath() {
                    this.spath_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSpath4Navi() {
                    this.spath4Navi_ = Collections.emptyList();
                    return this;
                }

                public Steps clearSstartLocation() {
                    this.sstartLocation_ = Collections.emptyList();
                    return this;
                }

                public Steps clearStepStatus() {
                    this.hasStepStatus = false;
                    this.stepStatus_ = 0;
                    return this;
                }

                public Steps clearStrafficmarkLoc() {
                    this.strafficmarkLoc_ = Collections.emptyList();
                    return this;
                }

                public Steps clearTrafficType() {
                    this.hasTrafficType = false;
                    this.trafficType_ = 0;
                    return this;
                }

                public Steps clearTurnType() {
                    this.hasTurnType = false;
                    this.turnType_ = 0;
                    return this;
                }

                public Steps clearType() {
                    this.hasType = false;
                    this.type_ = 0;
                    return this;
                }

                public Steps clearWalkType() {
                    this.hasWalkType = false;
                    this.walkType_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getCircleRoad() {
                    return this.circleRoad_;
                }

                public DetailGuideInfoV1 getCloudGuideV1(int i) {
                    return this.cloudGuideV1_.get(i);
                }

                public int getCloudGuideV1Count() {
                    return this.cloudGuideV1_.size();
                }

                public List<DetailGuideInfoV1> getCloudGuideV1List() {
                    return this.cloudGuideV1_;
                }

                public DetailGuideInfoV2 getCloudGuideV2(int i) {
                    return this.cloudGuideV2_.get(i);
                }

                public int getCloudGuideV2Count() {
                    return this.cloudGuideV2_.size();
                }

                public List<DetailGuideInfoV2> getCloudGuideV2List() {
                    return this.cloudGuideV2_;
                }

                public DetailGuideInfoV3 getCloudGuideV3(int i) {
                    return this.cloudGuideV3_.get(i);
                }

                public int getCloudGuideV3Count() {
                    return this.cloudGuideV3_.size();
                }

                public List<DetailGuideInfoV3> getCloudGuideV3List() {
                    return this.cloudGuideV3_;
                }

                public int getDirection() {
                    return this.direction_;
                }

                public int getDistance() {
                    return this.distance_;
                }

                public int getDuration() {
                    return this.duration_;
                }

                public int getFirstLinkEndIndex() {
                    return this.firstLinkEndIndex_;
                }

                public int getGuideType() {
                    return this.guideType_;
                }

                public int getHasPanid() {
                    return this.hasPanid_;
                }

                public String getInstructions() {
                    return this.instructions_;
                }

                public int getLight() {
                    return this.light_;
                }

                public Links getLinks(int i) {
                    return this.links_.get(i);
                }

                public int getLinksCount() {
                    return this.links_.size();
                }

                public List<Links> getLinksList() {
                    return this.links_;
                }

                public String getName() {
                    return this.name_;
                }

                public Pois getPoirefPois(int i) {
                    return this.poirefPois_.get(i);
                }

                public int getPoirefPoisCount() {
                    return this.poirefPois_.size();
                }

                public List<Pois> getPoirefPoisList() {
                    return this.poirefPois_;
                }

                public Pois getPois(int i) {
                    return this.pois_.get(i);
                }

                public int getPoisCount() {
                    return this.pois_.size();
                }

                public List<Pois> getPoisList() {
                    return this.pois_;
                }

                public int getRoadWidth() {
                    return this.roadWidth_;
                }

                public int getSendLocation(int i) {
                    return this.sendLocation_.get(i).intValue();
                }

                public int getSendLocationCount() {
                    return this.sendLocation_.size();
                }

                public List<Integer> getSendLocationList() {
                    return this.sendLocation_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    Iterator<Integer> it = getSpathList().iterator();
                    int iComputeSInt32SizeNoTag = 0;
                    int iComputeSInt32SizeNoTag2 = 0;
                    while (it.hasNext()) {
                        iComputeSInt32SizeNoTag2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                    }
                    int size = iComputeSInt32SizeNoTag2 + 0 + (getSpathList().size() * 1);
                    if (hasInstructions()) {
                        size += CodedOutputStreamMicro.computeStringSize(2, getInstructions());
                    }
                    if (hasType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(3, getType());
                    }
                    if (hasName()) {
                        size += CodedOutputStreamMicro.computeStringSize(4, getName());
                    }
                    if (hasFirstLinkEndIndex()) {
                        size += CodedOutputStreamMicro.computeInt32Size(5, getFirstLinkEndIndex());
                    }
                    if (hasTurnType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(6, getTurnType());
                    }
                    if (hasWalkType()) {
                        size += CodedOutputStreamMicro.computeInt32Size(7, getWalkType());
                    }
                    if (hasLight()) {
                        size += CodedOutputStreamMicro.computeInt32Size(8, getLight());
                    }
                    if (hasCircleRoad()) {
                        size += CodedOutputStreamMicro.computeInt32Size(9, getCircleRoad());
                    }
                    if (hasRoadWidth()) {
                        size += CodedOutputStreamMicro.computeInt32Size(10, getRoadWidth());
                    }
                    if (hasDistance()) {
                        size += CodedOutputStreamMicro.computeInt32Size(11, getDistance());
                    }
                    if (hasDuration()) {
                        size += CodedOutputStreamMicro.computeInt32Size(12, getDuration());
                    }
                    Iterator<Links> it2 = getLinksList().iterator();
                    while (it2.hasNext()) {
                        size += CodedOutputStreamMicro.computeMessageSize(13, it2.next());
                    }
                    Iterator<Pois> it3 = getPoisList().iterator();
                    while (it3.hasNext()) {
                        size += CodedOutputStreamMicro.computeMessageSize(14, it3.next());
                    }
                    if (hasDirection()) {
                        size += CodedOutputStreamMicro.computeInt32Size(15, getDirection());
                    }
                    if (hasHasPanid()) {
                        size += CodedOutputStreamMicro.computeInt32Size(16, getHasPanid());
                    }
                    Iterator<Integer> it4 = getSstartLocationList().iterator();
                    int iComputeSInt32SizeNoTag3 = 0;
                    while (it4.hasNext()) {
                        iComputeSInt32SizeNoTag3 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it4.next().intValue());
                    }
                    int size2 = size + iComputeSInt32SizeNoTag3 + (getSstartLocationList().size() * 2);
                    Iterator<Integer> it5 = getSendLocationList().iterator();
                    int iComputeSInt32SizeNoTag4 = 0;
                    while (it5.hasNext()) {
                        iComputeSInt32SizeNoTag4 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it5.next().intValue());
                    }
                    int size3 = size2 + iComputeSInt32SizeNoTag4 + (getSendLocationList().size() * 2);
                    Iterator<Integer> it6 = getStrafficmarkLocList().iterator();
                    int iComputeInt32SizeNoTag = 0;
                    while (it6.hasNext()) {
                        iComputeInt32SizeNoTag += CodedOutputStreamMicro.computeInt32SizeNoTag(it6.next().intValue());
                    }
                    int size4 = size3 + iComputeInt32SizeNoTag + (getStrafficmarkLocList().size() * 2);
                    if (hasTrafficType()) {
                        size4 += CodedOutputStreamMicro.computeInt32Size(20, getTrafficType());
                    }
                    Iterator<Integer> it7 = getSpath4NaviList().iterator();
                    while (it7.hasNext()) {
                        iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it7.next().intValue());
                    }
                    int size5 = size4 + iComputeSInt32SizeNoTag + (getSpath4NaviList().size() * 2);
                    if (hasStepStatus()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(22, getStepStatus());
                    }
                    Iterator<Pois> it8 = getPoirefPoisList().iterator();
                    while (it8.hasNext()) {
                        size5 += CodedOutputStreamMicro.computeMessageSize(23, it8.next());
                    }
                    Iterator<DetailGuideInfoV1> it9 = getCloudGuideV1List().iterator();
                    while (it9.hasNext()) {
                        size5 += CodedOutputStreamMicro.computeMessageSize(24, it9.next());
                    }
                    Iterator<DetailGuideInfoV2> it10 = getCloudGuideV2List().iterator();
                    while (it10.hasNext()) {
                        size5 += CodedOutputStreamMicro.computeMessageSize(25, it10.next());
                    }
                    if (hasGuideType()) {
                        size5 += CodedOutputStreamMicro.computeInt32Size(26, getGuideType());
                    }
                    Iterator<DetailGuideInfoV3> it11 = getCloudGuideV3List().iterator();
                    while (it11.hasNext()) {
                        size5 += CodedOutputStreamMicro.computeMessageSize(27, it11.next());
                    }
                    this.cachedSize = size5;
                    return size5;
                }

                public int getSpath(int i) {
                    return this.spath_.get(i).intValue();
                }

                public int getSpath4Navi(int i) {
                    return this.spath4Navi_.get(i).intValue();
                }

                public int getSpath4NaviCount() {
                    return this.spath4Navi_.size();
                }

                public List<Integer> getSpath4NaviList() {
                    return this.spath4Navi_;
                }

                public int getSpathCount() {
                    return this.spath_.size();
                }

                public List<Integer> getSpathList() {
                    return this.spath_;
                }

                public int getSstartLocation(int i) {
                    return this.sstartLocation_.get(i).intValue();
                }

                public int getSstartLocationCount() {
                    return this.sstartLocation_.size();
                }

                public List<Integer> getSstartLocationList() {
                    return this.sstartLocation_;
                }

                public int getStepStatus() {
                    return this.stepStatus_;
                }

                public int getStrafficmarkLoc(int i) {
                    return this.strafficmarkLoc_.get(i).intValue();
                }

                public int getStrafficmarkLocCount() {
                    return this.strafficmarkLoc_.size();
                }

                public List<Integer> getStrafficmarkLocList() {
                    return this.strafficmarkLoc_;
                }

                public int getTrafficType() {
                    return this.trafficType_;
                }

                public int getTurnType() {
                    return this.turnType_;
                }

                public int getType() {
                    return this.type_;
                }

                public int getWalkType() {
                    return this.walkType_;
                }

                public boolean hasCircleRoad() {
                    return this.hasCircleRoad;
                }

                public boolean hasDirection() {
                    return this.hasDirection;
                }

                public boolean hasDistance() {
                    return this.hasDistance;
                }

                public boolean hasDuration() {
                    return this.hasDuration;
                }

                public boolean hasFirstLinkEndIndex() {
                    return this.hasFirstLinkEndIndex;
                }

                public boolean hasGuideType() {
                    return this.hasGuideType;
                }

                public boolean hasHasPanid() {
                    return this.hasHasPanid;
                }

                public boolean hasInstructions() {
                    return this.hasInstructions;
                }

                public boolean hasLight() {
                    return this.hasLight;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasRoadWidth() {
                    return this.hasRoadWidth;
                }

                public boolean hasStepStatus() {
                    return this.hasStepStatus;
                }

                public boolean hasTrafficType() {
                    return this.hasTrafficType;
                }

                public boolean hasTurnType() {
                    return this.hasTurnType;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public boolean hasWalkType() {
                    return this.hasWalkType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Steps mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        switch (tag) {
                            case 0:
                                return this;
                            case 8:
                                addSpath(codedInputStreamMicro.readSInt32());
                                break;
                            case 18:
                                setInstructions(codedInputStreamMicro.readString());
                                break;
                            case 24:
                                setType(codedInputStreamMicro.readInt32());
                                break;
                            case 34:
                                setName(codedInputStreamMicro.readString());
                                break;
                            case 40:
                                setFirstLinkEndIndex(codedInputStreamMicro.readInt32());
                                break;
                            case 48:
                                setTurnType(codedInputStreamMicro.readInt32());
                                break;
                            case 56:
                                setWalkType(codedInputStreamMicro.readInt32());
                                break;
                            case 64:
                                setLight(codedInputStreamMicro.readInt32());
                                break;
                            case 72:
                                setCircleRoad(codedInputStreamMicro.readInt32());
                                break;
                            case 80:
                                setRoadWidth(codedInputStreamMicro.readInt32());
                                break;
                            case 88:
                                setDistance(codedInputStreamMicro.readInt32());
                                break;
                            case 96:
                                setDuration(codedInputStreamMicro.readInt32());
                                break;
                            case 106:
                                Links links = new Links();
                                codedInputStreamMicro.readMessage(links);
                                addLinks(links);
                                break;
                            case 114:
                                Pois pois = new Pois();
                                codedInputStreamMicro.readMessage(pois);
                                addPois(pois);
                                break;
                            case 120:
                                setDirection(codedInputStreamMicro.readInt32());
                                break;
                            case 128:
                                setHasPanid(codedInputStreamMicro.readInt32());
                                break;
                            case 136:
                                addSstartLocation(codedInputStreamMicro.readSInt32());
                                break;
                            case 144:
                                addSendLocation(codedInputStreamMicro.readSInt32());
                                break;
                            case 152:
                                addStrafficmarkLoc(codedInputStreamMicro.readInt32());
                                break;
                            case 160:
                                setTrafficType(codedInputStreamMicro.readInt32());
                                break;
                            case 168:
                                addSpath4Navi(codedInputStreamMicro.readSInt32());
                                break;
                            case 176:
                                setStepStatus(codedInputStreamMicro.readInt32());
                                break;
                            case 186:
                                Pois pois2 = new Pois();
                                codedInputStreamMicro.readMessage(pois2);
                                addPoirefPois(pois2);
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                                DetailGuideInfoV1 detailGuideInfoV1 = new DetailGuideInfoV1();
                                codedInputStreamMicro.readMessage(detailGuideInfoV1);
                                addCloudGuideV1(detailGuideInfoV1);
                                break;
                            case 202:
                                DetailGuideInfoV2 detailGuideInfoV2 = new DetailGuideInfoV2();
                                codedInputStreamMicro.readMessage(detailGuideInfoV2);
                                addCloudGuideV2(detailGuideInfoV2);
                                break;
                            case 208:
                                setGuideType(codedInputStreamMicro.readInt32());
                                break;
                            case 218:
                                DetailGuideInfoV3 detailGuideInfoV3 = new DetailGuideInfoV3();
                                codedInputStreamMicro.readMessage(detailGuideInfoV3);
                                addCloudGuideV3(detailGuideInfoV3);
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                    return this;
                                }
                                break;
                                break;
                        }
                    }
                }

                public Steps setCircleRoad(int i) {
                    this.hasCircleRoad = true;
                    this.circleRoad_ = i;
                    return this;
                }

                public Steps setCloudGuideV1(int i, DetailGuideInfoV1 detailGuideInfoV1) {
                    if (detailGuideInfoV1 == null) {
                        return this;
                    }
                    this.cloudGuideV1_.set(i, detailGuideInfoV1);
                    return this;
                }

                public Steps setCloudGuideV2(int i, DetailGuideInfoV2 detailGuideInfoV2) {
                    if (detailGuideInfoV2 == null) {
                        return this;
                    }
                    this.cloudGuideV2_.set(i, detailGuideInfoV2);
                    return this;
                }

                public Steps setCloudGuideV3(int i, DetailGuideInfoV3 detailGuideInfoV3) {
                    if (detailGuideInfoV3 == null) {
                        return this;
                    }
                    this.cloudGuideV3_.set(i, detailGuideInfoV3);
                    return this;
                }

                public Steps setDirection(int i) {
                    this.hasDirection = true;
                    this.direction_ = i;
                    return this;
                }

                public Steps setDistance(int i) {
                    this.hasDistance = true;
                    this.distance_ = i;
                    return this;
                }

                public Steps setDuration(int i) {
                    this.hasDuration = true;
                    this.duration_ = i;
                    return this;
                }

                public Steps setFirstLinkEndIndex(int i) {
                    this.hasFirstLinkEndIndex = true;
                    this.firstLinkEndIndex_ = i;
                    return this;
                }

                public Steps setGuideType(int i) {
                    this.hasGuideType = true;
                    this.guideType_ = i;
                    return this;
                }

                public Steps setHasPanid(int i) {
                    this.hasHasPanid = true;
                    this.hasPanid_ = i;
                    return this;
                }

                public Steps setInstructions(String str) {
                    this.hasInstructions = true;
                    this.instructions_ = str;
                    return this;
                }

                public Steps setLight(int i) {
                    this.hasLight = true;
                    this.light_ = i;
                    return this;
                }

                public Steps setLinks(int i, Links links) {
                    if (links == null) {
                        return this;
                    }
                    this.links_.set(i, links);
                    return this;
                }

                public Steps setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public Steps setPoirefPois(int i, Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    this.poirefPois_.set(i, pois);
                    return this;
                }

                public Steps setPois(int i, Pois pois) {
                    if (pois == null) {
                        return this;
                    }
                    this.pois_.set(i, pois);
                    return this;
                }

                public Steps setRoadWidth(int i) {
                    this.hasRoadWidth = true;
                    this.roadWidth_ = i;
                    return this;
                }

                public Steps setSendLocation(int i, int i2) {
                    this.sendLocation_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSpath(int i, int i2) {
                    this.spath_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSpath4Navi(int i, int i2) {
                    this.spath4Navi_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setSstartLocation(int i, int i2) {
                    this.sstartLocation_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setStepStatus(int i) {
                    this.hasStepStatus = true;
                    this.stepStatus_ = i;
                    return this;
                }

                public Steps setStrafficmarkLoc(int i, int i2) {
                    this.strafficmarkLoc_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Steps setTrafficType(int i) {
                    this.hasTrafficType = true;
                    this.trafficType_ = i;
                    return this;
                }

                public Steps setTurnType(int i) {
                    this.hasTurnType = true;
                    this.turnType_ = i;
                    return this;
                }

                public Steps setType(int i) {
                    this.hasType = true;
                    this.type_ = i;
                    return this;
                }

                public Steps setWalkType(int i) {
                    this.hasWalkType = true;
                    this.walkType_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    Iterator<Integer> it = getSpathList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(1, it.next().intValue());
                    }
                    if (hasInstructions()) {
                        codedOutputStreamMicro.writeString(2, getInstructions());
                    }
                    if (hasType()) {
                        codedOutputStreamMicro.writeInt32(3, getType());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(4, getName());
                    }
                    if (hasFirstLinkEndIndex()) {
                        codedOutputStreamMicro.writeInt32(5, getFirstLinkEndIndex());
                    }
                    if (hasTurnType()) {
                        codedOutputStreamMicro.writeInt32(6, getTurnType());
                    }
                    if (hasWalkType()) {
                        codedOutputStreamMicro.writeInt32(7, getWalkType());
                    }
                    if (hasLight()) {
                        codedOutputStreamMicro.writeInt32(8, getLight());
                    }
                    if (hasCircleRoad()) {
                        codedOutputStreamMicro.writeInt32(9, getCircleRoad());
                    }
                    if (hasRoadWidth()) {
                        codedOutputStreamMicro.writeInt32(10, getRoadWidth());
                    }
                    if (hasDistance()) {
                        codedOutputStreamMicro.writeInt32(11, getDistance());
                    }
                    if (hasDuration()) {
                        codedOutputStreamMicro.writeInt32(12, getDuration());
                    }
                    Iterator<Links> it2 = getLinksList().iterator();
                    while (it2.hasNext()) {
                        codedOutputStreamMicro.writeMessage(13, it2.next());
                    }
                    Iterator<Pois> it3 = getPoisList().iterator();
                    while (it3.hasNext()) {
                        codedOutputStreamMicro.writeMessage(14, it3.next());
                    }
                    if (hasDirection()) {
                        codedOutputStreamMicro.writeInt32(15, getDirection());
                    }
                    if (hasHasPanid()) {
                        codedOutputStreamMicro.writeInt32(16, getHasPanid());
                    }
                    Iterator<Integer> it4 = getSstartLocationList().iterator();
                    while (it4.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(17, it4.next().intValue());
                    }
                    Iterator<Integer> it5 = getSendLocationList().iterator();
                    while (it5.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(18, it5.next().intValue());
                    }
                    Iterator<Integer> it6 = getStrafficmarkLocList().iterator();
                    while (it6.hasNext()) {
                        codedOutputStreamMicro.writeInt32(19, it6.next().intValue());
                    }
                    if (hasTrafficType()) {
                        codedOutputStreamMicro.writeInt32(20, getTrafficType());
                    }
                    Iterator<Integer> it7 = getSpath4NaviList().iterator();
                    while (it7.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(21, it7.next().intValue());
                    }
                    if (hasStepStatus()) {
                        codedOutputStreamMicro.writeInt32(22, getStepStatus());
                    }
                    Iterator<Pois> it8 = getPoirefPoisList().iterator();
                    while (it8.hasNext()) {
                        codedOutputStreamMicro.writeMessage(23, it8.next());
                    }
                    Iterator<DetailGuideInfoV1> it9 = getCloudGuideV1List().iterator();
                    while (it9.hasNext()) {
                        codedOutputStreamMicro.writeMessage(24, it9.next());
                    }
                    Iterator<DetailGuideInfoV2> it10 = getCloudGuideV2List().iterator();
                    while (it10.hasNext()) {
                        codedOutputStreamMicro.writeMessage(25, it10.next());
                    }
                    if (hasGuideType()) {
                        codedOutputStreamMicro.writeInt32(26, getGuideType());
                    }
                    Iterator<DetailGuideInfoV3> it11 = getCloudGuideV3List().iterator();
                    while (it11.hasNext()) {
                        codedOutputStreamMicro.writeMessage(27, it11.next());
                    }
                }
            }

            public static Legs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Legs().mergeFrom(codedInputStreamMicro);
            }

            public static Legs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Legs) new Legs().mergeFrom(bArr);
            }

            public Legs addConnectedPois(ConnectedPois connectedPois) {
                if (connectedPois == null) {
                    return this;
                }
                if (this.connectedPois_.isEmpty()) {
                    this.connectedPois_ = new ArrayList();
                }
                this.connectedPois_.add(connectedPois);
                return this;
            }

            public Legs addSendLocation(int i) {
                if (this.sendLocation_.isEmpty()) {
                    this.sendLocation_ = new ArrayList();
                }
                this.sendLocation_.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSstartLocation(int i) {
                if (this.sstartLocation_.isEmpty()) {
                    this.sstartLocation_ = new ArrayList();
                }
                this.sstartLocation_.add(Integer.valueOf(i));
                return this;
            }

            public Legs addSteps(Steps steps) {
                if (steps == null) {
                    return this;
                }
                if (this.steps_.isEmpty()) {
                    this.steps_ = new ArrayList();
                }
                this.steps_.add(steps);
                return this;
            }

            public final Legs clear() {
                clearSteps();
                clearSstartLocation();
                clearSendLocation();
                clearStartAddress();
                clearEndAddress();
                clearDistance();
                clearDuration();
                clearSide();
                clearStartDist();
                clearEndDist();
                clearConnectedPois();
                clearLegLinked();
                clearType();
                this.cachedSize = -1;
                return this;
            }

            public Legs clearConnectedPois() {
                this.connectedPois_ = Collections.emptyList();
                return this;
            }

            public Legs clearDistance() {
                this.hasDistance = false;
                this.distance_ = 0;
                return this;
            }

            public Legs clearDuration() {
                this.hasDuration = false;
                this.duration_ = 0;
                return this;
            }

            public Legs clearEndAddress() {
                this.hasEndAddress = false;
                this.endAddress_ = "";
                return this;
            }

            public Legs clearEndDist() {
                this.hasEndDist = false;
                this.endDist_ = 0;
                return this;
            }

            public Legs clearLegLinked() {
                this.hasLegLinked = false;
                this.legLinked_ = null;
                return this;
            }

            public Legs clearSendLocation() {
                this.sendLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearSide() {
                this.hasSide = false;
                this.side_ = 0;
                return this;
            }

            public Legs clearSstartLocation() {
                this.sstartLocation_ = Collections.emptyList();
                return this;
            }

            public Legs clearStartAddress() {
                this.hasStartAddress = false;
                this.startAddress_ = "";
                return this;
            }

            public Legs clearStartDist() {
                this.hasStartDist = false;
                this.startDist_ = 0;
                return this;
            }

            public Legs clearSteps() {
                this.steps_ = Collections.emptyList();
                return this;
            }

            public Legs clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public ConnectedPois getConnectedPois(int i) {
                return this.connectedPois_.get(i);
            }

            public int getConnectedPoisCount() {
                return this.connectedPois_.size();
            }

            public List<ConnectedPois> getConnectedPoisList() {
                return this.connectedPois_;
            }

            public int getDistance() {
                return this.distance_;
            }

            public int getDuration() {
                return this.duration_;
            }

            public String getEndAddress() {
                return this.endAddress_;
            }

            public int getEndDist() {
                return this.endDist_;
            }

            public LegLinked getLegLinked() {
                return this.legLinked_;
            }

            public int getSendLocation(int i) {
                return this.sendLocation_.get(i).intValue();
            }

            public int getSendLocationCount() {
                return this.sendLocation_.size();
            }

            public List<Integer> getSendLocationList() {
                return this.sendLocation_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                Iterator<Integer> it = getSstartLocationList().iterator();
                int iComputeSInt32SizeNoTag = 0;
                int iComputeSInt32SizeNoTag2 = 0;
                while (it.hasNext()) {
                    iComputeSInt32SizeNoTag2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = iComputeSInt32SizeNoTag2 + 0 + (getSstartLocationList().size() * 1);
                Iterator<Integer> it2 = getSendLocationList().iterator();
                while (it2.hasNext()) {
                    iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it2.next().intValue());
                }
                int size2 = size + iComputeSInt32SizeNoTag + (getSendLocationList().size() * 1);
                if (hasStartAddress()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(3, getStartAddress());
                }
                if (hasEndAddress()) {
                    size2 += CodedOutputStreamMicro.computeStringSize(4, getEndAddress());
                }
                if (hasDistance()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
                }
                if (hasDuration()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(6, getDuration());
                }
                if (hasSide()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(7, getSide());
                }
                if (hasStartDist()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(8, getStartDist());
                }
                if (hasEndDist()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(9, getEndDist());
                }
                Iterator<Steps> it3 = getStepsList().iterator();
                while (it3.hasNext()) {
                    size2 += CodedOutputStreamMicro.computeMessageSize(10, it3.next());
                }
                Iterator<ConnectedPois> it4 = getConnectedPoisList().iterator();
                while (it4.hasNext()) {
                    size2 += CodedOutputStreamMicro.computeMessageSize(11, it4.next());
                }
                if (hasLegLinked()) {
                    size2 += CodedOutputStreamMicro.computeMessageSize(12, getLegLinked());
                }
                if (hasType()) {
                    size2 += CodedOutputStreamMicro.computeInt32Size(13, getType());
                }
                this.cachedSize = size2;
                return size2;
            }

            public int getSide() {
                return this.side_;
            }

            public int getSstartLocation(int i) {
                return this.sstartLocation_.get(i).intValue();
            }

            public int getSstartLocationCount() {
                return this.sstartLocation_.size();
            }

            public List<Integer> getSstartLocationList() {
                return this.sstartLocation_;
            }

            public String getStartAddress() {
                return this.startAddress_;
            }

            public int getStartDist() {
                return this.startDist_;
            }

            public Steps getSteps(int i) {
                return this.steps_.get(i);
            }

            public int getStepsCount() {
                return this.steps_.size();
            }

            public List<Steps> getStepsList() {
                return this.steps_;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasDistance() {
                return this.hasDistance;
            }

            public boolean hasDuration() {
                return this.hasDuration;
            }

            public boolean hasEndAddress() {
                return this.hasEndAddress;
            }

            public boolean hasEndDist() {
                return this.hasEndDist;
            }

            public boolean hasLegLinked() {
                return this.hasLegLinked;
            }

            public boolean hasSide() {
                return this.hasSide;
            }

            public boolean hasStartAddress() {
                return this.hasStartAddress;
            }

            public boolean hasStartDist() {
                return this.hasStartDist;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Legs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    switch (tag) {
                        case 0:
                            return this;
                        case 8:
                            addSstartLocation(codedInputStreamMicro.readSInt32());
                            break;
                        case 16:
                            addSendLocation(codedInputStreamMicro.readSInt32());
                            break;
                        case 26:
                            setStartAddress(codedInputStreamMicro.readString());
                            break;
                        case 34:
                            setEndAddress(codedInputStreamMicro.readString());
                            break;
                        case 40:
                            setDistance(codedInputStreamMicro.readInt32());
                            break;
                        case 48:
                            setDuration(codedInputStreamMicro.readInt32());
                            break;
                        case 56:
                            setSide(codedInputStreamMicro.readInt32());
                            break;
                        case 64:
                            setStartDist(codedInputStreamMicro.readInt32());
                            break;
                        case 72:
                            setEndDist(codedInputStreamMicro.readInt32());
                            break;
                        case 82:
                            Steps steps = new Steps();
                            codedInputStreamMicro.readMessage(steps);
                            addSteps(steps);
                            break;
                        case 90:
                            ConnectedPois connectedPois = new ConnectedPois();
                            codedInputStreamMicro.readMessage(connectedPois);
                            addConnectedPois(connectedPois);
                            break;
                        case 98:
                            LegLinked legLinked = new LegLinked();
                            codedInputStreamMicro.readMessage(legLinked);
                            setLegLinked(legLinked);
                            break;
                        case 104:
                            setType(codedInputStreamMicro.readInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                            break;
                            break;
                    }
                }
            }

            public Legs setConnectedPois(int i, ConnectedPois connectedPois) {
                if (connectedPois == null) {
                    return this;
                }
                this.connectedPois_.set(i, connectedPois);
                return this;
            }

            public Legs setDistance(int i) {
                this.hasDistance = true;
                this.distance_ = i;
                return this;
            }

            public Legs setDuration(int i) {
                this.hasDuration = true;
                this.duration_ = i;
                return this;
            }

            public Legs setEndAddress(String str) {
                this.hasEndAddress = true;
                this.endAddress_ = str;
                return this;
            }

            public Legs setEndDist(int i) {
                this.hasEndDist = true;
                this.endDist_ = i;
                return this;
            }

            public Legs setLegLinked(LegLinked legLinked) {
                if (legLinked == null) {
                    return clearLegLinked();
                }
                this.hasLegLinked = true;
                this.legLinked_ = legLinked;
                return this;
            }

            public Legs setSendLocation(int i, int i2) {
                this.sendLocation_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setSide(int i) {
                this.hasSide = true;
                this.side_ = i;
                return this;
            }

            public Legs setSstartLocation(int i, int i2) {
                this.sstartLocation_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Legs setStartAddress(String str) {
                this.hasStartAddress = true;
                this.startAddress_ = str;
                return this;
            }

            public Legs setStartDist(int i) {
                this.hasStartDist = true;
                this.startDist_ = i;
                return this;
            }

            public Legs setSteps(int i, Steps steps) {
                if (steps == null) {
                    return this;
                }
                this.steps_.set(i, steps);
                return this;
            }

            public Legs setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                Iterator<Integer> it = getSstartLocationList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(1, it.next().intValue());
                }
                Iterator<Integer> it2 = getSendLocationList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(2, it2.next().intValue());
                }
                if (hasStartAddress()) {
                    codedOutputStreamMicro.writeString(3, getStartAddress());
                }
                if (hasEndAddress()) {
                    codedOutputStreamMicro.writeString(4, getEndAddress());
                }
                if (hasDistance()) {
                    codedOutputStreamMicro.writeInt32(5, getDistance());
                }
                if (hasDuration()) {
                    codedOutputStreamMicro.writeInt32(6, getDuration());
                }
                if (hasSide()) {
                    codedOutputStreamMicro.writeInt32(7, getSide());
                }
                if (hasStartDist()) {
                    codedOutputStreamMicro.writeInt32(8, getStartDist());
                }
                if (hasEndDist()) {
                    codedOutputStreamMicro.writeInt32(9, getEndDist());
                }
                Iterator<Steps> it3 = getStepsList().iterator();
                while (it3.hasNext()) {
                    codedOutputStreamMicro.writeMessage(10, it3.next());
                }
                Iterator<ConnectedPois> it4 = getConnectedPoisList().iterator();
                while (it4.hasNext()) {
                    codedOutputStreamMicro.writeMessage(11, it4.next());
                }
                if (hasLegLinked()) {
                    codedOutputStreamMicro.writeMessage(12, getLegLinked());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(13, getType());
                }
            }
        }

        public static final class MapDrawInfo extends MessageMicro {
            public static final int GRAPH_ITEM_FIELD_NUMBER = 2;
            public static final int ICON_TYPE_FIELD_NUMBER = 3;
            public static final int ICON_URL_FIELD_NUMBER = 4;
            public static final int TYPE_FIELD_NUMBER = 1;
            private boolean hasIconType;
            private boolean hasIconUrl;
            private boolean hasType;
            private int type_ = 0;
            private List<GraphItemInfo> graphItem_ = Collections.emptyList();
            private int iconType_ = 0;
            private String iconUrl_ = "";
            private int cachedSize = -1;

            public static MapDrawInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new MapDrawInfo().mergeFrom(codedInputStreamMicro);
            }

            public static MapDrawInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (MapDrawInfo) new MapDrawInfo().mergeFrom(bArr);
            }

            public MapDrawInfo addGraphItem(GraphItemInfo graphItemInfo) {
                if (graphItemInfo == null) {
                    return this;
                }
                if (this.graphItem_.isEmpty()) {
                    this.graphItem_ = new ArrayList();
                }
                this.graphItem_.add(graphItemInfo);
                return this;
            }

            public final MapDrawInfo clear() {
                clearType();
                clearGraphItem();
                clearIconType();
                clearIconUrl();
                this.cachedSize = -1;
                return this;
            }

            public MapDrawInfo clearGraphItem() {
                this.graphItem_ = Collections.emptyList();
                return this;
            }

            public MapDrawInfo clearIconType() {
                this.hasIconType = false;
                this.iconType_ = 0;
                return this;
            }

            public MapDrawInfo clearIconUrl() {
                this.hasIconUrl = false;
                this.iconUrl_ = "";
                return this;
            }

            public MapDrawInfo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public GraphItemInfo getGraphItem(int i) {
                return this.graphItem_.get(i);
            }

            public int getGraphItemCount() {
                return this.graphItem_.size();
            }

            public List<GraphItemInfo> getGraphItemList() {
                return this.graphItem_;
            }

            public int getIconType() {
                return this.iconType_;
            }

            public String getIconUrl() {
                return this.iconUrl_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasType() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                Iterator<GraphItemInfo> it = getGraphItemList().iterator();
                while (it.hasNext()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(2, it.next());
                }
                if (hasIconType()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getIconType());
                }
                if (hasIconUrl()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getIconUrl());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasIconType() {
                return this.hasIconType;
            }

            public boolean hasIconUrl() {
                return this.hasIconUrl;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public MapDrawInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (tag == 18) {
                        GraphItemInfo graphItemInfo = new GraphItemInfo();
                        codedInputStreamMicro.readMessage(graphItemInfo);
                        addGraphItem(graphItemInfo);
                    } else if (tag == 24) {
                        setIconType(codedInputStreamMicro.readInt32());
                    } else if (tag == 34) {
                        setIconUrl(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public MapDrawInfo setGraphItem(int i, GraphItemInfo graphItemInfo) {
                if (graphItemInfo == null) {
                    return this;
                }
                this.graphItem_.set(i, graphItemInfo);
                return this;
            }

            public MapDrawInfo setIconType(int i) {
                this.hasIconType = true;
                this.iconType_ = i;
                return this;
            }

            public MapDrawInfo setIconUrl(String str) {
                this.hasIconUrl = true;
                this.iconUrl_ = str;
                return this;
            }

            public MapDrawInfo setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(1, getType());
                }
                Iterator<GraphItemInfo> it = getGraphItemList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(2, it.next());
                }
                if (hasIconType()) {
                    codedOutputStreamMicro.writeInt32(3, getIconType());
                }
                if (hasIconUrl()) {
                    codedOutputStreamMicro.writeString(4, getIconUrl());
                }
            }
        }

        public static final class Milestone extends MessageMicro {
            public static final int DIS_FIELD_NUMBER = 1;
            public static final int PT_FIELD_NUMBER = 2;
            private boolean hasDis;
            private int dis_ = 0;
            private List<Integer> pt_ = Collections.emptyList();
            private int cachedSize = -1;

            public static Milestone parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Milestone().mergeFrom(codedInputStreamMicro);
            }

            public static Milestone parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Milestone) new Milestone().mergeFrom(bArr);
            }

            public Milestone addPt(int i) {
                if (this.pt_.isEmpty()) {
                    this.pt_ = new ArrayList();
                }
                this.pt_.add(Integer.valueOf(i));
                return this;
            }

            public final Milestone clear() {
                clearDis();
                clearPt();
                this.cachedSize = -1;
                return this;
            }

            public Milestone clearDis() {
                this.hasDis = false;
                this.dis_ = 0;
                return this;
            }

            public Milestone clearPt() {
                this.pt_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getDis() {
                return this.dis_;
            }

            public int getPt(int i) {
                return this.pt_.get(i).intValue();
            }

            public int getPtCount() {
                return this.pt_.size();
            }

            public List<Integer> getPtList() {
                return this.pt_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeSInt32SizeNoTag = 0;
                int iComputeInt32Size = hasDis() ? CodedOutputStreamMicro.computeInt32Size(1, getDis()) + 0 : 0;
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                }
                int size = iComputeInt32Size + iComputeSInt32SizeNoTag + (getPtList().size() * 1);
                this.cachedSize = size;
                return size;
            }

            public boolean hasDis() {
                return this.hasDis;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Milestone mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setDis(codedInputStreamMicro.readInt32());
                    } else if (tag == 16) {
                        addPt(codedInputStreamMicro.readSInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public Milestone setDis(int i) {
                this.hasDis = true;
                this.dis_ = i;
                return this;
            }

            public Milestone setPt(int i, int i2) {
                this.pt_.set(i, Integer.valueOf(i2));
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasDis()) {
                    codedOutputStreamMicro.writeInt32(1, getDis());
                }
                Iterator<Integer> it = getPtList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeSInt32(2, it.next().intValue());
                }
            }
        }

        public static final class OtherInfo extends MessageMicro {
            public static final int LIGHT_NUM_FIELD_NUMBER = 1;
            private boolean hasLightNum;
            private int lightNum_ = 0;
            private int cachedSize = -1;

            public static OtherInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new OtherInfo().mergeFrom(codedInputStreamMicro);
            }

            public static OtherInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (OtherInfo) new OtherInfo().mergeFrom(bArr);
            }

            public final OtherInfo clear() {
                clearLightNum();
                this.cachedSize = -1;
                return this;
            }

            public OtherInfo clearLightNum() {
                this.hasLightNum = false;
                this.lightNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getLightNum() {
                return this.lightNum_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasLightNum() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getLightNum()) : 0;
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public boolean hasLightNum() {
                return this.hasLightNum;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public OtherInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setLightNum(codedInputStreamMicro.readInt32());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public OtherInfo setLightNum(int i) {
                this.hasLightNum = true;
                this.lightNum_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasLightNum()) {
                    codedOutputStreamMicro.writeInt32(1, getLightNum());
                }
            }
        }

        public static final class PolicyInfo extends MessageMicro {
            public static final int CALORIE_FIELD_NUMBER = 11;
            public static final int END_FIELD_NUMBER = 4;
            public static final int LABEL_FIELD_NUMBER = 2;
            public static final int LABEL_TIP_BAR_FIELD_NUMBER = 8;
            public static final int OPERATION_LABEL_CONTENT_FIELD_NUMBER = 9;
            public static final int OPERATION_LABEL_STYLE_FIELD_NUMBER = 10;
            public static final int PREVIEW_ROUTE_SCENE_FIELD_NUMBER = 7;
            public static final int RESULT_CARDS_FIELD_NUMBER = 6;
            public static final int RT_IDX_FIELD_NUMBER = 1;
            public static final int START_FIELD_NUMBER = 3;
            public static final int TAXI_FIELD_NUMBER = 5;
            private boolean hasCalorie;
            private boolean hasLabel;
            private boolean hasLabelTipBar;
            private boolean hasOperationLabelContent;
            private boolean hasOperationLabelStyle;
            private boolean hasPreviewRouteScene;
            private boolean hasRtIdx;
            private boolean hasStart;
            private boolean hasTaxi;
            private int rtIdx_ = 0;
            private String label_ = "";
            private Point_Info start_ = null;
            private List<Point_Info> end_ = Collections.emptyList();
            private Taxi taxi_ = null;
            private List<ResultCardInfo> resultCards_ = Collections.emptyList();
            private PreviewRouteSceneInfo previewRouteScene_ = null;
            private LabelTipBar labelTipBar_ = null;
            private String operationLabelContent_ = "";
            private OperationLabelStyle operationLabelStyle_ = null;
            private int calorie_ = 0;
            private int cachedSize = -1;

            public static final class LabelTipBar extends MessageMicro {
                public static final int CONTENT_FIELD_NUMBER = 2;
                public static final int LINK_FIELD_NUMBER = 3;
                public static final int TYPE_FIELD_NUMBER = 1;
                private boolean hasContent;
                private boolean hasLink;
                private boolean hasType;
                private String type_ = "";
                private String content_ = "";
                private String link_ = "";
                private int cachedSize = -1;

                public static LabelTipBar parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new LabelTipBar().mergeFrom(codedInputStreamMicro);
                }

                public static LabelTipBar parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (LabelTipBar) new LabelTipBar().mergeFrom(bArr);
                }

                public final LabelTipBar clear() {
                    clearType();
                    clearContent();
                    clearLink();
                    this.cachedSize = -1;
                    return this;
                }

                public LabelTipBar clearContent() {
                    this.hasContent = false;
                    this.content_ = "";
                    return this;
                }

                public LabelTipBar clearLink() {
                    this.hasLink = false;
                    this.link_ = "";
                    return this;
                }

                public LabelTipBar clearType() {
                    this.hasType = false;
                    this.type_ = "";
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getContent() {
                    return this.content_;
                }

                public String getLink() {
                    return this.link_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeStringSize = hasType() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getType()) : 0;
                    if (hasContent()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getContent());
                    }
                    if (hasLink()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getLink());
                    }
                    this.cachedSize = iComputeStringSize;
                    return iComputeStringSize;
                }

                public String getType() {
                    return this.type_;
                }

                public boolean hasContent() {
                    return this.hasContent;
                }

                public boolean hasLink() {
                    return this.hasLink;
                }

                public boolean hasType() {
                    return this.hasType;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public LabelTipBar mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 10) {
                            setType(codedInputStreamMicro.readString());
                        } else if (tag == 18) {
                            setContent(codedInputStreamMicro.readString());
                        } else if (tag == 26) {
                            setLink(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public LabelTipBar setContent(String str) {
                    this.hasContent = true;
                    this.content_ = str;
                    return this;
                }

                public LabelTipBar setLink(String str) {
                    this.hasLink = true;
                    this.link_ = str;
                    return this;
                }

                public LabelTipBar setType(String str) {
                    this.hasType = true;
                    this.type_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasType()) {
                        codedOutputStreamMicro.writeString(1, getType());
                    }
                    if (hasContent()) {
                        codedOutputStreamMicro.writeString(2, getContent());
                    }
                    if (hasLink()) {
                        codedOutputStreamMicro.writeString(3, getLink());
                    }
                }
            }

            public static final class OperationLabelStyle extends MessageMicro {
                public static final int BACKGROUND_COLOR_FIELD_NUMBER = 3;
                public static final int FONT_COLOR_FIELD_NUMBER = 2;
                public static final int FONT_SIZE_FIELD_NUMBER = 1;
                private boolean hasBackgroundColor;
                private boolean hasFontColor;
                private boolean hasFontSize;
                private int fontSize_ = 0;
                private String fontColor_ = "";
                private String backgroundColor_ = "";
                private int cachedSize = -1;

                public static OperationLabelStyle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new OperationLabelStyle().mergeFrom(codedInputStreamMicro);
                }

                public static OperationLabelStyle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (OperationLabelStyle) new OperationLabelStyle().mergeFrom(bArr);
                }

                public final OperationLabelStyle clear() {
                    clearFontSize();
                    clearFontColor();
                    clearBackgroundColor();
                    this.cachedSize = -1;
                    return this;
                }

                public OperationLabelStyle clearBackgroundColor() {
                    this.hasBackgroundColor = false;
                    this.backgroundColor_ = "";
                    return this;
                }

                public OperationLabelStyle clearFontColor() {
                    this.hasFontColor = false;
                    this.fontColor_ = "";
                    return this;
                }

                public OperationLabelStyle clearFontSize() {
                    this.hasFontSize = false;
                    this.fontSize_ = 0;
                    return this;
                }

                public String getBackgroundColor() {
                    return this.backgroundColor_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getFontColor() {
                    return this.fontColor_;
                }

                public int getFontSize() {
                    return this.fontSize_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeInt32Size = hasFontSize() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getFontSize()) : 0;
                    if (hasFontColor()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getFontColor());
                    }
                    if (hasBackgroundColor()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getBackgroundColor());
                    }
                    this.cachedSize = iComputeInt32Size;
                    return iComputeInt32Size;
                }

                public boolean hasBackgroundColor() {
                    return this.hasBackgroundColor;
                }

                public boolean hasFontColor() {
                    return this.hasFontColor;
                }

                public boolean hasFontSize() {
                    return this.hasFontSize;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public OperationLabelStyle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 8) {
                            setFontSize(codedInputStreamMicro.readInt32());
                        } else if (tag == 18) {
                            setFontColor(codedInputStreamMicro.readString());
                        } else if (tag == 26) {
                            setBackgroundColor(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public OperationLabelStyle setBackgroundColor(String str) {
                    this.hasBackgroundColor = true;
                    this.backgroundColor_ = str;
                    return this;
                }

                public OperationLabelStyle setFontColor(String str) {
                    this.hasFontColor = true;
                    this.fontColor_ = str;
                    return this;
                }

                public OperationLabelStyle setFontSize(int i) {
                    this.hasFontSize = true;
                    this.fontSize_ = i;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasFontSize()) {
                        codedOutputStreamMicro.writeInt32(1, getFontSize());
                    }
                    if (hasFontColor()) {
                        codedOutputStreamMicro.writeString(2, getFontColor());
                    }
                    if (hasBackgroundColor()) {
                        codedOutputStreamMicro.writeString(3, getBackgroundColor());
                    }
                }
            }

            public static final class Point_Info extends MessageMicro {
                public static final int BUILDINGNAME_FIELD_NUMBER = 9;
                public static final int BUILDING_FIELD_NUMBER = 6;
                public static final int BUILDING_INFOS_FIELD_NUMBER = 11;
                public static final int DISPT_FIELD_NUMBER = 8;
                public static final int FLOOR_FIELD_NUMBER = 5;
                public static final int FLOOR_INFO_FIELD_NUMBER = 10;
                public static final int GPT_FIELD_NUMBER = 7;
                public static final int INDOOR_LOC_TECH_FIELD_NUMBER = 13;
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int PT_FIELD_NUMBER = 1;
                public static final int PT_POPINF_FIELD_NUMBER = 17;
                public static final int REALITY_POINT_GIF_URL_FIELD_NUMBER = 14;
                public static final int RT_BUS_FIELD_NUMBER = 16;
                public static final int SPT_FIELD_NUMBER = 4;
                public static final int SUBUID_FIELD_NUMBER = 15;
                public static final int T_INFO_FIELD_NUMBER = 12;
                public static final int UID_FIELD_NUMBER = 3;
                private boolean hasBuilding;
                private boolean hasBuildingInfos;
                private boolean hasBuildingname;
                private boolean hasFloor;
                private boolean hasFloorInfo;
                private boolean hasIndoorLocTech;
                private boolean hasName;
                private boolean hasPt;
                private boolean hasPtPopinf;
                private boolean hasRealityPointGifUrl;
                private boolean hasRtBus;
                private boolean hasSubuid;
                private boolean hasUid;
                private String pt_ = "";
                private String name_ = "";
                private String uid_ = "";
                private List<Integer> spt_ = Collections.emptyList();
                private String floor_ = "";
                private String building_ = "";
                private List<Integer> gpt_ = Collections.emptyList();
                private List<Integer> dispt_ = Collections.emptyList();
                private String buildingname_ = "";
                private String floorInfo_ = "";
                private BuildingInfos buildingInfos_ = null;
                private List<TrafficHubPort> tInfo_ = Collections.emptyList();
                private int indoorLocTech_ = 0;
                private String realityPointGifUrl_ = "";
                private String subuid_ = "";
                private int rtBus_ = 0;
                private PtPopInf ptPopinf_ = null;
                private int cachedSize = -1;

                public static final class BuildingInfos extends MessageMicro {
                    public static final int BID_FIELD_NUMBER = 1;
                    public static final int FLOORLIST_FIELD_NUMBER = 3;
                    public static final int NAME_FIELD_NUMBER = 2;
                    private boolean hasBid;
                    private boolean hasFloorlist;
                    private boolean hasName;
                    private String bid_ = "";
                    private String name_ = "";
                    private String floorlist_ = "";
                    private int cachedSize = -1;

                    public static BuildingInfos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new BuildingInfos().mergeFrom(codedInputStreamMicro);
                    }

                    public static BuildingInfos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (BuildingInfos) new BuildingInfos().mergeFrom(bArr);
                    }

                    public final BuildingInfos clear() {
                        clearBid();
                        clearName();
                        clearFloorlist();
                        this.cachedSize = -1;
                        return this;
                    }

                    public BuildingInfos clearBid() {
                        this.hasBid = false;
                        this.bid_ = "";
                        return this;
                    }

                    public BuildingInfos clearFloorlist() {
                        this.hasFloorlist = false;
                        this.floorlist_ = "";
                        return this;
                    }

                    public BuildingInfos clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public String getBid() {
                        return this.bid_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getFloorlist() {
                        return this.floorlist_;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasBid() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getBid()) : 0;
                        if (hasName()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                        }
                        if (hasFloorlist()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getFloorlist());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public boolean hasBid() {
                        return this.hasBid;
                    }

                    public boolean hasFloorlist() {
                        return this.hasFloorlist;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public BuildingInfos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 10) {
                                setBid(codedInputStreamMicro.readString());
                            } else if (tag == 18) {
                                setName(codedInputStreamMicro.readString());
                            } else if (tag == 26) {
                                setFloorlist(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public BuildingInfos setBid(String str) {
                        this.hasBid = true;
                        this.bid_ = str;
                        return this;
                    }

                    public BuildingInfos setFloorlist(String str) {
                        this.hasFloorlist = true;
                        this.floorlist_ = str;
                        return this;
                    }

                    public BuildingInfos setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasBid()) {
                            codedOutputStreamMicro.writeString(1, getBid());
                        }
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(2, getName());
                        }
                        if (hasFloorlist()) {
                            codedOutputStreamMicro.writeString(3, getFloorlist());
                        }
                    }
                }

                public static final class PtPopInf extends MessageMicro {
                    public static final int TEXT_FIELD_NUMBER = 1;
                    public static final int URL_FIELD_NUMBER = 2;
                    private boolean hasText;
                    private boolean hasUrl;
                    private String text_ = "";
                    private String url_ = "";
                    private int cachedSize = -1;

                    public static PtPopInf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new PtPopInf().mergeFrom(codedInputStreamMicro);
                    }

                    public static PtPopInf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (PtPopInf) new PtPopInf().mergeFrom(bArr);
                    }

                    public final PtPopInf clear() {
                        clearText();
                        clearUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public PtPopInf clearText() {
                        this.hasText = false;
                        this.text_ = "";
                        return this;
                    }

                    public PtPopInf clearUrl() {
                        this.hasUrl = false;
                        this.url_ = "";
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasText() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getText()) : 0;
                        if (hasUrl()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getUrl());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public String getText() {
                        return this.text_;
                    }

                    public String getUrl() {
                        return this.url_;
                    }

                    public boolean hasText() {
                        return this.hasText;
                    }

                    public boolean hasUrl() {
                        return this.hasUrl;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public PtPopInf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 10) {
                                setText(codedInputStreamMicro.readString());
                            } else if (tag == 18) {
                                setUrl(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public PtPopInf setText(String str) {
                        this.hasText = true;
                        this.text_ = str;
                        return this;
                    }

                    public PtPopInf setUrl(String str) {
                        this.hasUrl = true;
                        this.url_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasText()) {
                            codedOutputStreamMicro.writeString(1, getText());
                        }
                        if (hasUrl()) {
                            codedOutputStreamMicro.writeString(2, getUrl());
                        }
                    }
                }

                public static final class TrafficHubPort extends MessageMicro {
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int TYPE_FIELD_NUMBER = 2;
                    private boolean hasName;
                    private boolean hasType;
                    private String name_ = "";
                    private int type_ = 0;
                    private int cachedSize = -1;

                    public static TrafficHubPort parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new TrafficHubPort().mergeFrom(codedInputStreamMicro);
                    }

                    public static TrafficHubPort parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (TrafficHubPort) new TrafficHubPort().mergeFrom(bArr);
                    }

                    public final TrafficHubPort clear() {
                        clearName();
                        clearType();
                        this.cachedSize = -1;
                        return this;
                    }

                    public TrafficHubPort clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public TrafficHubPort clearType() {
                        this.hasType = false;
                        this.type_ = 0;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasType()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeSInt32Size(2, getType());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public int getType() {
                        return this.type_;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasType() {
                        return this.hasType;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public TrafficHubPort mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 10) {
                                setName(codedInputStreamMicro.readString());
                            } else if (tag == 16) {
                                setType(codedInputStreamMicro.readSInt32());
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public TrafficHubPort setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public TrafficHubPort setType(int i) {
                        this.hasType = true;
                        this.type_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasType()) {
                            codedOutputStreamMicro.writeSInt32(2, getType());
                        }
                    }
                }

                public static Point_Info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Point_Info().mergeFrom(codedInputStreamMicro);
                }

                public static Point_Info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Point_Info) new Point_Info().mergeFrom(bArr);
                }

                public Point_Info addDispt(int i) {
                    if (this.dispt_.isEmpty()) {
                        this.dispt_ = new ArrayList();
                    }
                    this.dispt_.add(Integer.valueOf(i));
                    return this;
                }

                public Point_Info addGpt(int i) {
                    if (this.gpt_.isEmpty()) {
                        this.gpt_ = new ArrayList();
                    }
                    this.gpt_.add(Integer.valueOf(i));
                    return this;
                }

                public Point_Info addSpt(int i) {
                    if (this.spt_.isEmpty()) {
                        this.spt_ = new ArrayList();
                    }
                    this.spt_.add(Integer.valueOf(i));
                    return this;
                }

                public Point_Info addTInfo(TrafficHubPort trafficHubPort) {
                    if (trafficHubPort == null) {
                        return this;
                    }
                    if (this.tInfo_.isEmpty()) {
                        this.tInfo_ = new ArrayList();
                    }
                    this.tInfo_.add(trafficHubPort);
                    return this;
                }

                public final Point_Info clear() {
                    clearPt();
                    clearName();
                    clearUid();
                    clearSpt();
                    clearFloor();
                    clearBuilding();
                    clearGpt();
                    clearDispt();
                    clearBuildingname();
                    clearFloorInfo();
                    clearBuildingInfos();
                    clearTInfo();
                    clearIndoorLocTech();
                    clearRealityPointGifUrl();
                    clearSubuid();
                    clearRtBus();
                    clearPtPopinf();
                    this.cachedSize = -1;
                    return this;
                }

                public Point_Info clearBuilding() {
                    this.hasBuilding = false;
                    this.building_ = "";
                    return this;
                }

                public Point_Info clearBuildingInfos() {
                    this.hasBuildingInfos = false;
                    this.buildingInfos_ = null;
                    return this;
                }

                public Point_Info clearBuildingname() {
                    this.hasBuildingname = false;
                    this.buildingname_ = "";
                    return this;
                }

                public Point_Info clearDispt() {
                    this.dispt_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearFloor() {
                    this.hasFloor = false;
                    this.floor_ = "";
                    return this;
                }

                public Point_Info clearFloorInfo() {
                    this.hasFloorInfo = false;
                    this.floorInfo_ = "";
                    return this;
                }

                public Point_Info clearGpt() {
                    this.gpt_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearIndoorLocTech() {
                    this.hasIndoorLocTech = false;
                    this.indoorLocTech_ = 0;
                    return this;
                }

                public Point_Info clearName() {
                    this.hasName = false;
                    this.name_ = "";
                    return this;
                }

                public Point_Info clearPt() {
                    this.hasPt = false;
                    this.pt_ = "";
                    return this;
                }

                public Point_Info clearPtPopinf() {
                    this.hasPtPopinf = false;
                    this.ptPopinf_ = null;
                    return this;
                }

                public Point_Info clearRealityPointGifUrl() {
                    this.hasRealityPointGifUrl = false;
                    this.realityPointGifUrl_ = "";
                    return this;
                }

                public Point_Info clearRtBus() {
                    this.hasRtBus = false;
                    this.rtBus_ = 0;
                    return this;
                }

                public Point_Info clearSpt() {
                    this.spt_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearSubuid() {
                    this.hasSubuid = false;
                    this.subuid_ = "";
                    return this;
                }

                public Point_Info clearTInfo() {
                    this.tInfo_ = Collections.emptyList();
                    return this;
                }

                public Point_Info clearUid() {
                    this.hasUid = false;
                    this.uid_ = "";
                    return this;
                }

                public String getBuilding() {
                    return this.building_;
                }

                public BuildingInfos getBuildingInfos() {
                    return this.buildingInfos_;
                }

                public String getBuildingname() {
                    return this.buildingname_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getDispt(int i) {
                    return this.dispt_.get(i).intValue();
                }

                public int getDisptCount() {
                    return this.dispt_.size();
                }

                public List<Integer> getDisptList() {
                    return this.dispt_;
                }

                public String getFloor() {
                    return this.floor_;
                }

                public String getFloorInfo() {
                    return this.floorInfo_;
                }

                public int getGpt(int i) {
                    return this.gpt_.get(i).intValue();
                }

                public int getGptCount() {
                    return this.gpt_.size();
                }

                public List<Integer> getGptList() {
                    return this.gpt_;
                }

                public int getIndoorLocTech() {
                    return this.indoorLocTech_;
                }

                public String getName() {
                    return this.name_;
                }

                public String getPt() {
                    return this.pt_;
                }

                public PtPopInf getPtPopinf() {
                    return this.ptPopinf_;
                }

                public String getRealityPointGifUrl() {
                    return this.realityPointGifUrl_;
                }

                public int getRtBus() {
                    return this.rtBus_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeSInt32SizeNoTag = 0;
                    int iComputeStringSize = hasPt() ? CodedOutputStreamMicro.computeStringSize(1, getPt()) + 0 : 0;
                    if (hasName()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    if (hasUid()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getUid());
                    }
                    Iterator<Integer> it = getSptList().iterator();
                    int iComputeSInt32SizeNoTag2 = 0;
                    while (it.hasNext()) {
                        iComputeSInt32SizeNoTag2 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it.next().intValue());
                    }
                    int size = iComputeStringSize + iComputeSInt32SizeNoTag2 + (getSptList().size() * 1);
                    if (hasFloor()) {
                        size += CodedOutputStreamMicro.computeStringSize(5, getFloor());
                    }
                    if (hasBuilding()) {
                        size += CodedOutputStreamMicro.computeStringSize(6, getBuilding());
                    }
                    Iterator<Integer> it2 = getGptList().iterator();
                    int iComputeSInt32SizeNoTag3 = 0;
                    while (it2.hasNext()) {
                        iComputeSInt32SizeNoTag3 += CodedOutputStreamMicro.computeSInt32SizeNoTag(it2.next().intValue());
                    }
                    int size2 = size + iComputeSInt32SizeNoTag3 + (getGptList().size() * 1);
                    Iterator<Integer> it3 = getDisptList().iterator();
                    while (it3.hasNext()) {
                        iComputeSInt32SizeNoTag += CodedOutputStreamMicro.computeSInt32SizeNoTag(it3.next().intValue());
                    }
                    int size3 = size2 + iComputeSInt32SizeNoTag + (getDisptList().size() * 1);
                    if (hasBuildingname()) {
                        size3 += CodedOutputStreamMicro.computeStringSize(9, getBuildingname());
                    }
                    if (hasFloorInfo()) {
                        size3 += CodedOutputStreamMicro.computeStringSize(10, getFloorInfo());
                    }
                    if (hasBuildingInfos()) {
                        size3 += CodedOutputStreamMicro.computeMessageSize(11, getBuildingInfos());
                    }
                    Iterator<TrafficHubPort> it4 = getTInfoList().iterator();
                    while (it4.hasNext()) {
                        size3 += CodedOutputStreamMicro.computeMessageSize(12, it4.next());
                    }
                    if (hasIndoorLocTech()) {
                        size3 += CodedOutputStreamMicro.computeInt32Size(13, getIndoorLocTech());
                    }
                    if (hasRealityPointGifUrl()) {
                        size3 += CodedOutputStreamMicro.computeStringSize(14, getRealityPointGifUrl());
                    }
                    if (hasSubuid()) {
                        size3 += CodedOutputStreamMicro.computeStringSize(15, getSubuid());
                    }
                    if (hasRtBus()) {
                        size3 += CodedOutputStreamMicro.computeInt32Size(16, getRtBus());
                    }
                    if (hasPtPopinf()) {
                        size3 += CodedOutputStreamMicro.computeMessageSize(17, getPtPopinf());
                    }
                    this.cachedSize = size3;
                    return size3;
                }

                public int getSpt(int i) {
                    return this.spt_.get(i).intValue();
                }

                public int getSptCount() {
                    return this.spt_.size();
                }

                public List<Integer> getSptList() {
                    return this.spt_;
                }

                public String getSubuid() {
                    return this.subuid_;
                }

                public TrafficHubPort getTInfo(int i) {
                    return this.tInfo_.get(i);
                }

                public int getTInfoCount() {
                    return this.tInfo_.size();
                }

                public List<TrafficHubPort> getTInfoList() {
                    return this.tInfo_;
                }

                public String getUid() {
                    return this.uid_;
                }

                public boolean hasBuilding() {
                    return this.hasBuilding;
                }

                public boolean hasBuildingInfos() {
                    return this.hasBuildingInfos;
                }

                public boolean hasBuildingname() {
                    return this.hasBuildingname;
                }

                public boolean hasFloor() {
                    return this.hasFloor;
                }

                public boolean hasFloorInfo() {
                    return this.hasFloorInfo;
                }

                public boolean hasIndoorLocTech() {
                    return this.hasIndoorLocTech;
                }

                public boolean hasName() {
                    return this.hasName;
                }

                public boolean hasPt() {
                    return this.hasPt;
                }

                public boolean hasPtPopinf() {
                    return this.hasPtPopinf;
                }

                public boolean hasRealityPointGifUrl() {
                    return this.hasRealityPointGifUrl;
                }

                public boolean hasRtBus() {
                    return this.hasRtBus;
                }

                public boolean hasSubuid() {
                    return this.hasSubuid;
                }

                public boolean hasUid() {
                    return this.hasUid;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public Point_Info mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        switch (tag) {
                            case 0:
                                return this;
                            case 10:
                                setPt(codedInputStreamMicro.readString());
                                break;
                            case 18:
                                setName(codedInputStreamMicro.readString());
                                break;
                            case 26:
                                setUid(codedInputStreamMicro.readString());
                                break;
                            case 32:
                                addSpt(codedInputStreamMicro.readSInt32());
                                break;
                            case 42:
                                setFloor(codedInputStreamMicro.readString());
                                break;
                            case 50:
                                setBuilding(codedInputStreamMicro.readString());
                                break;
                            case 56:
                                addGpt(codedInputStreamMicro.readSInt32());
                                break;
                            case 64:
                                addDispt(codedInputStreamMicro.readSInt32());
                                break;
                            case 74:
                                setBuildingname(codedInputStreamMicro.readString());
                                break;
                            case 82:
                                setFloorInfo(codedInputStreamMicro.readString());
                                break;
                            case 90:
                                BuildingInfos buildingInfos = new BuildingInfos();
                                codedInputStreamMicro.readMessage(buildingInfos);
                                setBuildingInfos(buildingInfos);
                                break;
                            case 98:
                                TrafficHubPort trafficHubPort = new TrafficHubPort();
                                codedInputStreamMicro.readMessage(trafficHubPort);
                                addTInfo(trafficHubPort);
                                break;
                            case 104:
                                setIndoorLocTech(codedInputStreamMicro.readInt32());
                                break;
                            case 114:
                                setRealityPointGifUrl(codedInputStreamMicro.readString());
                                break;
                            case 122:
                                setSubuid(codedInputStreamMicro.readString());
                                break;
                            case 128:
                                setRtBus(codedInputStreamMicro.readInt32());
                                break;
                            case 138:
                                PtPopInf ptPopInf = new PtPopInf();
                                codedInputStreamMicro.readMessage(ptPopInf);
                                setPtPopinf(ptPopInf);
                                break;
                            default:
                                if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                    return this;
                                }
                                break;
                                break;
                        }
                    }
                }

                public Point_Info setBuilding(String str) {
                    this.hasBuilding = true;
                    this.building_ = str;
                    return this;
                }

                public Point_Info setBuildingInfos(BuildingInfos buildingInfos) {
                    if (buildingInfos == null) {
                        return clearBuildingInfos();
                    }
                    this.hasBuildingInfos = true;
                    this.buildingInfos_ = buildingInfos;
                    return this;
                }

                public Point_Info setBuildingname(String str) {
                    this.hasBuildingname = true;
                    this.buildingname_ = str;
                    return this;
                }

                public Point_Info setDispt(int i, int i2) {
                    this.dispt_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Point_Info setFloor(String str) {
                    this.hasFloor = true;
                    this.floor_ = str;
                    return this;
                }

                public Point_Info setFloorInfo(String str) {
                    this.hasFloorInfo = true;
                    this.floorInfo_ = str;
                    return this;
                }

                public Point_Info setGpt(int i, int i2) {
                    this.gpt_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Point_Info setIndoorLocTech(int i) {
                    this.hasIndoorLocTech = true;
                    this.indoorLocTech_ = i;
                    return this;
                }

                public Point_Info setName(String str) {
                    this.hasName = true;
                    this.name_ = str;
                    return this;
                }

                public Point_Info setPt(String str) {
                    this.hasPt = true;
                    this.pt_ = str;
                    return this;
                }

                public Point_Info setPtPopinf(PtPopInf ptPopInf) {
                    if (ptPopInf == null) {
                        return clearPtPopinf();
                    }
                    this.hasPtPopinf = true;
                    this.ptPopinf_ = ptPopInf;
                    return this;
                }

                public Point_Info setRealityPointGifUrl(String str) {
                    this.hasRealityPointGifUrl = true;
                    this.realityPointGifUrl_ = str;
                    return this;
                }

                public Point_Info setRtBus(int i) {
                    this.hasRtBus = true;
                    this.rtBus_ = i;
                    return this;
                }

                public Point_Info setSpt(int i, int i2) {
                    this.spt_.set(i, Integer.valueOf(i2));
                    return this;
                }

                public Point_Info setSubuid(String str) {
                    this.hasSubuid = true;
                    this.subuid_ = str;
                    return this;
                }

                public Point_Info setTInfo(int i, TrafficHubPort trafficHubPort) {
                    if (trafficHubPort == null) {
                        return this;
                    }
                    this.tInfo_.set(i, trafficHubPort);
                    return this;
                }

                public Point_Info setUid(String str) {
                    this.hasUid = true;
                    this.uid_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasPt()) {
                        codedOutputStreamMicro.writeString(1, getPt());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(3, getUid());
                    }
                    Iterator<Integer> it = getSptList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(4, it.next().intValue());
                    }
                    if (hasFloor()) {
                        codedOutputStreamMicro.writeString(5, getFloor());
                    }
                    if (hasBuilding()) {
                        codedOutputStreamMicro.writeString(6, getBuilding());
                    }
                    Iterator<Integer> it2 = getGptList().iterator();
                    while (it2.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(7, it2.next().intValue());
                    }
                    Iterator<Integer> it3 = getDisptList().iterator();
                    while (it3.hasNext()) {
                        codedOutputStreamMicro.writeSInt32(8, it3.next().intValue());
                    }
                    if (hasBuildingname()) {
                        codedOutputStreamMicro.writeString(9, getBuildingname());
                    }
                    if (hasFloorInfo()) {
                        codedOutputStreamMicro.writeString(10, getFloorInfo());
                    }
                    if (hasBuildingInfos()) {
                        codedOutputStreamMicro.writeMessage(11, getBuildingInfos());
                    }
                    Iterator<TrafficHubPort> it4 = getTInfoList().iterator();
                    while (it4.hasNext()) {
                        codedOutputStreamMicro.writeMessage(12, it4.next());
                    }
                    if (hasIndoorLocTech()) {
                        codedOutputStreamMicro.writeInt32(13, getIndoorLocTech());
                    }
                    if (hasRealityPointGifUrl()) {
                        codedOutputStreamMicro.writeString(14, getRealityPointGifUrl());
                    }
                    if (hasSubuid()) {
                        codedOutputStreamMicro.writeString(15, getSubuid());
                    }
                    if (hasRtBus()) {
                        codedOutputStreamMicro.writeInt32(16, getRtBus());
                    }
                    if (hasPtPopinf()) {
                        codedOutputStreamMicro.writeMessage(17, getPtPopinf());
                    }
                }
            }

            public static final class PreviewRouteSceneInfo extends MessageMicro {
                public static final int BUTTON_TXT_FIELD_NUMBER = 2;
                public static final int IS_DISPLAY_FIELD_NUMBER = 1;
                public static final int JUMP_URL_FIELD_NUMBER = 4;
                public static final int SUPERSCRIPT_TXT_FIELD_NUMBER = 3;
                private boolean hasButtonTxt;
                private boolean hasIsDisplay;
                private boolean hasJumpUrl;
                private boolean hasSuperscriptTxt;
                private int isDisplay_ = 0;
                private String buttonTxt_ = "";
                private String superscriptTxt_ = "";
                private String jumpUrl_ = "";
                private int cachedSize = -1;

                public static PreviewRouteSceneInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new PreviewRouteSceneInfo().mergeFrom(codedInputStreamMicro);
                }

                public static PreviewRouteSceneInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (PreviewRouteSceneInfo) new PreviewRouteSceneInfo().mergeFrom(bArr);
                }

                public final PreviewRouteSceneInfo clear() {
                    clearIsDisplay();
                    clearButtonTxt();
                    clearSuperscriptTxt();
                    clearJumpUrl();
                    this.cachedSize = -1;
                    return this;
                }

                public PreviewRouteSceneInfo clearButtonTxt() {
                    this.hasButtonTxt = false;
                    this.buttonTxt_ = "";
                    return this;
                }

                public PreviewRouteSceneInfo clearIsDisplay() {
                    this.hasIsDisplay = false;
                    this.isDisplay_ = 0;
                    return this;
                }

                public PreviewRouteSceneInfo clearJumpUrl() {
                    this.hasJumpUrl = false;
                    this.jumpUrl_ = "";
                    return this;
                }

                public PreviewRouteSceneInfo clearSuperscriptTxt() {
                    this.hasSuperscriptTxt = false;
                    this.superscriptTxt_ = "";
                    return this;
                }

                public String getButtonTxt() {
                    return this.buttonTxt_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public int getIsDisplay() {
                    return this.isDisplay_;
                }

                public String getJumpUrl() {
                    return this.jumpUrl_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeInt32Size = hasIsDisplay() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsDisplay()) : 0;
                    if (hasButtonTxt()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getButtonTxt());
                    }
                    if (hasSuperscriptTxt()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(3, getSuperscriptTxt());
                    }
                    if (hasJumpUrl()) {
                        iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
                    }
                    this.cachedSize = iComputeInt32Size;
                    return iComputeInt32Size;
                }

                public String getSuperscriptTxt() {
                    return this.superscriptTxt_;
                }

                public boolean hasButtonTxt() {
                    return this.hasButtonTxt;
                }

                public boolean hasIsDisplay() {
                    return this.hasIsDisplay;
                }

                public boolean hasJumpUrl() {
                    return this.hasJumpUrl;
                }

                public boolean hasSuperscriptTxt() {
                    return this.hasSuperscriptTxt;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public PreviewRouteSceneInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 8) {
                            setIsDisplay(codedInputStreamMicro.readInt32());
                        } else if (tag == 18) {
                            setButtonTxt(codedInputStreamMicro.readString());
                        } else if (tag == 26) {
                            setSuperscriptTxt(codedInputStreamMicro.readString());
                        } else if (tag == 34) {
                            setJumpUrl(codedInputStreamMicro.readString());
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public PreviewRouteSceneInfo setButtonTxt(String str) {
                    this.hasButtonTxt = true;
                    this.buttonTxt_ = str;
                    return this;
                }

                public PreviewRouteSceneInfo setIsDisplay(int i) {
                    this.hasIsDisplay = true;
                    this.isDisplay_ = i;
                    return this;
                }

                public PreviewRouteSceneInfo setJumpUrl(String str) {
                    this.hasJumpUrl = true;
                    this.jumpUrl_ = str;
                    return this;
                }

                public PreviewRouteSceneInfo setSuperscriptTxt(String str) {
                    this.hasSuperscriptTxt = true;
                    this.superscriptTxt_ = str;
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasIsDisplay()) {
                        codedOutputStreamMicro.writeInt32(1, getIsDisplay());
                    }
                    if (hasButtonTxt()) {
                        codedOutputStreamMicro.writeString(2, getButtonTxt());
                    }
                    if (hasSuperscriptTxt()) {
                        codedOutputStreamMicro.writeString(3, getSuperscriptTxt());
                    }
                    if (hasJumpUrl()) {
                        codedOutputStreamMicro.writeString(4, getJumpUrl());
                    }
                }
            }

            public static final class ResultCardInfo extends MessageMicro {
                public static final int ALTITUDE_DATA_INFO_FIELD_NUMBER = 3;
                public static final int CARD_TYPE_FIELD_NUMBER = 1;
                public static final int DATA_FIELD_NUMBER = 2;
                public static final int VIEW_TICKET_INFO_FIELD_NUMBER = 4;
                private boolean hasAltitudeDataInfo;
                private boolean hasCardType;
                private boolean hasData;
                private String cardType_ = "";
                private String data_ = "";
                private AltitudeDataInfo altitudeDataInfo_ = null;
                private List<ViewTicketsInfo> viewTicketInfo_ = Collections.emptyList();
                private int cachedSize = -1;

                public static final class AltitudeDataInfo extends MessageMicro {
                    public static final int ASCENT_ALTITUDE_FIELD_NUMBER = 3;
                    public static final int CHART_INFO_FIELD_NUMBER = 5;
                    public static final int DESCENT_ALTITUDE_FIELD_NUMBER = 4;
                    public static final int DOWNHILL_TOTAL_DIS_FIELD_NUMBER = 2;
                    public static final int UPHILL_TOTAL_DIS_FIELD_NUMBER = 1;
                    private boolean hasAscentAltitude;
                    private boolean hasDescentAltitude;
                    private boolean hasDownhillTotalDis;
                    private boolean hasUphillTotalDis;
                    private int uphillTotalDis_ = 0;
                    private int downhillTotalDis_ = 0;
                    private int ascentAltitude_ = 0;
                    private int descentAltitude_ = 0;
                    private List<AltitudeDataLineChartInfo> chartInfo_ = Collections.emptyList();
                    private int cachedSize = -1;

                    public static final class AltitudeDataLineChartInfo extends MessageMicro {
                        public static final int ALTITUDE_FIELD_NUMBER = 2;
                        public static final int DIS_FIELD_NUMBER = 1;
                        private boolean hasAltitude;
                        private boolean hasDis;
                        private int dis_ = 0;
                        private int altitude_ = 0;
                        private int cachedSize = -1;

                        public static AltitudeDataLineChartInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new AltitudeDataLineChartInfo().mergeFrom(codedInputStreamMicro);
                        }

                        public static AltitudeDataLineChartInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (AltitudeDataLineChartInfo) new AltitudeDataLineChartInfo().mergeFrom(bArr);
                        }

                        public final AltitudeDataLineChartInfo clear() {
                            clearDis();
                            clearAltitude();
                            this.cachedSize = -1;
                            return this;
                        }

                        public AltitudeDataLineChartInfo clearAltitude() {
                            this.hasAltitude = false;
                            this.altitude_ = 0;
                            return this;
                        }

                        public AltitudeDataLineChartInfo clearDis() {
                            this.hasDis = false;
                            this.dis_ = 0;
                            return this;
                        }

                        public int getAltitude() {
                            return this.altitude_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getCachedSize() {
                            if (this.cachedSize < 0) {
                                getSerializedSize();
                            }
                            return this.cachedSize;
                        }

                        public int getDis() {
                            return this.dis_;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public int getSerializedSize() {
                            int iComputeInt32Size = hasDis() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getDis()) : 0;
                            if (hasAltitude()) {
                                iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getAltitude());
                            }
                            this.cachedSize = iComputeInt32Size;
                            return iComputeInt32Size;
                        }

                        public boolean hasAltitude() {
                            return this.hasAltitude;
                        }

                        public boolean hasDis() {
                            return this.hasDis;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public AltitudeDataLineChartInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int tag = codedInputStreamMicro.readTag();
                                if (tag == 0) {
                                    return this;
                                }
                                if (tag == 8) {
                                    setDis(codedInputStreamMicro.readInt32());
                                } else if (tag == 16) {
                                    setAltitude(codedInputStreamMicro.readInt32());
                                } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                    return this;
                                }
                            }
                        }

                        public AltitudeDataLineChartInfo setAltitude(int i) {
                            this.hasAltitude = true;
                            this.altitude_ = i;
                            return this;
                        }

                        public AltitudeDataLineChartInfo setDis(int i) {
                            this.hasDis = true;
                            this.dis_ = i;
                            return this;
                        }

                        @Override // com.google.protobuf.micro.MessageMicro
                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasDis()) {
                                codedOutputStreamMicro.writeInt32(1, getDis());
                            }
                            if (hasAltitude()) {
                                codedOutputStreamMicro.writeInt32(2, getAltitude());
                            }
                        }
                    }

                    public static AltitudeDataInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new AltitudeDataInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static AltitudeDataInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (AltitudeDataInfo) new AltitudeDataInfo().mergeFrom(bArr);
                    }

                    public AltitudeDataInfo addChartInfo(AltitudeDataLineChartInfo altitudeDataLineChartInfo) {
                        if (altitudeDataLineChartInfo == null) {
                            return this;
                        }
                        if (this.chartInfo_.isEmpty()) {
                            this.chartInfo_ = new ArrayList();
                        }
                        this.chartInfo_.add(altitudeDataLineChartInfo);
                        return this;
                    }

                    public final AltitudeDataInfo clear() {
                        clearUphillTotalDis();
                        clearDownhillTotalDis();
                        clearAscentAltitude();
                        clearDescentAltitude();
                        clearChartInfo();
                        this.cachedSize = -1;
                        return this;
                    }

                    public AltitudeDataInfo clearAscentAltitude() {
                        this.hasAscentAltitude = false;
                        this.ascentAltitude_ = 0;
                        return this;
                    }

                    public AltitudeDataInfo clearChartInfo() {
                        this.chartInfo_ = Collections.emptyList();
                        return this;
                    }

                    public AltitudeDataInfo clearDescentAltitude() {
                        this.hasDescentAltitude = false;
                        this.descentAltitude_ = 0;
                        return this;
                    }

                    public AltitudeDataInfo clearDownhillTotalDis() {
                        this.hasDownhillTotalDis = false;
                        this.downhillTotalDis_ = 0;
                        return this;
                    }

                    public AltitudeDataInfo clearUphillTotalDis() {
                        this.hasUphillTotalDis = false;
                        this.uphillTotalDis_ = 0;
                        return this;
                    }

                    public int getAscentAltitude() {
                        return this.ascentAltitude_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public AltitudeDataLineChartInfo getChartInfo(int i) {
                        return this.chartInfo_.get(i);
                    }

                    public int getChartInfoCount() {
                        return this.chartInfo_.size();
                    }

                    public List<AltitudeDataLineChartInfo> getChartInfoList() {
                        return this.chartInfo_;
                    }

                    public int getDescentAltitude() {
                        return this.descentAltitude_;
                    }

                    public int getDownhillTotalDis() {
                        return this.downhillTotalDis_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeInt32Size = hasUphillTotalDis() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getUphillTotalDis()) : 0;
                        if (hasDownhillTotalDis()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getDownhillTotalDis());
                        }
                        if (hasAscentAltitude()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(3, getAscentAltitude());
                        }
                        if (hasDescentAltitude()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(4, getDescentAltitude());
                        }
                        Iterator<AltitudeDataLineChartInfo> it = getChartInfoList().iterator();
                        while (it.hasNext()) {
                            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, it.next());
                        }
                        this.cachedSize = iComputeInt32Size;
                        return iComputeInt32Size;
                    }

                    public int getUphillTotalDis() {
                        return this.uphillTotalDis_;
                    }

                    public boolean hasAscentAltitude() {
                        return this.hasAscentAltitude;
                    }

                    public boolean hasDescentAltitude() {
                        return this.hasDescentAltitude;
                    }

                    public boolean hasDownhillTotalDis() {
                        return this.hasDownhillTotalDis;
                    }

                    public boolean hasUphillTotalDis() {
                        return this.hasUphillTotalDis;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public AltitudeDataInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 8) {
                                setUphillTotalDis(codedInputStreamMicro.readInt32());
                            } else if (tag == 16) {
                                setDownhillTotalDis(codedInputStreamMicro.readInt32());
                            } else if (tag == 24) {
                                setAscentAltitude(codedInputStreamMicro.readInt32());
                            } else if (tag == 32) {
                                setDescentAltitude(codedInputStreamMicro.readInt32());
                            } else if (tag == 42) {
                                AltitudeDataLineChartInfo altitudeDataLineChartInfo = new AltitudeDataLineChartInfo();
                                codedInputStreamMicro.readMessage(altitudeDataLineChartInfo);
                                addChartInfo(altitudeDataLineChartInfo);
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public AltitudeDataInfo setAscentAltitude(int i) {
                        this.hasAscentAltitude = true;
                        this.ascentAltitude_ = i;
                        return this;
                    }

                    public AltitudeDataInfo setChartInfo(int i, AltitudeDataLineChartInfo altitudeDataLineChartInfo) {
                        if (altitudeDataLineChartInfo == null) {
                            return this;
                        }
                        this.chartInfo_.set(i, altitudeDataLineChartInfo);
                        return this;
                    }

                    public AltitudeDataInfo setDescentAltitude(int i) {
                        this.hasDescentAltitude = true;
                        this.descentAltitude_ = i;
                        return this;
                    }

                    public AltitudeDataInfo setDownhillTotalDis(int i) {
                        this.hasDownhillTotalDis = true;
                        this.downhillTotalDis_ = i;
                        return this;
                    }

                    public AltitudeDataInfo setUphillTotalDis(int i) {
                        this.hasUphillTotalDis = true;
                        this.uphillTotalDis_ = i;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasUphillTotalDis()) {
                            codedOutputStreamMicro.writeInt32(1, getUphillTotalDis());
                        }
                        if (hasDownhillTotalDis()) {
                            codedOutputStreamMicro.writeInt32(2, getDownhillTotalDis());
                        }
                        if (hasAscentAltitude()) {
                            codedOutputStreamMicro.writeInt32(3, getAscentAltitude());
                        }
                        if (hasDescentAltitude()) {
                            codedOutputStreamMicro.writeInt32(4, getDescentAltitude());
                        }
                        Iterator<AltitudeDataLineChartInfo> it = getChartInfoList().iterator();
                        while (it.hasNext()) {
                            codedOutputStreamMicro.writeMessage(5, it.next());
                        }
                    }
                }

                public static final class ViewTicketsInfo extends MessageMicro {
                    public static final int BOOKING_TIME_TAG_FIELD_NUMBER = 3;
                    public static final int BOOKING_URL_FIELD_NUMBER = 5;
                    public static final int NAME_FIELD_NUMBER = 1;
                    public static final int PRICE_FIELD_NUMBER = 2;
                    public static final int REFUND_TYPE_TAG_FIELD_NUMBER = 4;
                    private boolean hasBookingTimeTag;
                    private boolean hasBookingUrl;
                    private boolean hasName;
                    private boolean hasPrice;
                    private boolean hasRefundTypeTag;
                    private String name_ = "";
                    private int price_ = 0;
                    private String bookingTimeTag_ = "";
                    private String refundTypeTag_ = "";
                    private String bookingUrl_ = "";
                    private int cachedSize = -1;

                    public static ViewTicketsInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new ViewTicketsInfo().mergeFrom(codedInputStreamMicro);
                    }

                    public static ViewTicketsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (ViewTicketsInfo) new ViewTicketsInfo().mergeFrom(bArr);
                    }

                    public final ViewTicketsInfo clear() {
                        clearName();
                        clearPrice();
                        clearBookingTimeTag();
                        clearRefundTypeTag();
                        clearBookingUrl();
                        this.cachedSize = -1;
                        return this;
                    }

                    public ViewTicketsInfo clearBookingTimeTag() {
                        this.hasBookingTimeTag = false;
                        this.bookingTimeTag_ = "";
                        return this;
                    }

                    public ViewTicketsInfo clearBookingUrl() {
                        this.hasBookingUrl = false;
                        this.bookingUrl_ = "";
                        return this;
                    }

                    public ViewTicketsInfo clearName() {
                        this.hasName = false;
                        this.name_ = "";
                        return this;
                    }

                    public ViewTicketsInfo clearPrice() {
                        this.hasPrice = false;
                        this.price_ = 0;
                        return this;
                    }

                    public ViewTicketsInfo clearRefundTypeTag() {
                        this.hasRefundTypeTag = false;
                        this.refundTypeTag_ = "";
                        return this;
                    }

                    public String getBookingTimeTag() {
                        return this.bookingTimeTag_;
                    }

                    public String getBookingUrl() {
                        return this.bookingUrl_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getCachedSize() {
                        if (this.cachedSize < 0) {
                            getSerializedSize();
                        }
                        return this.cachedSize;
                    }

                    public String getName() {
                        return this.name_;
                    }

                    public int getPrice() {
                        return this.price_;
                    }

                    public String getRefundTypeTag() {
                        return this.refundTypeTag_;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public int getSerializedSize() {
                        int iComputeStringSize = hasName() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getName()) : 0;
                        if (hasPrice()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getPrice());
                        }
                        if (hasBookingTimeTag()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getBookingTimeTag());
                        }
                        if (hasRefundTypeTag()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(4, getRefundTypeTag());
                        }
                        if (hasBookingUrl()) {
                            iComputeStringSize += CodedOutputStreamMicro.computeStringSize(5, getBookingUrl());
                        }
                        this.cachedSize = iComputeStringSize;
                        return iComputeStringSize;
                    }

                    public boolean hasBookingTimeTag() {
                        return this.hasBookingTimeTag;
                    }

                    public boolean hasBookingUrl() {
                        return this.hasBookingUrl;
                    }

                    public boolean hasName() {
                        return this.hasName;
                    }

                    public boolean hasPrice() {
                        return this.hasPrice;
                    }

                    public boolean hasRefundTypeTag() {
                        return this.hasRefundTypeTag;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public ViewTicketsInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int tag = codedInputStreamMicro.readTag();
                            if (tag == 0) {
                                return this;
                            }
                            if (tag == 10) {
                                setName(codedInputStreamMicro.readString());
                            } else if (tag == 16) {
                                setPrice(codedInputStreamMicro.readInt32());
                            } else if (tag == 26) {
                                setBookingTimeTag(codedInputStreamMicro.readString());
                            } else if (tag == 34) {
                                setRefundTypeTag(codedInputStreamMicro.readString());
                            } else if (tag == 42) {
                                setBookingUrl(codedInputStreamMicro.readString());
                            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                        }
                    }

                    public ViewTicketsInfo setBookingTimeTag(String str) {
                        this.hasBookingTimeTag = true;
                        this.bookingTimeTag_ = str;
                        return this;
                    }

                    public ViewTicketsInfo setBookingUrl(String str) {
                        this.hasBookingUrl = true;
                        this.bookingUrl_ = str;
                        return this;
                    }

                    public ViewTicketsInfo setName(String str) {
                        this.hasName = true;
                        this.name_ = str;
                        return this;
                    }

                    public ViewTicketsInfo setPrice(int i) {
                        this.hasPrice = true;
                        this.price_ = i;
                        return this;
                    }

                    public ViewTicketsInfo setRefundTypeTag(String str) {
                        this.hasRefundTypeTag = true;
                        this.refundTypeTag_ = str;
                        return this;
                    }

                    @Override // com.google.protobuf.micro.MessageMicro
                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasName()) {
                            codedOutputStreamMicro.writeString(1, getName());
                        }
                        if (hasPrice()) {
                            codedOutputStreamMicro.writeInt32(2, getPrice());
                        }
                        if (hasBookingTimeTag()) {
                            codedOutputStreamMicro.writeString(3, getBookingTimeTag());
                        }
                        if (hasRefundTypeTag()) {
                            codedOutputStreamMicro.writeString(4, getRefundTypeTag());
                        }
                        if (hasBookingUrl()) {
                            codedOutputStreamMicro.writeString(5, getBookingUrl());
                        }
                    }
                }

                public static ResultCardInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new ResultCardInfo().mergeFrom(codedInputStreamMicro);
                }

                public static ResultCardInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (ResultCardInfo) new ResultCardInfo().mergeFrom(bArr);
                }

                public ResultCardInfo addViewTicketInfo(ViewTicketsInfo viewTicketsInfo) {
                    if (viewTicketsInfo == null) {
                        return this;
                    }
                    if (this.viewTicketInfo_.isEmpty()) {
                        this.viewTicketInfo_ = new ArrayList();
                    }
                    this.viewTicketInfo_.add(viewTicketsInfo);
                    return this;
                }

                public final ResultCardInfo clear() {
                    clearCardType();
                    clearData();
                    clearAltitudeDataInfo();
                    clearViewTicketInfo();
                    this.cachedSize = -1;
                    return this;
                }

                public ResultCardInfo clearAltitudeDataInfo() {
                    this.hasAltitudeDataInfo = false;
                    this.altitudeDataInfo_ = null;
                    return this;
                }

                public ResultCardInfo clearCardType() {
                    this.hasCardType = false;
                    this.cardType_ = "";
                    return this;
                }

                public ResultCardInfo clearData() {
                    this.hasData = false;
                    this.data_ = "";
                    return this;
                }

                public ResultCardInfo clearViewTicketInfo() {
                    this.viewTicketInfo_ = Collections.emptyList();
                    return this;
                }

                public AltitudeDataInfo getAltitudeDataInfo() {
                    return this.altitudeDataInfo_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getCachedSize() {
                    if (this.cachedSize < 0) {
                        getSerializedSize();
                    }
                    return this.cachedSize;
                }

                public String getCardType() {
                    return this.cardType_;
                }

                public String getData() {
                    return this.data_;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public int getSerializedSize() {
                    int iComputeStringSize = hasCardType() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getCardType()) : 0;
                    if (hasData()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getData());
                    }
                    if (hasAltitudeDataInfo()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getAltitudeDataInfo());
                    }
                    Iterator<ViewTicketsInfo> it = getViewTicketInfoList().iterator();
                    while (it.hasNext()) {
                        iComputeStringSize += CodedOutputStreamMicro.computeMessageSize(4, it.next());
                    }
                    this.cachedSize = iComputeStringSize;
                    return iComputeStringSize;
                }

                public ViewTicketsInfo getViewTicketInfo(int i) {
                    return this.viewTicketInfo_.get(i);
                }

                public int getViewTicketInfoCount() {
                    return this.viewTicketInfo_.size();
                }

                public List<ViewTicketsInfo> getViewTicketInfoList() {
                    return this.viewTicketInfo_;
                }

                public boolean hasAltitudeDataInfo() {
                    return this.hasAltitudeDataInfo;
                }

                public boolean hasCardType() {
                    return this.hasCardType;
                }

                public boolean hasData() {
                    return this.hasData;
                }

                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public ResultCardInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int tag = codedInputStreamMicro.readTag();
                        if (tag == 0) {
                            return this;
                        }
                        if (tag == 10) {
                            setCardType(codedInputStreamMicro.readString());
                        } else if (tag == 18) {
                            setData(codedInputStreamMicro.readString());
                        } else if (tag == 26) {
                            AltitudeDataInfo altitudeDataInfo = new AltitudeDataInfo();
                            codedInputStreamMicro.readMessage(altitudeDataInfo);
                            setAltitudeDataInfo(altitudeDataInfo);
                        } else if (tag == 34) {
                            ViewTicketsInfo viewTicketsInfo = new ViewTicketsInfo();
                            codedInputStreamMicro.readMessage(viewTicketsInfo);
                            addViewTicketInfo(viewTicketsInfo);
                        } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                    }
                }

                public ResultCardInfo setAltitudeDataInfo(AltitudeDataInfo altitudeDataInfo) {
                    if (altitudeDataInfo == null) {
                        return clearAltitudeDataInfo();
                    }
                    this.hasAltitudeDataInfo = true;
                    this.altitudeDataInfo_ = altitudeDataInfo;
                    return this;
                }

                public ResultCardInfo setCardType(String str) {
                    this.hasCardType = true;
                    this.cardType_ = str;
                    return this;
                }

                public ResultCardInfo setData(String str) {
                    this.hasData = true;
                    this.data_ = str;
                    return this;
                }

                public ResultCardInfo setViewTicketInfo(int i, ViewTicketsInfo viewTicketsInfo) {
                    if (viewTicketsInfo == null) {
                        return this;
                    }
                    this.viewTicketInfo_.set(i, viewTicketsInfo);
                    return this;
                }

                @Override // com.google.protobuf.micro.MessageMicro
                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCardType()) {
                        codedOutputStreamMicro.writeString(1, getCardType());
                    }
                    if (hasData()) {
                        codedOutputStreamMicro.writeString(2, getData());
                    }
                    if (hasAltitudeDataInfo()) {
                        codedOutputStreamMicro.writeMessage(3, getAltitudeDataInfo());
                    }
                    Iterator<ViewTicketsInfo> it = getViewTicketInfoList().iterator();
                    while (it.hasNext()) {
                        codedOutputStreamMicro.writeMessage(4, it.next());
                    }
                }
            }

            public static PolicyInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new PolicyInfo().mergeFrom(codedInputStreamMicro);
            }

            public static PolicyInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (PolicyInfo) new PolicyInfo().mergeFrom(bArr);
            }

            public PolicyInfo addEnd(Point_Info point_Info) {
                if (point_Info == null) {
                    return this;
                }
                if (this.end_.isEmpty()) {
                    this.end_ = new ArrayList();
                }
                this.end_.add(point_Info);
                return this;
            }

            public PolicyInfo addResultCards(ResultCardInfo resultCardInfo) {
                if (resultCardInfo == null) {
                    return this;
                }
                if (this.resultCards_.isEmpty()) {
                    this.resultCards_ = new ArrayList();
                }
                this.resultCards_.add(resultCardInfo);
                return this;
            }

            public final PolicyInfo clear() {
                clearRtIdx();
                clearLabel();
                clearStart();
                clearEnd();
                clearTaxi();
                clearResultCards();
                clearPreviewRouteScene();
                clearLabelTipBar();
                clearOperationLabelContent();
                clearOperationLabelStyle();
                clearCalorie();
                this.cachedSize = -1;
                return this;
            }

            public PolicyInfo clearCalorie() {
                this.hasCalorie = false;
                this.calorie_ = 0;
                return this;
            }

            public PolicyInfo clearEnd() {
                this.end_ = Collections.emptyList();
                return this;
            }

            public PolicyInfo clearLabel() {
                this.hasLabel = false;
                this.label_ = "";
                return this;
            }

            public PolicyInfo clearLabelTipBar() {
                this.hasLabelTipBar = false;
                this.labelTipBar_ = null;
                return this;
            }

            public PolicyInfo clearOperationLabelContent() {
                this.hasOperationLabelContent = false;
                this.operationLabelContent_ = "";
                return this;
            }

            public PolicyInfo clearOperationLabelStyle() {
                this.hasOperationLabelStyle = false;
                this.operationLabelStyle_ = null;
                return this;
            }

            public PolicyInfo clearPreviewRouteScene() {
                this.hasPreviewRouteScene = false;
                this.previewRouteScene_ = null;
                return this;
            }

            public PolicyInfo clearResultCards() {
                this.resultCards_ = Collections.emptyList();
                return this;
            }

            public PolicyInfo clearRtIdx() {
                this.hasRtIdx = false;
                this.rtIdx_ = 0;
                return this;
            }

            public PolicyInfo clearStart() {
                this.hasStart = false;
                this.start_ = null;
                return this;
            }

            public PolicyInfo clearTaxi() {
                this.hasTaxi = false;
                this.taxi_ = null;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public int getCalorie() {
                return this.calorie_;
            }

            public Point_Info getEnd(int i) {
                return this.end_.get(i);
            }

            public int getEndCount() {
                return this.end_.size();
            }

            public List<Point_Info> getEndList() {
                return this.end_;
            }

            public String getLabel() {
                return this.label_;
            }

            public LabelTipBar getLabelTipBar() {
                return this.labelTipBar_;
            }

            public String getOperationLabelContent() {
                return this.operationLabelContent_;
            }

            public OperationLabelStyle getOperationLabelStyle() {
                return this.operationLabelStyle_;
            }

            public PreviewRouteSceneInfo getPreviewRouteScene() {
                return this.previewRouteScene_;
            }

            public ResultCardInfo getResultCards(int i) {
                return this.resultCards_.get(i);
            }

            public int getResultCardsCount() {
                return this.resultCards_.size();
            }

            public List<ResultCardInfo> getResultCardsList() {
                return this.resultCards_;
            }

            public int getRtIdx() {
                return this.rtIdx_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasRtIdx() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getRtIdx()) : 0;
                if (hasLabel()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getLabel());
                }
                if (hasStart()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getStart());
                }
                Iterator<Point_Info> it = getEndList().iterator();
                while (it.hasNext()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, it.next());
                }
                if (hasTaxi()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, getTaxi());
                }
                Iterator<ResultCardInfo> it2 = getResultCardsList().iterator();
                while (it2.hasNext()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(6, it2.next());
                }
                if (hasPreviewRouteScene()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(7, getPreviewRouteScene());
                }
                if (hasLabelTipBar()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(8, getLabelTipBar());
                }
                if (hasOperationLabelContent()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(9, getOperationLabelContent());
                }
                if (hasOperationLabelStyle()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(10, getOperationLabelStyle());
                }
                if (hasCalorie()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeUInt32Size(11, getCalorie());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public Point_Info getStart() {
                return this.start_;
            }

            public Taxi getTaxi() {
                return this.taxi_;
            }

            public boolean hasCalorie() {
                return this.hasCalorie;
            }

            public boolean hasLabel() {
                return this.hasLabel;
            }

            public boolean hasLabelTipBar() {
                return this.hasLabelTipBar;
            }

            public boolean hasOperationLabelContent() {
                return this.hasOperationLabelContent;
            }

            public boolean hasOperationLabelStyle() {
                return this.hasOperationLabelStyle;
            }

            public boolean hasPreviewRouteScene() {
                return this.hasPreviewRouteScene;
            }

            public boolean hasRtIdx() {
                return this.hasRtIdx;
            }

            public boolean hasStart() {
                return this.hasStart;
            }

            public boolean hasTaxi() {
                return this.hasTaxi;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public PolicyInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    switch (tag) {
                        case 0:
                            return this;
                        case 8:
                            setRtIdx(codedInputStreamMicro.readInt32());
                            break;
                        case 18:
                            setLabel(codedInputStreamMicro.readString());
                            break;
                        case 26:
                            Point_Info point_Info = new Point_Info();
                            codedInputStreamMicro.readMessage(point_Info);
                            setStart(point_Info);
                            break;
                        case 34:
                            Point_Info point_Info2 = new Point_Info();
                            codedInputStreamMicro.readMessage(point_Info2);
                            addEnd(point_Info2);
                            break;
                        case 42:
                            Taxi taxi = new Taxi();
                            codedInputStreamMicro.readMessage(taxi);
                            setTaxi(taxi);
                            break;
                        case 50:
                            ResultCardInfo resultCardInfo = new ResultCardInfo();
                            codedInputStreamMicro.readMessage(resultCardInfo);
                            addResultCards(resultCardInfo);
                            break;
                        case 58:
                            PreviewRouteSceneInfo previewRouteSceneInfo = new PreviewRouteSceneInfo();
                            codedInputStreamMicro.readMessage(previewRouteSceneInfo);
                            setPreviewRouteScene(previewRouteSceneInfo);
                            break;
                        case 66:
                            LabelTipBar labelTipBar = new LabelTipBar();
                            codedInputStreamMicro.readMessage(labelTipBar);
                            setLabelTipBar(labelTipBar);
                            break;
                        case 74:
                            setOperationLabelContent(codedInputStreamMicro.readString());
                            break;
                        case 82:
                            OperationLabelStyle operationLabelStyle = new OperationLabelStyle();
                            codedInputStreamMicro.readMessage(operationLabelStyle);
                            setOperationLabelStyle(operationLabelStyle);
                            break;
                        case 88:
                            setCalorie(codedInputStreamMicro.readUInt32());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStreamMicro, tag)) {
                                return this;
                            }
                            break;
                            break;
                    }
                }
            }

            public PolicyInfo setCalorie(int i) {
                this.hasCalorie = true;
                this.calorie_ = i;
                return this;
            }

            public PolicyInfo setEnd(int i, Point_Info point_Info) {
                if (point_Info == null) {
                    return this;
                }
                this.end_.set(i, point_Info);
                return this;
            }

            public PolicyInfo setLabel(String str) {
                this.hasLabel = true;
                this.label_ = str;
                return this;
            }

            public PolicyInfo setLabelTipBar(LabelTipBar labelTipBar) {
                if (labelTipBar == null) {
                    return clearLabelTipBar();
                }
                this.hasLabelTipBar = true;
                this.labelTipBar_ = labelTipBar;
                return this;
            }

            public PolicyInfo setOperationLabelContent(String str) {
                this.hasOperationLabelContent = true;
                this.operationLabelContent_ = str;
                return this;
            }

            public PolicyInfo setOperationLabelStyle(OperationLabelStyle operationLabelStyle) {
                if (operationLabelStyle == null) {
                    return clearOperationLabelStyle();
                }
                this.hasOperationLabelStyle = true;
                this.operationLabelStyle_ = operationLabelStyle;
                return this;
            }

            public PolicyInfo setPreviewRouteScene(PreviewRouteSceneInfo previewRouteSceneInfo) {
                if (previewRouteSceneInfo == null) {
                    return clearPreviewRouteScene();
                }
                this.hasPreviewRouteScene = true;
                this.previewRouteScene_ = previewRouteSceneInfo;
                return this;
            }

            public PolicyInfo setResultCards(int i, ResultCardInfo resultCardInfo) {
                if (resultCardInfo == null) {
                    return this;
                }
                this.resultCards_.set(i, resultCardInfo);
                return this;
            }

            public PolicyInfo setRtIdx(int i) {
                this.hasRtIdx = true;
                this.rtIdx_ = i;
                return this;
            }

            public PolicyInfo setStart(Point_Info point_Info) {
                if (point_Info == null) {
                    return clearStart();
                }
                this.hasStart = true;
                this.start_ = point_Info;
                return this;
            }

            public PolicyInfo setTaxi(Taxi taxi) {
                if (taxi == null) {
                    return clearTaxi();
                }
                this.hasTaxi = true;
                this.taxi_ = taxi;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasRtIdx()) {
                    codedOutputStreamMicro.writeInt32(1, getRtIdx());
                }
                if (hasLabel()) {
                    codedOutputStreamMicro.writeString(2, getLabel());
                }
                if (hasStart()) {
                    codedOutputStreamMicro.writeMessage(3, getStart());
                }
                Iterator<Point_Info> it = getEndList().iterator();
                while (it.hasNext()) {
                    codedOutputStreamMicro.writeMessage(4, it.next());
                }
                if (hasTaxi()) {
                    codedOutputStreamMicro.writeMessage(5, getTaxi());
                }
                Iterator<ResultCardInfo> it2 = getResultCardsList().iterator();
                while (it2.hasNext()) {
                    codedOutputStreamMicro.writeMessage(6, it2.next());
                }
                if (hasPreviewRouteScene()) {
                    codedOutputStreamMicro.writeMessage(7, getPreviewRouteScene());
                }
                if (hasLabelTipBar()) {
                    codedOutputStreamMicro.writeMessage(8, getLabelTipBar());
                }
                if (hasOperationLabelContent()) {
                    codedOutputStreamMicro.writeString(9, getOperationLabelContent());
                }
                if (hasOperationLabelStyle()) {
                    codedOutputStreamMicro.writeMessage(10, getOperationLabelStyle());
                }
                if (hasCalorie()) {
                    codedOutputStreamMicro.writeUInt32(11, getCalorie());
                }
            }
        }

        public static final class Tip extends MessageMicro {
            public static final int CONTENT_FIELD_NUMBER = 1;
            public static final int DARK_ICONURL_FIELD_NUMBER = 5;
            public static final int ICONURL_FIELD_NUMBER = 2;
            public static final int LINK_FIELD_NUMBER = 3;
            public static final int MATERIAL_TYPE_FIELD_NUMBER = 6;
            public static final int TYPE_FIELD_NUMBER = 4;
            private boolean hasContent;
            private boolean hasDarkIconurl;
            private boolean hasIconurl;
            private boolean hasLink;
            private boolean hasMaterialType;
            private boolean hasType;
            private String content_ = "";
            private String iconurl_ = "";
            private String link_ = "";
            private int type_ = 0;
            private String darkIconurl_ = "";
            private String materialType_ = "";
            private int cachedSize = -1;

            public static Tip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Tip().mergeFrom(codedInputStreamMicro);
            }

            public static Tip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Tip) new Tip().mergeFrom(bArr);
            }

            public final Tip clear() {
                clearContent();
                clearIconurl();
                clearLink();
                clearType();
                clearDarkIconurl();
                clearMaterialType();
                this.cachedSize = -1;
                return this;
            }

            public Tip clearContent() {
                this.hasContent = false;
                this.content_ = "";
                return this;
            }

            public Tip clearDarkIconurl() {
                this.hasDarkIconurl = false;
                this.darkIconurl_ = "";
                return this;
            }

            public Tip clearIconurl() {
                this.hasIconurl = false;
                this.iconurl_ = "";
                return this;
            }

            public Tip clearLink() {
                this.hasLink = false;
                this.link_ = "";
                return this;
            }

            public Tip clearMaterialType() {
                this.hasMaterialType = false;
                this.materialType_ = "";
                return this;
            }

            public Tip clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getContent() {
                return this.content_;
            }

            public String getDarkIconurl() {
                return this.darkIconurl_;
            }

            public String getIconurl() {
                return this.iconurl_;
            }

            public String getLink() {
                return this.link_;
            }

            public String getMaterialType() {
                return this.materialType_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeStringSize = hasContent() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getContent()) : 0;
                if (hasIconurl()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIconurl());
                }
                if (hasLink()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getLink());
                }
                if (hasType()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getType());
                }
                if (hasDarkIconurl()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(5, getDarkIconurl());
                }
                if (hasMaterialType()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(6, getMaterialType());
                }
                this.cachedSize = iComputeStringSize;
                return iComputeStringSize;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasContent() {
                return this.hasContent;
            }

            public boolean hasDarkIconurl() {
                return this.hasDarkIconurl;
            }

            public boolean hasIconurl() {
                return this.hasIconurl;
            }

            public boolean hasLink() {
                return this.hasLink;
            }

            public boolean hasMaterialType() {
                return this.hasMaterialType;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Tip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        setContent(codedInputStreamMicro.readString());
                    } else if (tag == 18) {
                        setIconurl(codedInputStreamMicro.readString());
                    } else if (tag == 26) {
                        setLink(codedInputStreamMicro.readString());
                    } else if (tag == 32) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (tag == 42) {
                        setDarkIconurl(codedInputStreamMicro.readString());
                    } else if (tag == 50) {
                        setMaterialType(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public Tip setContent(String str) {
                this.hasContent = true;
                this.content_ = str;
                return this;
            }

            public Tip setDarkIconurl(String str) {
                this.hasDarkIconurl = true;
                this.darkIconurl_ = str;
                return this;
            }

            public Tip setIconurl(String str) {
                this.hasIconurl = true;
                this.iconurl_ = str;
                return this;
            }

            public Tip setLink(String str) {
                this.hasLink = true;
                this.link_ = str;
                return this;
            }

            public Tip setMaterialType(String str) {
                this.hasMaterialType = true;
                this.materialType_ = str;
                return this;
            }

            public Tip setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasContent()) {
                    codedOutputStreamMicro.writeString(1, getContent());
                }
                if (hasIconurl()) {
                    codedOutputStreamMicro.writeString(2, getIconurl());
                }
                if (hasLink()) {
                    codedOutputStreamMicro.writeString(3, getLink());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(4, getType());
                }
                if (hasDarkIconurl()) {
                    codedOutputStreamMicro.writeString(5, getDarkIconurl());
                }
                if (hasMaterialType()) {
                    codedOutputStreamMicro.writeString(6, getMaterialType());
                }
            }
        }

        public static final class UgcInfo extends MessageMicro {
            public static final int MATERIAL_ID_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 1;
            private boolean hasMaterialId;
            private boolean hasType;
            private int type_ = 0;
            private String materialId_ = "";
            private int cachedSize = -1;

            public static UgcInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new UgcInfo().mergeFrom(codedInputStreamMicro);
            }

            public static UgcInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (UgcInfo) new UgcInfo().mergeFrom(bArr);
            }

            public final UgcInfo clear() {
                clearType();
                clearMaterialId();
                this.cachedSize = -1;
                return this;
            }

            public UgcInfo clearMaterialId() {
                this.hasMaterialId = false;
                this.materialId_ = "";
                return this;
            }

            public UgcInfo clearType() {
                this.hasType = false;
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getMaterialId() {
                return this.materialId_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeInt32Size = hasType() ? 0 + CodedOutputStreamMicro.computeInt32Size(1, getType()) : 0;
                if (hasMaterialId()) {
                    iComputeInt32Size += CodedOutputStreamMicro.computeStringSize(2, getMaterialId());
                }
                this.cachedSize = iComputeInt32Size;
                return iComputeInt32Size;
            }

            public int getType() {
                return this.type_;
            }

            public boolean hasMaterialId() {
                return this.hasMaterialId;
            }

            public boolean hasType() {
                return this.hasType;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public UgcInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        setType(codedInputStreamMicro.readInt32());
                    } else if (tag == 18) {
                        setMaterialId(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public UgcInfo setMaterialId(String str) {
                this.hasMaterialId = true;
                this.materialId_ = str;
                return this;
            }

            public UgcInfo setType(int i) {
                this.hasType = true;
                this.type_ = i;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(1, getType());
                }
                if (hasMaterialId()) {
                    codedOutputStreamMicro.writeString(2, getMaterialId());
                }
            }
        }

        public static Routes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Routes().mergeFrom(codedInputStreamMicro);
        }

        public static Routes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Routes) new Routes().mergeFrom(bArr);
        }

        public Routes addGuideInfo(Guideinfo guideinfo) {
            if (guideinfo == null) {
                return this;
            }
            if (this.guideInfo_.isEmpty()) {
                this.guideInfo_ = new ArrayList();
            }
            this.guideInfo_.add(guideinfo);
            return this;
        }

        public Routes addLegs(Legs legs) {
            if (legs == null) {
                return this;
            }
            if (this.legs_.isEmpty()) {
                this.legs_ = new ArrayList();
            }
            this.legs_.add(legs);
            return this;
        }

        public Routes addMapDrawInfo(MapDrawInfo mapDrawInfo) {
            if (mapDrawInfo == null) {
                return this;
            }
            if (this.mapDrawInfo_.isEmpty()) {
                this.mapDrawInfo_ = new ArrayList();
            }
            this.mapDrawInfo_.add(mapDrawInfo);
            return this;
        }

        public Routes addMsInfo(Milestone milestone) {
            if (milestone == null) {
                return this;
            }
            if (this.msInfo_.isEmpty()) {
                this.msInfo_ = new ArrayList();
            }
            this.msInfo_.add(milestone);
            return this;
        }

        public Routes addUgcInfo(UgcInfo ugcInfo) {
            if (ugcInfo == null) {
                return this;
            }
            if (this.ugcInfo_.isEmpty()) {
                this.ugcInfo_ = new ArrayList();
            }
            this.ugcInfo_.add(ugcInfo);
            return this;
        }

        public final Routes clear() {
            clearLegs();
            clearClimb();
            clearTip();
            clearOtherinfo();
            clearPlcyInfo();
            clearMsInfo();
            clearRouteIdf();
            clearGuideInfo();
            clearUgcInfo();
            clearMapDrawInfo();
            this.cachedSize = -1;
            return this;
        }

        public Routes clearClimb() {
            this.hasClimb = false;
            this.climb_ = null;
            return this;
        }

        public Routes clearGuideInfo() {
            this.guideInfo_ = Collections.emptyList();
            return this;
        }

        public Routes clearLegs() {
            this.legs_ = Collections.emptyList();
            return this;
        }

        public Routes clearMapDrawInfo() {
            this.mapDrawInfo_ = Collections.emptyList();
            return this;
        }

        public Routes clearMsInfo() {
            this.msInfo_ = Collections.emptyList();
            return this;
        }

        public Routes clearOtherinfo() {
            this.hasOtherinfo = false;
            this.otherinfo_ = null;
            return this;
        }

        public Routes clearPlcyInfo() {
            this.hasPlcyInfo = false;
            this.plcyInfo_ = null;
            return this;
        }

        public Routes clearRouteIdf() {
            this.hasRouteIdf = false;
            this.routeIdf_ = "";
            return this;
        }

        public Routes clearTip() {
            this.hasTip = false;
            this.tip_ = null;
            return this;
        }

        public Routes clearUgcInfo() {
            this.ugcInfo_ = Collections.emptyList();
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public Climb getClimb() {
            return this.climb_;
        }

        public Guideinfo getGuideInfo(int i) {
            return this.guideInfo_.get(i);
        }

        public int getGuideInfoCount() {
            return this.guideInfo_.size();
        }

        public List<Guideinfo> getGuideInfoList() {
            return this.guideInfo_;
        }

        public Legs getLegs(int i) {
            return this.legs_.get(i);
        }

        public int getLegsCount() {
            return this.legs_.size();
        }

        public List<Legs> getLegsList() {
            return this.legs_;
        }

        public MapDrawInfo getMapDrawInfo(int i) {
            return this.mapDrawInfo_.get(i);
        }

        public int getMapDrawInfoCount() {
            return this.mapDrawInfo_.size();
        }

        public List<MapDrawInfo> getMapDrawInfoList() {
            return this.mapDrawInfo_;
        }

        public Milestone getMsInfo(int i) {
            return this.msInfo_.get(i);
        }

        public int getMsInfoCount() {
            return this.msInfo_.size();
        }

        public List<Milestone> getMsInfoList() {
            return this.msInfo_;
        }

        public OtherInfo getOtherinfo() {
            return this.otherinfo_;
        }

        public PolicyInfo getPlcyInfo() {
            return this.plcyInfo_;
        }

        public String getRouteIdf() {
            return this.routeIdf_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            Iterator<Legs> it = getLegsList().iterator();
            int iComputeMessageSize = 0;
            while (it.hasNext()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(1, it.next());
            }
            if (hasClimb()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(2, getClimb());
            }
            if (hasTip()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(3, getTip());
            }
            if (hasOtherinfo()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(4, getOtherinfo());
            }
            if (hasPlcyInfo()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(5, getPlcyInfo());
            }
            Iterator<Milestone> it2 = getMsInfoList().iterator();
            while (it2.hasNext()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(6, it2.next());
            }
            if (hasRouteIdf()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeStringSize(7, getRouteIdf());
            }
            Iterator<Guideinfo> it3 = getGuideInfoList().iterator();
            while (it3.hasNext()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(8, it3.next());
            }
            Iterator<UgcInfo> it4 = getUgcInfoList().iterator();
            while (it4.hasNext()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(9, it4.next());
            }
            Iterator<MapDrawInfo> it5 = getMapDrawInfoList().iterator();
            while (it5.hasNext()) {
                iComputeMessageSize += CodedOutputStreamMicro.computeMessageSize(10, it5.next());
            }
            this.cachedSize = iComputeMessageSize;
            return iComputeMessageSize;
        }

        public Tip getTip() {
            return this.tip_;
        }

        public UgcInfo getUgcInfo(int i) {
            return this.ugcInfo_.get(i);
        }

        public int getUgcInfoCount() {
            return this.ugcInfo_.size();
        }

        public List<UgcInfo> getUgcInfoList() {
            return this.ugcInfo_;
        }

        public boolean hasClimb() {
            return this.hasClimb;
        }

        public boolean hasOtherinfo() {
            return this.hasOtherinfo;
        }

        public boolean hasPlcyInfo() {
            return this.hasPlcyInfo;
        }

        public boolean hasRouteIdf() {
            return this.hasRouteIdf;
        }

        public boolean hasTip() {
            return this.hasTip;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Routes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int tag = codedInputStreamMicro.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        Legs legs = new Legs();
                        codedInputStreamMicro.readMessage(legs);
                        addLegs(legs);
                        break;
                    case 18:
                        Climb climb = new Climb();
                        codedInputStreamMicro.readMessage(climb);
                        setClimb(climb);
                        break;
                    case 26:
                        Tip tip = new Tip();
                        codedInputStreamMicro.readMessage(tip);
                        setTip(tip);
                        break;
                    case 34:
                        OtherInfo otherInfo = new OtherInfo();
                        codedInputStreamMicro.readMessage(otherInfo);
                        setOtherinfo(otherInfo);
                        break;
                    case 42:
                        PolicyInfo policyInfo = new PolicyInfo();
                        codedInputStreamMicro.readMessage(policyInfo);
                        setPlcyInfo(policyInfo);
                        break;
                    case 50:
                        Milestone milestone = new Milestone();
                        codedInputStreamMicro.readMessage(milestone);
                        addMsInfo(milestone);
                        break;
                    case 58:
                        setRouteIdf(codedInputStreamMicro.readString());
                        break;
                    case 66:
                        Guideinfo guideinfo = new Guideinfo();
                        codedInputStreamMicro.readMessage(guideinfo);
                        addGuideInfo(guideinfo);
                        break;
                    case 74:
                        UgcInfo ugcInfo = new UgcInfo();
                        codedInputStreamMicro.readMessage(ugcInfo);
                        addUgcInfo(ugcInfo);
                        break;
                    case 82:
                        MapDrawInfo mapDrawInfo = new MapDrawInfo();
                        codedInputStreamMicro.readMessage(mapDrawInfo);
                        addMapDrawInfo(mapDrawInfo);
                        break;
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, tag)) {
                            return this;
                        }
                        break;
                        break;
                }
            }
        }

        public Routes setClimb(Climb climb) {
            if (climb == null) {
                return clearClimb();
            }
            this.hasClimb = true;
            this.climb_ = climb;
            return this;
        }

        public Routes setGuideInfo(int i, Guideinfo guideinfo) {
            if (guideinfo == null) {
                return this;
            }
            this.guideInfo_.set(i, guideinfo);
            return this;
        }

        public Routes setLegs(int i, Legs legs) {
            if (legs == null) {
                return this;
            }
            this.legs_.set(i, legs);
            return this;
        }

        public Routes setMapDrawInfo(int i, MapDrawInfo mapDrawInfo) {
            if (mapDrawInfo == null) {
                return this;
            }
            this.mapDrawInfo_.set(i, mapDrawInfo);
            return this;
        }

        public Routes setMsInfo(int i, Milestone milestone) {
            if (milestone == null) {
                return this;
            }
            this.msInfo_.set(i, milestone);
            return this;
        }

        public Routes setOtherinfo(OtherInfo otherInfo) {
            if (otherInfo == null) {
                return clearOtherinfo();
            }
            this.hasOtherinfo = true;
            this.otherinfo_ = otherInfo;
            return this;
        }

        public Routes setPlcyInfo(PolicyInfo policyInfo) {
            if (policyInfo == null) {
                return clearPlcyInfo();
            }
            this.hasPlcyInfo = true;
            this.plcyInfo_ = policyInfo;
            return this;
        }

        public Routes setRouteIdf(String str) {
            this.hasRouteIdf = true;
            this.routeIdf_ = str;
            return this;
        }

        public Routes setTip(Tip tip) {
            if (tip == null) {
                return clearTip();
            }
            this.hasTip = true;
            this.tip_ = tip;
            return this;
        }

        public Routes setUgcInfo(int i, UgcInfo ugcInfo) {
            if (ugcInfo == null) {
                return this;
            }
            this.ugcInfo_.set(i, ugcInfo);
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            Iterator<Legs> it = getLegsList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(1, it.next());
            }
            if (hasClimb()) {
                codedOutputStreamMicro.writeMessage(2, getClimb());
            }
            if (hasTip()) {
                codedOutputStreamMicro.writeMessage(3, getTip());
            }
            if (hasOtherinfo()) {
                codedOutputStreamMicro.writeMessage(4, getOtherinfo());
            }
            if (hasPlcyInfo()) {
                codedOutputStreamMicro.writeMessage(5, getPlcyInfo());
            }
            Iterator<Milestone> it2 = getMsInfoList().iterator();
            while (it2.hasNext()) {
                codedOutputStreamMicro.writeMessage(6, it2.next());
            }
            if (hasRouteIdf()) {
                codedOutputStreamMicro.writeString(7, getRouteIdf());
            }
            Iterator<Guideinfo> it3 = getGuideInfoList().iterator();
            while (it3.hasNext()) {
                codedOutputStreamMicro.writeMessage(8, it3.next());
            }
            Iterator<UgcInfo> it4 = getUgcInfoList().iterator();
            while (it4.hasNext()) {
                codedOutputStreamMicro.writeMessage(9, it4.next());
            }
            Iterator<MapDrawInfo> it5 = getMapDrawInfoList().iterator();
            while (it5.hasNext()) {
                codedOutputStreamMicro.writeMessage(10, it5.next());
            }
        }
    }

    public static final class Session extends MessageMicro {
        public static final int CACHE_ID_FIELD_NUMBER = 1;
        private String cacheId_ = "";
        private int cachedSize = -1;
        private boolean hasCacheId;

        public static Session parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Session().mergeFrom(codedInputStreamMicro);
        }

        public static Session parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Session) new Session().mergeFrom(bArr);
        }

        public final Session clear() {
            clearCacheId();
            this.cachedSize = -1;
            return this;
        }

        public Session clearCacheId() {
            this.hasCacheId = false;
            this.cacheId_ = "";
            return this;
        }

        public String getCacheId() {
            return this.cacheId_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int iComputeStringSize = hasCacheId() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getCacheId()) : 0;
            this.cachedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        public boolean hasCacheId() {
            return this.hasCacheId;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Session mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int tag = codedInputStreamMicro.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    setCacheId(codedInputStreamMicro.readString());
                } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                    return this;
                }
            }
        }

        public Session setCacheId(String str) {
            this.hasCacheId = true;
            this.cacheId_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCacheId()) {
                codedOutputStreamMicro.writeString(1, getCacheId());
            }
        }
    }

    public static final class Taxi extends MessageMicro {
        public static final int DETAIL_FIELD_NUMBER = 4;
        public static final int DISTANCE_FIELD_NUMBER = 1;
        public static final int DURATION_FIELD_NUMBER = 2;
        public static final int REMARK_FIELD_NUMBER = 3;
        private boolean hasDistance;
        private boolean hasDuration;
        private boolean hasRemark;
        private String distance_ = "";
        private String duration_ = "";
        private String remark_ = "";
        private List<Detail> detail_ = Collections.emptyList();
        private int cachedSize = -1;

        public static final class Detail extends MessageMicro {
            public static final int DESC_FIELD_NUMBER = 4;
            public static final int KM_PRICE_FIELD_NUMBER = 1;
            public static final int START_PRICE_FIELD_NUMBER = 2;
            public static final int TOTAL_PRICE_FIELD_NUMBER = 3;
            private boolean hasDesc;
            private boolean hasKmPrice;
            private boolean hasStartPrice;
            private boolean hasTotalPrice;
            private String kmPrice_ = "";
            private String startPrice_ = "";
            private String totalPrice_ = "";
            private String desc_ = "";
            private int cachedSize = -1;

            public static Detail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Detail().mergeFrom(codedInputStreamMicro);
            }

            public static Detail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Detail) new Detail().mergeFrom(bArr);
            }

            public final Detail clear() {
                clearKmPrice();
                clearStartPrice();
                clearTotalPrice();
                clearDesc();
                this.cachedSize = -1;
                return this;
            }

            public Detail clearDesc() {
                this.hasDesc = false;
                this.desc_ = "";
                return this;
            }

            public Detail clearKmPrice() {
                this.hasKmPrice = false;
                this.kmPrice_ = "";
                return this;
            }

            public Detail clearStartPrice() {
                this.hasStartPrice = false;
                this.startPrice_ = "";
                return this;
            }

            public Detail clearTotalPrice() {
                this.hasTotalPrice = false;
                this.totalPrice_ = "";
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getCachedSize() {
                if (this.cachedSize < 0) {
                    getSerializedSize();
                }
                return this.cachedSize;
            }

            public String getDesc() {
                return this.desc_;
            }

            public String getKmPrice() {
                return this.kmPrice_;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public int getSerializedSize() {
                int iComputeStringSize = hasKmPrice() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getKmPrice()) : 0;
                if (hasStartPrice()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getStartPrice());
                }
                if (hasTotalPrice()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getTotalPrice());
                }
                if (hasDesc()) {
                    iComputeStringSize += CodedOutputStreamMicro.computeStringSize(4, getDesc());
                }
                this.cachedSize = iComputeStringSize;
                return iComputeStringSize;
            }

            public String getStartPrice() {
                return this.startPrice_;
            }

            public String getTotalPrice() {
                return this.totalPrice_;
            }

            public boolean hasDesc() {
                return this.hasDesc;
            }

            public boolean hasKmPrice() {
                return this.hasKmPrice;
            }

            public boolean hasStartPrice() {
                return this.hasStartPrice;
            }

            public boolean hasTotalPrice() {
                return this.hasTotalPrice;
            }

            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public Detail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int tag = codedInputStreamMicro.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        setKmPrice(codedInputStreamMicro.readString());
                    } else if (tag == 18) {
                        setStartPrice(codedInputStreamMicro.readString());
                    } else if (tag == 26) {
                        setTotalPrice(codedInputStreamMicro.readString());
                    } else if (tag == 34) {
                        setDesc(codedInputStreamMicro.readString());
                    } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                }
            }

            public Detail setDesc(String str) {
                this.hasDesc = true;
                this.desc_ = str;
                return this;
            }

            public Detail setKmPrice(String str) {
                this.hasKmPrice = true;
                this.kmPrice_ = str;
                return this;
            }

            public Detail setStartPrice(String str) {
                this.hasStartPrice = true;
                this.startPrice_ = str;
                return this;
            }

            public Detail setTotalPrice(String str) {
                this.hasTotalPrice = true;
                this.totalPrice_ = str;
                return this;
            }

            @Override // com.google.protobuf.micro.MessageMicro
            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasKmPrice()) {
                    codedOutputStreamMicro.writeString(1, getKmPrice());
                }
                if (hasStartPrice()) {
                    codedOutputStreamMicro.writeString(2, getStartPrice());
                }
                if (hasTotalPrice()) {
                    codedOutputStreamMicro.writeString(3, getTotalPrice());
                }
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(4, getDesc());
                }
            }
        }

        public static Taxi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Taxi().mergeFrom(codedInputStreamMicro);
        }

        public static Taxi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Taxi) new Taxi().mergeFrom(bArr);
        }

        public Taxi addDetail(Detail detail) {
            if (detail == null) {
                return this;
            }
            if (this.detail_.isEmpty()) {
                this.detail_ = new ArrayList();
            }
            this.detail_.add(detail);
            return this;
        }

        public final Taxi clear() {
            clearDistance();
            clearDuration();
            clearRemark();
            clearDetail();
            this.cachedSize = -1;
            return this;
        }

        public Taxi clearDetail() {
            this.detail_ = Collections.emptyList();
            return this;
        }

        public Taxi clearDistance() {
            this.hasDistance = false;
            this.distance_ = "";
            return this;
        }

        public Taxi clearDuration() {
            this.hasDuration = false;
            this.duration_ = "";
            return this;
        }

        public Taxi clearRemark() {
            this.hasRemark = false;
            this.remark_ = "";
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public Detail getDetail(int i) {
            return this.detail_.get(i);
        }

        public int getDetailCount() {
            return this.detail_.size();
        }

        public List<Detail> getDetailList() {
            return this.detail_;
        }

        public String getDistance() {
            return this.distance_;
        }

        public String getDuration() {
            return this.duration_;
        }

        public String getRemark() {
            return this.remark_;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public int getSerializedSize() {
            int iComputeStringSize = hasDistance() ? 0 + CodedOutputStreamMicro.computeStringSize(1, getDistance()) : 0;
            if (hasDuration()) {
                iComputeStringSize += CodedOutputStreamMicro.computeStringSize(2, getDuration());
            }
            if (hasRemark()) {
                iComputeStringSize += CodedOutputStreamMicro.computeStringSize(3, getRemark());
            }
            Iterator<Detail> it = getDetailList().iterator();
            while (it.hasNext()) {
                iComputeStringSize += CodedOutputStreamMicro.computeMessageSize(4, it.next());
            }
            this.cachedSize = iComputeStringSize;
            return iComputeStringSize;
        }

        public boolean hasDistance() {
            return this.hasDistance;
        }

        public boolean hasDuration() {
            return this.hasDuration;
        }

        public boolean hasRemark() {
            return this.hasRemark;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public Taxi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int tag = codedInputStreamMicro.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    setDistance(codedInputStreamMicro.readString());
                } else if (tag == 18) {
                    setDuration(codedInputStreamMicro.readString());
                } else if (tag == 26) {
                    setRemark(codedInputStreamMicro.readString());
                } else if (tag == 34) {
                    Detail detail = new Detail();
                    codedInputStreamMicro.readMessage(detail);
                    addDetail(detail);
                } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                    return this;
                }
            }
        }

        public Taxi setDetail(int i, Detail detail) {
            if (detail == null) {
                return this;
            }
            this.detail_.set(i, detail);
            return this;
        }

        public Taxi setDistance(String str) {
            this.hasDistance = true;
            this.distance_ = str;
            return this;
        }

        public Taxi setDuration(String str) {
            this.hasDuration = true;
            this.duration_ = str;
            return this;
        }

        public Taxi setRemark(String str) {
            this.hasRemark = true;
            this.remark_ = str;
            return this;
        }

        @Override // com.google.protobuf.micro.MessageMicro
        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(1, getDistance());
            }
            if (hasDuration()) {
                codedOutputStreamMicro.writeString(2, getDuration());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(3, getRemark());
            }
            Iterator<Detail> it = getDetailList().iterator();
            while (it.hasNext()) {
                codedOutputStreamMicro.writeMessage(4, it.next());
            }
        }
    }

    public static WalkPlan parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new WalkPlan().mergeFrom(codedInputStreamMicro);
    }

    public static WalkPlan parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (WalkPlan) new WalkPlan().mergeFrom(bArr);
    }

    public WalkPlan addArGuide(ARGuide aRGuide) {
        if (aRGuide == null) {
            return this;
        }
        if (this.arGuide_.isEmpty()) {
            this.arGuide_ = new ArrayList();
        }
        this.arGuide_.add(aRGuide);
        return this;
    }

    public WalkPlan addIndoorNavis(IndoorNavi indoorNavi) {
        if (indoorNavi == null) {
            return this;
        }
        if (this.indoorNavis_.isEmpty()) {
            this.indoorNavis_ = new ArrayList();
        }
        this.indoorNavis_.add(indoorNavi);
        return this;
    }

    public WalkPlan addRoutes(Routes routes) {
        if (routes == null) {
            return this;
        }
        if (this.routes_.isEmpty()) {
            this.routes_ = new ArrayList();
        }
        this.routes_.add(routes);
        return this;
    }

    public final WalkPlan clear() {
        clearTaxi();
        clearRoutes();
        clearOption();
        clearCurrentCity();
        clearIndoorNavis();
        clearYawStatus();
        clearArGuide();
        clearAppendRouteinfList();
        clearSession();
        clearVehicle();
        this.cachedSize = -1;
        return this;
    }

    public WalkPlan clearAppendRouteinfList() {
        this.hasAppendRouteinfList = false;
        this.appendRouteinfList_ = null;
        return this;
    }

    public WalkPlan clearArGuide() {
        this.arGuide_ = Collections.emptyList();
        return this;
    }

    public WalkPlan clearCurrentCity() {
        this.hasCurrentCity = false;
        this.currentCity_ = null;
        return this;
    }

    public WalkPlan clearIndoorNavis() {
        this.indoorNavis_ = Collections.emptyList();
        return this;
    }

    public WalkPlan clearOption() {
        this.hasOption = false;
        this.option_ = null;
        return this;
    }

    public WalkPlan clearRoutes() {
        this.routes_ = Collections.emptyList();
        return this;
    }

    public WalkPlan clearSession() {
        this.hasSession = false;
        this.session_ = null;
        return this;
    }

    public WalkPlan clearTaxi() {
        this.hasTaxi = false;
        this.taxi_ = null;
        return this;
    }

    public WalkPlan clearVehicle() {
        this.hasVehicle = false;
        this.vehicle_ = 0;
        return this;
    }

    public WalkPlan clearYawStatus() {
        this.hasYawStatus = false;
        this.yawStatus_ = 0;
        return this;
    }

    public AppendRouteInf getAppendRouteinfList() {
        return this.appendRouteinfList_;
    }

    public ARGuide getArGuide(int i) {
        return this.arGuide_.get(i);
    }

    public int getArGuideCount() {
        return this.arGuide_.size();
    }

    public List<ARGuide> getArGuideList() {
        return this.arGuide_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CurrentCity getCurrentCity() {
        return this.currentCity_;
    }

    public IndoorNavi getIndoorNavis(int i) {
        return this.indoorNavis_.get(i);
    }

    public int getIndoorNavisCount() {
        return this.indoorNavis_.size();
    }

    public List<IndoorNavi> getIndoorNavisList() {
        return this.indoorNavis_;
    }

    public Option getOption() {
        return this.option_;
    }

    public Routes getRoutes(int i) {
        return this.routes_.get(i);
    }

    public int getRoutesCount() {
        return this.routes_.size();
    }

    public List<Routes> getRoutesList() {
        return this.routes_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        Iterator<Routes> it = getRoutesList().iterator();
        int iComputeInt32Size = 0;
        while (it.hasNext()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(1, it.next());
        }
        if (hasTaxi()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(2, getTaxi());
        }
        if (hasOption()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(3, getOption());
        }
        if (hasCurrentCity()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(4, getCurrentCity());
        }
        Iterator<IndoorNavi> it2 = getIndoorNavisList().iterator();
        while (it2.hasNext()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(5, it2.next());
        }
        if (hasYawStatus()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(6, getYawStatus());
        }
        Iterator<ARGuide> it3 = getArGuideList().iterator();
        while (it3.hasNext()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(7, it3.next());
        }
        if (hasAppendRouteinfList()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(8, getAppendRouteinfList());
        }
        if (hasSession()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeMessageSize(9, getSession());
        }
        if (hasVehicle()) {
            iComputeInt32Size += CodedOutputStreamMicro.computeInt32Size(10, getVehicle());
        }
        this.cachedSize = iComputeInt32Size;
        return iComputeInt32Size;
    }

    public Session getSession() {
        return this.session_;
    }

    public Taxi getTaxi() {
        return this.taxi_;
    }

    public int getVehicle() {
        return this.vehicle_;
    }

    public int getYawStatus() {
        return this.yawStatus_;
    }

    public boolean hasAppendRouteinfList() {
        return this.hasAppendRouteinfList;
    }

    public boolean hasCurrentCity() {
        return this.hasCurrentCity;
    }

    public boolean hasOption() {
        return this.hasOption;
    }

    public boolean hasSession() {
        return this.hasSession;
    }

    public boolean hasTaxi() {
        return this.hasTaxi;
    }

    public boolean hasVehicle() {
        return this.hasVehicle;
    }

    public boolean hasYawStatus() {
        return this.hasYawStatus;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public WalkPlan mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    Routes routes = new Routes();
                    codedInputStreamMicro.readMessage(routes);
                    addRoutes(routes);
                    break;
                case 18:
                    Taxi taxi = new Taxi();
                    codedInputStreamMicro.readMessage(taxi);
                    setTaxi(taxi);
                    break;
                case 26:
                    Option option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
                    break;
                case 34:
                    CurrentCity currentCity = new CurrentCity();
                    codedInputStreamMicro.readMessage(currentCity);
                    setCurrentCity(currentCity);
                    break;
                case 42:
                    IndoorNavi indoorNavi = new IndoorNavi();
                    codedInputStreamMicro.readMessage(indoorNavi);
                    addIndoorNavis(indoorNavi);
                    break;
                case 48:
                    setYawStatus(codedInputStreamMicro.readInt32());
                    break;
                case 58:
                    ARGuide aRGuide = new ARGuide();
                    codedInputStreamMicro.readMessage(aRGuide);
                    addArGuide(aRGuide);
                    break;
                case 66:
                    AppendRouteInf appendRouteInf = new AppendRouteInf();
                    codedInputStreamMicro.readMessage(appendRouteInf);
                    setAppendRouteinfList(appendRouteInf);
                    break;
                case 74:
                    Session session = new Session();
                    codedInputStreamMicro.readMessage(session);
                    setSession(session);
                    break;
                case 80:
                    setVehicle(codedInputStreamMicro.readInt32());
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, tag)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    public WalkPlan setAppendRouteinfList(AppendRouteInf appendRouteInf) {
        if (appendRouteInf == null) {
            return clearAppendRouteinfList();
        }
        this.hasAppendRouteinfList = true;
        this.appendRouteinfList_ = appendRouteInf;
        return this;
    }

    public WalkPlan setArGuide(int i, ARGuide aRGuide) {
        if (aRGuide == null) {
            return this;
        }
        this.arGuide_.set(i, aRGuide);
        return this;
    }

    public WalkPlan setCurrentCity(CurrentCity currentCity) {
        if (currentCity == null) {
            return clearCurrentCity();
        }
        this.hasCurrentCity = true;
        this.currentCity_ = currentCity;
        return this;
    }

    public WalkPlan setIndoorNavis(int i, IndoorNavi indoorNavi) {
        if (indoorNavi == null) {
            return this;
        }
        this.indoorNavis_.set(i, indoorNavi);
        return this;
    }

    public WalkPlan setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.hasOption = true;
        this.option_ = option;
        return this;
    }

    public WalkPlan setRoutes(int i, Routes routes) {
        if (routes == null) {
            return this;
        }
        this.routes_.set(i, routes);
        return this;
    }

    public WalkPlan setSession(Session session) {
        if (session == null) {
            return clearSession();
        }
        this.hasSession = true;
        this.session_ = session;
        return this;
    }

    public WalkPlan setTaxi(Taxi taxi) {
        if (taxi == null) {
            return clearTaxi();
        }
        this.hasTaxi = true;
        this.taxi_ = taxi;
        return this;
    }

    public WalkPlan setVehicle(int i) {
        this.hasVehicle = true;
        this.vehicle_ = i;
        return this;
    }

    public WalkPlan setYawStatus(int i) {
        this.hasYawStatus = true;
        this.yawStatus_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        Iterator<Routes> it = getRoutesList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(1, it.next());
        }
        if (hasTaxi()) {
            codedOutputStreamMicro.writeMessage(2, getTaxi());
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(3, getOption());
        }
        if (hasCurrentCity()) {
            codedOutputStreamMicro.writeMessage(4, getCurrentCity());
        }
        Iterator<IndoorNavi> it2 = getIndoorNavisList().iterator();
        while (it2.hasNext()) {
            codedOutputStreamMicro.writeMessage(5, it2.next());
        }
        if (hasYawStatus()) {
            codedOutputStreamMicro.writeInt32(6, getYawStatus());
        }
        Iterator<ARGuide> it3 = getArGuideList().iterator();
        while (it3.hasNext()) {
            codedOutputStreamMicro.writeMessage(7, it3.next());
        }
        if (hasAppendRouteinfList()) {
            codedOutputStreamMicro.writeMessage(8, getAppendRouteinfList());
        }
        if (hasSession()) {
            codedOutputStreamMicro.writeMessage(9, getSession());
        }
        if (hasVehicle()) {
            codedOutputStreamMicro.writeInt32(10, getVehicle());
        }
    }
}
