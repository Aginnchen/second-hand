<template>
<!-- 个人信息页面 -->
<div>
  <!-- 步骤条 -->
  <el-steps direction="vertical" :active="2">
    <!-- 第一步:个人信息 -->
    <el-step title="个人信息">
      <template slot="icon">
        <i class="el-icon-edit"></i>

      </template>
      <!-- 图标 -->



      <!-- 描述(内容) -->
      <template slot="description">
        <!-- 卡片 -->  <el-button type="text" class="tuichu" @click="tuichu()">退出</el-button>
        <el-card shadow="hover" :body-style="{'padding-top':5,'padding-bottom':4}">
          <el-form>
            <el-row>
              <el-col :span="6">
                <el-form-item label="姓名:">
                  {{user.user_name}}
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="账号:">
              {{user.user_account}}
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="性别:">
                  {{user.sex}}
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6">
                <el-form-item label="手机号:">
{{user.phone}}
                </el-form-item>
              </el-col>

              <el-col :span="6">
                <el-form-item label="注册时间:">{{user.create_time}}
                </el-form-item>

              </el-col>
              <el-col :span="6">
                <el-form-item label="简介:">
快乐的一天
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-card>
      </template>

    </el-step>

    <el-step title="完">
      <template slot="icon">
        <i class="el-icon-edit"></i>
      </template>
    </el-step>
  </el-steps>
</div>
</template>

<script>
  import {mapGetters, mapMutations} from 'vuex'
  export default {
    data(){
      return{
        users:{
          user_account:'',

        }
      }
    },
    computed: {
      ...mapGetters(
        ['isLogin', 'user']
      )
    },
    methods: {

      tuichu(){
        this.$router.push("/Index")
      }
    },


  }
</script>

<style scoped>
.personal{
background-color: cyan;
  width: 100%;
  height: 400px;
}

  /*.el-form-item{*/
    /*position: relative;*/
   /*top: 40px;*/

  /*}*/
.tuichu{
  position: relative;
  /*靠右*/
right: -100%;
font-size: 20px;
  /*display: inline;*/
  /*float: right;*/
}
.tuichu:hover{
  color: #a6a9ad;
}
</style>
