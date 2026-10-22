package com.huachenjie.works.page.comment.base.provider;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coroutines.DataBindingUtil;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.databinding.WorksItemCommentBinding;
import com.zj.adlib.ju3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u0019\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u0019\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002R\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010!\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u001a\u0010$\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010#¨\u0006*"}, d2 = {"Lcom/huachenjie/works/page/comment/base/provider/CommentProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "Landroid/view/View;", "view", "data", "", "position", "d", "c", "", "e", "Landroid/widget/ImageView;", "imageView", "imageWidth", "imageHeight", "b", "I", "commentType", "commentSource", "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/comment/CommentBean;", "Lkotlin/jvm/functions/Function1;", "onCommentClick", "", "onAvatarClick", "onLongClick", "maxSize", "minSize", "getItemViewType", "()I", "itemViewType", "f", "getLayoutId", "layoutId", "<init>", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentProvider extends BaseNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int commentType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Function1<CommentBean, Unit> onCommentClick;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int commentSource;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Function1<String, Unit> onAvatarClick;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int maxSize;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Function1<BaseNode, Unit> onLongClick;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int minSize;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int itemViewType;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int layoutId;

    /* JADX WARN: Multi-variable type inference failed */
    public CommentProvider(int i, int i2, @NotNull Function1<? super CommentBean, Unit> function1, @NotNull Function1<? super String, Unit> function2, @NotNull Function1<? super BaseNode, Unit> function3) {
        Intrinsics.checkNotNullParameter(function1, "onCommentClick");
        Intrinsics.checkNotNullParameter(function2, "onAvatarClick");
        Intrinsics.checkNotNullParameter(function3, "onLongClick");
        this.commentType = i;
        this.commentSource = i2;
        this.onCommentClick = function1;
        this.onAvatarClick = function2;
        this.onLongClick = function3;
        this.maxSize = SizeUtils.b(150.0f);
        this.minSize = SizeUtils.b(60.0f);
        this.layoutId = R.layout.works_item_comment;
        addChildClickViewIds(R.id.iv_avatar, R.id.iv_pic);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        WorksItemCommentBinding worksItemCommentBinding;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        final CommentBean commentBean = item instanceof CommentBean ? (CommentBean) item : null;
        if (commentBean == null || (worksItemCommentBinding = (WorksItemCommentBinding) DataBindingUtil.bind(helper.itemView)) == null) {
            return;
        }
        CommentImageBean image = commentBean.getImage();
        if (TextUtils.isEmpty(image != null ? image.getPath() : null)) {
            worksItemCommentBinding.f37017a.setVisibility(8);
        } else {
            ImageView imageView = worksItemCommentBinding.f37017a;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivPic");
            CommentImageBean image2 = commentBean.getImage();
            Intrinsics.checkNotNull(image2);
            b(imageView, image2.getWidth(), commentBean.getImage().getHeight());
            Glide.with(worksItemCommentBinding.f37017a).load(commentBean.getImage().getPath()).apply((BaseRequestOptions<?>) ju3.p).into(worksItemCommentBinding.f37017a);
            worksItemCommentBinding.f37017a.setVisibility(0);
        }
        worksItemCommentBinding.f14522a.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.comment.base.provider.CommentProvider$convert$1$1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, int i) {
                commentBean.setLiked(z);
                commentBean.setLikeCount(i);
            }
        });
        worksItemCommentBinding.n(Integer.valueOf(this.commentType));
        worksItemCommentBinding.o(Integer.valueOf(this.commentSource));
        worksItemCommentBinding.m(commentBean);
        worksItemCommentBinding.executePendingBindings();
    }

    public final void b(ImageView imageView, int imageWidth, int imageHeight) {
        int i;
        int i2;
        if (imageWidth == 0 || imageHeight == 0) {
            i = this.maxSize;
            i2 = i;
        } else if (imageWidth > imageHeight) {
            i = this.maxSize;
            if (imageWidth <= i && imageWidth >= (i = this.minSize)) {
                i = imageWidth;
            }
            i2 = (imageHeight * i) / imageWidth;
        } else {
            int i3 = this.maxSize;
            if (imageHeight <= i3 && imageHeight >= (i3 = this.minSize)) {
                i3 = imageHeight;
            }
            int i4 = (imageWidth * i3) / imageHeight;
            i2 = i3;
            i = i4;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        imageView.setLayoutParams(layoutParams);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onChildClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        String path;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        CommentBean commentBean = data instanceof CommentBean ? (CommentBean) data : null;
        if (commentBean == null || TextUtils.isEmpty(commentBean.getCommentNo())) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_avatar) {
            this.onAvatarClick.invoke(commentBean.getUserInfo().getAppUserCode());
            return;
        }
        if (id == R.id.iv_pic) {
            CommentImageBean image = commentBean.getImage();
            if (image == null || (path = image.getPath()) == null) {
                path = "";
            }
            PicturePreviewUtil.i(view, path);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        CommentBean commentBean = data instanceof CommentBean ? (CommentBean) data : null;
        if (commentBean == null || TextUtils.isEmpty(commentBean.getCommentNo())) {
            return;
        }
        this.onCommentClick.invoke(commentBean);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean onLongClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        CommentBean commentBean = data instanceof CommentBean ? (CommentBean) data : null;
        if (commentBean == null || TextUtils.isEmpty(commentBean.getCommentNo())) {
            return false;
        }
        this.onLongClick.invoke(commentBean);
        return true;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return this.itemViewType;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return this.layoutId;
    }
}
