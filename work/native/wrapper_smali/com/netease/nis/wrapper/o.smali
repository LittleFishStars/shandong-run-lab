.class public final Lcom/netease/nis/wrapper/o;
.super Ljava/lang/Object;


# static fields
.field private static final a:Ljava/lang/String; = "lib"

.field private static final b:I = 0x5

.field private static final c:I = 0x1000


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Landroid/content/Context;)Ljava/io/File;
    .registers 3

    const-string v0, "IgwW"

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    const-string v0, "KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string v1, "PgQADS0aFjo="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    .registers 5

    invoke-virtual {p1, p2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v0, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static a(Landroid/content/Context;Ljava/io/File;)V
    .registers 11

    const/4 v4, 0x0

    const/4 v3, 0x1

    invoke-static {}, Lcom/netease/nis/wrapper/o;->b()Z

    move-result v1

    if-eqz v1, :cond_82

    :try_start_8
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    check-cast v1, Ldalvik/system/PathClassLoader;

    const-string v2, "KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    const-string v5, "PgQADS0aFjo="

    invoke-static/range {v5 .. v5}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v2, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v2, "IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Ljava/lang/reflect/Field;

    move-object v1, v0

    const/4 v5, 0x1

    invoke-virtual {v1, v5}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    move-object v0, v2

    check-cast v0, Ljava/lang/reflect/Field;

    move-object v1, v0

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    instance-of v5, v1, [Ljava/lang/Object;

    if-eqz v5, :cond_83

    check-cast v1, [Ljava/io/File;

    array-length v7, v1

    move v5, v4

    :goto_50
    if-ge v5, v7, :cond_5f

    aget-object v8, v1, v5

    if-eq v8, p1, :cond_5e

    if-eqz p1, :cond_7a

    invoke-virtual {p1, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7a

    :cond_5e
    move v4, v3

    :cond_5f
    if-nez v4, :cond_82

    array-length v4, v1

    add-int/lit8 v4, v4, 0x1

    const-class v5, Ljava/io/File;

    invoke-static {v5, v4}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v5

    const/4 v7, 0x0

    invoke-static {v5, v7, p1}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    :goto_6e
    if-ge v3, v4, :cond_7d

    add-int/lit8 v7, v3, -0x1

    aget-object v7, v1, v7

    invoke-static {v5, v3, v7}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_6e

    :cond_7a
    add-int/lit8 v5, v5, 0x1

    goto :goto_50

    :cond_7d
    check-cast v2, Ljava/lang/reflect/Field;

    invoke-virtual {v2, v6, v5}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_82
    :goto_82
    return-void

    :cond_83
    instance-of v3, v1, Ljava/util/ArrayList;

    if-eqz v3, :cond_82

    check-cast v1, Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v3

    const/4 v4, -0x1

    if-ne v3, v4, :cond_82

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_94
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_a0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_94

    :catch_9e
    move-exception v1

    goto :goto_82

    :cond_a0
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v3, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface {v3, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_af
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_b9

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_af

    :cond_b9
    check-cast v2, Ljava/lang/reflect/Field;

    invoke-virtual {v2, v6, v3}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_be
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_be} :catch_9e

    goto :goto_82
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)V
    .registers 6

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    if-nez p0, :cond_10

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CQwCAA9TBiELAAAZB0UnFlQLFB8J"

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_10
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_22

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CQwCAA9TCScHBgQTCkUnFlQACAcNKxdUCxQfCW4KBkUEHhU6HA=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_22
    :try_start_22
    invoke-static {p1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "HRwHEQQeSyIKFQEtGgc8BAYcQQ=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bhYBBgIWFj0="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_3f
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_22 .. :try_end_3f} :catch_40

    :goto_3f
    return-void

    :catch_40
    move-exception v0

    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "IgoVAS0aBzwEBhxBFQQnCREBWw=="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/UnsatisfiedLinkError;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "HRwHEQQeSyIKFQEtGgc8BAYcQQ=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bgMVDA0WAQ=="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p0, p1}, Lcom/netease/nis/wrapper/o;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_7c

    invoke-static {p0, p1}, Lcom/netease/nis/wrapper/o;->c(Landroid/content/Context;Ljava/lang/String;)V

    :cond_7c
    :try_start_7c
    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->load(Ljava/lang/String;)V

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "PAAYDA8YRSIKFQFB"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "bhYBBgIWFj0="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_9d
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_7c .. :try_end_9d} :catch_9e

    goto :goto_3f

    :catch_9e
    move-exception v0

    sget-object v2, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "PAAYDA8YRSIKFQFB"

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "bgMVDA0WAXQ="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/UnsatisfiedLinkError;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :try_start_c1
    new-instance v0, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/netease/nis/wrapper/o;->b()Z
    :try_end_cd
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_c1 .. :try_end_cd} :catch_f2

    move-result v1

    if-eqz v1, :cond_d3

    :try_start_d0
    invoke-static {p0, v0}, Lcom/netease/nis/wrapper/o;->b(Landroid/content/Context;Ljava/io/File;)V
    :try_end_d3
    .catch Ljava/lang/Exception; {:try_start_d0 .. :try_end_d3} :catch_119
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_d0 .. :try_end_d3} :catch_f2

    :cond_d3
    :goto_d3
    :try_start_d3
    invoke-static {p1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "LwIVDA9TCSEEECkIERcvFw1F"

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bhYBBgIWFj0="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_f0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_d3 .. :try_end_f0} :catch_f2

    goto/16 :goto_3f

    :catch_f2
    move-exception v0

    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "LwIVDA9TCSEEECkIERcvFw1F"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "bgMVDA0WAXQ="

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/UnsatisfiedLinkError;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    goto/16 :goto_3f

    :catch_119
    move-exception v0

    goto :goto_d3
.end method

.method private static a(Ljava/io/Closeable;)V
    .registers 2

    if-eqz p0, :cond_5

    :try_start_2
    invoke-interface {p0}, Ljava/io/Closeable;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_5} :catch_6

    :cond_5
    :goto_5
    return-void

    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method private static a(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 5

    const/16 v0, 0x1000

    new-array v0, v0, [B

    :goto_4
    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_10

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v1}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_4

    :cond_10
    return-void
.end method

.method private static a([Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x0

    array-length v2, p0

    move v1, v0

    :goto_3
    if-ge v1, v2, :cond_12

    aget-object v3, p0, v1

    if-eq v3, p1, :cond_11

    if-eqz p1, :cond_13

    invoke-virtual {p1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_13

    :cond_11
    const/4 v0, 0x1

    :cond_12
    return v0

    :cond_13
    add-int/lit8 v1, v1, 0x1

    goto :goto_3
.end method

.method private static a()[Ljava/lang/String;
    .registers 4

    const/4 v3, 0x1

    const/4 v2, 0x0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_10

    sget-object v0, Landroid/os/Build;->SUPPORTED_ABIS:[Ljava/lang/String;

    array-length v0, v0

    if-lez v0, :cond_10

    sget-object v0, Landroid/os/Build;->SUPPORTED_ABIS:[Ljava/lang/String;

    :goto_f
    return-object v0

    :cond_10
    sget-object v0, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_24

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    sget-object v1, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    aput-object v1, v0, v2

    sget-object v1, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    aput-object v1, v0, v3

    goto :goto_f

    :cond_24
    new-array v0, v3, [Ljava/lang/String;

    sget-object v1, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    aput-object v1, v0, v2

    goto :goto_f
.end method

.method private static b(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .registers 6

    invoke-static {p1}, Ljava/lang/System;->mapLibraryName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/io/File;

    const-string v2, "IgwW"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v1
.end method

.method private static b(Landroid/content/Context;Ljava/io/File;)V
    .registers 10

    const/4 v4, 0x0

    const/4 v2, 0x1

    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    check-cast v0, Ldalvik/system/PathClassLoader;

    const-string v1, "KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-string v3, "PgQADS0aFjo="

    invoke-static/range {v3 .. v3}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-string v1, "IAQADBcWKScHBgQTCiEnFxEGFRwXJwAH"

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Ljava/lang/reflect/Field;

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    move-object v0, v1

    check-cast v0, Ljava/lang/reflect/Field;

    invoke-virtual {v0, v5}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    instance-of v3, v0, [Ljava/lang/Object;

    if-eqz v3, :cond_78

    check-cast v0, [Ljava/io/File;

    array-length v6, v0

    move v3, v4

    :goto_46
    if-ge v3, v6, :cond_70

    aget-object v7, v0, v3

    if-eq v7, p1, :cond_52

    invoke-virtual {p1, v7}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_6d

    :cond_52
    move v3, v2

    :goto_53
    if-nez v3, :cond_77

    array-length v3, v0

    add-int/lit8 v3, v3, 0x1

    const-class v6, Ljava/io/File;

    invoke-static {v6, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v6

    invoke-static {v6, v4, p1}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    :goto_61
    if-ge v2, v3, :cond_72

    add-int/lit8 v4, v2, -0x1

    aget-object v4, v0, v4

    invoke-static {v6, v2, v4}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_61

    :cond_6d
    add-int/lit8 v3, v3, 0x1

    goto :goto_46

    :cond_70
    move v3, v4

    goto :goto_53

    :cond_72
    check-cast v1, Ljava/lang/reflect/Field;

    invoke-virtual {v1, v5, v6}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_77
    :goto_77
    return-void

    :cond_78
    instance-of v2, v0, Ljava/util/ArrayList;

    if-eqz v2, :cond_77

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_77

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_89
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_93

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_89

    :cond_93
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface {v2, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_ac

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_a2

    :cond_ac
    check-cast v1, Ljava/lang/reflect/Field;

    invoke-virtual {v1, v5, v2}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_77
.end method

.method private static b()Z
    .registers 1

    :try_start_0
    const-string v0, "KgQYEwgYSz0cBxEEHksMBAcAJRYdDQkVFhI/Ci8BERc="

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_9
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_9} :catch_b

    const/4 v0, 0x1

    :goto_a
    return v0

    :catch_b
    move-exception v0

    const/4 v0, 0x0

    goto :goto_a
.end method

.method private static c(Landroid/content/Context;Ljava/lang/String;)V
    .registers 16

    const/4 v12, 0x5

    const/4 v1, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    :try_start_4
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;
    :try_end_7
    .catchall {:try_start_4 .. :try_end_7} :catchall_151

    move-result-object v6

    move v0, v4

    :goto_9
    add-int/lit8 v2, v0, 0x1

    if-ge v0, v12, :cond_16c

    :try_start_d
    new-instance v3, Ljava/util/zip/ZipFile;

    new-instance v0, Ljava/io/File;

    iget-object v7, v6, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-direct {v0, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    const/4 v7, 0x1

    invoke-direct {v3, v0, v7}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;I)V
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_1a} :catch_22
    .catchall {:try_start_d .. :try_end_1a} :catchall_151

    :goto_1a
    if-nez v3, :cond_25

    if-eqz v3, :cond_21

    :try_start_1e
    invoke-virtual {v3}, Ljava/util/zip/ZipFile;->close()V
    :try_end_21
    .catch Ljava/io/IOException; {:try_start_1e .. :try_end_21} :catch_14c

    :cond_21
    :goto_21
    return-void

    :catch_22
    move-exception v0

    move v0, v2

    goto :goto_9

    :cond_25
    move v0, v4

    :goto_26
    add-int/lit8 v6, v0, 0x1

    if-ge v0, v12, :cond_123

    :try_start_2a
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v0, v2, :cond_70

    sget-object v0, Landroid/os/Build;->SUPPORTED_ABIS:[Ljava/lang/String;

    array-length v0, v0

    if-lez v0, :cond_70

    sget-object v0, Landroid/os/Build;->SUPPORTED_ABIS:[Ljava/lang/String;

    move-object v8, v0

    :goto_38
    array-length v9, v8

    move v7, v4

    move-object v0, v1

    move-object v2, v1

    :goto_3c
    if-ge v7, v9, :cond_91

    aget-object v0, v8, v7

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v10, "IgwW"

    invoke-static/range {v10 .. v10}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v2, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-char v10, Ljava/io/File;->separatorChar:C

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-char v2, Ljava/io/File;->separatorChar:C

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/System;->mapLibraryName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v0

    if-nez v0, :cond_91

    add-int/lit8 v7, v7, 0x1

    goto :goto_3c

    :cond_70
    sget-object v0, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_87

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v7, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    aput-object v7, v0, v2

    const/4 v2, 0x1

    sget-object v7, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    aput-object v7, v0, v2

    move-object v8, v0

    goto :goto_38

    :cond_87
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v7, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    aput-object v7, v0, v2

    move-object v8, v0

    goto :goto_38

    :cond_91
    if-nez v0, :cond_dc

    if-eqz v2, :cond_d6

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v7, "IgwW"

    invoke-static/range {v7 .. v7}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v0, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-char v7, Ljava/io/File;->separatorChar:C

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, "LxcZAAARDA=="

    invoke-static/range {v7 .. v7}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-char v7, Ljava/io/File;->separatorChar:C

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/System;->mapLibraryName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v0

    if-nez v0, :cond_dc

    new-instance v0, Lcom/netease/nis/wrapper/p;

    invoke-direct {v0, v2}, Lcom/netease/nis/wrapper/p;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_ce
    .catchall {:try_start_2a .. :try_end_ce} :catchall_ce

    :catchall_ce
    move-exception v0

    move-object v1, v3

    :goto_d0
    if-eqz v1, :cond_d5

    :try_start_d2
    invoke-virtual {v1}, Ljava/util/zip/ZipFile;->close()V
    :try_end_d5
    .catch Ljava/io/IOException; {:try_start_d2 .. :try_end_d5} :catch_14f

    :cond_d5
    :goto_d5
    throw v0

    :cond_d6
    :try_start_d6
    new-instance v0, Lcom/netease/nis/wrapper/p;

    invoke-direct {v0, p1}, Lcom/netease/nis/wrapper/p;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_dc
    invoke-static {p0, p1}, Lcom/netease/nis/wrapper/o;->b(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v7

    invoke-virtual {v7}, Ljava/io/File;->delete()Z
    :try_end_e3
    .catchall {:try_start_d6 .. :try_end_e3} :catchall_ce

    :try_start_e3
    invoke-virtual {v7}, Ljava/io/File;->createNewFile()Z
    :try_end_e6
    .catch Ljava/io/IOException; {:try_start_e3 .. :try_end_e6} :catch_ec
    .catchall {:try_start_e3 .. :try_end_e6} :catchall_ce

    move-result v2

    if-nez v2, :cond_f0

    move v0, v6

    goto/16 :goto_26

    :catch_ec
    move-exception v0

    move v0, v6

    goto/16 :goto_26

    :cond_f0
    :try_start_f0
    invoke-virtual {v3, v0}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    :try_end_f3
    .catch Ljava/io/FileNotFoundException; {:try_start_f0 .. :try_end_f3} :catch_12d
    .catch Ljava/io/IOException; {:try_start_f0 .. :try_end_f3} :catch_138
    .catchall {:try_start_f0 .. :try_end_f3} :catchall_143

    move-result-object v0

    :try_start_f4
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v7}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_f9
    .catch Ljava/io/FileNotFoundException; {:try_start_f4 .. :try_end_f9} :catch_164
    .catch Ljava/io/IOException; {:try_start_f4 .. :try_end_f9} :catch_15f
    .catchall {:try_start_f4 .. :try_end_f9} :catchall_154

    :try_start_f9
    invoke-static {v0, v2}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_fc
    .catch Ljava/io/FileNotFoundException; {:try_start_f9 .. :try_end_fc} :catch_167
    .catch Ljava/io/IOException; {:try_start_f9 .. :try_end_fc} :catch_162
    .catchall {:try_start_f9 .. :try_end_fc} :catchall_15a

    :try_start_fc
    invoke-static {v0}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    invoke-static {v2}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    move v0, v4

    :goto_103
    if-nez v0, :cond_169

    invoke-virtual {v7}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_169

    invoke-virtual {v7}, Ljava/io/File;->length()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v0, v8, v10

    if-eqz v0, :cond_169

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {v7, v0, v1}, Ljava/io/File;->setReadable(ZZ)Z

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {v7, v0, v1}, Ljava/io/File;->setExecutable(ZZ)Z

    const/4 v0, 0x1

    invoke-virtual {v7, v0}, Ljava/io/File;->setWritable(Z)Z
    :try_end_123
    .catchall {:try_start_fc .. :try_end_123} :catchall_ce

    :cond_123
    if-eqz v3, :cond_21

    :try_start_125
    invoke-virtual {v3}, Ljava/util/zip/ZipFile;->close()V
    :try_end_128
    .catch Ljava/io/IOException; {:try_start_125 .. :try_end_128} :catch_12a

    goto/16 :goto_21

    :catch_12a
    move-exception v0

    goto/16 :goto_21

    :catch_12d
    move-exception v0

    move-object v0, v1

    move-object v2, v1

    :goto_130
    :try_start_130
    invoke-static {v0}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    invoke-static {v2}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    move v0, v5

    goto :goto_103

    :catch_138
    move-exception v0

    move-object v0, v1

    move-object v2, v1

    :goto_13b
    invoke-static {v0}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    invoke-static {v2}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    move v0, v5

    goto :goto_103

    :catchall_143
    move-exception v0

    move-object v2, v1

    :goto_145
    invoke-static {v1}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    invoke-static {v2}, Lcom/netease/nis/wrapper/o;->a(Ljava/io/Closeable;)V

    throw v0
    :try_end_14c
    .catchall {:try_start_130 .. :try_end_14c} :catchall_ce

    :catch_14c
    move-exception v0

    goto/16 :goto_21

    :catch_14f
    move-exception v1

    goto :goto_d5

    :catchall_151
    move-exception v0

    goto/16 :goto_d0

    :catchall_154
    move-exception v2

    move-object v13, v2

    move-object v2, v1

    move-object v1, v0

    move-object v0, v13

    goto :goto_145

    :catchall_15a
    move-exception v1

    move-object v13, v1

    move-object v1, v0

    move-object v0, v13

    goto :goto_145

    :catch_15f
    move-exception v2

    move-object v2, v1

    goto :goto_13b

    :catch_162
    move-exception v8

    goto :goto_13b

    :catch_164
    move-exception v2

    move-object v2, v1

    goto :goto_130

    :catch_167
    move-exception v8

    goto :goto_130

    :cond_169
    move v0, v6

    goto/16 :goto_26

    :cond_16c
    move-object v3, v1

    goto/16 :goto_1a
.end method
