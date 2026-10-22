package com.baidu.entity.pb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.math.c;
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
public final class yellow_tips_list_t extends MessageMicro {
    public static final int ALL_PASS_ID_FIELD_NUMBER = 56;
    public static final int ASSIST_INFO_FIELD_NUMBER = 3;
    public static final int BACK_COLOR_ID_FIELD_NUMBER = 6;
    public static final int BUTTON_ACTION_FIELD_NUMBER = 40;
    public static final int CARLIMIT_INFO_ID_FIELD_NUMBER = 43;
    public static final int CITY_ID_FIELD_NUMBER = 34;
    public static final int COPY_WRITINGS_FIELD_NUMBER = 21;
    public static final int DISPLAY_POS_FIELD_NUMBER = 25;
    public static final int DU_TIP_ID_FIELD_NUMBER = 50;
    public static final int DU_TITLE_FIELD_NUMBER = 51;
    public static final int END_BTN_FIELD_NUMBER = 7;
    public static final int EVENT_IDS_FIELD_NUMBER = 53;
    public static final int EVENT_ID_FIELD_NUMBER = 18;
    public static final int EXPALN_TITLE_FIELD_NUMBER = 10;
    public static final int EXPLAIN_BUBBLE_FIELD_NUMBER = 24;
    public static final int EXPLAIN_SUB_TITLE_FIELD_NUMBER = 23;
    public static final int FIRST_LINE_FIELD_NUMBER = 29;
    public static final int GIF_URL_DARK_FIELD_NUMBER = 47;
    public static final int GIF_URL_FIELD_NUMBER = 46;
    public static final int GROUP_ID_FIELD_NUMBER = 32;
    public static final int ICON_ID_FIELD_NUMBER = 5;
    public static final int IDSS_CARD_ID_FIELD_NUMBER = 45;
    public static final int IMAGE_URL_FIELD_NUMBER = 20;
    public static final int JUMP_FLAG_FIELD_NUMBER = 16;
    public static final int LENGTH_FIELD_NUMBER = 12;
    public static final int LITTLE_ACTION_FIELD_NUMBER = 41;
    public static final int MAIN_ACTION_FIELD_NUMBER = 42;
    public static final int NEW_PATTERN_FIELD_NUMBER = 22;
    public static final int PANEL_FLAG_FIELD_NUMBER = 17;
    public static final int PASS_ID_FIELD_NUMBER = 55;
    public static final int PERMIT_INFO_ID_FIELD_NUMBER = 14;
    public static final int ROAD_NAME_FIELD_NUMBER = 11;
    public static final int ROAD_NO_FIELD_NUMBER = 15;
    public static final int ROUTE_PREVIEW_OFF_FIELD_NUMBER = 31;
    public static final int ROUTE_TAG_OFF_FIELD_NUMBER = 33;
    public static final int SECOND_LINE_FIELD_NUMBER = 30;
    public static final int SHOW_PANEL_FIELD_NUMBER = 52;
    public static final int SUB_TITLE_FIELD_NUMBER = 2;
    public static final int TAG_FIELD_NUMBER = 27;
    public static final int TAG_INFO_FIELD_NUMBER = 28;
    public static final int TIME_S_FIELD_NUMBER = 19;
    public static final int TIPS_BROADCAST_FIELD_NUMBER = 9;
    public static final int TIPS_COPY_FIELD_NUMBER = 8;
    public static final int TIPS_TYPE_FIELD_NUMBER = 26;
    public static final int TIP_ID_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 1;
    public static final int TRAFFIC_LIMIT_INFO_ID_FIELD_NUMBER = 44;
    public static final int TYPE_FIELD_NUMBER = 13;
    public static final int UI_TYPE_FIELD_NUMBER = 48;
    private List<ByteStringMicro> allPassId_;
    private ByteStringMicro assistInfo_;
    private int backColorId_;
    private action_t buttonAction_;
    private int cachedSize;
    private ByteStringMicro carlimitInfoId_;
    private ByteStringMicro cityId_;
    private List<ByteStringMicro> copyWritings_;
    private int displayPos_;
    private int duTipId_;
    private ByteStringMicro duTitle_;
    private List<end_button_info> endBtn_;
    private long eventId_;
    private List<Long> eventIds_;
    private ByteStringMicro expalnTitle_;
    private explain_bubble_t explainBubble_;
    private ByteStringMicro explainSubTitle_;
    private ByteStringMicro firstLine_;
    private ByteStringMicro gifUrlDark_;
    private ByteStringMicro gifUrl_;
    private int groupId_;
    private boolean hasAssistInfo;
    private boolean hasBackColorId;
    private boolean hasButtonAction;
    private boolean hasCarlimitInfoId;
    private boolean hasCityId;
    private boolean hasDisplayPos;
    private boolean hasDuTipId;
    private boolean hasDuTitle;
    private boolean hasEventId;
    private boolean hasExpalnTitle;
    private boolean hasExplainBubble;
    private boolean hasExplainSubTitle;
    private boolean hasFirstLine;
    private boolean hasGifUrl;
    private boolean hasGifUrlDark;
    private boolean hasGroupId;
    private boolean hasIconId;
    private boolean hasIdssCardId;
    private boolean hasJumpFlag;
    private boolean hasLength;
    private boolean hasLittleAction;
    private boolean hasMainAction;
    private boolean hasNewPattern;
    private boolean hasPanelFlag;
    private boolean hasPermitInfoId;
    private boolean hasRoadName;
    private boolean hasRoadNo;
    private boolean hasRoutePreviewOff;
    private boolean hasRouteTagOff;
    private boolean hasShowPanel;
    private boolean hasSubTitle;
    private boolean hasTag;
    private boolean hasTagInfo;
    private boolean hasTimeS;
    private boolean hasTipId;
    private boolean hasTipsBroadcast;
    private boolean hasTipsCopy;
    private boolean hasTipsType;
    private boolean hasTitle;
    private boolean hasType;
    private boolean hasUiType;
    private int iconId_;
    private int idssCardId_;
    private List<ByteStringMicro> imageUrl_;
    private boolean jumpFlag_;
    private int length_;
    private action_t littleAction_;
    private action_t mainAction_;
    private boolean newPattern_;
    private boolean panelFlag_;
    private List<ByteStringMicro> passId_;
    private ByteStringMicro permitInfoId_;
    private ByteStringMicro roadName_;
    private int roadNo_;
    private boolean routePreviewOff_;
    private boolean routeTagOff_;
    private List<ByteStringMicro> secondLine_;
    private boolean showPanel_;
    private ByteStringMicro subTitle_;
    private ByteStringMicro tagInfo_;
    private ByteStringMicro tag_;
    private int timeS_;
    private int tipId_;
    private ByteStringMicro tipsBroadcast_;
    private ByteStringMicro tipsCopy_;
    private int tipsType_;
    private ByteStringMicro title_;
    private List<ByteStringMicro> trafficLimitInfoId_;
    private int type_;
    private int uiType_;

