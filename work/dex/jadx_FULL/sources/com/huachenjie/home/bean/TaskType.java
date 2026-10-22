package com.huachenjie.home.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/huachenjie/home/bean/TaskType;", "", "Companion", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface TaskType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_BROWSE_ALL_REWARD = 14;
    public static final int TYPE_BROWSE_GOODS_DETAIL = 8;
    public static final int TYPE_BROWSE_GOODS_INFO_FLOW = 12;
    public static final int TYPE_BROWSE_HOT_WORKS = 13;
    public static final int TYPE_BUY_GOODS = 15;
    public static final int TYPE_DAILY_STEP = 5;
    public static final int TYPE_ELE_FLASH_BUY_DAILY = 21;
    public static final int TYPE_ELE_FLASH_BUY_ONCE = 106;
    public static final int TYPE_FIRST_JOIN_BUDDY = 102;
    public static final int TYPE_FIRST_PUBLISH_BUDDY = 103;
    public static final int TYPE_JOIN_BUDDY = 19;
    public static final int TYPE_JOIN_CHANNEL = 3;
    public static final int TYPE_JUMP_H5 = 10;
    public static final int TYPE_OPEN_OAID = 100;
    public static final int TYPE_PUBLISH_BUDDY = 20;
    public static final int TYPE_PUBLISH_WORK = 6;
    public static final int TYPE_PUSH_SWITCH = 1;
    public static final int TYPE_SEARCH_GOODS = 11;
    public static final int TYPE_SHARE_TASK = 7;
    public static final int TYPE_SIGN_UP = 101;
    public static final int TYPE_SINGLE_RUN = 4;
    public static final int TYPE_SOCIAL_SAY_HELLO = 18;
    public static final int TYPE_SUPPLEMENT_ENERGY = 17;
    public static final int TYPE_TASK_WIDGET = 2;
    public static final int TYPE_TODAY_SIGN = 16;
    public static final int TYPE_WATCH_AD = 9;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/home/bean/TaskType$Companion;", "", "()V", "TYPE_BROWSE_ALL_REWARD", "", "TYPE_BROWSE_GOODS_DETAIL", "TYPE_BROWSE_GOODS_INFO_FLOW", "TYPE_BROWSE_HOT_WORKS", "TYPE_BUY_GOODS", "TYPE_DAILY_STEP", "TYPE_ELE_FLASH_BUY_DAILY", "TYPE_ELE_FLASH_BUY_ONCE", "TYPE_FIRST_JOIN_BUDDY", "TYPE_FIRST_PUBLISH_BUDDY", "TYPE_JOIN_BUDDY", "TYPE_JOIN_CHANNEL", "TYPE_JUMP_H5", "TYPE_OPEN_OAID", "TYPE_PUBLISH_BUDDY", "TYPE_PUBLISH_WORK", "TYPE_PUSH_SWITCH", "TYPE_SEARCH_GOODS", "TYPE_SHARE_TASK", "TYPE_SIGN_UP", "TYPE_SINGLE_RUN", "TYPE_SOCIAL_SAY_HELLO", "TYPE_SUPPLEMENT_ENERGY", "TYPE_TASK_WIDGET", "TYPE_TODAY_SIGN", "TYPE_WATCH_AD", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_BROWSE_ALL_REWARD = 14;
        public static final int TYPE_BROWSE_GOODS_DETAIL = 8;
        public static final int TYPE_BROWSE_GOODS_INFO_FLOW = 12;
        public static final int TYPE_BROWSE_HOT_WORKS = 13;
        public static final int TYPE_BUY_GOODS = 15;
        public static final int TYPE_DAILY_STEP = 5;
        public static final int TYPE_ELE_FLASH_BUY_DAILY = 21;
        public static final int TYPE_ELE_FLASH_BUY_ONCE = 106;
        public static final int TYPE_FIRST_JOIN_BUDDY = 102;
        public static final int TYPE_FIRST_PUBLISH_BUDDY = 103;
        public static final int TYPE_JOIN_BUDDY = 19;
        public static final int TYPE_JOIN_CHANNEL = 3;
        public static final int TYPE_JUMP_H5 = 10;
        public static final int TYPE_OPEN_OAID = 100;
        public static final int TYPE_PUBLISH_BUDDY = 20;
        public static final int TYPE_PUBLISH_WORK = 6;
        public static final int TYPE_PUSH_SWITCH = 1;
        public static final int TYPE_SEARCH_GOODS = 11;
        public static final int TYPE_SHARE_TASK = 7;
        public static final int TYPE_SIGN_UP = 101;
        public static final int TYPE_SINGLE_RUN = 4;
        public static final int TYPE_SOCIAL_SAY_HELLO = 18;
        public static final int TYPE_SUPPLEMENT_ENERGY = 17;
        public static final int TYPE_TASK_WIDGET = 2;
        public static final int TYPE_TODAY_SIGN = 16;
        public static final int TYPE_WATCH_AD = 9;

        private Companion() {
        }
    }
}
