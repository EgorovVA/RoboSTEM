package ru.samsung.itschool.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController


class BlankFragment6 : Fragment() {
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null
    private var btn4: Button? = null
    private var btn5: Button? = null
    private var btn6: Button? = null
    private var btn7: Button? = null
    private var btn8: Button? = null
    private  var backButton: ImageButton?= null
    private var zadacha:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment6, container, false)
        btn1 = view.findViewById(R.id.button17)
        btn2 = view.findViewById(R.id.button18)
        btn3 = view.findViewById(R.id.button19)
        btn4 = view.findViewById(R.id.button20)
        btn5 = view.findViewById(R.id.button21)
        btn6 = view.findViewById(R.id.button22)
        btn7 = view.findViewById(R.id.button23)
        btn7 = view.findViewById(R.id.button24)
        val link: TextView? = view?.findViewById(R.id.Link2)
        if (link != null) {
            link.setElegantTextHeight(true)
            link.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            link.setSingleLine(false)
        }
        val num_rand = (1 until 8).random()
        btn1?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text ="Нужно делать так, как нужно. А как не нужно, делать не нужно!"
          }
        }
        btn2?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "— Ай-ай-ай, спасите-помогите! Не могу ни взад ни вперёд!"
            }
        }
        btn3?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "— Кто же это ходит за мёдом с воздушными шарами? — Я хожу!"
            }
        }
        btn4?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "— Хвост или есть, или его нет. По-моему, тут нельзя ошибиться."
            }
        }
        btn5?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "Это «ж-ж-ж» — неспроста!"
            }
        }
        btn6?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "Воздушным шаром можно кого хочешь утешить."
            }
        }
        btn7?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "А зачем тебе жужжать, если ты не пчела?"
            }
        }
        btn8?.setOnClickListener{
            if(num_rand == 1){
                view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
            }else{
                link?.text = "Можно ничего не делать, и тогда может случится много приятностей!"
            }
        }
        return view
    }





    override fun onResume() {
        super.onResume()
        val link: EditText? = view?.findViewById(R.id.Link)
        val txt:Int? =arguments?.getInt("key")
        val user = arguments?.getString("name")
        val intent = Intent(requireContext(),BlankFragment5::class.java)
        if (user != null) {

            if(txt==123456){
                zadacha = "http://robostem.ru/wp-content/uploads/2020/11/1-Биатлон.docx"
                val f = Storage(user,zadacha)
                intent.putExtra("member",f)
            }
            if(txt == null){
                zadacha = null.toString()
                val f = Storage(user,zadacha)
                intent.putExtra("member",f)
            }
        }
        if(txt==123456){
            link?.setText("http://robostem.ru/wp-content/uploads/2020/11/1-Биатлон.docx")
        }
        else{
            val nax = arguments?.getString("error")
            link?.setText(nax)
        }

    }


}