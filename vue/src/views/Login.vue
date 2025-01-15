<template>
  <div style="width: 100%; height: 100vh; overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
      <el-form
          ref="formRef"
          :model="form"
          status-icon
          :rules="rules"
          label-width="120px"
          class="demo-form"
      >
        <el-form-item label="Username">
          <el-input v-model="form.username" type="username" />
        </el-form-item>
        <el-form-item label="Password">
          <el-input v-model="form.password" type="password" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(formRef)"
          >Submit</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Login",
  data() {
    return {
      form: {},
      dialogVisible: true
    }
  },
  methods: {
    login() {
      this.$router.push("/home")
    },
    submitForm() {
      request.post("/user/login", this.form).then(res => {
            console.log(res) // for debug
            if(res.code === '0') {
              this.$message({
                type: "success",
                message: "Login success"
              })
              this.login()
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          }
      )
    }
  }
}

</script>

<style scoped>

</style>