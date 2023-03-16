package osp.leobert.android.hiltdemo.customcomponet.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import osp.leobert.android.hiltdemo.customcomponet.LibInitializer

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModuleBinds {
    @Binds
    @IntoSet
    abstract fun provideLibInitializer(bind: LibInitializer): Function1<Application, Any>

}
