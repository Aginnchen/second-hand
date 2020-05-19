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
        <el-button class="fl" size="small"   @click="openAddUser">添加汽车信息</el-button>
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
      <el-dialog title="修改订单" :visible.sync="isAddDialog" width="40%">
        <el-form :model="params">
          <el-form-item label="品牌">
            <el-input size="medium" placeholder="请输入品牌" v-model="params.brand" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="型号">
            <el-input size="medium" placeholder="请输入型号" v-model="params.model"></el-input>
          </el-form-item>
          <el-form-item label="配置">
            <el-input size="medium" placeholder="请输入配置" v-model="params.configuration"></el-input>
          </el-form-item>
          <el-form-item label="价格">
            <el-input size="medium" placeholder="请输入价格" v-model="params.money"></el-input>
          </el-form-item>
          <el-form-item label="颜色">
            <el-input size="medium" placeholder="请输入颜色" v-model="params.color"></el-input>
          </el-form-item>
          <el-form-item label="出产那个国家">
            <el-input size="medium" placeholder="请输入出产那个国家" v-model="params.state"></el-input>
          </el-form-item>
          <el-form-item label="上市时间">
            <el-input size="medium" placeholder="请输入上市时间" v-model="params.market_time"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="modification">提交</el-button>
        </div>
      </el-dialog>
      <el-dialog title="新增订单" :visible.sync="increased" width="40%">
      <el-form :model="params">
        <el-form-item label="品牌">
          <el-input size="medium" placeholder="请输入品牌" v-model="params.brand"></el-input>
        </el-form-item>
        <el-form-item label="型号">
          <el-input size="medium" placeholder="请输入型号" v-model="params.model"></el-input>
        </el-form-item>
        <el-form-item label="配置">
          <el-input size="medium" placeholder="请输入配置" v-model="params.configuration"></el-input>
        </el-form-item>
        <el-form-item label="价格">
          <el-input size="medium" placeholder="请输入价格" v-model="params.money"></el-input>
        </el-form-item>
        <el-form-item label="颜色">
          <el-input size="medium" placeholder="请输入颜色" v-model="params.color"></el-input>
        </el-form-item>
        <el-form-item label="出产那个国家">
          <el-input size="medium" placeholder="请输入出产那个国家" v-model="params.state"></el-input>
        </el-form-item>
        <el-form-item label="上市时间">
          <el-input size="medium" placeholder="请输入上市时间" v-model="params.market_time"></el-input>
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
  // import httpUtil from '../utils/HttpUtil.js'
  export default {
    data () {
      return {
        action: {
          //分页查询
          userList: 'projetsystem/Car/selectAllCar',
          //删除
          userdel: 'projetsystem/Car/deleteCar',
          //修改
          modification:'projetsystem/Car/updateCar',
        //  根据id查询
        inquire:'projetsystem/Car/selectPersonById',
        //  新增
          addUser:'projetsystem/Car/addPerson'
        },
        curr_page: 1,
        page_size: 10,
        total: 580,
        CarData: [],
        brand: '',
        configuration:'',
        params:{
          brand_id:null,
          brand:'',
          model:'',
          configuration:'',
          money:'',
          color:'',
          state:'',
          market_time:'',
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
      //删除
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
      //新增

      // 打开新增用户对话框
      openAddUser () {
        this.increased = true
      },
      // 新增用户
      increasedUser () {
        let params = {
          brand: this.params.brand,
          user_name: this.params.user_name,
          model: this.params.model,
          configuration: this.params.configuration,
          money: this.params.money,
          color: this.params.color,
          state: this.params.state,
          market_time: this.params.market_time,
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
            brand: '',
            user_name: '',
            model: '',
            configuration: '',
            money: '',
            color: '',
            state: '',
            market_time: ''
          }
        })
      },

      // 打开修改用户对话框
      modificationUser (params) {
        this.isAddDialog = true
        // console.log(params.brand_id)
        http.xhrGet(this, this.action.inquire + '/' + params.brand_id, null, (res) => {
          // console.log(res)
          this.params.brand_id = res.data.brand_id
          this.params.brand = res.data.brand
          this.params.model = res.data.model
          this.params.configuration = res.data.configuration
          this.params.money = res.data.money
          this.params.color = res.data.color
          this.params.state = res.data.state
          this.params.market_time = res.data.market_time
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
