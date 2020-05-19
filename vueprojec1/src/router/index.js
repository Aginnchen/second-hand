import Vue from 'vue'
import Router from 'vue-router'



// 登录界面
import Login from '@/components/Login'
// 注册界面

// 首页
import Index from '@/components/Index'
//车品展示
import Automobile from '@/components/Automobile'
//汽车详情
import Demo from '@/components/Demo'

// 用户订单界面
import Interface from '@/components/Interface'

//个人信息界面
import  UserInfo from '@/components/UserInfo'
//角色管理界面
import  Purchase from '@/components/Purchase'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },

      {
      path: '/Index',
      name: 'Index',
      component: Index,
    //    默认界面
        redirect:{name:'Automobile'},
        children:[
          {
            path: '/Automobile',
            name: 'Automobile',
            component: Automobile
          },
          {
            path: '/Demo',
            name: 'Demo',
            component: Demo
          },

          {
            path: '/Interface',
            name: 'Interface',
            component: Interface
          },
{
  path: '/Purchase',
    name: 'Purchase',
  component: Purchase
},


        ]


    },
    {
      path: '/UserInfo',
      name: 'UserInfo',
      component: UserInfo
    },


/**/
  ]
})
