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


class BlankFragment7 : Fragment() {
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private  var backButton: ImageButton?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
            view?.findNavController()?.navigate(R.id.action_blankFragment7_to_scannerActivity2)
        }
    }

    override fun onResume() {
        super.onResume()
        val link: EditText? = view?.findViewById(R.id.Link3)
        val txt:Int? =arguments?.getInt("key")

        val intent = Intent(requireContext(),BlankFragment7::class.java)
        var f =7
        val bundle = Bundle()
        bundle.putInt("frag",f)
        if(txt==379903){
            link?.setText("Плавильно продолжай!")
        }
        else{
            link?.setText("Подсказка: вторая возростная группа))")
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