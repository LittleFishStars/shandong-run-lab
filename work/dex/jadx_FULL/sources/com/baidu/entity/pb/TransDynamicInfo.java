package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
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
public final class TransDynamicInfo extends MessageMicro {
    public static final int ACCI_ROUTES_INFO_FIELD_NUMBER = 17;
    public static final int BLANKING_ROUTE_IDX_FIELD_NUMBER = 9;
    public static final int CHOICE_FIELD_NUMBER = 13;
    public static final int END_MARK_FIELD_NUMBER = 12;
    public static final int INFO_ID_FIELD_NUMBER = 1;
    public static final int JAVIRS_ACTION_INFO_FIELD_NUMBER = 18;
    public static final int MAIN_ROAD_NO_FIELD_NUMBER = 6;
    public static final int NEED_REMIND_FIELD_NUMBER = 10;
    public static final int NEW_ROAD_NO_FIELD_NUMBER = 7;
    public static final int PANEL_FIELD_NUMBER = 4;
    public static final int POINT_PAIR_FIELD_NUMBER = 15;
    public static final int PRIORITY_FIELD_NUMBER = 14;
    public static final int ROUTE_INFO_FIELD_NUMBER = 5;
    public static final int START_MARK_FIELD_NUMBER = 11;
    public static final int TEXT_INFO_FIELD_NUMBER = 8;
    public static final int TRANS_PREFER_INFO_FIELD_NUMBER = 19;
    public static final int TYPE_FIELD_NUMBER = 20;
    public static final int VOICE_BROAD_TYPE_FIELD_NUMBER = 3;
    public static final int VOICE_INFO_FIELD_NUMBER = 2;
    public static final int YAW_SPEAK_FIELD_NUMBER = 16;
    private TransRouteInfo acciRoutesInfo_;
    private ByteStringMicro blankingRouteIdx_;
    private int cachedSize;
    private List<TransPanel> choice_;
    private int endMark_;
    private boolean hasAcciRoutesInfo;
    private boolean hasBlankingRouteIdx;
    private boolean hasEndMark;
    private boolean hasInfoId;
    private boolean hasJavirsActionInfo;
    private boolean hasMainRoadNo;
    private boolean hasNeedRemind;
    private boolean hasNewRoadNo;
    private boolean hasPanel;
    private boolean hasPriority;
    private boolean hasStartMark;
    private boolean hasTextInfo;
    private boolean hasTransPreferInfo;
    private boolean hasType;
    private boolean hasVoiceBroadType;
    private boolean hasVoiceInfo;
    private boolean hasYawSpeak;
    private ByteStringMicro infoId_;
    private TransJavirsActionInfo javirsActionInfo_;
    private int mainRoadNo_;
    private int needRemind_;
    private int newRoadNo_;
    private TransPanel panel_;
    private List<TransPanelPointPair> pointPair_;
    private int priority_;
    private List<TransRouteInfo> routeInfo_;
    private int startMark_;
    private ByteStringMicro textInfo_;
    private TransPreferInfo transPreferInfo_;
    private int type_;
    private int voiceBroadType_;
    private TransVoiceInfo voiceInfo_;
    private ByteStringMicro yawSpeak_;

