package com.huachenjie.works.page.comment.base;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J<\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJB\u0010\r\u001a,\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nJD\u0010\u0010\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\nJJ\u0010\u0012\u001a4\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\nJ\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/page/comment/base/CommentDelegate;", "", "", "commentType", "a", "Lkotlin/reflect/KSuspendFunction3;", "", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/works/bean/comment/CommentBean;", "b", "(I)Lkotlin/reflect/KFunction;", "Lkotlin/reflect/KSuspendFunction4;", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "c", "", "Lcom/huachenjie/works/bean/comment/CommentImageBean;", "e", "Lkotlin/reflect/KSuspendFunction5;", "f", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "i", "Lkotlin/reflect/KSuspendFunction1;", "Lcom/alibaba/fastjson/JSONObject;", "d", y6b.f, y6b.g, "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CommentDelegate f37252a = new CommentDelegate();

    @JvmStatic
    public static final int a(int commentType) {
        if (commentType != 2) {
            return commentType != 3 ? 3 : 8;
        }
        return 5;
    }

    @Nullable
    public final KFunction<PageEntity<CommentBean>> b(int commentType) {
        if (commentType == 1) {
            return new CommentDelegate$provideCommentList$1(RequestModel.f36762a);
        }
        if (commentType == 2) {
            return new CommentDelegate$provideCommentList$2(RequestModel.f36762a);
        }
        if (commentType != 3) {
            return null;
        }
        return new CommentDelegate$provideCommentList$3(RequestModel.f36762a);
    }

    @Nullable
    public final KFunction<PageEntity<CommentReplyBean>> c(int commentType) {
        if (commentType == 1) {
            return new CommentDelegate$provideCommentReplyList$1(RequestModel.f36762a);
        }
        if (commentType == 2) {
            return new CommentDelegate$provideCommentReplyList$2(RequestModel.f36762a);
        }
        if (commentType != 3) {
            return null;
        }
        return new CommentDelegate$provideCommentReplyList$3(RequestModel.f36762a);
    }

    @Nullable
    public final KFunction<JSONObject> d(int commentType) {
        if (commentType == 1) {
            return new CommentDelegate$provideDeleteComment$1(RequestModel.f36762a);
        }
        if (commentType == 2) {
            return new CommentDelegate$provideDeleteComment$2(RequestModel.f36762a);
        }
        if (commentType != 3) {
            return null;
        }
        return new CommentDelegate$provideDeleteComment$3(RequestModel.f36762a);
    }

    @Nullable
    public final KFunction<CommentBean> e(int commentType) {
        if (commentType == 1) {
            return new CommentDelegate$providePublishComment$1(RequestModel.f36762a);
        }
        if (commentType == 2) {
            return new CommentDelegate$providePublishComment$2(RequestModel.f36762a);
        }
        if (commentType != 3) {
            return null;
        }
        return new CommentDelegate$providePublishComment$3(RequestModel.f36762a);
    }

    @Nullable
    public final KFunction<CommentReplyBean> f(int commentType) {
        if (commentType == 1) {
            return new CommentDelegate$providePublishCommentReply$1(RequestModel.f36762a);
        }
        if (commentType == 2) {
            return new CommentDelegate$providePublishCommentReply$2(RequestModel.f36762a);
        }
        if (commentType != 3) {
            return null;
        }
        return new CommentDelegate$providePublishCommentReply$3(RequestModel.f36762a);
    }

    public final int g(int commentType) {
        if (commentType == 1) {
            return 2;
        }
        if (commentType != 2) {
            return commentType != 3 ? 2 : 6;
        }
        return 4;
    }

    public final int h(int commentType) {
        if (commentType == 1) {
            return 2;
        }
        if (commentType != 2) {
            return commentType != 3 ? 2 : 4;
        }
        return 3;
    }

    @NotNull
    public final UploadFileType i(int commentType) {
        if (commentType == 1) {
            return UploadFileType.UPLOAD_WORKS_COMMENT;
        }
        if (commentType != 2) {
            return commentType != 3 ? UploadFileType.UPLOAD_WORKS_COMMENT : UploadFileType.UPLOAD_LIVE_COMMENT;
        }
        return UploadFileType.UPLOAD_QUOTE_COMMENT;
    }
}
