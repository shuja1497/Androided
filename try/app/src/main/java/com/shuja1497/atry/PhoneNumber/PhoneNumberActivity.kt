package com.shuja1497.atry.PhoneNumber

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shuja1497.atry.R
import android.content.Context.TELEPHONY_SERVICE
import android.telephony.TelephonyManager
import android.widget.Toast
import java.util.*
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber
import com.google.i18n.phonenumbers.PhoneNumberUtil
import kotlinx.android.synthetic.main.activity_phone_number.*


class PhoneNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

        val telephonyManager = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val simCountryIso = telephonyManager.simCountryIso

//        Toast.makeText(this, "ISO Code is ${simCountryIso.capitalize()}", Toast.LENGTH_LONG).show()

        val numberStr = "9897317397"
        val phoneUtil = PhoneNumberUtil.getInstance()
        var numberProto: PhoneNumber? = null
        try {
            numberProto = phoneUtil.parseAndKeepRawInput(numberStr, "IN")
        } catch (e: NumberParseException) {
            Toast.makeText(this, "NumberParseException was thrown: " + e.toString(), Toast.LENGTH_LONG).show()
        }

//        Toast.makeText(this, swissNumberProto.toString(), Toast.LENGTH_LONG).show()
        val isValid = phoneUtil.isValidNumber(numberProto)

        textView_phone_result.text = numberProto.toString()

        Toast.makeText(this, "Validation is $isValid", Toast.LENGTH_LONG).show()
    }
}
