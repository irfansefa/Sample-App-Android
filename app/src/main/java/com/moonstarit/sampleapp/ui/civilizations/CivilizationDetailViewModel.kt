package com.moonstarit.sampleapp.ui.civilizations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationDetailUseCase
import com.moonstarit.sampleapp.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CivilizationDetailViewModel(
    private val getCivilizationDetailUseCase: GetCivilizationDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CivilizationDetailState())
    val uiState: StateFlow<CivilizationDetailState> = _uiState.asStateFlow()

    fun loadDetails(id: Long) {
        viewModelScope.launch {
            _uiState.value = CivilizationDetailState(
                isLoading = true,
                error = null
            )
            _uiState.value = when (val result = getCivilizationDetailUseCase(id)) {
                is Resource.Error -> {
                    CivilizationDetailState(
                        civilizationData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
                is Resource.Success -> {
                    CivilizationDetailState(
                        civilizationData = result.data,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }
}

data class CivilizationDetailState(
    val civilizationData: CivilizationData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)