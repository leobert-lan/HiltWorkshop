package osp.leobert.android.hiltdemo.customcomponet

import dagger.hilt.android.internal.managers.ComponentSupplier
import dagger.hilt.internal.GeneratedComponentManager


/**
 * Classname: CustomComponentManager </p>
 * Description: TODO </p>
 * Created by leobert on 2023/3/15.
 */
class CustomComponentManager(
    private val componentCreator: ComponentSupplier
) : GeneratedComponentManager<Any> {

    @Volatile
    private var component: Any? = null

    private val componentLock = Any()

    override fun generatedComponent(): Any {
        if (component == null) {
            synchronized(componentLock) {
                if (component == null) {
                    component = componentCreator.get()
                }
            }
        }

        return component!!
    }
}