package br.com.etecmatao.avaliacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.time.Year

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun analise(v:View){
        var idNome = findViewById<TextInputEditText>(R.id.id_label_name)
        var idIdade = findViewById<TextInputEditText>(R.id.id_label_age)

        if (TextUtils.isEmpty(idNome.text.toString()) || TextUtils.isEmpty(idIdade.text.toString())){
            Toast.makeText(this, getString(R.string.msg_campo_obrigatorio), Toast.LENGTH_SHORT).show()
            return
        }

        var nome = idNome.text.toString()
        var idade = idIdade.text.toString().toInt()

        var ano = Year.now().value

        var nascimento:Int = ano - idade
        var mensagem = nome + ", voce provavelmente nasceu em " + nascimento + "!"

        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }
}
