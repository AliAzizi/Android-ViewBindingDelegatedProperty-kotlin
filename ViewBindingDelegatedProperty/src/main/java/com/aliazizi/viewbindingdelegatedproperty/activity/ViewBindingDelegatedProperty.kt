package com.aliazizi.viewbindingdelegatedproperty.activity

import android.os.Looper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T: ViewBinding> AppCompatActivity.viewBinding(noinline ref: (LayoutInflater) -> T)  = ViewBindingDelegatedProperty(this, ref)

class ViewBindingDelegatedProperty<T : ViewBinding>(
    private val activity: AppCompatActivity,
    private val inflateRef: (LayoutInflater) -> T
) : ReadOnlyProperty<AppCompatActivity, T>, LifecycleObserver {

    private var binder: T? = null

    init {
        activity.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Suppress("Unused")
    fun onCreate() {
        if (binder == null) {
            binder = inflateRef(activity.layoutInflater)
        }
        activity.setContentView(binder?.root!!)
        activity.lifecycle.removeObserver(this)
    }


    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        if (binder == null) {
            if (!isMainThread()) {
                throw IllegalThreadStateException("You can use it only on main thread.")
            }
            binder = inflateRef(thisRef.layoutInflater)
        }

        return binder!!
    }

    fun isMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()

}