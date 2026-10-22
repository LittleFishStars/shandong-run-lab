package com.huachenjie.base.bean;

import com.flyco.tablayout.listener.CustomTabEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/bean/TabEntity;", "Lcom/flyco/tablayout/listener/CustomTabEntity;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getTabSelectedIcon", "", "getTabTitle", "getTabUnselectedIcon", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabEntity implements CustomTabEntity {

    @NotNull
    private final String title;

    public TabEntity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
    }

    @Override // com.flyco.tablayout.listener.CustomTabEntity
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override // com.flyco.tablayout.listener.CustomTabEntity
    @NotNull
    /* JADX INFO: renamed from: getTabTitle, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    @Override // com.flyco.tablayout.listener.CustomTabEntity
    public int getTabUnselectedIcon() {
        return 0;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
