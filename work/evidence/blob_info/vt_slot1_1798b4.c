
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_001798b4(byte *param_1,undefined8 param_2,byte *param_3)

{
  uint *puVar1;
  undefined1 *puVar2;
  uint uVar3;
  byte bVar4;
  long lVar5;
  undefined1 *puVar6;
  undefined *puVar7;
  undefined1 *puVar8;
  int iVar9;
  long lVar10;
  size_t sVar11;
  long lVar12;
  ulong uVar13;
  ulong uVar14;
  byte *pbVar15;
  ulong uVar16;
  ulong uVar17;
  uint uVar18;
  uint uVar19;
  char *__s;
  long local_a0;
  undefined1 *local_98;
  undefined1 *local_90;
  long local_80;
  ulong local_78;
  ulong local_70;
  ulong local_68;
  ulong local_60;
  ulong local_58;
  undefined8 local_50;
  long local_48;
  
  lVar5 = tpidr_el0;
  local_48 = *(long *)(lVar5 + 0x28);
  param_1[0] = 0;
  param_1[1] = 0;
  param_1[2] = 0;
  param_1[3] = 0;
  param_1[4] = 0;
  param_1[5] = 0;
  param_1[6] = 0;
  param_1[7] = 0;
  param_1[8] = 0;
  param_1[9] = 0;
  param_1[10] = 0;
  param_1[0xb] = 0;
  param_1[0xc] = 0;
  param_1[0xd] = 0;
  param_1[0xe] = 0;
  param_1[0xf] = 0;
  param_1[0x10] = 0;
  puVar7 = PTR_DAT_00577ea0;
  param_1[0x11] = 0;
  param_1[0x12] = 0;
  param_1[0x13] = 0;
  param_1[0x14] = 0;
  param_1[0x15] = 0;
  param_1[0x16] = 0;
  param_1[0x17] = 0;
  uVar13 = (ulong)(*param_3 >> 1);
  if ((*param_3 & 1) != 0) {
    uVar13 = *(ulong *)(param_3 + 8);
  }
  if ((uVar13 == 0) || (lVar10 = (**(code **)(*(long *)PTR_DAT_00577ea0 + 0x160))(), lVar10 == 0))
  goto LAB_00179c90;
  uVar13 = (ulong)(*param_3 >> 1);
  if ((*param_3 & 1) != 0) {
    uVar13 = *(ulong *)(param_3 + 8);
  }
  (**(code **)(*(long *)puVar7 + 0x150))(lVar10,0,uVar13);
  local_78 = 0;
  local_70 = 0;
  local_68 = 0;
  local_80 = 0;
  uVar13 = *(ulong *)(param_3 + 8);
  pbVar15 = *(byte **)(param_3 + 0x10);
  if ((*param_3 & 1) == 0) {
    pbVar15 = param_3 + 1;
    uVar13 = (ulong)(*param_3 >> 1);
  }
  FUN_00346764(pbVar15,uVar13,lVar10,&local_80);
  if (local_80 != 0) {
    FUN_0011ff98(&local_78,lVar10);
    lVar12 = 0;
    __s = (char *)((ulong)&local_60 | 4);
    local_60 = 0x2f3e2e3700000079;
    do {
      __s[lVar12] = __s[lVar12] ^ (char)lVar12 + 0x79U;
      lVar12 = lVar12 + 1;
    } while (lVar12 != 4);
    local_58 = local_58 & 0xffffffffffffff00;
    sVar11 = strlen(__s);
    iVar9 = FUN_001309e8(&local_78,0,4,__s,sVar11);
    if (iVar9 == 0) {
      local_60 = 0;
      local_58 = 0;
      local_50 = 0;
      uVar14 = (ulong)((byte)local_78 >> 1);
      uVar13 = uVar14;
      if ((local_78 & 1) != 0) {
        uVar13 = local_70;
      }
      if (uVar13 - 4 != 0) {
        FUN_00179e08(&local_60,uVar13 - 4);
        uVar14 = (ulong)((byte)local_78 >> 1);
      }
      uVar13 = (ulong)&local_78 | 5;
      uVar16 = (ulong)&local_78 | 1;
      if (((byte)local_78 & 1) != 0) {
        uVar13 = local_68 + 4;
        uVar16 = local_68;
        uVar14 = local_70;
      }
      FUN_0017977c(&local_60,uVar13,uVar16 + uVar14);
      FUN_00179d44(&local_98,&local_60);
      uVar13 = (long)local_90 - (long)local_98;
      if (7 < uVar13) {
        uVar14 = 0;
        do {
          uVar16 = (ulong)(uint)((int)uVar14 << 1);
          uVar17 = (ulong)((int)uVar14 << 1 | 1);
          uVar19 = *(uint *)(local_98 + uVar16 * 4);
          lVar12 = 0x44;
          uVar18 = *(uint *)(local_98 + uVar17 * 4);
          do {
            puVar1 = (uint *)(&DAT_0057c970 + lVar12);
            lVar12 = lVar12 + -4;
            uVar3 = *puVar1 ^ uVar19;
            *(uint *)(local_98 + uVar16 * 4) = uVar3;
            uVar19 = (*(int *)(&DAT_0057cdb8 + (ulong)(uVar3 >> 0x10 & 0xff) * 4) +
                      (&DAT_0057c9b8)[uVar3 >> 0x18] ^
                     *(uint *)(&DAT_0057d1b8 + (ulong)(uVar3 >> 8 & 0xff) * 4)) +
                     *(int *)(&DAT_0057d5b8 + (ulong)(uVar3 & 0xff) * 4) ^ uVar18;
            *(uint *)(local_98 + uVar16 * 4) = uVar19;
            *(uint *)(local_98 + uVar17 * 4) = uVar3;
            uVar18 = uVar3;
          } while (lVar12 != 4);
          *(uint *)(local_98 + uVar16 * 4) = uVar3;
          *(uint *)(local_98 + uVar17 * 4) = uVar19;
          uVar14 = uVar14 + 1;
          *(uint *)(local_98 + uVar17 * 4) = DAT_0057c974 ^ uVar19;
          *(uint *)(local_98 + uVar16 * 4) = _DAT_0057c970 ^ uVar3;
        } while (uVar14 < uVar13 >> 3);
      }
      if (local_90 == local_98) {
LAB_00179bc8:
        uVar14 = 0;
      }
      else {
        pbVar15 = local_98 + (uVar13 - 1);
        bVar4 = *pbVar15;
        uVar14 = (ulong)bVar4;
        if (7 < (byte)(bVar4 - 1)) goto LAB_00179bc8;
        uVar16 = 0;
        do {
          if (bVar4 != *pbVar15) goto LAB_00179bc8;
          uVar16 = uVar16 + 1;
          pbVar15 = pbVar15 + -1;
        } while (uVar16 < uVar14);
      }
      uVar16 = uVar13 - uVar14;
      if (uVar13 < uVar16) {
        FUN_00179e08(&local_98,-uVar14);
        puVar6 = local_98;
        puVar2 = local_90;
      }
      else {
        puVar6 = local_98;
        puVar2 = local_90;
        if (uVar16 < uVar13) {
          puVar2 = local_98 + uVar16;
          local_90 = puVar2;
        }
      }
      for (; puVar8 = local_90, puVar6 != local_90; puVar6 = puVar6 + 1) {
        local_90 = puVar2;
        FUN_00159f58(param_1,*puVar6);
        puVar2 = local_90;
        local_90 = puVar8;
      }
      pbVar15 = *(byte **)(param_1 + 0x10);
      local_a0 = 0;
      if ((*param_1 & 1) == 0) {
        pbVar15 = param_1 + 1;
      }
      local_90 = puVar2;
      FUN_003f5324(pbVar15,&local_a0);
      if (local_a0 != 0) {
        FUN_0011ff98(param_1,&DAT_004abd98,0);
      }
      if (local_98 != (undefined1 *)0x0) {
        local_90 = local_98;
        FUN_00478110();
      }
      if (local_60 != 0) {
        local_58 = local_60;
        FUN_00478110();
      }
    }
  }
  (**(code **)(*(long *)puVar7 + 0x168))(lVar10);
  if ((local_78 & 1) != 0) {
    FUN_00478110(local_68);
  }
LAB_00179c90:
  if (*(long *)(lVar5 + 0x28) != local_48) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}

