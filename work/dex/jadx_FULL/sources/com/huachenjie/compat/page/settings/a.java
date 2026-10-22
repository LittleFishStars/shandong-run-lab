package com.huachenjie.compat.page.settings;

import android.content.Context;
import com.acse.ottn.activity.AcseHelpManager;
import com.hjq.permissions.Permission;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.compat.page.settings.a;
import com.zj.adlib.ai9;
import com.zj.adlib.fo6;
import com.zj.adlib.y6b;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/compat/page/settings/a;", "Lcom/huachenjie/compat/page/settings/SettingContact$Presenter;", "", "e", "Landroid/content/Context;", "ctx", "f", "", "on", y6b.g, y6b.f, "a", "Z", "featurePush", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class a extends SettingContact.Presenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean featurePush = true;

    public static final void j(a aVar, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "this$0");
        T t = ((BasePresenter) aVar).f33638a;
        if (t != 0) {
            ((SettingContact.PersonalView) t).l(z);
        }
    }

    @Override // com.huachenjie.common.base.BasePresenter
    public void e() {
        this.featurePush = ai9.k();
    }

    @Override // com.huachenjie.compat.page.settings.SettingContact.Presenter
    public void f(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        fo6 fo6Var = fo6.f41719a;
        boolean zA = fo6Var.a(ctx, "android.permission.ACCESS_COARSE_LOCATION");
        boolean zA2 = fo6Var.a(ctx, Permission.CAMERA);
        boolean zA3 = fo6Var.a(ctx, "android.permission.READ_PHONE_STATE");
        linkedHashMap.put(Permission.ACCESS_NOTIFICATION_POLICY, Boolean.valueOf(fo6Var.c(ctx)));
        linkedHashMap.put("android.permission.ACCESS_COARSE_LOCATION", Boolean.valueOf(zA));
        linkedHashMap.put(Permission.CAMERA, Boolean.valueOf(zA2));
        linkedHashMap.put("android.permission.READ_PHONE_STATE", Boolean.valueOf(zA3));
        linkedHashMap.put("featurePush", Boolean.valueOf(this.featurePush));
        ((SettingContact.PersonalView) ((BasePresenter) this).f33638a).h(linkedHashMap);
        AcseHelpManager.getGoodsWelfare(new AcseHelpManager.OnIndividuationCallBack() { // from class: com.zj.adlib.t78
            @Override // com.acse.ottn.activity.AcseHelpManager.OnIndividuationCallBack
            public final void onIndividuationState(boolean z) {
                a.j(this.f44866a, z);
            }
        });
    }

    @Override // com.huachenjie.compat.page.settings.SettingContact.Presenter
    public void g(boolean on) {
        AcseHelpManager.setGoodsWelfare(on ? "1" : "0");
    }

    @Override // com.huachenjie.compat.page.settings.SettingContact.Presenter
    public void h(boolean on) {
        this.featurePush = on;
        ai9.u(on);
    }
}
