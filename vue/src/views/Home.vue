<template>
  <div style="padding: 20px">
    <div>
      <el-button type="primary" style="margin-left: 5px" @click="add">Add</el-button>
    </div>
    <br>
    <div>
      <el-input v-model="search" placeholder="Please input" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="load">search</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100vw">
      <el-table-column fixed prop="id" label="id" width="150" />
      <el-table-column prop="username" label="username" width="120" />
      <el-table-column prop="password" label="password" width="120" />
      <el-table-column prop="age" label="age" width="120" />
      <el-table-column prop="gender" label="gender" width="120" />
      <el-table-column prop="address" label="Address" width="600" />
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">Edit</el-button>
          <el-popconfirm title="Are you sure to delete it?" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button link type="primary" size="small">Delete</el-button>
            </template>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-pagination
          v-model:current-page="currentPage"
          :page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          :small="small"
          :disabled="disabled"
          :background="background"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
  <div>
    <el-dialog v-model="dialogVisible" title="Tips" width="30%" :before-close="handleClose">
    <el-form :model="form" label-width="120px">
<!--      <el-form-item label="id">-->
<!--        <el-input v-model="form.id" style="width: 80%"></el-input>-->
<!--      </el-form-item>-->
      <el-form-item label="username">
        <el-input v-model="form.username" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="password">
        <el-input v-model="form.password" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="age">
        <el-input v-model="form.age" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="gender">
        <el-radio-group v-model="form.gender">
          <el-radio label="male">Male</el-radio>
          <el-radio label="female">Female</el-radio>
          <el-radio label="unknown">Unknown</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="address">
        <el-input v-model="form.address" style="width: 80%"></el-input>
      </el-form-item>
    </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="save">Confirm</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
// @ is an alias to /src
import request from "@/utils/request";

export default {
  name: 'Home',
  data() {
    return {
      form: {},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      total: 0,
      pageSize: 10,
      tableData: [
      ]
    }
  },
  mounted() {

  },
  created() {
    this.load()
  },
  methods: {
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete(id) {
      console.log(id)
      request.delete("/user/" + id).then(res => {
        if(res.code === '0') {
          this.$message({
            type: "success",
            message: "Delete success"
          })
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
        this.load()
      })
    },
    load() { // 刷新表
      request.get("/user", {
        params:{
          pageNumber: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    add() {
      this.dialogVisible = true
      this.form = {}
    },
    save() {
      if(this.form.id){ // 更新
        request.put("/user", this.form).then(res => {
          console.log(res) // for debug
          if(res.code === '0') {
            this.$message({
              type: "success",
              message: "Edit success"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load()
            }
        )
      } else { // 新增
        request.post("/user", this.form).then(res => {
          console.log(res) // for debug
          if(res.code === '0') {
            this.$message({
              type: "success",
              message: "Add success"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
          this.load()
            }
        )
      }
      this.dialogVisible = false
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNumber) {
      this.currentPage = pageNumber
      this.load()
    }
  }
}
</script>
