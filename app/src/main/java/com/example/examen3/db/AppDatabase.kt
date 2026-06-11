package com.example.examen3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "jugadores.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_JUGADOR = "jugador"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USUARIO = "usuario"
        private const val COLUMN_CONTRASENA = "contrasena"

        private const val CREATE_TABLE = "CREATE TABLE $TABLE_JUGADOR (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USUARIO TEXT, " +
                "$COLUMN_CONTRASENA TEXT)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_JUGADOR")
        onCreate(db)
    }

    fun insertarJugador(usuario: String, contrasena: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_USUARIO, usuario)
            put(COLUMN_CONTRASENA, contrasena)
        }
        return db.insert(TABLE_JUGADOR, null, values)
    }
}
