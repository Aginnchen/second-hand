<template>
  <!--角色管理-->
  <!--用户操作-->
  <div class="AA">
    <!--用户操作栏-->
    <div class="div1">
      <el-row :gutter="10">
        <el-col  :span="5">
          <el-input  size="small" placeholder="请输入用户姓名" v-model="user_name"> </el-input>
        </el-col>
        <el-col  :span="5">
          <el-input  size="small"placeholder="请输入用户电话号码" v-model="phone">
          </el-input>
        </el-col>
        <el-col  :span="2">
          <el-button size="small" type="primary" @click="search">搜索</el-button>
        </el-col>
        <!--type="success" icon="el-icon-plus"-->
        <el-button class="fl" size="small"  @click="openAddUser">添加用户</el-button>
      </el-row>
      <el-row>
        <el-table :data="CarData">
          <el-table-column type="selection" width="50px"></el-table-column>
          <el-table-column label="账号" prop="user_account"></el-table-column>
          <el-table-column label="姓名" prop="user_name"></el-table-column>
          <el-table-column label="密码" prop="user_password"></el-table-column>
          <el-table-column label="手机号" prop="phone"></el-table-column>
          <el-table-column label="性别" prop="sex"></el-table-column>

          <el-table-column label="注册时间" prop="create_time"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="text"  @click="modificationUser(scope.row)">修改</el-button>
              <el-button type="text" @click="userdel(scope.row)" >删除</el-button>
           
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="changeMaxSize"
          @current-change="changePageSize"
          :current-page="1"
          :page-sizes="[10, 50, 100, 200, 400]"
          :page-size="10"
          layout="total,sizes,prev,pager,next,jumper"
          :total="total"
        ></el-pagination>
      </el-row>
      <el-dialog title="修改用户" :visible.sync="isAddDialog" width="40%">
        <el-form :model="params">
          <el-form-item label="账号">
            <el-input size="medium" placeholder="请输入账号" v-model="params.user_account" ></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input size="medium" placeholder="请输入姓名" v-model="params.user_name"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input size="medium" placeholder="请输入密码" v-model="params.user_password"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input size="medium" placeholder="请输入电话号码" v-model="params.phone"></el-input>
          </el-form-item>
          <el-form-item label="注册时间">
            <el-input size="medium" placeholder="请输入注册时间" v-model="params.create_time"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="modification">提交</el-button>
        </div>
      </el-dialog>
      <!--新增-->
      <el-dialog title="新增用户" :visible.sync="increased" width="40%">
        <el-form :model="params">
          <el-form-item label="账号">
            <el-input size="medium" placeholder="请输入账号" v-model="params.user_account" ></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input size="medium" placeholder="请输入姓名" v-model="params.user_name"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input size="medium" placeholder="请输入密码" v-model="params.user_password"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input size="medium" placeholder="请输入电话号码" v-model="params.phone"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-input size="medium" placeholder="请输入性别" v-model="params.sex"></el-input>
          </el-form-item>
          <el-form-item label="注册时间">
            <el-input size="medium" placeholder="请输入注册时间" v-model="params.create_time"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary"@click="increasedUser">提交</el-button>
        </div>
      </el-dialog>
    </div>

  </div>
</template>

<script>
  import http from '@/utils/HttpUtil'
  export default {
    data () {
      return {
        action: {
          //分页查询
          userList: ' projetsystem/user/selectAllUser',
          // //删除
          userdel: 'projetsystem/user/deleteUser/',
          // //修改
          modification:'projetsystem/user/updateadminUser',
          // //  根据id查询
          inquire:'projetsystem/user/selectPersonById/',
          // //  新增
          addUser:'projetsystem/user/addUser'
        },
        curr_page: 1,
        page_size: 10,
        total: 580,
        CarData: [],
        user_name: '',
        phone:'',
                   params:{
          user_id:null,
          user_name:'',
          phone:'',
          user_account:'',
          user_password:'',
          sex:'',
          create_time:'',
        },
        //新增
        increased: false,
        //修改
        isAddDialog: false
      }
    },
    components: {

    },
    mounted () {
      this.getUserList()
    },
    methods: {
      getUserList (user_name = null, phone = null, curr_page = 1, page_size = 10) {
        const params = {
          'curr_page': curr_page,
          'page_size': page_size
        }
        if (user_name !== null && user_name !== '') {
          params['user_name'] = user_name
        } if (phone !== null && phone !== '') {
          params['phone'] = phone
        }
        http.xhrGet(this, this.action.userList, params, (res) => {
          this.total = res.data.total
          this.curr_page = res.data.curr_page
          this.page_size = res.data.pageSize
          this.CarData = res.data.list
        })
      },
      // page-size:返回PageSizes
      changeMaxSize (pagesize) {
        this.getUserList(this.user_name, this.phone, this.curr_page, pagesize)
      },
      // 改变页码时
      changePageSize (currpage) {
        this.getUserList(this.user_name, this.phone, currpage, this.page_size)
      },
      search () {
        let user_name = this.user_name
        let phone = this.phone
        this.getUserList(user_name, phone, 1, 10)
      },
      userdel (row) {
        this.$confirm('您确定要删除当前记录吗？', {
          confirmButtonText: '确定',
          cancelButtonText: '取消'
        }).then(() => {
          this.xhrDelete(row.user_id)
        })
      },
      xhrDelete (ids) {
        http.xhrPost(this, this.action.userdel + '/' + ids, null, (res) => {
          this.$message({
            type: 'success',
            message: res.message
          })
          this.getUserList(this.user_name, this.phone, this.curr_page, this.page_size)
        }, 'delete')
      },
      // //新增

      // 打开新增用户对话框
      openAddUser () {
        this.increased = true
      },
      // 新增用户
      increasedUser () {
        let params = {
          phone: this.params.phone,
          user_name: this.params.user_name,
          user_account: this.params.user_account,
          user_password: this.params.user_password,
          sex: this.params.sex,
          create_time: this.params.create_time,
        }
        http.xhrPost(this, this.action.addUser, params, (res) => {
          // 给出提示，新增成功，关闭抽屉，清空表单
          this.$message({
            type: 'success',
            message: res.message
          })
          this.increased = false
          this.getUserList()
          // 表单重置
          this.params = {
            user_name: '',
            phone: '',
            user_account: '',
            user_password: '',
            sex: '',
            create_time: '',
          }
        })
      },

      // 打开修改用户对话框
      modificationUser (params) {
        this.isAddDialog = true
        // console.log(params.brand_id)
        http.xhrGet(this, this.action.inquire + '/' + params.user_id, null, (res) => {
          // console.log(res)
          this.params.user_id = res.data.user_id
          this.params.user_account = res.data.user_account
          this.params.user_name = res.data.user_name
          this.params.user_password = res.data.user_password
          this.params.phone = res.data.phone
          this.params.sex = res.data.sex
          this.params.create_time = res.data.create_time

        })
      },
      // 修改用户
      modification () {
        const params = this.params
        console.log(params)
        http.xhrPost(this, this.action.modification, params, (res) => {
          console.log(res)
          // 给出提示，新增成功，关闭抽屉，清空表单
          this.$message({
            type: 'success',
            message: res.message
          })
          this.isAddDialog = false
          this.getUserList()
        })
      }
    }
  }
</script>

<style >
  <!--背景颜色-->
  html,body {
    width: 100%;
    height: 100%;
  }
  .AA{
    width: 100%;
    height: 100%;
    background-color: #f5f5f7;
  }
  .div1{
    padding-top: 20px;
  }
</style>
