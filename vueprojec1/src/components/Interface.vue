<template>
  <!--汽车信息界面-->
  <!--用户操作-->
  <div class="AA">
    <!--用户操作栏-->
    <div class="div1">
      <el-row :gutter="10">
        <el-col  :span="5">
          <el-input  size="small" placeholder="请输入品牌" v-model="brand"> </el-input>
        </el-col>
        <el-col  :span="5">
          <el-input  size="small"placeholder="请输入姓名" v-model="user_name">
            <!--v-model="modelParams.user_name"> -->
          </el-input>
        </el-col>
        <el-col  :span="2">
          <el-button size="small" type="primary" @click="search">搜索</el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-table :data="CarData">
          <el-table-column type="selection" width="50px"></el-table-column>
          <el-table-column label="用户订单ID" prop="order_id"></el-table-column>
          <el-table-column label="品牌" prop="brand"></el-table-column>
          <!--<el-table-column label="订单详情" prop="quantity"></el-table-column>-->
          <el-table-column label="订单金额" prop="money"></el-table-column>
          <el-table-column label="订单人姓名"   prop="user_name"></el-table-column>
          <el-table-column  label="订单时间"  prop="order_time"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="text"  @click="openAddUser(scope.row)">修改</el-button>
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
      <el-dialog title="修改订单" :visible.sync="isAddDialog" width="40%">
        <el-form :model="params">
          <el-form-item label="用户订单">
            <el-input size="medium" placeholder="请输入订单" v-model="params.order_id" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="品牌">
            <el-input size="medium" placeholder="请输入品牌" v-model="params.brand"></el-input>
          </el-form-item>
          <!--<el-form-item label="订单详情">-->
            <!--<el-input size="medium" placeholder="请输入订单详情" v-model="params.quantity"></el-input>-->
          <!--</el-form-item>-->
          <el-form-item label="订单金额">
            <el-input size="medium" placeholder="请输入订单金额" v-model="params.money"></el-input>
          </el-form-item>
          <el-form-item label="订单人姓名">
            <el-input size="medium" placeholder="请输入订单人姓名" v-model="params.user_name"></el-input>
          </el-form-item>
          <el-form-item label="订单时间">
            <el-input size="medium" placeholder="请输入订单时间" v-model="params.order_time"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="update">提交</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import http from '@/utils/HttpUtil'
  import aes from '@/utils/AESUtil.js'
  export default {
    data () {
      return {
        action: {
          userList: 'projetsystem/Orded/selectAllOrded',
          userdel: 'projetsystem/Orded/deleteOrded',

          update:'projetsystem/Orded/updateOrded',
          detailsUser:'projetsystem/Orded/selectPersonById'
        },
        curr_page: 1,
        page_size: 10,
        total: 580,
        CarData: [],
        brand: '',
        user_name:'',
        params:{
          order_id:null,
          quantity:'',
          money:'',
          user_name:'',
          order_time:'',
          brand:''
        },
        isAddDialog: false
      }
    },
    components: {

    },
    mounted () {
      this.getUserList()
    },
    methods: {
      getUserList (brand = null, user_name = null, curr_page = 1, page_size = 10) {
        const params = {
          'curr_page': curr_page,
          'page_size': page_size
        }
        if (brand !== null && brand !== '') {
          params['brand'] = brand
        } if (user_name !== null && user_name !== '') {
          params['user_name'] = user_name
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
        this.getUserList(this.brand, this.user_name, this.curr_page, pagesize)
      },
      // 改变页码时
      changePageSize (currpage) {
        this.getUserList(this.brand, this.user_name, currpage, this.page_size)
      },
      search () {
        let brand = this.brand
        let user_name = this.user_name
        this.getUserList(brand, user_name, 1, 10)
      },
      userdel (row) {
        this.$confirm('您确定要删除当前记录吗？', {
          confirmButtonText: '确定',
          cancelButtonText: '取消'
        }).then(() => {
          this.xhrDelete(row.order_id)
        })
      },
      xhrDelete (ids) {
        http.xhrPost(this, this.action.userdel + '/' + ids, null, (res) => {
          this.$message({
            type: 'success',
            message: res.message
          })
          this.getUserList(this.brand, this.order_id, this.curr_page, this.page_size)
        }, 'delete')
      },
      // 打开修改用户对话框
      openAddUser (params) {
        this.isAddDialog = true
        http.xhrGet(this, this.action.detailsUser + '/' + params.order_id, null, (res) => {
          console.log(res)
          this.params.order_id = res.data.order_id
          this.params.quantity = res.data.quantity
          this.params.user_name = res.data.user_name
          this.params.order_time = res.data.order_time
          this.params.money = res.data.money
          this.params.brand = res.data.brand
        })
      },
      // 修改用户
      update () {
        const params = this.params
        console.log(params)
        http.xhrPost(this, this.action.update, params, (res) => {
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

<style scoped>
  .top{
    padding-top: 20px;
  }
</style>
