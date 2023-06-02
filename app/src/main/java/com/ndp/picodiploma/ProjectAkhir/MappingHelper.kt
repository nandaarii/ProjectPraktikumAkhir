package com.ndp.picodiploma.ProjectAkhir

import android.database.Cursor

object MappingHelper {

    fun mapCursorToArrayList(noteCursor: Cursor?): ArrayList<Note> {
        val noteList = ArrayList<Note>()

        noteCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.customerColumns._ID))
                val name = getString(getColumnIndexOrThrow(DatabaseContract.customerColumns.NAME))
                val email = getString(getColumnIndexOrThrow(DatabaseContract.customerColumns.EMAIL))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.customerColumns.DATE))
                noteList.add(Note(id, name, email, date))
            }
        }
        return noteList
    }

}