<template>
  <div class="body" >
    <el-row type="flex" justify="center" align="middle" class="row" >
      <!-- 登录面板 -->
      <el-col :span="5" class="form_body"

              :xs="12" :xl="4" :md="5">
        <!-- 登录面板表单 -->
        <el-form size="small" :rules="rules"
                 :model="user" ref="user">
          <el-form-item>
            <span class="system_title">二手车交易登录系统</span>
            <span class="system_title1">一流的动力，二手的惊喜</span>
          </el-form-item>      <i class="el-icon-lock" slot="prefix"></i>
          <el-form-item prop="user_account">

            <el-input type="text"   placeholder="请输入账号" v-model="user.account" clearable>
              <i class="iconfont icon-yonghuming" slot="prefix"></i>
            </el-input>
          </el-form-item>
          <el-form-item prop="user_password">
            <el-input type="password" placeholder="请输入密码" v-model="user.password" clearable show-password>
              <i class="iconfont icon-mima" slot="prefix"></i>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       style="width: 100%;"
                       @click="login('user')">登录</el-button>
          </el-form-item>
          <el-checkbox >勾选同意 </el-checkbox>
          <a class="forgetLink" href="https://wenku.baidu.com/view/16ae569002d8ce2f0066f5335a8102d276a261e8.html" >《用户服务协议》</a>
          <el-form-item>
            <span style="margin-left:10px;font-size: 13px; color:#409EFF; ">推荐浏览器:</span>
            <a href="www.360.com" class="ChromeAndFireFox">
              <i class="icon-iconset0284 iconfont"></i>
              360浏览器
            </a>
            <a href="www.Firwfox.com" class="ChromeAndFireFox">
              <i class="iconfont icon-huohu"></i>
              火狐
            </a>
          </el-form-item>
          <a class="right" @click="register">注册账号</a>
        </el-form>
      </el-col>
    </el-row>



  </div>
</template>

<script>
  import httpUtil from '../utils/HttpUtil.js'
  import { mapMutations } from 'vuex'
  export default {
    data () {
      return {
        user: {
          account: '',
          password: ''
        },
        rules: {
          user_account: [{
            required: true, message: '请输入用户名必须为11位手机号', tigger: 'blur'
          },
          ],
          user_password: [{
            required: true, message: '请输入正确的密码', tigger: 'blur'
          }]
        },
        action: {
          login: 'projetsystem/user/login'
        }
      }
    },
    components: {

    },
    mounted () {
    },
    methods: {
      ...mapMutations(
        ['saveLoginInfo', 'changeLoginState']
      ),

      login (refName) {
        let params = {
          account: this.user.account,
          password: this.user.password
        }
        httpUtil.xhrPost(this, this.action.login, params, res => {
          let user = res.data
          console.log(user)
          // eslint-disable-next-line camelcase
          let param = (({user_id, user_account, user_name, phone,sex,create_time}) =>
            ({user_id, user_account, user_name, phone,sex,create_time}))(user)
          this.saveLoginInfo(param)
          this.changeLoginState(1)
          sessionStorage.setItem("user_id", user.user_id)
          this.$message({
            type: 'success',
            message: '登录成功，即将跳转页面',
            duration: 1000
          })
          this.$router.push('/Index')
        })
      },
      //注册
      register(){
        this.$router.push('/Register')
      },
    //获取公钥模板
    getRsaJsKey(callback){
      //通过axios原生请求,获取公钥模板
      axios.get(this.actions.getRSAKey).then(data =>{
        callback(data.data)
      },(error)=>{
        //请求失败后,通过消息提示显示错误信息
        this.$message.error('获取公钥模板失败'+error)
      })
    },
    //取到公钥模板后,根据模板和密码(明文),生成密文
    getCipher(password,callback){
      //直接调用公钥模板方法，获取模板
      this.getRsaJsKey(data =>{
        let keyArr=data.split(';')
        let keyModel=keyArr[0]
        let keyExponent=keyArr[1]
        //通过加密工具类生成密钥
        const publicKey=RSAUtils.getKeyPair(
          keyExponent,'',keyModel)
        //将密码顺序颠倒
        password=password.split('').reverse().join('')
        //通过公钥和颠倒的密码生成一个密文
        callback(RSAUtils.encryptedString(publicKey,password))
      })
    }
  }

  }
</script>
<style>
  .body{

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
  .form_body{
    /* 绝对定位 */
margin-top: 160px;    /* 自适应高度 */
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
    padding: 40px 20px 50px 20px;
    /*background-color: #409EFF;*/
    background: url("../assets/imgs/2.jpg") ;
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
    color: white;
 font-size: 10px;
  }

  .forgetLink{
    text-decoration: none;
    color: #909399;
  }
  .ChromeAndFireFox{
    /* 字体大小 */
    font-size: 13px;
    /* 左边距 */
    margin-left: 10px;
    /* 字间距 */
    letter-spacing: 2px;
    /* 字体颜色 */
    color:#909399;
    /*去除超链接下划线 */
    text-decoration: none;
  }
  /*忘记密码*/
.right{
  /*position: absolute;*/
margin-left: auto;
  color: #909399;
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
