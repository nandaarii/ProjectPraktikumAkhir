package com.ndp.picodiploma.ProjectAkhir

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import com.ndp.picodiploma.ProjectAkhir.DatabaseContract.customerColumns.Companion.TABLE_NAME
import com.ndp.picodiploma.ProjectAkhir.DatabaseContract.customerColumns.Companion._ID

class NoteHelper(context: Context) {

    private var dataBaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME

        private var INSTANCE: NoteHelper? = null
        fun getInstance(context: Context): NoteHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: NoteHelper(context)
            }
    }

    //Connection DB
    @Throws(SQLException::class)
    fun open() {
        database = dataBaseHelper.writableDatabase
    }
    fun close() {
        dataBaseHelper.close()
        if (database.isOpen)
            database.close()
    }

    //CRUD
    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$_ID ASC")
    }

    fun queryById(id: String): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            "$_ID = ?",
            arrayOf(id),
            null,
            null,
            null,
            null)
    }
    fun insert(values: ContentValues?): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

//  jika ada development tambahan
//    fun update(id: String, values: ContentValues?): Int {
//        return database.update(DATABASE_TABLE, values, "$_ID = ?", arrayOf(id))
//    }
//
//    fun deleteById(id: String): Int {
//        return database.delete(DATABASE_TABLE, "$_ID = '$id'", null)
//    }

}