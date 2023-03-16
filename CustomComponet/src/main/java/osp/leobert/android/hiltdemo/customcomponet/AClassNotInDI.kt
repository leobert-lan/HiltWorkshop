package osp.leobert.android.hiltdemo.customcomponet

/**
 * Classname: AClassNotInDI </p>
 * Description: 假定该类的实例不会通过Hilt获取，Demo中使用 new Instance 代指 反射构造函数获取实例 </p>
 * Created by leobert on 2023/3/14.
 */
class AClassNotInDI {

    fun getUse(): UserVO {
        return UserEntryPoint.manualGet()
            .provideUserVO()
    }

    fun login(user: User) {
        UserComponentManager.instance.onLogin(user)
    }

    fun logout() {
        UserComponentManager.instance.onLogout()
    }
}