package com.example.sitemaster

interface ProjectRepository {
    suspend fun getProjectDetails(projectName: String): Project?
}

