<template>
  <div class="body2" >
    <el-row type="flex" justify="center" align="middle" class="row" >
      <!-- 注册面板 -->
      <el-col :span="5" class="form_body1"

              :xs="12" :xl="4" :md="5">
        <!-- 注册板表单 -->
        <el-form size="small" :rules="rules"
                 :model="user" ref="user">
          <el-form-item>
            <span class="system_title">二手车交易注册系统</span>
            <span class="system_title1">一流的动力，二手的惊喜</span>
          </el-form-item>      <i class="el-icon-lock" slot="prefix"></i>
          <el-form-item prop="phone">

            <el-input type="text"   placeholder="请输入手机号" v-model="user.phone" clearable>
              <i class="iconfont icon-yonghuming" slot="prefix"></i>
            </el-input>
          </el-form-item>
          <el-form-item prop="user_name">
            <el-input type="text"   placeholder="请输入姓名" v-model="user.user_name" clearable>
              <i class="iconfont icon-yonghuming" slot="prefix"></i>
            </el-input>
          </el-form-item>
          <el-form-item prop="user_account">
            <el-input type="text"   placeholder="请输入账号" v-model="user.user_account" clearable>
              <i class="iconfont icon-yonghuming" slot="prefix"></i>
            </el-input>
          </el-form-item>
          <el-form-item prop="user_password">
            <el-input type="password" placeholder="请输入密码" v-model="user.user_password" clearable show-password>
              <i class="iconfont icon-mima" slot="prefix"></i>
            </el-input>
          </el-form-item>
          <el-form-item>
          <el-col :span="40">
            <el-form-item label="性别:" prop="sex">
              <el-radio-group v-model="user.sex">
                <el-radio label="保密">保密</el-radio>
                <el-radio label="男">男</el-radio>
                <el-radio label="女">女</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       style="width: 100%;"
                       @click="addUser('user')">注册</el-button>
          </el-form-item>

        </el-form>
      </el-col>
    </el-row>



  </div>
</template>

<script>
  import httpUtil from '../utils/HttpUtil.js'

  export default {
    data () {
      return {
        user: {
          user_account: '',
          user_name: '',
          user_password: '',
          phone:'',
          sex:''
        },
        user: {
          user_account: ''
        },
        rules: {
          sex: [{
            sex: true, message: '请输入性别', tigger: 'blur'  },
          ],
          phone: [{
            required: true, message: '请输入手机号', tigger: 'blur'  },
        ],
          user_name: [{
            required: true, message: '请输入用户名', tigger: 'blur'
          }],
          user_password: [{
            required: true, message: '请输入正确的密码', tigger: 'blur'
          },
          ],
          user_account:[{
            required: true, message: '请输入账号，账号和手机号必须一致', tigger: 'blur'
          }]
        },
        action: {
          addUser: 'projetsystem/user/addUser'
        }
      }
    },
    components: {

    },
    mounted () {
    },
    methods: {
      addUser(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let params = {
              user_account: this.user.user_account,
              user_name: this.user.user_name,
              user_password: this.user.user_password,
              phone: this.user.phone,
              sex: this.user.sex
            }
            httpUtil.xhrPost(this, this.action.addUser, params, data => {
              console.log("数据",data);
              this.$message({
                type: 'success',
                message: '注册成功,跳转登录页面',
                duration: 1000
              })
              this.$router.push('/')
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },


    }
  }
</script>
<style>
  .body2{

    width:100%;
    height:100%;

  }
  row{
    width:100%;
    height:100%;
  }
  login_bg{
    width:100%;
    height:100%;
    background-size: 100% 100%;
  }
  .form_body1{
    /* 绝对定位 */
    margin-top: 120px;    /* 自适应高度 */
    height:auto;
    /* 背景颜色 */
    background-color: #fff;
    /* 上边框 */
    /*border-top:5px #409eff solid;*/
    /* 圆角 */
    border-radius:5px;
    /* 阴影 */
    box-shadow: 1px 1px 5px rgba(0,0,0,0.5);
    /* 内边距 */
    padding: 10px 20px 10px 20px;
background-color: white;
  }
  .system_title{
    /* 声明标签为弹性盒子 */
    display: flex;
    /* 设置主轴和侧轴的对齐方式 */
    justify-content: center;
    align-items: center;
    /* 设置字体大小和字体颜色 */
    font-size:16px;
    color:#409EFF;
  }
  /*一流的动力，二手的惊喜*/
  .system_title1{
    display: flex;
    justify-content: center;
    align-items: center;
    color:#409EFF;
    font-size: 10px;
  }


  /*忘记密码*/
  .right{

    margin-left: auto;
    color: black;
    text-decoration: none;
  }
  /*.form_body .iconfont{*/
  /*!* 竖向对齐 *!*/
  /*vertical-align: middle;*/
  /*!* 右边间距 *!*/
  /*margin-right:2px;*/
  /*!* 颜色 *!*/
  /*color:#409EFF;*/
  /*}*/
</style>
