<template>
  <!-- 购买界面 -->
  <div class="purchase">
<div class="purchase1">
  <img src="../assets/imgs/大众.jpg" height="192" width="340"/>
  <div class="brand"><p >品牌：大众</p></div>
<div class="particulars"><p >详情：大众 途观 2015款 1.8TSI 自动两驱豪华型</p></div>
  <div class="configuration"> <p >配置：发动机1.8T/160马力/L4 级别：紧凑型SUV</p></div>
  <div class="price"> <p >价格：18.7万</p></div>
  <div class="payment" >  <el-button type="primary" round @click="openAddUser">确认付款</el-button> </div>
</div>
    <div class="purchase2">
      <img src="../assets/imgs/jeep.jpg" height="210" width="340"/>
      <div class="brand2"><p >品牌：Jeep</p></div>
      <div class="particulars2"><p >详情：Jeep 自由光 2017款 2.4L 领先版</p></div>
      <div class="configuration2"> <p >配置：发动机级别2.4L/175马力/级别:中型SUV</p></div>
      <div class="price2"> <p >价格：15.37万</p></div>
      <div class="payment2" >  <el-button type="primary" round @click="openAddUser">确认付款</el-button> </div>
    </div>
    <div class="purchase3">
      <img src="../assets/imgs/奥迪.jpg" height="192" width="340"/>
      <div class="brand3"><p >品牌：Jeep</p></div>
      <div class="particulars3"><p >详情：Jeep 自由光 2017款 2.4L 领先版</p></div>
      <div class="configuration3"> <p >配置：发动机级别2.4L/175马力/级别:中型SUV</p></div>
      <div class="price3"> <p >价格：15.37万</p></div>
      <div class="payment3" >  <el-button type="primary" round @click="openAddUser" >确认付款</el-button> </div>
    </div>
    <div class="purchase4">
      <img src="../assets/imgs/比亚迪.jpg" height="192" width="340"/>
      <div class="brand4"><p >品牌：比亚迪</p></div>
      <div class="particulars4"><p >详情：比亚迪L3 2013款 1.5L 自动舒适型</p></div>
      <div class="configuration4"> <p >配置：发动机级别1.5L/109马力/L4级别:紧凑型车</p></div>
      <div class="price4"> <p >价格：15.37万</p></div>
      <div class="payment4" >  <el-button type="primary" round  @click="openAddUser">确认付款</el-button> </div>
    </div>
<!--购买新增-->
    <el-dialog title="购买" :visible.sync="increased" width="40%">
      <el-form :model="params">

        <el-form-item label="订单品牌">
          <el-input size="medium" placeholder="请输入品牌" v-model="params.brand"></el-input>
        </el-form-item>
        <el-form-item label="订单金额">
          <el-input size="medium" placeholder="请输入金额" v-model="params.money"></el-input>
        </el-form-item>

        <el-form-item label="订单姓名">
          <el-input size="medium" placeholder="请输入订单姓名" v-model="params.user_name"></el-input>
        </el-form-item>
        <el-form-item label="订单时间">
          <el-input size="medium" placeholder="请输入付款时间" v-model="params.order_time"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary"@click="increasedUser">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import http from '@/utils/HttpUtil'
    export default {
      data() {
        return {
          action: {
            addUser: 'projetsystem/Orded/addOrded'
          },
          params: {
            order_id: null,

          },

          //新增
          increased: false,
        }

      },
      components: {},
      mounted() {

      },
      methods: {
        //新增

        // 打开新增用户对话框
        openAddUser () {
          this.increased = true
        },
        // 购买
        increasedUser () {
          let params = {
            brand: this.params.brand,
            user_name: this.params.user_name,
            quantity: this.params.quantity,
            money: this.params.money,
            order_time: this.params.order_time,
          }
          http.xhrPost(this, this.action.addUser, params, (res) => {
            // 给出提示，购买成功，关闭抽屉，清空表单
            this.$message({
              type: 'success',
              message: res.message
            })
            this.increased = false

            // 表单重置
            this.params = {
              brand: '',
              user_name: '',
              money: '',
              quantity: '',
              money: '',
              order_time: ''
            }
          })
        },
      }
    }
</script>

<style >
  *{
    margin: 0px;
    padding: 0px;
  }
  .purchase1{
    width:45%;
   height: 200px;
    background-color:#f5f5f7;
  }
  /*品牌*/
  .brand{
    text-decoration: none;
    float: right;
   margin-right: 270px;
  }
  /*详情*/
  .particulars{
    text-decoration: none;
    float: right;
    margin-top: -150px;
    margin-right: 10px;
  }
  /*配置*/
  .configuration{
    text-decoration: none;
    float: right;
    margin-top: -110px;
    margin-right: 0px;
  }
  /*价格*/
  .price{
    text-decoration: none;
    float: right;
    margin-top: -60px;
    margin-right: 260px;
  }
/*确认*/
  .payment{
    text-decoration: none;
    float: right;
    margin-top: -40px;
  }
  /*第二个*/
  .purchase2{
    text-decoration: none;
    float: right;
    margin-top: -13.1%;
   margin-right: 90px;
    width:45%;
    height: 220px;
    background-color:#f5f5f7;
  }
  /*品牌*/
  .brand2{
    text-decoration: none;
    float: right;
    margin-right: 270px;
  }
  /*详情*/
  .particulars2{
    text-decoration: none;
    float: right;
    margin-top: -150px;
    margin-right: 70px;
  }
  /*配置*/
  .configuration2{
    text-decoration: none;
    float: right;
    margin-top: -110px;
    margin-right: 20px;
  }
  /*价格*/
  .price2{
    text-decoration: none;
    float: right;
    margin-top: -60px;
    margin-right: 250px;
  }
  /*确认*/
  .payment2{
    text-decoration: none;
    float: right;
    margin-top: -40px;
  }
  /*第三*/
  .purchase3{
    margin-top: 20px;
    width:45%;
    height: 200px;
    background-color:#f5f5f7;
  }
  /*品牌*/
  .brand3{
    text-decoration: none;
    float: right;
    margin-right: 270px;
  }
  /*详情*/
  .particulars3{
    text-decoration: none;
    float: right;
    margin-top: -150px;
    margin-right: 70px;
  }
  /*配置*/
  .configuration3{
    text-decoration: none;
    float: right;
    margin-top: -110px;
    margin-right: 20px;
  }
  /*价格*/
  .price3{
    text-decoration: none;
    float: right;
    margin-top: -60px;
    margin-right: 250px;
  }
  /*确认*/
  .payment3{
    text-decoration: none;
    float: right;
    margin-top: -40px;
  }
  /*第4*/
   /*第二个*/
  .purchase4{
    text-decoration: none;
    float: right;
    margin-top: -11.5%;
    margin-right: 90px;
    width:45%;
    height: 200px;
    background-color:#f5f5f7;
  }
  /*品牌*/
  .brand4{
    text-decoration: none;
    float: right;
    margin-right: 260px;
  }
  /*详情*/
  .particulars4{
    text-decoration: none;
    float: right;
    margin-top: -150px;
    margin-right: 63px;
  }
  /*配置*/
  .configuration4{
    text-decoration: none;
    float: right;
    margin-top: -110px;
    margin-right: 5px;
  }
  /*价格*/
  .price4{
    text-decoration: none;
    float: right;
    margin-top: -60px;
    margin-right: 255px;
  }
  /*确认*/
  .payment4{
    text-decoration: none;
    float: right;
    margin-top: -40px;
  }
</style>
