package com.zj.adlib;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.BindingAdapter;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.works.bean.PostImageBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.external.widget.UserLaoButton;
import com.huachenjie.works.external.widget.UserReportButton;
import com.huachenjie.works.widget.PostDeleteButton;
import com.huachenjie.works.widget.PostNineGridView;
import com.huachenjie.works.widget.TagListView;
import com.huachenjie.works.widget.WorksDeleteButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b2\u00103J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0007J&\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007J,\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0007Jc\u0010\u001e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010%\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0007J\u001c\u0010*\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0007J\u001c\u0010-\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u00101\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010.2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u0004H\u0007¨\u00064"}, d2 = {"Lcom/zj/adlib/zv9;", "", "Landroid/view/View;", "view", "", "", "tagList", "", "f", "", "worksRichText", "", "worksRichJump", y6b.g, "Lcom/huachenjie/works/external/widget/UserReportButton;", "reportButton", UserConstants.CHAT_PARAMS.f, "", UserConstants.CHAT_PARAMS.h, "reportType", "e", "Lcom/huachenjie/works/external/widget/BLOperateAnimView;", "animType", "checked", "quantity", yj7.g.WORKS_NO, "worksAuthorNo", "commentNo", "commentUserNo", "source", "b", "(Lcom/huachenjie/works/external/widget/BLOperateAnimView;ILjava/lang/Boolean;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/huachenjie/works/external/widget/UserLaoButton;", "button", "Lcom/huachenjie/base/bean/UserInfoBean;", "userInfo", "buttonType", "a", "Lcom/huachenjie/works/widget/WorksDeleteButton;", "deleteButton", "Lcom/huachenjie/works/bean/WorkDetailBean;", "detailBean", y6b.f, "Lcom/huachenjie/works/widget/PostDeleteButton;", "postNo", "d", "Lcom/huachenjie/works/widget/PostNineGridView;", "Lcom/huachenjie/works/bean/PostImageBean;", "postImages", "c", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class zv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final zv9 f46354a = new zv9();

    @BindingAdapter(requireAll = true, value = {"userInfo", "buttonType", "source"})
    @JvmStatic
    public static final void a(@Nullable UserLaoButton button, @Nullable UserInfoBean userInfo, int buttonType, int source) {
        if (button == null || userInfo == null) {
            return;
        }
        button.initLaoButton(userInfo, buttonType, source);
    }

    @BindingAdapter(requireAll = false, value = {"animType", "checkedState", "quantity", yj7.g.WORKS_NO, "worksAuthorNo", "commentNo", "commentUserNo", "source"})
    @JvmStatic
    public static final void b(@Nullable BLOperateAnimView view, int animType, @Nullable Boolean checked, int quantity, @Nullable String worksNo, @Nullable String worksAuthorNo, @Nullable String commentNo, @Nullable String commentUserNo, int source) {
        if (view == null || animType <= 0 || checked == null) {
            return;
        }
        if (worksNo == null || worksNo.length() == 0) {
            return;
        }
        view.setCheckedState(animType, quantity, checked.booleanValue(), worksNo, commentNo == null ? "" : commentNo);
        if (worksAuthorNo == null) {
            worksAuthorNo = "";
        }
        view.setWorksAuthorNo(worksAuthorNo);
        if (commentUserNo == null) {
            commentUserNo = "";
        }
        view.setCommentUserNo(commentUserNo);
        view.setSource(source);
    }

    @BindingAdapter({"postImages"})
    @JvmStatic
    public static final void c(@Nullable PostNineGridView view, @Nullable List<PostImageBean> postImages) {
        if (view != null) {
            view.setPostImages(postImages);
        }
    }

    @BindingAdapter({"postNo"})
    @JvmStatic
    public static final void d(@Nullable PostDeleteButton deleteButton, @Nullable String postNo) {
        if (deleteButton == null || TextUtils.isEmpty(postNo)) {
            return;
        }
        deleteButton.setPostNo(postNo);
    }

    @BindingAdapter(requireAll = true, value = {UserConstants.CHAT_PARAMS.f, UserConstants.CHAT_PARAMS.h, "reportType"})
    @JvmStatic
    public static final void e(@Nullable UserReportButton reportButton, @Nullable String reportCode, int reportSource, int reportType) {
        if (reportButton != null) {
            if ((reportCode == null || reportCode.length() == 0) || reportSource == 0) {
                return;
            }
            reportButton.setReportCode(reportCode);
            reportButton.setReportSource(reportSource);
            reportButton.setReportType(reportType);
        }
    }

    @BindingAdapter({"tagList"})
    @JvmStatic
    public static final void f(@Nullable View view, @Nullable List<String> tagList) {
        if (view != null && (view instanceof TagListView)) {
            ((TagListView) view).setTagList(tagList);
        }
    }

    @BindingAdapter({"worksDetailBean"})
    @JvmStatic
    public static final void g(@Nullable WorksDeleteButton deleteButton, @Nullable WorkDetailBean detailBean) {
        if (deleteButton == null || detailBean == null) {
            return;
        }
        deleteButton.setDetailBean(detailBean);
    }

    @BindingAdapter(requireAll = false, value = {"worksRichText", "worksRichJump"})
    @JvmStatic
    public static final void h(@Nullable View view, @Nullable CharSequence worksRichText, boolean worksRichJump) {
        if (view == null || !(view instanceof TextView) || worksRichText == null) {
            return;
        }
        ti7.d((TextView) view, worksRichText, worksRichJump);
    }

    public static /* synthetic */ void i(View view, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        h(view, charSequence, z);
    }
}
