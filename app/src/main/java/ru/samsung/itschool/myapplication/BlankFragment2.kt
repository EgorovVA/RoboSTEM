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
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController


class BlankFragment2 : Fragment() {
    private var openLink: Button? = null
    private var bScanner: Button? = null
    private  var backButton:ImageButton ?= null
    private var zadacha:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment2, container, false)
        openLink = view.findViewById(R.id.button5)
        bScanner = view.findViewById(R.id.button9)
        bScanner?.setOnClickListener{
            checkCameraPermission()
        }
        backButton = view.findViewById(R.id.imageButton)
        backButton?.setOnClickListener{
            view.findNavController().navigate(R.id.action_blankFragment2_to_blankFragment)
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
            view?.findNavController()?.navigate(R.id.action_blankFragment2_to_scannerActivity)
           // startActivity(Intent(requireContext(), ScannerActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val link: EditText? = view?.findViewById(R.id.Link)
        val txt:Int? =arguments?.getInt("key")
        val user = arguments?.getString("name")
        val intent = Intent(requireContext(),BlankFragment4::class.java)
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
        when (txt) {
            268393 -> link?.setText("http://robostem.ru/wp-content/uploads/2020/11/1-Биатлон.docx")
            //1-Биатлон
            309980 -> link?.setText("https://docviewer.yandex.ru/?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruKfyYhlx9Rcl-ifb0UmKnXbBVEXw7t477XzD2zTyNcgk9lK9mtUieGy0fH0PEZgX4UOYltKiUWzPGAkPzHcCMJIyFhAeU2O8_jYHa1xtKLcxDcAUgyFE86BUIae5TR8xyg%3D%3D%3Fsign%3DUDo9073VhhdeulLNA2K-IwC_zGG-DHAaiHX5qnz68ik%3D&name=1-Кегельринг.docx")
            //1-Кегельринг
            694069 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruGce4iAxhxmQT2pFVmiK6Z7Kktrxhav7DKQoF2rQw83d3Euq7xYCtUCZppVujeljfclU4ys6fJQwtqLQpwUXo8I2r6HMswKYzH8Pn5UdpXvdCKjKQpW7Ka4E71Kp5q1t7w%3D%3D%3Fsign%3Dxm5LcgNc_u_Urye5q_qaLsLaqzEWnteOkF-xmVx2hgQ%3D&name=1-КегельрингКВАДРО.docx&nosw=1")
            //1-КегельрингКВАДРО
            812709 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruPmPlptx-I1pFD9Zezk6S4fNZnfyx-CrgzHRsHiXy-U-up_sWXWTSr83eBkIfoSCsD_5VpfBc93LcPbqiksO80fNCC2q8as4RPuna2AHMXwhlmp1-1ngA-G4XkZrMBgoNA%3D%3D%3Fsign%3D7HRmXpHybuy1ULSk5TuSdb2HSbGw-17KiTAKN8E_C80%3D&name=1-Линия.docx&nosw=1")
            //1-Линия
            456793 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruLMekWZrsKsjavzQkEZBF6g0UzygbdtcbabFndMaUZeAlC0YL-iyK2_Gs_BGsa7n4PEu1VpIYF3V14oRnwcU7RzJjdTpwugCsEu3V_nwoLmijkEolCJWwzFifEPgRSv95g%3D%3D%3Fsign%3DVJbfMZYU1aerFh3BxHxbOG5nrsV5BxU8kUwOaldk0ms%3D&name=2-КегельрингКВАДРО.docx&nosw=1")
            //2-КегельрингКВАДРО
            365599 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruGTz8D4ip_ZuU4osP96E-2YwCFP_7Y6Aa1VaDZkb-5Vn7QxJ_y9YMeJOXtqr4GWgWe0IFI1UXoMq44PC-eaXDF0ltTwXBS2rZV2pALQKYQjHvRM839hygDMh1DyVoA3B9w%3D%3D%3Fsign%3DeTcY3TQpl_MedDaHHKGRvcMft9SBR7zcN6VkdYnzJf8%3D&name=2-Уборка_мусора.docx&nosw=1")
            //2-Уборка_мусора
            581023 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruJ1wpqR7_dBiVX6k86ek-MSe7PTIGr318ovKrOQYjaoEpIPy2a8GL77iqM_GyGVy-XQ3ZbXst04CmOufoh4dqKSHkMjHf7ysIyjsUuJRbaqgrTOW85hoOvdW9x5Fti3zOA%3D%3D%3Fsign%3DxK5ZcW1WaMEcWu-1zrP2y3QQVK7LtZiQgz9MTYjlOpE%3D&name=2-Траектория.docx&nosw=1")
            //2-Траектория
            379903 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruH-vzyQMURScoGb2ZMO4GdUeBWiVVNWC1U1l_SVZzeNiAq8Sbe0rHXFEItQR5V6sLQVVDkQZ9Ppuh-T43z81sZRz3M41e67ha-taps93O36vHFnogbuVGlkmPbuZBIIUaQ%3D%3D%3Fsign%3DswO1cnum2OGq1Z8daq8yDw4giFdX2d1ogJRwpOrzPUc%3D&name=2-Гонка_шагающих_роботов.docx&nosw=1")
            //2-Гонка_шагающих_роботов
            108990 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruC6oq0iwKkPkezGuplm49WUNO6zoG_u3az97ptG95PTUzAkYlVBhq2Oxx0tedj4GJM3gu4WAtzRzU4l2OdQQagQ5h1oRNltTQIkpqlwJH8PqI4Qv243E2es3gj5iyrrW2w%3D%3D%3Fsign%3D_GnZQwoC9GEljB9q2lb5t9J17VaGOieiuiAn2aICHjs%3D&name=2-Попади-в-цель.docx&nosw=1")
            //2-Попади-в-цель
            942876 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruNygDb9JvtWOO9aHIjO36_fClvijCIsgIgs8Sd8sHJeZYd646R5soq9Nk74GsZDlTC5Gl1OXK58sojmYdYCy6tiIiyQCmNGO-GXphPeOaKgnIDPumuf5GyViO3DLce0ATA%3D%3D%3Fsign%3DW9W-gQzd2X0Max7RGBTM4HzRDwiLWG0pnape_p9AjoU%3D&name=2-доставка-рулона-бумаги.docx&nosw=1")
            //2-доставка-рулона-бумаги
            186795 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruEUwil5ne8WDmx8K6tZf2qtf9cYghFJAKm1spMZZH7J6kuxcrr86CQDC0bmHjG5tPHi2fZHSWV9kraUsOcxlYPMWU6x2BnLunrRmfOGfK-8MFTkV3Ndo7AWBS0kiLzhSNQ%3D%3D%3Fsign%3D3NEJz1pUM4o_uxpolFSpMPpcAsT8qxX8aSs_QQP3Ovg%3D&name=3-Земля-Франца-Иосифа.docx&nosw=1")
            //3-Земля-Франца-Иосифа
            699833 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruC1DCtnmfTi5S6HkTYUe6N4Vcje3Onkb-n1JxpHU5EKy2sghBSPWWQRYd3TYjwbTuR0IMIi2PeawUfUGPiPz6l5EZCBxY2_RbS93Gq4-QCuw6YHuLy1ZR-67kFEkQ4cntg%3D%3D%3Fsign%3D84ECEpUZZohJtgCrm2t7fEC2QFbiARtVOWc2ZGgVnBs%3D&name=3-Уборка_мусора.docx&nosw=1")
            //3-Уборка_мусора
            782301 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruBy9NX-e9h3Hny88DWNUqvqIKE5rE62NK7W0i0v-7ZHpcH65QSOMU5DE_zjt_6LX3q_xRFoRs7R74hZUvI94BfPLTcjj_lrrU9rW7jLvLxIN5uzNmr181OXzRHF2hfoWUA%3D%3D%3Fsign%3DneV3o77JOVCDPRpMfw6eEAU40N0L3pr4k9qkI1E6DFs%3D&name=3-Гонка_шагающих_роботов.docx&nosw=1")
            //3-Гонка_шагающих_роботов
            865460 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruP5HRwuqAaQjsGMr8uF7YQ_vCVE3UcIU3MO7uGm_qVumo7fQvye-WiMfLG_X1KEYwiubUnfodv-ddAmwHMVJjclTuuFJKQsJDk-a67nuwJKKF4UBy5InwO2DCI_cw6xfVQ%3D%3D%3Fsign%3DUx-i36IAcY5_-dAfLqi07OT4ybPYhvX6mj5c1eBieTA%3D&name=3-Очистка_дороги.docx&nosw=1")
            //3-Очистка_дороги
            226501 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruM5y8-iGSl7kIABAJFDvXRyH8XfksuFSTowDNRp00ysHlqdFhrtL91b48nGgSCWSMEORuEftjnG77S63rS9Qy_pkgtL6lyjb49AVrMhfI4XrKfUUOCkpKoaCCyOsK7PTCQ%3D%3D%3Fsign%3Db8hwdA7mdbZkOD5JFVcIXat97Mhtc0p0yTnxnvmJdBs%3D&name=3-Склад.docx&nosw=1")
            //3-Склад
            267336 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruMdH3PlTIGGux7HqfrYu3XQwQF3_59xAvK7qACP2JbVl14T263iZotYQ-JPfTwRAWAiZ6Fm54EukCuv8sQmhvsMYwp96eLK7itpKAg6SXN4I5rfrRwk4KMU7PX1tBSDHEw%3D%3D%3Fsign%3DT6OyYQGndxYSauayALbjL-SisMAtRRqeyp-o0-e71io%3D&name=4-Покатушки.docx&nosw=1")
            //4-Покатушки
            881560 -> link?.setText("https://docviewer.yandex.ru/?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruB66mtHiRMy10s1q3Ku22QxjF7H7loJCGTdUL0zjiWmscrE5WtBMYCIFo9LeIyVYinm17rQXcdwfLjG79QAtfcrN5ok5VU8LkuzGEJKew3eMh0H08mwtzg9n-d0oaeVeww%3D%3D%3Fsign%3DrK06g5jNB8Qu5_FoMphX8Hw5bNxhOfZHX4-ohmyaMD0%3D&name=4-Уборка_Мусора.docx")
            //4-Уборка_Мусора
            566588 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruIo9DrVWROtG8Ng6gsljW9zHXm2FkTKzJY3oHJovc_QgXNb-tJkErIOUFniBzizmhh0cEUmhjiY6ehMvH0X5btec-YfpyyVky8qax4iNWZEb6aV8fTyLX1Ft4l75pgVitQ%3D%3D%3Fsign%3DhoebBhhkwk88faqmdDEBs218xSwDQa9oLKNEYQ8NWDQ%3D&name=4-Опасный_контейнер.docx&nosw=1")
            //4-Опасный_контейнер
            935956 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruAi_5wR2pgIUnKJ9R_5ReaKvhBp3tasvXJKgWzFM2ugOwNPnm8hPUbGqhMpDnQ9HnT4XN6z9VdvvEFUsz4ieDJvpVu_lAHLGzt2vh7GeFHzJUMvpxTZ4n8r_cZP_TwaiTg%3D%3D%3Fsign%3DslqHpTgKGzRVBCQ10qseRAV5LIsrf8qVgaDbNly5-z0%3D&name=4-Раздельный_сбор_отходов.docx&nosw=1")
            //4-Раздельный_сбор_отходов
            627352 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruBuGLPxpdRAfrRTCkTyRpuN1OGyJ1CGEfYphUkmxn88MFiDb0okOorFVlH7bmX0opRELVSJS47OkRv-FP_rvVUACTlR02IepMEM3k6NupWtyFWY0gO30wf-Ljk9FQdFxKQ%3D%3D%3Fsign%3DaI07lByePxPrCkZ2hwiKwTAjC5ZzEnv5J9aYvKvHEXk%3D&name=5-Силач.docx&nosw=1")
            //5-Силач
            452561 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruBP581lfrLQsS86Rh25os2SUq_NglbU1wEkdw5-SeQ3EnYU6h5922OPw3qyrbxFnVma9XSS5W8Mcly7CLoKXCRRLGajJrgPXP0EJIkg-GcQqJfoZ0SREF-Q9ey-C3ZNqug%3D%3D%3Fsign%3D582kSz9qDhR6LfR_Ybp9lp7ySdg3vljbDmbU3SHVkjs%3D&name=5-Гонка_шагающих_роботов.docx&nosw=1")
            //5-Гонка_шагающих_роботов
            439932 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruIk2KHIpy08vLT0UaOXm2J-yKM0wyp5tWTm3vRBTVjeuAw45fND1AJSJ9S7LuF8lvluKlIet8PnjVYpEf71AwrYcnmZXMOKTCVWKHcP-3v8cYIB_Q1sdI0PECfdBvuSUtQ%3D%3D%3Fsign%3Dk8jtcVRcb1g7jSnVBHLrA_NBD7kc0xkdV6TOF-ipvxc%3D&name=5-Выход_из_лабиринта.docx&nosw=1")
            //5-Выход_из_лабиринта
            253343 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruCRwY2UEmmqPZuIy5VTK3XkoNIrnXDovBIkRdGSV6KUP-1VdKLE01ZpF4m-ku_G8QrQ8Qanbwr21ws56tq7dlV8CSJzmV3LQkvU78x_Ck9dO99vV913Tmf7eb3BmlLnCEA%3D%3D%3Fsign%3D83kCRi8cPprFQiyXiUzfenhaldX-Cd8Z8cUF7y741fE%3D&name=5-Харвестер.docx&nosw=1")
            //5-Харвестер
            588727 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruAGOGJ8ISIfkVEjDeaHWuJd9ALDWkkE-WCZE857AtCMA_ThFPolcU-wxI-_-VzQGieEhJOQPcaQEodpCE06oPoMmsW4VOIoD5TZ9dhHeM6hZgrEEgjigs4ZUPO2gLxuhtA%3D%3D%3Fsign%3DN8Jx19E7zXXN1g53YHvqu02uvRdUBwWRQrPb8NyyASI%3D&name=5-Шереметьево_Грузовой_-терминал.docx&nosw=1")
            //5-Шереметьево_Грузовой_-терминал
            360887 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruLvqaqt2i5TT_T6dHuKAsahYaHcoqweOdgeMrZKn0MA4OSOxVpeY5WXkuaCy9b7t0ykGzGAAKMS-tlQLhl-tGd4AM9MwwQU9zHexDxs9d8tjgJRlCor5D4hpR1ytd506_Q%3D%3D%3Fsign%3DL7uXa1ViHziuCC6QOPfJdBrH1VEgJb4_Qhu4zOnkt5c%3D&name=5-Сортировка_Отходов-2.docx&nosw=1")
            //5-Сортировка_Отходов-2
            695409 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruC9nzPj_SuziimHJBL4T7XEqiJwoEMiEgWOM9DDLxFNI-YlS8DMji1Ia_HVSS4_7N6JY1dKDFgXkCw0cSQZ6jTeOXNhC7S6tQTlOIYhmN9cVSdLWXpIbXD6jKdH6TuOdOA%3D%3D%3Fsign%3DSESYjsbxbp8HQ5OyJZRL2KRUyGqJ7GXVQMgB_l1AZFA%3D&name=5-доставка-рулона-бумаги.docx&nosw=1")
            //5-доставка-рулона-бумаги
            636057 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruK8zXjdu3K1JWItwAvBC8DW3U3uWI4yCPEPlLLqh9NJDbeH3Q9Q5HjYe_2mee8diLIA06QJfk9bs1510buZmfW95DH64JzTHF-kvWWCPX9J2vkFavzW0aoV7jb8hW8qR1Q%3D%3D%3Fsign%3Dz9cyQcVWmvop8WIItXwRqevjSb9vq-zAkHvCkLltyyM%3D&name=SPIKE-КегельрингКВАДРО.docx&nosw=1")
            //SPIKE-КегельрингКВАДРО
            467045 -> link?.setText("http://robostem.ru/wp-content/uploads/2020/11/SPIKE-Погрузчик.docx")
            //SPIKE-Погрузчик
            106935 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruGR3f3AB5UUYycGbKhEdOBGZohCLit78ksmIU1-78uF1RnYHq4hjcvm9DlEVr9Kq44CJi_F7MuwrfxAeyQyvKftedt2LAzFebJ_-t6uKfA8h8_yfHiwWaS9rC-SVixHzcg%3D%3D%3Fsign%3DaRWGOegvmMtZYWWDPdOVcujylUB8swtYKWb9dlUD7uU%3D&name=SPIKE-Склад-1.docx&nosw=1")
            //SPIKE-Склад-1
            674124 -> link?.setText("https://docviewer.yandex.ru/?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruOMpDcaVxAFzv6Sp2iRusbnVj_ajFaKY3ajVRWNvr8DSvDh_mhzPxP3z5EIY2tBLotA2D1Uuh50cDqLLF0uQxLQPAJJ00Pjt4VrHO-j-nxYka2E2EoZKzvNL9VmvzQ3EyA%3D%3D%3Fsign%3D7FjP7yobGX3We3BxYJQ_EAN60QjtaZnRRRMLubJcUtw%3D&name=SPIKE-Контролер.docx")
            //SPIKE-Контролер
            412107 -> link?.setText("http://robostem.ru/wp-content/uploads/2020/11/SPIKE-Биатлон.docx")
            //SPIKE-Биатлон
            408253 -> link?.setText("https://docviewer.yandex.ru/?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruLefF-LMW31S7Lq_3G4VYVqpIuouF0TE0GpJUprtc_rlVDb6ccSPkdoPdZz3uaywJ8cqV3r-X6a-Dnzs9dUn3yWGSWD_FZQy9oDZn10imVv1ZvZsWyW_RsX4b60BdVICdg%3D%3D%3Fsign%3DBpGFlcGJiT0pCwYeOihG009Htd2MWMdBdRQ9TN7cjyE%3D&name=SPIKE-Шорт-трек.docx")
            //SPIKE-Шорт-трек
            376126 -> link?.setText("https://docviewer.yandex.ru/?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruDI6WSJ-QEJmKxA0U0CcQcOO0JFk5-Fp7Yn38ZwsI3Lg6h5Iu_3Dg_ZZvtF8xKsxxSewewYwCaS2qAdy6Nr1v5z7BdDlYb13q2I0VBUw2DCcT02ouc-7H6M11sjO6kvirQ%3D%3D%3Fsign%3DbwFORu4lhuALAr9qXJzkjXcYYSyRuPTbFuV2mWtZZhY%3D&name=SPIKE-ЗФИ.docx")
            //SPIKE-ЗФИ
            643071 -> link?.setText("https://docviewer.yandex.ru/?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruAJ15KE9eiImbyjpLxhPVdsM6E6q_b0L2otgMEFPjf4IAcRj6FjuLAdpcyupYDAjZRNkvJ6EtMCdNpw1IdviTVnmwQPsxaGnxVhmZqi3Llq_VPf1J7DE_NhdXiJm8Bed4w%3D%3D%3Fsign%3D3IpxCOujYa_TBamJR_mKC4v9udfePOvPxdbr2Q9Tj-0%3D&name=SPIKE-Попади-в-цель.docx")
            //SPIKE-Попади-в-цель
            840921 -> link?.setText("https://docs.yandex.ru/docs/view?url=ya-browser%3A%2F%2F4DT1uXEPRrJRXlUFoewruCKVV_SaXM0XFDxCXh2_WkJz85o10uVM-jogshqZFzMhZcWBtRdpVeTAyDAghMwYojEFEr-rNL2WdXGSPXbnh9cf0LgIaSrmdbBcPmGc1AEodDuUz7JV66_n_B2HJ9jMmQ%3D%3D%3Fsign%3Dl_5BolNAIjJNTM3MN6t3a10abe7DogsXylfBP-C4cUc%3D&name=SPIKE-доставка-рулона-бумаги.docx&nosw=1")
            //=SPIKE-доставка-рулона-бумаги

            else -> { // Note the block
                val nax = arguments?.getString("error")
                link?.setText(nax)
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

