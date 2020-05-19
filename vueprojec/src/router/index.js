import Vue from 'vue'
import Router from 'vue-router'

// 登录界面
import Login from '@/components/Login'
// 注册界面
import Register from '@/components/Register'
// 首页
import Index from '@/components/Index'
//车品展示界面
import Automobile from '@/components/Automobile'
//汽车信息界面
import Demo from '@/components/Demo'
//购买汽车界面
import Purchase from '@/components/Purchase'

// 用户订单界面
import Interface from '@/components/Interface'

//问题反馈界面
import Problem from '@/components/Problem'

//个人信息界面
import  UserInfo from '@/components/UserInfo'
//个人设置界面
import  EditUser  from '@/components/EditUser'

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
            path: '/Problem',
            name: 'Problem',
            component: Problem
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
    {
      path: '/EditUser',
      name: 'EditUser',
      component: EditUser
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register
    },

/**/
  ]
})
