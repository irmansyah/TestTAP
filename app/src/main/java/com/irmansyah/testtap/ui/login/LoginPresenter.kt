package com.irmansyah.testtap.ui.login

import com.irmansyah.testtap.data.DataManager
import com.irmansyah.testtap.ui.base.BasePresenter
import com.irmansyah.testtap.utils.ScProvider

class LoginPresenter<V : LoginView> constructor(dataManager: DataManager, scProvider: ScProvider) : BasePresenter<V>(dataManager = dataManager, scProvider = scProvider)  {


}