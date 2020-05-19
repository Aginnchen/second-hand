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
        <el-input  size="small"placeholder="请输入配置" v-model="configuration">
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
          <el-table-column label="品牌" prop="brand"></el-table-column>
          <el-table-column label="型号" prop="model"></el-table-column>
          <el-table-column label="配置" prop="configuration"></el-table-column>
          <el-table-column label="价格" prop="money"></el-table-column>
          <el-table-column label="颜色" prop="color"></el-table-column>
          <el-table-column label="出产那个国家" prop="state"></el-table-column>
          <el-table-column label="上市时间" prop="market_time"></el-table-column>
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
  // import httpUtil from '../utils/HttpUtil.js'
  export default {
    data () {
      return {
        action: {
          userList: 'projetsystem/Car/selectAllCar',
          userdel: 'projetsystem/Car/deleteCar'
        },
        curr_page: 1,
        page_size: 10,
        total: 580,
        CarData: [],
        brand: '',
        configuration:'',

      }
    },
    components: {

    },
    mounted () {
      this.getUserList()
    },
    methods: {
      getUserList (brand = null, configuration = null, curr_page = 1, page_size = 10) {
        const params = {
          'curr_page': curr_page,
          'page_size': page_size
        }
        if (brand !== null && brand !== '') {
          params['brand'] = brand
        } if (configuration !== null && configuration !== '') {
          params['configuration'] = configuration
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
        this.getUserList(this.brand, this.configuration, this.curr_page, pagesize)
      },
      // 改变页码时
      changePageSize (currpage) {
        this.getUserList(this.brand, this.configuration, currpage, this.page_size)
      },
      search () {
        let brand = this.brand
        let configuration = this.configuration
        this.getUserList(brand, configuration, 1, 10)
      },
      userdel (row) {
        this.$confirm('您确定要删除当前记录吗？', {
          confirmButtonText: '确定',
          cancelButtonText: '取消'
        }).then(() => {
          this.xhrDelete(row.brand_id)
        })
      },
      xhrDelete (ids) {
        http.xhrPost(this, this.action.userdel + '/' + ids, null, (res) => {
          this.$message({
            type: 'success',
            message: res.message
          })
          this.getUserList(this.brand, this.configuration, this.curr_page, this.page_size)
        }, 'delete')
      },

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
