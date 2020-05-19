'use strict'
const menu = {
  state: {
    menu: [],
    actionMenu: {}
  },
  getters: {
    menu: state => state.menu,
    actionMenu: state => state.actionMenu
  },
  mutations: {
    saveMenu (state, menu) {
      state.menu = menu
    },
    updateActionMenu (state, actionMenu) {
      state.actionMenu = actionMenu
    },
    cleanActionMenu (state) {
      state.actionMenu = {}
    }
  },
  actions: {
    saveMenu ({commit}, menu) {
      commit('saveMenu', menu)
    },
    updateActionMenu ({commit}, actionMenu) {
      commit('updateActionMenu', actionMenu)
    },
    cleanActionMenu ({commit}) {
      commit('cleanActionMenu')
    }
  }
}
export default menu
