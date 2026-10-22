package com.huachenjie.works.page.share;

import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.page.share.enums.ExtendEvents;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import huachenjie.sdk.share.sharebody.SharedBody;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface OnShareCallback {
    default void a() {
    }

    default String b() {
        return "";
    }

    default void c(@NonNull ExtendEvents type) {
    }

    default WorkDetailBean d() {
        return null;
    }

    default SharedBody e() {
        return null;
    }

    MsgAttachment f();
}
