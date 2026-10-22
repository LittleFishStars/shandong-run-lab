package com.huachenjie.works.page.alumni.find_alumni;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InterestTagGroupBean;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniDialog;
import com.zj.adlib.fx7;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class FindAlumniDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG_GROUPS = "tagGroups";

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.find_alumni.FindAlumniDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/InterestTagGroupBean;", "Lkotlin/collections/ArrayList;", "tagGroups", "", "a", "", "TAG_GROUPS", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull ArrayList<InterestTagGroupBean> tagGroups) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(tagGroups, "tagGroups");
            FindAlumniDialog findAlumniDialog = new FindAlumniDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("tagGroups", tagGroups);
            findAlumniDialog.setArguments(bundle);
            findAlumniDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(FindAlumniDialog.class).getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FindAlumniDialog findAlumniDialog, View view) {
        ArrayList<InterestTagGroupBean> parcelableArrayList;
        Intrinsics.checkNotNullParameter(findAlumniDialog, "this$0");
        Bundle arguments = findAlumniDialog.getArguments();
        if (arguments == null || (parcelableArrayList = arguments.getParcelableArrayList("tagGroups")) == null) {
            return;
        }
        SettingInterestTagsActivity.Companion bVar = SettingInterestTagsActivity.INSTANCE;
        Context contextRequireContext = findAlumniDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        bVar.a(contextRequireContext, parcelableArrayList);
        findAlumniDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FindAlumniDialog findAlumniDialog, View view) {
        Intrinsics.checkNotNullParameter(findAlumniDialog, "this$0");
        findAlumniDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_find_alumni;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(28.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        TextView textView;
        super.initView();
        View view = getView();
        if (view != null && (textView = (TextView) view.findViewById(R.id.tv_setting)) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.tg3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FindAlumniDialog.initView$lambda$0(this.f44912a, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 == null || (imageView = (ImageView) view2.findViewById(R.id.tv_close)) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ug3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                FindAlumniDialog.initView$lambda$1(this.f45143a, view3);
            }
        });
    }
}