    public TransDynamicInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.infoId_ = byteStringMicro;
        this.voiceInfo_ = null;
        this.voiceBroadType_ = 0;
        this.panel_ = null;
        this.routeInfo_ = Collections.emptyList();
        this.mainRoadNo_ = 0;
        this.newRoadNo_ = 0;
        this.textInfo_ = byteStringMicro;
        this.blankingRouteIdx_ = byteStringMicro;
        this.needRemind_ = 0;
        this.startMark_ = 0;
        this.endMark_ = 0;
        this.choice_ = Collections.emptyList();
        this.priority_ = 0;
        this.pointPair_ = Collections.emptyList();
        this.yawSpeak_ = byteStringMicro;
        this.acciRoutesInfo_ = null;
        this.javirsActionInfo_ = null;
        this.transPreferInfo_ = null;
        this.type_ = 0;
        this.cachedSize = -1;
    }

    public static TransDynamicInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransDynamicInfo().mergeFrom(codedInputStreamMicro);
    }

    public static TransDynamicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransDynamicInfo) new TransDynamicInfo().mergeFrom(bArr);
    }

    public TransDynamicInfo addChoice(TransPanel transPanel) {
        if (transPanel == null) {
            return this;
        }
        if (this.choice_.isEmpty()) {
            this.choice_ = new ArrayList();
        }
        this.choice_.add(transPanel);
        return this;
    }

    public TransDynamicInfo addPointPair(TransPanelPointPair transPanelPointPair) {
        if (transPanelPointPair == null) {
            return this;
        }
        if (this.pointPair_.isEmpty()) {
            this.pointPair_ = new ArrayList();
        }
        this.pointPair_.add(transPanelPointPair);
        return this;
    }

    public TransDynamicInfo addRouteInfo(TransRouteInfo transRouteInfo) {
        if (transRouteInfo == null) {
            return this;
        }
        if (this.routeInfo_.isEmpty()) {
            this.routeInfo_ = new ArrayList();
        }
        this.routeInfo_.add(transRouteInfo);
        return this;
    }

    public final TransDynamicInfo clear() {
        clearInfoId();
        clearVoiceInfo();
        clearVoiceBroadType();
        clearPanel();
        clearRouteInfo();
        clearMainRoadNo();
        clearNewRoadNo();
        clearTextInfo();
        clearBlankingRouteIdx();
        clearNeedRemind();
        clearStartMark();
        clearEndMark();
        clearChoice();
        clearPriority();
        clearPointPair();
        clearYawSpeak();
        clearAcciRoutesInfo();
        clearJavirsActionInfo();
        clearTransPreferInfo();
        clearType();
        this.cachedSize = -1;
        return this;
    }

    public TransDynamicInfo clearAcciRoutesInfo() {
        this.hasAcciRoutesInfo = false;
        this.acciRoutesInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearBlankingRouteIdx() {
        this.hasBlankingRouteIdx = false;
        this.blankingRouteIdx_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransDynamicInfo clearChoice() {
        this.choice_ = Collections.emptyList();
        return this;
    }

    public TransDynamicInfo clearEndMark() {
        this.hasEndMark = false;
        this.endMark_ = 0;
        return this;
    }

    public TransDynamicInfo clearInfoId() {
        this.hasInfoId = false;
        this.infoId_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransDynamicInfo clearJavirsActionInfo() {
        this.hasJavirsActionInfo = false;
        this.javirsActionInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearMainRoadNo() {
        this.hasMainRoadNo = false;
        this.mainRoadNo_ = 0;
        return this;
    }

    public TransDynamicInfo clearNeedRemind() {
        this.hasNeedRemind = false;
        this.needRemind_ = 0;
        return this;
    }

    public TransDynamicInfo clearNewRoadNo() {
        this.hasNewRoadNo = false;
        this.newRoadNo_ = 0;
        return this;
    }

    public TransDynamicInfo clearPanel() {
        this.hasPanel = false;
        this.panel_ = null;
        return this;
    }

    public TransDynamicInfo clearPointPair() {
        this.pointPair_ = Collections.emptyList();
        return this;
    }

    public TransDynamicInfo clearPriority() {
        this.hasPriority = false;
        this.priority_ = 0;
        return this;
    }

    public TransDynamicInfo clearRouteInfo() {
        this.routeInfo_ = Collections.emptyList();
        return this;
    }

    public TransDynamicInfo clearStartMark() {
        this.hasStartMark = false;
        this.startMark_ = 0;
        return this;
    }

    public TransDynamicInfo clearTextInfo() {
        this.hasTextInfo = false;
        this.textInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransDynamicInfo clearTransPreferInfo() {
        this.hasTransPreferInfo = false;
        this.transPreferInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    public TransDynamicInfo clearVoiceBroadType() {
        this.hasVoiceBroadType = false;
        this.voiceBroadType_ = 0;
        return this;
    }

    public TransDynamicInfo clearVoiceInfo() {
        this.hasVoiceInfo = false;
        this.voiceInfo_ = null;
        return this;
    }

    public TransDynamicInfo clearYawSpeak() {
        this.hasYawSpeak = false;
        this.yawSpeak_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransRouteInfo getAcciRoutesInfo() {
        return this.acciRoutesInfo_;
    }

    public ByteStringMicro getBlankingRouteIdx() {
        return this.blankingRouteIdx_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public TransPanel getChoice(int i) {
        return this.choice_.get(i);
    }

    public int getChoiceCount() {
        return this.choice_.size();
    }

    public List<TransPanel> getChoiceList() {
        return this.choice_;
    }

    public int getEndMark() {
        return this.endMark_;
    }

    public ByteStringMicro getInfoId() {
        return this.infoId_;
    }

    public TransJavirsActionInfo getJavirsActionInfo() {
        return this.javirsActionInfo_;
    }

    public int getMainRoadNo() {
        return this.mainRoadNo_;
    }

    public int getNeedRemind() {
        return this.needRemind_;
    }

    public int getNewRoadNo() {
        return this.newRoadNo_;
    }

    public TransPanel getPanel() {
        return this.panel_;
    }

    public TransPanelPointPair getPointPair(int i) {
        return this.pointPair_.get(i);
    }

    public int getPointPairCount() {
        return this.pointPair_.size();
    }

    public List<TransPanelPointPair> getPointPairList() {
        return this.pointPair_;
    }

    public int getPriority() {
        return this.priority_;
    }

    public TransRouteInfo getRouteInfo(int i) {
        return this.routeInfo_.get(i);
    }

    public int getRouteInfoCount() {
        return this.routeInfo_.size();
    }

    public List<TransRouteInfo> getRouteInfoList() {
        return this.routeInfo_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeBytesSize = hasInfoId() ? 0 + CodedOutputStreamMicro.computeBytesSize(1, getInfoId()) : 0;
        if (hasVoiceInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(2, getVoiceInfo());
        }
        if (hasVoiceBroadType()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(3, getVoiceBroadType());
        }
        if (hasPanel()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(4, getPanel());
        }
        Iterator<TransRouteInfo> it = getRouteInfoList().iterator();
        while (it.hasNext()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(5, it.next());
        }
        if (hasMainRoadNo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(6, getMainRoadNo());
        }
        if (hasNewRoadNo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(7, getNewRoadNo());
        }
        if (hasTextInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(8, getTextInfo());
        }
        if (hasBlankingRouteIdx()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(9, getBlankingRouteIdx());
        }
        if (hasNeedRemind()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(10, getNeedRemind());
        }
        if (hasStartMark()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(11, getStartMark());
        }
        if (hasEndMark()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(12, getEndMark());
        }
        Iterator<TransPanel> it2 = getChoiceList().iterator();
        while (it2.hasNext()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(13, it2.next());
        }
        if (hasPriority()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(14, getPriority());
        }
        Iterator<TransPanelPointPair> it3 = getPointPairList().iterator();
        while (it3.hasNext()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(15, it3.next());
        }
        if (hasYawSpeak()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(16, getYawSpeak());
        }
        if (hasAcciRoutesInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(17, getAcciRoutesInfo());
        }
        if (hasJavirsActionInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(18, getJavirsActionInfo());
        }
        if (hasTransPreferInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(19, getTransPreferInfo());
        }
        if (hasType()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(20, getType());
        }
        this.cachedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    public int getStartMark() {
        return this.startMark_;
    }

    public ByteStringMicro getTextInfo() {
        return this.textInfo_;
    }

    public TransPreferInfo getTransPreferInfo() {
        return this.transPreferInfo_;
    }

    public int getType() {
        return this.type_;
    }

    public int getVoiceBroadType() {
        return this.voiceBroadType_;
    }

    public TransVoiceInfo getVoiceInfo() {
        return this.voiceInfo_;
    }

    public ByteStringMicro getYawSpeak() {
        return this.yawSpeak_;
    }

    public boolean hasAcciRoutesInfo() {
        return this.hasAcciRoutesInfo;
    }

    public boolean hasBlankingRouteIdx() {
        return this.hasBlankingRouteIdx;
    }

    public boolean hasEndMark() {
        return this.hasEndMark;
    }

    public boolean hasInfoId() {
        return this.hasInfoId;
    }

    public boolean hasJavirsActionInfo() {
        return this.hasJavirsActionInfo;
    }

    public boolean hasMainRoadNo() {
        return this.hasMainRoadNo;
    }

    public boolean hasNeedRemind() {
        return this.hasNeedRemind;
    }

    public boolean hasNewRoadNo() {
        return this.hasNewRoadNo;
    }

    public boolean hasPanel() {
        return this.hasPanel;
    }

    public boolean hasPriority() {
        return this.hasPriority;
    }

    public boolean hasStartMark() {
        return this.hasStartMark;
    }

    public boolean hasTextInfo() {
        return this.hasTextInfo;
    }

    public boolean hasTransPreferInfo() {
        return this.hasTransPreferInfo;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public boolean hasVoiceBroadType() {
        return this.hasVoiceBroadType;
    }

    public boolean hasVoiceInfo() {
        return this.hasVoiceInfo;
    }

    public boolean hasYawSpeak() {
        return this.hasYawSpeak;
    }

    public final boolean isInitialized() {
        return !hasVoiceInfo() || getVoiceInfo().isInitialized();
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransDynamicInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    setInfoId(codedInputStreamMicro.readBytes());
                    break;
                case 18:
                    TransVoiceInfo transVoiceInfo = new TransVoiceInfo();
                    codedInputStreamMicro.readMessage(transVoiceInfo);
                    setVoiceInfo(transVoiceInfo);
                    break;
                case 24:
                    setVoiceBroadType(codedInputStreamMicro.readInt32());
                    break;
                case 34:
                    TransPanel transPanel = new TransPanel();
                    codedInputStreamMicro.readMessage(transPanel);
                    setPanel(transPanel);
                    break;
                case 42:
                    TransRouteInfo transRouteInfo = new TransRouteInfo();
                    codedInputStreamMicro.readMessage(transRouteInfo);
                    addRouteInfo(transRouteInfo);
                    break;
                case 48:
                    setMainRoadNo(codedInputStreamMicro.readInt32());
                    break;
                case 56:
                    setNewRoadNo(codedInputStreamMicro.readInt32());
                    break;
                case 66:
                    setTextInfo(codedInputStreamMicro.readBytes());
                    break;
                case 74:
                    setBlankingRouteIdx(codedInputStreamMicro.readBytes());
                    break;
                case 80:
                    setNeedRemind(codedInputStreamMicro.readInt32());
                    break;
                case 88:
                    setStartMark(codedInputStreamMicro.readInt32());
                    break;
                case 96:
                    setEndMark(codedInputStreamMicro.readInt32());
                    break;
                case 106:
                    TransPanel transPanel2 = new TransPanel();
                    codedInputStreamMicro.readMessage(transPanel2);
                    addChoice(transPanel2);
                    break;
                case 112:
                    setPriority(codedInputStreamMicro.readInt32());
                    break;
                case 122:
                    TransPanelPointPair transPanelPointPair = new TransPanelPointPair();
                    codedInputStreamMicro.readMessage(transPanelPointPair);
                    addPointPair(transPanelPointPair);
                    break;
                case 130:
                    setYawSpeak(codedInputStreamMicro.readBytes());
                    break;
                case 138:
                    TransRouteInfo transRouteInfo2 = new TransRouteInfo();
                    codedInputStreamMicro.readMessage(transRouteInfo2);
                    setAcciRoutesInfo(transRouteInfo2);
                    break;
                case 146:
                    TransJavirsActionInfo transJavirsActionInfo = new TransJavirsActionInfo();
                    codedInputStreamMicro.readMessage(transJavirsActionInfo);
                    setJavirsActionInfo(transJavirsActionInfo);
                    break;
                case 154:
                    TransPreferInfo transPreferInfo = new TransPreferInfo();
                    codedInputStreamMicro.readMessage(transPreferInfo);
                    setTransPreferInfo(transPreferInfo);
                    break;
                case 160:
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

    public TransDynamicInfo setAcciRoutesInfo(TransRouteInfo transRouteInfo) {
        if (transRouteInfo == null) {
            return clearAcciRoutesInfo();
        }
        this.hasAcciRoutesInfo = true;
        this.acciRoutesInfo_ = transRouteInfo;
        return this;
    }

    public TransDynamicInfo setBlankingRouteIdx(ByteStringMicro byteStringMicro) {
        this.hasBlankingRouteIdx = true;
        this.blankingRouteIdx_ = byteStringMicro;
        return this;
    }

    public TransDynamicInfo setChoice(int i, TransPanel transPanel) {
        if (transPanel == null) {
            return this;
        }
        this.choice_.set(i, transPanel);
        return this;
    }

    public TransDynamicInfo setEndMark(int i) {
        this.hasEndMark = true;
        this.endMark_ = i;
        return this;
    }

    public TransDynamicInfo setInfoId(ByteStringMicro byteStringMicro) {
        this.hasInfoId = true;
        this.infoId_ = byteStringMicro;
        return this;
    }

    public TransDynamicInfo setJavirsActionInfo(TransJavirsActionInfo transJavirsActionInfo) {
        if (transJavirsActionInfo == null) {
            return clearJavirsActionInfo();
        }
        this.hasJavirsActionInfo = true;
        this.javirsActionInfo_ = transJavirsActionInfo;
        return this;
    }

    public TransDynamicInfo setMainRoadNo(int i) {
        this.hasMainRoadNo = true;
        this.mainRoadNo_ = i;
        return this;
    }

    public TransDynamicInfo setNeedRemind(int i) {
        this.hasNeedRemind = true;
        this.needRemind_ = i;
        return this;
    }

    public TransDynamicInfo setNewRoadNo(int i) {
        this.hasNewRoadNo = true;
        this.newRoadNo_ = i;
        return this;
    }

    public TransDynamicInfo setPanel(TransPanel transPanel) {
        if (transPanel == null) {
            return clearPanel();
        }
        this.hasPanel = true;
        this.panel_ = transPanel;
        return this;
    }

    public TransDynamicInfo setPointPair(int i, TransPanelPointPair transPanelPointPair) {
        if (transPanelPointPair == null) {
            return this;
        }
        this.pointPair_.set(i, transPanelPointPair);
        return this;
    }

    public TransDynamicInfo setPriority(int i) {
        this.hasPriority = true;
        this.priority_ = i;
        return this;
    }

    public TransDynamicInfo setRouteInfo(int i, TransRouteInfo transRouteInfo) {
        if (transRouteInfo == null) {
            return this;
        }
        this.routeInfo_.set(i, transRouteInfo);
        return this;
    }

    public TransDynamicInfo setStartMark(int i) {
        this.hasStartMark = true;
        this.startMark_ = i;
        return this;
    }

    public TransDynamicInfo setTextInfo(ByteStringMicro byteStringMicro) {
        this.hasTextInfo = true;
        this.textInfo_ = byteStringMicro;
        return this;
    }

    public TransDynamicInfo setTransPreferInfo(TransPreferInfo transPreferInfo) {
        if (transPreferInfo == null) {
            return clearTransPreferInfo();
        }
        this.hasTransPreferInfo = true;
        this.transPreferInfo_ = transPreferInfo;
        return this;
    }

    public TransDynamicInfo setType(int i) {
        this.hasType = true;
        this.type_ = i;
        return this;
    }

    public TransDynamicInfo setVoiceBroadType(int i) {
        this.hasVoiceBroadType = true;
        this.voiceBroadType_ = i;
        return this;
    }

    public TransDynamicInfo setVoiceInfo(TransVoiceInfo transVoiceInfo) {
        if (transVoiceInfo == null) {
            return clearVoiceInfo();
        }
        this.hasVoiceInfo = true;
        this.voiceInfo_ = transVoiceInfo;
        return this;
    }

    public TransDynamicInfo setYawSpeak(ByteStringMicro byteStringMicro) {
        this.hasYawSpeak = true;
        this.yawSpeak_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasInfoId()) {
            codedOutputStreamMicro.writeBytes(1, getInfoId());
        }
        if (hasVoiceInfo()) {
            codedOutputStreamMicro.writeMessage(2, getVoiceInfo());
        }
        if (hasVoiceBroadType()) {
            codedOutputStreamMicro.writeInt32(3, getVoiceBroadType());
        }
        if (hasPanel()) {
            codedOutputStreamMicro.writeMessage(4, getPanel());
        }
        Iterator<TransRouteInfo> it = getRouteInfoList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(5, it.next());
        }
        if (hasMainRoadNo()) {
            codedOutputStreamMicro.writeInt32(6, getMainRoadNo());
        }
        if (hasNewRoadNo()) {
            codedOutputStreamMicro.writeInt32(7, getNewRoadNo());
        }
        if (hasTextInfo()) {
            codedOutputStreamMicro.writeBytes(8, getTextInfo());
        }
        if (hasBlankingRouteIdx()) {
            codedOutputStreamMicro.writeBytes(9, getBlankingRouteIdx());
        }
        if (hasNeedRemind()) {
            codedOutputStreamMicro.writeInt32(10, getNeedRemind());
        }
        if (hasStartMark()) {
            codedOutputStreamMicro.writeInt32(11, getStartMark());
        }
        if (hasEndMark()) {
            codedOutputStreamMicro.writeInt32(12, getEndMark());
        }
        Iterator<TransPanel> it2 = getChoiceList().iterator();
        while (it2.hasNext()) {
            codedOutputStreamMicro.writeMessage(13, it2.next());
        }
        if (hasPriority()) {
            codedOutputStreamMicro.writeInt32(14, getPriority());
        }
        Iterator<TransPanelPointPair> it3 = getPointPairList().iterator();
        while (it3.hasNext()) {
            codedOutputStreamMicro.writeMessage(15, it3.next());
        }
        if (hasYawSpeak()) {
            codedOutputStreamMicro.writeBytes(16, getYawSpeak());
        }
        if (hasAcciRoutesInfo()) {
            codedOutputStreamMicro.writeMessage(17, getAcciRoutesInfo());
        }
        if (hasJavirsActionInfo()) {
            codedOutputStreamMicro.writeMessage(18, getJavirsActionInfo());
        }
        if (hasTransPreferInfo()) {
            codedOutputStreamMicro.writeMessage(19, getTransPreferInfo());
        }
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(20, getType());
        }
    }
}
