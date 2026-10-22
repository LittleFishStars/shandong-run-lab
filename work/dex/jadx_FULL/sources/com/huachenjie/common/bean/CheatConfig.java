package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/common/bean/CheatConfig;", "Landroid/os/Parcelable;", "cheatList", "", "Lcom/huachenjie/common/bean/CheatBean;", "(Ljava/util/List;)V", "getCheatList", "()Ljava/util/List;", "checkAdb", "", "checkBDMock", "checkEmulator", "checkHook", "checkMagisk", "checkMultiApp", "checkProxy", "checkRoot", "checkSign", "checkThirdRom", "checkVirtualLocation", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCheatConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheatConfig.kt\ncom/huachenjie/common/bean/CheatConfig\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1#2:140\n*E\n"})
public final class CheatConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CheatConfig> CREATOR = new Creator();

    @NotNull
    private final List<CheatBean> cheatList;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CheatConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheatConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(CheatBean.CREATOR.createFromParcel(parcel));
            }
            return new CheatConfig(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheatConfig[] newArray(int i) {
            return new CheatConfig[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CheatConfig() {
        List list = null;
        this(list, 1, list);
    }

    public CheatConfig(@NotNull List<CheatBean> list) {
        Intrinsics.checkNotNullParameter(list, "cheatList");
        this.cheatList = list;
    }

    public final boolean checkAdb() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 107));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkBDMock() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 109));
        CheatBean cheatBean = (CheatBean) next;
        if (cheatBean == null) {
            return true;
        }
        return cheatBean.getCheatValue();
    }

    public final boolean checkEmulator() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 101));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkHook() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 103));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkMagisk() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 104));
        CheatBean cheatBean = (CheatBean) next;
        if (cheatBean == null) {
            return true;
        }
        return cheatBean.getCheatValue();
    }

    public final boolean checkMultiApp() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 102));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkProxy() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 105));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkRoot() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 100));
        CheatBean cheatBean = (CheatBean) next;
        if (cheatBean == null) {
            return true;
        }
        return cheatBean.getCheatValue();
    }

    public final boolean checkSign() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 106));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkThirdRom() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 108));
        CheatBean cheatBean = (CheatBean) next;
        return cheatBean != null && cheatBean.getCheatValue();
    }

    public final boolean checkVirtualLocation() {
        Object next;
        Iterator<T> it = this.cheatList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((CheatBean) next).getCheatType() == 110));
        CheatBean cheatBean = (CheatBean) next;
        if (cheatBean == null) {
            return true;
        }
        return cheatBean.getCheatValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<CheatBean> getCheatList() {
        return this.cheatList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<CheatBean> list = this.cheatList;
        parcel.writeInt(list.size());
        Iterator<CheatBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ CheatConfig(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
