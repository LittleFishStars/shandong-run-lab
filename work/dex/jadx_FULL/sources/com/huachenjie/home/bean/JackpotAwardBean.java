package com.huachenjie.home.bean;

import android.text.TextUtils;
import com.huachenjie.base.bean.ThemeConfigBean;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.home.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\t\u0010#\u001a\u00020\u001eHÖ\u0001J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010%\u001a\u00020\u001aJ\t\u0010&\u001a\u00020 HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/huachenjie/home/bean/JackpotAwardBean;", "", "inspiration", "Lcom/huachenjie/home/bean/InspirationBean;", "awardList", "", "Lcom/huachenjie/home/bean/AwardBean;", "taskInfo", "Lcom/huachenjie/home/bean/DailyTasksBean;", "themeConfig", "Lcom/huachenjie/base/bean/ThemeConfigBean;", "(Lcom/huachenjie/home/bean/InspirationBean;Ljava/util/List;Lcom/huachenjie/home/bean/DailyTasksBean;Lcom/huachenjie/base/bean/ThemeConfigBean;)V", "getAwardList", "()Ljava/util/List;", "getInspiration", "()Lcom/huachenjie/home/bean/InspirationBean;", "getTaskInfo", "()Lcom/huachenjie/home/bean/DailyTasksBean;", "getThemeConfig", "()Lcom/huachenjie/base/bean/ThemeConfigBean;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "equals", "", "other", "findAwardBean", "index", "", "findBadge", "", "findButtonImageRes", "findTitleImageRes", "hashCode", "showAward", "showBadge", "toString", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JackpotAwardBean {

    @NotNull
    private final List<AwardBean> awardList;

    @NotNull
    private final InspirationBean inspiration;

    @NotNull
    private final DailyTasksBean taskInfo;

    @NotNull
    private final ThemeConfigBean themeConfig;

    public JackpotAwardBean() {
        this(null, null, null, null, 15, null);
    }

    public JackpotAwardBean(@NotNull InspirationBean inspirationBean, @NotNull List<AwardBean> list, @NotNull DailyTasksBean dailyTasksBean, @NotNull ThemeConfigBean themeConfigBean) {
        Intrinsics.checkNotNullParameter(inspirationBean, "inspiration");
        Intrinsics.checkNotNullParameter(list, "awardList");
        Intrinsics.checkNotNullParameter(dailyTasksBean, "taskInfo");
        Intrinsics.checkNotNullParameter(themeConfigBean, "themeConfig");
        this.inspiration = inspirationBean;
        this.awardList = list;
        this.taskInfo = dailyTasksBean;
        this.themeConfig = themeConfigBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JackpotAwardBean copy$default(JackpotAwardBean jackpotAwardBean, InspirationBean inspirationBean, List list, DailyTasksBean dailyTasksBean, ThemeConfigBean themeConfigBean, int i, Object obj) {
        if ((i & 1) != 0) {
            inspirationBean = jackpotAwardBean.inspiration;
        }
        if ((i & 2) != 0) {
            list = jackpotAwardBean.awardList;
        }
        if ((i & 4) != 0) {
            dailyTasksBean = jackpotAwardBean.taskInfo;
        }
        if ((i & 8) != 0) {
            themeConfigBean = jackpotAwardBean.themeConfig;
        }
        return jackpotAwardBean.copy(inspirationBean, list, dailyTasksBean, themeConfigBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InspirationBean getInspiration() {
        return this.inspiration;
    }

    @NotNull
    public final List<AwardBean> component2() {
        return this.awardList;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DailyTasksBean getTaskInfo() {
        return this.taskInfo;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ThemeConfigBean getThemeConfig() {
        return this.themeConfig;
    }

    @NotNull
    public final JackpotAwardBean copy(@NotNull InspirationBean inspiration, @NotNull List<AwardBean> awardList, @NotNull DailyTasksBean taskInfo, @NotNull ThemeConfigBean themeConfig) {
        Intrinsics.checkNotNullParameter(inspiration, "inspiration");
        Intrinsics.checkNotNullParameter(awardList, "awardList");
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        Intrinsics.checkNotNullParameter(themeConfig, "themeConfig");
        return new JackpotAwardBean(inspiration, awardList, taskInfo, themeConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JackpotAwardBean)) {
            return false;
        }
        JackpotAwardBean jackpotAwardBean = (JackpotAwardBean) other;
        return Intrinsics.areEqual(this.inspiration, jackpotAwardBean.inspiration) && Intrinsics.areEqual(this.awardList, jackpotAwardBean.awardList) && Intrinsics.areEqual(this.taskInfo, jackpotAwardBean.taskInfo) && Intrinsics.areEqual(this.themeConfig, jackpotAwardBean.themeConfig);
    }

    @NotNull
    public final AwardBean findAwardBean(int index) {
        return !showAward(index) ? new AwardBean(null, null, null, null, 0, 31, null) : this.awardList.get(index);
    }

    @NotNull
    public final String findBadge() {
        return this.themeConfig.getBadge();
    }

    public final int findButtonImageRes() {
        int status = this.taskInfo.getStatus();
        if (status == 0) {
            return R.drawable.home_ic_task_go_now;
        }
        if (status == 1) {
            return R.drawable.home_ic_task_receive_flash_coins;
        }
        if (status != 2) {
            return 0;
        }
        return R.drawable.home_ic_task_grab_it_now;
    }

    public final int findTitleImageRes() {
        int status = this.taskInfo.getStatus();
        if (status == 0 || status == 1) {
            return R.drawable.home_bg_flash_coins_title;
        }
        if (status != 2) {
            return 0;
        }
        return R.drawable.home_bg_flash_sale_title;
    }

    @NotNull
    public final List<AwardBean> getAwardList() {
        return this.awardList;
    }

    @NotNull
    public final InspirationBean getInspiration() {
        return this.inspiration;
    }

    @NotNull
    public final DailyTasksBean getTaskInfo() {
        return this.taskInfo;
    }

    @NotNull
    public final ThemeConfigBean getThemeConfig() {
        return this.themeConfig;
    }

    public int hashCode() {
        return (((((this.inspiration.hashCode() * 31) + this.awardList.hashCode()) * 31) + this.taskInfo.hashCode()) * 31) + this.themeConfig.hashCode();
    }

    public final boolean showAward(int index) {
        return index >= 0 && index < this.awardList.size();
    }

    public final boolean showBadge() {
        return !TextUtils.isEmpty(this.themeConfig.getBadge());
    }

    @NotNull
    public String toString() {
        return "JackpotAwardBean(inspiration=" + this.inspiration + ", awardList=" + this.awardList + ", taskInfo=" + this.taskInfo + ", themeConfig=" + this.themeConfig + ')';
    }

    public /* synthetic */ JackpotAwardBean(InspirationBean inspirationBean, List list, DailyTasksBean dailyTasksBean, ThemeConfigBean themeConfigBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new InspirationBean(0, 0.0f, 3, null) : inspirationBean, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new DailyTasksBean(null, null, null, null, 0, 0, 0, null, null, null, 0, 0, 4095, null) : dailyTasksBean, (i & 8) != 0 ? new ThemeConfigBean(null, null, null, null, null, null, null, null, null, null, 1023, null) : themeConfigBean);
    }
}
