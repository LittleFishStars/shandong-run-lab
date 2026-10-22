
void FUN_00178090(void)

{
  undefined8 *puVar1;
  undefined8 uVar2;
  
  if (DAT_0057d9b8 == (undefined8 *)0x0) {
    puVar1 = (undefined8 *)FUN_004780a8(0x10);
    uVar2 = *(undefined8 *)PTR_DAT_00577ea0;
    DAT_0057d9b8 = puVar1;
    *puVar1 = &PTR_FUN_0056e7c0;
    puVar1[1] = uVar2;
  }
  return;
}

