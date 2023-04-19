package com.example.mymenu.global

import android.app.Application
import com.example.mymenu.core.CalculoGC
import java.util.Date

enum class ENUM_ESTADO_CALCULO_GC {
    GRASA_ESENCIAL,
    ATLETAS,
    FITNESS,
    ACEPTABLE,
    OBESIDAD
}

class MyData : Application() {
    companion object {
        var listaCalculoGC: MutableMap<Int, CalculoGC> = mutableMapOf(
            1 to CalculoGC(15.45,15,'M',16.12,ENUM_ESTADO_CALCULO_GC.ACEPTABLE.name, Date()),
            2 to CalculoGC(10.14,22,'H',10.15,ENUM_ESTADO_CALCULO_GC.FITNESS.name, Date()),
            3 to CalculoGC(20.15,23,'M',19.457,ENUM_ESTADO_CALCULO_GC.ATLETAS.name, Date()),

        )
    }

    override fun onCreate() {
        super.onCreate()
    }

}
