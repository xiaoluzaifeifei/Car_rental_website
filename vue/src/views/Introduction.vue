<template>
  <div style="width: 800px; margin: 150px auto">
    <div>
      <img src="../assets/test.jpg">
    </div>
    <div>专业团队，匠心制作</div>
    <br>
    <div>
      <el-button @click="login">点击登录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Introduction",
  methods: {
    login() {
      this.$router.push("/login")
    }
  }
}
</script>

<style scoped>

</style>