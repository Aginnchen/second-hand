<template>
    <el-container>
      <el-header>
        <!-- 左侧logo -->
        <div class="logo"><img src="../assets/imgs/车图片.png" height="41" width="43"/>&nbsp;&nbsp;二手车交易管理系统</div>
        <!-- 个人中心 -->
        <div class="personal_center">
          <!-- 个人中心下拉框 -->
          <el-dropdown :hide-on-click="false"  @command="handleCommand">
            <span class="el-icon-s-custom">
            欢迎你：{{user.user_name}}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown" >
              <el-dropdown-item command="UserInfo">个人信息</el-dropdown-item>
              <el-dropdown-item command="EditUser">个人设置</el-dropdown-item>
              <el-dropdown-item command="exit">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        <!-- 查看个人信息对话框-->
        <el-dialog width="100%"
                   :fullscreen="true" title="个人信息">
          <userInfo></userInfo>
        </el-dialog>
        <!-- 修改个人信息对话框-->
        <el-dialog  width="100%"
                   title="修改个人信息">
          <!--向子组件传递operateSuccess方法-->
          <userSite @operateSuccess=""> </userSite>
        </el-dialog>
        </el-header>
      <!--侧菜单栏-->
      <el-container>

        <el-aside width="200px">
          <el-row class="tac">
            <!--<el-col :span="1">-->
              <el-menu  @select="Automobile">
                <el-menu-item index="1" >
                  <i class="el-icon-s-home"></i>
                  <span slot="title">车品展示</span>
                </el-menu-item>

                <el-menu-item index="2">
                  <i class="el-icon-menu"></i>
                  <span slot="title">汽车信息</span>
                </el-menu-item>
                <el-menu-item index="3" >
                  <img src="../assets/imgs/车辆列表.png" height="20" width="25"/>
                  <span slot="title">购买汽车</span>
                </el-menu-item>
                <el-menu-item index="4">
                  <i class="el-icon-document"></i>
                  <span slot="title">用户订单</span>

                </el-menu-item>
                <el-menu-item index="5">
                  <i class="el-icon-setting"></i>
                  <span slot="title">问题反馈</span>
                </el-menu-item>
              </el-menu>
            <!--</el-col>-->
          </el-row>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>

</el-container>
</template>

<script>
  import {mapGetters, mapMutations} from 'vuex'
  export default {
    data() {
      return {
users:{
  user_account:''

}
      };
    },
    computed: {
      ...mapGetters(
        ['isLogin', 'user']
      )
    },
    methods: {

      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      goTo(path) {
        this.$router.replace(path);
      },

      //跳转路径
      Automobile(index){
        console.log(index)
        //定义Map
        let map =new Map()
        map.set('1', '/Automobile')
        map.set('2', '/Demo')
        map.set('3', '/Purchase')
        map.set('4', '/Interface')
        map.set('5', '/Problem')
      //  跳转路径
        let routeUrl =map.get(index);
        this.$router.push(routeUrl)
      },
      handleCommand(value){
        switch(value){
          case 'UserInfo':
            //打开查看个人信息对话框
            console.log('UserInfo')
            this.$router.push("/UserInfo")
            break;
          case 'EditUser':
            //打开修改个人信息对话框
            console.log('EditUser')
            this.$router.push("/EditUser")
            break;
          case 'exit':
            //清空缓存数据
            sessionStorage.removeItem('UIAS'),
              sessionStorage.removeItem('user_id')
            this.$router.push('/')
            break;

        }
      },
    }


  };
</script>

<style >
  *{
    margin: 0px;
    padding: 0px;
  }
  html,body {
    width: 100%;
    height: 100%;
  }

  /* 设置整体高度 */
  .body{
    height:100%;
  }
  /* 给el容器设置100%的高度 */
  .el-container{
    height: 100%;
  }
  .el-aside{
    width: 30%;
    height: 100%;
    text-align: center;
    border-right:1px solid #E6E6E6;
  }
  /* 给头部标签设置下边框和为0的内边距 */
  .el-header{
    border-bottom:1px solid #E6E6E6;
    /*background-color: cyan;*/
    width: 100%;
    height: 100%;
    padding: 0;
  }
  /* 设置logo字体样式 */
  .el-header>.logo,.el-header>.personal_center{
    /* 字体颜色 */
    color: #409EFF;
    /* 设置宽高 */
    width:200px;
    height:100%;
    /* 声明为弹性盒子,以及弹性盒子的居中效果 */
    display: flex;
    justify-content: center;
    align-items: center;
    /* 左浮动 */
    float: left;
  }
  /* 给个人信息下拉框设置右浮动 */
  .el-header>.personal_center{
    /* 设置div右浮动 */
    float: right;
    /* 设置div右边距 */
    margin-right: 30px;
    /* 高度自适应 */
    width: auto;
  }
  .el-icon-s-custom:hover{
    color: #409EFF;
  }
  /* 下拉框鼠标悬浮时的样式 */
.el-dropdown-link:hover{
    /* 下拉框字体颜色 */
    color: #409EFF;
    /* 光标悬浮样式 */
    cursor: pointer;
    /* 颜色渐入 */
    transition-duration:0.5s;
  }
/**/
  .el-main{
    padding: 0px;

  }
</style>
