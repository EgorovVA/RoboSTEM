package ru.samsung.itschool.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController


class BlankFragment5 : Fragment() {
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private var gameBscan: Button? = null
    private  var backButton: ImageButton?= null
    private var zadacha:String = ""
    val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment5, container, false)
        openLink = view.findViewById(R.id.button14)
        bScanner = view.findViewById(R.id.button13)
        gameBscan = view.findViewById(R.id.button15)
        backButton = view.findViewById(R.id.imageButton2)
        bScanner?.setOnClickListener{
            checkCameraPermission()
        }
        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment5_to_blankFragment)
        }
        gameBscan?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment5_to_blankFragment6)
        }
        checktext()


        return view
    }


    fun checktext(){
        val txt:Int? =arguments?.getInt("key")
        openLink?.setOnClickListener {
            if(txt==123456){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://robostem.ru/wp-content/uploads/2020/11/1-Биатлон.docx"))
                startActivity(i)
            }
        }
    }


    private fun checkCameraPermission(){//разрешение камеры
        if(ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.CAMERA), 12)

        } else {
            bundle.putInt("frag",5)
            view?.findNavController()?.navigate(R.id.action_blankFragment5_to_scannerActivity,bundle)
            // startActivity(Intent(requireContext(), ScannerActivity::class.java))
        }
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