package osp.leobert.android.hiltworkshop

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import osp.leobert.android.hiltdemo.customcomponet.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userComponentManager: UserComponentManager

    // userVO 的注入 并不满足合理的需求，仅用作使用方法演示
    @Inject
    lateinit var userVO: UserVO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_login1).setOnClickListener {
            userComponentManager.onLogin(User("user1", "toke1"))
        }
        findViewById<View>(R.id.btn_logout1).setOnClickListener {
            userComponentManager.onLogout()
        }
        findViewById<View>(R.id.btn1).setOnClickListener {
            val userVo = EntryPoints.get(
                userComponentManager.generatedComponent(), UserEntryPoint::class.java
            ).provideUserVO()

            Toast.makeText(this, "user:${userVo.name}", Toast.LENGTH_SHORT).show()
        }

        //这里模拟Uni-app等技术栈，他们会通过反射方式构建实例（非DI方式），
        // 我们通过自定义EntryPoint的方式，突破IOC容器的壁垒，操作容器控制生命周期&获取依赖，避免了Scope泄漏

        val notInDI = AClassNotInDI()

        findViewById<View>(R.id.btn_login2).setOnClickListener {
            notInDI.login(User("user2", "toke2"))
        }
        findViewById<View>(R.id.btn_logout2).setOnClickListener {
            notInDI.logout()
        }
        findViewById<View>(R.id.btn2).setOnClickListener {
            Toast.makeText(this, "user:${notInDI.getUse().name}", Toast.LENGTH_SHORT).show()
        }

    }
}