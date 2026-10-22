package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.SpineSuitModelBean;
import com.huachenjie.common.constants.UserConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010!J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\u001d\u0010P\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0003J\u001d\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J²\u0002\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010fJ\t\u0010g\u001a\u00020\u0003HÖ\u0001J\u0013\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\b\u0010l\u001a\u0004\u0018\u00010mJ\t\u0010n\u001a\u00020\u0003HÖ\u0001J\t\u0010o\u001a\u00020\u0014HÖ\u0001J\u0019\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010+\"\u0004\b-\u0010.R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R%\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00106\"\u0004\b8\u00109R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010+\"\u0004\b=\u0010.R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010+\"\u0004\b?\u0010.R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\bA\u00100R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010+\"\u0004\bC\u0010.R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010+\"\u0004\bE\u0010.R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010+\"\u0004\bG\u0010.R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010+\"\u0004\bI\u0010.R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010+\"\u0004\bM\u0010.¨\u0006u"}, d2 = {"Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", "Landroid/os/Parcelable;", "section", "", "starLevel", "starMark", "starValue", "specialAbility", "crystalValue", "starDrill", "skinVoucher", "energyValue", "wearType", "modelList", "Ljava/util/ArrayList;", "Lcom/huachenjie/social_contact/bean/ModelListBean;", "Lkotlin/collections/ArrayList;", "modelPartList", "Lcom/huachenjie/social_contact/bean/ModelPartListBean;", "attitudeName", "", "attitudeImgUrl", "attitudeJsonUrl", UserConstants.USER_PARAMS.b, "buffType", "unlockDialogList", "", "Lcom/huachenjie/social_contact/bean/RareAttributeBean;", "soulValue", "levelStarMark", "personType", "metaverseUserId", "inspirationValue", "(IIIILjava/lang/Integer;IIILjava/lang/Integer;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;IIILjava/lang/String;Ljava/lang/String;)V", "getAttitudeImgUrl", "()Ljava/lang/String;", "setAttitudeImgUrl", "(Ljava/lang/String;)V", "getAttitudeJsonUrl", "setAttitudeJsonUrl", "getAttitudeName", "setAttitudeName", "getBuffType", "()I", "getCrystalValue", "setCrystalValue", "(I)V", "getEnergyValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInspirationValue", "getLevelStarMark", "getMetaverseUserId", "getModelList", "()Ljava/util/ArrayList;", "getModelPartList", "setModelPartList", "(Ljava/util/ArrayList;)V", "getNickName", "getPersonType", "getSection", "setSection", "getSkinVoucher", "setSkinVoucher", "getSoulValue", "getSpecialAbility", "getStarDrill", "setStarDrill", "getStarLevel", "setStarLevel", "getStarMark", "setStarMark", "getStarValue", "setStarValue", "getUnlockDialogList", "()Ljava/util/List;", "getWearType", "setWearType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(IIIILjava/lang/Integer;IIILjava/lang/Integer;ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;IIILjava/lang/String;Ljava/lang/String;)Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", "describeContents", "equals", "", "other", "", "getSpineSuitBean", "Lcom/huachenjie/common/bean/SpineSuitModelBean;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserCultivateInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserCultivateInfo.kt\ncom/huachenjie/social_contact/bean/UserCultivateInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,137:1\n1#2:138\n1549#3:139\n1620#3,3:140\n*S KotlinDebug\n*F\n+ 1 UserCultivateInfo.kt\ncom/huachenjie/social_contact/bean/UserCultivateInfo\n*L\n51#1:139\n51#1:140,3\n*E\n"})
public final /* data */ class UserCultivateInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UserCultivateInfo> CREATOR = new Creator();

    @Nullable
    private String attitudeImgUrl;

    @Nullable
    private String attitudeJsonUrl;

    @Nullable
    private String attitudeName;
    private final int buffType;
    private int crystalValue;

    @Nullable
    private final Integer energyValue;

    @Nullable
    private final String inspirationValue;
    private final int levelStarMark;

    @Nullable
    private final String metaverseUserId;

    @Nullable
    private final ArrayList<ModelListBean> modelList;

    @Nullable
    private ArrayList<ModelPartListBean> modelPartList;

    @Nullable
    private final String nickName;
    private final int personType;
    private int section;
    private int skinVoucher;
    private final int soulValue;

    @Nullable
    private final Integer specialAbility;
    private int starDrill;
    private int starLevel;
    private int starMark;
    private int starValue;

    @NotNull
    private final List<RareAttributeBean> unlockDialogList;
    private int wearType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserCultivateInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserCultivateInfo createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int i5 = parcel.readInt();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int i8 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i9 = parcel.readInt();
                arrayList = new ArrayList(i9);
                for (int i10 = 0; i10 != i9; i10++) {
                    arrayList.add(ModelListBean.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList3.add(ModelPartListBean.CREATOR.createFromParcel(parcel));
                }
                arrayList2 = arrayList3;
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(i14);
            int i15 = 0;
            while (i15 != i14) {
                arrayList4.add(RareAttributeBean.CREATOR.createFromParcel(parcel));
                i15++;
                i14 = i14;
            }
            return new UserCultivateInfo(i, i2, i3, i4, numValueOf, i5, i6, i7, numValueOf2, i8, arrayList, arrayList2, string, string2, string3, string4, i13, arrayList4, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserCultivateInfo[] newArray(int i) {
            return new UserCultivateInfo[i];
        }
    }

    public UserCultivateInfo(int i, int i2, int i3, int i4, @Nullable Integer num, int i5, int i6, int i7, @Nullable Integer num2, int i8, @Nullable ArrayList<ModelListBean> arrayList, @Nullable ArrayList<ModelPartListBean> arrayList2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i9, @NotNull List<RareAttributeBean> list, int i10, int i11, int i12, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(list, "unlockDialogList");
        this.section = i;
        this.starLevel = i2;
        this.starMark = i3;
        this.starValue = i4;
        this.specialAbility = num;
        this.crystalValue = i5;
        this.starDrill = i6;
        this.skinVoucher = i7;
        this.energyValue = num2;
        this.wearType = i8;
        this.modelList = arrayList;
        this.modelPartList = arrayList2;
        this.attitudeName = str;
        this.attitudeImgUrl = str2;
        this.attitudeJsonUrl = str3;
        this.nickName = str4;
        this.buffType = i9;
        this.unlockDialogList = list;
        this.soulValue = i10;
        this.levelStarMark = i11;
        this.personType = i12;
        this.metaverseUserId = str5;
        this.inspirationValue = str6;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSection() {
        return this.section;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getWearType() {
        return this.wearType;
    }

    @Nullable
    public final ArrayList<ModelListBean> component11() {
        return this.modelList;
    }

    @Nullable
    public final ArrayList<ModelPartListBean> component12() {
        return this.modelPartList;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAttitudeName() {
        return this.attitudeName;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getAttitudeImgUrl() {
        return this.attitudeImgUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAttitudeJsonUrl() {
        return this.attitudeJsonUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getBuffType() {
        return this.buffType;
    }

    @NotNull
    public final List<RareAttributeBean> component18() {
        return this.unlockDialogList;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getSoulValue() {
        return this.soulValue;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStarLevel() {
        return this.starLevel;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getLevelStarMark() {
        return this.levelStarMark;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getPersonType() {
        return this.personType;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getMetaverseUserId() {
        return this.metaverseUserId;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getInspirationValue() {
        return this.inspirationValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStarMark() {
        return this.starMark;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getStarValue() {
        return this.starValue;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSpecialAbility() {
        return this.specialAbility;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCrystalValue() {
        return this.crystalValue;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getStarDrill() {
        return this.starDrill;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getSkinVoucher() {
        return this.skinVoucher;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getEnergyValue() {
        return this.energyValue;
    }

    @NotNull
    public final UserCultivateInfo copy(int section, int starLevel, int starMark, int starValue, @Nullable Integer specialAbility, int crystalValue, int starDrill, int skinVoucher, @Nullable Integer energyValue, int wearType, @Nullable ArrayList<ModelListBean> modelList, @Nullable ArrayList<ModelPartListBean> modelPartList, @Nullable String attitudeName, @Nullable String attitudeImgUrl, @Nullable String attitudeJsonUrl, @Nullable String nickName, int buffType, @NotNull List<RareAttributeBean> unlockDialogList, int soulValue, int levelStarMark, int personType, @Nullable String metaverseUserId, @Nullable String inspirationValue) {
        Intrinsics.checkNotNullParameter(unlockDialogList, "unlockDialogList");
        return new UserCultivateInfo(section, starLevel, starMark, starValue, specialAbility, crystalValue, starDrill, skinVoucher, energyValue, wearType, modelList, modelPartList, attitudeName, attitudeImgUrl, attitudeJsonUrl, nickName, buffType, unlockDialogList, soulValue, levelStarMark, personType, metaverseUserId, inspirationValue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCultivateInfo)) {
            return false;
        }
        UserCultivateInfo userCultivateInfo = (UserCultivateInfo) other;
        return this.section == userCultivateInfo.section && this.starLevel == userCultivateInfo.starLevel && this.starMark == userCultivateInfo.starMark && this.starValue == userCultivateInfo.starValue && Intrinsics.areEqual(this.specialAbility, userCultivateInfo.specialAbility) && this.crystalValue == userCultivateInfo.crystalValue && this.starDrill == userCultivateInfo.starDrill && this.skinVoucher == userCultivateInfo.skinVoucher && Intrinsics.areEqual(this.energyValue, userCultivateInfo.energyValue) && this.wearType == userCultivateInfo.wearType && Intrinsics.areEqual(this.modelList, userCultivateInfo.modelList) && Intrinsics.areEqual(this.modelPartList, userCultivateInfo.modelPartList) && Intrinsics.areEqual(this.attitudeName, userCultivateInfo.attitudeName) && Intrinsics.areEqual(this.attitudeImgUrl, userCultivateInfo.attitudeImgUrl) && Intrinsics.areEqual(this.attitudeJsonUrl, userCultivateInfo.attitudeJsonUrl) && Intrinsics.areEqual(this.nickName, userCultivateInfo.nickName) && this.buffType == userCultivateInfo.buffType && Intrinsics.areEqual(this.unlockDialogList, userCultivateInfo.unlockDialogList) && this.soulValue == userCultivateInfo.soulValue && this.levelStarMark == userCultivateInfo.levelStarMark && this.personType == userCultivateInfo.personType && Intrinsics.areEqual(this.metaverseUserId, userCultivateInfo.metaverseUserId) && Intrinsics.areEqual(this.inspirationValue, userCultivateInfo.inspirationValue);
    }

    @Nullable
    public final String getAttitudeImgUrl() {
        return this.attitudeImgUrl;
    }

    @Nullable
    public final String getAttitudeJsonUrl() {
        return this.attitudeJsonUrl;
    }

    @Nullable
    public final String getAttitudeName() {
        return this.attitudeName;
    }

    public final int getBuffType() {
        return this.buffType;
    }

    public final int getCrystalValue() {
        return this.crystalValue;
    }

    @Nullable
    public final Integer getEnergyValue() {
        return this.energyValue;
    }

    @Nullable
    public final String getInspirationValue() {
        return this.inspirationValue;
    }

    public final int getLevelStarMark() {
        return this.levelStarMark;
    }

    @Nullable
    public final String getMetaverseUserId() {
        return this.metaverseUserId;
    }

    @Nullable
    public final ArrayList<ModelListBean> getModelList() {
        return this.modelList;
    }

    @Nullable
    public final ArrayList<ModelPartListBean> getModelPartList() {
        return this.modelPartList;
    }

    @Nullable
    public final String getNickName() {
        return this.nickName;
    }

    public final int getPersonType() {
        return this.personType;
    }

    public final int getSection() {
        return this.section;
    }

    public final int getSkinVoucher() {
        return this.skinVoucher;
    }

    public final int getSoulValue() {
        return this.soulValue;
    }

    @Nullable
    public final Integer getSpecialAbility() {
        return this.specialAbility;
    }

    @Nullable
    public final SpineSuitModelBean getSpineSuitBean() {
        ModelListBean modelListBean;
        SpineSuitModelBean spineSuitModelBean;
        Object next;
        ModelListBean modelListBean2;
        ArrayList arrayList;
        Object next2;
        ModelListBean modelListBean3;
        ModelListBean modelListBean4;
        Object next3;
        ModelListBean modelListBean5;
        Object next4;
        if (this.personType == 2) {
            ArrayList<ModelListBean> arrayList2 = this.modelList;
            if (arrayList2 != null) {
                Iterator<T> it = arrayList2.iterator();
                do {
                    if (!it.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it.next();
                } while (!(((ModelListBean) next4).getType() == 3));
                modelListBean5 = (ModelListBean) next4;
            } else {
                modelListBean5 = null;
            }
            if (modelListBean5 != null) {
                return new SpineSuitModelBean(modelListBean5.getMetaverseModelCode(), null, 2, null);
            }
            return null;
        }
        int i = this.wearType;
        if (i == 1) {
            ArrayList<ModelListBean> arrayList3 = this.modelList;
            if (arrayList3 != null) {
                Iterator<T> it2 = arrayList3.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!(((ModelListBean) next).getType() == 1));
                modelListBean = (ModelListBean) next;
            } else {
                modelListBean = null;
            }
            if (modelListBean == null) {
                return null;
            }
            spineSuitModelBean = new SpineSuitModelBean(modelListBean.getMetaverseModelCode(), null, 2, null);
        } else {
            if (i == 2) {
                ArrayList<ModelListBean> arrayList4 = this.modelList;
                if (arrayList4 != null) {
                    Iterator<T> it3 = arrayList4.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                        modelListBean3 = (ModelListBean) next2;
                    } while (!(modelListBean3.getType() == 2 && modelListBean3.getWearStatus() == 1));
                    modelListBean2 = (ModelListBean) next2;
                } else {
                    modelListBean2 = null;
                }
                ArrayList<ModelPartListBean> arrayList5 = this.modelPartList;
                if (arrayList5 != null) {
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                    Iterator<T> it4 = arrayList5.iterator();
                    while (it4.hasNext()) {
                        arrayList.add(((ModelPartListBean) it4.next()).getMetaverseModelPartCode());
                    }
                } else {
                    arrayList = new ArrayList();
                }
                if (modelListBean2 != null) {
                    return new SpineSuitModelBean(modelListBean2.getMetaverseModelCode(), arrayList);
                }
                return null;
            }
            if (i != 3) {
                return null;
            }
            ArrayList<ModelListBean> arrayList6 = this.modelList;
            if (arrayList6 != null) {
                Iterator<T> it5 = arrayList6.iterator();
                do {
                    if (!it5.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it5.next();
                } while (!(((ModelListBean) next3).getType() == 3));
                modelListBean4 = (ModelListBean) next3;
            } else {
                modelListBean4 = null;
            }
            if (modelListBean4 == null) {
                return null;
            }
            spineSuitModelBean = new SpineSuitModelBean(modelListBean4.getMetaverseModelCode(), null, 2, null);
        }
        return spineSuitModelBean;
    }

    public final int getStarDrill() {
        return this.starDrill;
    }

    public final int getStarLevel() {
        return this.starLevel;
    }

    public final int getStarMark() {
        return this.starMark;
    }

    public final int getStarValue() {
        return this.starValue;
    }

    @NotNull
    public final List<RareAttributeBean> getUnlockDialogList() {
        return this.unlockDialogList;
    }

    public final int getWearType() {
        return this.wearType;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.section) * 31) + Integer.hashCode(this.starLevel)) * 31) + Integer.hashCode(this.starMark)) * 31) + Integer.hashCode(this.starValue)) * 31;
        Integer num = this.specialAbility;
        int iHashCode2 = (((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.crystalValue)) * 31) + Integer.hashCode(this.starDrill)) * 31) + Integer.hashCode(this.skinVoucher)) * 31;
        Integer num2 = this.energyValue;
        int iHashCode3 = (((iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.wearType)) * 31;
        ArrayList<ModelListBean> arrayList = this.modelList;
        int iHashCode4 = (iHashCode3 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<ModelPartListBean> arrayList2 = this.modelPartList;
        int iHashCode5 = (iHashCode4 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        String str = this.attitudeName;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.attitudeImgUrl;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.attitudeJsonUrl;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nickName;
        int iHashCode9 = (((((((((((iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.buffType)) * 31) + this.unlockDialogList.hashCode()) * 31) + Integer.hashCode(this.soulValue)) * 31) + Integer.hashCode(this.levelStarMark)) * 31) + Integer.hashCode(this.personType)) * 31;
        String str5 = this.metaverseUserId;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.inspirationValue;
        return iHashCode10 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setAttitudeImgUrl(@Nullable String str) {
        this.attitudeImgUrl = str;
    }

    public final void setAttitudeJsonUrl(@Nullable String str) {
        this.attitudeJsonUrl = str;
    }

    public final void setAttitudeName(@Nullable String str) {
        this.attitudeName = str;
    }

    public final void setCrystalValue(int i) {
        this.crystalValue = i;
    }

    public final void setModelPartList(@Nullable ArrayList<ModelPartListBean> arrayList) {
        this.modelPartList = arrayList;
    }

    public final void setSection(int i) {
        this.section = i;
    }

    public final void setSkinVoucher(int i) {
        this.skinVoucher = i;
    }

    public final void setStarDrill(int i) {
        this.starDrill = i;
    }

    public final void setStarLevel(int i) {
        this.starLevel = i;
    }

    public final void setStarMark(int i) {
        this.starMark = i;
    }

    public final void setStarValue(int i) {
        this.starValue = i;
    }

    public final void setWearType(int i) {
        this.wearType = i;
    }

    @NotNull
    public String toString() {
        return "UserCultivateInfo(section=" + this.section + ", starLevel=" + this.starLevel + ", starMark=" + this.starMark + ", starValue=" + this.starValue + ", specialAbility=" + this.specialAbility + ", crystalValue=" + this.crystalValue + ", starDrill=" + this.starDrill + ", skinVoucher=" + this.skinVoucher + ", energyValue=" + this.energyValue + ", wearType=" + this.wearType + ", modelList=" + this.modelList + ", modelPartList=" + this.modelPartList + ", attitudeName=" + this.attitudeName + ", attitudeImgUrl=" + this.attitudeImgUrl + ", attitudeJsonUrl=" + this.attitudeJsonUrl + ", nickName=" + this.nickName + ", buffType=" + this.buffType + ", unlockDialogList=" + this.unlockDialogList + ", soulValue=" + this.soulValue + ", levelStarMark=" + this.levelStarMark + ", personType=" + this.personType + ", metaverseUserId=" + this.metaverseUserId + ", inspirationValue=" + this.inspirationValue + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.section);
        parcel.writeInt(this.starLevel);
        parcel.writeInt(this.starMark);
        parcel.writeInt(this.starValue);
        Integer num = this.specialAbility;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.crystalValue);
        parcel.writeInt(this.starDrill);
        parcel.writeInt(this.skinVoucher);
        Integer num2 = this.energyValue;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeInt(this.wearType);
        ArrayList<ModelListBean> arrayList = this.modelList;
        if (arrayList == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            Iterator<ModelListBean> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        ArrayList<ModelPartListBean> arrayList2 = this.modelPartList;
        if (arrayList2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(arrayList2.size());
            Iterator<ModelPartListBean> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.attitudeName);
        parcel.writeString(this.attitudeImgUrl);
        parcel.writeString(this.attitudeJsonUrl);
        parcel.writeString(this.nickName);
        parcel.writeInt(this.buffType);
        List<RareAttributeBean> list = this.unlockDialogList;
        parcel.writeInt(list.size());
        Iterator<RareAttributeBean> it3 = list.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.soulValue);
        parcel.writeInt(this.levelStarMark);
        parcel.writeInt(this.personType);
        parcel.writeString(this.metaverseUserId);
        parcel.writeString(this.inspirationValue);
    }

    public /* synthetic */ UserCultivateInfo(int i, int i2, int i3, int i4, Integer num, int i5, int i6, int i7, Integer num2, int i8, ArrayList arrayList, ArrayList arrayList2, String str, String str2, String str3, String str4, int i9, List list, int i10, int i11, int i12, String str5, String str6, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i, (i13 & 2) != 0 ? 0 : i2, (i13 & 4) != 0 ? 0 : i3, (i13 & 8) != 0 ? 0 : i4, num, (i13 & 32) != 0 ? 0 : i5, (i13 & 64) != 0 ? 0 : i6, (i13 & 128) != 0 ? 0 : i7, num2, (i13 & 512) != 0 ? 0 : i8, (i13 & 1024) != 0 ? new ArrayList() : arrayList, (i13 & 2048) != 0 ? new ArrayList() : arrayList2, str, str2, str3, str4, i9, list, i10, i11, i12, (2097152 & i13) != 0 ? "" : str5, (i13 & 4194304) != 0 ? "" : str6);
    }
}
