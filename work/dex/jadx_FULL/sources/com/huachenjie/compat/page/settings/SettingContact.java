package com.huachenjie.compat.page.settings;

import android.content.Context;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.base.BaseView;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/compat/page/settings/SettingContact;", "", "PersonalView", "Presenter", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SettingContact {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/huachenjie/compat/page/settings/SettingContact$PersonalView;", "Lcom/huachenjie/common/base/BaseView;", "", "", "", "map", "", y6b.g, "isOpen", t.d, "compat_release"}, k = 1, mv = {1, 8, 0})
    public interface PersonalView extends BaseView {
        void h(@NotNull Map<String, Boolean> map);

        void l(boolean isOpen);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/huachenjie/compat/page/settings/SettingContact$Presenter;", "Lcom/huachenjie/common/base/BasePresenter;", "Lcom/huachenjie/compat/page/settings/SettingContact$PersonalView;", "Landroid/content/Context;", "ctx", "", "f", "", "on", y6b.g, y6b.f, "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class Presenter extends BasePresenter<PersonalView> {
        public abstract void f(@NotNull Context ctx);

        public abstract void g(boolean on);

        public abstract void h(boolean on);
    }
}
