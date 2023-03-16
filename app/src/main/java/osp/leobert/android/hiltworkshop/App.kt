package osp.leobert.android.hiltworkshop

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


/**
 * <p><b>Package:</b> osp.leobert.android.hiltworkshop </p>
 * <p><b>Project:</b> HiltWorkshop </p>
 * <p><b>Classname:</b> App </p>
 * <p><b>Description:</b> TODO </p>
 * Created by leobert on 2022/4/2.
 */
@HiltAndroidApp
class App : Application() {


    @Inject
    lateinit var initializers: Set<@JvmSuppressWildcards Function1<Application, Any>>

    override fun onCreate() {
        super.onCreate()
        initializers.forEach {
            it(this)
        }
    }
}