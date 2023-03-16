package osp.leobert.android.hiltworkshop.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import osp.leobert.android.hiltdemo.customcomponet.UserComponentManager
import osp.leobert.android.hiltdemo.customcomponet.UserEntryPoint
import osp.leobert.android.hiltdemo.customcomponet.UserVO

/**
 * Classname: AppModule </p>
 * Description: TODO </p>
 * Created by leobert on 2023/3/15.
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object AppModule {

    @Provides
    fun provideUserVO(manager: UserComponentManager):UserVO {
        Log.d("","provideUserVO")
        return UserEntryPoint.manualGet(manager.generatedComponent()).provideUserVO()
    }
}