package com.huachenjie.base.interact.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Entity(tableName = "works_interact_event")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020\nJ\u0006\u0010-\u001a\u00020\nJ\u0006\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\nJ\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020\nJ\u0006\u00104\u001a\u00020\nJ\u0006\u00105\u001a\u00020\nJ\u0006\u00106\u001a\u00020\nJ\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u000208J\u0006\u0010;\u001a\u000208J\u0006\u0010<\u001a\u000208J\u0006\u0010=\u001a\u000208J\u0006\u0010>\u001a\u000208J\u0006\u0010?\u001a\u000208R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006A"}, d2 = {"Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", "", "()V", "bizNo", "", "getBizNo", "()Ljava/lang/String;", "setBizNo", "(Ljava/lang/String;)V", "bizType", "", "getBizType", "()I", "setBizType", "(I)V", "commentUserNo", "getCommentUserNo", "setCommentUserNo", StrategyEventDBModel.COLUMN_EVENT_TIME, "", "getEventTime", "()J", "setEventTime", "(J)V", "eventType", "getEventType", "setEventType", "id", "getId", "setId", "source", "getSource", "setSource", "worksAuthorNo", "getWorksAuthorNo", "setWorksAuthorNo", yj7.g.WORKS_NO, "getWorksNo", "setWorksNo", "getCollectEventType", "getFollowEventType", "getLikeAlumniSayEventType", "getLikeCommentAlumniSayEventType", "getLikeCommentEventType", "getLikePostWorksCommentEventType", "getLikePostWorksEventType", "getLikeWorksEventType", "getUnCollectEventType", "getUnFollowEventType", "getUnLikeAlumniSayEventType", "getUnLikeCommentAlumniSayEventType", "getUnLikeCommentEventType", "getUnLikePostWorksCommentEventType", "getUnLikePostWorksEventType", "getUnLikeWorksEventType", "isCollectWorks", "", "isFollowFriend", "isLikeAlumniSay", "isLikeComment", "isLikeCommentAlumniSay", "isLikePostWorks", "isLikePostWorksComment", "isLikeWorks", "Companion", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorksInteractEventBean {
    public static final int BIZ_TYPE_ALUMNI = 10;
    public static final int BIZ_TYPE_COMMENT = 2;
    public static final int BIZ_TYPE_POST = 20;
    public static final int BIZ_TYPE_USER = 3;
    public static final int BIZ_TYPE_WORKS = 1;
    public static final int EVENT_SOURCE_ALUMNI_SAY = 7;
    public static final int EVENT_SOURCE_ALUMNI_SAY_MATCH = 8;
    public static final int EVENT_SOURCE_CHAT = 6;
    public static final int EVENT_SOURCE_DETAIL = 1;
    public static final int EVENT_SOURCE_FOLLOW_LIST = 4;
    public static final int EVENT_SOURCE_FRIEND_LIST = 3;
    public static final int EVENT_SOURCE_NOTIFY_LIST = 2;
    public static final int EVENT_SOURCE_PERSON = 5;
    public static final int EVENT_SOURCE_POST_DETAIL = 10;
    public static final int EVENT_SOURCE_POST_LIST = 9;
    public static final int EVENT_TYPE_ALUMNI_SAY_LIKE = 330;
    public static final int EVENT_TYPE_ALUMNI_SAY_MATCH_LIKE = 332;
    public static final int EVENT_TYPE_ALUMNI_SAY_MATCH_UNLIKE = 333;
    public static final int EVENT_TYPE_ALUMNI_SAY_UNLIKE = 331;
    public static final int EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE = 430;
    public static final int EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_LIKE = 432;
    public static final int EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_UNLIKE = 433;
    public static final int EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_LIKE = 434;
    public static final int EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE = 435;
    public static final int EVENT_TYPE_COMMENT_ALUMNI_SAY_UNLIKE = 431;
    public static final int EVENT_TYPE_COMMENT_DETAIL_CANCEL_LIKE = 411;
    public static final int EVENT_TYPE_COMMENT_DETAIL_LIKE = 410;
    public static final int EVENT_TYPE_COMMENT_LIST_CANCEL_LIKE = 415;
    public static final int EVENT_TYPE_COMMENT_LIST_LIKE = 414;
    public static final int EVENT_TYPE_COMMENT_NOTIFY_CANCEL_LIKE = 413;
    public static final int EVENT_TYPE_COMMENT_NOTIFY_LIKE = 412;
    public static final int EVENT_TYPE_COMMENT_POST_DETAIL_LIKE = 444;
    public static final int EVENT_TYPE_COMMENT_POST_DETAIL_UNLIKE = 445;
    public static final int EVENT_TYPE_COMMENT_POST_LIKE = 440;
    public static final int EVENT_TYPE_COMMENT_POST_NOTIFY_LIKE = 442;
    public static final int EVENT_TYPE_COMMENT_POST_NOTIFY_UNLIKE = 443;
    public static final int EVENT_TYPE_COMMENT_POST_UNLIKE = 441;
    public static final int EVENT_TYPE_FRIEND_CHAT_CANCEL_FOLLOW = 119;
    public static final int EVENT_TYPE_FRIEND_CHAT_FOLLOW = 118;
    public static final int EVENT_TYPE_FRIEND_DETAIL_CANCEL_FOLLOW = 115;
    public static final int EVENT_TYPE_FRIEND_DETAIL_FOLLOW = 114;
    public static final int EVENT_TYPE_FRIEND_LIST_CANCEL_FOLLOW = 110;
    public static final int EVENT_TYPE_FRIEND_LIST_FOLLOW = 111;
    public static final int EVENT_TYPE_FRIEND_NOTIFY_CANCEL_FOLLOW = 113;
    public static final int EVENT_TYPE_FRIEND_NOTIFY_FOLLOW = 112;
    public static final int EVENT_TYPE_FRIEND_PERSON_CANCEL_FOLLOW = 117;
    public static final int EVENT_TYPE_FRIEND_PERSON_FOLLOW = 116;
    public static final int EVENT_TYPE_POST_DETAIL_LIKE = 342;
    public static final int EVENT_TYPE_POST_DETAIL_UNLIKE = 343;
    public static final int EVENT_TYPE_POST_LIKE = 340;
    public static final int EVENT_TYPE_POST_NOTIFY_LIKE = 344;
    public static final int EVENT_TYPE_POST_NOTIFY_UNLIKE = 345;
    public static final int EVENT_TYPE_POST_UNLIKE = 341;
    public static final int EVENT_TYPE_WORKS_DETAIL_CANCEL_COLLECT = 210;
    public static final int EVENT_TYPE_WORKS_DETAIL_CANCEL_LIKE = 310;
    public static final int EVENT_TYPE_WORKS_DETAIL_COLLECT = 211;
    public static final int EVENT_TYPE_WORKS_DETAIL_LIKE = 311;
    public static final int EVENT_TYPE_WORKS_LIST_CANCEL_COLLECT = 212;
    public static final int EVENT_TYPE_WORKS_LIST_CANCEL_LIKE = 312;
    public static final int EVENT_TYPE_WORKS_LIST_COLLECT = 213;
    public static final int EVENT_TYPE_WORKS_LIST_LIKE = 313;

    @ColumnInfo(name = "biz_no")
    @Nullable
    private String bizNo;

    @ColumnInfo(name = "biz_type")
    private int bizType;

    @ColumnInfo(name = "comment_user_no")
    @Nullable
    private String commentUserNo;

    @ColumnInfo(name = "event_time")
    private long eventTime;

    @ColumnInfo(name = "event_type")
    private int eventType;

    @PrimaryKey(autoGenerate = true)
    private long id;
    private int source;

    @ColumnInfo(name = "author_no")
    @Nullable
    private String worksAuthorNo;

    @ColumnInfo(name = "works_no")
    @Nullable
    private String worksNo;

    @Nullable
    public final String getBizNo() {
        return this.bizNo;
    }

    public final int getBizType() {
        return this.bizType;
    }

    public final int getCollectEventType() {
        return this.source == 1 ? 211 : 213;
    }

    @Nullable
    public final String getCommentUserNo() {
        return this.commentUserNo;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final int getFollowEventType() {
        int i = this.source;
        if (i == 1) {
            return 114;
        }
        if (i != 2) {
            return i != 3 ? 116 : 111;
        }
        return 112;
    }

    public final long getId() {
        return this.id;
    }

    public final int getLikeAlumniSayEventType() {
        int i = this.source;
        return (i == 7 || i != 8) ? 330 : 332;
    }

    public final int getLikeCommentAlumniSayEventType() {
        int i = this.source;
        if (i != 2) {
            return (i == 7 || i != 8) ? EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE : EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_LIKE;
        }
        return 434;
    }

    public final int getLikeCommentEventType() {
        int i = this.source;
        if (i != 1) {
            return i != 2 ? 414 : 412;
        }
        return 410;
    }

    public final int getLikePostWorksCommentEventType() {
        int i = this.source;
        if (i != 2) {
            return (i == 9 || i != 10) ? EVENT_TYPE_COMMENT_POST_LIKE : EVENT_TYPE_COMMENT_POST_DETAIL_LIKE;
        }
        return 442;
    }

    public final int getLikePostWorksEventType() {
        int i = this.source;
        if (i != 2) {
            return (i == 9 || i != 10) ? 340 : 342;
        }
        return 344;
    }

    public final int getLikeWorksEventType() {
        return this.source == 1 ? 311 : 313;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getUnCollectEventType() {
        return this.source == 1 ? 210 : 212;
    }

    public final int getUnFollowEventType() {
        int i = this.source;
        if (i == 1) {
            return 115;
        }
        if (i != 2) {
            return i != 3 ? 117 : 110;
        }
        return 113;
    }

    public final int getUnLikeAlumniSayEventType() {
        int i = this.source;
        return (i == 7 || i != 8) ? 331 : 333;
    }

    public final int getUnLikeCommentAlumniSayEventType() {
        int i = this.source;
        if (i != 2) {
            return (i == 7 || i != 8) ? EVENT_TYPE_COMMENT_ALUMNI_SAY_UNLIKE : EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_UNLIKE;
        }
        return EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE;
    }

    public final int getUnLikeCommentEventType() {
        int i = this.source;
        if (i != 1) {
            return i != 2 ? 415 : 413;
        }
        return 411;
    }

    public final int getUnLikePostWorksCommentEventType() {
        int i = this.source;
        if (i == 2) {
            return 443;
        }
        if (i == 9 || i != 10) {
            return 441;
        }
        return EVENT_TYPE_COMMENT_POST_DETAIL_UNLIKE;
    }

    public final int getUnLikePostWorksEventType() {
        int i = this.source;
        if (i != 2) {
            return (i == 9 || i != 10) ? 341 : 343;
        }
        return 345;
    }

    public final int getUnLikeWorksEventType() {
        return this.source == 1 ? 310 : 312;
    }

    @Nullable
    public final String getWorksAuthorNo() {
        return this.worksAuthorNo;
    }

    @Nullable
    public final String getWorksNo() {
        return this.worksNo;
    }

    public final boolean isCollectWorks() {
        int i = this.eventType;
        return i == 211 || i == 213;
    }

    public final boolean isFollowFriend() {
        int i = this.eventType;
        return i == 111 || i == 112 || i == 114;
    }

    public final boolean isLikeAlumniSay() {
        int i = this.eventType;
        return i == 330 || i == 332;
    }

    public final boolean isLikeComment() {
        int i = this.eventType;
        return i == 410 || i == 412 || i == 414;
    }

    public final boolean isLikeCommentAlumniSay() {
        int i = this.eventType;
        return i == 430 || i == 432 || i == 434;
    }

    public final boolean isLikePostWorks() {
        int i = this.eventType;
        return i == 340 || i == 342 || i == 344;
    }

    public final boolean isLikePostWorksComment() {
        int i = this.eventType;
        return i == 440 || i == 442 || i == 444;
    }

    public final boolean isLikeWorks() {
        int i = this.eventType;
        return i == 311 || i == 313;
    }

    public final void setBizNo(@Nullable String str) {
        this.bizNo = str;
    }

    public final void setBizType(int i) {
        this.bizType = i;
    }

    public final void setCommentUserNo(@Nullable String str) {
        this.commentUserNo = str;
    }

    public final void setEventTime(long j) {
        this.eventTime = j;
    }

    public final void setEventType(int i) {
        this.eventType = i;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setSource(int i) {
        this.source = i;
    }

    public final void setWorksAuthorNo(@Nullable String str) {
        this.worksAuthorNo = str;
    }

    public final void setWorksNo(@Nullable String str) {
        this.worksNo = str;
    }
}
