<template>
  <div>
    <span class="span1">个人修改</span>
    <el-form label-width="100px" :model="params">
      <el-row>
        <el-col :span="6">
          <el-form-item label="账号">
            <el-input  placeholder="请输入账号" v-model="params.user_account"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="姓名">
            <el-input placeholder="请输入姓名" v-model="params.user_name"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="手机号" >
            <el-input  placeholder="请输入手机号" v-model="params.phone"></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
      <el-col :span="24">
      <el-form-item class="btns">
      <el-button @click="updateUser" >确定</el-button>
      <el-button  @click="quexiao()">取消</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
  import http from '@/utils/HttpUtil'
  export default {
    data () {
      return {
        action: {
          polling:'projetsystem/user/selectPersonById',
          updateUser: 'projetsystem/user/updateUser'
        },
        params: {
          user_id: null,
          user_account: '',
          user_name: '',
          phone: ''
        }
      }
    },
    mounted () {
      this.polling()
    },
        methods: {
          // 显示原来数据
          polling () {
            this.params.user_id = sessionStorage.getItem("user_id")
            let user_id = this.params.user_id
            http.xhrGet(this, this.action.polling + '/' + user_id, null, (res) => {
              // console.log(res)
              this.params.user_account = res.data.user_account
              this.params.user_name = res.data.user_name
              this.params.phone = res.data.phone
            })
          },
          // 修改
          updateUser () {
            const params = this.params
            http.xhrPost(this, this.action.updateUser, params, (res) => {
              this.$message({
                type: 'success',
                message: "修改信息成功跳转首页",
                // duration: 2000
              })
              this.$router.push("/Index")
            })
          },
          quexiao() {
            this.$router.push("/Index")
          }
        }
      }
</script>

<style>
  .span1{
    position: absolute;
    font-size: 20px;
margin-top: -40px;

  }
.el-form{
  margin-top: 60px;
}
</style>
