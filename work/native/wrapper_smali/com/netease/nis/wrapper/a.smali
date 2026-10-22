.class public final Lcom/netease/nis/wrapper/a;
.super Ljava/lang/Object;


# static fields
.field public static a:Z

.field public static b:Z

.field public static c:Z

.field private static d:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const-string v0, "KgAWEAYsFjkMAAYJLFU="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/netease/nis/wrapper/a;->d:Ljava/lang/String;

    const-string v1, "fw=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    sput-boolean v0, Lcom/netease/nis/wrapper/a;->a:Z

    if-nez v0, :cond_1e

    const/4 v0, 0x1

    :goto_17
    sput-boolean v0, Lcom/netease/nis/wrapper/a;->b:Z

    sget-boolean v0, Lcom/netease/nis/wrapper/a;->a:Z

    sput-boolean v0, Lcom/netease/nis/wrapper/a;->c:Z

    return-void

    :cond_1e
    const/4 v0, 0x0

    goto :goto_17
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
