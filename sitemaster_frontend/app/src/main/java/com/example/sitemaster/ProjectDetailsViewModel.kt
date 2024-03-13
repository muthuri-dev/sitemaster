package com.example.sitemaster

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProjectDetailsViewModel(private val projectRepository: ProjectRepository) : ViewModel() {
    private val _projectState = MutableStateFlow<ProjectState>(ProjectState())
    val project = _projectState.asStateFlow()

    fun loadProject(projectName: String) {
        viewModelScope.launch {
            val project = projectRepository.getProjectDetails(projectName)
            _projectState.value = ProjectState(project)
        }
    }

    fun printUsers() {
        // Implement your logic for printing users here (e.g., Toast message)
    }
}


