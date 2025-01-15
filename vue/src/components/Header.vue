<template>
  <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color: deepskyblue">DJFLP Box Pro</div>
    <div style="flex: 1">东郊飞利浦大学</div>
    <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
      <el-dropdown>
        <span class="el-dropdown-link">
          Login or Register
          <i class="el-icon-arrow-down el-icon--right"></i>
        <el-icon class="el-icon--right">
          <arrow-down/>
        </el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>Action 1</el-dropdown-item>
            <el-dropdown-item>Action 2</el-dropdown-item>
            <el-dropdown-item>Action 3</el-dropdown-item>
            <el-dropdown-item disabled>Action 4</el-dropdown-item>
            <el-dropdown-item divided>Action 5</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="js" setup>

export default {
  name: "Header"
}
</script>