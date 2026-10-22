package com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface PbSCFeedPush {
    List<PbCommentFeed> getCommentFeeds();

    String getDisplayLikeCount();

    String getDisplayWatchingCount();

    List<PbSystemNoticeFeed> getSystemNoticeFeeds();
}
