package com.ndp.picodiploma.ProjectAkhir

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Service(
    var serviceType : String,
    var desc : String,
    var price : String,
) : Parcelable