    public yellow_tips_list_t() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title_ = byteStringMicro;
        this.subTitle_ = byteStringMicro;
        this.assistInfo_ = byteStringMicro;
        this.tipId_ = 0;
        this.iconId_ = 0;
        this.backColorId_ = 0;
        this.endBtn_ = Collections.emptyList();
        this.tipsCopy_ = byteStringMicro;
        this.tipsBroadcast_ = byteStringMicro;
        this.expalnTitle_ = byteStringMicro;
        this.roadName_ = byteStringMicro;
        this.length_ = 0;
        this.type_ = 0;
        this.permitInfoId_ = byteStringMicro;
        this.roadNo_ = 0;
        this.jumpFlag_ = false;
        this.panelFlag_ = false;
        this.eventId_ = 0L;
        this.timeS_ = 0;
        this.imageUrl_ = Collections.emptyList();
        this.copyWritings_ = Collections.emptyList();
        this.newPattern_ = false;
        this.explainSubTitle_ = byteStringMicro;
        this.explainBubble_ = null;
        this.displayPos_ = 0;
        this.tipsType_ = 0;
        this.tag_ = byteStringMicro;
        this.tagInfo_ = byteStringMicro;
        this.firstLine_ = byteStringMicro;
        this.secondLine_ = Collections.emptyList();
        this.routePreviewOff_ = false;
        this.groupId_ = 0;
        this.routeTagOff_ = false;
        this.cityId_ = byteStringMicro;
        this.buttonAction_ = null;
        this.littleAction_ = null;
        this.mainAction_ = null;
        this.carlimitInfoId_ = byteStringMicro;
        this.trafficLimitInfoId_ = Collections.emptyList();
        this.idssCardId_ = 0;
        this.gifUrl_ = byteStringMicro;
        this.gifUrlDark_ = byteStringMicro;
        this.uiType_ = 0;
        this.duTipId_ = 0;
        this.duTitle_ = byteStringMicro;
        this.showPanel_ = false;
        this.eventIds_ = Collections.emptyList();
        this.passId_ = Collections.emptyList();
        this.allPassId_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static yellow_tips_list_t parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new yellow_tips_list_t().mergeFrom(codedInputStreamMicro);
    }

    public static yellow_tips_list_t parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (yellow_tips_list_t) new yellow_tips_list_t().mergeFrom(bArr);
    }

    public yellow_tips_list_t addAllPassId(ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        if (this.allPassId_.isEmpty()) {
            this.allPassId_ = new ArrayList();
        }
        this.allPassId_.add(byteStringMicro);
        return this;
    }

    public yellow_tips_list_t addCopyWritings(ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        if (this.copyWritings_.isEmpty()) {
            this.copyWritings_ = new ArrayList();
        }
        this.copyWritings_.add(byteStringMicro);
        return this;
    }

    public yellow_tips_list_t addEndBtn(end_button_info end_button_infoVar) {
        if (end_button_infoVar == null) {
            return this;
        }
        if (this.endBtn_.isEmpty()) {
            this.endBtn_ = new ArrayList();
        }
        this.endBtn_.add(end_button_infoVar);
        return this;
    }

    public yellow_tips_list_t addEventIds(long j) {
        if (this.eventIds_.isEmpty()) {
            this.eventIds_ = new ArrayList();
        }
        this.eventIds_.add(Long.valueOf(j));
        return this;
    }

    public yellow_tips_list_t addImageUrl(ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        if (this.imageUrl_.isEmpty()) {
            this.imageUrl_ = new ArrayList();
        }
        this.imageUrl_.add(byteStringMicro);
        return this;
    }

    public yellow_tips_list_t addPassId(ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        if (this.passId_.isEmpty()) {
            this.passId_ = new ArrayList();
        }
        this.passId_.add(byteStringMicro);
        return this;
    }

    public yellow_tips_list_t addSecondLine(ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        if (this.secondLine_.isEmpty()) {
            this.secondLine_ = new ArrayList();
        }
        this.secondLine_.add(byteStringMicro);
        return this;
    }

    public yellow_tips_list_t addTrafficLimitInfoId(ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        if (this.trafficLimitInfoId_.isEmpty()) {
            this.trafficLimitInfoId_ = new ArrayList();
        }
        this.trafficLimitInfoId_.add(byteStringMicro);
        return this;
    }

    public final yellow_tips_list_t clear() {
        clearTitle();
        clearSubTitle();
        clearAssistInfo();
        clearTipId();
        clearIconId();
        clearBackColorId();
        clearEndBtn();
        clearTipsCopy();
        clearTipsBroadcast();
        clearExpalnTitle();
        clearRoadName();
        clearLength();
        clearType();
        clearPermitInfoId();
        clearRoadNo();
        clearJumpFlag();
        clearPanelFlag();
        clearEventId();
        clearTimeS();
        clearImageUrl();
        clearCopyWritings();
        clearNewPattern();
        clearExplainSubTitle();
        clearExplainBubble();
        clearDisplayPos();
        clearTipsType();
        clearTag();
        clearTagInfo();
        clearFirstLine();
        clearSecondLine();
        clearRoutePreviewOff();
        clearGroupId();
        clearRouteTagOff();
        clearCityId();
        clearButtonAction();
        clearLittleAction();
        clearMainAction();
        clearCarlimitInfoId();
        clearTrafficLimitInfoId();
        clearIdssCardId();
        clearGifUrl();
        clearGifUrlDark();
        clearUiType();
        clearDuTipId();
        clearDuTitle();
        clearShowPanel();
        clearEventIds();
        clearPassId();
        clearAllPassId();
        this.cachedSize = -1;
        return this;
    }

    public yellow_tips_list_t clearAllPassId() {
        this.allPassId_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearAssistInfo() {
        this.hasAssistInfo = false;
        this.assistInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearBackColorId() {
        this.hasBackColorId = false;
        this.backColorId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearButtonAction() {
        this.hasButtonAction = false;
        this.buttonAction_ = null;
        return this;
    }

    public yellow_tips_list_t clearCarlimitInfoId() {
        this.hasCarlimitInfoId = false;
        this.carlimitInfoId_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearCityId() {
        this.hasCityId = false;
        this.cityId_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearCopyWritings() {
        this.copyWritings_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearDisplayPos() {
        this.hasDisplayPos = false;
        this.displayPos_ = 0;
        return this;
    }

    public yellow_tips_list_t clearDuTipId() {
        this.hasDuTipId = false;
        this.duTipId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearDuTitle() {
        this.hasDuTitle = false;
        this.duTitle_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearEndBtn() {
        this.endBtn_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearEventId() {
        this.hasEventId = false;
        this.eventId_ = 0L;
        return this;
    }

    public yellow_tips_list_t clearEventIds() {
        this.eventIds_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearExpalnTitle() {
        this.hasExpalnTitle = false;
        this.expalnTitle_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearExplainBubble() {
        this.hasExplainBubble = false;
        this.explainBubble_ = null;
        return this;
    }

    public yellow_tips_list_t clearExplainSubTitle() {
        this.hasExplainSubTitle = false;
        this.explainSubTitle_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearFirstLine() {
        this.hasFirstLine = false;
        this.firstLine_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearGifUrl() {
        this.hasGifUrl = false;
        this.gifUrl_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearGifUrlDark() {
        this.hasGifUrlDark = false;
        this.gifUrlDark_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearGroupId() {
        this.hasGroupId = false;
        this.groupId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearIconId() {
        this.hasIconId = false;
        this.iconId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearIdssCardId() {
        this.hasIdssCardId = false;
        this.idssCardId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearImageUrl() {
        this.imageUrl_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearJumpFlag() {
        this.hasJumpFlag = false;
        this.jumpFlag_ = false;
        return this;
    }

    public yellow_tips_list_t clearLength() {
        this.hasLength = false;
        this.length_ = 0;
        return this;
    }

    public yellow_tips_list_t clearLittleAction() {
        this.hasLittleAction = false;
        this.littleAction_ = null;
        return this;
    }

    public yellow_tips_list_t clearMainAction() {
        this.hasMainAction = false;
        this.mainAction_ = null;
        return this;
    }

    public yellow_tips_list_t clearNewPattern() {
        this.hasNewPattern = false;
        this.newPattern_ = false;
        return this;
    }

    public yellow_tips_list_t clearPanelFlag() {
        this.hasPanelFlag = false;
        this.panelFlag_ = false;
        return this;
    }

    public yellow_tips_list_t clearPassId() {
        this.passId_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearPermitInfoId() {
        this.hasPermitInfoId = false;
        this.permitInfoId_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearRoadName() {
        this.hasRoadName = false;
        this.roadName_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearRoadNo() {
        this.hasRoadNo = false;
        this.roadNo_ = 0;
        return this;
    }

    public yellow_tips_list_t clearRoutePreviewOff() {
        this.hasRoutePreviewOff = false;
        this.routePreviewOff_ = false;
        return this;
    }

    public yellow_tips_list_t clearRouteTagOff() {
        this.hasRouteTagOff = false;
        this.routeTagOff_ = false;
        return this;
    }

    public yellow_tips_list_t clearSecondLine() {
        this.secondLine_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearShowPanel() {
        this.hasShowPanel = false;
        this.showPanel_ = false;
        return this;
    }

    public yellow_tips_list_t clearSubTitle() {
        this.hasSubTitle = false;
        this.subTitle_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearTag() {
        this.hasTag = false;
        this.tag_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearTagInfo() {
        this.hasTagInfo = false;
        this.tagInfo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearTimeS() {
        this.hasTimeS = false;
        this.timeS_ = 0;
        return this;
    }

    public yellow_tips_list_t clearTipId() {
        this.hasTipId = false;
        this.tipId_ = 0;
        return this;
    }

    public yellow_tips_list_t clearTipsBroadcast() {
        this.hasTipsBroadcast = false;
        this.tipsBroadcast_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearTipsCopy() {
        this.hasTipsCopy = false;
        this.tipsCopy_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearTipsType() {
        this.hasTipsType = false;
        this.tipsType_ = 0;
        return this;
    }

    public yellow_tips_list_t clearTitle() {
        this.hasTitle = false;
        this.title_ = ByteStringMicro.EMPTY;
        return this;
    }

    public yellow_tips_list_t clearTrafficLimitInfoId() {
        this.trafficLimitInfoId_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_list_t clearType() {
        this.hasType = false;
        this.type_ = 0;
        return this;
    }

    public yellow_tips_list_t clearUiType() {
        this.hasUiType = false;
        this.uiType_ = 0;
        return this;
    }

    public ByteStringMicro getAllPassId(int i) {
        return this.allPassId_.get(i);
    }

    public int getAllPassIdCount() {
        return this.allPassId_.size();
    }

    public List<ByteStringMicro> getAllPassIdList() {
        return this.allPassId_;
    }

    public ByteStringMicro getAssistInfo() {
        return this.assistInfo_;
    }

    public int getBackColorId() {
        return this.backColorId_;
    }

    public action_t getButtonAction() {
        return this.buttonAction_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getCarlimitInfoId() {
        return this.carlimitInfoId_;
    }

    public ByteStringMicro getCityId() {
        return this.cityId_;
    }

    public ByteStringMicro getCopyWritings(int i) {
        return this.copyWritings_.get(i);
    }

    public int getCopyWritingsCount() {
        return this.copyWritings_.size();
    }

    public List<ByteStringMicro> getCopyWritingsList() {
        return this.copyWritings_;
    }

    public int getDisplayPos() {
        return this.displayPos_;
    }

    public int getDuTipId() {
        return this.duTipId_;
    }

    public ByteStringMicro getDuTitle() {
        return this.duTitle_;
    }

    public end_button_info getEndBtn(int i) {
        return this.endBtn_.get(i);
    }

    public int getEndBtnCount() {
        return this.endBtn_.size();
    }

    public List<end_button_info> getEndBtnList() {
        return this.endBtn_;
    }

    public long getEventId() {
        return this.eventId_;
    }

    public long getEventIds(int i) {
        return this.eventIds_.get(i).longValue();
    }

    public int getEventIdsCount() {
        return this.eventIds_.size();
    }

    public List<Long> getEventIdsList() {
        return this.eventIds_;
    }

    public ByteStringMicro getExpalnTitle() {
        return this.expalnTitle_;
    }

    public explain_bubble_t getExplainBubble() {
        return this.explainBubble_;
    }

    public ByteStringMicro getExplainSubTitle() {
        return this.explainSubTitle_;
    }

    public ByteStringMicro getFirstLine() {
        return this.firstLine_;
    }

    public ByteStringMicro getGifUrl() {
        return this.gifUrl_;
    }

    public ByteStringMicro getGifUrlDark() {
        return this.gifUrlDark_;
    }

    public int getGroupId() {
        return this.groupId_;
    }

    public int getIconId() {
        return this.iconId_;
    }

    public int getIdssCardId() {
        return this.idssCardId_;
    }

    public ByteStringMicro getImageUrl(int i) {
        return this.imageUrl_.get(i);
    }

    public int getImageUrlCount() {
        return this.imageUrl_.size();
    }

    public List<ByteStringMicro> getImageUrlList() {
        return this.imageUrl_;
    }

    public boolean getJumpFlag() {
        return this.jumpFlag_;
    }

    public int getLength() {
        return this.length_;
    }

    public action_t getLittleAction() {
        return this.littleAction_;
    }

    public action_t getMainAction() {
        return this.mainAction_;
    }

    public boolean getNewPattern() {
        return this.newPattern_;
    }

    public boolean getPanelFlag() {
        return this.panelFlag_;
    }

    public ByteStringMicro getPassId(int i) {
        return this.passId_.get(i);
    }

    public int getPassIdCount() {
        return this.passId_.size();
    }

    public List<ByteStringMicro> getPassIdList() {
        return this.passId_;
    }

    public ByteStringMicro getPermitInfoId() {
        return this.permitInfoId_;
    }

    public ByteStringMicro getRoadName() {
        return this.roadName_;
    }

    public int getRoadNo() {
        return this.roadNo_;
    }

    public boolean getRoutePreviewOff() {
        return this.routePreviewOff_;
    }

    public boolean getRouteTagOff() {
        return this.routeTagOff_;
    }

    public ByteStringMicro getSecondLine(int i) {
        return this.secondLine_.get(i);
    }

    public int getSecondLineCount() {
        return this.secondLine_.size();
    }

    public List<ByteStringMicro> getSecondLineList() {
        return this.secondLine_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeBytesSizeNoTag = 0;
        int iComputeBytesSize = hasTitle() ? CodedOutputStreamMicro.computeBytesSize(1, getTitle()) + 0 : 0;
        if (hasSubTitle()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(2, getSubTitle());
        }
        if (hasAssistInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(3, getAssistInfo());
        }
        if (hasTipId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(4, getTipId());
        }
        if (hasIconId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(5, getIconId());
        }
        if (hasBackColorId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(6, getBackColorId());
        }
        Iterator<end_button_info> it = getEndBtnList().iterator();
        while (it.hasNext()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeMessageSize(7, it.next());
        }
        if (hasTipsCopy()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(8, getTipsCopy());
        }
        if (hasTipsBroadcast()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(9, getTipsBroadcast());
        }
        if (hasExpalnTitle()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(10, getExpalnTitle());
        }
        if (hasRoadName()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(11, getRoadName());
        }
        if (hasLength()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(12, getLength());
        }
        if (hasType()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(13, getType());
        }
        if (hasPermitInfoId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(14, getPermitInfoId());
        }
        if (hasRoadNo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(15, getRoadNo());
        }
        if (hasJumpFlag()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBoolSize(16, getJumpFlag());
        }
        if (hasPanelFlag()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBoolSize(17, getPanelFlag());
        }
        if (hasEventId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt64Size(18, getEventId());
        }
        if (hasTimeS()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(19, getTimeS());
        }
        Iterator<ByteStringMicro> it2 = getImageUrlList().iterator();
        int iComputeBytesSizeNoTag2 = 0;
        while (it2.hasNext()) {
            iComputeBytesSizeNoTag2 += CodedOutputStreamMicro.computeBytesSizeNoTag(it2.next());
        }
        int size = iComputeBytesSize + iComputeBytesSizeNoTag2 + (getImageUrlList().size() * 2);
        Iterator<ByteStringMicro> it3 = getCopyWritingsList().iterator();
        int iComputeBytesSizeNoTag3 = 0;
        while (it3.hasNext()) {
            iComputeBytesSizeNoTag3 += CodedOutputStreamMicro.computeBytesSizeNoTag(it3.next());
        }
        int size2 = size + iComputeBytesSizeNoTag3 + (getCopyWritingsList().size() * 2);
        if (hasNewPattern()) {
            size2 += CodedOutputStreamMicro.computeBoolSize(22, getNewPattern());
        }
        if (hasExplainSubTitle()) {
            size2 += CodedOutputStreamMicro.computeBytesSize(23, getExplainSubTitle());
        }
        if (hasExplainBubble()) {
            size2 += CodedOutputStreamMicro.computeMessageSize(24, getExplainBubble());
        }
        if (hasDisplayPos()) {
            size2 += CodedOutputStreamMicro.computeInt32Size(25, getDisplayPos());
        }
        if (hasTipsType()) {
            size2 += CodedOutputStreamMicro.computeInt32Size(26, getTipsType());
        }
        if (hasTag()) {
            size2 += CodedOutputStreamMicro.computeBytesSize(27, getTag());
        }
        if (hasTagInfo()) {
            size2 += CodedOutputStreamMicro.computeBytesSize(28, getTagInfo());
        }
        if (hasFirstLine()) {
            size2 += CodedOutputStreamMicro.computeBytesSize(29, getFirstLine());
        }
        Iterator<ByteStringMicro> it4 = getSecondLineList().iterator();
        int iComputeBytesSizeNoTag4 = 0;
        while (it4.hasNext()) {
            iComputeBytesSizeNoTag4 += CodedOutputStreamMicro.computeBytesSizeNoTag(it4.next());
        }
        int size3 = size2 + iComputeBytesSizeNoTag4 + (getSecondLineList().size() * 2);
        if (hasRoutePreviewOff()) {
            size3 += CodedOutputStreamMicro.computeBoolSize(31, getRoutePreviewOff());
        }
        if (hasGroupId()) {
            size3 += CodedOutputStreamMicro.computeInt32Size(32, getGroupId());
        }
        if (hasRouteTagOff()) {
            size3 += CodedOutputStreamMicro.computeBoolSize(33, getRouteTagOff());
        }
        if (hasCityId()) {
            size3 += CodedOutputStreamMicro.computeBytesSize(34, getCityId());
        }
        if (hasButtonAction()) {
            size3 += CodedOutputStreamMicro.computeMessageSize(40, getButtonAction());
        }
        if (hasLittleAction()) {
            size3 += CodedOutputStreamMicro.computeMessageSize(41, getLittleAction());
        }
        if (hasMainAction()) {
            size3 += CodedOutputStreamMicro.computeMessageSize(42, getMainAction());
        }
        if (hasCarlimitInfoId()) {
            size3 += CodedOutputStreamMicro.computeBytesSize(43, getCarlimitInfoId());
        }
        Iterator<ByteStringMicro> it5 = getTrafficLimitInfoIdList().iterator();
        int iComputeBytesSizeNoTag5 = 0;
        while (it5.hasNext()) {
            iComputeBytesSizeNoTag5 += CodedOutputStreamMicro.computeBytesSizeNoTag(it5.next());
        }
        int size4 = size3 + iComputeBytesSizeNoTag5 + (getTrafficLimitInfoIdList().size() * 2);
        if (hasIdssCardId()) {
            size4 += CodedOutputStreamMicro.computeInt32Size(45, getIdssCardId());
        }
        if (hasGifUrl()) {
            size4 += CodedOutputStreamMicro.computeBytesSize(46, getGifUrl());
        }
        if (hasGifUrlDark()) {
            size4 += CodedOutputStreamMicro.computeBytesSize(47, getGifUrlDark());
        }
        if (hasUiType()) {
            size4 += CodedOutputStreamMicro.computeInt32Size(48, getUiType());
        }
        if (hasDuTipId()) {
            size4 += CodedOutputStreamMicro.computeInt32Size(50, getDuTipId());
        }
        if (hasDuTitle()) {
            size4 += CodedOutputStreamMicro.computeBytesSize(51, getDuTitle());
        }
        if (hasShowPanel()) {
            size4 += CodedOutputStreamMicro.computeBoolSize(52, getShowPanel());
        }
        Iterator<Long> it6 = getEventIdsList().iterator();
        int iComputeInt64SizeNoTag = 0;
        while (it6.hasNext()) {
            iComputeInt64SizeNoTag += CodedOutputStreamMicro.computeInt64SizeNoTag(it6.next().longValue());
        }
        int size5 = size4 + iComputeInt64SizeNoTag + (getEventIdsList().size() * 2);
        Iterator<ByteStringMicro> it7 = getPassIdList().iterator();
        int iComputeBytesSizeNoTag6 = 0;
        while (it7.hasNext()) {
            iComputeBytesSizeNoTag6 += CodedOutputStreamMicro.computeBytesSizeNoTag(it7.next());
        }
        int size6 = size5 + iComputeBytesSizeNoTag6 + (getPassIdList().size() * 2);
        Iterator<ByteStringMicro> it8 = getAllPassIdList().iterator();
        while (it8.hasNext()) {
            iComputeBytesSizeNoTag += CodedOutputStreamMicro.computeBytesSizeNoTag(it8.next());
        }
        int size7 = size6 + iComputeBytesSizeNoTag + (getAllPassIdList().size() * 2);
        this.cachedSize = size7;
        return size7;
    }

    public boolean getShowPanel() {
        return this.showPanel_;
    }

    public ByteStringMicro getSubTitle() {
        return this.subTitle_;
    }

    public ByteStringMicro getTag() {
        return this.tag_;
    }

    public ByteStringMicro getTagInfo() {
        return this.tagInfo_;
    }

    public int getTimeS() {
        return this.timeS_;
    }

    public int getTipId() {
        return this.tipId_;
    }

    public ByteStringMicro getTipsBroadcast() {
        return this.tipsBroadcast_;
    }

    public ByteStringMicro getTipsCopy() {
        return this.tipsCopy_;
    }

    public int getTipsType() {
        return this.tipsType_;
    }

    public ByteStringMicro getTitle() {
        return this.title_;
    }

    public ByteStringMicro getTrafficLimitInfoId(int i) {
        return this.trafficLimitInfoId_.get(i);
    }

    public int getTrafficLimitInfoIdCount() {
        return this.trafficLimitInfoId_.size();
    }

    public List<ByteStringMicro> getTrafficLimitInfoIdList() {
        return this.trafficLimitInfoId_;
    }

    public int getType() {
        return this.type_;
    }

    public int getUiType() {
        return this.uiType_;
    }

    public boolean hasAssistInfo() {
        return this.hasAssistInfo;
    }

    public boolean hasBackColorId() {
        return this.hasBackColorId;
    }

    public boolean hasButtonAction() {
        return this.hasButtonAction;
    }

    public boolean hasCarlimitInfoId() {
        return this.hasCarlimitInfoId;
    }

    public boolean hasCityId() {
        return this.hasCityId;
    }

    public boolean hasDisplayPos() {
        return this.hasDisplayPos;
    }

    public boolean hasDuTipId() {
        return this.hasDuTipId;
    }

    public boolean hasDuTitle() {
        return this.hasDuTitle;
    }

    public boolean hasEventId() {
        return this.hasEventId;
    }

    public boolean hasExpalnTitle() {
        return this.hasExpalnTitle;
    }

    public boolean hasExplainBubble() {
        return this.hasExplainBubble;
    }

    public boolean hasExplainSubTitle() {
        return this.hasExplainSubTitle;
    }

    public boolean hasFirstLine() {
        return this.hasFirstLine;
    }

    public boolean hasGifUrl() {
        return this.hasGifUrl;
    }

    public boolean hasGifUrlDark() {
        return this.hasGifUrlDark;
    }

    public boolean hasGroupId() {
        return this.hasGroupId;
    }

    public boolean hasIconId() {
        return this.hasIconId;
    }

    public boolean hasIdssCardId() {
        return this.hasIdssCardId;
    }

    public boolean hasJumpFlag() {
        return this.hasJumpFlag;
    }

    public boolean hasLength() {
        return this.hasLength;
    }

    public boolean hasLittleAction() {
        return this.hasLittleAction;
    }

    public boolean hasMainAction() {
        return this.hasMainAction;
    }

    public boolean hasNewPattern() {
        return this.hasNewPattern;
    }

    public boolean hasPanelFlag() {
        return this.hasPanelFlag;
    }

    public boolean hasPermitInfoId() {
        return this.hasPermitInfoId;
    }

    public boolean hasRoadName() {
        return this.hasRoadName;
    }

    public boolean hasRoadNo() {
        return this.hasRoadNo;
    }

    public boolean hasRoutePreviewOff() {
        return this.hasRoutePreviewOff;
    }

    public boolean hasRouteTagOff() {
        return this.hasRouteTagOff;
    }

    public boolean hasShowPanel() {
        return this.hasShowPanel;
    }

    public boolean hasSubTitle() {
        return this.hasSubTitle;
    }

    public boolean hasTag() {
        return this.hasTag;
    }

    public boolean hasTagInfo() {
        return this.hasTagInfo;
    }

    public boolean hasTimeS() {
        return this.hasTimeS;
    }

    public boolean hasTipId() {
        return this.hasTipId;
    }

    public boolean hasTipsBroadcast() {
        return this.hasTipsBroadcast;
    }

    public boolean hasTipsCopy() {
        return this.hasTipsCopy;
    }

    public boolean hasTipsType() {
        return this.hasTipsType;
    }

    public boolean hasTitle() {
        return this.hasTitle;
    }

    public boolean hasType() {
        return this.hasType;
    }

    public boolean hasUiType() {
        return this.hasUiType;
    }

    public final boolean isInitialized() {
        return this.hasTitle && this.hasTipId;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public yellow_tips_list_t mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    setTitle(codedInputStreamMicro.readBytes());
                    break;
                case 18:
                    setSubTitle(codedInputStreamMicro.readBytes());
                    break;
                case 26:
                    setAssistInfo(codedInputStreamMicro.readBytes());
                    break;
                case 32:
                    setTipId(codedInputStreamMicro.readInt32());
                    break;
                case 40:
                    setIconId(codedInputStreamMicro.readInt32());
                    break;
                case 48:
                    setBackColorId(codedInputStreamMicro.readInt32());
                    break;
                case 58:
                    end_button_info end_button_infoVar = new end_button_info();
                    codedInputStreamMicro.readMessage(end_button_infoVar);
                    addEndBtn(end_button_infoVar);
                    break;
                case 66:
                    setTipsCopy(codedInputStreamMicro.readBytes());
                    break;
                case 74:
                    setTipsBroadcast(codedInputStreamMicro.readBytes());
                    break;
                case 82:
                    setExpalnTitle(codedInputStreamMicro.readBytes());
                    break;
                case 90:
                    setRoadName(codedInputStreamMicro.readBytes());
                    break;
                case 96:
                    setLength(codedInputStreamMicro.readInt32());
                    break;
                case 104:
                    setType(codedInputStreamMicro.readInt32());
                    break;
                case 114:
                    setPermitInfoId(codedInputStreamMicro.readBytes());
                    break;
                case 120:
                    setRoadNo(codedInputStreamMicro.readInt32());
                    break;
                case 128:
                    setJumpFlag(codedInputStreamMicro.readBool());
                    break;
                case 136:
                    setPanelFlag(codedInputStreamMicro.readBool());
                    break;
                case 144:
                    setEventId(codedInputStreamMicro.readInt64());
                    break;
                case 152:
                    setTimeS(codedInputStreamMicro.readInt32());
                    break;
                case 162:
                    addImageUrl(codedInputStreamMicro.readBytes());
                    break;
                case c.f6376a /* 170 */:
                    addCopyWritings(codedInputStreamMicro.readBytes());
                    break;
                case 176:
                    setNewPattern(codedInputStreamMicro.readBool());
                    break;
                case 186:
                    setExplainSubTitle(codedInputStreamMicro.readBytes());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                    explain_bubble_t explain_bubble_tVar = new explain_bubble_t();
                    codedInputStreamMicro.readMessage(explain_bubble_tVar);
                    setExplainBubble(explain_bubble_tVar);
                    break;
                case 200:
                    setDisplayPos(codedInputStreamMicro.readInt32());
                    break;
                case 208:
                    setTipsType(codedInputStreamMicro.readInt32());
                    break;
                case 218:
                    setTag(codedInputStreamMicro.readBytes());
                    break;
                case 226:
                    setTagInfo(codedInputStreamMicro.readBytes());
                    break;
                case 234:
                    setFirstLine(codedInputStreamMicro.readBytes());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                    addSecondLine(codedInputStreamMicro.readBytes());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                    setRoutePreviewOff(codedInputStreamMicro.readBool());
                    break;
                case 256:
                    setGroupId(codedInputStreamMicro.readInt32());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME /* 264 */:
                    setRouteTagOff(codedInputStreamMicro.readBool());
                    break;
                case 274:
                    setCityId(codedInputStreamMicro.readBytes());
                    break;
                case 322:
                    action_t action_tVar = new action_t();
                    codedInputStreamMicro.readMessage(action_tVar);
                    setButtonAction(action_tVar);
                    break;
                case 330:
                    action_t action_tVar2 = new action_t();
                    codedInputStreamMicro.readMessage(action_tVar2);
                    setLittleAction(action_tVar2);
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME /* 338 */:
                    action_t action_tVar3 = new action_t();
                    codedInputStreamMicro.readMessage(action_tVar3);
                    setMainAction(action_tVar3);
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME /* 346 */:
                    setCarlimitInfoId(codedInputStreamMicro.readBytes());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY /* 354 */:
                    addTrafficLimitInfoId(codedInputStreamMicro.readBytes());
                    break;
                case 360:
                    setIdssCardId(codedInputStreamMicro.readInt32());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT /* 370 */:
                    setGifUrl(codedInputStreamMicro.readBytes());
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE /* 378 */:
                    setGifUrlDark(codedInputStreamMicro.readBytes());
                    break;
                case 384:
                    setUiType(codedInputStreamMicro.readInt32());
                    break;
                case 400:
                    setDuTipId(codedInputStreamMicro.readInt32());
                    break;
                case 410:
                    setDuTitle(codedInputStreamMicro.readBytes());
                    break;
                case 416:
                    setShowPanel(codedInputStreamMicro.readBool());
                    break;
                case TypedValues.CycleType.TYPE_WAVE_OFFSET /* 424 */:
                    addEventIds(codedInputStreamMicro.readInt64());
                    break;
                case 442:
                    addPassId(codedInputStreamMicro.readBytes());
                    break;
                case 450:
                    addAllPassId(codedInputStreamMicro.readBytes());
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

    public yellow_tips_list_t setAllPassId(int i, ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        this.allPassId_.set(i, byteStringMicro);
        return this;
    }

    public yellow_tips_list_t setAssistInfo(ByteStringMicro byteStringMicro) {
        this.hasAssistInfo = true;
        this.assistInfo_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setBackColorId(int i) {
        this.hasBackColorId = true;
        this.backColorId_ = i;
        return this;
    }

    public yellow_tips_list_t setButtonAction(action_t action_tVar) {
        if (action_tVar == null) {
            return clearButtonAction();
        }
        this.hasButtonAction = true;
        this.buttonAction_ = action_tVar;
        return this;
    }

    public yellow_tips_list_t setCarlimitInfoId(ByteStringMicro byteStringMicro) {
        this.hasCarlimitInfoId = true;
        this.carlimitInfoId_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setCityId(ByteStringMicro byteStringMicro) {
        this.hasCityId = true;
        this.cityId_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setCopyWritings(int i, ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        this.copyWritings_.set(i, byteStringMicro);
        return this;
    }

    public yellow_tips_list_t setDisplayPos(int i) {
        this.hasDisplayPos = true;
        this.displayPos_ = i;
        return this;
    }

    public yellow_tips_list_t setDuTipId(int i) {
        this.hasDuTipId = true;
        this.duTipId_ = i;
        return this;
    }

    public yellow_tips_list_t setDuTitle(ByteStringMicro byteStringMicro) {
        this.hasDuTitle = true;
        this.duTitle_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setEndBtn(int i, end_button_info end_button_infoVar) {
        if (end_button_infoVar == null) {
            return this;
        }
        this.endBtn_.set(i, end_button_infoVar);
        return this;
    }

    public yellow_tips_list_t setEventId(long j) {
        this.hasEventId = true;
        this.eventId_ = j;
        return this;
    }

    public yellow_tips_list_t setEventIds(int i, long j) {
        this.eventIds_.set(i, Long.valueOf(j));
        return this;
    }

    public yellow_tips_list_t setExpalnTitle(ByteStringMicro byteStringMicro) {
        this.hasExpalnTitle = true;
        this.expalnTitle_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setExplainBubble(explain_bubble_t explain_bubble_tVar) {
        if (explain_bubble_tVar == null) {
            return clearExplainBubble();
        }
        this.hasExplainBubble = true;
        this.explainBubble_ = explain_bubble_tVar;
        return this;
    }

    public yellow_tips_list_t setExplainSubTitle(ByteStringMicro byteStringMicro) {
        this.hasExplainSubTitle = true;
        this.explainSubTitle_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setFirstLine(ByteStringMicro byteStringMicro) {
        this.hasFirstLine = true;
        this.firstLine_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setGifUrl(ByteStringMicro byteStringMicro) {
        this.hasGifUrl = true;
        this.gifUrl_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setGifUrlDark(ByteStringMicro byteStringMicro) {
        this.hasGifUrlDark = true;
        this.gifUrlDark_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setGroupId(int i) {
        this.hasGroupId = true;
        this.groupId_ = i;
        return this;
    }

    public yellow_tips_list_t setIconId(int i) {
        this.hasIconId = true;
        this.iconId_ = i;
        return this;
    }

    public yellow_tips_list_t setIdssCardId(int i) {
        this.hasIdssCardId = true;
        this.idssCardId_ = i;
        return this;
    }

    public yellow_tips_list_t setImageUrl(int i, ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        this.imageUrl_.set(i, byteStringMicro);
        return this;
    }

    public yellow_tips_list_t setJumpFlag(boolean z) {
        this.hasJumpFlag = true;
        this.jumpFlag_ = z;
        return this;
    }

    public yellow_tips_list_t setLength(int i) {
        this.hasLength = true;
        this.length_ = i;
        return this;
    }

    public yellow_tips_list_t setLittleAction(action_t action_tVar) {
        if (action_tVar == null) {
            return clearLittleAction();
        }
        this.hasLittleAction = true;
        this.littleAction_ = action_tVar;
        return this;
    }

    public yellow_tips_list_t setMainAction(action_t action_tVar) {
        if (action_tVar == null) {
            return clearMainAction();
        }
        this.hasMainAction = true;
        this.mainAction_ = action_tVar;
        return this;
    }

    public yellow_tips_list_t setNewPattern(boolean z) {
        this.hasNewPattern = true;
        this.newPattern_ = z;
        return this;
    }

    public yellow_tips_list_t setPanelFlag(boolean z) {
        this.hasPanelFlag = true;
        this.panelFlag_ = z;
        return this;
    }

    public yellow_tips_list_t setPassId(int i, ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        this.passId_.set(i, byteStringMicro);
        return this;
    }

    public yellow_tips_list_t setPermitInfoId(ByteStringMicro byteStringMicro) {
        this.hasPermitInfoId = true;
        this.permitInfoId_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setRoadName(ByteStringMicro byteStringMicro) {
        this.hasRoadName = true;
        this.roadName_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setRoadNo(int i) {
        this.hasRoadNo = true;
        this.roadNo_ = i;
        return this;
    }

    public yellow_tips_list_t setRoutePreviewOff(boolean z) {
        this.hasRoutePreviewOff = true;
        this.routePreviewOff_ = z;
        return this;
    }

    public yellow_tips_list_t setRouteTagOff(boolean z) {
        this.hasRouteTagOff = true;
        this.routeTagOff_ = z;
        return this;
    }

    public yellow_tips_list_t setSecondLine(int i, ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        this.secondLine_.set(i, byteStringMicro);
        return this;
    }

    public yellow_tips_list_t setShowPanel(boolean z) {
        this.hasShowPanel = true;
        this.showPanel_ = z;
        return this;
    }

    public yellow_tips_list_t setSubTitle(ByteStringMicro byteStringMicro) {
        this.hasSubTitle = true;
        this.subTitle_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setTag(ByteStringMicro byteStringMicro) {
        this.hasTag = true;
        this.tag_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setTagInfo(ByteStringMicro byteStringMicro) {
        this.hasTagInfo = true;
        this.tagInfo_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setTimeS(int i) {
        this.hasTimeS = true;
        this.timeS_ = i;
        return this;
    }

    public yellow_tips_list_t setTipId(int i) {
        this.hasTipId = true;
        this.tipId_ = i;
        return this;
    }

    public yellow_tips_list_t setTipsBroadcast(ByteStringMicro byteStringMicro) {
        this.hasTipsBroadcast = true;
        this.tipsBroadcast_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setTipsCopy(ByteStringMicro byteStringMicro) {
        this.hasTipsCopy = true;
        this.tipsCopy_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setTipsType(int i) {
        this.hasTipsType = true;
        this.tipsType_ = i;
        return this;
    }

    public yellow_tips_list_t setTitle(ByteStringMicro byteStringMicro) {
        this.hasTitle = true;
        this.title_ = byteStringMicro;
        return this;
    }

    public yellow_tips_list_t setTrafficLimitInfoId(int i, ByteStringMicro byteStringMicro) {
        byteStringMicro.getClass();
        this.trafficLimitInfoId_.set(i, byteStringMicro);
        return this;
    }

    public yellow_tips_list_t setType(int i) {
        this.hasType = true;
        this.type_ = i;
        return this;
    }

    public yellow_tips_list_t setUiType(int i) {
        this.hasUiType = true;
        this.uiType_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTitle()) {
            codedOutputStreamMicro.writeBytes(1, getTitle());
        }
        if (hasSubTitle()) {
            codedOutputStreamMicro.writeBytes(2, getSubTitle());
        }
        if (hasAssistInfo()) {
            codedOutputStreamMicro.writeBytes(3, getAssistInfo());
        }
        if (hasTipId()) {
            codedOutputStreamMicro.writeInt32(4, getTipId());
        }
        if (hasIconId()) {
            codedOutputStreamMicro.writeInt32(5, getIconId());
        }
        if (hasBackColorId()) {
            codedOutputStreamMicro.writeInt32(6, getBackColorId());
        }
        Iterator<end_button_info> it = getEndBtnList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeMessage(7, it.next());
        }
        if (hasTipsCopy()) {
            codedOutputStreamMicro.writeBytes(8, getTipsCopy());
        }
        if (hasTipsBroadcast()) {
            codedOutputStreamMicro.writeBytes(9, getTipsBroadcast());
        }
        if (hasExpalnTitle()) {
            codedOutputStreamMicro.writeBytes(10, getExpalnTitle());
        }
        if (hasRoadName()) {
            codedOutputStreamMicro.writeBytes(11, getRoadName());
        }
        if (hasLength()) {
            codedOutputStreamMicro.writeInt32(12, getLength());
        }
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(13, getType());
        }
        if (hasPermitInfoId()) {
            codedOutputStreamMicro.writeBytes(14, getPermitInfoId());
        }
        if (hasRoadNo()) {
            codedOutputStreamMicro.writeInt32(15, getRoadNo());
        }
        if (hasJumpFlag()) {
            codedOutputStreamMicro.writeBool(16, getJumpFlag());
        }
        if (hasPanelFlag()) {
            codedOutputStreamMicro.writeBool(17, getPanelFlag());
        }
        if (hasEventId()) {
            codedOutputStreamMicro.writeInt64(18, getEventId());
        }
        if (hasTimeS()) {
            codedOutputStreamMicro.writeInt32(19, getTimeS());
        }
        Iterator<ByteStringMicro> it2 = getImageUrlList().iterator();
        while (it2.hasNext()) {
            codedOutputStreamMicro.writeBytes(20, it2.next());
        }
        Iterator<ByteStringMicro> it3 = getCopyWritingsList().iterator();
        while (it3.hasNext()) {
            codedOutputStreamMicro.writeBytes(21, it3.next());
        }
        if (hasNewPattern()) {
            codedOutputStreamMicro.writeBool(22, getNewPattern());
        }
        if (hasExplainSubTitle()) {
            codedOutputStreamMicro.writeBytes(23, getExplainSubTitle());
        }
        if (hasExplainBubble()) {
            codedOutputStreamMicro.writeMessage(24, getExplainBubble());
        }
        if (hasDisplayPos()) {
            codedOutputStreamMicro.writeInt32(25, getDisplayPos());
        }
        if (hasTipsType()) {
            codedOutputStreamMicro.writeInt32(26, getTipsType());
        }
        if (hasTag()) {
            codedOutputStreamMicro.writeBytes(27, getTag());
        }
        if (hasTagInfo()) {
            codedOutputStreamMicro.writeBytes(28, getTagInfo());
        }
        if (hasFirstLine()) {
            codedOutputStreamMicro.writeBytes(29, getFirstLine());
        }
        Iterator<ByteStringMicro> it4 = getSecondLineList().iterator();
        while (it4.hasNext()) {
            codedOutputStreamMicro.writeBytes(30, it4.next());
        }
        if (hasRoutePreviewOff()) {
            codedOutputStreamMicro.writeBool(31, getRoutePreviewOff());
        }
        if (hasGroupId()) {
            codedOutputStreamMicro.writeInt32(32, getGroupId());
        }
        if (hasRouteTagOff()) {
            codedOutputStreamMicro.writeBool(33, getRouteTagOff());
        }
        if (hasCityId()) {
            codedOutputStreamMicro.writeBytes(34, getCityId());
        }
        if (hasButtonAction()) {
            codedOutputStreamMicro.writeMessage(40, getButtonAction());
        }
        if (hasLittleAction()) {
            codedOutputStreamMicro.writeMessage(41, getLittleAction());
        }
        if (hasMainAction()) {
            codedOutputStreamMicro.writeMessage(42, getMainAction());
        }
        if (hasCarlimitInfoId()) {
            codedOutputStreamMicro.writeBytes(43, getCarlimitInfoId());
        }
        Iterator<ByteStringMicro> it5 = getTrafficLimitInfoIdList().iterator();
        while (it5.hasNext()) {
            codedOutputStreamMicro.writeBytes(44, it5.next());
        }
        if (hasIdssCardId()) {
            codedOutputStreamMicro.writeInt32(45, getIdssCardId());
        }
        if (hasGifUrl()) {
            codedOutputStreamMicro.writeBytes(46, getGifUrl());
        }
        if (hasGifUrlDark()) {
            codedOutputStreamMicro.writeBytes(47, getGifUrlDark());
        }
        if (hasUiType()) {
            codedOutputStreamMicro.writeInt32(48, getUiType());
        }
        if (hasDuTipId()) {
            codedOutputStreamMicro.writeInt32(50, getDuTipId());
        }
        if (hasDuTitle()) {
            codedOutputStreamMicro.writeBytes(51, getDuTitle());
        }
        if (hasShowPanel()) {
            codedOutputStreamMicro.writeBool(52, getShowPanel());
        }
        Iterator<Long> it6 = getEventIdsList().iterator();
        while (it6.hasNext()) {
            codedOutputStreamMicro.writeInt64(53, it6.next().longValue());
        }
        Iterator<ByteStringMicro> it7 = getPassIdList().iterator();
        while (it7.hasNext()) {
            codedOutputStreamMicro.writeBytes(55, it7.next());
        }
        Iterator<ByteStringMicro> it8 = getAllPassIdList().iterator();
        while (it8.hasNext()) {
            codedOutputStreamMicro.writeBytes(56, it8.next());
        }
    }
}
