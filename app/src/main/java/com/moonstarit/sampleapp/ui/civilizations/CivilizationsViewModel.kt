package com.moonstarit.sampleapp.ui.civilizations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationsUseCase
import com.moonstarit.sampleapp.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CivilizationsViewModel(
    private val getCivilizationsUseCase: GetCivilizationsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CivilizationsState())
    val uiState: StateFlow<CivilizationsState> = _uiState.asStateFlow()

    init {
        loadCivilizations()
    }

    private fun loadCivilizations() {
        viewModelScope.launch {
            _uiState.value = CivilizationsState(
                isLoading = true,
                error = null
            )
            _uiState.value = when (val result = getCivilizationsUseCase()) {
                is Resource.Error -> {
                    CivilizationsState(
                        civilizationData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
                is Resource.Success -> {
                    CivilizationsState(
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