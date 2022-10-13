package com.moonstarit.sampleapp.ui.civilizations

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationsUseCase
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationsUseCaseImpl
import com.moonstarit.sampleapp.domain.util.Resource
import kotlinx.coroutines.launch

class CivilizationsViewModel(
    private val getCivilizationsUseCase: GetCivilizationsUseCase = GetCivilizationsUseCaseImpl()
) : ViewModel() {
    var state by mutableStateOf(CivilizationsState())
        private set

    fun loadCivilizations() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            state = when (val result = getCivilizationsUseCase()) {
                is Resource.Error -> {
                    state.copy(
                        civilizationData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
                is Resource.Success -> {
                    state.copy(
                        civilizationData = result.data,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }
}

data class CivilizationsState(
    val civilizationData: List<CivilizationData>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)