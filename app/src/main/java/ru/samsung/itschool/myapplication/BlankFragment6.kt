package ru.samsung.itschool.myapplication


import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController

class BlankFragment6 : Fragment() {
    private val bundle = Bundle()

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
        val link: TextView? = view?.findViewById(R.id.Link2)
        val num_rand: Int = (0 until 7).random()
        backButton = view.findViewById(R.id.imageButton2)
        backButton = view.findViewById(R.id.imageButton)

        val ViniPuh_Array :Array<String> = arrayOf(
            "Нужно делать так, как нужно. А как не нужно, делать не нужно!",
            "— Ай-ай-ай, спасите-помогите! Не могу ни взад ни вперёд!",
            "— Кто же это ходит за мёдом с воздушными шарами? — Я хожу!",
            "— Хвост или есть, или его нет. По-моему, тут нельзя ошибиться.",
            "Это «ж-ж-ж» — неспроста!",
            "Воздушным шаром можно кого хочешь утешить.",
            "А зачем тебе жужжать, если ты не пчела?",
            "Можно ничего не делать, и тогда может случится много приятностей!"
        )
        var Button_ = arrayOf<Button?>(
            view.findViewById(R.id.button17),
            view.findViewById(R.id.button18),
            view.findViewById(R.id.button19),
            view.findViewById(R.id.button20),
            view.findViewById(R.id.button21),
            view.findViewById(R.id.button22),
            view.findViewById(R.id.button23),
            view.findViewById(R.id.button24),
        )
        if (link != null) {
            link.setElegantTextHeight(true)
            link.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            link.setSingleLine(false)
        }

        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment6_to_blankFragment5)
        }

        fun cliker(i : Int){
            Button_[i]!!.setOnClickListener{
                if(num_rand == i){
                    bundle.putString("LALIPOP","пИДРИЛА оБОССАНЫЙ")
                    bundle.putInt("count",10)
                    requireView().findNavController().navigate(R.id.action_blankFragment6_to_blankFragment7,bundle)
                }
                link?.text =ViniPuh_Array[i]
            }
        }

        for(i in 0 .. Button_.size-1){
            cliker(i)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}