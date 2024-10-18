package com.example.projet_android.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet_android.model.Item
import com.example.projet_android.repositories.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> get() = _isError

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun fetchItems(authToken: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val itemsList = repository.getItems(authToken)
                _items.value = itemsList
            } catch (e: Exception) {
                e.printStackTrace()
                _isError.value = true
            } finally {
                _isLoading.value = false
            }
        }
    }
}