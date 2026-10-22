
void FUN_00179284(undefined8 *param_1,undefined8 param_2,byte *param_3)

{
  uint *puVar1;
  undefined1 *puVar2;
  uint uVar3;
  byte bVar4;
  long lVar5;
  undefined *puVar6;
  undefined1 *puVar7;
  size_t sVar8;
  ulong uVar9;
  ulong uVar10;
  ulong uVar11;
  uint uVar12;
  long lVar13;
  uint uVar14;
  char *pcVar15;
  void *__dest;
  ulong local_c0;
  size_t local_b8;
  void *local_b0;
  ulong local_a8;
  undefined8 uStack_a0;
  undefined8 local_98;
  undefined1 *local_90;
  undefined1 *local_88;
  undefined1 *local_80;
  long local_78;
  long local_70;
  undefined8 local_68;
  uint local_60;
  undefined1 local_5c;
  undefined1 local_5b;
  undefined1 local_5a;
  undefined1 local_59;
  undefined1 local_58;
  undefined7 uStack_57;
  ulong local_50;
  long local_48;
  
  lVar5 = tpidr_el0;
  local_48 = *(long *)(lVar5 + 0x28);
  *param_1 = 0;
  param_1[1] = 0;
  param_1[2] = 0;
  bVar4 = *param_3;
  if ((bVar4 & 1) == 0) {
    if (bVar4 >> 1 == 0) goto LAB_001796a4;
  }
  else if (*(long *)(param_3 + 8) == 0) goto LAB_001796a4;
  local_78 = 0;
  local_70 = 0;
  local_68 = 0;
  if ((bVar4 & 1) == 0) {
    if (bVar4 >> 1 == 0) goto LAB_00179308;
LAB_001792e8:
    FUN_00179e08(&local_78);
    bVar4 = *param_3;
    if ((bVar4 & 1) == 0) goto LAB_0017930c;
LAB_001792f8:
    uVar10 = *(ulong *)(param_3 + 8);
    param_3 = *(byte **)(param_3 + 0x10);
  }
  else {
    if (*(long *)(param_3 + 8) != 0) goto LAB_001792e8;
LAB_00179308:
    if ((bVar4 & 1) != 0) goto LAB_001792f8;
LAB_0017930c:
    param_3 = param_3 + 1;
    uVar10 = (ulong)(bVar4 >> 1);
  }
  FUN_0017977c(&local_78,param_3,param_3 + uVar10);
  FUN_00179d44(&local_90,&local_78);
  uVar9 = (long)local_88 - (long)local_90;
  uVar10 = 8;
  if ((uVar9 & 7) != 0) {
    uVar10 = 8 - (uVar9 & 7);
  }
  if (uVar10 != 0) {
    uVar9 = 1;
    while( true ) {
      local_a8 = CONCAT71(local_a8._1_7_,(char)uVar10);
      if (local_88 < local_80) {
        *local_88 = (char)uVar10;
        local_88 = local_88 + 1;
      }
      else {
        FUN_00130ff0(&local_90,&local_a8);
      }
      if (uVar10 <= uVar9) break;
      uVar9 = uVar9 + 1;
    }
    uVar9 = (long)local_88 - (long)local_90;
  }
  puVar7 = local_88;
  if (7 < uVar9) {
    uVar10 = 0;
    do {
      uVar9 = (ulong)(uint)((int)uVar10 << 1);
      uVar11 = (ulong)((int)uVar10 << 1 | 1);
      uVar14 = *(uint *)(local_90 + uVar9 * 4);
      lVar13 = 0;
      uVar12 = *(uint *)(local_90 + uVar11 * 4);
      do {
        puVar1 = (uint *)(&DAT_0057c970 + lVar13);
        lVar13 = lVar13 + 4;
        uVar3 = *puVar1 ^ uVar14;
        *(uint *)(local_90 + uVar9 * 4) = uVar3;
        uVar14 = (*(int *)(&DAT_0057cdb8 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) +
                  (&DAT_0057c9b8)[uVar3 >> 0x18] ^
                 *(uint *)(&DAT_0057d1b8 + (ulong)(uVar3 >> 8 & 0xff) * 4)) +
                 *(int *)(&DAT_0057d5b8 + (ulong)(uVar3 & 0xff) * 4) ^ uVar12;
        *(uint *)(local_90 + uVar9 * 4) = uVar14;
        *(uint *)(local_90 + uVar11 * 4) = uVar3;
        uVar12 = uVar3;
      } while (lVar13 != 0x40);
      *(uint *)(local_90 + uVar9 * 4) = uVar3;
      *(uint *)(local_90 + uVar11 * 4) = uVar14;
      uVar10 = uVar10 + 1;
      *(uint *)(local_90 + uVar11 * 4) = DAT_0057c9b0 ^ uVar14;
      *(uint *)(local_90 + uVar9 * 4) = DAT_0057c9b4 ^ uVar3;
    } while (uVar10 < (ulong)((long)local_88 - (long)local_90) >> 3);
  }
  local_a8 = 0;
  uStack_a0 = 0;
  local_98 = 0;
  for (puVar2 = local_90; puVar7 != puVar2; puVar2 = puVar2 + 1) {
    FUN_00159f58(&local_a8,*puVar2);
  }
  local_60 = 0x33;
  lVar13 = 0;
  local_5c = 0x7d;
  local_5b = 0x60;
  local_5a = 0x70;
  local_59 = 0x65;
  pcVar15 = (char *)((ulong)&local_60 | 4);
  do {
    pcVar15[lVar13] = pcVar15[lVar13] ^ (char)lVar13 + 0x33U;
    lVar13 = lVar13 + 1;
  } while (lVar13 != 4);
  local_58 = 0;
  local_b8 = 0;
  local_b0 = (void *)0x0;
  local_c0 = 0;
  sVar8 = strlen(pcVar15);
  if (0xffffffffffffffef < sVar8) {
                    /* WARNING: Subroutine does not return */
    FUN_0011ebc8(&local_c0);
  }
  if (sVar8 < 0x17) {
    __dest = (void *)((ulong)&local_c0 | 1);
    local_c0 = CONCAT71(local_c0._1_7_,(char)(sVar8 << 1));
    if (sVar8 != 0) goto LAB_00179574;
  }
  else {
    uVar10 = sVar8 + 0x10 & 0xfffffffffffffff0;
    __dest = (void *)FUN_004780a8(uVar10);
    local_c0 = uVar10 | 1;
    local_b8 = sVar8;
    local_b0 = __dest;
LAB_00179574:
    memcpy(__dest,pcVar15,sVar8);
  }
  *(undefined1 *)((long)__dest + sVar8) = 0;
  FUN_00123cf4(&local_60,&local_c0,&local_a8);
  puVar6 = PTR_DAT_00577ea0;
  uVar10 = (ulong)((byte)local_60 >> 1);
  if ((local_60 & 1) != 0) {
    uVar10 = CONCAT71(uStack_57,local_58);
  }
  lVar13 = (long)(int)((int)((uVar10 + 2) / 3) << 2 | 1);
  pcVar15 = (char *)(**(code **)(*(long *)PTR_DAT_00577ea0 + 0x160))(lVar13);
  if (pcVar15 != (char *)0x0) {
    (**(code **)(*(long *)puVar6 + 0x150))(pcVar15,0,lVar13);
    uVar10 = (ulong)((byte)local_60 >> 1);
    uVar9 = (ulong)&local_60 | 1;
    if ((local_60 & 1) != 0) {
      uVar10 = CONCAT71(uStack_57,local_58);
      uVar9 = local_50;
    }
    FUN_003463c8(uVar9,uVar10,pcVar15);
    sVar8 = strlen(pcVar15);
    FUN_0011ff98(param_1,pcVar15,sVar8);
    (**(code **)(*(long *)puVar6 + 0x168))(pcVar15);
  }
  if ((local_60 & 1) != 0) {
    FUN_00478110(local_50);
  }
  if ((local_c0 & 1) != 0) {
    FUN_00478110(local_b0);
  }
  if ((local_a8 & 1) != 0) {
    FUN_00478110(local_98);
  }
  if (local_90 != (undefined1 *)0x0) {
    local_88 = local_90;
    FUN_00478110();
  }
  if (local_78 != 0) {
    local_70 = local_78;
    FUN_00478110();
  }
LAB_001796a4:
  if (*(long *)(lVar5 + 0x28) != local_48) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}

