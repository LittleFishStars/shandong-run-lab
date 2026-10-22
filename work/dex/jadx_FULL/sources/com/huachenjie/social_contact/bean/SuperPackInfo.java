package com.huachenjie.social_contact.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.ir5;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00109\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0018Jx\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020\u0003J\t\u0010C\u001a\u00020\rHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001f¨\u0006E"}, d2 = {"Lcom/huachenjie/social_contact/bean/SuperPackInfo;", "", "giftBagCode", "", "role", "Lcom/huachenjie/social_contact/bean/RoleInfo;", "avatarFrame", "Lcom/huachenjie/social_contact/bean/AvatarFrameInfo;", "skill", "Lcom/huachenjie/social_contact/bean/SkillInfo;", "prop", "Lcom/huachenjie/social_contact/bean/PropInfo;", "starDrill", "", "crystalValue", "signReward", "bigAmount", "", "(Ljava/lang/String;Lcom/huachenjie/social_contact/bean/RoleInfo;Lcom/huachenjie/social_contact/bean/AvatarFrameInfo;Lcom/huachenjie/social_contact/bean/SkillInfo;Lcom/huachenjie/social_contact/bean/PropInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)V", "getAvatarFrame", "()Lcom/huachenjie/social_contact/bean/AvatarFrameInfo;", "setAvatarFrame", "(Lcom/huachenjie/social_contact/bean/AvatarFrameInfo;)V", "getBigAmount", "()Ljava/lang/Float;", "setBigAmount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCrystalValue", "()Ljava/lang/Integer;", "setCrystalValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGiftBagCode", "()Ljava/lang/String;", "getProp", "()Lcom/huachenjie/social_contact/bean/PropInfo;", "setProp", "(Lcom/huachenjie/social_contact/bean/PropInfo;)V", "getRole", "()Lcom/huachenjie/social_contact/bean/RoleInfo;", "setRole", "(Lcom/huachenjie/social_contact/bean/RoleInfo;)V", "getSignReward", "setSignReward", "getSkill", "()Lcom/huachenjie/social_contact/bean/SkillInfo;", "setSkill", "(Lcom/huachenjie/social_contact/bean/SkillInfo;)V", "getStarDrill", "setStarDrill", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Lcom/huachenjie/social_contact/bean/RoleInfo;Lcom/huachenjie/social_contact/bean/AvatarFrameInfo;Lcom/huachenjie/social_contact/bean/SkillInfo;Lcom/huachenjie/social_contact/bean/PropInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)Lcom/huachenjie/social_contact/bean/SuperPackInfo;", "equals", "", "other", "getBuyPrice", "getBuyPriceStr", "hashCode", "toString", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SuperPackInfo {

    @Nullable
    private AvatarFrameInfo avatarFrame;

    @Nullable
    private Float bigAmount;

    @Nullable
    private Integer crystalValue;

    @NotNull
    private final String giftBagCode;

    @Nullable
    private PropInfo prop;

    @Nullable
    private RoleInfo role;

    @Nullable
    private Integer signReward;

    @Nullable
    private SkillInfo skill;

    @Nullable
    private Integer starDrill;

    public SuperPackInfo(@NotNull String str, @Nullable RoleInfo roleInfo, @Nullable AvatarFrameInfo avatarFrameInfo, @Nullable SkillInfo skillInfo, @Nullable PropInfo propInfo, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Float f) {
        Intrinsics.checkNotNullParameter(str, "giftBagCode");
        this.giftBagCode = str;
        this.role = roleInfo;
        this.avatarFrame = avatarFrameInfo;
        this.skill = skillInfo;
        this.prop = propInfo;
        this.starDrill = num;
        this.crystalValue = num2;
        this.signReward = num3;
        this.bigAmount = f;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGiftBagCode() {
        return this.giftBagCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RoleInfo getRole() {
        return this.role;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AvatarFrameInfo getAvatarFrame() {
        return this.avatarFrame;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SkillInfo getSkill() {
        return this.skill;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PropInfo getProp() {
        return this.prop;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getStarDrill() {
        return this.starDrill;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getCrystalValue() {
        return this.crystalValue;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getSignReward() {
        return this.signReward;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Float getBigAmount() {
        return this.bigAmount;
    }

    @NotNull
    public final SuperPackInfo copy(@NotNull String giftBagCode, @Nullable RoleInfo role, @Nullable AvatarFrameInfo avatarFrame, @Nullable SkillInfo skill, @Nullable PropInfo prop, @Nullable Integer starDrill, @Nullable Integer crystalValue, @Nullable Integer signReward, @Nullable Float bigAmount) {
        Intrinsics.checkNotNullParameter(giftBagCode, "giftBagCode");
        return new SuperPackInfo(giftBagCode, role, avatarFrame, skill, prop, starDrill, crystalValue, signReward, bigAmount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuperPackInfo)) {
            return false;
        }
        SuperPackInfo superPackInfo = (SuperPackInfo) other;
        return Intrinsics.areEqual(this.giftBagCode, superPackInfo.giftBagCode) && Intrinsics.areEqual(this.role, superPackInfo.role) && Intrinsics.areEqual(this.avatarFrame, superPackInfo.avatarFrame) && Intrinsics.areEqual(this.skill, superPackInfo.skill) && Intrinsics.areEqual(this.prop, superPackInfo.prop) && Intrinsics.areEqual(this.starDrill, superPackInfo.starDrill) && Intrinsics.areEqual(this.crystalValue, superPackInfo.crystalValue) && Intrinsics.areEqual(this.signReward, superPackInfo.signReward) && Intrinsics.areEqual(this.bigAmount, superPackInfo.bigAmount);
    }

    @Nullable
    public final AvatarFrameInfo getAvatarFrame() {
        return this.avatarFrame;
    }

    @Nullable
    public final Float getBigAmount() {
        return this.bigAmount;
    }

    public final float getBuyPrice() {
        Float f = this.bigAmount;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    @NotNull
    public final String getBuyPriceStr() {
        String strA = ir5.a(Float.valueOf(getBuyPrice()));
        Intrinsics.checkNotNullExpressionValue(strA, "getMoneyStr(getBuyPrice())");
        return strA;
    }

    @Nullable
    public final Integer getCrystalValue() {
        return this.crystalValue;
    }

    @NotNull
    public final String getGiftBagCode() {
        return this.giftBagCode;
    }

    @Nullable
    public final PropInfo getProp() {
        return this.prop;
    }

    @Nullable
    public final RoleInfo getRole() {
        return this.role;
    }

    @Nullable
    public final Integer getSignReward() {
        return this.signReward;
    }

    @Nullable
    public final SkillInfo getSkill() {
        return this.skill;
    }

    @Nullable
    public final Integer getStarDrill() {
        return this.starDrill;
    }

    public int hashCode() {
        int iHashCode = this.giftBagCode.hashCode() * 31;
        RoleInfo roleInfo = this.role;
        int iHashCode2 = (iHashCode + (roleInfo == null ? 0 : roleInfo.hashCode())) * 31;
        AvatarFrameInfo avatarFrameInfo = this.avatarFrame;
        int iHashCode3 = (iHashCode2 + (avatarFrameInfo == null ? 0 : avatarFrameInfo.hashCode())) * 31;
        SkillInfo skillInfo = this.skill;
        int iHashCode4 = (iHashCode3 + (skillInfo == null ? 0 : skillInfo.hashCode())) * 31;
        PropInfo propInfo = this.prop;
        int iHashCode5 = (iHashCode4 + (propInfo == null ? 0 : propInfo.hashCode())) * 31;
        Integer num = this.starDrill;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.crystalValue;
        int iHashCode7 = (iHashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.signReward;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Float f = this.bigAmount;
        return iHashCode8 + (f != null ? f.hashCode() : 0);
    }

    public final void setAvatarFrame(@Nullable AvatarFrameInfo avatarFrameInfo) {
        this.avatarFrame = avatarFrameInfo;
    }

    public final void setBigAmount(@Nullable Float f) {
        this.bigAmount = f;
    }

    public final void setCrystalValue(@Nullable Integer num) {
        this.crystalValue = num;
    }

    public final void setProp(@Nullable PropInfo propInfo) {
        this.prop = propInfo;
    }

    public final void setRole(@Nullable RoleInfo roleInfo) {
        this.role = roleInfo;
    }

    public final void setSignReward(@Nullable Integer num) {
        this.signReward = num;
    }

    public final void setSkill(@Nullable SkillInfo skillInfo) {
        this.skill = skillInfo;
    }

    public final void setStarDrill(@Nullable Integer num) {
        this.starDrill = num;
    }

    @NotNull
    public String toString() {
        return "SuperPackInfo(giftBagCode=" + this.giftBagCode + ", role=" + this.role + ", avatarFrame=" + this.avatarFrame + ", skill=" + this.skill + ", prop=" + this.prop + ", starDrill=" + this.starDrill + ", crystalValue=" + this.crystalValue + ", signReward=" + this.signReward + ", bigAmount=" + this.bigAmount + ')';
    }

    public /* synthetic */ SuperPackInfo(String str, RoleInfo roleInfo, AvatarFrameInfo avatarFrameInfo, SkillInfo skillInfo, PropInfo propInfo, Integer num, Integer num2, Integer num3, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : roleInfo, (i & 4) != 0 ? null : avatarFrameInfo, (i & 8) != 0 ? null : skillInfo, (i & 16) == 0 ? propInfo : null, (i & 32) != 0 ? 0 : num, (i & 64) != 0 ? 0 : num2, (i & 128) != 0 ? 0 : num3, (i & 256) != 0 ? Float.valueOf(0.0f) : f);
    }
}
