package com.github.displayarraytorv

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/16/2018
 *  check https://github.com/KeiLazu for more
 */

@Parcelize
data class Item (val name: String?, val image: Int?): Parcelable