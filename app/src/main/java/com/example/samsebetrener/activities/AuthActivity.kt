package com.example.samsebetrener.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samsebetrener.R
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.database.Dependency
import com.example.samsebetrener.usecase.AuthUseCase
import com.example.samsebetrener.presenters.AuthPresenter
import com.example.samsebetrener.repositories.UserInfoRepository
import com.example.samsebetrener.utils.initialActivity
import com.example.samsebetrener.view.AuthActivityView

class AuthActivity : AppCompatActivity(), AuthActivityView {

    private lateinit var authPresenter: AuthPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_auth, R.id.main)

        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val authButton: Button = findViewById(R.id.button_auth)
        // TODO создай object Dependency а внутри него переменные by lazy {}
        // таким образом ты будешь создавать объекты лениво (не сразу, а только при первом вызове, дальше уже будет отдаваться один и тот же объект)
        // Если допустим тебе надо чтобы объект каждый раз пересоздавался сделай получение через get() = ObjectInfo()
        // Таким образаом у тебя будет всегда новый инстанс объекта
        // это даст тебе примерное поведение koin
        // и даст возможность передавать сразу готовые объекты в usecase или репозиторий
        // Причем тут у тебя можно достигнуть вот такой строчки:
        // val getUserInfoUseCase = Dependency.userInfoRepository - сразу получили и отдали готовый объект и с ним уже работаем
        // То есть делегируем создание и управлением жизненным циклом объектов другому классу, получателя объекта вообще не должно заботить,
        // где и как он создавался, а уж тем более как его создать и что для этого надо

        authPresenter = AuthPresenter(authActivityView = this, authUseCase = Dependency.authUseCase)

        linkToReg.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        authButton.setOnClickListener {
            authPresenter.authProcess(userLogin = userLogin, userPass = userPass)
        }
    }

    override fun showToastInfo(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context = this
}