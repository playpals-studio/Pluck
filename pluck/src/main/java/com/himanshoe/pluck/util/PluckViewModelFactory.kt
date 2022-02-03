@file:Suppress("UNCHECKED_CAST")

package com.himanshoe.pluck.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.himanshoe.pluck.data.PluckRepository
import com.himanshoe.pluck.ui.PluckViewModel

internal class PluckViewModelFactory(
    private val pluckRepository: PluckRepository,
    private val pluckUriManager: PluckUriManager,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PluckViewModel::class.java)) {
            PluckViewModel(this.pluckRepository, this.pluckUriManager) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
