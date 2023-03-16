package osp.leobert.android.hiltdemo.customcomponet

import android.app.Application
import android.util.Log
import javax.inject.Inject

/**
 * Classname: LibInitializer </p>
 * Description: TODO </p>
 * Created by leobert on 2023/3/14.
 */
class LibInitializer @Inject constructor(
    private val userComponentManager: UserComponentManager
) : Function1<Application, Any> {

    override fun invoke(app: Application): Any {
        UserComponentManager.instance = userComponentManager

        //test the instances fetch by different ways are the same:

        val builderByEntryPoint = UserComponentEntryPoint.manualGet(app).provideBuilder()
        val builderByNotation = userComponentManager.builder

        Log.d("LibInitializer", "are the two builders be the same: ${builderByEntryPoint == builderByNotation}")

        //test the instances fetch by different ways are the same:

        val managerByEntryPoint = UserComponentEntryPoint.manualGet(app).provideManager()

        Log.d("LibInitializer", "are the two managers be the same: ${managerByEntryPoint == userComponentManager}")

        // 通过这里的演示，我们得知：可以通过原先技术栈采用的方式初始化Library，并完成使用Hilt的必要初始化

        return Unit
    }
}