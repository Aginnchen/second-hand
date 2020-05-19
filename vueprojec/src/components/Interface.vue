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
          <el-input  size="small"placeholder="请输入配置" v-model="user_name">
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
          <el-table-column label="用户订单品牌" prop="brand"></el-table-column>
          <!--<el-table-column label="订单详情" prop="quantity"></el-table-column>-->
          <el-table-column label="订单金额" prop="money"></el-table-column>
          <el-table-column label="订单人姓名"   prop="user_name"></el-table-column>
          <el-table-column  label="订单时间"  prop="order_time"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
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
    </div>
  </div>
</template>

<script>
  import http from '@/utils/HttpUtil'
  export default {
    data () {
      return {
        action: {
          userList: 'projetsystem/Orded/selectAllOrded',
          userdel: 'projetsystem/Orded/deleteOrded'
        },
        curr_page: 1,
        page_size: 10,
        total: 580,
        CarData: [],
        brand: '',
        user_name:''
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

    }
  }
</script>

<style scoped>
 .top{
    padding-top: 20px;
  }
</style>
