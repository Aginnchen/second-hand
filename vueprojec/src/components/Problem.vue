<template>

  <div class="dcontent">
    <br/>

    <br/>
    <ul class="dlist">
      <li class="ditem1"><a style="text-decoration:none;color:#666;display:block" href="tel:17674703681">
        <el-button type="primary" round style="width: 160px"><i class="el-icon-phone-outline"></i>拨打投诉电话</el-button></a></li>
      <li class="ditem"><a style="text-decoration:none;color:#666;display:block" href="mailto:service@dcloud.io">
        <el-button type="primary" round style="width: 160px"> <i class="  el-icon-s-promotion"></i>  发送投诉邮件</el-button></a></li>
    </ul>

  </div>

</template>
<script >
  import { realconsolee } from '../assets/js/common.js'
  import { realconsole } from '../assets/js/immersed.js'
  export default {
    methods:{
      methods1:function(){
        realconsole();
        realconsolee();
      }
    }}

  function addachmentMail(){
    outSet("发送带附件邮件：")
    var msg = plus.messaging.createMessage(plus.messaging.TYPE_EMAIL);
    msg.to = ['service@dcloud.io'];
    msg.body = 'This is an example mail';
    plus.messaging.sendMessage( msg );
  }
  function htmlMail(){
    outSet("发送HTML邮件：");
    if ( plus.os.name == "iOS" ) {
      var msg = plus.messaging.createMessage(plus.messaging.TYPE_EMAIL);
      msg.to = ["service@dcloud.io"];
      msg.bodyType = "vue";

      outLine("支持");
    } else {
      outLine("此平台不支持发送HTML邮件功能！");
      plus.nativeUI.alert("此平台不支持发送HTML邮件功能！");
    }
  }
</script>

<style >

  * {
    margin: 0;
    padding: 0;
  }
  .dcontent{
    height: 100%;
    height: 100%;
    background-color: #f5f5f7;

  }
  li{ list-style: none;
    text-align: center;

  }
  .ditem{
    margin-top: 60px;
  }
</style>
