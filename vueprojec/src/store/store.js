'use strict'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import Vue from 'vue'
import user from './module/user'
import menu from './module/menu'
Vue.use(Vuex)
const getters = {}
const store = new Vuex.Store({
  modules: {user, menu},
  getters,
  plugins: [
    createPersistedState({
      key: 'UIAS',
      storage: window.sessionStorage
    })
  ]
})

export default store
