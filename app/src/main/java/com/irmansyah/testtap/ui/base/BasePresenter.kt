package com.irmansyah.testtap.ui.base

import com.irmansyah.testtap.data.DataManager
import com.irmansyah.testtap.utils.ScProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : MVPView> internal constructor(var dataManager: DataManager, var scProvider: ScProvider) {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    fun onAttach(view: V?) {
        this.view = view
    }

    fun getView(): V? = view

    fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }
}