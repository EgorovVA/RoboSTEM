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


class BlankFragment7 : Fragment() {
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private var backButton: ImageButton?= null
    private val link1: TextView?=null
    private val bundle = Bundle()
    private val ListArrey :Array<Int> = arrayOf(
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903,
        379903
    )

    private val QuestArrey :Array<String> = arrayOf(
        "В зоне мероприятия, есть место где сортируют отходы, вам нужно найти его. Но может эти отходы и разбрасывают, кто знает этих робото",
        "Идите туда где вам помогут в уборной, в срочной ситуации, ведь доставка это очень важная вещь, когда это так необходимо",
        "Вам надоело ожидать груз по часу после прилета, ничего страшного, на нашем мероприятии роботы сами доставляют груз, и возможно делают это быстрее, сходите и проверьте",
        "Пытаясь не вытолкнуть никого из мероприятия, двигайся туда где есть ринг",
        "Тут стоит двигаться в сторону Северного Ледовитого океана, там вы наткнетесь на архипилаг, который состоит из 192 островов",
        "Вы наверно уже запутались в нашем лабиринте , но ничего страшного ведь есть место, в котором роботы проходят лабиринты, может они подскажут вам выход?",
        "Найдите место где линией изображено очертание морского котика, раньше это был логотип мероприятия робонорд",
        "Найдите место, где роботы справляются с работой лучше, чем работники ЖКХ. Если программу для робота написал хороший программист, иначе вы увидите робота из ЖКХ)",
        "После сортировки мусора нужна же его доставка, найдите место, где происходит доставка",
        "Ты победил, редиска!!!",
        "Двигайся туда, опираясь только на конечности, напоминающие ноги живого существа. Ваши стопы в ходе движения не должны быть выше, чем связаная с ней точка крепления."
    )

    private val HelpArrey :Array<String> = arrayOf(
        "Не правильно)) Подсказка: 2 возростная группа))",
        "Не правильно)) Подсказка: 4 возростная группа))",
        "Не правильно)) Подсказка: 2 возростная группа))",
        "Не правильно)) Подсказка: 5 возростная группа))",
        "Не правильно)) Подсказка: 1 возростная группа))",
        "Не правильно)) Подсказка: 3 возростная группа))",
        "Не правильно)) Подсказка: 5 возростная группа))",
        "Не правильно)) Подсказка: 1 возростная группа))",
        "Не правильно)) Подсказка: 3 возростная группа))",
        "Не правильно)) Подсказка: 4 возростная группа))",
        "Сканируй!"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pidoor = arguments?.getString("LALIPOP")
        val view:View=inflater.inflate(R.layout.fragment7, container, false)
        openLink = view.findViewById(R.id.button5)
        bScanner = view.findViewById(R.id.button25)


        bScanner?.setOnClickListener{
            checkCameraPermission()
        }
        backButton = view.findViewById(R.id.imageButton)
        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment7_to_blankFragment6)
        }

        return view
    }

    private fun checkCameraPermission(){//разрешение камеры
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.CAMERA), 12)

        } else {
            bundle.putInt("fragment",7)
            view?.findNavController()?.navigate(R.id.action_blankFragment7_to_scannerActivity, bundle)
        }
    }

    override fun onResume() {
        super.onResume()
        val pidoor = arguments?.getString("LALIPOP")
        val intent = Intent(requireContext(),BlankFragment7::class.java)
        val link: EditText? = view?.findViewById(R.id.Link3)
        val link1: TextView? = view?.findViewById(R.id.Link2)
        val next_btn: Button? = view?.findViewById(R.id.button26)
        var txt:Int = 379903
        var count: Int = 0
        var quest = ""
        var help = ""
        if (link1 != null) {
            link1.setElegantTextHeight(true)
            link1.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE)
            link1.setSingleLine(false)
        }
        if(arguments?.getInt("key")==null){txt = 10}
        else{txt = arguments?.getInt("key")!!
        }
        if(arguments?.getInt("count")==null){count = 10}
        else{count = arguments?.getInt("count")!!
        }
        if(arguments?.getString("quest")==null){quest = "abc"}
        else{link1?.text = arguments?.getString("quest")
            quest = arguments?.getString("quest")!!
        }
        if(arguments?.getString("help")==null){quest = "abc"}
        else{link?.setText(arguments?.getString("help"))
            help = arguments?.getString("help")!!
        }
        for(i in 0 .. 9) {
            if (txt == ListArrey[count] && count == i) {
                link?.setText("Плавильно продолжай!")
                count = count+1
                bundle.putInt("count",count)
                bundle.putString("help","Плавильно продолжай!")
                break
            } else {
                link?.setText(HelpArrey[i])
                bundle.putString("help",help)
                bundle.putString("quest",QuestArrey[i])
                break
            }
        }

        if ( count == 10) {
            help = HelpArrey[10]
            quest = QuestArrey[10]
            link?.setText(help)
            link1?.text=QuestArrey[10]
            bundle.putString("help",help)
            bundle.putString("quest",quest)
            count = 0
        }
        next_btn?.setOnClickListener {
            for(i in 0 .. QuestArrey.size-1){
                if (txt == ListArrey[count] && count == i) {
                    link1?.text = QuestArrey[i]
                    quest = QuestArrey[i]
                    link?.setText(HelpArrey[10])
                    bundle.putString("quest",quest)
                    break
                }
            }
        }


    }

    override fun onRequestPermissionsResult(//разрешение камеры
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)


        if(requestCode == 12){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startActivity(Intent(requireContext(), ScannerActivity::class.java))
            }
        }
    }
}