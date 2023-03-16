package osp.leobert.android.hiltdemo.customcomponet

import android.content.Context
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton


@DefineComponent(parent = SingletonComponent::class)
@UserScope
interface UserComponent {
    @DefineComponent.Builder
    interface Builder {
        fun feedUser(@BindsInstance user: User?): Builder

        fun build(): UserComponent
    }
}

@Scope
annotation class UserScope

@Singleton
class UserComponentManager @Inject constructor(
    val builder: UserComponent.Builder
) : GeneratedComponentManager<UserComponent> {

    companion object {
        lateinit var instance: UserComponentManager
    }

    private var userComponent = builder
        .feedUser(null)
        .build()

    fun onLogin(user: User) {
        userComponent = builder.feedUser(user).build()
    }

    fun onLogout() {
        userComponent = builder.feedUser(null).build()
    }

    override fun generatedComponent(): UserComponent {
        return userComponent
    }

}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface UserComponentEntryPoint {

    companion object {

        fun manualGet(context: Context): UserComponentEntryPoint {
            return EntryPointAccessors.fromApplication(
                context, UserComponentEntryPoint::class.java
            )
        }
    }

    fun provideBuilder(): UserComponent.Builder

    fun provideManager():UserComponentManager
}

@EntryPoint
@InstallIn(UserComponent::class)
interface UserEntryPoint {

    companion object {
        fun manualGet(): UserEntryPoint {
            return EntryPoints.get(
                UserComponentManager.instance.generatedComponent(), UserEntryPoint::class.java
            )
        }

        fun manualGet(component: UserComponent): UserEntryPoint {
            return EntryPoints.get(
                component, UserEntryPoint::class.java
            )
        }
    }

    fun provideUserVO(): UserVO
}