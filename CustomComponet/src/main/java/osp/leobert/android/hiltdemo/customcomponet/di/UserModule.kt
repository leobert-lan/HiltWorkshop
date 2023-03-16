package osp.leobert.android.hiltdemo.customcomponet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import osp.leobert.android.hiltdemo.customcomponet.User
import osp.leobert.android.hiltdemo.customcomponet.UserComponent
import osp.leobert.android.hiltdemo.customcomponet.UserScope
import osp.leobert.android.hiltdemo.customcomponet.UserVO

/**
 * Classname: LibModule </p>
 * Description: TODO </p>
 * Created by leobert on 2023/3/14.
 */
@InstallIn(UserComponent::class)
@Module
object UserModule {

    @UserScope
    @Provides
    fun provideUserVO(user: User?): UserVO {
        return UserVO(user?.name ?: "")
    }
}