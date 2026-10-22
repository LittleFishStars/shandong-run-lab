package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.SpineSuitModelBean;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u0081\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014HÆ\u0001J\t\u00104\u001a\u000205HÖ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\u000e\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u000205J\t\u0010<\u001a\u000205HÖ\u0001J\u000e\u0010=\u001a\u0002072\u0006\u0010;\u001a\u000205J\t\u0010>\u001a\u00020\nHÖ\u0001J\u0019\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u000205HÖ\u0001R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001e\"\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006D"}, d2 = {"Lcom/huachenjie/base/bean/LotteryDrawBean;", "Landroid/os/Parcelable;", "spine", "Lcom/huachenjie/common/bean/SpineSuitModelBean;", "jackpotList", "", "Lcom/huachenjie/base/bean/JackpotBean;", "priorityRewards", "Lcom/huachenjie/base/bean/PriorityRewardBean;", "name", "", "inspiration", "Lcom/huachenjie/base/bean/HomeInspirationBean;", NicknameFragment.NICKNAME, "featuredAward", "Lcom/huachenjie/base/bean/FeaturedAwardBean;", "themeConfig", "Lcom/huachenjie/base/bean/ThemeConfigBean;", "winningList", "awardList", "", "(Lcom/huachenjie/common/bean/SpineSuitModelBean;Ljava/util/List;Lcom/huachenjie/base/bean/PriorityRewardBean;Ljava/lang/String;Lcom/huachenjie/base/bean/HomeInspirationBean;Ljava/lang/String;Lcom/huachenjie/base/bean/FeaturedAwardBean;Lcom/huachenjie/base/bean/ThemeConfigBean;Ljava/util/List;Ljava/util/List;)V", "getAwardList", "()Ljava/util/List;", "getFeaturedAward", "()Lcom/huachenjie/base/bean/FeaturedAwardBean;", "getInspiration", "()Lcom/huachenjie/base/bean/HomeInspirationBean;", "getJackpotList", "getName", "()Ljava/lang/String;", "getNickname", "setNickname", "(Ljava/lang/String;)V", "getPriorityRewards", "()Lcom/huachenjie/base/bean/PriorityRewardBean;", "getSpine", "()Lcom/huachenjie/common/bean/SpineSuitModelBean;", "getThemeConfig", "()Lcom/huachenjie/base/bean/ThemeConfigBean;", "getWinningList", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "findLotteryDraw", "index", "hashCode", "showLotteryDraw", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LotteryDrawBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<LotteryDrawBean> CREATOR = new Creator();

    @NotNull
    private final List<FeaturedAwardBean> awardList;

    @Nullable
    private final FeaturedAwardBean featuredAward;

    @NotNull
    private final HomeInspirationBean inspiration;

    @NotNull
    private final List<JackpotBean> jackpotList;

    @NotNull
    private final String name;

    @NotNull
    private String nickname;

    @NotNull
    private final PriorityRewardBean priorityRewards;

    @NotNull
    private final SpineSuitModelBean spine;

    @NotNull
    private final ThemeConfigBean themeConfig;

    @NotNull
    private final List<String> winningList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LotteryDrawBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LotteryDrawBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            SpineSuitModelBean spineSuitModelBean = (SpineSuitModelBean) parcel.readParcelable(LotteryDrawBean.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(JackpotBean.CREATOR.createFromParcel(parcel));
            }
            PriorityRewardBean priorityRewardBeanCreateFromParcel = PriorityRewardBean.CREATOR.createFromParcel(parcel);
            String string = parcel.readString();
            HomeInspirationBean homeInspirationBeanCreateFromParcel = HomeInspirationBean.CREATOR.createFromParcel(parcel);
            String string2 = parcel.readString();
            FeaturedAwardBean featuredAwardBeanCreateFromParcel = parcel.readInt() == 0 ? null : FeaturedAwardBean.CREATOR.createFromParcel(parcel);
            ThemeConfigBean themeConfigBeanCreateFromParcel = ThemeConfigBean.CREATOR.createFromParcel(parcel);
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            int i3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i3);
            for (int i4 = 0; i4 != i3; i4++) {
                arrayList2.add(FeaturedAwardBean.CREATOR.createFromParcel(parcel));
            }
            return new LotteryDrawBean(spineSuitModelBean, arrayList, priorityRewardBeanCreateFromParcel, string, homeInspirationBeanCreateFromParcel, string2, featuredAwardBeanCreateFromParcel, themeConfigBeanCreateFromParcel, arrayListCreateStringArrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LotteryDrawBean[] newArray(int i) {
            return new LotteryDrawBean[i];
        }
    }

    public LotteryDrawBean() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public LotteryDrawBean(@NotNull SpineSuitModelBean spineSuitModelBean, @NotNull List<JackpotBean> list, @NotNull PriorityRewardBean priorityRewardBean, @NotNull String str, @NotNull HomeInspirationBean homeInspirationBean, @NotNull String str2, @Nullable FeaturedAwardBean featuredAwardBean, @NotNull ThemeConfigBean themeConfigBean, @NotNull List<String> list2, @NotNull List<FeaturedAwardBean> list3) {
        Intrinsics.checkNotNullParameter(spineSuitModelBean, "spine");
        Intrinsics.checkNotNullParameter(list, "jackpotList");
        Intrinsics.checkNotNullParameter(priorityRewardBean, "priorityRewards");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(homeInspirationBean, "inspiration");
        Intrinsics.checkNotNullParameter(str2, NicknameFragment.NICKNAME);
        Intrinsics.checkNotNullParameter(themeConfigBean, "themeConfig");
        Intrinsics.checkNotNullParameter(list2, "winningList");
        Intrinsics.checkNotNullParameter(list3, "awardList");
        this.spine = spineSuitModelBean;
        this.jackpotList = list;
        this.priorityRewards = priorityRewardBean;
        this.name = str;
        this.inspiration = homeInspirationBean;
        this.nickname = str2;
        this.featuredAward = featuredAwardBean;
        this.themeConfig = themeConfigBean;
        this.winningList = list2;
        this.awardList = list3;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SpineSuitModelBean getSpine() {
        return this.spine;
    }

    @NotNull
    public final List<FeaturedAwardBean> component10() {
        return this.awardList;
    }

    @NotNull
    public final List<JackpotBean> component2() {
        return this.jackpotList;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PriorityRewardBean getPriorityRewards() {
        return this.priorityRewards;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final HomeInspirationBean getInspiration() {
        return this.inspiration;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final FeaturedAwardBean getFeaturedAward() {
        return this.featuredAward;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ThemeConfigBean getThemeConfig() {
        return this.themeConfig;
    }

    @NotNull
    public final List<String> component9() {
        return this.winningList;
    }

    @NotNull
    public final LotteryDrawBean copy(@NotNull SpineSuitModelBean spine, @NotNull List<JackpotBean> jackpotList, @NotNull PriorityRewardBean priorityRewards, @NotNull String name, @NotNull HomeInspirationBean inspiration, @NotNull String nickname, @Nullable FeaturedAwardBean featuredAward, @NotNull ThemeConfigBean themeConfig, @NotNull List<String> winningList, @NotNull List<FeaturedAwardBean> awardList) {
        Intrinsics.checkNotNullParameter(spine, "spine");
        Intrinsics.checkNotNullParameter(jackpotList, "jackpotList");
        Intrinsics.checkNotNullParameter(priorityRewards, "priorityRewards");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(inspiration, "inspiration");
        Intrinsics.checkNotNullParameter(nickname, NicknameFragment.NICKNAME);
        Intrinsics.checkNotNullParameter(themeConfig, "themeConfig");
        Intrinsics.checkNotNullParameter(winningList, "winningList");
        Intrinsics.checkNotNullParameter(awardList, "awardList");
        return new LotteryDrawBean(spine, jackpotList, priorityRewards, name, inspiration, nickname, featuredAward, themeConfig, winningList, awardList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LotteryDrawBean)) {
            return false;
        }
        LotteryDrawBean lotteryDrawBean = (LotteryDrawBean) other;
        return Intrinsics.areEqual(this.spine, lotteryDrawBean.spine) && Intrinsics.areEqual(this.jackpotList, lotteryDrawBean.jackpotList) && Intrinsics.areEqual(this.priorityRewards, lotteryDrawBean.priorityRewards) && Intrinsics.areEqual(this.name, lotteryDrawBean.name) && Intrinsics.areEqual(this.inspiration, lotteryDrawBean.inspiration) && Intrinsics.areEqual(this.nickname, lotteryDrawBean.nickname) && Intrinsics.areEqual(this.featuredAward, lotteryDrawBean.featuredAward) && Intrinsics.areEqual(this.themeConfig, lotteryDrawBean.themeConfig) && Intrinsics.areEqual(this.winningList, lotteryDrawBean.winningList) && Intrinsics.areEqual(this.awardList, lotteryDrawBean.awardList);
    }

    @NotNull
    public final JackpotBean findLotteryDraw(int index) {
        return !showLotteryDraw(index) ? new JackpotBean(0, null, null, null, null, 0, null, null, 0, 511, null) : this.jackpotList.get(index);
    }

    @NotNull
    public final List<FeaturedAwardBean> getAwardList() {
        return this.awardList;
    }

    @Nullable
    public final FeaturedAwardBean getFeaturedAward() {
        return this.featuredAward;
    }

    @NotNull
    public final HomeInspirationBean getInspiration() {
        return this.inspiration;
    }

    @NotNull
    public final List<JackpotBean> getJackpotList() {
        return this.jackpotList;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final PriorityRewardBean getPriorityRewards() {
        return this.priorityRewards;
    }

    @NotNull
    public final SpineSuitModelBean getSpine() {
        return this.spine;
    }

    @NotNull
    public final ThemeConfigBean getThemeConfig() {
        return this.themeConfig;
    }

    @NotNull
    public final List<String> getWinningList() {
        return this.winningList;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.spine.hashCode() * 31) + this.jackpotList.hashCode()) * 31) + this.priorityRewards.hashCode()) * 31) + this.name.hashCode()) * 31) + this.inspiration.hashCode()) * 31) + this.nickname.hashCode()) * 31;
        FeaturedAwardBean featuredAwardBean = this.featuredAward;
        return ((((((iHashCode + (featuredAwardBean == null ? 0 : featuredAwardBean.hashCode())) * 31) + this.themeConfig.hashCode()) * 31) + this.winningList.hashCode()) * 31) + this.awardList.hashCode();
    }

    public final void setNickname(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final boolean showLotteryDraw(int index) {
        return !this.jackpotList.isEmpty() && index >= 0 && index < this.jackpotList.size();
    }

    @NotNull
    public String toString() {
        return "LotteryDrawBean(spine=" + this.spine + ", jackpotList=" + this.jackpotList + ", priorityRewards=" + this.priorityRewards + ", name=" + this.name + ", inspiration=" + this.inspiration + ", nickname=" + this.nickname + ", featuredAward=" + this.featuredAward + ", themeConfig=" + this.themeConfig + ", winningList=" + this.winningList + ", awardList=" + this.awardList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.spine, flags);
        List<JackpotBean> list = this.jackpotList;
        parcel.writeInt(list.size());
        Iterator<JackpotBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        this.priorityRewards.writeToParcel(parcel, flags);
        parcel.writeString(this.name);
        this.inspiration.writeToParcel(parcel, flags);
        parcel.writeString(this.nickname);
        FeaturedAwardBean featuredAwardBean = this.featuredAward;
        if (featuredAwardBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            featuredAwardBean.writeToParcel(parcel, flags);
        }
        this.themeConfig.writeToParcel(parcel, flags);
        parcel.writeStringList(this.winningList);
        List<FeaturedAwardBean> list2 = this.awardList;
        parcel.writeInt(list2.size());
        Iterator<FeaturedAwardBean> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ LotteryDrawBean(SpineSuitModelBean spineSuitModelBean, List list, PriorityRewardBean priorityRewardBean, String str, HomeInspirationBean homeInspirationBean, String str2, FeaturedAwardBean featuredAwardBean, ThemeConfigBean themeConfigBean, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SpineSuitModelBean(null, null, 3, null) : spineSuitModelBean, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? new PriorityRewardBean(null, null, null, 0, null, 31, null) : priorityRewardBean, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? new HomeInspirationBean(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null) : homeInspirationBean, (i & 32) == 0 ? str2 : "", (i & 64) == 0 ? featuredAwardBean : null, (i & 128) != 0 ? new ThemeConfigBean(null, null, null, null, null, null, null, null, null, null, 1023, null) : themeConfigBean, (i & 256) != 0 ? new ArrayList() : list2, (i & 512) != 0 ? new ArrayList() : list3);
    }
}
